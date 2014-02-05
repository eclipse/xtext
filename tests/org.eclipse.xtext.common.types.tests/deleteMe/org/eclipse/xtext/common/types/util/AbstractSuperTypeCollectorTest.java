/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public abstract class AbstractSuperTypeCollectorTest extends Assert {

	protected abstract IJvmTypeProvider getTypeProvider();
	
	protected abstract SuperTypeCollector getCollector();
	
	@BeforeClass public static void createMockJavaProject() throws Exception {
		MockJavaProjectProvider.setUp();
	}

	@Test public void testObject() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Object.class));
		assertNotNull(collected);
		assertTrue(collected.toString(), collected.isEmpty());
	}
	
	@Test public void testSerializable() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Serializable.class));
		assertEquals(1,collected.size());
		assertEquals(Object.class.getCanonicalName(),collected.iterator().next());
	}
	
	@Test public void testString() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(String.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Object.class.getName(),
				Comparable.class.getName(),
				Serializable.class.getName(),
				CharSequence.class.getName()), collected);
	}
	
	@Test public void testStringArray() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getArrayType(String[].class));
		assertNotNull(collected);
		ImmutableSet<String> expectation = ImmutableSet.of(
				"java.lang.Object[]",
				"java.lang.Comparable<java.lang.String>[]",
				"java.io.Serializable[]",
				"java.lang.CharSequence[]",
				Cloneable.class.getName(),
				Object.class.getName(),
				Serializable.class.getName());
		assertEquals(collected.toString(), expectation.size(), collected.size());
		assertEquals(collected.toString(), expectation, collected);
	}
	
	@Test public void testObjectArray() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getArrayType(Object[].class));
		assertNotNull(collected);
		ImmutableSet<String> expectation = ImmutableSet.of(
				Cloneable.class.getName(),
				Object.class.getName(),
				Serializable.class.getName());
		assertEquals(collected.toString(), expectation.size(), collected.size());
		assertEquals(collected.toString(), expectation, collected);
	}
	
	@Test public void testPrimitiveArray() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getArrayType(int[].class));
		assertNotNull(collected);
		ImmutableSet<String> expectation = ImmutableSet.of(
				Cloneable.class.getName(),
				Object.class.getName(),
				Serializable.class.getName());
		assertEquals(collected.toString(), expectation.size(), collected.size());
		assertEquals(collected.toString(), expectation, collected);
	}
	
	@Test public void testCollections() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Collections.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Object.class.getName()), collected);
	}
	
	@Test public void testCollection() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Collection.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Iterable.class.getName(),Object.class.getName()), collected);
	}
	
	@Test public void testList() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(List.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Iterable.class.getName(),
				Collection.class.getName(),Object.class.getName()), collected);
	}
	
	@Test public void testStringBuffer() {
		Collection<JvmTypeReference> collected = getCollector().collectSuperTypes(getType(StringBuffer.class));
		assertNotNull(collected);
		List<JvmType> rawTypes = Lists.newArrayList(Collections2.transform(collected, new Function<JvmTypeReference, JvmType>() {
			public JvmType apply(JvmTypeReference from) {
				return from.getType();
			}
		}));
		Set<JvmType> rawTypesWithoutDuplicates = Sets.newHashSet(rawTypes);
		assertEquals(rawTypesWithoutDuplicates.size(), rawTypes.size());
	}
	
	@Test public void testSortedResultForList() {
		Iterator<String> collected = getCollector().collectSuperTypeNames(getType(List.class)).iterator();
		assertEquals(Collection.class.getName(),collected.next());
		assertEquals(Iterable.class.getName(),collected.next());
		assertEquals(Object.class.getName(),collected.next());
		assertFalse(collected.hasNext());
	}
	
	@Test public void testSortedResultForArrayList() {
		Iterator<String> collected = getCollector().collectSuperTypeNames(getType(ArrayList.class)).iterator();
		assertEquals(AbstractList.class.getName(),collected.next());
		assertEquals(AbstractCollection.class.getName(),collected.next());
		assertEquals(Object.class.getName(),collected.next());
		assertEquals(Collection.class.getName(),collected.next());
		assertEquals(Iterable.class.getName(),collected.next());
		assertEquals(List.class.getName(),collected.next());
		assertEquals(RandomAccess.class.getName(),collected.next());
		assertEquals(Cloneable.class.getName(),collected.next());
		assertEquals(Serializable.class.getName(),collected.next());
		assertFalse(collected.hasNext());
	}
	
	@Test public void testArgIsNull() {
		Collection<String> collected = getCollector().collectSuperTypeNames((JvmType)null);
		assertNotNull(collected);
		assertTrue(collected.isEmpty());
	}
	
	@Test public void testIsAssignable() throws Exception {
		assertFalse(getCollector().isSuperType(null, null));
		assertFalse(getCollector().isSuperType(null, getType(Object.class)));
		assertFalse(getCollector().isSuperType(getType(Object.class), null));
		assertFalse(getCollector().isSuperType(getType(Object.class), getType(String.class)));
		assertFalse(getCollector().isSuperType(getType(CharSequence.class), getType(String.class)));
		assertFalse(getCollector().isSuperType(getType(CharSequence.class), getType(Serializable.class)));
		assertFalse(getCollector().isSuperType(getType(CharSequence.class), getType(CharSequence.class)));
		assertTrue(getCollector().isSuperType(getType(String.class), getType(Serializable.class)));
		assertTrue(getCollector().isSuperType(getType(String.class), getType(CharSequence.class)));
		assertTrue(getCollector().isSuperType(getType(String.class), getType(Object.class)));
		assertTrue(getCollector().isSuperType(getType(List.class), getType(Collection.class)));
		assertTrue(getCollector().isSuperType(getType(ArrayList.class), getType(AbstractCollection.class)));
		assertTrue(getCollector().isSuperType(getType(ArrayList.class), getType(Serializable.class)));
	}
	
	protected JvmDeclaredType getType(Class<?> clazz) {
		return (JvmDeclaredType) getTypeProvider().findTypeByName(clazz.getCanonicalName());
	}
	
	protected JvmArrayType getArrayType(Class<?> clazz) {
		return (JvmArrayType) getTypeProvider().findTypeByName(clazz.getCanonicalName());
	}
}
