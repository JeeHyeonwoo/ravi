package com.v1.model.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public class CalendarDTO {
    private Long id;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private String type;
    private String username;
    private String backgroundColor;
    private String textColor;
    private boolean allDay;
}
