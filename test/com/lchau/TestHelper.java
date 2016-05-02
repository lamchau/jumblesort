package com.lchau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum TestHelper {
  ;

  public static <T> String[] shuffle(T[] array) {
    Collections.shuffle(Arrays.asList(array));
    return map(array);
  }

  public static <T> String[] map(T[] array) {
    List<String> values = new ArrayList<>();
    for (T value : array) {
      values.add(String.valueOf(value));
    }
    return values.toArray(new String[0]);
  }
}
