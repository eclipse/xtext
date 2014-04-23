package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class AnonymousClassFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatSingleMember() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        AnonymousClassFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatMultiMember() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        AnonymousClassFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Runnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int bar");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def foo(String x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatTypeParam() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        AnonymousClassFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Iterable<String>() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override iterator() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatNested() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        AnonymousClassFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Iterator");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = new Iterable<String>() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("override iterator() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new Iterator<String>() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("override hasNext() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("true");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("override next() {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("override remove() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
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
    this.assertFormatted(_function, _builder);
  }
}
