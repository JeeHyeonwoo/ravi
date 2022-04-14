package com.v1.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class ResponseCalendar {
    private Long boardId; // 일정이 속한 보드의 식별자 값
    private Long id;    // 일정 식별값
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date end;
    private String username;
    private String backgroundColor;
    private String textColor;
    private String description;
}
