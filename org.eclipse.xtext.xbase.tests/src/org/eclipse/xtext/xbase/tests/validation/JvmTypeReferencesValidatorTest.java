/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
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
	
	@Test 
	public void testVoidInFunctionParams() throws Exception {
		XExpression expression = expression("null as (String, void) => void");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, INVALID_USE_OF_TYPE);
	}
	
	@Test 
	public void testVoidInFunctionParams_1() throws Exception {
		XExpression expression = expression("null as (String) => void");
		helper.assertNoErrors(expression);
	}
	
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
	
	@Test public void testNoTypeArg() throws Exception {
		XExpression expression = expression("{ val java.util.List x = null }");
		helper.assertWarning(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.RAW_TYPE);
	}
	
	@Test public void testWrongNumberOfTypeArgs_0() throws Exception {
		XExpression expression = expression("{ val java.util.List<String, String> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}
	
	@Test public void testWrongNumberOfTypeArgs_1() throws Exception {
		XExpression expression = expression("{ val java.util.Map<String> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS);
	}
	
	@Test public void testWrongNumberOfTypeArgs_2() throws Exception {
		XExpression expression = expression("{ val java.lang.Object<String> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE, 
				"The type Object is not generic; it cannot be parameterized with arguments <String>");
	}
	
	@Test public void testWrongNumberOfTypeArgs_3() throws Exception {
		XExpression expression = expression("{ val java.lang.Override<String> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}
	
	@Test public void testWrongNumberOfTypeArgs_4() throws Exception {
		XExpression expression = expression("{ val java.lang.annotation.RetentionPolicy<String> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}
	
	@Test public void testWrongNumberOfTypeArgs_5() throws Exception {
		XExpression expression = expression("{ val int<String, Iterable<? extends Number>, (int, int)=>int> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE, "<String, Iterable<? extends Number>, (int, int)=>int>");
	}
	
	@Test public void testWrongNumberOfTypeArgs_6() throws Exception {
		XExpression expression = expression("{ val void<String> x = null }");
		helper.assertError(expression, TypesPackage.Literals.JVM_TYPE_REFERENCE, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}
	
	@Test public void testWrongNumberOfTypeArgs_7() throws Exception {
		XExpression expression = expression("{ val DoesNotExist<String> x = null }");
		helper.assertNoErrors(expression, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}
	
	@Test public void testWrongNumberOfTypeArgs_8() throws Exception {
		XExpression expression = expression("{ val String<DoesNotExist> x = null }");
		helper.assertNoErrors(expression, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}
	
	@Test public void testWrongNumberOfTypeArgs_9() throws Exception {
		XExpression expression = expression("{ val int<String, Iterable<? extends Number & CharSequence>, (int, Iterable<DoesNotExist>)=>int> x = null }");
		helper.assertNoErrors(expression, IssueCodes.TYPE_ARGUMENT_ON_NON_GENERIC_TYPE);
	}
	
	@Test 
	public void testInvalidWildcard_1() throws Exception {
		XExpression expression = expression("null as Iterable<? extends String & Number>");
		helper.assertError(expression, TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, IssueCodes.INVALID_WILDCARD_CONSTRAINTS, 
				"Invalid type constraint. Cannot use multiple upper bounds in wildcards.");
	}
	
	@Test 
	public void testInvalidWildcard_2() throws Exception {
		XExpression expression = expression("null as Iterable<? super String & Number>");
		helper.assertError(expression, TypesPackage.Literals.JVM_WILDCARD_TYPE_REFERENCE, IssueCodes.INVALID_WILDCARD_CONSTRAINTS, 
				"Invalid type constraint. Cannot use multiple lower bounds in wildcards.");
	}
}
