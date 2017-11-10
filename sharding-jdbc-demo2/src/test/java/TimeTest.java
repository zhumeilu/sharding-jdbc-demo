import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/10
 * Time: 13:43
 */
public class TimeTest {

    @Test
    public void test4() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(sdf.parse("2017-01-01"));
        System.out.println("getWeeksInWeekYear:"+calendar.getWeeksInWeekYear());
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2017-01-02"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2017-01-07"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2017-01-08"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2017-01-15"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2017-12-30"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2017-12-31"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2018-01-01"));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        calendar.setTime(sdf.parse("2018-12-31"));
        System.out.println("2018-12-31:"+calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("getWeeksInWeekYear:"+calendar.getWeeksInWeekYear());
        System.out.println(calendar.get(Calendar.YEAR));

    }
}
