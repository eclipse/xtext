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

import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot
 * be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * 
 * @see http://projecteuler.net/problem=23
 */
@SuppressWarnings("all")
public class Solution_023 {
  public static void main(final String[] args) {
    final Function1<Integer, Boolean> _function = (Integer it) -> {
      return Boolean.valueOf(Solution_023.isAbundant((it).intValue()));
    };
    final Set<Integer> allAbundantNumbers = IterableExtensions.<Integer>toSet(IterableExtensions.<Integer>filter(new IntegerRange(28123, 1), _function));
    final Function1<Integer, Boolean> _function_1 = (Integer it) -> {
      boolean _isSumOfAbundantNumbers = Solution_023.isSumOfAbundantNumbers((it).intValue(), allAbundantNumbers);
      return Boolean.valueOf((!_isSumOfAbundantNumbers));
    };
    final Function2<Integer, Integer, Integer> _function_2 = (Integer i1, Integer i2) -> {
      return Integer.valueOf(((i1).intValue() + (i2).intValue()));
    };
    InputOutput.<Integer>println(IterableExtensions.<Integer>reduce(IterableExtensions.<Integer>filter(new IntegerRange(28123, 1), _function_1), _function_2));
  }
  
  public static boolean isSumOfAbundantNumbers(final int input, final Set<Integer> allAmbundantNumbers) {
    for (final Integer i : allAmbundantNumbers) {
      boolean _contains = allAmbundantNumbers.contains(Integer.valueOf((input - (i).intValue())));
      if (_contains) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isAbundant(final int input) {
    final int sqrt = Double.valueOf(Math.floor(Math.sqrt(input))).intValue();
    final Function1<Integer, Boolean> _function = (Integer div) -> {
      return Boolean.valueOf((((div).intValue() != input) && ((input % (div).intValue()) == 0)));
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer i1, Integer i2) -> {
      int _xblockexpression = (int) 0;
      {
        final int other = (input / (i2).intValue());
        int _xifexpression = (int) 0;
        if (((other != (i2).intValue()) && (other != input))) {
          _xifexpression = (((i1).intValue() + (i2).intValue()) + other);
        } else {
          _xifexpression = ((i1).intValue() + (i2).intValue());
        }
        _xblockexpression = _xifexpression;
      }
      return Integer.valueOf(_xblockexpression);
    };
    final Integer sumOfDivisors = IterableExtensions.<Integer, Integer>fold(IterableExtensions.<Integer>filter(new IntegerRange(2, sqrt), _function), Integer.valueOf(1), _function_1);
    return ((sumOfDivisors).intValue() > input);
  }
}
