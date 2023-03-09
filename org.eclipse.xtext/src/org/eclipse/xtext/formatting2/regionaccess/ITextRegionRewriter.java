/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.io.IOException;

/**
 * 
 * Use {@link ITextRegionAccess#getRewriter()} to obtain an instance implementing this interface.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITextRegionRewriter {

	public void renderToAppendable(Iterable<? extends ITextReplacement> replacements, Appendable result)
			throws IOException;

	public ITextReplacement createReplacement(int offset, int length, String text);

	public void renderToAppendable(ITextSegment segment, Iterable<? extends ITextReplacement> replacements,
			Appendable result) throws IOException;

	/**
	 * <p>
	 * Applies all 'replacements' on the {@link ITextRegionAccess} this rewriter is responsible for.
	 * </p>
	 * 
	 * <p>
	 * Replaces the text regions in 'input' identified by {@link ITextReplacement#getOffset()} and
	 * {@link ITextReplacement#getLength()} with {@link ITextReplacement#getReplacementText()}.
	 * </p>
	 * 
	 * @return The text after the replacements have been applied.
	 */
	public String renderToString(Iterable<? extends ITextReplacement> replacements);

	/**
	 * Applies replacements similar to {@link #renderToString(Iterable)}, but {@link ITextReplacement#getOffset()} is
	 * treated as relative to {@link ITextSegment#getOffset()} from 'input'.
	 */
	public String renderToString(ITextSegment input, Iterable<? extends ITextReplacement> replacements);

}
