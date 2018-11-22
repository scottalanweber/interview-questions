import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of stairs of length L, and choices of taking one, two, or three stairs with each step, what are the total
 * number of ways you can choose to take steps when climbing these stairs without overshooting the top meaning the last
 * step taken lands you at the top?
 *
 * @author boydmr
 */
public class Stairs123 {

  public final class StepsTaken {
    List<Integer> sizeOfEachStep = new ArrayList<>();

    public void addPrecedingSteps(StepsTaken previousPattern) {
      sizeOfEachStep.addAll(previousPattern.sizeOfEachStep);
    }
    public void addStep(int stepSize) {
      sizeOfEachStep.add(stepSize);
    }

    public void removeLastStep() {
      sizeOfEachStep.remove(sizeOfEachStep.size()-1);
    }
  }

  /**
   * Calculate the total number of ways I can take 1, 2, or 3 stairs each step until I reach the top.
   * @param numberOfStairs
   * @return the number of valid combinations or 0 if no combination works.
   */
  public List<StepsTaken> calculateCombinations(int numberOfStairs, List<Integer> sizes) {
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
