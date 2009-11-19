/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.ComponentType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.Field;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.LowerBound;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.ReferenceTypeArgument;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeArgument;
import org.eclipse.xtext.common.types.TypeConstraint;
import org.eclipse.xtext.common.types.TypeParameter;
import org.eclipse.xtext.common.types.TypeParameterDeclarator;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.Visibility;
import org.eclipse.xtext.common.types.Wildcard;
import org.eclipse.xtext.common.types.WildcardTypeArgument;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.testSetups.Fields;
import org.eclipse.xtext.common.types.testSetups.InitializerWithConstructor;
import org.eclipse.xtext.common.types.testSetups.InitializerWithoutConstructor;
import org.eclipse.xtext.common.types.testSetups.NestedTypes;
import org.eclipse.xtext.common.types.testSetups.ParameterizedMethods;
import org.eclipse.xtext.common.types.testSetups.ParameterizedTypes;
import org.eclipse.xtext.common.types.testSetups.StaticNestedTypes;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeProviderTest extends TestCase {

	protected abstract ITypeProvider getTypeProvider();
	
	public void testFindTypeByName_int() {
		String typeName = "int";
		Type type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof PrimitiveType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_twice() {
		String typeName = "int";
		Type firstType = getTypeProvider().findTypeByName(typeName);
		Type secondType = getTypeProvider().findTypeByName(typeName);
		assertSame(firstType, secondType);
	}
	
	public void testFindTypeByName_int_array_01() {
		String typeName = "int[]";
		Type type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_array_02() {
		String typeName = int[].class.getName();
		Type type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals("int[]", type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_array_03() {
		String typeName = int[][][].class.getName();
		Type type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals("int[][][]", type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_array_04() {
		String typeName = "int[][][]";
		Type type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_01() {
		String typeName = CharSequence.class.getName();
		Type type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof GenericType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_02() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(4, type.getMembers().size());
		Set<String> allNames = Sets.newHashSet("length", "charAt", "subSequence", "toString");
		for(org.eclipse.xtext.common.types.Member member: type.getMembers()) {
			assertTrue(member.getCanonicalName(), member instanceof Operation);
			Operation op = (Operation) member;
			assertTrue(op.getSimpleName(), allNames.remove(op.getSimpleName()));
		}
	}
	
	public void testFindTypeByName_javaLangCharSequence_03() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation length = (Operation) type.eResource().getEObject("java.lang.CharSequence.length()");
		assertNotNull(length);
		Type returnType = length.getReturnType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("int", returnType.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_04() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation charAt = (Operation) type.eResource().getEObject("java.lang.CharSequence.charAt(int)");
		assertNotNull(charAt);
		Type returnType = charAt.getReturnType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("char", returnType.getCanonicalName());
		assertEquals(1, charAt.getParameters().size());
		Type intType = getTypeProvider().findTypeByName("int");
		assertSame(intType, charAt.getParameters().get(0).getParameterType());
	}
	
	public void testFindTypeByName_javaLangNumber_01() {
		String typeName = Number.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(type.getSuperTypes().toString(), 2, type.getSuperTypes().size());
		Type objectType = type.getSuperTypes().get(0);
		assertFalse("isProxy: "+ objectType, objectType.eIsProxy());
		assertEquals(Object.class.getName(), objectType.getCanonicalName());
		Type serializableType = type.getSuperTypes().get(1);
		assertFalse("isProxy: "+ serializableType, serializableType.eIsProxy());
		assertEquals(Serializable.class.getName(), serializableType.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangNumber_02() {
		String typeName = Number[][].class.getName();
		ArrayType type = (ArrayType) getTypeProvider().findTypeByName(typeName);
		Operation longValue = (Operation) type.eResource().getEObject("java.lang.Number.longValue()");
		assertNotNull(longValue);
		DeclaredType number = longValue.getDeclaringType();
		assertNotNull(number.getArrayType());
		assertSame(type, number.getArrayType().getArrayType());
		assertNull(type.getArrayType());
	}
	
	public void testFindTypeByName_javaUtilList_01() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		assertEquals(1, type.getTypeParameters().size());
		TypeParameter typeVariable = type.getTypeParameters().get(0);
		assertEquals("E", typeVariable.getName());
		assertEquals(1, typeVariable.getConstraints().size());
		TypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertSame(typeVariable, upperBound.getConstrainedType());
		assertNotNull(upperBound.getReferencedType());
		assertFalse(upperBound.getReferencedType().eIsProxy());
		assertEquals(Object.class.getName(), upperBound.getReferencedType().getCanonicalName());
	}
	
	public void testFindTypeByName_javaUtilList_02() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation toArray = (Operation) type.eResource().getEObject("java.util.List.toArray()");
		assertNotNull(toArray);
		assertEquals("java.lang.Object[]", toArray.getReturnType().getCanonicalName());
	}
	
	public void testFindTypeByName_javaUtilList_03() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation toArray = (Operation) type.eResource().getEObject("java.util.List.toArray(T[])");
		assertNotNull(toArray);
		assertEquals("T[]", toArray.getReturnType().getCanonicalName());
	}
	
	public void testFindTypeByName_javaUtilList_04() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation addAll = (Operation) type.eResource().getEObject("java.util.List.addAll(java.util.Collection)");
		assertNotNull(addAll);
		assertEquals("boolean", addAll.getReturnType().getCanonicalName());
	}
	
	public void testFindTypeByName_javaUtilList_05() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation addAll = (Operation) type.eResource().getEObject("java.util.List.addAll(java.util.Collection)");
		assertEquals(1, addAll.getParameters().size());
		assertEquals(getCollectionParamName(), addAll.getParameters().get(0).getName());
		Type parameterType = addAll.getParameters().get(0).getParameterType();
		assertFalse(parameterType.toString(), parameterType.eIsProxy());
	}
	
	public void testFindTypeByName_javaUtilList_06() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation containsAll = (Operation) type.eResource().getEObject("java.util.List.containsAll(java.util.Collection)");
		assertEquals(1, containsAll.getParameters().size());
		assertEquals(getCollectionParamName(), containsAll.getParameters().get(0).getName());
		Type parameterType = containsAll.getParameters().get(0).getParameterType();
		assertFalse(parameterType.toString(), parameterType.eIsProxy());
	}
	
	public void testFindTypeByName_javaUtilList_07() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(1, type.getSuperTypes().size());
		Type superType = type.getSuperTypes().get(0);
		assertFalse(superType.eIsProxy());
		assertEquals("java.util.Collection<E>", superType.getCanonicalName());
		assertTrue(superType instanceof ParameterizedType);
		assertEquals(1, type.getTypeParameters().size());
		ParameterizedType parameterizedSuperType = (ParameterizedType) superType;
		Type rawType = parameterizedSuperType.getRawType();
		assertFalse(rawType.eIsProxy());
		assertEquals(1, parameterizedSuperType.getArguments().size());
		TypeArgument superTypeParameter = parameterizedSuperType.getArguments().get(0);
		assertTrue(superTypeParameter instanceof ReferenceTypeArgument);
		ReferenceTypeArgument castedSuperTypeParameter = (ReferenceTypeArgument) superTypeParameter;
		Type parameterType = castedSuperTypeParameter.getType();
		assertFalse(parameterType.eIsProxy());
		assertSame(parameterType, type.getTypeParameters().get(0));
	}

	private Operation getMethodFromParameterizedMethods(String method) {
		String typeName = ParameterizedMethods.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		Operation result = (Operation) type.eResource().getEObject(ParameterizedMethods.class.getName() + "."+ method);
		assertNotNull(result);
		return result;
	}
	
	public void testMemberCount_01() {
		String typeName = ParameterizedMethods.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = ParameterizedMethods.class.getDeclaredMethods().length;
		assertEquals(10, methodCount);
		int constructorCount = ParameterizedMethods.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount);
		assertEquals(methodCount + constructorCount, type.getMembers().size());
	}
	
	public void testMemberCount_02() {
		String typeName = InitializerWithConstructor.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = InitializerWithConstructor.class.getDeclaredMethods().length;
		assertEquals(0, methodCount);
		int constructorCount = InitializerWithConstructor.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount);
		assertEquals(methodCount + constructorCount, type.getMembers().size());
	}
	
	public void testMemberCount_03() {
		String typeName = InitializerWithoutConstructor.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = InitializerWithoutConstructor.class.getDeclaredMethods().length;
		assertEquals(0, methodCount);
		int constructorCount = InitializerWithoutConstructor.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		assertEquals(methodCount + constructorCount, type.getMembers().size());
	}
	
	public void testMemberCount_04() {
		String typeName = NestedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = NestedTypes.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = NestedTypes.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = NestedTypes.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
	}
	
	public void testMemberCount_05() {
		String typeName = NestedTypes.Outer.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = NestedTypes.Outer.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = NestedTypes.Outer.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = NestedTypes.Outer.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		int fieldCount = NestedTypes.Outer.class.getDeclaredFields().length;
		assertEquals(1, fieldCount); // implicit reference to enclosing type
		assertEquals(methodCount + constructorCount + nestedTypesCount + fieldCount, type.getMembers().size());
	}
	
	public void testMemberCount_06() {
		String typeName = NestedTypes.Outer.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = NestedTypes.Outer.Inner.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = NestedTypes.Outer.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int fieldCount = NestedTypes.Outer.Inner.class.getDeclaredFields().length;
		assertEquals(1, fieldCount); // implicit reference to enclosing type
		assertEquals(methodCount + constructorCount + fieldCount, type.getMembers().size());
	}
	
	public void testMemberCount_07() {
		String typeName = StaticNestedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = StaticNestedTypes.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = StaticNestedTypes.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = StaticNestedTypes.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
	}
	
	public void testMemberCount_08() {
		String typeName = StaticNestedTypes.Outer.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
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
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = StaticNestedTypes.Outer.Inner.class.getDeclaredMethods().length;
		assertEquals(1, methodCount);
		int constructorCount = StaticNestedTypes.Outer.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		assertEquals(methodCount + constructorCount, type.getMembers().size());
	}
	
	public void testMemberCount_10() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = ParameterizedTypes.class.getDeclaredMethods().length;
		assertEquals(5, methodCount);
		int constructorCount = ParameterizedTypes.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int nestedTypesCount = ParameterizedTypes.class.getClasses().length;
		assertEquals(1, nestedTypesCount);
		assertEquals(methodCount + constructorCount + nestedTypesCount, type.getMembers().size());
	}
	
	public void testMemberCount_11() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int methodCount = ParameterizedTypes.Inner.class.getDeclaredMethods().length;
		assertEquals(7, methodCount);
		int constructorCount = ParameterizedTypes.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int fieldCount = ParameterizedTypes.Inner.class.getDeclaredFields().length;
		assertEquals(1, fieldCount);
		assertEquals(methodCount + constructorCount + fieldCount, type.getMembers().size());
	}
	
	public void testMemberCount_12() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int constructorCount = Fields.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int fieldCount = Fields.class.getDeclaredFields().length;
		assertEquals(5, fieldCount);
		int nestedCount = Fields.class.getDeclaredClasses().length;
		assertEquals(1, nestedCount);
		assertEquals(nestedCount + constructorCount + fieldCount, type.getMembers().size());
	}
	
	public void testMemberCount_13() {
		String typeName = Fields.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		int constructorCount = Fields.Inner.class.getDeclaredConstructors().length;
		assertEquals(1, constructorCount); // default constructor
		int fieldCount = Fields.Inner.class.getDeclaredFields().length;
		assertEquals(1, fieldCount);
		assertEquals(constructorCount + fieldCount, type.getMembers().size());
	}
	
	public void test_twoListParamsNoResult_01() {
		Operation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		assertEquals(1, twoListParamsNoResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListParamsNoResult_02() {
		Operation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListParamsNoResult.getParameters().get(0);
		Type paramType = firstParam.getParameterType();
		assertNotNull(paramType);
		assertFalse(paramType.eIsProxy());
		assertEquals("java.util.List<T>", paramType.getCanonicalName());
		assertTrue(paramType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) paramType;
		Type rawType = parameterized.getRawType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListParamsNoResult_03() {
		Operation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListParamsNoResult.getParameters().get(0);
		Type paramType = firstParam.getParameterType();
		ParameterizedType parameterized = (ParameterizedType) paramType;
		assertEquals(1, parameterized.getArguments().size());
		TypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof ReferenceTypeArgument);
		ReferenceTypeArgument referenceTypeParameter = (ReferenceTypeArgument) typeParameter;
		Type referencedType = referenceTypeParameter.getType();
		assertFalse(referencedType.eIsProxy());
		assertTrue(referencedType instanceof TypeParameter);
		TypeParameter typeVar = (TypeParameter) referencedType;
		assertEquals("T", typeVar.getName());
		assertSame(twoListParamsNoResult, typeVar.getDeclarator());
	}

	public void test_twoListParamsListResult_01() {
		Operation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		assertEquals(1, twoListParamsListResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListParamsListResult_02() {
		Operation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		Type returnType = twoListParamsListResult.getReturnType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("java.util.List<T>", returnType.getCanonicalName());
		assertTrue(returnType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) returnType;
		Type rawType = parameterized.getRawType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListParamsListResult_03() {
		Operation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		Type returnType = twoListParamsListResult.getReturnType();
		ParameterizedType parameterized = (ParameterizedType) returnType;
		assertEquals(1, parameterized.getArguments().size());
		TypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof ReferenceTypeArgument);
		ReferenceTypeArgument referenceTypeParameter = (ReferenceTypeArgument) typeParameter;
		Type referencedType = referenceTypeParameter.getType();
		assertFalse(referencedType.eIsProxy());
		assertTrue(referencedType instanceof TypeParameter);
		TypeParameter typeVar = (TypeParameter) referencedType;
		assertEquals("T", typeVar.getName());
		assertSame(twoListParamsListResult, typeVar.getDeclarator());
	}
	
	public void test_twoListWildcardsNoResult_01() {
		Operation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		assertEquals(1, twoListWildcardsNoResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListWildcardsNoResult_02() {
		Operation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListWildcardsNoResult.getParameters().get(0);
		Type paramType = firstParam.getParameterType();
		assertNotNull(paramType);
		assertFalse(paramType.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object>", paramType.getCanonicalName());
		assertTrue(paramType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) paramType;
		Type rawType = parameterized.getRawType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListWildcardsNoResult_03() {
		Operation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListWildcardsNoResult.getParameters().get(0);
		Type paramType = firstParam.getParameterType();
		ParameterizedType parameterized = (ParameterizedType) paramType;
		assertEquals(1, parameterized.getArguments().size());
		TypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeParameter = (WildcardTypeArgument) typeParameter;
		Wildcard wildcard = wildcardTypeParameter.getWildcard();
		assertEquals(1, wildcard.getConstraints().size());
		assertTrue(wildcard.getConstraints().get(0) instanceof UpperBound);
		UpperBound upperBound = (UpperBound) wildcard.getConstraints().get(0);
		assertNotNull(upperBound.getReferencedType());
		Type upperBoundType = upperBound.getReferencedType();
		assertFalse(upperBoundType.eIsProxy());
		assertEquals("java.lang.Object", upperBoundType.getCanonicalName());
	}
	
	public void test_twoListWildcardsListResult_01() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		assertEquals(1, twoListWildcardsListResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListWildcardsListResult_02() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		Type returnType = twoListWildcardsListResult.getReturnType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object>", returnType.getCanonicalName());
		assertTrue(returnType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) returnType;
		Type rawType = parameterized.getRawType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListWildcardsListResult_03() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		Type returnType = twoListWildcardsListResult.getReturnType();
		ParameterizedType parameterized = (ParameterizedType) returnType;
		assertEquals(1, parameterized.getArguments().size());
		TypeArgument typeParameter = parameterized.getArguments().get(0);
		assertTrue(typeParameter instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeParameter = (WildcardTypeArgument) typeParameter;
		Wildcard wildcard = wildcardTypeParameter.getWildcard();
		assertEquals(1, wildcard.getConstraints().size());
		assertTrue(wildcard.getConstraints().get(0) instanceof UpperBound);
		UpperBound upperBound = (UpperBound) wildcard.getConstraints().get(0);
		assertNotNull(upperBound.getReferencedType());
		Type upperBoundType = upperBound.getReferencedType();
		assertFalse(upperBoundType.eIsProxy());
		assertEquals("java.lang.Object", upperBoundType.getCanonicalName());
	}
	
	public void test_arrayWildcard_01() {
		Operation arrayWildcard = getMethodFromParameterizedMethods("arrayWildcard(java.util.List[])");
		assertEquals(1, arrayWildcard.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayWildcard_02() {
		Operation arrayWildcard = getMethodFromParameterizedMethods("arrayWildcard(java.util.List[])");
		Type paramType = arrayWildcard.getParameters().get(0).getParameterType();
		assertEquals("java.util.List<? extends java.lang.Object>[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_nestedArrayWildcard_01() {
		Operation nestedArrayWildcard = getMethodFromParameterizedMethods("nestedArrayWildcard(java.util.List[][])");
		assertEquals(1, nestedArrayWildcard.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayWildcard_02() {
		Operation nestedArrayWildcard = getMethodFromParameterizedMethods("nestedArrayWildcard(java.util.List[][])");
		Type paramType = nestedArrayWildcard.getParameters().get(0).getParameterType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_arrayParameterized_01() {
		Operation arrayParameterized = getMethodFromParameterizedMethods("arrayParameterized(java.util.List[])");
		assertEquals(1, arrayParameterized.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayParameterized_02() {
		Operation arrayParameterized = getMethodFromParameterizedMethods("arrayParameterized(java.util.List[])");
		Type paramType = arrayParameterized.getParameters().get(0).getParameterType();
		assertEquals("java.util.List<T>[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_nestedArrayParameterized_01() {
		Operation nestedArrayParameterized = getMethodFromParameterizedMethods("nestedArrayParameterized(java.util.List[][])");
		assertEquals(1, nestedArrayParameterized.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayParameterized_02() {
		Operation nestedArrayParameterized = getMethodFromParameterizedMethods("nestedArrayParameterized(java.util.List[][])");
		Type paramType = nestedArrayParameterized.getParameters().get(0).getParameterType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_arrayVariable_01() {
		Operation arrayVariable = getMethodFromParameterizedMethods("arrayVariable(T[])");
		assertEquals(1, arrayVariable.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayVariable_02() {
		Operation arrayVariable = getMethodFromParameterizedMethods("arrayVariable(T[])");
		Type paramType = arrayVariable.getParameters().get(0).getParameterType();
		assertEquals("T[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof TypeParameter);
	}
	
	public void test_nestedArrayVariable_01() {
		Operation nestedArrayVariable = getMethodFromParameterizedMethods("nestedArrayVariable(T[][])");
		assertEquals(1, nestedArrayVariable.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayVariable_02() {
		Operation nestedArrayVariable = getMethodFromParameterizedMethods("nestedArrayVariable(T[][])");
		Type paramType = nestedArrayVariable.getParameters().get(0).getParameterType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof TypeParameter);
	}
	
	public void test_nestedTypes_Outer() {
		String typeName = NestedTypes.Outer.class.getName();
		String expectedSuffix = NestedTypes.class.getSimpleName() + "$" + NestedTypes.Outer.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		Type outerType = (Type) type.eContainer();
		assertEquals(NestedTypes.class.getName(), outerType.getCanonicalName());
	}
	
	public void test_nestedTypes_Outer_Inner() {
		String typeName = NestedTypes.Outer.Inner.class.getName();
		String expectedSuffix = NestedTypes.class.getSimpleName() + 
			"$" + NestedTypes.Outer.class.getSimpleName() +
			"$" + NestedTypes.Outer.Inner.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		Type outerType = (Type) type.eContainer();
		assertEquals(NestedTypes.Outer.class.getName(), outerType.getCanonicalName());
	}
	
	public void test_staticNestedTypes_method() {
		String typeName = StaticNestedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation operation = getMethodFromType(type, StaticNestedTypes.class, "method()");
		assertEquals("boolean", operation.getReturnType().getCanonicalName());
	}
	
	public void test_staticNestedTypes_Outer() {
		String typeName = StaticNestedTypes.Outer.class.getName();
		String expectedSuffix = StaticNestedTypes.class.getSimpleName() + "$" + StaticNestedTypes.Outer.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		Type outerType = (Type) type.eContainer();
		assertEquals(StaticNestedTypes.class.getName(), outerType.getCanonicalName());
	}
	
	public void test_staticNestedTypes_Outer_method() {
		String typeName = StaticNestedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation operation = getMethodFromType(type, StaticNestedTypes.Outer.class, "method()");
		assertEquals("int", operation.getReturnType().getCanonicalName());
	}
	
	public void test_staticNestedTypes_Outer_Inner() {
		String typeName = StaticNestedTypes.Outer.Inner.class.getName();
		String expectedSuffix = StaticNestedTypes.class.getSimpleName() + 
			"$" + StaticNestedTypes.Outer.class.getSimpleName() +
			"$" + StaticNestedTypes.Outer.Inner.class.getSimpleName();
		assertTrue(typeName + " endsWith " + expectedSuffix, typeName.endsWith(expectedSuffix));
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(typeName, type.getCanonicalName());
		Type outerType = (Type) type.eContainer();
		assertEquals(StaticNestedTypes.Outer.class.getName(), outerType.getCanonicalName());
	}
	
	public void test_staticNestedTypes_Outer_Inner_method() {
		String typeName = StaticNestedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation operation = getMethodFromType(type, StaticNestedTypes.Outer.Inner.class, "method()");
		assertEquals("void", operation.getReturnType().getCanonicalName());
	}
	
	private Operation getMethodFromType(EObject context, Class<?> type, String method) {
		String methodName = type.getName() + "." + method;
		assertNotNull(context);
		Operation result = (Operation) context.eResource().getEObject(methodName);
		assertNotNull(methodName, result);
		return result;
	}
	
	public void test_ParameterizedTypes_01() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(5, type.getTypeParameters().size());
	}
	
	public void test_ParameterizedTypes_02() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodS = getMethodFromType(type, ParameterizedTypes.class, "methodS(S)");
		Type listS = methodS.getReturnType();
		assertFalse(listS.toString(), listS.eIsProxy());
		assertEquals("java.util.List<? extends S>", listS.getCanonicalName());
		ParameterizedType listType = (ParameterizedType) listS;
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeArgument = (WildcardTypeArgument) typeArgument;
		assertEquals("? extends S", wildcardTypeArgument.getCanonicalName());
		assertEquals(1, wildcardTypeArgument.getWildcard().getConstraints().size());
		UpperBound upperBound = (UpperBound) wildcardTypeArgument.getWildcard().getConstraints().get(0);
		TypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, upperBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_03() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodT = getMethodFromType(type, ParameterizedTypes.class, "methodT(T)");
		Type listS = methodT.getReturnType();
		assertFalse(listS.toString(), listS.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object & super T>", listS.getCanonicalName());
		ParameterizedType listType = (ParameterizedType) listS;
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeArgument = (WildcardTypeArgument) typeArgument;
		assertEquals("? extends java.lang.Object & super T", wildcardTypeArgument.getCanonicalName());
		assertEquals(2, wildcardTypeArgument.getWildcard().getConstraints().size());
		UpperBound uperBound = (UpperBound) wildcardTypeArgument.getWildcard().getConstraints().get(0);
		assertEquals("java.lang.Object", uperBound.getReferencedType().getCanonicalName());
		LowerBound lowerBound = (LowerBound) wildcardTypeArgument.getWildcard().getConstraints().get(1);
		TypeParameter t = type.getTypeParameters().get(1);
		assertSame(t, lowerBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_04() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodY = getMethodFromType(type, ParameterizedTypes.class, "methodY(Y)");
		assertEquals(1, methodY.getParameters().size());
		Type parameterType = methodY.getParameters().get(0).getParameterType();
		assertFalse(parameterType.eIsProxy());
		assertEquals("Y", parameterType.getCanonicalName());
		assertTrue(parameterType instanceof TypeParameter);
		assertSame(methodY, ((TypeParameter) parameterType).getDeclarator());
		TypeParameter y = (TypeParameter) parameterType;
		assertEquals(1, y.getConstraints().size());
		UpperBound upperBound = (UpperBound) y.getConstraints().get(0);
		TypeParameter t = type.getTypeParameters().get(1);
		assertSame(t, upperBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_05() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodZ = getMethodFromType(type, ParameterizedTypes.class, "methodZ(java.util.List)");
		assertEquals(1, methodZ.getParameters().size());
		assertEquals(2, methodZ.getDeclaredParameterizedTypes().size());
		assertEquals(1, methodZ.getTypeParameters().size());
		assertEquals("Z", methodZ.getTypeParameters().get(0).getCanonicalName());
		Type listZ = methodZ.getReturnType();
		assertFalse(listZ.toString(), listZ.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object & super Z>", listZ.getCanonicalName());
		ParameterizedType listType = (ParameterizedType) listZ;
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeArgument = (WildcardTypeArgument) typeArgument;
		assertEquals("? extends java.lang.Object & super Z", wildcardTypeArgument.getCanonicalName());
		assertEquals(2, wildcardTypeArgument.getWildcard().getConstraints().size());
		UpperBound upperBound = (UpperBound) wildcardTypeArgument.getWildcard().getConstraints().get(0);
		assertEquals("java.lang.Object", upperBound.getReferencedType().getCanonicalName());
		LowerBound lowerBound = (LowerBound) wildcardTypeArgument.getWildcard().getConstraints().get(1);
		assertEquals("Z", lowerBound.getReferencedType().getCanonicalName());
		TypeParameter z = methodZ.getTypeParameters().get(0);
		assertSame(z, lowerBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_06() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodMap = getMethodFromType(type, ParameterizedTypes.class, "methodMap(java.util.Map)");
		assertEquals(1, methodMap.getParameters().size());
		assertEquals(1, methodMap.getDeclaredParameterizedTypes().size());
		assertEquals(1, methodMap.getTypeParameters().size());
		assertEquals("Z", methodMap.getTypeParameters().get(0).getCanonicalName());
		Type z = methodMap.getReturnType();
		assertSame(methodMap.getTypeParameters().get(0), z);
		Type mapType = methodMap.getParameters().get(0).getParameterType();
		assertEquals("java.util.Map<? extends java.lang.Object & super Z,? extends S>", mapType.getCanonicalName());
		ParameterizedType parameterizedMapType = (ParameterizedType) mapType;
		assertSame(methodMap, parameterizedMapType.getDeclarator());
		assertEquals(2, parameterizedMapType.getArguments().size());
		WildcardTypeArgument extendsS = (WildcardTypeArgument) parameterizedMapType.getArguments().get(1);
		assertEquals(1, extendsS.getWildcard().getConstraints().size());
		Type s = type.getTypeParameters().get(0);
		assertSame(s, extendsS.getWildcard().getConstraints().get(0).getReferencedType());
	}
	
	public void test_ParameterizedTypes_S_01() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeVariable = type.getTypeParameters().get(0);
		assertEquals("S", typeVariable.getCanonicalName());
		assertSame(type, typeVariable.getDeclarator());
		assertEquals(1, typeVariable.getConstraints().size());
		TypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertEquals("java.lang.Object", upperBound.getReferencedType().getCanonicalName());
	}
	
	public void test_ParameterizedTypes_T_01() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeVariable = type.getTypeParameters().get(1);
		assertEquals("T", typeVariable.getCanonicalName());
		assertSame(type, typeVariable.getDeclarator());
		assertEquals(1, typeVariable.getConstraints().size());
		TypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertFalse(upperBound.getReferencedType().toString(), upperBound.getReferencedType().eIsProxy());
		assertEquals("S", upperBound.getReferencedType().getCanonicalName());
		TypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, upperBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_U_01() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeVariable = type.getTypeParameters().get(2);
		assertEquals("U", typeVariable.getCanonicalName());
		assertSame(type, typeVariable.getDeclarator());
		assertEquals(1, typeVariable.getConstraints().size());
		TypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertFalse(upperBound.getReferencedType().toString(), upperBound.getReferencedType().eIsProxy());
		assertEquals("java.util.List<S>", upperBound.getReferencedType().getCanonicalName());
		ParameterizedType listType = (ParameterizedType) upperBound.getReferencedType();
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		TypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, refTypeArgument.getType());
	}
	
	public void test_ParameterizedTypes_V_01() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeParameterV = type.getTypeParameters().get(3);
		assertEquals("V", typeParameterV.getCanonicalName());
		assertSame(type, typeParameterV.getDeclarator());
		assertEquals(1, typeParameterV.getConstraints().size());
		TypeConstraint typeConstraint = typeParameterV.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertFalse(upperBound.getReferencedType().toString(), upperBound.getReferencedType().eIsProxy());
		assertEquals("java.util.List<java.util.List<? extends V>>", upperBound.getReferencedType().getCanonicalName());
		ParameterizedType listType = (ParameterizedType) upperBound.getReferencedType();
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		assertEquals("java.util.List<? extends V>", refTypeArgument.getCanonicalName());
		ParameterizedType nestedListType = (ParameterizedType) refTypeArgument.getType();
		assertEquals(1, nestedListType.getArguments().size());
		TypeArgument nestedArgument = nestedListType.getArguments().get(0);
		assertTrue(nestedArgument instanceof WildcardTypeArgument);
		assertEquals(1, ((WildcardTypeArgument) nestedArgument).getWildcard().getConstraints().size());
		UpperBound nestedUpperBound = (UpperBound) ((WildcardTypeArgument) nestedArgument).getWildcard().getConstraints().get(0);
		assertSame(typeParameterV, nestedUpperBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_W_01() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeParameterW = type.getTypeParameters().get(4);
		assertEquals("W", typeParameterW.getCanonicalName());
		assertSame(type, typeParameterW.getDeclarator());
		assertEquals(2, typeParameterW.getConstraints().size());
		TypeConstraint firstTypeConstraint = typeParameterW.getConstraints().get(0);
		assertTrue(firstTypeConstraint instanceof UpperBound);
		UpperBound firstUpperBound = (UpperBound) firstTypeConstraint;
		assertNotNull(firstUpperBound.getReferencedType());
		assertFalse(firstUpperBound.getReferencedType().toString(), firstUpperBound.getReferencedType().eIsProxy());
		assertEquals("java.lang.Comparable<S>", firstUpperBound.getReferencedType().getCanonicalName());
		ParameterizedType comparableType = (ParameterizedType) firstUpperBound.getReferencedType();
		assertEquals(1, comparableType.getArguments().size());
		TypeArgument typeArgument = comparableType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		assertEquals(refTypeArgument.toString(), "S", refTypeArgument.getCanonicalName());
		TypeParameter s = type.getTypeParameters().get(0);
		assertSame(s, refTypeArgument.getType());
	}
	
	public void test_ParameterizedTypes_W_02() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeParameterW = type.getTypeParameters().get(4);
		assertEquals("W", typeParameterW.getCanonicalName());
		assertSame(type, typeParameterW.getDeclarator());
		assertEquals(2, typeParameterW.getConstraints().size());
		
		TypeConstraint secondTypeConstraint = typeParameterW.getConstraints().get(1);
		assertTrue(secondTypeConstraint instanceof UpperBound);
		UpperBound secondUpperBound = (UpperBound) secondTypeConstraint;
		assertNotNull(secondUpperBound.getReferencedType());
		assertFalse(secondUpperBound.getReferencedType().toString(), secondUpperBound.getReferencedType().eIsProxy());
		assertEquals("java.io.Serializable", secondUpperBound.getReferencedType().getCanonicalName());
	}
	
	public void test_ParameterizedTypes_Inner_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertEquals(3, type.getTypeParameters().size());
	}
	
	public void test_ParameterizedTypes_Inner_02() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodS = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodS()");
		Type s = methodS.getReturnType();
		assertFalse(s.toString(), s.eIsProxy());
		assertTrue(s instanceof TypeParameter);
		TypeParameter sParam = (TypeParameter) s;
		assertSame(type, sParam.getDeclarator());
	}
	
	public void test_ParameterizedTypes_Inner_03() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodX = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodX()");
		Type x = methodX.getReturnType();
		assertFalse(x.toString(), x.eIsProxy());
		assertTrue(x instanceof TypeParameter);
		TypeParameter xParam = (TypeParameter) x;
		assertSame(type, xParam.getDeclarator());
	}
	
	public void test_ParameterizedTypes_Inner_04() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodT = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodT()");
		Type listT = methodT.getReturnType();
		assertEquals("java.util.List<T>", listT.getCanonicalName());
		ParameterizedType listType = (ParameterizedType) listT;
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		assertEquals("T", refTypeArgument.getCanonicalName());
		TypeParameter t = ((TypeParameterDeclarator) type.getDeclaringType()).getTypeParameters().get(1);
		assertSame(t, refTypeArgument.getType());
	}
	
	public void test_ParameterizedTypes_Inner_05() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodVArray_01()");
		Type listT = methodV.getReturnType();
		assertEquals("java.util.List<? extends V>[]", listT.getCanonicalName());
		ArrayType listArrayType = (ArrayType) listT;
		ParameterizedType listType = (ParameterizedType) listArrayType.getComponentType();
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeArgument = (WildcardTypeArgument) typeArgument;
		assertEquals("? extends V", wildcardTypeArgument.getCanonicalName());
		assertEquals(1, wildcardTypeArgument.getWildcard().getConstraints().size());
		UpperBound upperBound = (UpperBound) wildcardTypeArgument.getWildcard().getConstraints().get(0);
		TypeParameter v = type.getTypeParameters().get(3);
		assertSame(v, upperBound.getReferencedType());
	}
	
	public void test_ParameterizedTypes_Inner_06() {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodVArray_02()");
		Type listV = methodV.getReturnType();
		assertEquals("java.util.List<? extends V[]>", listV.getCanonicalName());
		ParameterizedType listType = (ParameterizedType) listV;
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof WildcardTypeArgument);
		WildcardTypeArgument wildcardTypeArgument = (WildcardTypeArgument) typeArgument;
		assertEquals("? extends V[]", wildcardTypeArgument.getCanonicalName());
		assertEquals(1, wildcardTypeArgument.getWildcard().getConstraints().size());
		UpperBound upperBound = (UpperBound) wildcardTypeArgument.getWildcard().getConstraints().get(0);
		Type upperBoundType = upperBound.getReferencedType();
		assertTrue(upperBoundType instanceof ArrayType);
		assertTrue(((ArrayType) upperBoundType).getComponentType() instanceof TypeParameter);
		TypeParameter v = type.getTypeParameters().get(3);
		assertSame(v, ((ArrayType) upperBoundType).getComponentType());
	}
	
	public void test_ParameterizedTypes_Inner_07() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodZArray_01()");
		Type listZ = methodV.getReturnType();
		assertEquals("java.util.List<Z[][]>", listZ.getCanonicalName());
		ParameterizedType listType = (ParameterizedType) listZ;
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		Type argumentType = refTypeArgument.getType();
		assertTrue(argumentType instanceof ArrayType);
		assertTrue(((ArrayType) argumentType).getComponentType() instanceof ArrayType);
		ComponentType componentType = ((ArrayType) ((ArrayType) argumentType).getComponentType()).getComponentType();
		TypeParameter z = type.getTypeParameters().get(2);
		assertSame(z, componentType);
	}
	
	public void test_ParameterizedTypes_Inner_08() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation methodV = getMethodFromType(type, ParameterizedTypes.Inner.class, "methodZArray_02()");
		Type listZ = methodV.getReturnType();
		assertEquals("java.util.List<Z[]>[]", listZ.getCanonicalName());
		ArrayType listArrayType = (ArrayType) listZ;
		ParameterizedType listType = (ParameterizedType) listArrayType.getComponentType();
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		Type argumentType = refTypeArgument.getType();
		assertTrue(argumentType instanceof ArrayType);
		ComponentType componentType = ((ArrayType) argumentType).getComponentType();
		TypeParameter z = type.getTypeParameters().get(2);
		assertSame(z, componentType);
	}
	
	public void test_ParameterizedTypes_Inner_X_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeParameterX = type.getTypeParameters().get(0);
		assertEquals("X", typeParameterX.getCanonicalName());
		assertSame(type, typeParameterX.getDeclarator());
		assertEquals(1, typeParameterX.getConstraints().size());
		TypeConstraint typeConstraint = typeParameterX.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertEquals("W", upperBound.getReferencedType().getCanonicalName());
		Type upperBoundType = upperBound.getReferencedType();
		assertTrue(upperBoundType instanceof TypeParameter);
		TypeParameter typeParameterW = (TypeParameter) upperBoundType;
		assertSame(type.getDeclaringType(), typeParameterW.getDeclarator());
	}
	
	public void test_ParameterizedTypes_Inner_Y_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeParameterY = type.getTypeParameters().get(1);
		assertEquals("Y", typeParameterY.getCanonicalName());
		assertSame(type, typeParameterY.getDeclarator());
		assertEquals(1, typeParameterY.getConstraints().size());
		TypeConstraint typeConstraint = typeParameterY.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertEquals("java.util.List<X>", upperBound.getReferencedType().getCanonicalName());
		ParameterizedType listType = (ParameterizedType) upperBound.getReferencedType();
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		assertEquals("X", refTypeArgument.getCanonicalName());
		TypeParameter x = type.getTypeParameters().get(0);
		assertSame(x, refTypeArgument.getType());
	}
	
	public void test_ParameterizedTypes_Inner_Z_01() {
		String typeName = ParameterizedTypes.Inner.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		TypeParameter typeParameterZ = type.getTypeParameters().get(2);
		assertEquals("Z", typeParameterZ.getCanonicalName());
		assertSame(type, typeParameterZ.getDeclarator());
		assertEquals(1, typeParameterZ.getConstraints().size());
		TypeConstraint typeConstraint = typeParameterZ.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertNotNull(upperBound.getReferencedType());
		assertEquals("java.util.List<W>", upperBound.getReferencedType().getCanonicalName());
		ParameterizedType listType = (ParameterizedType) upperBound.getReferencedType();
		assertEquals(1, listType.getArguments().size());
		TypeArgument typeArgument = listType.getArguments().get(0);
		assertTrue(typeArgument instanceof ReferenceTypeArgument);
		ReferenceTypeArgument refTypeArgument = (ReferenceTypeArgument) typeArgument;
		assertEquals("W", refTypeArgument.getCanonicalName());
		TypeParameter w = ((TypeParameterDeclarator) type.getDeclaringType()).getTypeParameters().get(4);
		assertSame(w, refTypeArgument.getType());
	}
	
	public void testFields_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
	}
	
	private Field getFieldFromType(EObject context, Class<?> type, String field) {
		String fieldName = type.getName() + "." + field;
		assertNotNull(context);
		Field result = (Field) context.eResource().getEObject(fieldName);
		assertNotNull(fieldName, result);
		return result;
	}
	
	public void testFields_privateT_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Field field = getFieldFromType(type, Fields.class, "privateT");
		assertSame(type, field.getDeclaringType());
		assertEquals(Visibility.PRIVATE, field.getVisibility());
		Type fieldType = field.getType();
		assertSame(type.getTypeParameters().get(0), fieldType);
	}
	
	public void testFields_defaultListT_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Field field = getFieldFromType(type, Fields.class, "defaultListT");
		assertSame(type, field.getDeclaringType());
		assertEquals(Visibility.DEFAULT, field.getVisibility());
		Type fieldType = field.getType();
		assertEquals("java.util.List<T>", fieldType.getCanonicalName());
		assertTrue(fieldType instanceof ParameterizedType);
		ParameterizedType parameterizedFieldType = (ParameterizedType) fieldType;
		ReferenceTypeArgument refTypeArg = (ReferenceTypeArgument) parameterizedFieldType.getArguments().get(0);
		assertSame(type.getTypeParameters().get(0), refTypeArg.getType());
	}
	
	public void testFields_protectedString_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Field field = getFieldFromType(type, Fields.class, "protectedString");
		assertSame(type, field.getDeclaringType());
		assertEquals(Visibility.PROTECTED, field.getVisibility());
		Type fieldType = field.getType();
		assertEquals("java.lang.String", fieldType.getCanonicalName());
	}
	
	public void testFields_protectedStaticString_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Field field = getFieldFromType(type, Fields.class, "protectedStaticString");
		assertSame(type, field.getDeclaringType());
		assertTrue(field.isStatic());
		assertEquals(Visibility.PROTECTED, field.getVisibility());
		Type fieldType = field.getType();
		assertEquals("java.lang.String", fieldType.getCanonicalName());
	}
	
	public void testFields_publicInt_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Field field = getFieldFromType(type, Fields.class, "publicInt");
		assertSame(type, field.getDeclaringType());
		assertEquals(Visibility.PUBLIC, field.getVisibility());
		Type fieldType = field.getType();
		assertEquals("int", fieldType.getCanonicalName());
		assertTrue(field.getType() instanceof PrimitiveType);
	}
	
	public void testFields_innerFields_01() {
		String typeName = Fields.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Field field = getFieldFromType(type, Fields.Inner.class, "innerFields");
		GenericType innerType = (GenericType) getTypeProvider().findTypeByName(Fields.Inner.class.getName());
		assertSame(innerType, field.getDeclaringType());
		assertSame(type, innerType.getDeclaringType());
		assertEquals(Visibility.PUBLIC, field.getVisibility());
		Type fieldType = field.getType();
		assertEquals(typeName + "<java.lang.String>", fieldType.getCanonicalName());
		assertTrue(field.getType() instanceof ParameterizedType);
		ParameterizedType parameterizedFieldType = (ParameterizedType) fieldType;
		assertSame(type, parameterizedFieldType.getRawType());
	}
	
	protected abstract String getCollectionParamName();
}
