/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.commands;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.ApplyWorkspaceEditParams;
import org.eclipse.lsp4j.ApplyWorkspaceEditResponse;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.ExecuteCommandCapabilities;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.MessageActionItem;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.Registration;
import org.eclipse.lsp4j.RegistrationParams;
import org.eclipse.lsp4j.ShowMessageRequestParams;
import org.eclipse.lsp4j.Unregistration;
import org.eclipse.lsp4j.UnregistrationParams;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.ExecutableCommandRegistry;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CommandRegistryTest implements IResourceServiceProvider, IExecutableCommandService, LanguageClient {
  private Function1<? super String, ? extends IDisposable> register;
  
  private Set<String> commandsExecuted = CollectionLiterals.<String>newHashSet();
  
  private Map<String, Registration> registered = CollectionLiterals.<String, Registration>newHashMap();
  
  @Test
  public void testRegistration() {
    final ExecutableCommandRegistry reg = new ExecutableCommandRegistry();
    ClientCapabilities _clientCapabilities = new ClientCapabilities();
    final Procedure1<ClientCapabilities> _function = (ClientCapabilities it) -> {
      WorkspaceClientCapabilities _workspaceClientCapabilities = new WorkspaceClientCapabilities();
      final Procedure1<WorkspaceClientCapabilities> _function_1 = (WorkspaceClientCapabilities it_1) -> {
        ExecuteCommandCapabilities _executeCommandCapabilities = new ExecuteCommandCapabilities();
        final Procedure1<ExecuteCommandCapabilities> _function_2 = (ExecuteCommandCapabilities it_2) -> {
          it_2.setDynamicRegistration(Boolean.valueOf(true));
        };
        ExecuteCommandCapabilities _doubleArrow = ObjectExtensions.<ExecuteCommandCapabilities>operator_doubleArrow(_executeCommandCapabilities, _function_2);
        it_1.setExecuteCommand(_doubleArrow);
      };
      WorkspaceClientCapabilities _doubleArrow = ObjectExtensions.<WorkspaceClientCapabilities>operator_doubleArrow(_workspaceClientCapabilities, _function_1);
      it.setWorkspace(_doubleArrow);
    };
    final ClientCapabilities cap = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function);
    reg.initialize(Collections.<IResourceServiceProvider>unmodifiableList(CollectionLiterals.<IResourceServiceProvider>newArrayList(this)), cap, this);
    Assert.assertEquals("static-command", IterableExtensions.<String>head(reg.getCommands()));
    ExecuteCommandParams _executeCommandParams = new ExecuteCommandParams();
    final Procedure1<ExecuteCommandParams> _function_1 = (ExecuteCommandParams it) -> {
      it.setCommand("static-command");
    };
    ExecuteCommandParams _doubleArrow = ObjectExtensions.<ExecuteCommandParams>operator_doubleArrow(_executeCommandParams, _function_1);
    reg.executeCommand(_doubleArrow, null, null);
    ExecuteCommandParams _executeCommandParams_1 = new ExecuteCommandParams();
    final Procedure1<ExecuteCommandParams> _function_2 = (ExecuteCommandParams it) -> {
      it.setCommand("dynamic-command");
    };
    ExecuteCommandParams _doubleArrow_1 = ObjectExtensions.<ExecuteCommandParams>operator_doubleArrow(_executeCommandParams_1, _function_2);
    reg.executeCommand(_doubleArrow_1, null, null);
    Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("static-command")), this.commandsExecuted);
    this.commandsExecuted.clear();
    final IDisposable disposable = this.register.apply("dynamic-command");
    ExecuteCommandParams _executeCommandParams_2 = new ExecuteCommandParams();
    final Procedure1<ExecuteCommandParams> _function_3 = (ExecuteCommandParams it) -> {
      it.setCommand("dynamic-command");
    };
    ExecuteCommandParams _doubleArrow_2 = ObjectExtensions.<ExecuteCommandParams>operator_doubleArrow(_executeCommandParams_2, _function_3);
    reg.executeCommand(_doubleArrow_2, null, null);
    Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("dynamic-command")), this.commandsExecuted);
    this.commandsExecuted.clear();
    disposable.dispose();
    ExecuteCommandParams _executeCommandParams_3 = new ExecuteCommandParams();
    final Procedure1<ExecuteCommandParams> _function_4 = (ExecuteCommandParams it) -> {
      it.setCommand("dynamic-command");
    };
    ExecuteCommandParams _doubleArrow_3 = ObjectExtensions.<ExecuteCommandParams>operator_doubleArrow(_executeCommandParams_3, _function_4);
    reg.executeCommand(_doubleArrow_3, null, null);
    Assert.assertEquals(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet()), this.commandsExecuted);
  }
  
  @Override
  public List<String> initialize() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("static-command"));
  }
  
  @Override
  public void initializeDynamicRegistration(final Function1<? super String, ? extends IDisposable> register) {
    this.register = register;
  }
  
  @Override
  public Object execute(final ExecuteCommandParams params, final ILanguageServerAccess access, final CancelIndicator cancelIndicator) {
    return Boolean.valueOf(this.commandsExecuted.add(params.getCommand()));
  }
  
  @Delegate
  private IResourceServiceProvider noImpl;
  
  @Override
  public <T extends Object> T get(final Class<T> t) {
    return ((T) this);
  }
  
  @Delegate
  private LanguageClient noImpl3;
  
  @Override
  public CompletableFuture<Void> registerCapability(final RegistrationParams params) {
    final Registration reg = IterableExtensions.<Registration>head(params.getRegistrations());
    this.registered.put(reg.getId(), reg);
    return CompletableFuture.<Void>completedFuture(null);
  }
  
  @Override
  public CompletableFuture<Void> unregisterCapability(final UnregistrationParams params) {
    final Unregistration unreg = IterableExtensions.<Unregistration>head(params.getUnregisterations());
    this.registered.remove(unreg);
    return CompletableFuture.<Void>completedFuture(null);
  }
  
  public boolean canHandle(final URI uri) {
    return this.noImpl.canHandle(uri);
  }
  
  public IContainer.Manager getContainerManager() {
    return this.noImpl.getContainerManager();
  }
  
  public IEncodingProvider getEncodingProvider() {
    return this.noImpl.getEncodingProvider();
  }
  
  public IResourceDescription.Manager getResourceDescriptionManager() {
    return this.noImpl.getResourceDescriptionManager();
  }
  
  public IResourceValidator getResourceValidator() {
    return this.noImpl.getResourceValidator();
  }
  
  public CompletableFuture<ApplyWorkspaceEditResponse> applyEdit(final ApplyWorkspaceEditParams params) {
    return this.noImpl3.applyEdit(params);
  }
  
  public void logMessage(final MessageParams message) {
    this.noImpl3.logMessage(message);
  }
  
  public void publishDiagnostics(final PublishDiagnosticsParams diagnostics) {
    this.noImpl3.publishDiagnostics(diagnostics);
  }
  
  public void showMessage(final MessageParams messageParams) {
    this.noImpl3.showMessage(messageParams);
  }
  
  public CompletableFuture<MessageActionItem> showMessageRequest(final ShowMessageRequestParams requestParams) {
    return this.noImpl3.showMessageRequest(requestParams);
  }
  
  public void telemetryEvent(final Object object) {
    this.noImpl3.telemetryEvent(object);
  }
}
