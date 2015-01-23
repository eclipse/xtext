/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

import com.google.common.base.Objects;
import com.intellij.lang.Language;
import com.intellij.psi.ElementDescriptionLocation;
import com.intellij.psi.ElementDescriptionProvider;
import com.intellij.psi.PsiElement;
import com.intellij.usageView.UsageViewTypeLocation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class BaseXtextElementDescriptionProvider implements ElementDescriptionProvider {
  @Accessors
  private final IXtextLanguage language;
  
  public BaseXtextElementDescriptionProvider(final IXtextLanguage language) {
    this.language = language;
    language.injectMembers(this);
  }
  
  @Override
  public final String getElementDescription(final PsiElement element, final ElementDescriptionLocation location) {
    String _xifexpression = null;
    Language _language = null;
    if (element!=null) {
      _language=element.getLanguage();
    }
    boolean _equals = Objects.equal(_language, this.language);
    if (_equals) {
      _xifexpression = this.doGetElementDescription(element, location);
    }
    return _xifexpression;
  }
  
  public String doGetElementDescription(final PsiElement element, final ElementDescriptionLocation location) {
    boolean _equals = Objects.equal(location, UsageViewTypeLocation.INSTANCE);
    if (_equals) {
      if ((element instanceof PsiEObject)) {
        final EObject eObject = ((PsiEObject)element).getEObject();
        boolean _notEquals = (!Objects.equal(eObject, null));
        if (_notEquals) {
          EClass _eClass = eObject.eClass();
          return _eClass.getName();
        }
      }
    }
    return null;
  }
  
  @Pure
  public IXtextLanguage getLanguage() {
    return this.language;
  }
}
