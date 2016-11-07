/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import com.google.common.base.Objects;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.DidCloseTextDocumentParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.DocumentSymbolParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.ParameterInformation;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.ReferenceContext;
import org.eclipse.lsp4j.ReferenceParams;
import org.eclipse.lsp4j.ShowMessageRequestParams;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SignatureInformation;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceSymbolParams;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.DefinitionTestConfiguration;
import org.eclipse.xtext.testing.DocumentHighlightConfiguration;
import org.eclipse.xtext.testing.DocumentSymbolConfiguraiton;
import org.eclipse.xtext.testing.FileInfo;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.testing.HoverTestConfiguration;
import org.eclipse.xtext.testing.RangeFormattingConfiguration;
import org.eclipse.xtext.testing.ReferenceTestConfiguration;
import org.eclipse.xtext.testing.SignatureHelpConfiguration;
import org.eclipse.xtext.testing.TestCompletionConfiguration;
import org.eclipse.xtext.testing.TextDocumentConfiguration;
import org.eclipse.xtext.testing.WorkspaceSymbolConfiguraiton;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Before;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class AbstractLanguageServerTest implements LanguageClient {
  @Accessors
  protected final String fileExtension;
  
  @Before
  public void setup() {
    try {
      ServerModule _serverModule = new ServerModule();
      final Module module = Modules2.mixin(_serverModule, new AbstractModule() {
        @Override
        protected void configure() {
          AnnotatedBindingBuilder<RequestManager> _bind = this.<RequestManager>bind(RequestManager.class);
          _bind.toInstance(new RequestManager() {
            @Override
            public <V extends Object> CompletableFuture<V> runWrite(final Function1<? super CancelIndicator, ? extends V> writeRequest) {
              final CancelIndicator _function = () -> {
                return false;
              };
              V _apply = writeRequest.apply(_function);
              return CompletableFuture.<V>completedFuture(_apply);
            }
            
            @Override
            public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest) {
              final CancelIndicator _function = () -> {
                return false;
              };
              V _apply = readRequest.apply(_function);
              return CompletableFuture.<V>completedFuture(_apply);
            }
          });
        }
      });
      final Injector injector = Guice.createInjector(module);
      injector.injectMembers(this);
      Map<String, Object> _extensionToFactoryMap = this.resourceServerProviderRegistry.getExtensionToFactoryMap();
      final Object resourceServiceProvider = _extensionToFactoryMap.get(this.fileExtension);
      if ((resourceServiceProvider instanceof IResourceServiceProvider)) {
        LanguageInfo _get = ((IResourceServiceProvider)resourceServiceProvider).<LanguageInfo>get(LanguageInfo.class);
        this.languageInfo = _get;
      }
      this.languageServer.connect(this);
      this.languageServer.supportedMethods();
      File _file = new File("./test-data/test-project");
      this.root = _file;
      boolean _mkdirs = this.root.mkdirs();
      boolean _not = (!_mkdirs);
      if (_not) {
        Files.cleanFolder(this.root, null, true, false);
      }
      this.root.deleteOnExit();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  protected IResourceServiceProvider.Registry resourceServerProviderRegistry;
  
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  protected LanguageServerImpl languageServer;
  
  protected Map<String, List<? extends Diagnostic>> diagnostics = CollectionLiterals.<String, List<? extends Diagnostic>>newHashMap();
  
  protected File root;
  
  protected LanguageInfo languageInfo;
  
  protected Path getTestRootPath() {
    Path _path = this.root.toPath();
    Path _absolutePath = _path.toAbsolutePath();
    return _absolutePath.normalize();
  }
  
  protected Path relativize(final String uri) {
    try {
      Path _xblockexpression = null;
      {
        URI _uRI = new URI(uri);
        final Path path = Paths.get(_uRI);
        Path _testRootPath = this.getTestRootPath();
        _xblockexpression = _testRootPath.relativize(path);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected InitializeResult initialize() {
    return this.initialize(null);
  }
  
  protected InitializeResult initialize(final Procedure1<? super InitializeParams> initializer) {
    try {
      InitializeParams _initializeParams = new InitializeParams();
      final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
        it.setProcessId(Integer.valueOf(1));
        Path _testRootPath = this.getTestRootPath();
        String _string = _testRootPath.toString();
        it.setRootPath(_string);
      };
      final InitializeParams params = ObjectExtensions.<InitializeParams>operator_doubleArrow(_initializeParams, _function);
      if (initializer!=null) {
        initializer.apply(((InitializeParams) params));
      }
      CompletableFuture<InitializeResult> _initialize = this.languageServer.initialize(params);
      return _initialize.get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void open(final String fileUri, final String model) {
    String _languageName = this.languageInfo.getLanguageName();
    this.open(fileUri, _languageName, model);
  }
  
  protected void open(final String fileUri, final String langaugeId, final String model) {
    DidOpenTextDocumentParams _didOpenTextDocumentParams = new DidOpenTextDocumentParams();
    final Procedure1<DidOpenTextDocumentParams> _function = (DidOpenTextDocumentParams it) -> {
      it.setUri(fileUri);
      TextDocumentItem _textDocumentItem = new TextDocumentItem();
      final Procedure1<TextDocumentItem> _function_1 = (TextDocumentItem it_1) -> {
        it_1.setUri(fileUri);
        it_1.setLanguageId(langaugeId);
        it_1.setVersion(1);
        it_1.setText(model);
      };
      TextDocumentItem _doubleArrow = ObjectExtensions.<TextDocumentItem>operator_doubleArrow(_textDocumentItem, _function_1);
      it.setTextDocument(_doubleArrow);
    };
    DidOpenTextDocumentParams _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParams>operator_doubleArrow(_didOpenTextDocumentParams, _function);
    this.languageServer.didOpen(_doubleArrow);
  }
  
  protected void didCreateWatchedFiles(final String... fileUris) {
    DidChangeWatchedFilesParams _didChangeWatchedFilesParams = new DidChangeWatchedFilesParams();
    final Procedure1<DidChangeWatchedFilesParams> _function = (DidChangeWatchedFilesParams it) -> {
      for (final String fileUri : fileUris) {
        List<FileEvent> _changes = it.getChanges();
        FileEvent _fileEvent = new FileEvent();
        final Procedure1<FileEvent> _function_1 = (FileEvent it_1) -> {
          it_1.setUri(fileUri);
          it_1.setType(FileChangeType.Created);
        };
        FileEvent _doubleArrow = ObjectExtensions.<FileEvent>operator_doubleArrow(_fileEvent, _function_1);
        _changes.add(_doubleArrow);
      }
    };
    DidChangeWatchedFilesParams _doubleArrow = ObjectExtensions.<DidChangeWatchedFilesParams>operator_doubleArrow(_didChangeWatchedFilesParams, _function);
    this.languageServer.didChangeWatchedFiles(_doubleArrow);
  }
  
  protected void close(final String fileUri) {
    DidCloseTextDocumentParams _didCloseTextDocumentParams = new DidCloseTextDocumentParams();
    final Procedure1<DidCloseTextDocumentParams> _function = (DidCloseTextDocumentParams it) -> {
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
      it.setTextDocument(_textDocumentIdentifier);
    };
    DidCloseTextDocumentParams _doubleArrow = ObjectExtensions.<DidCloseTextDocumentParams>operator_doubleArrow(_didCloseTextDocumentParams, _function);
    this.languageServer.didClose(_doubleArrow);
  }
  
  public String writeFile(final String path, final CharSequence contents) {
    try {
      final File file = new File(this.root, path);
      File _parentFile = file.getParentFile();
      _parentFile.mkdirs();
      file.createNewFile();
      final FileWriter writer = new FileWriter(file);
      String _string = contents.toString();
      writer.write(_string);
      writer.close();
      URI _uRI = file.toURI();
      URI _normalize = _uRI.normalize();
      return this._uriExtensions.toPath(_normalize);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getVirtualFile(final String path) {
    final File file = new File(this.root, path);
    URI _uRI = file.toURI();
    URI _normalize = _uRI.normalize();
    return this._uriExtensions.toPath(_normalize);
  }
  
  protected String _toExpectation(final List<?> elements) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Object element : elements) {
        String _expectation = this.toExpectation(element);
        _builder.append(_expectation, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _toExpectation(final String it) {
    return it;
  }
  
  protected String _toExpectation(final Void it) {
    return "";
  }
  
  protected String _toExpectation(final Location it) {
    StringConcatenation _builder = new StringConcatenation();
    String _uri = it.getUri();
    Path _relativize = this.relativize(_uri);
    _builder.append(_relativize, "");
    _builder.append(" ");
    Range _range = it.getRange();
    String _expectation = this.toExpectation(_range);
    _builder.append(_expectation, "");
    return _builder.toString();
  }
  
  protected String _toExpectation(final Range it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    Position _start = it.getStart();
    String _expectation = this.toExpectation(_start);
    _builder.append(_expectation, "");
    _builder.append(" .. ");
    Position _end = it.getEnd();
    String _expectation_1 = this.toExpectation(_end);
    _builder.append(_expectation_1, "");
    _builder.append("]");
    return _builder.toString();
  }
  
  protected String _toExpectation(final Position it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    int _line = it.getLine();
    _builder.append(_line, "");
    _builder.append(", ");
    int _character = it.getCharacter();
    _builder.append(_character, "");
    _builder.append("]");
    return _builder.toString();
  }
  
  protected String _toExpectation(final SymbolInformation it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("symbol \"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("kind: ");
    SymbolKind _kind = it.getKind();
    int _value = _kind.getValue();
    _builder.append(_value, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("location: ");
    Location _location = it.getLocation();
    String _expectation = this.toExpectation(_location);
    _builder.append(_expectation, "    ");
    _builder.newLineIfNotEmpty();
    {
      String _containerName = it.getContainerName();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_containerName);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append("    ");
        _builder.append("container: \"");
        String _containerName_1 = it.getContainerName();
        _builder.append(_containerName_1, "    ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _toExpectation(final CompletionItem it) {
    StringConcatenation _builder = new StringConcatenation();
    String _label = it.getLabel();
    _builder.append(_label, "");
    {
      String _detail = it.getDetail();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_detail);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(" (");
        String _detail_1 = it.getDetail();
        _builder.append(_detail_1, "");
        _builder.append(")");
      }
    }
    {
      TextEdit _textEdit = it.getTextEdit();
      boolean _tripleNotEquals = (_textEdit != null);
      if (_tripleNotEquals) {
        _builder.append(" -> ");
        TextEdit _textEdit_1 = it.getTextEdit();
        String _expectation = this.toExpectation(_textEdit_1);
        _builder.append(_expectation, "");
      } else {
        if (((it.getInsertText() != null) && (!Objects.equal(it.getInsertText(), it.getLabel())))) {
          _builder.append(" -> ");
          String _insertText = it.getInsertText();
          _builder.append(_insertText, "");
        }
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _toExpectation(final TextEdit it) {
    StringConcatenation _builder = new StringConcatenation();
    String _newText = it.getNewText();
    _builder.append(_newText, "");
    _builder.append(" ");
    Range _range = it.getRange();
    String _expectation = this.toExpectation(_range);
    _builder.append(_expectation, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _toExpectation(final Hover it) {
    StringConcatenation _builder = new StringConcatenation();
    Range _range = it.getRange();
    String _expectation = this.toExpectation(_range);
    _builder.append(_expectation, "");
    _builder.newLineIfNotEmpty();
    {
      List<String> _contents = it.getContents();
      for(final String content : _contents) {
        String _expectation_1 = this.toExpectation(content);
        _builder.append(_expectation_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _toExpectation(final SignatureHelp it) {
    String _xblockexpression = null;
    {
      List<SignatureInformation> _signatures = it.getSignatures();
      int _size = _signatures.size();
      boolean _tripleEquals = (_size == 0);
      if (_tripleEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Signature index is expected to be null when no signatures are available. Was: ");
        Integer _activeSignature = it.getActiveSignature();
        _builder.append(_activeSignature, "");
        _builder.append(".");
        Integer _activeSignature_1 = it.getActiveSignature();
        Assert.assertNull(_builder.toString(), _activeSignature_1);
        return "<empty>";
      }
      Integer _activeSignature_2 = it.getActiveSignature();
      Assert.assertNotNull("Active signature index must not be null when signatures are available.", _activeSignature_2);
      String _xifexpression = null;
      Integer _activeParameter = it.getActiveParameter();
      boolean _tripleEquals_1 = (_activeParameter == null);
      if (_tripleEquals_1) {
        _xifexpression = "<empty>";
      } else {
        List<SignatureInformation> _signatures_1 = it.getSignatures();
        Integer _activeSignature_3 = it.getActiveSignature();
        SignatureInformation _get = _signatures_1.get((_activeSignature_3).intValue());
        List<ParameterInformation> _parameters = _get.getParameters();
        Integer _activeParameter_1 = it.getActiveParameter();
        ParameterInformation _get_1 = _parameters.get((_activeParameter_1).intValue());
        _xifexpression = _get_1.getLabel();
      }
      final String param = _xifexpression;
      StringConcatenation _builder_1 = new StringConcatenation();
      List<SignatureInformation> _signatures_2 = it.getSignatures();
      final Function1<SignatureInformation, String> _function = (SignatureInformation it_1) -> {
        return it_1.getLabel();
      };
      List<String> _map = ListExtensions.<SignatureInformation, String>map(_signatures_2, _function);
      String _join = IterableExtensions.join(_map, " | ");
      _builder_1.append(_join, "");
      _builder_1.append(" | ");
      _builder_1.append(param, "");
      _xblockexpression = _builder_1.toString();
    }
    return _xblockexpression;
  }
  
  protected String _toExpectation(final DocumentHighlight it) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      {
        Range _range = it.getRange();
        boolean _tripleEquals = (_range == null);
        if (_tripleEquals) {
          _builder.append("[NaN, NaN]:[NaN, NaN]");
        } else {
          Range _range_1 = it.getRange();
          String _expectation = this.toExpectation(_range_1);
          _builder.append(_expectation, "");
        }
      }
      final String rangeString = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        DocumentHighlightKind _kind = it.getKind();
        boolean _tripleEquals_1 = (_kind == null);
        if (_tripleEquals_1) {
          _builder_1.append("NaN");
        } else {
          DocumentHighlightKind _kind_1 = it.getKind();
          String _expectation_1 = this.toExpectation(_kind_1);
          _builder_1.append(_expectation_1, "");
        }
      }
      _builder_1.append(" ");
      _builder_1.append(rangeString, "");
      _xblockexpression = _builder_1.toString();
    }
    return _xblockexpression;
  }
  
  protected String _toExpectation(final DocumentHighlightKind kind) {
    String _string = kind.toString();
    String _substring = _string.substring(0, 1);
    return _substring.toUpperCase();
  }
  
  protected void testCompletion(final Procedure1<? super TestCompletionConfiguration> configurator) {
    try {
      @Extension
      final TestCompletionConfiguration configuration = new TestCompletionConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String filePath = _initializeContext.getUri();
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
      final Procedure1<TextDocumentPositionParams> _function = (TextDocumentPositionParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(filePath);
        it.setTextDocument(_textDocumentIdentifier);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        Position _position = new Position(_line, _column);
        it.setPosition(_position);
      };
      TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function);
      final CompletableFuture<CompletionList> completionItems = this.languageServer.completion(_doubleArrow);
      final CompletionList list = completionItems.get();
      List<CompletionItem> _items = list.getItems();
      List<CompletionItem> _items_1 = list.getItems();
      final Function1<CompletionItem, String> _function_1 = (CompletionItem it) -> {
        return it.getSortText();
      };
      List<CompletionItem> _sortBy = IterableExtensions.<CompletionItem, String>sortBy(_items_1, _function_1);
      List<CompletionItem> _list = IterableExtensions.<CompletionItem>toList(_sortBy);
      Assert.assertEquals(_items, _list);
      Procedure1<? super CompletionList> _assertCompletionList = configuration.getAssertCompletionList();
      boolean _tripleNotEquals = (_assertCompletionList != null);
      if (_tripleNotEquals) {
        Procedure1<? super CompletionList> _assertCompletionList_1 = configuration.getAssertCompletionList();
        _assertCompletionList_1.apply(list);
      } else {
        List<CompletionItem> _items_2 = list.getItems();
        final String actualCompletionItems = this.toExpectation(_items_2);
        String _expectedCompletionItems = configuration.getExpectedCompletionItems();
        this.assertEquals(_expectedCompletionItems, actualCompletionItems);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected FileInfo initializeContext(final TextDocumentConfiguration configuration) {
    this.initialize();
    Map<String, CharSequence> _filesInScope = configuration.getFilesInScope();
    boolean _isEmpty = _filesInScope.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Map<String, CharSequence> _filesInScope_1 = configuration.getFilesInScope();
      Set<Map.Entry<String, CharSequence>> _entrySet = _filesInScope_1.entrySet();
      final Function1<Map.Entry<String, CharSequence>, String> _function = (Map.Entry<String, CharSequence> it) -> {
        String _key = it.getKey();
        CharSequence _value = it.getValue();
        String _string = _value.toString();
        return this.writeFile(_key, _string);
      };
      final Iterable<String> createdFiles = IterableExtensions.<Map.Entry<String, CharSequence>, String>map(_entrySet, _function);
      this.didCreateWatchedFiles(((String[])Conversions.unwrapArray(createdFiles, String.class)));
      String _model = configuration.getModel();
      boolean _tripleEquals = (_model == null);
      if (_tripleEquals) {
        String _head = IterableExtensions.<String>head(createdFiles);
        Map<String, CharSequence> _filesInScope_2 = configuration.getFilesInScope();
        Set<Map.Entry<String, CharSequence>> _entrySet_1 = _filesInScope_2.entrySet();
        Map.Entry<String, CharSequence> _head_1 = IterableExtensions.<Map.Entry<String, CharSequence>>head(_entrySet_1);
        CharSequence _value = _head_1.getValue();
        String _string = _value.toString();
        return new FileInfo(_head, _string);
      }
    }
    String _model_1 = configuration.getModel();
    Assert.assertNotNull(_model_1);
    String _filePath = configuration.getFilePath();
    String _model_2 = configuration.getModel();
    final String filePath = this.writeFile(_filePath, _model_2);
    String _model_3 = configuration.getModel();
    this.open(filePath, _model_3);
    String _model_4 = configuration.getModel();
    return new FileInfo(filePath, _model_4);
  }
  
  protected void testDefinition(final Procedure1<? super DefinitionTestConfiguration> configurator) {
    try {
      @Extension
      final DefinitionTestConfiguration configuration = new DefinitionTestConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String fileUri = _initializeContext.getUri();
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
      final Procedure1<TextDocumentPositionParams> _function = (TextDocumentPositionParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
        it.setTextDocument(_textDocumentIdentifier);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        Position _position = new Position(_line, _column);
        it.setPosition(_position);
      };
      TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function);
      final CompletableFuture<List<? extends Location>> definitionsFuture = this.languageServer.definition(_doubleArrow);
      final List<? extends Location> definitions = definitionsFuture.get();
      Procedure1<? super List<? extends Location>> _assertDefinitions = configuration.getAssertDefinitions();
      boolean _tripleNotEquals = (_assertDefinitions != null);
      if (_tripleNotEquals) {
        Procedure1<? super List<? extends Location>> _assertDefinitions_1 = configuration.getAssertDefinitions();
        _assertDefinitions_1.apply(definitions);
      } else {
        final String actualDefinitions = this.toExpectation(definitions);
        String _expectedDefinitions = configuration.getExpectedDefinitions();
        this.assertEquals(_expectedDefinitions, actualDefinitions);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testHover(final Procedure1<? super HoverTestConfiguration> configurator) {
    try {
      @Extension
      final HoverTestConfiguration configuration = new HoverTestConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String fileUri = _initializeContext.getUri();
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
      final Procedure1<TextDocumentPositionParams> _function = (TextDocumentPositionParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
        it.setTextDocument(_textDocumentIdentifier);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        Position _position = new Position(_line, _column);
        it.setPosition(_position);
      };
      TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function);
      final CompletableFuture<Hover> hoverFuture = this.languageServer.hover(_doubleArrow);
      final Hover hover = hoverFuture.get();
      Procedure1<? super Hover> _assertHover = configuration.getAssertHover();
      boolean _tripleNotEquals = (_assertHover != null);
      if (_tripleNotEquals) {
        Procedure1<? super Hover> _assertHover_1 = configuration.getAssertHover();
        _assertHover_1.apply(hover);
      } else {
        final String actualHover = this.toExpectation(hover);
        String _expectedHover = configuration.getExpectedHover();
        this.assertEquals(_expectedHover, actualHover);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testSignatureHelp(final Procedure1<? super SignatureHelpConfiguration> configurator) {
    try {
      @Extension
      final SignatureHelpConfiguration configuration = new SignatureHelpConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String fileUri = _initializeContext.getUri();
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
      final Procedure1<TextDocumentPositionParams> _function = (TextDocumentPositionParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
        it.setTextDocument(_textDocumentIdentifier);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        Position _position = new Position(_line, _column);
        it.setPosition(_position);
      };
      TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function);
      final CompletableFuture<SignatureHelp> signatureHelpFuture = this.languageServer.signatureHelp(_doubleArrow);
      final SignatureHelp signatureHelp = signatureHelpFuture.get();
      Procedure1<? super SignatureHelp> _assertSignatureHelp = configuration.getAssertSignatureHelp();
      boolean _tripleNotEquals = (_assertSignatureHelp != null);
      if (_tripleNotEquals) {
        Procedure1<? super SignatureHelp> _assertSignatureHelp_1 = configuration.getAssertSignatureHelp();
        _assertSignatureHelp_1.apply(signatureHelp);
      } else {
        final String actualSignatureHelp = this.toExpectation(signatureHelp);
        String _expectedSignatureHelp = configuration.getExpectedSignatureHelp();
        String _trim = _expectedSignatureHelp.trim();
        String _trim_1 = actualSignatureHelp.trim();
        this.assertEquals(_trim, _trim_1);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testDocumentHighlight(final Procedure1<? super DocumentHighlightConfiguration> configurator) {
    try {
      DocumentHighlightConfiguration _documentHighlightConfiguration = new DocumentHighlightConfiguration();
      final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("MyModel.");
        _builder.append(this.fileExtension, "");
        it.setFilePath(_builder.toString());
      };
      @Extension
      final DocumentHighlightConfiguration configuration = ObjectExtensions.<DocumentHighlightConfiguration>operator_doubleArrow(_documentHighlightConfiguration, _function);
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String fileUri = _initializeContext.getUri();
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
      final Procedure1<TextDocumentPositionParams> _function_1 = (TextDocumentPositionParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
        it.setTextDocument(_textDocumentIdentifier);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        Position _position = new Position(_line, _column);
        it.setPosition(_position);
      };
      TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function_1);
      final CompletableFuture<List<? extends DocumentHighlight>> highlights = this.languageServer.documentHighlight(_doubleArrow);
      List<? extends DocumentHighlight> _get = highlights.get();
      final Function1<DocumentHighlight, String> _function_2 = (DocumentHighlight it) -> {
        return this.toExpectation(it);
      };
      List<String> _map = ListExtensions.map(_get, _function_2);
      final String actualDocumentHighlight = IterableExtensions.join(_map, " | ");
      String _expectedDocumentHighlight = configuration.getExpectedDocumentHighlight();
      this.assertEquals(_expectedDocumentHighlight, actualDocumentHighlight);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testDocumentSymbol(final Procedure1<? super DocumentSymbolConfiguraiton> configurator) {
    try {
      @Extension
      final DocumentSymbolConfiguraiton configuration = new DocumentSymbolConfiguraiton();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String fileUri = _initializeContext.getUri();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
      DocumentSymbolParams _documentSymbolParams = new DocumentSymbolParams(_textDocumentIdentifier);
      final CompletableFuture<List<? extends SymbolInformation>> symbolsFuture = this.languageServer.documentSymbol(_documentSymbolParams);
      final List<? extends SymbolInformation> symbols = symbolsFuture.get();
      Procedure1<? super List<? extends SymbolInformation>> _assertSymbols = configuration.getAssertSymbols();
      boolean _tripleNotEquals = (_assertSymbols != null);
      if (_tripleNotEquals) {
        Procedure1<? super List<? extends SymbolInformation>> _assertSymbols_1 = configuration.getAssertSymbols();
        _assertSymbols_1.apply(symbols);
      } else {
        final String actualSymbols = this.toExpectation(symbols);
        String _expectedSymbols = configuration.getExpectedSymbols();
        this.assertEquals(_expectedSymbols, actualSymbols);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testSymbol(final Procedure1<? super WorkspaceSymbolConfiguraiton> configurator) {
    try {
      @Extension
      final WorkspaceSymbolConfiguraiton configuration = new WorkspaceSymbolConfiguraiton();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      this.initializeContext(configuration);
      String _query = configuration.getQuery();
      WorkspaceSymbolParams _workspaceSymbolParams = new WorkspaceSymbolParams(_query);
      CompletableFuture<List<? extends SymbolInformation>> _symbol = this.languageServer.symbol(_workspaceSymbolParams);
      final List<? extends SymbolInformation> symbols = _symbol.get();
      Procedure1<? super List<? extends SymbolInformation>> _assertSymbols = configuration.getAssertSymbols();
      boolean _tripleNotEquals = (_assertSymbols != null);
      if (_tripleNotEquals) {
        Procedure1<? super List<? extends SymbolInformation>> _assertSymbols_1 = configuration.getAssertSymbols();
        _assertSymbols_1.apply(symbols);
      } else {
        final String actualSymbols = this.toExpectation(symbols);
        String _expectedSymbols = configuration.getExpectedSymbols();
        this.assertEquals(_expectedSymbols, actualSymbols);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testReferences(final Procedure1<? super ReferenceTestConfiguration> configurator) {
    try {
      @Extension
      final ReferenceTestConfiguration configuration = new ReferenceTestConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      FileInfo _initializeContext = this.initializeContext(configuration);
      final String fileUri = _initializeContext.getUri();
      ReferenceParams _referenceParams = new ReferenceParams();
      final Procedure1<ReferenceParams> _function = (ReferenceParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileUri);
        it.setTextDocument(_textDocumentIdentifier);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        Position _position = new Position(_line, _column);
        it.setPosition(_position);
        boolean _isIncludeDeclaration = configuration.isIncludeDeclaration();
        ReferenceContext _referenceContext = new ReferenceContext(_isIncludeDeclaration);
        it.setContext(_referenceContext);
      };
      ReferenceParams _doubleArrow = ObjectExtensions.<ReferenceParams>operator_doubleArrow(_referenceParams, _function);
      final CompletableFuture<List<? extends Location>> referencesFuture = this.languageServer.references(_doubleArrow);
      final List<? extends Location> references = referencesFuture.get();
      Procedure1<? super List<? extends Location>> _assertReferences = configuration.getAssertReferences();
      boolean _tripleNotEquals = (_assertReferences != null);
      if (_tripleNotEquals) {
        Procedure1<? super List<? extends Location>> _assertReferences_1 = configuration.getAssertReferences();
        _assertReferences_1.apply(references);
      } else {
        final String actualReferences = this.toExpectation(references);
        String _expectedReferences = configuration.getExpectedReferences();
        this.assertEquals(_expectedReferences, actualReferences);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertEquals(final String expected, final String actual) {
    String _replace = expected.replace("\t", "    ");
    String _replace_1 = actual.replace("\t", "    ");
    Assert.assertEquals(_replace, _replace_1);
  }
  
  protected void testFormatting(final Procedure1<? super FormattingConfiguration> configurator) {
    try {
      @Extension
      final FormattingConfiguration configuration = new FormattingConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      final FileInfo fileInfo = this.initializeContext(configuration);
      DocumentFormattingParams _documentFormattingParams = new DocumentFormattingParams();
      final Procedure1<DocumentFormattingParams> _function = (DocumentFormattingParams it) -> {
        String _uri = fileInfo.getUri();
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(_uri);
        it.setTextDocument(_textDocumentIdentifier);
      };
      DocumentFormattingParams _doubleArrow = ObjectExtensions.<DocumentFormattingParams>operator_doubleArrow(_documentFormattingParams, _function);
      final CompletableFuture<List<? extends TextEdit>> changes = this.languageServer.formatting(_doubleArrow);
      String _contents = fileInfo.getContents();
      Document _document = new Document(1, _contents);
      List<? extends TextEdit> _get = changes.get();
      ArrayList<TextEdit> _newArrayList = CollectionLiterals.<TextEdit>newArrayList(((TextEdit[])Conversions.unwrapArray(_get, TextEdit.class)));
      List<TextEdit> _reverse = ListExtensions.<TextEdit>reverse(_newArrayList);
      final Document result = _document.applyChanges(_reverse);
      String _expectedText = configuration.getExpectedText();
      String _contents_1 = result.getContents();
      this.assertEquals(_expectedText, _contents_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void testRangeFormatting(final Procedure1<? super RangeFormattingConfiguration> configurator) {
    try {
      @Extension
      final RangeFormattingConfiguration configuration = new RangeFormattingConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      final FileInfo fileInfo = this.initializeContext(configuration);
      DocumentRangeFormattingParams _documentRangeFormattingParams = new DocumentRangeFormattingParams();
      final Procedure1<DocumentRangeFormattingParams> _function = (DocumentRangeFormattingParams it) -> {
        String _uri = fileInfo.getUri();
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(_uri);
        it.setTextDocument(_textDocumentIdentifier);
        Range _range = configuration.getRange();
        it.setRange(_range);
      };
      DocumentRangeFormattingParams _doubleArrow = ObjectExtensions.<DocumentRangeFormattingParams>operator_doubleArrow(_documentRangeFormattingParams, _function);
      final CompletableFuture<List<? extends TextEdit>> changes = this.languageServer.rangeFormatting(_doubleArrow);
      String _contents = fileInfo.getContents();
      Document _document = new Document(1, _contents);
      List<? extends TextEdit> _get = changes.get();
      ArrayList<TextEdit> _newArrayList = CollectionLiterals.<TextEdit>newArrayList(((TextEdit[])Conversions.unwrapArray(_get, TextEdit.class)));
      List<TextEdit> _reverse = ListExtensions.<TextEdit>reverse(_newArrayList);
      final Document result = _document.applyChanges(_reverse);
      String _expectedText = configuration.getExpectedText();
      String _contents_1 = result.getContents();
      this.assertEquals(_expectedText, _contents_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void logMessage(final MessageParams message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void publishDiagnostics(final PublishDiagnosticsParams diagnostics) {
    String _uri = diagnostics.getUri();
    List<Diagnostic> _diagnostics = diagnostics.getDiagnostics();
    this.diagnostics.put(_uri, _diagnostics);
  }
  
  @Override
  public void showMessage(final MessageParams messageParams) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public CompletableFuture<Void> showMessageRequest(final ShowMessageRequestParams requestParams) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void telemetryEvent(final Object object) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected String toExpectation(final Object elements) {
    if (elements instanceof List) {
      return _toExpectation((List<?>)elements);
    } else if (elements instanceof DocumentHighlightKind) {
      return _toExpectation((DocumentHighlightKind)elements);
    } else if (elements instanceof String) {
      return _toExpectation((String)elements);
    } else if (elements == null) {
      return _toExpectation((Void)null);
    } else if (elements instanceof CompletionItem) {
      return _toExpectation((CompletionItem)elements);
    } else if (elements instanceof DocumentHighlight) {
      return _toExpectation((DocumentHighlight)elements);
    } else if (elements instanceof Hover) {
      return _toExpectation((Hover)elements);
    } else if (elements instanceof Location) {
      return _toExpectation((Location)elements);
    } else if (elements instanceof Position) {
      return _toExpectation((Position)elements);
    } else if (elements instanceof Range) {
      return _toExpectation((Range)elements);
    } else if (elements instanceof SignatureHelp) {
      return _toExpectation((SignatureHelp)elements);
    } else if (elements instanceof SymbolInformation) {
      return _toExpectation((SymbolInformation)elements);
    } else if (elements instanceof TextEdit) {
      return _toExpectation((TextEdit)elements);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(elements).toString());
    }
  }
  
  public AbstractLanguageServerTest(final String fileExtension) {
    super();
    this.fileExtension = fileExtension;
  }
  
  @Pure
  public String getFileExtension() {
    return this.fileExtension;
  }
}
