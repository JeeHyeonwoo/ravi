package com.v1.service;

import com.v1.model.vo.CalendarVO;

import java.util.List;

public interface CalendarService {/*
    public int[][] buildCalendar(int year, int month);*/

    public void save(CalendarVO calendarVO) throws Exception;

}
