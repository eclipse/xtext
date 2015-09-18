/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;

import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.XbaseStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 * @since 2.7
 */
@SuppressWarnings("all")
public class XbaseStandaloneSetup extends XbaseStandaloneSetupGenerated {
  public static void doSetup() {
    XbaseStandaloneSetup _xbaseStandaloneSetup = new XbaseStandaloneSetup();
    _xbaseStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
  
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    String _nsURI = XbasePackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI, XbasePackage.eINSTANCE);
    return super.createInjectorAndDoEMFRegistration();
  }
}
