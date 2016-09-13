/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.lsapi.CodeActionParams;
import io.typefox.lsapi.CodeLens;
import io.typefox.lsapi.CodeLensParams;
import io.typefox.lsapi.Command;
import io.typefox.lsapi.CompletionItem;
import io.typefox.lsapi.CompletionItemKind;
import io.typefox.lsapi.CompletionList;
import io.typefox.lsapi.DiagnosticSeverity;
import io.typefox.lsapi.DidChangeConfigurationParams;
import io.typefox.lsapi.DidChangeTextDocumentParams;
import io.typefox.lsapi.DidChangeWatchedFilesParams;
import io.typefox.lsapi.DidCloseTextDocumentParams;
import io.typefox.lsapi.DidOpenTextDocumentParams;
import io.typefox.lsapi.DidSaveTextDocumentParams;
import io.typefox.lsapi.DocumentFormattingParams;
import io.typefox.lsapi.DocumentHighlight;
import io.typefox.lsapi.DocumentOnTypeFormattingParams;
import io.typefox.lsapi.DocumentRangeFormattingParams;
import io.typefox.lsapi.DocumentSymbolParams;
import io.typefox.lsapi.FileChangeType;
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.Hover;
import io.typefox.lsapi.InitializeParams;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.MessageParams;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.ReferenceContext;
import io.typefox.lsapi.ReferenceParams;
import io.typefox.lsapi.RenameParams;
import io.typefox.lsapi.ShowMessageRequestParams;
import io.typefox.lsapi.SignatureHelp;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.TextDocumentContentChangeEvent;
import io.typefox.lsapi.TextDocumentIdentifier;
import io.typefox.lsapi.TextDocumentItem;
import io.typefox.lsapi.TextDocumentPositionParams;
import io.typefox.lsapi.TextDocumentSyncKind;
import io.typefox.lsapi.TextEdit;
import io.typefox.lsapi.VersionedTextDocumentIdentifier;
import io.typefox.lsapi.WorkspaceEdit;
import io.typefox.lsapi.WorkspaceSymbolParams;
import io.typefox.lsapi.impl.CompletionItemImpl;
import io.typefox.lsapi.impl.CompletionListImpl;
import io.typefox.lsapi.impl.CompletionOptionsImpl;
import io.typefox.lsapi.impl.DiagnosticImpl;
import io.typefox.lsapi.impl.HoverImpl;
import io.typefox.lsapi.impl.InitializeResultImpl;
import io.typefox.lsapi.impl.MarkedStringImpl;
import io.typefox.lsapi.impl.PositionImpl;
import io.typefox.lsapi.impl.PublishDiagnosticsParamsImpl;
import io.typefox.lsapi.impl.RangeImpl;
import io.typefox.lsapi.impl.ServerCapabilitiesImpl;
import io.typefox.lsapi.impl.SignatureHelpImpl;
import io.typefox.lsapi.impl.SignatureHelpOptionsImpl;
import io.typefox.lsapi.impl.TextEditImpl;
import io.typefox.lsapi.services.LanguageServer;
import io.typefox.lsapi.services.TextDocumentService;
import io.typefox.lsapi.services.WindowService;
import io.typefox.lsapi.services.WorkspaceService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.server.concurrent.CancellableIndicator;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;
import org.eclipse.xtext.ide.server.findReferences.WorkspaceResourceAccess;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.ide.server.hover.HoverService;
import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.ide.server.symbol.WorkspaceSymbolService;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
@Accessors
@SuppressWarnings("all")
public class LanguageServerImpl implements LanguageServer, WorkspaceService, WindowService, TextDocumentService {
  @Inject
  private RequestManager requestManager;
  
  @Inject
  private WorkspaceSymbolService workspaceSymbolService;
  
  private InitializeParams params;
  
  @Inject
  private Provider<WorkspaceManager> workspaceManagerProvider;
  
  private WorkspaceManager workspaceManager;
  
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  @Extension
  private IResourceServiceProvider.Registry languagesRegistry;
  
