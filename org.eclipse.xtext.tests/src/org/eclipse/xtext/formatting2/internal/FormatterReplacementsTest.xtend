/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.formatting2.FormatterRequest
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(FormatterTestLanguageInjectorProvider)
class FormatterReplacementsTest {

	@Inject Provider<FormatterRequest> requestProvider
	@Inject TextRegionAccessBuilder regionBuilder
	@Inject ParseHelper<IDList> parseHelper
	@Inject extension FormatterTestLanguageGrammarAccess

	@Test def testIdentityEditsAreFiltered() {
		val GenericFormatter<IDList> formatter = [ IDList model, extension regions, extension document |
			model.regionFor.ruleCallsTo(IDRule).forEach[prepend[autowrap; oneSpace]]
		]
		val parsed = parseHelper.parse("idlist  aaa bbb")
		val request = requestProvider.get()
		request.allowIdentityEdits = false
		request.textRegionAccess = regionBuilder.forNodeModel(parsed.eResource as XtextResource).create

		val replacements = formatter.format(request)
		val actual = replacements.map['''"«text»" -> "«replacementText»"«"\n"»'''].join
		val expected = '''
			"  " -> " "
		'''
		Assert.assertEquals(expected, actual)
	}
}
