/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AttributedPosition;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class HighlightingPresenterPositionIndexTest extends HighlightingPresenter {
  private List<AttributedPosition> positions;
  
  @Before
  public void setUp() {
    AttributedPosition _attributedPosition = new AttributedPosition(0, 2, null, null);
    AttributedPosition _attributedPosition_1 = new AttributedPosition(2, 2, null, null);
    this.positions = Collections.<AttributedPosition>unmodifiableList(Lists.<AttributedPosition>newArrayList(_attributedPosition, _attributedPosition_1));
  }
  
  @Test
  public void testIndexAtOffset() {
    int _minus = (-1);
    int _computeIndexAtOffset = this.computeIndexAtOffset(this.positions, _minus);
    Assert.assertEquals(0, _computeIndexAtOffset);
    int _computeIndexAtOffset_1 = this.computeIndexAtOffset(this.positions, 0);
    Assert.assertEquals(0, _computeIndexAtOffset_1);
    int _computeIndexAtOffset_2 = this.computeIndexAtOffset(this.positions, 1);
    Assert.assertEquals(1, _computeIndexAtOffset_2);
    int _computeIndexAtOffset_3 = this.computeIndexAtOffset(this.positions, 2);
    Assert.assertEquals(1, _computeIndexAtOffset_3);
    int _computeIndexAtOffset_4 = this.computeIndexAtOffset(this.positions, 3);
    Assert.assertEquals(2, _computeIndexAtOffset_4);
    int _computeIndexAtOffset_5 = this.computeIndexAtOffset(this.positions, 4);
    Assert.assertEquals(2, _computeIndexAtOffset_5);
  }
  
  @Test
  public void testIndexAfterOffset() {
    int _minus = (-1);
    int _computeIndexAfterOffset = this.computeIndexAfterOffset(this.positions, _minus);
    Assert.assertEquals(0, _computeIndexAfterOffset);
    int _computeIndexAfterOffset_1 = this.computeIndexAfterOffset(this.positions, 0);
    Assert.assertEquals(1, _computeIndexAfterOffset_1);
    int _computeIndexAfterOffset_2 = this.computeIndexAfterOffset(this.positions, 1);
    Assert.assertEquals(1, _computeIndexAfterOffset_2);
    int _computeIndexAfterOffset_3 = this.computeIndexAfterOffset(this.positions, 2);
    Assert.assertEquals(2, _computeIndexAfterOffset_3);
    int _computeIndexAfterOffset_4 = this.computeIndexAfterOffset(this.positions, 3);
    Assert.assertEquals(2, _computeIndexAfterOffset_4);
    int _computeIndexAfterOffset_5 = this.computeIndexAfterOffset(this.positions, 4);
    Assert.assertEquals(2, _computeIndexAfterOffset_5);
  }
  
  @Test
  public void testIndexEndingAtOrEnclosingOffset() {
    int _minus = (-1);
    int _computeIndexEndingAtOrEnclosingOffset = this.computeIndexEndingAtOrEnclosingOffset(this.positions, _minus);
    Assert.assertEquals(0, _computeIndexEndingAtOrEnclosingOffset);
    int _computeIndexEndingAtOrEnclosingOffset_1 = this.computeIndexEndingAtOrEnclosingOffset(this.positions, 0);
    Assert.assertEquals(0, _computeIndexEndingAtOrEnclosingOffset_1);
    int _computeIndexEndingAtOrEnclosingOffset_2 = this.computeIndexEndingAtOrEnclosingOffset(this.positions, 1);
    Assert.assertEquals(0, _computeIndexEndingAtOrEnclosingOffset_2);
    int _computeIndexEndingAtOrEnclosingOffset_3 = this.computeIndexEndingAtOrEnclosingOffset(this.positions, 2);
    Assert.assertEquals(1, _computeIndexEndingAtOrEnclosingOffset_3);
    int _computeIndexEndingAtOrEnclosingOffset_4 = this.computeIndexEndingAtOrEnclosingOffset(this.positions, 3);
    Assert.assertEquals(1, _computeIndexEndingAtOrEnclosingOffset_4);
    int _computeIndexEndingAtOrEnclosingOffset_5 = this.computeIndexEndingAtOrEnclosingOffset(this.positions, 4);
    Assert.assertEquals(2, _computeIndexEndingAtOrEnclosingOffset_5);
  }
}
