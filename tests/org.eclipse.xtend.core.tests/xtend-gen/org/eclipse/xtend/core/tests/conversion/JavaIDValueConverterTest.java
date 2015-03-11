/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.conversion;

import com.google.inject.Inject;
import org.eclipse.xtend.core.conversion.XtendValueConverterService;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaIDValueConverterTest extends AbstractXtendTestCase {
  @Inject
  private XtendValueConverterService valueConverterService;
  
  @Test
  public void testSimple() {
    final String s = "abc";
    final Object value = this.valueConverterService.toValue(s, "ID", null);
    Assert.assertEquals("abc", value);
    String _string = this.valueConverterService.toString(value, "ID");
    Assert.assertEquals(s, _string);
  }
  
  @Test
  public void testUnicode() {
    final String s = "\\u0050";
    final Object value = this.valueConverterService.toValue(s, "ID", null);
    Assert.assertEquals("P", value);
    String _string = this.valueConverterService.toString(value, "ID");
    Assert.assertEquals("P", _string);
  }
  
  @Test
  public void testInvalidUnicode() {
    final String s = "a\\u0060";
    try {
      this.valueConverterService.toValue(s, "ID", null);
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterWithValueException) {
        final ValueConverterWithValueException e = (ValueConverterWithValueException)_t;
        Object _value = e.getValue();
        final String value = ((String) _value);
        Assert.assertEquals("a", value);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testUnclosedUnicode_01() {
    final String s = "a\\u006";
    try {
      this.valueConverterService.toValue(s, "ID", null);
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterWithValueException) {
        final ValueConverterWithValueException e = (ValueConverterWithValueException)_t;
        Object _value = e.getValue();
        final String value = ((String) _value);
        Assert.assertEquals("au006", value);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testUnclosedUnicode_02() {
    final String s = "a\\u";
    try {
      this.valueConverterService.toValue(s, "ID", null);
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterWithValueException) {
        final ValueConverterWithValueException e = (ValueConverterWithValueException)_t;
        Object _value = e.getValue();
        final String value = ((String) _value);
        Assert.assertEquals("au", value);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testTrailingBackslash() {
    final String s = "a\\";
    try {
      this.valueConverterService.toValue(s, "ID", null);
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterWithValueException) {
        final ValueConverterWithValueException e = (ValueConverterWithValueException)_t;
        Object _value = e.getValue();
        final String value = ((String) _value);
        Assert.assertEquals("a", value);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testEscaped() {
    final String s = "class";
    final String value = this.valueConverterService.toString(s, "ID");
    Assert.assertEquals("^class", value);
    Object _value = this.valueConverterService.toValue(value, "ID", null);
    Assert.assertEquals(s, _value);
  }
  
  @Test
  public void testNull() {
    try {
      this.valueConverterService.toString(null, "ID");
      Assert.fail("Null value not detected.");
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        final ValueConverterException e = (ValueConverterException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testEmpty() {
    try {
      this.valueConverterService.toString("", "ID");
      Assert.fail("Empty value not detected.");
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        final ValueConverterException e = (ValueConverterException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testInvalidChar1() {
    try {
      this.valueConverterService.toString("^foo", "ID");
      Assert.fail("invalid char not detected..");
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        final ValueConverterException e = (ValueConverterException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testInvalidChar2() {
    try {
      this.valueConverterService.toString("foo%bar[]", "ID");
      Assert.fail("Empty value not detected.");
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        final ValueConverterException e = (ValueConverterException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testInvalidChar3() {
    try {
      this.valueConverterService.toString("0foo", "ID");
      Assert.fail("Empty value not detected.");
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        final ValueConverterException e = (ValueConverterException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
