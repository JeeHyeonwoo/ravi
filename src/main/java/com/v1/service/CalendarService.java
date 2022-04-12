package com.v1.service;

import com.v1.model.dto.CalendarDTO;
import com.v1.model.vo.CalendarVO;

import java.util.List;

public interface CalendarService {

    public void save(CalendarVO calendarVO) throws Exception;
    public List<CalendarDTO> findByCalendars(Long boardId, String month);
}
