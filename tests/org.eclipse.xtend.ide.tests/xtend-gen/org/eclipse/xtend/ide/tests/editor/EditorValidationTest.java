/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class EditorValidationTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper helper;
  
  @Inject
  @Extension
  private SyncUtil _syncUtil;
  
  @Inject
  private IResourceValidator validator;
  
  @After
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
      IXtextDocument _document_2 = editor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = EditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _string = issues.toString();
          boolean _isEmpty = issues.isEmpty();
          Assert.assertTrue(_string, _isEmpty);
          return null;
        }
      };
      _document_2.<Object>readOnly(_function);
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
      final IUnitOfWork<Boolean, XtextResource> _function = new IUnitOfWork<Boolean, XtextResource>() {
        public Boolean exec(final XtextResource r) throws Exception {
          EList<Adapter> _eAdapters = r.eAdapters();
          return Boolean.valueOf(_eAdapters.add(new AdapterImpl() {
            public void notifyChanged(final Notification msg) {
              int _featureID = msg.getFeatureID(Resource.class);
              boolean _equals = (_featureID == Resource.RESOURCE__ERRORS);
              if (_equals) {
                int _eventType = msg.getEventType();
                boolean _equals_1 = (_eventType == Notification.ADD);
                if (_equals_1) {
                  InputOutput.println();
                  EList<Resource.Diagnostic> _errors = r.getErrors();
                  int _size = _errors.size();
                  String _plus = ("Error added (" + Integer.valueOf(_size));
                  String _plus_1 = (_plus + " ");
                  Object _newValue = msg.getNewValue();
                  String _plus_2 = (_plus_1 + _newValue);
                  InputOutput.<String>println(_plus_2);
                  Exception _exception = new Exception();
                  _exception.printStackTrace();
                } else {
                  int _eventType_1 = msg.getEventType();
                  boolean _equals_2 = (_eventType_1 == Notification.REMOVE_MANY);
                  if (_equals_2) {
                    Object _oldValue = msg.getOldValue();
                    String _plus_3 = ("Error removed " + _oldValue);
                    InputOutput.<String>println(_plus_3);
                    Exception _exception_1 = new Exception();
                    _exception_1.printStackTrace();
                  }
                }
              }
            }
          }));
        }
      };
      _document.<Boolean>readOnly(_function);
      IXtextDocument _document_1 = editor.getDocument();
      _document_1.set(contentWithoutBar);
      this._syncUtil.waitForReconciler(editor);
      IXtextDocument _document_2 = editor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = EditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _join = IterableExtensions.join(issues, "\n");
          int _length = ((Object[])Conversions.unwrapArray(issues, Object.class)).length;
          Assert.assertEquals(_join, 3, _length);
          return null;
        }
      };
      _document_2.<Object>readOnly(_function_1);
      IXtextDocument _document_3 = editor.getDocument();
      _document_3.set((contentWithoutBar + bar));
      this._syncUtil.waitForReconciler(editor);
      IXtextDocument _document_4 = editor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_2 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = EditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _join = IterableExtensions.join(issues, "\n");
          boolean _isEmpty = issues.isEmpty();
          Assert.assertTrue(_join, _isEmpty);
          return null;
        }
      };
      _document_4.<Object>readOnly(_function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
