package cn.crm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date stringToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date parse = simpleDateFormat.parse(date);
            return parse;
        } catch (ParseException e) {
            System.out.println("传入时间格式错误，即将返回null");
        } catch (NullPointerException e){
            System.out.println("没有传入时间，返回null");
        }
        return null;
    }


}
