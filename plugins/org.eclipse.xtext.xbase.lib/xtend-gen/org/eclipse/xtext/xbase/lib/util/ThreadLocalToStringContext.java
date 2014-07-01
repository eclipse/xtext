/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.lib.util;

import java.util.IdentityHashMap;
import org.eclipse.xtext.xbase.lib.util.ToStringContext;

@SuppressWarnings("all")
class ThreadLocalToStringContext extends ToStringContext {
  private final static ThreadLocal<IdentityHashMap<Object, Boolean>> currentlyProcessed = new ThreadLocal<IdentityHashMap<Object, Boolean>>() {
    public IdentityHashMap<Object, Boolean> initialValue() {
      return new IdentityHashMap<Object, Boolean>();
    }
  };
  
  public IdentityHashMap<Object, Boolean> getCurrentlyProcessed() {
    return ThreadLocalToStringContext.currentlyProcessed.get();
  }
}
