/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.naming.QualifiedName
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class SerializableResourceDescriptionTest {
	
	@Test def void testSerialization() {
		val uri = URI::createURI("file:/foo/bar.baz.foo")
		val before = new SerializableResourceDescription => [
			URI = uri 
			references = #[
				new SerializableReferenceDescription => [
					sourceEObjectUri = uri.appendFragment('foo')
					targetEObjectUri = uri.appendFragment('hubble')
					containerEObjectURI = uri.appendFragment('baz')
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 1
				],
				new SerializableReferenceDescription => [
					sourceEObjectUri = uri.appendFragment('foo2')
					targetEObjectUri = uri.appendFragment('hubble2')
					containerEObjectURI = uri.appendFragment('baz2')
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 2
				]
			]
			descriptions = #[
				new SerializableEObjectDescription => [
					EObjectURI = uri.appendFragment('baz')
					qualifiedName = QualifiedName.create('foo','baz')
					EClass = EcorePackage.eINSTANCE.EAttribute
					userData = newHashMap('myKey' -> 'myValue')
				]
			]
			importedNames = #[QualifiedName.create('foo'), QualifiedName.create('foo','bar')]
		]
		
		val bout = new ByteArrayOutputStream()
		val objectOut = new ObjectOutputStream(bout)
		objectOut.writeObject(before)
		val in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray)) 
		val after = in.readObject as SerializableResourceDescription
		
		assertDescriptionsEqual(before, after)
	}
	
	def void assertDescriptionsEqual(SerializableResourceDescription before, SerializableResourceDescription after) {
		assertEquals(before.URI, after.URI)
		assertEquals(before.importedNames, after.importedNames)

		assertEquals(before.references.size, after.references.size)
		for (int i : 0..<before.references.size) {
			val beforeRef = before.references.get(i)
			val afterRef  = after.references.get(i)
			assertEquals(beforeRef.containerEObjectURI, afterRef.containerEObjectURI)
			assertEquals(beforeRef.sourceEObjectUri, afterRef.sourceEObjectUri)
			assertEquals(beforeRef.targetEObjectUri, afterRef.targetEObjectUri)
			assertEquals(beforeRef.EReference, afterRef.EReference)
			assertEquals(beforeRef.indexInList, afterRef.indexInList)
		}
		assertEquals(before.descriptions.size, after.descriptions.size)
		for (int i : 0..<before.descriptions.size) {
			val beforeDesc = before.descriptions.get(i)
			val afterDesc  = after.descriptions.get(i)
			assertEquals(beforeDesc.EClass, afterDesc.EClass)
			assertEquals(beforeDesc.name, afterDesc.name)
			assertEquals(beforeDesc.qualifiedName, afterDesc.qualifiedName)
			assertEquals(beforeDesc.userData, afterDesc.userData)
			assertEquals(beforeDesc.EObjectURI, afterDesc.EObjectURI)
		}
	}
	
	@Test def void testNullSafeSerialization() {
		val uri = URI::createURI("file:/foo/bar.baz.foo")
		val before = new SerializableResourceDescription => [
			URI = uri 
			references = #[
				new SerializableReferenceDescription => [
					sourceEObjectUri = uri.appendFragment('foo')
					targetEObjectUri = null
					containerEObjectURI = uri.appendFragment('baz')
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 1
				],
				new SerializableReferenceDescription => [
					sourceEObjectUri = null
					targetEObjectUri = uri.appendFragment('hubble2')
					containerEObjectURI = uri.appendFragment('baz2')
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 2
				],
				new SerializableReferenceDescription => [
					sourceEObjectUri = uri.appendFragment('foo')
					targetEObjectUri = uri.appendFragment('hubble2')
					containerEObjectURI = null
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 2
				],
				new SerializableReferenceDescription => [
					sourceEObjectUri = uri.appendFragment('foo')
					targetEObjectUri = null
					containerEObjectURI = null
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 2
				],
				new SerializableReferenceDescription => [
					sourceEObjectUri = null
					targetEObjectUri = null
					containerEObjectURI = null
					EReference = EcorePackage.eINSTANCE.EAnnotation_Contents
					indexInList = 2
				]
			]
			descriptions = #[
				new SerializableEObjectDescription => [
					EObjectURI = uri.appendFragment('baz')
					qualifiedName = QualifiedName.create('foo','baz')
					EClass = EcorePackage.eINSTANCE.EAttribute
					userData = newHashMap('myKey' -> 'myValue')
				]
			]
			importedNames = #[QualifiedName.create('foo'), QualifiedName.create('foo','bar')]
		]
		
		val bout = new ByteArrayOutputStream()
		val objectOut = new ObjectOutputStream(bout)
		objectOut.writeObject(before)
		val in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray)) 
		val after = in.readObject as SerializableResourceDescription
		assertDescriptionsEqual(before, after)
	}
}