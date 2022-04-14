package com.v1.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CalendarDTO {
    private Long id;
    private Long boardId;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String username;
    private String backgroundColor;
    private String textColor;
    private boolean allDay;
}
