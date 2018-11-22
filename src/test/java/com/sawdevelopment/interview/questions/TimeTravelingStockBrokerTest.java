package com.sawdevelopment.interview.questions;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TimeTravelingStockBrokerTest {
  private TimeTravelingStockBroker sut = new TimeTravelingStockBroker();

  @Test
  public void test_trip1() {
    int[] stockPrices = new int[]{1, 3, 2, 6, 9, 4, 5, 2, 2, 1};
    assertEquals(sut.maxProfit(stockPrices), 10);
  }

  @Test
  public void test_trip2() {
    int[] stockPrices = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    assertEquals(sut.maxProfit(stockPrices), 0);
  }

  @Test
  public void test_trip3() {
    int[] stockPrices = new int[]{5, 2, 9, 7, 9, 9, 2, 4, 5, 8};
    assertEquals(sut.maxProfit(stockPrices), 15);
  }

  @Test
  public void test_trip4() {
    int[] stockPrices = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertEquals(sut.maxProfit(stockPrices), 9);
  }

  @Test
  public void test_trip5() {
    int[] stockPrices = new int[]{6, 6, 4, 5, 6, 6, 6, 7, 8, 9};
    assertEquals(sut.maxProfit(stockPrices), 5);
  }

  @Test
  public void test_trip6() {
    int[] stockPrices = new int[]{8, 5, 6, 4, 5, 3, 6, 8, 2, 9};
    assertEquals(sut.maxProfit(stockPrices), 14);
  }

  @Test
  public void test_trip7() {
    int[] stockPrices = new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
    assertEquals(sut.maxProfit(stockPrices), 0);
  }
}