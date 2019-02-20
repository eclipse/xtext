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

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
 * 
 * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 * 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 * 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 * 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 * 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 * 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 * 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
 * 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
 * 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
 * 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
 * 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 * 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 * 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 * 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 * 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 * 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 * 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 * 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
 * 
 * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
 * 
 * What is the greatest product of four adjacent numbers in any direction (up, down, left, right, or diagonally) in the 20×20 grid?
 * 
 * @see http://projecteuler.net/problem=11
 */
@SuppressWarnings("all")
public class Solution_011 {
  public static void main(final String[] args) {
    new Solution_011().solve();
  }
  
  public void solve() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08");
    _builder.newLine();
    _builder.append("49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00");
    _builder.newLine();
    _builder.append("81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65");
    _builder.newLine();
    _builder.append("52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91");
    _builder.newLine();
    _builder.append("22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80");
    _builder.newLine();
    _builder.append("24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50");
    _builder.newLine();
    _builder.append("32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70");
    _builder.newLine();
    _builder.append("67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21");
    _builder.newLine();
    _builder.append("24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72");
    _builder.newLine();
    _builder.append("21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95");
    _builder.newLine();
    _builder.append("78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92");
    _builder.newLine();
    _builder.append("16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57");
    _builder.newLine();
    _builder.append("86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58");
    _builder.newLine();
    _builder.append("19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40");
    _builder.newLine();
    _builder.append("04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66");
    _builder.newLine();
    _builder.append("88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69");
    _builder.newLine();
    _builder.append("04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36");
    _builder.newLine();
    _builder.append("20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16");
    _builder.newLine();
    _builder.append("20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54");
    _builder.newLine();
    _builder.append("01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48");
    _builder.newLine();
    final String gridAsString = _builder.toString();
    int rows = 20;
    int columns = 20;
    final Function1<String, List<Integer>> _function = (String it) -> {
      final Function1<String, Integer> _function_1 = (String s) -> {
        return Integer.valueOf(s);
      };
      return IterableExtensions.<Integer>toList(ListExtensions.<String, Integer>map(((List<String>)Conversions.doWrapArray(it.split(" "))), _function_1));
    };
    final List<List<Integer>> it = IterableExtensions.<List<Integer>>toList(ListExtensions.<String, List<Integer>>map(((List<String>)Conversions.doWrapArray(gridAsString.split("\\r?\\n"))), _function));
    int result = 0;
    IntegerRange _upTo = new IntegerRange(0, (columns - 4));
    for (final Integer c : _upTo) {
      {
        IntegerRange _upTo_1 = new IntegerRange(0, (rows - 1));
        for (final Integer r : _upTo_1) {
          result = this.max(result, (this.$(it, (c).intValue(), (r).intValue())).intValue(), (this.$(it, ((c).intValue() + 1), (r).intValue())).intValue(), (this.$(it, ((c).intValue() + 2), (r).intValue())).intValue(), (this.$(it, ((c).intValue() + 3), (r).intValue())).intValue());
        }
        IntegerRange _upTo_2 = new IntegerRange(0, (rows - 4));
        for (final Integer r_1 : _upTo_2) {
          result = this.max(result, (this.$(it, (c).intValue(), (r_1).intValue())).intValue(), (this.$(it, ((c).intValue() + 1), ((r_1).intValue() + 1))).intValue(), (this.$(it, ((c).intValue() + 2), ((r_1).intValue() + 1))).intValue(), (this.$(it, ((c).intValue() + 3), ((r_1).intValue() + 3))).intValue());
        }
        IntegerRange _upTo_3 = new IntegerRange(4, (rows - 1));
        for (final Integer r_2 : _upTo_3) {
          result = this.max(result, (this.$(it, (c).intValue(), (r_2).intValue())).intValue(), (this.$(it, ((c).intValue() + 1), ((r_2).intValue() - 1))).intValue(), (this.$(it, ((c).intValue() + 2), ((r_2).intValue() - 1))).intValue(), (this.$(it, ((c).intValue() + 3), ((r_2).intValue() - 3))).intValue());
        }
      }
    }
    IntegerRange _upTo_1 = new IntegerRange(0, (columns - 1));
    for (final Integer c_1 : _upTo_1) {
      IntegerRange _upTo_2 = new IntegerRange(0, (rows - 4));
      for (final Integer r : _upTo_2) {
        result = this.max(result, (this.$(it, (c_1).intValue(), (r).intValue())).intValue(), (this.$(it, (c_1).intValue(), ((r).intValue() + 1))).intValue(), (this.$(it, (c_1).intValue(), ((r).intValue() + 2))).intValue(), (this.$(it, (c_1).intValue(), ((r).intValue() + 3))).intValue());
      }
    }
    IntegerRange _upTo_3 = new IntegerRange(4, (columns - 1));
    for (final Integer c_2 : _upTo_3) {
      IntegerRange _upTo_4 = new IntegerRange(0, (rows - 4));
      for (final Integer r_1 : _upTo_4) {
        result = this.max(result, (this.$(it, (c_2).intValue(), (r_1).intValue())).intValue(), (this.$(it, ((c_2).intValue() - 1), ((r_1).intValue() + 1))).intValue(), (this.$(it, ((c_2).intValue() - 2), ((r_1).intValue() + 2))).intValue(), (this.$(it, ((c_2).intValue() - 3), ((r_1).intValue() + 3))).intValue());
      }
    }
    InputOutput.<Integer>println(Integer.valueOf(result));
  }
  
  public Integer $(final List<List<Integer>> lists, final int column, final int row) {
    return lists.get(column).get(row);
  }
  
  public int max(final int current, final int a, final int b, final int c, final int d) {
    return Math.max(current, (((a * b) * c) * d));
  }
}
