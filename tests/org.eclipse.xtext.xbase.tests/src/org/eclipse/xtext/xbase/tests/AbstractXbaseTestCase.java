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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.CustomXbaseStandaloneSetup;
import org.eclipse.xtext.xbase.XFile;
import org.eclipse.xtext.xbase.XFunction;
import org.eclipse.xtext.xpression.XExpression;

import com.google.inject.Injector;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge
 *
 */
public abstract class AbstractXbaseTestCase extends TestCase {

	public AbstractXbaseTestCase() {
		super();
	}

	public AbstractXbaseTestCase(String name) {
		super(name);
	}
	
	protected Injector injector;

	@Override
	protected void setUp() throws Exception {
		injector = new CustomXbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	/**
	 * @param expr
	 */
	protected void log(EObject expr) {
		System.out.println(EmfFormatter.objToStr(expr));
	}

	protected XExpression expression(String string) throws IOException {
		String text = "foo() : " + string + ";";
		XFunction function = function(text);
		return function.getExpression();
	}

	/**
	 * @param model
	 * @return
	 * @throws IOException
	 */
	protected XFunction function(String model) throws IOException {
		String text = "class X {" + model + "}";
		XFile file = file(text);
		return (XFunction) file.getClasses().get(0).getMembers().get(0);
	}
	
	protected XFile file(String model) throws IOException {
		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.xbase"));
		resource.load(new StringInputStream(model), null);
		XFile file = (XFile) resource.getContents().get(0);
		assertTrue(resource.getErrors().toString(), resource.getErrors()
				.isEmpty());
		return file;
	}

}