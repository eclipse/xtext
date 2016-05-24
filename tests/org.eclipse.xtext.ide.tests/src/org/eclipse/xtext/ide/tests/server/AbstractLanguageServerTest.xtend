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
import io.typefox.lsapi.NotificationCallback
import io.typefox.lsapi.PublishDiagnosticsParams
import java.io.File
import java.io.FileWriter
import java.util.List
import java.util.Map
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import org.eclipse.xtext.util.Files
import org.junit.Before

/**
 * @author efftinge - Initial contribution and API
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
    
    @Inject 
    protected LanguageServerImpl languageServer 
    protected Map<String, List<? extends Diagnostic>> diagnostics = newHashMap()
    
    protected File root
    
    def String ->(String path, CharSequence contents) {
        val file = new File(root, path)
        file.parentFile.mkdirs
        file.createNewFile
        new FileWriter(file) => [
          write(contents.toString)
          close  
        ]
        return file.absolutePath.substring(root.absolutePath.length)
    }
    
    override call(PublishDiagnosticsParams t) {
        diagnostics.put(t.uri, t.diagnostics)
    }
    
}