/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.intellij.ide.util.treeView.smartTree.NodeProvider;
import com.intellij.openapi.editor.Editor;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.core.idea.structureview.XtendShowInheritedNodeProvider;
import org.eclipse.xtext.idea.structureview.XtextFileTreeModel;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class XtendFileTreeModel extends XtextFileTreeModel {
  private final Collection<NodeProvider> nodeProviders = Collections.<NodeProvider>unmodifiableList(CollectionLiterals.<NodeProvider>newArrayList(new XtendShowInheritedNodeProvider()));
  
  public XtendFileTreeModel(final BaseXtextFile xtextFile, final Editor editor) {
    super(xtextFile, editor);
  }
  
  public Collection<NodeProvider> getNodeProviders() {
    return this.nodeProviders;
  }
}
