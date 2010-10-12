/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.css.tests;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.example.css.XcssStandaloneSetup;
import org.eclipse.xtext.example.css.xcss.StyleRule;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge
 *
 */
public abstract class AbstractXcssTestCase extends TestCase {
	
	static Injector injector = new XcssStandaloneSetup().createInjectorAndDoEMFRegistration();

	@Override
	protected void setUp() throws Exception {
		getInjector().injectMembers(this);
	}
	
	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}
	
	protected StyleSheet styleSheet(String string) throws IOException {
		XtextResourceSet set = get(XtextResourceSet.class);
		Resource resource = set.createResource(URI.createURI("Test.xcss"));
		resource.load(new StringInputStream(string), null);
		assertTrue("Errors"+resource.getErrors(), resource.getErrors().isEmpty());
		StyleSheet sheet = (StyleSheet) resource.getContents().get(0);
		return sheet;
	}
	
	protected StyleRule rule(String string) throws IOException {
		return styleSheet(string).getRules().get(0);
	}

}