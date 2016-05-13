/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Inject
import io.typefox.lsapi.CompletionOptionsImpl
import io.typefox.lsapi.InitializeParams
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.InitializeResultImpl
import io.typefox.lsapi.LanguageServer
import io.typefox.lsapi.ServerCapabilitiesImpl
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors class LanguageServerImpl implements LanguageServer {
    
    InitializeParams params
    
    @Inject WorkspaceServiceImpl workspaceService
    @Inject TextDocumentServiceImpl textDocumentService
    
    override InitializeResult initialize(InitializeParams params) {
        this.params = params
        workspaceService.initialize(params, [ textDocumentService.publishDiagnostics($0, $1) ])
        return new InitializeResultImpl => [
            capabilities = new ServerCapabilitiesImpl => [
                completionProvider = new CompletionOptionsImpl => [
                    resolveProvider = true
                    triggerCharacters = #["."]
                ]
            ]
        ]
    }
    
    override void shutdown() {
    }
    
    override textDocumentService() {
        textDocumentService
    }
    
    override workspaceService() {
        workspaceService
    }
    
}