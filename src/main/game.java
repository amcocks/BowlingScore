package main;

import java.util.*;

public class game {
    ArrayList<frame> frames = new ArrayList<>();
    public game(int[] rolls) {
        //Start by creating frames to represent all of the rolls
        // Add the first nine frames
        int rollsFirstNineFrames = 18;
        int rollsPerFrame = 2;
        for(int position=0; position < rollsFirstNineFrames; position+=rollsPerFrame) {
            int positionRollOne = position;
            int positionRollTwo = positionRollOne + 1;
            frames.add(new frame(rolls[positionRollOne],rolls[positionRollTwo]));
        }
        // Now, adding the 10th frame which is a special case
        int rollOneFrameTenPosition = 18;
        int rollTwoFrameTenPosition = 19;
        int rollBonusFrameTenPosition = 20;
        frames.add(new frame(rolls[rollOneFrameTenPosition], rolls[rollTwoFrameTenPosition], rolls[rollBonusFrameTenPosition]));
    }
    public int scoreGame() {
        int score = 0;
        for(int frameIndex=0; frameIndex < frames.size(); frameIndex++){
            frame thisFrame = frames.get(frameIndex);
            int frameScore = 0;
            // When scoring frames, we may need to know the next two rolls
            int futureRoll = 0;
            int futureNextRoll = 0;
            int strikeScore = 10;
            if (frameIndex < (frames.size() - 1)){
                // There will be another frame, so this isn't the final one
                frame futureFrame = frames.get(frameIndex +1);
                futureRoll = futureFrame.getFirstRollVal();
                futureNextRoll = futureFrame.getSecondRollVal();
                // Turkey logic, need to look forward an additional frame
                if(futureRoll == strikeScore && frameIndex < (frames.size() - 2)) {
                    frame futureFutureFrame = frames.get(frameIndex + 2);
                    futureNextRoll = futureFutureFrame.getFirstRollVal();
                }
            }
            frameScore = thisFrame.scoreFrame(futureRoll, futureNextRoll);
            System.out.print("Frame score: " + frameScore);
            score += frameScore;
        }
        return score;
    }
}
