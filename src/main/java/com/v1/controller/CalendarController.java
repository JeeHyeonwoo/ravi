package com.v1.controller;

import com.v1.model.vo.CalendarVO;
import com.v1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/index")
    public String index() {
        return "calendar";
    }

    @PostMapping("/gettoday")
    @ResponseBody
    public String getToday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date now = new Date();
        return format.format(now);
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(CalendarVO calendarVO) {
        try{
            calendarService.save(calendarVO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "success";
    }

    @PostMapping("/getcalendar")
    @ResponseBody
    public String getCalendar(Long boardId, String month){
        calendarService.findByCalendars(boardId, month);
        return "gd";
    }


}
