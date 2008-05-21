/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.parser.ComplexReconstrTestASTFactory;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class ComplexReconstrTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ComplexReconstrTestStandaloneSetup.doSetup();
		with(ComplexReconstrTestLanguageFacade.LANGUAGE_ID);
	}

	public void testSimple() throws Exception {
		String model = "( a + b - c ) !";
		assertEquals(model,parseAndSerialize(model));
	}
	
	public void testComplex() throws Exception {
		String model = "( ( a + b ) ! - c + d + e + f - ( x + s ) - ( ( a + b ) ! - c ) ! ) !";
		assertEquals(model,parseAndSerialize(model));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = (EObject) getModel(model,new ComplexReconstrTestASTFactory());
		ComplexReconstrTestParseTreeConstructor con = new ComplexReconstrTestParseTreeConstructor();
		con.update(result);
		String resultString = con.getText();
		return resultString;
	}
}
