/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Moritz Eysholdt 
 * @author Jan Koehnlein
 */
public class PartialSerializationTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(PartialSerializationTestLanguageStandaloneSetup.class);
	}

	private String doSerialize(EObject obj) {
		return getSerializer().serialize(obj, SaveOptions.defaultOptions());
	}

	@Test public void testSimple() throws Exception {
		String model = " #1  node  test  (  node  subnode  )";
		NodeRoot root = (NodeRoot) getModel(model);
		assertEquals("node  test  (  node  subnode  )", doSerialize(root.getNode()));
	}

	@Test public void testSimpleSurroundComments1() throws Exception {
		String model = "/* x1 */ #1 /* x2 */ node /* x3 */ test  (  node  subnode /* x4 */ ) /* x5 */";
		NodeRoot root = (NodeRoot) getModel(model);
		assertEquals(model, doSerialize(root));
	}

	@Test public void testSimpleSurroundComments2() throws Exception {
		String model = "/* x1 */ #1 /* x2 */ node /* x3 */ test  (  node  subnode /* x4 */ ) /* x5 */";
		NodeRoot root = (NodeRoot) getModel(model);
		assertEquals("/* x2 */ node /* x3 */ test  (  node  subnode /* x4 */ ) /* x5 */", doSerialize(root.getNode()));
	}

	@Test public void testSimpleSurroundComments3() throws Exception {
		String model = "/* x1 */ #1 /* x2 */ node /* x3 */ test /* x4 */  ( /* x5 */ node /* x6 */ subnode /* x7 */ ) /* x8 */";
		NodeRoot root = (NodeRoot) getModel(model);
		String ser = doSerialize(root.getNode().getChildren().get(0));
		assertEquals("/* x5 */ node /* x6 */ subnode", ser);
	}

}
