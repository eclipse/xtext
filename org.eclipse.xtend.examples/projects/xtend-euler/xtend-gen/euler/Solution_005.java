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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @see http://projecteuler.net/problem=5
 */
@SuppressWarnings("all")
public class Solution_005 {
  public static void main(final String[] args) {
    ArrayList<Integer> result = CollectionLiterals.<Integer>newArrayList();
    IntegerRange _upTo = new IntegerRange(2, 20);
    for (final Integer i : _upTo) {
      {
        Integer j = i;
        for (final Integer k : result) {
          if ((((j).intValue() % (k).intValue()) == 0)) {
            j = Integer.valueOf(((j).intValue() / (k).intValue()));
          }
        }
        if (((j).intValue() != 1)) {
          result.add(j);
        }
      }
    }
    final Function2<Integer, Integer, Integer> _function = (Integer m1, Integer m2) -> {
      return Integer.valueOf(((m1).intValue() * (m2).intValue()));
    };
    InputOutput.<Integer>println(IterableExtensions.<Integer>reduce(result, _function));
  }
}
