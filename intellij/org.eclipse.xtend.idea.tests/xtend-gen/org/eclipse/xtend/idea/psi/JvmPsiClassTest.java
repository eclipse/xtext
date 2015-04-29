/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.psi;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifier;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiReferenceList;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterList;
import com.intellij.psi.PsiTypeParameterListOwner;
import com.intellij.testFramework.UsefulTestCase;
import junit.framework.TestCase;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.idea.types.psi.LoadingTypeResourcePhase;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmPsiClassTest extends LightXtendTest {
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
  
  public void testResolution() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void someMethod() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package mypackage;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public class Bar extends Foo {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final PsiClass class_ = this.myFixture.addClass(_builder_1.toString());
    final PsiMethod[] methods = class_.findMethodsByName("someMethod", true);
    UsefulTestCase.assertSize(1, methods);
    final PsiMethod method = IterableExtensions.<PsiMethod>head(((Iterable<PsiMethod>)Conversions.doWrapArray(methods)));
    String _name = method.getName();
    TestCase.assertEquals("someMethod", _name);
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    PsiClass _containingClass = method.getContainingClass();
    TestCase.assertEquals(psiClass, _containingClass);
  }
  
  public void testMethodBodyWithErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def methodWithErros() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Bar.blabla");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    PsiMethod[] _methods = psiClass.getMethods();
    UsefulTestCase.assertSize(2, _methods);
    final PsiMethod[] method = psiClass.findMethodsByName("methodWithErros", false);
    TestCase.assertNotNull(method);
  }
  
  public void testStub() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    this.setLoadingTypeResource(psiClass, true);
    String _name = psiClass.getName();
    TestCase.assertEquals("Foo", _name);
    String _qualifiedName = psiClass.getQualifiedName();
    TestCase.assertEquals("mypackage.Foo", _qualifiedName);
    PsiFile _containingFile = psiClass.getContainingFile();
    TestCase.assertNotNull(_containingFile);
    PsiClass _containingClass = psiClass.getContainingClass();
    TestCase.assertNull(_containingClass);
    PsiModifierList _modifierList = psiClass.getModifierList();
    boolean _hasModifierProperty = _modifierList.hasModifierProperty(PsiModifier.PUBLIC);
    TestCase.assertTrue(_hasModifierProperty);
    PsiModifierList _modifierList_1 = psiClass.getModifierList();
    boolean _hasModifierProperty_1 = _modifierList_1.hasModifierProperty(PsiModifier.PACKAGE_LOCAL);
    TestCase.assertFalse(_hasModifierProperty_1);
    PsiModifierList _modifierList_2 = psiClass.getModifierList();
    boolean _hasModifierProperty_2 = _modifierList_2.hasModifierProperty(PsiModifier.PRIVATE);
    TestCase.assertFalse(_hasModifierProperty_2);
    boolean _hasModifierProperty_3 = psiClass.hasModifierProperty(PsiModifier.PUBLIC);
    TestCase.assertTrue(_hasModifierProperty_3);
    boolean _hasModifierProperty_4 = psiClass.hasModifierProperty(PsiModifier.PACKAGE_LOCAL);
    TestCase.assertFalse(_hasModifierProperty_4);
    boolean _hasModifierProperty_5 = psiClass.hasModifierProperty(PsiModifier.PRIVATE);
    TestCase.assertFalse(_hasModifierProperty_5);
    boolean _isInterface = psiClass.isInterface();
    TestCase.assertFalse(_isInterface);
    boolean _isEnum = psiClass.isEnum();
    TestCase.assertFalse(_isEnum);
    boolean _isAnnotationType = psiClass.isAnnotationType();
    TestCase.assertFalse(_isAnnotationType);
  }
  
  public void testStub_Accessability() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("package class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    this.setLoadingTypeResource(psiClass, true);
    PsiModifierList _modifierList = psiClass.getModifierList();
    boolean _hasModifierProperty = _modifierList.hasModifierProperty(PsiModifier.PUBLIC);
    TestCase.assertFalse(_hasModifierProperty);
    PsiModifierList _modifierList_1 = psiClass.getModifierList();
    boolean _hasModifierProperty_1 = _modifierList_1.hasModifierProperty(PsiModifier.PACKAGE_LOCAL);
    TestCase.assertTrue(_hasModifierProperty_1);
    PsiModifierList _modifierList_2 = psiClass.getModifierList();
    boolean _hasModifierProperty_2 = _modifierList_2.hasModifierProperty(PsiModifier.PRIVATE);
    TestCase.assertFalse(_hasModifierProperty_2);
    boolean _hasModifierProperty_3 = psiClass.hasModifierProperty(PsiModifier.PUBLIC);
    TestCase.assertFalse(_hasModifierProperty_3);
    boolean _hasModifierProperty_4 = psiClass.hasModifierProperty(PsiModifier.PACKAGE_LOCAL);
    TestCase.assertTrue(_hasModifierProperty_4);
    boolean _hasModifierProperty_5 = psiClass.hasModifierProperty(PsiModifier.PRIVATE);
    TestCase.assertFalse(_hasModifierProperty_5);
  }
  
  public void testStub_Interface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    this.setLoadingTypeResource(psiClass, true);
    boolean _isInterface = psiClass.isInterface();
    TestCase.assertTrue(_isInterface);
  }
  
  public void testStub_Enum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("enum Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    this.setLoadingTypeResource(psiClass, true);
    boolean _isEnum = psiClass.isEnum();
    TestCase.assertTrue(_isEnum);
  }
  
  public void testStub_Annotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("annotation Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.addFileToProject("mypackage/Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("mypackage.Foo");
    this.setLoadingTypeResource(psiClass, true);
    boolean _isAnnotationType = psiClass.isAnnotationType();
    TestCase.assertTrue(_isAnnotationType);
  }
  
  public void testGetQualifiedName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    String _qualifiedName = psiClass.getQualifiedName();
    TestCase.assertEquals("foo.Foo", _qualifiedName);
    boolean _isInterface = psiClass.isInterface();
    TestCase.assertFalse(_isInterface);
    boolean _isAnnotationType = psiClass.isAnnotationType();
    TestCase.assertFalse(_isAnnotationType);
    boolean _isEnum = psiClass.isEnum();
    TestCase.assertFalse(_isEnum);
    PsiReferenceList _extendsList = psiClass.getExtendsList();
    PsiJavaCodeReferenceElement[] _referenceElements = _extendsList.getReferenceElements();
    PsiJavaCodeReferenceElement _head = IterableExtensions.<PsiJavaCodeReferenceElement>head(((Iterable<PsiJavaCodeReferenceElement>)Conversions.doWrapArray(_referenceElements)));
    String _qualifiedName_1 = _head.getQualifiedName();
    TestCase.assertEquals("java.lang.Object", _qualifiedName_1);
    PsiField[] _fields = psiClass.getFields();
    UsefulTestCase.assertEmpty(_fields);
    boolean _hasTypeParameters = psiClass.hasTypeParameters();
    TestCase.assertFalse(_hasTypeParameters);
    PsiTypeParameterList _typeParameterList = psiClass.getTypeParameterList();
    PsiTypeParameter[] _typeParameters = _typeParameterList.getTypeParameters();
    UsefulTestCase.assertEmpty(_typeParameters);
    PsiTypeParameter[] _typeParameters_1 = psiClass.getTypeParameters();
    UsefulTestCase.assertEmpty(_typeParameters_1);
  }
  
  public void testIsInterface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    boolean _isInterface = psiClass.isInterface();
    TestCase.assertTrue(_isInterface);
  }
  
  public void testIsAnnotationType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("annotation Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    boolean _isAnnotationType = psiClass.isAnnotationType();
    TestCase.assertTrue(_isAnnotationType);
  }
  
  public void testIsEnum() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("enum Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    boolean _isEnum = psiClass.isEnum();
    TestCase.assertTrue(_isEnum);
  }
  
  public void testGetExtendsList() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo extends ArrayList<Object> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    final PsiReferenceList extendsList = psiClass.getExtendsList();
    PsiReferenceList.Role _role = extendsList.getRole();
    TestCase.assertEquals(PsiReferenceList.Role.EXTENDS_LIST, _role);
    PsiJavaCodeReferenceElement[] _referenceElements = extendsList.getReferenceElements();
    UsefulTestCase.assertSize(1, _referenceElements);
    PsiClassType[] _referencedTypes = extendsList.getReferencedTypes();
    UsefulTestCase.assertSize(1, _referencedTypes);
    PsiClassType[] _referencedTypes_1 = extendsList.getReferencedTypes();
    PsiClassType _head = IterableExtensions.<PsiClassType>head(((Iterable<PsiClassType>)Conversions.doWrapArray(_referencedTypes_1)));
    PsiClass _resolve = _head.resolve();
    String _qualifiedName = _resolve.getQualifiedName();
    TestCase.assertEquals("java.util.ArrayList", _qualifiedName);
  }
  
  public void testGetExtendsList2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo extends Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    final PsiReferenceList extendsList = psiClass.getExtendsList();
    PsiReferenceList.Role _role = extendsList.getRole();
    TestCase.assertEquals(PsiReferenceList.Role.EXTENDS_LIST, _role);
    PsiJavaCodeReferenceElement[] _referenceElements = extendsList.getReferenceElements();
    UsefulTestCase.assertSize(1, _referenceElements);
    PsiClassType[] _referencedTypes = extendsList.getReferencedTypes();
    UsefulTestCase.assertSize(1, _referencedTypes);
    PsiClassType[] _referencedTypes_1 = extendsList.getReferencedTypes();
    PsiClassType _head = IterableExtensions.<PsiClassType>head(((Iterable<PsiClassType>)Conversions.doWrapArray(_referencedTypes_1)));
    final PsiClass extendedClass = _head.resolve();
    String _qualifiedName = extendedClass.getQualifiedName();
    TestCase.assertEquals("foo.Bar", _qualifiedName);
  }
  
  public void testGetFields() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    final PsiField[] fields = psiClass.getFields();
    UsefulTestCase.assertSize(1, fields);
    final PsiField field = IterableExtensions.<PsiField>head(((Iterable<PsiField>)Conversions.doWrapArray(fields)));
    TestCase.assertNotNull(field);
    String _name = field.getName();
    TestCase.assertEquals("foo", _name);
  }
  
  public void testGetMethods() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    final PsiMethod[] methods = psiClass.getMethods();
    UsefulTestCase.assertSize(2, methods);
    final PsiMethod method = IterableExtensions.<PsiMethod>last(((Iterable<PsiMethod>)Conversions.doWrapArray(methods)));
    TestCase.assertNotNull(method);
    String _name = method.getName();
    TestCase.assertEquals("m", _name);
    final PsiMethod[] ctrs = psiClass.getConstructors();
    UsefulTestCase.assertSize(1, ctrs);
    Object _head = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(ctrs)));
    Object _head_1 = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(methods)));
    TestCase.assertSame(_head, _head_1);
  }
  
  public void testPsiTypeParameterListOwner() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class Foo<T extends Number> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.myFixture.configureByText("Foo.xtend", _builder.toString());
    final JvmPsiClass psiClass = this.findJvmPsiClass("foo.Foo");
    boolean _hasTypeParameters = psiClass.hasTypeParameters();
    TestCase.assertTrue(_hasTypeParameters);
    final PsiTypeParameter[] typeParameters = psiClass.getTypeParameters();
    UsefulTestCase.assertSize(1, typeParameters);
    final PsiTypeParameter typeParameter = IterableExtensions.<PsiTypeParameter>head(((Iterable<PsiTypeParameter>)Conversions.doWrapArray(typeParameters)));
    int _index = typeParameter.getIndex();
    TestCase.assertEquals(0, _index);
    String _name = typeParameter.getName();
    TestCase.assertEquals("T", _name);
    PsiTypeParameterListOwner _owner = typeParameter.getOwner();
    TestCase.assertEquals(psiClass, _owner);
    final PsiReferenceList extendsList = typeParameter.getExtendsList();
    PsiReferenceList.Role _role = extendsList.getRole();
    TestCase.assertEquals(PsiReferenceList.Role.EXTENDS_BOUNDS_LIST, _role);
    PsiJavaCodeReferenceElement[] _referenceElements = extendsList.getReferenceElements();
    UsefulTestCase.assertSize(1, _referenceElements);
    PsiClassType[] _referencedTypes = extendsList.getReferencedTypes();
    UsefulTestCase.assertSize(1, _referencedTypes);
    PsiClassType[] _referencedTypes_1 = extendsList.getReferencedTypes();
    PsiClassType _head = IterableExtensions.<PsiClassType>head(((Iterable<PsiClassType>)Conversions.doWrapArray(_referencedTypes_1)));
    final PsiClass extendedClass = _head.resolve();
    String _qualifiedName = extendedClass.getQualifiedName();
    TestCase.assertEquals("java.lang.Number", _qualifiedName);
    PsiTypeParameterList _typeParameterList = psiClass.getTypeParameterList();
    PsiTypeParameter[] _typeParameters = _typeParameterList.getTypeParameters();
    UsefulTestCase.assertSize(1, _typeParameters);
    PsiTypeParameterList _typeParameterList_1 = psiClass.getTypeParameterList();
    PsiTypeParameter[] _typeParameters_1 = _typeParameterList_1.getTypeParameters();
    Object _head_1 = IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(_typeParameters_1)));
    TestCase.assertEquals(typeParameter, _head_1);
    PsiTypeParameterList _typeParameterList_2 = psiClass.getTypeParameterList();
    int _typeParameterIndex = _typeParameterList_2.getTypeParameterIndex(typeParameter);
    TestCase.assertEquals(0, _typeParameterIndex);
  }
  
  public void setLoadingTypeResource(final JvmPsiClass c, final boolean b) {
    EObject _jvmElement = JvmPsiElementExtensions.getJvmElement(c);
    LoadingTypeResourcePhase.setLoadingTypeResource(_jvmElement, b);
  }
}
