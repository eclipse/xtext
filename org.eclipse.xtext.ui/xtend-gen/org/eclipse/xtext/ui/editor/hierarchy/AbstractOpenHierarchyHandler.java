/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractHierarchyViewPart;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public abstract class AbstractOpenHierarchyHandler extends AbstractHandler {
  @Inject
  @Extension
  private EObjectAtOffsetHelper _eObjectAtOffsetHelper;
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
      Object _xifexpression = null;
      if ((editor != null)) {
        Object _xblockexpression_1 = null;
        {
          final ISelection selection = editor.getSelectionProvider().getSelection();
          Object _xifexpression_1 = null;
          if ((selection instanceof ITextSelection)) {
            Object _xblockexpression_2 = null;
            {
              final IWorkbenchWindow workbenchWindow = editor.getSite().getWorkbenchWindow();
              final IUnitOfWork<Object, XtextResource> _function = (XtextResource it) -> {
                Object _xblockexpression_3 = null;
                {
                  this.openHierarchy(this._eObjectAtOffsetHelper.resolveElementAt(it, ((ITextSelection)selection).getOffset()), workbenchWindow);
                  _xblockexpression_3 = null;
                }
                return _xblockexpression_3;
              };
              _xblockexpression_2 = editor.getDocument().<Object>priorityReadOnly(_function);
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected void openHierarchy(final EObject target, final IWorkbenchWindow workbenchWindow) {
    try {
      final IViewPart viewPart = workbenchWindow.getActivePage().showView(this.getHierarchyViewPartID());
      if ((viewPart instanceof AbstractHierarchyViewPart)) {
        ((AbstractHierarchyViewPart)viewPart).setBuilder(this.createHierarchyBuilder(target));
        ((AbstractHierarchyViewPart)viewPart).setRootURI(EcoreUtil2.getPlatformResourceOrNormalizedURI(target));
        ((AbstractHierarchyViewPart)viewPart).refresh(null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract String getHierarchyViewPartID();
  
  protected abstract IHierarchyBuilder createHierarchyBuilder(final EObject target);
}
