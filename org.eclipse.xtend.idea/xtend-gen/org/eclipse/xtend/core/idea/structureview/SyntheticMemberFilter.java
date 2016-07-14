/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import org.eclipse.xtend.core.idea.structureview.XtendFeatureTreeElement;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SyntheticMemberFilter implements Filter {
  public final static String ID = "SHOW_NO_SYNTHETIC";
  
  @Override
  public boolean isReverted() {
    return true;
  }
  
  @Override
  public boolean isVisible(final TreeElement treeNode) {
    boolean _xifexpression = false;
    if ((treeNode instanceof XtendFeatureTreeElement)) {
      boolean _isSynthetic = ((XtendFeatureTreeElement)treeNode).isSynthetic();
      _xifexpression = (!_isSynthetic);
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  @Override
  public String getName() {
    return SyntheticMemberFilter.ID;
  }
  
  @Override
  public ActionPresentation getPresentation() {
    return new ActionPresentationData("Show Synthetic Members", null, null);
  }
}
