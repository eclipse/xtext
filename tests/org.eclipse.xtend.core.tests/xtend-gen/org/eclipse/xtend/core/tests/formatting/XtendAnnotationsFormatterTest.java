package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendAnnotationsFormatterTest extends AbstractFormatterTest {
  protected CharSequence toFile(final CharSequence ann) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.lang.annotation.*");
    _builder.newLine();
    _builder.append("import com.google.common.annotations.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append(ann, "");
    _builder.newLineIfNotEmpty();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected void assertFormattedAnnotation(final CharSequence expectation, final CharSequence actual) {
    CharSequence _file = this.toFile(expectation);
    CharSequence _file_1 = this.toFile(actual);
    this.assertFormatted(_file, _file_1);
  }
  
  @Test
  public void formatClassSingleAnnotationSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Deprecated class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package  foo  @Deprecated  class  bar  {  }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClassSingleAnnotationML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package  foo  @Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("class  bar  {  }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClassTwoAnnotationsSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Override @Deprecated class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package  foo  @Override  @Deprecated  class  bar  {  }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClassTwoAnnotationsML1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package  foo  @Override  ");
    _builder_1.newLine();
    _builder_1.append("@Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("class  bar  {  }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatClassTwoAnnotationsML2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Override @Deprecated");
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package  foo  @Override @Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("class  bar  {  }");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void formatConstructorSingleAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Override  ");
    _builder_1.newLine();
    _builder_1.append("@Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("new() {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorTwoAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("new() {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorParameterSingleAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new(@Override @Deprecated String p) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("new(  @Override  @Deprecated  String  p  ) {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatConstructorParameterTwoAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new(@Deprecated String p) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("new(  @Deprecated  String   p  ) {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMethodSingleAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Override  ");
    _builder_1.newLine();
    _builder_1.append("@Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("def foo() {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMethodTwoAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Deprecated  ");
    _builder_1.newLine();
    _builder_1.append("def foo() {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMethodParameterSingleAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def foo(@Override @Deprecated String p) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def foo(  @Override  @Deprecated  String  p  ) {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatMethodParameterTwoAnnotations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("def foo(@Deprecated String p) {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("def foo(  @Deprecated  String   p  ) {  }");
    _builder_1.newLine();
    this.assertFormattedMember(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatAnnotationSingeValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@  SuppressWarnings  (  \"all\"  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Ignore(value = "https://bugs.eclipse.org/bugs/show_bug.cgi?id=393343")
  @Test
  public void formatAnnotationListValue0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings({})");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(  {  }  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Test
  public void formatAnnotationListValue1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings({\"all\"})");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(  {  \"all\"  }  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Test
  public void formatAnnotationListValue2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings({\"all\", \"access\"})");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(  {  \"all\"  ,   \"access\"  }  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Test
  public void formatAnnotationAssignedSingeValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(value=\"all\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(  value  =  \"all\"  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Test
  public void formatAnnotationAssignedListValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(value={\"all\", \"access\"})");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(  value  =  {  \"all\"  ,   \"access\"  }  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Test
  public void formatAnnotationMultiAssignments() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@GwtCompatible(serializable=true, emulated=true)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@GwtCompatible(  serializable  =  true,  emulated  =  true  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Test
  public void formatAnnotationEnumLiteral() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Retention(RetentionPolicy::CLASS)");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Retention(  RetentionPolicy::  CLASS  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
  
  @Ignore(value = "https://bugs.eclipse.org/bugs/show_bug.cgi?id=393349")
  @Test
  public void formatAnnotationStringConcatenation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings((\"all\" + \"more\"))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@  SuppressWarnings  (  (  \"all\"  +  \"more\"  )  )");
    _builder_1.newLine();
    this.assertFormattedAnnotation(_builder, _builder_1);
  }
}
