/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.validation.AbstractValidationMessageAcceptingTestCase;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug285605Test extends AbstractValidationMessageAcceptingTestCase {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	@Test public void testBug285605() throws Exception {
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

}
