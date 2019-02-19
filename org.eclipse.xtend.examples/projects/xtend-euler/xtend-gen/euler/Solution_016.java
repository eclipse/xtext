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
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @see http://projecteuler.net/problem=16
 */
@SuppressWarnings("all")
public class Solution_016 {
  public static void main(final String[] args) {
    final Function1<Character, Integer> _function = (Character it) -> {
      return Integer.valueOf(Character.getNumericValue(it.charValue()));
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer i1, Integer i2) -> {
      return Integer.valueOf(((i1).intValue() + (i2).intValue()));
    };
    InputOutput.<Integer>println(
      IterableExtensions.<Integer>reduce(ListExtensions.<Character, Integer>map(((List<Character>)Conversions.doWrapArray(BigInteger.valueOf(2L).pow(1000).toString().toCharArray())), _function), _function_1));
  }
}
