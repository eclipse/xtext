/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.smoke;

import java.util.List;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Case_3 {
  public void testReturnExpression_06() {
    final Function1<Integer, Integer> _function = (Integer i) -> {
      return i;
    };
    final Function1<? super Integer, ? extends Integer> closure = _function;
    IntegerRange _upTo = new IntegerRange(1, 100);
    for (final Integer x : _upTo) {
      closure.apply(x);
    }
  }

  public void testReturnExpression_07(final Class<?> c) {
    boolean _notEquals = (!Objects.equals(Case_3.class, c));
    if (_notEquals) {
      final Function1<Integer, Integer> _function = (Integer i) -> {
        return (i).intValue();
      };
      final Function1<? super Integer, ? extends Integer> closure = _function;
      IntegerRange _upTo = new IntegerRange(1, 100);
      for (final Integer x : _upTo) {
        closure.apply(x);
      }
    }
  }

  public int testOverriddenLocalVariable() {
    int _xblockexpression = (int) 0;
    {
      final int x = 3;
      int y = 2;
      int _xblockexpression_1 = (int) 0;
      {
        Integer.valueOf(x).toString();
        int x2 = y;
        final int y2 = 1;
        _xblockexpression_1 = (x2 + y2);
      }
      _xblockexpression = _xblockexpression_1;
    }
    return _xblockexpression;
  }

  public List<Character> testFeatureCall_03() {
    List<Character> _xblockexpression = null;
    {
      char[] _charArray = "abc".toCharArray();
      List<Character> x = IterableExtensions.<Character>toList(((Iterable<Character>) Conversions.doWrapArray(_charArray)));
      _xblockexpression = x;
    }
    return _xblockexpression;
  }
}
