/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.jvmmodel;

import com.google.inject.Inject;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import java.util.Set;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class PsiJvmModelAssociationsTests extends LightXtendTest {
  @Inject
  @Extension
  private JvmPsiClasses _jvmPsiClasses;
  
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  public void testAssociations() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void setName(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.configureByText(_builder.toString());
    BaseXtextFile _xtextFile = this.getXtextFile();
    Iterable<PsiClass> _psiClasses = this._jvmPsiClasses.getPsiClasses(_xtextFile);
    final PsiClass psiClass = IterableExtensions.<PsiClass>head(_psiClasses);
    final Set<PsiElement> sourceElements = this._iPsiJvmModelAssociations.getSourceElements(psiClass);
    String _string = sourceElements.toString();
    PsiElement _head = IterableExtensions.<PsiElement>head(sourceElements);
    TestCase.assertNotNull(_string, _head);
    PsiField[] _fields = psiClass.getFields();
    final PsiField psiField = IterableExtensions.<PsiField>head(((Iterable<PsiField>)Conversions.doWrapArray(_fields)));
    Set<PsiElement> _sourceElements = this._iPsiJvmModelAssociations.getSourceElements(psiField);
    PsiElement _head_1 = IterableExtensions.<PsiElement>head(_sourceElements);
    TestCase.assertNotNull(_head_1);
    PsiMethod[] _methods = psiClass.getMethods();
    final PsiMethod getterMethod = IterableExtensions.<PsiMethod>head(((Iterable<PsiMethod>)Conversions.doWrapArray(_methods)));
    Set<PsiElement> _sourceElements_1 = this._iPsiJvmModelAssociations.getSourceElements(getterMethod);
    PsiElement _head_2 = IterableExtensions.<PsiElement>head(_sourceElements_1);
    TestCase.assertNotNull(_head_2);
    PsiMethod[] _methods_1 = psiClass.getMethods();
    final PsiMethod setterMethod = IterableExtensions.<PsiMethod>last(((Iterable<PsiMethod>)Conversions.doWrapArray(_methods_1)));
    Set<PsiElement> _sourceElements_2 = this._iPsiJvmModelAssociations.getSourceElements(setterMethod);
    PsiElement _head_3 = IterableExtensions.<PsiElement>head(_sourceElements_2);
    TestCase.assertNotNull(_head_3);
    PsiParameterList _parameterList = setterMethod.getParameterList();
    PsiParameter[] _parameters = _parameterList.getParameters();
    final PsiParameter psiParameter = IterableExtensions.<PsiParameter>head(((Iterable<PsiParameter>)Conversions.doWrapArray(_parameters)));
    Set<PsiElement> _sourceElements_3 = this._iPsiJvmModelAssociations.getSourceElements(psiParameter);
    PsiElement _head_4 = IterableExtensions.<PsiElement>head(_sourceElements_3);
    TestCase.assertNotNull(_head_4);
    PsiClass[] _innerClasses = psiClass.getInnerClasses();
    final PsiClass innerClass = IterableExtensions.<PsiClass>head(((Iterable<PsiClass>)Conversions.doWrapArray(_innerClasses)));
    Set<PsiElement> _sourceElements_4 = this._iPsiJvmModelAssociations.getSourceElements(innerClass);
    PsiElement _head_5 = IterableExtensions.<PsiElement>head(_sourceElements_4);
    TestCase.assertNotNull(_head_5);
  }
}
