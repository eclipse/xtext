/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.syntaxColoring;

import static java.util.Collections.*;

import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * Representation of a generic, IDE independent semantic highlighting service.
 * Provides coloring and semantic highlighting information for clients based on
 * the underlying model.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@ImplementedBy(ISemanticHighlightService.Noop.class)
public interface ISemanticHighlightService {

	/**
	 * Shared, immutable empty instance.
	 */
	SemanticHighlight EMPTY = new SemanticHighlight(emptyList());

	/**
	 * Provides semantic highlighting information based on the offset in the
	 * document.
	 * 
	 * @param resource
	 *            the resource that will be highlighted. May be {@code null} in
	 *            some rare cases.
	 * @param document
	 *            the IDE and Xtext independent document that can be used to
	 *            convert the document based offsets to line based positions.
	 * @return the semantic highlight proposal for the resource.
	 */
	SemanticHighlight getSemanticHighlight(XtextResource resource, Document document);

	/**
	 * NOOP {@link ISemanticHighlightService semantic highlighting service}
	 * implementation. Always provides an {@link ISemanticHighlightService#EMPTY
	 * empty} instance.
	 * 
	 * @author akos.kitta - Initial contribution and API
	 */
	public static class Noop implements ISemanticHighlightService {

		@Override
		public SemanticHighlight getSemanticHighlight(final XtextResource resource, final Document document) {
			return EMPTY;
		}

	}
}
