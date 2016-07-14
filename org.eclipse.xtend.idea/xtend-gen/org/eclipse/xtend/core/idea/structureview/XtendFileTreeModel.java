/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.openapi.editor.Editor;
import java.util.Comparator;
import org.eclipse.xtend.core.idea.structureview.XtendShowInheritedNodeProvider;
import org.eclipse.xtend.core.idea.structureview.XtendTreeElementComparator;
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@SuppressWarnings("all")
public class XtendFileTreeModel extends XtextFileTreeModel {
  public XtendFileTreeModel(final BaseXtextFile xtextFile, final Editor editor) {
    super(xtextFile, editor);
    XtendShowInheritedNodeProvider _xtendShowInheritedNodeProvider = new XtendShowInheritedNodeProvider();
    this.nodeProviders.add(_xtendShowInheritedNodeProvider);
  }
  
  @Override
  public Comparator<TreeElement> getComparator() {
    return new XtendTreeElementComparator();
  }
}
