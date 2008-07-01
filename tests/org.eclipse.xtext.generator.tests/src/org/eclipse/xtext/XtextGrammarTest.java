/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.XtextGrammarTestParseTreeConstructor;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextGrammarTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextGrammarTestStandaloneSetup.class);
	}
	
	public void testInstantiate() throws Exception {
		EObject grammar = (EObject) getModel("language foo generate foo 'bar' Foo : name=ID;");
		assertWithXtend("'Foo'","parserRules.first().name",grammar);
		assertWithXtend("'name'","parserRules.first().alternatives.feature",grammar);
	}
	
	public void testSerialization() throws Exception {
		String model = "generate foo 'bar' Foo : ( 'stuff' '{' '}' STRING ) ? ;";
		EObject grammar = (EObject) getModel(model);
		XtextGrammarTestParseTreeConstructor ptc = (XtextGrammarTestParseTreeConstructor) getParseTreeConstructor();
		ptc.update(grammar);
		assertEquals(model, NodeUtil.getNodeAdapter(grammar).getParserNode().serialize());
	}

}
