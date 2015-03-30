/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.types.psi;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import java.util.ArrayList;
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
  
  public ArrayList<PsiClass> getPsiClassesByName(final BaseXtextFile it, final String name) {
    ArrayList<PsiClass> _xblockexpression = null;
    {
      final Resource resource = it.getResource();
      final ArrayList<PsiClass> result = CollectionLiterals.<PsiClass>newArrayList();
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
              result.add(((PsiClass) _psiElement));
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public ArrayList<PsiClass> getPsiClassesByQualifiedName(final BaseXtextFile it, final QualifiedName qualifiedName) {
    ArrayList<PsiClass> _xblockexpression = null;
    {
      final Resource resource = it.getResource();
      final ArrayList<PsiClass> result = CollectionLiterals.<PsiClass>newArrayList();
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
            result.add(((PsiClass) _psiElement));
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public Iterable<PsiClass> getPsiClasses(final BaseXtextFile it) {
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
    return Iterables.<PsiClass>filter(_map, PsiClass.class);
  }
}
