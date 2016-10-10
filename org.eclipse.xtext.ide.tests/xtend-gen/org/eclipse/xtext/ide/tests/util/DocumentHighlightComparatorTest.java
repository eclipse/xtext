/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.util;

import com.google.inject.Inject;
import io.typefox.lsapi.DocumentHighlight;
import io.typefox.lsapi.DocumentHighlightKind;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.impl.DocumentHighlightImpl;
import io.typefox.lsapi.impl.PositionImpl;
import io.typefox.lsapi.impl.RangeImpl;
import java.util.ArrayList;
import java.util.List;
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
    RangeImpl _newRange = this.newRange(2, 2, 2, 2);
    DocumentHighlightImpl _newHighlight = this.newHighlight(DocumentHighlightKind.Text, _newRange);
    RangeImpl _newRange_1 = this.newRange(1, 1, 1, 1);
    DocumentHighlightImpl _newHighlight_1 = this.newHighlight(DocumentHighlightKind.Text, _newRange_1);
    RangeImpl _newRange_2 = this.newRange(2, 2, 2, 2);
    DocumentHighlightImpl _newHighlight_2 = this.newHighlight(DocumentHighlightKind.Write, _newRange_2);
    RangeImpl _newRange_3 = this.newRange(1, 1, 1, 1);
    DocumentHighlightImpl _newHighlight_3 = this.newHighlight(DocumentHighlightKind.Write, _newRange_3);
    RangeImpl _newRange_4 = this.newRange(2, 2, 2, 2);
    DocumentHighlightImpl _newHighlight_4 = this.newHighlight(DocumentHighlightKind.Read, _newRange_4);
    RangeImpl _newRange_5 = this.newRange(1, 1, 1, 1);
    DocumentHighlightImpl _newHighlight_5 = this.newHighlight(DocumentHighlightKind.Read, _newRange_5);
    ArrayList<DocumentHighlightImpl> _newArrayList = CollectionLiterals.<DocumentHighlightImpl>newArrayList(_newHighlight, _newHighlight_1, _newHighlight_2, _newHighlight_3, _newHighlight_4, _newHighlight_5);
    final List<? extends DocumentHighlight> input = this.sort(_newArrayList);
    DocumentHighlight _get = input.get(0);
    Range _range = _get.getRange();
    Position _start = _range.getStart();
    int _line = _start.getLine();
    Assert.assertEquals(1, _line);
    DocumentHighlight _get_1 = input.get(0);
    Range _range_1 = _get_1.getRange();
    Position _start_1 = _range_1.getStart();
    int _character = _start_1.getCharacter();
    Assert.assertEquals(1, _character);
    DocumentHighlight _get_2 = input.get(0);
    Range _range_2 = _get_2.getRange();
    Position _end = _range_2.getEnd();
    int _line_1 = _end.getLine();
    Assert.assertEquals(1, _line_1);
    DocumentHighlight _get_3 = input.get(0);
    Range _range_3 = _get_3.getRange();
    Position _end_1 = _range_3.getEnd();
    int _character_1 = _end_1.getCharacter();
    Assert.assertEquals(1, _character_1);
    DocumentHighlight _get_4 = input.get(0);
    DocumentHighlightKind _kind = _get_4.getKind();
    Assert.assertEquals(DocumentHighlightKind.Text, _kind);
    DocumentHighlight _get_5 = input.get(1);
    Range _range_4 = _get_5.getRange();
    Position _start_2 = _range_4.getStart();
    int _line_2 = _start_2.getLine();
    Assert.assertEquals(1, _line_2);
    DocumentHighlight _get_6 = input.get(1);
    Range _range_5 = _get_6.getRange();
    Position _start_3 = _range_5.getStart();
    int _character_2 = _start_3.getCharacter();
    Assert.assertEquals(1, _character_2);
    DocumentHighlight _get_7 = input.get(1);
    Range _range_6 = _get_7.getRange();
    Position _end_2 = _range_6.getEnd();
    int _line_3 = _end_2.getLine();
    Assert.assertEquals(1, _line_3);
    DocumentHighlight _get_8 = input.get(1);
    Range _range_7 = _get_8.getRange();
    Position _end_3 = _range_7.getEnd();
    int _character_3 = _end_3.getCharacter();
    Assert.assertEquals(1, _character_3);
    DocumentHighlight _get_9 = input.get(1);
    DocumentHighlightKind _kind_1 = _get_9.getKind();
    Assert.assertEquals(DocumentHighlightKind.Read, _kind_1);
    DocumentHighlight _get_10 = input.get(2);
    Range _range_8 = _get_10.getRange();
    Position _start_4 = _range_8.getStart();
    int _line_4 = _start_4.getLine();
    Assert.assertEquals(1, _line_4);
    DocumentHighlight _get_11 = input.get(2);
    Range _range_9 = _get_11.getRange();
    Position _start_5 = _range_9.getStart();
    int _character_4 = _start_5.getCharacter();
    Assert.assertEquals(1, _character_4);
    DocumentHighlight _get_12 = input.get(2);
    Range _range_10 = _get_12.getRange();
    Position _end_4 = _range_10.getEnd();
    int _line_5 = _end_4.getLine();
    Assert.assertEquals(1, _line_5);
    DocumentHighlight _get_13 = input.get(2);
    Range _range_11 = _get_13.getRange();
    Position _end_5 = _range_11.getEnd();
    int _character_5 = _end_5.getCharacter();
    Assert.assertEquals(1, _character_5);
    DocumentHighlight _get_14 = input.get(2);
    DocumentHighlightKind _kind_2 = _get_14.getKind();
    Assert.assertEquals(DocumentHighlightKind.Write, _kind_2);
    DocumentHighlight _get_15 = input.get(3);
    Range _range_12 = _get_15.getRange();
    Position _start_6 = _range_12.getStart();
    int _line_6 = _start_6.getLine();
    Assert.assertEquals(2, _line_6);
    DocumentHighlight _get_16 = input.get(3);
    Range _range_13 = _get_16.getRange();
    Position _start_7 = _range_13.getStart();
    int _character_6 = _start_7.getCharacter();
    Assert.assertEquals(2, _character_6);
    DocumentHighlight _get_17 = input.get(3);
    Range _range_14 = _get_17.getRange();
    Position _end_6 = _range_14.getEnd();
    int _line_7 = _end_6.getLine();
    Assert.assertEquals(2, _line_7);
    DocumentHighlight _get_18 = input.get(3);
    Range _range_15 = _get_18.getRange();
    Position _end_7 = _range_15.getEnd();
    int _character_7 = _end_7.getCharacter();
    Assert.assertEquals(2, _character_7);
    DocumentHighlight _get_19 = input.get(3);
    DocumentHighlightKind _kind_3 = _get_19.getKind();
    Assert.assertEquals(DocumentHighlightKind.Text, _kind_3);
    DocumentHighlight _get_20 = input.get(4);
    Range _range_16 = _get_20.getRange();
    Position _start_8 = _range_16.getStart();
    int _line_8 = _start_8.getLine();
    Assert.assertEquals(2, _line_8);
    DocumentHighlight _get_21 = input.get(4);
    Range _range_17 = _get_21.getRange();
    Position _start_9 = _range_17.getStart();
    int _character_8 = _start_9.getCharacter();
    Assert.assertEquals(2, _character_8);
    DocumentHighlight _get_22 = input.get(4);
    Range _range_18 = _get_22.getRange();
    Position _end_8 = _range_18.getEnd();
    int _line_9 = _end_8.getLine();
    Assert.assertEquals(2, _line_9);
    DocumentHighlight _get_23 = input.get(4);
    Range _range_19 = _get_23.getRange();
    Position _end_9 = _range_19.getEnd();
    int _character_9 = _end_9.getCharacter();
    Assert.assertEquals(2, _character_9);
    DocumentHighlight _get_24 = input.get(4);
    DocumentHighlightKind _kind_4 = _get_24.getKind();
    Assert.assertEquals(DocumentHighlightKind.Read, _kind_4);
    DocumentHighlight _get_25 = input.get(5);
    Range _range_20 = _get_25.getRange();
    Position _start_10 = _range_20.getStart();
    int _line_10 = _start_10.getLine();
    Assert.assertEquals(2, _line_10);
    DocumentHighlight _get_26 = input.get(5);
    Range _range_21 = _get_26.getRange();
    Position _start_11 = _range_21.getStart();
    int _character_10 = _start_11.getCharacter();
    Assert.assertEquals(2, _character_10);
    DocumentHighlight _get_27 = input.get(5);
    Range _range_22 = _get_27.getRange();
    Position _end_10 = _range_22.getEnd();
    int _line_11 = _end_10.getLine();
    Assert.assertEquals(2, _line_11);
    DocumentHighlight _get_28 = input.get(5);
    Range _range_23 = _get_28.getRange();
    Position _end_11 = _range_23.getEnd();
    int _character_11 = _end_11.getCharacter();
    Assert.assertEquals(2, _character_11);
    DocumentHighlight _get_29 = input.get(5);
    DocumentHighlightKind _kind_5 = _get_29.getKind();
    Assert.assertEquals(DocumentHighlightKind.Write, _kind_5);
  }
  
  @Test
  public void withNull() {
    RangeImpl _newRange = this.newRange(1, 1, 1, 1);
    DocumentHighlightImpl _newHighlight = this.newHighlight(DocumentHighlightKind.Text, _newRange);
    RangeImpl _newRange_1 = this.newRange(1, 1, 1, 1);
    DocumentHighlightImpl _newHighlight_1 = this.newHighlight(DocumentHighlightKind.Write, _newRange_1);
    RangeImpl _newRange_2 = this.newRange(1, 1, 1, 1);
    DocumentHighlightImpl _newHighlight_2 = this.newHighlight(DocumentHighlightKind.Read, _newRange_2);
    ArrayList<DocumentHighlightImpl> _newArrayList = CollectionLiterals.<DocumentHighlightImpl>newArrayList(null, _newHighlight, _newHighlight_1, _newHighlight_2);
    final List<? extends DocumentHighlight> input = this.sort(_newArrayList);
    DocumentHighlight _get = input.get(0);
    Range _range = _get.getRange();
    Position _start = _range.getStart();
    int _line = _start.getLine();
    Assert.assertEquals(1, _line);
    DocumentHighlight _get_1 = input.get(0);
    Range _range_1 = _get_1.getRange();
    Position _start_1 = _range_1.getStart();
    int _character = _start_1.getCharacter();
    Assert.assertEquals(1, _character);
    DocumentHighlight _get_2 = input.get(0);
    Range _range_2 = _get_2.getRange();
    Position _end = _range_2.getEnd();
    int _line_1 = _end.getLine();
    Assert.assertEquals(1, _line_1);
    DocumentHighlight _get_3 = input.get(0);
    Range _range_3 = _get_3.getRange();
    Position _end_1 = _range_3.getEnd();
    int _character_1 = _end_1.getCharacter();
    Assert.assertEquals(1, _character_1);
    DocumentHighlight _get_4 = input.get(0);
    DocumentHighlightKind _kind = _get_4.getKind();
    Assert.assertEquals(DocumentHighlightKind.Text, _kind);
    DocumentHighlight _get_5 = input.get(1);
    Range _range_4 = _get_5.getRange();
    Position _start_2 = _range_4.getStart();
    int _line_2 = _start_2.getLine();
    Assert.assertEquals(1, _line_2);
    DocumentHighlight _get_6 = input.get(1);
    Range _range_5 = _get_6.getRange();
    Position _start_3 = _range_5.getStart();
    int _character_2 = _start_3.getCharacter();
    Assert.assertEquals(1, _character_2);
    DocumentHighlight _get_7 = input.get(1);
    Range _range_6 = _get_7.getRange();
    Position _end_2 = _range_6.getEnd();
    int _line_3 = _end_2.getLine();
    Assert.assertEquals(1, _line_3);
    DocumentHighlight _get_8 = input.get(1);
    Range _range_7 = _get_8.getRange();
    Position _end_3 = _range_7.getEnd();
    int _character_3 = _end_3.getCharacter();
    Assert.assertEquals(1, _character_3);
    DocumentHighlight _get_9 = input.get(1);
    DocumentHighlightKind _kind_1 = _get_9.getKind();
    Assert.assertEquals(DocumentHighlightKind.Read, _kind_1);
    DocumentHighlight _get_10 = input.get(2);
    Range _range_8 = _get_10.getRange();
    Position _start_4 = _range_8.getStart();
    int _line_4 = _start_4.getLine();
    Assert.assertEquals(1, _line_4);
    DocumentHighlight _get_11 = input.get(2);
    Range _range_9 = _get_11.getRange();
    Position _start_5 = _range_9.getStart();
    int _character_4 = _start_5.getCharacter();
    Assert.assertEquals(1, _character_4);
    DocumentHighlight _get_12 = input.get(2);
    Range _range_10 = _get_12.getRange();
    Position _end_4 = _range_10.getEnd();
    int _line_5 = _end_4.getLine();
    Assert.assertEquals(1, _line_5);
    DocumentHighlight _get_13 = input.get(2);
    Range _range_11 = _get_13.getRange();
    Position _end_5 = _range_11.getEnd();
    int _character_5 = _end_5.getCharacter();
    Assert.assertEquals(1, _character_5);
    DocumentHighlight _get_14 = input.get(2);
    DocumentHighlightKind _kind_2 = _get_14.getKind();
    Assert.assertEquals(DocumentHighlightKind.Write, _kind_2);
    DocumentHighlight _last = IterableExtensions.last(input);
    Assert.assertNull(_last);
  }
  
  private DocumentHighlightImpl newHighlight(final DocumentHighlightKind kind, final RangeImpl range) {
    return new DocumentHighlightImpl(range, kind);
  }
  
  private RangeImpl newRange(final int startLine, final int startChar, final int endLine, final int endChar) {
    PositionImpl _newPosition = this.newPosition(startLine, startChar);
    PositionImpl _newPosition_1 = this.newPosition(endLine, endChar);
    return new RangeImpl(_newPosition, _newPosition_1);
  }
  
  private PositionImpl newPosition(final int line, final int character) {
    new PositionImpl(line, character);
    return new PositionImpl(line, character);
  }
  
  private List<? extends DocumentHighlight> sort(final List<? extends DocumentHighlight> toSort) {
    toSort.sort(this.comparator);
    return toSort;
  }
}
