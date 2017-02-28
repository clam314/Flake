package com.clam314.flake;

/**
 * Created by clam314 on 2017/2/21
 */

public class Random {
    private static final java.util.Random RANDIM = new java.util.Random();

    public float getRandom(float lower,float upper){
        float min = Math.min(lower,upper);
        float max = Math.max(lower,upper);
        return getRandom(max-min)+min;
    }

    public float getRandom(float upper){
        return RANDIM.nextFloat()*upper;
    }

    public int getRandom(int upper){
        return RANDIM.nextInt(upper);
    }

    public int[] getLine(int height, int width) {
        int[] tempCheckNum = { 0, 0, 0, 0 };
        int temp = getRandomWidth(width);
        tempCheckNum[0] = temp;
        tempCheckNum[1] = (int) (Math.random() * height/4);
        tempCheckNum[2] = temp;
        tempCheckNum[3] = (int) (Math.random() * height/2);
        return tempCheckNum;
    }

    public int getRandomWidth(int width){
        return (int) (Math.random() * width);
    }
}
