/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@Ignore("https://github.com/eclipse/xtext-core/issues/520")
@SuppressWarnings("all")
public class RenameIssue520Test extends AbstractTestLangLanguageServerTest {
  @Test
  public void testTwoFiles() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("foo/Foo.testlang", model);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Bar {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo ref");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String model2 = _builder_1.toString();
      final String file2 = this.writeFile("foo/Bar.testlang", model2);
      this.initialize();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(file);
      Position _position = new Position(0, 6);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "FooNeu");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("changes :");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("Foo.testlang : FooNeu [[0, 5] .. [0, 8]]");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("Bar.testlang : FooNeu [[1, 1] .. [1, 4]]");
      _builder_2.newLine();
      _builder_2.append("documentChanges : ");
      _builder_2.newLine();
      _builder_2.newLine();
      this.assertEquals(_builder_2.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
