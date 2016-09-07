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
import io.typefox.lsapi.CompletionItem;
import io.typefox.lsapi.CompletionList;
import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidCloseTextDocumentParams;
import io.typefox.lsapi.DidOpenTextDocumentParams;
import io.typefox.lsapi.DocumentFormattingParams;
import io.typefox.lsapi.DocumentRangeFormattingParams;
import io.typefox.lsapi.Hover;
import io.typefox.lsapi.InitializeParams;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.MarkedString;
import io.typefox.lsapi.ParameterInformation;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.ReferenceParams;
import io.typefox.lsapi.SignatureHelp;
import io.typefox.lsapi.SignatureInformation;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.SymbolKind;
import io.typefox.lsapi.TextDocumentPositionParams;
import io.typefox.lsapi.TextEdit;
import io.typefox.lsapi.builders.DidCloseTextDocumentParamsBuilder;
import io.typefox.lsapi.builders.DidOpenTextDocumentParamsBuilder;
import io.typefox.lsapi.builders.DocumentFormattingParamsBuilder;
import io.typefox.lsapi.builders.DocumentRangeFormattingParamsBuilder;
import io.typefox.lsapi.builders.InitializeParamsBuilder;
import io.typefox.lsapi.builders.ReferenceParamsBuilder;
import io.typefox.lsapi.builders.TextDocumentItemBuilder;
import io.typefox.lsapi.builders.TextDocumentPositionParamsBuilder;
import io.typefox.lsapi.impl.DocumentSymbolParamsImpl;
import io.typefox.lsapi.impl.InitializeParamsImpl;
import io.typefox.lsapi.impl.TextDocumentIdentifierImpl;
import io.typefox.lsapi.impl.WorkspaceSymbolParamsImpl;
import io.typefox.lsapi.services.TextDocumentService;
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
import java.util.function.Consumer;
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
import org.eclipse.xtext.testing.DocumentSymbolConfiguraiton;
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
public abstract class AbstractLanguageServerTest implements Consumer<PublishDiagnosticsParams> {
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
            public CompletableFuture<Void> runWrite(final Procedure1<? super CancelIndicator> writeRequest, final CancelIndicator cancelIndicator) {
              writeRequest.apply(cancelIndicator);
              return CompletableFuture.<Void>completedFuture(null);
            }
            
