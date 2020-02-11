/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Guice
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xbase.XbaseStandaloneSetup
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.junit.runner.RunWith

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(EmptyClasspathXbaseInjectorProvider)
class EmptyClasspathTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {

	@Inject extension IBatchTypeResolver

	@Inject extension ParseHelper<EObject>

	override resolvesTo(String expression, String type) {
		expression.parse.resolveTypes
		return null
	}

	override isFunctionAndEquivalentTo(LightweightTypeReference reference, String type) {
		// nothing to do
	}

}

class EmptyClasspathXbaseInjectorProvider extends XbaseInjectorProvider {

	override internalCreateInjector() {
		return new EmptyClasspathXbaseTestStandaloneSetup().createInjectorAndDoEMFRegistration
	}

}

class EmptyClasspathXbaseTestStandaloneSetup extends XbaseStandaloneSetup {

	override createInjector() {
		Guice.createInjector(new EmptyClasspathRuntimeModule)
	}

}

class EmptyClasspathRuntimeModule extends XbaseInjectorProvider.XbaseTestRuntimeModule {

	override bindClassLoaderToInstance() {
		new EmptyClasspathClassLoader
	}

}

class EmptyClasspathClassLoader extends ClassLoader {

	override getResource(String name) {
		if (name.endsWith('.class')) {
			null
		} else {
			super.getResource(name)
		}
	}

}
