package com.v1.ravi;


import com.v1.mapper.CalendarMapper;
import com.v1.model.dto.CalendarDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class CalendarMapperTest {

    @Autowired
    CalendarMapper calendarMapper;

    @Test
    void test1() {
        String[] date = "April 2022".split(" ");
        int month = Month.valueOf(date[0]).ordinal() + 1;

        String s = String.valueOf(month);
        System.out.println(s);

    }
}
