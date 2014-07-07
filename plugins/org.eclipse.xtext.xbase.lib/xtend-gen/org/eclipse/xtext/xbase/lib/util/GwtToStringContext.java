/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.lib.util;

import com.google.common.annotations.GwtCompatible;
import java.util.IdentityHashMap;
import org.eclipse.xtext.xbase.lib.util.ToStringContext;

@GwtCompatible
@SuppressWarnings("all")
class GwtToStringContext extends ToStringContext {
  private final static IdentityHashMap<Object, Boolean> currentlyProcessed = new IdentityHashMap<Object, Boolean>();
  
  public IdentityHashMap<Object, Boolean> getCurrentlyProcessed() {
    return GwtToStringContext.currentlyProcessed;
  }
}
