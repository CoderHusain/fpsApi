package FpsApi.jobs;

import FpsApi.Constants;
import FpsApi.models.entities.UserPlayLog;
import FpsApi.repositories.UserPlayLogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckLogProcessor {

    public static final Logger _log = LogManager.getLogger(CheckLogProcessor.class);
    @Autowired
    UserPlayLogRepository userPlayLogRepository;
    @Scheduled(fixedRate = 10000)
    @Transactional
    public void checkLog() throws Exception{
        List<UserPlayLog> userPlayLogs = userPlayLogRepository.getLogsByStatus(Constants.PlayingStatus.PLAYING);
        for(UserPlayLog userPlayLog: userPlayLogs){
            LocalDateTime lastModifiedTime = userPlayLog.getLastModifiedTime();

            if(lastModifiedTime != null && lastModifiedTime.plusMinutes(2).isBefore(LocalDateTime.now())){
                userPlayLog.setPlayingStatus(Constants.PlayingStatus.END_MODE);
                userPlayLog.setEndDateTime(lastModifiedTime);
                userPlayLogRepository.update(userPlayLog);
                _log.info(userPlayLog.getUser().getName() + " has ended game mode " + userPlayLog.getGameMode() +
                        " at " + lastModifiedTime);
            }

        }
    }

}
