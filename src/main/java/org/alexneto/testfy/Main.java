package org.alexneto.testfy;

import org.alexneto.testfy.commands.help.Help;
import org.alexneto.testfy.options.OptionsBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {

	public static void main(String[] args) {
		CommandLine commandLine;
		String[] testArgs = { "-hH", "--help" };
		CommandLineParser parser = new DefaultParser();
		try {
			Options options = new OptionsBuilder().createdOptions();
			commandLine = parser.parse(options , testArgs);

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
