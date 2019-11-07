package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期工具类
 * @author SHE
 */
public class DateUtil {
	/*
	 * dateFormat  根据某种格式把字符串转化为日期
	 * dateStr把日期转化为字符串
	 */
	public static Date toDate(String dateFormat,String dateStr) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	/*
	 * 根据某种日期格式把日期转化为字符串
	 * 
	 */
	
	public static String dateToString(String dateFormat,Date date) {
		
		return new SimpleDateFormat(dateFormat).format(date);
	}

}
