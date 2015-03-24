/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.projectview;

import com.intellij.ide.projectView.PsiClassChildrenSource;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.ClassTreeNode;
import com.intellij.ide.projectView.impl.nodes.PsiFieldNode;
import com.intellij.ide.projectView.impl.nodes.PsiMethodNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmPsiClassTreeNode extends ClassTreeNode {
  public JvmPsiClassTreeNode(final Project project, final PsiClass value, final ViewSettings viewSettings) {
    super(project, value, viewSettings);
  }
  
  @Override
  public Collection<AbstractTreeNode> getChildrenImpl() {
    ArrayList<AbstractTreeNode> _xblockexpression = null;
    {
      ViewSettings _settings = this.getSettings();
      boolean _isShowMembers = _settings.isShowMembers();
      boolean _not = (!_isShowMembers);
      if (_not) {
        return CollectionLiterals.<AbstractTreeNode>emptyList();
      }
      PsiClass parent = this.getValue();
      final ArrayList<AbstractTreeNode> treeNodes = CollectionLiterals.<AbstractTreeNode>newArrayList();
      final ArrayList<PsiElement> result = CollectionLiterals.<PsiElement>newArrayList();
      PsiClassChildrenSource.DEFAULT_CHILDREN.addChildren(parent, result);
      for (final PsiElement element : result) {
        boolean _matched = false;
        if (!_matched) {
          if (element instanceof PsiClass) {
            _matched=true;
            Project _project = this.getProject();
            ViewSettings _settings_1 = this.getSettings();
            JvmPsiClassTreeNode _jvmPsiClassTreeNode = new JvmPsiClassTreeNode(_project, ((PsiClass)element), _settings_1);
            treeNodes.add(_jvmPsiClassTreeNode);
          }
        }
        if (!_matched) {
          if (element instanceof PsiMethod) {
            _matched=true;
            Project _project = this.getProject();
            ViewSettings _settings_1 = this.getSettings();
            PsiMethodNode _psiMethodNode = new PsiMethodNode(_project, ((PsiMethod)element), _settings_1);
            treeNodes.add(_psiMethodNode);
          }
        }
        if (!_matched) {
          if (element instanceof PsiField) {
            _matched=true;
            Project _project = this.getProject();
            ViewSettings _settings_1 = this.getSettings();
            PsiFieldNode _psiFieldNode = new PsiFieldNode(_project, ((PsiField)element), _settings_1);
            treeNodes.add(_psiFieldNode);
          }
        }
      }
      _xblockexpression = treeNodes;
    }
    return _xblockexpression;
  }
}
