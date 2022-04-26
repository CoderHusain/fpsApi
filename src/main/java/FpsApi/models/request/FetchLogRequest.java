package FpsApi.models.request;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.SimpleFormatter;

@Getter
@Setter
public class FetchLogRequest {
    LocalDateTime dateTime;
    String dateTimeStr;

    public void setDateTimeStr(String dateTimeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        try{
            this.dateTime = LocalDateTime.parse(dateTimeStr,formatter);
        } catch (Exception e){}
    }
}
