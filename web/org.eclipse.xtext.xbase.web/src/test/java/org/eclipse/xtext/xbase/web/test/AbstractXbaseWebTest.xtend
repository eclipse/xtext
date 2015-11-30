/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.test

import com.google.inject.Guice
import java.io.File
import java.io.FileWriter
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.web.server.ISession
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.xbase.web.test.languages.EntitiesWebModule

@Accessors(PROTECTED_GETTER)
class AbstractXbaseWebTest extends AbstractXtextTests {
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	val List<ExecutorService> executorServices = newArrayList
	
	TestResourceBaseProvider resourceBaseProvider
	
	XtextServiceDispatcher dispatcher
	
	protected def getRuntimeModule() {
		new EntitiesRuntimeModule
	}
	
	override void setUp() {
		super.setUp()
		resourceBaseProvider = new TestResourceBaseProvider
		with(new EntitiesStandaloneSetup {
			override createInjector() {
				val webModule = new EntitiesWebModule[Executors.newCachedThreadPool => [executorServices += it]]
				webModule.resourceBaseProvider = resourceBaseProvider
				return Guice.createInjector(Modules2.mixin(runtimeModule, webModule))
			}
		})
		dispatcher = injector.getInstance(XtextServiceDispatcher)
	}
	
	override tearDown() {
		executorServices.forEach[shutdown()]
		executorServices.clear()
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
	
	protected def getService(Map<String, String> parameters) {
		getService(parameters, new HashMapSession)
	}
	
	protected def getService(Map<String, String> parameters, ISession session) {
		val serviceContext = new MockServiceContext(parameters, session)
		dispatcher.getService(serviceContext)
	}
	
}
