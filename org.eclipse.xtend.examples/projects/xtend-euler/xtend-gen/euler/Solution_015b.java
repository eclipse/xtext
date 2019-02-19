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
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * How many routes are there through a 20×20 grid?
 * 
 * @see http://projecteuler.net/problem=15
 */
@SuppressWarnings("all")
public class Solution_015b {
  public static void main(final String[] args) {
    final int gridSize = 20;
    final ArrayList<Long> it = CollectionLiterals.<Long>newArrayList();
    final Consumer<Integer> _function = (Integer col) -> {
      it.add(Long.valueOf(1L));
    };
    new IntegerRange(1, (gridSize + 1)).forEach(_function);
    final Consumer<Integer> _function_1 = (Integer row) -> {
      final Consumer<Integer> _function_2 = (Integer col) -> {
        Long _get = it.get(((col).intValue() - 1));
        Long _get_1 = it.get((col).intValue());
        long _plus = ((_get).longValue() + (_get_1).longValue());
        it.set((col).intValue(), Long.valueOf(_plus));
      };
      new IntegerRange(1, gridSize).forEach(_function_2);
    };
    new IntegerRange(1, gridSize).forEach(_function_1);
    InputOutput.<Long>println(IterableExtensions.<Long>last(it));
  }
}
