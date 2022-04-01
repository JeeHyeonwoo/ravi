package com.v1.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CalendarVO {
    private Long id;
    private String title;
    private String description;     // 설명
    private Date start;
    private Date end;
    private String type;
    private Long userId;
    private Long boardId;
    private String backgroundColor;
    private String textColor;
    private boolean allDay;
}
