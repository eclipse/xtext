/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.annotations;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsStandaloneSetup;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.junit.Assert;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractXbaseWithAnnotationsTest extends Assert {
	
	static Injector injector = new XbaseWithAnnotationsStandaloneSetup() {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXbaseWithAnnotationsTest.class.getClassLoader();
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

	@Inject
	private ParseHelper<XAnnotation> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	protected XAnnotation annotation(String string, boolean resolve) throws Exception {
		XAnnotation parse = parseHelper.parse(string);
		if (resolve)
			validationHelper.assertNoErrors(parse);
		return parse;
	}

	protected Resource newResource(String input) throws IOException {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.___xbasewithannotations"));
		resource.load(new StringInputStream(input), null);
		return resource;
	}
}
