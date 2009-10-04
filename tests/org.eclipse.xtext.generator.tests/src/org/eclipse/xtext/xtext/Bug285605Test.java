/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug285605Test extends AbstractXtextTests implements ValidationMessageAcceptor {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	public void testBug285605() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"\n" + 
				"A: B;\n" + 
				"\n" + 
				"C: A | B;\n" + 
				"\n" + 
				"B: D;\n" + 
				"\n" + 
				"D: {D};";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		GrammarWithoutLeftRecursionInspector inspector = new GrammarWithoutLeftRecursionInspector(this);
		inspector.inspect(grammar);
	}

	public void acceptError(String message, EObject object, Integer feature, Integer code) {
		fail(message);
	}

	public void acceptWarning(String message, EObject object, Integer feature, Integer code) {
		fail(message);
	}
	
}
