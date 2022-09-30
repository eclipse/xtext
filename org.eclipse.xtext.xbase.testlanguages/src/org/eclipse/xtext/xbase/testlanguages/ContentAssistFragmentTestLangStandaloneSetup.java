/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.TypesPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ContentAssistFragmentTestLangStandaloneSetup extends ContentAssistFragmentTestLangStandaloneSetupGenerated{

	public static void doSetup() {
		new ContentAssistFragmentTestLangStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		EPackage.Registry.INSTANCE.put(TypesPackage.eINSTANCE.getNsURI(), TypesPackage.eINSTANCE);
		return super.createInjectorAndDoEMFRegistration();
	}
}

