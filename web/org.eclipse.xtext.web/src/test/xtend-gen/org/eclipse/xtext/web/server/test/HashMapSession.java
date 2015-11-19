/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test;

import java.util.HashMap;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class HashMapSession implements ISession {
  private final HashMap<Object, Object> map = new HashMap<Object, Object>();
  
  @Override
  public <T extends Object> T get(final Object key) {
    Object _get = this.map.get(key);
    return ((T) _get);
  }
  
  @Override
  public <T extends Object> T get(final Object key, final Function0<? extends T> factory) {
    synchronized (this.map) {
      final T sessionValue = this.<T>get(key);
      if ((sessionValue != null)) {
        return sessionValue;
      } else {
        final T factoryValue = factory.apply();
        this.put(key, factoryValue);
        return factoryValue;
      }
    }
  }
  
  @Override
  public void put(final Object key, final Object value) {
    this.map.put(key, value);
  }
  
  @Override
  public void remove(final Object key) {
    this.map.remove(key);
  }
}
