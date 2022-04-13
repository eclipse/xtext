/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.builder;

import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SaveWithReconciliationQueuedBuildDataTest extends AbstractSingleEditorQueuedBuildTest {
  @Override
  public ITextEditor doSave(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    final Function1<ITextEditor, ITextEditor> _function = (ITextEditor it) -> {
      return this._javaEditorExtension.reconcile(it, consumer);
    };
    return this._javaEditorExtension.save(editor, _function);
  }

  @Override
  public ITextEditor doClose(final ITextEditor editor, final Function1<? super ITextEditor, ? extends ITextEditor> consumer) {
    final Function1<ITextEditor, ITextEditor> _function = (ITextEditor it) -> {
      return this._javaEditorExtension.reconcile(it, consumer);
    };
    return this._javaEditorExtension.close(editor, _function);
  }
}
