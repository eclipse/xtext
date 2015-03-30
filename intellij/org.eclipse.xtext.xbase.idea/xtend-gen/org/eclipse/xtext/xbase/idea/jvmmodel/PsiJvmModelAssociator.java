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
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;
import org.eclipse.xtext.xbase.idea.jvmmodel.JvmPsiClassProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PsiJvmModelAssociator extends JvmModelAssociator {
  @Inject
  @Extension
  private IPsiModelAssociator _iPsiModelAssociator;
  
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
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
    PsiElementProvider _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (jvmElement instanceof JvmDeclaredType) {
        JvmDeclaredType _declaringType = ((JvmDeclaredType)jvmElement).getDeclaringType();
        boolean _equals = Objects.equal(_declaringType, null);
        if (_equals) {
          _matched=true;
          JvmPsiClassProvider _get = this.psiClassProviderProvider.get();
          final Procedure1<JvmPsiClassProvider> _function = new Procedure1<JvmPsiClassProvider>() {
            @Override
            public void apply(final JvmPsiClassProvider provider) {
              provider.setJvmDeclaredType(((JvmDeclaredType)jvmElement));
              provider.setSourceElement(sourceElement);
            }
          };
          _switchResult = ObjectExtensions.<JvmPsiClassProvider>operator_doubleArrow(_get, _function);
        }
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmDeclaredType) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          @Override
          public PsiElement get() {
            PsiElement _xblockexpression = null;
            {
              JvmDeclaredType _declaringType = ((JvmDeclaredType)jvmElement).getDeclaringType();
              final PsiElement psiClass = PsiJvmModelAssociator.this._iPsiModelAssociations.getPsiElement(_declaringType);
              PsiElement _xifexpression = null;
              if ((psiClass instanceof PsiClass)) {
                PsiClass[] _innerClasses = ((PsiClass)psiClass).getInnerClasses();
                _xifexpression = PsiJvmModelAssociator.this.findByJvmElement(_innerClasses, jvmElement);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmExecutable) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          @Override
          public PsiElement get() {
            PsiElement _xblockexpression = null;
            {
              JvmDeclaredType _declaringType = ((JvmExecutable)jvmElement).getDeclaringType();
              final PsiElement psiClass = PsiJvmModelAssociator.this._iPsiModelAssociations.getPsiElement(_declaringType);
              PsiElement _xifexpression = null;
              if ((psiClass instanceof PsiClass)) {
                PsiMethod[] _methods = ((PsiClass)psiClass).getMethods();
                _xifexpression = PsiJvmModelAssociator.this.findByJvmElement(_methods, jvmElement);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmField) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          @Override
          public PsiElement get() {
            PsiElement _xblockexpression = null;
            {
              JvmDeclaredType _declaringType = ((JvmField)jvmElement).getDeclaringType();
              final PsiElement psiClass = PsiJvmModelAssociator.this._iPsiModelAssociations.getPsiElement(_declaringType);
              PsiElement _xifexpression = null;
              if ((psiClass instanceof PsiClass)) {
                PsiField[] _fields = ((PsiClass)psiClass).getFields();
                _xifexpression = PsiJvmModelAssociator.this.findByJvmElement(_fields, jvmElement);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    if (!_matched) {
      if (jvmElement instanceof JvmFormalParameter) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          @Override
          public PsiElement get() {
            PsiElement _xblockexpression = null;
            {
              EObject _eContainer = ((JvmFormalParameter)jvmElement).eContainer();
              final PsiElement psiMethod = PsiJvmModelAssociator.this._iPsiModelAssociations.getPsiElement(_eContainer);
              PsiElement _xifexpression = null;
              if ((psiMethod instanceof PsiMethod)) {
                PsiParameterList _parameterList = ((PsiMethod)psiMethod).getParameterList();
                PsiParameter[] _parameters = _parameterList.getParameters();
                _xifexpression = PsiJvmModelAssociator.this.findByJvmElement(_parameters, jvmElement);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          }
        };
        _switchResult = _function;
      }
    }
    return _switchResult;
  }
  
  protected PsiElement findByJvmElement(final PsiElement[] elements, final EObject jvmElement) {
    final Function1<PsiElement, Boolean> _function = new Function1<PsiElement, Boolean>() {
      @Override
      public Boolean apply(final PsiElement element) {
        EObject _jvmElement = JvmPsiElementExtensions.getJvmElement(element);
        return Boolean.valueOf(Objects.equal(_jvmElement, jvmElement));
      }
    };
    return IterableExtensions.<PsiElement>findFirst(((Iterable<PsiElement>)Conversions.doWrapArray(elements)), _function);
  }
}
