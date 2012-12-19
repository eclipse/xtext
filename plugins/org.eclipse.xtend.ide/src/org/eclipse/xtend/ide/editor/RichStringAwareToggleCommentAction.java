/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.toggleComments.ToggleSLCommentAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringAwareToggleCommentAction extends ToggleSLCommentAction {

	private static Logger log = Logger.getLogger(RichStringAwareToggleCommentAction.class);
	
	@Singleton
	public static class Factory extends ToggleSLCommentAction.Factory {

		@Inject
		private TypedRegionMerger merger;
		
		@Override
		public ToggleSLCommentAction create(ResourceBundle bundle, String prefix, ITextEditor editor) {
			RichStringAwareToggleCommentAction result = new RichStringAwareToggleCommentAction(bundle, prefix, editor);
			result.merger = merger;
			return result;
		}
	}
	
	private TypedRegionMerger merger;
	
	public RichStringAwareToggleCommentAction(ResourceBundle bundle, String prefix, ITextEditor editor) {
		super(bundle, prefix, editor);
	}
	
	@Override
	protected boolean isSelectionCommented(ISelection selection) {
		if (!(selection instanceof ITextSelection))
			return false;

		ITextSelection textSelection= (ITextSelection) selection;
		if (textSelection.getStartLine() < 0 || textSelection.getEndLine() < 0)
			return false;

		IDocument document= getTextEditor().getDocumentProvider().getDocument(getTextEditor().getEditorInput());

		try {

			IRegion block= getTextBlockFromSelection(textSelection, document);
			ITypedRegion[] regions= TextUtilities.computePartitioning(document, getDocumentPartitioning(), block.getOffset(), block.getLength(), false);
			regions = merger.merge(regions);
			int[] lines= new int[regions.length * 2]; // [startline, endline, startline, endline, ...]
			for (int i= 0, j= 0; i < regions.length; i++, j+= 2) {
				// start line of region
				lines[j]= getFirstCompleteLineOfRegion(regions[i], document);
				// end line of region
				int length= regions[i].getLength();
				int offset= regions[i].getOffset() + length;
				if (length > 0)
					offset--;
				lines[j + 1]= (lines[j] == -1 ? -1 : document.getLineOfOffset(offset));
			}

			// Perform the check
			for (int i= 0, j= 0; i < regions.length; i++, j += 2) {
				String[] prefixes= getPrefixesMap().get(regions[i].getType());
				if (prefixes != null && prefixes.length > 0 && lines[j] >= 0 && lines[j + 1] >= 0)
					if (!isBlockCommented(lines[j], lines[j + 1], prefixes, document))
						return false;
			}

			return true;

		} catch (BadLocationException x) {
			// should not happen
			log.error(x.getMessage(), x);
		}

		return false;
	}

}
