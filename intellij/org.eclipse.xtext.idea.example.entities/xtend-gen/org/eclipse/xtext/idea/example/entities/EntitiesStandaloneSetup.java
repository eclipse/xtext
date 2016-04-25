/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.example.entities;

import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class EntitiesStandaloneSetup extends EntitiesStandaloneSetupGenerated {
  public static void doSetup() {
    EntitiesStandaloneSetup _entitiesStandaloneSetup = new EntitiesStandaloneSetup();
    _entitiesStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
