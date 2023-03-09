/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.occurrences;

import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import com.google.common.base.Preconditions;
import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * Representation of a transformer function that creates document
 * {@link DocumentHighlight document highlight} instances form
 * {@link ITextRegion text regions}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@ImplementedBy(ITextRegionTransformer.Default.class)
public interface ITextRegionTransformer {

	/**
	 * Transforms the {@link ITextRegion text region} argument into a
	 * {@link DocumentHighlight document highlight} instance by calculating the
	 * proper position from the document. The given kind will be used to
	 * distinguish between {@link DocumentHighlightKind#Read read},
	 * {@link DocumentHighlightKind#Write write} and ordinary
	 * {@link DocumentHighlightKind#Text text} occurrences.
	 * 
	 * <p>
	 * This conversion is required to transform the Xtext specific document
	 * relative offsets into language server specific line relative offsets.
	 * 
	 * @param document
	 *            the document that contains the text content. Cannot be
	 *            {@code null}.
	 * @param region
	 *            the text region that has to be converted. Cannot be
	 *            {@code null}.
	 * @param kind
	 *            the document highlight kind. Cannot be {@code null}.
	 * 
	 * @return
	 *            with a new transformed {@link DocumentHighlight document
	 *            highlight} instance.
	 */
	DocumentHighlight apply(final Document document, final ITextRegion region, final DocumentHighlightKind kind);

	/**
	 * Default text region to document highlight transformation function. Works
	 * only with {@link ITextRegionWithLineInformation} instances.
	 * 
	 * @author akos.kitta - Initial contribution and API
	 */
	@Singleton
	static final class Default implements ITextRegionTransformer {

		@Override
		public DocumentHighlight apply(final Document document, final ITextRegion region,
				final DocumentHighlightKind kind) {

			Preconditions.checkNotNull(document, "document");
			Preconditions.checkNotNull(region, "region");
			Preconditions.checkNotNull(kind, "kind");

			final int offset = region.getOffset();
			final Position start = document.getPosition(offset);
			final Position end = document.getPosition(offset + region.getLength());

			return new DocumentHighlight(new Range(start, end), kind);
		}

	}

}
