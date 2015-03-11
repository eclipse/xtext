package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class InsertionOffsetTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> parseHelper;
  
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;
  
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Test
  public void testField_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }
  
  @Test
  public void testField_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int y$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }
  
  @Test
  public void testField_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("$new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }
  
  @Test
  public void testField_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkFieldInsertionOffset(_builder);
  }
  
  @Test
  public void testMethod_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkMethodInsertionOffset(_builder);
  }
  
  @Test
  public void testMethod_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkMethodInsertionOffset(_builder);
  }
  
  @Test
  public void testMethod_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkMethodInsertionOffset(_builder);
  }
  
  @Test
  public void testConstructor_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }
  
  @Test
  public void testConstructor_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }
  
  @Test
  public void testConstructor_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("double y$");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {|");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }
  
  @Test
  public void testConstructor_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkConstructorInsertionOffset(_builder);
  }
  
  @Test
  public void testClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("|");
    _builder.newLine();
    _builder.append("}$");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.checkTypeInsertionOffset(_builder);
  }
  
  protected void checkFieldInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      String _replace = modelAsString.replace("$", "");
      final int caretOffset = _replace.indexOf("|");
      String _replace_1 = modelAsString.replace("|", "");
      final int expectedOffset = _replace_1.indexOf("$");
      String _replace_2 = modelAsString.replace("|", "");
      String _replace_3 = _replace_2.replace("$", "");
      XtendFile _parse = this.parseHelper.parse(_replace_3);
      EList<XtendTypeDeclaration> _xtendTypes = _parse.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      int _newFieldInsertOffset = this._insertionOffsets.getNewFieldInsertOffset(caretElement, xtendClass);
      Assert.assertEquals(expectedOffset, _newFieldInsertOffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void checkMethodInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      String _replace = modelAsString.replace("$", "");
      final int caretOffset = _replace.indexOf("|");
      String _replace_1 = modelAsString.replace("|", "");
      final int expectedOffset = _replace_1.indexOf("$");
      String _replace_2 = modelAsString.replace("|", "");
      String _replace_3 = _replace_2.replace("$", "");
      XtendFile _parse = this.parseHelper.parse(_replace_3);
      EList<XtendTypeDeclaration> _xtendTypes = _parse.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      int _newMethodInsertOffset = this._insertionOffsets.getNewMethodInsertOffset(caretElement, xtendClass);
      Assert.assertEquals(expectedOffset, _newMethodInsertOffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void checkConstructorInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      String _replace = modelAsString.replace("$", "");
      final int caretOffset = _replace.indexOf("|");
      String _replace_1 = modelAsString.replace("|", "");
      final int expectedOffset = _replace_1.indexOf("$");
      String _replace_2 = modelAsString.replace("|", "");
      String _replace_3 = _replace_2.replace("$", "");
      XtendFile _parse = this.parseHelper.parse(_replace_3);
      EList<XtendTypeDeclaration> _xtendTypes = _parse.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      int _newConstructorInsertOffset = this._insertionOffsets.getNewConstructorInsertOffset(caretElement, xtendClass);
      Assert.assertEquals(expectedOffset, _newConstructorInsertOffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void checkTypeInsertionOffset(final CharSequence model) {
    try {
      final String modelAsString = model.toString();
      String _replace = modelAsString.replace("$", "");
      final int caretOffset = _replace.indexOf("|");
      String _replace_1 = modelAsString.replace("|", "");
      final int expectedOffset = _replace_1.indexOf("$");
      String _replace_2 = modelAsString.replace("|", "");
      String _replace_3 = _replace_2.replace("$", "");
      XtendFile _parse = this.parseHelper.parse(_replace_3);
      EList<XtendTypeDeclaration> _xtendTypes = _parse.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      final XtendClass xtendClass = ((XtendClass) _head);
      Resource _eResource = xtendClass.eResource();
      final XtextResource xtextResource = ((XtextResource) _eResource);
      final EObject caretElement = this._eObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, caretOffset);
      int _newTypeInsertOffset = this._insertionOffsets.getNewTypeInsertOffset(caretElement, xtendClass);
      Assert.assertEquals(expectedOffset, _newTypeInsertOffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
