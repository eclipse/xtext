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
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * 
 * @see http://projecteuler.net/problem=7
 */
@SuppressWarnings("all")
public class Solution_007 {
  public static void main(final String[] args) {
    int n = 10001;
    ArrayList<Integer> seenPrimes = CollectionLiterals.<Integer>newArrayList();
    int slice = 0;
    while (true) {
      {
        List<Integer> numbers = IterableExtensions.<Integer>toList(new IntegerRange(((slice * n) + 1), ((slice + 1) * n)));
        for (final Integer prime : seenPrimes) {
          Solution_007.markAsNotPrime((prime).intValue(), numbers);
        }
        slice = (slice + 1);
        while ((!numbers.isEmpty())) {
          {
            Integer nextPrime = numbers.remove(0);
            if (((nextPrime).intValue() != 1)) {
              seenPrimes.add(nextPrime);
              int _size = seenPrimes.size();
              boolean _equals = (_size == n);
              if (_equals) {
                InputOutput.<Integer>println(nextPrime);
                return;
              }
              Solution_007.markAsNotPrime((nextPrime).intValue(), numbers);
            }
          }
        }
      }
    }
  }
  
  public static void markAsNotPrime(final int prime, final List<Integer> numbers) {
    Iterator<Integer> iter = numbers.iterator();
    while (iter.hasNext()) {
      Integer _next = iter.next();
      int _modulo = ((_next).intValue() % prime);
      boolean _equals = (_modulo == 0);
      if (_equals) {
        iter.remove();
      }
    }
  }
}
