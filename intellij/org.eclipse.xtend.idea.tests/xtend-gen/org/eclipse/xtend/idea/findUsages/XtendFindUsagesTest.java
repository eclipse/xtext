/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.findUsages;

import com.google.common.base.Objects;
import com.intellij.find.FindManager;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesManager;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.find.impl.FindManagerImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.CommonProcessors;
import java.util.Collection;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFindUsagesTest extends LightXtendTest {
  public void testGeneratedElements_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final PsiNamedElement element = this.getNamedElementAt(file, "MyClass");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiClass:MyClass");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(element, _builder_1.toString());
  }
  
  public void testGeneratedElements_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyClass2 extends MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("mypackage/MyClass2.xtend", _builder_1.toString());
    final PsiNamedElement element = this.getNamedElementAt(file, "MyClass");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("primaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("MyClass (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/mypackage/MyClass2.xtend");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 42");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("secondaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("PsiClass:MyClass {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 37");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 102");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.testFindUsages(element, _builder_2.toString());
  }
  
  public void testGeneratedElements_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 304");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiMethod:setX");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiParameter:x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 308");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testGeneratedElements_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile file = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    PsiNamedElement _namedElementAt = this.getNamedElementAt(file, "int y");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("y (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/mypackage/MyClass.xtend");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 128");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:y {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 251");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 364");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 417");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiMethod:getY");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiMethod:setY");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiParameter:y {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 421");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testOriginalElements_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    final PsiNamedElement element = this.getNamedElementAt(generatedSource, "MyClass");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiClass:MyClass");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(element, _builder_1.toString());
  }
  
  public void testOriginalElements_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class MyClass2 extends MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.myFixture.addFileToProject("mypackage/MyClass2.xtend", _builder_1.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    final PsiNamedElement element = this.getNamedElementAt(generatedSource, "MyClass");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("primaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("PsiClass:MyClass {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 37");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("mypackage.MyClass (class com.intellij.psi.impl.source.PsiJavaCodeReferenceElementImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass2.java");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 102");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("secondaryElements {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Type_XtendClassAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("MyClass (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("virtualFile : temp:///src/mypackage/MyClass2.xtend");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("navigationOffset : 42");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.testFindUsages(element, _builder_2.toString());
  }
  
  public void testOriginalElements_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int x");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:x {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.x (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 304");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE)");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  public void testOriginalElements_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Accessors class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getX() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final PsiFile sourceFile = this.myFixture.addFileToProject("mypackage/MyClass.xtend", _builder.toString());
    final Function1<VirtualFile, Boolean> _function = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        String _extension = it.getExtension();
        return Boolean.valueOf(Objects.equal(_extension, "java"));
      }
    };
    Iterable<PsiFile> _generatedSources = this.getGeneratedSources(sourceFile, _function);
    final PsiFile generatedSource = IterableExtensions.<PsiFile>head(_generatedSources);
    PsiNamedElement _namedElementAt = this.getNamedElementAt(generatedSource, "int y");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("primaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("PsiField:y {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 251");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 364");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("this.y (class com.intellij.psi.impl.source.tree.java.PsiReferenceExpressionImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/xtend-gen/mypackage/MyClass.java");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 417");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("secondaryElements {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(Member_XtendFieldAnnotationInfoAction_2_0_0_ELEMENT_TYPE) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("y (class org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("virtualFile : temp:///src/mypackage/MyClass.xtend");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("navigationOffset : 128");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.testFindUsages(_namedElementAt, _builder_1.toString());
  }
  
  protected PsiNamedElement getNamedElementAt(final PsiFile file, final String substring) {
    PsiNamedElement _xblockexpression = null;
    {
      String _text = file.getText();
      final int offset = _text.indexOf(substring);
      PsiElement _findElementAt = file.findElementAt(offset);
      _xblockexpression = PsiTreeUtil.<PsiNamedElement>getParentOfType(_findElementAt, PsiNamedElement.class, false);
    }
    return _xblockexpression;
  }
  
  protected void testHighlightUsages(final PsiElement element, final String expectation) {
    FindUsagesHandler _highlightUsagesHandler = this.getHighlightUsagesHandler(element);
    String _printUsages = this.printUsages(_highlightUsagesHandler);
    TestCase.assertEquals(expectation, _printUsages);
  }
  
  protected void testFindUsages(final PsiElement element, final String expectation) {
    FindUsagesHandler _findUsagesHandler = this.getFindUsagesHandler(element);
    String _printUsages = this.printUsages(_findUsagesHandler);
    TestCase.assertEquals(expectation, _printUsages);
  }
  
  protected String printUsages(final FindUsagesHandler findUsagesHandler) {
    String _xblockexpression = null;
    {
      final PsiElement[] primaryElements = findUsagesHandler.getPrimaryElements();
      final PsiElement[] secondaryElements = findUsagesHandler.getSecondaryElements();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("primaryElements {");
      _builder.newLine();
      _builder.append("\t");
      String _printUsages = this.printUsages(findUsagesHandler, primaryElements);
      _builder.append(_printUsages, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.append("secondaryElements {");
      _builder.newLine();
      _builder.append("\t");
      String _printUsages_1 = this.printUsages(findUsagesHandler, secondaryElements);
      _builder.append(_printUsages_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  protected String printUsages(final FindUsagesHandler findUsagesHandler, final PsiElement... elements) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final PsiElement element : elements) {
        _builder.append(element, "");
        final Collection<UsageInfo> usages = this.findUsages(findUsagesHandler, element);
        {
          boolean _isEmpty = usages.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            {
              for(final UsageInfo usage : usages) {
                _builder.append("\t");
                _builder.append(usage, "\t");
                _builder.append(" {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("virtualFile : ");
                VirtualFile _virtualFile = usage.getVirtualFile();
                _builder.append(_virtualFile, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("navigationOffset : ");
                int _navigationOffset = usage.getNavigationOffset();
                _builder.append(_navigationOffset, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected Collection<UsageInfo> findUsages(final FindUsagesHandler findUsagesHandler, final PsiElement... elements) {
    Collection<UsageInfo> _xblockexpression = null;
    {
      final CommonProcessors.CollectProcessor<UsageInfo> processor = new CommonProcessors.CollectProcessor<UsageInfo>();
      final FindUsagesOptions options = findUsagesHandler.getFindUsagesOptions(null);
      for (final PsiElement element : elements) {
        findUsagesHandler.processElementUsages(element, processor, options);
      }
      _xblockexpression = processor.getResults();
    }
    return _xblockexpression;
  }
  
  protected FindUsagesHandler getHighlightUsagesHandler(final PsiElement element) {
    FindManagerImpl _findManager = this.getFindManager();
    FindUsagesManager _findUsagesManager = _findManager.getFindUsagesManager();
    return _findUsagesManager.getFindUsagesHandler(element, true);
  }
  
  protected FindUsagesHandler getFindUsagesHandler(final PsiElement element) {
    FindManagerImpl _findManager = this.getFindManager();
    FindUsagesManager _findUsagesManager = _findManager.getFindUsagesManager();
    return _findUsagesManager.getFindUsagesHandler(element, false);
  }
  
  protected FindManagerImpl getFindManager() {
    Project _project = this.myFixture.getProject();
    FindManager _instance = FindManager.getInstance(_project);
    return ((FindManagerImpl) _instance);
  }
}
