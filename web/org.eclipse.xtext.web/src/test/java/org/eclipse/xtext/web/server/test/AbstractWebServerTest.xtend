/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import com.google.inject.Guice
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
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup
import org.eclipse.xtext.web.server.ISession
import org.eclipse.xtext.web.server.XtextServiceDispatcher
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.test.languages.StatemachineWebModule

@Accessors(PROTECTED_GETTER)
class AbstractWebServerTest extends AbstractXtextTests {
	
	static class TestResourceBaseProvider implements IResourceBaseProvider {
		val testFiles = new HashMap<String, URI>
		
		override getFileURI(String resourceId) {
			testFiles.get(resourceId)
		}
	}
	
	val List<ExecutorService> executorServices = newArrayList
	
	TestResourceBaseProvider resourceBaseProvider
	
	XtextServiceDispatcher dispatcher
	
	protected def Module getRuntimeModule() {
		new StatemachineRuntimeModule
	}
	
	override void setUp() {
		super.setUp()
		resourceBaseProvider = new TestResourceBaseProvider
		with(new StatemachineStandaloneSetup {
			override createInjector() {
				val webModule = new StatemachineWebModule[Executors.newCachedThreadPool => [executorServices += it]]
				webModule.resourceBaseProvider = resourceBaseProvider
				return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
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
		val requestData = new MockServiceContext(parameters, session)
		dispatcher.getService(requestData)
	}
	
}
