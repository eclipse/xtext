/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.XMemberFeatureCall
import com.google.inject.Inject
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.typesystem.^override.BottomResolvedOperation
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseNewTypeSystemInjectorProvider))
class ResolvedOperationTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver;
	
	def IResolvedOperation toOperation(String expression) {
		val featureCall = expression.expression as XMemberFeatureCall
		val resolvedTypes = typeResolver.resolveTypes(featureCall)
		val receiverType = resolvedTypes.getActualType(featureCall.memberCallTarget)
		val operation = featureCall.feature as JvmOperation
		return new BottomResolvedOperation(operation, receiverType)
	}
	
	@Test
	def void testArrayListIteratorIsBottom() {
		val operation = 'newArrayList.iterator'.toOperation
		assertTrue(operation.bottomInContext)
		assertEquals('ArrayList<Object>', operation.contextType.simpleName)
		assertEquals('iterator', operation.declaration.simpleName)
	}
	
	@Test
	def void testArrayListOfStringIteratesStrings() {
		val operation = 'newArrayList("").iterator'.toOperation
		assertEquals('ArrayList<String>', operation.contextType.simpleName)
		assertEquals('Iterator<String>', operation.returnType.simpleName)
	}
	
	@Test
	def void testIterableOfStringsIteratesStrings() {
		val operation = '(null as Iterable<? extends String>).iterator'.toOperation
		assertEquals('Iterator<? extends String>', operation.returnType.simpleName)
	}
	
	@Test
	def void testListOfStringToArray() {
		val operation = 'newArrayList("").toArray(null)'.toOperation
		assertEquals('T[]', operation.returnType.simpleName)
	}
	
	@Test
	def void testListToArrayInheritsOne() {
		val operation = '(null as java.util.List<String>).toArray(null)'.toOperation
		val overridden = operation.overriddenAndImplementedMethods
		assertEquals(1, overridden.size)
		val typeParameter = overridden.head.resolvedTypeParameters.head
		assertEquals(operation.declaration, typeParameter.declarator)
	}
	
	@Test
	def void testListToArrayHasTwoCandidates() {
		val operation = '(null as java.util.List<String>).toArray(null)'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
	}
	
	@Test
	def void testArrayListOfStringAcceptsStrings() {
		val operation = 'newArrayList("").addAll(null)'.toOperation
		assertEquals(1, operation.parameterTypes.size)
		assertEquals('Collection<? extends String>', operation.parameterTypes.head.simpleName)
	}
	
	@Test
	def void testHashSetInheritsIterator() {
		val operation = 'newHashSet("").iterator'.toOperation
		val candidates = operation.overriddenAndImplementedMethodCandidates
		assertEquals(2, candidates.size)
		assertEquals('AbstractCollection', candidates.head.declaringType.simpleName)
		assertEquals('Set', candidates.last.declaringType.simpleName)
	}
	
	@Test
	def void testInheritedAbstractCollectionIteratorIsNotBottom() {
		val operation = 'newHashSet("").iterator'.toOperation
		val candidates = operation.overriddenAndImplementedMethods
		assertFalse(candidates.head.bottomInContext)
		assertEquals('AbstractCollection<String>', candidates.head.asBottom.contextType.simpleName)
	}
	
}