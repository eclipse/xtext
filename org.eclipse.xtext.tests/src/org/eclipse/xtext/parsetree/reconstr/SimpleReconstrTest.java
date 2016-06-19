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
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

public class SimpleReconstrTest extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}

	@Test public void testSimple1() throws Exception {
		String model = "a b";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimple2() throws Exception {
		String model = "( a b ) !";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testFollowingHiddenTokens() throws Exception {
		String model = "a ";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testComplex() throws Exception {
		String model = "( ( a b ) ! c  d e  f (  x s ) ( \t ( a \n\rb/*ffo \n bar */ ) ! c ) ! ) //holla\n!";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testComplex1() throws Exception {
		String model = "(a b) //holla\n!";
		assertEquals(model, parseAndSerialize(model));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = getModel(model);
		//		if (logger.isTraceEnabled()) {
		//			System.out.println(EmfFormatter.objToStr(result));
		//			System.out.println(EmfFormatter.objToStr(NodeUtil.getRootNode(result)));
		//			logger.trace(EmfFormatter.objToStr(NodeUtil.getRootNode(result).getLeafNodes()));
		//		}
		return getSerializer().serialize(result, SaveOptions.defaultOptions());
	}

	@Test public void testSimpleExpressions5() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "a + b - c * d / e";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleExpressions1() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "a + b - c";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleExpressions3() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "a + (b - c)";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTwoNumbers() throws Exception {
		String model = "2 45";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTwoNumbersWithDefault() throws Exception {
		String model = "0 45";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTwoNumbersWithDefault2() throws Exception {
		String model = "0 45 # 0 # 1 # 2";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleManyStrings1() throws Exception {
		String model = "= \"xxx\" \"yyy\"";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleManyStrings2() throws Exception {
		String model = "= \"xxx\" \"yyy\" \"zzzz\"";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleAlternativeAssignment1() throws Exception {
		String model = "#2 mykeyword1";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleAlternativeBoolTrue() throws Exception {
		String model = "#4 myoption kw blupp";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleAlternativeBoolFalse() throws Exception {
		String model = "#4 kw blupp";
		assertEquals(model, parseAndSerialize(model));
	}

	// FIXME: This depends on
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=275855
	public void _testSimpleTransient101() throws Exception {
		String model = "#5 0";
		assertEquals(model, parseAndSerialize(model));
	}

	// FIXME: This depends on
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=275855
	public void _testSimpleTransient102() throws Exception {
		String model = "#5 1";
		assertEquals(model, parseAndSerialize(model));
	}

	// FIXME: This depends on
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=275855
	public void _testSimpleTransient103() throws Exception {
		String model = "#5 *";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient104() throws Exception {
		String model = "#5 *, 0";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient105() throws Exception {
		String model = "#5 *, 1";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient106() throws Exception {
		String model = "#5 *, *";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient107() throws Exception {
		String model = "#5 0, 0";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient108() throws Exception {
		String model = "#5 0, 1";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient109() throws Exception {
		String model = "#5 0, *";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient110() throws Exception {
		String model = "#5 1, 0";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient111() throws Exception {
		String model = "#5 1, 1";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSimpleTransient112() throws Exception {
		String model = "#5 1, *";
		assertEquals(model, parseAndSerialize(model));
	}

	// FIXME: this depends on
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=250313
	@Test public void testSimpleAlternativeAssignment2() throws Exception {
		String model = "#2 \"str\"";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testCrossRef() throws Exception {
		String model = "type A extends B type B extends A";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testSpare() throws Exception {
		String model = "#3 foo1";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testConsume11() throws Exception {
		String model = "#6 v1 1 2 a";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testConsume12() throws Exception {
		String model = "#6 v2 a b 2";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testConsume21() throws Exception {
		String model = "#7 #6 v1 1 2 a";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testConsume22() throws Exception {
		String model = "#7 #6 v2 a b 2";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testLoop1() throws Exception {
		String model = "kw0 #8 abc kw1 ab kw30";
		assertEquals("#8 abc ab kw30", parseAndSerialize(model));
	}

	@Test public void testLoop2() throws Exception {
		String model = "#9 abc adad kw2 kw3 kw6";
		assertEquals("#9 abc kw1 adad kw4 kw5", parseAndSerialize(model));
	}

	@Test public void testLoop3() throws Exception {
		String model = "kw3 #10 adad kw4 abcde kw5 kw4 abc kw5";
		assertEquals("kw1 #10 adad kw4 abcde kw5 kw4 abc kw5", parseAndSerialize(model));
	}

	@Test public void testLoop4() throws Exception {
		String model = "#11 kw2 asd kw5 kw6";
		assertEquals("#11 kw1 asd kw5", parseAndSerialize(model));
	}

	@Test public void testLoopBug285452a() throws Exception {
		String model = "#12 interface test";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testLoopBug285452b() throws Exception {
		String model = "#12 class test";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testDuplicateBug284491() throws Exception {
		String model = "#13 final static";
		assertEquals(model, parseAndSerialize(model));
	}

	public void _testEmptyObjectBug284850() throws Exception {
		String model = "#14 item test";
		EmptyObjectBug284850 result = (EmptyObjectBug284850) getModel(model);
		result.getItems().getList().clear();
		//		System.out.println(EmfFormatter.objToStr(result));
		String actual = getSerializer().serialize(result, SaveOptions.defaultOptions());
		assertEquals(model, actual);
	}

	@Test public void testMultiInheritanceBug280439() throws Exception {
		String model = "#15 a b";
		EObject result = getModel(model);
		assertEquals(model, getSerializer().serialize(result, SaveOptions.defaultOptions()));
	}

	@Test public void testEObjectRef() throws Exception {
		String model = "#16 obj refs obj";
		EObject result = getModel(model);
		assertEquals(model, getSerializer().serialize(result, SaveOptions.defaultOptions()));
	}

	@Test public void testTypeBug305577a() throws Exception {
		String model = "#17 ka foo";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testTypeBug305577b() throws Exception {
		String model = "#17 kb foo";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testTypeBug305577c() throws Exception {
		String model = "#18 ka foo";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testTypeBug305577d() throws Exception {
		String model = "#17 kb foo";
		assertEquals(model, parseAndSerialize(model));
	}

	@Test public void testBug305171() throws Exception {
		String model = "#19 kx a,b ky c,d foo";
		assertEquals(model, parseAndSerialize(model));

		model = "#19 ky c,d foo";
		assertEquals(model, parseAndSerialize(model));

		model = "#19 kx a,b foo";
		assertEquals(model, parseAndSerialize(model));

		model = "#19 foo";
		assertEquals(model, parseAndSerialize(model));

		model = "#19 kx a ky c foo";
		assertEquals(model, parseAndSerialize(model));

		model = "#19 kx a ky c kz d foo";
		assertEquals(model, parseAndSerialize(model));

		model = "#19 kz d foo";
		assertEquals(model, parseAndSerialize(model));
	}
	
	@Test public void testEnumBug310435Enum() throws Exception {
		String model = "#20 kw1 lit1 kw2 lit2 kw1 lit1 kw2 lit2 kw1 lit1 kw2 lit2";
		assertEquals(model, parseAndSerialize(model));
	}
	
	@Test public void testEnumBug310435Val() throws Exception {
		String model = "#21 kw2 '234' kw1 foo kw2 '[]' kw1 bar";
		assertEquals(model, parseAndSerialize(model));
	}
	
	@Test public void testRefnameTest() throws Exception {
		String model = "#22 id1 id2 ID3 ID4 kw1 kw2 id1 kw3 ID3 kw2 id2 kw3 ID4";
		assertEquals(model, parseAndSerialize(model));
	}


	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleReconstrTestLanguageStandaloneSetup.class);
	}
}
