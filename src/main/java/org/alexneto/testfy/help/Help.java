package org.alexneto.testfy.help;

public class Help{
	
	private String version = "1.0.0";
	private String appName = "testfy";

	public void help() {
		asciiArt();
		
		StringBuilder sb = new StringBuilder();
		sb.append("To use ").append(appName).append("\n");
		sb.append("\t$ ").append(appName).append(" <option>").append(" [test class name]").append(" [test method name]");
		System.out.println(sb.toString());
		
	}

	public void manPage() {
	}

	public void asciiArt() {
		System.out.println("_____  ____  __  _____  ____ __  ");
		System.out.println(" | |  | |_  ( (`  | |  | |_  \\ \\_/");
		System.out.println(" |_|  |_|__ _)_)  |_|  |_|    |_|");	
		System.out.println("                             " + version);
	}
}
