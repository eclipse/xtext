/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package example2;

import com.google.common.base.Objects;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class BasicExpressions {
  @Test
  public void literals() {
    Assert.assertEquals("Hello", "Hello");
    Assert.assertEquals(42, ((20 + 20) + (1 * 2)));
    BigDecimal _plus = new BigDecimal("0.00").add(BigDecimal.valueOf(42L));
    Assert.assertEquals(new BigDecimal("42.00"), _plus);
    Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf((!false)));
    Class<? extends BasicExpressions> _class = this.getClass();
    Assert.assertEquals(_class, BasicExpressions.class);
  }
  
  @Test
  public void collections() {
    final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Hello", "World"));
    final Function1<String, String> _function = new Function1<String, String>() {
      public String apply(final String it) {
        return it.toUpperCase();
      }
    };
    List<String> _map = ListExtensions.<String, String>map(list, _function);
    String _head = IterableExtensions.<String>head(_map);
    Assert.assertEquals("HELLO", _head);
    final HashSet<Integer> set = CollectionLiterals.<Integer>newHashSet(Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(5));
    final Function1<Integer, Boolean> _function_1 = new Function1<Integer, Boolean>() {
      public Boolean apply(final Integer it) {
        return Boolean.valueOf(((it).intValue() >= 3));
      }
    };
    Iterable<Integer> _filter = IterableExtensions.<Integer>filter(set, _function_1);
    int _size = IterableExtensions.size(_filter);
    Assert.assertEquals(2, _size);
    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("one", Integer.valueOf(1));
    Pair<String, Integer> _mappedTo_1 = Pair.<String, Integer>of("two", Integer.valueOf(2));
    Pair<String, Integer> _mappedTo_2 = Pair.<String, Integer>of("three", Integer.valueOf(3));
    final HashMap<String, Integer> map = CollectionLiterals.<String, Integer>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
    Integer _get = map.get("two");
    Assert.assertEquals(2, (_get).intValue());
  }
  
  @Test
  public void controlStructures() {
    int _length = "text".length();
    boolean _equals = (_length == 4);
    if (_equals) {
      int _xifexpression = (int) 0;
      boolean _notEquals = (!Objects.equal("foo", "bar"));
      if (_notEquals) {
        _xifexpression = 42;
      } else {
        _xifexpression = (-24);
      }
      Assert.assertEquals(42, _xifexpression);
    } else {
      Assert.fail("Never happens!");
    }
    final String t = "text";
    boolean _matched = false;
    if (!_matched) {
      int _length_1 = t.length();
      boolean _greaterThan = (_length_1 > 8);
      if (_greaterThan) {
        _matched=true;
        Assert.fail("Never happens!");
      }
    }
    if (!_matched) {
      if (Objects.equal(t, "text")) {
        _matched=true;
        Assert.assertTrue(true);
      }
    }
    if (!_matched) {
      Assert.fail("never happens!");
    }
    final Object someValue = "a string typed to Object";
    String _switchResult_1 = null;
    boolean _matched_1 = false;
    if (!_matched_1) {
      if (someValue instanceof Number) {
        _matched_1=true;
        _switchResult_1 = "number";
      }
    }
    if (!_matched_1) {
      if (someValue instanceof String) {
        _matched_1=true;
        _switchResult_1 = "string";
      }
    }
    Assert.assertEquals("string", _switchResult_1);
  }
  
  @Test
  public void loops() {
    int counter = 1;
    IntegerRange _upTo = new IntegerRange(1, 10);
    for (final Integer i : _upTo) {
      {
        Assert.assertEquals(counter, (i).intValue());
        counter = (counter + 1);
      }
    }
    final Iterator<Integer> iterator = Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5))).iterator();
    counter = 1;
    while (iterator.hasNext()) {
      {
        final Integer i_1 = iterator.next();
        Assert.assertEquals(counter, (i_1).intValue());
        counter = (counter + 1);
      }
    }
  }
}
