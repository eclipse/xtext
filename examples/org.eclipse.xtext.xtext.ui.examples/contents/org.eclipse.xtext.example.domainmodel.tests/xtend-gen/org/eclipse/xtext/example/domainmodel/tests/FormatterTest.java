package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.formatter.FormatterTestRequest;
import org.eclipse.xtext.junit4.formatter.FormatterTester;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class FormatterTest {
  @Inject
  @Extension
  private FormatterTester _formatterTester;
  
  /**
   * This example tests if the formatted document equals the unformatted document.
   * This is the most convenient way to test a formatter.
   */
  @Test
  public void example1() {
    final Procedure1<FormatterTestRequest> _function = new Procedure1<FormatterTestRequest>() {
      @Override
      public void apply(final FormatterTestRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("entity Foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("propertyName:String");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("op name() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val x = 1 + 2 + 4");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val foo = {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("println()");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("println()");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("null");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setToBeFormatted(_builder);
      }
    };
    this._formatterTester.assertFormatted(_function);
  }
  
  /**
   * This example tests whether a messy document is being formatted properly.
   * In contrast to the first example, this approach also allows to test formatting strategies that are input-aware.
   * Example: "Change newLines between tokens to be one at minimum, two at maximum."
   * Here, it depends on the formatters input document whether there will be one or two newLines on the output.
   */
  @Test
  public void example2() {
    final Procedure1<FormatterTestRequest> _function = new Procedure1<FormatterTestRequest>() {
      @Override
      public void apply(final FormatterTestRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("entity Foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("op foo():String {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\"xx\"");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setExpectation(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("entity Foo {  op  foo  (  )  :  String  {  \"xx\"  }  }");
        _builder_1.newLine();
        it.setToBeFormatted(_builder_1);
      }
    };
    this._formatterTester.assertFormatted(_function);
  }
  
  /**
   * This example shows how to test property-dependent formatting behavior.
   */
  @Test
  public void example3() {
    final Procedure1<FormatterTestRequest> _function = new Procedure1<FormatterTestRequest>() {
      @Override
      public void apply(final FormatterTestRequest it) {
        final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
          @Override
          public void apply(final MapBasedPreferenceValues it) {
            it.<String>put(FormatterPreferenceKeys.indentation, " ");
          }
        };
        it.preferences(_function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("entity Foo {");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("op foo():String {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"xx\"");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setExpectation(_builder);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("entity Foo {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("op foo():String {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"xx\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it.setToBeFormatted(_builder_1);
      }
    };
    this._formatterTester.assertFormatted(_function);
  }
}
