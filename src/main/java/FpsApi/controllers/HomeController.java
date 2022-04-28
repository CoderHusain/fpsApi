package FpsApi.controllers;

import FpsApi.models.entities.User;
import FpsApi.models.entities.UserPlayLog;
import FpsApi.models.request.AddLogRequest;
import FpsApi.models.request.FetchLogRequest;
import FpsApi.models.response.AbstractResponse;
import FpsApi.models.response.FetchLogResponse;
import FpsApi.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    MainService mainService;

    @GetMapping
    public String home(){
        return "homepage";
    }

    @PostMapping(value = "/maxPlayers")
    public FetchLogResponse fetchMaxPlayedMode(@RequestBody FetchLogRequest request){
        return mainService.fetchMaxPlayerMode(request);
    }

    @PostMapping(value = "/user")
    public AbstractResponse addUser(@RequestBody User user) throws Exception{
        return mainService.addUser(user);
    }

    @PostMapping(value = "/log")
    public AbstractResponse addPlayLog(@RequestBody AddLogRequest logRequest) throws Exception {
        return mainService.addUserPlayLog(logRequest);
    }

    @PostMapping(value = "/updatelogm")
    public AbstractResponse updateUserLog(@RequestBody AddLogRequest logRequest) throws Exception{
       return mainService.updateUserPlayLog(logRequest);
    }
}
