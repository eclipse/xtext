/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util.internal;

import com.google.common.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class AlternateJdkLoader extends URLClassLoader {
  private final ConcurrentMap<String, Object> locks = Maps.<String, Object>newConcurrentMap();
  
  public AlternateJdkLoader(final Iterable<File> files) {
    super(((URL[])Conversions.unwrapArray(IterableExtensions.<File, URL>map(files, new Function1<File, URL>() {
      @Override
      public URL apply(final File it) {
        try {
          return it.toURL();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    }), URL.class)));
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
