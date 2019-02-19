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

import java.math.BigInteger;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @see http://projecteuler.net/problem=20
 */
@SuppressWarnings("all")
public class Solution_020 {
  public static void main(final String[] args) {
    final Function2<BigInteger, Integer, BigInteger> _function = (BigInteger value, Integer i) -> {
      BigInteger _valueOf = BigInteger.valueOf(i);
      return value.multiply(_valueOf);
    };
    final Function2<Integer, Character, Integer> _function_1 = (Integer i, Character c) -> {
      int _numericValue = Character.getNumericValue((c).charValue());
      return Integer.valueOf((_numericValue + (i).intValue()));
    };
    InputOutput.<Integer>println(IterableExtensions.<Character, Integer>fold(((Iterable<Character>)Conversions.doWrapArray(IterableExtensions.<Integer, BigInteger>fold(new IntegerRange(1, 100), BigInteger.ONE, _function).toString().toCharArray())), Integer.valueOf(0), _function_1));
  }
}
