/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

import java.lang.reflect.Modifier;
import org.eclipse.xtext.xbase.web.contentassist.ITypeFilter;

@SuppressWarnings("all")
final class TypeMatchFilters {
  public final static ITypeFilter INTERNAL = new ITypeFilter() {
    @Override
    public boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path) {
      boolean _startsWith = simpleTypeName.startsWith("$");
      if (_startsWith) {
        return true;
      }
      int _length = enclosingTypeNames.length;
      boolean _greaterEqualsThan = (_length >= 1);
      if (_greaterEqualsThan) {
        String _get = enclosingTypeNames[0];
        boolean _startsWith_1 = _get.startsWith("$");
        if (_startsWith_1) {
          return true;
        }
      }
      return false;
    }
  };
  
  public final static ITypeFilter ABSTRACT = new ITypeFilter() {
    @Override
    public boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path) {
      return Modifier.isAbstract(modifiers);
    }
  };
  
  public final static ITypeFilter INTERFACE = new ITypeFilter() {
    @Override
    public boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path) {
      return Modifier.isInterface(modifiers);
    }
  };
  
  public static ITypeFilter operator_not(final ITypeFilter filter) {
    final ITypeFilter _function = new ITypeFilter() {
      @Override
      public boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path) {
        boolean _accept = filter.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
        return (!_accept);
      }
    };
    return _function;
  }
  
  public static ITypeFilter operator_and(final ITypeFilter filter1, final ITypeFilter filter2) {
    final ITypeFilter _function = new ITypeFilter() {
      @Override
      public boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path) {
        boolean _and = false;
        boolean _accept = filter1.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
        if (!_accept) {
          _and = false;
        } else {
          boolean _accept_1 = filter2.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
          _and = _accept_1;
        }
        return _and;
      }
    };
    return _function;
  }
  
  public static ITypeFilter operator_or(final ITypeFilter filter1, final ITypeFilter filter2) {
    final ITypeFilter _function = new ITypeFilter() {
      @Override
      public boolean accept(final int modifiers, final String packageName, final String simpleTypeName, final String[] enclosingTypeNames, final String path) {
        boolean _or = false;
        boolean _accept = filter1.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
        if (_accept) {
          _or = true;
        } else {
          boolean _accept_1 = filter2.accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path);
          _or = _accept_1;
        }
        return _or;
      }
    };
    return _function;
  }
}
