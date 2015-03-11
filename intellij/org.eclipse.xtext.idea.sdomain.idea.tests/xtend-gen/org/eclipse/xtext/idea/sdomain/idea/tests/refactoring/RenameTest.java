/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.refactoring;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType;
import org.eclipse.xtext.idea.tests.LightToolingTest;

@SuppressWarnings("all")
public class RenameTest extends LightToolingTest {
  public RenameTest() {
    super(SDomainFileType.INSTANCE);
  }
  
  public void testRenameQualifiedName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.sdomain", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo.Fo<caret>o foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.configureByText("Bar.sdomain", _builder_1.toString());
    this.myFixture.renameElementAtCaret("Foo2");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("entity Bar {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("foo.Foo2 foo");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.myFixture.checkResult(_builder_2.toString());
  }
  
  public void testRenameWithSeveralCandidates() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("import bar.*");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("bar {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("datatype String");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String abc");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("datatype Strin<caret>g2");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.sdomain", _builder.toString());
    this.myFixture.renameElementAtCaret("String");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("foo {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("import bar.*");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("bar {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("datatype String");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("entity Foo {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("String abc");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("datatype String");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.checkResult(_builder_1.toString());
  }
}
