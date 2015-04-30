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
import com.intellij.psi.search.GlobalSearchScope;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import javax.inject.Provider;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.idea.resource.ScopeBasedResourceDescriptions;
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations;
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider;
import org.eclipse.xtext.xbase.idea.types.psi.impl.StubBasedJvmPsiClass;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Singleton
@SuppressWarnings("all")
public class JvmPsiClasses {
  @Inject
  @Extension
  private IPsiJvmModelAssociations _iPsiJvmModelAssociations;
  
  @Inject
  @Extension
  private IPsiLogicalContainerProvider _iPsiLogicalContainerProvider;
  
  @Inject
  private Provider<StubBasedJvmPsiClass> stubBasedJvmPsiClassProvider;
  
  @Inject
  private Provider<ScopeBasedResourceDescriptions> resourceDescriptionsProvider;
  
  public Iterable<PsiClass> getPsiClassesByName(final BaseXtextFile xtextFile, final String name) {
    PsiFileBasedResourceDescription _psiFileBasedResourceDescription = new PsiFileBasedResourceDescription(xtextFile);
    return this.getPsiClassesByName(_psiFileBasedResourceDescription, name);
  }
  
  public Iterable<PsiClass> getPsiClassesByName(final String name, final GlobalSearchScope scope) {
    ScopeBasedResourceDescriptions _resourceDescriptions = this.getResourceDescriptions(scope);
    return this.getPsiClassesByName(_resourceDescriptions, name);
  }
  
  protected Iterable<PsiClass> getPsiClassesByName(final ISelectable selectable, final String name) {
    Iterable<IEObjectDescription> _exportedObjectsByType = selectable.getExportedObjectsByType(TypesPackage.Literals.JVM_DECLARED_TYPE);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription description) {
        QualifiedName _qualifiedName = description.getQualifiedName();
        String _shortName = JvmPsiClasses.this.getShortName(_qualifiedName);
        return Boolean.valueOf(Objects.equal(_shortName, name));
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_exportedObjectsByType, _function);
    final Function1<IEObjectDescription, PsiClass> _function_1 = new Function1<IEObjectDescription, PsiClass>() {
      @Override
      public PsiClass apply(final IEObjectDescription it) {
        return JvmPsiClasses.this.toPsiClass(it);
      }
    };
    return IterableExtensions.<IEObjectDescription, PsiClass>map(_filter, _function_1);
  }
  
  public Iterable<PsiClass> getPsiClassesByQualifiedName(final BaseXtextFile xtextFile, final QualifiedName qualifiedName) {
    PsiFileBasedResourceDescription _psiFileBasedResourceDescription = new PsiFileBasedResourceDescription(xtextFile);
    return this.getPsiClassesByQualifiedName(_psiFileBasedResourceDescription, qualifiedName);
  }
  
  public Iterable<PsiClass> getPsiClassesByQualifiedName(final QualifiedName qualifiedName, final GlobalSearchScope scope) {
    ScopeBasedResourceDescriptions _resourceDescriptions = this.getResourceDescriptions(scope);
    return this.getPsiClassesByQualifiedName(_resourceDescriptions, qualifiedName);
  }
  
  protected Iterable<PsiClass> getPsiClassesByQualifiedName(final ISelectable selectable, final QualifiedName qualifiedName) {
    Iterable<IEObjectDescription> _exportedObjects = selectable.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, qualifiedName, false);
    final Function1<IEObjectDescription, PsiClass> _function = new Function1<IEObjectDescription, PsiClass>() {
      @Override
      public PsiClass apply(final IEObjectDescription it) {
        return JvmPsiClasses.this.toPsiClass(it);
      }
    };
    return IterableExtensions.<IEObjectDescription, PsiClass>map(_exportedObjects, _function);
  }
  
  protected ScopeBasedResourceDescriptions getResourceDescriptions(final GlobalSearchScope scope) {
    ScopeBasedResourceDescriptions _xblockexpression = null;
    {
      final ScopeBasedResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.get();
      resourceDescriptions.setScope(scope);
      _xblockexpression = resourceDescriptions;
    }
    return _xblockexpression;
  }
  
  public Iterable<PsiClass> getPsiClasses(final BaseXtextFile xtextFile) {
    PsiFileBasedResourceDescription _psiFileBasedResourceDescription = new PsiFileBasedResourceDescription(xtextFile);
    Iterable<IEObjectDescription> _exportedObjectsByType = _psiFileBasedResourceDescription.getExportedObjectsByType(TypesPackage.Literals.JVM_DECLARED_TYPE);
    final Function1<IEObjectDescription, PsiClass> _function = new Function1<IEObjectDescription, PsiClass>() {
      @Override
      public PsiClass apply(final IEObjectDescription it) {
        return JvmPsiClasses.this.toPsiClass(it);
      }
    };
    return IterableExtensions.<IEObjectDescription, PsiClass>map(_exportedObjectsByType, _function);
  }
  
  protected PsiClass toPsiClass(final IEObjectDescription description) {
    StubBasedJvmPsiClass _xblockexpression = null;
    {
      final StubBasedJvmPsiClass stubBasedJvmPsiClass = this.stubBasedJvmPsiClassProvider.get();
      stubBasedJvmPsiClass.setObjectDescription(description);
      _xblockexpression = stubBasedJvmPsiClass;
    }
    return _xblockexpression;
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
        _switchResult = Collections.<PsiClass>unmodifiableList(CollectionLiterals.<PsiClass>newArrayList(((PsiClass)container)));
      }
    }
    if (!_matched) {
      if (container instanceof PsiMember) {
        _matched=true;
        PsiClass _containingClass = ((PsiMember)container).getContainingClass();
        _switchResult = Collections.<PsiClass>unmodifiableList(CollectionLiterals.<PsiClass>newArrayList(_containingClass));
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
  
  /**
   * Computes a short name from a qualified name. If the qualified name is a name with a name of a nested type,
   * only the innermost name is returned as the short name, e.g {@code 'java.util.Map$Entry'.shortName} yields {@code 'Entry'}
   */
  public String getShortName(final QualifiedName qualifiedName) {
    String _xblockexpression = null;
    {
      final String lastSegment = qualifiedName.getLastSegment();
      final int index = lastSegment.lastIndexOf("$");
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
