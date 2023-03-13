/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.formatting2

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.formatting2.FormatterPreferences
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.preferences.IPreferenceValuesProvider
import org.eclipse.xtext.preferences.TypedPreferenceValues
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class FormatterFacade {

	@Inject IResourceFactory resourceFactory
	@Inject @FormatterPreferences IPreferenceValuesProvider cfgProvider;
	@Inject IFormatter2 formatter;
	@Inject Provider<TextRegionAccessBuilder> regionAccessBuilder;

	def String format(String xtendCode) {
		val resourceSet = new XtextResourceSet
		val resource = resourceFactory.createResource(URI.createURI("synthetic://to-be-formatted.xtend")) as XtextResource
		resourceSet.resources += resource
		resource.load(new StringInputStream(xtendCode), emptyMap)
		val regionAccess = regionAccessBuilder.get().forNodeModel(resource).create()
		var request = new FormatterRequest => [
			allowIdentityEdits = false
			textRegionAccess = regionAccess
			preferences = TypedPreferenceValues.castOrWrap(cfgProvider.getPreferenceValues(resource))
		]
		var replacements = formatter.format(request)
		return regionAccess.getRewriter().renderToString(replacements)
	}

}