package de.thesuntoucher.jigg.util;

import java.text.DateFormat;
import java.util.Date;

public class JiggDateUtil {

	public static String format(Date date){
		return DateFormat.getDateTimeInstance().format(date);
	}
	
	public static Date parse(String seconds){
		return new Date(Long.parseLong(seconds)*1000);
	}
	
}
