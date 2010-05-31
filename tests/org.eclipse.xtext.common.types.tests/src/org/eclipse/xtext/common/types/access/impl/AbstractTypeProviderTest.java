/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EValidatorRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.testSetups.EmptyAbstractClass;
import org.eclipse.xtext.common.types.testSetups.Fields;
import org.eclipse.xtext.common.types.testSetups.InitializerWithConstructor;
import org.eclipse.xtext.common.types.testSetups.InitializerWithoutConstructor;
import org.eclipse.xtext.common.types.testSetups.NestedTypes;
import org.eclipse.xtext.common.types.testSetups.ParameterizedMethods;
import org.eclipse.xtext.common.types.testSetups.ParameterizedTypes;
import org.eclipse.xtext.common.types.testSetups.StaticNestedTypes;
import org.eclipse.xtext.common.types.testSetups.TestAnnotation;
import org.eclipse.xtext.common.types.testSetups.TestEnum;
import org.eclipse.xtext.common.types.testSetups.TypeWithInnerAnnotation;
import org.eclipse.xtext.common.types.testSetups.TypeWithInnerEnum;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeProviderTest extends TestCase {

	private Diagnostician diagnostician;

	protected abstract ITypeProvider getTypeProvider();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EValidator.Registry registry = new EValidatorRegistryImpl(EValidator.Registry.INSTANCE);
		registry.put(TypesPackage.eINSTANCE, new EObjectValidator());
		diagnostician = new Diagnostician(registry);
	}

	protected void diagnose(EObject object) {
		Resource resource = object.eResource();
		for (EObject content : resource.getContents()) {
			Diagnostic diagnostic = diagnostician.validate(content);
			assertTrue(diagnostic.toString(), diagnostic.getSeverity() == Diagnostic.OK);
		}
	}

	public void testFindTypeByName_int() {
		String typeName = "int";
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmPrimitiveType);
		assertEquals(typeName, type.getCanonicalName());
		diagnose(type);
	}

	public void testFindTypeByName_int_twice() {
		String typeName = "int";
		JvmType firstType = getTypeProvider().findTypeByName(typeName);
		JvmType secondType = getTypeProvider().findTypeByName(typeName);
		assertSame(firstType, secondType);
	}

	public void testFindTypeByName_int_array_01() {
		String typeName = "int[]";
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmArrayType);
		assertEquals(typeName, type.getCanonicalName());
		diagnose(type);
	}

	public void testFindTypeByName_int_array_02() {
		String typeName = int[].class.getName();
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmArrayType);
		assertEquals("int[]", type.getCanonicalName());
	}

	public void testFindTypeByName_int_array_03() {
		String typeName = int[][][].class.getName();
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmArrayType);
		assertEquals("int[][][]", type.getCanonicalName());
		diagnose(type);
	}

	public void testFindTypeByName_int_array_04() {
		String typeName = "int[][][]";
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmArrayType);
		assertEquals(typeName, type.getCanonicalName());
	}

	public void testFindTypeByName_javaLangCharSequence_01() {
		String typeName = CharSequence.class.getName();
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmGenericType);
		assertEquals(typeName, type.getCanonicalName());
		diagnose(type);
	}

	public void testFindTypeByName_javaLangCharSequence_02() {
		String typeName = CharSequence.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(4, type.getMembers().size());
		Set<String> allNames = Sets.newHashSet("length", "charAt", "subSequence", "toString");
		for (org.eclipse.xtext.common.types.JvmMember member : type.getMembers()) {
			assertTrue(member.getCanonicalName(), member instanceof JvmOperation);
			JvmOperation op = (JvmOperation) member;
			assertTrue(op.getSimpleName(), allNames.remove(op.getSimpleName()));
		}
	}

	public void testFindTypeByName_javaLangCharSequence_03() {
		String typeName = CharSequence.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation length = (JvmOperation) type.eResource().getEObject("java.lang.CharSequence.length()");
		assertNotNull(length);
		JvmType returnType = length.getReturnType().getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("int", returnType.getCanonicalName());
	}

	public void testFindTypeByName_javaLangCharSequence_04() {
		String typeName = CharSequence.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation charAt = (JvmOperation) type.eResource().getEObject("java.lang.CharSequence.charAt(int)");
		assertNotNull(charAt);
		JvmType returnType = charAt.getReturnType().getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("char", returnType.getCanonicalName());
		assertEquals(1, charAt.getParameters().size());
		JvmType intType = getTypeProvider().findTypeByName("int");
		assertSame(intType, charAt.getParameters().get(0).getParameterType().getType());
	}

	public void testFindTypeByName_javaLangNumber_01() {
		String typeName = Number.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(type.getSuperTypes().toString(), 2, type.getSuperTypes().size());
		JvmType objectType = type.getSuperTypes().get(0).getType();
		assertFalse("isProxy: " + objectType, objectType.eIsProxy());
		assertEquals(Object.class.getName(), objectType.getCanonicalName());
		JvmType serializableType = type.getSuperTypes().get(1).getType();
		assertFalse("isProxy: " + serializableType, serializableType.eIsProxy());
		assertEquals(Serializable.class.getName(), serializableType.getCanonicalName());
		diagnose(type);
	}

	public void testFindTypeByName_javaLangNumber_02() {
		String typeName = Number[][].class.getName();
		JvmArrayType type = (JvmArrayType) getTypeProvider().findTypeByName(typeName);
		JvmOperation longValue = (JvmOperation) type.eResource().getEObject("java.lang.Number.longValue()");
		assertNotNull(longValue);
		JvmDeclaredType number = longValue.getDeclaringType();
		assertNotNull(number.getArrayType());
		assertSame(type, number.getArrayType().getArrayType());
		assertNull(type.getArrayType());
		diagnose(type);
	}

	public void testFindTypeByName_javaUtilList_01() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		assertEquals(1, type.getTypeParameters().size());
		JvmTypeParameter typeVariable = type.getTypeParameters().get(0);
		assertEquals("E", typeVariable.getName());
		assertEquals(1, typeVariable.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertSame(typeVariable, upperBound.getOwner());
		assertNotNull(upperBound.getTypeReference());
		assertFalse(upperBound.getTypeReference().getType().eIsProxy());
		assertEquals(Object.class.getName(), upperBound.getTypeReference().getCanonicalName());
		diagnose(type);
	}

	public void testFindTypeByName_javaUtilList_02() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation toArray = (JvmOperation) type.eResource().getEObject("java.util.List.toArray()");
		assertNotNull(toArray);
		assertEquals("java.lang.Object[]", toArray.getReturnType().getCanonicalName());
	}

	public void testFindTypeByName_javaUtilList_03() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation toArray = (JvmOperation) type.eResource().getEObject("java.util.List.toArray(T[])");
		assertNotNull(toArray);
		assertEquals("T[]", toArray.getReturnType().getCanonicalName());
	}

	public void testFindTypeByName_javaUtilList_04() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation addAll = (JvmOperation) type.eResource().getEObject("java.util.List.addAll(java.util.Collection)");
		assertNotNull(addAll);
		assertEquals("boolean", addAll.getReturnType().getCanonicalName());
	}

	public void testFindTypeByName_javaUtilList_05() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation addAll = (JvmOperation) type.eResource().getEObject("java.util.List.addAll(java.util.Collection)");
		assertEquals(1, addAll.getParameters().size());
		assertEquals(getCollectionParamName(), addAll.getParameters().get(0).getName());
		JvmType parameterType = addAll.getParameters().get(0).getParameterType().getType();
		assertFalse(parameterType.toString(), parameterType.eIsProxy());
	}

	public void testFindTypeByName_javaUtilList_06() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation containsAll = (JvmOperation) type.eResource().getEObject(
				"java.util.List.containsAll(java.util.Collection)");
		assertEquals(1, containsAll.getParameters().size());
		assertEquals(getCollectionParamName(), containsAll.getParameters().get(0).getName());
		JvmType parameterType = containsAll.getParameters().get(0).getParameterType().getType();
		assertFalse(parameterType.toString(), parameterType.eIsProxy());
	}

	public void testFindTypeByName_javaUtilList_07() {
		String typeName = List.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(1, type.getSuperTypes().size());
		JvmParameterizedTypeReference superType = (JvmParameterizedTypeReference) type.getSuperTypes().get(0);
		assertFalse(superType.getType().eIsProxy());
		assertEquals("java.util.Collection<E>", superType.getCanonicalName());
		assertEquals(1, type.getTypeParameters().size());
		JvmType rawType = superType.getType();
		assertFalse(rawType.eIsProxy());
		assertEquals(1, superType.getArguments().size());
		JvmTypeArgument superTypeParameter = superType.getArguments().get(0);
		assertTrue(superTypeParameter instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument castedSuperTypeParameter = (JvmReferenceTypeArgument) superTypeParameter;
		JvmType parameterType = castedSuperTypeParameter.getTypeReference().getType();
		assertFalse(parameterType.eIsProxy());
		assertSame(parameterType, type.getTypeParameters().get(0));
	}

	private JvmOperation getMethodFromParameterizedMethods(String method) {
		String typeName = ParameterizedMethods.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		JvmOperation result = (JvmOperation) type.eResource().getEObject(ParameterizedMethods.class.getName() + "." + method);
		assertNotNull(result);
		return result;
	}

	public void testMemberCount_01() {
		String typeName = ParameterizedMethods.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = ParameterizedMethods.class.getDeclaredMethods().length;
		assertEquals(10, methodCount);
		int constructorCount = ParameterizedMethods.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount);
		assertEquals(methodCount + constructorCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_02() {
		String typeName = InitializerWithConstructor.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = InitializerWithConstructor.class.getDeclaredMethods().length;
		assertEquals(0, methodCount);
		int constructorCount = InitializerWithConstructor.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount);
		assertEquals(methodCount + constructorCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_03() {
		String typeName = InitializerWithoutConstructor.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = InitializerWithoutConstructor.class.getDeclaredMethods().length;
		assertEquals(0, methodCount);
		int constructorCount = InitializerWithoutConstructor.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		assertEquals(methodCount + constructorCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_04() {
		String typeName = NestedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = NestedTypes.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = NestedTypes.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = NestedTypes.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_05() {
		String typeName = NestedTypes.Outer.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = NestedTypes.Outer.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = NestedTypes.Outer.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = NestedTypes.Outer.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
	}

	public void testMemberCount_06() {
		String typeName = NestedTypes.Outer.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = NestedTypes.Outer.Inner.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = NestedTypes.Outer.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		assertEquals(methodCount + constructorCount, type.getMembers().size());
	}

	public void testMemberCount_07() {
		String typeName = StaticNestedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = StaticNestedTypes.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = StaticNestedTypes.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = StaticNestedTypes.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_08() {
		String typeName = StaticNestedTypes.Outer.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = StaticNestedTypes.Outer.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = StaticNestedTypes.Outer.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = StaticNestedTypes.Outer.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
	}

	public void testMemberCount_09() {
		String typeName = StaticNestedTypes.Outer.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = StaticNestedTypes.Outer.Inner.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = StaticNestedTypes.Outer.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		assertEquals(methodCount + constructorCount, type.getMembers().size());
	}

	public void testMemberCount_10() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = ParameterizedTypes.class.getDeclaredMethods().length;
		assertEquals(5, methodCount);
		int constructorCount = ParameterizedTypes.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = ParameterizedTypes.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_11() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = ParameterizedTypes.Inner.class.getDeclaredMethods().length;
		assertEquals(7, methodCount);
		int fieldCount = ParameterizedTypes.Inner.class.getDeclaredFields().length;
		assertEquals(1, fieldCount);
		assertEquals(methodCount + fieldCount, type.getMembers().size());
	}

	public void testMemberCount_12() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int constructorCount = Fields.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int fieldCount = Fields.class.getDeclaredFields().length;
		assertEquals(5, fieldCount);
		int nestedCount = Fields.class.getDeclaredClasses().length;
		assertEquals(1, nestedCount);
		assertEquals(nestedCount + constructorCount + fieldCount, type.getMembers().size());
		diagnose(type);
	}

	public void testMemberCount_13() {
		String typeName = Fields.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		int constructorCount = Fields.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int fieldCount = Fields.Inner.class.getDeclaredFields().length;
		assertEquals(1, fieldCount);
		assertEquals(constructorCount + fieldCount, type.getMembers().size());
	}
	
	public void testMemberCount_14() {
		String typeName = TestAnnotation.class.getName();
		JvmAnnotationType type = (JvmAnnotationType) getTypeProvider().findTypeByName(typeName);
		int methodCount = TestAnnotation.class.getDeclaredMethods().length;
		assertEquals(14, methodCount);
		int innerTypesCount = TestAnnotation.class.getDeclaredClasses().length;
		assertEquals(2, innerTypesCount);
		assertEquals(methodCount + innerTypesCount, type.getMembers().size());
	}
	
	public void testMemberCount_15() {
		String typeName = EmptyAbstractClass.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		int constructorCount = EmptyAbstractClass.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount);
		assertEquals(1, type.getMembers().size());
	}
	
	public void testMemberCount_16() {
		String typeName = TestEnum.class.getName();
		JvmEnumerationType type = (JvmEnumerationType) getTypeProvider().findTypeByName(typeName);
		int innerTypesCount = TestEnum.class.getDeclaredClasses().length;
		assertEquals(0, innerTypesCount);
		int methodCount = TestEnum.class.getDeclaredMethods().length;
		// TestEnum.values + TestEnum.valueOf
		assertEquals(2, methodCount);
		int constructorCount = TestEnum.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount);
		int fieldCount = TestEnum.class.getDeclaredFields().length;
		// FirstValue, SecondValue, string, ENUM$VALUES
		assertEquals(Arrays.toString(TestEnum.class.getDeclaredFields()), 4, fieldCount);
		// ENUM$VALUES is synthetic
		assertEquals(type.getMembers().toString(), innerTypesCount + methodCount + constructorCount + fieldCount - 1, type.getMembers().size());
	}

	public void test_twoListParamsNoResult_01() {
		JvmOperation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		assertEquals(2, twoListParamsNoResult.getParameters().size());
	}

	public void test_twoListParamsNoResult_02() {
		JvmOperation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		JvmFormalParameter firstParam = twoListParamsNoResult.getParameters().get(0);
		JvmTypeReference paramType = firstParam.getParameterType();
		assertNotNull(paramType);
		assertFalse(paramType.getType().eIsProxy());
		assertEquals("java.util.List<T>", paramType.getCanonicalName());
		assertTrue(paramType instanceof JvmParameterizedTypeReference);
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) paramType;
		JvmType rawType = parameterized.getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}

	public void test_twoListParamsNoResult_03() {
		JvmOperation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		JvmFormalParameter firstParam = twoListParamsNoResult.getParameters().get(0);
		JvmTypeReference paramType = firstParam.getParameterType();
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) paramType;
		assertEquals(1, parameterized.getArguments().size());
		JvmTypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument referenceTypeParameter = (JvmReferenceTypeArgument) typeParameter;
		JvmType referencedType = referenceTypeParameter.getTypeReference().getType();
		assertFalse(referencedType.eIsProxy());
		assertTrue(referencedType instanceof JvmTypeParameter);
		JvmTypeParameter typeVar = (JvmTypeParameter) referencedType;
		assertEquals("T", typeVar.getName());
		assertSame(twoListParamsNoResult, typeVar.getDeclarator());
	}

	public void test_twoListParamsListResult_01() {
		JvmOperation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		assertEquals(2, twoListParamsListResult.getParameters().size());
	}

	public void test_twoListParamsListResult_02() {
		JvmOperation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		JvmTypeReference returnType = twoListParamsListResult.getReturnType();
		assertNotNull(returnType);
		assertEquals("java.util.List<T>", returnType.getCanonicalName());
		assertTrue(returnType instanceof JvmParameterizedTypeReference);
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) returnType;
		JvmType rawType = parameterized.getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}

	public void test_twoListParamsListResult_03() {
		JvmOperation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		JvmTypeReference returnType = twoListParamsListResult.getReturnType();
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) returnType;
		assertEquals(1, parameterized.getArguments().size());
		JvmTypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument referenceTypeParameter = (JvmReferenceTypeArgument) typeParameter;
		JvmType referencedType = referenceTypeParameter.getTypeReference().getType();
		assertFalse(referencedType.eIsProxy());
		assertTrue(referencedType instanceof JvmTypeParameter);
		JvmTypeParameter typeVar = (JvmTypeParameter) referencedType;
		assertEquals("T", typeVar.getName());
		assertSame(twoListParamsListResult, typeVar.getDeclarator());
	}

	public void test_twoListWildcardsNoResult_01() {
		JvmOperation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		assertEquals(2, twoListWildcardsNoResult.getParameters().size());
	}

	public void test_twoListWildcardsNoResult_02() {
		JvmOperation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		JvmFormalParameter firstParam = twoListWildcardsNoResult.getParameters().get(0);
		JvmTypeReference paramType = firstParam.getParameterType();
		assertNotNull(paramType);
		assertEquals("java.util.List<? extends java.lang.Object>", paramType.getCanonicalName());
		assertTrue(paramType instanceof JvmParameterizedTypeReference);
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) paramType;
		JvmType rawType = parameterized.getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}

	public void test_twoListWildcardsNoResult_03() {
		JvmOperation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		JvmFormalParameter firstParam = twoListWildcardsNoResult.getParameters().get(0);
		JvmTypeReference paramType = firstParam.getParameterType();
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) paramType;
		assertEquals(1, parameterized.getArguments().size());
		JvmTypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcard = (JvmWildcardTypeArgument) typeParameter;
		assertEquals(1, wildcard.getConstraints().size());
		assertTrue(wildcard.getConstraints().get(0) instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) wildcard.getConstraints().get(0);
		assertNotNull(upperBound.getTypeReference());
		JvmType upperBoundType = upperBound.getTypeReference().getType();
		assertFalse(upperBoundType.eIsProxy());
		assertEquals("java.lang.Object", upperBoundType.getCanonicalName());
	}

	public void test_twoListWildcardsListResult_01() {
		JvmOperation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		assertEquals(2, twoListWildcardsListResult.getParameters().size());
	}

	public void test_twoListWildcardsListResult_02() {
		JvmOperation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		JvmTypeReference returnType = twoListWildcardsListResult.getReturnType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object>", returnType.getCanonicalName());
		assertTrue(returnType instanceof JvmParameterizedTypeReference);
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) returnType;
		JvmType rawType = parameterized.getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}

	public void test_twoListWildcardsListResult_03() {
		JvmOperation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		JvmTypeReference returnType = twoListWildcardsListResult.getReturnType();
		JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) returnType;
		assertEquals(1, parameterized.getArguments().size());
		JvmTypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcard = (JvmWildcardTypeArgument) typeParameter;
		assertEquals(1, wildcard.getConstraints().size());
		assertTrue(wildcard.getConstraints().get(0) instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) wildcard.getConstraints().get(0);
		assertNotNull(upperBound.getTypeReference());
		JvmType upperBoundType = upperBound.getTypeReference().getType();
		assertFalse(upperBoundType.eIsProxy());
		assertEquals("java.lang.Object", upperBoundType.getCanonicalName());
	}

	public void test_arrayWildcard_01() {
		JvmOperation arrayWildcard = getMethodFromParameterizedMethods("arrayWildcard(java.util.List[])");
		assertEquals(1, arrayWildcard.getParameters().size());
	}

	public void test_arrayWildcard_02() {
		JvmOperation arrayWildcard = getMethodFromParameterizedMethods("arrayWildcard(java.util.List[])");
		JvmTypeReference paramType = arrayWildcard.getParameters().get(0).getParameterType();
		assertEquals("java.util.List<? extends java.lang.Object>[]", paramType.getCanonicalName());
		assertTrue(paramType.getType() instanceof JvmArrayType);
		JvmArrayType arrayType = (JvmArrayType) paramType.getType();
		assertTrue(arrayType.getComponentType() instanceof JvmParameterizedTypeReference);
	}

	public void test_nestedArrayWildcard_01() {
		JvmOperation nestedArrayWildcard = getMethodFromParameterizedMethods("nestedArrayWildcard(java.util.List[][])");
		assertEquals(1, nestedArrayWildcard.getParameters().size());
	}

	public void test_nestedArrayWildcard_02() {
		JvmOperation nestedArrayWildcard = getMethodFromParameterizedMethods("nestedArrayWildcard(java.util.List[][])");
		JvmTypeReference paramType = nestedArrayWildcard.getParameters().get(0).getParameterType();
		assertTrue(paramType.getType() instanceof JvmArrayType);
		JvmArrayType arrayType = (JvmArrayType) paramType.getType();
		assertTrue(arrayType.getComponentType().getType() instanceof JvmArrayType);
		arrayType = (JvmArrayType) arrayType.getComponentType().getType();
		assertTrue(arrayType.getComponentType() instanceof JvmParameterizedTypeReference);
	}

	public void test_arrayParameterized_01() {
		JvmOperation arrayParameterized = getMethodFromParameterizedMethods("arrayParameterized(java.util.List[])");
		assertEquals(1, arrayParameterized.getParameters().size());
	}

	public void test_arrayParameterized_02() {
		JvmOperation arrayParameterized = getMethodFromParameterizedMethods("arrayParameterized(java.util.List[])");
		JvmTypeReference paramType = arrayParameterized.getParameters().get(0).getParameterType();
		assertEquals("java.util.List<T>[]", paramType.getCanonicalName());
		assertTrue(paramType.getType() instanceof JvmArrayType);
		JvmArrayType arrayType = (JvmArrayType) paramType.getType();
		assertTrue(arrayType.getComponentType() instanceof JvmParameterizedTypeReference);
	}

	public void test_nestedArrayParameterized_01() {
		JvmOperation nestedArrayParameterized = getMethodFromParameterizedMethods("nestedArrayParameterized(java.util.List[][])");
		assertEquals(1, nestedArrayParameterized.getParameters().size());
	}

	public void test_nestedArrayParameterized_02() {
		JvmOperation nestedArrayParameterized = getMethodFromParameterizedMethods("nestedArrayParameterized(java.util.List[][])");
		JvmTypeReference paramType = nestedArrayParameterized.getParameters().get(0).getParameterType();
		assertTrue(paramType.getType() instanceof JvmArrayType);
		JvmArrayType arrayType = (JvmArrayType) paramType.getType();
		assertTrue(arrayType.getComponentType().getType() instanceof JvmArrayType);
		arrayType = (JvmArrayType) arrayType.getComponentType().getType();
		assertTrue(arrayType.getComponentType() instanceof JvmParameterizedTypeReference);
	}

	public void test_arrayVariable_01() {
		JvmOperation arrayVariable = getMethodFromParameterizedMethods("arrayVariable(T[])");
		assertEquals(1, arrayVariable.getParameters().size());
	}

	public void test_arrayVariable_02() {
		JvmOperation arrayVariable = getMethodFromParameterizedMethods("arrayVariable(T[])");
		JvmType paramType = arrayVariable.getParameters().get(0).getParameterType().getType();
		assertEquals("T[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof JvmArrayType);
		JvmArrayType arrayType = (JvmArrayType) paramType;
		assertTrue(arrayType.getComponentType().getType() instanceof JvmTypeParameter);
	}

	public void test_nestedArrayVariable_01() {
		JvmOperation nestedArrayVariable = getMethodFromParameterizedMethods("nestedArrayVariable(T[][])");
		assertEquals(1, nestedArrayVariable.getParameters().size());
	}

	public void test_nestedArrayVariable_02() {
		JvmOperation nestedArrayVariable = getMethodFromParameterizedMethods("nestedArrayVariable(T[][])");
		JvmType paramType = nestedArrayVariable.getParameters().get(0).getParameterType().getType();
		assertTrue(paramType instanceof JvmArrayType);
		JvmArrayType arrayType = (JvmArrayType) paramType;
		assertTrue(arrayType.getComponentType().getType() instanceof JvmArrayType);
		arrayType = (JvmArrayType) arrayType.getComponentType().getType();
		assertTrue(arrayType.getComponentType().getType() instanceof JvmTypeParameter);
	}

	public void test_nestedTypes_Outer() {
		String typeName = NestedTypes.Outer.class.getName();
		String expectedSuffix = NestedTypes.class.getSimpleName() + "$" + NestedTypes.Outer.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		JvmType outerType = (JvmType) type.eContainer();
		assertEquals(NestedTypes.class.getName(), outerType.getCanonicalName());
	}

	public void test_nestedTypes_Outer_Inner() {
		String typeName = NestedTypes.Outer.Inner.class.getName();
		String expectedSuffix = NestedTypes.class.getSimpleName() + "$" + NestedTypes.Outer.class.getSimpleName() + "$"
				+ NestedTypes.Outer.Inner.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		JvmType outerType = (JvmType) type.eContainer();
		assertEquals(NestedTypes.Outer.class.getName(), outerType.getCanonicalName());
	}

	public void test_staticNestedTypes_method() {
		String typeName = StaticNestedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation operation = getMethodFromType(type, StaticNestedTypes.class, "method()");
		assertEquals("boolean", operation.getReturnType().getCanonicalName());
	}

	public void test_staticNestedTypes_Outer() {
		String typeName = StaticNestedTypes.Outer.class.getName();
		String expectedSuffix = StaticNestedTypes.class.getSimpleName() + "$"
				+ StaticNestedTypes.Outer.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		JvmType outerType = (JvmType) type.eContainer();
		assertEquals(StaticNestedTypes.class.getName(), outerType.getCanonicalName());
	}

	public void test_staticNestedTypes_Outer_method() {
		String typeName = StaticNestedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation operation = getMethodFromType(type, StaticNestedTypes.Outer.class, "method()");
		assertEquals("int", operation.getReturnType().getCanonicalName());
	}

	public void test_staticNestedTypes_Outer_Inner() {
		String typeName = StaticNestedTypes.Outer.Inner.class.getName();
		String expectedSuffix = StaticNestedTypes.class.getSimpleName() + "$"
				+ StaticNestedTypes.Outer.class.getSimpleName() + "$"
				+ StaticNestedTypes.Outer.Inner.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		JvmType outerType = (JvmType) type.eContainer();
		assertEquals(StaticNestedTypes.Outer.class.getName(), outerType.getCanonicalName());
	}

	public void test_staticNestedTypes_Outer_Inner_method() {
		String typeName = StaticNestedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation operation = getMethodFromType(type, StaticNestedTypes.Outer.Inner.class, "method()");
		assertEquals("void", operation.getReturnType().getCanonicalName());
	}

	private JvmOperation getMethodFromType(EObject context, Class<?> type, String method) {
		String methodName = type.getName() + "." + method;
		assertNotNull(context);
		JvmOperation result = (JvmOperation) context.eResource().getEObject(methodName);
		assertNotNull(methodName, result);
		return result;
	}
	
	private JvmConstructor getConstructorFromType(EObject context, Class<?> type, String constructor) {
		String methodName = type.getName() + "." + constructor;
		assertNotNull(context);
		JvmConstructor result = (JvmConstructor) context.eResource().getEObject(methodName);
		assertNotNull(methodName, result);
		return result;
	}

	public void test_ParameterizedTypes_01() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(5, type.getTypeParameters().size());
	}

	public void test_ParameterizedTypes_02() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodS = getMethodFromType(type, ParameterizedTypes.class, "methodS(S)");
		JvmTypeReference listS = methodS.getReturnType();
		assertFalse(listS.toString(), listS.eIsProxy());
		assertEquals("java.util.List<? extends S>", listS.getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listS;
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcardTypeArgument = (JvmWildcardTypeArgument) typeArgument;
		assertEquals("? extends S", wildcardTypeArgument.getCanonicalName());
		assertEquals(1, wildcardTypeArgument.getConstraints().size());
		JvmUpperBound upperBound = (JvmUpperBound) wildcardTypeArgument.getConstraints().get(0);
		JvmTypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, upperBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_03() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodT = getMethodFromType(type, ParameterizedTypes.class, "methodT(T)");
		JvmTypeReference listS = methodT.getReturnType();
		assertFalse(listS.toString(), listS.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object & super T>", listS.getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listS;
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcardTypeArgument = (JvmWildcardTypeArgument) typeArgument;
		assertEquals("? extends java.lang.Object & super T", wildcardTypeArgument.getCanonicalName());
		assertEquals(2, wildcardTypeArgument.getConstraints().size());
		JvmUpperBound uperBound = (JvmUpperBound) wildcardTypeArgument.getConstraints().get(0);
		assertEquals("java.lang.Object", uperBound.getTypeReference().getCanonicalName());
		JvmLowerBound lowerBound = (JvmLowerBound) wildcardTypeArgument.getConstraints().get(1);
		JvmTypeParameter t = type.getTypeParameters().get(1);
		assertSame(t, lowerBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_04() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodY = getMethodFromType(type, ParameterizedTypes.class, "methodY(Y)");
		assertEquals(1, methodY.getParameters().size());
		JvmType parameterType = methodY.getParameters().get(0).getParameterType().getType();
		assertFalse(parameterType.eIsProxy());
		assertEquals("Y", parameterType.getCanonicalName());
		assertTrue(parameterType instanceof JvmTypeParameter);
		assertSame(methodY, ((JvmTypeParameter) parameterType).getDeclarator());
		JvmTypeParameter y = (JvmTypeParameter) parameterType;
		assertEquals(1, y.getConstraints().size());
		JvmUpperBound upperBound = (JvmUpperBound) y.getConstraints().get(0);
		JvmTypeParameter t = type.getTypeParameters().get(1);
		assertSame(t, upperBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_05() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodZ = getMethodFromType(type, ParameterizedTypes.class, "methodZ(java.util.List)");
		assertEquals(1, methodZ.getParameters().size());
		assertEquals(1, methodZ.getTypeParameters().size());
		assertEquals("Z", methodZ.getTypeParameters().get(0).getCanonicalName());
		JvmTypeReference listZ = methodZ.getReturnType();
		assertFalse(listZ.toString(), listZ.getType().eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object & super Z>", listZ.getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listZ;
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcardTypeArgument = (JvmWildcardTypeArgument) typeArgument;
		assertEquals("? extends java.lang.Object & super Z", wildcardTypeArgument.getCanonicalName());
		assertEquals(2, wildcardTypeArgument.getConstraints().size());
		JvmUpperBound upperBound = (JvmUpperBound) wildcardTypeArgument.getConstraints().get(0);
		assertEquals("java.lang.Object", upperBound.getTypeReference().getCanonicalName());
		JvmLowerBound lowerBound = (JvmLowerBound) wildcardTypeArgument.getConstraints().get(1);
		assertEquals("Z", lowerBound.getTypeReference().getCanonicalName());
		JvmTypeParameter z = methodZ.getTypeParameters().get(0);
		assertSame(z, lowerBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_06() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodMap = getMethodFromType(type, ParameterizedTypes.class, "methodMap(java.util.Map)");
		assertEquals(1, methodMap.getParameters().size());
		assertEquals(1, methodMap.getTypeParameters().size());
		assertEquals("Z", methodMap.getTypeParameters().get(0).getCanonicalName());
		JvmType z = methodMap.getReturnType().getType();
		assertSame(methodMap.getTypeParameters().get(0), z);
		JvmTypeReference mapType = methodMap.getParameters().get(0).getParameterType();
		assertEquals("java.util.Map<? extends java.lang.Object & super Z,? extends S>", mapType.getCanonicalName());
		JvmParameterizedTypeReference parameterizedMapType = (JvmParameterizedTypeReference) mapType;
		assertEquals(2, parameterizedMapType.getArguments().size());
		JvmWildcardTypeArgument extendsS = (JvmWildcardTypeArgument) parameterizedMapType.getArguments().get(1);
		assertEquals(1, extendsS.getConstraints().size());
		JvmType s = type.getTypeParameters().get(0);
		assertSame(s, extendsS.getConstraints().get(0).getTypeReference().getType());
	}

	public void test_ParameterizedTypes_S_01() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeVariable = type.getTypeParameters().get(0);
		assertEquals("S", typeVariable.getCanonicalName());
		assertSame(type, typeVariable.getDeclarator());
		assertEquals(1, typeVariable.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertEquals("java.lang.Object", upperBound.getTypeReference().getCanonicalName());
	}

	public void test_ParameterizedTypes_T_01() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeVariable = type.getTypeParameters().get(1);
		assertEquals("T", typeVariable.getCanonicalName());
		assertSame(type, typeVariable.getDeclarator());
		assertEquals(1, typeVariable.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertFalse(upperBound.getTypeReference().toString(), upperBound.getTypeReference().eIsProxy());
		assertEquals("S", upperBound.getTypeReference().getCanonicalName());
		JvmTypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, upperBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_U_01() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeVariable = type.getTypeParameters().get(2);
		assertEquals("U", typeVariable.getCanonicalName());
		assertSame(type, typeVariable.getDeclarator());
		assertEquals(1, typeVariable.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertFalse(upperBound.getTypeReference().toString(), upperBound.getTypeReference().eIsProxy());
		assertEquals("java.util.List<S>", upperBound.getTypeReference().getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) upperBound.getTypeReference();
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		JvmTypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, refTypeArgument.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_V_01() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeParameterV = type.getTypeParameters().get(3);
		assertEquals("V", typeParameterV.getCanonicalName());
		assertSame(type, typeParameterV.getDeclarator());
		assertEquals(1, typeParameterV.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameterV.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertFalse(upperBound.getTypeReference().toString(), upperBound.getTypeReference().eIsProxy());
		assertEquals("java.util.List<java.util.List<? extends V>>", upperBound.getTypeReference().getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) upperBound.getTypeReference();
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		assertEquals("java.util.List<? extends V>", refTypeArgument.getCanonicalName());
		JvmParameterizedTypeReference nestedListType = (JvmParameterizedTypeReference) refTypeArgument.getTypeReference();
		assertEquals(1, nestedListType.getArguments().size());
		JvmTypeArgument nestedArgument = nestedListType.getArguments().get(0);
		assertTrue(nestedArgument instanceof JvmWildcardTypeArgument);
		assertEquals(1, ((JvmWildcardTypeArgument) nestedArgument).getConstraints().size());
		JvmUpperBound nestedUpperBound = (JvmUpperBound) ((JvmWildcardTypeArgument) nestedArgument).getConstraints().get(0);
		assertSame(typeParameterV, nestedUpperBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_W_01() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeParameterW = type.getTypeParameters().get(4);
		assertEquals("W", typeParameterW.getCanonicalName());
		assertSame(type, typeParameterW.getDeclarator());
		assertEquals(2, typeParameterW.getConstraints().size());
		JvmTypeConstraint firstTypeConstraint = typeParameterW.getConstraints().get(0);
		assertTrue(firstTypeConstraint instanceof JvmUpperBound);
		JvmUpperBound firstUpperBound = (JvmUpperBound) firstTypeConstraint;
		assertNotNull(firstUpperBound.getTypeReference());
		assertFalse(firstUpperBound.getTypeReference().toString(), firstUpperBound.getTypeReference().eIsProxy());
		assertEquals("java.lang.Comparable<S>", firstUpperBound.getTypeReference().getCanonicalName());
		JvmParameterizedTypeReference comparableType = (JvmParameterizedTypeReference) firstUpperBound.getTypeReference();
		assertEquals(1, comparableType.getArguments().size());
		JvmTypeArgument typeArgument = comparableType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		assertEquals(refTypeArgument.toString(), "S", refTypeArgument.getCanonicalName());
		JvmTypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, refTypeArgument.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_W_02() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeParameterW = type.getTypeParameters().get(4);
		assertEquals("W", typeParameterW.getCanonicalName());
		assertSame(type, typeParameterW.getDeclarator());
		assertEquals(2, typeParameterW.getConstraints().size());

		JvmTypeConstraint secondTypeConstraint = typeParameterW.getConstraints().get(1);
		assertTrue(secondTypeConstraint instanceof JvmUpperBound);
		JvmUpperBound secondUpperBound = (JvmUpperBound) secondTypeConstraint;
		assertNotNull(secondUpperBound.getTypeReference());
		assertFalse(secondUpperBound.getTypeReference().toString(), secondUpperBound.getTypeReference().eIsProxy());
		assertEquals("java.io.Serializable", secondUpperBound.getTypeReference().getCanonicalName());
	}

	public void test_ParameterizedTypes_Inner_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(3, type.getTypeParameters().size());
	}

	public void test_ParameterizedTypes_Inner_02() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodS = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodS()");
		JvmType s = methodS.getReturnType().getType();
		assertFalse(s.toString(), s.eIsProxy());
		assertTrue(s instanceof JvmTypeParameter);
		JvmTypeParameter sParam = (JvmTypeParameter) s;
		assertSame(type, sParam.getDeclarator());
	}

	public void test_ParameterizedTypes_Inner_03() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodX = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodX()");
		JvmType x = methodX.getReturnType().getType();
		assertFalse(x.toString(), x.eIsProxy());
		assertTrue(x instanceof JvmTypeParameter);
		JvmTypeParameter xParam = (JvmTypeParameter) x;
		assertSame(type, xParam.getDeclarator());
	}

	public void test_ParameterizedTypes_Inner_04() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodT = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodT()");
		JvmTypeReference listT = methodT.getReturnType();
		assertEquals("java.util.List<T>", listT.getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listT;
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		assertEquals("T", refTypeArgument.getCanonicalName());
		JvmTypeParameter t = ((JvmTypeParameterDeclarator) type.getDeclaringType()).getTypeParameters().get(1);
		assertSame(t, refTypeArgument.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_Inner_05() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodVArray_01()");
		JvmTypeReference listT = methodV.getReturnType();
		assertEquals("java.util.List<? extends V>[]", listT.getCanonicalName());
		JvmArrayType listArrayType = (JvmArrayType) listT.getType();
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listArrayType.getComponentType();
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcardTypeArgument = (JvmWildcardTypeArgument) typeArgument;
		assertEquals("? extends V", wildcardTypeArgument.getCanonicalName());
		assertEquals(1, wildcardTypeArgument.getConstraints().size());
		JvmUpperBound upperBound = (JvmUpperBound) wildcardTypeArgument.getConstraints().get(0);
		JvmTypeParameter v = type.getTypeParameters().get(3);
		assertSame(v, upperBound.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_Inner_06() {
		String typeName = ParameterizedTypes.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodVArray_02()");
		JvmTypeReference listV = methodV.getReturnType();
		assertEquals("java.util.List<? extends V[]>", listV.getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listV;
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmWildcardTypeArgument);
		JvmWildcardTypeArgument wildcardTypeArgument = (JvmWildcardTypeArgument) typeArgument;
		assertEquals("? extends V[]", wildcardTypeArgument.getCanonicalName());
		assertEquals(1, wildcardTypeArgument.getConstraints().size());
		JvmUpperBound upperBound = (JvmUpperBound) wildcardTypeArgument.getConstraints().get(0);
		JvmType upperBoundType = upperBound.getTypeReference().getType();
		assertTrue(upperBoundType instanceof JvmArrayType);
		assertTrue(((JvmArrayType) upperBoundType).getComponentType().getType() instanceof JvmTypeParameter);
		JvmTypeParameter v = type.getTypeParameters().get(3);
		assertSame(v, ((JvmArrayType) upperBoundType).getComponentType().getType());
	}

	public void test_ParameterizedTypes_Inner_07() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodZArray_01()");
		JvmTypeReference listZ = methodV.getReturnType();
		assertEquals("java.util.List<Z[][]>", listZ.getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listZ;
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		JvmType argumentType = refTypeArgument.getTypeReference().getType();
		assertTrue(argumentType instanceof JvmArrayType);
		assertTrue(((JvmArrayType) argumentType).getComponentType().getType() instanceof JvmArrayType);
		JvmComponentType componentType = (JvmComponentType) ((JvmArrayType) ((JvmArrayType) argumentType).getComponentType()
				.getType()).getComponentType().getType();
		JvmTypeParameter z = type.getTypeParameters().get(2);
		assertSame(z, componentType);
	}

	public void test_ParameterizedTypes_Inner_08() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodZArray_02()");
		JvmTypeReference listZ = methodV.getReturnType();
		assertEquals("java.util.List<Z[]>[]", listZ.getCanonicalName());
		JvmArrayType listArrayType = (JvmArrayType) listZ.getType();
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) listArrayType.getComponentType();
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		JvmType argumentType = refTypeArgument.getTypeReference().getType();
		assertTrue(argumentType instanceof JvmArrayType);
		JvmComponentType componentType = (JvmComponentType) ((JvmArrayType) argumentType).getComponentType().getType();
		JvmTypeParameter z = type.getTypeParameters().get(2);
		assertSame(z, componentType);
	}

	public void test_ParameterizedTypes_Inner_X_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeParameterX = type.getTypeParameters().get(0);
		assertEquals("X", typeParameterX.getCanonicalName());
		assertSame(type, typeParameterX.getDeclarator());
		assertEquals(1, typeParameterX.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameterX.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertEquals("W", upperBound.getTypeReference().getCanonicalName());
		JvmType upperBoundType = upperBound.getTypeReference().getType();
		assertTrue(upperBoundType instanceof JvmTypeParameter);
		JvmTypeParameter typeParameterW = (JvmTypeParameter) upperBoundType;
		assertSame(type.getDeclaringType(), typeParameterW.getDeclarator());
	}

	public void test_ParameterizedTypes_Inner_Y_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeParameterY = type.getTypeParameters().get(1);
		assertEquals("Y", typeParameterY.getCanonicalName());
		assertSame(type, typeParameterY.getDeclarator());
		assertEquals(1, typeParameterY.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameterY.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertEquals("java.util.List<X>", upperBound.getTypeReference().getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) upperBound.getTypeReference();
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		assertEquals("X", refTypeArgument.getCanonicalName());
		JvmTypeParameter x = type.getTypeParameters().get(0);
		assertSame(x, refTypeArgument.getTypeReference().getType());
	}

	public void test_ParameterizedTypes_Inner_Z_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmTypeParameter typeParameterZ = type.getTypeParameters().get(2);
		assertEquals("Z", typeParameterZ.getCanonicalName());
		assertSame(type, typeParameterZ.getDeclarator());
		assertEquals(1, typeParameterZ.getConstraints().size());
		JvmTypeConstraint typeConstraint = typeParameterZ.getConstraints().get(0);
		assertTrue(typeConstraint instanceof JvmUpperBound);
		JvmUpperBound upperBound = (JvmUpperBound) typeConstraint;
		assertNotNull(upperBound.getTypeReference());
		assertEquals("java.util.List<W>", upperBound.getTypeReference().getCanonicalName());
		JvmParameterizedTypeReference listType = (JvmParameterizedTypeReference) upperBound.getTypeReference();
		assertEquals(1, listType.getArguments().size());
		JvmTypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof JvmReferenceTypeArgument);
		JvmReferenceTypeArgument refTypeArgument = (JvmReferenceTypeArgument) typeArgument;
		assertEquals("W", refTypeArgument.getCanonicalName());
		JvmTypeParameter w = ((JvmTypeParameterDeclarator) type.getDeclaringType()).getTypeParameters().get(4);
		assertSame(w, refTypeArgument.getTypeReference().getType());
	}

	public void testFields_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
	}

	private JvmField getFieldFromType(EObject context, Class<?> type, String field) {
		String fieldName = type.getName() + "." + field;
		assertNotNull(context);
		JvmField result = (JvmField) context.eResource().getEObject(fieldName);
		assertNotNull(fieldName, result);
		return result;
	}

	public void testFields_privateT_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, Fields.class, "privateT");
		assertSame(type, field.getDeclaringType());
		assertEquals(JvmVisibility.PRIVATE, field.getVisibility());
		JvmType fieldType = field.getType().getType();
		assertSame(type.getTypeParameters().get(0), fieldType);
	}

	public void testFields_defaultListT_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, Fields.class, "defaultListT");
		assertSame(type, field.getDeclaringType());
		assertEquals(JvmVisibility.DEFAULT, field.getVisibility());
		JvmTypeReference fieldType = field.getType();
		assertEquals("java.util.List<T>", fieldType.getCanonicalName());
		assertTrue(fieldType instanceof JvmParameterizedTypeReference);
		JvmParameterizedTypeReference parameterizedFieldType = (JvmParameterizedTypeReference) fieldType;
		JvmReferenceTypeArgument refTypeArg = (JvmReferenceTypeArgument) parameterizedFieldType.getArguments().get(0);
		assertSame(type.getTypeParameters().get(0), refTypeArg.getTypeReference().getType());
	}

	public void testFields_protectedString_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, Fields.class, "protectedString");
		assertSame(type, field.getDeclaringType());
		assertEquals(JvmVisibility.PROTECTED, field.getVisibility());
		JvmType fieldType = field.getType().getType();
		assertEquals("java.lang.String", fieldType.getCanonicalName());
	}

	public void testFields_protectedStaticString_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, Fields.class, "protectedStaticString");
		assertSame(type, field.getDeclaringType());
		assertTrue(field.isStatic());
		assertEquals(JvmVisibility.PROTECTED, field.getVisibility());
		JvmType fieldType = field.getType().getType();
		assertEquals("java.lang.String", fieldType.getCanonicalName());
	}

	public void testFields_publicInt_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, Fields.class, "publicInt");
		assertSame(type, field.getDeclaringType());
		assertEquals(JvmVisibility.PUBLIC, field.getVisibility());
		JvmType fieldType = field.getType().getType();
		assertEquals("int", fieldType.getCanonicalName());
		assertTrue(field.getType().getType() instanceof JvmPrimitiveType);
	}

	public void testFields_innerFields_01() {
		String typeName = Fields.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, Fields.Inner.class, "innerFields");
		JvmGenericType innerType = (JvmGenericType) getTypeProvider().findTypeByName(Fields.Inner.class.getName());
		assertSame(innerType, field.getDeclaringType());
		assertSame(type, innerType.getDeclaringType());
		assertEquals(JvmVisibility.PUBLIC, field.getVisibility());
		JvmTypeReference fieldType = field.getType();
		assertEquals(typeName + "<java.lang.String>", fieldType.getCanonicalName());
		assertTrue(field.getType() instanceof JvmParameterizedTypeReference);
		JvmParameterizedTypeReference parameterizedFieldType = (JvmParameterizedTypeReference) fieldType;
		assertSame(type, parameterizedFieldType.getType());
	}

	public void testHashMap_01() {
		String typeName = HashMap.class.getName();
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		diagnose(type);
	}

	public void testInnerEnumType() throws Exception {
		JvmDeclaredType declaredType = (JvmDeclaredType) getTypeProvider().findTypeByName(TypeWithInnerEnum.class.getName());
		assertEquals(2, declaredType.getMembers().size());
		// default constructor
		assertTrue(Iterables.any(declaredType.getMembers(), new Predicate<JvmMember>() {
			public boolean apply(JvmMember input) {
				return (input instanceof JvmConstructor)
						&& input.getSimpleName().equals(TypeWithInnerEnum.class.getSimpleName());
			}
		}));
		// inner enum type
		assertTrue(Iterables.any(declaredType.getMembers(), new Predicate<JvmMember>() {
			public boolean apply(JvmMember input) {
				return (input instanceof JvmEnumerationType)
						&& input.getCanonicalName().equals(TypeWithInnerEnum.MyEnum.class.getName())
						&& input.getVisibility() == JvmVisibility.PUBLIC;
			}
		}));
	}

	public void testInnerAnnotationType() throws Exception {
		JvmDeclaredType declaredType = (JvmDeclaredType) getTypeProvider().findTypeByName(
				TypeWithInnerAnnotation.class.getName());
		assertEquals(2, declaredType.getMembers().size());
		// default constructor
		assertTrue(Iterables.any(declaredType.getMembers(), new Predicate<JvmMember>() {
			public boolean apply(JvmMember input) {
				return (input instanceof JvmConstructor)
						&& input.getSimpleName().equals(TypeWithInnerAnnotation.class.getSimpleName());
			}
		}));
		// inner annotation type
		assertTrue(Iterables.any(declaredType.getMembers(), new Predicate<JvmMember>() {
			public boolean apply(JvmMember input) {
				return (input instanceof JvmAnnotationType)
						&& input.getCanonicalName().equals(TypeWithInnerAnnotation.MyAnnotation.class.getName())
						&& input.getVisibility() == JvmVisibility.PUBLIC;
			}
		}));
	}

	public void testAnnotationType_01() throws Exception {
		String typeName = TestAnnotation.class.getName();
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmAnnotationType);
		diagnose(type);
	}
	
	public void testAnnotationType_02() throws Exception {
		String typeName = TestAnnotation.class.getName();
		JvmAnnotationType type = (JvmAnnotationType) getTypeProvider().findTypeByName(typeName);
		assertEquals(1, type.getSuperTypes().size());
		assertEquals(Annotation.class.getName(), type.getSuperTypes().get(0).getCanonicalName());
	}
	
	public void testEnum_01() throws Exception {
		String typeName = TestEnum.class.getName();
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmEnumerationType);
		diagnose(type);
	}
	
	public void testEnum_02() throws Exception {
		String typeName = TestEnum.class.getName();
		JvmEnumerationType type = (JvmEnumerationType) getTypeProvider().findTypeByName(typeName);
		assertEquals(1, type.getSuperTypes().size());
		assertEquals(Enum.class.getName(), type.getSuperTypes().get(0).getType().getCanonicalName());
		String superTypeName = Enum.class.getName() + "<" + typeName + ">";
		assertEquals(superTypeName, type.getSuperTypes().get(0).getCanonicalName());
	}
	
	public void testEnum_03() throws Exception {
		String typeName = TestEnum.class.getName();
		JvmEnumerationType type = (JvmEnumerationType) getTypeProvider().findTypeByName(typeName);
		assertEquals(2, type.getLiterals().size());
		Set<String> expectedLiterals = Sets.newHashSet(TestEnum.FirstValue.toString(), TestEnum.SecondValue.toString());
		for(JvmEnumerationLiteral literal: type.getLiterals()) {
			assertTrue(expectedLiterals.remove(literal.getSimpleName()));
			assertSame(type, literal.getEnumType());
			assertEquals(JvmVisibility.PUBLIC, literal.getVisibility());
		}
		assertTrue(expectedLiterals.toString(), expectedLiterals.isEmpty());
	}
	
	public void testAnnotations_01() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmAnnotationType annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.class.getName());
		JvmAnnotationTarget target = (JvmAnnotationTarget) getTypeProvider().findTypeByName(typeName);
		assertEquals(1, target.getAnnotations().size());
		JvmAnnotationReference annotationReference = target.getAnnotations().get(0);
		assertSame(annotationType, annotationReference.getAnnotation());
		assertEquals(14, annotationReference.getValues().size());
	}
	
	public void testIntAnnotationValue_01() throws Exception {
		JvmIntAnnotationValue value = (JvmIntAnnotationValue) getAnnotationValue("intValue");
		assertEquals(1, value.getValues().size());
		Integer integer = value.getValues().get(0);
		assertEquals(34, integer.intValue());
	}
	
	public void testIntAnnotationValue_02() throws Exception {
		JvmIntAnnotationValue value = (JvmIntAnnotationValue) getMethodParameterAnnotationValue("intValue");
		assertEquals(1, value.getValues().size());
		Integer integer = value.getValues().get(0);
		assertEquals(34, integer.intValue());
	}
	
	public void testIntAnnotationValue_03() throws Exception {
		JvmIntAnnotationValue value = (JvmIntAnnotationValue) getConstructorParameterAnnotationValue("intValue");
		assertEquals(1, value.getValues().size());
		Integer integer = value.getValues().get(0);
		assertEquals(34, integer.intValue());
	}
	
	public void testBooleanAnnotationValue_01() throws Exception {
		JvmBooleanAnnotationValue value = (JvmBooleanAnnotationValue) getAnnotationValue("booleanValue");
		assertEquals(1, value.getValues().size());
		assertFalse(value.getValues().get(0));
	}
	
	public void testBooleanAnnotationValue_02() throws Exception {
		JvmBooleanAnnotationValue value = (JvmBooleanAnnotationValue) getMethodParameterAnnotationValue("booleanValue");
		assertEquals(1, value.getValues().size());
		assertFalse(value.getValues().get(0));
	}
	
	public void testBooleanAnnotationValue_03() throws Exception {
		JvmBooleanAnnotationValue value = (JvmBooleanAnnotationValue) getConstructorParameterAnnotationValue("booleanValue");
		assertEquals(1, value.getValues().size());
		assertFalse(value.getValues().get(0));
	}
	
	public void testFloatAnnotationValue_01() throws Exception {
		JvmFloatAnnotationValue value = (JvmFloatAnnotationValue) getAnnotationValue("floatValue");
		assertEquals(1, value.getValues().size());
		Float f = value.getValues().get(0);
		assertEquals(0.8f, f.floatValue());
	}
	
	public void testFloatAnnotationValue_02() throws Exception {
		JvmFloatAnnotationValue value = (JvmFloatAnnotationValue) getMethodParameterAnnotationValue("floatValue");
		assertEquals(1, value.getValues().size());
		Float f = value.getValues().get(0);
		assertEquals(0.8f, f.floatValue());
	}
	
	public void testFloatAnnotationValue_03() throws Exception {
		JvmFloatAnnotationValue value = (JvmFloatAnnotationValue) getConstructorParameterAnnotationValue("floatValue");
		assertEquals(1, value.getValues().size());
		Float f = value.getValues().get(0);
		assertEquals(0.8f, f.floatValue());
	}
	
	public void testDoubleAnnotationValue_01() throws Exception {
		JvmDoubleAnnotationValue value = (JvmDoubleAnnotationValue) getAnnotationValue("doubleValue");
		assertEquals(1, value.getValues().size());
		Double d = value.getValues().get(0);
		assertEquals(0.5, d.doubleValue());
	}

	public void testDoubleAnnotationValue_02() throws Exception {
		JvmDoubleAnnotationValue value = (JvmDoubleAnnotationValue) getMethodParameterAnnotationValue("doubleValue");
		assertEquals(1, value.getValues().size());
		Double d = value.getValues().get(0);
		assertEquals(0.5, d.doubleValue());
	}
	
	public void testDoubleAnnotationValue_03() throws Exception {
		JvmDoubleAnnotationValue value = (JvmDoubleAnnotationValue) getConstructorParameterAnnotationValue("doubleValue");
		assertEquals(1, value.getValues().size());
		Double d = value.getValues().get(0);
		assertEquals(0.5, d.doubleValue());
	}
	
	public void testShortAnnotationValue_01() throws Exception {
		JvmShortAnnotationValue value = (JvmShortAnnotationValue) getAnnotationValue("shortValue");
		assertEquals(1, value.getValues().size());
		Short s = value.getValues().get(0);
		assertEquals(4, s.shortValue());
	}
	
	public void testShortAnnotationValue_02() throws Exception {
		JvmShortAnnotationValue value = (JvmShortAnnotationValue) getMethodParameterAnnotationValue("shortValue");
		assertEquals(1, value.getValues().size());
		Short s = value.getValues().get(0);
		assertEquals(4, s.shortValue());
	}
	
	public void testShortAnnotationValue_03() throws Exception {
		JvmShortAnnotationValue value = (JvmShortAnnotationValue) getConstructorParameterAnnotationValue("shortValue");
		assertEquals(1, value.getValues().size());
		Short s = value.getValues().get(0);
		assertEquals(4, s.shortValue());
	}
	
	public void testByteAnnotationValue_01() throws Exception {
		JvmByteAnnotationValue value = (JvmByteAnnotationValue) getAnnotationValue("byteValue");
		assertEquals(1, value.getValues().size());
		Byte b = value.getValues().get(0);
		assertEquals(2, b.byteValue());
	}
	
	public void testByteAnnotationValue_02() throws Exception {
		JvmByteAnnotationValue value = (JvmByteAnnotationValue) getMethodParameterAnnotationValue("byteValue");
		assertEquals(1, value.getValues().size());
		Byte b = value.getValues().get(0);
		assertEquals(2, b.byteValue());
	}
	
	public void testByteAnnotationValue_03() throws Exception {
		JvmByteAnnotationValue value = (JvmByteAnnotationValue) getConstructorParameterAnnotationValue("byteValue");
		assertEquals(1, value.getValues().size());
		Byte b = value.getValues().get(0);
		assertEquals(2, b.byteValue());
	}
	
	public void testLongAnnotationValue_01() throws Exception {
		JvmLongAnnotationValue value = (JvmLongAnnotationValue) getAnnotationValue("longValue");
		assertEquals(2, value.getValues().size());
		Long l = value.getValues().get(0);
		assertEquals(6, l.longValue());
		l = value.getValues().get(1);
		assertEquals(7, l.longValue());
	}
	
	public void testLongAnnotationValue_02() throws Exception {
		JvmLongAnnotationValue value = (JvmLongAnnotationValue) getMethodParameterAnnotationValue("longValue");
		assertEquals(2, value.getValues().size());
		Long l = value.getValues().get(0);
		assertEquals(6, l.longValue());
		l = value.getValues().get(1);
		assertEquals(7, l.longValue());
	}
	
	public void testLongAnnotationValue_03() throws Exception {
		JvmLongAnnotationValue value = (JvmLongAnnotationValue) getConstructorParameterAnnotationValue("longValue");
		assertEquals(2, value.getValues().size());
		Long l = value.getValues().get(0);
		assertEquals(6, l.longValue());
		l = value.getValues().get(1);
		assertEquals(7, l.longValue());
	}
	
	public void testCharAnnotationValue_01() throws Exception {
		JvmCharAnnotationValue value = (JvmCharAnnotationValue) getAnnotationValue("charValue");
		assertEquals(1, value.getValues().size());
		Character c = value.getValues().get(0);
		assertEquals('a', c.charValue());
	}
	
	public void testCharAnnotationValue_03() throws Exception {
		JvmCharAnnotationValue value = (JvmCharAnnotationValue) getConstructorParameterAnnotationValue("charValue");
		assertEquals(1, value.getValues().size());
		Character c = value.getValues().get(0);
		assertEquals('a', c.charValue());
	}
	
	public void testCharAnnotationValue_02() throws Exception {
		JvmCharAnnotationValue value = (JvmCharAnnotationValue) getMethodParameterAnnotationValue("charValue");
		assertEquals(1, value.getValues().size());
		Character c = value.getValues().get(0);
		assertEquals('a', c.charValue());
	}
	
	public void testStringAnnotationValue_01() throws Exception {
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("stringValue");
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("stringValue", s);
	}
	
	public void testStringAnnotationValue_02() throws Exception {
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("stringArrayValue");
		assertEquals(4, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("array", s);
		s = value.getValues().get(1);
		assertEquals("value", s);
		s = value.getValues().get(2);
		assertEquals("duplicate", s);
		s = value.getValues().get(3);
		assertEquals("duplicate", s);
	}
	
	public void testStringAnnotationValue_03() throws Exception {
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getMethodParameterAnnotationValue("stringValue");
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("stringValue", s);
	}
	
	public void testStringAnnotationValue_04() throws Exception {
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getMethodParameterAnnotationValue("stringArrayValue");
		assertEquals(2, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("array", s);
		s = value.getValues().get(1);
		assertEquals("value", s);
	}
	
	public void testStringAnnotationValue_05() throws Exception {
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getConstructorParameterAnnotationValue("stringValue");
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("stringValue", s);
	}
	
	public void testStringAnnotationValue_06() throws Exception {
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getConstructorParameterAnnotationValue("stringArrayValue");
		assertEquals(2, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("array", s);
		s = value.getValues().get(1);
		assertEquals("value", s);
	}
	
	public void testClassAnnotationValue_01() throws Exception {
		JvmTypeAnnotationValue value = (JvmTypeAnnotationValue) getAnnotationValue("charSequenceClass");
		assertEquals(1, value.getValues().size());
		JvmType type = value.getValues().get(0).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(String.class.getName(), type.getCanonicalName());
	}
	
	public void testClassAnnotationValue_02() throws Exception {
		JvmTypeAnnotationValue value = (JvmTypeAnnotationValue) getAnnotationValue("classArray");
		assertEquals(2, value.getValues().size());
		JvmType type = value.getValues().get(0).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(TestAnnotation.Annotated.class.getName(), type.getCanonicalName());
		type = value.getValues().get(1).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(TestAnnotation.Annotated.class.getName(), type.getCanonicalName());
	}
	
	public void testClassAnnotationValue_04() throws Exception {
		JvmTypeAnnotationValue value = (JvmTypeAnnotationValue) getMethodParameterAnnotationValue("charSequenceClass");
		assertEquals(1, value.getValues().size());
		JvmType type = value.getValues().get(0).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(String.class.getName(), type.getCanonicalName());
	}
	
	public void testClassAnnotationValue_03() throws Exception {
		JvmTypeAnnotationValue value = (JvmTypeAnnotationValue) getMethodParameterAnnotationValue("classArray");
		assertEquals(2, value.getValues().size());
		JvmType type = value.getValues().get(0).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(TestAnnotation.Annotated.class.getName(), type.getCanonicalName());
		type = value.getValues().get(1).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(TestAnnotation.Annotated.class.getName(), type.getCanonicalName());
	}
	
	public void testClassAnnotationValue_05() throws Exception {
		JvmTypeAnnotationValue value = (JvmTypeAnnotationValue) getConstructorParameterAnnotationValue("charSequenceClass");
		assertEquals(1, value.getValues().size());
		JvmType type = value.getValues().get(0).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(String.class.getName(), type.getCanonicalName());
	}
	
	public void testClassAnnotationValue_06() throws Exception {
		JvmTypeAnnotationValue value = (JvmTypeAnnotationValue) getConstructorParameterAnnotationValue("classArray");
		assertEquals(2, value.getValues().size());
		JvmType type = value.getValues().get(0).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(TestAnnotation.Annotated.class.getName(), type.getCanonicalName());
		type = value.getValues().get(1).getType();
		assertNotNull(type);
		assertFalse(type.eIsProxy());
		assertEquals(TestAnnotation.Annotated.class.getName(), type.getCanonicalName());
	}
	
	public void testAnnotationAnnotationValue_01() throws Exception {
		JvmAnnotationAnnotationValue value = (JvmAnnotationAnnotationValue) getAnnotationValue("annotationValue");
		assertEquals(1, value.getValues().size());
		assertEquals(1, value.getAnnotations().size());
		JvmAnnotationReference annotationReference = value.getValues().get(0);
		assertEquals(TestAnnotation.NestedAnnotation.class.getName(), annotationReference.getAnnotation().getCanonicalName());
		assertEquals(1, annotationReference.getValues().size());
		JvmStringAnnotationValue nestedValue = (JvmStringAnnotationValue) annotationReference.getValues().get(0);
		assertEquals(1, nestedValue.getValues().size());
		assertEquals("MyString", nestedValue.getValues().get(0));
	}
	
	public void testAnnotationAnnotationValue_02() throws Exception {
		JvmAnnotationAnnotationValue value = (JvmAnnotationAnnotationValue) getConstructorParameterAnnotationValue("annotationValue");
		assertEquals(1, value.getValues().size());
		assertEquals(1, value.getAnnotations().size());
		JvmAnnotationReference annotationReference = value.getValues().get(0);
		assertEquals(TestAnnotation.NestedAnnotation.class.getName(), annotationReference.getAnnotation().getCanonicalName());
		assertEquals(1, annotationReference.getValues().size());
		JvmStringAnnotationValue nestedValue = (JvmStringAnnotationValue) annotationReference.getValues().get(0);
		assertEquals(1, nestedValue.getValues().size());
		assertEquals("MyString", nestedValue.getValues().get(0));
	}
	
	public void testAnnotationAnnotationValue_03() throws Exception {
		JvmAnnotationAnnotationValue value = (JvmAnnotationAnnotationValue) getMethodParameterAnnotationValue("annotationValue");
		assertEquals(1, value.getValues().size());
		assertEquals(1, value.getAnnotations().size());
		JvmAnnotationReference annotationReference = value.getValues().get(0);
		assertEquals(TestAnnotation.NestedAnnotation.class.getName(), annotationReference.getAnnotation().getCanonicalName());
		assertEquals(1, annotationReference.getValues().size());
		JvmStringAnnotationValue nestedValue = (JvmStringAnnotationValue) annotationReference.getValues().get(0);
		assertEquals(1, nestedValue.getValues().size());
		assertEquals("MyString", nestedValue.getValues().get(0));
	}
	
	public void testEnumAnnotationValue_01() throws Exception {
		JvmEnumAnnotationValue value = (JvmEnumAnnotationValue) getAnnotationValue("enumValue");
		assertEquals(1, value.getValues().size());
		JvmEnumerationLiteral enumLiteral = value.getValues().get(0);
		assertFalse(enumLiteral.eIsProxy());
		assertEquals(TestEnum.FirstValue.toString(), enumLiteral.getSimpleName());
	}
	
	public void testEnumAnnotationValue_02() throws Exception {
		JvmEnumAnnotationValue value = (JvmEnumAnnotationValue) getConstructorParameterAnnotationValue("enumValue");
		assertEquals(1, value.getValues().size());
		JvmEnumerationLiteral enumLiteral = value.getValues().get(0);
		assertFalse(enumLiteral.eIsProxy());
		assertEquals(TestEnum.FirstValue.toString(), enumLiteral.getSimpleName());
	}
	
	public void testEnumAnnotationValue_03() throws Exception {
		JvmEnumAnnotationValue value = (JvmEnumAnnotationValue) getMethodParameterAnnotationValue("enumValue");
		assertEquals(1, value.getValues().size());
		JvmEnumerationLiteral enumLiteral = value.getValues().get(0);
		assertFalse(enumLiteral.eIsProxy());
		assertEquals(TestEnum.FirstValue.toString(), enumLiteral.getSimpleName());
	}
	
	public JvmAnnotationValue getAnnotationValue(String name) {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmAnnotationTarget target = (JvmAnnotationTarget) getTypeProvider().findTypeByName(typeName);
		return getAnnotationValue(name, target);
	}
	
	public JvmAnnotationValue getConstructorParameterAnnotationValue(String name) {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = constructor.getParameters().get(0);
		return getAnnotationValue(name, target);
	}
	
	public JvmAnnotationValue getMethodParameterAnnotationValue(String name) {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmOperation method = getMethodFromType(type, TestAnnotation.Annotated.class, "method(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = method.getParameters().get(0);
		return getAnnotationValue(name, target);
	}

	public JvmAnnotationValue getAnnotationValue(String name, JvmAnnotationTarget target) {
		JvmAnnotationReference annotationReference = target.getAnnotations().get(0);
		for(JvmAnnotationValue value: annotationReference.getValues()) {
			if (name.equals(value.getValueName()))
				return value;
		}
		fail("Cannot find annotationValue " + name);
		return null;
	}
	
	public void testAnnotatedMethod_01() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation operation = getMethodFromType(type, TestAnnotation.Annotated.class, "method()");
		assertNotNull(operation);
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("value", operation);
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("method", s);
	}
	
	public void testAnnotatedConstructor_01() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated()");
		assertNotNull(constructor);
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("value", constructor);
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("constructor", s);
	}
	
	public void testAnnotatedConstructor_02() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String)");
		assertNotNull(constructor);
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("value", constructor);
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("secondConstructor", s);
	}
	
	public void testAnnotatedConstructor_03() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String,T)");
		assertNotNull(constructor);
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("value", constructor);
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("parameterizedConstructor", s);
	}
	
	public void testAnnotatedConstructor_04() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String,java.lang.String)");
		assertNotNull(constructor);
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("value", constructor);
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("thirdConstructorWithBody", s);
	}
	
	public void testAnnotatedField_01() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, TestAnnotation.Annotated.class, "field");
		assertNotNull(field);
		JvmStringAnnotationValue value = (JvmStringAnnotationValue) getAnnotationValue("value", field);
		assertEquals(1, value.getValues().size());
		String s = value.getValues().get(0);
		assertEquals("MyString", s);
	}
	
	public void testAnnotatedParameter_01() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmAnnotationType annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.class.getName());
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = constructor.getParameters().get(0);
		assertEquals(2, target.getAnnotations().size());
		JvmAnnotationReference annotationReference = target.getAnnotations().get(0);
		assertSame(annotationType, annotationReference.getAnnotation());
		
		annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.NestedAnnotation.class.getName());
		annotationReference = target.getAnnotations().get(1);
		assertSame(annotationType, annotationReference.getAnnotation());
	}
	
	public void testAnnotatedParameter_02() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = constructor.getParameters().get(1);
		assertEquals(0, target.getAnnotations().size());
	}

	public void testAnnotatedParameter_03() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmAnnotationType annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.NestedAnnotation.class.getName());
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmConstructor constructor = getConstructorFromType(type, TestAnnotation.Annotated.class, "Annotated(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = constructor.getParameters().get(2);
		assertEquals(1, target.getAnnotations().size());
		JvmAnnotationReference annotationReference = target.getAnnotations().get(0);
		assertSame(annotationType, annotationReference.getAnnotation());
	}
	
	public void testAnnotatedParameter_04() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmAnnotationType annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.class.getName());
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmOperation method = getMethodFromType(type, TestAnnotation.Annotated.class, "method(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = method.getParameters().get(0);
		assertEquals(2, target.getAnnotations().size());
		JvmAnnotationReference annotationReference = target.getAnnotations().get(0);
		assertSame(annotationType, annotationReference.getAnnotation());
		
		annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.NestedAnnotation.class.getName());
		annotationReference = target.getAnnotations().get(1);
		assertSame(annotationType, annotationReference.getAnnotation());
	}
	
	public void testAnnotatedParameter_05() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmOperation method = getMethodFromType(type, TestAnnotation.Annotated.class, "method(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = method.getParameters().get(1);
		assertEquals(0, target.getAnnotations().size());
	}

	public void testAnnotatedParameter_06() throws Exception {
		String typeName = TestAnnotation.Annotated.class.getName();
		JvmAnnotationType annotationType = (JvmAnnotationType) getTypeProvider().findTypeByName(TestAnnotation.NestedAnnotation.class.getName());
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		JvmOperation method = getMethodFromType(type, TestAnnotation.Annotated.class, "method(java.lang.String,java.lang.String,java.lang.String)");
		JvmAnnotationTarget target = method.getParameters().get(2);
		assertEquals(1, target.getAnnotations().size());
		JvmAnnotationReference annotationReference = target.getAnnotations().get(0);
		assertSame(annotationType, annotationReference.getAnnotation());
	}
	
	protected abstract String getCollectionParamName();
	
	public void testPerformance() {
		for(int i = 0; i < 10/*00*/; i++) {
			getTypeProvider().getResourceSet().getResources().clear();
			getTypeProvider().findTypeByName(TestAnnotation.class.getName());
			getTypeProvider().findTypeByName(ParameterizedMethods.class.getName());
			getTypeProvider().findTypeByName(ParameterizedTypes.class.getName());
		}
//		fail();
	}
}
