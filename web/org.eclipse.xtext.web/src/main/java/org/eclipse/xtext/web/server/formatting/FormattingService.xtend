/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.formatting

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import org.eclipse.xtext.formatting.INodeModelFormatter
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment
import org.eclipse.xtext.preferences.ITypedPreferenceValues
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.util.Wrapper
import org.eclipse.xtext.web.server.InvalidRequestException
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess

/**
 * Service class for text formatting.
 */
@Singleton
class FormattingService {
	
	@Inject(optional = true) INodeModelFormatter formatter1
	
	@Inject(optional = true) Provider<IFormatter2> formatter2Provider
	
	@Inject Provider<FormatterRequest> formatterRequestProvider
	
	@Inject TextRegionAccessBuilder regionBuilder
	
	/**
	 * Format the given document. This operation modifies the document content and returns the 
	 */
	def FormattingResult format(XtextWebDocumentAccess document, ITextRegion selection, ITypedPreferenceValues preferences) throws InvalidRequestException {
		val textWrapper = new Wrapper<String>
		val regionWrapper = new Wrapper<TextRegion>
		
		document.modify([ it, cancelIndicator |
			if (formatter2Provider !== null) {
				textWrapper.set = format2(resource, selection, preferences)
				if (selection !== null)
					regionWrapper.set = new TextRegion(selection.offset, selection.length)
			} else if (formatter1 !== null) {
				val formattedRegion = format1(resource, selection)
				textWrapper.set = formattedRegion.formattedText
				regionWrapper.set = new TextRegion(formattedRegion.offset, formattedRegion.length)
			} else
				throw new IllegalStateException('No formatter is available in the language configuration.')
			
			dirty = true
			createNewStateId()
			return new FormattingResult(stateId, textWrapper.get, regionWrapper.get)
		], [ it, cancelIndicator |
			if (regionWrapper.empty)
				setText(textWrapper.get)
			else
				updateText(textWrapper.get, regionWrapper.get.offset, regionWrapper.get.length)
			return null
		])
	}
	
	protected def format1(XtextResource resource, ITextRegion selection) {
		val parseResult = resource.parseResult
		if (parseResult === null)
			return null
		val rootNode = parseResult.rootNode
		var region = selection
		if (region === null) {
			region = new TextRegion(rootNode.offset, rootNode.length)
		}
		return formatter1.format(rootNode, region.offset, region.length)
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
		if (selection !== null)
			return regionAccess.rewriter.renderToString(
					new TextSegment(regionAccess, selection.offset, selection.length), replacements)
		else
			return regionAccess.rewriter.renderToString(replacements)
	}
	
}