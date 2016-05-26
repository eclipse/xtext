/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidOpenTextDocumentParamsImpl;
import io.typefox.lsapi.InitializeParamsImpl;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.Location;
import io.typefox.lsapi.NotificationCallback;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.TextDocumentIdentifierImpl;
import io.typefox.lsapi.TextDocumentItemImpl;
import io.typefox.lsapi.TextDocumentPositionParamsImpl;
import io.typefox.lsapi.TextDocumentService;
import io.typefox.lsapi.util.LsapiFactories;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbstractLanguageServerTest implements NotificationCallback<PublishDiagnosticsParams> {
  @Before
  public void setup() {
    try {
      ServerModule _serverModule = new ServerModule();
      final Injector injector = Guice.createInjector(_serverModule);
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
    final InitializeParamsImpl params = new InitializeParamsImpl();
    Path _rootPath = this.getRootPath();
    String _string = _rootPath.toString();
    params.setRootPath(_string);
    if (initializer!=null) {
      initializer.apply(params);
    }
    return this.languageServer.initialize(params);
  }
  
  protected void open(final String fileUri, final String model) {
    DidOpenTextDocumentParamsImpl _didOpenTextDocumentParamsImpl = new DidOpenTextDocumentParamsImpl();
    final Procedure1<DidOpenTextDocumentParamsImpl> _function = new Procedure1<DidOpenTextDocumentParamsImpl>() {
      @Override
      public void apply(final DidOpenTextDocumentParamsImpl it) {
        TextDocumentItemImpl _textDocumentItemImpl = new TextDocumentItemImpl();
        final Procedure1<TextDocumentItemImpl> _function = new Procedure1<TextDocumentItemImpl>() {
          @Override
          public void apply(final TextDocumentItemImpl it) {
            it.setUri(fileUri);
            it.setVersion(1);
            it.setText(model);
          }
        };
        TextDocumentItemImpl _doubleArrow = ObjectExtensions.<TextDocumentItemImpl>operator_doubleArrow(_textDocumentItemImpl, _function);
        it.setTextDocument(_doubleArrow);
      }
    };
    DidOpenTextDocumentParamsImpl _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParamsImpl>operator_doubleArrow(_didOpenTextDocumentParamsImpl, _function);
    this.languageServer.didOpen(_doubleArrow);
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
  public void call(final PublishDiagnosticsParams t) {
    String _uri = t.getUri();
    List<? extends Diagnostic> _diagnostics = t.getDiagnostics();
    this.diagnostics.put(_uri, _diagnostics);
  }
  
  protected TextDocumentPositionParamsImpl newPosition(final String uri, final int line, final int column) {
    final TextDocumentPositionParamsImpl params = new TextDocumentPositionParamsImpl();
    TextDocumentIdentifierImpl _newIdentifier = this.newIdentifier(uri);
    params.setTextDocument(_newIdentifier);
    PositionImpl _newPosition = LsapiFactories.newPosition(line, column);
    params.setPosition(_newPosition);
    return params;
  }
  
  protected TextDocumentIdentifierImpl newIdentifier(final String uri) {
    final TextDocumentIdentifierImpl identifier = new TextDocumentIdentifierImpl();
    identifier.setUri(uri);
    return identifier;
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
