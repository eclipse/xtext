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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.ReferenceTypeParameter;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeConstraint;
import org.eclipse.xtext.common.types.TypeParameter;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.TypeVariable;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.Wildcard;
import org.eclipse.xtext.common.types.WildcardTypeParameter;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.common.types.testSetups.InitializerWithConstructor;
import org.eclipse.xtext.common.types.testSetups.InitializerWithoutConstructor;
import org.eclipse.xtext.common.types.testSetups.NestedTypes;
import org.eclipse.xtext.common.types.testSetups.ParameterizedMethods;
import org.eclipse.xtext.common.types.testSetups.StaticNestedTypes;

import com.google.common.collect.Sets;

import junit.framework.TestCase;

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
		Type returnType = length.getReturnType().getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("int", returnType.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_04() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation charAt = (Operation) type.eResource().getEObject("java.lang.CharSequence.charAt(int)");
		assertNotNull(charAt);
		Type returnType = charAt.getReturnType().getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("char", returnType.getCanonicalName());
		assertEquals(1, charAt.getParameters().size());
		Type intType = getTypeProvider().findTypeByName("int");
		assertSame(intType, charAt.getParameters().get(0).getParameterType().getType());
	}
	
	public void testFindTypeByName_javaLangNumber_01() {
		String typeName = Number.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(type.getSuperTypes().toString(), 2, type.getSuperTypes().size());
		TypeReference objectReference = type.getSuperTypes().get(0);
		Type objectType = objectReference.getType();
		assertFalse("isProxy: "+ objectType, objectType.eIsProxy());
		assertEquals(Object.class.getName(), objectType.getCanonicalName());
		TypeReference serializableReference = type.getSuperTypes().get(1);
		Type serializableType = serializableReference.getType();
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
		assertEquals(1, type.getTypeVariables().size());
		TypeVariable typeVariable = type.getTypeVariables().get(0);
		assertEquals("E", typeVariable.getName());
		assertEquals(1, typeVariable.getConstraints().size());
		TypeConstraint typeConstraint = typeVariable.getConstraints().get(0);
		assertTrue(typeConstraint instanceof UpperBound);
		UpperBound upperBound = (UpperBound) typeConstraint;
		assertSame(typeVariable, upperBound.getConstrainedType());
		assertEquals(1, upperBound.getReferencedTypes().size());
		TypeReference typeReference = upperBound.getReferencedTypes().get(0);
		assertFalse(typeReference.getType().eIsProxy());
		assertEquals(Object.class.getName(), typeReference.getType().getCanonicalName());
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
		TypeReference parameterType = addAll.getParameters().get(0).getParameterType();
		assertFalse(parameterType.getType().toString(), parameterType.getType().eIsProxy());
	}
	
	public void testFindTypeByName_javaUtilList_06() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		Operation containsAll = (Operation) type.eResource().getEObject("java.util.List.containsAll(java.util.Collection)");
		assertEquals(1, containsAll.getParameters().size());
		assertEquals(getCollectionParamName(), containsAll.getParameters().get(0).getName());
		TypeReference parameterType = containsAll.getParameters().get(0).getParameterType();
		assertFalse(parameterType.getType().toString(), parameterType.getType().eIsProxy());
	}
	
	public void testFindTypeByName_javaUtilList_07() {
		String typeName = List.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertEquals(1, type.getSuperTypes().size());
		TypeReference superTypeReference = type.getSuperTypes().get(0);
		Type superType = superTypeReference.getType();
		assertFalse(superType.eIsProxy());
		assertEquals("java.util.Collection<E>", superType.getCanonicalName());
		assertTrue(superType instanceof ParameterizedType);
		assertEquals(1, type.getTypeVariables().size());
		ParameterizedType parameterizedSuperType = (ParameterizedType) superType;
		TypeReference rawTypeRef = parameterizedSuperType.getRawType();
		Type rawType = rawTypeRef.getType();
		assertFalse(rawType.eIsProxy());
		assertEquals(1, parameterizedSuperType.getParameters().size());
		TypeParameter superTypeParameter = parameterizedSuperType.getParameters().get(0);
		assertTrue(superTypeParameter instanceof ReferenceTypeParameter);
		ReferenceTypeParameter castedSuperTypeParameter = (ReferenceTypeParameter) superTypeParameter;
		TypeReference parameterReference = castedSuperTypeParameter.getReference();
		Type parameterType = parameterReference.getType();
		assertFalse(parameterType.eIsProxy());
		assertSame(parameterType, type.getTypeVariables().get(0));
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
	
	public void test_twoListParamsNoResult_01() {
		Operation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		assertEquals(1, twoListParamsNoResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListParamsNoResult_02() {
		Operation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListParamsNoResult.getParameters().get(0);
		TypeReference paramTypeRef = firstParam.getParameterType();
		Type paramType = paramTypeRef.getType();
		assertNotNull(paramType);
		assertFalse(paramType.eIsProxy());
		assertEquals("java.util.List<T>", paramType.getCanonicalName());
		assertTrue(paramType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) paramType;
		Type rawType = parameterized.getRawType().getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListParamsNoResult_03() {
		Operation twoListParamsNoResult = getMethodFromParameterizedMethods("twoListParamsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListParamsNoResult.getParameters().get(0);
		TypeReference paramTypeRef = firstParam.getParameterType();
		Type paramType = paramTypeRef.getType();
		ParameterizedType parameterized = (ParameterizedType) paramType;
		assertEquals(1, parameterized.getParameters().size());
		TypeParameter typeParameter = parameterized.getParameters().get(0);
		assertTrue(typeParameter instanceof ReferenceTypeParameter);
		ReferenceTypeParameter referenceTypeParameter = (ReferenceTypeParameter) typeParameter;
		Type referencedType = referenceTypeParameter.getReference().getType();
		assertFalse(referencedType.eIsProxy());
		assertTrue(referencedType instanceof TypeVariable);
		TypeVariable typeVar = (TypeVariable) referencedType;
		assertEquals("T", typeVar.getName());
		assertSame(twoListParamsNoResult, typeVar.getDeclarator());
	}

	public void test_twoListParamsListResult_01() {
		Operation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		assertEquals(1, twoListParamsListResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListParamsListResult_02() {
		Operation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		TypeReference returnTypeRef = twoListParamsListResult.getReturnType();
		Type returnType = returnTypeRef.getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("java.util.List<T>", returnType.getCanonicalName());
		assertTrue(returnType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) returnType;
		Type rawType = parameterized.getRawType().getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListParamsListResult_03() {
		Operation twoListParamsListResult = getMethodFromParameterizedMethods("twoListParamsListResult(java.util.List,java.util.List)");
		TypeReference returnTypeRef = twoListParamsListResult.getReturnType();
		Type returnType = returnTypeRef.getType();
		ParameterizedType parameterized = (ParameterizedType) returnType;
		assertEquals(1, parameterized.getParameters().size());
		TypeParameter typeParameter = parameterized.getParameters().get(0);
		assertTrue(typeParameter instanceof ReferenceTypeParameter);
		ReferenceTypeParameter referenceTypeParameter = (ReferenceTypeParameter) typeParameter;
		Type referencedType = referenceTypeParameter.getReference().getType();
		assertFalse(referencedType.eIsProxy());
		assertTrue(referencedType instanceof TypeVariable);
		TypeVariable typeVar = (TypeVariable) referencedType;
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
		TypeReference paramTypeRef = firstParam.getParameterType();
		Type paramType = paramTypeRef.getType();
		assertNotNull(paramType);
		assertFalse(paramType.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object>", paramType.getCanonicalName());
		assertTrue(paramType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) paramType;
		Type rawType = parameterized.getRawType().getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListWildcardsNoResult_03() {
		Operation twoListWildcardsNoResult = getMethodFromParameterizedMethods("twoListWildcardsNoResult(java.util.List,java.util.List)");
		FormalParameter firstParam = twoListWildcardsNoResult.getParameters().get(0);
		TypeReference paramTypeRef = firstParam.getParameterType();
		Type paramType = paramTypeRef.getType();
		ParameterizedType parameterized = (ParameterizedType) paramType;
		assertEquals(1, parameterized.getParameters().size());
		TypeParameter typeParameter = parameterized.getParameters().get(0);
		assertTrue(typeParameter instanceof WildcardTypeParameter);
		WildcardTypeParameter wildcardTypeParameter = (WildcardTypeParameter) typeParameter;
		Wildcard wildcard = wildcardTypeParameter.getWildcard();
		assertEquals(1, wildcard.getConstraints().size());
		assertTrue(wildcard.getConstraints().get(0) instanceof UpperBound);
		UpperBound upperBound = (UpperBound) wildcard.getConstraints().get(0);
		assertEquals(1, upperBound.getReferencedTypes().size());
		Type upperBoundType = upperBound.getReferencedTypes().get(0).getType();
		assertFalse(upperBoundType.eIsProxy());
		assertEquals("java.lang.Object", upperBoundType.getCanonicalName());
	}
	
	public void test_twoListWildcardsListResult_01() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		assertEquals(1, twoListWildcardsListResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListWildcardsListResult_02() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		TypeReference returnTypeRef = twoListWildcardsListResult.getReturnType();
		Type returnType = returnTypeRef.getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("java.util.List<? extends java.lang.Object>", returnType.getCanonicalName());
		assertTrue(returnType instanceof ParameterizedType);
		ParameterizedType parameterized = (ParameterizedType) returnType;
		Type rawType = parameterized.getRawType().getType();
		assertFalse(rawType.eIsProxy());
		assertEquals("java.util.List", rawType.getCanonicalName());
	}
	
	public void test_twoListWildcardsListResult_03() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedMethods("twoListWildcardsListResult(java.util.List,java.util.List)");
		TypeReference returnTypeRef = twoListWildcardsListResult.getReturnType();
		Type returnType = returnTypeRef.getType();
		ParameterizedType parameterized = (ParameterizedType) returnType;
		assertEquals(1, parameterized.getParameters().size());
		TypeParameter typeParameter = parameterized.getParameters().get(0);
		assertTrue(typeParameter instanceof WildcardTypeParameter);
		WildcardTypeParameter wildcardTypeParameter = (WildcardTypeParameter) typeParameter;
		Wildcard wildcard = wildcardTypeParameter.getWildcard();
		assertEquals(1, wildcard.getConstraints().size());
		assertTrue(wildcard.getConstraints().get(0) instanceof UpperBound);
		UpperBound upperBound = (UpperBound) wildcard.getConstraints().get(0);
		assertEquals(1, upperBound.getReferencedTypes().size());
		Type upperBoundType = upperBound.getReferencedTypes().get(0).getType();
		assertFalse(upperBoundType.eIsProxy());
		assertEquals("java.lang.Object", upperBoundType.getCanonicalName());
	}
	
	public void test_arrayWildcard_01() {
		Operation arrayWildcard = getMethodFromParameterizedMethods("arrayWildcard(java.util.List[])");
		assertEquals(1, arrayWildcard.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayWildcard_02() {
		Operation arrayWildcard = getMethodFromParameterizedMethods("arrayWildcard(java.util.List[])");
		Type paramType = arrayWildcard.getParameters().get(0).getParameterType().getType();
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
		Type paramType = nestedArrayWildcard.getParameters().get(0).getParameterType().getType();
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
		Type paramType = arrayParameterized.getParameters().get(0).getParameterType().getType();
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
		Type paramType = nestedArrayParameterized.getParameters().get(0).getParameterType().getType();
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
		Type paramType = arrayVariable.getParameters().get(0).getParameterType().getType();
		assertEquals("T[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof TypeVariable);
	}
	
	public void test_nestedArrayVariable_01() {
		Operation nestedArrayVariable = getMethodFromParameterizedMethods("nestedArrayVariable(T[][])");
		assertEquals(1, nestedArrayVariable.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayVariable_02() {
		Operation nestedArrayVariable = getMethodFromParameterizedMethods("nestedArrayVariable(T[][])");
		Type paramType = nestedArrayVariable.getParameters().get(0).getParameterType().getType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof TypeVariable);
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

	protected abstract String getCollectionParamName();
}
