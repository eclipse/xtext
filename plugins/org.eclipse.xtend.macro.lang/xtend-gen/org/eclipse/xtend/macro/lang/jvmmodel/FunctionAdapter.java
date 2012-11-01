/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.macro.lang.jvmmodel;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class FunctionAdapter extends AdapterImpl {
  private Function1<? super List<Object>,? extends Object> _function;
  
  public Function1<? super List<Object>,? extends Object> getFunction() {
    return this._function;
  }
  
  public void setFunction(final Function1<? super List<Object>,? extends Object> function) {
    this._function = function;
  }
  
  public boolean isAdapterForType(final Object type) {
    boolean _equals = Objects.equal(type, FunctionAdapter.class);
    return _equals;
  }
}
