/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IInternalFormatter extends IFormatter {

	ITextReplacer createCommentReplacer(IComment comment);

	IFormattableDocument createFormattableDocument();

	IFormattableSubDocument createFormattableSubDocument(int offset, int length, IFormattableDocument parent);

	IHiddenRegionFormatting createHiddenRegionFormatting(IFormattableDocument document, IHiddenRegion hiddenRegion);

	IMerger<IHiddenRegionFormatting> createHiddenRegionFormattingMerger();

	ITextReplacer createHiddenRegionReplacer(IHiddenRegionFormatting hiddenRegionFormatting);

	ITextReplacement createTextReplacement(int offset, int length, String text);

	ITextReplacerContext createTextReplacerContext(IFormattableDocument document);

	IMerger<ITextReplacer> createTextReplacerMerger();

	IFormatterRequest getRequest();
}
