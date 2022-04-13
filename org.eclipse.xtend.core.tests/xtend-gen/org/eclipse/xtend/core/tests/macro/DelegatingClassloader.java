/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.net.URL;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;

@SuppressWarnings("all")
public class DelegatingClassloader extends ClassLoader {
  private CompilationTestHelper.Result classFinder;

  public DelegatingClassloader(final ClassLoader parent, final CompilationTestHelper.Result classFinder) {
    super(parent);
    this.classFinder = classFinder;
  }

  @Override
  protected URL findResource(final String name) {
    final URL result = this.classFinder.getClassLoader().getResource(name);
    URL _elvis = null;
    if (result != null) {
      _elvis = result;
    } else {
      URL _findResource = super.findResource(name);
      _elvis = _findResource;
    }
    return _elvis;
  }

  @Override
  public Class<?> findClass(final String name) throws ClassNotFoundException {
    Class<?> _xblockexpression = null;
    {
      final Class<?> result = this.classFinder.getCompiledClass(name);
      if ((result != null)) {
        return result;
      }
      _xblockexpression = super.findClass(name);
    }
    return _xblockexpression;
  }

  @Override
  public Class<?> loadClass(final String name) throws ClassNotFoundException {
    return super.loadClass(name);
  }
}
