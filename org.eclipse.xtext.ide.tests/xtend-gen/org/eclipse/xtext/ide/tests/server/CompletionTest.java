/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.TestCompletionConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompletionTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testCompletion_01() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      it.setModel("");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type -> type [[0, 0] .. [0, 0]]");
      _builder.newLine();
      it.setExpectedCompletionItems(_builder.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_02() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      it.setModel("type ");
      it.setColumn(5);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("name (ID) -> name [[0, 5] .. [0, 5]]");
      _builder.newLine();
      it.setExpectedCompletionItems(_builder.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_03() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(1);
      it.setColumn("type Bar {".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Bar (TypeDeclaration) -> Bar [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("Foo (TypeDeclaration) -> Foo [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("boolean -> boolean [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("int -> int [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("op -> op [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("string -> string [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("void -> void [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("} -> } [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("{ -> { [[1, 9] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("+ } [[1, 11] .. [1, 11]]");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_04() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(1);
      it.setColumn("    Fo".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Foo (TypeDeclaration) -> Foo [[1, 4] .. [1, 6]]");
      _builder_1.newLine();
      _builder_1.append("[ -> [ [[1, 6] .. [1, 6]]");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_05() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type foo {}");
      _builder.newLine();
      _builder.append("type Boo {}");
      _builder.newLine();
      _builder.append("type boo {}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(1);
      it.setColumn("type Bar {".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Boo (TypeDeclaration) -> Boo [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("boo (TypeDeclaration) -> boo [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("Foo (TypeDeclaration) -> Foo [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("foo (TypeDeclaration) -> foo [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("boolean -> boolean [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("int -> int [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("op -> op [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("string -> string [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("void -> void [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("} -> } [[1, 10] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("{ -> { [[1, 9] .. [1, 10]]");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("+ } [[1, 11] .. [1, 11]]");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_AdditionalEdits_01() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo ");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(0);
      it.setColumn("type Foo ".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("extends -> extends [[0, 9] .. [0, 9]]");
      _builder_1.newLine();
      _builder_1.append("{ -> { [[0, 9] .. [0, 9]]");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("+ } [[1, 0] .. [1, 0]]");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testCompletion_AdditionalEdits_02() {
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo  ");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(0);
      it.setColumn("type Foo ".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("extends -> extends [[0, 9] .. [0, 9]]");
      _builder_1.newLine();
      _builder_1.append("{ -> { [[0, 9] .. [0, 9]]");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("+ } [[0, 10] .. [0, 10]]");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
  }
}
