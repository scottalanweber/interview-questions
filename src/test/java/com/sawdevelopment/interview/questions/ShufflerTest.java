package com.sawdevelopment.interview.questions;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Scott Weber
 */
public class ShufflerTest
{
  private Shuffler sut;
  private List<Object> items;
  private static final int SIZE = 52;

  @BeforeMethod
  public void setup() {
    items = generateTestList();

    sut = new Shuffler();
  }

  private List<Object> generateTestList() {
    List<Object> list = new ArrayList<>();
    for (int i = 0; i < SIZE; i++) {
      list.add(i);
    }
    return list;
  }

  @Test
  public void NullListParameter() {
    List<Object> actual = sut.shuffle(null);

    assertEquals(actual.size(), 0);
  }

  @Test
  public void EmptyListParameter() {
    List<Object> actual = sut.shuffle(new ArrayList<>());

    assertEquals(actual.size(), 0);
  }

  @Test
  public void shouldContainAllOriginalItems() {
    List<Object> actual = sut.shuffle(items);

    for (Object o : items) {
      assertTrue(actual.contains(o));
    }
  }

  @Test
  public void shouldContainNoNewItems() {
    List<Object> actual = sut.shuffle(items);

    assertEquals(actual.size(), items.size());
  }

  @Test
  public void shouldBeReordered_EvenSizeList() {
    List<Object> actual = sut.shuffle(items);

    verifyOrderedList(actual);
  }

  @Test
  public void shouldBeReordered_OddSizeList() {
    items.remove(items.size() - 1);
    List<Object> actual = sut.shuffle(items);

    verifyOrderedList(actual);
  }

  @Test
  public void outputResult_EvenList() {
    List<Object> actual = sut.shuffle(items);

    System.out.println("EVEN SIZE LIST: " + actual);
  }

  @Test
  public void outputResult_OddList() {
    items.remove(items.size() - 1);
    List<Object> actual = sut.shuffle(items);

    System.out.println("ODD SIZE LIST: " + actual);
  }

  private void verifyOrderedList(List<Object> actual) {
    Integer prev = (Integer) actual.get(actual.size() - 1);
    Integer current;
    Integer diff;

    for (Object o : actual) {
      current = (Integer) o;
      diff = current - prev;
      // Verify consecutive numbers are not neighbors
      assertNotEquals(diff, 1, String.format("%s is next to %s", current, prev));
      assertNotEquals(diff, -1, String.format("%s is next to %s", current, prev));

      // Verify endpoints are not neighbors (0 and 51 in a 52 item list)
      assertNotEquals(diff, SIZE - 1, String.format("%s is next to %s", current, prev));
      assertNotEquals(diff, 1 - SIZE, String.format("%s is next to %s", current, prev));
      prev = current;
    }
  }
}
