/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.typesystem.AssignabilityTest
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.declaration.TypeReference

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class TypeReferenceAssignabilityTest extends AssignabilityTest {

	@Inject Provider<CompilationUnitImpl> compilationUnitProvider

	override isAssignableFrom(Pair<String, String> lhsAndParams, String rhs, boolean expectation) {
		val signature = '''def «IF !lhsAndParams.value.nullOrEmpty»<«lhsAndParams.value»> «ENDIF»void method(«lhsAndParams.
			key.fixup» lhs, «rhs.fixup» rhs) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val xtendFile = EcoreUtil.getRootContainer(function) as XtendFile
		xtendFile.asCompilationUnit [ it |
			val lhsType = if (lhsAndParams.key != null)
					toTypeReference(operation.parameters.head.parameterType)
				else
					toTypeReference(owner.newAnyTypeReference)
			val rhsType = if (rhs != null)
					toTypeReference(operation.parameters.last.parameterType)
				else
					toTypeReference(owner.newAnyTypeReference)
			assertEquals(lhsType.simpleName + " := " + rhsType.simpleName, expectation,
				testIsAssignable(lhsType, rhsType))
			if (expectation) {
				for (superType : lhsType.declaredSuperTypes) {
					if (superType.array == lhsType.array || lhsType.array == rhsType.array)
						assertEquals(superType.toString, expectation, testIsAssignable(superType, rhsType))
				}
			}
		]
	}
	
	def boolean testIsAssignable(CompilationUnitImpl unit, TypeReference lhs, TypeReference rhs) { 
		assertTrue(lhs.doIsAssignable(lhs))
		assertTrue(rhs.doIsAssignable(rhs))
		val boolean result = lhs.doIsAssignable(rhs)
		
		// TODO cannot use this variation since newWildcardTypeReference is lossy with the rhs
		// e.g. it is not exactly the RHS that is passed to the method 
//		if (!rhs.isVoid) {
//			val wcRhs = unit.typeReferenceProvider.newWildcardTypeReference(rhs.wrapperIfPrimitive)
//			assertEquals(result, lhs.doIsAssignable(wcRhs))
//		}
		return result
	}
	
	def boolean doIsAssignable(TypeReference lhs, TypeReference rhs) {
		return lhs.isAssignableFrom(rhs)
	}

	def asCompilationUnit(XtendFile file, (CompilationUnitImpl)=>void block) {
		val compilationUnit = compilationUnitProvider.get
		compilationUnit.xtendFile = file
		block.apply(compilationUnit)
	}
	
}