package io.RPS.rps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.RPS.GamePlay;
import io.RPS.RPS;

@RestController
public class RPSController {

    ArrayList<ResultBean> pveWinnerList = new ArrayList<ResultBean>();
    ArrayList<ResultBean> pvpWinnerList = new ArrayList<ResultBean>();
    int round = 0;
   
    @RequestMapping(method =RequestMethod.GET, value = "date")
    public String showDate(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
     
        return dateFormat.format(new Date());
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "pve")
    public ArrayList<ResultBean> postPvE(@RequestParam(defaultValue = "000") String input){
        round +=1;
        ResultBean result = new ResultBean(round, input.toUpperCase(), RPS.generateRandomValue(), GamePlay.determineWinner(input, RPS.generateRandomValue()));
       pveWinnerList.add(result);
       return getPvE();
      
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "pve", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ResultBean> getPvE(){
       
    return pveWinnerList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "pvp")
    public ArrayList<ResultBean> postPvP(@RequestParam(defaultValue = "000") String frstinput,@RequestParam(defaultValue = "000") String scndinput){
        round +=1;
        ResultBean result = new ResultBean(round, frstinput.toUpperCase(), scndinput.toUpperCase(), GamePlay.determineWinner(frstinput, scndinput));
       pvpWinnerList.add(result);

       return getPvP();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "pvp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ResultBean> getPvP(){
       
    return pvpWinnerList;
    }
    
   
}
