/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.ide.tests.testlanguage.signatureHelp.SignatureHelpServiceImpl;
import org.eclipse.xtext.testing.SignatureHelpConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * Class for testing the the {@link SignatureHelpService signature help service} implementation.
 * 
 * @author akos.kitta - Initial contribution and API
 * @see SignatureHelpServiceImpl
 */
@SuppressWarnings("all")
public class SignatureHelpTest extends AbstractTestLangLanguageServerTest {
  private static final int LINE_NUMBER = 12;
  
  @Test
  public void singleArgsExactMatchAfterTriggerChar() {
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type A { op foo(a: A) { } } type Main { op main() { foo() } }");
      it.setModel(_builder.toString());
      it.setLine(0);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type A { op foo(a: A) { } } type Main { op main() { foo(");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("A.foo(a: A): void | a: A");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void noArgsExactMatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo()");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("A.foo(): void | A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | <empty>");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void firstArgExactMatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void secondArgExactMatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, 2)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1, 2");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | b: B");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void thirdArgExactMatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, 2, 3)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1, 2, 3");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void singleArgWithLeadingWhitespace() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(     1)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(     1");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void singleArgWithTrailingWhitespace() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1    )");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1    ");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void multipleArgsWithLeadingWhitespaceBeforeFirstArg_ExpectFirstArg() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(    1, 2)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(    1");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void multipleArgsWithLeadingWhitespaceBeforeComma_ExpectFirstArg() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(    1   , 2)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(    1   ");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void multipleArgsWithLeadingWhitespaceAtComma_ExpectFirstArg() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(    1   , 2)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(    1   ,");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | b: B");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void multipleArgsAtComma() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, 2, 3)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1, 2,");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void multipleArgsAtCommaIncomplete() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, 2,)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1, 2,");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void multipleArgsWithCommentAtCommaIncomplete() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, /*,*/ 2,)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1, /*,*/ 2,");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("C.foo(a: A, b: B, c: C): void | c: C");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void beforeOperationCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, 2)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("<empty>");
    };
    this.testSignatureHelp(_function);
  }
  
  @Test
  public void afterOperationCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo(1, 2)");
    final String testMe = _builder.toString();
    final Procedure1<SignatureHelpConfiguration> _function = (SignatureHelpConfiguration it) -> {
      it.setModel(this.getModel(testMe));
      it.setLine(SignatureHelpTest.LINE_NUMBER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo(1, 2)");
      it.setColumn(_builder_1.length());
      it.setExpectedSignatureHelp("<empty>");
    };
    this.testSignatureHelp(_function);
  }
  
  private String getModel(final CharSequence method) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type A { ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op foo() { } ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op foo(a: A): string { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("type B { ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op foo(a: A, b: B): int { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("type C { ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op foo(a: A, b: B, c: C): void { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("type Test { ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("op main() {");
    _builder.newLine();
    _builder.append(method);
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
