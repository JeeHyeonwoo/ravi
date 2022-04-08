package com.v1.ravi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class RaviApplicationTests {
    public int[][] buildCalendar(int year, int month) {
        int[][] calendar = new int[5][7];

        int dayMax = 0;
        int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leap = isLeapYear(year);

        if (month == 2 && leap == true) {
            dayMax = dayDataLeapYear[month - 1];
        }
        if (month == 2 && leap == false) {
            dayMax = dayData[month - 1];
        }
        if (month != 2) {
            dayMax = dayData[month - 1];
        }

        int dayWeek = calMonth1stDayWeek(year, month); // 기준 월의 1일의 요일

        int row = dayWeek - 1;
        int column = 0;

        for (int i = 1; i <= dayMax; i++) {

            if (row % 7 == 0) {
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
        try {
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
    }

    @Test
    void contextLoads() {
        int[][] test = buildCalendar(2022, 3);

        System.out.println(Arrays.deepToString(test));
    }

    public static void bfs() {
        int[][] check = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] checked = new boolean[6];
        queue.offer(1);
        checked[1] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int j = 1; j <= 6; j++) {
                if (check[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    System.out.print(j + " ");
                }

            }
        }

    }



    @Test
    void test() {
        Graph graph = new Graph(7);
        int[][] g = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        for(int i=0; i < g.length; i++) {
            graph.addEdge(g[i][0], g[i][1]);

        }


        System.out.println("BFS시작");
        graph.bfs(1);
    }


}
