/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.tests;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.validation.IssueCodes;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelUiInjectorProvider.class)
@SuppressWarnings("all")
public class QuickfixTest extends AbstractQuickfixTest {
  @Before
  public void setup() throws Exception {
    JavaProjectSetupUtil.createJavaProject(this.getProjectName());
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
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Capitalize name", "Capitalize name of \'blog\'", _builder_1.toString());
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
    _builder_1.append("}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Uncapitalize name", "Uncapitalize name of \'SetTitle\'", _builder_1.toString());
    this.testQuickfixesOn(_builder, IssueCodes.INVALID_FEATURE_NAME, _quickfix);
  }

  @Test
  public void fix_unused_imports1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Blog {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Blog {}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix(
      "Organize imports", 
      "Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.", _builder_1.toString());
    this.testQuickfixesOn(_builder, org.eclipse.xtext.xbase.validation.IssueCodes.IMPORT_UNUSED, _quickfix);
  }

  @Test
  public void fix_unused_imports2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Blog {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("posts : List<Post>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Post {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("entity Blog {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("posts : List<Post>");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("entity Post {}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix(
      "Organize imports", 
      "Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.", _builder_1.toString());
    this.testQuickfixesOn(_builder, org.eclipse.xtext.xbase.validation.IssueCodes.IMPORT_UNUSED, _quickfix);
  }

  @Test
  public void fix_wildcard_imports() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Blog {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("posts : List<Post>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("entity Post {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("entity Blog {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("posts : List<Post>");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("entity Post {}");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix(
      "Organize imports", 
      "Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.", _builder_1.toString());
    this.testQuickfixesOn(_builder, org.eclipse.xtext.xbase.validation.IssueCodes.IMPORT_WILDCARD_DEPRECATED, _quickfix);
  }
}
