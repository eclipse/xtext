/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist

import com.google.common.collect.Sets
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedExecutable
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedOperation
import org.eclipse.xtext.xbase.typesystem.^override.OverrideHelper
import org.eclipse.xtext.xbase.typesystem.^override.ResolvedConstructor
import org.eclipse.xtext.xbase.typesystem.^override.ResolvedFeatures
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper

import static com.google.common.collect.Lists.newArrayList

/**
 * 
 */
class OverrideProposalUtil {

	@Inject IGeneratorConfigProvider generatorConfigProvider
	@Inject OverrideHelper overrideHelper
	@Inject IVisibilityHelper visibilityHelper

	def List<IResolvedExecutable> getImplementationCandidates(JvmDeclaredType type, boolean isAnonymous) {
		if (type === null || !(type instanceof JvmGenericType))
			return Collections.emptyList()

		var JavaVersion sourceVersion = generatorConfigProvider.get(type).getJavaSourceVersion()
		var ResolvedFeatures resolvedFeatures = overrideHelper.getResolvedFeatures(type, sourceVersion)
		var List<IResolvedExecutable> result = newArrayList()
		var ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(visibilityHelper, resolvedFeatures.getType())
		addOperationCandidates(resolvedFeatures, contextualVisibilityHelper, result)
		if (!isAnonymous && !(type as JvmGenericType).isInterface())
			addConstructorCandidates(resolvedFeatures, contextualVisibilityHelper, result)
		return result
	}

	def protected void addOperationCandidates(ResolvedFeatures resolvedFeatures, IVisibilityHelper visibilityHelper, List<IResolvedExecutable> result) {
		var List<IResolvedOperation> allOperations = resolvedFeatures.getAllOperations()
		var LightweightTypeReference inferredType = resolvedFeatures.getType()
		for (IResolvedOperation operation : allOperations) {
			if (isCandidate(inferredType, operation, visibilityHelper)) {
				result.add(operation)
			}
		}
	}

	def protected void addConstructorCandidates(ResolvedFeatures resolvedFeatures, IVisibilityHelper visibilityHelper, List<IResolvedExecutable> result) {
		var LightweightTypeReference typeReference = resolvedFeatures.getType()
		var List<LightweightTypeReference> superTypes = typeReference.getSuperTypes()
		for (LightweightTypeReference superType : superTypes) {
			if (!superType.isInterfaceType()) {
				var List<IResolvedConstructor> declaredConstructors = resolvedFeatures.getDeclaredConstructors()
				var Set<String> erasedSignatures = Sets.newHashSet()
				for (IResolvedConstructor constructor : declaredConstructors) {
					erasedSignatures.add(constructor.getResolvedErasureSignature())
				}
				var ResolvedFeatures superClass = overrideHelper.getResolvedFeatures(superType)
				var List<IResolvedConstructor> constructors = superClass.getDeclaredConstructors()
				for (IResolvedConstructor constructor : constructors) {
					var IResolvedConstructor overriddenConstructor = new ResolvedConstructor(constructor.getDeclaration(), typeReference)
					if (isCandidate(typeReference, overriddenConstructor, visibilityHelper)) {
						if (erasedSignatures.add(constructor.getResolvedErasureSignature())) result.add(overriddenConstructor)
					}
				}
				return;
			}
		}
	}

	def protected boolean isCandidate(LightweightTypeReference type, IResolvedExecutable executable, IVisibilityHelper visibilityHelper) {
		var JvmDeclaredType declaringType = executable.getDeclaration().getDeclaringType()
		if (type.getType() !== declaringType && isVisible(executable, visibilityHelper)) {
			var JvmExecutable rawExecutable = executable.getDeclaration()
			if (rawExecutable instanceof JvmOperation) {
				var JvmOperation operation = rawExecutable
				if (operation.isFinal() || operation.isStatic())
					return false
				else if (type.getType() instanceof JvmGenericType && (type.getType() as JvmGenericType).isInterface())
					return declaringType instanceof JvmGenericType && (declaringType as JvmGenericType).isInterface() && !operation.isAbstract()
				else
					return true
			} else {
				return true
			}
		}
		return false
	}

	def protected boolean isVisible(IResolvedExecutable executable, IVisibilityHelper visibilityHelper) {
		// TODO check parameter types
		return visibilityHelper.isVisible(executable.getDeclaration())
	}

}