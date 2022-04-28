package FpsApi.services;

import FpsApi.models.entities.User;
import FpsApi.models.entities.UserPlayLog;
import FpsApi.models.request.AddLogRequest;
import FpsApi.models.request.FetchLogRequest;
import FpsApi.models.response.AbstractResponse;
import FpsApi.models.response.FetchLogResponse;
import FpsApi.repositories.UserPlayLogRepository;
import FpsApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class MainService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPlayLogRepository logRepository;

    public FetchLogResponse fetchMaxPlayerMode(FetchLogRequest fetchLogRequest){
        List<UserPlayLog> logs = logRepository.aggregateByLocationMode(fetchLogRequest.getDateTime());
        FetchLogResponse response = new FetchLogResponse();
        UserPlayLog maxMode = null;
        long max = 0L;
        for(UserPlayLog playLog: logs){
            if(playLog.getTotalPlayers() > max) {
                max = playLog.getTotalPlayers();
                maxMode = playLog;
            }
        }
        response.setObject(maxMode);
        response.setSuccess(true);
        return response;
    }

    public AbstractResponse addUser(User user) throws Exception {
        AbstractResponse response = new AbstractResponse();
        userRepository.save(user);
        response.setSuccess(true);
        return response;
    }

    public AbstractResponse addUserPlayLog(AddLogRequest logRequest) throws Exception {
        AbstractResponse response = new AbstractResponse();
        User user = userRepository.findByGuid(logRequest.getUserGuid());
        UserPlayLog log = new UserPlayLog();
        log.setUser(user);
        log.setGameMode(logRequest.getGameMode());
        log.setStartDateTime(logRequest.getStartDateTime());
//        log.setEndDateTime(logRequest.getEndDateTime());
        logRepository.save(log);
        response.setSuccess(true);
        return response;
    }

    public AbstractResponse updateUserPlayLog(AddLogRequest logRequest) throws Exception {
        AbstractResponse response = new AbstractResponse();
        UserPlayLog userPlayLog = logRepository.findByGuid(logRequest.getGuid());
        userPlayLog.setLastModifiedTime(logRequest.getLastModifiedTime());
        logRepository.save(userPlayLog);
        response.setSuccess(true);
        return response;
    }




}
