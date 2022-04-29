package FpsApi.models.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class AddLogRequest {


    String gameMode;
    String guid;
    String userGuid;
    LocalDateTime startDateTime;
    String startDateTimeStr;

    LocalDateTime lastModifiedTime;
    String lastModifiedTimeStr;

    LocalDateTime endDateTime;
    String endDateTimeStr;

    String locationCode;
    public void setStartDateTimeStr(String startDateTimeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try{
            this.startDateTime = LocalDateTime.parse(startDateTimeStr,formatter);
            this.startDateTimeStr = startDateTimeStr;
        } catch (Exception e){}
    }

    public void setLastModifiedTimeStr(String lastModifiedTimeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try{
            this.lastModifiedTime = LocalDateTime.parse(lastModifiedTimeStr,formatter);
            this.lastModifiedTimeStr = lastModifiedTimeStr;
        } catch (Exception e){}
    }

    public void setEndDateTimeStr(String endDateTimeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try{
            this.endDateTime = LocalDateTime.parse(endDateTimeStr,formatter);
            this.endDateTimeStr = endDateTimeStr;
        } catch (Exception e){}
    }

}
