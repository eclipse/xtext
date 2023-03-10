/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.reconciler.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class ContentFormatterFactory implements IContentFormatterFactory {

	public class ContentFormatter implements IContentFormatter {
		@Override
		public void format(IDocument document, IRegion region) {
			IXtextDocument doc = xtextDocumentUtil.getXtextDocument(document);
			ReplaceRegion r = doc.priorityReadOnly(new FormattingUnitOfWork(region));
			try {
				if (r != null) {
					TextEdit edit = createTextEdit(doc, r);
					if (edit != null) {
						edit.apply(doc);
					}
					
				}
			} catch (BadLocationException e) {
				throw new RuntimeException(e);
			}
		}
		
		@Override
		public IFormattingStrategy getFormattingStrategy(String contentType) {
			return null;
		}
	}

	/**
	 * TODO: Use a {@link org.eclipse.xtext.util.ReplaceRegion} instead of the {@link ReplaceRegion}.
	 */
	public class FormattingUnitOfWork implements
			IUnitOfWork<ReplaceRegion, XtextResource> {

		protected final IRegion region;

		public FormattingUnitOfWork(IRegion region) {
			super();
			this.region = region;
		}

		@Override
		public ReplaceRegion exec(XtextResource state) throws Exception {
			IParseResult parseResult = state.getParseResult();
			if (parseResult == null)
				return null;
			IFormattedRegion r = formatter.format(parseResult.getRootNode(), region.getOffset(), region.getLength());
			return new ReplaceRegion(r.getOffset(), r.getLength(), r.getFormattedText());
		}
	}

	@Inject
	protected INodeModelFormatter formatter;
	
	/**
	 * @since 2.19
	 */
	@Inject 
	protected XtextDocumentUtil xtextDocumentUtil;

	@Override
	public IContentFormatter createConfiguredFormatter(
			SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		return new ContentFormatter();
	}
	
	/**
	 * Create a text edit from the given replace region.
	 * The default impl will strip the common leading and trailing parts of the replaced region and the replacement text. 
	 * 
	 * @since 2.8
	 */
	protected TextEdit createTextEdit(IXtextDocument doc, ReplaceRegion r) throws BadLocationException {
		String originalText = doc.get(r.getOffset(), r.getLength());
		String newText = r.getText();
		int start = 0;
		int originalEnd = originalText.length() - 1;
		int newEnd = newText.length() - 1;
		int minLen = Math.min(r.getLength(), newText.length());
		while(start < minLen && originalText.charAt(start) == newText.charAt(start)) {
			start++;
		}
		while (originalEnd >= start
				&& newEnd >= start
				&& originalText.charAt(originalEnd) == newText.charAt(newEnd)) {
			originalEnd--;
			newEnd--;
		}
		return new ReplaceEdit(r.getOffset() + start, originalEnd - start + 1, r.getText().substring(start, newEnd + 1));
	}

}
