package com.sawdevelopment.interview.questions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNull;

/**
 * @author Scott Weber
 */
public class ShortestPalindromeTest {

  private ShortestPalindrome sut;

  @BeforeMethod
  public void setup() {

    sut = new ShortestPalindrome();
  }

  @Test
  public void testShortestPalindrome_NullString() {
    assertNull(sut.shortestPalindromeRecursive(null));
    assertNull(sut.shortestPalindromeIterative(null));
    assertNull(sut.shortestPalindromeBrie(null));
  }

  @Test
  public void testShortestPalindrome_EmptyString() {
    assertEquals(sut.shortestPalindromeRecursive(""), "");
    assertEquals(sut.shortestPalindromeIterative(""), "");
    assertEquals(sut.shortestPalindromeBrie(""), "");
  }

  @Test
  public void testShortestPalindrome_SingleCharString() {
    assertEquals(sut.shortestPalindromeRecursive("a"), "a");
    assertEquals(sut.shortestPalindromeIterative("a"), "a");
    assertEquals(sut.shortestPalindromeBrie("a"), "a");
  }

  @Test
  public void testShortestPalindrome_PalindromeString() {
    assertEquals(sut.shortestPalindromeRecursive("acca"), "acca");
    assertEquals(sut.shortestPalindromeRecursive("acbca"), "acbca");

    assertEquals(sut.shortestPalindromeIterative("acca"),"acca");
    assertEquals(sut.shortestPalindromeIterative("acbca"), "acbca");

    assertEquals(sut.shortestPalindromeBrie("acca"),"acca");
    assertEquals(sut.shortestPalindromeBrie("acbca"), "acbca");
  }

  @Test
  public void testShortestPalindrome_NonPalindromeString_NotCompleteCopy() {
    assertEquals(sut.shortestPalindromeRecursive("baaabc"), "cbaaabc");
    assertEquals(sut.shortestPalindromeRecursive("abadc"), "cdabadc");
    assertEquals(sut.shortestPalindromeRecursive("aaabcbaa"), "aabcbaaabcbaa");

    assertEquals(sut.shortestPalindromeIterative("baaabc"), "cbaaabc");
    assertEquals(sut.shortestPalindromeIterative("abadc"), "cdabadc");
    assertEquals(sut.shortestPalindromeIterative("aaabcbaa"), "aabcbaaabcbaa");

    assertEquals(sut.shortestPalindromeBrie("baaabc"), "cbaaabc");
    assertEquals(sut.shortestPalindromeBrie("abadc"), "cdabadc");
    assertEquals(sut.shortestPalindromeBrie("aaabcbaa"), "aabcbaaabcbaa");
  }

  @Test
  public void testShortestPalindrome_NonPalindromeString_CompleteCopy() {
    assertEquals(sut.shortestPalindromeRecursive("dogbreath"), "htaerbgodogbreath");
    assertEquals(sut.shortestPalindromeRecursive("bcaaabc"), "cbaaacbcaaabc");

    assertEquals(sut.shortestPalindromeIterative("dogbreath"), "htaerbgodogbreath");
    assertEquals(sut.shortestPalindromeIterative("bcaaabc"), "cbaaacbcaaabc");

    assertEquals(sut.shortestPalindromeBrie("dogbreath"), "htaerbgodogbreath");
    assertEquals(sut.shortestPalindromeBrie("bcaaabc"), "cbaaacbcaaabc");
  }

}
