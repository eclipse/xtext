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
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.eclipse.xtext.xbase.formatting.IBasicFormatter;
import org.eclipse.xtext.xbase.formatting.IFormattingPreferenceValuesProvider;
import org.eclipse.xtext.xbase.formatting.TextReplacement;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated // use org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory
public class FormatterFactory implements IContentFormatterFactory {

	//TODO move me to Xtext
	public static class ContentFormatter implements IContentFormatter {
		@Inject
		protected IBasicFormatter formatter;
		
		@Inject
		private IFormattingPreferenceValuesProvider cfgProvider;
		
		public void format(IDocument document, IRegion region) {
			IXtextDocument doc = (IXtextDocument) document;
			
			TextEdit r = doc.priorityReadOnly(new FormattingUnitOfWork(formatter, region, cfgProvider));
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

	//TODO move me to Xtext
	public static class FormattingUnitOfWork implements IUnitOfWork<TextEdit, XtextResource> {

		private final IRegion region;
		private final IPreferenceValuesProvider configurationProvider;
		private final IBasicFormatter formatter;

		public FormattingUnitOfWork(IBasicFormatter formatter, IRegion region, IPreferenceValuesProvider configurationProvider) {
			super();
			this.configurationProvider = configurationProvider;
			this.region = region;
			this.formatter = formatter;
		}

		public TextEdit exec(XtextResource state) throws Exception {
			IParseResult parseResult = state.getParseResult();
			if (parseResult == null)
				return null;
			IPreferenceValues configuration = configurationProvider.getPreferenceValues(state);
			final MultiTextEdit mte = new MultiTextEdit();
			try {
				//	long start = System.currentTimeMillis();
				List<TextReplacement> edits = formatter.format(state, region.getOffset(), region.getLength(), new FormattingPreferenceValues(configuration));
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
	
	@Inject private ContentFormatter formatter;

	public IContentFormatter createConfiguredFormatter(SourceViewerConfiguration configuration,
			ISourceViewer sourceViewer) {
		return formatter;
	}

}
