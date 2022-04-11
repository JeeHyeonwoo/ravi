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

    /*@GetMapping("/")
    public String setCalendar(Model model) {
        Calendar cal = Calendar.getInstance(Locale.KOREA);
        int[][] calendar = calendarService.buildCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));

        model.addAttribute("Calendar", calendar);

        return "/index";
    }*/

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
            System.out.println(calendarVO.getStart() + " ~ " + calendarVO.getEnd());
            //calendarService.save(calendarVO);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.printf(calendarVO.toString());
        return "success";
    }

    @PostMapping("/getcalendar")
    @ResponseBody
    public List<Map<String, Object>> getCalendar(@RequestParam Map<String, Object> map, HttpServletRequest request
    , HttpServletResponse response) throws Exception{
        List<Map<String, Object>> result = new ArrayList<>();
        map.put("start", "2022-04-04");
        map.put("end", "2022-04-06");
        map.put("title", "제목");
        result.add(map);
        return result;
    }
}
