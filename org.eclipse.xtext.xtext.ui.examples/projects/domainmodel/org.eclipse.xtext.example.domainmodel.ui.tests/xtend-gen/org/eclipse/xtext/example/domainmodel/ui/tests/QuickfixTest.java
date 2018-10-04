package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.ui.tests.DomainmodelUiInjectorProvider;
import org.eclipse.xtext.example.domainmodel.validation.IssueCodes;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class QuickfixTest extends AbstractQuickfixTest {
  @Before
  public void setup() {
    try {
      JavaProjectSetupUtil.createJavaProject(this.getProjectName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void fix_invalid_entity_name() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity blog {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Blog {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Capitalize name", "Capitalize name  of \'blog\'", _builder_1.toString());
    this.testQuickfixesOn(_builder, IssueCodes.INVALID_TYPE_NAME, _quickfix);
  }
  
  @Test
  public void fix_invalid_property_name() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Blog {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Title : String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Blog {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("title : String");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Uncapitalize name", "Uncapitalize name of \'Title\'", _builder_1.toString());
    this.testQuickfixesOn(_builder, IssueCodes.INVALID_FEATURE_NAME, _quickfix);
  }
  
  @Test
  public void fix_invalid_operation_name() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Blog {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("title : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op SetTitle(String title) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Blog {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("title : String");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("op setTitle(String title) {}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Uncapitalize name", "Uncapitalize name of \'SetTitle\'", _builder_1.toString());
    this.testQuickfixesOn(_builder, IssueCodes.INVALID_FEATURE_NAME, _quickfix);
  }
}
