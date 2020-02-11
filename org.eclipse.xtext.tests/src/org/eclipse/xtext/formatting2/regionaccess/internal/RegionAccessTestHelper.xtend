/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert

import static extension org.eclipse.xtext.util.Strings.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class RegionAccessTestHelper {

	@Inject ParseHelper<Root> parseHelper
	@Inject Provider<TextRegionAccessBuilder> textRegionAccessBuilder
	@Inject ValidationTestHelper validationTestHelper

	def ITextRegionAccess toTextRegionAccess(CharSequence file) {
		val obj = parseHelper.parse(file.toString.replace("\r\n", "\n").trim)
		validationTestHelper.assertNoErrors(obj)
		return textRegionAccessBuilder.get.forNodeModel(obj.eResource as XtextResource).create
	}

	def ITextRegionAccess modify(ITextRegionAccess base, (ITextRegionDiffBuilder)=>void modify) {
		val fac = new StringBasedTextRegionAccessDiffBuilder(base)
		modify.apply(fac)
		val modified = fac.create()
		return modified
	}

	def ===(ITextRegionAccess access, CharSequence expectation) {
		if (access instanceof ITextRegionAccessDiff) {
			assertDiffs(access)
		}
		val tra1 = new TextRegionAccessToString().withRegionAccess(access).cfg() + "\n"
		Assert.assertEquals(expectation.toPlatformLineSeparator, tra1.toPlatformLineSeparator)
	}

	def void assertDiffs(ITextRegionAccessDiff regions) {
		val rewriter = regions.getOriginalTextRegionAccess().getRewriter()
		val result = Lists.newArrayList()
		for (r : regions.getRegionDifferences()) {
			val originalRegion = r.originalRegion
			val modifiedRegion = r.modifiedRegion
			val replacement = originalRegion.replaceWith(modifiedRegion.text)
			result.add(replacement)
		}
		val actual = rewriter.renderToString(result)
		val expected = regions.regionForDocument.text
		Assert.assertEquals(expected, actual)
	}

	private def TextRegionAccessToString cfg(TextRegionAccessToString toStr) {
		toStr.hideColumnExplanation().withTextWidth(10)
	}
}
