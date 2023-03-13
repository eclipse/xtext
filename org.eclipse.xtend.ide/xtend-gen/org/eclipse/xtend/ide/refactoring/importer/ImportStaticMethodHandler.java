/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.refactoring.importer;

import com.google.inject.Inject;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportStaticMethodHandler extends AbstractHandler {
  @Inject
  private SyncUtil syncUtil;

  @Inject
  @Extension
  private StaticMethodImporter importer;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    try {
      Object _xblockexpression = null;
      {
        this.syncUtil.totalSync(false);
        final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
        if ((editor != null)) {
          ISelection _selection = editor.getSelectionProvider().getSelection();
          final ITextSelection selection = ((ITextSelection) _selection);
          final IXtextDocument document = editor.getDocument();
          this.importer.importStaticMethod(document, selection);
        }
        _xblockexpression = null;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
