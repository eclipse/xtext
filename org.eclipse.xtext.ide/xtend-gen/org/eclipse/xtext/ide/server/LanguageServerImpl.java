/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.ClientCapabilities;
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
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.ExecuteCommandCapabilities;
import org.eclipse.lsp4j.ExecuteCommandOptions;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureHelpOptions;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.TextEdit;
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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ide.server.BuildManager;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ICapabilitiesContributor;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService;
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
import org.eclipse.xtext.ide.server.signatureHelp.ISignatureHelpService;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Log
@SuppressWarnings("all")
public class LanguageServerImpl implements LanguageServer, WorkspaceService, TextDocumentService, LanguageClientAware, Endpoint, JsonRpcMethodProvider, ILanguageServerAccess.IBuildListener {
  @FinalFieldsConstructor
  public static class BufferedCancelIndicator implements CancelIndicator {
    private final CancelIndicator delegate;
    
    private Long canceledSince;
    
    @Override
    public boolean isCanceled() {
      if (((this.canceledSince == null) && this.delegate.isCanceled())) {
        this.canceledSince = Long.valueOf(System.currentTimeMillis());
        return false;
      }
      return ((this.canceledSince != null) && (System.currentTimeMillis() > ((this.canceledSince).longValue() + 1000)));
    }
    
    public BufferedCancelIndicator(final CancelIndicator delegate) {
      super();
      this.delegate = delegate;
    }
  }
  
  @Inject
  @Accessors(AccessorType.PUBLIC_GETTER)
  private RequestManager requestManager;
  
  @Inject
  private WorkspaceSymbolService workspaceSymbolService;
  
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  @Extension
  private IResourceServiceProvider.Registry languagesRegistry;
  
  @Inject
  private ExecutableCommandRegistry commandRegistry;
  
  private WorkspaceManager workspaceManager;
  
  private InitializeParams params;
  
  @Inject
  public void setWorkspaceManager(final WorkspaceManager manager) {
    this.workspaceManager = manager;
    WorkspaceResourceAccess _workspaceResourceAccess = new WorkspaceResourceAccess(this.workspaceManager);
    this.resourceAccess = _workspaceResourceAccess;
  }
  
  private Iterable<? extends IResourceServiceProvider> getAllLanguages() {
    final Function1<String, IResourceServiceProvider> _function = (String ext) -> {
      final URI synthUri = URI.createURI(("synth:///file." + ext));
      return this.languagesRegistry.getResourceServiceProvider(synthUri);
    };
    return ListExtensions.<String, IResourceServiceProvider>map(IterableExtensions.<String>sort(IterableExtensions.<String>toList(this.languagesRegistry.getExtensionToFactoryMap().keySet())), _function);
  }
  
