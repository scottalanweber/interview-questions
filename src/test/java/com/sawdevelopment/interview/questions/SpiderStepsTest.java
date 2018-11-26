package com.sawdevelopment.interview.questions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SpiderStepsTest {
  private SpiderSteps sut = new SpiderSteps();

  @Test
  public void test_0() {
    assertEquals(sut.stepsTaken(50, 50, 1), 1);
  }

  @Test
  public void test_1() {
    assertEquals(sut.stepsTaken(50, 100, 1), 1);
  }

  @Test
  public void test_2() {
    assertEquals(sut.stepsTaken(100, 75, 1), 2);
  }

  @Test
  public void test_3() {
    assertEquals(sut.stepsTaken(200, 50, 1), 5);
  }

  @Test
  public void test_4() {
    assertEquals(sut.stepsTaken(500, 20, 15), 97);
  }

  @Test
  public void test_5() {
    assertEquals(sut.stepsTaken(190, 50, 1), 4);
  }
}