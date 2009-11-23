/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Bug281990Test extends AbstractXtextTests {

	public static class RecursiveScopeProvider extends LazyLinkingTestLanguageScopeProvider {
		public IScope scope_Type_extends(Type t, EReference ref) {
			t.getParentId();
			return IScope.NULLSCOPE;
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new LazyLinkingTestLanguageRuntimeModule() {
			@Override
			public Class<? extends IScopeProvider> bindIScopeProvider() {
				return org.eclipse.xtext.linking.lazy.Bug281990Test.RecursiveScopeProvider.class;
			}
		});
		new LazyLinkingTestLanguageStandaloneSetup().register(getInjector());
	}

	public void testRecursionErrorMessage() throws Exception {
		try {
			getModel("type Foo extends Foo.bar { Foo foo; }");
			fail("Exception expected.");
		} catch (AssertionError e) {
			assertTrue(e.getMessage().startsWith("Cyclic"));
		}
	}
}
