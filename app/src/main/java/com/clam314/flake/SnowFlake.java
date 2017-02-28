package com.clam314.flake;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * Created by clam314 on 2017/2/21
 */

public class SnowFlake {
    private static final float ANGLE_RANGE = 0.1f;
    private static final float HALF_ANGLE_RANGE = ANGLE_RANGE/2f;
    private static final float HALF_PI = (float)Math.PI/2f;
    private static final float ANGLE_SEED = 25f;
    private static final float ANGLE_DIVISOR = 10000f;

    private static final float INCREMENT_LOWER = 2f;
    private static final float INCREMENT_UPPER = 4f;

    private static final float FLAKE_SIZE_LOWER = 7f;
    private static final float FLAKE_SIZE_UPPER = 20f;

    private final Random mRandom;
    private final Point mPosition;
    private float mAngle;
    private final float mIncrement;
    private final float mFlakeSize;
    private final Paint mPaint;

    private SnowFlake(Random random, Point position, float angle, float increment, float flakeSize, Paint paint){
        mRandom = random;
        mPosition = position;
        mAngle = angle;
        mIncrement = increment;
        mFlakeSize = flakeSize;
        mPaint = paint;
    }

    public static SnowFlake create(int width, int height, Paint paint){
        Random random = new Random();
        int x = random.getRandom(width);
        int y = random.getRandom(height);
        Point position = new Point(x,y);
        float angle = random.getRandom(ANGLE_SEED)/ANGLE_SEED*ANGLE_RANGE+HALF_PI-HALF_ANGLE_RANGE;
        float increment = random.getRandom(INCREMENT_LOWER,INCREMENT_UPPER);
        float flakeSize = random.getRandom(FLAKE_SIZE_LOWER,FLAKE_SIZE_UPPER);
        return new SnowFlake(random,position,angle,increment,flakeSize,paint);
    }

    public void draw(Canvas canvas){
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        move(width,height);
        canvas.drawCircle(mPosition.x,mPosition.y,mFlakeSize,mPaint);
    }

    private void move(int width, int height){
        double x = mPosition.x + (mIncrement * Math.cos(mAngle));
        double y = mPosition.y + (mIncrement * Math.sin(mAngle));
        mAngle += mRandom.getRandom(-ANGLE_SEED,ANGLE_SEED)/ANGLE_DIVISOR;
        mPosition.set((int)x,(int)y);
        if (!isInside(width,height)){
            reset(width);
        }
    }

    private boolean isInside(int width,int height){
        int x = mPosition.x;
        int y = mPosition.y;
        return x > mFlakeSize - 5 && x + mFlakeSize <= width && y >= -mFlakeSize - 1 && y - mFlakeSize < height;
    }

    private void reset(int width){
        mPosition.x = mRandom.getRandom(width);
        mPosition.y = (int)(-mFlakeSize -1);
        mAngle = mRandom.getRandom(ANGLE_SEED)/ANGLE_SEED*ANGLE_RANGE+HALF_PI-HALF_ANGLE_RANGE;
    }
}
