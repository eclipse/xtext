/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;

/**
 * Interface for language specific extensions to LSP. Implementors should use {@link JsonNotification} and {@link
 * JsonRequest} annotations.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ILanguageServerExtension {
	/**
	 * The same jsonrpc method might be supported by multiple languages and only the actual invocation might reveal is a
	 * language wants to handle it, based on e.g. a uri in the parameter.
	 * 
	 * To indicate that a request is not handled, this exception should be thrown by the service.
	 */
	static final RuntimeException NOT_HANDLED_EXCEPTION = new UnsupportedOperationException("not handled");

	/**
	 * Initialize the extension.
	 * @param access Provides access to language server documents, resource and build events.
	 */
	void initialize(ILanguageServerAccess access);
}
