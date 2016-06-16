/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.test

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import com.google.inject.util.Modules
import java.io.File
import java.io.FileWriter
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.web.example.entities.tests.EntitiesInjectorProvider
import org.eclipse.xtext.web.server.ISession
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.xbase.web.test.languages.EntitiesWebModule
import org.junit.After
import org.junit.Before

abstract class AbstractXbaseWebTest {
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	val injectorProvider = new EntitiesInjectorProvider {
		override protected internalCreateInjector() {
			new EntitiesStandaloneSetup {
				override createInjector() {
					val webModule = new EntitiesWebModule[Executors.newCachedThreadPool => [executorServices += it]]
					webModule.resourceBaseProvider = resourceBaseProvider
					return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
				}
			}.createInjectorAndDoEMFRegistration()
		}
	}
	
	val List<ExecutorService> executorServices = newArrayList
	
	TestResourceBaseProvider resourceBaseProvider
	
	@Inject XtextServiceDispatcher dispatcher
	
	protected def Module getRuntimeModule() {
		new EntitiesRuntimeModule
	}
	
	@Before
	def void setup() {
		resourceBaseProvider = new TestResourceBaseProvider
		val injector = injectorProvider.injector
		injector.injectMembers(this)
		injectorProvider.setupRegistry()
	}
	
	@After
	def void teardown() {
		executorServices.forEach[shutdown()]
		executorServices.clear()
		resourceBaseProvider.testFiles.clear()
		injectorProvider.restoreRegistry()
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
