/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide

import com.google.inject.Guice
import org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguageRuntimeModule
import org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguageStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class PartialSerializationTestLanguageIdeSetup extends PartialSerializationTestLanguageStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new PartialSerializationTestLanguageRuntimeModule, new PartialSerializationTestLanguageIdeModule))
	}
	
}
