import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class a1 {

    @Test
    public void ss(){
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        System.out.println(dateTime.getMonthValue());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(dateTime);
        System.out.println(format);

        System.out.println("====================");
        Instant instant = Instant.now();
        System.out.println(instant);
        java.util.Date date = Date.from(instant);
        //LocalDateTime from = LocalDateTime.from(instant);
        //System.out.println(from);
        System.out.println(date);
        Instant toInstant = date.toInstant();
        System.out.println(toInstant);
    }
}
