/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.util;

import com.google.inject.Inject;
import java.util.ArrayList;
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
    Range _newRange = this.newRange(1, 2, 1, 2);
    Range _newRange_1 = this.newRange(1, 1, 2, 1);
    Range _newRange_2 = this.newRange(1, 1, 1, 2);
    Range _newRange_3 = this.newRange(1, 1, 1, 1);
    Range _newRange_4 = this.newRange(2, 2, 2, 3);
    ArrayList<Range> _newArrayList = CollectionLiterals.<Range>newArrayList(_newRange, _newRange_1, _newRange_2, _newRange_3, _newRange_4);
    final List<? extends Range> input = this.sort(_newArrayList);
    Range _get = input.get(0);
    Position _start = _get.getStart();
    int _line = _start.getLine();
    Assert.assertEquals(1, _line);
    Range _get_1 = input.get(0);
    Position _start_1 = _get_1.getStart();
    int _character = _start_1.getCharacter();
    Assert.assertEquals(1, _character);
    Range _get_2 = input.get(0);
    Position _end = _get_2.getEnd();
    int _line_1 = _end.getLine();
    Assert.assertEquals(1, _line_1);
    Range _get_3 = input.get(0);
    Position _end_1 = _get_3.getEnd();
    int _character_1 = _end_1.getCharacter();
    Assert.assertEquals(1, _character_1);
    Range _get_4 = input.get(1);
    Position _start_2 = _get_4.getStart();
    int _line_2 = _start_2.getLine();
    Assert.assertEquals(1, _line_2);
    Range _get_5 = input.get(1);
    Position _start_3 = _get_5.getStart();
    int _character_2 = _start_3.getCharacter();
    Assert.assertEquals(1, _character_2);
    Range _get_6 = input.get(1);
    Position _end_2 = _get_6.getEnd();
    int _line_3 = _end_2.getLine();
    Assert.assertEquals(1, _line_3);
    Range _get_7 = input.get(1);
    Position _end_3 = _get_7.getEnd();
    int _character_3 = _end_3.getCharacter();
    Assert.assertEquals(2, _character_3);
    Range _get_8 = input.get(2);
    Position _start_4 = _get_8.getStart();
    int _line_4 = _start_4.getLine();
    Assert.assertEquals(1, _line_4);
    Range _get_9 = input.get(2);
    Position _start_5 = _get_9.getStart();
    int _character_4 = _start_5.getCharacter();
    Assert.assertEquals(1, _character_4);
    Range _get_10 = input.get(2);
    Position _end_4 = _get_10.getEnd();
    int _line_5 = _end_4.getLine();
    Assert.assertEquals(2, _line_5);
    Range _get_11 = input.get(2);
    Position _end_5 = _get_11.getEnd();
    int _character_5 = _end_5.getCharacter();
    Assert.assertEquals(1, _character_5);
    Range _get_12 = input.get(3);
    Position _start_6 = _get_12.getStart();
    int _line_6 = _start_6.getLine();
    Assert.assertEquals(1, _line_6);
    Range _get_13 = input.get(3);
    Position _start_7 = _get_13.getStart();
    int _character_6 = _start_7.getCharacter();
    Assert.assertEquals(2, _character_6);
    Range _get_14 = input.get(3);
    Position _end_6 = _get_14.getEnd();
    int _line_7 = _end_6.getLine();
    Assert.assertEquals(1, _line_7);
    Range _get_15 = input.get(3);
    Position _end_7 = _get_15.getEnd();
    int _character_7 = _end_7.getCharacter();
    Assert.assertEquals(2, _character_7);
    Range _get_16 = input.get(4);
    Position _start_8 = _get_16.getStart();
    int _line_8 = _start_8.getLine();
    Assert.assertEquals(2, _line_8);
    Range _get_17 = input.get(4);
    Position _start_9 = _get_17.getStart();
    int _character_8 = _start_9.getCharacter();
    Assert.assertEquals(2, _character_8);
    Range _get_18 = input.get(4);
    Position _end_8 = _get_18.getEnd();
    int _line_9 = _end_8.getLine();
    Assert.assertEquals(2, _line_9);
    Range _get_19 = input.get(4);
    Position _end_9 = _get_19.getEnd();
    int _character_9 = _end_9.getCharacter();
    Assert.assertEquals(3, _character_9);
  }
  
  @Test
  public void withNull() {
    Range _newRange = this.newRange(2, 2, 2, 3);
    Range _newRange_1 = this.newRange(1, 1, 1, 1);
    ArrayList<Range> _newArrayList = CollectionLiterals.<Range>newArrayList(_newRange, null, _newRange_1);
    final List<? extends Range> input = this.sort(_newArrayList);
    Range _get = input.get(0);
    Position _start = _get.getStart();
    int _line = _start.getLine();
    Assert.assertEquals(1, _line);
    Range _get_1 = input.get(0);
    Position _start_1 = _get_1.getStart();
    int _character = _start_1.getCharacter();
    Assert.assertEquals(1, _character);
    Range _get_2 = input.get(0);
    Position _end = _get_2.getEnd();
    int _line_1 = _end.getLine();
    Assert.assertEquals(1, _line_1);
    Range _get_3 = input.get(0);
    Position _end_1 = _get_3.getEnd();
    int _character_1 = _end_1.getCharacter();
    Assert.assertEquals(1, _character_1);
    Range _get_4 = input.get(1);
    Position _start_2 = _get_4.getStart();
    int _line_2 = _start_2.getLine();
    Assert.assertEquals(2, _line_2);
    Range _get_5 = input.get(1);
    Position _start_3 = _get_5.getStart();
    int _character_2 = _start_3.getCharacter();
    Assert.assertEquals(2, _character_2);
    Range _get_6 = input.get(1);
    Position _end_2 = _get_6.getEnd();
    int _line_3 = _end_2.getLine();
    Assert.assertEquals(2, _line_3);
    Range _get_7 = input.get(1);
    Position _end_3 = _get_7.getEnd();
    int _character_3 = _end_3.getCharacter();
    Assert.assertEquals(3, _character_3);
    Range _last = IterableExtensions.last(input);
    Assert.assertNull(_last);
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
