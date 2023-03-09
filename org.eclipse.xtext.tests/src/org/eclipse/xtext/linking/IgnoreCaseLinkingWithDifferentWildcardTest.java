/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseLinkingWithDifferentWildcardTest extends AbstractIgnoreCaseLinkingTest {

	public static class OtherWildcardLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
		@Override
		public String getWildCard() {
			return "all";
		}
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IgnoreCaseNamespacesTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new IgnoreCaseNamespacesTestLanguageRuntimeModule() {
					@Override
					public void configureIScopeProviderDelegate(Binder binder) {
						binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(OtherWildcardLocalScopeProvider.class);
					}
				});
			}
		});
	}
	
	@Override
	@Test public void testWithImports() throws Exception {
		String input = "'a.b.all' a C { b a { c B {} d a {} } }";
		getModel(input);
	}
	
	@Test public void testWithImportsIgnoreCase_01() throws Exception {
		String input = "'A.B.all' a C { b a { c B {} d a {} } }";
		getModel(input);
	}
	
	@Test public void testWithImportsIgnoreCase_02() throws Exception {
		String input = "'A.B.ALL' a C { b a { c B {} d a {} } }";
		getModel(input);
	}
	
	@Test public void testWithImportsIgnoreCase_03() throws Exception {
		String input = "'a.b.ALL' a C { b a { c B {} d a {} } }";
		getModel(input);
	}
	
}
