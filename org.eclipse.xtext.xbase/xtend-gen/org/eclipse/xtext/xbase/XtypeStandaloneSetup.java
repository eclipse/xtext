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
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.XtypeStandaloneSetupGenerated;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 * @since 2.7
 */
@SuppressWarnings("all")
public class XtypeStandaloneSetup extends XtypeStandaloneSetupGenerated {
  public static void doSetup() {
    XtypeStandaloneSetup _xtypeStandaloneSetup = new XtypeStandaloneSetup();
    _xtypeStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
  
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    String _nsURI = TypesPackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI, TypesPackage.eINSTANCE);
    String _nsURI_1 = XtypePackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI_1, XtypePackage.eINSTANCE);
    return super.createInjectorAndDoEMFRegistration();
  }
}
