/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
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
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class RenameTest2 extends AbstractLanguageServerTest {
  public RenameTest2() {
    super("fileawaretestlanguage");
  }
  
  @Test
  public void testRenameSelfRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("element Foo {");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref Foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("foo/Foo.fileawaretestlanguage", model);
      this.initialize();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(file);
      Position _position = new Position(2, 9);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "Bar");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Foo.fileawaretestlanguage : Bar [[2, 8] .. [2, 11]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Bar [[3, 5] .. [3, 8]]");
      _builder_1.newLine();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore
  public void testRenameContainer() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("element Foo {");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("element Bar {");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref foo.Foo.Bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref Foo.Bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref Bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("foo/Foo.fileawaretestlanguage", model);
      this.initialize();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(file);
      Position _position = new Position(2, 9);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "Baz");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Foo.fileawaretestlanguage : Baz [[2, 8] .. [2, 11]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Baz [[3, 9] .. [3, 12]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Baz [[3, 6] .. [3, 9]]");
      _builder_1.newLine();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
