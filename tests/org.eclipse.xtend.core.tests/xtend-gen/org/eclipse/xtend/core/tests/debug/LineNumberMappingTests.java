package org.eclipse.xtend.core.tests.debug;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.debug.AbstractTraceRegionFSA;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
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
    _builder.append("String case x.length > 4 : { \t// 9..14");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("println(\t\t\t\t\t// 17");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("\"It\'s a long one \" \t\t// 16");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("+ x.length)\t\t\t// 15");
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
    _builder.append("String \t\t\t\t\t// 7..8");
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
    final List<LineMapping> normalizedMappings = this.lineMappingProvider.getLineMapping(region);
    String _string = xtendCodeWithLineNumbers.toString();
    final String[] lines = _string.split("\n");
    int _size = ((List<String>)Conversions.doWrapArray(lines)).size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer lineNumber : _upTo) {
      {
        final LineMapping mapping = this.findMapping(normalizedMappings, lineNumber);
        final String line = lines[(lineNumber).intValue()];
        boolean _notEquals = (!Objects.equal(mapping, null));
        if (_notEquals) {
          int _indexOf = line.indexOf("//");
          int _minus_1 = (-1);
          boolean _equals = (_indexOf == _minus_1);
          if (_equals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Line ");
            _builder.append(lineNumber, "");
            _builder.append(" is mapped to ");
            _builder.append(mapping.targetStartLine, "");
            _builder.append("(\'");
            _builder.append(line, "");
            _builder.append("\')");
            String _string_1 = _builder.toString();
            Assert.fail(_string_1);
          }
          int _indexOf_1 = line.indexOf("//");
          int _plus = (_indexOf_1 + 2);
          String _substring = line.substring(_plus);
          final String expectation = _substring.trim();
          int expTargetStart = (-1);
          int expTargetEnd = (-1);
          int _indexOf_2 = expectation.indexOf("..");
          int _minus_2 = (-1);
          boolean _notEquals_1 = (_indexOf_2 != _minus_2);
          if (_notEquals_1) {
            final int idx = expectation.indexOf("..");
            String _substring_1 = expectation.substring(0, idx);
            int _parseInt = Integer.parseInt(_substring_1);
            expTargetStart = _parseInt;
            int _plus_1 = (idx + 2);
            String _substring_2 = expectation.substring(_plus_1);
            int _parseInt_1 = Integer.parseInt(_substring_2);
            expTargetEnd = _parseInt_1;
          } else {
            int _parseInt_2 = Integer.parseInt(expectation);
            int _expTargetEnd = expTargetEnd = _parseInt_2;
            expTargetStart = _expTargetEnd;
          }
          Assert.assertEquals(line, expTargetStart, mapping.targetStartLine);
          String _plus_2 = ("unexpected end in line : " + line);
          Assert.assertEquals(_plus_2, expTargetEnd, mapping.targetEndLine);
        } else {
          int _indexOf_3 = line.indexOf("//");
          int _minus_3 = (-1);
          boolean _notEquals_2 = (_indexOf_3 != _minus_3);
          if (_notEquals_2) {
            String _plus_3 = ("Unmatched expectation : " + line);
            Assert.fail(_plus_3);
          }
        }
      }
    }
  }
  
  public LineMapping findMapping(final List<LineMapping> mappings, final Integer sourceLine) {
    for (final LineMapping m : mappings) {
      int _plus = ((sourceLine).intValue() + 1);
      boolean _equals = (m.sourceStartLine == _plus);
      if (_equals) {
        return m;
      }
    }
    return null;
  }
  
  public AbstractTraceRegion getTraceRegion(final CharSequence xtendCode) {
    try {
      String _string = xtendCode.toString();
      final XtendClass clazz = super.clazz(_string);
      AbstractTraceRegionFSA _abstractTraceRegionFSA = new AbstractTraceRegionFSA();
      final AbstractTraceRegionFSA fsa = _abstractTraceRegionFSA;
      Resource _eResource = clazz.eResource();
      this.generator.doGenerate(_eResource, fsa);
      final AbstractTraceRegion result = ((ITraceRegionProvider) fsa.charSequence).getTraceRegion();
      String _string_1 = fsa.charSequence.toString();
      this.print(result, _string_1);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void print(final AbstractTraceRegion provider, final String code) {
  }
}
