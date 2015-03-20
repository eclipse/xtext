/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.types.psi.impl;

import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiParameterList;
import com.intellij.psi.PsiReferenceList;
import com.intellij.psi.PsiTypeParameterList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightMethodBuilder extends com.intellij.psi.impl.light.LightMethodBuilder {
  @Accessors
  private PsiElement parent;
  
  public LightMethodBuilder(final PsiManager manager, final Language language, final String name, final PsiParameterList parameterList, final PsiModifierList modifierList, final PsiReferenceList throwsList, final PsiTypeParameterList typeParameterList) {
    super(manager, language, name, parameterList, modifierList, throwsList, typeParameterList);
  }
  
  @Pure
  public PsiElement getParent() {
    return this.parent;
  }
  
  public void setParent(final PsiElement parent) {
    this.parent = parent;
  }
}
