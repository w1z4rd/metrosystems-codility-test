package org.costa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProblemOneTest {
  private static ProblemOne s;

  @BeforeClass
  public static void before() {
    s = new ProblemOne();
  }

  @AfterClass
  public static void after() {
    s = null;
  }

  @Test
  public void testWithNullInput() {
    String actual = s.solution(null);
    assertNull(actual);
  }

  @Test
  public void testWithEmptyInput() {
    String actual = s.solution("");
    String expected = "";
    assertEquals(expected, actual);
  }

  @Test
  public void testWithOnlySpaces() {
    String actual = s.solution("      ");
    String expected = "";
    assertEquals(expected, actual);
  }

  @Test
  public void testWithNoSpaces() {
    String actual = s.solution("nospaces");
    String expected = "secapson";
    assertEquals(expected, actual);
  }
  
  @Test
  public void testWithSpacesAndWords() {
    String actual = s.solution("all your base are belong to us");
    String expected = "lla ruoy esab era gnoleb ot su";
    assertEquals(expected, actual);
  }
}
