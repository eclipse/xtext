/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferencesValidatorTest extends AbstractXbaseTestCase {
	@Inject
	protected ValidationTestHelper helper;
	
	@Test public void testNoPrimitivesInTypeArgs() throws Exception {
		XExpression expression = expression("null as java.util.List<boolean>");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.INVALID_USE_OF_TYPE);
	}
	
	@Test public void testNoPrimitivesInTypeArgs_00() throws Exception {
		XExpression expression = expression("null as java.util.List<? extends boolean>");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.INVALID_USE_OF_TYPE);
	}
	
	@Test public void testNoPrimitivesInTypeArgs_01() throws Exception {
		XExpression expression = expression("{val (void)=>void func = [void s|s+'foo'] func}");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.INVALID_USE_OF_TYPE);
	}
	
	@Test public void testFormalParameterTypeNotVoid() throws Exception {
		XExpression expression = expression("for (void x : null as java.util.List<?>) 'foo'+'bar'");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.INVALID_USE_OF_TYPE);
	}
	
}
