/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.common.collect.LinkedListMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import java.util.List
import java.util.Map
import java.util.concurrent.CompletableFuture
import java.util.function.Function
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.CodeActionParams
import org.eclipse.lsp4j.CodeLens
import org.eclipse.lsp4j.CodeLensOptions
import org.eclipse.lsp4j.CodeLensParams
import org.eclipse.lsp4j.ColoringParams
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionList
import org.eclipse.lsp4j.CompletionOptions
import org.eclipse.lsp4j.CompletionParams
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
import org.eclipse.lsp4j.DocumentSymbol
import org.eclipse.lsp4j.DocumentSymbolParams
import org.eclipse.lsp4j.ExecuteCommandOptions
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.lsp4j.FileChangeType
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.PublishDiagnosticsParams
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.ReferenceParams
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.SemanticHighlightingServerCapabilities
import org.eclipse.lsp4j.ServerCapabilities
import org.eclipse.lsp4j.SignatureHelpOptions
import org.eclipse.lsp4j.SymbolInformation
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.TextDocumentSyncKind
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.WorkspaceEdit
import org.eclipse.lsp4j.WorkspaceSymbolParams
import org.eclipse.lsp4j.jsonrpc.Endpoint
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethod
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethodProvider
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageClientAware
import org.eclipse.lsp4j.services.LanguageClientExtensions
import org.eclipse.lsp4j.services.LanguageServer
import org.eclipse.lsp4j.services.TextDocumentService
import org.eclipse.lsp4j.services.WorkspaceService
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.server.ILanguageServerAccess.IBuildListener
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver
import org.eclipse.xtext.ide.server.codelens.ICodeLensService
import org.eclipse.xtext.ide.server.coloring.IColoringService
import org.eclipse.xtext.ide.server.commands.ExecutableCommandRegistry
import org.eclipse.xtext.ide.server.concurrent.RequestManager
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.findReferences.WorkspaceResourceAccess
import org.eclipse.xtext.ide.server.formatting.FormattingService
import org.eclipse.xtext.ide.server.hover.IHoverService
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService
import org.eclipse.xtext.ide.server.rename.IRenameService
import org.eclipse.xtext.ide.server.semanticHighlight.SemanticHighlightingRegistry
import org.eclipse.xtext.ide.server.signatureHelp.ISignatureHelpService
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService
import org.eclipse.xtext.ide.server.symbol.IDocumentSymbolService
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.validation.Issue

