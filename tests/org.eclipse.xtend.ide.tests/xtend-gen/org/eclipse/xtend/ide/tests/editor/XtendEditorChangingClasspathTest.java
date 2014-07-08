/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendEditorChangingClasspathTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private XtendLibClasspathAdder _xtendLibClasspathAdder;
  
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Inject
  private IStateChangeEventBroker stateChangeEventBroker;
  
  public void tearDown() throws Exception {
    this.workbenchTestHelper.tearDown();
  }
  
  @Test
  public void testAddXtendLib() {
    try {
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final IFile file = IResourcesSetupUtil.createFile("testProject/src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForAutoBuild();
      this.workbenchTestHelper.openEditor(file);
      this.assertAddLibsToClasspath(project);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddXtendLibWithDirtyEditor() {
    try {
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final IFile file = IResourcesSetupUtil.createFile("testProject/src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForAutoBuild();
      final XtextEditor editor = this.workbenchTestHelper.openEditor(file);
      final Procedure0 _function = new Procedure0() {
        public void apply() {
          XtendEditorChangingClasspathTest.this.changeContent(editor, "{}", "{ def foo () {} }");
        }
      };
      this.waitForChangeEvent(_function);
      this.assertAddLibsToClasspath(project);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertAddLibsToClasspath(final IJavaProject project) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        XtendEditorChangingClasspathTest.this._xtendLibClasspathAdder.addLibsToClasspath(project, null);
      }
    };
    IResourceDescription.Event _waitForCoarseGrainedEvent = this.waitForCoarseGrainedEvent(_function);
    Assert.assertNotNull(_waitForCoarseGrainedEvent);
  }
  
  public IResourceDescription.Event waitForCoarseGrainedEvent(final Procedure0 producer) {
    try {
      IResourceDescription.Event _xblockexpression = null;
      {
        final ArrayList<IResourceDescription.Event> event = CollectionLiterals.<IResourceDescription.Event>newArrayList();
        final ArrayList<Boolean> listenToEvent = CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true));
        final IResourceDescription.Event.Listener _function = new IResourceDescription.Event.Listener() {
          public void descriptionsChanged(final IResourceDescription.Event e) {
            boolean _and = false;
            Boolean _head = IterableExtensions.<Boolean>head(listenToEvent);
            if (!(_head).booleanValue()) {
              _and = false;
            } else {
              _and = (e instanceof IResourceDescription.CoarseGrainedEvent);
            }
            if (_and) {
              listenToEvent.set(0, Boolean.valueOf(false));
              event.add(e);
              XtendEditorChangingClasspathTest.this.stateChangeEventBroker.removeListener(this);
            }
          }
        };
        this.stateChangeEventBroker.addListener(_function);
        producer.apply();
        final int maxAttempts = 5;
        int attempt = 0;
        boolean _and = false;
        Boolean _head = IterableExtensions.<Boolean>head(listenToEvent);
        if (!(_head).booleanValue()) {
          _and = false;
        } else {
          _and = (attempt < maxAttempts);
        }
        boolean _while = _and;
        while (_while) {
          {
            Thread.sleep(50);
            attempt = (attempt + 1);
          }
          boolean _and_1 = false;
          Boolean _head_1 = IterableExtensions.<Boolean>head(listenToEvent);
          if (!(_head_1).booleanValue()) {
            _and_1 = false;
          } else {
            _and_1 = (attempt < maxAttempts);
          }
          _while = _and_1;
        }
        _xblockexpression = IterableExtensions.<IResourceDescription.Event>head(event);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IResourceDescription.Event waitForChangeEvent(final Procedure0 producer) {
    try {
      IResourceDescription.Event _xblockexpression = null;
      {
        final ArrayList<IResourceDescription.Event> event = CollectionLiterals.<IResourceDescription.Event>newArrayList();
        final ArrayList<Boolean> listenToEvent = CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true));
        final IResourceDescription.Event.Listener _function = new IResourceDescription.Event.Listener() {
          public void descriptionsChanged(final IResourceDescription.Event e) {
            Boolean _head = IterableExtensions.<Boolean>head(listenToEvent);
            if ((boolean) _head) {
              listenToEvent.set(0, Boolean.valueOf(false));
              event.add(e);
              XtendEditorChangingClasspathTest.this.stateChangeEventBroker.removeListener(this);
            }
          }
        };
        this.stateChangeEventBroker.addListener(_function);
        producer.apply();
        final int maxAttempts = 5;
        int attempt = 0;
        boolean _and = false;
        Boolean _head = IterableExtensions.<Boolean>head(listenToEvent);
        if (!(_head).booleanValue()) {
          _and = false;
        } else {
          _and = (attempt < maxAttempts);
        }
        boolean _while = _and;
        while (_while) {
          {
            Thread.sleep(50);
            attempt = (attempt + 1);
          }
          boolean _and_1 = false;
          Boolean _head_1 = IterableExtensions.<Boolean>head(listenToEvent);
          if (!(_head_1).booleanValue()) {
            _and_1 = false;
          } else {
            _and_1 = (attempt < maxAttempts);
          }
          _while = _and_1;
        }
        _xblockexpression = IterableExtensions.<IResourceDescription.Event>head(event);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XtextEditor changeContent(final XtextEditor editor, final String oldText, final String newText) {
    try {
      XtextEditor _xblockexpression = null;
      {
        IDocumentProvider _documentProvider = editor.getDocumentProvider();
        IEditorInput _editorInput = editor.getEditorInput();
        final IDocument document = _documentProvider.getDocument(_editorInput);
        final String model = document.get();
        int _indexOf = model.indexOf(oldText);
        int _length = oldText.length();
        document.replace(_indexOf, _length, newText);
        _xblockexpression = editor;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
