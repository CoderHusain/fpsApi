package FpsApi.models.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class AddLogRequest {


    String gameMode;
    String userGuid;
    LocalDateTime startdateTime;
    String startdateTimeStr;

    LocalDateTime endDateTime;
    String endDateTimeStr;

    public void setStartDateTimeStr(String startDateTimeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        try{
            this.startdateTime = LocalDateTime.parse(startDateTimeStr,formatter);
        } catch (Exception e){}
    }

    public void setEndDateTimeStr(String endDateTimeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        try{
            this.endDateTime = LocalDateTime.parse(endDateTimeStr,formatter);
        } catch (Exception e){}
    }
}
