/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=493784">https://bugs.eclipse.org/bugs/show_bug.cgi?id=493784</a>
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug493784Test extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper testHelper;
  
  @Inject
  @Extension
  private SyncUtil _syncUtil;
  
  @Test
  public void testNoMemoryLeakOnEditing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class A2 extends A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def test() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}\t\t\t\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String xtendModel = _builder.toString();
      final IFile xtendClass = this.testHelper.createFile("XtendClass.xtend", xtendModel);
      final XtextEditor editor = this.testHelper.openEditor(xtendClass);
      Integer _listenerCount = this.getListenerCount(editor);
      Assert.assertEquals(1, (_listenerCount).intValue());
      this.pressKey(editor, ' ');
      this._syncUtil.waitForReconciler(editor);
      Integer _listenerCount_1 = this.getListenerCount(editor);
      Assert.assertEquals(1, (_listenerCount_1).intValue());
      this.pressKey(editor, ' ');
      this._syncUtil.waitForReconciler(editor);
      Integer _listenerCount_2 = this.getListenerCount(editor);
      Assert.assertEquals(1, (_listenerCount_2).intValue());
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      editor.doSave(_nullProgressMonitor);
      this._syncUtil.waitForReconciler(editor);
      Integer _listenerCount_3 = this.getListenerCount(editor);
      Assert.assertEquals(1, (_listenerCount_3).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Integer getListenerCount(final XtextEditor editor) {
    IXtextDocument _document = editor.getDocument();
    final IUnitOfWork<Integer, XtextResource> _function = (XtextResource it) -> {
      ResourceSet _resourceSet = it.getResourceSet();
      final JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(_resourceSet);
      Class<? extends JvmTypeChangeDispatcher> _class = dispatcher.getClass();
      final Field field = _class.getDeclaredField("listeners");
      field.setAccessible(true);
      Object _get = field.get(dispatcher);
      final Map<Notifier, List<Runnable>> listeners = ((Map<Notifier, List<Runnable>>) _get);
      Set<Map.Entry<Notifier, List<Runnable>>> _entrySet = listeners.entrySet();
      final Function1<Map.Entry<Notifier, List<Runnable>>, Integer> _function_1 = (Map.Entry<Notifier, List<Runnable>> it_1) -> {
        List<Runnable> _value = it_1.getValue();
        int _size = 0;
        if (_value!=null) {
          _size=_value.size();
        }
        return Integer.valueOf(_size);
      };
      Iterable<Integer> _map = IterableExtensions.<Map.Entry<Notifier, List<Runnable>>, Integer>map(_entrySet, _function_1);
      Iterable<Integer> _filterNull = IterableExtensions.<Integer>filterNull(_map);
      final Function2<Integer, Integer, Integer> _function_2 = (Integer p1, Integer p2) -> {
        return Integer.valueOf(((p1).intValue() + (p2).intValue()));
      };
      return IterableExtensions.<Integer>reduce(_filterNull, _function_2);
    };
    return _document.<Integer>readOnly(_function);
  }
  
  private void pressKey(final XtextEditor editor, final char c) throws Exception {
    ISourceViewer _internalSourceViewer = editor.getInternalSourceViewer();
    final StyledText textWidget = _internalSourceViewer.getTextWidget();
    final Event e = new Event();
    e.character = c;
    e.type = SWT.KeyDown;
    e.doit = true;
    if ((c == SWT.ESC)) {
      e.keyCode = 27;
    }
    textWidget.notifyListeners(SWT.KeyDown, e);
  }
}
