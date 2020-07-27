package com.solid.isp;

public class Pinguim implements Aves {

    @Override
    public Double getMaxRunningDistance() {
        return 500000d;
    }

    @Override
    public Integer birdEggsMedium() {
        return 1;
    }

    @Override
    public Double getMaxFlyingHeight() {
        return null;
    }
}
