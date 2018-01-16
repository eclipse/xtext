/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyStateEditorSupportIntegrationTest extends AbstractEditorTest {
  @Inject
  @Extension
  private SyncUtil syncUtil;
  
  private XtextEditor editor;
  
  private List<IResourceDescription.Event> events;
  
  private Display myDisplay;
  
  private StyledText styledText;
  
  @Before
  public void setUpEditor() {
    try {
      final IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI.createURI("dummy.testlanguage"));
      rsp.<Injector>get(Injector.class).injectMembers(this);
      final IFile file = IResourcesSetupUtil.createFile("test/foo.testlanguage", "stuff foo");
      this.editor = this.openEditor(file);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
      this.editor.getSite().getPage().activate(this.editor);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_1);
      this.events = CollectionLiterals.<IResourceDescription.Event>newArrayList();
      final IResourceDescription.Event.Listener _function = (IResourceDescription.Event it) -> {
        this.events.add(it);
      };
      this.editor.getDirtyStateEditorSupport().getDirtyStateManager().addListener(_function);
      this.myDisplay = this.editor.getSite().getShell().getDisplay();
      IterableExtensions.<Shell>head(((Iterable<Shell>)Conversions.doWrapArray(this.myDisplay.getShells()))).forceActive();
      NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_2);
      this.styledText = this.editor.getInternalSourceViewer().getTextWidget();
      this.styledText.setCaretOffset(9);
      this.styledText.setFocus();
      this.syncUtil.waitForReconciler(this.editor);
      NullProgressMonitor _nullProgressMonitor_3 = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_3);
      Thread.sleep(20);
      Assert.assertTrue(this.events.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=488380
   */
  @Test
  public void testSaveAndEdit() {
    this.pushKey((IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray("a".toCharArray())))).charValue(), 0);
    Assert.assertEquals(1, this.events.size());
    Assert.assertEquals("fooa", IterableExtensions.<String>last(IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IResourceDescription.Delta>head(IterableExtensions.<IResourceDescription.Event>last(this.events).getDeltas()).getNew().getExportedObjects()).getQualifiedName().getSegments()));
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.editor.doSave(_nullProgressMonitor);
    NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_1);
    Assert.assertEquals(2, this.events.size());
    Assert.assertNull(IterableExtensions.<IResourceDescription.Delta>head(IterableExtensions.<IResourceDescription.Event>last(this.events).getDeltas()).getNew());
    this.pushKey(((char) 0), SWT.BS);
    Assert.assertEquals(3, this.events.size());
    Assert.assertEquals("foo", IterableExtensions.<String>last(IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IResourceDescription.Delta>head(IterableExtensions.<IResourceDescription.Event>last(this.events).getDeltas()).getNew().getExportedObjects()).getQualifiedName().getSegments()));
  }
  
  /**
   * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=354123
   */
  @Test
  public void testUndoRedo() {
    this.pushKey((IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray("a".toCharArray())))).charValue(), 0);
    Assert.assertEquals(1, this.events.size());
    Assert.assertEquals("fooa", IterableExtensions.<String>last(IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IResourceDescription.Delta>head(IterableExtensions.<IResourceDescription.Event>last(this.events).getDeltas()).getNew().getExportedObjects()).getQualifiedName().getSegments()));
    ISourceViewer _internalSourceViewer = this.editor.getInternalSourceViewer();
    final IUndoManager undoManager = ((XtextSourceViewer) _internalSourceViewer).getUndoManager();
    undoManager.undo();
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
    this.syncUtil.waitForReconciler(this.editor);
    Assert.assertEquals(2, this.events.size());
    Assert.assertNull(IterableExtensions.<IResourceDescription.Delta>head(IterableExtensions.<IResourceDescription.Event>last(this.events).getDeltas()).getNew());
    undoManager.redo();
    NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_1);
    this.syncUtil.waitForReconciler(this.editor);
    Assert.assertEquals(3, this.events.size());
    Assert.assertEquals("fooa", IterableExtensions.<String>last(IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IResourceDescription.Delta>head(IterableExtensions.<IResourceDescription.Event>last(this.events).getDeltas()).getNew().getExportedObjects()).getQualifiedName().getSegments()));
  }
  
  protected void pushKey(final char c, final int k) {
    try {
      final String textBefore = this.editor.getDocument().get();
      Event _event = new Event();
      final Procedure1<Event> _function = (Event it) -> {
        it.type = SWT.KeyDown;
        it.character = c;
        it.keyCode = k;
      };
      final Event event = ObjectExtensions.<Event>operator_doubleArrow(_event, _function);
      this.myDisplay.post(event);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
      Event _event_1 = new Event();
      final Procedure1<Event> _function_1 = (Event it) -> {
        it.type = SWT.KeyUp;
        it.character = c;
        it.keyCode = k;
      };
      final Event event2 = ObjectExtensions.<Event>operator_doubleArrow(_event_1, _function_1);
      this.myDisplay.post(event2);
      int maxTries = 10;
      while ((maxTries-- > 0)) {
        {
          String _get = this.editor.getDocument().get();
          boolean _notEquals = (!Objects.equal(_get, textBefore));
          if (_notEquals) {
            this.syncUtil.waitForReconciler(this.editor);
            return;
          }
          Thread.sleep(10);
          NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
          this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_1);
        }
      }
      Assert.fail("Document didn\'t change on keystroke");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected String getEditorId() {
    return "org.eclipse.xtext.ui.tests.TestLanguage";
  }
}
