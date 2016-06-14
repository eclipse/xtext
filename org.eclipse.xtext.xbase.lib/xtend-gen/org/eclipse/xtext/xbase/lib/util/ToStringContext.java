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

/**
 * On GWT we just use a static variable instead of a ThreadLocal
 */
@GwtCompatible(emulated = true)
@SuppressWarnings("all")
class ToStringContext {
  public final static ToStringContext INSTANCE = new ToStringContext();
  
  private final static ThreadLocal<IdentityHashMap<Object, Boolean>> currentlyProcessed = new ThreadLocal<IdentityHashMap<Object, Boolean>>() {
    @Override
    public IdentityHashMap<Object, Boolean> initialValue() {
      return new IdentityHashMap<Object, Boolean>();
    }
  };
  
  public boolean startProcessing(final Object obj) {
    IdentityHashMap<Object, Boolean> _get = ToStringContext.currentlyProcessed.get();
    Boolean _put = _get.put(obj, Boolean.TRUE);
    return Objects.equal(_put, null);
  }
  
  public void endProcessing(final Object obj) {
    IdentityHashMap<Object, Boolean> _get = ToStringContext.currentlyProcessed.get();
    _get.remove(obj);
  }
}
