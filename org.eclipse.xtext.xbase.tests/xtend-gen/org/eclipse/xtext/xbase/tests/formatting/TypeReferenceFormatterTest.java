package org.eclipse.xtext.xbase.tests.formatting;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.formatting.XbaseFormatterTestInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterTestInjectorProvider.class)
@SuppressWarnings("all")
public class TypeReferenceFormatterTest {
  @Inject
  private FormatterTester tester;
  
  private void assertFormattedTypeRef(final Procedure1<? super FormatterTestRequest> test) {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      test.apply(it);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var ");
      CharSequence _toBeFormatted = it.getToBeFormatted();
      _builder.append(_toBeFormatted, "\t");
      _builder.append(" x");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      String _string = _builder.toString();
      String _trim = _string.trim();
      it.setToBeFormatted(_trim);
    };
    this.tester.assertFormatted(_function);
  }
  
  @Test
  public void simple() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("String");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void array1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("String[]");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void array2() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("String[][]");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void function0() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("=>void");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void function1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("()=>void");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void function2() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("(String)=>String");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void function3() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("(Collection<?>)=>Collection<?>");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void function4() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("(Collection<? extends String>)=>Collection<? extends String>");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void function5() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("(String, String)=>String");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void parameters1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("Collection<String>");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void parameters2() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("Map<String, String>");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void parametersNested() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("Map<Collection<String>, Collection<String>>");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void parametersUpperBound() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("Collection<? extends String>");
    };
    this.assertFormattedTypeRef(_function);
  }
  
  @Test
  public void parametersLowerBound() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      it.setToBeFormatted("Collection<? super String>");
    };
    this.assertFormattedTypeRef(_function);
  }
}
