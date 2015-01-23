/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.google.common.base.Objects;
import com.intellij.icons.AllIcons;
import com.intellij.ide.IdeBundle;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import java.util.Comparator;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class AlphaSorter implements Sorter {
  public final static String ALPHA_SORTER_ID = "OUTLINE_ALPHA_COMPARATOR";
  
  @Accessors
  private Comparator<TreeElement> comparator;
  
  @Override
  public boolean isVisible() {
    return (!Objects.equal(this.comparator, null));
  }
  
  @Override
  public String getName() {
    return AlphaSorter.ALPHA_SORTER_ID;
  }
  
  @Override
  public ActionPresentation getPresentation() {
    String _message = IdeBundle.message("action.sort.alphabetically");
    String _message_1 = IdeBundle.message("action.sort.alphabetically");
    return new ActionPresentationData(_message, _message_1, 
      AllIcons.ObjectBrowser.Sorted);
  }
  
  @Override
  public String toString() {
    return this.getName();
  }
  
  @Pure
  public Comparator<TreeElement> getComparator() {
    return this.comparator;
  }
  
  public void setComparator(final Comparator<TreeElement> comparator) {
    this.comparator = comparator;
  }
}
