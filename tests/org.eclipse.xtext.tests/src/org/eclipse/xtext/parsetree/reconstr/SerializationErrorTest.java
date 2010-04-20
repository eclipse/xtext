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
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.SerializerUtil.SerializationOptions;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired;

public class SerializationErrorTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SerializationErrorTestLanguageStandaloneSetup.class);
	}

	private TreeConstructionReport ser(EObject obj) throws IOException {
		TokenStringBuffer b = new TokenStringBuffer();
		TreeConstructionReport r;
		try {
			SerializationOptions opt = new SerializationOptions();
			opt.setFormat(true);
			opt.setValidateConcreteSyntax(false);
			r = getSerializer().serialize(obj, b, opt);
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
		// assertEquals(2, r.getLikelyErrorReasons(3).size());
		// assertTrue(r.toString(), r.getLikelyErrorReasons(1).get(0).contains(
		// "Test(TwoRequired).one is not set"));
		assertTrue(r.toString(), r.toString().contains(
				"TwoRequired.one is not set"));
	}

	public void testElementToMuch() throws Exception {
		Model m = (Model) getModel("twooptions one a");
		// System.out.println(EmfFormatter.objToStr(m));
		((TwoOptions) m.getTest()).setTwo("b");
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		assertTrue(r.toString(), r.toString().contains(
				"Can not leave rule 'Parenthesis' "
						+ "since the current object "
						+ "'TwoOptions' has features with "
						+ "unconsumed values: 'two':1"));
		// assertTrue(r.toString(), r.getLikelyErrorReasons(1).get(0).contains(
		// "Can not leave rule 'Parenthesis' "
		// + "since the current object "
		// + "'TwoOptions' has features with "
		// + "unconsumed values: 'two':1"));

	}

	public void testDeepToMuch() throws Exception {
		Model m = (Model) getModel("{ twooptions one a { twooptions one a { twooptions one a }}}");
		// System.out.println(EmfFormatter.objToStr(m));
		Indent i = ((Indent) m.getTest()).getIndent().get(0).getIndent().get(0);
		i.getOpt().setTwo("b");
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		String msg = r.toString();
		assertTrue(msg, msg.contains("Model {"));
		assertTrue(msg, msg.contains("indent[0] = Indent"));
		assertTrue(msg, msg.contains("Can not leave rule 'TwoOptions' "
				+ "since the current object "
				+ "'TwoOptions' has features with "
				+ "unconsumed values: 'two':1"));
	}
}
