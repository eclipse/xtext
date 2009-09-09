/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.TypeResource;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderTest extends TestCase {

	private ResourceSet resourceSet;
	private ClasspathTypeProvider typeProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		typeProvider = new ClasspathTypeProvider(getClass().getClassLoader(), resourceSet);
	}
	
	@Override
	protected void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
		super.tearDown();
	}
	
	public void testSetup_01() {
		Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap();
		assertSame(typeProvider, map.get(ClassURIHelper.PROTOCOL));
	}
	
	public void testCreateResource_01() {
		URI primitivesURI = URI.createURI("java:/Primitives"); 
		TypeResource resource = typeProvider.createResource(primitivesURI);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}
	
	public void testCreateResource_02() {
		URI primitivesURI = URI.createURI("java:/Primitives"); 
		TypeResource resource = (TypeResource) resourceSet.createResource(primitivesURI);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}
	
	public void testGetResource_01() {
		URI primitivesURI = URI.createURI("java:/Primitives"); 
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, true);
		assertNotNull(resource);
		assertTrue(resource.isLoaded());
		assertEquals(9, resource.getContents().size());
	}
	
	public void testGetResource_02() {
		URI primitivesURI = URI.createURI("java:/Primitives"); 
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, false);
		assertNull(resource);
	}
	
	public void testGetResource_03() {
		URI primitivesURI = URI.createURI("java:/Primitives"); 
		TypeResource createdResource = (TypeResource) resourceSet.createResource(primitivesURI);
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, false);
		assertSame(createdResource, resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}
	
	public void testGetResource_04() {
		URI primitivesURI = URI.createURI("java:/Primitives"); 
		TypeResource createdResource = (TypeResource) resourceSet.createResource(primitivesURI);
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, true);
		assertSame(createdResource, resource);
		assertTrue(resource.isLoaded());
		assertEquals(9, resource.getContents().size());
	}
	
	public void testCreateMirror_01() {
		URI uri = URI.createURI("java:/Objects/java.util.Map");
		IMirror mirror = typeProvider.createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof ClassMirror);
		assertEquals("java.util.Map", ((ClassMirror) mirror).getMirroredClass().getName());
	}
	
	public void testCreateMirror_02() {
		URI uri = URI.createURI("java:/Primitives");
		IMirror mirror = typeProvider.createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof PrimitiveMirror);
	}
	
	public void testCreateMirror_03() {
		URI uri = URI.createURI("java:/Something");
		try {
			typeProvider.createMirror(uri);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}
	
	public void testCreateMirror_04() {
		URI uri = URI.createURI("java:/Primitives").appendFragment("int");
		try {
			typeProvider.createMirror(uri);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}
	
	public void testCreateMirror_05() {
		URI uri = URI.createURI("java:/Objects/java.lang.does.not.exist");
		try {
			typeProvider.createMirror(uri);
			fail("Expected TypeNotFoundException");
		} catch (TypeNotFoundException ex) {
			// OK
		}
	}
	
	public void testNormalizeClassName_01() {
		String name = String.class.getName();
		assertEquals(name, typeProvider.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_02() {
		String name = String[].class.getName();
		assertEquals(name, typeProvider.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_03() {
		String name = int.class.getName();
		assertEquals(name, typeProvider.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_04() {
		String name = int[].class.getName();
		assertEquals(name, typeProvider.normalizeClassName(name));
	}
	
	public void testNormalizeClassName_05() {
		String name = String[].class.getName();
		assertEquals(name, typeProvider.normalizeClassName(String.class.getName() + "[]"));
	}
	
	public void testNormalizeClassName_06() {
		String name = int[].class.getName();
		assertEquals(name, typeProvider.normalizeClassName(int.class.getName() + "[]"));
	}
	
	public void testNormalizeClassName_07() {
		Class<?>[] allArrayTypes = {
				boolean[].class,
				int[].class,
				float[].class,
				byte[].class,
				char[].class,
				double[].class,
				short[].class,
				long[].class,
				String[].class
		};
		for(Class<?> arrayType: allArrayTypes) {
			Class<?> componentType = arrayType.getComponentType();
			String name = componentType.getName() + "[]";
			String expectedName = arrayType.getName();
			assertEquals(expectedName, typeProvider.normalizeClassName(name));
		}
	}
	
	public void testFindTypeByName_int() {
		String typeName = "int";
		Type type = typeProvider.findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof PrimitiveType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_twice() {
		String typeName = "int";
		Type firstType = typeProvider.findTypeByName(typeName);
		Type secondType = typeProvider.findTypeByName(typeName);
		assertSame(firstType, secondType);
	}
	
	public void testFindTypeByName_int_array_01() {
		String typeName = "int[]";
		Type type = typeProvider.findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_array_02() {
		String typeName = int[].class.getName();
		Type type = typeProvider.findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals("int[]", type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_array_03() {
		String typeName = int[][][].class.getName();
		Type type = typeProvider.findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals("int[][][]", type.getCanonicalName());
	}
	
	public void testFindTypeByName_int_array_04() {
		String typeName = "int[][][]";
		Type type = typeProvider.findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof ArrayType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_01() {
		String typeName = CharSequence.class.getName();
		Type type = typeProvider.findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof GenericType);
		assertEquals(typeName, type.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_02() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) typeProvider.findTypeByName(typeName);
		assertEquals(4, type.getMembers().size());
		Set<String> allNames = Sets.newHashSet("length", "charAt", "subSequence", "toString");
		for(org.eclipse.xtext.common.types.Member member: type.getMembers()) {
			assertTrue(member.getCanonicalName(), member instanceof Operation);
			Operation op = (Operation) member;
			assertTrue(op.getName(), allNames.remove(op.getName()));
		}
	}
	
	public void testFindTypeByName_javaLangCharSequence_03() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) typeProvider.findTypeByName(typeName);
		Operation length = (Operation) type.eResource().getEObject("java.lang.CharSequence.length()");
		assertNotNull(length);
		Type returnType = length.getReturnType().getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("int", returnType.getCanonicalName());
	}
	
	public void testFindTypeByName_javaLangCharSequence_04() {
		String typeName = CharSequence.class.getName();
		GenericType type = (GenericType) typeProvider.findTypeByName(typeName);
		Operation charAt = (Operation) type.eResource().getEObject("java.lang.CharSequence.charAt(int)");
		assertNotNull(charAt);
		Type returnType = charAt.getReturnType().getType();
		assertNotNull(returnType);
		assertFalse(returnType.eIsProxy());
		assertEquals("char", returnType.getCanonicalName());
		assertEquals(1, charAt.getParameters().size());
		Type intType = typeProvider.findTypeByName("int");
		assertSame(intType, charAt.getParameters().get(0).getParameterType().getType());
	}
	
	public void testFindTypeByName_javaLangNumber_01() {
		String typeName = Number.class.getName();
		GenericType type = (GenericType) typeProvider.findTypeByName(typeName);
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
		ArrayType type = (ArrayType) typeProvider.findTypeByName(typeName);
		Operation longValue = (Operation) type.eResource().getEObject("java.lang.Number.longValue()");
		assertNotNull(longValue);
		DeclaredType number = longValue.getDeclaringType();
		assertNotNull(number.getArrayType());
		assertSame(type, number.getArrayType().getArrayType());
		assertNull(type.getArrayType());
	}
}
