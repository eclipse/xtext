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
import java.util.Collections
import java.util.List
import java.util.concurrent.CompletableFuture
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.CodeLens
import org.eclipse.lsp4j.CodeLensParams
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionList
import org.eclipse.lsp4j.CompletionOptions
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.DidCloseTextDocumentParams
import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.DidSaveTextDocumentParams
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.DocumentOnTypeFormattingParams
import org.eclipse.lsp4j.DocumentRangeFormattingParams
import org.eclipse.lsp4j.DocumentSymbolParams
import org.eclipse.lsp4j.FileChangeType
import org.eclipse.lsp4j.Hover
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.PublishDiagnosticsParams
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.ReferenceParams
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.ServerCapabilities
import org.eclipse.lsp4j.SignatureHelp
import org.eclipse.lsp4j.SignatureHelpOptions
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.TextDocumentSyncKind
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceSymbolParams
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageClientAware
import org.eclipse.lsp4j.services.LanguageServer
import org.eclipse.lsp4j.services.TextDocumentService
import org.eclipse.lsp4j.services.WorkspaceService
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.findReferences.WorkspaceResourceAccess
import org.eclipse.xtext.ide.server.formatting.FormattingService
import org.eclipse.xtext.ide.server.hover.HoverService
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService
import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.Issue

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Accessors class LanguageServerImpl implements LanguageServer, WorkspaceService, TextDocumentService, LanguageClientAware {

	@Inject
	RequestManager requestManager
	
	@Inject
	WorkspaceSymbolService workspaceSymbolService

	InitializeParams params
	@Inject Provider<WorkspaceManager> workspaceManagerProvider
	WorkspaceManager workspaceManager
	@Inject extension UriExtensions
	@Inject extension IResourceServiceProvider.Registry languagesRegistry
	@Inject OperationCanceledManager operationCanceledManager

	override CompletableFuture<InitializeResult> initialize(InitializeParams params) {
		if (params.rootPath === null) {
			throw new IllegalArgumentException("Bad initialization request. rootPath must not be null.")
		}
		if (languagesRegistry.extensionToFactoryMap.isEmpty) {
			throw new IllegalStateException("No Xtext languages have been registered. Please make sure you have added the languages's setup class in '/META-INF/services/org.eclipse.xtext.ISetup'")
		}
		this.params = params
		workspaceManager = workspaceManagerProvider.get
		resourceAccess = new WorkspaceResourceAccess(workspaceManager)

		val result = new InitializeResult
		result.capabilities = new ServerCapabilities => [
			hoverProvider = true
			definitionProvider = true
			referencesProvider = true
			documentSymbolProvider = true
			workspaceSymbolProvider = true
            //TODO make this language specific
            signatureHelpProvider = new SignatureHelpOptions(#['(', ','])
			textDocumentSync = TextDocumentSyncKind.Incremental
			completionProvider = new CompletionOptions => [
				resolveProvider = false
				triggerCharacters = #["."]
			]
			documentFormattingProvider = true
			documentRangeFormattingProvider = true
			documentHighlightProvider = true
		]

		requestManager.runWrite([ cancelIndicator |
			val rootURI = URI.createFileURI(params.rootPath).toPath.toUri
			workspaceManager.initialize(rootURI, [this.publishDiagnostics($0, $1)], cancelIndicator)
		], CancellableIndicator.NullImpl)

		return CompletableFuture.completedFuture(result)
	}
	
	override connect(LanguageClient client) {
		this.client = client
	}

	override exit() {
	}

	override CompletableFuture<Void> shutdown() {
	}

	override TextDocumentService getTextDocumentService() {
		return this
	}

	override WorkspaceService getWorkspaceService() {
		return this
	}

	// end notification callbacks
	// file/content change events
	override didOpen(DidOpenTextDocumentParams params) {
		requestManager.runWrite [ cancelIndicator |
			workspaceManager.didOpen(params.textDocument.uri.toUri, params.textDocument.version, params.textDocument.text, cancelIndicator)
		]
	}

	override didChange(DidChangeTextDocumentParams params) {
		requestManager.runWrite [ cancelIndicator |
			workspaceManager.didChange(params.textDocument.uri.toUri, params.textDocument.version, params.contentChanges.map [ event |
				new TextEdit(event.range, event.text)
			], cancelIndicator)
		]
	}

	override didClose(DidCloseTextDocumentParams params) {
		requestManager.runWrite [ cancelIndicator |
			workspaceManager.didClose(params.textDocument.uri.toUri, cancelIndicator)
		]
	}

	override didSave(DidSaveTextDocumentParams params) {
	    // the document's content is in sync with the file system
		// doesn't matter to us, so do nothing
	}

	override didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
		requestManager.runWrite [ cancelIndicator |
			val dirtyFiles = newArrayList
			val deletedFiles = newArrayList
			for (fileEvent : params.changes) {
				if (fileEvent.type === FileChangeType.Deleted) {
					deletedFiles += toUri(fileEvent.uri)
				} else {
					dirtyFiles += toUri(fileEvent.uri)
				}
			}
			workspaceManager.doBuild(dirtyFiles, deletedFiles, cancelIndicator)
		]
	}
	
	override didChangeConfiguration(DidChangeConfigurationParams params) {
        requestManager.runWrite [ cancelIndicator |
            workspaceManager.refreshWorkspaceConfig(cancelIndicator)
        ]
    }

	// end file/content change events
    
    WorkspaceResourceAccess resourceAccess
	
	LanguageClient client

	private def void publishDiagnostics(URI uri, Iterable<? extends Issue> issues) {
		val diagnostics = new PublishDiagnosticsParams => [
			it.uri = toPath(uri)
			it.diagnostics = issues.map[toDiagnostic].toList
		]
		client.publishDiagnostics(diagnostics)
	}

	private def Diagnostic toDiagnostic(Issue issue) {
		new Diagnostic => [
			code = issue.code
			severity = switch issue.severity {
				case ERROR: DiagnosticSeverity.Error
				case WARNING: DiagnosticSeverity.Warning
				case INFO: DiagnosticSeverity.Information
				default: DiagnosticSeverity.Hint
			}
			message = issue.message
            val lineNumber = (issue.lineNumber ?: 1) - 1
            val column = (issue.column ?: 1) - 1
            val length = (issue.length ?: 0)
			range = new Range(
				new Position(lineNumber, column),
				new Position(lineNumber, column + length)
			)
		]
	}
	// end validation stuff
	
	@FinalFieldsConstructor
	static class BufferedCancelIndicator implements CancelIndicator {
	    
	    val CancelIndicator delegate;
	    Long canceledSince
    
        override isCanceled() {
            if (canceledSince === null && delegate.canceled) {
                canceledSince = System.currentTimeMillis
                return false
            }
            return canceledSince !== null && System.currentTimeMillis > canceledSince + 1000
        }
	    
	}
	// completion stuff
	override CompletableFuture<CompletionList> completion(TextDocumentPositionParams params) {
		return requestManager.runRead[ origialCancelIndicator |
		    
		    val cancelIndicator = new BufferedCancelIndicator(origialCancelIndicator)
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val contentAssistService = resourceServiceProvider?.get(ContentAssistService)
			if (contentAssistService === null)
				return new CompletionList();
            
            val result = workspaceManager.doRead(uri) [ document, resource |
                return contentAssistService.createCompletionList(document, resource, params, cancelIndicator)
            ]
            return result
		]
	}

	// end completion stuff
	// symbols
	override definition(TextDocumentPositionParams params) {
		return requestManager.<List<? extends Location>>runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val documentSymbolService = resourceServiceProvider?.get(DocumentSymbolService)
			if (documentSymbolService === null)
				return emptyList
	
			val definitions = workspaceManager.doRead(uri) [ document, resource |
				val offset = document.getOffSet(params.position)
				return documentSymbolService.getDefinitions(resource, offset, resourceAccess, cancelIndicator)
			]
			return definitions
		]
	}

	override references(ReferenceParams params) {
		return requestManager.<List<? extends Location>>runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val documentSymbolService = resourceServiceProvider?.get(DocumentSymbolService)
			if (documentSymbolService === null)
				return emptyList
	
			return workspaceManager.doRead(uri) [ document, resource |
				val offset = document.getOffSet(params.position)
				
				val definitions = if (params.context.includeDeclaration)
						documentSymbolService.getDefinitions(resource, offset, resourceAccess, cancelIndicator)
					else
						emptyList
				
				val indexData = workspaceManager.index
				val references = documentSymbolService.getReferences(resource, offset, resourceAccess, indexData, cancelIndicator)
				val result = definitions + references
				return result.toList
			]
		]
	}

	override documentSymbol(DocumentSymbolParams params) {
		return requestManager.<List<? extends SymbolInformation>>runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val documentSymbolService = resourceServiceProvider?.get(DocumentSymbolService)
			if (documentSymbolService === null)
				return emptyList
	
			return workspaceManager.doRead(uri) [ document, resource |
				return documentSymbolService.getSymbols(resource, cancelIndicator)
			]
		]
	}

	override symbol(WorkspaceSymbolParams params) {
		return requestManager.<List<? extends SymbolInformation>>runRead [ cancelIndicator |
			val indexData = workspaceManager.index
			return workspaceSymbolService.getSymbols(params.query, resourceAccess, indexData, cancelIndicator)
		]
	}

	// end symbols

	// hover
	
	override hover(TextDocumentPositionParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val hoverService = resourceServiceProvider?.get(HoverService)
			if (hoverService === null)
				return new Hover(emptyList, null)

			return workspaceManager.doRead(uri) [ document, resource |
				val offset = document.getOffSet(params.position)
				return hoverService.hover(resource, offset)
			]
		]
	}
	
	// end hover
	
	override resolveCompletionItem(CompletionItem unresolved) {
		return CompletableFuture.completedFuture(unresolved)
	}

	override signatureHelp(TextDocumentPositionParams position) {
		return requestManager.runRead [ cancelIndicator |
            val uri = position.textDocument.uri.toUri;
            val serviceProvider = uri.resourceServiceProvider;
            val helper = serviceProvider?.get(SignatureHelpService);
            if (helper === null) {
                return new SignatureHelp(); 
            }
            
            return workspaceManager.doRead(uri, [doc, resource |
                val offset = doc.getOffSet(position.position);
                return helper.getSignatureHelp(resource, offset);
            ]);
        ];
	}

	override documentHighlight(TextDocumentPositionParams position) {
		return requestManager.runRead [ cancelIndicator |
			val uri = position.textDocument.uri.toUri;
			val serviceProvider = uri.resourceServiceProvider;
			val service =  serviceProvider?.get(IDocumentHighlightService);
			if (service === null) {
				return emptyList;
			}
			
			return workspaceManager.doRead(uri, [doc, resource |
				val offset = doc.getOffSet(position.position);
				return service.getDocumentHighlights(resource, offset);
			]);
		];
	}

	override codeAction(CodeActionParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override codeLens(CodeLensParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override resolveCodeLens(CodeLens unresolved) {
		return CompletableFuture.completedFuture(unresolved)
	}

	override formatting(DocumentFormattingParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val formatterService = resourceServiceProvider?.get(FormattingService)
			if (formatterService === null)
				return Collections.emptyList

			return workspaceManager.doRead(uri) [ document, resource |
				val offset = 0
				val length = document.contents.length
				if (length === 0 || resource.contents.isEmpty) {
				    return emptyList
				}
				return formatterService.format(resource, document, offset, length)
			]  
		]
	}

	override rangeFormatting(DocumentRangeFormattingParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val formatterService = resourceServiceProvider?.get(FormattingService)
			if (formatterService === null)
				return Collections.emptyList

			return workspaceManager.doRead(uri) [ document, resource |
				val offset = document.getOffSet(params.range.start)
				val length = document.getOffSet(params.range.end) - offset
				return formatterService.format(resource, document, offset, length)
			]  
		]
	}

	override onTypeFormatting(DocumentOnTypeFormattingParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override rename(RenameParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}


}
