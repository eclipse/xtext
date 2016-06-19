/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.Triple;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(Bug443705Test.Bug443705InjectorProvider.class)
public class Bug443705Test {

	public static class Bug443705InjectorProvider extends LazyLinkingTestLanguageInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new Bug443705StandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}

	public static class Bug443705StandaloneSetup extends LazyLinkingTestLanguageStandaloneSetupGenerated {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new Bug443705RuntimeModule());
		}
	}

	public static class Bug443705RuntimeModule extends LazyLinkingTestLanguageRuntimeModule {
		@Override
		public Class<? extends IScopeProvider> bindIScopeProvider() {
			return org.eclipse.xtext.linking.lazy.Bug443705Test.RecursiveScopeProvider.class;
		}

		@Override
		public Class<? extends XtextResource> bindXtextResource() {
			return CyclicResolutionExceptionIgnoringResource.class;
		}
	}

	public static class CyclicResolutionExceptionIgnoringResource extends LazyLinkingResource {
		@Override
		protected EObject handleCyclicResolution(Triple<EObject, EReference, INode> triple) throws AssertionError {
			return null; // instead of throwing an exception
		}
	}

	public static class RecursiveScopeProvider extends LazyLinkingTestLanguageScopeProvider {
		public IScope scope_Property_type(Property p, EReference ref) {
			// try causing a CyclicResolutionException twice to test if 
			// org.eclipse.xtext.linking.lazy.LazyLinkingResource.resolving
			// is cleaned up properly
			Assert.assertTrue(p.getType().get(0).eIsProxy());
			Assert.assertTrue(p.getType().get(0).eIsProxy());
			return new SimpleScope(Collections.singleton(EObjectDescription.create("Bar", p.eContainer())));
		}
	}

	@Inject
	private ParseHelper<EObject> parser;

	@Inject
	private ValidationTestHelper validator;

	@Test
	public void testRecursionErrorMessage() throws Exception {
		EObject object = parser.parse("type Foo { Bar foo; }");
		validator.assertNoErrors(object);
	}
}
