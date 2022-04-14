package com.v1.model.dto;

import lombok.Data;

@Data
public class RequestCalendar {

    private String startDate;

    private String endDate;
    private Long boardId;
    private Long id;
}
