/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.occurrences;

import java.util.List;

import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightParams;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.ImplementedBy;

/**
 * Representation of a document highlight service. This service can be used to
 * resolve document highlights for a given text document position.
 * 
 * <p>
 * For programming languages this usually highlights all references to the
 * symbol scoped to this file.
 * 
 * @author akos.kitta - Initial contribution and API
 * 
 * @see DocumentHighlight
 */
@ImplementedBy(DefaultDocumentHighlightService.class)
public interface IDocumentHighlightService {

	/**
	 * @since 2.21
	 */
	List<? extends DocumentHighlight> getDocumentHighlights(Document document, XtextResource resource, DocumentHighlightParams params, CancelIndicator cancelIndicator);

}
