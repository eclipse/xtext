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
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.ClassTreeNode;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtext.idea.common.types.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileTreeNode extends PsiFileNode {
  @Inject
  @Extension
  private JvmPsiClasses _jvmPsiClasses;
  
  public XtendFileTreeNode(final Project project, final XtendFileImpl value, final ViewSettings viewSettings) {
    super(project, value, viewSettings);
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  public XtendFileImpl getXtendFile() {
    PsiFile _value = this.getValue();
    return ((XtendFileImpl) _value);
  }
  
  @Override
  public Collection<AbstractTreeNode> getChildrenImpl() {
    List<AbstractTreeNode> _xblockexpression = null;
    {
      final ViewSettings viewSettings = this.getSettings();
      XtendFileImpl _xtendFile = this.getXtendFile();
      Iterable<PsiClass> _psiClasses = this._jvmPsiClasses.getPsiClasses(_xtendFile);
      final Function1<PsiClass, ClassTreeNode> _function = new Function1<PsiClass, ClassTreeNode>() {
        @Override
        public ClassTreeNode apply(final PsiClass psiClass) {
          Project _project = XtendFileTreeNode.this.getProject();
          return new ClassTreeNode(_project, psiClass, viewSettings);
        }
      };
      Iterable<ClassTreeNode> _map = IterableExtensions.<PsiClass, ClassTreeNode>map(_psiClasses, _function);
      Iterable<AbstractTreeNode> _filter = Iterables.<AbstractTreeNode>filter(_map, AbstractTreeNode.class);
      _xblockexpression = IterableExtensions.<AbstractTreeNode>toList(_filter);
    }
    return _xblockexpression;
  }
}
