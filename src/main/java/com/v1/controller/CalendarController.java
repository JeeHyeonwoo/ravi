package com.v1.controller;

import com.v1.domain.StatusEnum;
import com.v1.model.dto.CalendarDTO;
import com.v1.model.dto.RequestCalendar;
import com.v1.model.dto.ResponseCalendar;
import com.v1.model.vo.CalendarVO;
import com.v1.model.vo.Response;
import com.v1.model.vo.Result;
import com.v1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public List<ResponseCalendar> getCalendar(RequestCalendar requestCalendar){

        /*calendarService.findByCalendars(boardId, month);*/
        return calendarService.findByCalendars(requestCalendar);
    }

    @PostMapping("/delete")
    @ResponseBody
    public ResponseEntity<Response> delete(RequestCalendar requestCalendar) {
        boolean result = calendarService.deleteCalendar(requestCalendar);
        if(result) {
            Result response = Result.builder().build();
            return new ResponseEntity<>(Response.builder().response(response).contents("delete Success").build(), HttpStatus.OK);
        } else {
            Result response = Result.builder()
                    .status(StatusEnum.NOT_FOUND)
                    .errorCode("400")
                    .message("존재하지 않는 일정입니다")
                    .build();
            return new ResponseEntity<>(Response.builder().response(response).contents("Not Found").build(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/view")
    @ResponseBody
    public ResponseEntity<Response> view(RequestCalendar requestCalendar) {
        ResponseCalendar responseCalendar = calendarService.calendarInfo(requestCalendar);
        if(responseCalendar != null) {
            Result response = Result.builder().build();
            return new ResponseEntity<>(Response.builder().response(response).contents(responseCalendar).build(), HttpStatus.OK);
        } else {
            Result response = Result.builder()
                    .status(StatusEnum.NOT_FOUND)
                    .errorCode("400")
                    .message("존재하지 않는 일정입니다")
                    .build();
            return new ResponseEntity<>(Response.builder().response(response).contents("Not Found").build(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Response> update(RequestCalendar requestCalendar){

        boolean result = calendarService.updateService(requestCalendar);
        if(result) {
            Result response = Result.builder().build();
            return new ResponseEntity<>(Response.builder().response(response).contents("success").build(), HttpStatus.OK);
        } else {
            Result response = Result.builder()
                    .status(StatusEnum.NOT_FOUND)
                    .errorCode("400")
                    .message("존재하지 않는 일정입니다")
                    .build();
            return new ResponseEntity<>(Response.builder().response(response).contents("Not Found").build(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/html-thumb")
    public void htmlThumbnail() throws IOException {

    }

}
