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
    _builder_1.append("package foo class bar{}");
    _builder_1.newLine();
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
  public void formatClassAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Deprecated");
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
  public void formatImports() {
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
  public void formatClosures() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[ toUpperCase == it ]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
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
    _builder.append("val y = x.filter[ z | z.toUpperCase == z ]");
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
  public void formatClosuresParamMultiLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[ z |");
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
    _builder.append("if(true)");
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
    _builder.append("var x = if(true)");
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
    _builder.append("if(true)");
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
    _builder.append("if(true)");
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
    _builder.append("if(true) {");
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
    _builder.append("if(true)");
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
    _builder.append("if(true) {");
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
  public void formatFor1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i:1 .. 2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatFor2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i:1 .. 2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
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
}
