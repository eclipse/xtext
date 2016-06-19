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
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class SerializationErrorTest extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SerializationErrorTestLanguageStandaloneSetup.class);
	}

	@SuppressWarnings("deprecation")
	private TreeConstructionReport ser(EObject obj) throws IOException {
		TokenStringBuffer b = new TokenStringBuffer();
		TreeConstructionReport r;
		try {
			r = get(Serializer.class).serialize(obj, b, SaveOptions.newBuilder().format().noValidation().getOptions());
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

	@Test public void testMissingElement() throws Exception {
		Model m = (Model) getModel("tworequired a b");
		// System.out.println(EmfFormatter.objToStr(m));
		((TwoRequired) m.getTest()).setOne(null);
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		// assertEquals(2, r.getLikelyErrorReasons(3).size());
		// assertTrue(r.toString(), r.getLikelyErrorReasons(1).get(0).contains(
		// "Test(TwoRequired).one is not set"));
		assertTrue(r.toString(), r.toString().contains("TwoRequired.one is not set"));
	}

	@Test public void testValueConverterError() throws Exception {
		Model m = (Model) getModel("tworequired a b");
		((TwoRequired) m.getTest()).setOne("|nv4l|d");
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		assertTrue(r.toString(), r.toString().contains("invalid characters"));
	}

	@Test public void testElementTooMuch() throws Exception {
		Model m = (Model) getModel("twooptions one a");
		// System.out.println(EmfFormatter.objToStr(m));
		((TwoOptions) m.getTest()).setTwo("b");
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		assertTrue(
				r.toString(),
				r.toString().contains(
						"Can not leave rule 'Parenthesis' " + "since the current object "
								+ "'TwoOptions' has features with " + "unconsumed values: 'two':1"));
		// assertTrue(r.toString(), r.getLikelyErrorReasons(1).get(0).contains(
		// "Can not leave rule 'Parenthesis' "
		// + "since the current object "
		// + "'TwoOptions' has features with "
		// + "unconsumed values: 'two':1"));

	}

	@Test public void testDeep() throws Exception {
		Model m = (Model) getModel("{ twooptions one a { twooptions one a { twooptions one a }}}");
		// System.out.println(EmfFormatter.objToStr(m));
		Indent i = ((Indent) m.getTest()).getIndent().get(0).getIndent().get(0);
		i.getOpt().setTwo("b");
		TreeConstructionReport r = ser(m);
		assertFalse(r.isSuccess());
		String msg = r.toString();
		assertTrue(
				msg,
				msg.contains("Can not leave rule 'TwoOptions' " + "since the current object "
						+ "'TwoOptions' has features with " + "unconsumed values: 'two':1"));
	}
}
