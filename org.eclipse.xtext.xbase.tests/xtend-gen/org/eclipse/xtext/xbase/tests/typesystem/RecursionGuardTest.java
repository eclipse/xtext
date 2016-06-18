/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
        boolean _tryNext = it.tryNext(s);
        Assert.assertTrue(_tryNext);
        it.done(s);
        Object _get = this._reflectExtensions.<Object>get(it, "head");
        Assert.assertNull(_get);
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
      boolean _tryNext = it.tryNext(s);
      Assert.assertTrue(_tryNext);
      boolean _tryNext_1 = it.tryNext(s);
      Assert.assertFalse(_tryNext_1);
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
  
  @Test
  public void tryNextWithDifferentValuesYieldsTrue() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      boolean _tryNext = it.tryNext("first");
      Assert.assertTrue(_tryNext);
      boolean _tryNext_1 = it.tryNext("second");
      Assert.assertTrue(_tryNext_1);
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
  
  @Test
  public void clearYieldsEmpty() {
    RecursionGuard<String> _recursionGuard = new RecursionGuard<String>();
    final Procedure1<RecursionGuard<String>> _function = (RecursionGuard<String> it) -> {
      try {
        boolean _tryNext = it.tryNext("dummy");
        Assert.assertTrue(_tryNext);
        it.clear();
        Object _get = this._reflectExtensions.<Object>get(it, "head");
        Assert.assertNull(_get);
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
      boolean _tryNext = it.tryNext(s);
      Assert.assertTrue(_tryNext);
      it.done(s);
      it.done(s);
    };
    ObjectExtensions.<RecursionGuard<String>>operator_doubleArrow(_recursionGuard, _function);
  }
}
