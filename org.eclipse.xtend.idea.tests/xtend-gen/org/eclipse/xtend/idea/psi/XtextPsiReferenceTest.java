/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiEnumConstant;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiReference;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextPsiReferenceTest extends LightXtendTest {
  @Test
  public void testGetTextOffset() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.File");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Main {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val file = new File(\'lalala\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("File(");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement element = reference.getElement();
    final TextRange textRange = element.getTextRange();
    final int textOffset = element.getTextOffset();
    String _plus = (textRange + " ");
    String _plus_1 = (_plus + Integer.valueOf(textOffset));
    boolean _contains = textRange.contains(textOffset);
    TestCase.assertTrue(_plus_1, _contains);
  }
  
  @Test
  public void testDeclaredType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Foo.xtend", model);
    final int index = model.indexOf("String");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    if ((referencedElement instanceof PsiClass)) {
      String _qualifiedName = ((PsiClass)referencedElement).getQualifiedName();
      TestCase.assertEquals("java.lang.String", _qualifiedName);
    } else {
      TestCase.fail(("" + referencedElement));
    }
  }
  
  @Test
  public void testDefaultConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {}");
    _builder.newLine();
    final PsiClass psiClass = this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new Bar");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Foo.xtend", model);
    final int index = model.indexOf("Bar");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    TestCase.assertEquals(psiClass, referencedElement);
  }
  
  @Test
  public void testConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new String(\'lalala\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String model = _builder.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("String");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    if ((referencedElement instanceof PsiMethod)) {
      boolean _isConstructor = ((PsiMethod)referencedElement).isConstructor();
      TestCase.assertTrue(_isConstructor);
      String _name = ((PsiMethod)referencedElement).getName();
      TestCase.assertEquals("String", _name);
    } else {
      TestCase.fail(("" + referencedElement));
    }
  }
  
  @Test
  public void testField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String myField = \"Hello World!\";");
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
    _builder_1.append("\t");
    _builder_1.append("def foo(Bar bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.myField");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("myField");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    if ((referencedElement instanceof PsiField)) {
      String _name = ((PsiField)referencedElement).getName();
      TestCase.assertEquals("myField", _name);
    } else {
      TestCase.fail(("" + referencedElement));
    }
  }
  
  @Test
  public void testEnumLiteral() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("MY_ENUM_LITERAL");
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
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Bar.MY_ENUM_LITERAL");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("MY_ENUM_LITERAL");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    if ((referencedElement instanceof PsiEnumConstant)) {
      String _name = ((PsiEnumConstant)referencedElement).getName();
      TestCase.assertEquals("MY_ENUM_LITERAL", _name);
    } else {
      TestCase.fail(("" + referencedElement));
    }
  }
  
  @Test
  public void testValueOf() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum Bar {}");
    _builder.newLine();
    final PsiClass psiClass = this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Bar.valueOf(\'MY_ENUM_LITERAL\')");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("valueOf");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    TestCase.assertEquals(psiClass, referencedElement);
  }
  
  @Test
  public void testValues() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum Bar {}");
    _builder.newLine();
    final PsiClass psiClass = this.myFixture.addClass(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Bar.values");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("values");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    TestCase.assertEquals(psiClass, referencedElement);
  }
  
  @Test
  public void testMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String myMethod() { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"Hello World!\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder_1.append("\t");
    _builder_1.append("def foo(Bar bar) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar.myMethod");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String model = _builder_1.toString();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/Main.xtend", model);
    final int index = model.indexOf("myMethod");
    final PsiReference reference = file.findReferenceAt(index);
    final PsiElement referencedElement = reference.resolve();
    if ((referencedElement instanceof PsiMethod)) {
      boolean _isConstructor = ((PsiMethod)referencedElement).isConstructor();
      TestCase.assertFalse(_isConstructor);
      String _name = ((PsiMethod)referencedElement).getName();
      TestCase.assertEquals("myMethod", _name);
    } else {
      TestCase.fail(("" + referencedElement));
    }
  }
}
