package io.RPS;

import java.util.Random;

public class RPSBean {

    public static final String[] rps = {"ROCK", "PAPER", "SCISSOR"};

    public static String[] getRps() {
        return rps;
    }

    public static String generateRandomValue() {
        Random rand = new Random();
        return rps[rand.nextInt(rps.length)];

    }

    ResultObject result = new ResultObject();
    
}