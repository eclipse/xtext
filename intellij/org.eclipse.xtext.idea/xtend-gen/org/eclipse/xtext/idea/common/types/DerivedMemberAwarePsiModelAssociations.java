/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.PsiElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DerivedMemberAwarePsiModelAssociations extends PsiModelAssociations {
  @Inject
  @Extension
  private IJvmModelAssociations jvmModelAssociations;
  
  @Override
  public PsiElement getPsiElement(final EObject object) {
    EObject _elvis = null;
    EObject _primarySourceElement = this.jvmModelAssociations.getPrimarySourceElement(object);
    if (_primarySourceElement != null) {
      _elvis = _primarySourceElement;
    } else {
      _elvis = object;
    }
    return super.getPsiElement(_elvis);
  }
}
