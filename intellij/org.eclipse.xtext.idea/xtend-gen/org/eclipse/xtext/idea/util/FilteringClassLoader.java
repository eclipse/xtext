/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.util;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class FilteringClassLoader extends ClassLoader {
  private final Function1<? super String, ? extends Boolean> filter;
  
  public FilteringClassLoader(final ClassLoader parent, final Function1<? super String, ? extends Boolean> filter) {
    super(parent);
    this.filter = filter;
  }
  
  @Override
  protected Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
    try {
      ClassLoader _systemClassLoader = ClassLoader.getSystemClassLoader();
      ClassLoader _parent = _systemClassLoader.getParent();
      Class<?> _loadClass = null;
      if (_parent!=null) {
        _loadClass=_parent.loadClass(name);
      }
      return _loadClass;
    } catch (final Throwable _t) {
      if (_t instanceof ClassNotFoundException) {
        final ClassNotFoundException e = (ClassNotFoundException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Boolean _apply = this.filter.apply(name);
    boolean _not = (!(_apply).booleanValue());
    if (_not) {
      throw new ClassNotFoundException(name);
    }
    return super.loadClass(name, resolve);
  }
}
