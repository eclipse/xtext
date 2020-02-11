/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.tests.typesystem.EmptyClasspathRuntimeModule;

@SuppressWarnings("all")
public class EmptyClasspathXbaseTestStandaloneSetup extends XbaseStandaloneSetup {
  @Override
  public Injector createInjector() {
    EmptyClasspathRuntimeModule _emptyClasspathRuntimeModule = new EmptyClasspathRuntimeModule();
    return Guice.createInjector(_emptyClasspathRuntimeModule);
  }
}
