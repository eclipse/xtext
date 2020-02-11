/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.ColoringInformation;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionItemKind;
import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.DocumentSymbol;
import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.InsertTextFormat;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.MarkupContent;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.SignatureHelp;
import org.eclipse.lsp4j.SymbolInformation;
import org.eclipse.lsp4j.TextDocumentEdit;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.TestCompletionConfiguration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
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
      _builder.append("package -> package [[0, 0] .. [0, 0]]");
      _builder.newLine();
      _builder.append("type -> type [[0, 0] .. [0, 0]]");
      _builder.newLine();
      _builder.append("Sample Snippet -> type ${1|A,B,C|} {");
      _builder.newLine();
      _builder.append("                ");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("} [[0, 0] .. [0, 0]]");
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
  public void testSnippet() {
    this.withKind = true;
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append(" ");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(1);
      it.setColumn(0);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(Keyword) package -> package [[1, 0] .. [1, 0]]");
      _builder_1.newLine();
      _builder_1.append("(Keyword) type -> type [[1, 0] .. [1, 0]]");
      _builder_1.newLine();
      _builder_1.append("(Snippet|Snippet) Sample Snippet -> type ${1|A,B,C|} {");
      _builder_1.newLine();
      _builder_1.append("                ");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("} [[1, 0] .. [1, 0]]");
      _builder_1.newLine();
      it.setExpectedCompletionItems(_builder_1.toString());
    };
    this.testCompletion(_function);
    this.withKind = false;
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
  
  private boolean withKind = false;
  
  @Override
  protected String _toExpectation(final CompletionItem it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (this.withKind) {
        _builder.append("(");
        CompletionItemKind _kind = it.getKind();
        _builder.append(_kind);
        {
          InsertTextFormat _insertTextFormat = it.getInsertTextFormat();
          boolean _tripleNotEquals = (_insertTextFormat != null);
          if (_tripleNotEquals) {
            _builder.append("|");
            InsertTextFormat _insertTextFormat_1 = it.getInsertTextFormat();
            _builder.append(_insertTextFormat_1);
          }
        }
        _builder.append(") ");
      }
    }
    String _label = it.getLabel();
    _builder.append(_label);
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it.getDetail());
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(" (");
        String _detail = it.getDetail();
        _builder.append(_detail);
        _builder.append(")");
      }
    }
    {
      TextEdit _textEdit = it.getTextEdit();
      boolean _tripleNotEquals_1 = (_textEdit != null);
      if (_tripleNotEquals_1) {
        _builder.append(" -> ");
        String _expectation = this.toExpectation(it.getTextEdit());
        _builder.append(_expectation);
        {
          boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(it.getAdditionalTextEdits());
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            _builder.append("   + ");
            final Function1<TextEdit, String> _function = (TextEdit it_1) -> {
              return this.toExpectation(it_1);
            };
            String _join = IterableExtensions.join(ListExtensions.<TextEdit, String>map(it.getAdditionalTextEdits(), _function), "   + ");
            _builder.append(_join);
          }
        }
      } else {
        if (((it.getInsertText() != null) && (!Objects.equal(it.getInsertText(), it.getLabel())))) {
          _builder.append(" -> ");
          String _insertText = it.getInsertText();
          _builder.append(_insertText);
        }
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Override
  protected String toExpectation(final Object it) {
    if (it instanceof Integer) {
      return _toExpectation((Integer)it);
    } else if (it instanceof List) {
      return _toExpectation((List<?>)it);
    } else if (it instanceof DocumentHighlightKind) {
      return _toExpectation((DocumentHighlightKind)it);
    } else if (it instanceof String) {
      return _toExpectation((String)it);
    } else if (it instanceof VersionedTextDocumentIdentifier) {
      return _toExpectation((VersionedTextDocumentIdentifier)it);
    } else if (it instanceof Pair) {
      return _toExpectation((Pair<SemanticHighlightingInformation, List<List<String>>>)it);
    } else if (it == null) {
      return _toExpectation((Void)null);
    } else if (it instanceof Map) {
      return _toExpectation((Map<Object, Object>)it);
    } else if (it instanceof CodeAction) {
      return _toExpectation((CodeAction)it);
    } else if (it instanceof CodeLens) {
      return _toExpectation((CodeLens)it);
    } else if (it instanceof ColoringInformation) {
      return _toExpectation((ColoringInformation)it);
    } else if (it instanceof Command) {
      return _toExpectation((Command)it);
    } else if (it instanceof CompletionItem) {
      return _toExpectation((CompletionItem)it);
    } else if (it instanceof DocumentHighlight) {
      return _toExpectation((DocumentHighlight)it);
    } else if (it instanceof DocumentSymbol) {
      return _toExpectation((DocumentSymbol)it);
    } else if (it instanceof Hover) {
      return _toExpectation((Hover)it);
    } else if (it instanceof Location) {
      return _toExpectation((Location)it);
    } else if (it instanceof MarkupContent) {
      return _toExpectation((MarkupContent)it);
    } else if (it instanceof Position) {
      return _toExpectation((Position)it);
    } else if (it instanceof Range) {
      return _toExpectation((Range)it);
    } else if (it instanceof SignatureHelp) {
      return _toExpectation((SignatureHelp)it);
    } else if (it instanceof SymbolInformation) {
      return _toExpectation((SymbolInformation)it);
    } else if (it instanceof TextDocumentEdit) {
      return _toExpectation((TextDocumentEdit)it);
    } else if (it instanceof TextEdit) {
      return _toExpectation((TextEdit)it);
    } else if (it instanceof WorkspaceEdit) {
      return _toExpectation((WorkspaceEdit)it);
    } else if (it instanceof Either) {
      return _toExpectation((Either<?, ?>)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
