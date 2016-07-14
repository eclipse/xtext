/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.google.inject.Inject;
import com.intellij.openapi.editor.Editor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.idea.structureview.XtendFileTreeModel;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileJvmTreeModel extends XtendFileTreeModel {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  public XtendFileJvmTreeModel(final BaseXtextFile xtextFile, final Editor editor) {
    super(xtextFile, editor);
  }
  
  @Override
  public Object getCurrentEditorElement() {
    Object _xblockexpression = null;
    {
      final Object element = this.getSuperCurrentEditorElement();
      Object _xifexpression = null;
      if ((element instanceof PsiEObject)) {
        EObject _eObject = ((PsiEObject)element).getEObject();
        EObject _primaryJvmElement = this._iJvmModelAssociations.getPrimaryJvmElement(_eObject);
        URI _uRI = null;
        if (_primaryJvmElement!=null) {
          _uRI=EcoreUtil.getURI(_primaryJvmElement);
        }
        _xifexpression = _uRI;
      } else {
        _xifexpression = super.getCurrentEditorElement();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
