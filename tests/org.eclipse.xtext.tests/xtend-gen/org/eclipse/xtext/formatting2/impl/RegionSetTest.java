/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.impl;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.ITextRegion2;
import org.eclipse.xtext.formatting2.impl.RegionSet;
import org.eclipse.xtext.formatting2.impl.TestableProblemReporter;
import org.eclipse.xtext.formatting2.impl.TextRegion2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class RegionSetTest {
  private void test(final CharSequence expectation, final Procedure1<? super RegionSet<ITextRegion2>> test) {
    final TestableProblemReporter issues = new TestableProblemReporter();
    TextRegion2 _textRegion2 = new TextRegion2(null, 10, 90);
    final RegionSet<ITextRegion2> set = new RegionSet<ITextRegion2>(_textRegion2, null, issues);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 10, 0);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 10, 1);
        it.add(_textRegion2_1);
        TextRegion2 _textRegion2_2 = new TextRegion2(null, 11, 1);
        it.add(_textRegion2_2);
        TextRegion2 _textRegion2_3 = new TextRegion2(null, 12, 1);
        it.add(_textRegion2_3);
        TextRegion2 _textRegion2_4 = new TextRegion2(null, 99, 1);
        it.add(_textRegion2_4);
        TextRegion2 _textRegion2_5 = new TextRegion2(null, 100, 0);
        it.add(_textRegion2_5);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 10, 1);
        it.add(_textRegion2);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 10, 0);
        it.add(_textRegion2);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 9, 1);
        it.add(_textRegion2);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 99, 1);
        it.add(_textRegion2);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 100, 0);
        it.add(_textRegion2);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 101, 1);
        it.add(_textRegion2);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 20, 0);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 20, 1);
        it.add(_textRegion2_1);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 20, 1);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 20, 0);
        it.add(_textRegion2_1);
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
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 20, 0);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 20, 0);
        it.add(_textRegion2_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[20,2]<>[21,0]");
    _builder.newLine();
    _builder.append("set=[[20,2]]");
    _builder.newLine();
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 20, 2);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 21, 0);
        it.add(_textRegion2_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[21,0]<>[20,2]");
    _builder.newLine();
    _builder.append("set=[[20,2]]");
    _builder.newLine();
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 21, 0);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 20, 2);
        it.add(_textRegion2_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[21,5]<>[20,2]");
    _builder.newLine();
    _builder.append("set=[[21,5]]");
    _builder.newLine();
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 21, 5);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 20, 2);
        it.add(_textRegion2_1);
      }
    };
    this.test(_builder, _function);
  }
  
  @Test
  public void testMergeConflic5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("issues=mergeConflict:[21,5]<>[20,2]");
    _builder.newLine();
    _builder.append("set=[[21,5]]");
    _builder.newLine();
    final Procedure1<RegionSet<ITextRegion2>> _function = new Procedure1<RegionSet<ITextRegion2>>() {
      public void apply(final RegionSet<ITextRegion2> it) {
        TextRegion2 _textRegion2 = new TextRegion2(null, 21, 5);
        it.add(_textRegion2);
        TextRegion2 _textRegion2_1 = new TextRegion2(null, 20, 2);
        it.add(_textRegion2_1);
      }
    };
    this.test(_builder, _function);
  }
}
