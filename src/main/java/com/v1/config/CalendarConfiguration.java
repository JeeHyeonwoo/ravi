package com.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Locale;

@Configuration
public class CalendarConfiguration {
    @Bean
    public Calendar calendar() {
        return Calendar.getInstance(Locale.KOREA);
    }
}
