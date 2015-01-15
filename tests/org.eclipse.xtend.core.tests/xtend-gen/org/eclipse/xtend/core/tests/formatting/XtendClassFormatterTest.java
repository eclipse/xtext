package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendClassFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatConstructor01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
        it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatConstructor02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
        it.<Boolean>put(XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatConstructor1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatConstructor2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(x)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatConstructor3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String x, String y) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(x, y)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatConstructor4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p2,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p3,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p4,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p5");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatField01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
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
    _builder.append("class bar {");
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
    _builder.append("class bar {");
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
    _builder.append("class bar {");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldVar() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var int foo");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int bar");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static val int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldStaticVar() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static var int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldExtension01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldExtensionInit01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension String = \"a\" + \"b\"");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldExtensionInit02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension String = \"a\" + \"b\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Integer = 1 + 2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldExtensionVal01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension val String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldExtensionVar01() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension var String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatFieldExtension02() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      @Override
      public void apply(final MapBasedPreferenceValues it) {
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Integer");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder.append("class bar");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x, String y) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String p1, String p2, String p3, String p4, String p5, String p6,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p7, String p8, String p9, String p10, String p11, String p12,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p13, String p14) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p1,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p2,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p3,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p4,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String p5");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatAbstractMethod1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatAbstractMethod2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract class bar {");
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
    _builder.append("class bar {");
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
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def baz(String x, String y");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append(") {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
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
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated def baz() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
}
