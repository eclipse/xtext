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
import io.typefox.lsapi.Diagnostic
import io.typefox.lsapi.InitializeParamsImpl
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.NotificationCallback
import io.typefox.lsapi.PublishDiagnosticsParams
import java.io.File
import java.io.FileWriter
import java.util.List
import java.util.Map
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.ide.server.UriExtensions
import org.eclipse.xtext.util.Files
import org.junit.Before

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AbstractLanguageServerTest implements NotificationCallback<PublishDiagnosticsParams> {
    
    @Before
    def void setup() {
        val injector = Guice.createInjector(new ServerModule())
        injector.injectMembers(this)
        // register notification callbacks
        languageServer.getTextDocumentService.onPublishDiagnostics(this)
        
        // create workingdir
        root = new File("./test-data/test-project")
        if (!root.mkdirs) {
            Files.cleanFolder(root, null, true, false)
        }
        root.deleteOnExit
    }
    
    @Inject extension UriExtensions
    @Inject protected LanguageServerImpl languageServer 
    protected Map<String, List<? extends Diagnostic>> diagnostics = newHashMap()
    
    protected File root
	
	protected def InitializeResult initialize() {
		return initialize(null)
	}
	
	protected def InitializeResult initialize((InitializeParamsImpl)=>void initializer) {
		val params = new InitializeParamsImpl
		params.rootPath = root.toPath.toAbsolutePath.normalize.toString
		initializer?.apply(params)
		return languageServer.initialize(params)
	}
    
    def String ->(String path, CharSequence contents) {
        val file = new File(root, path)
        file.parentFile.mkdirs
        file.createNewFile
        
        val writer = new FileWriter(file)
      	writer.write(contents.toString)
      	writer.close

		return file.toURI.normalize.toPath
    }
    
    override call(PublishDiagnosticsParams t) {
        diagnostics.put(t.uri, t.diagnostics)
    }
    
}