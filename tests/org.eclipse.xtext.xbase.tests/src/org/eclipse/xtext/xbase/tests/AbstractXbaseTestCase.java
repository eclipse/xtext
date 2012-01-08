/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.junit.Assert;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge
 * 
 */
public abstract class AbstractXbaseTestCase extends Assert {

	public static class SynchronizedXtextResourceSetProvider implements Provider<SynchronizedXtextResourceSet> {

		@Inject
		private ClassLoader classLoader;
		
		@Inject
		private IJvmTypeProvider.Factory typeProviderFactory;
		
		public SynchronizedXtextResourceSet get() {
			SynchronizedXtextResourceSet result = new SynchronizedXtextResourceSet();
			result.setClasspathURIContext(classLoader);
			typeProviderFactory.findOrCreateTypeProvider(result);
			return result;
		}
		
	}
	
	static Injector injector = new XbaseStandaloneSetup() {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new org.eclipse.xtext.xbase.XbaseRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXbaseTestCase.class.getClassLoader();
				}
				@SuppressWarnings("unused")
				public Class<? extends Provider<SynchronizedXtextResourceSet>> provideSynchronizedResourceSet() {
					return SynchronizedXtextResourceSetProvider.class;
				}
			});
		}
	}.createInjectorAndDoEMFRegistration();

	@Before
	public void setUp() throws Exception {
		getInjector().injectMembers(this);
	}

	public Injector getInjector() {
		return injector;
	}

	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XExpression expression(String string) throws Exception {
		return expression(string, false);
	}

	@Inject
	private ParseHelper<XExpression> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	protected XExpression expression(String string, boolean resolve) throws Exception {
		XExpression parse = parseHelper.parse(string);
		if (resolve)
			validationHelper.assertNoErrors(parse);
		return parse;
	}

	protected Resource newResource(String input) throws IOException {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.___xbase"));
		resource.load(new StringInputStream(input), null);
		return resource;
	}

}