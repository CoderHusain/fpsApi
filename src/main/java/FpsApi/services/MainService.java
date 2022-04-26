package FpsApi.services;

import FpsApi.models.entities.User;
import FpsApi.models.entities.UserPlayLog;
import FpsApi.models.request.FetchLogRequest;
import FpsApi.models.response.AbstractResponse;
import FpsApi.models.response.FetchLogResponse;
import FpsApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MainService {

    @Autowired
    UserRepository userRepository;

    public FetchLogResponse fetchMaxPlayerMode(FetchLogRequest fetchLogRequest){
        UserPlayLog userPlayLog = userRepository.aggregateByLocationMode(fetchLogRequest.getDateTime());
        FetchLogResponse response = new FetchLogResponse();
        response.setObject(userPlayLog);
        response.setSuccess(true);
        return response;
    }

    public AbstractResponse addUser(User user) throws Exception {
        AbstractResponse response = new AbstractResponse();
        userRepository.save(user);
        response.setSuccess(true);
        return response;
    }



}
