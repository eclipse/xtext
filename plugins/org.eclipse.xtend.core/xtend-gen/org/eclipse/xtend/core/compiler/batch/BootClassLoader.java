/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.compiler.batch;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;

/**
 * Use this classloader as a parent in order to supply different JDK classes than the
 * currently running VM.
 */
@SuppressWarnings("all")
public class BootClassLoader extends URLClassLoader {
  public BootClassLoader(final URL[] urls) {
    super(urls);
  }
  
  protected Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
    Class<?> _xsynchronizedexpression = null;
    Object _classLoadingLock = this.getClassLoadingLock(name);
    synchronized (_classLoadingLock) {
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
  
  public URL getResource(final String name) {
    return this.findResource(name);
  }
  
  public Enumeration<URL> getResources(final String name) throws IOException {
    return this.findResources(name);
  }
}
