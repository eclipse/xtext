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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractSuperTypeCollectorTest extends TestCase {

	protected abstract IJvmTypeProvider getTypeProvider();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected SuperTypeCollector getCollector() {
		return new SuperTypeCollector(TypesFactory.eINSTANCE);
	}
	
	public void testObject() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Object.class));
		assertNotNull(collected);
		assertTrue(collected.toString(), collected.isEmpty());
	}
	
	public void testSerializable() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Serializable.class));
		assertEquals(1,collected.size());
		assertEquals(Object.class.getCanonicalName(),collected.iterator().next());
	}
	
	public void testString() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(String.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Object.class.getName(),
				Comparable.class.getName(),
				Serializable.class.getName(),
				CharSequence.class.getName()), collected);
	}
	
	public void testCollections() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Collections.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Object.class.getName()), collected);
	}
	
	public void testCollection() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(Collection.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Iterable.class.getName(),Object.class.getName()), collected);
	}
	
	public void testList() {
		Collection<String> collected = getCollector().collectSuperTypeNames(getType(List.class));
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Iterable.class.getName(),
				Collection.class.getName(),Object.class.getName()), collected);
	}
	
	public void testArgIsNull() {
		Collection<String> collected = getCollector().collectSuperTypeNames((JvmType)null);
		assertNotNull(collected);
		assertTrue(collected.isEmpty());
	}
	
	public void testIsAssignable() throws Exception {
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
}
