/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.codebuilder;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.codebuilder.MemberFromSuperImplementor;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.override.BottomResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideTester;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("null")
public class SuperMemberImplementorTest extends AbstractXtendUITestCase {

	private XtendClass xtendClass;

	@Inject
	private MemberFromSuperImplementor implementor;

	@Inject
	private InsertionOffsets insertionOffsets;
	
	@Inject 
	private WorkbenchTestHelper testHelper;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private CommonTypeComputationServices services;

	private JvmGenericType implementedInterface;

	private JvmGenericType superClass;

	private String throwsExpression;

	private String model;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		model = "class Foo<U> extends org.eclipse.xtend.ide.tests.data.Constructor<U> implements org.eclipse.xtend.ide.tests.data.OverrideFunctions<U, CharSequence> {}";
		xtendClass = (XtendClass) testHelper.xtendFile("Foo.xtend", model).getXtendTypes().get(0);
		implementedInterface = (JvmGenericType) xtendClass.getImplements().get(0).getType();
		superClass = (JvmGenericType) xtendClass.getExtends().getType();
		throwsExpression = "\n  throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")\n";
	}

	@Test public void testInsertOffset() throws Exception {
		assertEquals(model.lastIndexOf('}'), insertionOffsets.getNewMethodInsertOffset(null, xtendClass));
	}

	@Test public void testPlain() {
		checkOverrideMethodCode("plain", "override plain() {" + throwsExpression + "}");
	}

	@Test public void testClassTypeParam() {
		checkOverrideMethodCode("classTypeParameter", "override classTypeParameter(U param) {" + throwsExpression + "}");
	}

	@Test public void testClassTypeParam2() {
		checkOverrideMethodCode("classTypeParameter2",
				"override classTypeParameter2(Iterable<? extends CharSequence> param) {" + throwsExpression + "}");
	}

	@Test public void testClassTypeParam3() {
		checkOverrideMethodCode("classTypeParameter3",
				"override classTypeParameter3(Iterable<? super CharSequence> param) {" + throwsExpression + "}");
	}

	@Test public void testMethodTypeParam() {
		checkOverrideMethodCode("methodTypeParameter", "override <V> methodTypeParameter(V param) { " + throwsExpression
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
				"override concreteClassTypeParameter(U param) { super.concreteClassTypeParameter(param) }");
	}

	@Test public void testMethodTypeParam_1() {
		checkOverrideMethodCode("concreteMethodTypeParameter",
				"override <V> concreteMethodTypeParameter(V param) { super.<V>concreteMethodTypeParameter(param)}");
	}

	@Test public void testOverrideConstructor_0() {
		checkImplementConstructor("String", "new(String x) { super(x) }");
	}

	@Test public void testOverrideConstructor_1() {
		checkImplementConstructor("U", "new(U x) { super(x) }");
	}

	@Test public void testOverrideConstructor_2() {
		checkImplementConstructor("int", "protected new(int x) { super(x) }");
	}

	@Test public void testOverrideConstructor_3() {
		checkImplementConstructor(null, "new() { }");
	}

	protected void checkOverrideMethodCode(String operationName, String overrideCode) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
		LightweightTypeReference contextType = getContextType();
		IResolvedOperation resolvedOperation = new BottomResolvedOperation((JvmOperation) findExecutable(implementedInterface, operationName), contextType, new OverrideTester());
		implementor.appendOverrideFunction(xtendClass, resolvedOperation, appendable);
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
		LightweightTypeReference contextType = getContextType();
		ResolvedConstructor resolvedConstructor = new ResolvedConstructor(constructor, contextType);
		implementor.appendConstructorFromSuper(xtendClass, resolvedConstructor, appendable);
		String code = appendable.toString();
		if (!equalsIgnoreWhitespace(implementCode, code))
			assertEquals(implementCode, code);
	}

	protected LightweightTypeReference getContextType() {
		JvmGenericType inferredType = associations.getInferredType(xtendClass);
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, inferredType);
		ParameterizedTypeReference contextType = new ParameterizedTypeReference(owner, inferredType);
		for(JvmTypeParameter typeParamter: inferredType.getTypeParameters()) {
			contextType.addTypeArgument(new ParameterizedTypeReference(owner, typeParamter));
		}
		return contextType;
	}

	protected JvmExecutable findExecutable(JvmGenericType owner, final String name) {
		return (JvmExecutable) find(owner.getMembers(), new Predicate<JvmMember>() {
			public boolean apply(JvmMember input) {
				return input instanceof JvmExecutable && equal(name, input.getSimpleName());
			}
		});
	}
}
