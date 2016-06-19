/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Bug318343Test extends AbstractXtextTests {
	
	private DefaultGlobalScopeProvider globalScopeProvider;
	private Resource resource1;
	private Resource resource2;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
		globalScopeProvider = get(DefaultGlobalScopeProvider.class);
		XtextResourceSet xtextResourceSet = get(XtextResourceSet.class);
		resource1 = xtextResourceSet.createResource(URI.createFileURI(new File("uri1.langatestlanguage").getAbsolutePath()));
		resource2 = xtextResourceSet.createResource(URI.createFileURI(new File("uri2.langatestlanguage").getAbsolutePath()));
		resource1.load(new StringInputStream("type t1"),null);
		resource2.load(new StringInputStream("type t2"),null);
	}

	@Test public void testScopeContainsT1() throws Exception {
		IScope scope = globalScopeProvider.getScope(resource2, LangATestLanguagePackage.Literals.TYPE__EXTENDS);
		assertNotNull(scope.getSingleElement(QualifiedName.create("t1")));
	}
	
	@Test public void testScopeContainsNotT2() throws Exception {
		IScope scope = globalScopeProvider.getScope(resource2, LangATestLanguagePackage.Literals.TYPE__EXTENDS);
		assertNull(scope.getSingleElement(QualifiedName.create("t2")));
	}
	@Override
	public void tearDown() throws Exception {
		resource1 = null;
		resource2 = null;
		globalScopeProvider = null;
		super.tearDown();
		
	}
	
}
