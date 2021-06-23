package dataObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DataTestSet1 {

    public static Random rd = new Random();

    public static final String USERNAME = "selenium@webdriver.com";
    public static final String PASSWORD = "1234567890";

    public static final String NEW_USERNAME = "lqduat".concat(String.valueOf(rd.nextInt(1000000))).concat("@logigear.com");
    public static final String NEW_PASSWORD = "123456789";
    public static final String NEW_PID = "123456789";

    public static final String USERNAME_TC09 = "selenium2@webdriver.com";
    public static final String PASSWORD_TC09 = "123456789";

    public static final String DEPART_STATION = "Sài Gòn";
    public static final String ARRIVE_STATION = "Nha Trang";
    public static final String DEPART_DATE = "6/30/2021";
    public static final String SEAT_TYPE = "Soft bed with air conditioner";
    public static final String AMOUNT = "1";

    public static final String DEPART_STATION_TC16 = "Đà Nẵng";
    public static final String ARRIVE_STATION_TC16 = "Huế";
    public static final String DEPART_DATE_TC16 = "6/30/2021";
    public static final String SEAT_TYPE_TC16 = "Soft bed";
    public static final String AMOUNT_TC16 = "1";

}
