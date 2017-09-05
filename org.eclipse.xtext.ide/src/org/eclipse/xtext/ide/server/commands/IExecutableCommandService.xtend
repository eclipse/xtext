/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.commands

import java.util.List
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.util.IDisposable
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
interface IExecutableCommandService {
	
	/**
	 * Called on server initialize.
	 * @return the supported commands
	 */
	def List<String> initialize()
	
	/**
	 * Called on server initialize, only if the client supported dynamicRegistration of commands.
	 */
	def void initializeDynamicRegistration((String)=>IDisposable register) {}
	
	/**
	 * Called when the client wants to execute a registered command.
	 */
	def Object execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator)
}