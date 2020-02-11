/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class RecursionGuardTest {
  @Extension
  private ReflectExtensions _reflectExtensions = new ReflectExtensions();
  
  @Test
  public void tryNextAndDoneYieldsEmpty() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      try {
        final String s = "literal";
        Assert.assertTrue(it.tryNext(s));
        it.done(s);
        Assert.assertNull(this._reflectExtensions.<Object>get(it, "head"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
  
  @Test
  public void tryNextTwiceYieldsFalse() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      final String s = "literal";
      Assert.assertTrue(it.tryNext(s));
      Assert.assertFalse(it.tryNext(s));
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
  
  @Test
  public void tryNextWithDifferentValuesYieldsTrue() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      Assert.assertTrue(it.tryNext("first"));
      Assert.assertTrue(it.tryNext("second"));
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
  
  @Test
  public void clearYieldsEmpty() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      try {
        Assert.assertTrue(it.tryNext("dummy"));
        it.clear();
        Assert.assertNull(this._reflectExtensions.<Object>get(it, "head"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
  
  @Test(expected = IllegalStateException.class)
  public void doneTwice() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      final String s = "literal";
      Assert.assertTrue(it.tryNext(s));
      it.done(s);
      it.done(s);
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
}
