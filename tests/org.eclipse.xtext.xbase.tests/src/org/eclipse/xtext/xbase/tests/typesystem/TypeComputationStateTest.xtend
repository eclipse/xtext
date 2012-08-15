/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.junit.typesystem.PublicReentrantTypeResolver
import org.eclipse.xtext.xbase.junit.typesystem.PublicResolvedTypes
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer
import org.eclipse.xtext.xbase.typesystem.internal.ChildExpressionTypeComputationState
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionTypeComputationState
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.RootExpressionComputationState
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationState

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class TypeComputationStateTest extends AbstractXbaseTestCase implements ITypeComputer {
	
	@Inject PublicReentrantTypeResolver resolver
	
	@Inject extension ReflectExtensions
	
	@Test
	def void testChildrenAddEntryForParent() {
		resolver.typeComputer = this 
		val expression = expression("{ null }")
		val resolution = new PublicResolvedTypes(resolver)
		val any = new AnyTypeReference(resolution.getReferenceOwner())
		new RootExpressionComputationState(resolution, resolver.batchScopeProvider.newSession(expression.eResource), expression, resolver, any).computeTypes
		assertEquals(any.toString, resolution.getActualType(expression).identifier)
		assertEquals(any.toString, resolution.internalGetActualType(expression).toString)
		assertEquals(any.toString, resolution.getActualType(expression.eContents.head as XNullLiteral).identifier)
		assertEquals(any.toString, resolution.internalGetActualType(expression.eContents.head as XNullLiteral).toString)
	}

	override computeTypes(XExpression expression, LightweightTypeComputationState state) {
		assertTrue("state is instanceof ExpressionTypeComputationState", state instanceof ExpressionTypeComputationState)
		val expectedType = state.immediateExpectations.head.expectedType
		if (state instanceof ChildExpressionTypeComputationState) {
			val casted = state as ChildExpressionTypeComputationState
			val resolution = casted.<ResolvedTypes>get("resolvedTypes")
			val parentResolution = casted.<ExpressionTypeComputationState>get("parent").<ResolvedTypes>get("resolvedTypes")
			assertNull(parentResolution.getActualType(expression.eContainer as XExpression))
			assertNull(parentResolution.getActualType(expression.eContainer as XExpression))
			state.acceptActualType(expectedType)
			assertNull(parentResolution.getActualType(expression))
			assertEquals(expectedType.identifier, resolution.getActualType(expression).identifier)
			assertNull(parentResolution.getActualType(expression.eContainer as XExpression))
		} else {
			assertTrue(expression instanceof XBlockExpression)
			val nullLiteral = expression.eContents.head as XNullLiteral
			state.computeTypes(nullLiteral)
			val resolution = state.<ResolvedTypes>get("resolvedTypes")
			assertEquals(expectedType.identifier, resolution.getActualType(nullLiteral).identifier)
		}
	}
	
	override getRefinableCandidate(XExpression expression, LightweightTypeComputationState state) {
		throw new UnsupportedOperationException("Unexpected!")
	}
	
}
