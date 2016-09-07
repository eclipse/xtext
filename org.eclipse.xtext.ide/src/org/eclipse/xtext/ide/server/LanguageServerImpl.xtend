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
import io.typefox.lsapi.CompletionItemKind
import io.typefox.lsapi.CompletionList
import io.typefox.lsapi.DiagnosticSeverity
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
import io.typefox.lsapi.FileChangeType
import io.typefox.lsapi.InitializeParams
import io.typefox.lsapi.InitializeResult
import io.typefox.lsapi.Location
import io.typefox.lsapi.MessageParams
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.ReferenceParams
import io.typefox.lsapi.RenameParams
import io.typefox.lsapi.ShowMessageRequestParams
import io.typefox.lsapi.SymbolInformation
import io.typefox.lsapi.TextDocumentPositionParams
import io.typefox.lsapi.TextDocumentSyncKind
import io.typefox.lsapi.WorkspaceSymbolParams
import io.typefox.lsapi.impl.CompletionItemImpl
import io.typefox.lsapi.impl.CompletionListImpl
import io.typefox.lsapi.impl.CompletionOptionsImpl
import io.typefox.lsapi.impl.DiagnosticImpl
import io.typefox.lsapi.impl.HoverImpl
import io.typefox.lsapi.impl.InitializeResultImpl
import io.typefox.lsapi.impl.PositionImpl
import io.typefox.lsapi.impl.PublishDiagnosticsParamsImpl
import io.typefox.lsapi.impl.RangeImpl
import io.typefox.lsapi.impl.ServerCapabilitiesImpl
import io.typefox.lsapi.impl.SignatureHelpImpl
import io.typefox.lsapi.impl.SignatureHelpOptionsImpl
import io.typefox.lsapi.impl.TextEditImpl
import io.typefox.lsapi.services.LanguageServer
import io.typefox.lsapi.services.TextDocumentService
import io.typefox.lsapi.services.WindowService
import io.typefox.lsapi.services.WorkspaceService
import java.util.Collections
import java.util.List
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.findReferences.WorkspaceResourceAccess
import org.eclipse.xtext.ide.server.formatting.FormattingService
import org.eclipse.xtext.ide.server.hover.HoverService
import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.validation.Issue

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Accessors class LanguageServerImpl implements LanguageServer, WorkspaceService, WindowService, TextDocumentService {

	@Inject
	RequestManager requestManager
	
	@Inject
	WorkspaceSymbolService workspaceSymbolService

	InitializeParams params
	@Inject Provider<WorkspaceManager> workspaceManagerProvider
	WorkspaceManager workspaceManager
	@Inject extension UriExtensions
	@Inject extension IResourceServiceProvider.Registry languagesRegistry

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

		val result = new InitializeResultImpl
		result.capabilities = new ServerCapabilitiesImpl => [
			hoverProvider = true
			definitionProvider = true
			referencesProvider = true
			documentSymbolProvider = true
			workspaceSymbolProvider = true
            //TODO make this language specific
            signatureHelpProvider = new SignatureHelpOptionsImpl(#['(', ','])
			textDocumentSync = TextDocumentSyncKind.Incremental
			completionProvider = new CompletionOptionsImpl => [
				resolveProvider = false
				triggerCharacters = #["."]
			]
			documentFormattingProvider = true
			documentRangeFormattingProvider = true
		]

		requestManager.runWrite([ cancelIndicator |
			val rootURI = URI.createFileURI(params.rootPath).toPath.toUri
			workspaceManager.initialize(rootURI, [this.publishDiagnostics($0, $1)], cancelIndicator)
		], CancellableIndicator.NullImpl)

		return CompletableFuture.completedFuture(result)
	}

	override exit() {
	}

	override void shutdown() {
	}

	override TextDocumentService getTextDocumentService() {
		return this
	}

	override WorkspaceService getWorkspaceService() {
		return this
	}

	override WindowService getWindowService() {
		return this
	}
	
	// notification callbacks
	override onTelemetryEvent(Consumer<Object> callback) {
		// TODO: auto-generated method stub
	}

	override onShowMessage(Consumer<MessageParams> callback) {
		// TODO: auto-generated method stub
	}

	override onShowMessageRequest(Consumer<ShowMessageRequestParams> callback) {
		// TODO: auto-generated method stub
	}

	override onLogMessage(Consumer<MessageParams> callback) {
		// TODO: auto-generated method stub
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
				new TextEditImpl(event.range as RangeImpl, event.text)
			], cancelIndicator)
		]
	}

	override didClose(DidCloseTextDocumentParams params) {
		requestManager.runWrite [ cancelIndicator |
			workspaceManager.didClose(params.textDocument.uri.toUri, cancelIndicator)
		]
	}

	override didSave(DidSaveTextDocumentParams params) {
		requestManager.runWrite [ cancelIndicator |
			workspaceManager.didSave(params.textDocument.uri.toUri, cancelIndicator)
		]
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
	
	override didChangeConfiguraton(DidChangeConfigurationParams params) {
        requestManager.runWrite [ cancelIndicator |
            workspaceManager.refreshWorkspaceConfig(cancelIndicator)
        ]
    }

	// end file/content change events
	// validation stuff
	private List<Consumer<PublishDiagnosticsParams>> diagnosticListeners = newArrayList()
    
    WorkspaceResourceAccess resourceAccess

	override onPublishDiagnostics(Consumer<PublishDiagnosticsParams> callback) {
		diagnosticListeners.add(callback)
	}

	private def void publishDiagnostics(URI uri, Iterable<? extends Issue> issues) {
		val diagnostics = new PublishDiagnosticsParamsImpl => [
			it.uri = toPath(uri)
			it.diagnostics = issues.map[toDiagnostic].toList
		]
		for (diagnosticsCallback : diagnosticListeners) {
			diagnosticsCallback.accept(diagnostics)
		}
	}

	private def DiagnosticImpl toDiagnostic(Issue issue) {
		new DiagnosticImpl => [
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
			range = new RangeImpl(
				new PositionImpl(lineNumber, column),
				new PositionImpl(lineNumber, column + length)
			)
		]
	}

	// end validation stuff
	// completion stuff
	override CompletableFuture<CompletionList> completion(TextDocumentPositionParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val contentAssistService = resourceServiceProvider?.get(ContentAssistService)
			val result = new CompletionListImpl
			if (contentAssistService === null)
				return result
            
            result.items = workspaceManager.doRead(uri) [ document, resource |
                val caretOffset = document.getOffSet(params.position)
                val entries = contentAssistService.createProposals(document.contents, caretOffset, resource, cancelIndicator)
                return [|
                    val caretPosition = new PositionImpl(params.position as PositionImpl)
                    val completionItems = newArrayList
                    entries.forEach[entry, idx|
                        val item = entry.toCompletionItem(caretOffset, caretPosition, document)
                        item.sortText = idx.toString
                        completionItems += item                        
                    ]
                    return completionItems
                ]
            ].apply
            return result
		]
	}

	protected def CompletionItemImpl toCompletionItem(ContentAssistEntry entry, int caretOffset, PositionImpl caretPosition, Document document) {
		val completionItem = new CompletionItemImpl
		completionItem.label = entry.label ?: entry.proposal
		completionItem.detail = entry.description
	    val prefixOffset = caretOffset - (entry.prefix?:'').length
	    val prefixPosition = document.getPosition(prefixOffset)
	    completionItem.textEdit = new TextEditImpl(new RangeImpl(prefixPosition, caretPosition), entry.proposal) 
		completionItem.kind = translateKind(entry)
		return completionItem
	}
    
    protected def translateKind(ContentAssistEntry entry) {
        switch entry.kind {
            case ContentAssistEntry.KIND_CLASS : CompletionItemKind.Class
            case ContentAssistEntry.KIND_COLOR : CompletionItemKind.Color
            case ContentAssistEntry.KIND_CONSTRUCTOR : CompletionItemKind.Constructor
            case ContentAssistEntry.KIND_ENUM : CompletionItemKind.Enum
            case ContentAssistEntry.KIND_FIELD : CompletionItemKind.Field
            case ContentAssistEntry.KIND_FILE : CompletionItemKind.File
            case ContentAssistEntry.KIND_FUNCTION : CompletionItemKind.Function
            case ContentAssistEntry.KIND_INTERFACE : CompletionItemKind.Interface
            case ContentAssistEntry.KIND_KEYWORD : CompletionItemKind.Keyword
            case ContentAssistEntry.KIND_METHOD : CompletionItemKind.Method
            case ContentAssistEntry.KIND_MODULE : CompletionItemKind.Module
            case ContentAssistEntry.KIND_PROPERTY : CompletionItemKind.Property
            case ContentAssistEntry.KIND_REFERENCE : CompletionItemKind.Reference
            case ContentAssistEntry.KIND_SNIPPET : CompletionItemKind.Snippet
            case ContentAssistEntry.KIND_TEXT : CompletionItemKind.Text
            case ContentAssistEntry.KIND_UNIT : CompletionItemKind.Unit
            case ContentAssistEntry.KIND_VALUE : CompletionItemKind.Value
            case ContentAssistEntry.KIND_VARIABLE : CompletionItemKind.Variable
            default : CompletionItemKind.Value
        }
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
				return new HoverImpl(emptyList, null)

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
                return new SignatureHelpImpl(); 
            }
            
            return workspaceManager.doRead(uri, [doc, resource |
                val offset = doc.getOffSet(position.position);
                return helper.getSignatureHelp(resource, offset);
            ]);
        ];
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
