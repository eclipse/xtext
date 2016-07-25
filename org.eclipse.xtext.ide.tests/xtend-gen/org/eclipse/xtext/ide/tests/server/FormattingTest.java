/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Range;
import io.typefox.lsapi.builders.RangeBuilder;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.testing.RangeFormattingConfiguration;
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
  public void testRangeFormattingService() {
    final Procedure1<RangeFormattingConfiguration> _function = (RangeFormattingConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo{int bar} type Bar{Foo foo}");
      it.setModel(_builder.toString());
      final Procedure1<RangeBuilder> _function_1 = (RangeBuilder it_1) -> {
        it_1.start(0, 0);
        it_1.end(0, 17);
      };
      RangeBuilder _rangeBuilder = new RangeBuilder(_function_1);
      Range _build = _rangeBuilder.build();
      it.setRange(_build);
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
