package com.v1.model.vo;

import com.v1.domain.StatusEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Result {
    @Builder.Default
    protected StatusEnum status = StatusEnum.OK;

    @Builder.Default
    protected String message = "success";

    @Builder.Default
    protected String errorCode = "";

}
