package org.com.java8;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CliOptionsTest {


	public static void main(String[] args){
		Options options = new Options();
		options.addOption(Option.builder("cf").desc("value to be passed with command line argumnet").required(true).argName("cfValue").hasArg().build());

		CommandLineParser commandLineParser;
		CommandLine commandline;
		try {
			commandLineParser = new DefaultParser();
			commandline = commandLineParser.parse(options, args);
			System.out.println(commandline.getOptionValue("cf"));
			
		} catch (ParseException e) {
		    HelpFormatter formatter = new HelpFormatter();
		    formatter.printHelp("sample", options);
		}
		

		


		
	}

}
