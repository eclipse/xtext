/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.linking

import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.resource.BatchLinkableResource
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BeforeLinkingTest extends AbstractXbaseTestCase {
	
	@Inject extension ParseHelper<XExpression>
	
	@Inject extension ReflectExtensions
	
	@Test
	def void testImplicitLambdaParameter() {
		val block = '''
			{
				val Comparable<String> c = [ length ]
				c.toString
			}
		'''.parse as XBlockExpression
		val resource = block.eResource as BatchLinkableResource
		resource.resolveLazyCrossReferences(null)
		val assignment = block.expressions.head as XVariableDeclaration
		val lambda = assignment.right as XClosure
		val implicitParameter = lambda.implicitFormalParameters.head
		assertEquals('String', implicitParameter.parameterType.simpleName)
		resource.update(0, 0, '')
		assertNull(implicitParameter.eResource)
	}
	
	@Test
	def void testImplicitReceiver() {
		val block = '''
			{
				val it = ''
				toString
			}
		'''.parse as XBlockExpression
		val resource = block.eResource as BatchLinkableResource
		val toString = block.expressions.last as XFeatureCall
		val implicitReceiver = toString.implicitReceiver as XFeatureCall
		assertEquals('it', implicitReceiver.feature.simpleName)
		resource.update(0, 0, '')
		assertNull(toString.get('implicitReceiver'))
		assertNotNull(toString.implicitReceiver) // computed on demand	
	}
	
	@Test
	def void testImplicitFirstArgument() {
		val block = '''
			{
				val it = newArrayList
				unmodifiableView
			}
		'''.parse as XBlockExpression
		val resource = block.eResource as BatchLinkableResource
		val unmodifiableView = block.expressions.last as XFeatureCall
		val implicitFirstArgument = unmodifiableView.implicitFirstArgument as XFeatureCall
		assertEquals('it', implicitFirstArgument.feature.simpleName)
		resource.update(0, 0, '')
		assertNull(unmodifiableView.get('implicitFirstArgument'))
		assertNotNull(unmodifiableView.implicitFirstArgument) // computed on demand	
	}
	
}