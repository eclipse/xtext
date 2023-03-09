/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegmentDiff;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionAccessTestHelper {
	@Inject
	private ParseHelper<Root> parseHelper;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;

	@Inject
	private ValidationTestHelper validationTestHelper;

	public ITextRegionAccess toTextRegionAccess(CharSequence file) throws Exception {
		Root obj = parseHelper.parse(file.toString().replace("\r\n", "\n").trim());
		validationTestHelper.assertNoErrors(obj);
		return textRegionAccessBuilder.get().forNodeModel((XtextResource) obj.eResource()).create();
	}

	public ITextRegionAccess modify(ITextRegionAccess base, Procedure1<? super ITextRegionDiffBuilder> modify) {
		StringBasedTextRegionAccessDiffBuilder fac = new StringBasedTextRegionAccessDiffBuilder(base);
		modify.apply(fac);
		StringBasedTextRegionAccessDiff modified = fac.create();
		return modified;
	}

	public void assertRegions(ITextRegionAccess access, CharSequence expectation) {
		if (access instanceof ITextRegionAccessDiff) {
			assertDiffs((ITextRegionAccessDiff) access);
		}
		String tra1 = cfg(new TextRegionAccessToString().withRegionAccess(access)) + "\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), Strings.toPlatformLineSeparator(tra1));
	}

	public void assertDiffs(ITextRegionAccessDiff regions) {
		ITextRegionRewriter rewriter = regions.getOriginalTextRegionAccess().getRewriter();
		List<ITextReplacement> result = new ArrayList<>();
		for (ITextSegmentDiff r : regions.getRegionDifferences()) {
			ITextSegment originalRegion = r.getOriginalRegion();
			ITextSegment modifiedRegion = r.getModifiedRegion();
			ITextReplacement replacement = originalRegion.replaceWith(modifiedRegion.getText());
			result.add(replacement);
		}
		String actual = rewriter.renderToString(result);
		String expected = regions.regionForDocument().getText();
		Assert.assertEquals(expected, actual);
	}

	private TextRegionAccessToString cfg(TextRegionAccessToString toStr) {
		return toStr.hideColumnExplanation().withTextWidth(10);
	}
}
