/** 
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase

import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.xtype.XtypePackage
import com.google.inject.Injector

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 * @since 2.7
 */
class XtypeStandaloneSetup extends XtypeStandaloneSetupGenerated {

	def static void doSetup() {
		new XtypeStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	override Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(TypesPackage.eINSTANCE.getNsURI(), TypesPackage.eINSTANCE)
		EPackage.Registry.INSTANCE.put(XtypePackage.eINSTANCE.getNsURI(), XtypePackage.eINSTANCE)
		return super.createInjectorAndDoEMFRegistration()
	}
}
