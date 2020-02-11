/** 
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EPackage;
import com.google.inject.Injector;

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 * @since 2.7
 */
public class XbaseStandaloneSetup extends XbaseStandaloneSetupGenerated {

	public static void doSetup() {
		new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(XbasePackage.eINSTANCE.getNsURI(), XbasePackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
}
