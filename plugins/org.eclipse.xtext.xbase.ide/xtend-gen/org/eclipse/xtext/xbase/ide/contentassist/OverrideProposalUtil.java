/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
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
    GeneratorConfig _get = this.generatorConfigProvider.get(type);
    JavaVersion sourceVersion = _get.getJavaSourceVersion();
    ResolvedFeatures resolvedFeatures = this.overrideHelper.getResolvedFeatures(type, sourceVersion);
    List<IResolvedExecutable> result = Lists.<IResolvedExecutable>newArrayList();
    LightweightTypeReference _type = resolvedFeatures.getType();
    ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(this.visibilityHelper, _type);
    this.addOperationCandidates(resolvedFeatures, contextualVisibilityHelper, result);
    boolean _and = false;
    if (!(!isAnonymous)) {
      _and = false;
    } else {
      boolean _isInterface = ((JvmGenericType) type).isInterface();
      boolean _not = (!_isInterface);
      _and = _not;
    }
    if (_and) {
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
          String _resolvedErasureSignature = constructor.getResolvedErasureSignature();
          erasedSignatures.add(_resolvedErasureSignature);
        }
        ResolvedFeatures superClass = this.overrideHelper.getResolvedFeatures(superType);
        List<IResolvedConstructor> constructors = superClass.getDeclaredConstructors();
        for (final IResolvedConstructor constructor_1 : constructors) {
          {
            JvmConstructor _declaration = constructor_1.getDeclaration();
            IResolvedConstructor overriddenConstructor = new ResolvedConstructor(_declaration, typeReference);
            boolean _isCandidate = this.isCandidate(typeReference, overriddenConstructor, visibilityHelper);
            if (_isCandidate) {
              String _resolvedErasureSignature_1 = constructor_1.getResolvedErasureSignature();
              boolean _add = erasedSignatures.add(_resolvedErasureSignature_1);
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
    JvmExecutable _declaration = executable.getDeclaration();
    JvmDeclaredType declaringType = _declaration.getDeclaringType();
    boolean _and = false;
    JvmType _type = type.getType();
    boolean _tripleNotEquals = (_type != declaringType);
    if (!_tripleNotEquals) {
      _and = false;
    } else {
      boolean _isVisible = this.isVisible(executable, visibilityHelper);
      _and = _isVisible;
    }
    if (_and) {
      JvmExecutable rawExecutable = executable.getDeclaration();
      if ((rawExecutable instanceof JvmOperation)) {
        JvmOperation operation = ((JvmOperation)rawExecutable);
        boolean _or = false;
        boolean _isFinal = operation.isFinal();
        if (_isFinal) {
          _or = true;
        } else {
          boolean _isStatic = operation.isStatic();
          _or = _isStatic;
        }
        if (_or) {
          return false;
        } else {
          boolean _and_1 = false;
          JvmType _type_1 = type.getType();
          if (!(_type_1 instanceof JvmGenericType)) {
            _and_1 = false;
          } else {
            JvmType _type_2 = type.getType();
            boolean _isInterface = ((JvmGenericType) _type_2).isInterface();
            _and_1 = _isInterface;
          }
          if (_and_1) {
            boolean _and_2 = false;
            boolean _and_3 = false;
            if (!(declaringType instanceof JvmGenericType)) {
              _and_3 = false;
            } else {
              boolean _isInterface_1 = ((JvmGenericType) declaringType).isInterface();
              _and_3 = _isInterface_1;
            }
            if (!_and_3) {
              _and_2 = false;
            } else {
              boolean _isAbstract = operation.isAbstract();
              boolean _not = (!_isAbstract);
              _and_2 = _not;
            }
            return _and_2;
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
    JvmExecutable _declaration = executable.getDeclaration();
    return visibilityHelper.isVisible(_declaration);
  }
}
