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
import io.typefox.lsapi.InitializeParamsImpl;
import io.typefox.lsapi.NotificationCallback;
import io.typefox.lsapi.PublishDiagnosticsParams;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.TextDocumentServiceImpl;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageStandaloneSetup;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerTest implements NotificationCallback<PublishDiagnosticsParams> {
  @Before
  public void setup() {
    ServerModule _serverModule = new ServerModule();
    final Injector injector = Guice.createInjector(_serverModule);
    injector.injectMembers(this);
  }
  
  @Inject
  public Object voidRegisterTestLanguage(final IResourceServiceProvider.Registry registry) {
    Object _xblockexpression = null;
    {
      TestLanguageStandaloneSetup _testLanguageStandaloneSetup = new TestLanguageStandaloneSetup();
      final Injector injector = _testLanguageStandaloneSetup.createInjectorAndDoEMFRegistration();
      Map<String, Object> _extensionToFactoryMap = registry.getExtensionToFactoryMap();
      FileExtensionProvider _instance = injector.<FileExtensionProvider>getInstance(FileExtensionProvider.class);
      String _primaryFileExtension = _instance.getPrimaryFileExtension();
      IResourceServiceProvider _instance_1 = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
      _xblockexpression = _extensionToFactoryMap.put(_primaryFileExtension, _instance_1);
    }
    return _xblockexpression;
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  @Test
  public void testInitializeBuild() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("string foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.operator_mappedTo(
      "MyType1.testlang", _builder);
    TextDocumentServiceImpl _textDocumentService = this.languageServer.getTextDocumentService();
    _textDocumentService.onPublishDiagnostics(this);
    InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
    final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
      @Override
      public void apply(final InitializeParamsImpl it) {
        String _absolutePath = ServerTest.this.root.getAbsolutePath();
        it.setRootPath(_absolutePath);
      }
    };
    InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
    this.languageServer.initialize(_doubleArrow);
    String _join = IterableExtensions.join(this.diagnosticNotifications, ",");
    boolean _isEmpty = this.diagnosticNotifications.isEmpty();
    Assert.assertTrue(_join, _isEmpty);
  }
  
  @Test
  public void testInitializeBuildWithError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.operator_mappedTo(
      "MyType1.testlang", _builder);
    TextDocumentServiceImpl _textDocumentService = this.languageServer.getTextDocumentService();
    _textDocumentService.onPublishDiagnostics(this);
    InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
    final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
      @Override
      public void apply(final InitializeParamsImpl it) {
        String _absolutePath = ServerTest.this.root.getAbsolutePath();
        it.setRootPath(_absolutePath);
      }
    };
    InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
    this.languageServer.initialize(_doubleArrow);
    PublishDiagnosticsParams _head = IterableExtensions.<PublishDiagnosticsParams>head(this.diagnosticNotifications);
    List<? extends Diagnostic> _diagnostics = _head.getDiagnostics();
    Diagnostic _head_1 = IterableExtensions.head(_diagnostics);
    String _message = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to Type \'NonExisting\'.", _message);
  }
  
  private final File root = ObjectExtensions.<File>operator_doubleArrow(new File("./test-data/test-project"), new Procedure1<File>() {
    @Override
    public void apply(final File it) {
      it.mkdirs();
      it.deleteOnExit();
    }
  });
  
  public void operator_mappedTo(final String path, final CharSequence contents) {
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
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private List<PublishDiagnosticsParams> diagnosticNotifications = CollectionLiterals.<PublishDiagnosticsParams>newArrayList();
  
  @Override
  public void onNotification(final PublishDiagnosticsParams t) {
    this.diagnosticNotifications.add(t);
  }
}
