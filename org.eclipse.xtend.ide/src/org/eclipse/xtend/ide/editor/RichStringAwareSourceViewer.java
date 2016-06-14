/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringAwareSourceViewer extends XtextSourceViewer {

	private static Logger log = Logger.getLogger(RichStringAwareSourceViewer.class);
	
	@Singleton
	public static class Factory extends DefaultFactory {

		@Inject
		private TypedRegionMerger merger;
		
		@Override
		public XtextSourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler,
				IOverviewRuler overviewRuler, boolean showsAnnotationOverview, int styles) {
			RichStringAwareSourceViewer result = new RichStringAwareSourceViewer(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
			result.merger = merger;
			return result;
		}
		
	}
	
	private TypedRegionMerger merger;
	
	public RichStringAwareSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void shift(boolean useDefaultPrefixes, boolean right, boolean ignoreWhitespace) {
		if (useDefaultPrefixes && ignoreWhitespace) { // let's assume we toggled comments
			if (fUndoManager != null)
				fUndoManager.beginCompoundChange();

			IDocument d= getDocument();
			@SuppressWarnings("rawtypes")
			Map partitioners= null;
			DocumentRewriteSession rewriteSession= null;
			try {
				ITextSelection selection= (ITextSelection) getSelection();
				IRegion block= copiedGetTextBlockFromSelection(selection);
				ITypedRegion[] regions= TextUtilities.computePartitioning(d, getDocumentPartitioning(), block.getOffset(), block.getLength(), false);
				regions = merger.merge(regions);
				int lineCount= 0;
				int[] lines= new int[regions.length * 2]; // [start line, end line, start line, end line, ...]
				for (int i= 0, j= 0; i < regions.length; i++, j+= 2) {
					// start line of region
					lines[j]= copiedGetFirstCompleteLineOfRegion(regions[i]);
					// end line of region
					int length= regions[i].getLength();
					int offset= regions[i].getOffset() + length;
					if (length > 0)
						offset--;
					lines[j + 1]= (lines[j] == -1 ? -1 : d.getLineOfOffset(offset));
					lineCount += lines[j + 1] - lines[j] + 1;
				}

				if (d instanceof IDocumentExtension4) {
					IDocumentExtension4 extension= (IDocumentExtension4) d;
					rewriteSession= extension.startRewriteSession(DocumentRewriteSessionType.SEQUENTIAL);
				} else {
					setRedraw(false);
					startSequentialRewriteMode(true);
				}
				if (lineCount >= 20)
					partitioners= TextUtilities.removeDocumentPartitioners(d);

				// Perform the shift operation.
				@SuppressWarnings("rawtypes")
				Map map=  fDefaultPrefixChars;
					for (int i= 0, j= 0; i < regions.length; i++, j += 2) {
					String[] prefixes= (String[]) copiedSelectContentTypePlugin(regions[i].getType(), map);
					if (prefixes != null && prefixes.length > 0 && lines[j] >= 0 && lines[j + 1] >= 0) {
						if (right)
							copiedShiftRight(lines[j], lines[j + 1], prefixes[0]);
						else
							copiedShiftLeft(lines[j], lines[j + 1], prefixes, ignoreWhitespace);
					}
				}

			} catch (BadLocationException x) {
				log.debug(x.getMessage(), x);

			} finally {

				if (partitioners != null)
					TextUtilities.addDocumentPartitioners(d, partitioners);

				if (d instanceof IDocumentExtension4) {
					IDocumentExtension4 extension= (IDocumentExtension4) d;
					extension.stopRewriteSession(rewriteSession);
				} else {
					stopSequentialRewriteMode();
					setRedraw(true);
				}

				if (fUndoManager != null)
					fUndoManager.endCompoundChange();
			}
		} else {
			super.shift(useDefaultPrefixes, right, ignoreWhitespace);
		}
	}
	
	private IRegion copiedGetTextBlockFromSelection(ITextSelection selection) {

		try {
			IDocument document= getDocument();
			int start= document.getLineOffset(selection.getStartLine());
			int endLine= selection.getEndLine();
			IRegion endLineInfo= document.getLineInformation(endLine);
			int end= endLineInfo.getOffset() + endLineInfo.getLength();
			return new Region(start, end - start);

		} catch (BadLocationException x) {
		}

		return null;
	}
	
	private void copiedShiftRight(int startLine, int endLine, String prefix) {

		try {

			IDocument d= getDocument();
			while (startLine <= endLine) {
				d.replace(d.getLineOffset(startLine++), 0, prefix);
			}

		} catch (BadLocationException x) {
			log.debug(x.getMessage(), x);
		}
	}
	
	private void copiedShiftLeft(int startLine, int endLine, String[] prefixes, boolean ignoreWhitespace) {

		IDocument d= getDocument();

		try {

			IRegion[] occurrences= new IRegion[endLine - startLine + 1];

			// find all the first occurrences of prefix in the given lines
			for (int i= 0; i < occurrences.length; i++) {

				IRegion line= d.getLineInformation(startLine + i);
				String text= d.get(line.getOffset(), line.getLength());

				int index= -1;
				int[] found= TextUtilities.indexOf(prefixes, text, 0);
				if (found[0] != -1) {
					if (ignoreWhitespace) {
						String s= d.get(line.getOffset(), found[0]);
						s= s.trim();
						if (s.length() == 0)
							index= line.getOffset() + found[0];
					} else if (found[0] == 0)
						index= line.getOffset();
				}

				if (index > -1) {
					// remember where prefix is in line, so that it can be removed
					int length= prefixes[found[1]].length();
					if (length == 0 && !ignoreWhitespace && line.getLength() > 0) {
						// found a non-empty line which cannot be shifted
						return;
					}
					occurrences[i]= new Region(index, length);
				} else {
					// found a line which cannot be shifted
					return;
				}
			}

			// OK - change the document
			int decrement= 0;
			for (int i= 0; i < occurrences.length; i++) {
				IRegion r= occurrences[i];
				d.replace(r.getOffset() - decrement, r.getLength(), ""); //$NON-NLS-1$
				decrement += r.getLength();
			}

		} catch (BadLocationException x) {
			log.debug(x.getMessage(), x);
		}
	}

	private Object copiedSelectContentTypePlugin(String type, @SuppressWarnings("rawtypes") Map plugins) {

		if (plugins == null)
			return null;

		return plugins.get(type);
	}
	
	private int copiedGetFirstCompleteLineOfRegion(IRegion region) {

		try {

			IDocument d= getDocument();

			int startLine= d.getLineOfOffset(region.getOffset());

			int offset= d.getLineOffset(startLine);
			if (offset >= region.getOffset())
				return startLine;

			offset= d.getLineOffset(startLine + 1);
			return (offset > region.getOffset() + region.getLength() ? -1 : startLine + 1);

		} catch (BadLocationException x) {
			log.debug(x.getMessage(), x);
		}

		return -1;
	}
	
	@Override
	public void doOperation(int operation) {
		if (getTextWidget() == null || (!redraws() && operation != FORMAT))
			return;

		if(operation == CONTENTASSIST_PROPOSALS) {
			fContentAssistant.showPossibleCompletions();
			fContentAssistant.showContextInformation();
		} else {	
			super.doOperation(operation);
		}
	}
}
