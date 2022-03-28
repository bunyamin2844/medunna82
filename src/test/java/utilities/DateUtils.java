package utilities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {


    public static String getDate(){
        LocalDateTime dateObj = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        return dateObj.format(formatDate);
    }
}
