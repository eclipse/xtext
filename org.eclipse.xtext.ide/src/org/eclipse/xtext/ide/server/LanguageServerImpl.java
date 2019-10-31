/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeActionParams;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensOptions;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.lsp4j.ColoringInformation;
import org.eclipse.lsp4j.ColoringParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionOptions;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.DidChangeConfigurationParams;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DidSaveTextDocumentParams;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentOnTypeFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.DocumentSymbolCapabilities;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.ExecuteCommandCapabilities;
import org.eclipse.lsp4j.ExecuteCommandOptions;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.InitializedParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.RenameCapabilities;
import org.eclipse.lsp4j.RenameOptions;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.SemanticHighlightingServerCapabilities;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureHelpOptions;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.WorkspaceSymbolParams;
import org.eclipse.lsp4j.jsonrpc.Endpoint;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethod;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethodProvider;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.services.LanguageClientExtensions;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.BuildManager.Buildable;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2;
import org.eclipse.xtext.ide.server.codelens.ICodeLensResolver;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.ide.server.coloring.IColoringService;
import org.eclipse.xtext.ide.server.commands.ExecutableCommandRegistry;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;
import org.eclipse.xtext.ide.server.findReferences.WorkspaceResourceAccess;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.ide.server.hover.IHoverService;
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService;
import org.eclipse.xtext.ide.server.rename.IRenameService;
import org.eclipse.xtext.ide.server.rename.IRenameService2;
import org.eclipse.xtext.ide.server.semanticHighlight.SemanticHighlightingRegistry;
import org.eclipse.xtext.ide.server.signatureHelp.ISignatureHelpService;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService;
import org.eclipse.xtext.ide.server.symbol.IDocumentSymbolService;
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.util.BufferedCancelIndicator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Objects;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings({ "deprecation" })
public class LanguageServerImpl implements LanguageServer, WorkspaceService, TextDocumentService, LanguageClientAware,
		Endpoint, JsonRpcMethodProvider, ILanguageServerAccess.IBuildListener {

	private static final Logger LOG = Logger.getLogger(LanguageServerImpl.class);

	@Inject
	private RequestManager requestManager;

	@Inject
	private WorkspaceSymbolService workspaceSymbolService;

	@Inject
	private UriExtensions uriExtensions;

	@Inject
	private IResourceServiceProvider.Registry languagesRegistry;

	@Inject
	private ExecutableCommandRegistry commandRegistry;

	@Inject
	private SemanticHighlightingRegistry semanticHighlightingRegistry;

	@Inject
	private ILanguageServerShutdownAndExitHandler shutdownAndExitHandler;

	private WorkspaceManager workspaceManager;

	private InitializeParams initializeParams;

	private InitializeResult initializeResult;

	private WorkspaceResourceAccess resourceAccess;

	private LanguageClient client;

	private Map<String, JsonRpcMethod> supportedMethods;
	
	private final CompletableFuture<InitializedParams> initialized = new CompletableFuture<>();

	private final Multimap<String, Endpoint> extensionProviders = LinkedListMultimap.create();

	@Inject
	public void setWorkspaceManager(WorkspaceManager manager) {
		workspaceManager = manager;
		resourceAccess = new WorkspaceResourceAccess(workspaceManager);
	}

	private Set<? extends IResourceServiceProvider> getAllLanguages() {
		// provide a stable order
		Map<String, IResourceServiceProvider> sorted = new TreeMap<>();
		for (String ext : languagesRegistry.getExtensionToFactoryMap().keySet()) {
			sorted.put(ext, languagesRegistry.getResourceServiceProvider(URI.createURI("synth:///file." + ext)));
		}
		return ImmutableSet.copyOf(sorted.values());
	}

	@Override
	public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
		if (initializeParams != null) {
			throw new IllegalStateException("This language server has already been initialized.");
		}
		URI baseDir = getBaseDir(params);
		if (languagesRegistry.getExtensionToFactoryMap().isEmpty()) {
			throw new IllegalStateException(
					"No Xtext languages have been registered. Please make sure you have added the languages\'s setup class in \'/META-INF/services/org.eclipse.xtext.ISetup\'");
		}
		initializeParams = params;

		InitializeResult result = new InitializeResult();

		result.setCapabilities(createServerCapabilities(params));
		access.addBuildListener(this);
		return requestManager.runWrite(() -> {
			workspaceManager.initialize(baseDir, this::publishDiagnostics, CancelIndicator.NullImpl);
			return result;
		}, (cancelIndicator, it) -> it).thenApply(it -> initializeResult = it);
	}

	/**
	 * Configure the server capabilities for this instance.
	 *
	 * @param params
	 *            the initialization parametrs
	 * @return the server capabilities
	 * @since 2.20
	 */
	protected ServerCapabilities createServerCapabilities(InitializeParams params) {
		ServerCapabilities serverCapabilities = new ServerCapabilities();
		serverCapabilities.setHoverProvider(true);
		serverCapabilities.setDefinitionProvider(true);
		serverCapabilities.setReferencesProvider(true);
		serverCapabilities.setDocumentSymbolProvider(true);
		serverCapabilities.setWorkspaceSymbolProvider(true);
		Set<? extends IResourceServiceProvider> allLanguages = getAllLanguages();
		if (allLanguages.stream().anyMatch((serviceProvider) -> serviceProvider.get(ICodeLensService.class) != null)) {
			CodeLensOptions codeLensOptions = new CodeLensOptions();
			codeLensOptions.setResolveProvider(allLanguages.stream()
					.anyMatch((serviceProvider) -> serviceProvider.get(ICodeLensResolver.class) != null));
			serverCapabilities.setCodeLensProvider(codeLensOptions);
		}
		serverCapabilities.setCodeActionProvider(allLanguages.stream()
				.anyMatch((serviceProvider) -> serviceProvider.get(ICodeActionService.class) != null
						|| serviceProvider.get(ICodeActionService2.class) != null));

		serverCapabilities.setSignatureHelpProvider(new SignatureHelpOptions(ImmutableList.of("(", ",")));
		serverCapabilities.setTextDocumentSync(TextDocumentSyncKind.Incremental);
		CompletionOptions completionOptions = new CompletionOptions();
		completionOptions.setResolveProvider(false);
		completionOptions.setTriggerCharacters(ImmutableList.of("."));
		serverCapabilities.setCompletionProvider(completionOptions);
		serverCapabilities.setDocumentFormattingProvider(true);
		serverCapabilities.setDocumentRangeFormattingProvider(true);
		serverCapabilities.setDocumentHighlightProvider(true);
		ClientCapabilities clientCapabilities = null;
		if (params != null) {
			clientCapabilities = params.getCapabilities();
		}
		TextDocumentClientCapabilities textDocument = null;
		if (clientCapabilities != null) {
			textDocument = clientCapabilities.getTextDocument();
		}
		RenameCapabilities rename = null;
		if (textDocument != null) {
			rename = textDocument.getRename();
		}
		Boolean prepareSupport = null;
		if (rename != null) {
			prepareSupport = rename.getPrepareSupport();
		}
		boolean clientPrepareSupport = Objects.equal(Boolean.TRUE, prepareSupport);
		if (clientPrepareSupport && allLanguages.stream()
				.anyMatch(serviceProvider -> serviceProvider.get(IRenameService2.class) != null)) {
			RenameOptions renameOptions = new RenameOptions();
			renameOptions.setPrepareProvider(true);
			serverCapabilities.setRenameProvider(Either.<Boolean, RenameOptions>forRight(renameOptions));
		} else {
			serverCapabilities.setRenameProvider(Either.forLeft(allLanguages.stream()
					.anyMatch((serviceProvider) -> serviceProvider.get(IRenameService.class) != null
							|| serviceProvider.get(IRenameService2.class) != null)));
		}
		WorkspaceClientCapabilities workspace = null;
		if (clientCapabilities != null) {
			workspace = clientCapabilities.getWorkspace();
		}
		ExecuteCommandCapabilities executeCommand = null;
		if (workspace != null) {
			executeCommand = workspace.getExecuteCommand();
		}
		if (executeCommand != null) {
			commandRegistry.initialize(allLanguages, clientCapabilities, client);
			ExecuteCommandOptions executeCommandOptions = new ExecuteCommandOptions();
			executeCommandOptions.setCommands(commandRegistry.getCommands());
			serverCapabilities.setExecuteCommandProvider(executeCommandOptions);
		}
		semanticHighlightingRegistry.initialize(allLanguages, clientCapabilities, client);
		serverCapabilities.setSemanticHighlighting(
				new SemanticHighlightingServerCapabilities(semanticHighlightingRegistry.getAllScopes()));

		for (IResourceServiceProvider language : allLanguages) {
			ICapabilitiesContributor capabilitiesContributor = language.get(ICapabilitiesContributor.class);
			if (capabilitiesContributor != null) {
				capabilitiesContributor.contribute(serverCapabilities, params);
			}
		}
		return serverCapabilities;
	}

	@Override
	public void initialized(InitializedParams params) {
		initialized.complete(params);
	}

	@Deprecated
	private URI deprecatedToBaseDir(InitializeParams params) {
		String rootPath = params.getRootPath();
		if (rootPath != null) {
			return uriExtensions.toUri(uriExtensions.toUriString(URI.createFileURI(rootPath)));
		}
		return null;
	}

	/**
	 * Compute the base dir.
	 */
	protected URI getBaseDir(InitializeParams params) {
		String rootUri = params.getRootUri();
		if (rootUri != null) {
			return uriExtensions.toUri(rootUri);
		}
		return deprecatedToBaseDir(params);
	}

	@Override
	public void connect(LanguageClient client) {
		this.client = client;
	}

	@Override
	public void exit() {
		shutdownAndExitHandler.exit();
	}

	@Override
	public CompletableFuture<Object> shutdown() {
		shutdownAndExitHandler.shutdown();
		return CompletableFuture.completedFuture(new Object());
	}

	@Override
	public TextDocumentService getTextDocumentService() {
		return this;
	}

	@Override
	public WorkspaceService getWorkspaceService() {
		return this;
	}

	@Override
	public void didOpen(DidOpenTextDocumentParams params) {
		runBuildable(() -> toBuildable(params));
	}

	/**
	 * Evaluate the params and deduce the respective build command.
	 * @since 2.20
	 */
	protected Buildable toBuildable(DidOpenTextDocumentParams params) {
		TextDocumentItem textDocument = params.getTextDocument();
		return workspaceManager.didOpen(getURI(textDocument), textDocument.getVersion(), textDocument.getText());
	}

	@Override
	public void didChange(DidChangeTextDocumentParams params) {
		runBuildable(() -> toBuildable(params));
	}

	/**
	 * Evaluate the params and deduce the respective build command.
	 */
	protected Buildable toBuildable(DidChangeTextDocumentParams params) {
		VersionedTextDocumentIdentifier textDocument = params.getTextDocument();
		return workspaceManager.didChangeTextDocumentContent(getURI(textDocument), textDocument.getVersion(),
				params.getContentChanges());
	}

	@Override
	public void didClose(DidCloseTextDocumentParams params) {
		runBuildable(() -> toBuildable(params));
	}

	/**
	 * Evaluate the params and deduce the respective build command.
	 */
	protected Buildable toBuildable(DidCloseTextDocumentParams params) {
		return workspaceManager.didClose(getURI(params.getTextDocument()));
	}

	@Override
	public void didSave(DidSaveTextDocumentParams params) {
		// nothing to do
	}

	@Override
	public void didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
		runBuildable(() -> toBuildable(params));
	}

	/**
	 * Evaluate the params and deduce the respective build command.
	 */
	protected Buildable toBuildable(DidChangeWatchedFilesParams params) {
		List<URI> dirtyFiles = new ArrayList<>();
		List<URI> deletedFiles = new ArrayList<>();
		params.getChanges().stream()
				.map((fileEvent) -> Pair.of(uriExtensions.toUri(fileEvent.getUri()), fileEvent.getType()))
				.filter(pair -> !workspaceManager.isDocumentOpen(pair.getKey())).forEach(pair -> {
					if (pair.getValue() == FileChangeType.Deleted) {
						deletedFiles.add(pair.getKey());
					} else {
						dirtyFiles.add(pair.getKey());
					}
				});
		return workspaceManager.didChangeFiles(dirtyFiles, deletedFiles);
	}

	/**
	 * Compute a buildable and run the build in a write action
	 *
	 * @param newBuildable
	 *            the factory for the buildable.
	 * @since 2.20
	 */
	protected void runBuildable(Supplier<? extends Buildable> newBuildable) {
		requestManager.runWrite(newBuildable::get, (cancelIndicator, buildable) -> buildable.build(cancelIndicator));
	}

	@Override
	public void didChangeConfiguration(DidChangeConfigurationParams params) {
		requestManager.runWrite(() -> {
			workspaceManager.refreshWorkspaceConfig(CancelIndicator.NullImpl);
			return null;
		}, (a, b) -> null);
	}

	private void publishDiagnostics(URI uri, Iterable<? extends Issue> issues) {
		initialized.thenAccept((initParams) -> {
			PublishDiagnosticsParams publishDiagnosticsParams = new PublishDiagnosticsParams();
			publishDiagnosticsParams.setUri(uriExtensions.toUriString(uri));
			// this is not a premature optimization but a trick to handle issues of deleted resources
			if (!issues.iterator().hasNext()) {
				publishDiagnosticsParams.setDiagnostics(Collections.emptyList());
			} else {
				publishDiagnosticsParams.setDiagnostics(
						workspaceManager.doRead(uri, (document, resource) -> toDiagnostics(issues, document)));
			}
			client.publishDiagnostics(publishDiagnosticsParams);
		});
	}

	/**
	 * Convert the given issues to diagnostics. Does not return any issue with severity {@link Severity#IGNORE ignore}
	 * by default.
	 */
	protected List<Diagnostic> toDiagnostics(Iterable<? extends Issue> issues, Document document) {
		List<Diagnostic> result = new ArrayList<>();
		for (Issue issue : issues) {
			if (issue.getSeverity() != Severity.IGNORE) {
				result.add(toDiagnostic(issue, document));
			}
		}
		return result;
	}

	/**
	 * Convert the given issue to a diagnostic.
	 */
	protected Diagnostic toDiagnostic(Issue issue, Document document) {
		Diagnostic result = new Diagnostic();
		result.setCode(issue.getCode());
		result.setMessage(issue.getMessage());
		result.setSeverity(toDiagnosticSeverity(issue.getSeverity()));
		Position start = document.getPosition(issue.getOffset());
		Position end = document.getPosition(issue.getOffset() + issue.getLength());
		result.setRange(new Range(start, end));
		return result;
	}

	/**
	 * Convert the serverity to a lsp {@link DiagnosticSeverity}.
	 *
	 * Defaults to severity {@link DiagnosticSeverity#Hint hint}.
	 */
	protected DiagnosticSeverity toDiagnosticSeverity(Severity severity) {
		switch (severity) {
		case ERROR:
			return DiagnosticSeverity.Error;
		case IGNORE:
			return DiagnosticSeverity.Hint;
		case INFO:
			return DiagnosticSeverity.Information;
		case WARNING:
			return DiagnosticSeverity.Warning;
		default:
			return DiagnosticSeverity.Hint;
		}
	}

	@Override
	public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams params) {
		return requestManager.runRead((cancelIndicator) -> completion(cancelIndicator, params));
	}

	/**
	 * Compute the completion items.
	 */
	protected Either<List<CompletionItem>, CompletionList> completion(CancelIndicator originalCancelIndicator,
			CompletionParams params) {
		URI uri = getURI(params);
		ContentAssistService contentAssistService = getService(uri, ContentAssistService.class);
		if (contentAssistService == null) {
			return Either.forRight(new CompletionList());
		}
		BufferedCancelIndicator cancelIndicator = new BufferedCancelIndicator(originalCancelIndicator);
		return Either.forRight(workspaceManager.doRead(uri,
				(doc, res) -> contentAssistService.createCompletionList(doc, res, params, cancelIndicator)));
	}

	/**
	 * Obtain the URI from the given parameters.
	 * @since 2.20
	 */
	protected URI getURI(TextDocumentPositionParams params) {
		return getURI(params.getTextDocument());
	}

	/**
	 * Obtain the URI from the given identifier.
	 * @since 2.20
	 */
	protected URI getURI(TextDocumentIdentifier documentIdentifier) {
		return uriExtensions.toUri(documentIdentifier.getUri());
	}

	/**
	 * Obtain the URI from the given document item.
	 * @since 2.20
	 */
	protected URI getURI(TextDocumentItem documentItem) {
		return uriExtensions.toUri(documentItem.getUri());
	}

	@Override
	public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(
			TextDocumentPositionParams params) {
		return requestManager.runRead(cancelIndicator -> definition(params, cancelIndicator));
	}

	/**
	 * Compute the definition. Executed in a read request.
	 * @since 2.20
	 */
	protected Either<List<? extends Location>, List<? extends LocationLink>> definition(
			TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
		return Either.forLeft(definition(cancelIndicator, params));
	}

	/**
	 * Compute the definition.
	 */
	protected List<? extends Location> definition(CancelIndicator cancelIndicator, TextDocumentPositionParams params) {
		URI uri = getURI(params);
		DocumentSymbolService documentSymbolService = getService(uri, DocumentSymbolService.class);
		if (documentSymbolService == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri,
				(doc, res) -> documentSymbolService.getDefinitions(doc, res, params, resourceAccess, cancelIndicator));
	}

	@Override
	public CompletableFuture<List<? extends Location>> references(ReferenceParams params) {
		return requestManager.runRead(cancelIndicator -> references(params, cancelIndicator));
	}

	/**
	 * Compute the references. Executed in read request.
	 * @since 2.20
	 */
	protected List<? extends Location> references(ReferenceParams params, CancelIndicator cancelIndicator) {
		URI uri = getURI(params);
		DocumentSymbolService documentSymbolService = getService(uri, DocumentSymbolService.class);
		if (documentSymbolService == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri, (document, resource) -> documentSymbolService.getReferences(document,
				resource, params, resourceAccess, workspaceManager.getIndex(), cancelIndicator));
	}

	@Override
	public CompletableFuture<List<Either<SymbolInformation, DocumentSymbol>>> documentSymbol(
			DocumentSymbolParams params) {
		return requestManager.runRead((cancelIndicator) -> documentSymbol(params, cancelIndicator));
	}

	/**
	 * Compute the symbol information. Executed in a read request.
	 * @since 2.20
	 */
	protected List<Either<SymbolInformation, DocumentSymbol>> documentSymbol(DocumentSymbolParams params,
			CancelIndicator cancelIndicator) {
		URI uri = getURI(params.getTextDocument());
		IDocumentSymbolService documentSymbolService = getIDocumentSymbolService(getResourceServiceProvider(uri));
		if (documentSymbolService == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri,
				(document, resource) -> documentSymbolService.getSymbols(document, resource, params, cancelIndicator));
	}

	/**
	 * @since 2.16
	 */
	protected IDocumentSymbolService getIDocumentSymbolService(IResourceServiceProvider serviceProvider) {
		if (serviceProvider == null) {
			return null;
		}
		if (isHierarchicalDocumentSymbolSupport()) {
			return serviceProvider.get(HierarchicalDocumentSymbolService.class);
		} else {
			return serviceProvider.get(DocumentSymbolService.class);
		}
	}

	/**
	 * {@code true} if the {@code TextDocumentClientCapabilities} explicitly declares the hierarchical document symbol
	 * support at LS initialization time. Otherwise, false.
	 */
	protected boolean isHierarchicalDocumentSymbolSupport() {
		ClientCapabilities capabilities = initializeParams.getCapabilities();
		if (capabilities == null) {
			return false;
		}
		TextDocumentClientCapabilities textDocument = capabilities.getTextDocument();
		if (textDocument == null) {
			return false;
		}
		DocumentSymbolCapabilities documentSymbol = textDocument.getDocumentSymbol();
		if (documentSymbol == null) {
			return false;
		}
		Boolean hierarchicalDocumentSymbolSupport = documentSymbol.getHierarchicalDocumentSymbolSupport();
		if (hierarchicalDocumentSymbolSupport == null) {
			return false;
		}
		return hierarchicalDocumentSymbolSupport;
	}

	@Override
	public CompletableFuture<List<? extends SymbolInformation>> symbol(WorkspaceSymbolParams params) {
		return requestManager.runRead((cancelIndicator) -> symbol(params, cancelIndicator));
	}

	/**
	 * Compute the symbol information. Executed in a read request.
	 * @since 2.20
	 */
	protected List<? extends SymbolInformation> symbol(WorkspaceSymbolParams params, CancelIndicator cancelIndicator) {
		return workspaceSymbolService.getSymbols(params.getQuery(), resourceAccess, workspaceManager.getIndex(),
				cancelIndicator);
	}

	@Override
	public CompletableFuture<Hover> hover(TextDocumentPositionParams params) {
		return requestManager.runRead((cancelIndicator) -> hover(params, cancelIndicator));
	}

	/**
	 * Compute the hover. Executed in a read request.
	 * @since 2.20
	 */
	protected Hover hover(TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
		URI uri = getURI(params);
		IHoverService hoverService = getService(uri, IHoverService.class);
		if (hoverService == null) {
			return IHoverService.EMPTY_HOVER;
		}
		return workspaceManager.<Hover>doRead(uri,
				(document, resource) -> hoverService.hover(document, resource, params, cancelIndicator));
	}

	@Override
	public CompletableFuture<CompletionItem> resolveCompletionItem(CompletionItem unresolved) {
		return CompletableFuture.<CompletionItem>completedFuture(unresolved);
	}

	@Override
	public CompletableFuture<SignatureHelp> signatureHelp(TextDocumentPositionParams params) {
		return requestManager.runRead((cancelIndicator) -> signatureHelp(params, cancelIndicator));
	}

	/**
	 * Compute the signature help. Executed in a read request.
	 * @since 2.20
	 */
	protected SignatureHelp signatureHelp(TextDocumentPositionParams params, CancelIndicator cancelIndicator) {
		URI uri = getURI(params);
		ISignatureHelpService helper = getService(uri, ISignatureHelpService.class);
		if (helper == null) {
			return ISignatureHelpService.EMPTY;
		}
		return workspaceManager.doRead(uri,
				(doc, resource) -> helper.getSignatureHelp(doc, resource, params, cancelIndicator));
	}

	@Override
	public CompletableFuture<List<? extends DocumentHighlight>> documentHighlight(TextDocumentPositionParams params) {
		return requestManager.runRead((cancelIndicator) -> documentHighlight(params, cancelIndicator));
	}

	/**
	 * Compute the document highlights. Executed in a read request.
	 * @since 2.20
	 */
	protected List<? extends DocumentHighlight> documentHighlight(TextDocumentPositionParams params,
			CancelIndicator cancelIndicator) {
		URI uri = getURI(params);
		IDocumentHighlightService service = getService(uri, IDocumentHighlightService.class);
		if (service == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri,
				(doc, resource) -> service.getDocumentHighlights(doc, resource, params, cancelIndicator));
	}

	@Override
	public CompletableFuture<List<Either<Command, CodeAction>>> codeAction(CodeActionParams params) {
		return requestManager.runRead((cancelIndicator) -> codeAction(params, cancelIndicator));
	}

	/**
	 * Compute the code action commands. Executed in a read request.
	 * @since 2.20
	 */
	protected List<Either<Command, CodeAction>> codeAction(CodeActionParams params, CancelIndicator cancelIndicator) {
		URI uri = getURI(params.getTextDocument());
		IResourceServiceProvider serviceProvider = getResourceServiceProvider(uri);
		ICodeActionService service = getService(serviceProvider, ICodeActionService.class);
		ICodeActionService2 service2 = getService(serviceProvider, ICodeActionService2.class);
		if (service == null && service2 == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri, (doc, resource) -> {
			List<Either<Command, CodeAction>> result = new ArrayList<>();
			if (service != null) {
				List<Either<Command, CodeAction>> actions = service.getCodeActions(doc, resource, params,
						cancelIndicator);
				if (actions != null) {
					result.addAll(actions);
				}
			}
			if (service2 != null) {
				ICodeActionService2.Options options = new ICodeActionService2.Options();
				options.setDocument(doc);
				options.setResource(resource);
				options.setLanguageServerAccess(access);
				options.setCodeActionParams(params);
				options.setCancelIndicator(cancelIndicator);
				List<Either<Command, CodeAction>> actions = service2.getCodeActions(options);
				if (actions != null) {
					result.addAll(actions);
				}
			}
			return result;
		});
	}

	/**
	 * Put the document uri into the data of the given code lenses.
	 */
	protected void installURI(List<? extends CodeLens> codeLenses, String uri) {
		for (CodeLens lens : codeLenses) {
			Object data = lens.getData();
			if (data != null) {
				lens.setData(Arrays.asList(uri, lens.getData()));
			} else {
				lens.setData(uri);
			}
		}
	}

	/**
	 * Remove the document uri from the data of the given code lense.
	 */
	protected URI uninstallURI(CodeLens lens) {
		URI result = null;
		Object data = lens.getData();
		if (data instanceof String) {
			result = URI.createURI(data.toString());
			lens.setData(null);
		} else {
			if (data instanceof List<?>) {
				List<?> l = (List<?>) data;
				result = URI.createURI(l.get(0).toString());
				lens.setData(l.get(1));
			}
		}
		return result;
	}

	@Override
	public CompletableFuture<List<? extends CodeLens>> codeLens(CodeLensParams params) {
		return requestManager.runRead((cancelIndicator) -> codeLens(params, cancelIndicator));
	}

	/**
	 * Compute the code lenses. Executed in a read request.
	 * @since 2.20
	 */
	protected List<? extends CodeLens> codeLens(CodeLensParams params, CancelIndicator cancelIndicator) {
		URI uri = getURI(params.getTextDocument());
		ICodeLensService codeLensService = getService(uri, ICodeLensService.class);
		if (codeLensService == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri, (document, resource) -> {
			List<? extends CodeLens> result = codeLensService.computeCodeLenses(document, resource, params,
					cancelIndicator);
			installURI(result, uri.toString());
			return result;
		});
	}

	@Override
	public CompletableFuture<CodeLens> resolveCodeLens(CodeLens unresolved) {
		URI uri = uninstallURI(unresolved);
		if (uri == null) {
			return CompletableFuture.completedFuture(unresolved);
		}
		return requestManager.runRead((cancelIndicator) -> resolveCodeLens(uri, unresolved, cancelIndicator));
	}

	/**
	 * Resolve the given code lens. Executed in a read request.
	 * @since 2.20
	 */
	protected CodeLens resolveCodeLens(URI uri, CodeLens unresolved, CancelIndicator cancelIndicator) {
		ICodeLensResolver resolver = getService(uri, ICodeLensResolver.class);
		if (resolver == null) {
			return unresolved;
		}
		return workspaceManager.doRead(uri,
				(document, resource) -> resolver.resolveCodeLens(document, resource, unresolved, cancelIndicator));
	}

	@Override
	public CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params) {
		return requestManager.runRead((cancelIndicator) -> formatting(params, cancelIndicator));
	}

	/**
	 * Create the text edits for the formatter. Executed in a read request.
	 * @since 2.20
	 */
	protected List<? extends TextEdit> formatting(DocumentFormattingParams params, CancelIndicator cancelIndicator) {
		URI uri = getURI(params.getTextDocument());
		FormattingService formatterService = getService(uri, FormattingService.class);
		if (formatterService == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri,
				(document, resource) -> formatterService.format(document, resource, params, cancelIndicator));
	}

	@Override
	public CompletableFuture<List<? extends TextEdit>> rangeFormatting(DocumentRangeFormattingParams params) {
		return requestManager.runRead((cancelIndicator) -> rangeFormatting(params, cancelIndicator));
	}

	/**
	 * Create the text edits for the formatter. Executed in a read request.
	 * @since 2.20
	 */
	protected List<? extends TextEdit> rangeFormatting(DocumentRangeFormattingParams params,
			CancelIndicator cancelIndicator) {
		URI uri = getURI(params.getTextDocument());
		FormattingService formatterService = getService(uri, FormattingService.class);
		if (formatterService == null) {
			return Collections.emptyList();
		}
		return workspaceManager.doRead(uri,
				(document, resource) -> formatterService.format(document, resource, params, cancelIndicator));
	}

	/**
	 * @param uri
	 *            the current URI
	 * @param type
	 *            the type of the service
	 * @return the service instance or null if the language does not exist or if it does not expose the service.
	 * @since 2.20
	 */
	protected <Service> Service getService(URI uri, Class<Service> type) {
		return getService(getResourceServiceProvider(uri), type);
	}

	/**
	 * @param <Service>
	 *            the type of the service
	 * @param resourceServiceProvider
	 *            the resource service provider. May be null
	 * @param type
	 *            the type of the service
	 * @return the service instance or null if not available.
	 * @since 2.20
	 */
	protected <Service> Service getService(IResourceServiceProvider resourceServiceProvider, Class<Service> type) {
		if (resourceServiceProvider == null) {
			return null;
		}
		return resourceServiceProvider.get(type);
	}

	@Override
	public CompletableFuture<Object> executeCommand(ExecuteCommandParams params) {
		return requestManager.runRead((cancelIndicator) -> executeCommand(params, cancelIndicator));
	}

	/**
	 * Execute the command. Runs in a read request.
	 * @since 2.20
	 */
	protected Object executeCommand(ExecuteCommandParams params, CancelIndicator cancelIndicator) {
		return commandRegistry.executeCommand(params, access, cancelIndicator);
	}

	@Override
	public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(DocumentOnTypeFormattingParams params) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	@Override
	public CompletableFuture<WorkspaceEdit> rename(RenameParams renameParams) {
		return requestManager.runRead(cancelIndicator -> rename(renameParams, cancelIndicator));
	}

	/**
	 * Compute the rename edits. Executed in a read request.
	 * @since 2.20
	 */
	protected WorkspaceEdit rename(RenameParams renameParams, CancelIndicator cancelIndicator) {
		URI uri = getURI(renameParams.getTextDocument());

		IResourceServiceProvider resourceServiceProvider = getResourceServiceProvider(uri);
		IRenameService renameServiceOld = getService(resourceServiceProvider, IRenameService.class);
		if (renameServiceOld != null) {
			return renameServiceOld.rename(workspaceManager, renameParams, cancelIndicator);
		}
		IRenameService2 renameService2 = getService(resourceServiceProvider, IRenameService2.class);
		if (renameService2 != null) {
			IRenameService2.Options options = new IRenameService2.Options();
			options.setLanguageServerAccess(access);
			options.setRenameParams(renameParams);
			options.setCancelIndicator(cancelIndicator);
			return renameService2.rename(options);
		}
		return new WorkspaceEdit();
	}

	/**
	 * @param uri
	 *            the current URI
	 * @return the resource service provider or null.
	 */
	protected IResourceServiceProvider getResourceServiceProvider(URI uri) {
		return languagesRegistry.getResourceServiceProvider(uri);
	}

	/**
	 * @since 2.18
	 */
	@Override
	public CompletableFuture<Either<Range, PrepareRenameResult>> prepareRename(TextDocumentPositionParams params) {
		return requestManager.runRead(cancelIndicator -> prepareRename(params, cancelIndicator));
	}

	/**
	 * Prepare the rename operation. Executed in a read request.
	 * @since 2.20
	 */
	protected Either<Range, PrepareRenameResult> prepareRename(TextDocumentPositionParams params,
			CancelIndicator cancelIndicator) {
		URI uri = getURI(params);
		IRenameService2 renameService = getService(uri, IRenameService2.class);
		if (renameService == null) {
			throw new UnsupportedOperationException();
		}
		IRenameService2.PrepareRenameOptions options = new IRenameService2.PrepareRenameOptions();
		options.setLanguageServerAccess(access);
		options.setParams(params);
		options.setCancelIndicator(cancelIndicator);
		return renameService.prepareRename(options);
	}

	@Override
	public void notify(String method, Object parameter) {
		for (Endpoint endpoint : extensionProviders.get(method)) {
			try {
				endpoint.notify(method, parameter);
			} catch (UnsupportedOperationException e) {
				if (e != ILanguageServerExtension.NOT_HANDLED_EXCEPTION) {
					throw e;
				}
			}
		}
	}

	@Override
	public CompletableFuture<?> request(String method, Object parameter) {
		if (!extensionProviders.containsKey(method)) {
			throw new UnsupportedOperationException("The json request \'" + method + "\' is unknown.");
		}
		for (Endpoint endpoint : extensionProviders.get(method)) {
			try {
				return endpoint.request(method, parameter);
			} catch (UnsupportedOperationException e) {
				if (e != ILanguageServerExtension.NOT_HANDLED_EXCEPTION) {
					throw e;
				}
			}
		}
		return null;
	}

	@Override
	public Map<String, JsonRpcMethod> supportedMethods() {
		if (supportedMethods != null) {
			return supportedMethods;
		}
		synchronized (extensionProviders) {
			Map<String, JsonRpcMethod> supportedMethods = new LinkedHashMap<>();
			supportedMethods.putAll(ServiceEndpoints.getSupportedMethods(getClass()));

			Map<String, JsonRpcMethod> extensions = new LinkedHashMap<>();
			for (IResourceServiceProvider resourceServiceProvider : getAllLanguages()) {
				ILanguageServerExtension ext = resourceServiceProvider.get(ILanguageServerExtension.class);
				if (ext != null) {
					ext.initialize(access);
					Map<String, JsonRpcMethod> supportedExtensions = ext instanceof JsonRpcMethodProvider
							? ((JsonRpcMethodProvider) ext).supportedMethods()
							: ServiceEndpoints.getSupportedMethods(ext.getClass());
					for (Map.Entry<String, JsonRpcMethod> entry : supportedExtensions.entrySet()) {
						if (supportedMethods.containsKey(entry.getKey())) {
							LOG.error("The json rpc method \'" + entry.getKey()
									+ "\' can not be an extension as it is already defined in the LSP standard.");
						} else {
							JsonRpcMethod existing = extensions.put(entry.getKey(), entry.getValue());
							if (existing != null && !Objects.equal(existing, entry.getValue())) {
								LOG.error("An incompatible LSP extension \'" + entry.getKey()
										+ "\' has already been registered. Using 1 ignoring 2. \n1 : " + existing
										+ " \n2 : " + entry.getValue());
								extensions.put(entry.getKey(), existing);
							} else {
								Endpoint endpoint = ServiceEndpoints.toEndpoint(ext);
								extensionProviders.put(entry.getKey(), endpoint);
								supportedMethods.put(entry.getKey(), entry.getValue());
							}
						}
					}
				}
			}
			this.supportedMethods = supportedMethods;
			return supportedMethods;
		}
	}

	private final ILanguageServerAccess access = new ILanguageServerAccess() {
		@Override
		public <T> CompletableFuture<T> doRead(String uri, Function<ILanguageServerAccess.Context, T> function) {
			return requestManager.runRead(cancelIndicator -> workspaceManager.doRead(uriExtensions.toUri(uri),
					(document, resource) -> function.apply(new ILanguageServerAccess.Context(resource, document,
							workspaceManager.isDocumentOpen(resource.getURI()), cancelIndicator))));
		}

		@Override
		public void addBuildListener(ILanguageServerAccess.IBuildListener listener) {
			workspaceManager.addBuildListener(listener);
		}

		@Override
		public LanguageClient getLanguageClient() {
			return client;
		}

		@Override
		public ResourceSet newLiveScopeResourceSet(URI uri) {
			ProjectManager projectManager = workspaceManager.getProjectManager(uri);
			XtextResourceSet resourceSet = projectManager
					.createNewResourceSet(projectManager.getIndexState().getResourceDescriptions());
			resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, true);
			return resourceSet;
		}

		@Override
		public InitializeParams getInitializeParams() {
			return initializeParams;
		}

		@Override
		public <T> CompletableFuture<T> doReadIndex(
				Function<? super ILanguageServerAccess.IndexContext, ? extends T> function) {
			return requestManager.runRead(cancelIndicator -> function
					.apply(new ILanguageServerAccess.IndexContext(workspaceManager.getIndex(), cancelIndicator)));
		}

		@Override
		public InitializeResult getInitializeResult() {
			return initializeResult;
		}
	};

	@Override
	public void afterBuild(List<IResourceDescription.Delta> deltas) {
		FluentIterable.from(deltas).filter(it -> it.getNew() != null).transform(it -> it.getUri().toString())
				.forEach(it -> {
					access.doRead(it, ctx -> {
						if (ctx.isDocumentOpen()) {
							if (ctx.getResource() instanceof XtextResource) {
								XtextResource resource = (XtextResource) ctx.getResource();
								IColoringService coloringService = resource.getResourceServiceProvider()
										.get(IColoringService.class);
								if (coloringService != null && client instanceof LanguageClientExtensions) {
									Document doc = ctx.getDocument();
									List<? extends ColoringInformation> coloringInfos = coloringService
											.getColoring(resource, doc);
									if (!IterableExtensions.isNullOrEmpty(coloringInfos)) {
										String uri = resource.getURI().toString();
										((LanguageClientExtensions) client)
												.updateColoring(new ColoringParams(uri, coloringInfos));
									}
								}
							}
						}
						semanticHighlightingRegistry.update(ctx);
						return null;
					});
				});
	}

	/**
	 * @since 2.16
	 */
	protected ILanguageServerAccess getLanguageServerAccess() {
		return access;
	}

	/**
	 * @since 2.16
	 */
	protected LanguageClient getLanguageClient() {
		return client;
	}

	/**
	 * @since 2.16
	 */
	protected ExecutableCommandRegistry getCommandRegistry() {
		return commandRegistry;
	}

	/**
	 * @since 2.16
	 */
	protected Multimap<String, Endpoint> getExtensionProviders() {
		return ImmutableMultimap.copyOf(extensionProviders);
	}

	/**
	 * @since 2.16
	 */
	protected Map<String, JsonRpcMethod> getSupportedMethods() {
		return ImmutableMap.copyOf(supportedMethods);
	}

	/**
	 * @since 2.16
	 */
	protected IResourceServiceProvider.Registry getLanguagesRegistry() {
		return languagesRegistry;
	}

	/**
	 * @since 2.16
	 */
	protected IReferenceFinder.IResourceAccess getWorkspaceResourceAccess() {
		return resourceAccess;
	}

	/**
	 * @since 2.16
	 */
	protected WorkspaceManager getWorkspaceManager() {
		return workspaceManager;
	}

	/**
	 * @since 2.16
	 */
	protected WorkspaceSymbolService getWorkspaceSymbolService() {
		return workspaceSymbolService;
	}

	public RequestManager getRequestManager() {
		return requestManager;
	}
}