            @Override
            public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest, final CancelIndicator cancelIndicator) {
              V _apply = readRequest.apply(cancelIndicator);
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
      TextDocumentService _textDocumentService = this.languageServer.getTextDocumentService();
      _textDocumentService.onPublishDiagnostics(this);
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
  
  protected Path getRootPath() {
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
        Path _rootPath = this.getRootPath();
        _xblockexpression = _rootPath.relativize(path);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected InitializeResult initialize() {
    return this.initialize(null);
  }
  
  protected InitializeResult initialize(final Procedure1<? super InitializeParamsImpl> initializer) {
    try {
      final Procedure1<InitializeParamsBuilder> _function = (InitializeParamsBuilder it) -> {
        it.processId(Integer.valueOf(1));
        Path _rootPath = this.getRootPath();
        String _string = _rootPath.toString();
        it.rootPath(_string);
      };
      InitializeParamsBuilder _initializeParamsBuilder = new InitializeParamsBuilder(_function);
      final InitializeParams params = _initializeParamsBuilder.build();
      if (initializer!=null) {
        initializer.apply(((InitializeParamsImpl) params));
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
    final Procedure1<DidOpenTextDocumentParamsBuilder> _function = (DidOpenTextDocumentParamsBuilder it) -> {
      it.uri(fileUri);
      final Procedure1<TextDocumentItemBuilder> _function_1 = (TextDocumentItemBuilder it_1) -> {
        it_1.uri(fileUri);
        it_1.languageId(langaugeId);
        it_1.version(1);
        it_1.text(model);
      };
      it.textDocument(_function_1);
    };
    DidOpenTextDocumentParamsBuilder _didOpenTextDocumentParamsBuilder = new DidOpenTextDocumentParamsBuilder(_function);
    DidOpenTextDocumentParams _build = _didOpenTextDocumentParamsBuilder.build();
    this.languageServer.didOpen(_build);
  }
  
  protected void close(final String fileUri) {
    final Procedure1<DidCloseTextDocumentParamsBuilder> _function = (DidCloseTextDocumentParamsBuilder it) -> {
      it.textDocument(fileUri);
    };
    DidCloseTextDocumentParamsBuilder _didCloseTextDocumentParamsBuilder = new DidCloseTextDocumentParamsBuilder(_function);
    DidCloseTextDocumentParams _build = _didCloseTextDocumentParamsBuilder.build();
    this.languageServer.didClose(_build);
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
  
  @Override
  public void accept(final PublishDiagnosticsParams t) {
    String _uri = t.getUri();
    List<? extends Diagnostic> _diagnostics = t.getDiagnostics();
    this.diagnostics.put(_uri, _diagnostics);
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
      List<? extends MarkedString> _contents = it.getContents();
      for(final MarkedString content : _contents) {
        String _expectation_1 = this.toExpectation(content);
        _builder.append(_expectation_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _toExpectation(final MarkedString it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _language = it.getLanguage();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_language);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        String _language_1 = it.getLanguage();
        _builder.append(_language_1, "");
        _builder.append(" -> ");
      }
    }
    String _value = it.getValue();
    _builder.append(_value, "");
    return _builder.toString();
  }
  
  protected String _toExpectation(final SignatureHelp it) {
    String _xblockexpression = null;
    {
      List<? extends SignatureInformation> _signatures = it.getSignatures();
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
        List<? extends SignatureInformation> _signatures_1 = it.getSignatures();
        Integer _activeSignature_3 = it.getActiveSignature();
        SignatureInformation _get = _signatures_1.get((_activeSignature_3).intValue());
        List<? extends ParameterInformation> _parameters = _get.getParameters();
        Integer _activeParameter_1 = it.getActiveParameter();
        ParameterInformation _get_1 = _parameters.get((_activeParameter_1).intValue());
        _xifexpression = _get_1.getLabel();
      }
      final String param = _xifexpression;
      StringConcatenation _builder_1 = new StringConcatenation();
      List<? extends SignatureInformation> _signatures_2 = it.getSignatures();
      final Function1<SignatureInformation, String> _function = (SignatureInformation it_1) -> {
        return it_1.getLabel();
      };
      List<String> _map = ListExtensions.map(_signatures_2, _function);
      String _join = IterableExtensions.join(_map, " | ");
      _builder_1.append(_join, "");
      _builder_1.append(" | ");
      _builder_1.append(param, "");
      _xblockexpression = _builder_1.toString();
    }
    return _xblockexpression;
  }
  
  protected void testCompletion(final Procedure1<? super TestCompletionConfiguration> configurator) {
    try {
      @Extension
      final TestCompletionConfiguration configuration = new TestCompletionConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<TextDocumentPositionParamsBuilder> _function = (TextDocumentPositionParamsBuilder it) -> {
        it.textDocument(fileUri);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        it.position(_line, _column);
      };
      TextDocumentPositionParamsBuilder _textDocumentPositionParamsBuilder = new TextDocumentPositionParamsBuilder(_function);
      TextDocumentPositionParams _build = _textDocumentPositionParamsBuilder.build();
      final CompletableFuture<CompletionList> completionItems = this.languageServer.completion(_build);
      CompletionList _get = completionItems.get();
      List<? extends CompletionItem> _items = _get.getItems();
      final String actualCompletionItems = this.toExpectation(_items);
      String _expectedCompletionItems = configuration.getExpectedCompletionItems();
      this.assertEquals(_expectedCompletionItems, actualCompletionItems);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String initializeContext(final TextDocumentConfiguration configuration) {
    this.initialize();
    Map<String, CharSequence> _filesInScope = configuration.getFilesInScope();
    Set<Map.Entry<String, CharSequence>> _entrySet = _filesInScope.entrySet();
    for (final Map.Entry<String, CharSequence> e : _entrySet) {
      {
        String _key = e.getKey();
        CharSequence _value = e.getValue();
        String _string = _value.toString();
        final String filePath = this.writeFile(_key, _string);
        CharSequence _value_1 = e.getValue();
        String _string_1 = _value_1.toString();
        this.open(filePath, _string_1);
      }
    }
    String _filePath = configuration.getFilePath();
    String _model = configuration.getModel();
    final String filePath = this.writeFile(_filePath, _model);
    String _model_1 = configuration.getModel();
    this.open(filePath, _model_1);
    return filePath;
  }
  
  protected void testDefinition(final Procedure1<? super DefinitionTestConfiguration> configurator) {
    try {
      @Extension
      final DefinitionTestConfiguration configuration = new DefinitionTestConfiguration();
      configuration.setFilePath(("MyModel." + this.fileExtension));
      configurator.apply(configuration);
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<TextDocumentPositionParamsBuilder> _function = (TextDocumentPositionParamsBuilder it) -> {
        it.textDocument(fileUri);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        it.position(_line, _column);
      };
      TextDocumentPositionParamsBuilder _textDocumentPositionParamsBuilder = new TextDocumentPositionParamsBuilder(_function);
      TextDocumentPositionParams _build = _textDocumentPositionParamsBuilder.build();
      final CompletableFuture<List<? extends Location>> definitions = this.languageServer.definition(_build);
      List<? extends Location> _get = definitions.get();
      final String actualDefinitions = this.toExpectation(_get);
      String _expectedDefinitions = configuration.getExpectedDefinitions();
      this.assertEquals(_expectedDefinitions, actualDefinitions);
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
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<TextDocumentPositionParamsBuilder> _function = (TextDocumentPositionParamsBuilder it) -> {
        it.textDocument(fileUri);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        it.position(_line, _column);
      };
      TextDocumentPositionParamsBuilder _textDocumentPositionParamsBuilder = new TextDocumentPositionParamsBuilder(_function);
      TextDocumentPositionParams _build = _textDocumentPositionParamsBuilder.build();
      final CompletableFuture<Hover> hover = this.languageServer.hover(_build);
      Hover _get = hover.get();
      final String actualHover = this.toExpectation(_get);
      String _expectedHover = configuration.getExpectedHover();
      this.assertEquals(_expectedHover, actualHover);
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
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<TextDocumentPositionParamsBuilder> _function = (TextDocumentPositionParamsBuilder it) -> {
        it.textDocument(fileUri);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        it.position(_line, _column);
      };
      TextDocumentPositionParamsBuilder _textDocumentPositionParamsBuilder = new TextDocumentPositionParamsBuilder(_function);
      TextDocumentPositionParams _build = _textDocumentPositionParamsBuilder.build();
      final CompletableFuture<SignatureHelp> signatureHelps = this.languageServer.signatureHelp(_build);
      SignatureHelp _get = signatureHelps.get();
      final String actualHover = this.toExpectation(_get);
      String _expectedSignatureHelp = configuration.getExpectedSignatureHelp();
      this.assertEquals(_expectedSignatureHelp, actualHover);
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
      final String fileUri = this.initializeContext(configuration);
      TextDocumentIdentifierImpl _textDocumentIdentifierImpl = new TextDocumentIdentifierImpl(fileUri);
      DocumentSymbolParamsImpl _documentSymbolParamsImpl = new DocumentSymbolParamsImpl(_textDocumentIdentifierImpl);
      final CompletableFuture<List<? extends SymbolInformation>> symbols = this.languageServer.documentSymbol(_documentSymbolParamsImpl);
      List<? extends SymbolInformation> _get = symbols.get();
      final String actualSymbols = this.toExpectation(_get);
      String _expectedSymbols = configuration.getExpectedSymbols();
      this.assertEquals(_expectedSymbols, actualSymbols);
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
      WorkspaceSymbolParamsImpl _workspaceSymbolParamsImpl = new WorkspaceSymbolParamsImpl(_query);
      CompletableFuture<List<? extends SymbolInformation>> _symbol = this.languageServer.symbol(_workspaceSymbolParamsImpl);
      final List<? extends SymbolInformation> symbols = _symbol.get();
      final String actualSymbols = this.toExpectation(symbols);
      String _expectedSymbols = configuration.getExpectedSymbols();
      this.assertEquals(_expectedSymbols, actualSymbols);
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
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<ReferenceParamsBuilder> _function = (ReferenceParamsBuilder it) -> {
        it.textDocument(fileUri);
        int _line = configuration.getLine();
        int _column = configuration.getColumn();
        it.position(_line, _column);
        boolean _isIncludeDeclaration = configuration.isIncludeDeclaration();
        it.context(_isIncludeDeclaration);
      };
      ReferenceParamsBuilder _referenceParamsBuilder = new ReferenceParamsBuilder(_function);
      ReferenceParams _build = _referenceParamsBuilder.build();
      final CompletableFuture<List<? extends Location>> definitions = this.languageServer.references(_build);
      List<? extends Location> _get = definitions.get();
      final String actualDefinitions = this.toExpectation(_get);
      String _expectedReferences = configuration.getExpectedReferences();
      this.assertEquals(_expectedReferences, actualDefinitions);
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
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<DocumentFormattingParamsBuilder> _function = (DocumentFormattingParamsBuilder it) -> {
        it.textDocument(fileUri);
      };
      DocumentFormattingParamsBuilder _documentFormattingParamsBuilder = new DocumentFormattingParamsBuilder(_function);
      DocumentFormattingParams _build = _documentFormattingParamsBuilder.build();
      final CompletableFuture<List<? extends TextEdit>> changes = this.languageServer.formatting(_build);
      String _model = configuration.getModel();
      Document _document = new Document(1, _model);
      List<? extends TextEdit> _get = changes.get();
      ArrayList<TextEdit> _newArrayList = CollectionLiterals.<TextEdit>newArrayList(((TextEdit[])Conversions.unwrapArray(_get, TextEdit.class)));
      List<TextEdit> _reverse = ListExtensions.<TextEdit>reverse(_newArrayList);
      final Document result = _document.applyChanges(_reverse);
      String _expectedText = configuration.getExpectedText();
      String _contents = result.getContents();
      this.assertEquals(_expectedText, _contents);
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
      final String fileUri = this.initializeContext(configuration);
      final Procedure1<DocumentRangeFormattingParamsBuilder> _function = (DocumentRangeFormattingParamsBuilder it) -> {
        it.textDocument(fileUri);
        Range _range = configuration.getRange();
        it.range(_range);
      };
      DocumentRangeFormattingParamsBuilder _documentRangeFormattingParamsBuilder = new DocumentRangeFormattingParamsBuilder(_function);
      DocumentRangeFormattingParams _build = _documentRangeFormattingParamsBuilder.build();
      final CompletableFuture<List<? extends TextEdit>> changes = this.languageServer.rangeFormatting(_build);
      String _model = configuration.getModel();
      Document _document = new Document(1, _model);
      List<? extends TextEdit> _get = changes.get();
      ArrayList<TextEdit> _newArrayList = CollectionLiterals.<TextEdit>newArrayList(((TextEdit[])Conversions.unwrapArray(_get, TextEdit.class)));
      List<TextEdit> _reverse = ListExtensions.<TextEdit>reverse(_newArrayList);
      final Document result = _document.applyChanges(_reverse);
      String _expectedText = configuration.getExpectedText();
      String _contents = result.getContents();
      this.assertEquals(_expectedText, _contents);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String toExpectation(final Object elements) {
    if (elements instanceof List) {
      return _toExpectation((List<?>)elements);
    } else if (elements instanceof CompletionItem) {
      return _toExpectation((CompletionItem)elements);
    } else if (elements instanceof Hover) {
      return _toExpectation((Hover)elements);
    } else if (elements instanceof Location) {
      return _toExpectation((Location)elements);
    } else if (elements instanceof MarkedString) {
      return _toExpectation((MarkedString)elements);
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
    } else if (elements == null) {
      return _toExpectation((Void)null);
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
