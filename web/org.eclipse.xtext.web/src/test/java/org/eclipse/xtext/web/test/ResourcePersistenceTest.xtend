/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.test

import com.google.inject.Guice
import java.io.File
import java.io.FileWriter
import java.util.HashMap
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.persistence.ResourceContentResult
import org.junit.Test

class ResourcePersistenceTest extends AbstractXtextTests {
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	ExecutorService executorService
	
	TestResourceBaseProvider resourceBaseProvider
	
	XtextServiceDispatcher dispatcher
	
	override void setUp() {
		super.setUp()
		executorService = Executors.newCachedThreadPool
		resourceBaseProvider = new TestResourceBaseProvider
		with(new EntitiesStandaloneSetup {
			override createInjector() {
				val runtimeModule = new EntitiesRuntimeModule
				val ideModule = new EntitiesIdeModule(executorService, resourceBaseProvider)
				return Guice.createInjector(runtimeModule, ideModule)
			}
		})
		dispatcher = injector.getInstance(XtextServiceDispatcher)
	}
	
	override tearDown() {
		executorService.shutdown()
		super.tearDown()
	}
	
	protected def createFile(String content) {
		val file = File.createTempFile('test', '.entities')
		resourceBaseProvider.testFiles.put(file.name, URI.createFileURI(file.absolutePath))
		val writer = new FileWriter(file)
		writer.write(content)
		writer.close()
		file.deleteOnExit
		return file
	}
	
	@Test def testLoadFile() {
		val resourceContent = 'entity foo {}'
		val file = createFile(resourceContent)
		
		val sessionStore = new HashMapSessionStore
		val parameters = #{'resource' -> file.name}
		val service = dispatcher.getService('/load', parameters, sessionStore)
		assertFalse(service.hasSideEffects)
		assertFalse(service.hasTextInput)
		
		val result = service.service.apply() as ResourceContentResult
		assertEquals(resourceContent, result.fullText)
		assertFalse(result.dirty)
	}
	
}