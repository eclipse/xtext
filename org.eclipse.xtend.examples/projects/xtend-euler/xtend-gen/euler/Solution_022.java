/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler
 */
package euler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @see http://projecteuler.net/problem=22
 */
@SuppressWarnings("all")
public class Solution_022 {
  public static void main(final String[] args) {
    try {
      InputStream _resourceAsStream = Solution_022.class.getResourceAsStream("names.txt");
      InputStreamReader _inputStreamReader = new InputStreamReader(_resourceAsStream);
      final BufferedReader reader = new BufferedReader(_inputStreamReader);
      try {
        final String line = reader.readLine();
        final Matcher matcher = Pattern.compile("\"(\\w+)\"").matcher(line);
        final ArrayList<String> names = CollectionLiterals.<String>newArrayList();
        while (matcher.find()) {
          names.add(matcher.group(1));
        }
        final AtomicLong result = new AtomicLong();
        final Procedure2<String, Integer> _function = (String name, Integer i) -> {
          final Function1<Character, Integer> _function_1 = (Character it) -> {
            int _numericValue = Character.getNumericValue((it).charValue());
            return Integer.valueOf((_numericValue - 9));
          };
          final Function2<Integer, Integer, Integer> _function_2 = (Integer i1, Integer i2) -> {
            return Integer.valueOf(((i1).intValue() + (i2).intValue()));
          };
          Integer _reduce = IterableExtensions.<Integer>reduce(ListExtensions.<Character, Integer>map(((List<Character>)Conversions.doWrapArray(name.toCharArray())), _function_1), _function_2);
          int _multiply = ((_reduce).intValue() * ((i).intValue() + 1));
          result.addAndGet(_multiply);
        };
        IterableExtensions.<String>forEach(IterableExtensions.<String>sort(names), _function);
        InputOutput.<AtomicLong>println(result);
      } finally {
        reader.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
