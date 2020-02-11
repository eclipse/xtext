/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.tests.typesystem.EmptyClasspathClassLoader;

@SuppressWarnings("all")
public class EmptyClasspathRuntimeModule extends XbaseInjectorProvider.XbaseTestRuntimeModule {
  @Override
  public ClassLoader bindClassLoaderToInstance() {
    return new EmptyClasspathClassLoader();
  }
}
