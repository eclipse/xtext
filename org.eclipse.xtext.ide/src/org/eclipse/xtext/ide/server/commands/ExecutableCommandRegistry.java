/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.commands;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.ExecuteCommandCapabilities;
import org.eclipse.lsp4j.ExecuteCommandOptions;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.lsp4j.Registration;
import org.eclipse.lsp4j.RegistrationParams;
import org.eclipse.lsp4j.Unregistration;
import org.eclipse.lsp4j.UnregistrationParams;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IDisposable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ExecutableCommandRegistry {

	private static final Logger LOG = Logger.getLogger(ExecutableCommandRegistry.class);
	private static final String METHOD = "workspace/executeCommand";

	private Multimap<String, IExecutableCommandService> registeredCommands;

	private LanguageClient client;

	public void initialize(Iterable<? extends IResourceServiceProvider> allLanguages, ClientCapabilities capabilities,
			LanguageClient client) {
		this.client = client;
		this.registeredCommands = HashMultimap.create();
		boolean hasDynamicRegistration = false;
		WorkspaceClientCapabilities workspace = capabilities.getWorkspace();
		if (workspace != null) {
			ExecuteCommandCapabilities executeCommandCapabilities = workspace.getExecuteCommand();
			if (executeCommandCapabilities != null) {
				Boolean dynamicRegistration = executeCommandCapabilities.getDynamicRegistration();
				if (dynamicRegistration != null) {
					hasDynamicRegistration = dynamicRegistration.booleanValue();
				}
			}
		}
		for (IResourceServiceProvider lang : allLanguages) {
			IExecutableCommandService service = lang.get(IExecutableCommandService.class);
			if (service != null) {
				List<String> commands = service.initialize();
				for (String c : commands) {
					registeredCommands.put(c, service);
				}
				if (hasDynamicRegistration) {
					service.initializeDynamicRegistration((String command) -> {
						return register(command, service);
					});
				}
			}
		}
	}

	protected IDisposable register(String command, IExecutableCommandService service) {
		String requestId = UUID.randomUUID().toString();
		Registration reg = new Registration();
		reg.setId(requestId);
		reg.setMethod(ExecutableCommandRegistry.METHOD);
		ExecuteCommandOptions executeCommandOptions = new ExecuteCommandOptions();
		executeCommandOptions.setCommands(Collections.unmodifiableList(Lists.newArrayList(command)));
		reg.setRegisterOptions(executeCommandOptions);
		RegistrationParams registrationParams = new RegistrationParams();
		registrationParams.setRegistrations(Lists.newArrayList(reg));
		client.registerCapability(registrationParams);
		registeredCommands.put(command, service);
		return () -> {
			Unregistration unReg = new Unregistration();
			unReg.setId(requestId);
			unReg.setMethod(ExecutableCommandRegistry.METHOD);
			UnregistrationParams unregistrationParams = new UnregistrationParams();
			unregistrationParams.setUnregisterations(Lists.newArrayList(unReg));
			this.client.unregisterCapability(unregistrationParams);
			this.registeredCommands.remove(command, service);
		};
	}

	public Object executeCommand(ExecuteCommandParams params, ILanguageServerAccess access,
			CancelIndicator cancelIndicator) {
		Object result = null;
		for (IExecutableCommandService service : registeredCommands.get(params.getCommand())) {
			Object localResult = service.execute(params, access, cancelIndicator);
			if (localResult != null) {
				if (result != null) {
					ExecutableCommandRegistry.LOG.error("Multiple commands '" + params.getCommand()
							+ "' have been registered. All are executed but only one result will be send back.");
				} else {
					result = localResult;
				}
			}
		}
		return result;
	}

	public List<String> getCommands() {
		return Lists.newArrayList(registeredCommands.keySet());
	}

}
