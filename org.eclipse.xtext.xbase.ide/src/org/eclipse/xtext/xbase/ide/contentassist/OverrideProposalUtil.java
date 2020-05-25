/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class OverrideProposalUtil {
	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;

	@Inject
	private OverrideHelper overrideHelper;

	@Inject
	private IVisibilityHelper visibilityHelper;

	public List<IResolvedExecutable> getImplementationCandidates(JvmDeclaredType type, boolean isAnonymous) {
		if (type == null || !(type instanceof JvmGenericType)) {
			return Collections.emptyList();
		}
		JavaVersion sourceVersion = generatorConfigProvider.get(type).getJavaSourceVersion();
		ResolvedFeatures resolvedFeatures = overrideHelper.getResolvedFeatures(type, sourceVersion);
		List<IResolvedExecutable> result = new ArrayList<>();
		ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(visibilityHelper,
				resolvedFeatures.getType());
		addOperationCandidates(resolvedFeatures, contextualVisibilityHelper, result);
		if (!isAnonymous && !((JvmGenericType) type).isInterface()) {
			addConstructorCandidates(resolvedFeatures, contextualVisibilityHelper, result);
		}
		return result;
	}

	protected void addOperationCandidates(ResolvedFeatures resolvedFeatures, IVisibilityHelper visibilityHelper,
			List<IResolvedExecutable> result) {
		List<IResolvedOperation> allOperations = resolvedFeatures.getAllOperations();
		LightweightTypeReference inferredType = resolvedFeatures.getType();
		for (IResolvedOperation operation : allOperations) {
			if (isCandidate(inferredType, operation, visibilityHelper)) {
				result.add(operation);
			}
		}
	}

	protected void addConstructorCandidates(ResolvedFeatures resolvedFeatures, IVisibilityHelper visibilityHelper,
			List<IResolvedExecutable> result) {
		LightweightTypeReference typeReference = resolvedFeatures.getType();
		List<LightweightTypeReference> superTypes = typeReference.getSuperTypes();
		for (LightweightTypeReference superType : superTypes) {
			if (!superType.isInterfaceType()) {
				List<IResolvedConstructor> declaredConstructors = resolvedFeatures.getDeclaredConstructors();
				Set<String> erasedSignatures = Sets.<String>newHashSet();
				for (IResolvedConstructor constructor : declaredConstructors) {
					erasedSignatures.add(constructor.getResolvedErasureSignature());
				}
				ResolvedFeatures superClass = overrideHelper.getResolvedFeatures(superType);
				for (IResolvedConstructor superclassConstructor : superClass.getDeclaredConstructors()) {
					IResolvedConstructor overriddenConstructor = new ResolvedConstructor(
							superclassConstructor.getDeclaration(), typeReference);
					if (isCandidate(typeReference, overriddenConstructor, visibilityHelper)) {
						if (erasedSignatures.add(superclassConstructor.getResolvedErasureSignature())) {
							result.add(overriddenConstructor);
						}
					}
				}
				return;
			}
		}
	}

	protected boolean isCandidate(LightweightTypeReference type, IResolvedExecutable executable,
			IVisibilityHelper visibilityHelper) {
		JvmDeclaredType declaringType = executable.getDeclaration().getDeclaringType();
		if (type.getType() != declaringType && isVisible(executable, visibilityHelper)) {
			JvmExecutable rawExecutable = executable.getDeclaration();
			if (rawExecutable instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) rawExecutable;
				if (operation.isFinal() || operation.isStatic()) {
					return false;
				} else {
					if (type.getType() instanceof JvmGenericType && ((JvmGenericType) type.getType()).isInterface()) {
						return  declaringType instanceof JvmGenericType
								&& ((JvmGenericType) declaringType).isInterface() && !operation.isAbstract();
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

	protected boolean isVisible(IResolvedExecutable executable, IVisibilityHelper visibilityHelper) {
		return visibilityHelper.isVisible(executable.getDeclaration());
	}
}
