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
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XpressionStandaloneSetup;
import org.eclipse.xtext.xpression.XExpression;

/**
 * @author Sven Efftinge
 *
 */
public abstract class AbstractXbaseTestCase extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XpressionStandaloneSetup());
	}

	protected XExpression expression(String string) throws IOException {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.xpression"));
		resource.load(new StringInputStream(string), null);
		XExpression exp = (XExpression) resource.getContents().get(0);
		return exp;
	}

}