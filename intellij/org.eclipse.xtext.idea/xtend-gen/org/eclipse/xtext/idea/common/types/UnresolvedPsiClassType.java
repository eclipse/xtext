/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.intellij.psi.PsiClassType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class UnresolvedPsiClassType extends Exception {
  @Accessors
  private final PsiClassType psiClassType;
  
  @Accessors
  private final PsiClassType.ClassResolveResult classResolveResult;
  
  public UnresolvedPsiClassType(final PsiClassType psiClassType, final PsiClassType.ClassResolveResult classResolveResult) {
    super();
    this.psiClassType = psiClassType;
    this.classResolveResult = classResolveResult;
  }
  
  @Pure
  public PsiClassType getPsiClassType() {
    return this.psiClassType;
  }
  
  @Pure
  public PsiClassType.ClassResolveResult getClassResolveResult() {
    return this.classResolveResult;
  }
}
