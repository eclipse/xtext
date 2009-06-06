/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class SerializationErrorTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SerializationErrorTestLanguageStandaloneSetup.class);
	}

	private TreeConstructionReport ser(EObject obj) throws IOException {
		TokenStringBuffer b = new TokenStringBuffer();
		TreeConstructionReport r;
		try {
			r = getSerializer().serialize(obj, b, null, true);
		} catch (XtextSerializationException e) {
			r = e.getReport();
		}
		// System.out.println("Result:");
		// System.out.println(r);
		// System.out.println();
		// String path = "tmp/" + getName() + ".pdf";
		// new TraceToDot().draw(r, path, "-T pdf");
		return r;
	}

	public void testMissingElement() throws Exception {
		Model m = (Model) getModel("tworequired a b");
		// System.out.println(EmfFormatter.objToStr(m));
		((TwoRequired) m.getTest()).setOne(null);
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		assertEquals(2, r.getLikelyErrorReasons().size());
		assertTrue(r.toString(), r.getLikelyErrorReasons().get(0).contains(
				"Test(TwoRequired).one is not set"));
	}

	public void testElementToMuch() throws Exception {
		Model m = (Model) getModel("twooptions one a");
		// System.out.println(EmfFormatter.objToStr(m));
		((TwoOptions) m.getTest()).setTwo("b");
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		assertTrue(r.toString(), r.getLikelyErrorReasons().get(0).contains(
				"Can not leave rule 'Parenthesis' "
						+ "since the current object "
						+ "'TwoOptions' has features with "
						+ "unconsumed values: 'two':1"));

	}
}
