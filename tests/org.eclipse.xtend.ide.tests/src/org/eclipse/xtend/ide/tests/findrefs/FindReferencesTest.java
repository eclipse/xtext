/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.findrefs;

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.junit.ui.FindReferencesTestUtil;
import org.eclipse.xtext.xbase.junit.ui.FindReferencesTestUtil.MockAcceptor;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class FindReferencesTest extends AbstractXtendUITestCase {

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private FindReferencesTestUtil findReferencesTester;

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	@Test public void testFindReferencesToClass() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo {}").getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar extends Foo {}").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(classBar.getExtends(), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		findReferencesTester.checkFindReferences(classFoo, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesThis() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo { def foo() {this} }").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmGenericType inferredType = associations.getInferredType(classFoo);
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionFoo.getExpression()).getExpressions().get(0), inferredType,
				XABSTRACT_FEATURE_CALL__FEATURE);
		findReferencesTester.checkFindReferences(inferredType, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}
	
	@Test public void testFindReferencesTypeLiteral() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo { def foo() { Foo } }").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmGenericType inferredType = associations.getInferredType(classFoo);
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionFoo.getExpression()).getExpressions().get(0), inferredType,	XABSTRACT_FEATURE_CALL__FEATURE);
		findReferencesTester.checkFindReferences(inferredType, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}
	
	@Test public void testFindReferencesTypeLiteralWithPackageFragment() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "package com.acme class Foo { def foo() { com.acme.Foo } }").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmGenericType inferredType = associations.getInferredType(classFoo);
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);
		
		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionFoo.getExpression()).getExpressions().get(0), inferredType,	XABSTRACT_FEATURE_CALL__FEATURE);
		findReferencesTester.checkFindReferences(inferredType, "Java References to com.acme.Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesToConstructor() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo {}").getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { def bar() {new Foo()} }").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionBar.getExpression()).getExpressions().get(0),
				inferredConstructor, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		findReferencesTester.checkFindReferences(classFoo, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesFromReturnType() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo {}").getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { def Foo bar() {null} }").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getReturnType(), inferredTypeFoo, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		findReferencesTester.checkFindReferences(classFoo, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesFromParameter() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo {}").getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { def bar(Foo x) {null} }").getXtendTypes().get(0);
		waitForAutoBuild();
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);
		XtendFunction functionBar = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(functionBar.getParameters().get(0).getParameterType(), inferredTypeFoo,
				JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		findReferencesTester.checkFindReferences(classFoo, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesToFunction() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo { def foo() {this} def bar() {foo()} }")
				.getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { def baz(Foo it) {foo()} }").getXtendTypes().get(0);
		waitForAutoBuild();
		XtendFunction functionFoo = (XtendFunction) classFoo.getMembers().get(0);
		XtendFunction functionBar = (XtendFunction) classFoo.getMembers().get(1);
		JvmOperation inferredOperation = associations.getDirectlyInferredOperation(functionFoo);
		XtendFunction functionBaz = (XtendFunction) classBar.getMembers().get(0);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(((XBlockExpression) functionBar.getExpression()).getExpressions().get(0),
				inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		mockAcceptor.expect(((XBlockExpression) functionBaz.getExpression()).getExpressions().get(0),
				inferredOperation, XABSTRACT_FEATURE_CALL__FEATURE);
		findReferencesTester.checkFindReferences(functionFoo, "Java References to Foo.foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesToAnonymousSuperType() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo {}")
				.getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { val foo = new Foo{} }").getXtendTypes().get(0);
		waitForAutoBuild();
		XtendField fieldFoo = (XtendField) classBar.getMembers().get(0);
		JvmGenericType inferredTypeFoo = associations.getInferredType(classFoo);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(fieldFoo.getInitialValue(),
				inferredTypeFoo, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		findReferencesTester.checkFindReferences(inferredTypeFoo, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesToAnonymousImplicitSuperConstructor() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo {}")
				.getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { val foo = new Foo{} }").getXtendTypes().get(0);
		waitForAutoBuild();
		XtendField fieldFoo = (XtendField) classBar.getMembers().get(0);
		JvmConstructor inferredConstructor = associations.getInferredConstructor(classFoo);

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(fieldFoo.getInitialValue(),
				inferredConstructor, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		findReferencesTester.checkFindReferences(inferredConstructor, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

	@Test public void testFindReferencesToAnonymousExplicitSuperConstructor() throws Exception {
		XtendClass classFoo = (XtendClass) testHelper.xtendFile("Foo", "class Foo { new() {} }")
				.getXtendTypes().get(0);
		XtendClass classBar = (XtendClass) testHelper.xtendFile("Bar", "class Bar { val foo = new Foo{} }").getXtendTypes().get(0);
		waitForAutoBuild();
		XtendField fieldFoo = (XtendField) classBar.getMembers().get(0);
		JvmConstructor inferredConstructor = associations.getInferredConstructor((XtendConstructor) classFoo.getMembers().get(0));

		final MockAcceptor mockAcceptor = new MockAcceptor();
		mockAcceptor.expect(fieldFoo.getInitialValue(),
				inferredConstructor, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		findReferencesTester.checkFindReferences(inferredConstructor, "Java References to Foo (/test.project/src/Foo.xtend)", mockAcceptor);
	}

}
