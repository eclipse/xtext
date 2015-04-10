/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.internal.TextReplacementList;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;

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
	public void renderToAppendable(Iterable<? extends ITextReplacement> replacements, Appendable result) {
		renderToAppendable((ITextSegment) access, replacements, result);
	}

	@Override
	public void renderToAppendable(ITextSegment input, Iterable<? extends ITextReplacement> rep, Appendable result) {
		int offset = input.getOffset();
		String text = input.getText();
		List<ITextReplacement> list = new TextReplacementList<ITextReplacement>(rep);
		Collections.sort(list);
		int lastOffset = 0;
		try {
			for (ITextReplacement r : rep) {
				result.append(text.subSequence(lastOffset, r.getOffset() - offset));
				result.append(r.getReplacementText());
				lastOffset = (r.getOffset() - offset) + r.getLength();
			}
			result.append(text.subSequence(lastOffset, text.length()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String renderToString(Iterable<? extends ITextReplacement> replacements) {
		StringBuilder result = new StringBuilder();
		renderToAppendable(replacements, result);
		return result.toString();
	}

	@Override
	public String renderToString(ITextSegment input, Iterable<? extends ITextReplacement> replacements) {
		StringBuilder result = new StringBuilder();
		renderToAppendable(input, replacements, result);
		return result.toString();
	}
}
