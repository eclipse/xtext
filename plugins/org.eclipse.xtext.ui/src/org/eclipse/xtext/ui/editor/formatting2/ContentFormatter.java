/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting2;

import static java.util.Collections.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.internal.LoggingFormatterProblemReporter;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBaseRegionAccess;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.TypedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ContentFormatter implements IContentFormatter {

	public class FormattingUnitOfWork implements IUnitOfWork<TextEdit, XtextResource> {
		private final IXtextDocument document;
		private final IRegion region;

		public FormattingUnitOfWork(IXtextDocument document, IRegion region) {
			super();
			this.document = document;
			this.region = region;
		}

		public TextEdit exec(XtextResource state) throws Exception {
			return ContentFormatter.this.exec(document, region, state);
		}
	}

	private final static Logger LOG = Logger.getLogger(FormattingUnitOfWork.class);

	@Inject
	private Provider<IFormatter2> formatterProvider;

	@Inject
	private Provider<LoggingFormatterProblemReporter> loggingFormatterProblemReporterProvider;

	@Inject
	private NodeModelBaseRegionAccess.Builder nodeModelTokenAccessBuilder;

	@Inject
	@FormatterPreferences
	private IPreferenceValuesProvider preferencesProvider;

	@Inject
	private Provider<FormatterRequest> requestProvider;

	protected TextEdit createTextEdit(List<ITextReplacement> replacements) {
		final MultiTextEdit mte = new MultiTextEdit();
		for (ITextReplacement tr : replacements)
			mte.addChild(new ReplaceEdit(tr.getOffset(), tr.getLength(), tr.getReplacementText()));
		return mte;
	}

	protected TextEdit exec(IXtextDocument document, IRegion region, XtextResource resource) throws Exception {
		try {
			IParseResult parseResult = resource.getParseResult();
			if (parseResult != null) {
				FormatterRequest request = requestProvider.get();
				initRequest(document, region, resource, request);
				IFormatter2 formatter = formatterProvider.get();
				List<ITextReplacement> replacements = formatter.format(request);
				final TextEdit mte = createTextEdit(replacements);
				return mte;
			}
		} catch (Exception e) {
			LOG.error("Error formatting " + resource.getURI() + ": " + e.getMessage(), e);
		} finally {
			formatterProvider = null;
		}
		return new MultiTextEdit();
	}

	public void format(IDocument document, IRegion region) {
		IXtextDocument doc = (IXtextDocument) document;
		TextEdit r = doc.priorityReadOnly(new FormattingUnitOfWork(doc, region));
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

	public Provider<LoggingFormatterProblemReporter> getLoggingFormatterProblemReporterProvider() {
		return loggingFormatterProblemReporterProvider;
	}

	public IPreferenceValuesProvider getPreferencesProvider() {
		return preferencesProvider;
	}

	protected void initRequest(IXtextDocument document, IRegion region, XtextResource resource, FormatterRequest request) {
		ITextRegion textRegion = new TextRegion(region.getOffset(), region.getLength());
		request.setAllowIdentityEdits(false);
		request.setFormatUndenfinedTokensOnly(false);
		request.setProblemHandler(loggingFormatterProblemReporterProvider.get());
		request.setRegions(singletonList(textRegion));
		NodeModelBaseRegionAccess tokenAccess = nodeModelTokenAccessBuilder.withResource(resource).create();
		IPreferenceValues preferenceValues = preferencesProvider.getPreferenceValues(resource);
		request.setPreferenceValues(TypedPreferenceValues.castOrWrap(preferenceValues));
		request.setTokens(tokenAccess);
	}

	public void setPreferencesProvider(IPreferenceValuesProvider cfgProvider) {
		this.preferencesProvider = cfgProvider;
	}
}