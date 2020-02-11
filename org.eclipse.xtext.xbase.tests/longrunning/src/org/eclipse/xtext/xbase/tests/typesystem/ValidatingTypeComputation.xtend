/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.internal.AbstractTypeExpectation
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.ExpressionAwareStackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.ReassigningStackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.StackedResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.TypeData
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sebastian Zarnekow
 */
class ValidatingBatchTypeResolver extends DefaultBatchTypeResolver {

	@Inject
	Provider<ValidatingReentrantTypeResolver> resolverProvider;

	override createResolver() {
		resolverProvider.get
	}

}

/**
 * @author Sebastian Zarnekow
 */
class ValidatingReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	override createResolvedTypes(CancelIndicator monitor) {
		return new ValidatingRootResolvedTypes(this, monitor)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class ValidatingRootResolvedTypes extends RootResolvedTypes {
	
	new(DefaultReentrantTypeResolver resolver, CancelIndicator monitor) {
		super(resolver, monitor)
	}
	
	override pushReassigningTypes() {
		return new ValidatingReassigningResolvedTypes(this)
	}
	
	override pushTypes() {
		return new ValidatingStackedResolvedTypes(this)
	}
	
	override pushTypes(XExpression context) {
		return new ValidatingExpressionAwareResolvedTypes(this, context)
	}
	
	override setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (!reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.setType(identifiable, reference)
	}
	
	override reassignType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (reference !== null && !reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.reassignType(identifiable, reference)
	}
	
	override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.typeReference !== null && !boundTypeArgument.typeReference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.acceptHint(handle, boundTypeArgument)
	}
	
	override protected getHints(Object handle) {
		val result = super.getHints(handle)
		result.forEach[ 
			if (typeReference !== null && !typeReference.isOwnedBy(referenceOwner))
				throw new IllegalArgumentException("reference is not owned by this resolved types")
		]
		return result
	}
	
