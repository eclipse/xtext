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

import com.google.common.collect.AbstractIterator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @see http://projecteuler.net/problem=3
 */
@SuppressWarnings("all")
public class Solution_003 extends AbstractIterator<Long> {
  public static void main(final String[] args) {
    InputOutput.<Long>println(IteratorExtensions.<Long>last(new Solution_003()));
  }
  
  private long compound = 600851475143L;
  
  private long sqrt = Double.valueOf(Math.sqrt(this.compound)).longValue();
  
  private long current = 2;
  
  @Override
  protected Long computeNext() {
    Long _xblockexpression = null;
    {
      while ((this.current < this.sqrt)) {
        {
          if ((((this.compound % this.current) == 0) && this.isPrime(this.current))) {
            long result = this.current;
            this.current = (this.current + 1);
            return Long.valueOf(result);
          }
          this.current = (this.current + 1);
        }
      }
      _xblockexpression = this.endOfData();
    }
    return _xblockexpression;
  }
  
  public boolean isPrime(final long l) {
    int _intValue = Double.valueOf(Math.sqrt(l)).intValue();
    final Function1<Integer, Boolean> _function = (Integer i) -> {
      return Boolean.valueOf(((l % (i).intValue()) == 0));
    };
    return IterableExtensions.isEmpty(IterableExtensions.<Integer>filter(new IntegerRange(2, _intValue), _function));
  }
}
