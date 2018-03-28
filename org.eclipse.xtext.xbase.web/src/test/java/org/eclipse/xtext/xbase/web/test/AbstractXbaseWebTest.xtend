/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.web.test

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import java.io.File
import java.io.FileWriter
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.util.DisposableRegistry
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup
import org.eclipse.xtext.web.example.entities.ide.EntitiesIdeModule
import org.eclipse.xtext.web.example.entities.tests.EntitiesInjectorProvider
import org.eclipse.xtext.web.server.ISession
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.xbase.web.test.languages.EntitiesWebModule
import org.junit.After
import org.junit.Before
import org.junit.Assert

abstract class AbstractXbaseWebTest {
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	protected def normalizeLineSeparator(String value) {
		value.replace("\r\n","\n")
	}
	
	def void assertEquals(CharSequence expected, CharSequence actual) {
		Assert.assertEquals(expected.toString.normalizeLineSeparator, actual.toString.toString.normalizeLineSeparator)
	}
	
	val injectorProvider = new EntitiesInjectorProvider {
		override protected internalCreateInjector() {
			new EntitiesStandaloneSetup {
				override createInjector() {
					val webModule = new EntitiesWebModule
					val ideModule = new EntitiesIdeModule
					webModule.resourceBaseProvider = resourceBaseProvider
					return Guice.createInjector(Modules2.mixin(runtimeModule, ideModule, webModule))
				}
			}.createInjectorAndDoEMFRegistration()
		}
	}
	
	TestResourceBaseProvider resourceBaseProvider
	
	@Inject DisposableRegistry disposableRegistry
	
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
		disposableRegistry.dispose()
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
