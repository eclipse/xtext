/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractHierarchyViewPart;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
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
          ISelectionProvider _selectionProvider = editor.getSelectionProvider();
          final ISelection selection = _selectionProvider.getSelection();
          Object _xifexpression_1 = null;
          if ((selection instanceof ITextSelection)) {
            Object _xblockexpression_2 = null;
            {
              IWorkbenchPartSite _site = editor.getSite();
              final IWorkbenchWindow workbenchWindow = _site.getWorkbenchWindow();
              IXtextDocument _document = editor.getDocument();
              final IUnitOfWork<Object, XtextResource> _function = new IUnitOfWork<Object, XtextResource>() {
                @Override
                public Object exec(final XtextResource it) throws Exception {
                  Object _xblockexpression = null;
                  {
                    int _offset = ((ITextSelection)selection).getOffset();
                    EObject _resolveElementAt = AbstractOpenHierarchyHandler.this._eObjectAtOffsetHelper.resolveElementAt(it, _offset);
                    AbstractOpenHierarchyHandler.this.openHierarchy(_resolveElementAt, workbenchWindow);
                    _xblockexpression = null;
                  }
                  return _xblockexpression;
                }
              };
              _xblockexpression_2 = _document.<Object>priorityReadOnly(_function);
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
      IWorkbenchPage _activePage = workbenchWindow.getActivePage();
      String _hierarchyViewPartID = this.getHierarchyViewPartID();
      final IViewPart viewPart = _activePage.showView(_hierarchyViewPartID);
      if ((viewPart instanceof AbstractHierarchyViewPart)) {
        IHierarchyBuilder _createHierarchyBuilder = this.createHierarchyBuilder(target);
        ((AbstractHierarchyViewPart)viewPart).setBuilder(_createHierarchyBuilder);
        URI _platformResourceOrNormalizedURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(target);
        ((AbstractHierarchyViewPart)viewPart).setRootURI(_platformResourceOrNormalizedURI);
        ((AbstractHierarchyViewPart)viewPart).refresh(null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract String getHierarchyViewPartID();
  
  protected abstract IHierarchyBuilder createHierarchyBuilder(final EObject target);
}
