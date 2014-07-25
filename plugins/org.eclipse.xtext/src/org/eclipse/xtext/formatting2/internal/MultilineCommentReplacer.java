/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IComment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MultilineCommentReplacer extends CommentReplacer {

	private final char prefix;

	public MultilineCommentReplacer(IComment comment, char prefix) {
		super(comment);
		this.prefix = prefix;
	}

	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		IComment comment = getComment();
		String oldIndentation = comment.getIndentation().getText();
		String indentationString = context.getIndentationString();
		String newIndentation = indentationString + " " + prefix + " ";
		List<ITextSegment> lines = comment.splitIntoLines();
		for (int i = 1; i < lines.size() - 1; i++) {
			ITextSegment line = lines.get(i);
			String text = line.getText();
			int prefixOffset = prefixOffset(text);
			if (prefixOffset >= 0) {
				context.replaceText(line.getOffset(), prefixOffset + 1, newIndentation);
			} else if (text.startsWith(oldIndentation)) {
				context.replaceText(line.getOffset(), oldIndentation.length(), newIndentation);
			} else {
				context.replaceText(line.getOffset(), 0, newIndentation);
			}
		}
		if (lines.size() > 1) {
			ITextSegment line = lines.get(lines.size() - 1);
			context.replaceText(line.getIndentation(), indentationString + " ");
		}
		return context;
	}

	protected int prefixOffset(String string) {
		for (int i = 0; i < string.length(); i++) {
			char charAt = string.charAt(i);
			if (prefix == charAt) {
				int j = i + 1;
				if (j < string.length() && Character.isWhitespace(string.charAt(j)))
					return j;
				else
					return i;
			}
			if (!Character.isWhitespace(charAt))
				return -1;
		}
		return -1;
	}

}
