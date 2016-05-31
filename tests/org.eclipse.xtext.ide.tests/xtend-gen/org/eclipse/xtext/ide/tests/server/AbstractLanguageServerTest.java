/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidCloseTextDocumentParamsImpl;
import io.typefox.lsapi.DidOpenTextDocumentParamsImpl;
import io.typefox.lsapi.InitializeParamsImpl;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.services.TextDocumentService;
import io.typefox.lsapi.util.LsapiFactories;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbstractLanguageServerTest implements Consumer<PublishDiagnosticsParams> {
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
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  protected LanguageServerImpl languageServer;
  
  protected Map<String, List<? extends Diagnostic>> diagnostics = CollectionLiterals.<String, List<? extends Diagnostic>>newHashMap();
  
  protected File root;
  
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
      Path _rootPath = this.getRootPath();
      String _string = _rootPath.toString();
      final InitializeParamsImpl params = LsapiFactories.newInitializeParams(1, _string);
      if (initializer!=null) {
        initializer.apply(params);
      }
      CompletableFuture<InitializeResult> _initialize = this.languageServer.initialize(params);
      return _initialize.get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void open(final String fileUri, final String model) {
    DidOpenTextDocumentParamsImpl _newDidOpenTextDocumentParams = LsapiFactories.newDidOpenTextDocumentParams(fileUri, "testlang", 1, model);
    this.languageServer.didOpen(_newDidOpenTextDocumentParams);
  }
  
  protected void close(final String fileUri) {
    DidCloseTextDocumentParamsImpl _newDidCloseTextDocumentParams = LsapiFactories.newDidCloseTextDocumentParams(fileUri);
    this.languageServer.didClose(_newDidCloseTextDocumentParams);
  }
  
  public String operator_mappedTo(final String path, final CharSequence contents) {
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
  
  protected String toExpectation(final Object elements) {
    if (elements instanceof List) {
      return _toExpectation((List<?>)elements);
    } else if (elements instanceof Location) {
      return _toExpectation((Location)elements);
    } else if (elements instanceof Position) {
      return _toExpectation((Position)elements);
    } else if (elements instanceof Range) {
      return _toExpectation((Range)elements);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(elements).toString());
    }
  }
}
