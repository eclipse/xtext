/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SinglelineDocCommentReplacer extends SinglelineCommentReplacer {

	public SinglelineDocCommentReplacer(IComment comment, String prefix) {
		super(comment, prefix);
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		ITextSegment firstSpace = getFirstSpace();
		if (firstSpace != null) {
			if (hasEmptyBody())
				context.addReplacement(firstSpace.replaceWith(""));
			else
				context.addReplacement(firstSpace.replaceWith(" "));
		}
		return context;
	}

	@Override
	public void configureWhitespace(WhitespaceReplacer leading, WhitespaceReplacer trailing) {
	}

}
