package assignment22.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

	public static String PATTERN = "yyyy-MM-dd";

	private DateUtil() {
	}

	public static String toString(Date input) {
		if(input==null) {
			return "null";
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
			return sdf.format(input);
		} catch (Exception e) {
			return "";
		}
	}

	public static Date toDate(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		sdf.setLenient(false);
		try {
			return sdf.parse(input);
		} catch (ParseException e) {
			return null;
		}
	}
}
