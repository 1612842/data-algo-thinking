package com.zalopay;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by thinhda.
 * Date: 2019-04-15
 */

public class SlaServiceImpl implements SlaService {
    @Override
    public Duration calculate(LocalDateTime begin, LocalDateTime end) {
        // TODO: calc working hours
        Duration duration = Duration.between(begin,end);
        LocalDateTime beginWorkingMorningStart = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth(), 8, 30);
        LocalDateTime beginWorkingMorningEnd = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth(), 12, 00);
        LocalDateTime beginWorkingAfternoonStart = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth(), 13, 00);
        LocalDateTime beginWorkingAfternoonEnd = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth(), 18, 00);

        LocalDateTime endWorkingMorningStart = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 8, 30);
        LocalDateTime endWorkingMorningEnd = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 12, 00);
        LocalDateTime endWorkingAfternoonStart=LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 13, 00);
        LocalDateTime endWorkingAfternoonEnd= LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 18, 00);

        System.out.println("Day of week begin: "+ begin.getDayOfWeek() +" "+ begin.getDayOfMonth()+" "+ begin.getMonth()+" "+ begin.getYear()+" ->"+begin.getHour()+":"+begin.getMinute());
        System.out.println("Day of week end: "+ end.getDayOfWeek() +" "+ end.getDayOfMonth()+" "+ end.getMonth()+" "+ end.getYear()+" ->"+end.getHour()+":"+end.getMinute());

        //Time request and end in one day
        if (inOneDate(begin,end)){

            if (isMorningBegin(begin,beginWorkingMorningStart,beginWorkingMorningEnd)&&
                isAfternoonEnd(end,endWorkingAfternoonStart,endWorkingAfternoonEnd)){
                   duration = minusDuration(duration,1,30,1);
            }
        }else{

            long dayBetween =  ChronoUnit.DAYS.between(begin, end);

            //Neu hai ngay khac nhau thi khoang cach toi thieu la 1
            if (begin.getDayOfMonth()!=end.getDayOfMonth())
                dayBetween+=1;

            System.out.println("Day between: " +dayBetween);

            numWeekendBetweenToDateWorking(begin,end);

            //Ngày bắt đầu là chiều hôm trước và Ngày hoàn thành công việc là sáng ngày hôm sau
            if (isAfternoonBegin(begin,beginWorkingAfternoonStart,beginWorkingAfternoonEnd)
                && isMorningEnd(end,endWorkingMorningStart,endWorkingMorningEnd)){
                duration = minusDuration(duration,14,30,dayBetween);
            }
        }




        System.out.println(duration.getSeconds()/60 + " minutes-----"+duration.getSeconds()/3600+" hours");
        System.out.println("-------------------------------------------------------------------------");
        return duration;
    }

    private Duration minusDuration(Duration duration,int hours, int minutes, long numDay) {
        Duration temp = duration;

        temp=temp.minusHours(hours).minusMinutes(minutes);
        if (numDay>1)
        for (int i=1;i<numDay;i++){
            temp=temp.minusMinutes(24*60 - 480);//thoi gian trong 1 ngay ma khong lam viec
        }

        return temp;
    }


    private boolean inOneDate(LocalDateTime begin, LocalDateTime end) {
        if (begin.getYear()==end.getYear()&&begin.getMonth()==end.getMonth()&&begin.getDayOfMonth()==end.getDayOfMonth()){
            return true;
        }
        else
            return false;
    }


    private long numWeekendBetweenToDateWorking(LocalDateTime begin, LocalDateTime end){
        long weekBetween =  ChronoUnit.WEEKS.between(begin, end);
        System.out.println(begin.getDayOfWeek().getValue());
        System.out.println(end.getDayOfWeek().getValue());
        if (end.getDayOfWeek().getValue()<begin.getDayOfWeek().getValue())
            weekBetween+=1;
        System.out.println(weekBetween);
        return weekBetween;
    }

    private boolean isMorningBegin(LocalDateTime begin, LocalDateTime morningStart, LocalDateTime morningEnd) {
        if (begin.compareTo(morningStart) >= 0 && begin.compareTo(morningEnd) <= 0)
            return true;
        return false;
    }

    private boolean isAfternoonBegin(LocalDateTime begin, LocalDateTime afternoonStart, LocalDateTime afternoonEnd) {
        if (begin.compareTo(afternoonStart) >= 0 && begin.compareTo(afternoonEnd) <= 0)
            return true;
        return false;
    }

    private boolean isMorningEnd(LocalDateTime end, LocalDateTime morningStart, LocalDateTime morningEnd) {
        if (end.compareTo(morningStart) >= 0 && end.compareTo(morningEnd) <= 0)
            return true;
        return false;
    }

    private boolean isAfternoonEnd(LocalDateTime end, LocalDateTime afternoonStart, LocalDateTime afternoonEnd) {
        if (end.compareTo(afternoonStart) >= 0 && end.compareTo(afternoonEnd) <= 0)
            return true;
        return false;
    }

}
