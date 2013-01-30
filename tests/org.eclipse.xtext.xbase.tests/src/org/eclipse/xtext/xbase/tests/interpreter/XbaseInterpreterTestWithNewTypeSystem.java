/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
public class XbaseInterpreterTestWithNewTypeSystem extends XbaseInterpreterTest {
	
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
	
	@Override
	@Test
	// re-enabled
	public void testBlock_02() throws Exception {
		super.testBlock_02();
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
	
	// re-enabled
	@Override
	@Test
	public void testForLoop_16() throws Exception {
		super.testForLoop_16();
	}
	
	// re-enabled
	@Override
	@Test public void testClosure_31() throws Exception {
		super.testClosure_31();
	}
	
	// re-enabled
	@Override
	@Test
	public void testMapValuesExtension() throws Exception {
		super.testMapValuesExtension();
	}

	// re-enabled
	@Override
	@Test
	public void testReduceWithPlusOperator() throws Exception {
		super.testReduceWithPlusOperator();
	}
	
	@Override
	@Test
	@Ignore
	public void testImplicitOneArgClosure_01() throws Exception {
		super.testImplicitOneArgClosure_01();
	}
	
}
