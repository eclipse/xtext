/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.DocumentHighlightConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * Class for testing the {@link DocumentHighlightService document highlight
 * service} behavior through the language server.
 * 
 * <p>
 * The string representation of on single {@link DocumentHighlight highlight}
 * instance is represented with the below pattern:
 * 
 * <pre>
 * R|W|T [{d}+, {d}+] .. [{d}+, {d}+]
 * </pre>
 * 
 * where the first character describes the {@link DocumentHighlightKind kind} of
 * the document highlight. If missing, then the value is {@code NaN}. The values
 * between the first square brackets are the start {@link Position#getLine()
 * line} and the (zero-based) {@link Position#getCharacter() character offset}
 * in the line. The second square brackets contains the end position of the
 * selection and described with the same semantics as the first start range.
 * Multiple highlight instances are separated by the {@code |} ("pipe")
 * character.
 * 
 * @author akos.kitta - Initial contribution and API
 * 
 * @see DocumentHighlight
 * @see IDocumentHighlightService
 */
@SuppressWarnings("all")
public class DocumentHighlightTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void singleLineNoOccurrences_SelectionBeforeWriteSiteMethodName() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo() { } }");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void singleLineNoOccurrences_SelectionAfterWriteSiteMethodName() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo() { } }");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op foo(");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void singleLineSingleOccurrence() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo() { } }");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void singleLineSingleOccurrenceWithVariable() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { int foo op foo() { } }");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { int fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 13] .. [0, 16]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void singleLineSingleOccurrenceWithMultipleTypes() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo() { } } type B { op foo() { } }");
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void singleLineMultipleOccurrences_SelectionOnReadSite() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo() { } op bar() { foo(10) } }");
      it.setModel(_builder.toString());
      it.setLine(0);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op foo() { } op bar() { fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]] | R [[0, 33] .. [0, 36]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void singleLineMultipleOccurrences_SelectionOnWriteSite() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo() { } op bar() { foo(10) } }");
      it.setModel(_builder.toString());
      it.setLine(0);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]] | R [[0, 33] .. [0, 36]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void multipleLinesMultipleOccurrences_WithHorizontalTabs() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op foo() { }");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op bar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo(10)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      it.setModel(_builder.toString());
      it.setLine(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\t");
      _builder_1.append("op fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[1, 4] .. [1, 7]] | R [[3, 2] .. [3, 5]]");
    };
    this.testDocumentHighlight(_function);
  }
  
  @Test
  public void multipleLinesMultipleOccurrences_WithWhitespaces() {
    final Procedure1<DocumentHighlightConfiguration> _function = (DocumentHighlightConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("op foo() { }");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("op bar() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("foo(10)");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      it.setModel(_builder.toString());
      it.setLine(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("    ");
      _builder_1.append("op fo");
      it.setColumn(_builder_1.length());
      it.setExpectedDocumentHighlight("W [[1, 7] .. [1, 10]] | R [[3, 8] .. [3, 11]]");
    };
    this.testDocumentHighlight(_function);
  }
}
