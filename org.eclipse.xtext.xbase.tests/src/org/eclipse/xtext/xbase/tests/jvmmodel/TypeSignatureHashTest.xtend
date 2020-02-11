/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 package org.eclipse.xtext.xbase.tests.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.descriptions.JvmDeclaredTypeSignatureHashProvider
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

import static extension org.eclipse.xtext.util.Strings.*

/**
 * The remaining tests are in xtend.core.tests, as it is a lot easier to specify JvmModels in Xtend ;-)
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
class TypeSignatureHashTest extends AbstractXbaseTestCase {
	
	@Inject extension JvmDeclaredTypeSignatureHashProvider
	
	@Inject extension JvmTypesBuilder
	
	@Inject extension TypeReferences;
	
	@Test
	def testSubType() {
		val eObject = EcoreFactory::eINSTANCE.createEObject
		val bar = eObject.toClass('Bar')
		val foo = eObject.toClass('Foo') [
			members += bar
		]
		val hash = foo.hash
		bar.members += eObject.toConstructor() []
		assertEquals(hash, foo.hash)
		bar.simpleName = 'Baz'
		assertFalse("Expected different hashes", hash.equal(foo.hash))
	}
	
	@Test
	def void testUnsealedType() {
		val eObject = EcoreFactory::eINSTANCE.createEObject
		val bar = eObject.toClass('Bar')
		assertFalse('Bar'.equal(bar.hash))
	}
	
	@Test
	def void testRecursiveInheritance() {
		val eObject = EcoreFactory::eINSTANCE.createEObject
		val bar = eObject.toClass('Bar')
		val foo = eObject.toClass('Foo')
		bar.superTypes += createTypeRef(foo);
		foo.superTypes += createTypeRef(bar);
		assertNotNull(foo.hash)
		assertFalse(foo.hash.equal(bar.hash))
	}

	@Test
	def void testSealedType() {
		val e = expression("null")
		assertEquals('java.lang.String', (findDeclaredType(typeof(String), e) as JvmDeclaredType).hash)
	}
}