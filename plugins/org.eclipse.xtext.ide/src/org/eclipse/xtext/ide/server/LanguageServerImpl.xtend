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
import io.typefox.lsapi.CompletionList
import io.typefox.lsapi.CompletionListImpl
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
import io.typefox.lsapi.LanguageDescriptionImpl
import io.typefox.lsapi.Location
import io.typefox.lsapi.MessageParams
import io.typefox.lsapi.PublishDiagnosticsParams
import io.typefox.lsapi.PublishDiagnosticsParamsImpl
import io.typefox.lsapi.RangeImpl
import io.typefox.lsapi.ReferenceParams
import io.typefox.lsapi.RenameParams
import io.typefox.lsapi.ServerCapabilities
import io.typefox.lsapi.ServerCapabilitiesImpl
import io.typefox.lsapi.ShowMessageRequestParams
import io.typefox.lsapi.SymbolInformation
import io.typefox.lsapi.TextDocumentPositionParams
import io.typefox.lsapi.WorkspaceSymbolParams
import io.typefox.lsapi.services.LanguageServer
import io.typefox.lsapi.services.TextDocumentService
import io.typefox.lsapi.services.WindowService
import io.typefox.lsapi.services.WorkspaceService
import java.util.List
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.LanguageInfo
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.editor.syntaxcoloring.IEditorHighlightingConfigurationProvider
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.findReferences.WorkspaceResourceAccess
import org.eclipse.xtext.ide.server.hover.HoverService
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.validation.Issue

import static io.typefox.lsapi.util.LsapiFactories.*
import org.eclipse.xtext.resource.IMimeTypeProvider

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
			textDocumentSync = ServerCapabilities.SYNC_INCREMENTAL
			completionProvider = new CompletionOptionsImpl => [
				resolveProvider = false
				triggerCharacters = #["."]
			]
		]
		result.supportedLanguages = newArrayList()
		for (serviceProvider : languagesRegistry.extensionToFactoryMap.values.filter(IResourceServiceProvider).toSet) {
		    val extensionProvider = serviceProvider.get(FileExtensionProvider)
		    val mimeTypesProvider = serviceProvider.get(IMimeTypeProvider)
		    val langInfo = serviceProvider.get(LanguageInfo)
		    val highlightingProvider = serviceProvider.get(IEditorHighlightingConfigurationProvider)
		    val language = new LanguageDescriptionImpl => [
		        fileExtensions = extensionProvider.fileExtensions.toList
		        languageId = langInfo.languageName
		        mimeTypes = mimeTypesProvider.mimeTypes
		        if (highlightingProvider !== null)
		          highlightingConfiguration = highlightingProvider.getConfiguration(params.clientName)
		    ]
		    result.supportedLanguages.add(language)
		}

		requestManager.runWrite([ cancelIndicator |
			val rootURI = URI.createFileURI(params.rootPath)
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
				newTextEdit(event.range as RangeImpl, event.text)
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
				if (fileEvent.type === FileEvent.TYPE_DELETED) {
					deletedFiles += toUri(fileEvent.uri)
				} else {
					dirtyFiles += toUri(fileEvent.uri)
				}
			}
			workspaceManager.doBuild(dirtyFiles, deletedFiles, cancelIndicator)
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
				case ERROR: Diagnostic.SEVERITY_ERROR
				case WARNING: Diagnostic.SEVERITY_WARNING
				case INFO: Diagnostic.SEVERITY_INFO
				default: Diagnostic.SEVERITY_HINT
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
	override CompletableFuture<CompletionList> completion(TextDocumentPositionParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val contentAssistService = resourceServiceProvider?.get(ContentAssistService)
			val result = new CompletionListImpl
			if (contentAssistService === null)
				return result

			val entries = workspaceManager.doRead(uri) [ document, resource |
				val offset = document.getOffSet(params.position)
				return contentAssistService.createProposals(document.contents, offset, resource, cancelIndicator)
			]
			result.items = entries.map[toCompletionItem].toList 
			return result
		]
	}

	protected def CompletionItemImpl toCompletionItem(ContentAssistEntry entry) {
		val completionItem = new CompletionItemImpl
		completionItem.label = entry.label ?: entry.proposal
		completionItem.detail = entry.description
		completionItem.insertText = entry.proposal
		return completionItem
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
				return emptyHover

			return workspaceManager.doRead(uri) [ document, resource |
				val offset = document.getOffSet(params.position)
				return hoverService.hover(resource, offset)
			]  
		]
	}
	
	// end hover
	
	override didChangeConfiguraton(DidChangeConfigurationParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override resolveCompletionItem(CompletionItem unresolved) {
		return CompletableFuture.completedFuture(unresolved)
	}

	override signatureHelp(TextDocumentPositionParams position) {
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
		return CompletableFuture.completedFuture(unresolved)
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
