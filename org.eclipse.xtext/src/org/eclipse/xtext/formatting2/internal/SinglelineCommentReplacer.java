/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class SinglelineCommentReplacer extends CommentReplacer {

	private final String prefix;

	public SinglelineCommentReplacer(IComment comment, String prefix) {
		super(comment);
		this.prefix = prefix;
	}

	protected ITextSegment getFirstSpace() {
		IComment comment = getComment();
		String text = comment.getText();
		if (!text.startsWith(prefix))
			return null;
		int start = prefix.length();
		for (int i = start; i < text.length(); i++) {
			char charAt = text.charAt(i);
			if (!Character.isWhitespace(charAt) || charAt == '\r' || charAt == '\n')
				return new TextSegment(comment.getTextRegionAccess(), comment.getOffset() + start, i - start);
		}
		return new TextSegment(comment.getTextRegionAccess(), comment.getOffset() + start, text.length() - start);
	}

	public String getPrefix() {
		return prefix;
	}

	protected boolean hasEmptyBody() {
		IComment comment = getComment();
		String text = comment.getText();
		if (!text.startsWith(prefix))
			return false;
		int start = prefix.length();
		for (int i = start; i < text.length(); i++) {
			char charAt = text.charAt(i);
			if (!Character.isWhitespace(charAt))
				return false;
		}
		return true;
	}

}