  @Override
  public CompletableFuture<InitializeResult> initialize(final InitializeParams params) {
    String _rootPath = params.getRootPath();
    boolean _tripleEquals = (_rootPath == null);
    if (_tripleEquals) {
      throw new IllegalArgumentException("Bad initialization request. rootPath must not be null.");
    }
    Map<String, Object> _extensionToFactoryMap = this.languagesRegistry.getExtensionToFactoryMap();
    boolean _isEmpty = _extensionToFactoryMap.isEmpty();
    if (_isEmpty) {
      throw new IllegalStateException("No Xtext languages have been registered. Please make sure you have added the languages\'s setup class in \'/META-INF/services/org.eclipse.xtext.ISetup\'");
    }
    this.params = params;
    WorkspaceManager _get = this.workspaceManagerProvider.get();
    this.workspaceManager = _get;
    WorkspaceResourceAccess _workspaceResourceAccess = new WorkspaceResourceAccess(this.workspaceManager);
    this.resourceAccess = _workspaceResourceAccess;
    final InitializeResultImpl result = new InitializeResultImpl();
    ServerCapabilitiesImpl _serverCapabilitiesImpl = new ServerCapabilitiesImpl();
    final Procedure1<ServerCapabilitiesImpl> _function = (ServerCapabilitiesImpl it) -> {
      it.setHoverProvider(Boolean.valueOf(true));
      it.setDefinitionProvider(Boolean.valueOf(true));
      it.setReferencesProvider(Boolean.valueOf(true));
      it.setDocumentSymbolProvider(Boolean.valueOf(true));
      it.setWorkspaceSymbolProvider(Boolean.valueOf(true));
      SignatureHelpOptionsImpl _signatureHelpOptionsImpl = new SignatureHelpOptionsImpl(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("(", ",")));
      it.setSignatureHelpProvider(_signatureHelpOptionsImpl);
      it.setTextDocumentSync(TextDocumentSyncKind.Incremental);
      CompletionOptionsImpl _completionOptionsImpl = new CompletionOptionsImpl();
      final Procedure1<CompletionOptionsImpl> _function_1 = (CompletionOptionsImpl it_1) -> {
        it_1.setResolveProvider(Boolean.valueOf(false));
        it_1.setTriggerCharacters(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(".")));
      };
      CompletionOptionsImpl _doubleArrow = ObjectExtensions.<CompletionOptionsImpl>operator_doubleArrow(_completionOptionsImpl, _function_1);
      it.setCompletionProvider(_doubleArrow);
      it.setDocumentFormattingProvider(Boolean.valueOf(true));
      it.setDocumentRangeFormattingProvider(Boolean.valueOf(true));
    };
    ServerCapabilitiesImpl _doubleArrow = ObjectExtensions.<ServerCapabilitiesImpl>operator_doubleArrow(_serverCapabilitiesImpl, _function);
    result.setCapabilities(_doubleArrow);
    final Procedure1<CancelIndicator> _function_1 = (CancelIndicator cancelIndicator) -> {
      String _rootPath_1 = params.getRootPath();
      URI _createFileURI = URI.createFileURI(_rootPath_1);
      String _path = this._uriExtensions.toPath(_createFileURI);
      final URI rootURI = this._uriExtensions.toUri(_path);
      final Procedure2<URI, Iterable<Issue>> _function_2 = (URI $0, Iterable<Issue> $1) -> {
        this.publishDiagnostics($0, $1);
      };
      this.workspaceManager.initialize(rootURI, _function_2, cancelIndicator);
    };
    this.requestManager.runWrite(_function_1, CancellableIndicator.NullImpl);
    return CompletableFuture.<InitializeResult>completedFuture(result);
  }
  
  @Override
  public void exit() {
  }
  
  @Override
  public void shutdown() {
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
  public WindowService getWindowService() {
    return this;
  }
  
  @Override
  public void onTelemetryEvent(final Consumer<Object> callback) {
  }
  
  @Override
  public void onShowMessage(final Consumer<MessageParams> callback) {
  }
  
  @Override
  public void onShowMessageRequest(final Consumer<ShowMessageRequestParams> callback) {
  }
  
  @Override
  public void onLogMessage(final Consumer<MessageParams> callback) {
  }
  
  @Override
  public void didOpen(final DidOpenTextDocumentParams params) {
    final Procedure1<CancelIndicator> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentItem _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      URI _uri_1 = this._uriExtensions.toUri(_uri);
      TextDocumentItem _textDocument_1 = params.getTextDocument();
      int _version = _textDocument_1.getVersion();
      TextDocumentItem _textDocument_2 = params.getTextDocument();
      String _text = _textDocument_2.getText();
      this.workspaceManager.didOpen(_uri_1, _version, _text, cancelIndicator);
    };
    this.requestManager.runWrite(_function);
  }
  
  @Override
  public void didChange(final DidChangeTextDocumentParams params) {
    final Procedure1<CancelIndicator> _function = (CancelIndicator cancelIndicator) -> {
      VersionedTextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      URI _uri_1 = this._uriExtensions.toUri(_uri);
      VersionedTextDocumentIdentifier _textDocument_1 = params.getTextDocument();
      int _version = _textDocument_1.getVersion();
      List<? extends TextDocumentContentChangeEvent> _contentChanges = params.getContentChanges();
      final Function1<TextDocumentContentChangeEvent, TextEdit> _function_1 = (TextDocumentContentChangeEvent event) -> {
        Range _range = event.getRange();
        String _text = event.getText();
        return new TextEditImpl(((RangeImpl) _range), _text);
      };
      List<TextEdit> _map = ListExtensions.map(_contentChanges, _function_1);
      this.workspaceManager.didChange(_uri_1, _version, _map, cancelIndicator);
    };
    this.requestManager.runWrite(_function);
  }
  
  @Override
  public void didClose(final DidCloseTextDocumentParams params) {
    final Procedure1<CancelIndicator> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      URI _uri_1 = this._uriExtensions.toUri(_uri);
      this.workspaceManager.didClose(_uri_1, cancelIndicator);
    };
    this.requestManager.runWrite(_function);
  }
  
  @Override
  public void didSave(final DidSaveTextDocumentParams params) {
    final Procedure1<CancelIndicator> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      URI _uri_1 = this._uriExtensions.toUri(_uri);
      this.workspaceManager.didSave(_uri_1, cancelIndicator);
    };
    this.requestManager.runWrite(_function);
  }
  
  @Override
  public void didChangeWatchedFiles(final DidChangeWatchedFilesParams params) {
    final Procedure1<CancelIndicator> _function = (CancelIndicator cancelIndicator) -> {
      final ArrayList<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
      final ArrayList<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
      List<? extends FileEvent> _changes = params.getChanges();
      for (final FileEvent fileEvent : _changes) {
        FileChangeType _type = fileEvent.getType();
        boolean _tripleEquals = (_type == FileChangeType.Deleted);
        if (_tripleEquals) {
          String _uri = fileEvent.getUri();
          URI _uri_1 = this._uriExtensions.toUri(_uri);
          deletedFiles.add(_uri_1);
        } else {
          String _uri_2 = fileEvent.getUri();
          URI _uri_3 = this._uriExtensions.toUri(_uri_2);
          dirtyFiles.add(_uri_3);
        }
      }
      this.workspaceManager.doBuild(dirtyFiles, deletedFiles, cancelIndicator);
    };
    this.requestManager.runWrite(_function);
  }
  
  @Override
  public void didChangeConfiguraton(final DidChangeConfigurationParams params) {
    final Procedure1<CancelIndicator> _function = (CancelIndicator cancelIndicator) -> {
      this.workspaceManager.refreshWorkspaceConfig(cancelIndicator);
    };
    this.requestManager.runWrite(_function);
  }
  
  private List<Consumer<PublishDiagnosticsParams>> diagnosticListeners = CollectionLiterals.<Consumer<PublishDiagnosticsParams>>newArrayList();
  
  private WorkspaceResourceAccess resourceAccess;
  
  @Override
  public void onPublishDiagnostics(final Consumer<PublishDiagnosticsParams> callback) {
    this.diagnosticListeners.add(callback);
  }
  
  private void publishDiagnostics(final URI uri, final Iterable<? extends Issue> issues) {
    PublishDiagnosticsParamsImpl _publishDiagnosticsParamsImpl = new PublishDiagnosticsParamsImpl();
    final Procedure1<PublishDiagnosticsParamsImpl> _function = (PublishDiagnosticsParamsImpl it) -> {
      String _path = this._uriExtensions.toPath(uri);
      it.setUri(_path);
      final Function1<Issue, DiagnosticImpl> _function_1 = (Issue it_1) -> {
        return this.toDiagnostic(it_1);
      };
      Iterable<DiagnosticImpl> _map = IterableExtensions.map(issues, _function_1);
      List<DiagnosticImpl> _list = IterableExtensions.<DiagnosticImpl>toList(_map);
      it.setDiagnostics(_list);
    };
    final PublishDiagnosticsParamsImpl diagnostics = ObjectExtensions.<PublishDiagnosticsParamsImpl>operator_doubleArrow(_publishDiagnosticsParamsImpl, _function);
    for (final Consumer<PublishDiagnosticsParams> diagnosticsCallback : this.diagnosticListeners) {
      diagnosticsCallback.accept(diagnostics);
    }
  }
  
  private DiagnosticImpl toDiagnostic(final Issue issue) {
    DiagnosticImpl _diagnosticImpl = new DiagnosticImpl();
    final Procedure1<DiagnosticImpl> _function = (DiagnosticImpl it) -> {
      String _code = issue.getCode();
      it.setCode(_code);
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
      String _message = issue.getMessage();
      it.setMessage(_message);
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
      PositionImpl _positionImpl = new PositionImpl(lineNumber, column);
      PositionImpl _positionImpl_1 = new PositionImpl(lineNumber, (column + (length).intValue()));
      RangeImpl _rangeImpl = new RangeImpl(_positionImpl, _positionImpl_1);
      it.setRange(_rangeImpl);
    };
    return ObjectExtensions.<DiagnosticImpl>operator_doubleArrow(_diagnosticImpl, _function);
  }
  
  @Override
  public CompletableFuture<CompletionList> completion(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, CompletionList> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      ContentAssistService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<ContentAssistService>get(ContentAssistService.class);
      }
      final ContentAssistService contentAssistService = _get;
      final CompletionListImpl result = new CompletionListImpl();
      if ((contentAssistService == null)) {
        return result;
      }
      final Function2<Document, XtextResource, Function0<ArrayList<CompletionItemImpl>>> _function_1 = (Document document, XtextResource resource) -> {
        Position _position = params.getPosition();
        final int caretOffset = document.getOffSet(_position);
        String _contents = document.getContents();
        final Iterable<ContentAssistEntry> entries = contentAssistService.createProposals(_contents, caretOffset, resource, cancelIndicator);
        final Function0<ArrayList<CompletionItemImpl>> _function_2 = () -> {
          Position _position_1 = params.getPosition();
          final PositionImpl caretPosition = new PositionImpl(((PositionImpl) _position_1));
          final ArrayList<CompletionItemImpl> completionItems = CollectionLiterals.<CompletionItemImpl>newArrayList();
          final Procedure2<ContentAssistEntry, Integer> _function_3 = (ContentAssistEntry entry, Integer idx) -> {
            final CompletionItemImpl item = this.toCompletionItem(entry, caretOffset, caretPosition, document);
            String _string = idx.toString();
            item.setSortText(_string);
            completionItems.add(item);
          };
          IterableExtensions.<ContentAssistEntry>forEach(entries, _function_3);
          return completionItems;
        };
        return _function_2;
      };
      Function0<ArrayList<CompletionItemImpl>> _doRead = this.workspaceManager.<Function0<ArrayList<CompletionItemImpl>>>doRead(uri, _function_1);
      ArrayList<CompletionItemImpl> _apply = _doRead.apply();
      result.setItems(_apply);
      return result;
    };
    return this.requestManager.<CompletionList>runRead(_function);
  }
  
  protected CompletionItemImpl toCompletionItem(final ContentAssistEntry entry, final int caretOffset, final PositionImpl caretPosition, final Document document) {
    final CompletionItemImpl completionItem = new CompletionItemImpl();
    String _elvis = null;
    String _label = entry.getLabel();
    if (_label != null) {
      _elvis = _label;
    } else {
      String _proposal = entry.getProposal();
      _elvis = _proposal;
    }
    completionItem.setLabel(_elvis);
    String _description = entry.getDescription();
    completionItem.setDetail(_description);
    String _elvis_1 = null;
    String _prefix = entry.getPrefix();
    if (_prefix != null) {
      _elvis_1 = _prefix;
    } else {
      _elvis_1 = "";
    }
    int _length = _elvis_1.length();
    final int prefixOffset = (caretOffset - _length);
    final PositionImpl prefixPosition = document.getPosition(prefixOffset);
    RangeImpl _rangeImpl = new RangeImpl(prefixPosition, caretPosition);
    String _proposal_1 = entry.getProposal();
    TextEditImpl _textEditImpl = new TextEditImpl(_rangeImpl, _proposal_1);
    completionItem.setTextEdit(_textEditImpl);
    CompletionItemKind _translateKind = this.translateKind(entry);
    completionItem.setKind(_translateKind);
    return completionItem;
  }
  
  protected CompletionItemKind translateKind(final ContentAssistEntry entry) {
    CompletionItemKind _switchResult = null;
    String _kind = entry.getKind();
    switch (_kind) {
      case ContentAssistEntry.KIND_CLASS:
        _switchResult = CompletionItemKind.Class;
        break;
      case ContentAssistEntry.KIND_COLOR:
        _switchResult = CompletionItemKind.Color;
        break;
      case ContentAssistEntry.KIND_CONSTRUCTOR:
        _switchResult = CompletionItemKind.Constructor;
        break;
      case ContentAssistEntry.KIND_ENUM:
        _switchResult = CompletionItemKind.Enum;
        break;
      case ContentAssistEntry.KIND_FIELD:
        _switchResult = CompletionItemKind.Field;
        break;
      case ContentAssistEntry.KIND_FILE:
        _switchResult = CompletionItemKind.File;
        break;
      case ContentAssistEntry.KIND_FUNCTION:
        _switchResult = CompletionItemKind.Function;
        break;
      case ContentAssistEntry.KIND_INTERFACE:
        _switchResult = CompletionItemKind.Interface;
        break;
      case ContentAssistEntry.KIND_KEYWORD:
        _switchResult = CompletionItemKind.Keyword;
        break;
      case ContentAssistEntry.KIND_METHOD:
        _switchResult = CompletionItemKind.Method;
        break;
      case ContentAssistEntry.KIND_MODULE:
        _switchResult = CompletionItemKind.Module;
        break;
      case ContentAssistEntry.KIND_PROPERTY:
        _switchResult = CompletionItemKind.Property;
        break;
      case ContentAssistEntry.KIND_REFERENCE:
        _switchResult = CompletionItemKind.Reference;
        break;
      case ContentAssistEntry.KIND_SNIPPET:
        _switchResult = CompletionItemKind.Snippet;
        break;
      case ContentAssistEntry.KIND_TEXT:
        _switchResult = CompletionItemKind.Text;
        break;
      case ContentAssistEntry.KIND_UNIT:
        _switchResult = CompletionItemKind.Unit;
        break;
      case ContentAssistEntry.KIND_VALUE:
        _switchResult = CompletionItemKind.Value;
        break;
      case ContentAssistEntry.KIND_VARIABLE:
        _switchResult = CompletionItemKind.Variable;
        break;
      default:
        _switchResult = CompletionItemKind.Value;
        break;
    }
    return _switchResult;
  }
  
  @Override
  public CompletableFuture<List<? extends Location>> definition(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, List<? extends Location>> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
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
        Position _position = params.getPosition();
        final int offset = document.getOffSet(_position);
        return documentSymbolService.getDefinitions(resource, offset, this.resourceAccess, cancelIndicator);
      };
      final List<? extends Location> definitions = this.workspaceManager.<List<? extends Location>>doRead(uri, _function_1);
      return definitions;
    };
    return this.requestManager.<List<? extends Location>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends Location>> references(final ReferenceParams params) {
    final Function1<CancelIndicator, List<? extends Location>> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      DocumentSymbolService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<DocumentSymbolService>get(DocumentSymbolService.class);
      }
      final DocumentSymbolService documentSymbolService = _get;
      if ((documentSymbolService == null)) {
        return CollectionLiterals.<Location>emptyList();
      }
      final Function2<Document, XtextResource, List<Location>> _function_1 = (Document document, XtextResource resource) -> {
        Position _position = params.getPosition();
        final int offset = document.getOffSet(_position);
        List<? extends Location> _xifexpression = null;
        ReferenceContext _context = params.getContext();
        boolean _isIncludeDeclaration = _context.isIncludeDeclaration();
        if (_isIncludeDeclaration) {
          _xifexpression = documentSymbolService.getDefinitions(resource, offset, this.resourceAccess, cancelIndicator);
        } else {
          _xifexpression = CollectionLiterals.emptyList();
        }
        final List<? extends Location> definitions = _xifexpression;
        final IResourceDescriptions indexData = this.workspaceManager.getIndex();
        final List<? extends Location> references = documentSymbolService.getReferences(resource, offset, this.resourceAccess, indexData, cancelIndicator);
        final Iterable<Location> result = Iterables.<Location>concat(definitions, references);
        return IterableExtensions.<Location>toList(result);
      };
      return this.workspaceManager.<List<Location>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends Location>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends SymbolInformation>> documentSymbol(final DocumentSymbolParams params) {
    final Function1<CancelIndicator, List<? extends SymbolInformation>> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
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
        return documentSymbolService.getSymbols(resource, cancelIndicator);
      };
      return this.workspaceManager.<List<? extends SymbolInformation>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends SymbolInformation>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends SymbolInformation>> symbol(final WorkspaceSymbolParams params) {
    final Function1<CancelIndicator, List<? extends SymbolInformation>> _function = (CancelIndicator cancelIndicator) -> {
      final IResourceDescriptions indexData = this.workspaceManager.getIndex();
      String _query = params.getQuery();
      return this.workspaceSymbolService.getSymbols(_query, this.resourceAccess, indexData, cancelIndicator);
    };
    return this.requestManager.<List<? extends SymbolInformation>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<Hover> hover(final TextDocumentPositionParams params) {
    final Function1<CancelIndicator, Hover> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      HoverService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<HoverService>get(HoverService.class);
      }
      final HoverService hoverService = _get;
      if ((hoverService == null)) {
        List<MarkedStringImpl> _emptyList = CollectionLiterals.<MarkedStringImpl>emptyList();
        return new HoverImpl(_emptyList, null);
      }
      final Function2<Document, XtextResource, Hover> _function_1 = (Document document, XtextResource resource) -> {
        Position _position = params.getPosition();
        final int offset = document.getOffSet(_position);
        return hoverService.hover(resource, offset);
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
  public CompletableFuture<SignatureHelp> signatureHelp(final TextDocumentPositionParams position) {
    final Function1<CancelIndicator, SignatureHelp> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = position.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
      final IResourceServiceProvider serviceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      SignatureHelpService _get = null;
      if (serviceProvider!=null) {
        _get=serviceProvider.<SignatureHelpService>get(SignatureHelpService.class);
      }
      final SignatureHelpService helper = _get;
      if ((helper == null)) {
        return new SignatureHelpImpl();
      }
      final Function2<Document, XtextResource, SignatureHelp> _function_1 = (Document doc, XtextResource resource) -> {
        Position _position = position.getPosition();
        final int offset = doc.getOffSet(_position);
        return helper.getSignatureHelp(resource, offset);
      };
      return this.workspaceManager.<SignatureHelp>doRead(uri, _function_1);
    };
    return this.requestManager.<SignatureHelp>runRead(_function);
  }
  
  @Override
  public CompletableFuture<DocumentHighlight> documentHighlight(final TextDocumentPositionParams position) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletableFuture<List<? extends Command>> codeAction(final CodeActionParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletableFuture<List<? extends CodeLens>> codeLens(final CodeLensParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletableFuture<CodeLens> resolveCodeLens(final CodeLens unresolved) {
    return CompletableFuture.<CodeLens>completedFuture(unresolved);
  }
  
  @Override
  public CompletableFuture<List<? extends TextEdit>> formatting(final DocumentFormattingParams params) {
    final Function1<CancelIndicator, List<? extends TextEdit>> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      FormattingService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<FormattingService>get(FormattingService.class);
      }
      final FormattingService formatterService = _get;
      if ((formatterService == null)) {
        return Collections.<TextEdit>emptyList();
      }
      final Function2<Document, XtextResource, List<TextEdit>> _function_1 = (Document document, XtextResource resource) -> {
        final int offset = 0;
        String _contents = document.getContents();
        final int length = _contents.length();
        return formatterService.format(resource, document, offset, length);
      };
      return this.workspaceManager.<List<? extends TextEdit>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends TextEdit>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends TextEdit>> rangeFormatting(final DocumentRangeFormattingParams params) {
    final Function1<CancelIndicator, List<? extends TextEdit>> _function = (CancelIndicator cancelIndicator) -> {
      TextDocumentIdentifier _textDocument = params.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this._uriExtensions.toUri(_uri);
      final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
      FormattingService _get = null;
      if (resourceServiceProvider!=null) {
        _get=resourceServiceProvider.<FormattingService>get(FormattingService.class);
      }
      final FormattingService formatterService = _get;
      if ((formatterService == null)) {
        return Collections.<TextEdit>emptyList();
      }
      final Function2<Document, XtextResource, List<TextEdit>> _function_1 = (Document document, XtextResource resource) -> {
        Range _range = params.getRange();
        Position _start = _range.getStart();
        final int offset = document.getOffSet(_start);
        Range _range_1 = params.getRange();
        Position _end = _range_1.getEnd();
        int _offSet = document.getOffSet(_end);
        final int length = (_offSet - offset);
        return formatterService.format(resource, document, offset, length);
      };
      return this.workspaceManager.<List<? extends TextEdit>>doRead(uri, _function_1);
    };
    return this.requestManager.<List<? extends TextEdit>>runRead(_function);
  }
  
  @Override
  public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(final DocumentOnTypeFormattingParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletableFuture<WorkspaceEdit> rename(final RenameParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public RequestManager getRequestManager() {
    return this.requestManager;
  }
  
  public void setRequestManager(final RequestManager requestManager) {
    this.requestManager = requestManager;
  }
  
  @Pure
  public WorkspaceSymbolService getWorkspaceSymbolService() {
    return this.workspaceSymbolService;
  }
  
  public void setWorkspaceSymbolService(final WorkspaceSymbolService workspaceSymbolService) {
    this.workspaceSymbolService = workspaceSymbolService;
  }
  
  @Pure
  public InitializeParams getParams() {
    return this.params;
  }
  
  public void setParams(final InitializeParams params) {
    this.params = params;
  }
  
  @Pure
  public Provider<WorkspaceManager> getWorkspaceManagerProvider() {
    return this.workspaceManagerProvider;
  }
  
  public void setWorkspaceManagerProvider(final Provider<WorkspaceManager> workspaceManagerProvider) {
    this.workspaceManagerProvider = workspaceManagerProvider;
  }
  
  @Pure
  public WorkspaceManager getWorkspaceManager() {
    return this.workspaceManager;
  }
  
  public void setWorkspaceManager(final WorkspaceManager workspaceManager) {
    this.workspaceManager = workspaceManager;
  }
  
  @Pure
  public UriExtensions get_uriExtensions() {
    return this._uriExtensions;
  }
  
  public void set_uriExtensions(final UriExtensions _uriExtensions) {
    this._uriExtensions = _uriExtensions;
  }
  
  @Pure
  public IResourceServiceProvider.Registry getLanguagesRegistry() {
    return this.languagesRegistry;
  }
  
  public void setLanguagesRegistry(final IResourceServiceProvider.Registry languagesRegistry) {
    this.languagesRegistry = languagesRegistry;
  }
  
  @Pure
  public List<Consumer<PublishDiagnosticsParams>> getDiagnosticListeners() {
    return this.diagnosticListeners;
  }
  
  public void setDiagnosticListeners(final List<Consumer<PublishDiagnosticsParams>> diagnosticListeners) {
    this.diagnosticListeners = diagnosticListeners;
  }
  
  @Pure
  public WorkspaceResourceAccess getResourceAccess() {
    return this.resourceAccess;
  }
  
  public void setResourceAccess(final WorkspaceResourceAccess resourceAccess) {
    this.resourceAccess = resourceAccess;
  }
}
