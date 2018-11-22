package com.sawdevelopment.interview.questions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author scottalanweber
 */
public class JsonCounterTest {

  private JsonCounter sut;

  @BeforeMethod
  public void setUp() {
    sut = new JsonCounter();
  }

  @Test
  public void testCountJsonObjects() {
    assertEquals(sut.countJsonObjects(), 9961);
  }
}