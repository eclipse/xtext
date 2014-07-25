/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting2;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.internal.FormatterRequest;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelTokenAccess;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.TypedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class FormattingUnitOfWork implements IUnitOfWork<TextEdit, XtextResource> {

	private final static Logger LOG = Logger.getLogger(FormattingUnitOfWork.class);

	@Inject
	private IFormatter2 formatter;

	@Inject
	private FormatterRequest request;

	public FormatterRequest getRequest() {
		return request;
	}

	@Inject
	@FormatterPreferences
	private IPreferenceValuesProvider cfgProvider;

	@Inject
	private NodeModelTokenAccess.Builder nodeModelTokenAccessBuilder;

	protected void initializeRequest(FormatterRequest request, XtextResource resource) {
		NodeModelTokenAccess tokenAccess = nodeModelTokenAccessBuilder.withResource(resource).create();
		IPreferenceValues preferenceValues = cfgProvider.getPreferenceValues(resource);
		request.setPreferenceValues(TypedPreferenceValues.castOrWrap(preferenceValues));
		request.setTokens(tokenAccess);
	}

	public TextEdit exec(XtextResource state) throws Exception {
		if (formatter == null)
			throw new RuntimeException("This " + getClass().getSimpleName() + " can not be executed a second time.");
		try {
			IParseResult parseResult = state.getParseResult();
			if (parseResult != null) {
				initializeRequest(request, state);
				List<ITextReplacement> replacements = formatter.format(request);
				final TextEdit mte = createTextEdit(replacements);
				return mte;
			}
		} catch (Exception e) {
			LOG.error("Error formatting " + state.getURI() + ": " + e.getMessage(), e);
		} finally {
			this.formatter = null;
		}
		return new MultiTextEdit();
	}

	protected TextEdit createTextEdit(List<ITextReplacement> replacements) {
		final MultiTextEdit mte = new MultiTextEdit();
		for (ITextReplacement tr : replacements)
			mte.addChild(new ReplaceEdit(tr.getOffset(), tr.getLength(), tr.getReplacementText()));
		return mte;
	}
}