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
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
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
      this._workbenchTestHelper.closeWelcomePage();
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
      _builder.append("}   ");
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
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("import foo.NoDebuggingCase");
      _builder_1.newLine();
      _builder_1.append("class Bar {                              ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void testCase() {         ");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("var c = new NoDebuggingCase()");
      _builder_1.newLine();
      _builder_1.append("\t                                   ");
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
      IXtextDocument _document = consumer.getDocument();
      _document.replace(0, 1, "p");
      this._syncUtil.waitForDirtyStateUpdater(consumer);
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
      final String replaceModel = _builder_2.toString();
      IXtextDocument _document_1 = editor.getDocument();
      int _length = model.length();
      _document_1.replace(0, _length, replaceModel);
      this._workbenchTestHelper.saveEditor(editor, false);
      this._syncUtil.waitForDirtyStateUpdater(consumer);
      this.assertHasErrors(consumer);
      IXtextDocument _document_2 = editor.getDocument();
      int _length_1 = replaceModel.length();
      _document_2.replace(0, _length_1, model);
      this._workbenchTestHelper.saveEditor(editor, false);
      this._syncUtil.waitForDirtyStateUpdater(consumer);
      this.assertHasNoErrors(consumer);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static long VALIDATION_TIMEOUT = 10000L;
  
  private void assertHasErrors(final XtextEditor editor) {
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
