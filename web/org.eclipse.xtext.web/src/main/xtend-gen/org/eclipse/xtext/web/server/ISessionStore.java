/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public interface ISessionStore {
  public static class NullImpl implements ISessionStore {
    @Override
    public <T extends Object> T get(final Object key) {
      return null;
    }
    
    @Override
    public <T extends Object> T get(final Object key, final Function0<? extends T> factory) {
      return null;
    }
    
    @Override
    public void put(final Object key, final Object value) {
    }
    
    @Override
    public void remove(final Object key) {
    }
  }
  
  public abstract <T extends Object> T get(final Object key);
  
  public abstract <T extends Object> T get(final Object key, final Function0<? extends T> factory);
  
  public abstract void put(final Object key, final Object value);
  
  public abstract void remove(final Object key);
}
