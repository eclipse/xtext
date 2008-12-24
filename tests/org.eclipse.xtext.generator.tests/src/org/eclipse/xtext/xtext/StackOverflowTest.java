/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StackOverflowTest extends AbstractGeneratorTest {
	
	private String model;
	
	@Override
	protected void setUp() throws Exception {
		model = "language test\n" +
				"import 'http://www.eclipse.org/2008/Xtext'	as xtext\n" +
				"generate test 'http://eclipse.org/xtext/tests/SimpleTest'\n" +
				"Foo : name=ID (nameRefs+=NameRef)*;\n" +
				"NameRef returns xtext::RuleCall : rle=[ParserRule];\n" +
				"MyRule returns xtext::ParserRule : name=ID;";
		with(XtextStandaloneSetup.class);
	}
	
	public void testNoStackOverflow() throws Exception {
		Resource r = getResourceFromString(model);
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());		
		r = getResourceFromString(model);
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());		
	}

}
