package TddPracticeInJava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int addition(String input) {
		if(input.isEmpty()) {
			return 0;
		}
		if(input.startsWith("//")) {
			return sumWithCustomDelimiter(input);
		}
		String[] numberValues = input.replace("\n", ",").split(",");
		return addListOfNumber(numberValues);
	}
	
	private int addListOfNumber(String[] numberValues) {
		int result = 0;
		for(String number: numberValues) {
			int value = parseNumber(number);
			if(value <= 1000) {
				result += value;
			}
		}
		return result;
	}
	
	private int sumWithCustomDelimiter(String input) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if(matcher.matches()) {
			String delimiter = matcher.group(1);
			String numbers = matcher.group(2);
			String[] numberValues = numbers.split(Pattern.quote(delimiter));
			return addListOfNumber(numberValues);
		}
		return 0;
	}
	
	private int parseNumber(String number) {
		try {
			return Integer.parseInt(number.trim());
		} catch (NumberFormatException exception) {
			return 0;
		}
	}
}
