/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {

	//TODO reactivate temporarily disabled tests
	@Override
	public void testThrowExpression_01() {
	}

	@Override
	public void testSpreadOperator_01() {
	}

	@Override
	public void testSpreadOperator_02() {
	}
	
	
	//TODO FIX US
	@Override
	public void testUpToOperator() throws Exception {
	}
	
	@Override
	public void testOverriddenLocalVariables() throws Exception {
	}
	
	@Override
	public void testOverriddenLocalVariables_0() throws Exception {
	}
	
	@Override
	public void testFeatureCall_02() {
	}
	
	@Override
	public void testFeatureCall_04() {
	}
	
	@Override
	public void testAssignment_07() {
	}
	
	@Override
	public void testAssignment_08() {
	}
	
	@Override
	public void testAssignment_11() {
	}
	
	@Override
	public void testAssignment_12() {
	}
	
	@Override
	public void testForLoop_01() {
	}
	
	@Override
	public void testForLoop_02() {
	}
	
	@Override
	public void testSwitchExpression_07() {
	}
	
	@Override
	public void testSwitchExpression_08() {
	}
	
	@Override
	public void testTryCatch_05() {
	}
	
	@Override
	public void testTryCatch_WithThrows_01() {
	}
	
	@Override
	public void testClosure_11() {
	}
	
	@Override
	public void testArrayConversion_01() {
	}
	
	@Override
	public void testArrayConversion_02() {
	}
	
	@Override
	public void testArrayConversion_03() {
	}
	
	@Override
	public void testArrayConversion_04() {
	}
	
	@Override
	public void testArrayConversion_05() {
	}
	
	@Inject
	private CompilerTestHelper testHelper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		CompilerTestHelper.INJECTOR.injectMembers(this);
		testHelper.setUp();
	}

	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		testHelper.assertEvaluatesTo(object, string);
	}
	
	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		testHelper.assertEvaluatesWithException(class1, string);
	}

}
