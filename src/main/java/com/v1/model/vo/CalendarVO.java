package com.v1.model.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@ToString
public class CalendarVO {
    private Long id;
    private String title;
    private String desc;     // 설명

    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String start;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String end;

    private Long userId;
    private Long boardId = 1L;
    private String backgroundColor;
    private String textColor;
    private boolean allDay;


}
