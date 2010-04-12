/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseLinkingWithNamespaceImportsTest extends AbstractIgnoreCaseLinkingTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(IgnoreCaseNamespacesTestLanguageStandaloneSetup.class);
	}
	
	@Override
	public void testWithImports() throws Exception {
		String input = "'b.*' a C { b a { c B {} c a {} } }";
		getModel(input);
	}
	
	public void testWithImportsIgnoreCase() throws Exception {
		String input = "'B.*' a C { b a { c B {} c a {} } }";
		getModel(input);
	}
	
}
