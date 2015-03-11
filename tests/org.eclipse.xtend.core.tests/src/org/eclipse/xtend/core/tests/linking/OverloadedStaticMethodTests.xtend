/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.typesystem.^override.BottomResolvedOperation
import org.eclipse.xtext.xbase.typesystem.^override.OverrideTester
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices
import org.junit.Test

/**
 * Use a copy of org.junit.Assert as test data
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractOverloadedStaticMethodTest extends AbstractXtendTestCase {
	
	@Inject OverrideTester overrideTester
	@Inject CommonTypeComputationServices services
	
	protected def void linksTo(String invocation, String method) {
		val file = invocation.inMethodBody.file(false)
		val c = file.xtendTypes.head as XtendClass
		val m = c.members.head as XtendFunction
		val body = m.expression as XBlockExpression
		val featureCall = body.expressions.last as XAbstractFeatureCall
		val operation = featureCall.feature as JvmOperation
		val owner = new StandardTypeReferenceOwner(services, file)
		val declaration = owner.newParameterizedTypeReference(operation.declaringType)
		val resolved = new BottomResolvedOperation(operation, declaration, overrideTester)
		assertEquals(method, resolved.simpleSignature)
		assertTrue(file.eResource.errors.join("\n"), file.eResource.errors.empty)
		assertNull(featureCall.implicitReceiver)
		assertNull(featureCall.implicitFirstArgument)
	}
	
	protected def String inMethodBody(String invocation)
	
	@Test
	def void failWithoutArguments() {
		'fail'.linksTo('fail()')
	}
	
	@Test
	def void failWithExplicitArgument() {
		'fail("")'.linksTo('fail(String)')
	}
	
	@Test
	def void failWithImplicitOnScope() {
		'val String it = null fail'.linksTo('fail()')
	}
	
	@Test
	def void assertEqualsNullAsObjectArray() {
		// that's what JDT resolves
		'assertEquals(null, null)'.linksTo('assertEquals(Object[], Object[])')
	}
	
	@Test
	def void assertEqualsStringNumberArray() {
		// that's what JDT resolves
		'assertEquals(null as String[], null as Number[])'.linksTo('assertEquals(Object[], Object[])')
	}
	
	@Test
	def void assertEqualsNullAsObjectArrayWithMessage() {
		// that's what JDT resolves
		'assertEquals("", null, null)'.linksTo('assertEquals(String, Object[], Object[])')
	}
	
	@Test
	def void assertEqualsNullAsObjectArrayWithNullMessage() {
		// that's what JDT resolves
		'assertEquals(null, null, null)'.linksTo('assertEquals(String, Object[], Object[])')
	}
	
	@Test
	def void assertEqualsObjectNull() {
		'assertEquals(null as Object, null)'.linksTo('assertEquals(Object, Object)')
	}
	
	@Test
	def void assertEqualsNullObject() {
		'assertEquals(null, null as Object)'.linksTo('assertEquals(Object, Object)')
	}
	
	@Test
	def void assertEqualsWithIterables() {
		'assertEquals(null as Iterable<String>, null as Iterable<String>)'.linksTo('assertEquals(Object, Object)')
	}
	
	@Test
	def void assertEqualsWithLists() {
		'assertEquals(null as java.util.List<String>, null as java.util.List<String>)'.linksTo('assertEquals(Object, Object)')
	}
	
	@Test
	def void assertEqualsWithListAndObjectArray() {
		'assertEquals(null as java.util.List<String>, null as Object[])'.linksTo('assertEquals(Object, Object)')
	}
	
	@Test
	def void assertEqualsWithBooleans() {
		'assertEquals(true, true)'.linksTo('assertEquals(Object, Object)')
	}
	
	@Test
	def void assertEqualsWithBooleansAndMessage() {
		'assertEquals("", true, true)'.linksTo('assertEquals(String, Object, Object)')
	}
	
	@Test
	def void assertEqualsWithBooleansAndNullMessage() {
		'assertEquals(null, true, true)'.linksTo('assertEquals(String, Object, Object)')
	}
}

/**
 * Use a copy of org.junit.Assert as test data
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class InheritedStaticMethodTest extends AbstractOverloadedStaticMethodTest {
	protected override inMethodBody(String invocation) '''
		import overloading.CopiedAssert
		class C extends CopiedAssert {
			def void m() {
				«invocation»
			}
		}
	'''
}