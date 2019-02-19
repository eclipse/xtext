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

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @see http://projecteuler.net/problem=1
 */
@SuppressWarnings("all")
public class Solution_001 {
  public static void main(final String[] args) {
    final Function1<Integer, Boolean> _function = (Integer i) -> {
      return Boolean.valueOf(((((i).intValue() % 3) == 0) || (((i).intValue() % 5) == 0)));
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer i1, Integer i2) -> {
      return Integer.valueOf(((i1).intValue() + (i2).intValue()));
    };
    InputOutput.<Integer>println(IterableExtensions.<Integer>reduce(IterableExtensions.<Integer>filter(new IntegerRange(1, 999), _function), _function_1));
  }
}
