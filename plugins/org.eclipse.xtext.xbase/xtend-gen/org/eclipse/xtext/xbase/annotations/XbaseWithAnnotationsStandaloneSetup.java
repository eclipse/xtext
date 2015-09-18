/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations;

import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsStandaloneSetupGenerated;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
@SuppressWarnings("all")
public class XbaseWithAnnotationsStandaloneSetup extends XbaseWithAnnotationsStandaloneSetupGenerated {
  public static void doSetup() {
    XbaseWithAnnotationsStandaloneSetup _xbaseWithAnnotationsStandaloneSetup = new XbaseWithAnnotationsStandaloneSetup();
    _xbaseWithAnnotationsStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
  
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    String _nsURI = XAnnotationsPackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI, XAnnotationsPackage.eINSTANCE);
    return super.createInjectorAndDoEMFRegistration();
  }
}
