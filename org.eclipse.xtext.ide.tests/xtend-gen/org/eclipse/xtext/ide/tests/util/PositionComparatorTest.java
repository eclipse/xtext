/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.util;

import java.util.ArrayList;
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
    ArrayList<Position> _newArrayList = CollectionLiterals.<Position>newArrayList(_position, _position_1, _position_2, _position_3);
    final List<? extends Position> input = this.sort(_newArrayList);
    Position _get = input.get(0);
    int _line = _get.getLine();
    Assert.assertEquals(1, _line);
    Position _get_1 = input.get(0);
    int _character = _get_1.getCharacter();
    Assert.assertEquals(1, _character);
    Position _get_2 = input.get(1);
    int _line_1 = _get_2.getLine();
    Assert.assertEquals(1, _line_1);
    Position _get_3 = input.get(1);
    int _character_1 = _get_3.getCharacter();
    Assert.assertEquals(2, _character_1);
    Position _get_4 = input.get(2);
    int _line_2 = _get_4.getLine();
    Assert.assertEquals(2, _line_2);
    Position _get_5 = input.get(2);
    int _character_2 = _get_5.getCharacter();
    Assert.assertEquals(1, _character_2);
    Position _get_6 = input.get(3);
    int _line_3 = _get_6.getLine();
    Assert.assertEquals(2, _line_3);
    Position _get_7 = input.get(3);
    int _character_3 = _get_7.getCharacter();
    Assert.assertEquals(2, _character_3);
  }
  
  @Test
  public void withNull() {
    Position _position = new Position(2, 2);
    Position _position_1 = new Position(1, 1);
    ArrayList<Position> _newArrayList = CollectionLiterals.<Position>newArrayList(_position, null, _position_1);
    final List<? extends Position> input = this.sort(_newArrayList);
    Position _get = input.get(0);
    int _line = _get.getLine();
    Assert.assertEquals(1, _line);
    Position _get_1 = input.get(0);
    int _character = _get_1.getCharacter();
    Assert.assertEquals(1, _character);
    Position _get_2 = input.get(1);
    int _line_1 = _get_2.getLine();
    Assert.assertEquals(2, _line_1);
    Position _get_3 = input.get(1);
    int _character_1 = _get_3.getCharacter();
    Assert.assertEquals(2, _character_1);
    Position _last = IterableExtensions.last(input);
    Assert.assertNull(_last);
  }
  
  private List<? extends Position> sort(final List<? extends Position> toSort) {
    toSort.sort(this.comparator);
    return toSort;
  }
}
