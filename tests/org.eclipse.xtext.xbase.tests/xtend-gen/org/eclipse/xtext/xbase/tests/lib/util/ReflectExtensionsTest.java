package org.eclipse.xtext.xbase.tests.lib.util;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ReflectExtensionsTest {
  public ReflectExtensions ext = new Function0<ReflectExtensions>() {
    public ReflectExtensions apply() {
      ReflectExtensions _reflectExtensions = new ReflectExtensions();
      return _reflectExtensions;
    }
  }.apply();
  
  @Test
  public void testInvoke_01() {
    final String x = "foo";
    Object _invoke = this.ext.invoke(x, "length");
    Assert.assertEquals(Integer.valueOf(3), _invoke);
  }
  
  @Test
  public void testInvoke_02() {
    final String x = "foo";
    try {
      this.ext.invoke(x, "foo");
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchMethodException) {
        final NoSuchMethodException e = (NoSuchMethodException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testInvoke_03() {
    final String x = "foo";
    try {
      this.ext.invoke(x, "length", Integer.valueOf(24));
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchMethodException) {
        final NoSuchMethodException e = (NoSuchMethodException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testInvokeWithOverloadedMethods() {
    StringBuilder _stringBuilder = new StringBuilder();
    final StringBuilder x = _stringBuilder;
    try {
      this.ext.invoke(x, "append", "foo");
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
        String _message = e.getMessage();
        InputOutput.<String>println(_message);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testGet_01() {
    ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
    final ReflectExtensionsTest x = _reflectExtensionsTest;
    Object _get = this.ext.<Object>get(x, "ext");
    Assert.assertNotNull(_get);
  }
  
  @Test
  public void testGet_02() {
    ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
    final ReflectExtensionsTest x = _reflectExtensionsTest;
    try {
      Object _get = this.ext.<Object>get(x, "foo");
      Assert.assertNotNull(_get);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchFieldException) {
        final NoSuchFieldException e = (NoSuchFieldException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testSet_01() {
    ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
    final ReflectExtensionsTest x = _reflectExtensionsTest;
    this.ext.set(x, "ext", null);
    Assert.assertNull(x.ext);
  }
  
  @Test
  public void testSet_02() {
    ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
    final ReflectExtensionsTest x = _reflectExtensionsTest;
    try {
      this.ext.set(x, "foo", "bar");
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof NoSuchFieldException) {
        final NoSuchFieldException e = (NoSuchFieldException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
