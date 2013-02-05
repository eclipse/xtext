/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.common.collect.Iterables
import com.google.common.collect.UnmodifiableIterator
import com.google.inject.Inject
import java.lang.ref.SoftReference
import java.util.AbstractList
import java.util.ArrayList
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper
import org.eclipse.xtext.xbase.typesystem.^override.ResolvedOperations
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ResolvedOperationsTest extends AbstractXbaseTestCase {
	
	@Inject
	OverrideHelper overrideHelper
	
	def ResolvedOperations toResolvedOperations(Class<?> type) {
		val typeLiteral = '''typeof(«type.canonicalName»)'''.expression as XTypeLiteral
		val result = overrideHelper.getResolvedOperations(typeLiteral.type as JvmDeclaredType)
		return result
	}
	
	def ResolvedOperations toResolvedOperations(String castExpression) {
		val cast = castExpression.expression as XCastedExpression
		val result = overrideHelper.getResolvedOperations(cast.type)
		return result
	}
	
	@Test
	def void testArrayListHasNoAbstractMethods() {
		val resolvedOperations = typeof(ArrayList).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		all.forEach [
			assertFalse(declaration.isAbstract)
		]
	}
	
	@Test
	def void testIterableIterator() {
		val resolvedOperations = typeof(Iterable).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		val iterator = Iterables::getOnlyElement(all.filter [ declaration.isAbstract ])
		assertEquals("java.lang.Iterable.iterator()", iterator.declaration.identifier)
	}
	
	@Test
	def void testUnmodifiableIterator() {
		val resolvedOperations = typeof(UnmodifiableIterator).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		assertEquals(all.toString, 2, all.filter [ declaration.isAbstract ].size)
		assertEquals(all.toString, 1 /* remove */ + 6 /* from Object */, all.filter [ declaration.final ].size)
		val declared = resolvedOperations.declaredOperations
		assertEquals(1, declared.size)
	}
	
	@Test
	def void testAbstractList() {
		val resolvedOperations = typeof(AbstractList).toResolvedOperations
		val all = resolvedOperations.allOperations
		assertFalse(all.empty)
		assertEquals(all.toString, 1 /* AbstractList.get */ + 1 /* AbstractCollection.size */, all.filter [ declaration.isAbstract ].size)
		val declared = resolvedOperations.declaredOperations
		assertEquals(1, declared.filter [ declaration.isAbstract ].size)
	}
	
	@Test
	def void testSoftReferenceConstructors() {
		val resolvedOperations = typeof(SoftReference).toResolvedOperations
		assertEquals(1, resolvedOperations.declaredOperations.size)
		assertEquals(2, resolvedOperations.declaredConstructors.size)
		resolvedOperations.declaredConstructors.forEach [
			switch(declaration.parameters.size) {
				case 1: {
					assertEquals("SoftReference(T)", resolvedSignature)
					assertEquals("SoftReference(java.lang.Object)", resolvedErasureSignature)
				}
				case 2: {
					assertEquals("SoftReference(T,java.lang.ref.ReferenceQueue<? super T>)", resolvedSignature)
					assertEquals("SoftReference(java.lang.Object,java.lang.ref.ReferenceQueue)", resolvedErasureSignature)
				}
				default: fail("Unexpected constructor: " + it)
			}
		]
	}
	
	
	@Test
	def void testSoftReferenceOfString() {
		val resolvedOperations = "null as java.lang.ref.SoftReference<String>".toResolvedOperations
		assertEquals(1, resolvedOperations.declaredOperations.size)
		assertEquals(2, resolvedOperations.declaredConstructors.size)
		resolvedOperations.declaredConstructors.forEach [
			switch(declaration.parameters.size) {
				case 1: {
					assertEquals("SoftReference(java.lang.String)", resolvedSignature)
					assertEquals("SoftReference(java.lang.String)", resolvedErasureSignature)
				}
				case 2: {
					assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue<? super java.lang.String>)", resolvedSignature)
					assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue)", resolvedErasureSignature)
				}
				default: fail("Unexpected constructor: " + it)
			}
		]
	}
	
}