/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.findReferences;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    final Set<QualifiedName> names = this.declarators.getDeclaratorData(targetURIs, resourceAccess).getDeclaratorNames();
    boolean _isCanceled = monitor.isCanceled();
    if (_isCanceled) {
      throw new OperationCanceledException();
    }
    final Set<QualifiedName> importedNames = IterableExtensions.<QualifiedName>toSet(resourceDescription.getImportedNames());
    final Function1<QualifiedName, Boolean> _function = (QualifiedName it) -> {
      return Boolean.valueOf(importedNames.contains(it));
    };
    boolean _exists = IterableExtensions.<QualifiedName>exists(names, _function);
    if (_exists) {
      final IUnitOfWork<Object, ResourceSet> _function_1 = (ResourceSet it) -> {
        this.findReferences(targetURIs, it.getResource(resourceDescription.getURI(), true), acceptor, monitor);
        return null;
      };
      resourceAccess.<Object>readOnly(resourceDescription.getURI(), _function_1);
    }
  }

  @Override
  protected void findLocalReferencesFromElement(final Predicate<URI> targetURIs, final EObject sourceCandidate, final Resource localResource, final IReferenceFinder.Acceptor acceptor) {
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
      if ((((XImportDeclaration)sourceCandidate).isStatic() && (!((XImportDeclaration)sourceCandidate).isWildcard()))) {
        _matched_1=true;
        this.addReferenceToFeatureFromStaticImport(((XImportDeclaration)sourceCandidate), targetURIs, acceptor);
      }
    }
    if (!_matched_1) {
      if (sourceCandidate instanceof XFeatureCall) {
        if (((((XFeatureCall)sourceCandidate).getActualReceiver() == null) && ((XFeatureCall)sourceCandidate).isStatic())) {
          _matched_1=true;
          this.addReferenceToTypeFromStaticImport(((XAbstractFeatureCall)sourceCandidate), targetURIs, acceptor);
        }
      }
    }
    if (!_matched_1) {
      if (sourceCandidate instanceof XMemberFeatureCall) {
        _matched_1=true;
        if ((((XMemberFeatureCall)sourceCandidate).isStatic() && (!((XMemberFeatureCall)sourceCandidate).isStaticWithDeclaringType()))) {
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

  protected void addReferencesToSuper(final AnonymousClass anonymousClass, final Predicate<URI> targetURISet, final IReferenceFinder.Acceptor acceptor) {
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

  protected void addReferenceToFeatureFromStaticImport(final XImportDeclaration importDeclaration, final Predicate<URI> targetURISet, final IReferenceFinder.Acceptor acceptor) {
    final Consumer<JvmFeature> _function = (JvmFeature it) -> {
      this.addReferenceIfTarget(it, targetURISet, importDeclaration, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, acceptor);
    };
    this._staticallyImportedMemberProvider.getAllFeatures(importDeclaration).forEach(_function);
  }

  protected void addReferenceToTypeFromStaticImport(final XAbstractFeatureCall sourceCandidate, final Predicate<URI> targetURISet, final IReferenceFinder.Acceptor acceptor) {
    final JvmIdentifiableElement feature = sourceCandidate.getFeature();
    if ((feature instanceof JvmMember)) {
      final JvmDeclaredType type = ((JvmMember)feature).getDeclaringType();
      this.addReferenceIfTarget(type, targetURISet, sourceCandidate, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, acceptor);
    }
  }

  protected void addReferenceIfTarget(final EObject candidate, final Predicate<URI> targetURISet, final EObject sourceElement, final EReference reference, final IReferenceFinder.Acceptor acceptor) {
    final URI candidateURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(candidate);
    boolean _apply = targetURISet.apply(candidateURI);
    if (_apply) {
      final URI sourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceElement);
      acceptor.accept(sourceElement, sourceURI, reference, (-1), candidate, candidateURI);
    }
  }
}
