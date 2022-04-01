package com.v1.mapper;

import com.v1.model.vo.CalendarVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarMapper {
    void insert(CalendarVO calendarVO);
}
