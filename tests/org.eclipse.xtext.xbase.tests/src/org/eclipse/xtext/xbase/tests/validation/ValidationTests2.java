/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

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
public class ValidationTests2 extends ValidationTests {

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testLocalVarWithArguments() throws Exception {
		super.testLocalVarWithArguments();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_00() throws Exception {
		super.testVariableShadowing_00();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_01() throws Exception {
		super.testVariableShadowing_01();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_03() throws Exception {
		super.testVariableShadowing_03();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_04() throws Exception {
		super.testVariableShadowing_04();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_05() throws Exception {
		super.testVariableShadowing_05();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_06() throws Exception {
		super.testVariableShadowing_06();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVariableShadowing_07() throws Exception {
		super.testVariableShadowing_07();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testVoidInReturnExpression_02() throws Exception {
		super.testVoidInReturnExpression_02();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testReturnExpressionInClosure_01() throws Exception {
		super.testReturnExpressionInClosure_01();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testExceptionInClosure_01() throws Exception {
		super.testExceptionInClosure_01();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testExceptionInClosure_03() throws Exception {
		super.testExceptionInClosure_03();
	}

	@Override
	@Test @Ignore("TODO To be implemented")
	public void testExceptionInClosure_04() throws Exception {
		super.testExceptionInClosure_04();
	}
	
}
