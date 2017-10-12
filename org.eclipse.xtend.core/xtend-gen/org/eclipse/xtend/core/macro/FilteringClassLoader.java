/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.net.URL;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class FilteringClassLoader extends ClassLoader {
  private final static char DOT = '.';
  
  private final static char SLASH = '/';
  
  private final List<String> includes;
  
  private final List<String> resourceIncludes;
  
  public FilteringClassLoader(final ClassLoader parent, final List<String> includes) {
    super(parent);
    this.includes = includes;
    final Function1<String, String> _function = (String it) -> {
      return it.replace(FilteringClassLoader.DOT, FilteringClassLoader.SLASH);
    };
    this.resourceIncludes = ListExtensions.<String, String>map(includes, _function);
  }
  
  @Override
  public Class<?> loadClass(final String name, final boolean resolve) throws ClassNotFoundException {
    try {
      ClassLoader _parent = ClassLoader.getSystemClassLoader().getParent();
      Class<?> _loadClass = null;
      if (_parent!=null) {
        _loadClass=_parent.loadClass(name);
      }
      return _loadClass;
    } catch (final Throwable _t) {
      if (_t instanceof ClassNotFoundException) {
        final ClassNotFoundException ignored = (ClassNotFoundException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    boolean _isValidClass = this.isValidClass(name);
    if (_isValidClass) {
      final Class<?> result = super.loadClass(name, false);
      if (resolve) {
        this.resolveClass(result);
      }
      return result;
    } else {
      throw new ClassNotFoundException(name);
    }
  }
  
  @Override
  public URL getResource(final String name) {
    ClassLoader _parent = ClassLoader.getSystemClassLoader().getParent();
    URL _resource = null;
    if (_parent!=null) {
      _resource=_parent.getResource(name);
    }
    final URL result = _resource;
    if ((result != null)) {
      return result;
    }
    boolean _isValidResource = this.isValidResource(name);
    if (_isValidResource) {
      return super.getResource(name);
    }
    return null;
  }
  
  private boolean isValidClass(final String name) {
    final Function1<String, Boolean> _function = (String it) -> {
      return Boolean.valueOf(name.startsWith((it + Character.valueOf(FilteringClassLoader.DOT))));
    };
    return IterableExtensions.<String>exists(this.includes, _function);
  }
  
  private boolean isValidResource(final String name) {
    final Function1<String, Boolean> _function = (String it) -> {
      return Boolean.valueOf(name.startsWith((it + Character.valueOf(FilteringClassLoader.SLASH))));
    };
    return IterableExtensions.<String>exists(this.resourceIncludes, _function);
  }
}
