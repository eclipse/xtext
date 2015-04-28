/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.xbase.idea.jvm.PsiJvmFileImpl;
import org.eclipse.xtext.xbase.idea.jvmmodel.JvmPsiClassProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PsiJvmModelAssociator extends JvmModelAssociator {
  @Inject
  @Extension
  private IPsiModelAssociator _iPsiModelAssociator;
  
  @Inject
  private Provider<JvmPsiClassProvider> psiClassProviderProvider;
  
  @Override
  public void associate(final EObject sourceElement, final EObject jvmElement) {
    super.associate(sourceElement, jvmElement);
    final PsiElementProvider psiElementProvider = this.createPsiElementProvider(sourceElement, jvmElement);
    boolean _notEquals = (!Objects.equal(psiElementProvider, null));
    if (_notEquals) {
      this._iPsiModelAssociator.associate(jvmElement, psiElementProvider);
    }
  }
  
  @Override
  public void associatePrimary(final EObject sourceElement, final EObject jvmElement) {
    super.associatePrimary(sourceElement, jvmElement);
    final PsiElementProvider psiElementProvider = this.createPsiElementProvider(sourceElement, jvmElement);
    boolean _notEquals = (!Objects.equal(psiElementProvider, null));
    if (_notEquals) {
      this._iPsiModelAssociator.associatePrimary(jvmElement, psiElementProvider);
    }
  }
  
  protected PsiElementProvider createPsiElementProvider(final EObject sourceElement, final EObject jvmElement) {
    final PsiElementProvider _function = new PsiElementProvider() {
      @Override
      public PsiElement get() {
        PsiElement _xblockexpression = null;
        {
          final EObject root = EcoreUtil.getRootContainer(jvmElement);
          PsiElement _xifexpression = null;
          if ((root instanceof JvmDeclaredType)) {
            PsiElement _xblockexpression_1 = null;
            {
              final JvmPsiClassProvider provider = PsiJvmModelAssociator.this.psiClassProviderProvider.get();
              provider.setJvmDeclaredType(((JvmDeclaredType)root));
              provider.setSourceElement(sourceElement);
              _xblockexpression_1 = provider.get();
            }
            _xifexpression = _xblockexpression_1;
          }
          final PsiElement psiClass = _xifexpression;
          boolean _equals = Objects.equal(root, jvmElement);
          if (_equals) {
            return psiClass;
          }
          final PsiFile psiFile = psiClass.getContainingFile();
          PsiElement _xifexpression_1 = null;
          if ((psiFile instanceof PsiJvmFileImpl)) {
            Map<EObject, PsiElement> _mapping = ((PsiJvmFileImpl)psiFile).getMapping();
            _xifexpression_1 = _mapping.get(jvmElement);
          }
          _xblockexpression = _xifexpression_1;
        }
        return _xblockexpression;
      }
    };
    return _function;
  }
}
