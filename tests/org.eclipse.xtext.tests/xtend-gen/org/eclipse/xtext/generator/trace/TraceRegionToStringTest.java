/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceRegionToStringTester;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceRegionToStringTest {
  @Test
  public void simple() {
    final TraceRegionToStringTester tester = new TraceRegionToStringTester();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo bar");
    _builder.newLine();
    tester.setLocalText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("baz buz");
    _builder_1.newLine();
    tester.setRemote1(_builder_1.toString());
    SourceRelativeURI _uri1 = tester.getUri1();
    TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(4, 2, _uri1);
    TraceRegionToStringTester.Region _region = new TraceRegionToStringTester.Region(1, 2, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
    tester.setTrace(_region);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("-- local1 --- | -- remote1 --");
    _builder_2.newLine();
    _builder_2.append("f[1[oo]1] bar | baz [1[bu]1]z");
    _builder_2.newLine();
    _builder_2.append("-----------------------------");
    _builder_2.newLine();
    _builder_2.append("1: D 1-2 Region -> Location[4,2,remote1]");
    _builder_2.newLine();
    this.operator_tripleEquals(tester, _builder_2);
  }
  
  @Test
  public void oneChild() {
    final TraceRegionToStringTester tester = new TraceRegionToStringTester();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo bar");
    _builder.newLine();
    tester.setLocalText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("baz buz");
    _builder_1.newLine();
    tester.setRemote1(_builder_1.toString());
    SourceRelativeURI _uri1 = tester.getUri1();
    TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 6, _uri1);
    TraceRegionToStringTester.Region _region = new TraceRegionToStringTester.Region(0, 7, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
    final Procedure1<TraceRegionToStringTester.Region> _function = new Procedure1<TraceRegionToStringTester.Region>() {
      @Override
      public void apply(final TraceRegionToStringTester.Region it) {
        TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(2, 4);
        it.addChild(1, 6, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
      }
    };
    TraceRegionToStringTester.Region _doubleArrow = ObjectExtensions.<TraceRegionToStringTester.Region>operator_doubleArrow(_region, _function);
    tester.setTrace(_doubleArrow);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("----- local1 ----- | ----- remote1 -----");
    _builder_2.newLine();
    _builder_2.append("[1[f[2[oo bar]2,1] | b[1[a[2[z bu]2]z]1]");
    _builder_2.newLine();
    _builder_2.append("----------------------------------------");
    _builder_2.newLine();
    _builder_2.append("1: D 0-7 Region -> Location[1,6,remote1] {");
    _builder_2.newLine();
    _builder_2.append("2: D 1-6   Region -> Location[2,4]");
    _builder_2.newLine();
    _builder_2.append("1:       }");
    _builder_2.newLine();
    this.operator_tripleEquals(tester, _builder_2);
  }
  
  @Test
  public void twoIdentical() {
    final TraceRegionToStringTester tester = new TraceRegionToStringTester();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo bar");
    _builder.newLine();
    tester.setLocalText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("baz buz");
    _builder_1.newLine();
    tester.setRemote1(_builder_1.toString());
    SourceRelativeURI _uri1 = tester.getUri1();
    TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 5, _uri1);
    TraceRegionToStringTester.Region _region = new TraceRegionToStringTester.Region(0, 7, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
    final Procedure1<TraceRegionToStringTester.Region> _function = new Procedure1<TraceRegionToStringTester.Region>() {
      @Override
      public void apply(final TraceRegionToStringTester.Region it) {
        TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 5);
        it.addChild(0, 7, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
      }
    };
    TraceRegionToStringTester.Region _doubleArrow = ObjectExtensions.<TraceRegionToStringTester.Region>operator_doubleArrow(_region, _function);
    tester.setTrace(_doubleArrow);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("---- local1 ----- | ---- remote1 ----");
    _builder_2.newLine();
    _builder_2.append("[1,2[foo bar]2,1] | b[1,2[az bu]2,1]z");
    _builder_2.newLine();
    _builder_2.append("-------------------------------------");
    _builder_2.newLine();
    _builder_2.append("1: D 0-7 Region -> Location[1,5,remote1] {");
    _builder_2.newLine();
    _builder_2.append("2: D 0-7   Region -> Location[1,5]");
    _builder_2.newLine();
    _builder_2.append("1:       }");
    _builder_2.newLine();
    this.operator_tripleEquals(tester, _builder_2);
  }
  
  @Test
  public void twoFrame1() {
    final TraceRegionToStringTester tester = new TraceRegionToStringTester();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo bar");
    _builder.newLine();
    tester.setLocalText(_builder.toString());
    TextRegion _textRegion = new TextRegion(1, 5);
    tester.setLocalFrame(_textRegion);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("baz buz");
    _builder_1.newLine();
    tester.setRemote1(_builder_1.toString());
    SourceRelativeURI _uri1 = tester.getUri1();
    TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 5, _uri1);
    TraceRegionToStringTester.Region _region = new TraceRegionToStringTester.Region(0, 7, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
    final Procedure1<TraceRegionToStringTester.Region> _function = new Procedure1<TraceRegionToStringTester.Region>() {
      @Override
      public void apply(final TraceRegionToStringTester.Region it) {
        TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 5);
        it.addChild(2, 1, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
        TraceRegionToStringTester.Location _location_1 = new TraceRegionToStringTester.Location(1, 5);
        it.addChild(5, 1, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location_1)));
      }
    };
    TraceRegionToStringTester.Region _doubleArrow = ObjectExtensions.<TraceRegionToStringTester.Region>operator_doubleArrow(_region, _function);
    tester.setTrace(_doubleArrow);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("---- local1 ----- | ---- remote1 ----");
    _builder_2.newLine();
    _builder_2.append("o[1[o]1] b[2[a]2] | b[1,2[az bu]2,1]z");
    _builder_2.newLine();
    _builder_2.append("-------------------------------------");
    _builder_2.newLine();
    _builder_2.append("1: D 2-1 Region -> Location[1,5]");
    _builder_2.newLine();
    _builder_2.append("2: D 5-1 Region -> Location[1,5]");
    _builder_2.newLine();
    this.operator_tripleEquals(tester, _builder_2);
  }
  
  @Test
  public void twoFrame2() {
    final TraceRegionToStringTester tester = new TraceRegionToStringTester();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo bar");
    _builder.newLine();
    tester.setLocalText(_builder.toString());
    TextRegion _textRegion = new TextRegion(2, 4);
    tester.setLocalFrame(_textRegion);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("baz buz");
    _builder_1.newLine();
    tester.setRemote1(_builder_1.toString());
    SourceRelativeURI _uri1 = tester.getUri1();
    TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 5, _uri1);
    TraceRegionToStringTester.Region _region = new TraceRegionToStringTester.Region(0, 7, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
    final Procedure1<TraceRegionToStringTester.Region> _function = new Procedure1<TraceRegionToStringTester.Region>() {
      @Override
      public void apply(final TraceRegionToStringTester.Region it) {
        TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(1, 5);
        it.addChild(2, 1, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
        TraceRegionToStringTester.Location _location_1 = new TraceRegionToStringTester.Location(1, 5);
        it.addChild(5, 1, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location_1)));
      }
    };
    TraceRegionToStringTester.Region _doubleArrow = ObjectExtensions.<TraceRegionToStringTester.Region>operator_doubleArrow(_region, _function);
    tester.setTrace(_doubleArrow);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("---- local1 ---- | ---- remote1 ----");
    _builder_2.newLine();
    _builder_2.append("[1[o]1] b[2[a]2] | b[1,2[az bu]2,1]z");
    _builder_2.newLine();
    _builder_2.append("------------------------------------");
    _builder_2.newLine();
    _builder_2.append("1: D 2-1 Region -> Location[1,5]");
    _builder_2.newLine();
    _builder_2.append("2: D 5-1 Region -> Location[1,5]");
    _builder_2.newLine();
    this.operator_tripleEquals(tester, _builder_2);
  }
  
  @Test
  public void twoFiles() {
    final TraceRegionToStringTester tester = new TraceRegionToStringTester();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo bar");
    _builder.newLine();
    tester.setLocalText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("baz buz");
    _builder_1.newLine();
    tester.setRemote1(_builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("xxx zzz");
    _builder_2.newLine();
    tester.setRemote2(_builder_2.toString());
    SourceRelativeURI _uri1 = tester.getUri1();
    TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(0, 7, _uri1);
    TraceRegionToStringTester.Region _region = new TraceRegionToStringTester.Region(0, 7, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
    final Procedure1<TraceRegionToStringTester.Region> _function = new Procedure1<TraceRegionToStringTester.Region>() {
      @Override
      public void apply(final TraceRegionToStringTester.Region it) {
        TraceRegionToStringTester.Location _location = new TraceRegionToStringTester.Location(0, 3);
        it.addChild(0, 3, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location)));
        SourceRelativeURI _uri2 = tester.getUri2();
        TraceRegionToStringTester.Location _location_1 = new TraceRegionToStringTester.Location(0, 3, _uri2);
        it.addChild(4, 3, Collections.<ILocationData>unmodifiableList(CollectionLiterals.<ILocationData>newArrayList(_location_1)));
      }
    };
    TraceRegionToStringTester.Region _doubleArrow = ObjectExtensions.<TraceRegionToStringTester.Region>operator_doubleArrow(_region, _function);
    tester.setTrace(_doubleArrow);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("------- local1 -------- | ---- remote1 -----");
    _builder_3.newLine();
    _builder_3.append("[1,2[foo]2] [3[bar]3,1] | [1,2[baz]2] buz]1]");
    _builder_3.newLine();
    _builder_3.append("                        ");
    _builder_3.append("| ---- remote2 -----");
    _builder_3.newLine();
    _builder_3.append("                        ");
    _builder_3.append("| [3[xxx]3] zzz");
    _builder_3.newLine();
    _builder_3.append("--------------------------------------------");
    _builder_3.newLine();
    _builder_3.append("1: D 0-7 Region -> Location[0,7,remote1] {");
    _builder_3.newLine();
    _builder_3.append("2: D 0-3   Region -> Location[0,3]");
    _builder_3.newLine();
    _builder_3.append("3: D 4-3   Region -> Location[0,3,remote2]");
    _builder_3.newLine();
    _builder_3.append("1:       }");
    _builder_3.newLine();
    this.operator_tripleEquals(tester, _builder_3);
  }
  
  public void operator_tripleEquals(final TraceRegionToStringTester actual, final CharSequence expectation) {
    final String rendered = actual.toString();
    String _string = expectation.toString();
    String _trim = _string.trim();
    Assert.assertEquals(_trim, rendered);
  }
}
