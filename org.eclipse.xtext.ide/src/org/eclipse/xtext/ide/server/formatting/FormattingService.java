/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server.formatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.lsp4j.DocumentFormattingParams;
import org.eclipse.lsp4j.DocumentRangeFormattingParams;
import org.eclipse.lsp4j.FormattingOptions;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Language Service Implementation for Formatting and Range-Formatting
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.11
 */
public class FormattingService {
	@Inject(optional = true)
	private Provider<IFormatter2> formatter2Provider;

	@Inject
	private Provider<FormatterRequest> formatterRequestProvider;

	@Inject
	private TextRegionAccessBuilder regionBuilder;

	@Inject
	private IIndentationInformation indentationInformation;

	public List<? extends TextEdit> format(Document document, XtextResource resource, DocumentFormattingParams params,
			CancelIndicator cancelIndicator) {
		int offset = 0;
		int length = document.getContents().length();
		if (length == 0 || resource.getContents().isEmpty()) {
			return Collections.emptyList();
		}
		return format(resource, document, offset, length, params.getOptions());
	}

	public List<? extends TextEdit> format(Document document, XtextResource resource,
			DocumentRangeFormattingParams params, CancelIndicator cancelIndicator) {
		int startOffset = document.getOffSet(params.getRange().getStart());
		int endOffset = document.getOffSet(params.getRange().getEnd());
		int length = endOffset - startOffset;
		return format(resource, document, startOffset, length, params.getOptions());
	}

	/**
	 * @since 2.14
	 */
	public List<TextEdit> format(XtextResource resource, Document document, int offset, int length,
			FormattingOptions options) {
		String indent = indentationInformation.getIndentString();
		if (options != null) {
			if (options.isInsertSpaces()) {
				indent = Strings.padEnd("", options.getTabSize(), ' ');
			}
		}
		List<TextEdit> result = new ArrayList<>();
		if (this.formatter2Provider != null) {
			MapBasedPreferenceValues preferences = new MapBasedPreferenceValues();
			preferences.put("indentation", indent);
			List<ITextReplacement> replacements = format2(resource, new TextRegion(offset, length), preferences);
			for (ITextReplacement r : replacements) {
				result.add(toTextEdit(document, r.getReplacementText(), r.getOffset(), r.getLength()));
			}
		}
		return result;
	}

	protected TextEdit toTextEdit(Document document, String formattedText, int startOffset, int length) {
		TextEdit textEdit = new TextEdit();
		textEdit.setNewText(formattedText);
		textEdit.setRange(new Range(document.getPosition(startOffset), document.getPosition((startOffset + length))));
		return textEdit;
	}

	protected List<ITextReplacement> format2(XtextResource resource, ITextRegion selection,
			ITypedPreferenceValues preferences) {
		FormatterRequest request = formatterRequestProvider.get();
		request.setAllowIdentityEdits(false);
		request.setFormatUndefinedHiddenRegionsOnly(false);
		if (selection != null) {
			request.setRegions(Collections.singletonList(selection));
		}
		if (preferences != null) {
			request.setPreferences(preferences);
		}
		ITextRegionAccess regionAccess = regionBuilder.forNodeModel(resource).create();
		request.setTextRegionAccess(regionAccess);
		IFormatter2 formatter2 = formatter2Provider.get();
		List<ITextReplacement> replacements = formatter2.format(request);
		return replacements;
	}
}
