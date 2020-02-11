/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import com.google.inject.Guice;
import org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguageRuntimeModule;
import org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.Modules2;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class PartialSerializationTestLanguageIdeSetup extends PartialSerializationTestLanguageStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new PartialSerializationTestLanguageRuntimeModule(), new PartialSerializationTestLanguageIdeModule()));
	}
	
}
