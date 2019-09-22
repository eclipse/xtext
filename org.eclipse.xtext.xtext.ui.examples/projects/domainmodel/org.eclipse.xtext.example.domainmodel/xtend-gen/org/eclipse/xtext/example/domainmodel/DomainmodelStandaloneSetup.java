/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.xtext.example.domainmodel.DomainmodelStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class DomainmodelStandaloneSetup extends DomainmodelStandaloneSetupGenerated {
  public static void doSetup() {
    new DomainmodelStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
