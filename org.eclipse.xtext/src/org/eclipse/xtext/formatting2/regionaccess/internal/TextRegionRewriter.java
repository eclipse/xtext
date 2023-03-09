/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.internal.TextReplacementList;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextRegionRewriter implements ITextRegionRewriter {

	private final ITextRegionAccess access;

	public TextRegionRewriter(ITextRegionAccess access) {
		super();
		this.access = access;
	}

	@Override
	public void renderToAppendable(Iterable<? extends ITextReplacement> replacements, Appendable result)
			throws IOException {
		renderToAppendable(access.regionForDocument(), replacements, result);
	}

	@Override
	public void renderToAppendable(ITextSegment input, Iterable<? extends ITextReplacement> rep, Appendable result)
			throws IOException {
		int offset = input.getOffset();
		String text = input.getText();
		List<ITextReplacement> list = new TextReplacementList<ITextReplacement>(rep);
		Collections.sort(list);
		int lastOffset = 0;
		for (ITextReplacement r : list) {
			result.append(text.subSequence(lastOffset, r.getOffset() - offset));
			result.append(r.getReplacementText());
			lastOffset = (r.getOffset() - offset) + r.getLength();
		}
		if (lastOffset <= text.length())
			result.append(text.subSequence(lastOffset, text.length()));
	}

	@Override
	public String renderToString(Iterable<? extends ITextReplacement> replacements) {
		StringBuilder result = new StringBuilder();
		try {
			renderToAppendable(replacements, result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result.toString();
	}

	@Override
	public String renderToString(ITextSegment input, Iterable<? extends ITextReplacement> replacements) {
		StringBuilder result = new StringBuilder();
		try {
			renderToAppendable(input, replacements, result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result.toString();
	}

	@Override
	public ITextReplacement createReplacement(int offset, int length, String text) {
		return new TextReplacement(access, offset, length, text);
	}
}
