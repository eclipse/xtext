/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.syntaxColoring

import java.util.List
import org.eclipse.lsp4j.annotations.LanguageServerAPI

/**
 * Representation of a computed mapping from ranges to the appropriate
 * highlighting style.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@LanguageServerAPI
class SemanticHighlight {

	/**
	 * A list of semantic highlight information.
	 */
	List<? extends SemanticHighlightInformation> infos;

}
