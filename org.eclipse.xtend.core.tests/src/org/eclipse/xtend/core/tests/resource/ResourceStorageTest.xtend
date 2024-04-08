/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.OutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtend.core.tests.util.InMemoryURIConverter
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xbase.resource.BatchLinkableResource
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable
import org.junit.Test
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ResourceStorageTest extends AbstractXtendTestCase {
	
	@Inject IResourceStorageFacade resourceStorageFacade
	
	@Test def void testWriteAndLoad() {
		val contents = '''
			package foo
			
			class Bar {
				def dispatch myMethod(String s) {}
				/**
				 * Hello myMethod
				 */
				def dispatch myMethod(CharSequence cs) {}
			}
			class Foo {
				def dispatch other(String it) {
					var x = ""
					x = length.toString
					println(x)
				}
			}
		'''
		val file = file(contents)
		val originalResource = file.eResource as StorageAwareResource
		
		val originalAdapter = EcoreUtil.getExistingAdapter(originalResource, JvmModelAssociator.Adapter) as JvmModelAssociator.Adapter
		
		val bout = new ByteArrayOutputStream;
		(resourceStorageFacade as ResourceStorageFacade).storeNodeModel = true
		resourceStorageFacade.createResourceStorageWritable(bout).writeResource(originalResource)
		
		val in = resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray))
		
		val resource = file.eResource.resourceSet.createResource(URI.createURI("synthetic:/test/MyClass.xtend")) as StorageAwareResource
		// set a synthetic converter so we can obtain the text by the URI
		val converter = new InMemoryURIConverter()
		converter.addModel(resource.URI.toString, contents)
		resource.resourceSet.URIConverter = converter
		
		file.eResource.resourceSet.resources += resource;
		resource.loadFromStorage(in)
		
		// check contents
		val jvmClass = resource.contents.get(1) as JvmGenericType
		assertEquals('java.lang.CharSequence', jvmClass.declaredOperations.get(2).parameters.head.parameterType.qualifiedName)
		assertEquals('java.lang.Object', jvmClass.declaredOperations.get(2).returnType.qualifiedName)
		assertEquals('Hello myMethod', jvmClass.declaredOperations.get(1).eAdapters.filter(DocumentationAdapter).head.documentation)
		
		// check resource description
		assertEquals(resource.URI, resource.resourceDescription.URI)
		assertEquals(2, resource.resourceDescription.exportedObjects.size)
		assertEquals("foo.Bar", resource.resourceDescription.exportedObjects.head.qualifiedName.toString)
		
		// check node model
		val restoredNodes = NodeModelUtils.findActualNodeFor(resource.contents.head).asTreeIterable.iterator
		val originalNodes = NodeModelUtils.findActualNodeFor(file).asTreeIterable.iterator
		while (restoredNodes.hasNext) {
			val rest = restoredNodes.next
			val orig = originalNodes.next
			assertEquals(orig.startLine, rest.startLine)
			assertEquals(orig.endLine, rest.endLine)
			assertEquals(orig.offset, rest.offset)
			assertEquals(orig.endOffset, rest.endOffset)
			assertEquals(orig.length, rest.length)
			
			assertEquals(orig.totalStartLine, rest.totalStartLine)
			assertEquals(orig.totalEndLine, rest.totalEndLine)
			assertEquals(orig.totalOffset, rest.totalOffset)
			assertEquals(orig.totalEndOffset, rest.totalEndOffset)
			assertEquals(orig.totalLength, rest.totalLength)
			
			assertSame(orig.grammarElement, rest.grammarElement)
			assertEquals(file.eResource.getURIFragment(orig.semanticElement),resource.getURIFragment(rest.semanticElement))
			
			assertEquals(orig.text, rest.text)
		}
		
		assertFalse(originalNodes.hasNext)
		
		val restoredAdapter = EcoreUtil.getExistingAdapter(resource, JvmModelAssociator.Adapter) as JvmModelAssociator.Adapter
		assertEquals(originalAdapter.logicalContainerMap.size, restoredAdapter.logicalContainerMap.size);
		assertEquals(originalAdapter.sourceToTargetMap.size, restoredAdapter.sourceToTargetMap.size);
		assertEquals(originalAdapter.targetToSourceMap.size, restoredAdapter.targetToSourceMap.size);
	}
	
	@Test(expected=IOException) def void testFailedWrite() throws Exception {
		val file = file('class C{}')
		new BatchLinkableResourceStorageWritable(new ByteArrayOutputStream, false) {
			override protected writeAssociationsAdapter(BatchLinkableResource resource, OutputStream zipOut) throws IOException {
				val removeMe = resource.eAdapters.findFirst[it instanceof JvmModelAssociator.Adapter]
				assertTrue(resource.eAdapters.remove(removeMe))
				super.writeAssociationsAdapter(resource, zipOut)
			}
		}.writeResource(file.eResource as StorageAwareResource)	
	}
	
	@Test def void testConstantValueIsPersisted() {
		val contents = '''
			class C {
				static val CONSTANT = 'a' + 'b' + 0
			}
		'''
		val file = file(contents)
		
		val bout = new ByteArrayOutputStream;
		(resourceStorageFacade as ResourceStorageFacade).storeNodeModel = true
		resourceStorageFacade.createResourceStorageWritable(bout).writeResource(file.eResource as StorageAwareResource)
		
		val in = resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray))
		
		val resource = file.eResource.resourceSet.createResource(URI.createURI("synthetic:/test/MyClass.xtend")) as StorageAwareResource
		// set a synthetic converter so we can obtain the text by the URI
		val converter = new InMemoryURIConverter()
		converter.addModel(resource.URI.toString, contents)
		resource.resourceSet.URIConverter = converter
		
		file.eResource.resourceSet.resources += resource;
		resource.loadFromStorage(in)
		
		// check constant value was written
		val jvmClass = resource.contents.get(1) as JvmGenericType
		val field = jvmClass.members.lastOrNull as JvmField
		assertTrue(field.constant)
		assertTrue(field.isSetConstant)
		assertEquals('ab0', field.constantValue)
	}
	
	@Test def void testConstantValueIsPersisted_01() {
		val contents = '''
			class C {
				static val CONSTANT = Object
			}
		'''
		val file = file(contents)
		
		val bout = new ByteArrayOutputStream;
		(resourceStorageFacade as ResourceStorageFacade).storeNodeModel = true
		resourceStorageFacade.createResourceStorageWritable(bout).writeResource(file.eResource as StorageAwareResource)
		
		val in = resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray))
		
		val resource = file.eResource.resourceSet.createResource(URI.createURI("synthetic:/test/MyClass.xtend")) as StorageAwareResource
		// set a synthetic converter so we can obtain the text by the URI
		val converter = new InMemoryURIConverter()
		converter.addModel(resource.URI.toString, contents)
		resource.resourceSet.URIConverter = converter
		
		file.eResource.resourceSet.resources += resource;
		resource.loadFromStorage(in)
		
		// check constant value was written
		val jvmClass = resource.contents.get(1) as JvmGenericType
		val field = jvmClass.members.lastOrNull as JvmField
		assertFalse(field.constant)
		assertTrue(field.isSetConstant)
		assertNull(field.constantValue)
	}
}