/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage;

import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ide.tests.testlanguage.withtransient.WithtransientPackage;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class PartialSerializationTestLanguageStandaloneSetup extends PartialSerializationTestLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new PartialSerializationTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public void register(Injector injector) {
		super.register(injector);
		if (!EPackage.Registry.INSTANCE.containsKey(
			"http://www.eclipse.org/xtext/ide/tests/testlanguage/mm/withtransient")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/xtext/ide/tests/testlanguage/mm/withtransient",
				WithtransientPackage.eINSTANCE);
		}
	}
	
}
