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
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider;
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
  
  public Iterable<PsiClass> getPsiClassesByName(final BaseXtextFile xtextFile, final String name) {
    Iterable<PsiClass> _xblockexpression = null;
    {
      final XtextResource resource = xtextFile.getResource();
      IResourceDescription _resourceDescription = this.getResourceDescription(resource);
      Iterable<IEObjectDescription> _exportedObjectsByType = _resourceDescription.getExportedObjectsByType(TypesPackage.Literals.JVM_DECLARED_TYPE);
      final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
        @Override
        public Boolean apply(final IEObjectDescription description) {
          QualifiedName _qualifiedName = description.getQualifiedName();
          String _shortName = JvmPsiClasses.this.getShortName(_qualifiedName);
          return Boolean.valueOf(Objects.equal(_shortName, name));
        }
      };
      Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_exportedObjectsByType, _function);
      final Function1<IEObjectDescription, PsiElement> _function_1 = new Function1<IEObjectDescription, PsiElement>() {
        @Override
        public PsiElement apply(final IEObjectDescription description) {
          return JvmPsiClasses.this._iPsiModelAssociations.getPsiElement(description, resource);
        }
      };
      Iterable<PsiElement> _map = IterableExtensions.<IEObjectDescription, PsiElement>map(_filter, _function_1);
      _xblockexpression = Iterables.<PsiClass>filter(_map, PsiClass.class);
    }
    return _xblockexpression;
  }
  
  public Iterable<PsiClass> getPsiClassesByQualifiedName(final BaseXtextFile xtextFile, final QualifiedName qualifiedName) {
    Iterable<PsiClass> _xblockexpression = null;
    {
      final XtextResource resource = xtextFile.getResource();
      IResourceDescription _resourceDescription = this.getResourceDescription(resource);
      Iterable<IEObjectDescription> _exportedObjects = _resourceDescription.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, qualifiedName, false);
      final Function1<IEObjectDescription, PsiElement> _function = new Function1<IEObjectDescription, PsiElement>() {
        @Override
        public PsiElement apply(final IEObjectDescription description) {
          return JvmPsiClasses.this._iPsiModelAssociations.getPsiElement(description, resource);
        }
      };
      Iterable<PsiElement> _map = IterableExtensions.<IEObjectDescription, PsiElement>map(_exportedObjects, _function);
      _xblockexpression = Iterables.<PsiClass>filter(_map, PsiClass.class);
    }
    return _xblockexpression;
  }
  
  protected IResourceDescription getResourceDescription(final XtextResource resource) {
    IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
    IResourceDescription.Manager _resourceDescriptionManager = _resourceServiceProvider.getResourceDescriptionManager();
    return _resourceDescriptionManager.getResourceDescription(resource);
  }
  
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
  
  protected Iterable<PsiClass> _findPsiClasses(final BaseXtextFile element) {
    return this.getPsiClasses(element);
  }
  
  protected Iterable<PsiClass> _findPsiClasses(final PsiElement element) {
    Iterable<PsiClass> _switchResult = null;
    PsiElement _nearestLogicalContainer = this._iPsiLogicalContainerProvider.getNearestLogicalContainer(element);
    final PsiElement container = _nearestLogicalContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof PsiClass) {
        _matched=true;
        _switchResult = Iterables.<PsiClass>filter(Collections.<PsiClass>unmodifiableList(CollectionLiterals.<PsiClass>newArrayList(((PsiClass)container))), PsiClass.class);
      }
    }
    if (!_matched) {
      if (container instanceof PsiMember) {
        _matched=true;
        PsiClass _containingClass = ((PsiMember)container).getContainingClass();
        _switchResult = Iterables.<PsiClass>filter(Collections.<PsiClass>unmodifiableList(CollectionLiterals.<PsiClass>newArrayList(_containingClass)), PsiClass.class);
      }
    }
    if (!_matched) {
      Iterable<PsiClass> _xblockexpression = null;
      {
        final Iterable<PsiClass> psiClasses = this.getPsiClasses(element);
        Iterable<PsiClass> _xifexpression = null;
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
  
  protected Iterable<PsiClass> _findPsiClasses(final Void element) {
    return CollectionLiterals.<PsiClass>emptyList();
  }
  
  public String getShortName(final QualifiedName qualifiedName) {
    String _xblockexpression = null;
    {
      final String lastSegment = qualifiedName.getLastSegment();
      final int index = lastSegment.indexOf("$");
      String _xifexpression = null;
      if ((index == (-1))) {
        _xifexpression = lastSegment;
      } else {
        _xifexpression = lastSegment.substring(index);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Iterable<PsiClass> findPsiClasses(final PsiElement element) {
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