import static org.eclipse.xtext.diagnostics.Severity.*

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Log class LanguageServerImpl implements LanguageServer, WorkspaceService, TextDocumentService, LanguageClientAware, Endpoint, JsonRpcMethodProvider, IBuildListener {

	@Inject @Accessors(PUBLIC_GETTER) RequestManager requestManager
	@Inject WorkspaceSymbolService workspaceSymbolService
	@Inject extension UriExtensions
	@Inject extension IResourceServiceProvider.Registry languagesRegistry
	@Inject ExecutableCommandRegistry commandRegistry
	@Inject SemanticHighlightingRegistry semanticHighlightingRegistry
	
	// injected below
	WorkspaceManager workspaceManager
	InitializeParams params
	
	boolean hasShutdownBeenCalled = false;
	
	@Inject
	def void setWorkspaceManager(WorkspaceManager manager) {
		this.workspaceManager = manager
		resourceAccess = new WorkspaceResourceAccess(workspaceManager)
	}
	
	private def Iterable<? extends IResourceServiceProvider> getAllLanguages() {
		this.languagesRegistry.extensionToFactoryMap.keySet.toList.sort.map[ext|
			val synthUri = URI.createURI("synth:///file."+ext)
			return synthUri.resourceServiceProvider
		].toSet
	} 

	override CompletableFuture<InitializeResult> initialize(InitializeParams params) {
		if (this.params !== null) {
			throw new IllegalStateException("This language server has already been initialized.")
		}
		val baseDir = params.baseDir
		if (languagesRegistry.extensionToFactoryMap.isEmpty) {
			throw new IllegalStateException("No Xtext languages have been registered. Please make sure you have added the languages's setup class in '/META-INF/services/org.eclipse.xtext.ISetup'")
		}
		this.params = params
		val result = new InitializeResult
		var capabilities = new ServerCapabilities => [
			hoverProvider = true
			definitionProvider = true
			referencesProvider = true
			documentSymbolProvider = true
			workspaceSymbolProvider = true
			
			// check if a language with code lens capability exists
			if (allLanguages.exists[get(ICodeLensService)!==null]) {
				codeLensProvider = new CodeLensOptions => [
					resolveProvider = allLanguages.exists[get(ICodeLensResolver)!==null]
				]
			}
			
			// check if a language with code actions capability exists
			codeActionProvider = allLanguages.exists[get(ICodeActionService)!==null] 
			
			signatureHelpProvider = new SignatureHelpOptions(#['(', ','])
			textDocumentSync = TextDocumentSyncKind.Incremental
			completionProvider = new CompletionOptions => [
				resolveProvider = false
				triggerCharacters = #["."]
			]
			documentFormattingProvider = true
			documentRangeFormattingProvider = true
			documentHighlightProvider = true
			renameProvider = allLanguages.exists[get(IRenameService)!==null]

			val clientCapabilities = params.capabilities;
			// register execute command capability
			if (clientCapabilities?.workspace?.executeCommand !== null) {
				this.commandRegistry.initialize(allLanguages, clientCapabilities, client)
				executeCommandProvider = new ExecuteCommandOptions => [
					commands = this.commandRegistry.getCommands()
				]
			}

			semanticHighlightingRegistry.initialize(allLanguages, clientCapabilities, client);
			semanticHighlighting = new SemanticHighlightingServerCapabilities(semanticHighlightingRegistry.allScopes);

		]
		for (language : allLanguages) {
			language.get(ICapabilitiesContributor)?.contribute(capabilities, params)
		}
		result.capabilities = capabilities
		
		access.addBuildListener(this);
		
		return requestManager.runWrite([
			workspaceManager.initialize(baseDir, [this.publishDiagnostics($0, $1)], CancelIndicator.NullImpl)
			return null
		], []).thenApply [result]
	}
	
	@Deprecated
	private def URI deprecatedToBaseDir(InitializeParams params) {
		if (params.rootPath !== null) {
			return URI.createFileURI(params.rootPath).toUriString.toUri
		}
		return null
	}
	
	protected def URI getBaseDir(InitializeParams params) {
		if (params.rootUri !== null) {
			return params.rootUri.toUri
		}
		return params.deprecatedToBaseDir;
	}
	
	override connect(LanguageClient client) {
		this.client = client
	}

	override exit() {
		if(this.hasShutdownBeenCalled) {
			System.exit(0);
		} else {
			System.exit(1);
		}
	}

	override CompletableFuture<Object> shutdown() {
		this.hasShutdownBeenCalled = true;
		return CompletableFuture.completedFuture(new Object());
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
		requestManager.runWrite([
			workspaceManager.didOpen(params.textDocument.uri.toUri, params.textDocument.version, params.textDocument.text)
		], [cancelIndicator , buildable | 
			buildable.build(cancelIndicator)
		])
	}

	override didChange(DidChangeTextDocumentParams params) {
		requestManager.runWrite([ 
			workspaceManager.didChange(params.textDocument.uri.toUri, params.textDocument.version, params.contentChanges.map [ event |
				new TextEdit(event.range, event.text)
			])
		], [cancelIndicator , buildable | 
			buildable.build(cancelIndicator)
		])
	}

	override didClose(DidCloseTextDocumentParams params) {
		requestManager.runWrite([
			workspaceManager.didClose(params.textDocument.uri.toUri)
		], [cancelIndicator , buildable | 
			buildable.build(cancelIndicator)
		])
	}

	override didSave(DidSaveTextDocumentParams params) {
	    // the document's content is in sync with the file system
		// doesn't matter to us, so do nothing
	}

	override didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
		requestManager.runWrite([
			val dirtyFiles = newArrayList
			val deletedFiles = newArrayList
			for (fileEvent : params.changes) {
				if (fileEvent.type === FileChangeType.Deleted) {
					deletedFiles += toUri(fileEvent.uri)
				} else {
					dirtyFiles += toUri(fileEvent.uri)
				}
			}
			workspaceManager.didChangeFiles(dirtyFiles, deletedFiles)
		], [cancelIndicator , buildable | 
			buildable.build(cancelIndicator)
		])
	}
	
	override didChangeConfiguration(DidChangeConfigurationParams params) {
		requestManager.runWrite([
            workspaceManager.refreshWorkspaceConfig(CancelIndicator.NullImpl)
            return null
        ], [])
    }

	// end file/content change events
    
    WorkspaceResourceAccess resourceAccess
	
	LanguageClient client

	private def void publishDiagnostics(URI uri, Iterable<? extends Issue> issues) {
		val diagnostics = new PublishDiagnosticsParams => [
			it.uri = toUriString(uri)
			it.diagnostics = issues.filter[severity !== IGNORE].map[toDiagnostic].toList
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
	override completion(CompletionParams params) {
		return requestManager.runRead[cancelIndicator | completion(cancelIndicator, params)]
	}
	
	protected def Either<List<CompletionItem>, CompletionList> completion(CancelIndicator originalCancelIndicator, CompletionParams params) {
		val cancelIndicator = new BufferedCancelIndicator(originalCancelIndicator)
		val uri = params.textDocument.uri.toUri
		val resourceServiceProvider = uri.resourceServiceProvider
		val contentAssistService = resourceServiceProvider?.get(ContentAssistService)
		if (contentAssistService === null) {
			return Either.forRight(new CompletionList())
		}
        
        val completionList = workspaceManager.doRead(uri) [ document, resource |
            return contentAssistService.createCompletionList(document, resource, params, cancelIndicator)
        ]
        return Either.forRight(completionList)
	}

	// end completion stuff
	// symbols
	override definition(TextDocumentPositionParams params) {
		return requestManager.runRead[cancelIndicator|definition(cancelIndicator, params)]
	}
	
	protected def List<? extends Location> definition(CancelIndicator cancelIndicator, TextDocumentPositionParams params) {
		val uri = params.textDocument.uri.toUri
		val resourceServiceProvider = uri.resourceServiceProvider
		val documentSymbolService = resourceServiceProvider?.get(DocumentSymbolService)
		if (documentSymbolService === null)
			return emptyList

		return workspaceManager.doRead(uri) [ document, resource |
			documentSymbolService.getDefinitions(document, resource, params, resourceAccess, cancelIndicator)
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
				documentSymbolService.getReferences(document, resource, params, resourceAccess, workspaceManager.index, cancelIndicator)
			]
		]
	}

	override documentSymbol(DocumentSymbolParams params) {
		return requestManager.<List<Either<SymbolInformation, DocumentSymbol>>>runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val documentSymbolService = resourceServiceProvider.IDocumentSymbolService
			if (documentSymbolService === null) {
				return emptyList
			}
	
			return workspaceManager.doRead(uri) [ document, resource |
				return documentSymbolService.getSymbols(document, resource, params, cancelIndicator)
			]
		]
	}

	/**
	 * @since 2.16
	 */
	protected def IDocumentSymbolService getIDocumentSymbolService(IResourceServiceProvider serviceProvider) {
		if (serviceProvider === null) {
			return null;
		}
		val documentSymbolServiceClass = if(hierarchicalDocumentSymbolSupport) HierarchicalDocumentSymbolService else DocumentSymbolService;
		return serviceProvider.get(documentSymbolServiceClass);
	}

	/**
	 * {@code true} if the {@code TextDocumentClientCapabilities} explicitly declares the hierarchical document symbol support
	 * at LS initialization time. Otherwise, false.
	 */
	protected def boolean isHierarchicalDocumentSymbolSupport() {
		return this.params.capabilities?.textDocument?.documentSymbol?.hierarchicalDocumentSymbolSupport ?: false;
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
			val hoverService = resourceServiceProvider?.get(IHoverService)
			if (hoverService === null)
				return IHoverService.EMPTY_HOVER

			return workspaceManager.doRead(uri) [ document, resource |
				hoverService.hover(document, resource, params, cancelIndicator)
			]
		]
	}
	
	// end hover
	
	override resolveCompletionItem(CompletionItem unresolved) {
		return CompletableFuture.completedFuture(unresolved)
	}

	override signatureHelp(TextDocumentPositionParams params) {
		return requestManager.runRead [ cancelIndicator |
            val uri = params.textDocument.uri.toUri;
            val serviceProvider = uri.resourceServiceProvider;
            val helper = serviceProvider?.get(ISignatureHelpService);
            if (helper === null)
                return ISignatureHelpService.EMPTY
            
            return workspaceManager.doRead(uri) [doc, resource |
                helper.getSignatureHelp(doc, resource, params, cancelIndicator)
            ]
        ];
	}

	override documentHighlight(TextDocumentPositionParams params) {
		return requestManager.runRead [ cancelIndicator |
			val uri = params.textDocument.uri.toUri;
			val serviceProvider = uri.resourceServiceProvider;
			val service = serviceProvider?.get(IDocumentHighlightService);
			if (service === null)
				return emptyList
			
			return workspaceManager.doRead(uri) [doc, resource |
				service.getDocumentHighlights(doc, resource, params, cancelIndicator)
			]
		];
	}

	override codeAction(CodeActionParams params) {
		return requestManager.runRead [ cancelIndicator |
			val uri = params.textDocument.uri.toUri;
			val serviceProvider = uri.resourceServiceProvider;
			val service = serviceProvider?.get(ICodeActionService);
			if (service === null)
				return emptyList
			
			return workspaceManager.doRead(uri) [doc, resource |
				service.getCodeActions(doc, resource, params, cancelIndicator)
			]
		]
	}

	private def void installURI(List<? extends CodeLens> codeLenses, String uri) {
		for (lens : codeLenses) {
			if (lens.data !== null) {
				lens.data = newArrayList(uri, lens.data)
			} else {
				lens.data = uri
			}
		}
	}

	private def URI uninstallURI(CodeLens lens) {
		var URI result = null
		if (lens.data instanceof String) {
			result = URI.createURI(lens.data.toString)
			lens.data = null
		} else if (lens.data instanceof List<?>) {
			val l = lens.data as List<?>
			result = URI.createURI(l.head.toString)
			lens.data = l.get(1)
		}
		return result
	}
	
	override codeLens(CodeLensParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val codeLensService = resourceServiceProvider?.get(ICodeLensService)
			if (codeLensService === null)
				return emptyList

			return workspaceManager.doRead(uri) [ document, resource |
				val result = codeLensService.computeCodeLenses(document, resource, params, cancelIndicator)
				installURI(result, uri.toString)
				return result
			]
		]
	}

	override resolveCodeLens(CodeLens unresolved) {
		val uri = uninstallURI(unresolved)
		if (uri === null) {
			return CompletableFuture.completedFuture(unresolved)
		}
		return requestManager.runRead[ cancelIndicator |
			val resourceServiceProvider = uri.resourceServiceProvider
			val resolver = resourceServiceProvider?.get(ICodeLensResolver)
			if (resolver === null)
				return unresolved

			return workspaceManager.doRead(uri) [ document, resource |
				val result = resolver.resolveCodeLens(document, resource, unresolved, cancelIndicator)
				return result
			]
		]
	}

	override formatting(DocumentFormattingParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val formatterService = resourceServiceProvider?.get(FormattingService)
			if (formatterService === null)
				return emptyList

			return workspaceManager.doRead(uri) [ document, resource |
				formatterService.format(document, resource, params, cancelIndicator)
			]  
		]
	}

	override rangeFormatting(DocumentRangeFormattingParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val formatterService = resourceServiceProvider?.get(FormattingService)
			if (formatterService === null)
				return emptyList

			return workspaceManager.doRead(uri) [ document, resource |
				formatterService.format(document, resource, params, cancelIndicator)
			]  
		]
	}
	
	override executeCommand(ExecuteCommandParams params) {
		return requestManager.runRead[ cancelIndicator |
			this.commandRegistry.executeCommand(params, this.access, cancelIndicator)
		]
	}

	override onTypeFormatting(DocumentOnTypeFormattingParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override rename(RenameParams params) {
		return requestManager.runRead[ cancelIndicator |
			val uri = params.textDocument.uri.toUri
			val resourceServiceProvider = uri.resourceServiceProvider
			val renameService = resourceServiceProvider?.get(IRenameService)
			if (renameService === null)
				return new WorkspaceEdit
			renameService.rename(workspaceManager, params, cancelIndicator)
		]
	}
	
	override notify(String method, Object parameter) {
		for (endpoint : extensionProviders.get(method)) {
			try {
				endpoint.notify(method, parameter)
			} catch (UnsupportedOperationException e) {
				if (e !== ILanguageServerExtension.NOT_HANDLED_EXCEPTION) {
					throw e
				}
			}
		}
	}
	
	override request(String method, Object parameter) {
		if (!extensionProviders.containsKey(method)) {
			throw new UnsupportedOperationException("The json request '"+method+"' is unknown.")
		}
		for (endpoint : extensionProviders.get(method)) {
			try {
				return endpoint.request(method, parameter)
			} catch (UnsupportedOperationException e) {
				if (e !== ILanguageServerExtension.NOT_HANDLED_EXCEPTION) {
					throw e
				}
			}
		}
	}
	
	
	Map<String, JsonRpcMethod> supportedMethods = null
	Multimap<String, Endpoint> extensionProviders = LinkedListMultimap.create
	
	override supportedMethods() {
		if (this.supportedMethods !== null) {
			return this.supportedMethods
		}
		synchronized (extensionProviders) {
			val supportedMethods = <String,JsonRpcMethod>newLinkedHashMap()
			supportedMethods.putAll(ServiceEndpoints.getSupportedMethods(class))
			val extensions = <String,JsonRpcMethod>newLinkedHashMap()
			for (resourceServiceProvider : languagesRegistry.extensionToFactoryMap.values.toSet.filter(IResourceServiceProvider)) {
				val ext = resourceServiceProvider.get(ILanguageServerExtension)
				if (ext !== null) {
					ext.initialize(access)
					val supportedExtensions = if (ext instanceof JsonRpcMethodProvider) {
						ext.supportedMethods
					} else {
						ServiceEndpoints.getSupportedMethods(ext.class)
					}
					for (entry : supportedExtensions.entrySet) {
						if (supportedMethods.containsKey(entry.key)) {
							LOG.error("The json rpc method '"+entry.key+"' can not be an extension as it is already defined in the LSP standard.")
						} else {
							val existing = extensions.put(entry.key, entry.value)
							if (existing !== null && existing != entry.value) {
								LOG.error("An incompatible LSP extension '"+entry.key+"' has already been registered. Using 1 ignoring 2. \n1 : "+existing+" \n2 : "+entry.value)
								extensions.put(entry.key, existing)
							} else {
								val endpoint = ServiceEndpoints.toEndpoint(ext)
								extensionProviders.put(entry.key, endpoint)
								supportedMethods.put(entry.key, entry.value)
							}
						}
					}
				}
			}
			this.supportedMethods = supportedMethods
			return supportedMethods
		}
	}
	
	ILanguageServerAccess access = new ILanguageServerAccess () {
		
		override <T> doRead(String uri, Function<Context, T> function) {
				requestManager.runRead [ cancelIndicator |
					workspaceManager.doRead(uri.toUri) [ document, resource |
						val ctx = new Context(resource, document, workspaceManager.isDocumentOpen(resource.URI), cancelIndicator)
						return function.apply(ctx)
					]
				]
		}
		
		override addBuildListener(IBuildListener listener) {
			workspaceManager.addBuildListener(listener)
		}
		
		override getLanguageClient() {
			client
		}
		
	}
	
	override afterBuild(List<Delta> deltas) {
		deltas.filter[^new !== null].map[uri.toString].forEach [
				access.<Void>doRead(it) [ ctx |
					if (ctx.documentOpen) {
						if (ctx.resource instanceof XtextResource) {
							// XXX Do the coloring update if the resource has no syntax errors?
							val resource = ctx.resource as XtextResource;
							val serviceProvider = resource.URI.resourceServiceProvider;
							val coloringService = serviceProvider?.get(IColoringService);
							if (coloringService !== null) {
								if (client instanceof LanguageClientExtensions) {
									val doc = ctx.document;
									val coloringInfos = coloringService.getColoring(resource, doc);
									if (!coloringInfos.nullOrEmpty) {
										val uri = resource.URI.toString;
										client.updateColoring(new ColoringParams(uri, coloringInfos));
									}
								}
							}
						}
					}
					semanticHighlightingRegistry.update(ctx);
					return /*void*/ null;
				];
			];
	}

}
