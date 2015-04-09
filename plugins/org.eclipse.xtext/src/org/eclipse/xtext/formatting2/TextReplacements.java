/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.formatting2.internal.TextReplacementList;

/**
 * Utilities related to {@link ITextReplacement}.
 * 
 * @since 2.8
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TextReplacements {
	/**
	 * <p>
	 * Applies all 'replacements' on 'input'.
	 * </p>
	 * 
	 * <p>
	 * Replaces the text regions in 'input' identified by {@link ITextReplacement#getOffset()} and
	 * {@link ITextReplacement#getLength()} with {@link ITextReplacement#getReplacementText()}.
	 * </p>
	 * 
	 * @return The text after the replacements have been applied.
	 */
	public static String apply(CharSequence input, Iterable<? extends ITextReplacement> replacements) {
		StringBuilder result = new StringBuilder();
		doApply(input, 0, replacements, result);
		return result.toString();
	}

	public static void apply(CharSequence input, Iterable<? extends ITextReplacement> replacements, Appendable result) {
		doApply(input, 0, replacements, result);
	}

	/**
	 * Applies replacements similar to {@link #apply(CharSequence, Iterable)}, but {@link ITextReplacement#getOffset()}
	 * is treated as relative to {@link ITextSegment#getOffset()} from 'input'.
	 */
	public static String apply(ITextSegment input, Iterable<? extends ITextReplacement> replacements) {
		StringBuilder result = new StringBuilder();
		doApply(input.getText(), input.getOffset(), replacements, result);
		return result.toString();
	}

	private static String doApply(CharSequence input, int offset, Iterable<? extends ITextReplacement> replacements,
			Appendable result) {
		List<ITextReplacement> list = new TextReplacementList<ITextReplacement>(replacements);
		Collections.sort(list);
		int lastOffset = 0;
		try {
			for (ITextReplacement r : list) {
				result.append(input.subSequence(lastOffset, r.getOffset() - offset));
				result.append(r.getReplacementText());
				lastOffset = (r.getOffset() - offset) + r.getLength();
			}
			result.append(input.subSequence(lastOffset, input.length()));
			return result.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
