package org.wants.data.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public final static String DEFAULT_DATE_FORMAT = "yyyy-M-d";

	public static String format(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		return sdf.format(date);
	}

}
