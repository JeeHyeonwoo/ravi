package com.v1.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {
    private Long id;
    private String url;
    private Date date;
}
