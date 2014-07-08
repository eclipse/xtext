/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyStateEditorValidationTest extends AbstractXtendUITestCase {
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
      final IMarker[] markers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
      final Procedure1<IMarker> _function = new Procedure1<IMarker>() {
        public void apply(final IMarker it) {
          try {
            Map _attributes = it.getAttributes();
            Collection _values = _attributes.values();
            InputOutput.<Collection>println(_values);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<IMarker>forEach(((Iterable<IMarker>)Conversions.doWrapArray(markers)), _function);
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
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      _document_2.<Object>readOnly(_function_1);
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
      IXtextDocument _document_1 = editor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = DirtyStateEditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          String _string = issues.toString();
          int _length = ((Object[])Conversions.unwrapArray(issues, Object.class)).length;
          Assert.assertEquals(_string, 3, _length);
          return null;
        }
      };
      _document_1.<Object>readOnly(_function);
      IXtextDocument _document_2 = editor.getDocument();
      _document_2.set((contentWithoutBar + bar));
      this._syncUtil.waitForReconciler(editor);
      IXtextDocument _document_3 = editor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      IXtextDocument _document = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      _document.<Object>readOnly(_function);
      IXtextDocument _document_1 = interfaceEditor.getDocument();
      _document_1.set(interfaceChanged);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForDirtyStateUpdater(classEditor);
      IXtextDocument _document_2 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
            public boolean isCanceled() {
              return false;
            }
          };
          final List<Issue> issues = DirtyStateEditorValidationTest.this.validator.validate(it, CheckMode.NORMAL_AND_FAST, _function);
          int _size = issues.size();
          Assert.assertEquals(1, _size);
          return null;
        }
      };
      _document_2.<Object>readOnly(_function_1);
      IXtextDocument _document_3 = interfaceEditor.getDocument();
      _document_3.set(interface_);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForDirtyStateUpdater(classEditor);
      IXtextDocument _document_4 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_2 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      _document_4.<Object>readOnly(_function_2);
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
      IXtextDocument _document = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      _document.<Object>readOnly(_function);
      IXtextDocument _document_1 = interfaceEditor.getDocument();
      _document_1.set(interfaceChanged);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForDirtyStateUpdater(classEditor);
      IXtextDocument _document_2 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_1 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      _document_2.<Object>readOnly(_function_1);
      IXtextDocument _document_3 = interfaceEditor.getDocument();
      _document_3.set(interface_);
      this._syncUtil.waitForReconciler(interfaceEditor);
      this._syncUtil.waitForDirtyStateUpdater(classEditor);
      IXtextDocument _document_4 = classEditor.getDocument();
      final IUnitOfWork<Object, XtextResource> _function_2 = new IUnitOfWork<Object, XtextResource>() {
        public Object exec(final XtextResource it) throws Exception {
          final CancelIndicator _function = new CancelIndicator() {
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
      _document_4.<Object>readOnly(_function_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
