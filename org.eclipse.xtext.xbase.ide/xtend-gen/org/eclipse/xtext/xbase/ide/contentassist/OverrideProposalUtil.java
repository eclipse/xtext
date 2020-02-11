/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

@SuppressWarnings("all")
public class OverrideProposalUtil {
  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;
  
  @Inject
  private OverrideHelper overrideHelper;
  
  @Inject
  private IVisibilityHelper visibilityHelper;
  
  public List<IResolvedExecutable> getImplementationCandidates(final JvmDeclaredType type, final boolean isAnonymous) {
    if (((type == null) || (!(type instanceof JvmGenericType)))) {
      return Collections.<IResolvedExecutable>emptyList();
    }
    JavaVersion sourceVersion = this.generatorConfigProvider.get(type).getJavaSourceVersion();
    ResolvedFeatures resolvedFeatures = this.overrideHelper.getResolvedFeatures(type, sourceVersion);
    List<IResolvedExecutable> result = Lists.<IResolvedExecutable>newArrayList();
    LightweightTypeReference _type = resolvedFeatures.getType();
    ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(this.visibilityHelper, _type);
    this.addOperationCandidates(resolvedFeatures, contextualVisibilityHelper, result);
    if (((!isAnonymous) && (!((JvmGenericType) type).isInterface()))) {
      this.addConstructorCandidates(resolvedFeatures, contextualVisibilityHelper, result);
    }
    return result;
  }
  
  protected void addOperationCandidates(final ResolvedFeatures resolvedFeatures, final IVisibilityHelper visibilityHelper, final List<IResolvedExecutable> result) {
    List<IResolvedOperation> allOperations = resolvedFeatures.getAllOperations();
    LightweightTypeReference inferredType = resolvedFeatures.getType();
    for (final IResolvedOperation operation : allOperations) {
      boolean _isCandidate = this.isCandidate(inferredType, operation, visibilityHelper);
      if (_isCandidate) {
        result.add(operation);
      }
    }
  }
  
  protected void addConstructorCandidates(final ResolvedFeatures resolvedFeatures, final IVisibilityHelper visibilityHelper, final List<IResolvedExecutable> result) {
    LightweightTypeReference typeReference = resolvedFeatures.getType();
    List<LightweightTypeReference> superTypes = typeReference.getSuperTypes();
    for (final LightweightTypeReference superType : superTypes) {
      boolean _isInterfaceType = superType.isInterfaceType();
      boolean _not = (!_isInterfaceType);
      if (_not) {
        List<IResolvedConstructor> declaredConstructors = resolvedFeatures.getDeclaredConstructors();
        Set<String> erasedSignatures = Sets.<String>newHashSet();
        for (final IResolvedConstructor constructor : declaredConstructors) {
          erasedSignatures.add(constructor.getResolvedErasureSignature());
        }
        ResolvedFeatures superClass = this.overrideHelper.getResolvedFeatures(superType);
        List<IResolvedConstructor> constructors = superClass.getDeclaredConstructors();
        for (final IResolvedConstructor constructor_1 : constructors) {
          {
            JvmConstructor _declaration = constructor_1.getDeclaration();
            IResolvedConstructor overriddenConstructor = new ResolvedConstructor(_declaration, typeReference);
            boolean _isCandidate = this.isCandidate(typeReference, overriddenConstructor, visibilityHelper);
            if (_isCandidate) {
              boolean _add = erasedSignatures.add(constructor_1.getResolvedErasureSignature());
              if (_add) {
                result.add(overriddenConstructor);
              }
            }
          }
        }
        return;
      }
    }
  }
  
  protected boolean isCandidate(final LightweightTypeReference type, final IResolvedExecutable executable, final IVisibilityHelper visibilityHelper) {
    JvmDeclaredType declaringType = executable.getDeclaration().getDeclaringType();
    if (((type.getType() != declaringType) && this.isVisible(executable, visibilityHelper))) {
      JvmExecutable rawExecutable = executable.getDeclaration();
      if ((rawExecutable instanceof JvmOperation)) {
        JvmOperation operation = ((JvmOperation)rawExecutable);
        if ((operation.isFinal() || operation.isStatic())) {
          return false;
        } else {
          if (((type.getType() instanceof JvmGenericType) && ((JvmGenericType) type.getType()).isInterface())) {
            return (((declaringType instanceof JvmGenericType) && ((JvmGenericType) declaringType).isInterface()) && (!operation.isAbstract()));
          } else {
            return true;
          }
        }
      } else {
        return true;
      }
    }
    return false;
  }
  
  protected boolean isVisible(final IResolvedExecutable executable, final IVisibilityHelper visibilityHelper) {
    return visibilityHelper.isVisible(executable.getDeclaration());
  }
}
