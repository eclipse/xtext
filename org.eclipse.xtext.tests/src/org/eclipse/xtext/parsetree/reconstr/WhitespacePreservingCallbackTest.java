/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

public class WhitespacePreservingCallbackTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ComplexReconstrTestLanguageStandaloneSetup.class);
	}

	@Test public void testSimple() throws Exception {
		check("a");
	}

	@Test public void testHiddenInBetween() throws Exception {
		check("a \t /* foo bar */ + b");
	}

	@Test
	public void testFail1() throws Exception {
		IAstFactory f = getASTFactory();
		failsWith(f.create(ComplexrewritetestPackage.Literals.ADD));
	}

	@Test
	public void testFail2() throws Exception {
		IAstFactory f = getASTFactory();
		EObject add = f.create(ComplexrewritetestPackage.Literals.ADD);

		// one operand INVALID
		EObject atom1 = f.create(ComplexrewritetestPackage.Literals.ATOM);
		f.set(atom1, "name", "x", null, null);
		f.add(add, "addOperands", atom1, null, null);
		failsWith(add);

		// two operands VALID
		EObject atom2 = f.create(ComplexrewritetestPackage.Literals.ATOM);
		f.set(atom2, "name", "x", null, null);
		f.add(add, "addOperands", atom2, null, null);
		assertNotNull(serialize(add));

		// three operands INVALID
		EObject atom3 = f.create(ComplexrewritetestPackage.Literals.ATOM);
		f.set(atom3, "name", "x", null, null);
		f.add(add, "addOperands", atom3, null, null);
		failsWith(add);
	}

	private void check(String m1) throws Exception {
		assertEquals(m1, parseAndSerialize(m1));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = getModel(model);
		return getSerializer().serialize(result, SaveOptions.defaultOptions());
	}

	private void failsWith(EObject o) {
		try {
			get(ISerializer.class).serialize(o);
			fail("Should fail with RuntimeException");
		} catch (RuntimeException e) {
			// Test successful
		}
	}
}
