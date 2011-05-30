/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.doubleClicking.AbstractPartitionDoubleClickSelector;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.xtend2.ui.autoedit.TokenTypeToPartitionMapper;

/**
 * Double click strategy that is aware of rich string partitions.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Xtend2DoubleClickStrategyProvider extends DoubleClickStrategyProvider {

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
		return super.getStrategy(sourceViewer, contentType, documentPartitioning);
	}
	
}
