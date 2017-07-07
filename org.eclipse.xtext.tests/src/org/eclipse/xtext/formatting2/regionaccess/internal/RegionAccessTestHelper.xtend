/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject

import static extension org.eclipse.xtext.util.Strings.*
import com.google.inject.Provider
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert

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
		val tra1 = new TextRegionAccessToString().withRegionAccess(access).cfg() + "\n"
		Assert.assertEquals(expectation.toPlatformLineSeparator, tra1.toPlatformLineSeparator)
	}

	private def TextRegionAccessToString cfg(TextRegionAccessToString toStr) {
		toStr.hideColumnExplanation().withTextWidth(10)
	}
}
