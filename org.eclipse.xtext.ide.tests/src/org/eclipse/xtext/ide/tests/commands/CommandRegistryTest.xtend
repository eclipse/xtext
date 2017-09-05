/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.commands

import java.util.Map
import java.util.Set
import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.ExecuteCommandCapabilities
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.lsp4j.Registration
import org.eclipse.lsp4j.RegistrationParams
import org.eclipse.lsp4j.UnregistrationParams
import org.eclipse.lsp4j.WorkspaceClientCapabilities
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IDisposable
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService
import org.eclipse.xtext.ide.server.commands.ExecutableCommandRegistry

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CommandRegistryTest implements IResourceServiceProvider, IExecutableCommandService, LanguageClient {

	(String)=>IDisposable register
	Set<String> commandsExecuted = newHashSet
	Map<String, Registration> registered = newHashMap
	
	@Test def void testRegistration() {
		val reg = new ExecutableCommandRegistry()
		val cap = new ClientCapabilities => [
			workspace = new WorkspaceClientCapabilities => [
				executeCommand  = new ExecuteCommandCapabilities => [
					dynamicRegistration = true
				]
			]
		]
		reg.initialize(#[this], cap, this)
		
		Assert.assertEquals('static-command', reg.commands.head)
		
		// should be executed
		reg.executeCommand(new ExecuteCommandParams => [ command = 'static-command' ], null, null)
		
		// should NOT be executed
		reg.executeCommand(new ExecuteCommandParams => [ command = 'dynamic-command' ], null, null)
		
		Assert.assertEquals(#{'static-command'}, this.commandsExecuted)
		this.commandsExecuted.clear
		
		val disposable = register.apply('dynamic-command')
		
		// should be executed
		reg.executeCommand(new ExecuteCommandParams => [ command = 'dynamic-command' ], null, null)
		
		Assert.assertEquals(#{'dynamic-command'}, this.commandsExecuted)
		this.commandsExecuted.clear
		
		// unregister
		disposable.dispose
		// should NOT be executed
		reg.executeCommand(new ExecuteCommandParams => [ command = 'dynamic-command' ], null, null)
		Assert.assertEquals(#{}, this.commandsExecuted)
	}

	override initialize() {
		#['static-command']
	}
	
	override initializeDynamicRegistration((String)=>IDisposable register) {
		this.register = register
	}
	
	override execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		this.commandsExecuted.add(params.command)
	}
	
	@Delegate IResourceServiceProvider noImpl
	
	override <T> get(Class<T> t) {
		return this as T
	}
	
	@Delegate LanguageClient noImpl3
	
	override registerCapability(RegistrationParams params) {
		val reg = params.registrations.head
		registered.put(reg.id, reg)
		return CompletableFuture.completedFuture(null)
	}
	
	override unregisterCapability(UnregistrationParams params) {
		val unreg = params.unregisterations.head
		registered.remove(unreg)
		return CompletableFuture.completedFuture(null)
	}
	
}
