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
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XExpression;
import org.junit.Assert;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public abstract class AbstractXbaseTestCase extends Assert {

	@Inject
	private Injector injector;

	public Injector getInjector() {
		return injector;
	}

	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected XExpression expression(CharSequence string) throws Exception {
		return expression(string, false);
	}

	@Inject
	private ParseHelper<XExpression> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;

	protected XExpression expression(CharSequence string, boolean resolve) throws Exception {
		XExpression parse = parseHelper.parse(string);
		if (resolve)
			validationHelper.assertNoErrors(parse);
		return parse;
	}

	protected Resource newResource(CharSequence input) throws IOException {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.___xbase"));
		resource.load(new StringInputStream(input.toString()), null);
		return resource;
	}

}