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

import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 				1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * 				(1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @see http://projecteuler.net/problem=6
 */
@SuppressWarnings("all")
public class Solution_006 {
  public static void main(final String[] args) {
    final Function2<Integer, Integer, Integer> _function = (Integer i1, Integer i2) -> {
      return Integer.valueOf(((i1).intValue() + (i2).intValue()));
    };
    Integer result = IterableExtensions.<Integer>reduce(new IntegerRange(1, 100), _function);
    result = Integer.valueOf(((result).intValue() * (result).intValue()));
    final Function2<Integer, Integer, Integer> _function_1 = (Integer r, Integer i) -> {
      return Integer.valueOf(((r).intValue() - ((i).intValue() * (i).intValue())));
    };
    result = IterableExtensions.<Integer, Integer>fold(new IntegerRange(1, 100), result, _function_1);
    InputOutput.<Integer>println(result);
  }
}
