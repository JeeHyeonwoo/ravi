package com.v1.model.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@ToString
public class CalendarVO {
    private Long id;
    private String title;
    private String description;     // 설명

    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String start;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String end;

    private String type;
    private Long userId;
    private Long boardId;
    private String backgroundColor;
    private String textColor;
    private Long groupId = 1L;
    private boolean allDay;


}
