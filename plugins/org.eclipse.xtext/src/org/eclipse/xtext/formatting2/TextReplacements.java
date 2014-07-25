/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.internal.TextReplacementList;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextReplacements {
	public static String apply(CharSequence input, Iterable<ITextReplacement> replacements) {
		ArrayList<ITextReplacement> list = new TextReplacementList<ITextReplacement>(replacements);
		Collections.sort(list);
		int lastOffset = 0;
		StringBuilder result = new StringBuilder();
		for (ITextReplacement r : list) {
			result.append(input.subSequence(lastOffset, r.getOffset()));
			result.append(r.getReplacementText());
			lastOffset = r.getOffset() + r.getLength();
		}
		result.append(input.subSequence(lastOffset, input.length()));
		return result.toString();
	}

	public static String apply(ITextSegment input, Iterable<ITextReplacement> replacements) {
		List<ITextReplacement> list = new TextReplacementList<ITextReplacement>(replacements);
		Collections.sort(list);
		String text = input.getText();
		int offset = input.getOffset();
		int lastOffset = 0;
		StringBuilder result = new StringBuilder();
		for (ITextReplacement r : list) {
			result.append(text.subSequence(lastOffset, r.getOffset() - offset));
			result.append(r.getReplacementText());
			lastOffset = (r.getOffset() - offset) + r.getLength();
		}
		result.append(text.subSequence(lastOffset, text.length()));
		return result.toString();
	}
}
