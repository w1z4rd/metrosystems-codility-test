package org.costa;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemThreeTest {
  private static ProblemThree s;

  @BeforeClass
  public static void before() {
    s = new ProblemThree();
  }

  @AfterClass
  public static void after() {
    s = null;
  }

  @Test
  public void testNullInput() {
    int[] A = null;
    int actual = s.solution(A);
    int expected = 0;
    assertEquals(expected, actual);

  }

  @Test
  public void testEmptyInput() {
    int[] A = new int[0];
    int actual = s.solution(A);
    int expected = 0;
    assertEquals(expected, actual);
  }

  @Test
  public void testOneElementInput() {
    int[] A = new int[1];
    int actual = s.solution(A);
    int expected = 1;
    assertEquals(expected, actual);
  }

  @Test
  public void testInputWithOnlyZeroes() {
    int[] A = { 0, 0 };
    int actual = s.solution(A);
    int expected = 2;
    assertEquals(expected, actual);
  }

  @Test
  public void testWithNegativeSeriesLonger() {
    int[] A = { 1, 0, 0, 0, 0, 0, -1, 1, -1 };
    int actual = s.solution(A);
    assert (actual == 8);
  }

  @Test
  public void testWithPositiveSeriesLonger() {
    int[] A = { 5, 4, -1, 2, 0, -1, 1 };
    int actual = s.solution(A);
    int expected = 4;
    assertEquals(expected, actual);
  }

  @Test
  public void testWithStartingZeroes() {
    int[] A = { 0, 0, -1, 2, 0, 0, 1 };
    int actual = s.solution(A);
    int expected = 6;
    assertEquals(expected, actual);
  }

}
