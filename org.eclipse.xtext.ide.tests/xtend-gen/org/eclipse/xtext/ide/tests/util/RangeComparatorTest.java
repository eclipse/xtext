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
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.RangeComparator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the null-safe {@link RangeComparator}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class RangeComparatorTest extends Assert {
  @Inject
  private RangeComparator comparator;
  
  @Test
  public void withoutNull() {
    final List<? extends Range> input = this.sort(CollectionLiterals.<Range>newArrayList(this.newRange(1, 2, 1, 2), this.newRange(1, 1, 2, 1), this.newRange(1, 1, 1, 2), this.newRange(1, 1, 1, 1), 
      this.newRange(2, 2, 2, 3)));
    Assert.assertEquals(1, input.get(0).getStart().getLine());
    Assert.assertEquals(1, input.get(0).getStart().getCharacter());
    Assert.assertEquals(1, input.get(0).getEnd().getLine());
    Assert.assertEquals(1, input.get(0).getEnd().getCharacter());
    Assert.assertEquals(1, input.get(1).getStart().getLine());
    Assert.assertEquals(1, input.get(1).getStart().getCharacter());
    Assert.assertEquals(1, input.get(1).getEnd().getLine());
    Assert.assertEquals(2, input.get(1).getEnd().getCharacter());
    Assert.assertEquals(1, input.get(2).getStart().getLine());
    Assert.assertEquals(1, input.get(2).getStart().getCharacter());
    Assert.assertEquals(2, input.get(2).getEnd().getLine());
    Assert.assertEquals(1, input.get(2).getEnd().getCharacter());
    Assert.assertEquals(1, input.get(3).getStart().getLine());
    Assert.assertEquals(2, input.get(3).getStart().getCharacter());
    Assert.assertEquals(1, input.get(3).getEnd().getLine());
    Assert.assertEquals(2, input.get(3).getEnd().getCharacter());
    Assert.assertEquals(2, input.get(4).getStart().getLine());
    Assert.assertEquals(2, input.get(4).getStart().getCharacter());
    Assert.assertEquals(2, input.get(4).getEnd().getLine());
    Assert.assertEquals(3, input.get(4).getEnd().getCharacter());
  }
  
  @Test
  public void withNull() {
    final List<? extends Range> input = this.sort(CollectionLiterals.<Range>newArrayList(this.newRange(2, 2, 2, 3), null, this.newRange(1, 1, 1, 1)));
    Assert.assertEquals(1, input.get(0).getStart().getLine());
    Assert.assertEquals(1, input.get(0).getStart().getCharacter());
    Assert.assertEquals(1, input.get(0).getEnd().getLine());
    Assert.assertEquals(1, input.get(0).getEnd().getCharacter());
    Assert.assertEquals(2, input.get(1).getStart().getLine());
    Assert.assertEquals(2, input.get(1).getStart().getCharacter());
    Assert.assertEquals(2, input.get(1).getEnd().getLine());
    Assert.assertEquals(3, input.get(1).getEnd().getCharacter());
    Assert.assertNull(IterableExtensions.last(input));
  }
  
  private Range newRange(final int startLine, final int startChar, final int endLine, final int endChar) {
    Position _position = new Position(startLine, startChar);
    Position _position_1 = new Position(endLine, endChar);
    return new Range(_position, _position_1);
  }
  
  private List<? extends Range> sort(final List<? extends Range> toSort) {
    toSort.sort(this.comparator);
    return toSort;
  }
}
