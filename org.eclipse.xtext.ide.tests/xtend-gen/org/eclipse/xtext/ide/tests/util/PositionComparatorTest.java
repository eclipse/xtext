/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.util;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.PositionComparator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the null-safe {@link PositionComparator}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
@SuppressWarnings("all")
public class PositionComparatorTest extends Assert {
  @Inject
  private PositionComparator comparator;
  
  @Test
  public void withoutNull() {
    Position _position = new Position(2, 2);
    Position _position_1 = new Position(2, 1);
    Position _position_2 = new Position(1, 2);
    Position _position_3 = new Position(1, 1);
    final List<? extends Position> input = this.sort(CollectionLiterals.<Position>newArrayList(_position, _position_1, _position_2, _position_3));
    Assert.assertEquals(1, input.get(0).getLine());
    Assert.assertEquals(1, input.get(0).getCharacter());
    Assert.assertEquals(1, input.get(1).getLine());
    Assert.assertEquals(2, input.get(1).getCharacter());
    Assert.assertEquals(2, input.get(2).getLine());
    Assert.assertEquals(1, input.get(2).getCharacter());
    Assert.assertEquals(2, input.get(3).getLine());
    Assert.assertEquals(2, input.get(3).getCharacter());
  }
  
  @Test
  public void withNull() {
    Position _position = new Position(2, 2);
    Position _position_1 = new Position(1, 1);
    final List<? extends Position> input = this.sort(CollectionLiterals.<Position>newArrayList(_position, null, _position_1));
    Assert.assertEquals(1, input.get(0).getLine());
    Assert.assertEquals(1, input.get(0).getCharacter());
    Assert.assertEquals(2, input.get(1).getLine());
    Assert.assertEquals(2, input.get(1).getCharacter());
    Assert.assertNull(IterableExtensions.last(input));
  }
  
  private List<? extends Position> sort(final List<? extends Position> toSort) {
    toSort.sort(this.comparator);
    return toSort;
  }
}
