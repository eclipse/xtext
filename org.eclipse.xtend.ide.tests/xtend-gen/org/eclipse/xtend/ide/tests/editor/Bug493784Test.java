/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
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
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String xtendModel = _builder.toString();
      final IFile xtendClass = this.testHelper.createFile("XtendClass.xtend", xtendModel);
      final XtextEditor editor = this.testHelper.openEditor(xtendClass);
      Assert.assertEquals(1, (this.getListenerCount(editor)).intValue());
      this.pressKey(editor, ' ');
      this._syncUtil.waitForReconciler(editor);
      Assert.assertEquals(1, (this.getListenerCount(editor)).intValue());
      this.pressKey(editor, ' ');
      this._syncUtil.waitForReconciler(editor);
      Assert.assertEquals(1, (this.getListenerCount(editor)).intValue());
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      editor.doSave(_nullProgressMonitor);
      this._syncUtil.waitForReconciler(editor);
      Assert.assertEquals(1, (this.getListenerCount(editor)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private Integer getListenerCount(final XtextEditor editor) {
    final IUnitOfWork<Integer, XtextResource> _function = (XtextResource it) -> {
      final JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(it.getResourceSet());
      final Field field = dispatcher.getClass().getDeclaredField("listeners");
      field.setAccessible(true);
      Object _get = field.get(dispatcher);
      final List<Runnable> listeners = ((List<Runnable>) _get);
      return Integer.valueOf(listeners.size());
    };
    return editor.getDocument().<Integer>readOnly(_function);
  }

  private void pressKey(final XtextEditor editor, final char c) throws Exception {
    final StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
    final Event e = new Event();
    e.character = c;
    e.type = SWT.KeyDown;
    e.doit = true;
    textWidget.notifyListeners(SWT.KeyDown, e);
  }
}
