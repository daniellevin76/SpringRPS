package io.RPS.rps;



public class ResultBean {
    public  int round;
    public  String firsInput;
    public  String secondInput;
    public  String winner;
    
    public ResultBean(int round, String firsInput, String secondInput, String winner) {
        this.round = round;
        this.firsInput = firsInput;
        this.secondInput = secondInput;
        this.winner = winner;
       
    }
    public int getRound() {
        return round;
    }
    
    public String getFirsInput() {
        return firsInput;
    }
   
    public String getSecondInput() {
        return secondInput;
    }
   
    public String getWinner() {
        return winner;
    }
    
   
    
    public String toString(){
        return "Round: "+round+", First Input: "+firsInput+", Second Input: "+secondInput+", Winner: "+winner;
    }
    

}
