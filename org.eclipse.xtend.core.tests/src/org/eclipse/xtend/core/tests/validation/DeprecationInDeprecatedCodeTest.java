/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
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
	
	@Test public void testNoIssueIfSameResource() throws Exception {
		XtendFile file = file("@Deprecated class C {} class D { public C c = null }");
		helper.assertNoIssues(file);
	}
	
	@Test public void testDeprecatedStaticField_0() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_0() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).deprecatedFunction(#[])");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticField_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).deprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticField_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember11.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).deprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction_1_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember11(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticField_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember1.InnerMember12.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).deprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction_1_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember1.InnerMember12(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticField_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).deprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticField_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember21.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).deprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction_2_1() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember21(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticField_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticField_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedStaticFunction_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.deprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testStaticFunction_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("testdata.DeprecatedMembers.InnerMember2.InnerMember22.nodeprecatedStaticFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedConstructor_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1)");
		helper.assertNoIssues(cls);
	}

	@Test public void testConstructor_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f)");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedField_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testField_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedField");
		helper.assertNoIssues(cls);
	}

	@Test public void testDeprecatedFunction_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).deprecatedFunction");
		helper.assertNoIssues(cls);
	}

	@Test public void testFunction_2_2() throws Exception {
		XtendClass cls = expressionInDeprecatedCode("new testdata.DeprecatedMembers.InnerMember2.InnerMember22(1f).nodeprecatedFunction");
		helper.assertNoIssues(cls);
	}
}
