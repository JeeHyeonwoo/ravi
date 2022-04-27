package com.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @PostMapping("/get-current-project-image")
    public void getProjectImage(){
        // DB에서 최근 저장된 프로젝트 url 4개의 경로를 가져온다.

        // 가져온 경로의 프로젝트의 썸네일을 만든다.

        // 출력한다.

    }
}
