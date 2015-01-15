package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys;
import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendEnumFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatPublic() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public enum Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatLiteral01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatLiteral02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAR,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAZ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatLiteral03() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
        it.<Integer>put(XtendFormatterPreferenceKeys.blankLinesBetweenEnumLiterals, Integer.valueOf(1));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO,");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAR,");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BAZ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatBraces_01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
        it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatBraces_02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
        it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
}
