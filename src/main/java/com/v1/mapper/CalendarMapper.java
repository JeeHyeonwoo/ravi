package com.v1.mapper;

import com.v1.model.dto.CalendarDTO;
import com.v1.model.vo.CalendarVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarMapper {
    void insert(CalendarVO calendarVO);
    List<CalendarDTO> findByCalendar(Long boardId, String month);
}
