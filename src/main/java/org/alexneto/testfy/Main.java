package org.alexneto.testfy;

import org.alexneto.testfy.help.Help;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

	public static void main(String[] args) {
		CommandLine commandLine;
		Option option_help = Option.builder("h").required(false).desc("show man page").longOpt("help").build();
		Option option_manPage = Option.builder("H").required(false).desc("Show complete help").longOpt("HELP").build();

		Options options = new Options();
		CommandLineParser parser = new DefaultParser();

		String[] testArgs = { "-hH", "--help" };

		options.addOption(option_help);
		options.addOption(option_manPage);

		try {
			commandLine = parser.parse(options, testArgs);

			if (commandLine.hasOption("h")) {
				new Help().help();
			}
			if (commandLine.hasOption("H")) {
				new Help().manPage();
			}
			// System.out.println(commandLine.getOptionValue("H"));
			String[] remainder = commandLine.getArgs();
			System.out.print("Remaining arguments: ");
			for (String argument : remainder) {
				System.out.print(argument);
				System.out.print(" ");
			}

			System.out.println();

		} catch (ParseException exception) {
			System.out.print("Parse error: ");
			System.out.println(exception.getMessage());
		}
	}
}
