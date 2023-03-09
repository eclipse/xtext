/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage;

import org.eclipse.xtext.ide.tests.testlanguage.ide.PartialContentAssistTestLanguageIdeModule;
import org.eclipse.xtext.ide.tests.testlanguage.tests.PartialContentAssistTestLanguageInjectorProvider;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PartialContentAssistTestLanguageIdeInjectorProvider
		extends PartialContentAssistTestLanguageInjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		return new TestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(createRuntimeModule(), new PartialContentAssistTestLanguageIdeModule()));
			}
		}.createInjectorAndDoEMFRegistration();
	}

}