	override acceptType(XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int hints) {
		if (!expectation.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("expectation is not owned by this resolved types")
		if (!type.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("type is not owned by this resolved types")
		super.acceptType(expression, expectation, type, returnType, hints)
	}
	
	override getAllHints(Object handle) {
		val result = super.getAllHints(handle)
		result.forEach [
			if (typeReference !== null &&!typeReference.isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("hint is not owned by this resolved types")
		]
		return result
	}
	
	override getUnboundTypeReference(Object handle) {
		val result = super.getUnboundTypeReference(handle)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(JvmIdentifiableElement identifiable) {
		val result = super.getActualType(identifiable)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(XExpression expression) {
		val result = super.getActualType(expression)
		if (result !== null && !result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getExpectedType(XExpression expression) {
		val result = super.getExpectedType(expression)
		if (result !== null && !result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getMergedType(List<LightweightTypeReference> types) {
		types.forEach [
			if (!isOwnedBy(getOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.getMergedType(types)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override mergeTypeData(XExpression expression, List<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		allValues.forEach [
			if (!isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override acceptType(XExpression expression, TypeData typeData) {
		if (!typeData.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("typeData is not owned by this resolved types") 
		}
		super.acceptType(expression, typeData)
	}
	
	override acceptUnboundTypeReference(Object handle, UnboundTypeReference reference) {
		if (!reference.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("reference is not owned by this resolved types") 
		}
		super.acceptUnboundTypeReference(handle, reference)
	}
	
	override doGetTypeData(XExpression expression) {
		val result = super.doGetTypeData(expression)
		result?.forEach [
			if (!isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		return result
	}

}

class ValidatingExpressionAwareResolvedTypes extends ExpressionAwareStackedResolvedTypes {
	
	new(ResolvedTypes parent, XExpression expression) {
		super(parent, expression)
	}
	
	override pushReassigningTypes() {
		return new ValidatingReassigningResolvedTypes(this)
	}
	
	override pushTypes() {
		return new ValidatingStackedResolvedTypes(this)
	}
	
	override pushTypes(XExpression context) {
		return new ValidatingExpressionAwareResolvedTypes(this, context)
	}
	
	override setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (!reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.setType(identifiable, reference)
	}
	
	override reassignType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (reference !== null && !reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.reassignType(identifiable, reference)
	}
	
	override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.typeReference !== null && !boundTypeArgument.typeReference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.acceptHint(handle, boundTypeArgument)
	}
	
	override protected getHints(Object handle) {
		val result = super.getHints(handle)
		result.forEach[ 
			if (typeReference !== null && !typeReference.isOwnedBy(referenceOwner))
				throw new IllegalArgumentException("reference is not owned by this resolved types")
		]
		return result
	}
	
	override acceptType(XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int hints) {
		if (!expectation.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("expectation is not owned by this resolved types")
		if (!type.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("type is not owned by this resolved types")
		super.acceptType(expression, expectation, type, returnType, hints)
	}
	
	override getAllHints(Object handle) {
		val result = super.getAllHints(handle)
		result.forEach [
			if (typeReference !== null && !typeReference.isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("hint is not owned by this resolved types")
		]
		return result
	}
	
	override getUnboundTypeReference(Object handle) {
		val result = super.getUnboundTypeReference(handle)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(JvmIdentifiableElement identifiable) {
		val result = super.getActualType(identifiable)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(XExpression expression) {
		val result = super.getActualType(expression)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getExpectedType(XExpression expression) {
		val result = super.getExpectedType(expression)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getMergedType(List<LightweightTypeReference> types) {
		types.forEach [
			if (!isOwnedBy(getOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.getMergedType(types)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override mergeTypeData(XExpression expression, List<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		allValues.forEach [
			if (!isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty)
		if (result !== null && !result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
}

class ValidatingStackedResolvedTypes extends StackedResolvedTypes {
	
	new(ResolvedTypes parent) {
		super(parent)
	}
	
	override pushReassigningTypes() {
		return new ValidatingReassigningResolvedTypes(this)
	}
	
	override pushTypes() {
		return new ValidatingStackedResolvedTypes(this)
	}
	
	override pushTypes(XExpression context) {
		return new ValidatingExpressionAwareResolvedTypes(this, context)
	}
	
	override setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (!reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.setType(identifiable, reference)
	}
	
	override reassignType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (reference !== null && !reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.reassignType(identifiable, reference)
	}
	
	override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.typeReference !== null && !boundTypeArgument.typeReference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.acceptHint(handle, boundTypeArgument)
	}
	
	override protected getHints(Object handle) {
		val result = super.getHints(handle)
		result.forEach[ 
			if (typeReference !== null && !typeReference.isOwnedBy(referenceOwner))
				throw new IllegalArgumentException("reference is not owned by this resolved types")
		]
		return result
	}
	
	override acceptType(XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int hints) {
		if (!expectation.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("expectation is not owned by this resolved types")
		if (!type.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("type is not owned by this resolved types")
		super.acceptType(expression, expectation, type, returnType, hints)
	}
	
	override getAllHints(Object handle) {
		val result = super.getAllHints(handle)
		result.forEach [
			if (typeReference !== null && !typeReference.isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("hint is not owned by this resolved types")
		]
		return result
	}
	
	override getUnboundTypeReference(Object handle) {
		val result = super.getUnboundTypeReference(handle)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(JvmIdentifiableElement identifiable) {
		val result = super.getActualType(identifiable)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(XExpression expression) {
		val result = super.getActualType(expression)
		if (result !== null && !result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getExpectedType(XExpression expression) {
		val result = super.getExpectedType(expression)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getMergedType(List<LightweightTypeReference> types) {
		types.forEach [
			if (!isOwnedBy(getOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.getMergedType(types)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override mergeTypeData(XExpression expression, List<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		allValues.forEach [
			if (!isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
}

class ValidatingReassigningResolvedTypes extends ReassigningStackedResolvedTypes {
	
	new(ResolvedTypes parent) {
		super(parent)
	}
	
	override pushReassigningTypes() {
		return new ValidatingReassigningResolvedTypes(this)
	}
	
	override pushTypes() {
		return new ValidatingStackedResolvedTypes(this)
	}
	
	override pushTypes(XExpression context) {
		return new ValidatingExpressionAwareResolvedTypes(this, context)
	}
	
	override setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (!reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.setType(identifiable, reference)
	}
	
	override reassignType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (reference !== null && !reference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.reassignType(identifiable, reference)
	}
	
	override acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.typeReference !== null && !boundTypeArgument.typeReference.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("reference is not owned by this resolved types")
		super.acceptHint(handle, boundTypeArgument)
	}
	
	override protected getHints(Object handle) {
		val result = super.getHints(handle)
		result.forEach[ 
			if (typeReference !== null && !typeReference.isOwnedBy(referenceOwner))
				throw new IllegalArgumentException("reference is not owned by this resolved types")
		]
		return result
	}
	
	override acceptType(XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int hints) {
		if (!expectation.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("expectation is not owned by this resolved types")
		if (!type.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("type is not owned by this resolved types")
		super.acceptType(expression, expectation, type, returnType, hints)
	}
	
	override getAllHints(Object handle) {
		val result = super.getAllHints(handle)
		result.forEach [
			if (typeReference !== null &&!typeReference.isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("hint is not owned by this resolved types")
		]
		return result
	}
	
	override getUnboundTypeReference(Object handle) {
		val result = super.getUnboundTypeReference(handle)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(JvmIdentifiableElement identifiable) {
		val result = super.getActualType(identifiable)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getActualType(XExpression expression) {
		val result = super.getActualType(expression)
		if (result !== null && !result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getExpectedType(XExpression expression) {
		val result = super.getExpectedType(expression)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override getMergedType(List<LightweightTypeReference> types) {
		types.forEach [
			if (!isOwnedBy(getOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.getMergedType(types)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
	override mergeTypeData(XExpression expression, List<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		allValues.forEach [
			if (!isOwnedBy(getReferenceOwner()))
				throw new IllegalArgumentException("result is not owned by this resolved types")
		]
		val result = super.mergeTypeData(expression, allValues, returnType, nullIfEmpty)
		if (!result.isOwnedBy(getReferenceOwner()))
			throw new IllegalArgumentException("result is not owned by this resolved types")
		return result
	}
	
}

