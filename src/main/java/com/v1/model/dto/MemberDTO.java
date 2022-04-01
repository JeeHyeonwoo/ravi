package com.v1.model.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private Long id;
    private String username;
    private int boardId;
}
