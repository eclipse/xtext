/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.Guice
import com.google.inject.Inject
import io.typefox.lsapi.InitializeParamsImpl
import io.typefox.lsapi.NotificationCallback
import io.typefox.lsapi.PublishDiagnosticsParams
import java.io.File
import java.io.FileWriter
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageStandaloneSetup
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ServerTest implements NotificationCallback<PublishDiagnosticsParams> {
    
    @Before
    def void setup() {
    	val injector = Guice.createInjector(new ServerModule())
    	injector.injectMembers(this)
    }
    
    @Inject def voidRegisterTestLanguage(IResourceServiceProvider.Registry registry) {
        val injector = new TestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration
        registry.extensionToFactoryMap.put(injector.getInstance(FileExtensionProvider).primaryFileExtension, injector.getInstance(IResourceServiceProvider))   
    }
    
    @Inject LanguageServerImpl languageServer 
    
    @Test
    def void testInitializeBuild() {
        'MyType1.testlang' -> '''
            type Test {
                string foo
            }
        '''
    	languageServer.getTextDocumentService.onPublishDiagnostics(this)
    	languageServer.initialize(new InitializeParamsImpl => [
    	    rootPath = root.absolutePath
    	])
    	assertTrue(diagnosticNotifications.join(','), diagnosticNotifications.isEmpty)
    }
    
    @Test
    def void testInitializeBuildWithError() {
        'MyType1.testlang' -> '''
            type Test {
                NonExisting foo
            }
        '''
    	languageServer.getTextDocumentService.onPublishDiagnostics(this)
    	languageServer.initialize(new InitializeParamsImpl => [
    	    rootPath = root.absolutePath
    	])
    	assertEquals("Couldn't resolve reference to Type 'NonExisting'.", diagnosticNotifications.head.diagnostics.head.message)
    }
    
    
    // utilities
    val File root = new File("./test-data/test-project") => [
        mkdirs
        deleteOnExit
    ]
    
    def void ->(String path, CharSequence contents) {
        val file = new File(root, path)
        file.parentFile.mkdirs
        file.createNewFile
        new FileWriter(file) => [
          write(contents.toString)
          close  
        ]
    }
    
    List<PublishDiagnosticsParams> diagnosticNotifications = newArrayList()
    
    override onNotification(PublishDiagnosticsParams t) {
        diagnosticNotifications += t
    }
    
}