/**
 * Copyright (c) 2017, 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.ApplyWorkspaceEditParams;
import org.eclipse.lsp4j.ApplyWorkspaceEditResponse;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.ConfigurationParams;
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
import org.eclipse.lsp4j.WorkspaceFolder;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CommandRegistryTest implements IResourceServiceProvider, IExecutableCommandService, LanguageClient {
	private Function1<? super String, ? extends IDisposable> register;

	private Set<String> commandsExecuted = new HashSet<>();

	private Map<String, Registration> registered = new HashMap<>();

	@Test
	public void testRegistration() {
		ExecutableCommandRegistry reg = new ExecutableCommandRegistry();
		ClientCapabilities cap = new ClientCapabilities();
		WorkspaceClientCapabilities workspaceClientCapabilities = new WorkspaceClientCapabilities();
		ExecuteCommandCapabilities executeCommandCapabilities = new ExecuteCommandCapabilities();
		executeCommandCapabilities.setDynamicRegistration(true);
		workspaceClientCapabilities.setExecuteCommand(executeCommandCapabilities);
		cap.setWorkspace(workspaceClientCapabilities);

		reg.initialize(Collections.unmodifiableList(Lists.newArrayList(this)), cap, this);
		Assert.assertEquals("static-command", Iterables.getFirst(reg.getCommands(), null));
		ExecuteCommandParams staticCommandParams = new ExecuteCommandParams();
		staticCommandParams.setCommand("static-command");
		reg.executeCommand(staticCommandParams, null, null);

		ExecuteCommandParams dynamicCommandParams = new ExecuteCommandParams();
		dynamicCommandParams.setCommand("dynamic-command");
		reg.executeCommand(dynamicCommandParams, null, null);
		Assert.assertEquals(Collections.unmodifiableSet(Sets.newHashSet("static-command")), commandsExecuted);
		commandsExecuted.clear();
		IDisposable disposable = register.apply("dynamic-command");

		ExecuteCommandParams dynamicCommandParams2 = new ExecuteCommandParams();
		dynamicCommandParams2.setCommand("dynamic-command");
		reg.executeCommand(dynamicCommandParams2, null, null);
		Assert.assertEquals(Collections.unmodifiableSet(Sets.newHashSet("dynamic-command")), commandsExecuted);
		commandsExecuted.clear();
		disposable.dispose();
		
		ExecuteCommandParams dynamicCommandParams3 = new ExecuteCommandParams();
		dynamicCommandParams3.setCommand("dynamic-command");
		reg.executeCommand(dynamicCommandParams3, null, null);
		Assert.assertEquals(Collections.unmodifiableSet(new HashSet<>()), commandsExecuted);
	}

	@Override
	public List<String> initialize() {
		return Collections.unmodifiableList(Lists.newArrayList("static-command"));
	}

	@Override
	public void initializeDynamicRegistration(Function1<? super String, ? extends IDisposable> register) {
		this.register = register;
	}

	@Override
	public Object execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		return Boolean.valueOf(commandsExecuted.add(params.getCommand()));
	}

	@Delegate
	private IResourceServiceProvider noImpl;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> T get(Class<T> t) {
		return ((T) this);
	}

	@Delegate
	private LanguageClient noImpl3;

	@Override
	public CompletableFuture<Void> registerCapability(RegistrationParams params) {
		Registration reg = Iterables.getFirst(params.getRegistrations(), null);
		registered.put(reg.getId(), reg);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public CompletableFuture<Void> unregisterCapability(UnregistrationParams params) {
		Unregistration unreg = Iterables.getFirst(params.getUnregisterations(), null);
		registered.remove(unreg.getId());
		return CompletableFuture.completedFuture(null);
	}

	public boolean canHandle(URI uri) {
		return noImpl.canHandle(uri);
	}

	public IContainer.Manager getContainerManager() {
		return noImpl.getContainerManager();
	}

	public IEncodingProvider getEncodingProvider() {
		return noImpl.getEncodingProvider();
	}

	public IResourceDescription.Manager getResourceDescriptionManager() {
		return noImpl.getResourceDescriptionManager();
	}

	public IResourceValidator getResourceValidator() {
		return noImpl.getResourceValidator();
	}

	public CompletableFuture<ApplyWorkspaceEditResponse> applyEdit(ApplyWorkspaceEditParams params) {
		return noImpl3.applyEdit(params);
	}

	public CompletableFuture<List<Object>> configuration(ConfigurationParams configurationParams) {
		return noImpl3.configuration(configurationParams);
	}

	public void logMessage(MessageParams message) {
		noImpl3.logMessage(message);
	}

	public void publishDiagnostics(PublishDiagnosticsParams diagnostics) {
		noImpl3.publishDiagnostics(diagnostics);
	}

	public void showMessage(MessageParams messageParams) {
		noImpl3.showMessage(messageParams);
	}

	public CompletableFuture<MessageActionItem> showMessageRequest(ShowMessageRequestParams requestParams) {
		return noImpl3.showMessageRequest(requestParams);
	}

	public void telemetryEvent(Object object) {
		noImpl3.telemetryEvent(object);
	}

	public CompletableFuture<List<WorkspaceFolder>> workspaceFolders() {
		return noImpl3.workspaceFolders();
	}
}
