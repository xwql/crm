package cn.crm.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Component
public class MiddleMonth {
    public  static List<String> getMiddleDateString(String start, String end){
        List<String> list = new ArrayList<String>();
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM").parse(start);
            Date endDate = new SimpleDateFormat("yyyy-MM").parse(end);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            // 获取开始年份和开始月份
            int startYear = calendar.get(Calendar.YEAR);
            int startMonth = calendar.get(Calendar.MONTH);
            // 获取结束年份和结束月份
            calendar.setTime(endDate);
            int endYear = calendar.get(Calendar.YEAR);
            int endMonth = calendar.get(Calendar.MONTH);
            //

            for (int i = startYear; i <= endYear; i++) {
                String date = "";
                if (startYear == endYear) {
                    for (int j = startMonth; j <= endMonth; j++) {
                        if (j < 9) {
                            date = i + "-0" + (j + 1);
                        } else {
                            date = i + "-" + (j + 1);
                        }
                        list.add(date);
                    }

                } else {
                    if (i == startYear) {
                        for (int j = startMonth; j < 12; j++) {
                            if (j < 9) {
                                date = i + "-0" + (j + 1);
                            } else {
                                date = i + "-" + (j + 1);
                            }
                            list.add(date);
                        }
                    } else if (i == endYear) {
                        for (int j = 0; j <= endMonth; j++) {
                            if (j < 9) {
                                date = i + "-0" + (j + 1);
                            } else {
                                date = i + "-" + (j + 1);
                            }
                            list.add(date);
                        }
                    } else {
                        for (int j = 0; j < 12; j++) {
                            if (j < 9) {
                                date = i + "-0" + (j + 1);
                            } else {
                                date = i + "-" + (j + 1);
                            }
                            list.add(date);
                        }
                    }

                }

            }
            // 所有的月份已经准备好
            //System.out.println(list);
            /*for(int i = 0;i < list.size();i++){
                System.out.println(list.get(i));
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<Date> getMiddleDate(String start,String end){
        List<String> middleDateString = getMiddleDateString(start, end);
        ArrayList<Date> dates = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        try {
            for (String str : middleDateString) {
                dates.add(simpleDateFormat.parse(str));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dates;
    }
}
