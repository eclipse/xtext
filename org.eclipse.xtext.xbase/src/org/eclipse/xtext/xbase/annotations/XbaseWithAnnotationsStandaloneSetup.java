/** 
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import com.google.inject.Injector;

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class XbaseWithAnnotationsStandaloneSetup extends XbaseWithAnnotationsStandaloneSetupGenerated {

	public static void doSetup() {
		new XbaseWithAnnotationsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(XAnnotationsPackage.eINSTANCE.getNsURI(), XAnnotationsPackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
}
