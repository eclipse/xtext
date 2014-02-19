package org.eclipse.xtext.xbase.tests.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.formatting.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.formatting.AbstractXbaseFormatterTest;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseFormatterTest extends AbstractXbaseFormatterTest {
  public void put(final MapBasedPreferenceValues values, final PreferenceKey key, final Object value) {
    String _id = key.getId();
    String _string = value.toString();
    values.put(_id, _string);
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
    _builder.append("{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = newArrayList(\"A\", \"b\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val y = \'foo\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("x.join");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("  ");
    _builder_1.append("{  ");
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
    _builder_1.append("}");
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
  public void formatClosuresParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter(toUpperCase == it)");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatClosuresParenthesis2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter(foo|foo.toUpperCase == foo)");
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
  public void formatClosuresEmptyParam() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val Iterable<Object> x = [|#[].iterator]");
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
  public void formatIf1SL1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true) println(\"foo\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatIf1SL2() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisSL, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) println(\"foo\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatIf1ML1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatIf1ML2() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
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
  public void formatIfElse3() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
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
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (i : 1 .. 2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatFor3() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (i : 1 .. 2)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatBasicFor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (var i = 1; i < 10; i = i + 1)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for  (  var    i  =   1  ;   i   <   10;   i    =  i    +  1  )  println(i)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBasicFor2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (;;) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for  (      ;     ;      )  {     return     true }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBasicFor3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (val x = 1, val y = 2;;) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return x + y");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for  (    val    x   = 1    ,   val   y     =   2 ;     ;      )  {     return     x  +  y }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBasicFor4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = 1");
    _builder.newLine();
    _builder.append("for (; x < 10;)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(x)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("for  (       ;     x     <    10      ;      )       println(x)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBasicFor5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = 1");
    _builder.newLine();
    _builder.append("for (;; x = x + 1, x = x + 2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(x)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("for  (       ;     ;     x     =      x \t+      1  ,  x  =   x   +    2 )          println(x)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatBasicFor6() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (val x = 1;; x = x + 1, x = x + 2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(x)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("for  (\t\t\tval \t\tx \t\t= \t\t1\t\t;     ;     x     =      x \t+      1  ,  x  =   x   +    2 )          println(x)");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatWhile11() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatWhile12() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatWhile2() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatWhile21() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while (true)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatDoWhile11() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("do");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("while (true)");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatDoWhile12() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("do");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("while(true)");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatDoWhile2() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("do {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("} while (true)");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatDoWhile3() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("do");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("while (true)");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatSwitchSL() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'x\': println(\'x\') case \'y\': println(\'y\') }");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatSwitchSL1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'x\': println(\'x\') case \'y\': println(\'y\') }");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatSwitchDefaultSL() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'y\': println(\'y\') default: println(\'z\') }");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatSwitchDefaultSL1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'y\': println(\'y\') default: println(\'z\') }");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatSwitchCaseSL1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\'");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': println(\'y\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
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
  public void formatSwitchCaseDefaultSL1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\'");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': println(\'y\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default: println(\'z\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatSwitchCaseDefaultSLParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': println(\'y\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default: println(\'z\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch   \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')  default  :    println(\'z\')");
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
  public void formatSwitchDefaultML() {
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
    _builder.append("\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'z\')");
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
    _builder_1.append("println(\'x\')   case   \'y\':    println(\'y\')     default  :    println(\'z\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchDefault2ML() {
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
    _builder.append("\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'z\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\': println(\'x\')   case   \'y\':    println(\'y\')     ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default  :    ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(\'z\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchMLBlock() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
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
    this.assertFormattedExpression(_function, _builder, _builder_1);
  }
  
  @Test
  public void formatSwitchDefaultMLBlock() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
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
    _builder.append("\t");
    _builder.append("default: {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'z\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  { case \'x\': { println(\'x\') }  case   \'y\':  {  println(\'y\') } default: { println(\'z\') } }");
    _builder_1.newLine();
    this.assertFormattedExpression(_function, _builder, _builder_1);
  }
  
  @Test
  public void formatSwitchMLBlock1() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\'");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\':");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\':");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
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
    this.assertFormattedExpression(_function, _builder, _builder_1);
  }
  
  @Test
  public void formatFeatureCallNoParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val v1 = newArrayList");
    _builder.newLine();
    _builder.append("val v2 = newArrayList");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatFeatureCallNoParams() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val v1 = newArrayList()");
    _builder.newLine();
    _builder.append("val v2 = newArrayList()");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatFeatureCall1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4, 5, 6),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4, 5, 6), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
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
  public void formatConstructorCallNoParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val v1 = new ArrayList");
    _builder.newLine();
    _builder.append("val v2 = new ArrayList");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatConstructorCallClosure() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Thread[|println(\"foo\")]");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatConstructorCallNoParams() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val v1 = new ArrayList()");
    _builder.newLine();
    _builder.append("val v2 = new ArrayList()");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatConstructorCall1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4, 5, 6),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4, 5, 6), new ArrayList(5, 6, 7, 8), new ArrayList(9, 10, 11, 12), new ArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorCall2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = new ArrayList(new ArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
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
    _builder.append("new ArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
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
  public void formatMemberFeatureCallNoParenthesis() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val v1 = \"x\".toString");
    _builder.newLine();
    _builder.append("val v2 = \"x\".toString");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatMemberFeatureCallNoParams() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val v1 = \"x\".toString()");
    _builder.newLine();
    _builder.append("val v2 = \"x\".toString()");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
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
    _builder.append("val ML1 = \"x\".substring(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28)");
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
    _builder.append("val ML1 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("16 + 17 + 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 + 26 + 27 + 28 + 29 + 30 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("31 + 32 + 33 + 34 + 35 + 36");
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
    _builder.append("11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 + 19 + 20 + 21 + 22 + 23 + 24 + 25 +");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("26 + 27 + 28 + 29 + 30 + 31 + 32 + 33 + 34 + 35 + 36");
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
  public void formatTryCatchExpression11() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(true));
      }
    };
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
    this.assertFormattedExpression(_function, _builder);
  }
  
  @Test
  public void formatTryCatchExpression12() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.whitespaceBetweenKeywordAndParenthesisML, Boolean.valueOf(false));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("catch(Exception e)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    this.assertFormattedExpression(_function, _builder);
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
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(false));
      }
    };
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
    this.assertFormattedExpression(_function, _builder, _builder_1);
  }
  
  @Test
  public void formatTryCatchFinallyExpression3() {
    final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
      public void apply(final MapBasedPreferenceValues it) {
        XbaseFormatterTest.this.put(it, XbaseFormatterPreferenceKeys.bracesInNewLine, Boolean.valueOf(true));
      }
    };
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"x\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("catch (Exception e)");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"y\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("finally");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"z\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("try  {   println(\"x\")  }   catch   (   Exception   e   )  {  println(\"y\")  } finally  {  println(\"z\")  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_function, _builder, _builder_1);
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
  public void formatListLiteral1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#[12, 13, 14]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#[12,     13  ,\t14\t\t]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatListLiteral3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("12,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("13,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("14");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("#[12,     13  ,\t14\t\t");
    _builder_1.newLine();
    _builder_1.append("]");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatEmptySwitchSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch null { }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch   null    {      }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatEmptySwitchSL_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch null { default: 1 }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch   null    {    default    :  1  }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatEmptySwitchML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch null {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch   null    {      ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatEmptySwitchML_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch null {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default: 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch   null    {      ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("default : 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
}
