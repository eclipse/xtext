/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewTreeElement;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.XtextFileTreeElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextFileTreeModel extends TextEditorBasedStructureViewModel implements StructureViewModel.ElementInfoProvider {
  @Accessors
  private IStructureViewTreeElementProvider structureViewTreeElementProvider;
  
  public XtextFileTreeModel(final BaseXtextFile xtextFile, final Editor editor) {
    super(editor, xtextFile);
  }
  
  protected BaseXtextFile getPsiFile() {
    PsiFile _psiFile = super.getPsiFile();
    return ((BaseXtextFile) _psiFile);
  }
  
  public StructureViewTreeElement getRoot() {
    XtextFileTreeElement _xblockexpression = null;
    {
      BaseXtextFile _psiFile = this.getPsiFile();
      final XtextFileTreeElement rootTreeElement = new XtextFileTreeElement(_psiFile);
      rootTreeElement.setStructureViewTreeElementProvider(this.structureViewTreeElementProvider);
      _xblockexpression = rootTreeElement;
    }
    return _xblockexpression;
  }
  
  public boolean isAlwaysLeaf(final StructureViewTreeElement element) {
    boolean _xifexpression = false;
    if ((element instanceof AbstractStructureViewTreeElement)) {
      _xifexpression = ((AbstractStructureViewTreeElement)element).isLeaf();
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  public boolean isAlwaysShowsPlus(final StructureViewTreeElement element) {
    return false;
  }
  
  @Pure
  public IStructureViewTreeElementProvider getStructureViewTreeElementProvider() {
    return this.structureViewTreeElementProvider;
  }
  
  public void setStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider) {
    this.structureViewTreeElementProvider = structureViewTreeElementProvider;
  }
}
