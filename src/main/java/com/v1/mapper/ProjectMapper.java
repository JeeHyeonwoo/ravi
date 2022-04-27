package com.v1.mapper;

import com.v1.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper{
    void insert();
    List<ProjectDTO> currentProject(int limit);
}
