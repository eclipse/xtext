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
import org.eclipse.xtext.parsetree.reconstr.callbacks.SimpleSerializingCallback;
import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class SimpleReconstrTest extends AbstractGeneratorTest {
	
	public void testSimple() throws Exception {
	    with(SimpleReconstrTestStandaloneSetup.class);
	    String model = "( a b ) !";
		assertEquals(model,parseAndSerialize(model));
	}
	
	public void testComplex() throws Exception {
	    with(SimpleReconstrTestStandaloneSetup.class);
	    String model = "( ( a b ) ! c d e f ( x s ) ( ( a b ) ! c ) ! ) !";
		assertEquals(model,parseAndSerialize(model));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = (EObject) getModel(model);
		IParseTreeConstructor con = getParseTreeConstructor();
		SimpleSerializingCallback callback = new SimpleSerializingCallback(getValueConverterService());
		con.update(result, callback);
		return callback.toString();
	}
	
	public void testSimpleExpressions() throws Exception {
		with(SimpleExpressionsStandaloneSetup.class);
		String model = "a + b - c * d / e";
		assertEquals(model,parseAndSerialize(model));
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
}
