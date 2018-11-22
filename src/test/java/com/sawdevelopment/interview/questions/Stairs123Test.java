package com.sawdevelopment.interview.questions;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author boydmr
 */
public class Stairs123Test {

  @Test
  public void test_1_2_3_sizes_w_0_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(0, Arrays.asList(1,2,3));
    assertEquals(0, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_1_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(1, Arrays.asList(1,2,3));
    assertEquals(1, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_2_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(2, Arrays.asList(1,2,3));
    assertEquals(2, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_3_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(3, Arrays.asList(1,2,3));
    assertEquals(4, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_4_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(4, Arrays.asList(1,2,3));
    assertEquals(7, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_5_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(5, Arrays.asList(1,2,3));
    assertEquals(13, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_6_stairs() {
    Stairs123 sut = new Stairs123();
    List<Stairs123.StepsTaken> validPatterns = sut.calculateCombinations(6, Arrays.asList(1,2,3));
    assertEquals(24, validPatterns.size());
  }

  @Test
  public void test_1_2_3_sizes_w_0_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(0);
    assertEquals(0, validPatterns);
  }

  @Test
  public void test_1_2_3_sizes_w_1_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(1);
    assertEquals(1, validPatterns);
  }

  @Test
  public void test_1_2_3_sizes_w_2_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(2);
    assertEquals(2, validPatterns);
  }

  @Test
  public void test_1_2_3_sizes_w_3_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(3);
    assertEquals(4, validPatterns);
  }

  @Test
  public void test_1_2_3_sizes_w_4_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(4);
    assertEquals(7, validPatterns);
  }

  @Test
  public void test_1_2_3_sizes_w_5_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(5);
    assertEquals(13, validPatterns);
  }

  @Test
  public void test_1_2_3_sizes_w_6_stairs_recursive() {
    Stairs123 sut = new Stairs123();
    int validPatterns = sut.calculateCombinationsRecursive(6);
    assertEquals(24, validPatterns);
  }
}
