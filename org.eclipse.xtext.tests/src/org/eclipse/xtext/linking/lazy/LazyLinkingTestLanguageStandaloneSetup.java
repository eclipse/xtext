/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LazyLinkingTestLanguageStandaloneSetup extends LazyLinkingTestLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new LazyLinkingTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		super.register(injector);
		if (!EPackage.Registry.INSTANCE.containsKey("http://eclipse.org/xtext/lazyLinkingTestLanguage")) {
			EPackage.Registry.INSTANCE.put("http://eclipse.org/xtext/lazyLinkingTestLanguage", LazyLinkingPackage.eINSTANCE);
		}
	}
	
}
