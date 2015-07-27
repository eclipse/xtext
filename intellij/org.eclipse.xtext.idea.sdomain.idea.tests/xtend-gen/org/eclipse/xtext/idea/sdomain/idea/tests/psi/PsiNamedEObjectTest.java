/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.sdomain.idea.tests.psi;

import com.intellij.codeInsight.TargetElementUtilBase;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.intellij.util.IncorrectOperationException;
import junit.framework.TestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class PsiNamedEObjectTest extends LightCodeInsightFixtureTestCase {
  public void testEntity_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "Foo", "Bar");
  }
  
  public void testEntity_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity \t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Foo");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "Foo", "Bar");
  }
  
  public void testEntity_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "Foo", "Bar");
  }
  
  public void testEntity_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("entity ");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Foo ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */\t\t\t\t{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "Foo", "Bar");
  }
  
  public void testEntity_05() {
    try {
      this.testPsiNamedEObject("entity Foo {}", "Foo", "12");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testEntity_06() {
    try {
      this.testPsiNamedEObject("entity Foo {}", "Foo", "a.b.c");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testEntity_07() {
    try {
      this.testPsiNamedEObject("entity Foo {}", "Foo", "");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testEntity_08() {
    try {
      this.testPsiNamedEObject("entity Foo {}", "Foo", "\t\t");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testEntity_09() {
    this.testPsiNamedEObject("entity Foo {}", "oo", "Foo", "Bar");
  }
  
  public void testEntity_10() {
    this.testPsiNamedEObject("entity Foo {}", "o ", "Foo", "Bar");
  }
  
  public void testEntity_11() {
    this.testPsiNamedEObject("entity Foo {}", " {", "Foo", "Bar");
  }
  
  public void testEntity_12() {
    this.testNotPsiNamedEObject("entity Foo {}", " Foo");
  }
  
  public void testEntity_13() {
    this.testNotPsiNamedEObject("entity Foo {}", "{}");
  }
  
  public void testNamespace_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "a.b.c", "d.e.f");
  }
  
  public void testNamespace_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("a.b.c ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "a.b.c", "d.e.f");
  }
  
  public void testNamespace_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d.e.f {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "d.e.f", "c.b.a");
  }
  
  public void testNamespace_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("d.e.f ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "d.e.f", "c.b.a");
  }
  
  public void testNamespace_05() {
    try {
      this.testPsiNamedEObject("a.b.c {}", "a.b.c", "12");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testNamespace_06() {
    try {
      this.testPsiNamedEObject("a.b.c {}", "a.b.c", "");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testNamespace_07() {
    try {
      this.testPsiNamedEObject("a.b.c {}", "a.b.c", "\t\t");
      TestCase.fail("IncorrectOperationException is expected");
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        Throwable _cause = e.getCause();
        if ((_cause instanceof IncorrectOperationException)) {
        } else {
          throw e;
        }
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void testNamespace_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testNotPsiNamedEObject(_builder, " a");
  }
  
  public void testNamespace_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "a.", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_10() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, ".b", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "b.", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_12() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "./* lalala */c", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_13() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "/* lalala */c", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_14() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "ala */c", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_15() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "c ", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_16() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, " {}", "a.b./* lalala */c", "d.e.f");
  }
  
  public void testNamespace_17() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("a.b./* lalala */c {}");
    _builder.newLine();
    this.testNotPsiNamedEObject(_builder, "{}");
  }
  
  public void testDatatype_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("datatype String");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "String", "Integer");
  }
  
  public void testDatatype_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("datatype ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.newLine();
    _builder.append("String");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "String", "Integer");
  }
  
  public void testDatatype_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("datatype String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "String", "Integer");
  }
  
  public void testDatatype_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a.b.c {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("datatype ");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Hello World!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/* Hello ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("World! */\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.testPsiNamedEObject(_builder, "String", "Integer");
  }
  
  protected void testNotPsiNamedEObject(final CharSequence text, final String textAfterCaret) {
    String _string = text.toString();
    this.testNotPsiNamedEObject(_string, textAfterCaret);
  }
  
  protected void testPsiNamedEObject(final CharSequence text, final String name, final String newName) {
    this.testPsiNamedEObject(text, name, name, newName);
  }
  
  protected void testPsiNamedEObject(final CharSequence text, final String textAfterCaret, final String name, final String newName) {
    String _string = text.toString();
    this.testPsiNamedEObject(_string, textAfterCaret, name, newName);
  }
  
  protected void testNotPsiNamedEObject(final String text, final String textAfterCaret) {
    this.myFixture.configureByText("aaa.sdomain", text);
    final int offset = text.indexOf(textAfterCaret);
    final PsiNamedEObject element = this.findPsiNamedEObject(offset);
    TestCase.assertNull(element);
  }
  
  protected void testPsiNamedEObject(final String text, final String textAfterCaret, final String name, final String newName) {
    this.myFixture.configureByText("aaa.sdomain", text);
    Editor _editor = this.myFixture.getEditor();
    Document _document = _editor.getDocument();
    String _text = _document.getText();
    final int offset = _text.indexOf(textAfterCaret);
    final PsiNamedEObject element = this.findPsiNamedEObject(offset);
    TestCase.assertNotNull(element);
    Editor _editor_1 = this.myFixture.getEditor();
    Document _document_1 = _editor_1.getDocument();
    String _text_1 = _document_1.getText();
    final int nameOffset = _text_1.indexOf(name);
    this.assertPsiNamedEObject(element, name, nameOffset);
    this.myFixture.renameElement(element, newName);
    Editor _editor_2 = this.myFixture.getEditor();
    Document _document_2 = _editor_2.getDocument();
    String _text_2 = _document_2.getText();
    final int newNameOffset = _text_2.indexOf(newName);
    PsiNamedEObject _findPsiNamedEObject = this.findPsiNamedEObject(newNameOffset);
    this.assertPsiNamedEObject(_findPsiNamedEObject, newName, newNameOffset);
  }
  
  protected void assertPsiNamedEObject(final PsiNamedEObject element, final String name, final int nameOffset) {
    TestCase.assertNotNull(element);
    int _textOffset = element.getTextOffset();
    TestCase.assertEquals(nameOffset, _textOffset);
    String _name = element.getName();
    TestCase.assertEquals(name, _name);
    PsiEObjectIdentifier _nameIdentifier = element.getNameIdentifier();
    this.assertPsiEObjectIdentifier(_nameIdentifier, element, name, nameOffset);
  }
  
  protected void assertPsiEObjectIdentifier(final PsiEObjectIdentifier identifier, final PsiNamedEObject element, final String name, final int nameOffset) {
    TestCase.assertNotNull(identifier);
    boolean _isValid = identifier.isValid();
    TestCase.assertTrue(_isValid);
    PsiFile _containingFile = element.getContainingFile();
    PsiFile _containingFile_1 = identifier.getContainingFile();
    TestCase.assertEquals(_containingFile, _containingFile_1);
    PsiElement _parent = identifier.getParent();
    TestCase.assertEquals(element, _parent);
    String _text = identifier.getText();
    TestCase.assertEquals(name, _text);
    TextRange _textRange = identifier.getTextRange();
    int _startOffset = _textRange.getStartOffset();
    TestCase.assertEquals(nameOffset, _startOffset);
    int _length = name.length();
    int _plus = (nameOffset + _length);
    TextRange _textRange_1 = identifier.getTextRange();
    int _endOffset = _textRange_1.getEndOffset();
    TestCase.assertEquals(_plus, _endOffset);
    int _textOffset = identifier.getTextOffset();
    TestCase.assertEquals(nameOffset, _textOffset);
    int _length_1 = name.length();
    int _textLength = identifier.getTextLength();
    TestCase.assertEquals(_length_1, _textLength);
  }
  
  protected PsiNamedEObject findPsiNamedEObject(final int offset) {
    PsiNamedEObject _xblockexpression = null;
    {
      TargetElementUtilBase _instance = TargetElementUtilBase.getInstance();
      Editor _editor = this.myFixture.getEditor();
      final PsiElement targetElement = _instance.findTargetElement(_editor, TargetElementUtilBase.ELEMENT_NAME_ACCEPTED, offset);
      PsiNamedEObject _xifexpression = null;
      if ((targetElement instanceof PsiNamedEObject)) {
        _xifexpression = ((PsiNamedEObject)targetElement);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
