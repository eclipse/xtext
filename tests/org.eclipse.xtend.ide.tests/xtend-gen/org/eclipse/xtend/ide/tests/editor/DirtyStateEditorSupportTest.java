/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
import java.util.Set;
import org.apache.log4j.Level;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
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
import org.junit.Before;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyStateEditorSupportTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  @Extension
  private SyncUtil _syncUtil;
  
  @Before
  public void start() {
    try {
      WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME);
      this._workbenchTestHelper.closeWelcomePage();
      IResourcesSetupUtil.reallyWaitForAutoBuild();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void close() {
    try {
      this._workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug464483() {
    try {
      IResourcesSetupUtil.assertNoErrorsInWorkspace();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static class B {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final XtextEditor c1Editor = this._workbenchTestHelper.openEditor("C1.xtend", model);
      this._syncUtil.waitForReconciler(c1Editor);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import A.B");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class C {}");
      _builder_1.newLine();
      final XtextEditor c2Editor = this._workbenchTestHelper.openEditor("C2.xtend", _builder_1.toString());
      this._syncUtil.waitForReconciler(c2Editor);
      this.assertHasNoErrors(c1Editor);
      this.assertHasNoErrors(c2Editor);
      final int staticOffset = model.indexOf("static");
      final Runnable _function = new Runnable() {
        @Override
        public void run() {
          try {
            IXtextDocument _document = c1Editor.getDocument();
            _document.replace(staticOffset, 0, "// ");
            DirtyStateEditorSupportTest.this._syncUtil.waitForReconciler(c1Editor);
            DirtyStateEditorSupportTest.this.assertHasErrors(c2Editor, "A.B cannot be resolved to a type.");
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      LoggingTester.LogCapture _captureLogging = LoggingTester.captureLogging(Level.ERROR, XtextDocument.class, _function);
      _captureLogging.assertNoLogEntries();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnloadJvmTypes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("class NoDebuggingCase {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void call(NoDebuggingAcceptor inner) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(inner) ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("interface NoDebuggingAcceptor {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("def void accept(String typeImport)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("} ");
      _builder.newLine();
      final String model = _builder.toString();
      final XtextEditor editor = this._workbenchTestHelper.openEditor("foo/foo.xtend", model);
      this._syncUtil.waitForReconciler(editor);
      this._syncUtil.waitForBuild(null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("import foo.NoDebuggingCase");
      _builder_1.newLine();
      _builder_1.append("class Bar {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void testCase() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("var c = new NoDebuggingCase()");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("c.call(new NoDebuggingCase.NoDebuggingAcceptor() {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("override accept(String typeImport) {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("})");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final XtextEditor consumer = this._workbenchTestHelper.openEditor("foo/bar.xtend", _builder_1.toString());
      this._syncUtil.waitForReconciler(consumer);
      this._syncUtil.waitForBuild(null);
      this.assertHasNoErrors(consumer);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package foo");
      _builder_2.newLine();
      _builder_2.append("class NoDebuggingCase {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("def void call() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("println() ");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("} ");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      final String replaceModel = _builder_2.toString();
      IXtextDocument _document = editor.getDocument();
      int _length = model.length();
      _document.replace(0, _length, replaceModel);
      this._syncUtil.waitForReconciler(editor);
      this.assertHasErrors(consumer);
      IXtextDocument _document_1 = editor.getDocument();
      int _length_1 = replaceModel.length();
      _document_1.replace(0, _length_1, model);
      this._syncUtil.waitForReconciler(editor);
      this.assertHasNoErrors(consumer);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static long VALIDATION_TIMEOUT = 2000L;
  
  private void assertHasErrors(final XtextEditor editor) {
    this.assertHasErrors(editor, null);
  }
  
  private void assertHasErrors(final XtextEditor editor, final String... messages) {
    final Function0<Boolean> _function = new Function0<Boolean>() {
      @Override
      public Boolean apply() {
        List<Annotation> _errorAnnotations = DirtyStateEditorSupportTest.this.getErrorAnnotations(editor);
        int _size = _errorAnnotations.size();
        return Boolean.valueOf((_size > 0));
      }
    };
    this._workbenchTestHelper.awaitUIUpdate(_function, DirtyStateEditorSupportTest.VALIDATION_TIMEOUT);
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
    boolean _greaterThan = (_size > 0);
    Assert.assertTrue(_join, _greaterThan);
    if ((messages != null)) {
      final Function1<Annotation, String> _function_2 = new Function1<Annotation, String>() {
        @Override
        public String apply(final Annotation it) {
          return it.getText();
        }
      };
      List<String> _map_1 = ListExtensions.<Annotation, String>map(errors, _function_2);
      final Set<String> actualErrors = IterableExtensions.<String>toSet(_map_1);
      final Set<String> expectedErrors = IterableExtensions.<String>toSet(((Iterable<String>)Conversions.doWrapArray(messages)));
      Assert.assertEquals(expectedErrors, actualErrors);
    }
  }
  
  private void assertHasNoErrors(final XtextEditor editor) {
    final Function0<Boolean> _function = new Function0<Boolean>() {
      @Override
      public Boolean apply() {
        List<Annotation> _errorAnnotations = DirtyStateEditorSupportTest.this.getErrorAnnotations(editor);
        int _size = _errorAnnotations.size();
        return Boolean.valueOf((_size == 0));
      }
    };
    this._workbenchTestHelper.awaitUIUpdate(_function, DirtyStateEditorSupportTest.VALIDATION_TIMEOUT);
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
    boolean _equals = (_size == 0);
    Assert.assertTrue(_join, _equals);
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
