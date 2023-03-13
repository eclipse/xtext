/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
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

  @Override
  public void tearDown() throws Exception {
    this.workbenchTestHelper.tearDown();
  }

  @Test
  public void testAddXtendLib() {
    try {
      final IJavaProject project = JavaProjectSetupUtil.createJavaProject("testProject");
      final IFile file = IResourcesSetupUtil.createFile("testProject/src/Foo.xtend", "class Foo {}");
      IResourcesSetupUtil.waitForBuild();
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
      IResourcesSetupUtil.waitForBuild();
      final XtextEditor editor = this.workbenchTestHelper.openEditor(file);
      final Procedure0 _function = () -> {
        this.changeContent(editor, "{}", "{ def foo () {} }");
      };
      this.waitForChangeEvent(_function);
      this.assertAddLibsToClasspath(project);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void assertAddLibsToClasspath(final IJavaProject project) {
    final Procedure0 _function = () -> {
      this._xtendLibClasspathAdder.addLibsToClasspath(project, null);
    };
    Assert.assertNotNull(
      this.waitForCoarseGrainedEvent(_function));
  }

  public IResourceDescription.Event waitForCoarseGrainedEvent(final Procedure0 producer) {
    try {
      IResourceDescription.Event _xblockexpression = null;
      {
        final ArrayList<IResourceDescription.Event> event = CollectionLiterals.<IResourceDescription.Event>newArrayList();
        final ArrayList<Boolean> listenToEvent = CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true));
        final IResourceDescription.Event.Listener _function = new IResourceDescription.Event.Listener() {
          @Override
          public void descriptionsChanged(final IResourceDescription.Event e) {
            if (((IterableExtensions.<Boolean>head(listenToEvent)).booleanValue() && (e instanceof IResourceDescription.CoarseGrainedEvent))) {
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
        while (((IterableExtensions.<Boolean>head(listenToEvent)).booleanValue() && (attempt < maxAttempts))) {
          {
            Thread.sleep(50);
            attempt = (attempt + 1);
          }
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
          @Override
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
        while (((IterableExtensions.<Boolean>head(listenToEvent)).booleanValue() && (attempt < maxAttempts))) {
          {
            Thread.sleep(50);
            attempt = (attempt + 1);
          }
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
        final IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
        final String model = document.get();
        document.replace(model.indexOf(oldText), oldText.length(), newText);
        _xblockexpression = editor;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
