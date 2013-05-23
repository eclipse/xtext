/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.reconciler.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class ContentFormatterFactory implements IContentFormatterFactory {

	public class ContentFormatter implements IContentFormatter {
		public void format(IDocument document, IRegion region) {
			IXtextDocument doc = (IXtextDocument) document;
			ReplaceRegion r = doc.readOnly(new FormattingUnitOfWork(region));
			try {
				if (r != null)
					doc.replace(r.getOffset(), r.getLength(), r.getText());
			} catch (BadLocationException e) {
				throw new RuntimeException(e);
			}
		}

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

	public IContentFormatter createConfiguredFormatter(
			SourceViewerConfiguration configuration, ISourceViewer sourceViewer) {
		return new ContentFormatter();
	}

}
