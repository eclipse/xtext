/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stéphane Galland - Initial contribution and API
 */
public class DeprecatedTest extends AbstractXbaseTestCase {

	@Inject
	protected ValidationTestHelper helper;

	protected void assertWarning(XExpression expr, EClass eClass, String... message) {
		helper.assertWarning(expr, eClass, DEPRECATED_MEMBER_REFERENCE, message);
	}
	
	@Test public void testDeprecatedStaticField_0() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The field DeprecatedMembers.deprecatedStaticField is deprecated");
	}

	@Test public void testStaticField_0() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.nodeprecatedStaticField");
		helper.assertNoIssues(expr);
	}
	
	@Test public void testDeprecatedStaticFunction() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method deprecatedStaticFunction(String...) from the type DeprecatedMembers is deprecated");
	}

	@Test public void testStaticFunction() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.nodeprecatedStaticFunction");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedConstructor() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers(int) is deprecated");
	}

	@Test public void testConstructor() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers(1f)");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedField() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The field DeprecatedMembers.deprecatedField is deprecated");
	}

	@Test public void testField() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers(1f).nodeprecatedField");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedFunction() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method deprecatedFunction(String[]) from the type DeprecatedMembers is deprecated");
	}

	@Test public void testFunction() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers(1f).nodeprecatedFunction");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedStaticField_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The field DeprecatedMembers.InnerMember1.deprecatedStaticField is deprecated");
	}

	@Test public void testStaticField_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticField");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedStaticFunction_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method deprecatedStaticFunction() from the type DeprecatedMembers.InnerMember1 is deprecated");
	}

	@Test public void testStaticFunction_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticFunction");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedConstructor_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers.InnerMember1(int) is deprecated");
	}

	@Test public void testConstructor_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1(1f)");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedField_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The field DeprecatedMembers.InnerMember1.deprecatedField is deprecated");
	}

	@Test public void testField_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedField");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedFunction_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method deprecatedFunction() from the type DeprecatedMembers.InnerMember1 is deprecated");
	}

	@Test public void testFunction_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedFunction");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedStaticField_1_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticField_1_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticField");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedStaticFunction_1_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticFunction_1_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticFunction");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedConstructor_1_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL);
	}

	@Test public void testConstructor_1_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f)");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedField_1_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testField_1_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedField");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedFunction_1_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testFunction_1_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedFunction");
		helper.assertNoError(expr, DEPRECATED_MEMBER_REFERENCE);
	}

	@Test public void testDeprecatedStaticField_1_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticField_1_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticFunction_1_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticFunction_1_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedConstructor_1_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL);
	}

	@Test public void testConstructor_1_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f)");
		assertWarning(expr, XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers.InnerMember1.InnerMember12(float) is deprecated");
	}

	@Test public void testDeprecatedField_1_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testField_1_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedFunction_1_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testFunction_1_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticField_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticField_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticFunction_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticFunction_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedConstructor_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL);
	}

	@Test public void testConstructor_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2(1f)");
		assertWarning(expr, XCONSTRUCTOR_CALL);
	}

	@Test public void testDeprecatedField_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testField_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedFunction_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testFunction_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticField_2_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticField_2_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticFunction_2_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticFunction_2_1() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedConstructor_2_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL);
	}

	@Test public void testConstructor_2_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f)");
		assertWarning(expr, XCONSTRUCTOR_CALL);
	}

	@Test public void testDeprecatedField_2_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testField_2_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedFunction_2_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testFunction_2_1() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticField_2_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticField_2_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testDeprecatedStaticFunction_2_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL);
	}

	@Test public void testStaticFunction_2_2() throws Exception {
		XExpression expr = expression("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method nodeprecatedStaticFunction() from the type DeprecatedMembers.InnerMember2.InnerMember22 is deprecated");
	}

	@Test public void testDeprecatedConstructor_2_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1)");
		assertWarning(expr, XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers.InnerMember2.InnerMember22(int) is deprecated");
	}

	@Test public void testConstructor_2_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f)");
		assertWarning(expr,  XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers.InnerMember2.InnerMember22(float) is deprecated");
	}

	@Test public void testDeprecatedField_2_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The field DeprecatedMembers.InnerMember2.InnerMember22.deprecatedField is deprecated");
	}

	@Test public void testField_2_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedField");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The field DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedField is deprecated");
	}

	@Test public void testDeprecatedFunction_2_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method deprecatedFunction() from the type DeprecatedMembers.InnerMember2.InnerMember22 is deprecated");
		assertWarning(expr, XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers.InnerMember2.InnerMember22(float) is deprecated");
	}

	@Test public void testFunction_2_2() throws Exception {
		XExpression expr = expression("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedFunction");
		assertWarning(expr, XABSTRACT_FEATURE_CALL, "The method nodeprecatedFunction() from the type DeprecatedMembers.InnerMember2.InnerMember22 is deprecated");
		assertWarning(expr, XCONSTRUCTOR_CALL, "The constructor DeprecatedMembers.InnerMember2.InnerMember22(float) is deprecated");
	}
}
