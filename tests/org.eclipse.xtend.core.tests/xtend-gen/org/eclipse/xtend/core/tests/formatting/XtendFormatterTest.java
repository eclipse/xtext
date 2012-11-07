package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterTest extends AbstractFormatterTest {
  @Test
  public void formatClass1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package  foo  class  bar  {  }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClass11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("   ");
    _builder_1.append("package  foo  class  bar  {  }");
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClass2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class bar{}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClass3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int member1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int member2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def meth1() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def meth2() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int member3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class bar{ int member1 int member2 def meth1() {} def meth2(){} int member3 }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClass31() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def meth1() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class bar{");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def meth1() {} ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClass4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int member1");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int member2");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def meth1() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def meth2() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int member3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class bar{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("int member1 ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("int member2 ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def meth1() {} ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def meth2(){} ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("int member3");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClasses1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class baz {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo class bar{} class baz{}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClasses2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class baz {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class bar{} ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class baz{}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatImports1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.Set");
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
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatImports2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import java.util.Map");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import java.util.Set");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatConstructor() {
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
    this.assertFormatted(_builder);
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
  public void formatMethod() {
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
    this.assertFormatted(_builder);
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
  
  @Test
  public void formatGenerics() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = <Pair<String, String>>newArrayList()");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatBlockExpression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\");");
    _builder.newLine();
    _builder.append("val y = \'foo\';");
    _builder.newLine();
    _builder.append("x.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") ; val y = \'foo\' ; x.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBlockExpressionPreserveNewLines() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val x = newArrayList(\"A\", \"b\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val y = \'foo\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x.join");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") ;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("val y = \'foo\'");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("x.join");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClosures() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[toUpperCase == it]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatClosuresSemicolon() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(\"A\", \"b\").filter[val b = it; b.toUpperCase == b]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("newArrayList(\"A\", \"b\").filter[ val b = it  ;   b.toUpperCase == b ]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter[   ] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresParam() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[z|z.toUpperCase == z]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatClosuresMultiLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val z = it");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("z.toUpperCase == z");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter [");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val z = it z.toUpperCase == z ");
    _builder_1.newLine();
    _builder_1.append("] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresMultiLine_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val z = it");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("z.toUpperCase == z");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter[");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val z = it z.toUpperCase == z ");
    _builder_1.newLine();
    _builder_1.append("] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresMultiLineSemicolon() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val z = it;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("z.toUpperCase == z;");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter [");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val z = it  ;   z.toUpperCase == z  ;   ");
    _builder_1.newLine();
    _builder_1.append("] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresWrapIfNeeded() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[val z = it z.toUpperCase == z z.toUpperCase == z");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("z.toUpperCase == z]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter [ val z = it z.toUpperCase == z z.toUpperCase == z z.toUpperCase == z ] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresParamMultiLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter [ z |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val w = z");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("w.toUpperCase == w");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter[ z |");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val w = z w.toUpperCase == w");
    _builder_1.newLine();
    _builder_1.append("] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresWithOperator() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = new StringBuffer() => [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("append(\"x\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("append(\"y\")");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = new StringBuffer() => [");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("append(\"x\")");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("append(\"y\")");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMultiLineClosureWithAssignment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("x += foo.myBuilder [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("x += foo.myBuilder [");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo bar");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1SL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) println(\"foo\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)println(\"foo\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1ML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1MLVar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("var x = if (true)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("var x = if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\") else println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1MLSemicolon1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\");");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\");");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1MLSemicolon2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\");");
    _builder.newLine();
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\");");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatIfElse1SL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) println(\"foo\") else println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)println(\"foo\")else  println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIfElse1ML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIfElse2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatIfElseIf1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("else if (false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    _builder_1.append("else if(false)");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIfElseIf2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("} else if (false) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true) {");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    _builder_1.append("} else if(false) {");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIfElseIf3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("} else if (false)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true) {");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    _builder_1.append("} else if(false)");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFor1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (i : 1 .. 2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for  (  i  :  1 .. 2  )  println(i)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFor2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (i : 1 .. 2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for  (  i  :  1   ..   2  )   {   println(i)  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatWhile1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("while  (  true  )  println(\"x\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatWhile2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("while  (  true  )   {   println(\"x\")  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatDoWhile1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("do");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("while (true)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("do  println(\"x\")   while  (  true  ) ");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatDoWhile2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("do {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("} while (true)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("do  {  println(\"x\")   } while  (  true  ) ");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'x\': println(\'x\') case \'y\': println(\'y\') }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')    }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchSLParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'x\': println(\'x\') case \'y\': println(\'y\') }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch  \'x\'  {   case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')    }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchCaseSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': println(\'y\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchCaseSLParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': println(\'y\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch   \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\':");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\':");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'y\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\':   ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(\'x\')   case   \'y\':    println(\'y\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchMLBlock() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'y\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  { case \'x\': { println(\'x\') }  case   \'y\':  {  println(\'y\') } }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFeatureCall1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFeatureCall2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFeatureCallMultiline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = newArrayList(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(9),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(10)");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9), newArrayList(10)");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorCall1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorCall2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorCallMultiline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = new ArrayList(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(9, 10, 11, 12),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(13, 14, 15, 16)");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4), new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16)");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCall1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = \"x\".substring(0).substring(1).substring(2).substring(3).");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("substring(4).substring(5).substring(6).substring(7).substring(8).");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("substring(9).substring(10).substring(11)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = \"x\".substring(0).substring(1).substring(2).substring(3).substring(4).substring(5).substring(6).substring(7).substring(8).substring(9).substring(10).substring(11)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCall2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = \"x\".substring(0).substring(1)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = \"x\"");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("substring(0)");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("substring(1)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCall21() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = \"x\".toString.toString");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = \"x\"");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("toString");
    _builder_1.newLine();
    _builder_1.append(".");
    _builder_1.newLine();
    _builder_1.append("toString");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCall3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = \"x\".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = \"x\".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCall4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = \"x\".substring(0, 1, 2)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = \"x\".substring (");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("0, ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("1, ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("2)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCallMultiline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = \"x\".substring(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("0,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("1,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("2");
    _builder.newLine();
    _builder.append(")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = \"x\".substring (");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("0, ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("1, ");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("2");
    _builder_1.newLine();
    _builder_1.append(")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCallBuilder1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(\"x\").map()[]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("newArrayList(\"x\")  .  map  (  )  [  ]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCallBuilder2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(\"x\").map()[lenght]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("newArrayList(\"x\")  .  map  (  )  [  lenght  ]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCallBuilderMultiline1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(\"x\").map(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("length");
    _builder.newLine();
    _builder.append(")[lenght]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("newArrayList(\"x\")  .  map  (  length  ");
    _builder_1.newLine();
    _builder_1.append(")  [  lenght  ]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMemberFeatureCallBuilderMultiline2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newArrayList(\"x\").map(length) [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("length");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("newArrayList(\"x\")  .  map  (  length   )  [  length  ");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBinaryExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("15 + 16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("29 + 30 + 31 + 32 + 33 + 34 + 35 + 36");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 ");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBinaryExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36 ");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXTypeLiteral() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof(String)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof  (  String  )");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXTypeLiteralArray1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof(String[])");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof  (  String  [  ])");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXTypeLiteralArray2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typeof(String[][])");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("typeof  (  String  [  ] [ ] )");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXThrowExpression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new RuntimeException()");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("throw  new  RuntimeException()");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXReturnExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return \"foo\"");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return   \"foo\"");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXReturnExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"foo\"");
    _builder.newLine();
    _builder.append("return");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\"foo\"  return");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatXReturnExpression3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return;");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return   ;");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryFinallyExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("finally");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try   println(\"x\")   finally   println(\"y\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryFinallyExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try  {   println(\"x\")  }  finally  {  println(\"y\")  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryCatchExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("catch (Exception e)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try   println(\"x\")   catch (  Exception   e  )   println(\"y\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryCatchExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try  {   println(\"x\")  }  catch (  Exception   e  )  {  println(\"y\")  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryCatchFinallyExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("catch (Exception e)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("finally");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"z\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try   println(\"x\")  catch   (   Exception   e   )   println(\"y\")  finally   println(\"z\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryCatchFinallyExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"z\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try  {   println(\"x\")  }   catch   (   Exception   e   )  {  println(\"y\")  } finally  {  println(\"z\")  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryCatchCatchFinallyExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("catch (Exception e)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("catch (Exception f)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"z\")");
    _builder.newLine();
    _builder.append("finally");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"a\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try   println(\"x\")  catch   (   Exception   e   )   println(\"y\")  catch   (   Exception   f  )   println(\"z\")  finally   println(\"a\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatTryCatchCatchFinallyExpression2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("} catch (Exception f) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"z\")");
    _builder.newLine();
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"a\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try  {   println(\"x\")  }   catch   (   Exception   e   )  {  println(\"y\")  } catch   (   Exception   f  )  {  println(\"z\")  } finally  {  println(\"a\")  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatPreferencesExample() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Movies {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def settings(XtendFormatterConfig config) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<FormatterSetting> settings = newArrayList()");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (entry : config.namedProperties.entrySet) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val key = entry.key");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val category = key.split(\".\").head");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var catEnum = Category::byName(category)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (catEnum == null)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("catEnum = Category::OTHER");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("settings.add(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD,");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("key, key.toFirstUpper, newArrayList(entry.value.name)))");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return settings");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
}
