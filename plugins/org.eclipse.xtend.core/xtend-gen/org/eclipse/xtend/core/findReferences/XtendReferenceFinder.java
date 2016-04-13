/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.findReferences;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.findReferences.Declarators;
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendReferenceFinder extends ReferenceFinder {
  @Inject
  @Extension
  private StaticallyImportedMemberProvider _staticallyImportedMemberProvider;
  
  @Inject
  @Extension
  private AnonymousClassUtil _anonymousClassUtil;
  
  @Inject
  private Declarators declarators;
  
  @Override
  public void findReferencesInDescription(final TargetURIs targetURIs, final IResourceDescription resourceDescription, final IReferenceFinder.IResourceAccess resourceAccess, final IReferenceFinder.Acceptor acceptor, final IProgressMonitor monitor) {
    if ((resourceAccess == null)) {
      return;
    }
    Declarators.DeclaratorsData _declaratorData = this.declarators.getDeclaratorData(targetURIs, resourceAccess);
    final Set<QualifiedName> names = _declaratorData.getDeclaratorNames();
    boolean _isCanceled = monitor.isCanceled();
    if (_isCanceled) {
      throw new OperationCanceledException();
    }
    Iterable<QualifiedName> _importedNames = resourceDescription.getImportedNames();
    final Set<QualifiedName> importedNames = IterableExtensions.<QualifiedName>toSet(_importedNames);
    final Function1<QualifiedName, Boolean> _function = new Function1<QualifiedName, Boolean>() {
      @Override
      public Boolean apply(final QualifiedName it) {
        return Boolean.valueOf(importedNames.contains(it));
      }
    };
    boolean _exists = IterableExtensions.<QualifiedName>exists(names, _function);
    if (_exists) {
      URI _uRI = resourceDescription.getURI();
      final IUnitOfWork<Object, ResourceSet> _function_1 = new IUnitOfWork<Object, ResourceSet>() {
        @Override
        public Object exec(final ResourceSet it) throws Exception {
          URI _uRI = resourceDescription.getURI();
          Resource _resource = it.getResource(_uRI, true);
          XtendReferenceFinder.this.findReferences(targetURIs, _resource, acceptor, monitor);
          return null;
        }
      };
      resourceAccess.<Object>readOnly(_uRI, _function_1);
    }
  }
  
  @Override
  protected void findLocalReferencesFromElement(final TargetURIs targetURIs, final EObject sourceCandidate, final Resource localResource, final IReferenceFinder.Acceptor acceptor) {
    boolean _matched = false;
    if (sourceCandidate instanceof XAbstractFeatureCall) {
      boolean _isPackageFragment = ((XAbstractFeatureCall)sourceCandidate).isPackageFragment();
      if (_isPackageFragment) {
        _matched=true;
        return;
      }
    }
    super.findLocalReferencesFromElement(targetURIs, sourceCandidate, localResource, acceptor);
    boolean _matched_1 = false;
    if (sourceCandidate instanceof XImportDeclaration) {
      boolean _and = false;
      boolean _isStatic = ((XImportDeclaration)sourceCandidate).isStatic();
      if (!_isStatic) {
        _and = false;
      } else {
        boolean _isWildcard = ((XImportDeclaration)sourceCandidate).isWildcard();
        boolean _not = (!_isWildcard);
        _and = _not;
      }
      if (_and) {
        _matched_1=true;
        this.addReferenceToFeatureFromStaticImport(((XImportDeclaration)sourceCandidate), targetURIs, acceptor);
      }
    }
    if (!_matched_1) {
      if (sourceCandidate instanceof XFeatureCall) {
        boolean _and = false;
        XExpression _actualReceiver = ((XFeatureCall)sourceCandidate).getActualReceiver();
        boolean _equals = Objects.equal(_actualReceiver, null);
        if (!_equals) {
          _and = false;
        } else {
          boolean _isStatic = ((XFeatureCall)sourceCandidate).isStatic();
          _and = _isStatic;
        }
        if (_and) {
          _matched_1=true;
          this.addReferenceToTypeFromStaticImport(((XAbstractFeatureCall)sourceCandidate), targetURIs, acceptor);
        }
      }
    }
    if (!_matched_1) {
      if (sourceCandidate instanceof XMemberFeatureCall) {
        _matched_1=true;
        boolean _and = false;
        boolean _isStatic = ((XMemberFeatureCall)sourceCandidate).isStatic();
        if (!_isStatic) {
          _and = false;
        } else {
          boolean _isStaticWithDeclaringType = ((XMemberFeatureCall)sourceCandidate).isStaticWithDeclaringType();
          boolean _not = (!_isStaticWithDeclaringType);
          _and = _not;
        }
        if (_and) {
          this.addReferenceToTypeFromStaticImport(((XAbstractFeatureCall)sourceCandidate), targetURIs, acceptor);
        }
      }
    }
    if (!_matched_1) {
      if (sourceCandidate instanceof AnonymousClass) {
        _matched_1=true;
        this.addReferencesToSuper(((AnonymousClass)sourceCandidate), targetURIs, acceptor);
      }
    }
  }
  
  protected void addReferencesToSuper(final AnonymousClass anonymousClass, final TargetURIs targetURISet, final IReferenceFinder.Acceptor acceptor) {
    final XConstructorCall constructorCall = anonymousClass.getConstructorCall();
    final JvmGenericType superType = this._anonymousClassUtil.getSuperType(anonymousClass);
    if (superType!=null) {
      this.addReferenceIfTarget(superType, targetURISet, constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, acceptor);
    }
    final JvmConstructor superConstructor = this._anonymousClassUtil.getSuperTypeConstructor(anonymousClass);
    if (superConstructor!=null) {
      this.addReferenceIfTarget(superConstructor, targetURISet, constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, acceptor);
    }
  }
  
  protected void addReferenceToFeatureFromStaticImport(final XImportDeclaration importDeclaration, final TargetURIs targetURISet, final IReferenceFinder.Acceptor acceptor) {
    Iterable<JvmFeature> _allFeatures = this._staticallyImportedMemberProvider.getAllFeatures(importDeclaration);
    final Procedure1<JvmFeature> _function = new Procedure1<JvmFeature>() {
      @Override
      public void apply(final JvmFeature it) {
        XtendReferenceFinder.this.addReferenceIfTarget(it, targetURISet, importDeclaration, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, acceptor);
      }
    };
    IterableExtensions.<JvmFeature>forEach(_allFeatures, _function);
  }
  
  protected void addReferenceToTypeFromStaticImport(final XAbstractFeatureCall sourceCandidate, final TargetURIs targetURISet, final IReferenceFinder.Acceptor acceptor) {
    final JvmIdentifiableElement feature = sourceCandidate.getFeature();
    if ((feature instanceof JvmMember)) {
      final JvmDeclaredType type = ((JvmMember)feature).getDeclaringType();
      this.addReferenceIfTarget(type, targetURISet, sourceCandidate, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, acceptor);
    }
  }
  
  protected void addReferenceIfTarget(final EObject candidate, final TargetURIs targetURISet, final EObject sourceElement, final EReference reference, final IReferenceFinder.Acceptor acceptor) {
    final URI candidateURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(candidate);
    boolean _contains = targetURISet.contains(candidateURI);
    if (_contains) {
      final URI sourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceElement);
      acceptor.accept(sourceElement, sourceURI, reference, (-1), candidate, candidateURI);
    }
  }
}
