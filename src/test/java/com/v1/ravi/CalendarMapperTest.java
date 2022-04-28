package com.v1.ravi;


import com.v1.mapper.CalendarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


@SpringBootTest
public class CalendarMapperTest {

    @Autowired
    CalendarMapper calendarMapper;

    @Test
    void test1() {
        String[] date = "April 2022".split(" ");
        int month = Month.valueOf(date[0]).ordinal() + 1;

        String s = String.valueOf(month);
        System.out.println(s +"ㅇ아아아앙");

    }


    @Test
    void test2() {
        try {
            // String -> Date 변경
            String from = "Sun Mar 27 2022 00:00:00 GMT+0900 (한국 표준시)";
            SimpleDateFormat sDate = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
            Date n = sDate.parse(from);

            // 날짜 연산
            Calendar cal = Calendar.getInstance();
            cal.setTime(n);
            cal.add(Calendar.MONTH, 1);

            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(dformat.format(cal.getTime()));

        }catch (Exception e) {
            System.out.println("실패");
        }
    }

    @Test
    void test3() {

    }
}
