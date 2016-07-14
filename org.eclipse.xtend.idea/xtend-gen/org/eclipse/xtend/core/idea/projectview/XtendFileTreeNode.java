/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.projectview;

import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.idea.lang.psi.impl.XtendFileImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFileTreeNode extends PsiFileNode {
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
    return Collections.<AbstractTreeNode>unmodifiableList(CollectionLiterals.<AbstractTreeNode>newArrayList());
  }
}
