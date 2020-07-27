package com.solid.isp;

public class Arara implements Aves {


    @Override
    public Double getMaxRunningDistance() {
        return 19800d;
    }

    @Override
    public Double getMaxFlyingHeight() {
        return 11270d;
    }

    @Override
    public Integer birdEggsMedium() {
        return 2;
    }
}
