/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.completion;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.eclipse.xtend.core.idea.lang.XtendFileType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.tests.LibraryUtil;
import org.eclipse.xtext.idea.tests.LightToolingTest;

@SuppressWarnings("all")
public class XtendCompletionTest extends LightToolingTest {
  public void testClassKeyword() {
    this.complete("cl<caret>");
    this.assertLookupStrings("class");
  }
  
  public void testExtendsKeyword() {
    this.complete("class Foo ex<caret>");
    this.assertLookupStrings("extends");
  }
  
  public void testEmptyFile() {
    this.complete("");
    this.assertLookupStrings(
      "@", 
      "annotation", 
      "class", 
      "enum", 
      "import", 
      "interface", 
      "package");
  }
  
  public void testMemberFeatureCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.toS<caret>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.complete(_builder.toString());
    this.assertLookupStrings("toString");
  }
  
  public void testFeatureCall() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("toS<caret>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.complete(_builder.toString());
    this.assertLookupStrings("toString");
  }
  
  public XtendCompletionTest() {
    super(XtendFileType.INSTANCE);
  }
  
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
    LibraryUtil.addXbaseLibrary(model);
  }
}
