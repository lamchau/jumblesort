package com.lchau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    List<String> values = new ArrayList<>(Arrays.asList(JumbleSorter.sort(args)));
    // render
    System.out.println(String.join(" ", values));
  }
}