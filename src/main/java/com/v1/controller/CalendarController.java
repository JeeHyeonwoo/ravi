package com.v1.controller;

import com.v1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping
    public String setCalendar(Model model) {
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        int[][] calendar = calendarService.buildCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));

        model.addAttribute("Calendar", calendar);

        return "/index";
    }
}
