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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @see http://projecteuler.net/problem=10
 */
@SuppressWarnings("all")
public class Solution_010 {
  public static void main(final String[] args) {
    ArrayList<Long> primes = CollectionLiterals.<Long>newArrayList();
    IntegerRange _upTo = new IntegerRange(2, 1_999_999);
    for (final Integer i : _upTo) {
      {
        Iterator<Long> primeIter = primes.iterator();
        boolean isPrime = true;
        long knownPrime = 0L;
        while (((isPrime && ((knownPrime * knownPrime) < (i).intValue())) && primeIter.hasNext())) {
          {
            knownPrime = (primeIter.next()).longValue();
            if ((((i).intValue() % knownPrime) == 0)) {
              isPrime = false;
            }
          }
        }
        if (isPrime) {
          primes.add(Long.valueOf(((long) (i).intValue())));
        }
      }
    }
    final Function2<Long, Long, Long> _function = (Long i1, Long i2) -> {
      return Long.valueOf(((i1).longValue() + (i2).longValue()));
    };
    InputOutput.<Long>println(IterableExtensions.<Long>reduce(primes, _function));
  }
}
