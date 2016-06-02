package org.eclipse.xpect.tests.state;

import org.eclipse.xpect.state.Creates;

@SuppressWarnings("all")
public class TypeParam<T extends CharSequence> {
  public TypeParam(final Class<T> type) {
  }
  
  @Creates
  public T get() {
    return null;
  }
}
