/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.occurrences;

import java.util.List;

import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

import io.typefox.lsapi.DocumentHighlight;

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
	 * Returns with a list of {@link DocumentHighlight document highlight}
	 * instances that matches with the given text from the resource at the given
	 * offset.
	 * 
	 * @param resource
	 *            the resource that represents the document where matching
	 *            highlights have to be collected.
	 * @param offset
	 *            the offset used to identify the selected text from the
	 *            resource.
	 * 
	 * @return a list of document highlight instances that matches with the
	 *         selected text based on an arbitrary logic. Might return with an
	 *         empty list but never returns with {@code null}.
	 */
	List<? extends DocumentHighlight> getDocumentHighlights(final XtextResource resource, final int offset);

}
