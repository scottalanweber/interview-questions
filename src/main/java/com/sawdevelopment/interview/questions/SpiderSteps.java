package com.sawdevelopment.interview.questions;

class SpiderSteps {
  int stepsTaken(int wallHeight, int stepsForward, int stepsBack) {
    int totalSteps = 1;
    int heightClimbed = 0;

    while(true) {
      heightClimbed = heightClimbed + stepsForward;

      if(wallHeight <= heightClimbed) {
        return totalSteps;
      }

      heightClimbed = heightClimbed - stepsBack;
      ++totalSteps;
    }
  }
}
