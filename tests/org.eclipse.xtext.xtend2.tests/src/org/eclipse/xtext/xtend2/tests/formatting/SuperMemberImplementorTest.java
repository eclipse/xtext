/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.formatting;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xtend2.formatting.MemberFromSuperImplementor;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SuperMemberImplementorTest extends AbstractXtend2TestCase {

	private XtendClass xtendClass;

	@Inject
	private MemberFromSuperImplementor implementor;

	private JvmGenericType implementedInterface;

	private JvmGenericType superClass;

	private String throwsExpression;

	private String model;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		model = "class Foo<U> extends test.Constructor<U> implements test.OverrideFunctions<U, CharSequence> {}";
		xtendClass = clazz(model);
		implementedInterface = (JvmGenericType) xtendClass.getImplements().get(0).getType();
		superClass = (JvmGenericType) xtendClass.getExtends().getType();
		throwsExpression = "throw new UnsupportedOperationException(\"Auto-generated function stub\")";
	}

	public void testInsertOffset() throws Exception {
		assertEquals(model.lastIndexOf('}'), implementor.getFunctionInsertOffset(xtendClass));
	}

	public void testPlain() {
		checkOverrideMethodCode("plain", "override plain() { " + throwsExpression + "}");
	}

	public void testClassTypeParam() {
		checkOverrideMethodCode("classTypeParameter", "override classTypeParameter(U p0) { " + throwsExpression + "}");
	}

	public void testClassTypeParam2() {
		checkOverrideMethodCode("classTypeParameter2",
				"override classTypeParameter2(Iterable<? extends CharSequence> p0) { " + throwsExpression + "}");
	}

	public void testClassTypeParam3() {
		checkOverrideMethodCode("classTypeParameter3",
				"override classTypeParameter3(Iterable<? super CharSequence> p0) { " + throwsExpression + "}");
	}

	public void testMethodTypeParam() {
		checkOverrideMethodCode("methodTypeParameter", "override <V> methodTypeParameter(V p0) { " + throwsExpression
				+ "}");
	}

	public void testException() {
		checkOverrideMethodCode("exception", "override exception() throws Exception { " + throwsExpression + "}");
	}

	public void testProtected() {
		checkOverrideMethodCode("protectedMethod", "override protected protectedMethod() { " + throwsExpression + "}");
	}

	public void testPlain_1() {
		checkOverrideMethodCode("concretePlain", "override concretePlain() { super.concretePlain() }");
	}

	public void testClassTypeParam_1() {
		checkOverrideMethodCode("concreteClassTypeParameter",
				"override concreteClassTypeParameter(U p0) { super.concreteClassTypeParameter(p0) }");
	}

	public void testMethodTypeParam_1() {
		checkOverrideMethodCode("concreteMethodTypeParameter",
				"override <V> concreteMethodTypeParameter(V p0) { super.<V>concreteMethodTypeParameter(p0)}");
	}

	public void testOverrideConstructor_0() {
		checkImplementConstructor(0, "new(String p0) { super(p0) }");
	}

	public void testOverrideConstructor_1() {
		checkImplementConstructor(1, "new(U p0) { super(p0) }");
	}

	public void testOverrideConstructor_2() {
		checkImplementConstructor(2, "protected new(int p0) { super(p0) }");
	}

	public void testOverrideConstructor_3() {
		checkImplementConstructor(3, "new() { }");
	}

	protected void checkOverrideMethodCode(String operationName, String overrideCode) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
		implementor.appendOverrideFunction(xtendClass,
				(JvmOperation) findExecutable(implementedInterface, operationName), appendable);
		String code = appendable.toString();
		if (!equalsIgnoreWhitespace(overrideCode, code))
			assertEquals(overrideCode, code);
	}

	protected void checkImplementConstructor(int index, String implementCode) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
		implementor.appendConstructorFromSuper(xtendClass,
				Iterables.get(superClass.getDeclaredConstructors(), index), appendable);
		String code = appendable.toString();
		if (!equalsIgnoreWhitespace(implementCode, code))
			assertEquals(implementCode, code);
	}

	protected JvmExecutable findExecutable(JvmGenericType owner, final String name) {
		return (JvmExecutable) find(owner.getMembers(), new Predicate<JvmMember>() {
			public boolean apply(JvmMember input) {
				return input instanceof JvmExecutable && equal(name, input.getSimpleName());
			}
		});
	}
}
