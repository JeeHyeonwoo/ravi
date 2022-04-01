package com.v1.service.impl;

import com.v1.mapper.CalendarMapper;
import com.v1.mapper.MemberMapper;
import com.v1.model.dto.MemberDTO;
import com.v1.model.vo.CalendarVO;
import com.v1.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final MemberMapper memberMapper;
    private final CalendarMapper calendarMapper;

    @Override
    public void save(CalendarVO calendarVO) throws Exception{
        String name = memberMapper.findByName(calendarVO.getUserId()).map(MemberDTO::getUsername).orElse(null);
        if(name != null) {
            calendarMapper.insert(calendarVO);
        }else {
            throw new Exception("존재하지 않는 사용자의 접근");
        }
    }


    /**
     * 캘린더 빌드
     * */

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
