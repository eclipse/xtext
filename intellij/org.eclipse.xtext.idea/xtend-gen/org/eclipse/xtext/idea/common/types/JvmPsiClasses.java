/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.common.types;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class JvmPsiClasses {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  public Iterable<PsiClass> getPsiClasses(final BaseXtextFile it) {
    XtextResource _resource = it.getResource();
    EList<EObject> _contents = _resource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType, PsiElement> _function = new Function1<JvmDeclaredType, PsiElement>() {
      @Override
      public PsiElement apply(final JvmDeclaredType it) {
        return JvmPsiClasses.this._iPsiModelAssociations.getPsiElement(it);
      }
    };
    Iterable<PsiElement> _map = IterableExtensions.<JvmDeclaredType, PsiElement>map(_filter, _function);
    return Iterables.<PsiClass>filter(_map, PsiClass.class);
  }
  
  public Iterable<PsiClass> getPsiClasses(final PsiElement element) {
    Set<PsiElement> _jvmElements = this._iPsiJvmModelAssociations.getJvmElements(element);
    return Iterables.<PsiClass>filter(_jvmElements, PsiClass.class);
  }
}
