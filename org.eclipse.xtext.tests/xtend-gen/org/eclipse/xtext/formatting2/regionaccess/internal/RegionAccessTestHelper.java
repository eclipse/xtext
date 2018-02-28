/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegmentDiff;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedTextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.internal.StringBasedTextRegionAccessDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class RegionAccessTestHelper {
  @Inject
  private ParseHelper<Root> parseHelper;
  
  @Inject
  private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;
  
  @Inject
  private ValidationTestHelper validationTestHelper;
  
  public ITextRegionAccess toTextRegionAccess(final CharSequence file) {
    try {
      final Root obj = this.parseHelper.parse(file.toString().replace("\r\n", "\n").trim());
      this.validationTestHelper.assertNoErrors(obj);
      Resource _eResource = obj.eResource();
      return this.textRegionAccessBuilder.get().forNodeModel(((XtextResource) _eResource)).create();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ITextRegionAccess modify(final ITextRegionAccess base, final Procedure1<? super ITextRegionDiffBuilder> modify) {
    final StringBasedTextRegionAccessDiffBuilder fac = new StringBasedTextRegionAccessDiffBuilder(base);
    modify.apply(fac);
    final StringBasedTextRegionAccessDiff modified = fac.create();
    return modified;
  }
  
  public void operator_tripleEquals(final ITextRegionAccess access, final CharSequence expectation) {
    if ((access instanceof ITextRegionAccessDiff)) {
      this.assertDiffs(((ITextRegionAccessDiff)access));
    }
    TextRegionAccessToString _cfg = this.cfg(new TextRegionAccessToString().withRegionAccess(access));
    final String tra1 = (_cfg + "\n");
    Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), Strings.toPlatformLineSeparator(tra1));
  }
  
  public void assertDiffs(final ITextRegionAccessDiff regions) {
    final ITextRegionRewriter rewriter = regions.getOriginalTextRegionAccess().getRewriter();
    final ArrayList<ITextReplacement> result = Lists.<ITextReplacement>newArrayList();
    List<ITextSegmentDiff> _regionDifferences = regions.getRegionDifferences();
    for (final ITextSegmentDiff r : _regionDifferences) {
      {
        final ITextSegment originalRegion = r.getOriginalRegion();
        final ITextSegment modifiedRegion = r.getModifiedRegion();
        final ITextReplacement replacement = originalRegion.replaceWith(modifiedRegion.getText());
        result.add(replacement);
      }
    }
    final String actual = rewriter.renderToString(result);
    final String expected = regions.regionForDocument().getText();
    Assert.assertEquals(expected, actual);
  }
  
  private TextRegionAccessToString cfg(final TextRegionAccessToString toStr) {
    return toStr.hideColumnExplanation().withTextWidth(10);
  }
}
