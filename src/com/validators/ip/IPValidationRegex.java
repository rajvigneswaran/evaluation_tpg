/**
 * 
 */
package com.validators.ip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rajvigneswaran
 */
public class IPValidationRegex {

	// ip address group with either 0 to 9 or 10 to 99 or 100 to 199 or 200 to 249
	// or 250 to 255
	private static final String IP_COMMON__GROUP_PATTERN = "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";

	// validate if ip address is in the group of three separated by "." and append
	// with another ip address group.
	private static final String IP_PATTERN = "\\b(?:" + IP_COMMON__GROUP_PATTERN + "\\.){3}" + IP_COMMON__GROUP_PATTERN;

	public static boolean validateIpAddresses(String inputFileName) throws IOException {
		final String fileName = inputFileName.split("\\.")[0];
		final String tmpFileName = fileName + "_tmp.txt";
		final File inputFile = new File(inputFileName);
		final File tmpFile = new File(tmpFileName);
		final BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		final BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			if (isIpAddress(currentLine.trim())) {
				writer.write(currentLine + System.getProperty("line.separator"));
			}
		}

		currentLine = null;
		writer.close();
		reader.close();
		inputFile.delete();
		return tmpFile.renameTo(new File(inputFileName));
	}

	private static boolean isIpAddress(String ipAddress) {
		final Pattern pattern = Pattern.compile(IP_PATTERN);
		final Matcher matcher = pattern.matcher(ipAddress);
		return matcher.find();
	}

	public static void main(String[] args) throws IOException {
		IPValidationRegex.validateIpAddresses("ip_addresses.txt");
	}
}
