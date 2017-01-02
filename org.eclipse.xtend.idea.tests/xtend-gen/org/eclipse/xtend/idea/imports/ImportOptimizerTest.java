/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.imports;

import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;

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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field XtendLanguage is undefined"
      + "\nThe method or field XImportSectionOptimizer is undefined"
      + "\nThe method or field CommandProcessor is undefined"
      + "\nThe method or field project is undefined"
      + "\nThe method or field ApplicationManager is undefined"
      + "\nThe method or field PsiDocumentManager is undefined"
      + "\nThe method getProject() is undefined"
      + "\nThe method or field Assert is undefined"
      + "\naddFileToProject cannot be resolved"
      + "\nINSTANCE cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\nprocessFile cannot be resolved"
      + "\ninstance cannot be resolved"
      + "\nexecuteCommand cannot be resolved"
      + "\napplication cannot be resolved"
      + "\nrunWriteAction cannot be resolved"
      + "\nrun cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ncommitAllDocuments cannot be resolved"
      + "\nassertEquals cannot be resolved"
      + "\ngetText cannot be resolved");
  }
}
