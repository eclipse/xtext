/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import java.io.File
import java.io.FileWriter
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.formatting.ILineSeparatorInformation
import org.eclipse.xtext.util.DisposableRegistry
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule
import org.eclipse.xtext.web.example.statemachine.tests.StatemachineInjectorProvider
import org.eclipse.xtext.web.server.ISession
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.test.languages.StatemachineWebModule
import org.junit.After
import org.junit.Assert
import org.junit.Before

abstract class AbstractWebServerTest {
	
	static class TestLineSeparatorInformation implements ILineSeparatorInformation {
		
		override getLineSeparator() {
			"\n"
		}
		
	}
	
	protected def normalizeLineSeparator(String value) {
		value.replace("\r\n","\n")
	}

	def void assertEquals(CharSequence expected, CharSequence actual) {
		Assert.assertEquals(expected.toString.normalizeLineSeparator, actual.toString.toString.normalizeLineSeparator)
	}
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	val injectorProvider = new StatemachineInjectorProvider {
		override protected internalCreateInjector() {
			new StatemachineStandaloneSetup {
				override createInjector() {
					val webModule = getWebModule()
					webModule.resourceBaseProvider = resourceBaseProvider
					return Guice.createInjector(Modules2.mixin(runtimeModule, ideModule, webModule))
				}
			}.createInjectorAndDoEMFRegistration()
		}
	}
	
	TestResourceBaseProvider resourceBaseProvider
	
	@Inject DisposableRegistry disposableRegistry
	
	@Inject XtextServiceDispatcher dispatcher
	
	protected def Module getIdeModule() {
		new StatemachineIdeModule
	}
	
	protected def StatemachineWebModule getWebModule() {
		new StatemachineWebModule
	}
	
	protected def Module getRuntimeModule() {
		new StatemachineRuntimeModule() {
			def Class<? extends ILineSeparatorInformation> bindILineSeparatorInformation() {
				TestLineSeparatorInformation
			}
		}
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
		val file = File.createTempFile('test', '.statemachine')
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
