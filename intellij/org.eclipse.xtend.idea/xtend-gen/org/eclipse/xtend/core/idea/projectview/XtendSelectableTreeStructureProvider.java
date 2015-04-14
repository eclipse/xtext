/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.projectview;

import com.intellij.ide.projectView.SelectableTreeStructureProvider;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import java.util.Collection;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtend.core.idea.projectview.XtendFileTreeNode;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSelectableTreeStructureProvider implements SelectableTreeStructureProvider {
  private final Project project;
  
  public XtendSelectableTreeStructureProvider(final Project project) {
    this.project = project;
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public PsiElement getTopLevelElement(final PsiElement element) {
    return null;
  }
  
  @Override
  public Object getData(final Collection<AbstractTreeNode> selected, final String dataName) {
    return null;
  }
  
  @Override
  public Collection<AbstractTreeNode> modify(final AbstractTreeNode parent, final Collection<AbstractTreeNode> children, final ViewSettings settings) {
    final Function1<AbstractTreeNode, AbstractTreeNode> _function = new Function1<AbstractTreeNode, AbstractTreeNode>() {
      @Override
      public AbstractTreeNode apply(final AbstractTreeNode child) {
        AbstractTreeNode _xblockexpression = null;
        {
          final Object value = child.getValue();
          AbstractTreeNode _xifexpression = null;
          if ((value instanceof XtendFileImpl)) {
            _xifexpression = new XtendFileTreeNode(XtendSelectableTreeStructureProvider.this.project, ((XtendFileImpl)value), settings);
          } else {
            _xifexpression = child;
          }
          _xblockexpression = _xifexpression;
        }
        return _xblockexpression;
      }
    };
    Iterable<AbstractTreeNode> _map = IterableExtensions.<AbstractTreeNode, AbstractTreeNode>map(children, _function);
    return IterableExtensions.<AbstractTreeNode>toList(_map);
  }
}
