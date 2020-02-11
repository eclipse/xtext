/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.doubleClicking.AbstractPartitionDoubleClickSelector;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.model.CommonBreakIterator;

/**
 * Double click strategy that is aware of rich string partitions.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendDoubleClickStrategyProvider extends DoubleClickStrategyProvider {

	@Override
	public ITextDoubleClickStrategy getStrategy(ISourceViewer sourceViewer, String contentType,
			String documentPartitioning) {
		if (TokenTypeToPartitionMapper.RICH_STRING_LITERAL_PARTITION.equals(contentType)) {
			return new AbstractPartitionDoubleClickSelector(documentPartitioning) {
				
				@Override
				protected IRegion getSelectedRegion(IDocument document, ITypedRegion completePartition)
						throws BadLocationException {
					String content = document.get(completePartition.getOffset(), completePartition.getLength());
					int trimLeft = 1; // assume « as start character
					if (content.startsWith("'''")) {
						trimLeft = 3;
					}
					int trimRight = 0;
					if (content.endsWith("'''")) {
						trimRight = 3;
					} else if (content.endsWith("''")) {
						trimRight = 2;
					} else if (content.endsWith("'") || content.endsWith("\u00AB")) {
						trimRight = 1;
					}
					return new Region(completePartition.getOffset() + trimLeft, completePartition.getLength() - trimLeft - trimRight);
				}
				
			};
		}
		if (TokenTypeToPartitionMapper.JAVA_DOC_PARTITION.equals(contentType)) {
			return new AbstractPartitionDoubleClickSelector(documentPartitioning) {

				/**
				 * Allows to select the complete <code>@param</code> instead of just the literal <code>param</code>.
				 * Copied from org.eclipse.jdt.internal.ui.text.java.JavadocDoubleClickStrategy.
				 */
				@Override
				protected IRegion findExtendedDoubleClickSelection(IDocument document, int position) {
					try {
						IRegion match = super.findExtendedDoubleClickSelection(document, position);
						if (match != null)
							return match;

						IRegion word = findWord(document, position);

						IRegion line = document.getLineInformationOfOffset(position);
						if (position == line.getOffset() + line.getLength())
							return null;

						int start = word.getOffset();
						int end = start + word.getLength();

						if (start > 0
								&& document.getChar(start - 1) == '@'
								&& Character.isJavaIdentifierPart(document.getChar(start))
								&& (start == 1 || Character.isWhitespace(document.getChar(start - 2)) || document.getChar(start - 2) == '{')) {
							// double click after @ident
							start--;
						} else if (end == position 
								&& end == start + 1 
								&& end < line.getOffset() + line.getLength()
								&& document.getChar(end) == '@') {
							// double click before " @ident"
							return findExtendedDoubleClickSelection(document, position + 1);
						}

						if (start == end)
							return null;
						return new Region(start, end - start);

					} catch (BadLocationException x) {
						return null;
					}
				}

				@Override
				protected CommonBreakIterator createBreakIterator() {
					return new CommonBreakIterator(false) {
						class Braces extends Other {
							@Override
							protected boolean isValid(char ch) {
								return ch == '{' || ch == '}';
							}
						}

						class Parentheses extends Other {
							@Override
							protected boolean isValid(char ch) {
								return ch == '(' || ch == ')';
							}
						}

						Braces braces = new Braces();
						Parentheses parentheses = new Parentheses();

						@Override
						protected Run getRun(char ch) {
							if (braces.isValid(ch)) {
								return braces;
							}
							if (parentheses.isValid(ch)) {
								return parentheses;
							}
							return super.getRun(ch);
						}
					};
				}
			};

		}
		return super.getStrategy(sourceViewer, contentType, documentPartitioning);
	}

}
