package com.v1.service.impl;

import com.v1.domain.Month;
import com.v1.mapper.CalendarMapper;
import com.v1.mapper.MemberMapper;
import com.v1.model.dto.CalendarDTO;
import com.v1.model.dto.MemberDTO;
import com.v1.model.dto.RequestCalendar;
import com.v1.model.dto.ResponseCalendar;
import com.v1.model.vo.CalendarVO;
import com.v1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final MemberMapper memberMapper;
    private final CalendarMapper calendarMapper;

    @Override
    public void save(CalendarVO calendarVO) throws Exception{
        MemberDTO dto = memberMapper.findByName(calendarVO.getUserId());
        if(dto != null) {
            calendarMapper.insert(calendarVO);
        }else {
            throw new Exception("존재하지 않는 사용자의 접근");
        }
    }

    @Override
    public List<ResponseCalendar> findByCalendars(RequestCalendar requestCalendar) {
        CalendarDTO calendarDTO = new CalendarDTO();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss", Locale.ENGLISH);

        try{
            calendarDTO.setBoardId(requestCalendar.getBoardId());
            calendarDTO.setStartDate(simpleDateFormat.parse(requestCalendar.getStartDate()));
            calendarDTO.setEndDate(simpleDateFormat.parse(requestCalendar.getEndDate()));
        } catch (Exception e){
            System.out.println("실패 : " + e.getMessage());
        }

        return calendarMapper.findByCalendars(calendarDTO);
    }

    @Override
    public boolean deleteCalendar(RequestCalendar requestCalendar) {
        Optional<ResponseCalendar> responseCalendar = calendarMapper.findByCalendar(requestCalendar);
        if(responseCalendar.isPresent()){
            calendarMapper.delete(requestCalendar.getId());
            return true;
        }
        return false;

    }

    @Override
    public ResponseCalendar calendarInfo(RequestCalendar requestCalendar) {
        Optional<ResponseCalendar> result = calendarMapper.findByCalendar(requestCalendar);
        if(result.isPresent()){
            return result.get();
        }
        return null;

    }

    @Override
    public boolean updateService(RequestCalendar requestCalendar) {

        calendarMapper.update(requestCalendar);
        return true;
    }

    /*@Override
    public int[][] buildCalendar(int year, int month) {
        int[][] calendar = new int[5][7];

        int dayMax = 0;
        int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leap = isLeapYear(year);

        if(month == 2 && leap == true) {
            dayMax = dayDataLeapYear[month - 1];
        }
        if(month == 2 && leap == false) {
            dayMax = dayData[month - 1];
        }
        if(month != 2) {
            dayMax = dayData[month - 1];
        }

        int dayWeek = calMonth1stDayWeek(year, month); // 기준 월의 1일의 요일

        int row = dayWeek-1;
        int column = 0;

        for(int i = 1; i <= dayMax; i++) {

            if( row % 7 == 0) {
                row = 0;
                column += 1;
            }
            calendar[column][row++] = i;
        }

        return calendar;
    }

    public int calMonth1stDayWeek(int year, int month) {
        Calendar calendar = Calendar.getInstance(Locale.KOREA);
        Date currentTime = new Date();
        String YMD = year + "-" + month + "-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(currentTime);
        try{
            calendar.setTime(format.parse(YMD));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        return dayNum;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        else
            return false;
    }*/



}
