/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.lsapi.CodeActionParams;
import io.typefox.lsapi.CodeLens;
import io.typefox.lsapi.CodeLensParams;
import io.typefox.lsapi.Command;
import io.typefox.lsapi.CompletionItem;
import io.typefox.lsapi.CompletionItemImpl;
import io.typefox.lsapi.CompletionOptionsImpl;
import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DiagnosticImpl;
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
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.Hover;
import io.typefox.lsapi.InitializeParams;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.InitializeResultImpl;
import io.typefox.lsapi.LanguageServer;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.MessageParams;
import io.typefox.lsapi.NotificationCallback;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.PublishDiagnosticsParamsImpl;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.RangeImpl;
import io.typefox.lsapi.ReferenceParams;
import io.typefox.lsapi.RenameParams;
import io.typefox.lsapi.ServerCapabilities;
import io.typefox.lsapi.ServerCapabilitiesImpl;
import io.typefox.lsapi.ShowMessageRequestParams;
import io.typefox.lsapi.SignatureHelp;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.TextDocumentContentChangeEvent;
import io.typefox.lsapi.TextDocumentIdentifier;
import io.typefox.lsapi.TextDocumentItem;
import io.typefox.lsapi.TextDocumentPositionParams;
import io.typefox.lsapi.TextDocumentService;
import io.typefox.lsapi.TextEdit;
import io.typefox.lsapi.VersionedTextDocumentIdentifier;
import io.typefox.lsapi.WindowService;
import io.typefox.lsapi.WorkspaceEdit;
import io.typefox.lsapi.WorkspaceService;
import io.typefox.lsapi.WorkspaceSymbolParams;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
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
 */
@Accessors
@SuppressWarnings("all")
public class LanguageServerImpl implements LanguageServer, WorkspaceService, WindowService, TextDocumentService {
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
  public InitializeResult initialize(final InitializeParams params) {
    this.params = params;
    WorkspaceManager _get = this.workspaceManagerProvider.get();
    this.workspaceManager = _get;
    String _rootPath = params.getRootPath();
    final URI rootURI = URI.createFileURI(_rootPath);
    final Procedure2<URI, Iterable<Issue>> _function = new Procedure2<URI, Iterable<Issue>>() {
      @Override
      public void apply(final URI $0, final Iterable<Issue> $1) {
        LanguageServerImpl.this.publishDiagnostics($0, $1);
      }
    };
    this.workspaceManager.initialize(rootURI, _function);
    InitializeResultImpl _initializeResultImpl = new InitializeResultImpl();
    final Procedure1<InitializeResultImpl> _function_1 = new Procedure1<InitializeResultImpl>() {
      @Override
      public void apply(final InitializeResultImpl it) {
        ServerCapabilitiesImpl _serverCapabilitiesImpl = new ServerCapabilitiesImpl();
        final Procedure1<ServerCapabilitiesImpl> _function = new Procedure1<ServerCapabilitiesImpl>() {
          @Override
          public void apply(final ServerCapabilitiesImpl it) {
            it.setTextDocumentSync(Integer.valueOf(ServerCapabilities.SYNC_INCREMENTAL));
            CompletionOptionsImpl _completionOptionsImpl = new CompletionOptionsImpl();
            final Procedure1<CompletionOptionsImpl> _function = new Procedure1<CompletionOptionsImpl>() {
              @Override
              public void apply(final CompletionOptionsImpl it) {
                it.setResolveProvider(false);
                it.setTriggerCharacters(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(".")));
              }
            };
            CompletionOptionsImpl _doubleArrow = ObjectExtensions.<CompletionOptionsImpl>operator_doubleArrow(_completionOptionsImpl, _function);
            it.setCompletionProvider(_doubleArrow);
          }
        };
        ServerCapabilitiesImpl _doubleArrow = ObjectExtensions.<ServerCapabilitiesImpl>operator_doubleArrow(_serverCapabilitiesImpl, _function);
        it.setCapabilities(_doubleArrow);
      }
    };
    return ObjectExtensions.<InitializeResultImpl>operator_doubleArrow(_initializeResultImpl, _function_1);
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
  public void didOpen(final DidOpenTextDocumentParams params) {
    TextDocumentItem _textDocument = params.getTextDocument();
    String _uri = _textDocument.getUri();
    URI _uri_1 = this._uriExtensions.toUri(_uri);
    TextDocumentItem _textDocument_1 = params.getTextDocument();
    int _version = _textDocument_1.getVersion();
    TextDocumentItem _textDocument_2 = params.getTextDocument();
    String _text = _textDocument_2.getText();
    this.workspaceManager.didOpen(_uri_1, _version, _text);
  }
  
