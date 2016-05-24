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
import io.typefox.lsapi.NotificationCallback;
import io.typefox.lsapi.PublishDiagnosticsParams;
import io.typefox.lsapi.TextDocumentService;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Before;

/**
 * @author efftinge - Initial contribution and API
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
  protected LanguageServerImpl languageServer;
  
  protected Map<String, List<? extends Diagnostic>> diagnostics = CollectionLiterals.<String, List<? extends Diagnostic>>newHashMap();
  
  protected File root;
  
  public String operator_mappedTo(final String path, final CharSequence contents) {
    try {
      final File file = new File(this.root, path);
      File _parentFile = file.getParentFile();
      _parentFile.mkdirs();
      file.createNewFile();
      FileWriter _fileWriter = new FileWriter(file);
      final Procedure1<FileWriter> _function = new Procedure1<FileWriter>() {
        @Override
        public void apply(final FileWriter it) {
          try {
            String _string = contents.toString();
            it.write(_string);
            it.close();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<FileWriter>operator_doubleArrow(_fileWriter, _function);
      String _absolutePath = file.getAbsolutePath();
      String _absolutePath_1 = this.root.getAbsolutePath();
      int _length = _absolutePath_1.length();
      return _absolutePath.substring(_length);
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
}
