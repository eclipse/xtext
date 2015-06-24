/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import com.google.inject.Guice
import com.google.inject.util.Modules
import java.io.File
import java.io.FileWriter
import java.util.HashMap
import java.util.Map
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.test.languages.StatemachineWebModule
import org.eclipse.xtext.web.server.ISessionStore

@Accessors(PROTECTED_GETTER)
class AbstractWebServerTest extends AbstractXtextTests {
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	ExecutorService executorService
	
	TestResourceBaseProvider resourceBaseProvider
	
	XtextServiceDispatcher dispatcher
	
	protected def getRuntimeModule() {
		new StatemachineRuntimeModule
	}
	
	override void setUp() {
		super.setUp()
		executorService = Executors.newCachedThreadPool
		resourceBaseProvider = new TestResourceBaseProvider
		with(new StatemachineStandaloneSetup {
			override createInjector() {
				val webModule = new StatemachineWebModule(executorService)
				webModule.resourceBaseProvider = resourceBaseProvider
				return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
			}
		})
		dispatcher = injector.getInstance(XtextServiceDispatcher)
	}
	
	override tearDown() {
		executorService.shutdown()
		super.tearDown()
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
		getService(parameters, new HashMapSessionStore)
	}
	
	protected def getService(Map<String, String> parameters, ISessionStore sessionStore) {
		val requestData = new MockRequestData(parameters)
		dispatcher.getService(requestData, sessionStore)
	}
	
}
