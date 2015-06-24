/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi;

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
    EObject _xblockexpression = null;
    {
      final PsiFile containingFile = element.getContainingFile();
      EObject _xifexpression = null;
      if ((containingFile instanceof BaseXtextFile)) {
        EObject _xblockexpression_1 = null;
        {
          final URI resourceURI = ((BaseXtextFile)containingFile).getURI();
          final IResourceServiceProvider resourceServiceProvider = this.resourceServiceProviderRegistry.getResourceServiceProvider(resourceURI);
          EObject _xifexpression_1 = null;
          if ((resourceServiceProvider instanceof IResourceIdeaServiceProvider)) {
            IPsiModelAssociations _psiModelAssociations = ((IResourceIdeaServiceProvider)resourceServiceProvider).getPsiModelAssociations();
            _xifexpression_1 = _psiModelAssociations.getEObject(element);
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiElement getPsiElement(final EObject object) {
    PsiElement _xblockexpression = null;
    {
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
