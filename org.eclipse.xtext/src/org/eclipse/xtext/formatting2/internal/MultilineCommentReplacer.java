/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.List;

import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MultilineCommentReplacer extends CommentReplacer {

	private final boolean multiline;
	private final char prefix;

	public MultilineCommentReplacer(IComment comment, char prefix) {
		super(comment);
		this.prefix = prefix;
		this.multiline = comment.isMultiline();
	}

	@Override
	public void configureWhitespace(WhitespaceReplacer leading, WhitespaceReplacer trailing) {
		if (multiline) {
			enforceNewLine(leading);
			enforceNewLine(trailing);
		} else {
			if (!leading.getRegion().isMultiline()) {
				enforceSingleSpace(leading);
			}
			if (!trailing.getRegion().isMultiline()) {
				enforceSingleSpace(trailing);
			}
		}
	}

	@Override
	public ITextReplacerContext createReplacements(ITextReplacerContext context) {
		if (!multiline)
			return context;
		IComment comment = getComment();
		ITextRegionAccess access = comment.getTextRegionAccess();
		List<ILineRegion> lines = comment.getLineRegions();
		String oldIndentation = lines.get(0).getIndentation().getText();
		String indentationString = context.getIndentationString();
		String newIndentation = indentationString + " " + prefix + " ";
		for (int i = 1; i < lines.size() - 1; i++) {
			ITextSegment line = lines.get(i);
			String text = line.getText();
			int prefixOffset = prefixOffset(text);
			ITextSegment target;
			if (prefixOffset >= 0)
				target = access.regionForOffset(line.getOffset(), prefixOffset + 1);
			else if (text.startsWith(oldIndentation))
				target = access.regionForOffset(line.getOffset(), oldIndentation.length());
			else
				target = access.regionForOffset(line.getOffset(), 0);
			context.addReplacement(target.replaceWith(newIndentation));
		}
		if (lines.size() > 1) {
			ILineRegion line = lines.get(lines.size() - 1);
			context.addReplacement(line.getIndentation().replaceWith(indentationString + " "));
		}
		return context;
	}

	protected void enforceNewLine(WhitespaceReplacer replacer) {
		if (replacer.getRegion().getOffset() <= 0)
			return;
		Integer min = replacer.getFormatting().getNewLineMin();
		if (min == null || min < 1)
			replacer.getFormatting().setNewLinesMin(1);
	}

	protected void enforceSingleSpace(WhitespaceReplacer replacer) {
		if (replacer.getRegion().getOffset() <= 0)
			return;
		String space = replacer.getFormatting().getSpace();
		if (space == null || space.length() < 1)
			replacer.getFormatting().setSpace(" ");
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
