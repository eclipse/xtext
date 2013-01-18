/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtend.core.formatting.MemberFromSuperImplementor;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SuperMemberImplementorTest extends AbstractXtendTestCase {

	private XtendClass xtendClass;

	@Inject
	private MemberFromSuperImplementor implementor;

	private JvmGenericType implementedInterface;

	private JvmGenericType superClass;

	private String throwsExpression;

	private String model;

	@Before
	public void setUp() throws Exception {
		model = "class Foo<U> extends test.Constructor<U> implements test.OverrideFunctions<U, CharSequence> {}";
		xtendClass = clazz(model);
		implementedInterface = (JvmGenericType) xtendClass.getImplements().get(0).getType();
		superClass = (JvmGenericType) xtendClass.getExtends().getType();
		throwsExpression = "\n  throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")\n";
	}

	@Test public void testInsertOffset() throws Exception {
		assertEquals(model.lastIndexOf('}'), implementor.getFunctionInsertOffset(xtendClass));
	}

	@Test public void testPlain() {
		checkOverrideMethodCode("plain", "override plain() {" + throwsExpression + "}");
	}

	@Test public void testClassTypeParam() {
		checkOverrideMethodCode("classTypeParameter", "override classTypeParameter(U arg0) {" + throwsExpression + "}");
	}

	@Test public void testClassTypeParam2() {
		checkOverrideMethodCode("classTypeParameter2",
				"override classTypeParameter2(Iterable<? extends CharSequence> arg0) {" + throwsExpression + "}");
	}

	@Test public void testClassTypeParam3() {
		checkOverrideMethodCode("classTypeParameter3",
				"override classTypeParameter3(Iterable<? super CharSequence> arg0) {" + throwsExpression + "}");
	}

	@Test public void testMethodTypeParam() {
		checkOverrideMethodCode("methodTypeParameter", "override <V> methodTypeParameter(V arg0) { " + throwsExpression
				+ "}");
	}

	@Test public void testException() {
		checkOverrideMethodCode("exception", "override exception() throws Exception {" + throwsExpression + "}");
	}

	@Test public void testProtected() {
		checkOverrideMethodCode("protectedMethod", "override protected protectedMethod() {" + throwsExpression + "}");
	}

	@Test public void testPlain_1() {
		checkOverrideMethodCode("concretePlain", "override concretePlain() { super.concretePlain() }");
	}

	@Test public void testClassTypeParam_1() {
		checkOverrideMethodCode("concreteClassTypeParameter",
				"override concreteClassTypeParameter(U arg0) { super.concreteClassTypeParameter(arg0) }");
	}

	@Test public void testMethodTypeParam_1() {
		checkOverrideMethodCode("concreteMethodTypeParameter",
				"override <V> concreteMethodTypeParameter(V arg0) { super.<V>concreteMethodTypeParameter(arg0)}");
	}

	@Test public void testOverrideConstructor_0() {
		checkImplementConstructor("String", "new(String arg0) { super(arg0) }");
	}

	@Test public void testOverrideConstructor_1() {
		checkImplementConstructor("U", "new(U arg0) { super(arg0) }");
	}

	@Test public void testOverrideConstructor_2() {
		checkImplementConstructor("int", "protected new(int arg0) { super(arg0) }");
	}

	@Test public void testOverrideConstructor_3() {
		checkImplementConstructor(null, "new() { }");
	}

	protected void checkOverrideMethodCode(String operationName, String overrideCode) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
		implementor.appendOverrideFunction(xtendClass,
				(JvmOperation) findExecutable(implementedInterface, operationName), appendable);
		String code = appendable.toString();
		if (!equalsIgnoreWhitespace(overrideCode, code))
			assertEquals(overrideCode, code);
	}

	protected void checkImplementConstructor(final String firstParamType, String implementCode) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
		
		JvmConstructor constructor = Iterables.find(superClass.getDeclaredConstructors(), new Predicate<JvmConstructor>() {
			public boolean apply(JvmConstructor c) {
				if (firstParamType == null)
					return c.getParameters().isEmpty();
				if (c.getParameters().size() >= 1) {
					return firstParamType.equals(c.getParameters().get(0).getParameterType().getSimpleName());
				}
				return false;
			}
		});
		implementor.appendConstructorFromSuper(xtendClass, constructor, appendable);
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
