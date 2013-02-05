/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EvaluationCompilerTestWithNewTypeSystem extends EvaluationCompilerTest {

	@Override
	@Test 
	@Ignore("Wrong type")
	public void testReturnExpression_07() throws Exception {
		assertEvaluatesTo(null, "return if (true) while(false) ('foo'+'bar').length else null");
		assertEvaluatesTo(null, "return if (false) while(false) ('foo'+'bar').length else null");
	}
	
	@Override
	@Test 
	@Ignore("Wrong type")
	public void testReturnExpression_08() throws Exception {
		assertEvaluatesTo(null, "return if (true) while(false) ('foo'+'bar').length else 'zonk'");
		assertEvaluatesTo("zonk", "return if (false) while(false) ('foo'+'bar').length else 'zonk'");
	}
	
	// re-enabled
	@Override
	@Test
	public void testBlock_01() throws Exception {
		super.testBlock_01();
	}
	
	// re-enabled
	@Override
	@Test
	public void testBlock_02() throws Exception {
		super.testBlock_02();
	}
	
	// re-enabled
	@Override
	@Test
	public void testForLoop_16() throws Exception {
		super.testForLoop_16();
	}

	// re-enabled
	@Override
	@Test
	public void testCollectionExtensions_08() throws Exception {
		super.testCollectionExtensions_08();
	}
	
	// re-enabled
	@Override
	@Test
	public void testCollectionExtensions_09() throws Exception {
		super.testCollectionExtensions_09();
	}
	
	// re-enabled
	@Override
	@Test
	public void testCollectionExtensions_10() throws Exception {
		super.testCollectionExtensions_10();
	}
	
	@Override
	@Test
	public void testMapValuesExtension() throws Exception {
		super.testMapValuesExtension();
	}
	
	@Override
	@Test
	public void testReduceWithPlusOperator() throws Exception {
		super.testReduceWithPlusOperator();
	}
	
	// TODO move to AbstractXbaseEvaluationTests
	@Test public void testClosure_07_02() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"new testdata.ClosureClient().useProvider(null as =>String[])");
	}
	
	// TODO move to AbstractXbaseEvaluationTests
	@Test public void testClosure_07_03() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"new testdata.ClosureClient().useSupplier(null as =>Iterable<? extends String[]>[])");
	}
	
	// TODO move to AbstractXbaseEvaluationTests
	@Test public void testClosure_07_04() throws Exception {
		assertEvaluatesWithException(NullPointerException.class, 
				"new testdata.ClosureClient().invoke0(null as =>String[])");
	}
	
	// TODO move to AbstractXbaseEvaluationTests
	@Override
	@Test public void testSwitchExpression_21() throws Exception {
		assertEvaluatesTo(Character.valueOf('b'), 
				"{\n" + 
				"    val Comparable<?> c = 'abc'\n" + 
				"    switch c {\n" + 
				"        CharSequence: switch(c) {\n" + 
				"             java.io.Serializable: {\n" + 
				"                 c.charAt(1)\n" + 
				"             }\n" + 
				"         }\n" + 
				"    }\n" + 
				"}");
	}
	
	@Override
	@Test
	@Ignore("To be implemented later")
	public void testImplicitOneArgClosure_01() throws Exception {
		super.testImplicitOneArgClosure_01();
	}
	
}
