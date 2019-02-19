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

import com.google.common.base.Objects;
import java.util.HashSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @see http://projecteuler.net/problem=21
 */
@SuppressWarnings("all")
public class Solution_021 {
  public static void main(final String[] args) {
    HashSet<Integer> result = CollectionLiterals.<Integer>newHashSet();
    final int max = 10000;
    IntegerRange _upTo = new IntegerRange(1, max);
    for (final Integer i : _upTo) {
      boolean _contains = result.contains(i);
      boolean _not = (!_contains);
      if (_not) {
        final Integer sumOfDivisors = Solution_021.sumOfDivisors((i).intValue());
        if (((!Objects.equal(sumOfDivisors, i)) && ((sumOfDivisors).intValue() <= max))) {
          final Integer otherSumOfDivisors = Solution_021.sumOfDivisors((sumOfDivisors).intValue());
          boolean _equals = Objects.equal(otherSumOfDivisors, i);
          if (_equals) {
            result.add(i);
            result.add(sumOfDivisors);
          }
        }
      }
    }
    final Function2<Integer, Integer, Integer> _function = (Integer i1, Integer i2) -> {
      return Integer.valueOf(((i1).intValue() + (i2).intValue()));
    };
    InputOutput.<Integer>println(IterableExtensions.<Integer>reduce(result, _function));
  }
  
  public static Integer sumOfDivisors(final int input) {
    Integer _xblockexpression = null;
    {
      final int sqrt = Double.valueOf(Math.floor(Math.sqrt(input))).intValue();
      final Function1<Integer, Boolean> _function = (Integer div) -> {
        return Boolean.valueOf(((input % (div).intValue()) == 0));
      };
      final Function2<Integer, Integer, Integer> _function_1 = (Integer i1, Integer i2) -> {
        int _xblockexpression_1 = (int) 0;
        {
          final int other = (input / (i2).intValue());
          int _xifexpression = (int) 0;
          if ((other != (i2).intValue())) {
            _xifexpression = (((i1).intValue() + (i2).intValue()) + other);
          } else {
            _xifexpression = ((i1).intValue() + (i2).intValue());
          }
          _xblockexpression_1 = _xifexpression;
        }
        return Integer.valueOf(_xblockexpression_1);
      };
      _xblockexpression = IterableExtensions.<Integer, Integer>fold(IterableExtensions.<Integer>filter(new IntegerRange(2, sqrt), _function), Integer.valueOf(1), _function_1);
    }
    return _xblockexpression;
  }
}
