/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * Provides means to store information that can be accessed for subsequent requests.
 * This allows to improve the server performance by avoiding duplicate computations,
 * and to share resources across multiple service requests.
 */
@SuppressWarnings("all")
public interface ISession {
  /**
   * A default implementation that stores nothing.
   */
  public static class NullImpl implements ISession {
    @Override
    public <T extends Object> T get(final Object key) {
      return null;
    }
    
    @Override
    public <T extends Object> T get(final Object key, final Function0<? extends T> factory) {
      return factory.apply();
    }
    
    @Override
    public void put(final Object key, final Object value) {
    }
    
    @Override
    public void remove(final Object key) {
    }
  }
  
  /**
   * Get the stored information for the given key. Returns {@code null} if nothing
   * is associated with that key.
   */
  public abstract <T extends Object> T get(final Object key);
  
  /**
   * Get the stored information for the given key, creating it if it is not present yet.
   * The check for presence of the information and the invocation of the factory are
   * done in an atomic block, thus the session store may be accessed from multiple threads.
   */
  public abstract <T extends Object> T get(final Object key, final Function0<? extends T> factory);
  
  /**
   * Add the given information to this session store, overwriting any previously stored
   * information for that key.
   */
  public abstract void put(final Object key, final Object value);
  
  /**
   * Remove the information stored with the given key.
   */
  public abstract void remove(final Object key);
}
