/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.transientvalues;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TransientValuesTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(TransientValuesTestStandaloneSetup.class);
	}
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Test public void testRequired1() throws Exception {
		final String model = "test required 1 1";
		EObject m = getModel(model);
		// System.out.println(EmfFormater.objToStr(m, ""));
		String s = serialize(m);
		assertEquals(model, s);
	}

	@Test public void testOptional1() throws Exception {
		final String in = "test optional 12";
		final String out = "test optional";
		String s = serialize(getModel(in));
		assertEquals(out, s);
	}

	@Test public void testOptional2() throws Exception {
		final String in = "test optional 12:13";
		final String out = "test optional";
		String s = serialize(getModel(in));
		assertEquals(out, s);
	}

	@Test public void testList() throws Exception {
		final String in = "test list 1 2 3 4 5 6";
		final String out = "test list 1 3 5";
		String s = serialize(getModel(in)).trim();
		assertEquals(out, s);
	}
}
