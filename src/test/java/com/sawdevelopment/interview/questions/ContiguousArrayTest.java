package com.sawdevelopment.interview.questions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ContiguousArrayTest {
  private ContiguousArray sut = new ContiguousArray();

  @Test
  public void contiguousArrayTest_0() {
    int[] input = new int[]{5, 2, 3, 6, 4, 4, 6, 6};
    assertTrue(sut.isContiguous(input));
  }

  @Test
  public void contiguousArrayTest_1() {
    int[] input = new int[]{10, 14, 10, 12, 12, 13, 15};
    assertFalse(sut.isContiguous(input));
  }

  @Test
  public void contiguousArrayTest_2() {
    int[] input = new int[]{4, 2, 3, 7, 4, 4, 6, 6};
    assertFalse(sut.isContiguous(input));
  }

  @Test
  public void contiguousArrayTest_3() {
    int[] input = new int[]{1, 2, 3, 6, 4, 4, 5, 6};
    assertTrue(sut.isContiguous(input));
  }

  @Test
  public void contiguousArrayTest_4() {
    int[] input = new int[]{5, 2, 3, 1, 4, 4, 9, 6};
    assertFalse(sut.isContiguous(input));
  }
}