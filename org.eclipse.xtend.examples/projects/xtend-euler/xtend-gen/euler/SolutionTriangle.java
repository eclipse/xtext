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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class SolutionTriangle {
  private int result;
  
  public SolutionTriangle(final String triangle) {
    final Function1<String, ArrayList<Integer>> _function = (String it) -> {
      final Function1<String, Integer> _function_1 = (String it_1) -> {
        return Integer.valueOf(Integer.parseInt(it_1));
      };
      List<Integer> _map = ListExtensions.<String, Integer>map(((List<String>)Conversions.doWrapArray(it.split(" "))), _function_1);
      return new ArrayList<Integer>(_map);
    };
    List<ArrayList<Integer>> _map = ListExtensions.<String, ArrayList<Integer>>map(((List<String>)Conversions.doWrapArray(triangle.split("\\r?\\n"))), _function);
    final ArrayList<ArrayList<Integer>> it = new ArrayList<ArrayList<Integer>>(_map);
    int _size = it.size();
    int _minus = (_size - 1);
    final Consumer<Integer> _function_1 = (Integer lineIndex) -> {
      final ArrayList<Integer> line = it.get((lineIndex).intValue());
      int _size_1 = line.size();
      int _minus_1 = (_size_1 - 2);
      final Consumer<Integer> _function_2 = (Integer i) -> {
        this.addValue(it.get(((lineIndex).intValue() - 1)), (i).intValue(), Math.max((line.get((i).intValue())).intValue(), (line.get(((i).intValue() + 1))).intValue()));
      };
      new IntegerRange(0, _minus_1).forEach(_function_2);
    };
    new IntegerRange(_minus, 1).forEach(_function_1);
    this.result = (it.get(0).get(0)).intValue();
  }
  
  public Integer addValue(final List<Integer> list, final int idx, final int value) {
    Integer _get = list.get(idx);
    int _plus = ((_get).intValue() + value);
    return list.set(idx, Integer.valueOf(_plus));
  }
  
  @Override
  public String toString() {
    return Integer.valueOf(this.result).toString();
  }
}
