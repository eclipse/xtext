/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Inject;
import io.typefox.lsapi.CompletionOptionsImpl;
import io.typefox.lsapi.InitializeParams;
import io.typefox.lsapi.InitializeResult;
import io.typefox.lsapi.InitializeResultImpl;
import io.typefox.lsapi.LanguageServer;
import io.typefox.lsapi.ServerCapabilitiesImpl;
import io.typefox.lsapi.TextDocumentService;
import io.typefox.lsapi.WindowService;
import io.typefox.lsapi.WorkspaceService;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.server.TextDocumentServiceImpl;
import org.eclipse.xtext.ide.server.WindowServiceImpl;
import org.eclipse.xtext.ide.server.WorkspaceServiceImpl;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class LanguageServerImpl implements LanguageServer {
  private InitializeParams params;
  
  @Inject
  private WorkspaceServiceImpl workspaceService;
  
  @Inject
  private TextDocumentServiceImpl textDocumentService;
  
  @Inject
  private WindowServiceImpl windowService;
  
  @Override
  public InitializeResult initialize(final InitializeParams params) {
    this.params = params;
    final Procedure2<URI, Iterable<Issue>> _function = new Procedure2<URI, Iterable<Issue>>() {
      @Override
      public void apply(final URI $0, final Iterable<Issue> $1) {
        LanguageServerImpl.this.textDocumentService.publishDiagnostics($0, $1);
      }
    };
    this.workspaceService.initialize(params, _function);
    InitializeResultImpl _initializeResultImpl = new InitializeResultImpl();
    final Procedure1<InitializeResultImpl> _function_1 = new Procedure1<InitializeResultImpl>() {
      @Override
      public void apply(final InitializeResultImpl it) {
        ServerCapabilitiesImpl _serverCapabilitiesImpl = new ServerCapabilitiesImpl();
        final Procedure1<ServerCapabilitiesImpl> _function = new Procedure1<ServerCapabilitiesImpl>() {
          @Override
          public void apply(final ServerCapabilitiesImpl it) {
            CompletionOptionsImpl _completionOptionsImpl = new CompletionOptionsImpl();
            final Procedure1<CompletionOptionsImpl> _function = new Procedure1<CompletionOptionsImpl>() {
              @Override
              public void apply(final CompletionOptionsImpl it) {
                it.setResolveProvider(true);
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
  public void shutdown() {
  }
  
  @Override
  public TextDocumentService getTextDocumentService() {
    return this.textDocumentService;
  }
  
  @Override
  public WorkspaceService getWorkspaceService() {
    return this.workspaceService;
  }
  
  @Override
  public void exit() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public WindowService getWindowService() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public InitializeParams getParams() {
    return this.params;
  }
  
  public void setParams(final InitializeParams params) {
    this.params = params;
  }
  
  public void setWorkspaceService(final WorkspaceServiceImpl workspaceService) {
    this.workspaceService = workspaceService;
  }
  
  public void setTextDocumentService(final TextDocumentServiceImpl textDocumentService) {
    this.textDocumentService = textDocumentService;
  }
  
  public void setWindowService(final WindowServiceImpl windowService) {
    this.windowService = windowService;
  }
}
