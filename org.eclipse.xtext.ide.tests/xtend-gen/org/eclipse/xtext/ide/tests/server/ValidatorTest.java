/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;
import java.util.Map;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.ide.tests.testlanguage.validation.TestLanguageValidator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidatorTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testMultilineDiagnostic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Multiline_Demo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", Strings.toUnixLineSeparator(_builder));
    this.initialize();
    final List<Diagnostic> problems = IterableExtensions.<Map.Entry<String, List<Diagnostic>>>head(this.getDiagnostics().entrySet()).getValue();
    String _join = IterableExtensions.join(problems, "\n");
    String _plus = ("problems found:\n" + _join);
    Assert.assertEquals(_plus, 1, problems.size());
    final Diagnostic problem = IterableExtensions.<Diagnostic>head(problems);
    this.assertEquals("Test Validation to mark the whole type", problem.getMessage());
    this.assertEquals(TestLanguageValidator.MULTILINE_PROBLEM, problem.getCode());
    final Range range = problem.getRange();
    Assert.assertEquals(0, range.getStart().getLine());
    Assert.assertEquals(0, range.getStart().getCharacter());
    Assert.assertEquals(1, range.getEnd().getLine());
    Assert.assertEquals(1, range.getEnd().getCharacter());
  }
  
  @Test
  public void testMultilineDiagnostic_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Multiline_Demo2 {");
    _builder.newLine();
    _builder.append("string sample}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", Strings.toUnixLineSeparator(_builder));
    this.initialize();
    final List<Diagnostic> problems = IterableExtensions.<Map.Entry<String, List<Diagnostic>>>head(this.getDiagnostics().entrySet()).getValue();
    String _join = IterableExtensions.join(problems, "\n");
    String _plus = ("problems found:\n" + _join);
    Assert.assertEquals(_plus, 1, problems.size());
    final Diagnostic problem = IterableExtensions.<Diagnostic>head(problems);
    this.assertEquals("Test Validation to mark the whole type", problem.getMessage());
    this.assertEquals(TestLanguageValidator.MULTILINE_PROBLEM, problem.getCode());
    final Range range = problem.getRange();
    Assert.assertEquals(0, range.getStart().getLine());
    Assert.assertEquals(0, range.getStart().getCharacter());
    Assert.assertEquals(1, range.getEnd().getLine());
    Assert.assertEquals(14, range.getEnd().getCharacter());
  }
  
  @Test
  public void testDiagnosticAtEndOfLineExcludingNewline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type lowercase");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", Strings.toUnixLineSeparator(_builder));
    this.initialize();
    final List<Diagnostic> problems = IterableExtensions.<Map.Entry<String, List<Diagnostic>>>head(this.getDiagnostics().entrySet()).getValue();
    String _join = IterableExtensions.join(problems, "\n");
    String _plus = ("problems found:\n" + _join);
    Assert.assertEquals(_plus, 1, problems.size());
    final Diagnostic problem = IterableExtensions.<Diagnostic>head(problems);
    this.assertEquals("Name should start with a capital", problem.getMessage());
    this.assertEquals(TestLanguageValidator.INVALID_NAME, problem.getCode());
    final Range range = problem.getRange();
    Assert.assertEquals(0, range.getStart().getLine());
    Assert.assertEquals(5, range.getStart().getCharacter());
    Assert.assertEquals(0, range.getEnd().getLine());
    Assert.assertEquals(14, range.getEnd().getCharacter());
  }
  
  @Test
  public void testDiagnosticAtEndOfLineIncludingNewline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type");
    _builder.newLine();
    this.writeFile("MyType1.testlang", Strings.toUnixLineSeparator(_builder));
    this.initialize();
    final List<Diagnostic> problems = IterableExtensions.<Map.Entry<String, List<Diagnostic>>>head(this.getDiagnostics().entrySet()).getValue();
    String _join = IterableExtensions.join(problems, "\n");
    String _plus = ("problems found:\n" + _join);
    Assert.assertEquals(_plus, 1, problems.size());
    final Diagnostic problem = IterableExtensions.<Diagnostic>head(problems);
    this.assertEquals("mismatched input \'<EOF>\' expecting RULE_ID", problem.getMessage());
    this.assertEquals(org.eclipse.xtext.diagnostics.Diagnostic.SYNTAX_DIAGNOSTIC, problem.getCode());
    final Range range = problem.getRange();
    Assert.assertEquals(0, range.getStart().getLine());
    Assert.assertEquals(4, range.getStart().getCharacter());
    Assert.assertEquals(1, range.getEnd().getLine());
    Assert.assertEquals(0, range.getEnd().getCharacter());
  }
}
