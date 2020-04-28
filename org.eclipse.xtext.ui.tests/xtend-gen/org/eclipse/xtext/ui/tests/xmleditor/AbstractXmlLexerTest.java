package org.eclipse.xtext.ui.tests.xmleditor;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.tests.xmleditor.AbstractLexerTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

@SuppressWarnings("all")
public abstract class AbstractXmlLexerTest extends AbstractLexerTest {
  @Rule
  public final Timeout timeout = Timeout.seconds(2);
  
  @Test
  public void test001() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _builder_1 = new StringConcatenation();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test002() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test003() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"\"/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test004() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\"/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"c\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test005() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\'/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'c\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test006() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\" d=\'e\'/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"c\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'e\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test007() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\' d=\"e\"/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'c\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"e\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test008() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a></a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test009() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\"></a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"c\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test010() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\'></a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'c\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test011() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\' d=\"e\"></a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'c\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"e\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test012() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\" d=\'e\'></a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"c\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'e\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test013() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>text</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'text\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test014() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\">text</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"c\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'text\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test015() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>text</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'text\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test016() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b/>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test017() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<d e=\"f\"/>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"c\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'e\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\"f\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test018() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>c</b>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<d>e</d>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<f/>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'c\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'e\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'f\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test019() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<c/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<d>e</d>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'c\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'e\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test020() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<c>d</c>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<d/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'c\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'c\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test021() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<c>d</c>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<d e=\'f\'/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<g>h</g>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'c\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'c\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'d\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'e\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_STRING \'\'f\'\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'g\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'h\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'g\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    _builder_1.append("RULE_PCDATA \'");
    _builder_1.newLine();
    _builder_1.append("\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_END_OPEN \'</\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_CLOSE \'>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
  
  @Test
  public void test022() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("0 \'\"\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
}
