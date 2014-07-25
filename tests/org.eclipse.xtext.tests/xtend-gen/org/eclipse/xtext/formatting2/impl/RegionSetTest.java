/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.impl;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.impl.ArrayListTextSegmentSet;
import org.eclipse.xtext.formatting2.impl.TestableProblemReporter;
import org.eclipse.xtext.formatting2.impl.TextSegment;
import org.eclipse.xtext.formatting2.impl.TextSegmentSet;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class RegionSetTest {
  private void test(final CharSequence expectation, final Procedure1<? super TextSegmentSet<ITextSegment>> test) {
    final TestableProblemReporter issues = new TestableProblemReporter();
    TextSegment _textSegment = new TextSegment(null, 10, 90);
    final ArrayListTextSegmentSet<ITextSegment> set = new ArrayListTextSegmentSet<ITextSegment>(_textSegment, null, issues);
    test.apply(set);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.append(issues, "");
    _builder.newLineIfNotEmpty();
    _builder.append("set=[");
    String _string = set.toString();
    String _replace = _string.replace("\n", ", ");
    _builder.append(_replace, "");
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    final String actual = _builder.toString();
    String _string_1 = expectation.toString();
    String _string_2 = actual.toString();
    Assert.assertEquals(_string_1, _string_2);
  }
  
  @Test
  public void testAddValid() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[10,0], [10,1], [11,1], [12,1], [99,1], [100,0]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 10, 0);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 11, 1);
        it.add(_textSegment_1);
        TextSegment _textSegment_2 = new TextSegment(null, 99, 1);
        it.add(_textSegment_2);
        TextSegment _textSegment_3 = new TextSegment(null, 10, 1);
        it.add(_textSegment_3);
        TextSegment _textSegment_4 = new TextSegment(null, 100, 0);
        it.add(_textSegment_4);
        TextSegment _textSegment_5 = new TextSegment(null, 12, 1);
        it.add(_textSegment_5);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testLowerBoundOK1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[10,1]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 10, 1);
        it.add(_textSegment);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testLowerBoundOK2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[10,0]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 10, 0);
        it.add(_textSegment);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testLowerBoundNotOK() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=outOfRegion:[9,1]");
    _builder.newLine();
    _builder.append("set=[]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 9, 1);
        it.add(_textSegment);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testUpperBoundOK1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[99,1]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 99, 1);
        it.add(_textSegment);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testUpperBoundOK2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[100,0]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 100, 0);
        it.add(_textSegment);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testUpperBoundNotOK() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=outOfRegion:[101,1]");
    _builder.newLine();
    _builder.append("set=[]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 101, 1);
        it.add(_textSegment);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testNoMergeConflic1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[20,0], [20,1]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 20, 0);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 20, 1);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testNoMergeConflic2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=");
    _builder.newLine();
    _builder.append("set=[[20,0], [20,1]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 20, 1);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 20, 0);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[20,0]<>[20,0]");
    _builder.newLine();
    _builder.append("set=[]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 20, 0);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 20, 0);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[21,0]<>[20,2]");
    _builder.newLine();
    _builder.append("set=[[20,2]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 20, 2);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 21, 0);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[20,2]<>[21,0]");
    _builder.newLine();
    _builder.append("set=[[20,2]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 21, 0);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 20, 2);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[20,2]<>[21,5]");
    _builder.newLine();
    _builder.append("set=[[21,5]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 21, 5);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 20, 2);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[20,2]<>[21,5]");
    _builder.newLine();
    _builder.append("set=[[21,5]]");
    _builder.newLine();
    final Procedure1<TextSegmentSet<ITextSegment>> _function = new Procedure1<TextSegmentSet<ITextSegment>>() {
      public void apply(final TextSegmentSet<ITextSegment> it) {
        TextSegment _textSegment = new TextSegment(null, 21, 5);
        it.add(_textSegment);
        TextSegment _textSegment_1 = new TextSegment(null, 20, 2);
        it.add(_textSegment_1);
      }
    };
    this.test(_builder, _function);
  }
}
