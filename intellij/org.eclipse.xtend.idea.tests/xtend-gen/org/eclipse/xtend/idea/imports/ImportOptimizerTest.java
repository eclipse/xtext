/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.imports;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.idea.imports.XImportSectionOptimizer;
import org.junit.Assert;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportOptimizerTest extends LightXtendTest {
  public void testQualifiedNameGestShortened() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<String> myList");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("List<String> myList");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterOptimizeImports(_builder, _builder_1.toString());
  }
  
  public void testSimpleNameClash() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class List {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<String> myList");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class List {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("java.util.List<String> myList");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterOptimizeImports(_builder, _builder_1.toString());
  }
  
  public void testWildcardImportBecomesAbsolute() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("List<String> myList");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("List<String> myList");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterOptimizeImports(_builder, _builder_1.toString());
  }
  
  public void assertAfterOptimizeImports(final CharSequence before, final String expected) {
    String _string = before.toString();
    final PsiFile file = this.myFixture.addFileToProject("MyClass.xtend", _string);
    XImportSectionOptimizer _instance = XtendLanguage.INSTANCE.<XImportSectionOptimizer>getInstance(XImportSectionOptimizer.class);
    final Runnable runnable = _instance.processFile(file);
    CommandProcessor _instance_1 = CommandProcessor.getInstance();
    Project _project = this.getProject();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        Application _application = ApplicationManager.getApplication();
        final Runnable _function = new Runnable() {
          @Override
          public void run() {
            runnable.run();
          }
        };
        _application.runWriteAction(_function);
        Project _project = ImportOptimizerTest.this.getProject();
        PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
        _instance.commitAllDocuments();
      }
    };
    _instance_1.executeCommand(_project, _function, "", "");
    String _string_1 = expected.toString();
    String _text = file.getText();
    Assert.assertEquals(_string_1, _text);
  }
}
