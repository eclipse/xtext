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
import java.math.BigInteger;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 *   Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
 * 
 * Hence the first 12 terms will be:
 * 
 *    F1 = 1
 *    F2 = 1
 *    F3 = 2
 *    F4 = 3
 *    F5 = 5
 *    F6 = 8
 *    F7 = 13
 *    F8 = 21
 *    F9 = 34
 *    F10 = 55
 *    F11 = 89
 *    F12 = 144
 * 
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @see http://projecteuler.net/problem=25
 */
@SuppressWarnings("all")
public class Solution_025 extends AbstractIterator<Integer> {
  public static void main(final String[] args) {
    InputOutput.<Integer>println(IteratorExtensions.<Integer>last(new Solution_025()));
  }
  
  private BigInteger max = BigInteger.TEN.pow(999);
  
  private BigInteger f1 = BigInteger.ONE;
  
  private BigInteger f2 = BigInteger.ONE;
  
  private int idx = 2;
  
  @Override
  public Integer computeNext() {
    boolean _greaterEqualsThan = (this.f2.compareTo(this.max) >= 0);
    if (_greaterEqualsThan) {
      return this.endOfData();
    }
    final BigInteger next = this.f1.add(this.f2);
    this.f1 = this.f2;
    this.f2 = next;
    this.idx = (this.idx + 1);
    return Integer.valueOf(this.idx);
  }
}
