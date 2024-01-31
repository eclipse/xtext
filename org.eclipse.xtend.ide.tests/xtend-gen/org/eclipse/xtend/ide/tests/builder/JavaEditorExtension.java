/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.inject.Inject;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.junit.Assert;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaEditorExtension {
  private static final Boolean VERBOSE = Boolean.FALSE;

  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  public ITextEditor reconcile(final String fileName, final String oldText, final String newText) {
    return this.reconcile(this.openJavaEditor(fileName), oldText, newText);
  }

  public ITextEditor reconcile(final ITextEditor editor, final String oldText, final String newText) {
    final Function1<ITextEditor, ITextEditor> _function = (ITextEditor it) -> {
      return this.changeContent(it, oldText, newText);
    };
    return this.reconcile(editor, _function);
  }

  public ITextEditor reconcile(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    ITextEditor _xblockexpression = null;
    {
      if ((consumer == null)) {
        return editor;
      }
      final Procedure0 _function = () -> {
        consumer.apply(editor);
      };
      this.waitForPostReconcileEvent(_function);
      _xblockexpression = editor;
    }
    return _xblockexpression;
  }

  public ITextEditor save(final ITextEditor editor) {
    return this.save(editor, null);
  }

  public ITextEditor save(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    ITextEditor _xblockexpression = null;
    {
      final Procedure0 _function = () -> {
        if ((consumer != null)) {
          consumer.apply(editor);
        }
        Assert.assertTrue(this._workbenchTestHelper.saveEditor(editor, false));
      };
      this.waitForPostChangeEvent(_function);
      _xblockexpression = editor;
    }
    return _xblockexpression;
  }

  public ITextEditor close(final ITextEditor editor) {
    return this.close(editor, null);
  }

  public ITextEditor close(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    ITextEditor _xblockexpression = null;
    {
      final Procedure0 _function = () -> {
        if ((consumer != null)) {
          consumer.apply(editor);
        }
        Assert.assertTrue(this._workbenchTestHelper.closeEditor(editor, false));
      };
      this.waitForPostChangeEvent(_function);
      _xblockexpression = editor;
    }
    return _xblockexpression;
  }

  public String waitForPostReconcileEvent(final Procedure0 producer) {
    return this.waitForElementChangedEvent(ElementChangedEvent.POST_RECONCILE, producer);
  }

  public String waitForPostChangeEvent(final Procedure0 producer) {
    return this.waitForElementChangedEvent(ElementChangedEvent.POST_CHANGE, producer);
  }

  public String waitForElementChangedEvent(final int eventMask, final Procedure0 producer) {
    String _xblockexpression = null;
    {
      if ((JavaEditorExtension.VERBOSE).booleanValue()) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("start waiting for an element changed event: ");
        _builder.append(eventMask);
        InputOutput.<String>println(_builder.toString());
      }
      final AtomicBoolean changed = new AtomicBoolean(false);
      final IElementChangedListener _function = new IElementChangedListener() {
        @Override
        public void elementChanged(final ElementChangedEvent it) {
          JavaCore.removeElementChangedListener(this);
          boolean _get = changed.get();
          boolean _not = (!_get);
          if (_not) {
            changed.set(true);
            if ((JavaEditorExtension.VERBOSE).booleanValue()) {
              InputOutput.<ElementChangedEvent>println(it);
            }
          }
        }
      };
      JavaCore.addElementChangedListener(_function, eventMask);
      producer.apply();
      Display display = Display.getCurrent();
      Assert.assertNotNull(display);
      final AtomicBoolean stop = new AtomicBoolean();
      final Runnable _function_1 = () -> {
        stop.set(true);
      };
      display.timerExec(10000, _function_1);
      while (((!changed.get()) && (!stop.get()))) {
        boolean _readAndDispatch = display.readAndDispatch();
        boolean _not = (!_readAndDispatch);
        if (_not) {
          if ((JavaEditorExtension.VERBOSE).booleanValue()) {
            InputOutput.<String>println("Display sleep...");
          }
          display.sleep();
        }
      }
      boolean _get = changed.get();
      boolean _not = (!_get);
      if (_not) {
        throw new AssertionError("No event has been received");
      }
      String _xifexpression = null;
      if ((JavaEditorExtension.VERBOSE).booleanValue()) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("end waiting for an element changed event: ");
        _builder_1.append(eventMask);
        _xifexpression = InputOutput.<String>println(_builder_1.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public ITextEditor openJavaEditor(final String fileName) {
    try {
      return this._workbenchTestHelper.openLikeTextEditor(this._workbenchTestHelper.getFile(fileName));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public ITextEditor changeContent(final ITextEditor editor, final String oldText, final String newText) {
    try {
      ITextEditor _xblockexpression = null;
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
