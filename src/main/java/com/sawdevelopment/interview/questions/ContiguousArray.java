package com.sawdevelopment.interview.questions;

import java.util.Arrays;

/**
 * Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous integers else print “No”.
 */
class ContiguousArray {
  boolean isContiguous(int[] inputValues) {
    // Sort
    Arrays.sort(inputValues);
    for(int i = 0; i < inputValues.length - 1; ++i) {
      if(inputValues[i+1] - inputValues[i] > 1) {
        return false;
      }
    }

    return true;
  }
}
