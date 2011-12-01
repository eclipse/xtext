/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.validation;

import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FeatureCallValidationTest extends AbstractXtend2TestCase {

	@Inject
	private ValidationTestHelper helper;

	public void testXFeatureCallField1() throws Exception {
		XtendClass clazz = clazz("class X { String foo def meth() { foo.toLowerCase } }");
		helper.assertNoErrors(clazz);
	}

	public void testXFeatureCallField2() throws Exception {
		XtendClass clazz = clazz("class X { static String foo def meth() { foo.toLowerCase } }");
		helper.assertNoErrors(clazz);
	}

	public void testXFeatureCallField3() throws Exception {
		XtendClass clazz = clazz("class X { String foo def static meth() { foo.toLowerCase } }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	public void testXFeatureCallField4() throws Exception {
		XtendClass clazz = clazz("class X { static String foo def static meth() { foo.toLowerCase } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallField1() throws Exception {
		XtendClass clazz = clazz("class X { String foo def meth() { new X().foo.toLowerCase } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallField2() throws Exception {
		XtendClass clazz = clazz("class X { static String foo def meth() { new X().foo.toLowerCase } }");
		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testXMemberFeatureCallField3() throws Exception {
		XtendClass clazz = clazz("class X { String foo def static meth() { new X().foo.toLowerCase } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallField4() throws Exception {
		XtendClass clazz = clazz("class X { static String foo def static meth() { new X().foo.toLowerCase } }");
		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testXAssignmentField1() throws Exception {
		XtendClass clazz = clazz("class X { String foo def meth() { foo = '' } }");
		helper.assertNoErrors(clazz);
	}

	public void testXAssignmentField2() throws Exception {
		XtendClass clazz = clazz("class X { static String foo def meth() { foo = '' } }");
		helper.assertNoErrors(clazz);
	}

	public void testXAssignmentField3() throws Exception {
		XtendClass clazz = clazz("class X { String foo def static meth() { foo = '' } }");
		helper.assertError(clazz, XbasePackage.Literals.XASSIGNMENT,
				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	public void testXAssignmentField4() throws Exception {
		XtendClass clazz = clazz("class X { static String foo def static meth() { foo = '' } }");
		helper.assertNoErrors(clazz);
	}

	public void testXFeatureCallOperation1() throws Exception {
		XtendClass clazz = clazz("class X { def setFoo(String x) {} def meth() { setFoo('') } }");
		helper.assertNoErrors(clazz);
	}

	public void testXFeatureCallOperation2() throws Exception {
		XtendClass clazz = clazz("class X { def static setFoo(String x) {} def meth() { setFoo('') } }");
		helper.assertNoErrors(clazz);
	}

	public void testXFeatureCallOperation3() throws Exception {
		XtendClass clazz = clazz("class X { def setFoo(String x) {} def static meth() { setFoo('') } }");
		helper.assertError(clazz, XbasePackage.Literals.XFEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	public void testXFeatureCallOperation4() throws Exception {
		XtendClass clazz = clazz("class X { def static setFoo(String x) {} def static meth() { setFoo('') } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallOperation1() throws Exception {
		XtendClass clazz = clazz("class X { def setFoo(String x) {} def meth() { new X().setFoo('') } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallOperation2() throws Exception {
		XtendClass clazz = clazz("class X { def static setFoo(String x) {} def meth() { new X().setFoo('') } }");
		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testXMemberFeatureCallOperation3() throws Exception {
		XtendClass clazz = clazz("class X { def setFoo(String x) {} def static meth() { new X().setFoo('') } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallOperation4() throws Exception {
		XtendClass clazz = clazz("class X { def static setFoo(String x) {} def static meth() { new X().setFoo('') } }");
		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER);
	}

	public void testXAssignmentOperation1() throws Exception {
		XtendClass clazz = clazz("class X { def setFoo(String x) {} def meth() { foo = '' } }");
		helper.assertNoErrors(clazz);
	}

	//	public void testXAssignmentOperation2() throws Exception {
	//		XtendClass clazz = clazz("class X { def static setFoo(String x) {} def meth() { foo = '' } }");
	//		helper.assertNoErrors(clazz);
	//	}
	//
	//	public void testXAssignmentOperation3() throws Exception {
	//		XtendClass clazz = clazz("class X { def setFoo(String x) {} def static meth() { foo = '' } }");
	//		helper.assertError(clazz, XbasePackage.Literals.XASSIGNMENT,
	//				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	//	}
	//
	//	public void testXAssignmentOperation4() throws Exception {
	//		XtendClass clazz = clazz("class X { def static setFoo(String x) {} def static meth() { foo = '' } }");
	//		helper.assertNoErrors(clazz);
	//	}

	public void testXMemberFeatureCallImportedMemberExtension1() throws Exception {
		XtendClass clazz = clazz("class X { extension test.ExtensionMethods def meth() { 'foo'.instanceExtension } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallImportedMemberExtension2() throws Exception {
		XtendClass clazz = clazz("class X { extension test.ExtensionMethods def static meth() { 'foo'.instanceExtension } }");
		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	//	 static methods from instance extensions are not on the scope
	//	public void testXMemberFeatureCallImportedMemberExtension3() throws Exception {
	//		XtendClass clazz = clazz("class X { extension test.ExtensionMethods def meth() { 'foo'.staticExtension } }");
	//		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
	//				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	//	}
	//
	//	public void testXMemberFeatureCallImprotedMemberExtension4() throws Exception {
	//		XtendClass clazz = clazz("class X { extension test.ExtensionMethods def static meth() { 'foo'.staticExtension } }");
	//		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
	//				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	//	}

	public void testXMemberFeatureCallLocalMemberExtension1() throws Exception {
		XtendClass clazz = clazz("class X { def instanceExtension(String foo) { foo + 'inst' } def meth() { 'foo'.instanceExtension } }");
		helper.assertNoErrors(clazz);
	}

	public void testXMemberFeatureCallLocalMemberExtension2() throws Exception {
		XtendClass clazz = clazz("class X { def instanceExtension(String foo) { foo + 'inst' } def static meth() { 'foo'.instanceExtension } }");
		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	}

	//	 static methods from instance extensions are not on the scope
	//	public void testXMemberFeatureCallLocalMemberExtension3() throws Exception {
	//		XtendClass clazz = clazz("class X { def static staticExtension(String foo) { foo + 'inst' } def meth() { 'foo'.staticExtension } }");
	//		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
	//				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	//	}
	//
	//	public void testXMemberFeatureCallLocalMemberExtension4() throws Exception {
	//		XtendClass clazz = clazz("class X { def static staticExtension(String foo) { foo + 'inst' } def static meth() { 'foo'.staticExtension } }");
	//		helper.assertError(clazz, XbasePackage.Literals.XMEMBER_FEATURE_CALL,
	//				org.eclipse.xtext.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER);
	//	}

}
