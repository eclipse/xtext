/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.testing.DocumentHighlightConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * Class for testing the highlighting of reference that refer to the object in which they are embedded.
 */
@SuppressWarnings("all")
public class DocumentHighlightTest2 extends AbstractLanguageServerTest {
  public DocumentHighlightTest2() {
    super("nestedRefs");
  }
  
  @Test
  public void testHighlightDeclarationWithNestedReference() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("decl myDecl end myDecl;");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(0);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("decl myDec");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 5] .. [0, 11]] | R [[0, 16] .. [0, 22]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void testHighlightNestedReferenceInsideDeclaration() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("decl myDecl end myDecl;");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(0);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("decl myDecl end myDe");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 5] .. [0, 11]] | R [[0, 16] .. [0, 22]]");
    };
    this.testDocumentHighlight(_function);
  }
}
