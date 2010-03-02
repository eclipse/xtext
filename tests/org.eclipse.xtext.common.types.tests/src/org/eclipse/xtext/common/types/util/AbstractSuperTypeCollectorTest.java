/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.ITypeProvider;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractSuperTypeCollectorTest extends TestCase {

	private SuperTypeCollector collector;

	protected abstract ITypeProvider getTypeProvider();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		collector = new SuperTypeCollector();
	}
	
	@Override
	protected void tearDown() throws Exception {
		collector = null;
		super.tearDown();
	}
	
	public void testObject() {
		JvmType objectType = getTypeProvider().findTypeByName(Object.class.getName());
		Collection<String> collected = collector.collectSuperTypeNames(objectType);
		assertNotNull(collected);
		assertTrue(collected.toString(), collected.isEmpty());
	}
	
	public void testSerializable() {
		JvmType objectType = getTypeProvider().findTypeByName(Serializable.class.getName());
		Collection<String> collected = collector.collectSuperTypeNames(objectType);
		assertNotNull(collected);
		assertTrue(collected.isEmpty());
	}
	
	public void testString() {
		JvmType objectType = getTypeProvider().findTypeByName(String.class.getName());
		Collection<String> collected = collector.collectSuperTypeNames(objectType);
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Object.class.getName(),
				Comparable.class.getName(),
				Serializable.class.getName(),
				CharSequence.class.getName()), collected);
	}
	
	public void testCollections() {
		JvmType objectType = getTypeProvider().findTypeByName(Collections.class.getName());
		Collection<String> collected = collector.collectSuperTypeNames(objectType);
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Object.class.getName()), collected);
	}
	
	public void testCollection() {
		JvmType objectType = getTypeProvider().findTypeByName(Collection.class.getName());
		Collection<String> collected = collector.collectSuperTypeNames(objectType);
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Iterable.class.getName()), collected);
	}
	
	public void testList() {
		JvmType objectType = getTypeProvider().findTypeByName(List.class.getName());
		Collection<String> collected = collector.collectSuperTypeNames(objectType);
		assertNotNull(collected);
		assertEquals(collected.toString(), ImmutableSet.of(
				Iterable.class.getName(),
				Collection.class.getName()), collected);
	}
	
	public void testArgIsNull() {
		Collection<String> collected = collector.collectSuperTypeNames(null);
		assertNotNull(collected);
		assertTrue(collected.isEmpty());
	}
}
