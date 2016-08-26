/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.HoverTestConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class HoverTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testHover_01() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Some documentation.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(3);
      int _length = "type F".length();
      it.setColumn(_length);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[[3, 5] .. [3, 8]]");
      _builder_1.newLine();
      _builder_1.append("Some documentation.");
      _builder_1.newLine();
      it.setExpectedHover(_builder_1.toString());
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_02() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Some documentation.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("type Foo {}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(3);
      int _length = "{".length();
      it.setColumn(_length);
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_03() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Some documentation.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(4);
      int _length = "\tF".length();
      it.setColumn(_length);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[[4, 1] .. [4, 4]]");
      _builder_1.newLine();
      _builder_1.append("Some documentation.");
      _builder_1.newLine();
      it.setExpectedHover(_builder_1.toString());
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_04() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Some documentation.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("type Bar extends Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(5);
      int _length = "type Bar extends F".length();
      it.setColumn(_length);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[[5, 17] .. [5, 20]]");
      _builder_1.newLine();
      _builder_1.append("Some documentation.");
      _builder_1.newLine();
      it.setExpectedHover(_builder_1.toString());
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_05() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* Some documentation.");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of(("MyModel2." + this.fileExtension), _builder.toString());
      it.setFilesInScope(Collections.<String, CharSequence>unmodifiableMap(CollectionLiterals.<String, CharSequence>newHashMap(_mappedTo)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Bar extends Foo {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setModel(_builder_1.toString());
      int _length = "type Bar extends F".length();
      it.setColumn(_length);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("[[0, 17] .. [0, 20]]");
      _builder_2.newLine();
      _builder_2.append("Some documentation.");
      _builder_2.newLine();
      it.setExpectedHover(_builder_2.toString());
    };
    this.testHover(_function);
  }
}
