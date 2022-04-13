/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.debug;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class LineNumberMappingTests extends AbstractXtendTestCase {
  @Inject
  private IGenerator generator;

  @Inject
  private LineMappingProvider lineMappingProvider;

  @Test
  public void testLineMapping_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println( // 7");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"Hello World\") // 8");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\"Hello World\") // 7");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println( // 9");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new String( // 7");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\"Hello World\")) // 8");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(new String(\"Hello World\")) // 7..8");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch x : \"Hello\" as Object { \t\t// 7..8");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String case x.length > 4 : { \t// 9..13");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("println(\t\t\t\t\t// 16");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"It\'s a long one \" \t\t// 15");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("+ x.length)\t\t\t// 14");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\t\t// 7");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\'foo\' \t\t// 8");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("+ \'bar\')\t// 8");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo(\t\t// 6");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new Object())\t// 5");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo(Object x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void doStuff() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch x : \"Hello\" { \t\t// 5..6");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String \t\t\t\t\t// 7");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("case ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("x.length > 4 : {// 8..10");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("null\t\t\t// 12");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  @Test
  public void testLineMapping_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Object doStuff() { // 16");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch x : \"Hello\" { \t\t// 5..7");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("String \t\t\t\t\t// 8");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("case ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("x.length > 4 : {// 9..11");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("null\t\t\t// 13");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertLineNumbers(_builder);
  }

  public void assertLineNumbers(final CharSequence xtendCodeWithLineNumbers) {
    final AbstractTraceRegion region = this.getTraceRegion(xtendCodeWithLineNumbers);
    final List<LineMappingProvider.LineMapping> normalizedMappings = this.lineMappingProvider.getLineMapping(region);
    final String[] lines = xtendCodeWithLineNumbers.toString().split("\n");
    int _size = ((List<String>)Conversions.doWrapArray(lines)).size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer lineNumber : _upTo) {
      {
        final LineMappingProvider.LineMapping mapping = this.findMapping(normalizedMappings, lineNumber);
        final String line = lines[(lineNumber).intValue()];
        if ((mapping != null)) {
          int _indexOf = line.indexOf("//");
          boolean _equals = (_indexOf == (-1));
          if (_equals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Line ");
            _builder.append(lineNumber);
            _builder.append(" is mapped to ");
            _builder.append(mapping.targetStartLine);
            _builder.append("(\'");
            _builder.append(line);
            _builder.append("\')");
            Assert.fail(_builder.toString());
          }
          int _indexOf_1 = line.indexOf("//");
          int _plus = (_indexOf_1 + 2);
          final String expectation = line.substring(_plus).trim();
          int expTargetStart = (-1);
          int expTargetEnd = (-1);
          int _indexOf_2 = expectation.indexOf("..");
          boolean _notEquals = (_indexOf_2 != (-1));
          if (_notEquals) {
            final int idx = expectation.indexOf("..");
            expTargetStart = Integer.parseInt(expectation.substring(0, idx));
            expTargetEnd = Integer.parseInt(expectation.substring((idx + 2)));
          } else {
            expTargetStart = (expTargetEnd = Integer.parseInt(expectation));
          }
          Assert.assertEquals(line, expTargetStart, mapping.targetStartLine);
          Assert.assertEquals(("unexpected end in line : " + line), expTargetEnd, mapping.targetEndLine);
        } else {
          int _indexOf_3 = line.indexOf("//");
          boolean _notEquals_1 = (_indexOf_3 != (-1));
          if (_notEquals_1) {
            Assert.fail(("Unmatched expectation : " + line));
          }
        }
      }
    }
  }

  public LineMappingProvider.LineMapping findMapping(final List<LineMappingProvider.LineMapping> mappings, final Integer sourceLine) {
    for (final LineMappingProvider.LineMapping m : mappings) {
      if ((m.sourceStartLine == ((sourceLine).intValue() + 1))) {
        return m;
      }
    }
    return null;
  }

  public AbstractTraceRegion getTraceRegion(final CharSequence xtendCode) {
    try {
      final XtendClass clazz = super.clazz(xtendCode.toString());
      final TraceRegionFSAForTest fsa = new TraceRegionFSAForTest();
      this.generator.doGenerate(clazz.eResource(), fsa);
      final AbstractTraceRegion result = ((ITraceRegionProvider) fsa.charSequence).getTraceRegion();
      this.print(result, fsa.charSequence.toString());
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void print(final AbstractTraceRegion provider, final String code) {
  }
}
