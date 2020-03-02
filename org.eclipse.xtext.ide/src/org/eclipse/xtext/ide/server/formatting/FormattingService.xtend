/*******************************************************************************
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.formatting

import com.google.common.base.Strings
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.DocumentRangeFormattingParams
import org.eclipse.lsp4j.FormattingOptions
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.xtext.formatting.IIndentationInformation
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.preferences.ITypedPreferenceValues
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion

/**
 * Language Service Implementation for Formatting and Range-Formatting
 * 
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.11
 */
class FormattingService {

	@Inject(optional=true) Provider<IFormatter2> formatter2Provider

	@Inject Provider<FormatterRequest> formatterRequestProvider

	@Inject TextRegionAccessBuilder regionBuilder
	
	@Inject IIndentationInformation indentationInformation

	def List<? extends TextEdit> format(
		Document document,
		XtextResource resource,
		DocumentFormattingParams params,
		CancelIndicator cancelIndicator
	) {
		val offset = 0
		val length = document.contents.length
		if (length === 0 || resource.contents.isEmpty) {
			return emptyList
		}
		return format(resource, document, offset, length, params.options)
	}

	def List<? extends TextEdit> format(
		Document document,
		XtextResource resource,
		DocumentRangeFormattingParams params,
		CancelIndicator cancelIndicator
	) {
		val offset = document.getOffSet(params.range.start)
		val length = document.getOffSet(params.range.end) - offset
		return format(resource, document, offset, length, params.options)
	}

	/**
	 * @since 2.14
	 */
	def List<TextEdit> format(XtextResource resource, Document document, int offset, int length, FormattingOptions options) {
		var indent = indentationInformation.indentString
		if (options !== null) {
			if (options.insertSpaces) {
				indent = Strings.padEnd("", options.tabSize," ")
			}
		}
		if (formatter2Provider !== null) {
			val preferences = new MapBasedPreferenceValues()
			preferences.put("indentation", indent)
			val replacements = format2(resource, new TextRegion(offset, length), preferences)
			return replacements.map [ r |
				document.toTextEdit(r.replacementText, r.offset, r.length)
			].<TextEdit>toList
		} else {
			return <TextEdit>newArrayList
		}

	}
	
	protected def TextEdit toTextEdit(Document document, String formattedText, int startOffset, int length) {
		new TextEdit => [
			newText = formattedText
			range = new Range => [
				start = document.getPosition(startOffset)
				end = document.getPosition(startOffset + length)
			]
		]
	}

	protected def format2(XtextResource resource, ITextRegion selection, ITypedPreferenceValues preferences) {
		val request = formatterRequestProvider.get()
		request.allowIdentityEdits = false
		request.formatUndefinedHiddenRegionsOnly = false
		if (selection !== null)
			request.regions = #[selection]
		if (preferences !== null) {
			request.preferences = preferences
		}
		val regionAccess = regionBuilder.forNodeModel(resource).create()
		request.textRegionAccess = regionAccess
		val formatter2 = formatter2Provider.get();
		val replacements = formatter2.format(request)
		return replacements
	}

}
