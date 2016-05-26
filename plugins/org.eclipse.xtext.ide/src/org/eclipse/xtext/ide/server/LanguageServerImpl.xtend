/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Inject
import com.google.inject.Provider
import io.typefox.lsapi.CodeActionParams
import io.typefox.lsapi.CodeLens
import io.typefox.lsapi.CodeLensParams
import io.typefox.lsapi.CompletionItem
import io.typefox.lsapi.CompletionItemImpl
import io.typefox.lsapi.CompletionOptionsImpl
import io.typefox.lsapi.Diagnostic
import io.typefox.lsapi.DiagnosticImpl
import io.typefox.lsapi.DidChangeConfigurationParams
import io.typefox.lsapi.DidChangeTextDocumentParams
import io.typefox.lsapi.DidChangeWatchedFilesParams
import io.typefox.lsapi.DidCloseTextDocumentParams
import io.typefox.lsapi.DidOpenTextDocumentParams
import io.typefox.lsapi.DidSaveTextDocumentParams
import io.typefox.lsapi.DocumentFormattingParams
import io.typefox.lsapi.DocumentOnTypeFormattingParams
import io.typefox.lsapi.DocumentRangeFormattingParams
import io.typefox.lsapi.DocumentSymbolParams
import io.typefox.lsapi.FileEvent
import io.typefox.lsapi.InitializeParams
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.InitializeResultImpl
import io.typefox.lsapi.LanguageServer
import io.typefox.lsapi.MessageParams
import io.typefox.lsapi.NotificationCallback
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.PublishDiagnosticsParamsImpl
import io.typefox.lsapi.RangeImpl
import io.typefox.lsapi.ReferenceParams
import io.typefox.lsapi.RenameParams
import io.typefox.lsapi.ServerCapabilities
import io.typefox.lsapi.ServerCapabilitiesImpl
import io.typefox.lsapi.ShowMessageRequestParams
import io.typefox.lsapi.TextDocumentPositionParams
import io.typefox.lsapi.TextDocumentService
import io.typefox.lsapi.WindowService
import io.typefox.lsapi.WorkspaceService
import io.typefox.lsapi.WorkspaceSymbolParams
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.validation.Issue

