/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem.newImpl

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

/**
 * @author Sebastian Zarnekow
 */
abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
	
	@Inject
	protected extension IXtendJvmAssociations
	
	def isAssignableFrom(Class<?> lhs, String rhs) {
		(lhs.canonicalName->null).isAssignableFrom(rhs, true)
	}
	
	def isAssignableFrom(Class<?> lhs, Class<?> rhs) {
		(lhs.canonicalName->null).isAssignableFrom(rhs.canonicalName, true)
	}
	
	def isAssignableFrom(String lhs, String rhs) {
		(lhs->null).isAssignableFrom(rhs, true)
	}
	
	def isAssignableFromAny(String lhs) {
		(lhs->null).isAssignableFrom(null, true)
	}
	
	def isAssignableFrom(String lhs, Class<?> rhs) {
		(lhs->null).isAssignableFrom(rhs.canonicalName, true)
	}
	
	def isNotAssignableFrom(Class<?> lhs, String rhs) {
		(lhs.canonicalName->null).isAssignableFrom(rhs, false)
	}
	
	def isNotAssignableFrom(String lhs, String rhs) {
		(lhs->null).isAssignableFrom(rhs, false)
	}
	
	def isNotAssignableFromAny(String lhs) {
		(lhs->null).isAssignableFrom(null, false)
	}
	
	def isAssignableFrom(Pair<String, String> lhsAndParams, String rhs) {
		lhsAndParams.isAssignableFrom(rhs, true)
	}
	
	def isNotAssignableFrom(Pair<String, String> lhsAndParams, String rhs) {
		lhsAndParams.isAssignableFrom(rhs, false)
	}
	
	def isAssignableFrom(Pair<String, String> lhsAndParams, String rhs, boolean expectation) {
		// TODO synthesize unique variable names as soon as the function should be validated
		val signature = '''def «IF !lhsAndParams.value.nullOrEmpty»<«lhsAndParams.value»> «ENDIF»void method(«
			lhsAndParams.key.fixup» lhs, «
			rhs.fixup» rhs) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val lhsType = if (lhsAndParams.key !== null) operation.parameters.head.parameterType.toLightweightTypeReference else owner.newAnyTypeReference
		val rhsType = if (rhs !== null) operation.parameters.last.parameterType.toLightweightTypeReference else owner.newAnyTypeReference
		assertEquals(lhsType.simpleName + " := " + rhsType.simpleName, expectation, lhsType.testIsAssignable(rhsType))
		if (expectation) {
			for(superType: lhsType.allSuperTypes) {
				if (superType.array == lhsType.array || lhsType.array == rhsType.array)
					assertEquals(superType.toString, expectation, superType.testIsAssignable(rhsType))		
			}
		}
	}
	
	def protected String fixup(String type) {
		type?.replace("$$Procedure", "org.eclipse.xtext.xbase.lib.Procedures.Procedure")
			?.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure")
			?.replace("$Function<", "com.google.common.base.Function<")
			?.replace("$Predicate<", "com.google.common.base.Predicate<")
			?.replace("$$Function", "org.eclipse.xtext.xbase.lib.Functions.Function")
			?.replace("$Function", "org.eclipse.xtext.xbase.lib.Functions$Function")
			?:'Object'
	}
	
	def boolean testIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) { 
		assertTrue(lhs.doIsAssignable(lhs))
		assertTrue(lhs.doIsAssignable(lhs.toTypeReference.toLightweightTypeReference))
		assertTrue(rhs.doIsAssignable(rhs.toTypeReference.toLightweightTypeReference))
		val boolean result = lhs.doIsAssignable(rhs)
		if (!rhs.primitiveVoid) {
			val wcRhs = owner.newWildcardTypeReference
			wcRhs.addUpperBound(rhs.wrapperTypeIfPrimitive)
			assertEquals(result, lhs.doIsAssignable(wcRhs))
			val compoundRhs = owner.newCompoundTypeReference(true)
			compoundRhs.addComponent(rhs)
			val object = rhs.owner.services.typeReferences.findDeclaredType(Object, rhs.owner.contextResourceSet)
			compoundRhs.addComponent(rhs.owner.newParameterizedTypeReference(object))
			assertEquals(lhs + ' := ' + compoundRhs.toString, result, lhs.doIsAssignable(compoundRhs))
		}
		return result
	}
	
	def boolean doIsAssignable(LightweightTypeReference lhs, LightweightTypeReference rhs) {
		return lhs.isAssignableFrom(rhs)
	}
}