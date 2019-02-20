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
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @see http://projecteuler.net/problem=4
 */
@SuppressWarnings("all")
public class Solution_004 {
  public static void main(final String[] args) {
    int result = 0;
    IntegerRange _upTo = new IntegerRange(100, 999);
    for (final Integer left : _upTo) {
      IntegerRange _upTo_1 = new IntegerRange((left).intValue(), 999);
      for (final Integer right : _upTo_1) {
        {
          int candidate = ((left).intValue() * (right).intValue());
          if ((candidate > result)) {
            List<Character> charList = (List<Character>)Conversions.doWrapArray(Integer.valueOf(candidate).toString().toCharArray());
            List<Character> _reverseView = ListExtensions.<Character>reverseView(charList);
            boolean _equals = Objects.equal(_reverseView, charList);
            if (_equals) {
              result = candidate;
            }
          }
        }
      }
    }
    InputOutput.<Integer>println(Integer.valueOf(result));
  }
}
