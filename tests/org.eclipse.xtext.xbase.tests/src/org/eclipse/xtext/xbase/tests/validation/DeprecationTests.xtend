/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtext.xbase.XbasePackage

/**
 * @author Stéphane Galland - Initial contribution and API
 */
public class DeprecationTests extends AbstractXbaseTestCase {

	@Inject
	extension ValidationTestHelper
	
	@Test def void testDeprecatedStaticField_0() {
		'''
			testdata.DeprecatedMembers.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_0() {
		'''
			testdata.DeprecatedMembers.nodeprecatedField
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction() {
		'''
			testdata.DeprecatedMembers.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction() {
		'''
			testdata.DeprecatedMembers.nodeprecatedStaticFunction
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor() {
		'''
			new testdata.DeprecatedMembers(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor() {
		'''
			new testdata.DeprecatedMembers(1f)
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField() {
		'''
			new testdata.DeprecatedMembers(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField() {
		'''
			new testdata.DeprecatedMembers(1f).nodeprecatedField
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction() {
		'''
			new testdata.DeprecatedMembers(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction() {
		'''
			new testdata.DeprecatedMembers(1f).nodeprecatedFunction
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticField_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.nodeprecatedField
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticFunction
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1(1f)
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedField
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedFunction
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticField_1_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_1_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedField
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction_1_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction_1_1() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticFunction
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor_1_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor_1_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f)
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField_1_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField_1_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedField
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction_1_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction_1_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedFunction
		'''.expression.assertNoError(IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticField_1_2() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_1_2() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction_1_2() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction_1_2() {
		'''
			testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor_1_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor_1_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField_1_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField_1_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction_1_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction_1_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticField_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2(1f)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticField_2_1() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_2_1() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction_2_1() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction_2_1() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor_2_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor_2_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField_2_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField_2_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction_2_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction_2_1() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticField_2_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticField_2_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedStaticFunction_2_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testStaticFunction_2_2() {
		'''
			testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedConstructor_2_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testConstructor_2_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f)
		'''.expression.assertWarning(
			XbasePackage::Literals::XCONSTRUCTOR_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedField_2_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testField_2_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedField
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testDeprecatedFunction_2_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}

	@Test def void testFunction_2_2() {
		'''
			new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedFunction
		'''.expression.assertWarning(
			XbasePackage::Literals::XABSTRACT_FEATURE_CALL,
			IssueCodes.DEPRECATED_FEATURE)
	}
}
