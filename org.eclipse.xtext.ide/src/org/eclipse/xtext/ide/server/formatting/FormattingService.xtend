/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server.formatting

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.lsp4j.DocumentFormattingParams
import org.eclipse.lsp4j.DocumentRangeFormattingParams
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextEdit
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.preferences.ITypedPreferenceValues
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import com.google.common.base.Strings
import org.eclipse.lsp4j.FormattingOptions
import java.util.Map
import java.util.concurrent.ConcurrentHashMap

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
		if (OverrideChecker.hasFormatOverride(class)) {
			return format(resource, document, offset, length)
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
		if (OverrideChecker.hasFormatOverride(class)) {
			return format(resource, document, offset, length)
		}
		return format(resource, document, offset, length, params.options)
	}
	
	/**
	 * @deprecated use {@link #format(XtextResource, document, offset, length, FormattingOptions} instead.
	 */
	@Deprecated
	def List<TextEdit> format(XtextResource resource, Document document, int offset, int length) {
		format(resource, document, offset, length, null)
	}

	/**
	 * @since 2.14
	 */
	def List<TextEdit> format(XtextResource resource, Document document, int offset, int length, FormattingOptions options) {
		var indent = "\t"
		if (options !== null) {
			if (options.insertSpaces) {
				indent = Strings.padEnd("", options.tabSize," ")
			}
		}
		if (formatter2Provider !== null) {
			val replacements = format2(resource, new TextRegion(offset, length), new MapBasedPreferenceValues(#{"indentation"->indent}))
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
	
	private static class OverrideChecker {
		static val Map<Class<?>, Boolean> CLASSES_WITH_OVERRIDES = new ConcurrentHashMap<Class<?>, Boolean>()
		def static boolean hasFormatOverride(Class<? extends FormattingService> formattingServiceClass) {
			var Boolean result = CLASSES_WITH_OVERRIDES.get(formattingServiceClass)
			if (result === null) {
				try {
					result = Boolean.FALSE
					var Class<?> theClass = formattingServiceClass
					while (!result && theClass !== FormattingService) {
						try {
							theClass.getDeclaredMethod("format", XtextResource, Document, Integer.TYPE, Integer.TYPE)
							result = Boolean.TRUE
						} catch (NoSuchMethodException noSuchMethodException) {
						}
						theClass = theClass.getSuperclass()
					}
				} catch (Exception exception) {
					result = Boolean.TRUE
				}
				CLASSES_WITH_OVERRIDES.put(formattingServiceClass, result)
			}
			return result
		}
}

}
