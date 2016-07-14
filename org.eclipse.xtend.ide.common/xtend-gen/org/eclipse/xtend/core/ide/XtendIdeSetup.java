/**
 * Copyright (c) 2010-2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.ide.XtendIdeModule;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class XtendIdeSetup extends XtendStandaloneSetup {
  @Override
  public Injector createInjector() {
    XtendRuntimeModule _xtendRuntimeModule = new XtendRuntimeModule();
    XtendIdeModule _xtendIdeModule = new XtendIdeModule();
    return Guice.createInjector(_xtendRuntimeModule, _xtendIdeModule);
  }
}
