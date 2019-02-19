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

import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @see http://projecteuler.net/problem=9
 */
@SuppressWarnings("all")
public class Solution_009 {
  public static void main(final String[] args) {
    final Consumer<Integer> _function = (Integer a) -> {
      final Consumer<Integer> _function_1 = (Integer b) -> {
        int c = ((1000 - (a).intValue()) - (b).intValue());
        if ((c >= 0)) {
          if (((((a).intValue() * (a).intValue()) + ((b).intValue() * (b).intValue())) == (c * c))) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("a = ");
            _builder.append(a);
            _builder.newLineIfNotEmpty();
            _builder.append("b = ");
            _builder.append(b);
            _builder.newLineIfNotEmpty();
            _builder.append("c = ");
            _builder.append(c);
            _builder.newLineIfNotEmpty();
            _builder.append("product = ");
            _builder.append((((a).intValue() * (b).intValue()) * c));
            _builder.newLineIfNotEmpty();
            InputOutput.<String>println(_builder.toString());
          }
        }
      };
      new IntegerRange(((a).intValue() + 1), (1000 - (a).intValue())).forEach(_function_1);
    };
    new IntegerRange(1, 1000).forEach(_function);
  }
}
