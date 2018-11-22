import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of stairs of length L, and choices of taking one, two, or three stairs with each step, what are the total
 * number of ways you can choose to take steps when climbing these stairs without overshooting the top meaning the last
 * step taken lands you at the top?
 *
 * @author boydmr
 */
class Stairs123 {

  final class StepsTaken {
    List<Integer> sizeOfEachStep = new ArrayList<>();

    void addPrecedingSteps(StepsTaken previousPattern) {
      sizeOfEachStep.addAll(previousPattern.sizeOfEachStep);
    }
    void addStep(int stepSize) {
      sizeOfEachStep.add(stepSize);
    }

    void removeLastStep() {
      sizeOfEachStep.remove(sizeOfEachStep.size()-1);
    }
  }

  /**
   * ~~~~~ Scott's Solution ~~~~~
   * Recursively calculate the number of possible steps that can be taken to reach the top of the stairs.
   * @param numberOfStairs Number of stairs that will be in the staircase
   * @return number of possible combinations
   */
  int calculateCombinationsRecursive(int numberOfStairs) {
    if(numberOfStairs <= 0) {
      return 0;
    }

    return getValidPatternsRecursive(numberOfStairs);
  }

  private int getValidPatternsRecursive(int numberOfStairs) {
    if (numberOfStairs < 0) {
      return 0;
    }

    if (numberOfStairs <= 1) {
      return 1;
    }

    return getValidPatternsRecursive(numberOfStairs - 1) +
        getValidPatternsRecursive(numberOfStairs - 2) +
        getValidPatternsRecursive(numberOfStairs - 3);
  }

  /**
   * Calculate the total number of ways I can take 1, 2, or 3 stairs each step until I reach the top.
   * @param numberOfStairs Number of stairs that will be in the staircase
   * @return the number of valid combinations or 0 if no combination works.
   */
  List<StepsTaken> calculateCombinations(int numberOfStairs, List<Integer> sizes) {
    List<StepsTaken> validPatternsAccumulator = new ArrayList<>();
    StepsTaken stepsTakenSoFar = new StepsTaken();
    getValidPatterns(numberOfStairs, sizes, stepsTakenSoFar, validPatternsAccumulator);
    System.out.println("For " + numberOfStairs + " stairs and allowed steps: " + sizes);
    for(int i=0; i<validPatternsAccumulator.size(); i++) {
      System.out.println(i + ": " + validPatternsAccumulator.get(i).sizeOfEachStep);
    }
    return validPatternsAccumulator;
  }

  private void getValidPatterns(int numberOfStairs, List<Integer> sizes, StepsTaken stepsTakenSoFar, List<StepsTaken> validPatternsAccumulator) {
    for(int sizeToTakeThisStep : sizes) {
      int remainingStairs = numberOfStairs - sizeToTakeThisStep;
      if (remainingStairs < 0) { // invalid last step size. try next step size.
        continue;
      }
      if (remainingStairs == 0) { // we landed at the top with. this is a valid pattern.
        StepsTaken validPattern = new StepsTaken();
        validPattern.addPrecedingSteps(stepsTakenSoFar);
        validPattern.addStep(sizeToTakeThisStep);
        validPatternsAccumulator.add(validPattern);
        continue;
      }
      if (remainingStairs > 0) { // more steps to take. run again with the remaining steps and the current step taken.
        stepsTakenSoFar.addStep(sizeToTakeThisStep);
        getValidPatterns(remainingStairs, sizes, stepsTakenSoFar, validPatternsAccumulator);
        stepsTakenSoFar.removeLastStep();
      }
    }
  }
}
