/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.lib.util;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.IdentityHashMap;
import org.eclipse.xtext.xbase.lib.Exceptions;

@GwtCompatible
@SuppressWarnings("all")
abstract class ToStringContext {
  public static ToStringContext instance() {
    try {
      ToStringContext _xtrycatchfinallyexpression = null;
      try {
        ClassLoader _classLoader = ToStringContext.class.getClassLoader();
        Class<?> _loadClass = _classLoader.loadClass("org.eclipse.xtext.xbase.lib.util.ThreadLocalToStringContext");
        Object _newInstance = _loadClass.newInstance();
        _xtrycatchfinallyexpression = ((ToStringContext) _newInstance);
      } catch (final Throwable _t) {
        if (_t instanceof ClassNotFoundException) {
          final ClassNotFoundException e = (ClassNotFoundException)_t;
          ClassLoader _classLoader_1 = ToStringContext.class.getClassLoader();
          Class<?> _loadClass_1 = _classLoader_1.loadClass("org.eclipse.xtext.xbase.lib.util.GwtToStringContext");
          Object _newInstance_1 = _loadClass_1.newInstance();
          _xtrycatchfinallyexpression = ((ToStringContext) _newInstance_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return _xtrycatchfinallyexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean startProcessing(final Object obj) {
    IdentityHashMap<Object, Boolean> _currentlyProcessed = this.getCurrentlyProcessed();
    Boolean _put = _currentlyProcessed.put(obj, Boolean.TRUE);
    return Objects.equal(_put, null);
  }
  
  public void endProcessing(final Object obj) {
    IdentityHashMap<Object, Boolean> _currentlyProcessed = this.getCurrentlyProcessed();
    _currentlyProcessed.remove(obj);
  }
  
  public abstract IdentityHashMap<Object, Boolean> getCurrentlyProcessed();
}
