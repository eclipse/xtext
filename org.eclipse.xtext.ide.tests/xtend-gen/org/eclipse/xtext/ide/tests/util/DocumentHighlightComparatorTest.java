/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.util;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.DocumentHighlightComparator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the null-safe {@link DocumentHighlightComparator}.
 * 
 * <p>
 * This test focuses on the {@link DocumentHighlightKind} and the null-safety
 * other orderings are checked via the {@link RangeComparatorTest}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class DocumentHighlightComparatorTest extends Assert {
  @Inject
  private DocumentHighlightComparator comparator;
  
  @Test
  public void withoutNull() {
    final List<? extends DocumentHighlight> input = this.sort(CollectionLiterals.<DocumentHighlight>newArrayList(this.newHighlight(DocumentHighlightKind.Text, this.newRange(2, 2, 2, 2)), this.newHighlight(DocumentHighlightKind.Text, this.newRange(1, 1, 1, 1)), 
      this.newHighlight(DocumentHighlightKind.Write, this.newRange(2, 2, 2, 2)), this.newHighlight(DocumentHighlightKind.Write, this.newRange(1, 1, 1, 1)), 
      this.newHighlight(DocumentHighlightKind.Read, this.newRange(2, 2, 2, 2)), this.newHighlight(DocumentHighlightKind.Read, this.newRange(1, 1, 1, 1))));
    Assert.assertEquals(1, input.get(0).getRange().getStart().getLine());
    Assert.assertEquals(1, input.get(0).getRange().getStart().getCharacter());
    Assert.assertEquals(1, input.get(0).getRange().getEnd().getLine());
    Assert.assertEquals(1, input.get(0).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Text, input.get(0).getKind());
    Assert.assertEquals(1, input.get(1).getRange().getStart().getLine());
    Assert.assertEquals(1, input.get(1).getRange().getStart().getCharacter());
    Assert.assertEquals(1, input.get(1).getRange().getEnd().getLine());
    Assert.assertEquals(1, input.get(1).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Read, input.get(1).getKind());
    Assert.assertEquals(1, input.get(2).getRange().getStart().getLine());
    Assert.assertEquals(1, input.get(2).getRange().getStart().getCharacter());
    Assert.assertEquals(1, input.get(2).getRange().getEnd().getLine());
    Assert.assertEquals(1, input.get(2).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Write, input.get(2).getKind());
    Assert.assertEquals(2, input.get(3).getRange().getStart().getLine());
    Assert.assertEquals(2, input.get(3).getRange().getStart().getCharacter());
    Assert.assertEquals(2, input.get(3).getRange().getEnd().getLine());
    Assert.assertEquals(2, input.get(3).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Text, input.get(3).getKind());
    Assert.assertEquals(2, input.get(4).getRange().getStart().getLine());
    Assert.assertEquals(2, input.get(4).getRange().getStart().getCharacter());
    Assert.assertEquals(2, input.get(4).getRange().getEnd().getLine());
    Assert.assertEquals(2, input.get(4).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Read, input.get(4).getKind());
    Assert.assertEquals(2, input.get(5).getRange().getStart().getLine());
    Assert.assertEquals(2, input.get(5).getRange().getStart().getCharacter());
    Assert.assertEquals(2, input.get(5).getRange().getEnd().getLine());
    Assert.assertEquals(2, input.get(5).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Write, input.get(5).getKind());
  }
  
  @Test
  public void withNull() {
    final List<? extends DocumentHighlight> input = this.sort(CollectionLiterals.<DocumentHighlight>newArrayList(null, this.newHighlight(DocumentHighlightKind.Text, this.newRange(1, 1, 1, 1)), 
      this.newHighlight(DocumentHighlightKind.Write, this.newRange(1, 1, 1, 1)), this.newHighlight(DocumentHighlightKind.Read, this.newRange(1, 1, 1, 1))));
    Assert.assertEquals(1, input.get(0).getRange().getStart().getLine());
    Assert.assertEquals(1, input.get(0).getRange().getStart().getCharacter());
    Assert.assertEquals(1, input.get(0).getRange().getEnd().getLine());
    Assert.assertEquals(1, input.get(0).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Text, input.get(0).getKind());
    Assert.assertEquals(1, input.get(1).getRange().getStart().getLine());
    Assert.assertEquals(1, input.get(1).getRange().getStart().getCharacter());
    Assert.assertEquals(1, input.get(1).getRange().getEnd().getLine());
    Assert.assertEquals(1, input.get(1).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Read, input.get(1).getKind());
    Assert.assertEquals(1, input.get(2).getRange().getStart().getLine());
    Assert.assertEquals(1, input.get(2).getRange().getStart().getCharacter());
    Assert.assertEquals(1, input.get(2).getRange().getEnd().getLine());
    Assert.assertEquals(1, input.get(2).getRange().getEnd().getCharacter());
    Assert.assertEquals(DocumentHighlightKind.Write, input.get(2).getKind());
    Assert.assertNull(IterableExtensions.last(input));
  }
  
  private DocumentHighlight newHighlight(final DocumentHighlightKind kind, final Range range) {
    return new DocumentHighlight(range, kind);
  }
  
  private Range newRange(final int startLine, final int startChar, final int endLine, final int endChar) {
    Position _position = new Position(startLine, startChar);
    Position _position_1 = new Position(endLine, endChar);
    return new Range(_position, _position_1);
  }
  
  private List<? extends DocumentHighlight> sort(final List<? extends DocumentHighlight> toSort) {
    toSort.sort(this.comparator);
    return toSort;
  }
}
