package com.sawdevelopment.interview.questions;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @author scottalanweber
 */
public class T9MapperTest {
  private T9Mapper sut = new T9Mapper();

  @Test
  public void testMapToWords() {
    List<String> output = sut.mapToWords(Arrays.asList(2, 2, 8));

    assertNotNull(output);
    assertEquals(27, output.size());
  }

}