import static io.typefox.lsapi.util.LsapiFactories.*

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors class LanguageServerImpl implements LanguageServer, WorkspaceService, WindowService, TextDocumentService {
    
    InitializeParams params
    @Inject Provider<WorkspaceManager> workspaceManagerProvider
    WorkspaceManager workspaceManager
    @Inject extension UriExtensions
    @Inject extension IResourceServiceProvider.Registry languagesRegistry
    
    override InitializeResult initialize(InitializeParams params) {
        this.params = params
        workspaceManager = workspaceManagerProvider.get
        val rootURI = URI.createFileURI(params.rootPath)
        workspaceManager.initialize(rootURI)[this.publishDiagnostics($0, $1)]
        return new InitializeResultImpl => [
            capabilities = new ServerCapabilitiesImpl => [
            	documentSymbolProvider = true
            	textDocumentSync = ServerCapabilities.SYNC_INCREMENTAL
                completionProvider = new CompletionOptionsImpl => [
                    resolveProvider = false
                    triggerCharacters = #["."]
                ]
            ]
        ]
    }

    override exit() {
    }

    override void shutdown() {
    }

    override getTextDocumentService() {
        this
    }

    override getWorkspaceService() {
        this
    }

    override getWindowService() {
        this
    }

    // notification callbacks

    override onShowMessage(NotificationCallback<MessageParams> callback) {
        // TODO: auto-generated method stub
    }

    override onShowMessageRequest(NotificationCallback<ShowMessageRequestParams> callback) {
        // TODO: auto-generated method stub
    }
    
    override onLogMessage(NotificationCallback<MessageParams> callback) {
        // TODO: auto-generated method stub
    }

    // end notification callbacks

    // file/content change events
    override didOpen(DidOpenTextDocumentParams params) {
        workspaceManager.didOpen(params.textDocument.uri.toUri, params.textDocument.version, params.textDocument.text)
    }
    
    override didChange(DidChangeTextDocumentParams params) {
        workspaceManager.didChange(params.textDocument.uri.toUri, params.textDocument.version, params.contentChanges.map [ event |
            newTextEdit(event.range as RangeImpl, event.text)
        ])
    }
    
    override didClose(DidCloseTextDocumentParams params) {
        workspaceManager.didClose(params.textDocument.uri.toUri)
    }
    
    override didSave(DidSaveTextDocumentParams params) {
        workspaceManager.didSave(params.textDocument.uri.toUri)
    }
    
    override didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
        val dirtyFiles = newArrayList
        val deletedFiles = newArrayList
        for (fileEvent : params.changes) {
            if (fileEvent.type === FileEvent.TYPE_DELETED) {
                deletedFiles += toUri(fileEvent.uri)
            } else {
                dirtyFiles += toUri(fileEvent.uri)
            }
        }
        workspaceManager.doBuild(dirtyFiles, deletedFiles)
    }
    // end file/content change events
    
    // validation stuff
    
    private List<NotificationCallback<PublishDiagnosticsParams>> diagnosticListeners = newArrayList()
    
    override onPublishDiagnostics(NotificationCallback<PublishDiagnosticsParams> callback) {
        diagnosticListeners.add(callback)
    }
    
    private def void publishDiagnostics(URI uri, Iterable<? extends Issue> issues) {
        val diagnostics = new PublishDiagnosticsParamsImpl => [
            it.uri = toPath(uri)
            it.diagnostics = issues.map[toDiagnostic].toList
        ]
        for (diagnosticsCallback : diagnosticListeners) {
            diagnosticsCallback.call(diagnostics)
        }
    }
    
    private def DiagnosticImpl toDiagnostic(Issue issue) {
        new DiagnosticImpl => [
            code = issue.code 
            severity = switch issue.severity {
                case ERROR : Diagnostic.SEVERITY_ERROR
                case WARNING : Diagnostic.SEVERITY_WARNING
                case INFO : Diagnostic.SEVERITY_INFO
                default : Diagnostic.SEVERITY_HINT
            }
            message = issue.message
            range = newRange(
                 newPosition(issue.lineNumber - 1, issue.column - 1),
                 newPosition(issue.lineNumber - 1, issue.column - 1 + issue.length)
            )
        ]
    }
    
    // end validation stuff
    
    // completion stuff
    
    override completion(TextDocumentPositionParams params) {
		val uri = params.textDocument.uri.toUri
		val resourceServiceProvider = uri.resourceServiceProvider
		val contentAssistService = resourceServiceProvider?.get(ContentAssistService)
		if (contentAssistService === null)
			return emptyList

		val entries = workspaceManager.doRead(uri) [ document, resource |
			val offset = document.getOffSet(params.position)
			return contentAssistService.createProposals(document.contents, offset, resource)
		]
		return entries.map[toCompletionItem].toList
	}

	protected def CompletionItem toCompletionItem(ContentAssistEntry entry) {
		val completionItem = new CompletionItemImpl
		completionItem.label = entry.label ?: entry.proposal
		completionItem.detail = entry.description
		completionItem.insertText = entry.proposal
		return completionItem
	}
    
    // end completion stuff
    
    // symbols
    
    override documentSymbol(DocumentSymbolParams params) {
    	val uri = params.textDocument.uri.toUri
		val resourceServiceProvider = uri.resourceServiceProvider
		val documentSymbolService = resourceServiceProvider?.get(DocumentSymbolService)
		if (documentSymbolService === null)
        	return emptyList
        	
        return workspaceManager.doRead(uri) [ document, resource | 
        	return documentSymbolService.getSymbols(resource) 
        ]		
    }
    
    // end symbols
    
    override symbol(WorkspaceSymbolParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didChangeConfiguraton(DidChangeConfigurationParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override resolveCompletionItem(CompletionItem unresolved) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override hover(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override signatureHelp(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override definition(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override references(ReferenceParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override documentHighlight(TextDocumentPositionParams position) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override codeAction(CodeActionParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override codeLens(CodeLensParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override resolveCodeLens(CodeLens unresolved) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override formatting(DocumentFormattingParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override rangeFormatting(DocumentRangeFormattingParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override onTypeFormatting(DocumentOnTypeFormattingParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override rename(RenameParams params) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
}