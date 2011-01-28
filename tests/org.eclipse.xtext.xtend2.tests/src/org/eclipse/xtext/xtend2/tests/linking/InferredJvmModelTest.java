/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xtend2.linking.XtendSourceAssociator;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class InferredJvmModelTest extends AbstractXtend2TestCase {

	@Inject
	private XtendSourceAssociator sourceAssociator;
	
	public void testInferredJvmType() throws Exception {
		XtendFile xtendFile = file("class Foo { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(xtendClass.getInferredJvmType(), inferredType);
		assertEquals(xtendClass, sourceAssociator.getXtendSource(inferredType));
		assertEquals(xtendClass.getCanonicalName(), inferredType.getCanonicalName());
		assertEquals(JvmVisibility.PUBLIC, inferredType.getVisibility());
	}

	public void testInferredSuperType() throws Exception {
		XtendFile xtendFile = file("class Foo extends Object { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getSuperTypes().size());
		assertFalse(xtendClass.getSuperTypes().get(0) == inferredType.getSuperTypes().get(0));
		assertEquals(xtendClass.getSuperTypes().get(0).getType(), inferredType.getSuperTypes().get(0).getType());
	}

	public void testInferredSuperTypeTypeArgument() throws Exception {
		XtendFile xtendFile = file("class Foo extends Iterable<Object> { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getSuperTypes().size());
		JvmTypeReference xtendSuperType = xtendClass.getSuperTypes().get(0);
		JvmTypeReference jvmSuperType = inferredType.getSuperTypes().get(0);
		assertFalse(xtendSuperType == jvmSuperType);
		assertTrue(jvmSuperType instanceof JvmParameterizedTypeReference);
		assertTrue(xtendSuperType instanceof JvmParameterizedTypeReference);
		EList<JvmTypeReference> xtendTypeArguments = ((JvmParameterizedTypeReference)xtendSuperType).getArguments();
		EList<JvmTypeReference> jvmTypeArguments = ((JvmParameterizedTypeReference)jvmSuperType).getArguments();
		assertEquals(1, jvmTypeArguments.size());
		JvmTypeReference xtendTypeArgument = xtendTypeArguments.get(0);
		JvmTypeReference jvmTypeArgument = jvmTypeArguments.get(0);
		assertFalse(xtendTypeArgument == jvmTypeArgument);
		assertEquals(xtendTypeArgument.getType(), jvmTypeArgument.getType());
	}
	
	public void testInferredTypeParameter() throws Exception {
		XtendFile xtendFile = file("class Foo <T> { }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		assertEquals(1, inferredType.getTypeParameters().size());
		assertFalse(xtendClass.getTypeParameters().get(0) == inferredType.getTypeParameters().get(0));
		assertEquals(xtendClass.getTypeParameters().get(0).getCanonicalName(), inferredType.getTypeParameters().get(0).getCanonicalName());
	}
	
	public void testInferredTypeWithSelfReferringTypeParameter() throws Exception {
		XtendFile xtendFile = file("package foo class Foo <T extends Foo> {}");
		JvmGenericType inferredType = getInferredType(xtendFile);
		assertEquals(1, inferredType.getTypeParameters().size());
		JvmTypeParameter typeParameter = inferredType.getTypeParameters().get(0);
		assertEquals(1, typeParameter.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameter.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		assertEquals(inferredType, ((JvmUpperBound)typeConstraint).getTypeReference().getType());
	}

	public void testInferredFunction() throws Exception {
		XtendFile xtendFile = file("class Foo { bar() true }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		XtendClass xtendClass = xtendFile.getXtendClass();
		EList<JvmMember> jvmMembers = inferredType.getMembers();
		assertEquals(1, jvmMembers.size());
		JvmMember jvmMember = jvmMembers.get(0);
		assertTrue(jvmMember instanceof JvmOperation);
		XtendMember xtendMember = xtendClass.getMembers().get(0);
		assertEquals(xtendMember.getCanonicalName(), jvmMember.getCanonicalName());
		assertEquals(jvmMember, xtendMember.getInferredJvmMember());
		assertEquals(xtendMember, sourceAssociator.getXtendSource((JvmOperation) inferredType.getMembers().get(0)));
	}
	
	public void testInferredFunctionWithReturnType() throws Exception {
		XtendFile xtendFile = file("class Foo { Boolean bar() true }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(0);
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertFalse(xtendFunction.getReturnType() == jvmOperation.getReturnType());
		assertEquals(xtendFunction.getReturnType().getType(), jvmOperation.getReturnType().getType());
	}
	
	public void testInferredFunctionWithParameter() throws Exception {
		XtendFile xtendFile = file("class Foo { bar(Boolean baz) true }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(0);
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertEquals(1, jvmOperation.getParameters().size());
		JvmFormalParameter jvmParameter = jvmOperation.getParameters().get(0);
		JvmFormalParameter xtendParameter = xtendFunction.getParameters().get(0);
		assertEquals(xtendParameter.getCanonicalName(), jvmParameter.getCanonicalName());
		assertEquals(xtendParameter.getParameterType().getType(), jvmParameter.getParameterType().getType());
	}
	
	public void testInferredFunctionWithSelfTypeReference() throws Exception {
		XtendFile xtendFile = file("package foo class Foo { Foo bar() this }");
		JvmGenericType inferredType = getInferredType(xtendFile);
		JvmOperation jvmOperation = (JvmOperation) inferredType.getMembers().get(0);
		assertEquals(inferredType, jvmOperation.getReturnType().getType());
		XtendFunction xtendFunction = (XtendFunction) xtendFile.getXtendClass().getMembers().get(0);
		assertEquals(inferredType, xtendFunction.getReturnType().getType());
	}

	protected JvmGenericType getInferredType(XtendFile xtendFile) {
		assertEquals(2, xtendFile.eResource().getContents().size());
		EObject secondRoot = xtendFile.eResource().getContents().get(1);
		assertTrue(secondRoot instanceof JvmGenericType);
		JvmGenericType inferredType = (JvmGenericType) secondRoot;
		return inferredType;
	}
}
