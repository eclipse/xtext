/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AttributedPosition;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
    this.positions = Collections.<AttributedPosition>unmodifiableList(CollectionLiterals.<AttributedPosition>newArrayList(_attributedPosition, _attributedPosition_1));
  }
  
  @Test
  public void testIndexAtOffset() {
    Assert.assertEquals(0, this.computeIndexAtOffset(this.positions, (-1)));
    Assert.assertEquals(0, this.computeIndexAtOffset(this.positions, 0));
    Assert.assertEquals(1, this.computeIndexAtOffset(this.positions, 1));
    Assert.assertEquals(1, this.computeIndexAtOffset(this.positions, 2));
    Assert.assertEquals(2, this.computeIndexAtOffset(this.positions, 3));
    Assert.assertEquals(2, this.computeIndexAtOffset(this.positions, 4));
  }
  
  @Test
  public void testIndexAfterOffset() {
    Assert.assertEquals(0, this.computeIndexAfterOffset(this.positions, (-1)));
    Assert.assertEquals(1, this.computeIndexAfterOffset(this.positions, 0));
    Assert.assertEquals(1, this.computeIndexAfterOffset(this.positions, 1));
    Assert.assertEquals(2, this.computeIndexAfterOffset(this.positions, 2));
    Assert.assertEquals(2, this.computeIndexAfterOffset(this.positions, 3));
    Assert.assertEquals(2, this.computeIndexAfterOffset(this.positions, 4));
  }
  
  @Test
  public void testIndexEndingAtOrEnclosingOffset() {
    Assert.assertEquals(0, this.computeIndexEndingAtOrEnclosingOffset(this.positions, (-1)));
    Assert.assertEquals(0, this.computeIndexEndingAtOrEnclosingOffset(this.positions, 0));
    Assert.assertEquals(0, this.computeIndexEndingAtOrEnclosingOffset(this.positions, 1));
    Assert.assertEquals(1, this.computeIndexEndingAtOrEnclosingOffset(this.positions, 2));
    Assert.assertEquals(1, this.computeIndexEndingAtOrEnclosingOffset(this.positions, 3));
    Assert.assertEquals(2, this.computeIndexEndingAtOrEnclosingOffset(this.positions, 4));
  }
}