  @Override
  public CompletableFuture<InitializeResult> initialize(final InitializeParams params) {
    if ((this.params != null)) {
      throw new IllegalStateException("This language server has already been initialized.");
    }
    final URI baseDir = this.getBaseDir(params);
    boolean _isEmpty = this.languagesRegistry.getExtensionToFactoryMap().isEmpty();
    if (_isEmpty) {
      throw new IllegalStateException("No Xtext languages have been registered. Please make sure you have added the languages\'s setup class in \'/META-INF/services/org.eclipse.xtext.ISetup\'");
    }
    this.params = params;
    final InitializeResult result = new InitializeResult();
    ServerCapabilities _serverCapabilities = new ServerCapabilities();
    final Procedure1<ServerCapabilities> _function = (ServerCapabilities it) -> {
      it.setHoverProvider(Boolean.valueOf(true));
      it.setDefinitionProvider(Boolean.valueOf(true));
      it.setReferencesProvider(Boolean.valueOf(true));
      it.setDocumentSymbolProvider(Boolean.valueOf(true));
      it.setWorkspaceSymbolProvider(Boolean.valueOf(true));
      final Function1<IResourceServiceProvider, Boolean> _function_1 = (IResourceServiceProvider it_1) -> {
        ICodeLensService _get = it_1.<ICodeLensService>get(ICodeLensService.class);
        return Boolean.valueOf((_get != null));
      };
      boolean _exists = IterableExtensions.exists(this.getAllLanguages(), _function_1);
      if (_exists) {
        CodeLensOptions _codeLensOptions = new CodeLensOptions();
        final Procedure1<CodeLensOptions> _function_2 = (CodeLensOptions it_1) -> {
          final Function1<IResourceServiceProvider, Boolean> _function_3 = (IResourceServiceProvider it_2) -> {
            ICodeLensResolver _get = it_2.<ICodeLensResolver>get(ICodeLensResolver.class);
            return Boolean.valueOf((_get != null));
          };
          it_1.setResolveProvider(IterableExtensions.exists(this.getAllLanguages(), _function_3));
        };
        CodeLensOptions _doubleArrow = ObjectExtensions.<CodeLensOptions>operator_doubleArrow(_codeLensOptions, _function_2);
        it.setCodeLensProvider(_doubleArrow);
      }
      final Function1<IResourceServiceProvider, Boolean> _function_3 = (IResourceServiceProvider it_1) -> {
        ICodeActionService _get = it_1.<ICodeActionService>get(ICodeActionService.class);
        return Boolean.valueOf((_get != null));
      };
      it.setCodeActionProvider(Boolean.valueOf(IterableExtensions.exists(this.getAllLanguages(), _function_3)));
      SignatureHelpOptions _signatureHelpOptions = new SignatureHelpOptions(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("(", ",")));
      it.setSignatureHelpProvider(_signatureHelpOptions);
      it.setTextDocumentSync(TextDocumentSyncKind.Incremental);
      CompletionOptions _completionOptions = new CompletionOptions();
      final Procedure1<CompletionOptions> _function_4 = (CompletionOptions it_1) -> {
        it_1.setResolveProvider(Boolean.valueOf(false));
        it_1.setTriggerCharacters(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(".")));
      };
      CompletionOptions _doubleArrow_1 = ObjectExtensions.<CompletionOptions>operator_doubleArrow(_completionOptions, _function_4);
      it.setCompletionProvider(_doubleArrow_1);
      it.setDocumentFormattingProvider(Boolean.valueOf(true));
      it.setDocumentRangeFormattingProvider(Boolean.valueOf(true));
      it.setDocumentHighlightProvider(Boolean.valueOf(true));
      ClientCapabilities _capabilities = params.getCapabilities();
      WorkspaceClientCapabilities _workspace = null;
      if (_capabilities!=null) {
        _workspace=_capabilities.getWorkspace();
      }
      ExecuteCommandCapabilities _executeCommand = null;
      if (_workspace!=null) {
        _executeCommand=_workspace.getExecuteCommand();
      }
      boolean _tripleNotEquals = (_executeCommand != null);
      if (_tripleNotEquals) {
        this.commandRegistry.initialize(this.getAllLanguages(), params.getCapabilities(), this.client);
        ExecuteCommandOptions _executeCommandOptions = new ExecuteCommandOptions();
        final Procedure1<ExecuteCommandOptions> _function_5 = (ExecuteCommandOptions it_1) -> {
          it_1.setCommands(this.commandRegistry.getCommands());
        };
        ExecuteCommandOptions _doubleArrow_2 = ObjectExtensions.<ExecuteCommandOptions>operator_doubleArrow(_executeCommandOptions, _function_5);
        it.setExecuteCommandProvider(_doubleArrow_2);
      }
    };
    ServerCapabilities capabilities = ObjectExtensions.<ServerCapabilities>operator_doubleArrow(_serverCapabilities, _function);
    Iterable<? extends IResourceServiceProvider> _allLanguages = this.getAllLanguages();
    for (final IResourceServiceProvider language : _allLanguages) {
      ICapabilitiesContributor _get = language.<ICapabilitiesContributor>get(ICapabilitiesContributor.class);
      if (_get!=null) {
        _get.contribute(capabilities, params);
      }
    }
    result.setCapabilities(capabilities);
    this.access.addBuildListener(this);
    final Function0<Object> _function_1 = () -> {
      final Procedure2<URI, Iterable<Issue>> _function_2 = (URI $0, Iterable<Issue> $1) -> {
        this.publishDiagnostics($0, $1);
      };
      this.workspaceManager.initialize(baseDir, _function_2, CancelIndicator.NullImpl);
      return null;
    };
    final Function2<CancelIndicator, Object, Object> _function_2 = (CancelIndicator $0, Object $1) -> {
      return null;
    };
    final Function<Object, InitializeResult> _function_3 = (Object it) -> {
      return result;
    };
    return this.requestManager.<Object, Object>runWrite(_function_1, _function_2).<InitializeResult>thenApply(_function_3);
  }
  
  @Deprecated
  private URI deprecatedToBaseDir(final InitializeParams params) {
    String _rootPath = params.getRootPath();
    boolean _tripleNotEquals = (_rootPath != null);
    if (_tripleNotEquals) {
      return this._uriExtensions.toUri(this._uriExtensions.toPath(URI.createFileURI(params.getRootPath())));
    }
    return null;
  }
  
  protected URI getBaseDir(final InitializeParams params) {
    String _rootUri = params.getRootUri();
    boolean _tripleNotEquals = (_rootUri != null);
    if (_tripleNotEquals) {
      return this._uriExtensions.toUri(params.getRootUri());
    }
    return this.deprecatedToBaseDir(params);
  }
  
  @Override
  public void connect(final LanguageClient client) {
    this.client = client;
  }
  
  @Override
  public void exit() {
  }
  
  @Override
  public CompletableFuture<Object> shutdown() {
    Object _object = new Object();
    return CompletableFuture.<Object>completedFuture(_object);
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
  public void didOpen(final DidOpenTextDocumentParams params) {
    final Function0<BuildManager.Buildable> _function = () -> {
      return this.workspaceManager.didOpen(this._uriExtensions.toUri(params.getTextDocument().getUri()), params.getTextDocument().getVersion(), params.getTextDocument().getText());
    };
    final Function2<CancelIndicator, BuildManager.Buildable, List<IResourceDescription.Delta>> _function_1 = (CancelIndicator cancelIndicator, BuildManager.Buildable buildable) -> {
      return buildable.build(cancelIndicator);
    };
    this.requestManager.<BuildManager.Buildable, List<IResourceDescription.Delta>>runWrite(_function, _function_1);
  }
  
  @Override
  public void didChange(final DidChangeTextDocumentParams params) {
    final Function0<BuildManager.Buildable> _function = () -> {
      final Function1<TextDocumentContentChangeEvent, TextEdit> _function_1 = (TextDocumentContentChangeEvent event) -> {
        Range _range = event.getRange();
        String _text = event.getText();
        return new TextEdit(_range, _text);
      };
      return this.workspaceManager.didChange(this._uriExtensions.toUri(params.getTextDocument().getUri()), params.getTextDocument().getVersion(), ListExtensions.<TextDocumentContentChangeEvent, TextEdit>map(params.getContentChanges(), _function_1));
    };
    final Function2<CancelIndicator, BuildManager.Buildable, List<IResourceDescription.Delta>> _function_1 = (CancelIndicator cancelIndicator, BuildManager.Buildable buildable) -> {
      return buildable.build(cancelIndicator);
    };
    this.requestManager.<BuildManager.Buildable, List<IResourceDescription.Delta>>runWrite(_function, _function_1);
  }
  
  @Override
  public void didClose(final DidCloseTextDocumentParams params) {
    final Function0<BuildManager.Buildable> _function = () -> {
      return this.workspaceManager.didClose(this._uriExtensions.toUri(params.getTextDocument().getUri()));
    };
    final Function2<CancelIndicator, BuildManager.Buildable, List<IResourceDescription.Delta>> _function_1 = (CancelIndicator cancelIndicator, BuildManager.Buildable buildable) -> {
      return buildable.build(cancelIndicator);
    };
    this.requestManager.<BuildManager.Buildable, List<IResourceDescription.Delta>>runWrite(_function, _function_1);
  }
  
  @Override
  public void didSave(final DidSaveTextDocumentParams params) {
  }
  
  @Override
  public void didChangeWatchedFiles(final DidChangeWatchedFilesParams params) {
    final Function0<BuildManager.Buildable> _function = () -> {
      BuildManager.Buildable _xblockexpression = null;
      {
        final ArrayList<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
        final ArrayList<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
        List<FileEvent> _changes = params.getChanges();
        for (final FileEvent fileEvent : _changes) {
          FileChangeType _type = fileEvent.getType();
          boolean _tripleEquals = (_type == FileChangeType.Deleted);
          if (_tripleEquals) {
            URI _uri = this._uriExtensions.toUri(fileEvent.getUri());
            deletedFiles.add(_uri);
          } else {
            URI _uri_1 = this._uriExtensions.toUri(fileEvent.getUri());
            dirtyFiles.add(_uri_1);
          }
        }
        _xblockexpression = this.workspaceManager.didChangeFiles(dirtyFiles, deletedFiles);
      }
      return _xblockexpression;
    };
    final Function2<CancelIndicator, BuildManager.Buildable, List<IResourceDescription.Delta>> _function_1 = (CancelIndicator cancelIndicator, BuildManager.Buildable buildable) -> {
      return buildable.build(cancelIndicator);
    };
    this.requestManager.<BuildManager.Buildable, List<IResourceDescription.Delta>>runWrite(_function, _function_1);
  }
  
  @Override
  public void didChangeConfiguration(final DidChangeConfigurationParams params) {
    final Function0<Object> _function = () -> {
      this.workspaceManager.refreshWorkspaceConfig(CancelIndicator.NullImpl);
      return null;
    };
    final Function2<CancelIndicator, Object, Object> _function_1 = (CancelIndicator $0, Object $1) -> {
      return null;
    };
    this.requestManager.<Object, Object>runWrite(_function, _function_1);
  }
  
  private WorkspaceResourceAccess resourceAccess;
  
  private LanguageClient client;
  
  private void publishDiagnostics(final URI uri, final Iterable<? extends Issue> issues) {
    PublishDiagnosticsParams _publishDiagnosticsParams = new PublishDiagnosticsParams();
    final Procedure1<PublishDiagnosticsParams> _function = (PublishDiagnosticsParams it) -> {
      it.setUri(this._uriExtensions.toPath(uri));
      final Function1<Issue, Diagnostic> _function_1 = (Issue it_1) -> {
        return this.toDiagnostic(it_1);
      };
      it.setDiagnostics(IterableExtensions.<Diagnostic>toList(IterableExtensions.map(issues, _function_1)));
    };
    final PublishDiagnosticsParams diagnostics = ObjectExtensions.<PublishDiagnosticsParams>operator_doubleArrow(_publishDiagnosticsParams, _function);
    this.client.publishDiagnostics(diagnostics);
  }
  
  private Diagnostic toDiagnostic(final Issue issue) {
    Diagnostic _diagnostic = new Diagnostic();
    final Procedure1<Diagnostic> _function = (Diagnostic it) -> {
      it.setCode(issue.getCode());
      DiagnosticSeverity _switchResult = null;
      Severity _severity = issue.getSeverity();
      if (_severity != null) {
        switch (_severity) {
          case ERROR:
            _switchResult = DiagnosticSeverity.Error;
            break;
          case WARNING:
            _switchResult = DiagnosticSeverity.Warning;
            break;
          case INFO:
            _switchResult = DiagnosticSeverity.Information;
            break;
          default:
            _switchResult = DiagnosticSeverity.Hint;
            break;
        }
      } else {
        _switchResult = DiagnosticSeverity.Hint;
      }
      it.setSeverity(_switchResult);
      it.setMessage(issue.getMessage());
      Integer _elvis = null;
      Integer _lineNumber = issue.getLineNumber();
      if (_lineNumber != null) {
        _elvis = _lineNumber;
      } else {
        _elvis = Integer.valueOf(1);
      }
      final int lineNumber = ((_elvis).intValue() - 1);
      Integer _elvis_1 = null;
      Integer _column = issue.getColumn();
      if (_column != null) {
        _elvis_1 = _column;
      } else {
        _elvis_1 = Integer.valueOf(1);
      }
      final int column = ((_elvis_1).intValue() - 1);
      Integer _elvis_2 = null;
      Integer _length = issue.getLength();
      if (_length != null) {
        _elvis_2 = _length;
      } else {
        _elvis_2 = Integer.valueOf(0);
      }
      final Integer length = _elvis_2;
      Position _position = new Position(lineNumber, column);
      Position _position_1 = new Position(lineNumber, (column + (length).intValue()));
      Range _range = new Range(_position, _position_1);
      it.setRange(_range);
    };
    return ObjectExtensions.<Diagnostic>operator_doubleArrow(_diagnostic, _function);
  }
  
  @Override
  public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, Either<List<CompletionItem>, CompletionList>> _function = (CancelIndicator origialCancelIndicator) -> {
      return this.completion(origialCancelIndicator, params);
    };
    return this.requestManager.<Either<List<CompletionItem>, CompletionList>>runRead(_function);
  }
  
  protected Either<List<CompletionItem>, CompletionList> completion(final CancelIndicator origialCancelIndicator, final TextDocumentPositionParams params) {
    final LanguageServerImpl.BufferedCancelIndicator cancelIndicator = new LanguageServerImpl.BufferedCancelIndicator(origialCancelIndicator);
    final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
    final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
    ContentAssistService _get = null;
    if (resourceServiceProvider!=null) {
      _get=resourceServiceProvider.<ContentAssistService>get(ContentAssistService.class);
    }
    final ContentAssistService contentAssistService = _get;
    if ((contentAssistService == null)) {
      CompletionList _completionList = new CompletionList();
      return Either.<List<CompletionItem>, CompletionList>forRight(_completionList);
    }
    final Function2<Document, XtextResource, CompletionList> _function = (Document document, XtextResource resource) -> {
      return contentAssistService.createCompletionList(document, resource, params, cancelIndicator);
    };
    final CompletionList completionList = this.workspaceManager.<CompletionList>doRead(uri, _function);
    return Either.<List<CompletionItem>, CompletionList>forRight(completionList);
  }
  
  @Override
  public CompletableFuture<List<? extends Location>> definition(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, List<? extends Location>> _function = (CancelIndicator cancelIndicator) -> {
      return this.definition(cancelIndicator, params);
    };
    return this.requestManager.<List<? extends Location>>runRead(_function);
  }
  
  protected List<? extends Location> definition(final CancelIndicator cancelIndicator, final TextDocumentPositionParams params) {
    final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
    final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
    DocumentSymbolService _get = null;
    if (resourceServiceProvider!=null) {
      _get=resourceServiceProvider.<DocumentSymbolService>get(DocumentSymbolService.class);
    }
    final DocumentSymbolService documentSymbolService = _get;
    if ((documentSymbolService == null)) {
      return CollectionLiterals.<Location>emptyList();
    }
    final Function2<Document, XtextResource, List<? extends Location>> _function = (Document document, XtextResource resource) -> {
      return documentSymbolService.getDefinitions(document, resource, params, this.resourceAccess, cancelIndicator);
    };
    return this.workspaceManager.<List<? extends Location>>doRead(uri, _function);
  }
  
  @Override
  public CompletableFuture<List<? extends Location>> references(final ReferenceParams params) {
    final Function1<CancelIndicator, List<? extends Location>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      DocumentSymbolService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<DocumentSymbolService>get(DocumentSymbolService.class);
      }
      final DocumentSymbolService documentSymbolService = _get;
      if ((documentSymbolService == null)) {
        return CollectionLiterals.<Location>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends Location>> _function_1 = (Document document, XtextResource resource) -> {
        return documentSymbolService.getReferences(document, resource, params, this.resourceAccess, this.workspaceManager.getIndex(), cancelIndicator);
      };
      return this.workspaceManager.<List<? extends Location>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends Location>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends SymbolInformation>> documentSymbol(final DocumentSymbolParams params) {
    final Function1<CancelIndicator, List<? extends SymbolInformation>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      DocumentSymbolService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<DocumentSymbolService>get(DocumentSymbolService.class);
      }
      final DocumentSymbolService documentSymbolService = _get;
      if ((documentSymbolService == null)) {
        return CollectionLiterals.<SymbolInformation>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends SymbolInformation>> _function_1 = (Document document, XtextResource resource) -> {
        return documentSymbolService.getSymbols(document, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<List<? extends SymbolInformation>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends SymbolInformation>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends SymbolInformation>> symbol(final WorkspaceSymbolParams params) {
    final Function1<CancelIndicator, List<? extends SymbolInformation>> _function = (CancelIndicator cancelIndicator) -> {
      final IResourceDescriptions indexData = this.workspaceManager.getIndex();
      return this.workspaceSymbolService.getSymbols(params.getQuery(), this.resourceAccess, indexData, cancelIndicator);
    };
    return this.requestManager.<List<? extends SymbolInformation>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<Hover> hover(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, Hover> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      IHoverService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<IHoverService>get(IHoverService.class);
      }
      final IHoverService hoverService = _get;
      if ((hoverService == null)) {
        return IHoverService.EMPTY_HOVER;
      }
      final Function2<Document, XtextResource, Hover> _function_1 = (Document document, XtextResource resource) -> {
        return hoverService.hover(document, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<Hover>doRead(uri, _function_1);
    };
    return this.requestManager.<Hover>runRead(_function);
  }
  
  @Override
  public CompletableFuture<CompletionItem> resolveCompletionItem(final CompletionItem unresolved) {
    return CompletableFuture.<CompletionItem>completedFuture(unresolved);
  }
  
  @Override
  public CompletableFuture<SignatureHelp> signatureHelp(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, SignatureHelp> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider serviceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      ISignatureHelpService _get = null;
      if (serviceProvider!=null) {
        _get=serviceProvider.<ISignatureHelpService>get(ISignatureHelpService.class);
      }
      final ISignatureHelpService helper = _get;
      if ((helper == null)) {
        return ISignatureHelpService.EMPTY;
      }
      final Function2<Document, XtextResource, SignatureHelp> _function_1 = (Document doc, XtextResource resource) -> {
        return helper.getSignatureHelp(doc, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<SignatureHelp>doRead(uri, _function_1);
    };
    return this.requestManager.<SignatureHelp>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends DocumentHighlight>> documentHighlight(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, List<? extends DocumentHighlight>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider serviceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      IDocumentHighlightService _get = null;
      if (serviceProvider!=null) {
        _get=serviceProvider.<IDocumentHighlightService>get(IDocumentHighlightService.class);
      }
      final IDocumentHighlightService service = _get;
      if ((service == null)) {
        return CollectionLiterals.<DocumentHighlight>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends DocumentHighlight>> _function_1 = (Document doc, XtextResource resource) -> {
        return service.getDocumentHighlights(doc, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<List<? extends DocumentHighlight>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends DocumentHighlight>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends Command>> codeAction(final CodeActionParams params) {
    final Function1<CancelIndicator, List<? extends Command>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider serviceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      ICodeActionService _get = null;
      if (serviceProvider!=null) {
        _get=serviceProvider.<ICodeActionService>get(ICodeActionService.class);
      }
      final ICodeActionService service = _get;
      if ((service == null)) {
        return CollectionLiterals.<Command>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends Command>> _function_1 = (Document doc, XtextResource resource) -> {
        return service.getCodeActions(doc, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<List<? extends Command>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends Command>>runRead(_function);
  }
  
  private void installURI(final List<? extends CodeLens> codeLenses, final String uri) {
    for (final CodeLens lens : codeLenses) {
      Object _data = lens.getData();
      boolean _tripleNotEquals = (_data != null);
      if (_tripleNotEquals) {
        lens.setData(CollectionLiterals.<Object>newArrayList(uri, lens.getData()));
      } else {
        lens.setData(uri);
      }
    }
  }
  
  private URI uninstallURI(final CodeLens lens) {
    URI result = null;
    Object _data = lens.getData();
    if ((_data instanceof String)) {
      result = URI.createURI(lens.getData().toString());
      lens.setData(null);
    } else {
      Object _data_1 = lens.getData();
      if ((_data_1 instanceof List<?>)) {
        Object _data_2 = lens.getData();
        final List<?> l = ((List<?>) _data_2);
        result = URI.createURI(IterableExtensions.head(l).toString());
        lens.setData(l.get(1));
      }
    }
    return result;
  }
  
  @Override
  public CompletableFuture<List<? extends CodeLens>> codeLens(final CodeLensParams params) {
    final Function1<CancelIndicator, List<? extends CodeLens>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      ICodeLensService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<ICodeLensService>get(ICodeLensService.class);
      }
      final ICodeLensService codeLensService = _get;
      if ((codeLensService == null)) {
        return CollectionLiterals.<CodeLens>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends CodeLens>> _function_1 = (Document document, XtextResource resource) -> {
        final List<? extends CodeLens> result = codeLensService.computeCodeLenses(document, resource, params, cancelIndicator);
        this.installURI(result, uri.toString());
        return result;
      };
      return this.workspaceManager.<List<? extends CodeLens>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends CodeLens>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<CodeLens> resolveCodeLens(final CodeLens unresolved) {
    final URI uri = this.uninstallURI(unresolved);
    if ((uri == null)) {
      return CompletableFuture.<CodeLens>completedFuture(unresolved);
    }
    final Function1<CancelIndicator, CodeLens> _function = (CancelIndicator cancelIndicator) -> {
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      ICodeLensResolver _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<ICodeLensResolver>get(ICodeLensResolver.class);
      }
      final ICodeLensResolver resolver = _get;
      if ((resolver == null)) {
        return unresolved;
      }
      final Function2<Document, XtextResource, CodeLens> _function_1 = (Document document, XtextResource resource) -> {
        final CodeLens result = resolver.resolveCodeLens(document, resource, unresolved, cancelIndicator);
        return result;
      };
      return this.workspaceManager.<CodeLens>doRead(uri, _function_1);
    };
    return this.requestManager.<CodeLens>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends TextEdit>> formatting(final DocumentFormattingParams params) {
    final Function1<CancelIndicator, List<? extends TextEdit>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      FormattingService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<FormattingService>get(FormattingService.class);
      }
      final FormattingService formatterService = _get;
      if ((formatterService == null)) {
        return CollectionLiterals.<TextEdit>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends TextEdit>> _function_1 = (Document document, XtextResource resource) -> {
        return formatterService.format(document, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<List<? extends TextEdit>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends TextEdit>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends TextEdit>> rangeFormatting(final DocumentRangeFormattingParams params) {
    final Function1<CancelIndicator, List<? extends TextEdit>> _function = (CancelIndicator cancelIndicator) -> {
      final URI uri = this._uriExtensions.toUri(params.getTextDocument().getUri());
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      FormattingService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<FormattingService>get(FormattingService.class);
      }
      final FormattingService formatterService = _get;
      if ((formatterService == null)) {
        return CollectionLiterals.<TextEdit>emptyList();
      }
      final Function2<Document, XtextResource, List<? extends TextEdit>> _function_1 = (Document document, XtextResource resource) -> {
        return formatterService.format(document, resource, params, cancelIndicator);
      };
      return this.workspaceManager.<List<? extends TextEdit>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends TextEdit>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<Object> executeCommand(final ExecuteCommandParams params) {
    final Function1<CancelIndicator, Object> _function = (CancelIndicator cancelIndicator) -> {
      return this.commandRegistry.executeCommand(params, this.access, cancelIndicator);
    };
    return this.requestManager.<Object>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(final DocumentOnTypeFormattingParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletableFuture<WorkspaceEdit> rename(final RenameParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void notify(final String method, final Object parameter) {
    Collection<Endpoint> _get = this.extensionProviders.get(method);
    for (final Endpoint endpoint : _get) {
      try {
        endpoint.notify(method, parameter);
      } catch (final Throwable _t) {
        if (_t instanceof UnsupportedOperationException) {
          final UnsupportedOperationException e = (UnsupportedOperationException)_t;
          if ((e != ILanguageServerExtension.NOT_HANDLED_EXCEPTION)) {
            throw e;
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  @Override
  public CompletableFuture<?> request(final String method, final Object parameter) {
    boolean _containsKey = this.extensionProviders.containsKey(method);
    boolean _not = (!_containsKey);
    if (_not) {
      throw new UnsupportedOperationException((("The json request \'" + method) + "\' is unknown."));
    }
    Collection<Endpoint> _get = this.extensionProviders.get(method);
    for (final Endpoint endpoint : _get) {
      try {
        return endpoint.request(method, parameter);
      } catch (final Throwable _t) {
        if (_t instanceof UnsupportedOperationException) {
          final UnsupportedOperationException e = (UnsupportedOperationException)_t;
          if ((e != ILanguageServerExtension.NOT_HANDLED_EXCEPTION)) {
            throw e;
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return null;
  }
  
  private Map<String, JsonRpcMethod> supportedMethods = null;
  
  private Multimap<String, Endpoint> extensionProviders = LinkedListMultimap.<String, Endpoint>create();
  
  @Override
  public Map<String, JsonRpcMethod> supportedMethods() {
    if ((this.supportedMethods != null)) {
      return this.supportedMethods;
    }
    synchronized (this.extensionProviders) {
      final LinkedHashMap<String, JsonRpcMethod> supportedMethods = CollectionLiterals.<String, JsonRpcMethod>newLinkedHashMap();
      supportedMethods.putAll(ServiceEndpoints.getSupportedMethods(this.getClass()));
      final LinkedHashMap<String, JsonRpcMethod> extensions = CollectionLiterals.<String, JsonRpcMethod>newLinkedHashMap();
      Iterable<IResourceServiceProvider> _filter = Iterables.<IResourceServiceProvider>filter(IterableExtensions.<Object>toSet(this.languagesRegistry.getExtensionToFactoryMap().values()), IResourceServiceProvider.class);
      for (final IResourceServiceProvider resourceServiceProvider : _filter) {
        {
          final ILanguageServerExtension ext = resourceServiceProvider.<ILanguageServerExtension>get(ILanguageServerExtension.class);
          if ((ext != null)) {
            ext.initialize(this.access);
            Map<String, JsonRpcMethod> _xifexpression = null;
            if ((ext instanceof JsonRpcMethodProvider)) {
              _xifexpression = ((JsonRpcMethodProvider)ext).supportedMethods();
            } else {
              _xifexpression = ServiceEndpoints.getSupportedMethods(ext.getClass());
            }
            final Map<String, JsonRpcMethod> supportedExtensions = _xifexpression;
            Set<Map.Entry<String, JsonRpcMethod>> _entrySet = supportedExtensions.entrySet();
            for (final Map.Entry<String, JsonRpcMethod> entry : _entrySet) {
              boolean _containsKey = supportedMethods.containsKey(entry.getKey());
              if (_containsKey) {
                String _key = entry.getKey();
                String _plus = ("The json rpc method \'" + _key);
                String _plus_1 = (_plus + "\' can not be an extension as it is already defined in the LSP standard.");
                LanguageServerImpl.LOG.error(_plus_1);
              } else {
                final JsonRpcMethod existing = extensions.put(entry.getKey(), entry.getValue());
                if (((existing != null) && (!Objects.equal(existing, entry.getValue())))) {
                  String _key_1 = entry.getKey();
                  String _plus_2 = ("An incompatible LSP extension \'" + _key_1);
                  String _plus_3 = (_plus_2 + "\' has already been registered. Using 1 ignoring 2. \n1 : ");
                  String _plus_4 = (_plus_3 + existing);
                  String _plus_5 = (_plus_4 + " \n2 : ");
                  JsonRpcMethod _value = entry.getValue();
                  String _plus_6 = (_plus_5 + _value);
                  LanguageServerImpl.LOG.error(_plus_6);
                  extensions.put(entry.getKey(), existing);
                } else {
                  final Endpoint endpoint = ServiceEndpoints.toEndpoint(ext);
                  this.extensionProviders.put(entry.getKey(), endpoint);
                  supportedMethods.put(entry.getKey(), entry.getValue());
                }
              }
            }
          }
        }
      }
      this.supportedMethods = supportedMethods;
      return supportedMethods;
    }
  }
  
  private ILanguageServerAccess access = new ILanguageServerAccess() {
    @Override
    public <T extends Object> CompletableFuture<T> doRead(final String uri, final Function<ILanguageServerAccess.Context, T> function) {
      final Function1<CancelIndicator, T> _function = (CancelIndicator cancelIndicator) -> {
        final Function2<Document, XtextResource, T> _function_1 = (Document document, XtextResource resource) -> {
          boolean _isDocumentOpen = LanguageServerImpl.this.workspaceManager.isDocumentOpen(resource.getURI());
          final ILanguageServerAccess.Context ctx = new ILanguageServerAccess.Context(resource, document, _isDocumentOpen, cancelIndicator);
          return function.apply(ctx);
        };
        return LanguageServerImpl.this.workspaceManager.<T>doRead(LanguageServerImpl.this._uriExtensions.toUri(uri), _function_1);
      };
      return LanguageServerImpl.this.requestManager.<T>runRead(_function);
    }
    
    @Override
    public void addBuildListener(final ILanguageServerAccess.IBuildListener listener) {
      LanguageServerImpl.this.workspaceManager.addBuildListener(listener);
    }
    
    @Override
    public LanguageClient getLanguageClient() {
      return LanguageServerImpl.this.client;
    }
  };
  
  @Override
  public void afterBuild(final List<IResourceDescription.Delta> deltas) {
    if ((this.client instanceof LanguageClientExtensions)) {
      final Function1<IResourceDescription.Delta, Boolean> _function = (IResourceDescription.Delta it) -> {
        IResourceDescription _new = it.getNew();
        return Boolean.valueOf((_new != null));
      };
      final Function1<IResourceDescription.Delta, String> _function_1 = (IResourceDescription.Delta it) -> {
        return it.getUri().toString();
      };
      final Consumer<String> _function_2 = (String it) -> {
        final Function<ILanguageServerAccess.Context, Void> _function_3 = (ILanguageServerAccess.Context ctx) -> {
          boolean _isDocumentOpen = ctx.isDocumentOpen();
          if (_isDocumentOpen) {
            Resource _resource = ctx.getResource();
            if ((_resource instanceof XtextResource)) {
              Resource _resource_1 = ctx.getResource();
              final XtextResource resource = ((XtextResource) _resource_1);
              final IResourceServiceProvider serviceProvider = this.languagesRegistry.getResourceServiceProvider(resource.getURI());
              IColoringService _get = null;
              if (serviceProvider!=null) {
                _get=serviceProvider.<IColoringService>get(IColoringService.class);
              }
              final IColoringService coloringService = _get;
              if ((coloringService != null)) {
                final Document doc = ctx.getDocument();
                final List<? extends ColoringInformation> coloringInfos = coloringService.getColoring(resource, doc);
                boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(coloringInfos);
                boolean _not = (!_isNullOrEmpty);
                if (_not) {
                  final String uri = resource.getURI().toString();
                  ColoringParams _coloringParams = new ColoringParams(uri, coloringInfos);
                  ((LanguageClientExtensions)this.client).updateColoring(_coloringParams);
                }
              }
            }
            return null;
          }
          return null;
        };
        this.access.<Void>doRead(it, _function_3);
      };
      IterableExtensions.<IResourceDescription.Delta, String>map(IterableExtensions.<IResourceDescription.Delta>filter(deltas, _function), _function_1).forEach(_function_2);
    }
  }
  
  private final static Logger LOG = Logger.getLogger(LanguageServerImpl.class);
  
  @Pure
  public RequestManager getRequestManager() {
    return this.requestManager;
  }
}
