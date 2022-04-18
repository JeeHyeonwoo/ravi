package com.v1.service;

import com.v1.model.dto.RequestCalendar;
import com.v1.model.dto.ResponseCalendar;
import com.v1.model.vo.CalendarVO;

import java.util.List;

public interface CalendarService {

    void save(CalendarVO calendarVO) throws Exception;
    List<ResponseCalendar> findByCalendars(RequestCalendar requestCalendar);
    boolean deleteCalendar(RequestCalendar requestCalendar);
    ResponseCalendar calendarInfo(RequestCalendar requestCalendar);
    boolean updateService(RequestCalendar requestCalendar);
}
