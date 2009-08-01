/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.EmfFormatter;

public class SimpleReconstrTest extends AbstractGeneratorTest {

	private static final Logger logger = Logger
			.getLogger(SimpleReconstrTest.class);

	public void testSimple1() throws Exception {
		String model = "a b";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimple2() throws Exception {
		String model = "( a b ) !";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testFollowingHiddenTokens() throws Exception {
		String model = "a ";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testComplex() throws Exception {
		String model = "( ( a b ) ! c  d e  f (  x s ) ( \t ( a \n\rb/*ffo \n bar */ ) ! c ) ! ) //holla\n!";
		assertEquals(model, parseAndSerialize(model));
	}

	private String parseAndSerialize(String model) throws Exception {
		EObject result = getModel(model);
		if (logger.isTraceEnabled()) {
			logger.trace(EmfFormatter.objToStr(result));
			logger.trace(EmfFormatter.objToStr(NodeUtil.getRootNode(result)));
			logger.trace(EmfFormatter.objToStr(NodeUtil.getRootNode(result)
					.getLeafNodes()));
		}
		return getSerializer().serialize(result, false);
	}

	public void testSimpleExpressions5() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "a + b - c * d / e";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleExpressions1() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "a + b - c";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTwoNumbers() throws Exception {
		String model = "2 45";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTwoNumbersWithDefault() throws Exception {
		String model = "0 45";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTwoNumbersWithDefault2() throws Exception {
		String model = "0 45 # 0 # 1 # 2";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleManyStrings1() throws Exception {
		String model = "= \"xxx\" \"yyy\"";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleManyStrings2() throws Exception {
		String model = "= \"xxx\" \"yyy\" \"zzzz\"";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleAlternativeAssignment1() throws Exception {
		String model = "#2 mykeyword1";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleAlternativeBoolTrue() throws Exception {
		String model = "#4 myoption kw blupp";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleAlternativeBoolFalse() throws Exception {
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

	public void testSimpleTransient104() throws Exception {
		String model = "#5 *, 0";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient105() throws Exception {
		String model = "#5 *, 1";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient106() throws Exception {
		String model = "#5 *, *";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient107() throws Exception {
		String model = "#5 0, 0";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient108() throws Exception {
		String model = "#5 0, 1";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient109() throws Exception {
		String model = "#5 0, *";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient110() throws Exception {
		String model = "#5 1, 0";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient111() throws Exception {
		String model = "#5 1, 1";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSimpleTransient112() throws Exception {
		String model = "#5 1, *";
		assertEquals(model, parseAndSerialize(model));
	}

	// FIXME: this depends on
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=250313
	public void testSimpleAlternativeAssignment2() throws Exception {
		String model = "#2 \"str\"";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testCrossRef() throws Exception {
		String model = "type A extends B type B extends A";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testSpare() throws Exception {
		String model = "#3 id1";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testConsume11() throws Exception {
		String model = "#6 v1 1 2 a";
		assertEquals(model, parseAndSerialize(model));
	}

	public void testConsume12() throws Exception {
		String model = "#6 v2 a b 2";
		assertEquals(model, parseAndSerialize(model));
	}
	
	public void testConsume21() throws Exception {
		String model = "#7 #6 v1 1 2 a";
		assertEquals(model, parseAndSerialize(model));
	}
	
	public void testConsume22() throws Exception {
		String model = "#7 #6 v2 a b 2";
		assertEquals(model, parseAndSerialize(model));
	}
	
	public void testLoop1() throws Exception {
		String model = "kw0 #8 abc kw1 ab kw30";
		assertEquals(" #8 abc  ab kw30", parseAndSerialize(model));
	}
	
	public void testLoop2() throws Exception {
		String model = "#9 abc adad kw2 kw3 kw6";
		assertEquals("#9 abc kw1 adad kw4 kw5    ", parseAndSerialize(model));
	}
	
	public void testLoop3() throws Exception {
		String model = "kw3 #10 adad kw4 abcde kw5 kw4 abc kw5";
		assertEquals("kw1 #10 adad kw4 abcde kw5 kw4 abc kw5", parseAndSerialize(model));
	}
	
	public void testLoop4() throws Exception {
		String model = "#11 kw2 asd kw5 kw6";
		assertEquals("#11 kw1  asd kw5 ", parseAndSerialize(model));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SimpleReconstrTestLanguageStandaloneSetup.class);
	}
}
