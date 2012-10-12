/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

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
public class EvaluationCompilerTestWithNewTypeSystem extends EvaluationCompilerTest {

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
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testReturnExpression_06() throws Exception {
		super.testReturnExpression_06();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testForLoop_01() throws Exception {
		super.testForLoop_01();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testForLoop_02() throws Exception {
		super.testForLoop_02();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_01() throws Exception {
		super.testMemberCallOnMultiType_01();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_02() throws Exception {
		super.testMemberCallOnMultiType_02();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_03() throws Exception {
		super.testMemberCallOnMultiType_03();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_04() throws Exception {
		super.testMemberCallOnMultiType_04();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_05() throws Exception {
		super.testMemberCallOnMultiType_05();
	}

	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_06() throws Exception {
		super.testMemberCallOnMultiType_06();
	}
	
	@Ignore("Work in progress")
	@Override
	@Test
	public void testMemberCallOnMultiType_09() throws Exception {
		super.testMemberCallOnMultiType_09();
	}
	
	@Override
	@Test
	@Ignore("To be implemented later")
	public void testImplicitOneArgClosure_01() throws Exception {
		super.testImplicitOneArgClosure_01();
	}
	
	@Override
	@Test
	@Ignore("To be implemented later")
	public void testClosure_06_1() throws Exception {
		super.testClosure_06_1();
	}
	
	@Override
	@Test
	@Ignore("To be implemented later")
	public void testClosure_10() throws Exception {
		super.testClosure_10();
	}
	
	@Override
	@Test
	@Ignore("To be implemented later")
	public void testClosure_10_2() throws Exception {
		super.testClosure_10_2();
	}
	
	@Override
	@Test
	@Ignore("To be implemented later")
	public void testStaticMethod_02() throws Exception {
		super.testStaticMethod_02();
	}
	
}
