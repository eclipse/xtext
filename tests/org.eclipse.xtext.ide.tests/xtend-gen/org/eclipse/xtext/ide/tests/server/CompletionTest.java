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
import org.eclipse.xtext.ide.tests.server.TestCompletionConfiguration;
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
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type");
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
      _builder.append("name (ID)");
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
      int _length = "type Bar {".length();
      it.setColumn(_length);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Bar (TypeDeclaration)");
      _builder_1.newLine();
      _builder_1.append("Foo (TypeDeclaration)");
      _builder_1.newLine();
      _builder_1.append("boolean");
      _builder_1.newLine();
      _builder_1.append("int");
      _builder_1.newLine();
      _builder_1.append("string");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("{");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
  }
}
