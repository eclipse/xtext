package org.eclipse.xtext.xbase.tests.lib.util;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ReflectExtensionsTest {
  @Extension
  public ReflectExtensions ext = new ReflectExtensions();
  
  private ReflectExtensions privateExt = new ReflectExtensions();
  
  @Test
  public void testInvoke_01() {
    try {
      final String x = "foo";
      Assert.assertEquals(Integer.valueOf(3), this.ext.invoke(x, "length"));
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
      final StringBuilder x = new StringBuilder();
      try {
        this.ext.invoke(x, "append", "foo");
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof IllegalStateException) {
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
      final Function1<String, String> _function = (String x) -> {
        return x;
      };
      final Function1<String, String> x = _function;
      Assert.assertNull(this.ext.invoke(x, "apply", null));
      Assert.assertEquals("foo", this.ext.invoke(x, "apply", "foo"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInvokeWithPrimitives() {
    try {
      final String x = "foo";
      Assert.assertEquals("o", this.ext.invoke(x, "substring", Integer.valueOf(1), Integer.valueOf(2)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGet_01() {
    try {
      final ReflectExtensionsTest x = new ReflectExtensionsTest();
      Assert.assertNotNull(this.ext.<Object>get(x, "ext"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGet_02() {
    try {
      final ReflectExtensionsTest x = new ReflectExtensionsTest();
      try {
        Assert.assertNotNull(this.ext.<Object>get(x, "foo"));
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
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
      final ReflectExtensionsTest x = new ReflectExtensionsTest();
      Assert.assertSame(x.privateExt, this.ext.<Object>get(x, "privateExt"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSet_01() {
    try {
      final ReflectExtensionsTest x = new ReflectExtensionsTest();
      this.ext.set(x, "ext", null);
      Assert.assertNull(x.ext);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSet_02() {
    try {
      final ReflectExtensionsTest x = new ReflectExtensionsTest();
      try {
        this.ext.set(x, "foo", "bar");
        Assert.fail();
      } catch (final Throwable _t) {
        if (_t instanceof NoSuchFieldException) {
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
      final ReflectExtensionsTest x = new ReflectExtensionsTest();
      this.ext.set(x, "privateExt", null);
      Assert.assertNull(x.privateExt);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
