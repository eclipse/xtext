/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import com.google.common.collect.ImmutableList;
import java.net.URL;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class FilteringClassLoader extends ClassLoader {
  private static final char DOT = '.';

  private static final char SLASH = '/';

  private final List<String> includes;

  private final List<String> resourceIncludes;

  public FilteringClassLoader(final ClassLoader parent, final List<String> includes) {
    super(parent);
    final Function1<String, String> _function = (String it) -> {
      return (it + Character.valueOf(FilteringClassLoader.DOT));
    };
    this.includes = ImmutableList.<String>copyOf(ListExtensions.<String, String>map(includes, _function));
    final Function1<String, String> _function_1 = (String it) -> {
      return it.replace(FilteringClassLoader.DOT, FilteringClassLoader.SLASH);
    };
    final Function1<String, String> _function_2 = (String it) -> {
      return (it + Character.valueOf(FilteringClassLoader.SLASH));
    };
    this.resourceIncludes = ImmutableList.<String>copyOf(ListExtensions.<String, String>map(ListExtensions.<String, String>map(includes, _function_1), _function_2));
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
    boolean _xblockexpression = false;
    {
      for (final String it : this.includes) {
        boolean _startsWith = name.startsWith(it);
        if (_startsWith) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }

  private boolean isValidResource(final String name) {
    boolean _xblockexpression = false;
    {
      for (final String it : this.resourceIncludes) {
        boolean _startsWith = name.startsWith(it);
        if (_startsWith) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
}
