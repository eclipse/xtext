/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.commands

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import java.util.UUID
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.ExecuteCommandOptions
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.lsp4j.Registration
import org.eclipse.lsp4j.RegistrationParams
import org.eclipse.lsp4j.Unregistration
import org.eclipse.lsp4j.UnregistrationParams
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IDisposable
import org.eclipse.xtext.util.internal.Log

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Log class ExecutableCommandRegistry {
	
	private static val METHOD = 'workspace/executeCommand'
	
	Multimap<String, IExecutableCommandService> registeredCommands
	
	LanguageClient client
	
	def void initialize(Iterable<? extends IResourceServiceProvider> allLanguages, ClientCapabilities capabilites, LanguageClient client) {
		this.client = client
		registeredCommands = HashMultimap.create
		val hasDynamicRegistration = capabilites.workspace.executeCommand.dynamicRegistration
		for (lang : allLanguages) {
			val service = lang.get(IExecutableCommandService)
			if (service !== null) {
				val commands = service.initialize()
				for (c : commands) {
					registeredCommands.put(c, service)
				}
				if (hasDynamicRegistration) {
					service.initializeDynamicRegistration[ command |
						this.register(command, service)
					]
				}
			}
		}
	}
	
	protected def IDisposable register(String command, IExecutableCommandService service) {
		val requestId = UUID.randomUUID.toString 	
		val reg =  new Registration => [
			id = requestId
			method = METHOD
			registerOptions = new ExecuteCommandOptions => [
				commands = #[command]
			] 
		]
		client.registerCapability(new RegistrationParams => [
			it.registrations = newArrayList(reg)
		])
		registeredCommands.put(command, service)
		return [
			val unReg = new Unregistration => [
				id = requestId
				method = METHOD 
			]
			client.unregisterCapability(new UnregistrationParams => [
				it.unregisterations = newArrayList(unReg)
			])
			registeredCommands.remove(command, service)
		]
	}
	
	def Object executeCommand(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		var Object result = null
		for (service : this.registeredCommands.get(params.command)) {
			val localResult = service.execute(params, access, cancelIndicator)
			if (localResult !== null) {
				if (result !== null) {
					org.eclipse.xtext.ide.server.commands.ExecutableCommandRegistry.LOG.error('''Multiple commands '«params.command»' have been registered. All are executed but only one result will be send back.''')
				} else {
					result = localResult
				}
			}
		}
		return result
	}
	
	def getCommands() {
		return this.registeredCommands.keySet.toList
	}

}