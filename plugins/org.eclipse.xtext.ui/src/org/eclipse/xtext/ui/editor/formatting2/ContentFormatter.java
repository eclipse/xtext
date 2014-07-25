/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting2;

import static java.util.Collections.*;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.formatting2.impl.FormatterRequest;
import org.eclipse.xtext.formatting2.impl.LoggingFormatterProblemReporter;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ContentFormatter implements IContentFormatter {

	@Inject
	private Provider<LoggingFormatterProblemReporter> loggingFormatterProblemReporterProvider;

	@Inject
	private Provider<FormattingUnitOfWork> formattingUnitOfWorkProvider;

	public void format(IDocument document, IRegion region) {
		IXtextDocument doc = (IXtextDocument) document;
		FormattingUnitOfWork unitOfWork = formattingUnitOfWorkProvider.get();
		initializeRequest(unitOfWork.getRequest(), document, region);
		TextEdit r = doc.readOnly(unitOfWork);
		try {
			if (r != null)
				r.apply(document);
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
	}

	protected void initializeRequest(FormatterRequest request, IDocument document, IRegion region) {
		ITextRegion textRegion = new TextRegion(region.getOffset(), region.getLength());
		request.setAllowIdentityEdits(false);
		request.setFormatUndenfinedTokensOnly(false);
		request.setProblemHandler(loggingFormatterProblemReporterProvider.get());
		request.setRegions(singletonList(textRegion));
	}

	public Provider<LoggingFormatterProblemReporter> getLoggingFormatterProblemReporterProvider() {
		return loggingFormatterProblemReporterProvider;
	}

	public Provider<FormattingUnitOfWork> getFormattingUnitOfWorkProvider() {
		return formattingUnitOfWorkProvider;
	}

	public IFormattingStrategy getFormattingStrategy(String contentType) {
		return null;
	}
}