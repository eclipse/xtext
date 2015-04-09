/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.projectview;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.ide.projectView.SelectableTreeStructureProvider;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.util.Collection;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtend.core.idea.projectview.JvmPsiClassTreeNode;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendSelectableTreeStructureProvider implements SelectableTreeStructureProvider {
  private final Project project;
  
  @Inject
  @Extension
  private JvmPsiClasses _jvmPsiClasses;
  
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
    Collection<AbstractTreeNode> _xblockexpression = null;
    {
      if ((parent instanceof PsiFileNode)) {
        final PsiFile value = ((PsiFileNode)parent).getValue();
        if ((value instanceof XtendFileImpl)) {
          Iterable<JvmPsiClass> _psiClasses = this._jvmPsiClasses.getPsiClasses(((BaseXtextFile)value));
          final Function1<JvmPsiClass, JvmPsiClassTreeNode> _function = new Function1<JvmPsiClass, JvmPsiClassTreeNode>() {
            @Override
            public JvmPsiClassTreeNode apply(final JvmPsiClass psiClass) {
              ViewSettings _settings = ((PsiFileNode)parent).getSettings();
              return new JvmPsiClassTreeNode(XtendSelectableTreeStructureProvider.this.project, psiClass, _settings);
            }
          };
          Iterable<JvmPsiClassTreeNode> _map = IterableExtensions.<JvmPsiClass, JvmPsiClassTreeNode>map(_psiClasses, _function);
          Iterable<AbstractTreeNode> _filter = Iterables.<AbstractTreeNode>filter(_map, AbstractTreeNode.class);
          return IterableExtensions.<AbstractTreeNode>toList(_filter);
        }
      }
      _xblockexpression = children;
    }
    return _xblockexpression;
  }
}
