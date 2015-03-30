/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.PsiFieldImpl;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmPsiFieldImpl extends PsiFieldImpl {
  public JvmPsiFieldImpl(final ASTNode node) {
    super(node);
  }
  
  @Override
  public PsiElement getNavigationElement() {
    PsiElement _elvis = null;
    PsiElement _navigationElement = JvmPsiElementExtensions.getNavigationElement(this);
    if (_navigationElement != null) {
      _elvis = _navigationElement;
    } else {
      PsiElement _navigationElement_1 = super.getNavigationElement();
      _elvis = _navigationElement_1;
    }
    return _elvis;
  }
}
