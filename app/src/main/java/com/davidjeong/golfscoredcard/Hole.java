package com.davidjeong.golfscoredcard;

public class Hole {
    private String mLabel;
    private int mHoleScore;

    public Hole(String label, int holeScore) {
        mLabel = label;
        mHoleScore = holeScore;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public int getHoleScore() {
        return mHoleScore;
    }

    public void setHoleScore(int holeScore) {
        mHoleScore = holeScore;
    }
}
