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
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.typesystem.AssignabilityTest
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference
import org.eclipse.emf.ecore.util.EcoreUtil

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
		xtendFile.asCompilationUnit [ extension unit |
			val lhsType = if (lhsAndParams.key != null)
					operation.parameters.head.parameterType.newTypeReference(unit).toLightweightTypeReference
				else
					new AnyTypeReference(this)
			val rhsType = if (rhs != null)
					operation.parameters.last.parameterType.newTypeReference(unit).toLightweightTypeReference
				else
					new AnyTypeReference(this)
			assertEquals(lhsType.simpleName + " := " + rhsType.simpleName, expectation,
				lhsType.testIsAssignable(rhsType))
			if (expectation) {
				for (superType : lhsType.allSuperTypes) {
					if (superType.array == lhsType.array || lhsType.array == rhsType.array)
						assertEquals(superType.toString, expectation, superType.testIsAssignable(rhsType))
				}
			}
		]
	}

	override testIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		assertTrue(lhs.doIsAssignable(lhs))
		assertTrue(lhs.doIsAssignable(lhs.toTypeReference.toLightweightReference))
		assertTrue(rhs.doIsAssignable(rhs.toTypeReference.toLightweightReference))
		val boolean result = lhs.doIsAssignable(rhs)
		if (!rhs.primitiveVoid) {
			val wcRhs = new WildcardTypeReference(rhs.owner)
			wcRhs.addUpperBound(rhs.wrapperTypeIfPrimitive)
			assertEquals(result, lhs.doIsAssignable(wcRhs))
			val compoundRhs = new CompoundTypeReference(rhs.owner, true)
			compoundRhs.addComponent(rhs)
			val object = rhs.owner.services.typeReferences.findDeclaredType(Object, rhs.owner.contextResourceSet)
			compoundRhs.addComponent(new ParameterizedTypeReference(rhs.owner, object))
			assertEquals(lhs + ' := ' + compoundRhs.toString, result, lhs.doIsAssignable(compoundRhs))
		}
		return result
	}

	def asCompilationUnit(XtendFile file, (CompilationUnitImpl)=>void block) {
		val compilationUnit = compilationUnitProvider.get
		compilationUnit.xtendFile = file
		block.apply(compilationUnit)
	}

	def newTypeReference(JvmTypeReference reference, extension CompilationUnitImpl unit) {
		reference.toTypeReference.toLightweightTypeReference.newTypeReference(unit)
	}

	def TypeReference newTypeReference(LightweightTypeReference reference, extension CompilationUnitImpl unit) {
		extension val typeReferenceProvider = unit.typeReferenceProvider
		val typeArguments = reference.typeArguments.map[newTypeReference(unit)]
		val invariantBoundSubstitute = reference.invariantBoundSubstitute
		var depth = 0
		var LightweightTypeReference componentType = invariantBoundSubstitute
		while (componentType.array) {
			componentType = componentType.componentType
			depth = depth + 1
		}
		var typeReference = componentType.type.toType.newTypeReference(typeArguments)
		if (reference.wildcard) {
			if (reference.lowerBoundSubstitute == invariantBoundSubstitute) {
				typeReference = typeReference.newWildcardTypeReferenceWithLowerBound
			} else {
				typeReference = typeReference.newWildcardTypeReference
			}
		}
		var i = 0
		while (i < depth) {
			i = i + 1
			typeReference = typeReference.newArrayTypeReference
		}
		typeReference
	}

}