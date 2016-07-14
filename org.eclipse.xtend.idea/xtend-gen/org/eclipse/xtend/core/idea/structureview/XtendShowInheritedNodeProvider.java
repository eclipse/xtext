/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.intellij.icons.AllIcons;
import com.intellij.ide.IdeBundle;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.NodeProvider;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendShowInheritedNodeProvider implements NodeProvider<TreeElement> {
  public final static String ID = "XTEND_SHOW_INHERITED";
  
  @Override
  public Collection<TreeElement> provideNodes(final TreeElement node) {
    return CollectionLiterals.<TreeElement>emptyList();
  }
  
  @Override
  public String getName() {
    return XtendShowInheritedNodeProvider.ID;
  }
  
  @Override
  public ActionPresentation getPresentation() {
    String _message = IdeBundle.message("action.structureview.show.inherited");
    return new ActionPresentationData(_message, null, AllIcons.Hierarchy.Supertypes);
  }
}
