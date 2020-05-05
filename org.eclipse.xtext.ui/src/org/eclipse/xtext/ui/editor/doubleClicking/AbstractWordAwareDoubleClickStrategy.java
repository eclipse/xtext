/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.doubleClicking;


import java.text.BreakIterator;
import java.text.CharacterIterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultTextDoubleClickStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.ui.editor.model.CommonBreakIterator;
import org.eclipse.xtext.ui.editor.model.DocumentCharacterIterator;

/**
 * <p>Customized {@link DefaultTextDoubleClickStrategy} that uses a word iterator instead
 * of a plain {@link java.text.BreakIterator break iterator} to tokenize the document
 * content. It is based on the plain text content of the document, e.g. terminal tokens are
 * not taken into account.</p>
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractWordAwareDoubleClickStrategy extends DefaultTextDoubleClickStrategy {

	@Override
	protected IRegion findWord(IDocument document, int offset) {
		try {
			IRegion line = document.getLineInformationOfOffset(offset);

			if (offset == line.getOffset() + line.getLength())
				return null;

			BreakIterator breakIter = createBreakIterator();
			CharacterIterator characterIterator = new DocumentCharacterIterator(document);
			breakIter.setText(characterIterator);
			int start = breakIter.preceding(offset);
			if (start == BreakIterator.DONE)
				start = line.getOffset();

			int end = breakIter.following(offset);
			if (end == BreakIterator.DONE)
				end = line.getOffset() + line.getLength();

			if (breakIter.isBoundary(offset)) {
				if (end - offset > offset - start)
					start = offset;
				else
					end = offset;
			}

			if (end == start)
				return null;
			return new Region(start, end - start);
		} catch (BadLocationException e) {
			return null;
		}
	}
	
	/**
	 * @return a new break iterator. Defaults to an instance that does not take camel humps into account.
	 */
	protected CommonBreakIterator createBreakIterator() {
		return new CommonBreakIterator(false);
	}
}
