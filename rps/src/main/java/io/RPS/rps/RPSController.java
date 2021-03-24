package io.RPS.rps;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.RPS.GamePlay;
import io.RPS.RPS;

@RestController
public class RPSController {

    ArrayList<ResultBean> winnerList = new ArrayList<ResultBean>();
    int round = 0;
   
    
    @RequestMapping(method = RequestMethod.POST, value = "pve")
    public String postPvE(@RequestParam(defaultValue = "000") String input){
        round +=1;
        ResultBean result = new ResultBean(round, input.toUpperCase(), RPS.generateRandomValue(), GamePlay.determineWinner(input, RPS.generateRandomValue()));
       winnerList.add(result);
      return "done";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "pve", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ResultBean> getPvE(@RequestParam(defaultValue = "000") String input){
       
    return winnerList;
    }
    
   
}
