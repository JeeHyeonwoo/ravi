package com.v1.mapper;

import com.v1.model.dto.CalendarDTO;
import com.v1.model.dto.RequestCalendar;
import com.v1.model.dto.ResponseCalendar;
import com.v1.model.vo.CalendarVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Mapper
public interface CalendarMapper {
    void insert(CalendarVO calendarVO);
    List<ResponseCalendar> findByCalendars(CalendarDTO calendarDTO);
    Optional<ResponseCalendar> findByCalendar(RequestCalendar requestCalendar);
    void delete(Long id);
}
