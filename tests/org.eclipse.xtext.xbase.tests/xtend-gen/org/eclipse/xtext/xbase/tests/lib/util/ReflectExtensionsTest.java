package org.eclipse.xtext.xbase.tests.lib.util;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ReflectExtensionsTest {
  @Extension
  public ReflectExtensions ext = new Function0<ReflectExtensions>() {
    public ReflectExtensions apply() {
      ReflectExtensions _reflectExtensions = new ReflectExtensions();
      return _reflectExtensions;
    }
  }.apply();
  
  private ReflectExtensions privateExt = new Function0<ReflectExtensions>() {
    public ReflectExtensions apply() {
      ReflectExtensions _reflectExtensions = new ReflectExtensions();
      return _reflectExtensions;
    }
  }.apply();
  
  @Test
  public void testInvoke_01() {
    try {
      final String x = "foo";
      Object _invoke = this.ext.invoke(x, "length");
      Assert.assertEquals(Integer.valueOf(3), _invoke);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvoke_02() {
    try {
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvoke_03() {
    try {
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvokeWithOverloadedMethods() {
    try {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder x = _stringBuilder;
      try {
        this.ext.invoke(x, "append", "foo");
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IllegalStateException) {
          final IllegalStateException e = (IllegalStateException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvokeWithNull() {
    try {
      final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String x) {
          return x;
        }
      };
      final Function1<String,String> x = _function;
      Object _invoke = this.ext.invoke(x, "apply", null);
      Assert.assertNull(_invoke);
      Object _invoke_1 = this.ext.invoke(x, "apply", "foo");
      Assert.assertEquals("foo", _invoke_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvokeWithPrimitives() {
    try {
      final String x = "foo";
      Object _invoke = this.ext.invoke(x, "substring", Integer.valueOf(1), Integer.valueOf(2));
      Assert.assertEquals("o", _invoke);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGet_01() {
    try {
      ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
      final ReflectExtensionsTest x = _reflectExtensionsTest;
      Object _get = this.ext.<Object>get(x, "ext");
      Assert.assertNotNull(_get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGet_02() {
    try {
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGet_03() {
    try {
      ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
      final ReflectExtensionsTest x = _reflectExtensionsTest;
      Object _get = this.ext.<Object>get(x, "privateExt");
      Assert.assertSame(x.privateExt, _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSet_01() {
    try {
      ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
      final ReflectExtensionsTest x = _reflectExtensionsTest;
      this.ext.set(x, "ext", null);
      Assert.assertNull(x.ext);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSet_02() {
    try {
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSet_03() {
    try {
      ReflectExtensionsTest _reflectExtensionsTest = new ReflectExtensionsTest();
      final ReflectExtensionsTest x = _reflectExtensionsTest;
      this.ext.set(x, "privateExt", null);
      Assert.assertNull(x.privateExt);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
