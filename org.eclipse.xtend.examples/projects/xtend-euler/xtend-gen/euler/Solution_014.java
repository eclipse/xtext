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
import com.google.common.collect.AbstractIterator;
import java.util.BitSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @see http://projecteuler.net/problem=14
 */
@SuppressWarnings("all")
public class Solution_014 extends AbstractIterator<Long> {
  public static void main(final String[] args) {
    final BitSet numbersSeen = new BitSet(1_000_000);
    final Function1<Integer, Pair<Integer, Integer>> _function = (Integer it) -> {
      int _size = IteratorExtensions.size(new Solution_014((it).intValue(), numbersSeen));
      return Pair.<Integer, Integer>of(it, Integer.valueOf(_size));
    };
    final Function2<Pair<Integer, Integer>, Pair<Integer, Integer>, Pair<Integer, Integer>> _function_1 = (Pair<Integer, Integer> r1, Pair<Integer, Integer> r2) -> {
      Pair<Integer, Integer> _xifexpression = null;
      Integer _value = r1.getValue();
      Integer _value_1 = r2.getValue();
      boolean _greaterThan = (_value.compareTo(_value_1) > 0);
      if (_greaterThan) {
        _xifexpression = r1;
      } else {
        _xifexpression = r2;
      }
      return _xifexpression;
    };
    InputOutput.<Integer>println(
      IterableExtensions.<Pair<Integer, Integer>>reduce(IterableExtensions.<Integer, Pair<Integer, Integer>>map(new IntegerRange(1_000_000, 1), _function), _function_1).getKey());
  }
  
  private Long current;
  
  private BitSet numbersSeen;
  
  public Solution_014(final long start, final BitSet numbersSeen) {
    this.current = Long.valueOf(start);
    boolean _get = numbersSeen.get(this.current.intValue());
    if (_get) {
      this.current = Long.valueOf(1L);
    }
    this.numbersSeen = numbersSeen;
  }
  
  @Override
  protected Long computeNext() {
    final Long result = this.current;
    long _switchResult = (long) 0;
    final Long current = this.current;
    boolean _matched = false;
    if (Objects.equal(current, 0L)) {
      _matched=true;
      return this.endOfData();
    }
    if (!_matched) {
      if (Objects.equal(current, 1L)) {
        _matched=true;
        _switchResult = 0L;
      }
    }
    if (!_matched) {
      if ((((this.current).longValue() % 2) == 0)) {
        _matched=true;
        _switchResult = ((this.current).longValue() / 2);
      }
    }
    if (!_matched) {
      _switchResult = ((3 * (this.current).longValue()) + 1);
    }
    this.current = Long.valueOf(_switchResult);
    if (((result).longValue() < 1_000_000)) {
      this.numbersSeen.set(result.intValue());
    }
    return result;
  }
}
