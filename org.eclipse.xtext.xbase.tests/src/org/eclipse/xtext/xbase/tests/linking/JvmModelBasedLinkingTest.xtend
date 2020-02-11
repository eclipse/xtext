/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseWithLogicalContainerInjectorProvider))
class JvmModelBasedLinkingTest extends AbstractXbaseTestCase {
	
	@Inject extension JvmTypesBuilder
	@Inject TypeReferences refs
	@Inject extension ValidationTestHelper
	
	@Test
	def void testLinkToParameter() {
		val expr = expression("x", false)
		val resource = expr.eResource
		resource.eSetDeliver(false)
		resource.contents += expr.toClass("Foo") [
			members += expr.toMethod("doStuff", expr.stringType) [
				parameters += expr.toParameter("x", expr.stringType)
				setBody(expr)
			]
		]
		
		expr.assertNoErrors
	}
	
	@Test
	def void testLinkToParameter_1() {
		val expr = expression("x", false) as XFeatureCall
		val resource = expr.eResource
		resource.eSetDeliver(false)
		resource.contents += expr.toClass("Foo") [
			members += expr.toField("x", expr.stringType)
			members += expr.toMethod("doStuff", expr.stringType) [
				parameters += expr.toParameter("x", expr.stringType)
				setBody(expr)
			]
		]
		expr.assertNoErrors
		assertTrue( expr.feature instanceof JvmFormalParameter)
	}
	
	@Test
	def void testLinkToField() {
		val expr = expression("x", false) as XFeatureCall
		val resource = expr.eResource
		resource.eSetDeliver(false)
		resource.contents += expr.toClass("Foo") [
			members += expr.toField("x", expr.stringType)
			members += expr.toMethod("doStuff", expr.stringType) [
				parameters += expr.toParameter("y", expr.stringType)
				setBody(expr)
			]
		]
		expr.assertNoErrors
		assertTrue( expr.feature instanceof JvmField)
	}
	
	@Test
	def void testLinkToField_1() {
		val expr = expression("x", false) as XFeatureCall
		val resource = expr.eResource
		resource.eSetDeliver(false)
		resource.contents += expr.toClass("Foo") [
			members += expr.toField("x", expr.stringType)
			members += expr.toMethod("getX", expr.stringType) [
				setBody(expr)
			]
		]
		expr.assertNoErrors
		assertTrue( expr.feature instanceof JvmField)
	}
	
	def stringType(EObject ctx) {
		refs.getTypeForName(typeof(String), ctx)
	}
}

