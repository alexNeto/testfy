package org.alexneto.testfy.options;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionsBuilder {

	private List<Option> optionsList;

	public OptionsBuilder() {

		optionsList = new ArrayList<Option>();
		createOption("h", false, "Show help", "help");
		createOption("H", false, "Show man page", "HELP");

	}

	private void createOption(String shortOption, boolean required, String description, String longOption) {
		Option option = Option.builder(shortOption).required(required).desc(description).longOpt(longOption).build();
		addOption(option);
		;
	}

	private void addOption(Option option) {
		optionsList.add(option);

	}

	public Options createdOptions() {
		Options options = new Options();

		for (Option option : optionsList) {
			options.addOption(option);
		}
		return options;
	}

}
