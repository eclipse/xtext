/**
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.example.domainmodel.DomainmodelRuntimeModule;
import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetup;
import org.eclipse.xtext.example.domainmodel.ide.DomainmodelIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class DomainmodelIdeSetup extends DomainmodelStandaloneSetup {
  @Override
  public Injector createInjector() {
    DomainmodelRuntimeModule _domainmodelRuntimeModule = new DomainmodelRuntimeModule();
    DomainmodelIdeModule _domainmodelIdeModule = new DomainmodelIdeModule();
    return Guice.createInjector(Modules2.mixin(_domainmodelRuntimeModule, _domainmodelIdeModule));
  }
}
