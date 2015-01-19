/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.PsiElement;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.types.psi.impl.JvmPsiClassImpl;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class PsiJvmModelAssociations implements IPsiJvmModelAssociations {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Override
  public Set<PsiElement> getSourceElements(final PsiElement jvmElement) {
    Set<PsiElement> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(jvmElement, null);
      if (_equals) {
        return null;
      }
      EObject _userData = jvmElement.<EObject>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
      _xblockexpression = this.getSourceElements(_userData);
    }
    return _xblockexpression;
  }
  
  @Override
  public Set<PsiElement> getSourceElements(final EObject jvmElement) {
    Set<EObject> _sourceElements = this.jvmModelAssociations.getSourceElements(jvmElement);
    final Function1<EObject, PsiElement> _function = new Function1<EObject, PsiElement>() {
      @Override
      public PsiElement apply(final EObject it) {
        return PsiJvmModelAssociations.this._iPsiModelAssociations.getPsiElement(it);
      }
    };
    Iterable<PsiElement> _map = IterableExtensions.<EObject, PsiElement>map(_sourceElements, _function);
    return IterableExtensions.<PsiElement>toSet(_map);
  }
  
  @Override
  public Set<PsiElement> getJvmElements(final PsiElement sourceElement) {
    EObject _eObject = this._iPsiModelAssociations.getEObject(sourceElement);
    return this.getJvmElements(_eObject);
  }
  
  @Override
  public Set<PsiElement> getJvmElements(final EObject sourceElement) {
    Set<EObject> _jvmElements = this.jvmModelAssociations.getJvmElements(sourceElement);
    final Function1<EObject, PsiElement> _function = new Function1<EObject, PsiElement>() {
      @Override
      public PsiElement apply(final EObject it) {
        return PsiJvmModelAssociations.this._iPsiModelAssociations.getPsiElement(it);
      }
    };
    Iterable<PsiElement> _map = IterableExtensions.<EObject, PsiElement>map(_jvmElements, _function);
    return IterableExtensions.<PsiElement>toSet(_map);
  }
  
  @Override
  public PsiElement getPrimarySourceElement(final PsiElement jvmElement) {
    PsiElement _xblockexpression = null;
    {
      boolean _equals = Objects.equal(jvmElement, null);
      if (_equals) {
        return null;
      }
      EObject _userData = jvmElement.<EObject>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
      _xblockexpression = this.getPrimarySourceElement(_userData);
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiElement getPrimarySourceElement(final EObject jvmElement) {
    EObject _primarySourceElement = this.jvmModelAssociations.getPrimarySourceElement(jvmElement);
    return this._iPsiModelAssociations.getPsiElement(_primarySourceElement);
  }
  
  @Override
  public PsiElement getPrimaryJvmElement(final PsiElement sourceElement) {
    EObject _eObject = this._iPsiModelAssociations.getEObject(sourceElement);
    return this.getPrimaryJvmElement(_eObject);
  }
  
  @Override
  public PsiElement getPrimaryJvmElement(final EObject sourceElement) {
    EObject _primaryJvmElement = this.jvmModelAssociations.getPrimaryJvmElement(sourceElement);
    return this._iPsiModelAssociations.getPsiElement(_primaryJvmElement);
  }
  
  @Override
  public boolean isPrimaryJvmElement(final PsiElement jvmElement) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(jvmElement, null);
      if (_equals) {
        return false;
      }
      EObject _userData = jvmElement.<EObject>getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY);
      _xblockexpression = this.isPrimaryJvmElement(_userData);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isPrimaryJvmElement(final EObject jvmElement) {
    return this.jvmModelAssociations.isPrimaryJvmElement(jvmElement);
  }
}
