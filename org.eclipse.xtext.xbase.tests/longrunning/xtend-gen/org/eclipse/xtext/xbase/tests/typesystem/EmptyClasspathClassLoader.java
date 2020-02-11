/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.net.URL;

@SuppressWarnings("all")
public class EmptyClasspathClassLoader extends ClassLoader {
  @Override
  public URL getResource(final String name) {
    URL _xifexpression = null;
    boolean _endsWith = name.endsWith(".class");
    if (_endsWith) {
      _xifexpression = null;
    } else {
      _xifexpression = super.getResource(name);
    }
    return _xifexpression;
  }
}
