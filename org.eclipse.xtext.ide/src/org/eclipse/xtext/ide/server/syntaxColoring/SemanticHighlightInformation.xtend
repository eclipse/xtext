/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.syntaxColoring

import java.util.List
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.annotations.LanguageServerAPI

/**
 * Representation of a range and highlighting style identifiers that should be
 * highlighted based on semantic information of the underlying model.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@LanguageServerAPI
class SemanticHighlightInformation {

	/**
	 * The range that should be highlighted on the client-side.
	 */
	Range range;

	/**
	 * A list of highlighting style identifiers, that should be applied on
	 * the range. Several styles could be merged on the client-side by 
	 * applying all styles on the range. 
	 */
	List<String> ids;

}