  @Override
  public void didChange(final DidChangeTextDocumentParams params) {
    VersionedTextDocumentIdentifier _textDocument = params.getTextDocument();
    String _uri = _textDocument.getUri();
    URI _uri_1 = this._uriExtensions.toUri(_uri);
    VersionedTextDocumentIdentifier _textDocument_1 = params.getTextDocument();
    int _version = _textDocument_1.getVersion();
    List<? extends TextDocumentContentChangeEvent> _contentChanges = params.getContentChanges();
    final Function1<TextDocumentContentChangeEvent, TextEdit> _function = new Function1<TextDocumentContentChangeEvent, TextEdit>() {
      @Override
      public TextEdit apply(final TextDocumentContentChangeEvent event) {
        Range _range = event.getRange();
        String _text = event.getText();
        return LsapiFactories.newTextEdit(((RangeImpl) _range), _text);
      }
    };
    List<TextEdit> _map = ListExtensions.map(_contentChanges, _function);
    this.workspaceManager.didChange(_uri_1, _version, _map);
  }
  
  @Override
  public void didClose(final DidCloseTextDocumentParams params) {
    TextDocumentIdentifier _textDocument = params.getTextDocument();
    String _uri = _textDocument.getUri();
    URI _uri_1 = this._uriExtensions.toUri(_uri);
    this.workspaceManager.didClose(_uri_1);
  }
  
  @Override
  public void didSave(final DidSaveTextDocumentParams params) {
    TextDocumentIdentifier _textDocument = params.getTextDocument();
    String _uri = _textDocument.getUri();
    URI _uri_1 = this._uriExtensions.toUri(_uri);
    this.workspaceManager.didSave(_uri_1);
  }
  
