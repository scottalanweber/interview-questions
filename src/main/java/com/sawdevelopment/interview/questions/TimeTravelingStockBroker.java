package com.sawdevelopment.interview.questions;

/**
 * As a Stock Broker and an Inventor, you've developed the technology that will allow for you to travel back in time exactly 10 days.
 * You use this technology for financial gain by buying and selling stock knowing what the price is going to do the next
 * day. For simplicity, let's assume you only buy a single stock. Write a method that determines the maximum financial
 * gain that you can earn each trip back in time. The given price on any single day will always be greater than 0.
 *
 * For example, with the given data set of [1, 3, 2, 6, 9, 4, 5, 2, 2, 1], max gain = (3-1) + (9-2) + (5-4) = 10
 *
 * @author scottalanweber
 */
class TimeTravelingStockBroker {
  int maxProfit(int[] stockPrices) {
    char currentState = 'H';
    int buyPrice = 0;
    int maxGain = 0;

    for(int i = 0; i < stockPrices.length - 1; ++i) {
      if(stockPrices[i] < stockPrices[i+1] && currentState != 'B' && buyPrice == 0) {
        currentState = 'B';
        buyPrice = stockPrices[i];
        continue;
      }

      if(stockPrices[i] > stockPrices[i+1] && currentState != 'S' && buyPrice > 0) {
        currentState = 'S';
        maxGain += stockPrices[i] - buyPrice;
        buyPrice = 0;
        continue;
      }

      currentState = 'H';
    }

    if(buyPrice > 0 && currentState != 'S') {
      maxGain += stockPrices[stockPrices.length - 1] - buyPrice;
    }

    return maxGain;
  }
}
