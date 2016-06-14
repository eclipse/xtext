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
abstract class AbstractOverloadedInstanceMethodTest extends AbstractXtendTestCase {
	
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
		assertNotNull(featureCall.implicitReceiver)
		assertNull(featureCall.implicitFirstArgument)
	}
	
	protected def String inMethodBody(String invocation)
	
	@Test
	def void putWithAllNulls() {
		'put(null, null, null)'.linksTo('put(MapBasedPreferenceValues, PreferenceKey, Object)')
	}
	
	@Test
	def void assertFormattedWithNull() {
		'assertFormatted(null)'.linksTo('assertFormatted(CharSequence)')
	}
	
	@Test
	def void assertFormattedWithTemplate() {
		"assertFormatted('''''')".linksTo('assertFormatted(CharSequence)')
	}
	
	@Test
	def void assertFormattedWithString() {
		"assertFormatted('')".linksTo('assertFormatted(CharSequence)')
	}
	
	@Test
	def void assertFormattedWithLambdaAndNull() {
		"assertFormatted([], null)".linksTo('assertFormatted(Procedure1<? super MapBasedPreferenceValues>, CharSequence)')
	}
	@Test
	def void assertFormattedWithLambdaAndString() {
		"assertFormatted([], '')".linksTo('assertFormatted(Procedure1<? super MapBasedPreferenceValues>, CharSequence)')
	}
	@Test
	def void assertFormattedWithLambdaAndTemplate() {
		"assertFormatted([], '''''')".linksTo('assertFormatted(Procedure1<? super MapBasedPreferenceValues>, CharSequence)')
	}
	
	@Test
	def void assertFormattedMemberWithLambdaAndNull() {
		"assertFormattedMember([], null)".linksTo(
			'assertFormattedMember(Procedure1<? super MapBasedPreferenceValues>, String)')
	}
	@Test
	def void assertFormattedMemberWithLambdaAndString() {
		"assertFormattedMember([], '')".linksTo(
			'assertFormattedMember(Procedure1<? super MapBasedPreferenceValues>, String)')
	}
	@Test
	def void assertFormattedMemberWithLambdaAndTemplate() {
		"assertFormattedMember([], '''''')".linksTo(
			'assertFormattedMember(Procedure1<? super MapBasedPreferenceValues>, String)')
	}
	
}

/**
 * Use a copy of org.junit.Assert as test data
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class InheritedInstanceMethodTest extends AbstractOverloadedInstanceMethodTest {
	protected override inMethodBody(String invocation) '''
		import overloading.CopiedAbstractXtendFormatterTest
		class C extends CopiedAbstractXtendFormatterTest {
			def void m() {
				«invocation»
			}
		}
	'''
}