/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import org.eclipse.lsp4j.ServerCapabilities
import org.eclipse.lsp4j.InitializeParams

/**
 * @author Sven Efftinge - Initial contribution and API
 */
interface ICapabilitiesContributor {

	/**
	 * Allows an individual language to contribute to and overwrite properties in the server's capabilities.
	 */
	def ServerCapabilities contribute(ServerCapabilities capabilities, InitializeParams params);
}