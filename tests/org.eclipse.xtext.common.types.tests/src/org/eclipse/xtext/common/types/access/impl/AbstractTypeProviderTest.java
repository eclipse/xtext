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
import org.eclipse.xtext.common.types.access.scenarios.ParameterizedTypes;

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

	private Operation getMethodFromParameterizedTypes(String method) {
		String typeName = ParameterizedTypes.class.getName();
		GenericType type = (GenericType) getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		Operation result = (Operation) type.eResource().getEObject(ParameterizedTypes.class.getName() + "."+ method);
		assertNotNull(result);
		return result;
	}
	
	public void test_twoListParamsNoResult_01() {
		Operation twoListParamsNoResult = getMethodFromParameterizedTypes("twoListParamsNoResult(java.util.List,java.util.List)");
		assertEquals(1, twoListParamsNoResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListParamsNoResult_02() {
		Operation twoListParamsNoResult = getMethodFromParameterizedTypes("twoListParamsNoResult(java.util.List,java.util.List)");
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
		Operation twoListParamsNoResult = getMethodFromParameterizedTypes("twoListParamsNoResult(java.util.List,java.util.List)");
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
		Operation twoListParamsListResult = getMethodFromParameterizedTypes("twoListParamsListResult(java.util.List,java.util.List)");
		assertEquals(1, twoListParamsListResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListParamsListResult_02() {
		Operation twoListParamsListResult = getMethodFromParameterizedTypes("twoListParamsListResult(java.util.List,java.util.List)");
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
		Operation twoListParamsListResult = getMethodFromParameterizedTypes("twoListParamsListResult(java.util.List,java.util.List)");
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
		Operation twoListWildcardsNoResult = getMethodFromParameterizedTypes("twoListWildcardsNoResult(java.util.List,java.util.List)");
		assertEquals(1, twoListWildcardsNoResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListWildcardsNoResult_02() {
		Operation twoListWildcardsNoResult = getMethodFromParameterizedTypes("twoListWildcardsNoResult(java.util.List,java.util.List)");
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
		Operation twoListWildcardsNoResult = getMethodFromParameterizedTypes("twoListWildcardsNoResult(java.util.List,java.util.List)");
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
		Operation twoListWildcardsListResult = getMethodFromParameterizedTypes("twoListWildcardsListResult(java.util.List,java.util.List)");
		assertEquals(1, twoListWildcardsListResult.getDeclaredParameterizedTypes().size());
	}
	
	public void test_twoListWildcardsListResult_02() {
		Operation twoListWildcardsListResult = getMethodFromParameterizedTypes("twoListWildcardsListResult(java.util.List,java.util.List)");
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
		Operation twoListWildcardsListResult = getMethodFromParameterizedTypes("twoListWildcardsListResult(java.util.List,java.util.List)");
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
		Operation arrayWildcard = getMethodFromParameterizedTypes("arrayWildcard(java.util.List[])");
		assertEquals(1, arrayWildcard.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayWildcard_02() {
		Operation arrayWildcard = getMethodFromParameterizedTypes("arrayWildcard(java.util.List[])");
		Type paramType = arrayWildcard.getParameters().get(0).getParameterType().getType();
		assertEquals("java.util.List<? extends java.lang.Object>[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_nestedArrayWildcard_01() {
		Operation nestedArrayWildcard = getMethodFromParameterizedTypes("nestedArrayWildcard(java.util.List[][])");
		assertEquals(1, nestedArrayWildcard.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayWildcard_02() {
		Operation nestedArrayWildcard = getMethodFromParameterizedTypes("nestedArrayWildcard(java.util.List[][])");
		Type paramType = nestedArrayWildcard.getParameters().get(0).getParameterType().getType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_arrayParameterized_01() {
		Operation arrayParameterized = getMethodFromParameterizedTypes("arrayParameterized(java.util.List[])");
		assertEquals(1, arrayParameterized.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayParameterized_02() {
		Operation arrayParameterized = getMethodFromParameterizedTypes("arrayParameterized(java.util.List[])");
		Type paramType = arrayParameterized.getParameters().get(0).getParameterType().getType();
		assertEquals("java.util.List<T>[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_nestedArrayParameterized_01() {
		Operation nestedArrayParameterized = getMethodFromParameterizedTypes("nestedArrayParameterized(java.util.List[][])");
		assertEquals(1, nestedArrayParameterized.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayParameterized_02() {
		Operation nestedArrayParameterized = getMethodFromParameterizedTypes("nestedArrayParameterized(java.util.List[][])");
		Type paramType = nestedArrayParameterized.getParameters().get(0).getParameterType().getType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof ParameterizedType);
	}
	
	public void test_arrayVariable_01() {
		Operation arrayVariable = getMethodFromParameterizedTypes("arrayVariable(T[])");
		assertEquals(1, arrayVariable.getDeclaredParameterizedTypes().size());
	}
	
	public void test_arrayVariable_02() {
		Operation arrayVariable = getMethodFromParameterizedTypes("arrayVariable(T[])");
		Type paramType = arrayVariable.getParameters().get(0).getParameterType().getType();
		assertEquals("T[]", paramType.getCanonicalName());
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof TypeVariable);
	}
	
	public void test_nestedArrayVariable_01() {
		Operation nestedArrayVariable = getMethodFromParameterizedTypes("nestedArrayVariable(T[][])");
		assertEquals(1, nestedArrayVariable.getDeclaredParameterizedTypes().size());
	}
	
	public void test_nestedArrayVariable_02() {
		Operation nestedArrayVariable = getMethodFromParameterizedTypes("nestedArrayVariable(T[][])");
		Type paramType = nestedArrayVariable.getParameters().get(0).getParameterType().getType();
		assertTrue(paramType instanceof ArrayType);
		ArrayType arrayType = (ArrayType) paramType;
		assertTrue(arrayType.getComponentType() instanceof ArrayType);
		arrayType = (ArrayType) arrayType.getComponentType();
		assertTrue(arrayType.getComponentType() instanceof TypeVariable);
	}

	protected abstract String getCollectionParamName();
}
