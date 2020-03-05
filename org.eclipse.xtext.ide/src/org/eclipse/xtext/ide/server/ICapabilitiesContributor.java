/*******************************************************************************
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.InitializeParams;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ICapabilitiesContributor {

	/**
	 * Allows an individual language to contribute to and overwrite properties in the server's capabilities.
	 */
	ServerCapabilities contribute(ServerCapabilities capabilities, InitializeParams params);
}