package org.eclipse.xtext.example.domainmodel.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.example.domainmodel.ui.internal.DomainmodelActivator;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.AbstractOutlineTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class OutlineTest extends AbstractOutlineTest {
  @Override
  protected String getEditorId() {
    return DomainmodelActivator.ORG_ECLIPSE_XTEXT_EXAMPLE_DOMAINMODEL_DOMAINMODEL;
  }
  
  @Test
  public void testOutline() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("name : String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op doStuff(String x) : String {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x + \' \' + this.name");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Foo");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("name : String");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("doStuff(String) : String");
      _builder_1.newLine();
      this.assertAllLabels(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOutlineWithPackage() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypackage {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity Foo {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("name : String");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("op doStuff(String x) : String {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return x + \' \' + this.name");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("mypackage");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("Foo");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("name : String");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("doStuff(String) : String");
      _builder_1.newLine();
      this.assertAllLabels(_builder, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
