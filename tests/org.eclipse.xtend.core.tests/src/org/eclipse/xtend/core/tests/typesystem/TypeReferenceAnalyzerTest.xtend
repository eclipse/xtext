/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.typesystem.util.TypeReferenceAnalyzer
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sebastian Zarnekow
 */
class TypeReferenceAnalyzerTest extends AbstractXtendTestCase {
	
	@Inject
	extension TypeReferenceAnalyzer analyzer
	
	@Inject
	extension IXtendJvmAssociations
	
	@Inject
	TypesFactory typesFactory
	
	def refersTypeParameter(String typeReference, boolean expectation) {
		val signature = '''def <T> void method(«typeReference» p) {}'''
		val function = function(signature.toString)
		val operation = function.directlyInferredOperation
		val reference = operation.parameters.head.parameterType
		val typeParam = operation.typeParameters.head
		assertEquals(expectation, typeParam.isReferencedBy(reference))
		val delegate = typesFactory.createJvmDelegateTypeReference
		delegate.delegate = reference
		assertEquals(expectation, typeParam.isReferencedBy(delegate))
		val multiType = typesFactory.createJvmMultiTypeReference
		multiType.references += reference
		assertEquals(expectation, typeParam.isReferencedBy(multiType))
		val synonym = typesFactory.createJvmSynonymTypeReference
		synonym.references += reference
		assertEquals(expectation, typeParam.isReferencedBy(synonym))
	}
	
	@Test
	def void testDirectReference() {
		'T'.refersTypeParameter(true)
	}
	
	@Test
	def void testNoReference() {
		'String'.refersTypeParameter(false)
	}
	
	@Test
	def void testReferencedInTypeArgument() {
		'java.util.List<T>'.refersTypeParameter(true)
	}
	
	@Test
	def void testReferencedInNestedTypeArgument() {
		'java.util.List<Iterable<T>>'.refersTypeParameter(true)
	}
	
	@Test
	def void testReferencedInTypeArgumentOfProxy() {
		'DoesNotExist<T>'.refersTypeParameter(true)
	}
	
	@Test
	def void testReferencedInWildcardExtends() {
		'java.util.List<? extends T>'.refersTypeParameter(true)
	}
	
	@Test
	def void testReferencedInWildcardSuper() {
		'java.util.List<? super T>'.refersTypeParameter(true)
	}
	
	@Test
	def void testReferencedInFunctionType_01() {
		'()=>T'.refersTypeParameter(true)
	}
	
	@Test
	def void testReferencedInFunctionType_02() {
		'(java.util.List<T>)=>String'.refersTypeParameter(true)
	}
}