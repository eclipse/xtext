/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.ArrayList;
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
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
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
  
  private Display display;
  
  @Before
  public void setUpEditor() {
    try {
      URI _createURI = URI.createURI("dummy.testlanguage");
      final IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(_createURI);
      Injector _get = rsp.<Injector>get(Injector.class);
      _get.injectMembers(this);
      final IFile file = IResourcesSetupUtil.createFile("test/foo.testlanguage", "stuff foo");
      XtextEditor _openEditor = this.openEditor(file);
      this.editor = _openEditor;
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
      ArrayList<IResourceDescription.Event> _newArrayList = CollectionLiterals.<IResourceDescription.Event>newArrayList();
      this.events = _newArrayList;
      DirtyStateEditorSupport _dirtyStateEditorSupport = this.editor.getDirtyStateEditorSupport();
      IDirtyStateManager _dirtyStateManager = _dirtyStateEditorSupport.getDirtyStateManager();
      final IResourceDescription.Event.Listener _function = new IResourceDescription.Event.Listener() {
        @Override
        public void descriptionsChanged(final IResourceDescription.Event it) {
          DirtyStateEditorSupportIntegrationTest.this.events.add(it);
        }
      };
      _dirtyStateManager.addListener(_function);
      IWorkbenchPartSite _site = this.editor.getSite();
      Shell _shell = _site.getShell();
      Display _display = _shell.getDisplay();
      this.display = _display;
      ISourceViewer _internalSourceViewer = this.editor.getInternalSourceViewer();
      final StyledText styledText = _internalSourceViewer.getTextWidget();
      styledText.setCaretOffset(9);
      styledText.setFocus();
      this.syncUtil.waitForReconciler(this.editor);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_1);
      boolean _isEmpty = this.events.isEmpty();
      Assert.assertTrue(_isEmpty);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=488380
   */
  @Test
  public void testSaveAndEdit() {
    Event _event = new Event();
    final Procedure1<Event> _function = new Procedure1<Event>() {
      @Override
      public void apply(final Event it) {
        char[] _charArray = "b".toCharArray();
        Character _head = IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(_charArray)));
        it.character = (_head).charValue();
        it.type = SWT.KeyDown;
      }
    };
    Event _doubleArrow = ObjectExtensions.<Event>operator_doubleArrow(_event, _function);
    this.display.post(_doubleArrow);
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
    this.syncUtil.waitForReconciler(this.editor);
    int _size = this.events.size();
    Assert.assertEquals(1, _size);
    IResourceDescription.Event _last = IterableExtensions.<IResourceDescription.Event>last(this.events);
    ImmutableList<IResourceDescription.Delta> _deltas = _last.getDeltas();
    IResourceDescription.Delta _head = IterableExtensions.<IResourceDescription.Delta>head(_deltas);
    IResourceDescription _new = _head.getNew();
    Iterable<IEObjectDescription> _exportedObjects = _new.getExportedObjects();
    IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
    QualifiedName _qualifiedName = _head_1.getQualifiedName();
    List<String> _segments = _qualifiedName.getSegments();
    String _last_1 = IterableExtensions.<String>last(_segments);
    Assert.assertEquals("foob", _last_1);
    NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
    this.editor.doSave(_nullProgressMonitor_1);
    NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_2);
    int _size_1 = this.events.size();
    Assert.assertEquals(2, _size_1);
    IResourceDescription.Event _last_2 = IterableExtensions.<IResourceDescription.Event>last(this.events);
    ImmutableList<IResourceDescription.Delta> _deltas_1 = _last_2.getDeltas();
    IResourceDescription.Delta _head_2 = IterableExtensions.<IResourceDescription.Delta>head(_deltas_1);
    IResourceDescription _new_1 = _head_2.getNew();
    Assert.assertNull(_new_1);
    Event _event_1 = new Event();
    final Procedure1<Event> _function_1 = new Procedure1<Event>() {
      @Override
      public void apply(final Event it) {
        it.keyCode = SWT.BS;
        it.type = SWT.KeyDown;
      }
    };
    Event _doubleArrow_1 = ObjectExtensions.<Event>operator_doubleArrow(_event_1, _function_1);
    this.display.post(_doubleArrow_1);
    NullProgressMonitor _nullProgressMonitor_3 = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_3);
    this.syncUtil.waitForReconciler(this.editor);
    int _size_2 = this.events.size();
    Assert.assertEquals(3, _size_2);
    IResourceDescription.Event _last_3 = IterableExtensions.<IResourceDescription.Event>last(this.events);
    ImmutableList<IResourceDescription.Delta> _deltas_2 = _last_3.getDeltas();
    IResourceDescription.Delta _head_3 = IterableExtensions.<IResourceDescription.Delta>head(_deltas_2);
    IResourceDescription _new_2 = _head_3.getNew();
    Iterable<IEObjectDescription> _exportedObjects_1 = _new_2.getExportedObjects();
    IEObjectDescription _head_4 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
    QualifiedName _qualifiedName_1 = _head_4.getQualifiedName();
    List<String> _segments_1 = _qualifiedName_1.getSegments();
    String _last_4 = IterableExtensions.<String>last(_segments_1);
    Assert.assertEquals("foo", _last_4);
  }
  
  /**
   * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=354123
   */
  @Test
  public void testUndoRedo() {
    Event _event = new Event();
    final Procedure1<Event> _function = new Procedure1<Event>() {
      @Override
      public void apply(final Event it) {
        char[] _charArray = "b".toCharArray();
        Character _head = IterableExtensions.<Character>head(((Iterable<Character>)Conversions.doWrapArray(_charArray)));
        it.character = (_head).charValue();
        it.type = SWT.KeyDown;
      }
    };
    Event _doubleArrow = ObjectExtensions.<Event>operator_doubleArrow(_event, _function);
    this.display.post(_doubleArrow);
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor);
    this.syncUtil.waitForReconciler(this.editor);
    int _size = this.events.size();
    Assert.assertEquals(1, _size);
    IResourceDescription.Event _last = IterableExtensions.<IResourceDescription.Event>last(this.events);
    ImmutableList<IResourceDescription.Delta> _deltas = _last.getDeltas();
    IResourceDescription.Delta _head = IterableExtensions.<IResourceDescription.Delta>head(_deltas);
    IResourceDescription _new = _head.getNew();
    Iterable<IEObjectDescription> _exportedObjects = _new.getExportedObjects();
    IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
    QualifiedName _qualifiedName = _head_1.getQualifiedName();
    List<String> _segments = _qualifiedName.getSegments();
    String _last_1 = IterableExtensions.<String>last(_segments);
    Assert.assertEquals("foob", _last_1);
    ISourceViewer _internalSourceViewer = this.editor.getInternalSourceViewer();
    final IUndoManager undoManager = ((XtextSourceViewer) _internalSourceViewer).getUndoManager();
    undoManager.undo();
    NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_1);
    this.syncUtil.waitForReconciler(this.editor);
    int _size_1 = this.events.size();
    Assert.assertEquals(2, _size_1);
    IResourceDescription.Event _last_2 = IterableExtensions.<IResourceDescription.Event>last(this.events);
    ImmutableList<IResourceDescription.Delta> _deltas_1 = _last_2.getDeltas();
    IResourceDescription.Delta _head_2 = IterableExtensions.<IResourceDescription.Delta>head(_deltas_1);
    IResourceDescription _new_1 = _head_2.getNew();
    Assert.assertNull(_new_1);
    undoManager.redo();
    NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
    this.syncUtil.yieldToQueuedDisplayJobs(_nullProgressMonitor_2);
    this.syncUtil.waitForReconciler(this.editor);
    int _size_2 = this.events.size();
    Assert.assertEquals(3, _size_2);
    IResourceDescription.Event _last_3 = IterableExtensions.<IResourceDescription.Event>last(this.events);
    ImmutableList<IResourceDescription.Delta> _deltas_2 = _last_3.getDeltas();
    IResourceDescription.Delta _head_3 = IterableExtensions.<IResourceDescription.Delta>head(_deltas_2);
    IResourceDescription _new_2 = _head_3.getNew();
    Iterable<IEObjectDescription> _exportedObjects_1 = _new_2.getExportedObjects();
    IEObjectDescription _head_4 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
    QualifiedName _qualifiedName_1 = _head_4.getQualifiedName();
    List<String> _segments_1 = _qualifiedName_1.getSegments();
    String _last_4 = IterableExtensions.<String>last(_segments_1);
    Assert.assertEquals("foob", _last_4);
  }
  
  @Override
  protected String getEditorId() {
    return "org.eclipse.xtext.ui.tests.TestLanguage";
  }
}
