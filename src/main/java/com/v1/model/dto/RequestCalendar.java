package com.v1.model.dto;

import lombok.Data;

@Data
public class RequestCalendar {

    private String startDate;

    private String endDate;
    private Long boardId;
    private Long id;
    private String title;
    private String username;
    private String backgroundColor;
    private String textColor;
    private String description;
}
