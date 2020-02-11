/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeActionTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testCodeAction() {
    final Procedure1<AbstractLanguageServerTest.TestCodeActionConfiguration> _function = (AbstractLanguageServerTest.TestCodeActionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("command : my.textedit.command");
      _builder_1.newLine();
      _builder_1.append("title : Make \'foo\' upper case");
      _builder_1.newLine();
      _builder_1.append("args : ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("MyModel.testlang : Foo [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      it.setExpectedCodeActions(_builder_1.toString());
    };
    this.testCodeAction(_function);
  }
  
  @Test
  public void testSemanticCodeAction() {
    final Procedure1<AbstractLanguageServerTest.TestCodeActionConfiguration> _function = (AbstractLanguageServerTest.TestCodeActionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String ccc");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String aaa");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("type String {}");
      _builder.newLine();
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("title : Sort Members");
      _builder_1.newLine();
      _builder_1.append("kind : ");
      _builder_1.newLine();
      _builder_1.append("command : ");
      _builder_1.newLine();
      _builder_1.append("codes : unsorted_members");
      _builder_1.newLine();
      _builder_1.append("edit : changes :");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("MyModel.testlang : ");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("String aaa");
      _builder_1.newLine();
      _builder_1.append("     ");
      _builder_1.append("[[0, 10] .. [0, 10]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("     ");
      _builder_1.append("[[1, 11] .. [3, 0]]");
      _builder_1.newLine();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      it.setExpectedCodeActions(_builder_1.toString());
    };
    this.testCodeAction(_function);
  }
}
