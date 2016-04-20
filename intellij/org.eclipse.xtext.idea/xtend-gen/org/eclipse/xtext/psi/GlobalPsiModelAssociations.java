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
import com.google.inject.Singleton;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.idea.resource.IResourceIdeaServiceProvider;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class GlobalPsiModelAssociations implements IPsiModelAssociations {
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  @Override
  public EObject getEObject(final PsiElement element) {
    boolean _equals = Objects.equal(element, null);
    if (_equals) {
      return null;
    }
    final PsiFile containingFile = element.getContainingFile();
    if ((containingFile instanceof BaseXtextFile)) {
      final URI resourceURI = ((BaseXtextFile)containingFile).getURI();
      final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(resourceURI);
      if ((resourceServiceProvider instanceof IResourceIdeaServiceProvider)) {
        IPsiModelAssociations _psiModelAssociations = ((IResourceIdeaServiceProvider)resourceServiceProvider).getPsiModelAssociations();
        return _psiModelAssociations.getEObject(element);
      }
    }
    return null;
  }
  
  @Override
  public PsiElement getPsiElement(final EObject object) {
    PsiElement _xblockexpression = null;
    {
      boolean _equals = Objects.equal(object, null);
      if (_equals) {
        return null;
      }
      URI _uRI = EcoreUtil.getURI(object);
      final URI resourceURI = _uRI.trimFragment();
      final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(resourceURI);
      PsiElement _xifexpression = null;
      if ((resourceServiceProvider instanceof IResourceIdeaServiceProvider)) {
        IPsiModelAssociations _psiModelAssociations = ((IResourceIdeaServiceProvider)resourceServiceProvider).getPsiModelAssociations();
        _xifexpression = _psiModelAssociations.getPsiElement(object);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiElement getPsiElement(final IEObjectDescription objectDescription, final Resource context) {
    PsiElement _xblockexpression = null;
    {
      if ((Objects.equal(objectDescription, null) || Objects.equal(context, null))) {
        return null;
      }
      final URI resourceURI = context.getURI();
      final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(resourceURI);
      PsiElement _xifexpression = null;
      if ((resourceServiceProvider instanceof IResourceIdeaServiceProvider)) {
        IPsiModelAssociations _psiModelAssociations = ((IResourceIdeaServiceProvider)resourceServiceProvider).getPsiModelAssociations();
        _xifexpression = _psiModelAssociations.getPsiElement(objectDescription, context);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
