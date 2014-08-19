/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stéphane Galland - Initial contribution and API
 */
public class DeprecationInDeprecatedCodeTest extends AbstractXtendTestCase {

	@Inject
	protected ValidationTestHelper helper;

	protected XtendClass expressionInDeprecatedCode(String expression) throws Exception {
		return clazz("class Foo { @Deprecated def bar(int x) { " + expression + " } }");
	}
	
	@Test public void testDeprecatedStaticField_0() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_0() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.nodeprecatedStaticField");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.nodeprecatedStaticFunction");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f)");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).nodeprecatedField");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).nodeprecatedFunction");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticField_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticField");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticFunction");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f)");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedField");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedFunction");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticField_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticField");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticFunction");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f)");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedField");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction_1_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedFunction");
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
		helper.assertNoError(expr, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticField_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction_1_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticField_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticField_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction_2_1() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticField_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticField_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedStaticFunction_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testStaticFunction_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedConstructor_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1)");
		helper.assertWarning(expr, XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testConstructor_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f)");
		helper.assertWarning(expr,  XCONSTRUCTOR_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedField_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testField_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedField");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testDeprecatedFunction_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}

	@Test public void testFunction_2_2() throws Exception {
		XtendClass expr = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedFunction");
		helper.assertWarning(expr, XABSTRACT_FEATURE_CALL, DEPRECATION_IN_DEPRECATED_CODE);
	}
}
