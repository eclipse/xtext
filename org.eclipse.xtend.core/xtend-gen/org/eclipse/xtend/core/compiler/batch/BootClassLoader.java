/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.compiler.batch;

import com.google.common.collect.Maps;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentMap;

/**
 * @deprecated This was an accidently exposed implementation detail of the batch compiler
 * @since 2.7
 */
@Deprecated
@SuppressWarnings("all")
public class BootClassLoader extends URLClassLoader {
  private final ConcurrentMap<String, Object> locks = Maps.<String, Object>newConcurrentMap();

  public BootClassLoader(final URL[] urls) {
    super(urls);
  }

  @Override
  protected Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
    Class<?> _xsynchronizedexpression = null;
    synchronized (this.getClassLoadingLockJdk5(name)) {
      Class<?> _xblockexpression = null;
      {
        Class<?> _elvis = null;
        Class<?> _findLoadedClass = this.findLoadedClass(name);
        if (_findLoadedClass != null) {
          _elvis = _findLoadedClass;
        } else {
          Class<?> _findClass = this.findClass(name);
          _elvis = _findClass;
        }
        final Class<?> c = _elvis;
        if (resolve) {
          this.resolveClass(c);
        }
        _xblockexpression = c;
      }
      _xsynchronizedexpression = _xblockexpression;
    }
    return _xsynchronizedexpression;
  }

  @Override
  public URL getResource(final String name) {
    return this.findResource(name);
  }

  @Override
  public Enumeration<URL> getResources(final String name) throws IOException {
    return this.findResources(name);
  }

  private Object getClassLoadingLockJdk5(final String className) {
    final Object newLock = new Object();
    final Object existingLock = this.locks.putIfAbsent(className, newLock);
    Object _elvis = null;
    if (existingLock != null) {
      _elvis = existingLock;
    } else {
      _elvis = newLock;
    }
    return _elvis;
  }
}
