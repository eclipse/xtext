/**
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.util.Modules;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend.web.XtendWebModule;

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class XtendWebSetup extends XtendStandaloneSetup {
  private final Provider<ExecutorService> executorServiceProvider;
  
  @Override
  public Injector createInjector() {
    final XtendRuntimeModule runtimeModule = new XtendRuntimeModule();
    final XtendWebModule webModule = new XtendWebModule(this.executorServiceProvider);
    Modules.OverriddenModuleBuilder _override = Modules.override(runtimeModule);
    Module _with = _override.with(webModule);
    return Guice.createInjector(_with);
  }
  
  public XtendWebSetup(final Provider<ExecutorService> executorServiceProvider) {
    super();
    this.executorServiceProvider = executorServiceProvider;
  }
}
