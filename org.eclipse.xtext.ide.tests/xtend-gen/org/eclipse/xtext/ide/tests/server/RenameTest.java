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
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class RenameTest extends AbstractTestLangLanguageServerTest {
  private String firstFile;
  
  private String secondFile;
  
  @Before
  public void setUp() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Test foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String first = _builder.toString();
    this.firstFile = this.writeFile("MyType1.testlang", first);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Test2 {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Test foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String second = _builder_1.toString();
    this.secondFile = this.writeFile("MyType2.testlang", second);
    this.initialize();
  }
  
  @Test
  public void testRenameOnDeclaration() {
    Position _position = new Position(0, 5);
    this.doTest(this.firstFile, _position);
  }
  
  @Test
  public void testRenameOnReference() {
    Position _position = new Position(1, 5);
    this.doTest(this.firstFile, _position);
  }
  
  @Test
  public void testRenameOnReferenceInOtherFile() {
    Position _position = new Position(1, 5);
    this.doTest(this.secondFile, _position);
  }
  
  protected void doTest(final String fileName, final Position position) {
    try {
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(fileName);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, position, "Tescht");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("changes :");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("MyType1.testlang : Tescht [[0, 5] .. [0, 9]]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Tescht [[1, 4] .. [1, 8]]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("MyType2.testlang : Test [[1, 4] .. [1, 8]]");
      _builder.newLine();
      _builder.append("documentChanges : ");
      _builder.newLine();
      this.assertEquals(_builder.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
