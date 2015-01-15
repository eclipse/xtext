package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendInterfaceFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatField01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatField02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int baz");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldInit01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldInit02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int foo = 1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int baz = 1 + 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldVal() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldFinal() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldPublicFinal() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldStatic02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldStatic03() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static int bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldStaticVal() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static val int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldStaticFinal() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldPublicStaticFinal() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatMethod01() {
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
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatMethod02() {
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
    _builder.append("interface bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatMethod03() {
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
    _builder.append("interface bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatMethod04() {
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
    _builder.append("interface bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatMethod1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x, String y)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String p1, String p2, String p3, String p4, String p5, String p6,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p7, String p8, String p9, String p10, String p11, String p12,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p13, String p14)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo()");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethodMultiline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String x,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("interface bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def baz(String x, String y");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(")");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatMethodAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
}
