/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.coloring

import java.util.List
import org.eclipse.lsp4j.generator.LanguageServerAPI
import org.eclipse.lsp4j.jsonrpc.validation.NonNull

/**
 * Representation of a computed mapping from ranges to the appropriate
 * highlighting style.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@LanguageServerAPI
class ColoringParams {

	/**
	 * The URI for which coloring information is reported.
	 */
	@NonNull
	String uri;

	/**
	 * A list of coloring information instances.
	 */
	List<? extends ColoringInformation> infos;

}
