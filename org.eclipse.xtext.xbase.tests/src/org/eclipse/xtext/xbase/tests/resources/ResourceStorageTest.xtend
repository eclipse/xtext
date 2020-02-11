/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.resources

import com.google.inject.Guice
import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider.XbaseTestRuntimeModule
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider.XbaseTestStandaloneSetup
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test for {@link BatchLinkableResourceStorageFacade} Node Model Serialization
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XbaseWithResourceStorageFacadeInjectorProvider)
class ResourceStorageTest extends AbstractXbaseTestCase {
	
	static class XbaseWithResourceStorageFacadeInjectorProvider extends XbaseInjectorProvider {
		
		override protected internalCreateInjector() {
			return new XbaseTestWithResourceStorageFacadeStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
		
	}
	
	static class XbaseTestWithResourceStorageFacadeStandaloneSetup extends XbaseTestStandaloneSetup {
		
		override createInjector() {
			return Guice.createInjector(new XbaseTestWithResourceStorageFacadeRuntimeModule())
		}
		
	}
	
	static class XbaseTestWithResourceStorageFacadeRuntimeModule extends XbaseTestRuntimeModule {
		
		def Class<? extends IResourceStorageFacade> bindIResourceStorageFacade() {
			return BatchLinkableResourceStorageFacade
		}
		
	}
	
	static class InMemoryURIConverter extends ExtensibleURIConverterImpl {
		final Map<URI, InputStream> models = new HashMap<URI, InputStream>()
	
		def void addModel(String uri, String content) {
			models.put(URI.createURI(uri), new StringInputStream(content))
		}
	
		override boolean exists(URI uri, Map<?, ?> options) {
			var boolean result = models.containsKey(uri)
			if (!result) {
				for (URI knownUri : models.keySet()) {
					if(uri.toString().endsWith(knownUri.toString())) return true
				}
			}
			return result
		}
	
		override InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			return models.get(uri)
		}
	}
	
	@Inject IResourceStorageFacade resourceStorageFacade
	
	@Test def void testWriteAndLoad() {
		val contents = '''
		{
			var x = "Hello"
			var y = ""
			val it = x
			y = length.toString
			println(x)
			y = length.toString
			println(x)
			y = length.toString
			println(x)
		}
		'''
		val file = expression(contents)
		
		val bout = new ByteArrayOutputStream;
		(resourceStorageFacade as ResourceStorageFacade).storeNodeModel = true
		resourceStorageFacade.createResourceStorageWritable(bout).writeResource(file.eResource as StorageAwareResource)
		
		val in = resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray))
		
		val resource = file.eResource.resourceSet.createResource(URI.createURI("synthetic:/Test.___xbase")) as StorageAwareResource
		// set a synthetic converter so we can obtain the text by the URI
		val converter = new ResourceStorageTest.InMemoryURIConverter()
		converter.addModel(resource.URI.toString, contents)
		resource.resourceSet.URIConverter = converter
		
		file.eResource.resourceSet.resources += resource;
		resource.loadFromStorage(in)
		
		// check contents
		val root = resource.contents.get(0) as XExpression
		assertTrue(root instanceof XBlockExpression)
		
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
			
			assertTrue(orig.semanticElement !== null && rest.semanticElement !== null || orig.semanticElement === null && rest.semanticElement === null)
			if (orig.semanticElement !== null) {
				assertEquals(file.eResource.getURIFragment(orig.semanticElement),resource.getURIFragment(rest.semanticElement))
			}
			
			assertEquals(orig.text, rest.text)
		}
		
		assertFalse(originalNodes.hasNext)
	}
	
}