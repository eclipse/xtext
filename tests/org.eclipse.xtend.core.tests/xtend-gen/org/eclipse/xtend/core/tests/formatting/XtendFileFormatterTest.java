package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFileFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void formatClass11() {
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
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatClass12() {
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
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatClass112() {
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
    _builder.append("int member1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatClass122() {
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
    _builder.append("int member1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_function, _builder);
  }
  
  @Test
  public void formatClass111() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
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
  
  @Test
  public void formatPreferencesExample_02() {
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
    _builder.append("createSetting(catEnum, SettingsData::WidgetType::NUMBER_FIELD,");
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
  
  @Test
  public void formatAssignment_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.i = 5");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatAssignment_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int i");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("C::i = 5");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void typeReferenceIntegration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Foo extends AbstractMap<String, Collection<?>> implements List<String>, Map<String, Collection<?>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String[] field");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String[] methode(String[] param) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val String[] valTypes = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val featureCall1 = <String>newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val featureCall2 = <String, Collection<?>>newHashMap");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val memberFeatureCall1 = featureCall1.<String>toList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val memberFeatureCall2 = featureCall1.<String, Collection<?>>toMap[it]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val constructorCall1 = new ArrayList<String>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val constructorCall2 = new HashMap<String, Collection<?>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val slclosure1 = [Collection<String> x|x]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val slclosure2 = [Collection<String> x, Map<String, Collection<?>> y|x]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val mlclosure1 = [ Collection<String> x |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val mlclosure2 = [ Collection<String> x, Map<String, Collection<?>> y |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
}