  @Override
  public void didChangeWatchedFiles(final DidChangeWatchedFilesParams params) {
    final ArrayList<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
    final ArrayList<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
    List<? extends FileEvent> _changes = params.getChanges();
    for (final FileEvent fileEvent : _changes) {
      int _type = fileEvent.getType();
      boolean _tripleEquals = (_type == FileEvent.TYPE_DELETED);
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
    this.workspaceManager.doBuild(dirtyFiles, deletedFiles);
  }
  
  private List<NotificationCallback<PublishDiagnosticsParams>> diagnosticListeners = CollectionLiterals.<NotificationCallback<PublishDiagnosticsParams>>newArrayList();
  
  @Override
  public void onPublishDiagnostics(final NotificationCallback<PublishDiagnosticsParams> callback) {
    this.diagnosticListeners.add(callback);
  }
  
  private void publishDiagnostics(final URI uri, final Iterable<? extends Issue> issues) {
    PublishDiagnosticsParamsImpl _publishDiagnosticsParamsImpl = new PublishDiagnosticsParamsImpl();
    final Procedure1<PublishDiagnosticsParamsImpl> _function = new Procedure1<PublishDiagnosticsParamsImpl>() {
      @Override
      public void apply(final PublishDiagnosticsParamsImpl it) {
        String _path = LanguageServerImpl.this._uriExtensions.toPath(uri);
        it.setUri(_path);
        final Function1<Issue, DiagnosticImpl> _function = new Function1<Issue, DiagnosticImpl>() {
          @Override
          public DiagnosticImpl apply(final Issue it) {
            return LanguageServerImpl.this.toDiagnostic(it);
          }
        };
        Iterable<DiagnosticImpl> _map = IterableExtensions.map(issues, _function);
        List<DiagnosticImpl> _list = IterableExtensions.<DiagnosticImpl>toList(_map);
        it.setDiagnostics(_list);
      }
    };
    final PublishDiagnosticsParamsImpl diagnostics = ObjectExtensions.<PublishDiagnosticsParamsImpl>operator_doubleArrow(_publishDiagnosticsParamsImpl, _function);
    for (final NotificationCallback<PublishDiagnosticsParams> diagnosticsCallback : this.diagnosticListeners) {
      diagnosticsCallback.call(diagnostics);
    }
  }
  
  private DiagnosticImpl toDiagnostic(final Issue issue) {
    DiagnosticImpl _diagnosticImpl = new DiagnosticImpl();
    final Procedure1<DiagnosticImpl> _function = new Procedure1<DiagnosticImpl>() {
      @Override
      public void apply(final DiagnosticImpl it) {
        String _code = issue.getCode();
        it.setCode(_code);
        int _switchResult = (int) 0;
        Severity _severity = issue.getSeverity();
        if (_severity != null) {
          switch (_severity) {
            case ERROR:
              _switchResult = Diagnostic.SEVERITY_ERROR;
              break;
            case WARNING:
              _switchResult = Diagnostic.SEVERITY_WARNING;
              break;
            case INFO:
              _switchResult = Diagnostic.SEVERITY_INFO;
              break;
            default:
              _switchResult = Diagnostic.SEVERITY_HINT;
              break;
          }
        } else {
          _switchResult = Diagnostic.SEVERITY_HINT;
        }
        it.setSeverity(Integer.valueOf(_switchResult));
        String _message = issue.getMessage();
        it.setMessage(_message);
        Integer _lineNumber = issue.getLineNumber();
        int _minus = ((_lineNumber).intValue() - 1);
        Integer _column = issue.getColumn();
        int _minus_1 = ((_column).intValue() - 1);
        PositionImpl _newPosition = LsapiFactories.newPosition(_minus, _minus_1);
        Integer _lineNumber_1 = issue.getLineNumber();
        int _minus_2 = ((_lineNumber_1).intValue() - 1);
        Integer _column_1 = issue.getColumn();
        int _minus_3 = ((_column_1).intValue() - 1);
        Integer _length = issue.getLength();
        int _plus = (_minus_3 + (_length).intValue());
        PositionImpl _newPosition_1 = LsapiFactories.newPosition(_minus_2, _plus);
        RangeImpl _newRange = LsapiFactories.newRange(_newPosition, _newPosition_1);
        it.setRange(_newRange);
      }
    };
    return ObjectExtensions.<DiagnosticImpl>operator_doubleArrow(_diagnosticImpl, _function);
  }
  
  @Override
  public List<? extends CompletionItem> completion(final TextDocumentPositionParams params) {
    TextDocumentIdentifier _textDocument = params.getTextDocument();
    String _uri = _textDocument.getUri();
    final URI uri = this._uriExtensions.toUri(_uri);
    final IResourceServiceProvider resourceServiceProvider = this.languagesRegistry.getResourceServiceProvider(uri);
    ContentAssistService _get = null;
    if (resourceServiceProvider!=null) {
      _get=resourceServiceProvider.<ContentAssistService>get(ContentAssistService.class);
    }
    final ContentAssistService contentAssistService = _get;
    if ((contentAssistService == null)) {
      return CollectionLiterals.<CompletionItem>emptyList();
    }
    final Function2<Document, XtextResource, Iterable<ContentAssistEntry>> _function = new Function2<Document, XtextResource, Iterable<ContentAssistEntry>>() {
      @Override
      public Iterable<ContentAssistEntry> apply(final Document document, final XtextResource resource) {
        Position _position = params.getPosition();
        final int offset = document.getOffSet(_position);
        String _contents = document.getContents();
        return contentAssistService.createProposals(_contents, offset, resource);
      }
    };
    final Iterable<ContentAssistEntry> entries = this.workspaceManager.<Iterable<ContentAssistEntry>>doRead(uri, _function);
    final Function1<ContentAssistEntry, CompletionItem> _function_1 = new Function1<ContentAssistEntry, CompletionItem>() {
      @Override
      public CompletionItem apply(final ContentAssistEntry it) {
        return LanguageServerImpl.this.toCompletionItem(it);
      }
    };
    Iterable<CompletionItem> _map = IterableExtensions.<ContentAssistEntry, CompletionItem>map(entries, _function_1);
    return IterableExtensions.<CompletionItem>toList(_map);
  }
  
  protected CompletionItem toCompletionItem(final ContentAssistEntry entry) {
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
    String _proposal_1 = entry.getProposal();
    completionItem.setInsertText(_proposal_1);
    return completionItem;
  }
  
  @Override
  public void onShowMessage(final NotificationCallback<MessageParams> callback) {
  }
  
  @Override
  public void onShowMessageRequest(final NotificationCallback<ShowMessageRequestParams> callback) {
  }
  
  @Override
  public void onLogMessage(final NotificationCallback<MessageParams> callback) {
  }
  
  @Override
  public List<? extends SymbolInformation> symbol(final WorkspaceSymbolParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void didChangeConfiguraton(final DidChangeConfigurationParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletionItem resolveCompletionItem(final CompletionItem unresolved) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Hover hover(final TextDocumentPositionParams position) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public SignatureHelp signatureHelp(final TextDocumentPositionParams position) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends Location> definition(final TextDocumentPositionParams position) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends Location> references(final ReferenceParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public DocumentHighlight documentHighlight(final TextDocumentPositionParams position) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends SymbolInformation> documentSymbol(final DocumentSymbolParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends Command> codeAction(final CodeActionParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends CodeLens> codeLens(final CodeLensParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CodeLens resolveCodeLens(final CodeLens unresolved) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends TextEdit> formatting(final DocumentFormattingParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends TextEdit> rangeFormatting(final DocumentRangeFormattingParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public List<? extends TextEdit> onTypeFormatting(final DocumentOnTypeFormattingParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public WorkspaceEdit rename(final RenameParams params) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
  public List<NotificationCallback<PublishDiagnosticsParams>> getDiagnosticListeners() {
    return this.diagnosticListeners;
  }
  
  public void setDiagnosticListeners(final List<NotificationCallback<PublishDiagnosticsParams>> diagnosticListeners) {
    this.diagnosticListeners = diagnosticListeners;
  }
}
