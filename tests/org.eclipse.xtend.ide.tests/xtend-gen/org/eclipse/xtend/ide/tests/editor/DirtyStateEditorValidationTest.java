/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyStateEditorValidationTest extends AbstractXtendUITestCase {
  private final static long VALIDATION_TIMEOUT = 2000L;
  
  @Inject
  @Extension
  private WorkbenchTestHelper helper;
  
  @Inject
  @Extension
  private SyncUtil _syncUtil;
  
  @Inject
  private IResourceValidator validator;
  
  @After
  @Override
  public void tearDown() {
    try {
      this.helper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=414947
   */
  @Test
  public void testLinkingOfEnum() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static Foo.*");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
      _builder.append("class SomeClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Foo x = A");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("enum Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("A, B, C");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String content = _builder.toString();
      final IFile file = this.helper.createFile("SomeClass.xtend", content);
      this._syncUtil.waitForBuild(null);
      IMarker[] _findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      Assert.assertEquals(0, _length);
      final XtextEditor editor = this.helper.openEditor(file);
      IXtextDocument _document = editor.getDocument();
      _document.set("");
      this._syncUtil.waitForReconciler(editor);
      IXtextDocument _document_1 = editor.getDocument();
      _document_1.set(content);
      this._syncUtil.waitForReconciler(editor);
      this.assertNumberOfErrorAnnotations(editor, 0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug410575() {
    try {
      IProject _createPluginProject = WorkbenchTestHelper.createPluginProject("projectA", "org.eclipse.xtext.xbase.lib", "org.eclipse.xtend.lib");
      final IJavaProject projectA = JavaCore.create(_createPluginProject);
      IProject _project = projectA.getProject();
      WorkbenchTestHelper.addExportedPackages(_project, "mypack");
      IProject _createPluginProject_1 = WorkbenchTestHelper.createPluginProject("projectB", "projectA", "org.eclipse.xtext.xbase.lib");
      JavaCore.create(_createPluginProject_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String myProperty");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IFile declaration = this.helper.createFileImpl("projectA/src/mypack/MyClass.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package otherpack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class OtherClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void myMethod() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("val my = new mypack.MyClass(\"hello\")");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("println(my.getMyProperty())");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IFile file = this.helper.createFileImpl("projectB/src/otherpack/OtherClass.xtend", _builder_1.toString());
      IResourcesSetupUtil.reallyWaitForAutoBuild();
      final IMarker[] markers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = markers.length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        final Function1<IMarker, Object> _function = new Function1<IMarker, Object>() {
          @Override
          public Object apply(final IMarker it) {
            try {
              return it.getAttribute(IMarker.MESSAGE);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        List<Object> _map = ListExtensions.<IMarker, Object>map(((List<IMarker>)Conversions.doWrapArray(markers)), _function);
        String _join = IterableExtensions.join(_map, "\n");
        Assert.fail(_join);
      }
      final XtextEditor editor = this.helper.openEditor(declaration);
      IXtextDocument _document = editor.getDocument();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package mypack");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@Data class MyClass {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("boolean foo");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      _document.set(_builder_2.toString());
      this._syncUtil.waitForReconciler(editor);
      this.assertNumberOfErrorAnnotations(editor, 0);
      final XtextEditor editor2 = this.helper.openEditor(file);
      this._syncUtil.waitForReconciler(editor2);
      this.assertNumberOfErrorAnnotations(editor2, 2);
      IXtextDocument _document_1 = editor2.getDocument();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package otherpack");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("class OtherClass {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("def void myMethod() {");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("val my = new mypack.MyClass(true)");
      _builder_3.newLine();
      _builder_3.append("\t\t");
      _builder_3.append("println(my.isFoo())");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      _document_1.set(_builder_3.toString());
      this._syncUtil.waitForReconciler(editor2);
      this.assertNumberOfErrorAnnotations(editor2, 0);
      IXtextDocument _document_2 = editor2.getDocument();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("package otherpack");
      _builder_4.newLine();
      _builder_4.newLine();
      _builder_4.append("@org.eclipse.xtend.lib.annotations.Data class OtherClass {");
      _builder_4.newLine();
      _builder_4.append("}");
      _builder_4.newLine();
      _document_2.set(_builder_4.toString());
      this._syncUtil.waitForReconciler(editor2);
      this.assertNumberOfErrorAnnotations(editor2, 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=415052
   */
  @Test
  public void testLinkingOfEnum2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static Foo.*");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"all\")");
      _builder.newLine();
      _builder.append("class SomeClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val Foo x = A");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String contentWithoutBar = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("enum Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("A, B, C");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String bar = _builder_1.toString();
      final IFile file = this.helper.createFile("SomeClass.xtend", (contentWithoutBar + bar));
      this._syncUtil.waitForBuild(null);
      IMarker[] _findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      Assert.assertEquals(0, _length);
      final XtextEditor editor = this.helper.openEditor(file);
      IXtextDocument _document = editor.getDocument();
      _document.set(contentWithoutBar);
      this._syncUtil.waitForReconciler(editor);
      this.assertNumberOfErrorAnnotations(editor, 3);
      IXtextDocument _document_1 = editor.getDocument();
      _document_1.set((contentWithoutBar + bar));
      this._syncUtil.waitForReconciler(editor);
      this.assertNumberOfErrorAnnotations(editor, 0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddedInterfaceMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String interface_ = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void bar(String b)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String interfaceChanged = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Bar implements Foo {");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final String class_ = _builder_2.toString();
      final IFile interfaceFile = this.helper.createFile("Foo.xtend", interface_);
      final IFile classFile = this.helper.createFile("Bar.xtend", class_);
      this._syncUtil.waitForBuild(null);
      IMarker[] _findMarkers = classFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      Assert.assertEquals(0, _length);
      final XtextEditor interfaceEditor = this.helper.openEditor(interfaceFile);
      final XtextEditor classEditor = this.helper.openEditor(classFile);
      this.assertNumberOfErrorAnnotations(classEditor, 0);
      IXtextDocument _document = interfaceEditor.getDocument();
      _document.set(interfaceChanged);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForReconciler(classEditor);
      IXtextDocument _document_1 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            @Override
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = DirtyStateEditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _string = issues.toString();
          int _size = issues.size();
          Assert.assertEquals(_string, 1, _size);
          return null;
        }
      };
      _document_1.<Object>readOnly(_function);
      IXtextDocument _document_2 = interfaceEditor.getDocument();
      _document_2.set(interface_);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForReconciler(classEditor);
      IXtextDocument _document_3 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            @Override
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = DirtyStateEditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _string = issues.toString();
          boolean _isEmpty = issues.isEmpty();
          Assert.assertTrue(_string, _isEmpty);
          return null;
        }
      };
      _document_3.<Object>readOnly(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testChangedOverriddenSignature() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String interface_ = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void bar(String b)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String interfaceChanged = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Bar implements Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("override bar() {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final String class_ = _builder_2.toString();
      final IFile interfaceFile = this.helper.createFile("Foo.xtend", interface_);
      final IFile classFile = this.helper.createFile("Bar.xtend", class_);
      this._syncUtil.waitForBuild(null);
      IMarker[] _findMarkers = classFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      Assert.assertEquals(0, _length);
      final XtextEditor interfaceEditor = this.helper.openEditor(interfaceFile);
      final XtextEditor classEditor = this.helper.openEditor(classFile);
      this.assertNumberOfErrorAnnotations(classEditor, 0);
      IXtextDocument _document = interfaceEditor.getDocument();
      _document.set(interfaceChanged);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForReconciler(classEditor);
      IXtextDocument _document_1 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            @Override
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = DirtyStateEditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _string = issues.toString();
          int _size = issues.size();
          Assert.assertEquals(_string, 2, _size);
          return null;
        }
      };
      _document_1.<Object>readOnly(_function);
      IXtextDocument _document_2 = interfaceEditor.getDocument();
      _document_2.set(interface_);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForReconciler(classEditor);
      IXtextDocument _document_3 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        @Override
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            @Override
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = DirtyStateEditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _string = issues.toString();
          boolean _isEmpty = issues.isEmpty();
          Assert.assertTrue(_string, _isEmpty);
          return null;
        }
      };
      _document_3.<Object>readOnly(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidateOnOpen() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String interface_ = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void bar(String b)");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String interfaceChanged = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Bar implements Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("override bar() {}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final String class_ = _builder_2.toString();
      final IFile interfaceFile = this.helper.createFile("Foo.xtend", interface_);
      final IFile classFile = this.helper.createFile("Bar.xtend", class_);
      this._syncUtil.waitForBuild(null);
      IMarker[] _findMarkers = classFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      int _length = _findMarkers.length;
      Assert.assertEquals(0, _length);
      final XtextEditor interfaceEditor = this.helper.openEditor(interfaceFile);
      final XtextEditor classEditor = this.helper.openEditor(classFile);
      this.assertNumberOfErrorAnnotations(classEditor, 0);
      this.helper.closeEditor(classEditor, false);
      IXtextDocument _document = interfaceEditor.getDocument();
      _document.set(interfaceChanged);
      this._syncUtil.waitForReconciler(interfaceEditor);
      final XtextEditor classEditorWithError = this.helper.openEditor(classFile);
      this.assertNumberOfErrorAnnotations(classEditorWithError, 2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertNumberOfErrorAnnotations(final XtextEditor editor, final int expectedNumber) {
    final Function0<Boolean> _function = new Function0<Boolean>() {
      @Override
      public Boolean apply() {
        List<Annotation> _errorAnnotations = DirtyStateEditorValidationTest.this.getErrorAnnotations(editor);
        int _size = _errorAnnotations.size();
        return Boolean.valueOf((_size == expectedNumber));
      }
    };
    this.helper.awaitUIUpdate(_function, DirtyStateEditorValidationTest.VALIDATION_TIMEOUT);
    final List<Annotation> errors = this.getErrorAnnotations(editor);
    final Function1<Annotation, String> _function_1 = new Function1<Annotation, String>() {
      @Override
      public String apply(final Annotation it) {
        String _text = it.getText();
        String _plus = (_text + "(");
        boolean _isPersistent = it.isPersistent();
        String _plus_1 = (_plus + Boolean.valueOf(_isPersistent));
        return (_plus_1 + ")");
      }
    };
    List<String> _map = ListExtensions.<Annotation, String>map(errors, _function_1);
    String _join = IterableExtensions.join(_map, ", ");
    int _size = errors.size();
    Assert.assertEquals(_join, expectedNumber, _size);
  }
  
  private List<Annotation> getErrorAnnotations(final XtextEditor editor) {
    IDocumentProvider _documentProvider = editor.getDocumentProvider();
    IEditorInput _editorInput = editor.getEditorInput();
    IAnnotationModel _annotationModel = _documentProvider.getAnnotationModel(_editorInput);
    Iterator _annotationIterator = _annotationModel.getAnnotationIterator();
    Iterator<Annotation> _filter = Iterators.<Annotation>filter(_annotationIterator, Annotation.class);
    final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
      @Override
      public Boolean apply(final Annotation it) {
        String _type = it.getType();
        return Boolean.valueOf(Objects.equal(_type, "org.eclipse.xtext.ui.editor.error"));
      }
    };
    Iterator<Annotation> _filter_1 = IteratorExtensions.<Annotation>filter(_filter, _function);
    return IteratorExtensions.<Annotation>toList(_filter_1);
  }
}
