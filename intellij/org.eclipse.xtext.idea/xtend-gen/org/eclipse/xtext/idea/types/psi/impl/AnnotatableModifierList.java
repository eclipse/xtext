/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.types.psi.impl;

import com.google.common.base.Objects;
import com.intellij.lang.Language;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.light.LightModifierList;
import java.util.ArrayList;
import org.eclipse.xtext.idea.types.psi.impl.LightAnnotation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class AnnotatableModifierList extends LightModifierList {
  private final ArrayList<PsiAnnotation> annotations = CollectionLiterals.<PsiAnnotation>newArrayList();
  
  public AnnotatableModifierList(final PsiManager manager, final Language language) {
    super(manager, language, new String[] {});
  }
  
  @Override
  public LightAnnotation addAnnotation(final String qualifiedName) {
    LightAnnotation _xblockexpression = null;
    {
      PsiManager _manager = this.getManager();
      Language _language = this.getLanguage();
      final LightAnnotation anno = new LightAnnotation(_manager, _language, qualifiedName);
      anno.setOwner(this);
      this.annotations.add(anno);
      _xblockexpression = anno;
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiAnnotation findAnnotation(final String qualifiedName) {
    final Function1<PsiAnnotation, Boolean> _function = new Function1<PsiAnnotation, Boolean>() {
      @Override
      public Boolean apply(final PsiAnnotation a) {
        String _qualifiedName = a.getQualifiedName();
        return Boolean.valueOf(Objects.equal(qualifiedName, _qualifiedName));
      }
    };
    return IterableExtensions.<PsiAnnotation>findFirst(this.annotations, _function);
  }
  
  @Override
  public PsiAnnotation[] getAnnotations() {
    return ((PsiAnnotation[])Conversions.unwrapArray(this.annotations, PsiAnnotation.class));
  }
  
  @Override
  public PsiAnnotation[] getApplicableAnnotations() {
    return ((PsiAnnotation[])Conversions.unwrapArray(this.annotations, PsiAnnotation.class));
  }
}
