/*******************************************************************************
 * Copyright (c) 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.folding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.lsp4j.FoldingRange;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.editor.folding.IFoldingRangeProvider;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Mark Sujew - Initial contribution and API
 * 
 * @since 2.26
 */
@Singleton
public class FoldingRangeService {

	@Inject
	private IFoldingRangeProvider foldingRangeProvider;

	public List<FoldingRange> createFoldingRanges(Document document, XtextResource resource,
			CancelIndicator cancelIndicator) {
		if (resource == null || document == null) {
			return Collections.emptyList();
		}
		return foldingRangeProvider.getFoldingRanges(resource, cancelIndicator).stream()
				.map(range -> toFoldingRange(document, range)).filter(range -> isValidRange(range))
				.collect(Collectors.toList());
	}

	protected FoldingRange toFoldingRange(Document document, org.eclipse.xtext.ide.editor.folding.FoldingRange range) {
		int offset = range.getOffset();
		int length = range.getLength();
		int endOffset = offset + length;
		Position start = document.getPosition(offset);
		Position end = document.getPosition(endOffset);
		FoldingRange result = new FoldingRange(start.getLine(), end.getLine());
		if (range.getKind() != null) {
			result.setKind(range.getKind().toString());
		}
		return result;
	}

	protected boolean isValidRange(FoldingRange range) {
		return range.getStartLine() < range.getEndLine();
	}
}
