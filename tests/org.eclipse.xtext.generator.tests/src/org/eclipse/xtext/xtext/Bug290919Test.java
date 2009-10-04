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
public class Bug290919Test extends AbstractXtextTests implements ValidationMessageAcceptor {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	public void testBug2900919() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"\n" + 
				"TModel :\n" + 
				"    element=TElement\n" + 
				";\n" + 
				"\n" + 
				"TElement :\n" + 
				"    TSimpleElement | TSimpleElement2\n" + 
				";\n" + 
				"\n" + 
				"TSimpleElement:\n" + 
				"(annotations+=TAnnotation)*\n" + 
				"'simpleElement' name=ID\n" + 
				";\n" + 
				"\n" + 
				"TSimpleElement2:\n" + 
				"(annotations+=TAnnotation)*\n" + 
				"'simpleElement2' name=ID ;\n" + 
				"\n" + 
				"\n" + 
				"TAnnotation:\n" + 
				"    TDescriptionAnnotation | TUuidAnnotation\n" + 
				";\n" + 
				"\n" + 
				"TDescriptionAnnotation:\n" + 
				"    value = STRING \n" + 
				";\n" + 
				"\n" + 
				"TUuidAnnotation:\n" + 
				"    value = INT\n" + 
				";";
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
