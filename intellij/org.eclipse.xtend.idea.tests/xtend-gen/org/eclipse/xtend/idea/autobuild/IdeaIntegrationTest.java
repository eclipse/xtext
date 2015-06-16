/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.autobuild;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.ComparisonFailure;

@SuppressWarnings("all")
public class IdeaIntegrationTest extends LightXtendTest {
  public void testJavaChangeTriggersError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package otherPackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import mypackage.Bar");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void callToBar(Bar bar) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar.doStuff()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("otherPackage/Foo.xtend", _builder.toString());
    try {
      VirtualFile _virtualFile = xtendFile.getVirtualFile();
      this.myFixture.testHighlighting(true, true, true, _virtualFile);
      TestCase.fail("expecting errors");
    } catch (final Throwable _t) {
      if (_t instanceof ComparisonFailure) {
        final ComparisonFailure e = (ComparisonFailure)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void doStuff() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("myPackage/Bar.java", _builder_1.toString());
    VirtualFile _virtualFile_1 = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile_1);
  }
  
  public void testCyclicResolution() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void callToFoo(Foo foo) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo.callToBar(this);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(Bar bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.callToFoo(this)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testCyclicResolution2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar extends Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void someMethod() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(Bar bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.someMethod");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testCyclicResolution3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar extends Foo<? extends Bar> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void someMethod() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo<T extends Bar> {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(T bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.someMethod");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
  
  public void testCyclicResolution4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar extends Foo<Bar> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void someMethod(Bar b) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo<T extends Bar> {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void callToBar(T bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.someMethod(bar)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiFile xtendFile = this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder_1.toString());
    VirtualFile _virtualFile = xtendFile.getVirtualFile();
    this.myFixture.testHighlighting(true, true, true, _virtualFile);
  }
}
