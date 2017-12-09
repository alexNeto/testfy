package org.alexneto.testfy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

	public static void main(String[] args) {
		CommandLine commandLine;
		Option option_help = Option.builder("h").required(true).desc("show man page").longOpt("help").build();

		Options options = new Options();
		CommandLineParser parser = new DefaultParser();

		String[] testArgs = { "h", "--help" };

		options.addOption(option_help);

		try {
			commandLine = parser.parse(options, testArgs);

			if (commandLine.hasOption("h")) {
				System.out.print("Option h is present.  The value is: ");
				System.out.println(commandLine.getOptionValue("A"));
			}

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
