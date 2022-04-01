package com.v1.controller;

import com.v1.model.vo.CalendarVO;
import com.v1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    /*@GetMapping("/")
    public String setCalendar(Model model) {
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        int[][] calendar = calendarService.buildCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));

        model.addAttribute("Calendar", calendar);

        return "/index";
    }*/

    @PostMapping("/gettoday")
    @ResponseBody
    public String getToday() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date now = new Date();
        return format.format(now);
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody CalendarVO calendarVO) {
        try{
            calendarService.save(calendarVO);
        }catch (Exception e){
            e.getMessage();
        }

        System.out.printf(calendarVO.toString());
        return "success";
    }
}
