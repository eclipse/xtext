/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.util;

import io.typefox.lsapi.Position;
import io.typefox.lsapi.impl.PositionImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
    PositionImpl _newPosition = this.newPosition(2, 2);
    PositionImpl _newPosition_1 = this.newPosition(2, 1);
    PositionImpl _newPosition_2 = this.newPosition(1, 2);
    PositionImpl _newPosition_3 = this.newPosition(1, 1);
    ArrayList<PositionImpl> _newArrayList = CollectionLiterals.<PositionImpl>newArrayList(_newPosition, _newPosition_1, _newPosition_2, _newPosition_3);
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
    PositionImpl _newPosition = this.newPosition(2, 2);
    PositionImpl _newPosition_1 = this.newPosition(1, 1);
    ArrayList<PositionImpl> _newArrayList = CollectionLiterals.<PositionImpl>newArrayList(_newPosition, null, _newPosition_1);
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
  
  private PositionImpl newPosition(final int line, final int character) {
    return new PositionImpl(line, character);
  }
  
  private List<? extends Position> sort(final List<? extends Position> toSort) {
    toSort.sort(this.comparator);
    return toSort;
  }
}
