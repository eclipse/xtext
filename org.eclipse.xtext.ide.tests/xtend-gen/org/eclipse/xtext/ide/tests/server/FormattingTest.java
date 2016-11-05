/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.testing.RangeFormattingConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * Tests for {@link FormattingService}
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class FormattingTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testFormattingService() {
    final Procedure1<FormattingConfiguration> _function = (FormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("type Bar{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedText(_builder_1.toString());
    };
    this.testFormatting(_function);
  }
  
  @Test
  public void testFormattingClosedFile() {
    final Procedure1<FormattingConfiguration> _function = (FormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      Pair<String, String> _mappedTo = Pair.<String, String>of("foo.testlang", _builder.toString());
      it.setFilesInScope(Collections.<String, CharSequence>unmodifiableMap(CollectionLiterals.<String, CharSequence>newHashMap(_mappedTo)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("type Bar{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedText(_builder_1.toString());
    };
    this.testFormatting(_function);
  }
  
  @Test
  public void testRangeFormattingService() {
    final Procedure1<RangeFormattingConfiguration> _function = (RangeFormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      Range _range = new Range();
      final Procedure1<Range> _function_1 = (Range it_1) -> {
        Position _position = new Position(0, 0);
        it_1.setStart(_position);
        Position _position_1 = new Position(0, 17);
        it_1.setEnd(_position_1);
      };
      Range _doubleArrow = ObjectExtensions.<Range>operator_doubleArrow(_range, _function_1);
      it.setRange(_doubleArrow);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Foo{");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("int bar");
      _builder_1.newLine();
      _builder_1.append("} type Bar{Foo foo}");
      it.setExpectedText(_builder_1.toString());
    };
    this.testRangeFormatting(_function);
  }
}
