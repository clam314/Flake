package com.clam314.flake;

/**
 * Created by clam314 on 2017/2/21
 */

public class Line {
    int x1;
    int y1;
    int x2;
    int y2;

    public Line(int x1,int y1,int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void set(int x1, int y1,int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
