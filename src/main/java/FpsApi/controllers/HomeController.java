package FpsApi.controllers;

import FpsApi.models.request.FetchLogRequest;
import FpsApi.models.response.FetchLogResponse;
import FpsApi.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public FetchLogResponse fetchMaxPlayedMode(FetchLogRequest request){
        return mainService.fetchMaxPlayerMode(request);
    }
}
