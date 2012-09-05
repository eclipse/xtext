package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendRichStringFormatterTest extends AbstractFormatterTest {
  @Test
  public void testSimple() {
    this.assertFormattedExpression(
      "val x = \'\'\'foo\'\'\';", 
      "val  x  =  \'\'\'foo\'\'\' ;");
  }
  
  @Test
  public void testSimpleVar() {
    this.assertFormattedExpression(
      "val x = \'\'\'foo\u00ABnewArrayList()\u00BBbar\'\'\';", 
      "val  x  =  \'\'\'foo\u00AB  newArrayList()  \u00BBbar\'\'\' ;");
  }
  
  @Test
  public void testIndentation1() {
    String _plus = ("val x = \'\'\'\n" + 
      "\tfoo\n");
    String _plus_1 = (_plus + 
      "\'\'\';");
    String _plus_2 = ("val  x  = \'\'\'\n" + 
      "foo\n");
    String _plus_3 = (_plus_2 + 
      "\'\'\' ;");
    this.assertFormattedExpression(_plus_1, _plus_3);
  }
  
  @Test
  public void testIndentation2() {
    String _plus = ("val x = \'\'\'x\n" + 
      "foo\n");
    String _plus_1 = (_plus + 
      "\'\'\';");
    String _plus_2 = ("val  x  = \'\'\'x\n" + 
      "foo\n");
    String _plus_3 = (_plus_2 + 
      "\'\'\' ;");
    this.assertFormattedExpression(_plus_1, _plus_3);
  }
  
  @Test
  public void testIndentation3() {
    String _plus = ("val x = \'\'\'x\n" + 
      "  foo\n");
    String _plus_1 = (_plus + 
      "\'\'\';");
    String _plus_2 = ("val  x  = \'\'\'x\n" + 
      "  foo\n");
    String _plus_3 = (_plus_2 + 
      "  \'\'\' ;");
    this.assertFormattedExpression(_plus_1, _plus_3);
  }
  
  @Test
  public void testIndentation4() {
    String _plus = ("val x = \'\'\'\n" + 
      "  foo\n");
    String _plus_1 = (_plus + 
      "x\'\'\';");
    String _plus_2 = ("val  x  = \'\'\'\n" + 
      "  foo\n");
    String _plus_3 = (_plus_2 + 
      "x\'\'\' ;");
    this.assertFormattedExpression(_plus_1, _plus_3);
  }
  
  @Test
  public void testIndentation5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo");
    _builder.newLine();
    {
      if (true) {
        _builder.append("\t");
        _builder.append("bar");
        _builder.newLine();
      }
    }
    final CharSequence x = _builder;
    String _plus = ("\'\'\'\n" + 
      "\tfoo\n");
    String _plus_1 = (_plus + 
      "\t   \u00ABIF true\u00BB\n");
    String _plus_2 = (_plus_1 + 
      "\t      bar\n");
    String _plus_3 = (_plus_2 + 
      "\t   \u00ABENDIF\u00BB\n");
    String _plus_4 = (_plus_3 + 
      "\'\'\'");
    String _plus_5 = ("\'\'\'\n" + 
      "foo\n");
    String _plus_6 = (_plus_5 + 
      "   \u00ABIF true\u00BB\n");
    String _plus_7 = (_plus_6 + 
      "      bar\n");
    String _plus_8 = (_plus_7 + 
      "   \u00ABENDIF\u00BB\n");
    String _plus_9 = (_plus_8 + 
      "\'\'\'");
    this.assertFormattedExpression(_plus_4, _plus_9);
  }
}
