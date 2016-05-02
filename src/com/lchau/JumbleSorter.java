package com.lchau;

import java.util.*;

public enum JumbleSorter {
  ;

  private static final String INTEGER_REGEX = "^-?\\d+$";
  private static final int MAX_INTEGER = 999999;

  /**
   * Sorts the specified list into ascending order while retaining positioned.
   *
   * @param args string values
   * @return the sorted array
   */
  public static String[] sort(String[] args) {
    if (args == null) {
      return new String[0];
    }

    boolean[] positions = new boolean[args.length];
    // PriorityQueue for brevity
    // alternatively we could have used: ArrayList > sort > listIterator
    Queue<Integer> integers = new PriorityQueue<>();
    Queue<String> strings = new PriorityQueue<>(String.CASE_INSENSITIVE_ORDER);

    // partition
    for (int i = 0; i < positions.length; i++) {
      String str = args[i];
      boolean isInteger = isInteger(str);
      positions[i] = isInteger;

      if (isInteger) {
        int value = Integer.valueOf(str);
        integers.add(value);
      } else {
        strings.add(str);
      }
    }

    // restore positions
    List<String> results = new ArrayList<>();
    for (boolean b : positions) {
      String value = b ? String.valueOf(integers.poll()) : strings.poll();
      results.add(value);
    }
    return results.toArray(new String[0]);
  }

  protected static boolean isInteger(String str) {
    if (str instanceof String && str.matches(INTEGER_REGEX)) {
      int value = Integer.valueOf(str);
      if (Math.abs(value) > MAX_INTEGER) {
        throw new NumberFormatException("Maximum integer value [-999999, 999999]");
      }
      return true;
    }
    return false;
  }
}