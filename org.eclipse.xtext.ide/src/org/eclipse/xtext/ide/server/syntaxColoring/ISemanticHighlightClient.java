/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.syntaxColoring;

import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;

/**
 * Representation of a language-server client that can receive
 * {@link SemanticHighlight semantic highlight} push notifications from the
 * language-server as part of the
 * <a href="https://github.com/Microsoft/language-server-protocol">Language
 * Server Protocol</a> {@link ILanguageServerExtension extension}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
public interface ISemanticHighlightClient {

	/**
	 * Pushes the {@link SemanticHighlight semantic highlight} to the client.
	 * 
	 * @param highlight
	 *            the information that should be pushed to the client side. Must
	 *            not be {@code null}.
	 */
	@JsonNotification("lsp4j/pushSemanticHighlight")
	void pushSemanticHighlight(SemanticHighlight highlight);

}
