/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class StackedResolvedTypes extends ResolvedTypes {

	private final ResolvedTypes parent;
	private Optional<Map<JvmIdentifiableElement, LightweightTypeReference>> flattenedReassignedTypes;

	protected StackedResolvedTypes(ResolvedTypes parent) {
		super(parent.shared);
		this.parent = parent;
	}
	
	@Override
	protected void clear() {
		flattenedReassignedTypes = null;
		super.clear();
	}
	
	protected ResolvedTypes getParent() {
		return parent;
	}
	
	protected void mergeIntoParent() {
		prepareMergeIntoParent();
		performMergeIntoParent();
	}
	
	protected void prepareMergeIntoParent() {
		// override in subtypes
	}
	
	protected void performMergeIntoParent() {
		ResolvedTypes parent = getParent();
		mergeInto(parent);
		clear();
	}
	
	protected void mergeInto(ResolvedTypes parent) {
		mergeTypeParametersIntoParent(parent);
		mergeExpressionTypesIntoParent(parent);
		mergeTypesIntoParent(parent);
		mergeLinkingCandidatesIntoParent(parent);
		mergeQueuedDiagnostics(parent);
		mergeDeferredRunnables(parent);
		mergePropagatedTypes(parent);
		mergeRefinedTypes(parent);
	}
	
	protected void mergePropagatedTypes(ResolvedTypes parent) {
		for(XExpression expression: basicGetPropagatedTypes()) {
			parent.setPropagatedType(expression);
		}
	}
	
	protected void mergeRefinedTypes(ResolvedTypes parent) {
		for(XExpression expression: basicGetRefinedTypes()) {
			parent.setRefinedType(expression);
		}
	}
	
	@Override
	protected boolean isPropagatedType(XExpression expression) {
		if (super.isPropagatedType(expression)) {
			return true;
		}
		return parent.isPropagatedType(expression);
	}
	
	@Override
	public boolean isRefinedType(XExpression expression) {
		if (super.isRefinedType(expression)) {
			return true;
		}
		return parent.isRefinedType(expression);
	}

	protected void mergeQueuedDiagnostics(ResolvedTypes parent) {
		Collection<AbstractDiagnostic> diagnostics = super.getQueuedDiagnostics();
		for(AbstractDiagnostic diagnostic: diagnostics) {
			parent.addDiagnostic(diagnostic);
		}
	}
	
	protected void mergeDeferredRunnables(ResolvedTypes parent) {
		Collection<IAcceptor<? super IResolvedTypes>> runnables = super.getDeferredLogic();
		for(IAcceptor<? super IResolvedTypes> runnable: runnables) {
			parent.addDeferredLogic(runnable);
		}
	}

	protected void mergeExpressionTypesIntoParent(ResolvedTypes parent) {
		Map<XExpression, List<TypeData>> expressionTypes = basicGetExpressionTypes();
		if (!expressionTypes.isEmpty()) {
			for(Map.Entry<XExpression, List<TypeData>> entry: expressionTypes.entrySet()) {
				List<TypeData> list = entry.getValue();
				for (int i = 0, size = list.size(); i < size; i++) {
					parent.acceptType(entry.getKey(), prepareMerge(list.get(i), parent.getReferenceOwner()));
				}
			}
		}
	}
	
	protected TypeData prepareMerge(TypeData typeData, ITypeReferenceOwner owner) {
		LightweightTypeReference typeReference = typeData.getActualType();
		if (typeData.isOwnedBy(owner) && !(typeReference instanceof UnboundTypeReference))
			return typeData;
		if (typeReference instanceof UnboundTypeReference && super.isResolved(((UnboundTypeReference) typeReference).getHandle())) {
			typeReference = typeReference.getUpperBoundSubstitute();
		}
		return new TypeData(typeData.getExpression(), typeData.getExpectation().copyInto(owner), typeReference.copyInto(owner), typeData.getConformanceFlags(), typeData.isReturnType());
	}
	
	protected void mergeLinkingCandidatesIntoParent(ResolvedTypes parent) {
		Map<XExpression, IApplicableCandidate> linkingCandidates = basicGetLinkingMap();
		if (!linkingCandidates.isEmpty()) {
			for(Map.Entry<XExpression, IApplicableCandidate> entry: linkingCandidates.entrySet()) {
				parent.acceptCandidate(entry.getKey(), entry.getValue());
			}
		}
	}

	protected void mergeTypesIntoParent(ResolvedTypes parent) {
		Map<JvmIdentifiableElement, LightweightTypeReference> types = basicGetTypes();
		if (!types.isEmpty()) {
			for(Map.Entry<JvmIdentifiableElement, LightweightTypeReference> entry: types.entrySet()) {
				LightweightTypeReference value = entry.getValue();
				if (value instanceof UnboundTypeReference && super.isResolved(((UnboundTypeReference) value).getHandle())) {
					parent.setType(entry.getKey(), value.getUpperBoundSubstitute().copyInto(parent.getReferenceOwner()));
				} else {
					parent.setType(entry.getKey(), value.copyInto(parent.getReferenceOwner()));
				}
			}
		}
	}

	protected void mergeTypeParametersIntoParent(ResolvedTypes parent) {
		for(UnboundTypeReference unbound: basicGetTypeParameters().values()) {
			LightweightTypeReference resolvedTo = unbound.getResolvedTo();
			if (resolvedTo == null) {
				List<JvmTypeParameter> typeParameters = basicGetDeclardTypeParameters();
				if (typeParameters != null && typeParameters.contains(unbound.getTypeParameter())) {
					unbound.tryResolve();
					if (!unbound.internalIsResolved()) {
						if (unbound.getExpression() instanceof XConstructorCall) {
							unbound.resolve(); // resolve against constraints 
						} else {
							unbound.acceptHint(unbound.getOwner().newParameterizedTypeReference(unbound.getTypeParameter()), 
									BoundTypeArgumentSource.RESOLVED, unbound, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
						}
					}
				} else {
					LightweightTypeReference reference = unbound.copyInto(parent.getReferenceOwner());
					if (reference instanceof UnboundTypeReference) {
						parent.acceptUnboundTypeReference(unbound.getHandle(), (UnboundTypeReference) reference);
					}
				}
			}
		}
		Map<Object, List<LightweightBoundTypeArgument>> typeParameterHints = basicGetTypeParameterHints();
		for(Map.Entry<Object, List<LightweightBoundTypeArgument>> hint: typeParameterHints.entrySet()) {
			if (!parent.isResolved(hint.getKey())) {
				List<LightweightBoundTypeArgument> boundTypeArguments = hint.getValue();
				for(LightweightBoundTypeArgument boundTypeArgument: boundTypeArguments) {
					if (boundTypeArgument.getOrigin() instanceof VarianceInfo) {
						parent.acceptHint(hint.getKey(), boundTypeArgument);
					} else {
						LightweightBoundTypeArgument copy = new LightweightBoundTypeArgument(
								boundTypeArgument.getTypeReference().copyInto(parent.getReferenceOwner()), 
								boundTypeArgument.getSource(), boundTypeArgument.getOrigin(), 
								boundTypeArgument.getDeclaredVariance(), 
								boundTypeArgument.getActualVariance());
						parent.acceptHint(hint.getKey(), copy);
					}
				}
			}
		}
	}
	
	@Override
	protected boolean doIsResolved(Object handle) {
		boolean result = super.doIsResolved(handle) || parent.doIsResolved(handle);
		return result;
	}

	@Override
	/* @Nullable */
	protected List<TypeData> doGetTypeData(XExpression expression) {
		List<TypeData> result = super.doGetTypeData(expression);
		if (result == null) {
			result = parent.doGetTypeData(expression);
		}
		return result;
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference doGetActualTypeNoDeclaration(JvmIdentifiableElement identifiable, boolean ignoreReassignedTypes) {
		LightweightTypeReference result = super.doGetActualTypeNoDeclaration(identifiable, ignoreReassignedTypes);
		if (result == null) {
			result = parent.doGetActualTypeNoDeclaration(identifiable, ignoreReassignedTypes);
		}
		return result;
	}
	
	@Override
	protected boolean isRefinedType(JvmIdentifiableElement element) {
		if (super.isRefinedType(element)) {
			return true;
		}
		return parent.isRefinedType(element);
	}
	
	@Override
	/* @Nullable */
	protected IApplicableCandidate doGetCandidate(/* @Nullable */ XExpression featureOrConstructorCall) {
		IApplicableCandidate result = super.doGetCandidate(featureOrConstructorCall);
		if (result != null)
			return result;
		return parent.doGetCandidate(featureOrConstructorCall);
	}
	
	@Override
	/* @Nullable */
	protected JvmIdentifiableElement doGetLinkedFeature(/* @Nullable */ XExpression featureOrConstructorCall) {
		JvmIdentifiableElement result = super.doGetLinkedFeature(featureOrConstructorCall);
		if (result != null)
			return result;
		return parent.doGetLinkedFeature(featureOrConstructorCall);
	}
	
	@Override
	public List<LightweightTypeReference> getExpectedExceptions() {
		return parent.getExpectedExceptions();
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference doGetDeclaredType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = shared.root.doGetDeclaredType(identifiable);
		return result;
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		List<JvmTypeParameter> result = basicGetDeclardTypeParameters();
		if (result != null)
			return result;
		return parent.getDeclaredTypeParameters();
	}
	
	@Override
	public void addDeclaredTypeParameters(List<JvmTypeParameter> typeParameters) {
		if (typeParameters.isEmpty())
			return;
		List<JvmTypeParameter> list = basicGetDeclardTypeParameters();
		if (list == null) {
			super.addDeclaredTypeParameters(parent.getDeclaredTypeParameters());
			getDeclaredTypeParameters().addAll(typeParameters);
		} else { 
			list.addAll(typeParameters);
		}
	}
	
	public void replaceDeclaredTypeParameters(List<JvmTypeParameter> typeParameters) {
		List<JvmTypeParameter> list = basicGetDeclardTypeParameters();
		if (list != null) {
			throw new IllegalStateException("Cannot replace declared type parameters if there are already type parameters in this StackedResolvedTypes");
		}
		super.addDeclaredTypeParameters(typeParameters);
	}
	
	@Override
	/* @Nullable */
	protected List<LightweightTypeReference> doGetActualTypeArguments(XExpression expression) {
		List<LightweightTypeReference> result = super.doGetActualTypeArguments(expression);
		if (result == null) {
			result = parent.doGetActualTypeArguments(expression);
		}
		return result;
	}
	
	@Override
	/* @Nullable */
	protected IFeatureLinkingCandidate doGetFeature(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = super.doGetFeature(featureCall);
		if (result == null) {
			result = parent.doGetFeature(featureCall);
		}
		return result;
	}
	
	@Override
	/* @Nullable */
	protected IConstructorLinkingCandidate doGetConstructor(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = super.doGetConstructor(constructorCall);
		if (result == null) {
			result = parent.doGetConstructor(constructorCall);
		}
		return result;
	}
	
	@Override
	public void reassignType(JvmIdentifiableElement identifiable, /* @Nullable */ LightweightTypeReference reference) {
		super.reassignType(identifiable, reference);
		if (reference == null) {
			getParent().reassignType(identifiable, reference);
		}
		flattenedReassignedTypes = null;
	}
	
	@Override
	public List<AbstractDiagnostic> getQueuedDiagnostics() {
		List<AbstractDiagnostic> result = Lists.newArrayList(super.getQueuedDiagnostics());
		result.addAll(parent.getQueuedDiagnostics());
		return result;
	}
	
	@Override
	public Collection<IAcceptor<? super IResolvedTypes>> getDeferredLogic() {
		List<IAcceptor<? super IResolvedTypes>> result = Lists.newArrayList(super.getDeferredLogic());
		result.addAll(parent.getDeferredLogic());
		return result;
	}
	
	@Override
	protected UnboundTypeReference getUnboundTypeReference(Object handle) {
		UnboundTypeReference result = basicGetTypeParameters().get(handle);
		if (result == null) {
			result = parent.getUnboundTypeReference(handle);
			if (result.internalIsResolved())
				throw new IllegalStateException("Cannot query unbound reference that was already resolved");
			return (UnboundTypeReference) result.copyInto(getReferenceOwner());
		}
		return result;
	}
	
	@Override
	protected void refineExpectedType(XExpression receiver, ITypeExpectation refinedExpectation) {
		Collection<TypeData> typeData = basicGetExpressionTypes().get(receiver);
		if (typeData == null) {
			getParent().refineExpectedType(receiver, refinedExpectation);
		} else {
			super.refineExpectedType(receiver, refinedExpectation);
		}
	}
	
	@Override
	protected List<LightweightBoundTypeArgument> getHints(Object handle) {
		List<LightweightBoundTypeArgument> result = super.getHints(handle);
		if (result.size() == 1 && super.isResolved(handle)) {
			return result;
		}
		List<LightweightBoundTypeArgument> parentHints = getParent().getHints(handle);
		if (parentHints.size() == 1 && getParent().isResolved(handle)) {
			LightweightBoundTypeArgument parentHint = parentHints.get(0);
			LightweightBoundTypeArgument copy = new LightweightBoundTypeArgument(
					parentHint.getTypeReference().copyInto(getReferenceOwner()), 
					parentHint.getSource(), parentHint.getOrigin(), 
					parentHint.getDeclaredVariance(), 
					parentHint.getActualVariance());
			return Collections.singletonList(copy);
		}
		if (parentHints.isEmpty())
			return result;
		List<LightweightBoundTypeArgument> withParentHints = Lists.newArrayListWithCapacity(parentHints.size() + result.size());
		for(LightweightBoundTypeArgument parentHint: parentHints) {
			if (parentHint.getTypeReference() == null) {
				withParentHints.add(parentHint);
			} else {
				LightweightBoundTypeArgument copy = new LightweightBoundTypeArgument(
						parentHint.getTypeReference().copyInto(getReferenceOwner()), 
						parentHint.getSource(), 
						parentHint.getOrigin(), 
						parentHint.getDeclaredVariance(), 
						parentHint.getActualVariance());
				withParentHints.add(copy);
			}
		}
		withParentHints.addAll(result);
		return withParentHints;
	}
	
	protected int getConformanceFlags(XExpression expression, boolean recompute) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData == null) {
			throw new IllegalStateException();
		}
		return getConformanceFlags(typeData, recompute);
	}

	@Override
	protected void appendContent(StringBuilder result, String indentation) {
		super.appendContent(result, indentation);
		result.append("\n" + indentation + "parent: [");
		parent.appendContent(result, indentation + "  ");
		closeBracket(result, indentation);
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedTypeForAssociatedExpression(JvmMember member, XExpression expression) {
		return parent.getExpectedTypeForAssociatedExpression(member, expression);
	}
	
	@Override
	protected void markToBeInferred(XExpression expression) {
		parent.markToBeInferred(expression);
	}

	@Override
	/* @Nullable */
	protected Map<JvmIdentifiableElement, LightweightTypeReference> getFlattenedReassignedTypes() {
		if (flattenedReassignedTypes != null) {
			// already computed
			return flattenedReassignedTypes.orNull();
		}
		Map<JvmIdentifiableElement, LightweightTypeReference> result = parent.getFlattenedReassignedTypes();
		if (result == null) {
			// parent doesn't have reassigned types
			// use only locally reassigned types
			return (flattenedReassignedTypes = Optional.fromNullable(super.getFlattenedReassignedTypes())).orNull();
		}
		Map<JvmIdentifiableElement, LightweightTypeReference> myReassignedTypes = basicGetReassignedTypes();
		if (myReassignedTypes.isEmpty()) {
			// no locally reassigned types, use result from parent which was already checked for null
			return (flattenedReassignedTypes = Optional.of(result)).orNull();
		}
		// merge parent's reassigned types and locally reassigned types
		result = Maps.newHashMap(result);
		result.putAll(myReassignedTypes);
		return (flattenedReassignedTypes = Optional.of(result)).orNull();
	}
}
