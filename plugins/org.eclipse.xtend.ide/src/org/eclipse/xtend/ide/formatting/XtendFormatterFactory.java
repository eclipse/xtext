/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.IFormatterConfigurationProvider;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtendFormatterFactory implements IContentFormatterFactory {

	@Inject
	protected XtendFormatter formatter;
	@Inject
	private IFormatterConfigurationProvider cfgProvider;

	public class ContentFormatter implements IContentFormatter {
		public void format(IDocument document, IRegion region) {
			IXtextDocument doc = (IXtextDocument) document;
			TextEdit r = doc.readOnly(new FormattingUnitOfWork(region));
			try {
				if (r != null)
					r.apply(document);
			} catch (BadLocationException e) {
				throw new RuntimeException(e);
			}
		}

		public IFormattingStrategy getFormattingStrategy(String contentType) {
			return null;
		}
	}

	public class FormattingUnitOfWork implements IUnitOfWork<TextEdit, XtextResource> {

		protected final IRegion region;

		public FormattingUnitOfWork(IRegion region) {
			super();
			this.region = region;
		}

		public TextEdit exec(XtextResource state) throws Exception {
			IParseResult parseResult = state.getParseResult();
			if (parseResult == null)
				return null;
			final MultiTextEdit mte = new MultiTextEdit();
			try {
				IConfigurationValues<XtendFormatterConfigKeys> cfg = cfgProvider.getFormatterConfiguration(state);
				//	long start = System.currentTimeMillis();
				List<TextReplacement> edits = formatter.format(state, region.getOffset(), region.getLength(), cfg);
				//	long time = System.currentTimeMillis() - start;
				//	System.out.println(String.format("Formatting: Time to create text edits: %.3f sec. Applied edits: %d", time / 1000.0, edits.size()));
				for (TextReplacement tr : edits)
					mte.addChild(new ReplaceEdit(tr.getOffset(), tr.getLength(), tr.getText()));
			} catch (Throwable e) {
				e.printStackTrace();// dialog
			}
			return mte;
		}
	}

	public void setConfigurationProvider(IFormatterConfigurationProvider provider) {
		this.cfgProvider = provider;
	}

	public IContentFormatter createConfiguredFormatter(SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		return new ContentFormatter();
	}

}
