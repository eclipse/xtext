/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.openapi.util.Condition;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.psi.IPsiModelAssociations;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextPsiExtensions {
  @Inject
  private IPsiModelAssociations associations;
  
  public PsiElement findEObjectAssociatedPsiElement(final PsiElement ctx, final int offset) {
    PsiFile _containingFile = ctx.getContainingFile();
    final PsiElement element = _containingFile.findElementAt(offset);
    return this.findEObjectAssociatedPsiElement(element);
  }
  
  public EObject findEObject(final PsiElement ctx, final int offset) {
    PsiElement _findEObjectAssociatedPsiElement = this.findEObjectAssociatedPsiElement(ctx, offset);
    return this.associations.getEObject(_findEObjectAssociatedPsiElement);
  }
  
  public PsiElement findEObjectAssociatedPsiElement(final PsiElement element) {
    final Condition<PsiElement> _function = new Condition<PsiElement>() {
      @Override
      public boolean value(final PsiElement it) {
        EObject _eObject = XtextPsiExtensions.this.associations.getEObject(it);
        return (!Objects.equal(_eObject, null));
      }
    };
    return PsiTreeUtil.findFirstParent(element, false, _function);
  }
  
  public EObject findEObject(final PsiElement ctx) {
    PsiElement _findEObjectAssociatedPsiElement = this.findEObjectAssociatedPsiElement(ctx);
    return this.associations.getEObject(_findEObjectAssociatedPsiElement);
  }
}
