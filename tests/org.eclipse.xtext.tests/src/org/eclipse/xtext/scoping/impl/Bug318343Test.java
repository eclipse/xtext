/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class Bug318343Test extends AbstractXtextTests {
	
	private DefaultGlobalScopeProvider globalScopeProvider;
	private Resource resource1;
	private Resource resource2;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
		globalScopeProvider = get(DefaultGlobalScopeProvider.class);
		XtextResourceSet xtextResourceSet = get(XtextResourceSet.class);
		resource1 = xtextResourceSet.createResource(URI.createURI("uri1.langatestlanguage"));
		resource2 = xtextResourceSet.createResource(URI.createURI("uri2.langatestlanguage"));
		resource1.load(new StringInputStream("type t1"),null);
		resource2.load(new StringInputStream("type t2"),null);
	}

	public void testScopeContainsT1() throws Exception {
		IScope scope = globalScopeProvider.getScope(resource2.getContents().get(0), LangATestLanguagePackage.Literals.TYPE__EXTENDS);
		assertNotNull(scope.getContentByName("t1"));
	}
	
	public void testScopeContainsNotT2() throws Exception {
		IScope scope = globalScopeProvider.getScope(resource2.getContents().get(0), LangATestLanguagePackage.Literals.TYPE__EXTENDS);
		assertNull(scope.getContentByName("t2"));
	}
	@Override
	protected void tearDown() throws Exception {
		resource1 = null;
		resource2 = null;
		globalScopeProvider = null;
		super.tearDown();
		
	}
	
}
