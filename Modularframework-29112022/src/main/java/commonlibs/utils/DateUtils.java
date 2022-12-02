package commonlibs.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static String getcurrentdatetime()
	{		
	LocalDateTime datetime=LocalDateTime.now();	
		
	DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss")	;
	
	String datetimeformat=datetime.format(format);
	
	return datetimeformat;		
	}	
}
