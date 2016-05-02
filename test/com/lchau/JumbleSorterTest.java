package com.lchau;

import org.junit.Test;

import static com.lchau.TestHelper.map;
import static com.lchau.TestHelper.shuffle;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class JumbleSorterTest {
  @Test
  public void testSortEmpty() throws Exception {
    String[] args = shuffle(new Object[] {});
    String[] actual = JumbleSorter.sort(args);
    String[] expected = map(new Object[] {});

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSortNull() throws Exception {
    String[] actual = JumbleSorter.sort(null);
    String[] expected = map(new Object[0]);

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSortComposite() throws Exception {
    String[] args = map(new Object[] {10, "foo", 5, "fizz", 2, "buzz", 0, 1});
    String[] actual = JumbleSorter.sort(args);
    String[] expected = map(new Object[] {0, "buzz", 1, "fizz", 2, "foo", 5, 10});

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSortNumeric() throws Exception {
    String[] args = shuffle(new Object[] {1, 0, -1, 999, 9999, 99999, -99999, -9999, -999});
    String[] actual = JumbleSorter.sort(args);
    String[] expected = map(new Object[] {-99999, -9999, -999, -1, 0, 1, 999, 9999, 99999});

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSortString() throws Exception {
    String[] args = shuffle(new Object[] {"foo", "bar", "fizz", "buzz"});
    String[] actual = JumbleSorter.sort(args);
    String[] expected = map(new Object[] {"bar", "buzz", "fizz", "foo"});

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testExample_01() throws Exception {
    String[] args = map(new Integer[] {1});
    String[] actual = JumbleSorter.sort(args);
    String[] expected = new String[] {"1"};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testExample_02() throws Exception {
    String[] args = new String[] {"car", "bus", "truck"};
    String[] actual = JumbleSorter.sort(args);
    String[] expected = new String[] {"bus", "car", "truck"};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testExample_03() throws Exception {
    String[] args = map(new Object[] {8, 4, 6, 1, -2, 9, 5});
    String[] actual = JumbleSorter.sort(args);
    String[] expected = map(new Object[] {-2, 1, 4, 5, 6, 8, 9});

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testExample_04() throws Exception {
    String[] args = new String[] {"car", "truck", "8", "4", "bus", "6", "1"};
    String[] actual = JumbleSorter.sort(args);
    String[] expected = new String[] {"bus", "car", "1", "4", "truck", "6", "8"};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void testIsIntegerPositive() throws Exception {
    assertTrue(JumbleSorter.isInteger("1"));
    assertTrue(JumbleSorter.isInteger("999999"));
  }

  @Test
  public void testIsIntegerZero() throws Exception {
    assertTrue(JumbleSorter.isInteger("0"));
  }

  @Test
  public void testIsIntegerNegative() throws Exception {
    assertTrue(JumbleSorter.isInteger("-1"));
    assertTrue(JumbleSorter.isInteger("-999999"));
  }

  @Test(expected = NumberFormatException.class)
  public void testIsIntegerMin() throws Exception {
    assertTrue(JumbleSorter.isInteger("-1000000"));
  }

  @Test(expected = NumberFormatException.class)
  public void testIsIntegerMax() throws Exception {
    assertTrue(JumbleSorter.isInteger("1000000"));
  }
}