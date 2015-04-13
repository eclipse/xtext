/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMember;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
  
  @Inject
  @Extension
  private IPsiLogicalContainerProvider _iPsiLogicalContainerProvider;
  
  public Iterable<JvmPsiClass> getPsiClassesByName(final BaseXtextFile it, final String name) {
    ArrayList<JvmPsiClass> _xblockexpression = null;
    {
      final Resource resource = it.getResource();
      final ArrayList<JvmPsiClass> result = CollectionLiterals.<JvmPsiClass>newArrayList();
      IResourceDescription _resourceDescription = it.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjectsByType = _resourceDescription.getExportedObjectsByType(TypesPackage.Literals.JVM_DECLARED_TYPE);
      for (final IEObjectDescription description : _exportedObjectsByType) {
        ResourceSet _resourceSet = resource.getResourceSet();
        URI _eObjectURI = description.getEObjectURI();
        EObject _eObject = _resourceSet.getEObject(_eObjectURI, true);
        final EObject jvmDeclaredType = _eObject;
        boolean _matched = false;
        if (!_matched) {
          if (jvmDeclaredType instanceof JvmDeclaredType) {
            String _simpleName = ((JvmDeclaredType)jvmDeclaredType).getSimpleName();
            boolean _equals = Objects.equal(_simpleName, name);
            if (_equals) {
              _matched=true;
              PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(jvmDeclaredType);
              result.add(((JvmPsiClass) _psiElement));
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public Iterable<JvmPsiClass> getPsiClassesByQualifiedName(final BaseXtextFile it, final QualifiedName qualifiedName) {
    ArrayList<JvmPsiClass> _xblockexpression = null;
    {
      final Resource resource = it.getResource();
      final ArrayList<JvmPsiClass> result = CollectionLiterals.<JvmPsiClass>newArrayList();
      IResourceDescription _resourceDescription = it.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects = _resourceDescription.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, qualifiedName, false);
      for (final IEObjectDescription description : _exportedObjects) {
        ResourceSet _resourceSet = resource.getResourceSet();
        URI _eObjectURI = description.getEObjectURI();
        EObject _eObject = _resourceSet.getEObject(_eObjectURI, true);
        final EObject jvmDeclaredType = _eObject;
        boolean _matched = false;
        if (!_matched) {
          if (jvmDeclaredType instanceof JvmDeclaredType) {
            _matched=true;
            PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(jvmDeclaredType);
            result.add(((JvmPsiClass) _psiElement));
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public Iterable<JvmPsiClass> getPsiClasses(final BaseXtextFile it) {
    Resource _resource = it.getResource();
    EList<EObject> _contents = _resource.getContents();
    Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
    final Function1<JvmDeclaredType, PsiElement> _function = new Function1<JvmDeclaredType, PsiElement>() {
      @Override
      public PsiElement apply(final JvmDeclaredType it) {
        return JvmPsiClasses.this._iPsiModelAssociations.getPsiElement(it);
      }
    };
    Iterable<PsiElement> _map = IterableExtensions.<JvmDeclaredType, PsiElement>map(_filter, _function);
    return Iterables.<JvmPsiClass>filter(_map, JvmPsiClass.class);
  }
  
  public Iterable<JvmPsiClass> getPsiClasses(final PsiElement element) {
    Set<PsiElement> _jvmElements = this._iPsiJvmModelAssociations.getJvmElements(element);
    return Iterables.<JvmPsiClass>filter(_jvmElements, JvmPsiClass.class);
  }
  
  protected Iterable<JvmPsiClass> _findPsiClasses(final BaseXtextFile element) {
    return this.getPsiClasses(element);
  }
  
  protected Iterable<JvmPsiClass> _findPsiClasses(final PsiElement element) {
    Iterable<JvmPsiClass> _switchResult = null;
    PsiElement _nearestLogicalContainer = this._iPsiLogicalContainerProvider.getNearestLogicalContainer(element);
    final PsiElement container = _nearestLogicalContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof PsiClass) {
        _matched=true;
        _switchResult = Iterables.<JvmPsiClass>filter(Collections.<PsiClass>unmodifiableList(CollectionLiterals.<PsiClass>newArrayList(((PsiClass)container))), JvmPsiClass.class);
      }
    }
    if (!_matched) {
      if (container instanceof PsiMember) {
        _matched=true;
        PsiClass _containingClass = ((PsiMember)container).getContainingClass();
        _switchResult = Iterables.<JvmPsiClass>filter(Collections.<PsiClass>unmodifiableList(CollectionLiterals.<PsiClass>newArrayList(_containingClass)), JvmPsiClass.class);
      }
    }
    if (!_matched) {
      Iterable<JvmPsiClass> _xblockexpression = null;
      {
        final Iterable<JvmPsiClass> psiClasses = this.getPsiClasses(element);
        Iterable<JvmPsiClass> _xifexpression = null;
        boolean _isEmpty = IterableExtensions.isEmpty(psiClasses);
        if (_isEmpty) {
          PsiElement _parent = element.getParent();
          _xifexpression = this.findPsiClasses(_parent);
        } else {
          _xifexpression = psiClasses;
        }
        _xblockexpression = _xifexpression;
      }
      _switchResult = _xblockexpression;
    }
    return _switchResult;
  }
  
  protected Iterable<JvmPsiClass> _findPsiClasses(final Void element) {
    return CollectionLiterals.<JvmPsiClass>emptyList();
  }
  
  public Iterable<JvmPsiClass> findPsiClasses(final PsiElement element) {
    if (element instanceof BaseXtextFile) {
      return _findPsiClasses((BaseXtextFile)element);
    } else if (element != null) {
      return _findPsiClasses(element);
    } else if (element == null) {
      return _findPsiClasses((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
