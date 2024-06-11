/**
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import com.google.common.annotations.Beta;
import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Sven Efftinge - Initial contribution and API
 *         Rubén Porras Campo - Semantic Tokens Full
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public abstract class AbstractLanguageServerTest /* implements Endpoint  */{
  /**
   * A request manager that will run the given read and write actions in the same thread immediately, sequentially.
   */
  @Singleton
  public static class DirectRequestManager extends RequestManager {
    @Inject
    public DirectRequestManager(final OperationCanceledManager operationCanceledManager) {
      super(null, operationCanceledManager);
    }

    @Override
    public synchronized <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> request) {
      final CompletableFuture<V> result = new CompletableFuture<V>();
      try {
        final CancelIndicator _function = () -> {
          return false;
        };
        result.complete(request.apply(_function));
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          boolean _isCancelException = this.isCancelException(t);
          if (_isCancelException) {
            result.cancel(true);
          } else {
            result.completeExceptionally(t);
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return result;
    }

    @Override
    public synchronized <U extends Object, V extends Object> CompletableFuture<V> runWrite(final Function0<? extends U> nonCancellable, final Function2<? super CancelIndicator, ? super U, ? extends V> request) {
      final CompletableFuture<V> result = new CompletableFuture<V>();
      try {
        result.complete(request.apply(CancelIndicator.NullImpl, nonCancellable.apply()));
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          boolean _isCancelException = this.isCancelException(t);
          if (_isCancelException) {
            result.cancel(true);
          } else {
            result.completeExceptionally(t);
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return result;
    }
  }

  @Accessors
  public static class TestCodeLensConfiguration extends TextDocumentPositionConfiguration {
    private String expectedCodeLensItems = "";

    private /* Procedure1<? super List<? extends CodeLens>> */Object assertCodeLenses = null;

    @Pure
    public String getExpectedCodeLensItems() {
      return this.expectedCodeLensItems;
    }

    public void setExpectedCodeLensItems(final String expectedCodeLensItems) {
      this.expectedCodeLensItems = expectedCodeLensItems;
    }

    @Pure
    public /* Procedure1<? super List<? extends CodeLens>> */Object getAssertCodeLenses() {
      return this.assertCodeLenses;
    }

    public void setAssertCodeLenses(final /* Procedure1<? super List<? extends CodeLens>> */Object assertCodeLenses) {
      this.assertCodeLenses = assertCodeLenses;
    }
  }

  @Accessors
  public static class TestCodeActionConfiguration extends TextDocumentPositionConfiguration {
    private String expectedCodeActions = "";

    private /* Procedure1<? super List<Either<Command, CodeAction>>> */Object assertCodeActions = null;

    @Pure
    public String getExpectedCodeActions() {
      return this.expectedCodeActions;
    }

    public void setExpectedCodeActions(final String expectedCodeActions) {
      this.expectedCodeActions = expectedCodeActions;
    }

    @Pure
    public /* Procedure1<? super List<Either>> */Object getAssertCodeActions() {
      return this.assertCodeActions;
    }

    public void setAssertCodeActions(final /* Procedure1<? super List<Either>> */Object assertCodeActions) {
      this.assertCodeActions = assertCodeActions;
    }
  }

  @Accessors
  protected final String fileExtension;

  protected static final String TEST_PROJECT_PATH = "/test-data/test-project";

  @Before
  @BeforeEach
  public void setup() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method connect(Object) is undefined for the type LanguageServerImpl"
      + "\nThe method or field ServiceEndpoints is undefined"
      + "\nThe method supportedMethods() is undefined for the type LanguageServerImpl"
      + "\nThe method getLanguageClientClass() from the type AbstractLanguageServerTest refers to the missing type LanguageClient"
      + "\ntoServiceObject cannot be resolved");
  }

  @After
  @AfterEach
  public void cleanup() {
    try {
      boolean _exists = this.root.exists();
      if (_exists) {
        Files.cleanFolder(this.root, null, true, true);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * @since 2.18
   */
  protected /* Class<? extends LanguageClient> */Object getLanguageClientClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field LanguageClient is undefined");
  }

  protected com.google.inject.Module getServerModule() {
    ServerModule _serverModule = new ServerModule();
    final com.google.inject.Module _function = (Binder it) -> {
      it.<RequestManager>bind(RequestManager.class).to(AbstractLanguageServerTest.DirectRequestManager.class);
    };
    return Modules2.mixin(_serverModule, _function);
  }

  @Inject
  protected IResourceServiceProvider.Registry resourceServerProviderRegistry;

  @Inject
  @Extension
  private UriExtensions _uriExtensions;

  @Inject
  protected LanguageServerImpl languageServer;

  protected List<Pair<String, Object>> notifications = CollectionLiterals.<Pair<String, Object>>newArrayList();

  protected File root;

  protected LanguageInfo languageInfo;

  protected boolean hierarchicalDocumentSymbolSupport = false;

  protected Path getTestRootPath() {
    return this.root.toPath().toAbsolutePath().normalize();
  }

  protected Path relativize(final String uri) {
    try {
      Path _xblockexpression = null;
      {
        URI _uRI = new URI(uri);
        final Path path = Paths.get(_uRI);
        _xblockexpression = this.getTestRootPath().relativize(path);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected /* InitializeResult */Object initialize() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initialize((InitializeParams)=>void) from the type AbstractLanguageServerTest refers to the missing type InitializeResult");
  }

  protected /* InitializeResult */Object initialize(final /* Procedure1<? super InitializeParams> */Object initializer) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initialize((InitializeParams)=>void, boolean) from the type AbstractLanguageServerTest refers to the missing type InitializeResult");
  }

  protected /* InitializeResult */Object initialize(final /* Procedure1<? super InitializeParams> */Object initializer, final boolean callInitialized) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method initialize((InitializeParams)=>void, boolean, boolean) from the type AbstractLanguageServerTest refers to the missing type InitializeResult");
  }

  protected /* InitializeResult */Object initialize(final /* Procedure1<? super InitializeParams> */Object initializer, final boolean callInitialized, final boolean useRootPath) {
    throw new Error("Unresolved compilation problems:"
      + "\nInitializeParams cannot be resolved."
      + "\nThe method processId(int) is undefined"
      + "\nThe method workspaceFolders(List<Object>) is undefined"
      + "\nWorkspaceFolder cannot be resolved."
      + "\nClientCapabilities cannot be resolved."
      + "\nWorkspaceClientCapabilities cannot be resolved."
      + "\nThe method initialized(Object) is undefined for the type LanguageServerImpl"
      + "\nType mismatch: cannot convert from LanguageServerImpl to (InitializeParams)=>void"
      + "\nThe method initialize((InitializeParams)=>void, boolean) from the type AbstractLanguageServerTest refers to the missing type InitializeResult"
      + "\n=> cannot be resolved"
      + "\ncapabilities cannot be resolved"
      + "\n=== cannot be resolved"
      + "\ncapabilities cannot be resolved"
      + "\ncapabilities cannot be resolved"
      + "\nworkspace cannot be resolved"
      + "\n=== cannot be resolved"
      + "\ncapabilities cannot be resolved"
      + "\nworkspace cannot be resolved"
      + "\ncapabilities cannot be resolved"
      + "\nworkspace cannot be resolved"
      + "\nworkspaceFolders cannot be resolved"
      + "\ncapabilities cannot be resolved"
      + "\ntextDocument cannot be resolved"
      + "\ndocumentSymbol cannot be resolved"
      + "\nhierarchicalDocumentSymbolSupport cannot be resolved"
      + "\n?: cannot be resolved"
      + "\nget cannot be resolved");
  }

  protected void open(final String fileUri, final String model) {
    this.open(fileUri, this.languageInfo.getLanguageName(), model);
  }

  protected void open(final String fileUri, final String langaugeId, final String model) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method didOpen(Object) is undefined for the type LanguageServerImpl"
      + "\nDidOpenTextDocumentParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentItem cannot be resolved."
      + "\nThe method uri(String) is undefined"
      + "\nThe method languageId(String) is undefined"
      + "\nThe method version(int) is undefined"
      + "\nThe method text(String) is undefined"
      + "\n=> cannot be resolved"
      + "\n=> cannot be resolved");
  }

  protected void didCreateWatchedFiles(final String... fileUris) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method didChangeWatchedFiles(Object) is undefined for the type LanguageServerImpl"
      + "\nDidChangeWatchedFilesParams cannot be resolved."
      + "\nThe method or field changes is undefined"
      + "\nFileEvent cannot be resolved."
      + "\nThe method uri(String) is undefined"
      + "\nThe method type(Object) is undefined for the type Object"
      + "\nThe method or field FileChangeType is undefined"
      + "\n=> cannot be resolved"
      + "\n+= cannot be resolved"
      + "\n=> cannot be resolved"
      + "\nCreated cannot be resolved");
  }

  protected void close(final String fileUri) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method didClose(Object) is undefined for the type LanguageServerImpl"
      + "\nDidCloseTextDocumentParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\n=> cannot be resolved");
  }

  public String writeFile(final String path, final CharSequence contents) {
    try {
      final File file = new File(this.root, path);
      file.getParentFile().mkdirs();
      file.createNewFile();
      final FileWriter writer = new FileWriter(file);
      writer.write(contents.toString());
      writer.close();
      return this._uriExtensions.toUriString(file.toURI().normalize());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void deleteFile(final String path) {
    new File(this.root, path).delete();
  }

  public String getVirtualFile(final String path) {
    final File file = new File(this.root, path);
    return this._uriExtensions.toUriString(file.toURI().normalize());
  }

  protected String _toExpectation(final List<?> elements) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either");
  }

  protected String _toExpectation(final String it) {
    return it;
  }

  protected String _toExpectation(final Integer it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(it);
    return _builder.toString();
  }

  protected String _toExpectation(final Void it) {
    return "";
  }

  protected String _toExpectation(final /* Either<?, ?> */Object either) {
    throw new Error("Unresolved compilation problems:"
      + "\nisLeft cannot be resolved"
      + "\ngetLeft cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\ngetRight cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* Location */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field uri is undefined"
      + "\nThe method or field range is undefined"
      + "\nrelativize cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* Range */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field start is undefined"
      + "\nThe method or field end is undefined"
      + "\ntoExpectation cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* Position */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field line is undefined"
      + "\nThe method or field character is undefined");
  }

  @Deprecated
  protected String _toExpectation(final /* SymbolInformation */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field location is undefined"
      + "\nThe method or field containerName is undefined"
      + "\nThe method or field containerName is undefined"
      + "\nvalue cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved");
  }

  protected String _toExpectation(final /* WorkspaceSymbol */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field name is undefined"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field location is undefined"
      + "\nThe method or field containerName is undefined"
      + "\nThe method or field containerName is undefined"
      + "\nvalue cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved");
  }

  /**
   * @since 2.16
   */
  protected String _toExpectation(final /* DocumentSymbol */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field range is undefined"
      + "\nThe method or field selectionRange is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field range is undefined"
      + "\nThe method or field selectionRange is undefined"
      + "\nThe method or field detail is undefined"
      + "\nThe method or field deprecated is undefined"
      + "\nThe method or field children is undefined"
      + "\nThe method or field children is undefined"
      + "\ncontainsRange cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* CompletionItem */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field label is undefined"
      + "\nThe method or field detail is undefined"
      + "\nThe method or field detail is undefined"
      + "\nThe method or field textEdit is undefined"
      + "\nThe method or field textEdit is undefined"
      + "\nThe method or field additionalTextEdits is undefined"
      + "\nThe method or field additionalTextEdits is undefined"
      + "\nThe method or field insertText is undefined"
      + "\nThe method or field insertText is undefined"
      + "\nThe method or field label is undefined"
      + "\nThe method or field insertText is undefined"
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njoin cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n!= cannot be resolved");
  }

  protected String _toExpectation(final /* TextEdit */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field newText is undefined"
      + "\nThe method or field range is undefined"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* Hover */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field range is undefined"
      + "\nThe method or field contents is undefined"
      + "\ntoExpectation cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* SignatureHelp */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field signatures is undefined"
      + "\nThe method or field activeSignature is undefined"
      + "\nThe method or field activeSignature is undefined"
      + "\nThe method or field activeSignature is undefined"
      + "\nThe method or field activeParameter is undefined"
      + "\nThe method or field signatures is undefined"
      + "\nThe method or field activeSignature is undefined"
      + "\nThe method or field activeParameter is undefined"
      + "\nThe method or field signatures is undefined"
      + "\nThe method or field label is undefined"
      + "\nsize cannot be resolved"
      + "\n=== cannot be resolved"
      + "\n=== cannot be resolved"
      + "\nget cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ngetLeft cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njoin cannot be resolved");
  }

  protected String _toExpectation(final /* DocumentHighlight */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field range is undefined"
      + "\nThe method or field range is undefined"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field kind is undefined"
      + "\n=== cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\n=== cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* DocumentHighlightKind */Object kind) {
    throw new Error("Unresolved compilation problems:"
      + "\ntoString cannot be resolved"
      + "\nsubstring cannot be resolved"
      + "\ntoUpperCase cannot be resolved");
  }

  protected String _toExpectation(final Map<Object, Object> it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either"
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either"
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either");
  }

  protected String _toExpectation(final /* CodeLens */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field command is undefined"
      + "\nThe method or field range is undefined"
      + "\ntitle cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* FoldingRange */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field startLine is undefined"
      + "\nThe method or field endLine is undefined");
  }

  protected void testCodeLens(final Procedure1<? super AbstractLanguageServerTest.TestCodeLensConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method codeLens(Object) is undefined for the type LanguageServerImpl"
      + "\nCodeLensParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method resolveCodeLens(Object) is undefined for the type LanguageServerImpl"
      + "\nThe field AbstractLanguageServerTest.TestCodeLensConfiguration.assertCodeLenses refers to the missing type CodeLens"
      + "\nThe field AbstractLanguageServerTest.TestCodeLensConfiguration.assertCodeLenses refers to the missing type CodeLens"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\nmap cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntoList cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* MarkupContent */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field value is undefined");
  }

  protected String _toExpectation(final /* Command */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field command is undefined"
      + "\nThe method or field title is undefined"
      + "\nThe method or field arguments is undefined"
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either"
      + "\njoin cannot be resolved");
  }

  protected String _toExpectation(final /* WorkspaceEdit */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field changes is undefined"
      + "\nThe method or field changes is undefined"
      + "\nThe method or field documentChanges is undefined"
      + "\nThe method or field documentChanges is undefined"
      + "\nThe method or field isLeft is undefined"
      + "\nThe method or field getLeft is undefined"
      + "\nThe method or field documentChanges is undefined"
      + "\nThe method or field isRight is undefined"
      + "\nThe method or field getRight is undefined"
      + "\n!== cannot be resolved"
      + "\nentrySet cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nnullOrEmpty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nmap cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nmap cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* ResourceOperation */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field kind is undefined");
  }

  protected String _toExpectation(final /* CodeAction */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field title is undefined"
      + "\nThe method or field kind is undefined"
      + "\nThe method or field command is undefined"
      + "\nThe method or field nullOrEmpty is undefined for the type Map<String, List<Diagnostic>>"
      + "\nThe method map((Object)=>Object) is undefined for the type Map<String, List<Diagnostic>>"
      + "\nThe method or field code is undefined"
      + "\nThe method or field edit is undefined"
      + "\nThe method getDiagnostics() from the type AbstractLanguageServerTest refers to the missing type Diagnostic"
      + "\nThe method getDiagnostics() from the type AbstractLanguageServerTest refers to the missing type Diagnostic"
      + "\n! cannot be resolved"
      + "\nget cannot be resolved"
      + "\njoin cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* TextDocumentEdit */Object e) {
    throw new Error("Unresolved compilation problems:"
      + "\ntextDocument cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\nedits cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected String _toExpectation(final /* VersionedTextDocumentIdentifier */Object v) {
    throw new Error("Unresolved compilation problems:"
      + "\nuri cannot be resolved"
      + "\nversion cannot be resolved");
  }

  @Beta
  protected void testSemanticTokensFull(final Procedure1<? super SemanticTokensFullConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method semanticTokensFull(Object) is undefined for the type LanguageServerImpl"
      + "\nSemanticTokensParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\ndata cannot be resolved"
      + "\ntoArray cannot be resolved");
  }

  protected void testCodeAction(final Procedure1<? super AbstractLanguageServerTest.TestCodeActionConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method codeAction(Object) is undefined for the type LanguageServerImpl"
      + "\nCodeActionParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method range(Object) is undefined"
      + "\nRange cannot be resolved."
      + "\nThe method start(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method end(Object) is undefined"
      + "\nThe method or field start is undefined"
      + "\nThe method context(Object) is undefined"
      + "\nCodeActionContext cannot be resolved."
      + "\nThe method diagnostics(List<Diagnostic>) is undefined"
      + "\nThe method getDiagnostics() from the type AbstractLanguageServerTest refers to the missing type Diagnostic"
      + "\nThe field AbstractLanguageServerTest.TestCodeActionConfiguration.assertCodeActions refers to the missing type Either"
      + "\nThe field AbstractLanguageServerTest.TestCodeActionConfiguration.assertCodeActions refers to the missing type Either"
      + "\n=> cannot be resolved"
      + "\n=> cannot be resolved"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected void testCompletion(final Procedure1<? super TestCompletionConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method completion(Object) is undefined for the type LanguageServerImpl"
      + "\nCompletionParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method position(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method or field sortText is undefined"
      + "\nThe method or field assertCompletionList is undefined for the type TestCompletionConfiguration"
      + "\nThe method or field assertCompletionList is undefined for the type TestCompletionConfiguration"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\nisLeft cannot be resolved"
      + "\ngetLeft cannot be resolved"
      + "\ngetRight cannot be resolved"
      + "\nitems cannot be resolved"
      + "\nsortBy cannot be resolved"
      + "\ntoList cannot be resolved"
      + "\n!== cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetRight cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected FileInfo initializeContext(final TextDocumentConfiguration configuration) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field initializer is undefined for the type TextDocumentConfiguration"
      + "\nThe method initialize((InitializeParams)=>void) from the type AbstractLanguageServerTest refers to the missing type InitializeResult");
  }

  protected void testDefinition(final Procedure1<? super DefinitionTestConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method definition(Object) is undefined for the type LanguageServerImpl"
      + "\nDefinitionParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method position(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method or field assertDefinitions is undefined for the type DefinitionTestConfiguration"
      + "\nThe method or field assertDefinitions is undefined for the type DefinitionTestConfiguration"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetLeft cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected void testHover(final Procedure1<? super HoverTestConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method hover(Object) is undefined for the type LanguageServerImpl"
      + "\nHoverParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method position(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method or field assertHover is undefined for the type HoverTestConfiguration"
      + "\nThe method or field assertHover is undefined for the type HoverTestConfiguration"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\napply cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected Object testSignatureHelp(final Procedure1<? super SignatureHelpConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method signatureHelp(Object) is undefined for the type LanguageServerImpl"
      + "\nSignatureHelpParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method position(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method or field assertSignatureHelp is undefined for the type SignatureHelpConfiguration"
      + "\nThe method or field assertSignatureHelp is undefined for the type SignatureHelpConfiguration"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\napply cannot be resolved"
      + "\ntoExpectation cannot be resolved"
      + "\ntrim cannot be resolved");
  }

  protected void testDocumentHighlight(final Procedure1<? super DocumentHighlightConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method documentHighlight(Object) is undefined for the type LanguageServerImpl"
      + "\nDocumentHighlightParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method position(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method toExpectation(Either) from the type AbstractLanguageServerTest refers to the missing type Either"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\nmap cannot be resolved"
      + "\njoin cannot be resolved");
  }

  protected void testDocumentSymbol(final Procedure1<? super DocumentSymbolConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method documentSymbol(Object) is undefined for the type LanguageServerImpl"
      + "\nDocumentSymbolParams cannot be resolved."
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method or field getAssertSymbols is undefined for the type DocumentSymbolConfiguration"
      + "\nThe method or field getAssertSymbols is undefined for the type DocumentSymbolConfiguration"
      + "\nThe method or field getRight is undefined"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\napply cannot be resolved"
      + "\nmap cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected void testSymbol(final Procedure1<? super WorkspaceSymbolConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method symbol(Object) is undefined for the type LanguageServerImpl"
      + "\nWorkspaceSymbolParams cannot be resolved."
      + "\nThe method or field assertSymbols is undefined for the type WorkspaceSymbolConfiguration"
      + "\nThe method or field assertWorkspaceSymbols is undefined for the type WorkspaceSymbolConfiguration"
      + "\nThe method or field assertSymbols is undefined for the type WorkspaceSymbolConfiguration"
      + "\nThe method or field assertWorkspaceSymbols is undefined for the type WorkspaceSymbolConfiguration"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nisLeft cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetLeft cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetRight cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  protected void testReferences(final Procedure1<? super ReferenceTestConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method references(Object) is undefined for the type LanguageServerImpl"
      + "\nReferenceParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method position(Object) is undefined"
      + "\nPosition cannot be resolved."
      + "\nThe method context(Object) is undefined"
      + "\nReferenceContext cannot be resolved."
      + "\nThe method or field assertReferences is undefined for the type ReferenceTestConfiguration"
      + "\nThe method or field assertReferences is undefined for the type ReferenceTestConfiguration"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\n!== cannot be resolved"
      + "\napply cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  public void assertEquals(final String expected, final String actual) {
    final String expectedM = expected.replace(System.lineSeparator(), "\n");
    final String actualM = actual.replace(System.lineSeparator(), "\n");
    Assert.assertEquals(expectedM.replace("\t", "    "), actualM.replace("\t", "    "));
  }

  public void assertEqualsStricter(final String expected, final String actual) {
    final String expectedM = expected.replace(System.lineSeparator(), "\n");
    final String actualM = actual.replace(System.lineSeparator(), "\n");
    Assert.assertEquals(expectedM, actualM);
  }

  protected void testFormatting(final Procedure1<? super FormattingConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method testFormatting((DocumentFormattingParams)=>void, (FormattingConfiguration)=>void) from the type AbstractLanguageServerTest refers to the missing type DocumentFormattingParams");
  }

  protected void testFormatting(final /* Procedure1<? super DocumentFormattingParams> */Object paramsConfigurator, final Procedure1<? super FormattingConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nTextEdit cannot be resolved to a type."
      + "\nThe method formatting(Object) is undefined for the type LanguageServerImpl"
      + "\nDocumentFormattingParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method applyChanges(List<TextEdit>) is undefined for the type Document"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncontents cannot be resolved");
  }

  protected void testRangeFormatting(final Procedure1<? super RangeFormattingConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method testRangeFormatting((DocumentRangeFormattingParams)=>void, (RangeFormattingConfiguration)=>void) from the type AbstractLanguageServerTest refers to the missing type DocumentRangeFormattingParams");
  }

  protected void testRangeFormatting(final /* Procedure1<? super DocumentRangeFormattingParams> */Object paramsConfigurator, final Procedure1<? super RangeFormattingConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nTextEdit cannot be resolved to a type."
      + "\nThe method rangeFormatting(Object) is undefined for the type LanguageServerImpl"
      + "\nDocumentRangeFormattingParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\nThe method range(Object) is undefined"
      + "\nThe method or field range is undefined for the type RangeFormattingConfiguration"
      + "\nThe method applyChanges(List<TextEdit>) is undefined for the type Document"
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncontents cannot be resolved");
  }

  /**
   * @since 2.26
   */
  protected void testFolding(final Procedure1<? super FoldingConfiguration> configurator) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method foldingRange(Object) is undefined for the type LanguageServerImpl"
      + "\nFoldingRangeRequestParams cannot be resolved."
      + "\nThe method textDocument(Object) is undefined"
      + "\nTextDocumentIdentifier cannot be resolved."
      + "\n=> cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntoExpectation cannot be resolved");
  }

  @Override
  public boolean notify(final String method, final Object parameter) {
    Pair<String, Object> _mappedTo = Pair.<String, Object>of(method, parameter);
    return this.notifications.add(_mappedTo);
  }

  @Override
  public CompletableFuture<Object> request(final String method, final Object parameter) {
    return CompletableFuture.<Object>completedFuture(null);
  }

  protected /* Map<String, List<Diagnostic>> */Object getDiagnostics() {
    throw new Error("Unresolved compilation problems:"
      + "\nDiagnostic cannot be resolved to a type."
      + "\nThe method or field PublishDiagnosticsParams is undefined"
      + "\nThe method or field uri is undefined for the type Object"
      + "\nThe method or field diagnostics is undefined for the type Object");
  }

  protected String toExpectation(final Either it) {
    if (it != null) {
      return _toExpectation(it);
    } else if (it != null) {
      return _toExpectation(it);
    } else if (it != null) {
      return _toExpectation(it);
    } else if (it == null) {
      return _toExpectation(null);
    } else if (it != null) {
      return _toExpectation(it);
    } else {
      return _toExpectation(it);
    }
  }

  public AbstractLanguageServerTest(final String fileExtension) {
    throw new Error("Unresolved compilation problems:"
      + "\nImplemented interface must be an interface");
  }

  @Pure
  public String getFileExtension() {
    return this.fileExtension;
  }
}
