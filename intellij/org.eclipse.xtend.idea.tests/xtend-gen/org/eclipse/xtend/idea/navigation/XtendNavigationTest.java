/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.navigation;

import com.google.common.base.Objects;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.DebugUtil;
import junit.framework.TestCase;
import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend.idea.navigation.NavigationTestData;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiAnonymousClass;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiClassImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiMethodImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiParameterImpl;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendNavigationTest extends LightXtendTest {
  public void testNavigateToParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("String name");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("println(na");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("me)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiParameterImpl>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      JvmPsiParameterImpl.class);
  }
  
  public void testNavigateToClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("class Greeter {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("Greeter().sayHello(args.head)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(name)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.newLineIfNotEmpty();
    this.<JvmPsiClassImpl>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      JvmPsiClassImpl.class);
  }
  
  public void testNavigateToClass2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "");
    _builder.append("class Foo {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Bar extends ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "");
    _builder.append("Foo {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClass.class);
  }
  
  public void testNavigateToClass3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("static class Bar {}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("static class Baz extends ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t");
    _builder.append("Bar {}");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiClassImpl>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiClassImpl.class);
  }
  
  public void testNavigateToAnnonymousClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface Greeter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t\t");
    _builder.append("new Greeter() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t\t");
    _builder.append("this.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiAnonymousClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiAnonymousClass.class);
  }
  
  public void testNavigateToAnnonymousClass2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface Greeter {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void sayHello(String name)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Greeter() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t\t");
    _builder.append("new Greeter() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("override sayHello(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t\t\t");
    _builder.append("this.sayHello(name)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.<JvmPsiAnonymousClass>testNavigateTo(
      "mypackage/Foo.xtend", _builder.toString(), 
      JvmPsiAnonymousClass.class);
  }
  
  public void testNavigateToConstructor() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("Greeter(args.head)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("new(String name)");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("println(name)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final JvmPsiMethodImpl psiConstructor = this.<JvmPsiMethodImpl>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      JvmPsiMethodImpl.class);
    boolean _isConstructor = psiConstructor.isConstructor();
    TestCase.assertTrue(_isConstructor);
  }
  
  public void testNavigateToMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package mypackage");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Greeter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String ... args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Greeter().");
    _builder.append(NavigationTestData.REFERENCE_OFFSET, "\t\t");
    _builder.append("sayHello(args.head)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_START_OFFSET, "\t");
    _builder.append("def void sayHello(String name) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("println(name)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.append(NavigationTestData.NAVIGATION_ELEMENT_END_OFFSET, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final JvmPsiMethodImpl psiMethod = this.<JvmPsiMethodImpl>testNavigateTo(
      "mypackage/Greeter.xtend", _builder.toString(), 
      JvmPsiMethodImpl.class);
    boolean _isConstructor = psiMethod.isConstructor();
    TestCase.assertFalse(_isConstructor);
  }
  
  protected <T extends Object> T testNavigateTo(final String relativePath, final String fileText, final Class<T> expectedType) {
    T _xblockexpression = null;
    {
      final NavigationTestData navigationTestData = new NavigationTestData(fileText);
      String _model = navigationTestData.getModel();
      this.openFileInEditor(relativePath, _model);
      int _navigationElementStartOffset = navigationTestData.getNavigationElementStartOffset();
      int _navigationElementEndOffset = navigationTestData.getNavigationElementEndOffset();
      TextRange _textRange = new TextRange(_navigationElementStartOffset, _navigationElementEndOffset);
      final PsiElement navigationElement = this.findNavigationElement(_textRange);
      int _referenceOffset = navigationTestData.getReferenceOffset();
      _xblockexpression = this.<T>assertReference(_referenceOffset, expectedType, navigationElement);
    }
    return _xblockexpression;
  }
  
  protected <T extends Object> T assertReference(final int referenceOffset, final Class<T> expectedType, final PsiElement expectedNavigationElement) {
    T _xblockexpression = null;
    {
      Editor _editor = this.myFixture.getEditor();
      CaretModel _caretModel = _editor.getCaretModel();
      _caretModel.moveToOffset(referenceOffset);
      final PsiElement targetElement = this.myFixture.getElementAtCaret();
      TestCase.assertNotNull(targetElement);
      Class<? extends PsiElement> _class = targetElement.getClass();
      String _plus = (_class + " is not assignable from ");
      String _plus_1 = (_plus + expectedType);
      Class<? extends PsiElement> _class_1 = targetElement.getClass();
      boolean _isAssignableFrom = expectedType.isAssignableFrom(_class_1);
      TestCase.assertTrue(_plus_1, _isAssignableFrom);
      final PsiElement actualNavigationElement = targetElement.getNavigationElement();
      boolean _notEquals = (!Objects.equal(expectedNavigationElement, actualNavigationElement));
      if (_notEquals) {
        PsiFile _file = this.getFile();
        String _psiToString = DebugUtil.psiToString(_file, true, true);
        TestCase.assertEquals(_psiToString, expectedNavigationElement, actualNavigationElement);
      }
      _xblockexpression = ((T) targetElement);
    }
    return _xblockexpression;
  }
  
  protected PsiElement findNavigationElement(final TextRange range) {
    PsiElement _xblockexpression = null;
    {
      PsiFile _file = this.getFile();
      int _startOffset = range.getStartOffset();
      PsiElement element = _file.findElementAt(_startOffset);
      PsiElement _xifexpression = null;
      if ((element instanceof LeafXtextPsiElement)) {
        _xifexpression = ((LeafXtextPsiElement)element).getParent();
      } else {
        _xifexpression = element;
      }
      PsiElement navigationElement = _xifexpression;
      TestCase.assertNotNull(navigationElement);
      Class<? extends PsiElement> _class = navigationElement.getClass();
      String _plus = ("" + _class);
      Class<? extends PsiElement> _class_1 = navigationElement.getClass();
      boolean _isAssignableFrom = PsiEObject.class.isAssignableFrom(_class_1);
      TestCase.assertTrue(_plus, _isAssignableFrom);
      while ((!navigationElement.getTextRange().contains(range))) {
        {
          PsiElement _parent = navigationElement.getParent();
          navigationElement = _parent;
          TestCase.assertNotNull(navigationElement);
        }
      }
      PsiElement _navigationElement = navigationElement.getNavigationElement();
      TestCase.assertEquals(navigationElement, _navigationElement);
      _xblockexpression = navigationElement;
    }
    return _xblockexpression;
  }
  
  protected PsiFile openFileInEditor(final String relativePath, final String fileText) {
    PsiFile _xblockexpression = null;
    {
      final PsiFile xtendFile = this.myFixture.addFileToProject(relativePath, fileText);
      VirtualFile _virtualFile = xtendFile.getVirtualFile();
      this.myFixture.testHighlighting(true, true, true, _virtualFile);
      VirtualFile _virtualFile_1 = xtendFile.getVirtualFile();
      this.myFixture.openFileInEditor(_virtualFile_1);
      _xblockexpression = xtendFile;
    }
    return _xblockexpression;
  }
}
