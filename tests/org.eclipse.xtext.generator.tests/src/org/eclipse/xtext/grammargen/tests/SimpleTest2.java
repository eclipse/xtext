/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammargen.tests;

import java.util.List;

import org.antlr.runtime.CommonToken;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.generator.tests.Invocation;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class SimpleTest2 extends AbstractGeneratorTest {
	
	public void testFoo() throws Exception {
		List<Invocation> parse = parse("keyword bla 3 {}");
		assertEquals("create", parse.get(0).method);
		assertEquals("Child", parse.get(0).feature);

		assertEquals("set", parse.get(1).method);
		assertEquals("name", parse.get(1).feature);
		assertEquals("bla", ((CommonToken)parse.get(1).param).getText());
		
		assertEquals("set", parse.get(2).method);
		assertEquals("number", parse.get(2).feature);
		assertEquals("3", ((CommonToken)parse.get(2).param).getText());
		
		assertEquals("create", parse.get(3).method);
		assertEquals("Model", parse.get(3).feature);
		
		assertEquals("add", parse.get(4).method);
		assertEquals("contents", parse.get(4).feature);
		assertEquals("Child",((EClass)parse.get(4).param).getName());
	}
	
	
	
	
}
