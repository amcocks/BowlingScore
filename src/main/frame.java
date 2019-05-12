package main;

public class frame {
    boolean isFrameTen;
    int[] roll;
    int bonusRoll;
    enum rollValue {
        first,
        second
    }
    public frame(int firstRollVal, int secondRollVal) {
        isFrameTen = false;
        bonusRoll = 0;
        roll = new int[] {firstRollVal, secondRollVal};
    }
    public frame(int firstRollVal, int secondRollVal, int bonusRollVal) {
        isFrameTen = true;
        roll = new int[] {firstRollVal, secondRollVal};
        bonusRoll = bonusRollVal;
    }
    public int getFirstRollVal() {
        return roll[rollValue.first.ordinal()];
    }
    public int getSecondRollVal() {
        return roll[rollValue.second.ordinal()];
    }
    public boolean isFrameTen() {
        return isFrameTen;
    }
    public int getBonusRoll() {
        if(isFrameTen) {
            return bonusRoll;
        }
        else {
            return 0;
        }
    }

    public int scoreFrame(int nextRoll, int nextNextRoll) {
        int score = 0;
        int frameTotal = getFirstRollVal() + getSecondRollVal();
        int strikeSpareTotal = 10;
        int frameTenStrikeSpareTotal = 20;
        score = frameTotal; // in all cases the score is at least the frame total
        // If this is the 10th frame, populate nextRoll with BonusRoll
        if(this.isFrameTen()){
            nextRoll = getBonusRoll();
        }
        // If it was a strike or spare, add the next roll
        if(frameTotal == strikeSpareTotal || (this.isFrameTen() && (frameTotal == frameTenStrikeSpareTotal))) {
            score += nextRoll;
        }
        // If this was a strike, then the total is also the value of the NextNextRoll
        if(getFirstRollVal() == strikeSpareTotal) {
            score += nextNextRoll;
        }
        return score;
    }
}
