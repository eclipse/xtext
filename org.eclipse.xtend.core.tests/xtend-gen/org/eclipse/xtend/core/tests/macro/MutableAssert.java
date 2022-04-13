/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

@SuppressWarnings("all")
public class MutableAssert extends Assert {
  public static void assertValidQualifiedName(final String name, final String expectedQualifiedName, final Procedure1<? super String> codeToTest) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(" has to be a valid qualified name");
    final String message = _builder.toString();
    final Procedure0 _function = () -> {
      codeToTest.apply(null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function);
    final Procedure0 _function_1 = () -> {
      codeToTest.apply("  ");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function_1);
    final Procedure0 _function_2 = () -> {
      codeToTest.apply("456");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function_2);
    final Procedure0 _function_3 = () -> {
      codeToTest.apply("foo. Bar ");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function_3);
    final Procedure0 _function_4 = () -> {
      codeToTest.apply("foo.456.Bar");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function_4);
    codeToTest.apply(expectedQualifiedName);
  }

  public static void assertValidJavaIdentifier(final String name, final Procedure1<? super String> codeToTest) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name);
    _builder.append(" has to be a valid java identifier");
    final String message = _builder.toString();
    final Procedure0 _function = () -> {
      codeToTest.apply(null);
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function);
    final Procedure0 _function_1 = () -> {
      codeToTest.apply("  ");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function_1);
    final Procedure0 _function_2 = () -> {
      codeToTest.apply("456");
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, message, _function_2);
    codeToTest.apply("foo");
  }

  public static <T extends Throwable> T assertThrowable(final Class<T> clazz, final String message, final Procedure0 codeToTest) {
    T _xblockexpression = null;
    {
      final T t = MutableAssert.<T>assertThrowable(clazz, codeToTest);
      Assert.assertEquals(message, t.getMessage());
      _xblockexpression = t;
    }
    return _xblockexpression;
  }

  public static <T extends Throwable> T assertThrowable(final Class<T> clazz, final Procedure0 codeToTest) {
    Object _xblockexpression = null;
    {
      try {
        codeToTest.apply();
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable e = (Throwable)_t;
          Assert.assertEquals(e.getMessage(), clazz, e.getClass());
          return ((T) e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("an instance of the ");
      String _name = clazz.getName();
      _builder.append(_name);
      _builder.append(" class had to be thrown");
      Assert.fail(_builder.toString());
      _xblockexpression = null;
    }
    return ((T)_xblockexpression);
  }
}
