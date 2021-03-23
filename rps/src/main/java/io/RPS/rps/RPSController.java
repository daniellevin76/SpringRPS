package io.RPS.rps;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.RPS.GamePlay;
import io.RPS.RPSBean;

@RestController
public class RPSController {

    @RequestMapping(method = RequestMethod.GET, value = "pve")
    public String pvE(@RequestParam String input){
        
       
       return GamePlay.determineWinner(input, RPSBean.generateRandomValue());
    }
    
}
