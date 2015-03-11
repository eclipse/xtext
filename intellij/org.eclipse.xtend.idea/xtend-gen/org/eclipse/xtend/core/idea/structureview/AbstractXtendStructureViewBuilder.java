/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.newStructureView.TreeActionsOwner;
import com.intellij.openapi.editor.Editor;
import org.eclipse.xtend.core.idea.structureview.XtendFileTreeModel;
import org.eclipse.xtend.core.idea.structureview.XtendStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewBuilder;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractXtendStructureViewBuilder extends AbstractStructureViewBuilder {
  @Override
  public XtextFileTreeModel createStructureViewModel(final Editor editor) {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return new XtendFileTreeModel(_xtextFile, editor);
  }
  
  @Override
  public void configureStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider, final XtextFileTreeModel model, final StructureView view) {
    if ((structureViewTreeElementProvider instanceof XtendStructureViewTreeElementProvider)) {
      if ((view instanceof TreeActionsOwner)) {
        ((XtendStructureViewTreeElementProvider)structureViewTreeElementProvider).setTreeActionsOwner(((TreeActionsOwner)view));
      }
    }
  }
}
