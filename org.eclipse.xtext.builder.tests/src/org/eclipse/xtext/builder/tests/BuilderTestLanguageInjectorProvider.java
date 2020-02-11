/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import org.eclipse.xtext.builder.tests.internal.TestsActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

import com.google.inject.Injector;

/**
 * An injector provider that allows to inject values from the 
 * <code>org.eclipse.xtext.builder.tests.BuilderTestLanguage</code> into a test class.
 * 
 * Use along with <code>@InjectWith</code>.
 * 
 * @see TestsActivator#ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderTestLanguageInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return TestsActivator.getInstance().getInjector(TestsActivator.ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE);
	}

}