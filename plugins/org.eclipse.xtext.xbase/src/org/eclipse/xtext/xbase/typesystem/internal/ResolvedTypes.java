/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.BaseResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.MultimapJoiner;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
public abstract class ResolvedTypes extends BaseResolvedTypes {

	protected class Owner implements TypeReferenceOwner {

		public CommonTypeComputationServices getServices() {
			return ResolvedTypes.this.getServices();
		}

		public ResourceSet getContextResourceSet() {
			return ResolvedTypes.this.getContextResourceSet();
		}

		public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
			ResolvedTypes.this.acceptHint(handle, boundTypeArgument);
		}

		public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
			return ResolvedTypes.this.getAllHints(handle);
		}

		public boolean isResolved(Object handle) {
			return ResolvedTypes.this.isResolved(handle);
		}
		
	}
	
	private final DefaultReentrantTypeResolver resolver;
	
	private Map<JvmIdentifiableElement, LightweightTypeReference> types;
	private Map<JvmIdentifiableElement, LightweightTypeReference> reassignedTypes;
	private Multimap<XExpression, TypeData> expressionTypes;
	private Map<Object, UnboundTypeReference> unboundTypeParameters;
	private ListMultimap<Object, LightweightBoundTypeArgument> typeParameterHints;
	private Set<Object> resolvedTypeParameters;
	private Map<XExpression, ILinkingCandidate<?>> featureLinking;
	
	protected ResolvedTypes(DefaultReentrantTypeResolver resolver) {
		this.resolver = resolver;
	}
	
	@Override
	protected OwnedConverter createConverter() {
		return new OwnedConverter(new Owner());
	}
	
	public ResourceSet getContextResourceSet() {
		return resolver.getRoot().eResource().getResourceSet();
	}
	
	// overridden because we want it to be accessible from within this package
	@Override
	protected OwnedConverter getConverter() {
		return super.getConverter();
	}

	public CommonTypeComputationServices getServices() {
		return resolver.getServices();
	}

	public List<Diagnostic> getQueuedDiagnostics() {
		throw new UnsupportedOperationException("TODO implement me");
	}

	@Nullable
	protected TypeData getTypeData(XExpression expression, boolean returnType) {
		Collection<TypeData> values = doGetTypeData(expression);
		if (values == null) {
			return null;
		}
		TypeData result = mergeTypeData(expression, values, returnType, false);
		return result;
	}
	
	@Nullable
	protected Collection<TypeData> doGetTypeData(XExpression expression) {
		Collection<TypeData> result = basicGetExpressionTypes().get(expression);
		if (result.isEmpty())
			return null;
		return result;
	}
	
	@Nullable
	protected TypeData mergeTypeData(final XExpression expression, Collection<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		List<TypeData> values = Lists.newArrayListWithCapacity(allValues.size());
		for(TypeData value: allValues) {
			if (returnType == value.isReturnType()) {
				values.add(value);
			}
		}
		if (values.isEmpty() && nullIfEmpty) {
			return null;
		}
		if (values.size() == 1) {
			TypeData typeData = values.get(0);
			return typeData;
		}
		
//		final XComputedTypeReference mergedType = getXtypeFactory().createXComputedTypeReference();
//		mergedType.setTypeProvider(new AbstractReentrantTypeReferenceProvider() {
//			@Override
//			protected LightweightTypeReference doGetTypeReference() {
//				Collection<TypeData> freshlyObtainedValues = ensureExpressionTypesMapExists().get(expression);
				List<LightweightTypeReference> references = Lists.newArrayList();
				for(TypeData value: values) {
					LightweightTypeReference reference = value.getActualType();
//					if (returnType == value.isReturnType() && isValidForMergedResult(reference, mergedType)) {
						references.add(reference);
//					}
				}
				LightweightTypeReference mergedType = getMergedType(references);
//			}
//		});
		// TODO improve - return error type information
		if (mergedType == null)
			return null;
		TypeData result = new TypeData(expression, values.get(0).getExpectation() /* TODO use all expectations? */, mergedType, ConformanceHint.MERGED /* TODO do we need that? */, returnType);
		return result;
	}
	
//	protected boolean isValidForMergedResult(LightweightTypeReference reference, LightweightTypeReference mayNotBe) {
//		if (reference == mayNotBe || reference == null)
//			return false;
//		if (reference instanceof CompoundTypeReference) {
//			List<LightweightTypeReference> components = ((CompoundTypeReference) reference).getComponents();
//			if (components.isEmpty())
//				return false;
//			for(LightweightTypeReference component: components) {
//				if (!isValidForMergedResult(component, mayNotBe)) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}

	@Nullable
	protected LightweightTypeReference getMergedType(List<LightweightTypeReference> types) {
		if (types.isEmpty()) {
			return null;
		}
		if (types.size() == 1) {
			LightweightTypeReference result = types.get(0);
			return result;
		}
		LightweightTypeReference result = getServices().getTypeConformanceComputer().getCommonSuperType(types);
		if (result != null || types.isEmpty()) {
			return result;
		}
		// common type of JvmAnyType and JvmVoid may be null ... use JvmAnyType in that case
		for (LightweightTypeReference type: types) {
			if (!type.isType(Void.TYPE)) {
				return type;
			}
		}
		return types.get(0);
	}

	@Nullable
	public LightweightTypeReference internalGetActualType(XExpression expression) {
		LightweightTypeReference result = doGetActualType(expression);
		return toOwnedReference(result);
	}

	@Nullable
	protected LightweightTypeReference toOwnedReference(@Nullable LightweightTypeReference result) {
		return result != null ? result.copyInto(getReferenceOwner()) : null;
	}

	@Nullable
	protected LightweightTypeReference doGetActualType(XExpression expression) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData != null)
			return typeData.getActualType();
		return null;
	}
	
	@Nullable
	public LightweightTypeReference internalGetExpectedType(XExpression expression) {
		LightweightTypeReference result = doGetExpectedType(expression);
		return toOwnedReference(result);
	}

	@Nullable
	protected LightweightTypeReference doGetExpectedType(XExpression expression) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData != null)
			return typeData.getExpectation().internalGetExpectedType();
		return null;
	}
	
	public final List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression) {
		List<LightweightTypeReference> result = doGetActualTypeArguments(expression);
		if (result == null)
			return Collections.emptyList();
		return result;
	}
	
	@Nullable
	protected List<LightweightTypeReference> doGetActualTypeArguments(XExpression expression) {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public void setType(JvmIdentifiableElement identifiable, JvmTypeReference reference) {
		setType(identifiable, getConverter().toLightweightReference(reference));
	}
	
	public void reassignType(JvmIdentifiableElement identifiable, JvmTypeReference reference) {
		reassignType(identifiable, getConverter().toLightweightReference(reference));
	}

	public void setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		if (ensureTypesMapExists().put(identifiable, reference) != null) {
			throw new IllegalStateException("identifiable was already typed");
		}
	}
	
	public void reassignType(JvmIdentifiableElement identifiable, @Nullable LightweightTypeReference reference) {
		if (reference != null) {
			LightweightTypeReference actualType = internalGetActualType(identifiable);
			if (actualType != null) {
				if (!reference.isAssignableFrom(actualType)) {
					if (actualType.isAssignableFrom(reference)) {
						ensureReassignedTypesMapExists().put(identifiable, reference);
					} else {
						CompoundTypeReference multiType = actualType.toMultiType(reference);
						ensureReassignedTypesMapExists().put(identifiable, multiType);					
					}
				}
			} else {
				ensureReassignedTypesMapExists().put(identifiable, reference);
			}
		} else {
			ensureReassignedTypesMapExists().remove(identifiable);
		}
	}
	
	protected LightweightTypeReference acceptType(final XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, ConformanceHint conformanceHint, boolean returnType) {
		if (!type.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("type is associated with an incompatible owner");
		}
		if (!expectation.isOwnedBy(getReferenceOwner())) {
			throw new IllegalArgumentException("expected type is associated with an incompatible owner");
		}
		
//		AbstractTypeComputationState state = expectation.getState();
		// expectation is type parameter - type is actual - bind type
		// no expectation, type wrap type and add pending type parameter data that should be resolved later on demand
		// this will resolve them to their type parameter constraints if any and no other thing is available
		// mind the conformance hint
		
		TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), getReferenceOwner()) {
			@Override
			protected LightweightTypeReference getUnmappedSubstitute(
					ParameterizedTypeReference reference,
					JvmTypeParameter type, 
					ConstraintVisitingInfo visiting) {
				// TODO extract method 'isExpressionWithTypeArguments'
				if (expression instanceof XAbstractFeatureCall || expression instanceof XConstructorCall || expression instanceof XClosure) {
					return createUnboundTypeReference(expression, type);
				} else {
					throw new IllegalStateException("expression was: " + expression);
				}
			}
			
			@Override
			protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference,
					ConstraintVisitingInfo visiting) {
				return reference;
			}
			
		};
		LightweightTypeReference actualType = substitutor.substitute(type);
		acceptType(expression, new TypeData(expression, expectation, actualType, conformanceHint, returnType));
		return actualType;
	}
	
	protected void acceptType(XExpression expression, TypeData typeData) {
		ensureExpressionTypesMapExists().put(expression, typeData);
	}
	
	protected Map<JvmIdentifiableElement, LightweightTypeReference> basicGetTypes() {
		return types != null ? types : Collections.<JvmIdentifiableElement, LightweightTypeReference>emptyMap(); 
	}

	private Map<JvmIdentifiableElement, LightweightTypeReference> ensureTypesMapExists() {
		if (types == null) {
			types = Maps.newLinkedHashMap();
		}
		return types;
	}

	private Map<JvmIdentifiableElement, LightweightTypeReference> ensureReassignedTypesMapExists() {
		if (reassignedTypes == null) {
			reassignedTypes = Maps.newLinkedHashMap();
		}
		return reassignedTypes;
	}
	
	protected Multimap<XExpression, TypeData> basicGetExpressionTypes() {
		return expressionTypes != null ? expressionTypes : ImmutableMultimap.<XExpression, TypeData>of();
	}
	
	private Multimap<XExpression, TypeData> ensureExpressionTypesMapExists() {
		if (expressionTypes == null) {
			expressionTypes = createExpressionTypesMap();
		}
		return expressionTypes;
	}
	
	private Multimap<XExpression, TypeData> createExpressionTypesMap() {
		return createMultiMap();
	}

	protected ListMultimap<Object, LightweightBoundTypeArgument> basicGetTypeParameterHints() {
		return typeParameterHints != null ? typeParameterHints : ImmutableListMultimap.<Object, LightweightBoundTypeArgument>of();
	}
	
	private ListMultimap<Object, LightweightBoundTypeArgument> ensureTypeParameterHintsMapExists() {
		if (typeParameterHints == null) {
			typeParameterHints = createMultiMap();
		}
		return typeParameterHints;
	}

	private <K, V> ListMultimap<K, V> createMultiMap() {
		return Multimaps2.newLinkedHashListMultimap(2, 2);
	}
	
	private Map<XExpression, ILinkingCandidate<?>> ensureLinkingMapExists() {
		if (featureLinking == null) {
			featureLinking = Maps.newLinkedHashMap();
		}
		return featureLinking;
	}
	
	protected Map<XExpression, ILinkingCandidate<?>> basicGetLinkingCandidates() {
		return featureLinking != null ? featureLinking : Collections.<XExpression, ILinkingCandidate<?>>emptyMap();
	}
	
	@Nullable
	public LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = doGetActualType(identifiable);
		return toOwnedReference(result);
	}

	@Nullable
	protected LightweightTypeReference doGetActualType(JvmIdentifiableElement identifiable) {
		if (reassignedTypes != null) {
			LightweightTypeReference result = reassignedTypes.get(identifiable);
			if (result != null) {
				return result;
			}
		}
		if (types == null)
			return getDeclaredType(identifiable);
		LightweightTypeReference result = basicGetTypes().get(identifiable);
		if (result == null) {
			return getDeclaredType(identifiable);
		}
		return result;
	}
	
	@Nullable
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmOperation) {
			return getConverter().toLightweightReference(((JvmOperation) identifiable).getReturnType());
		}
		if (identifiable instanceof JvmField) {
			return getConverter().toLightweightReference(((JvmField) identifiable).getType());
		}
		if (identifiable instanceof JvmConstructor) {
			return getConverter().toLightweightReference(resolver.getServices().getTypeReferences().createTypeRef(((JvmConstructor) identifiable).getDeclaringType()));
		}
		return null;
	}
	
	@Nullable
	public IFeatureLinkingCandidate getFeature(XAbstractFeatureCall featureCall) {
		return (IFeatureLinkingCandidate) basicGetLinkingCandidates().get(featureCall);
	}
	
	@Nullable
	public IConstructorLinkingCandidate getConstructor(XConstructorCall constructorCall) {
		return (IConstructorLinkingCandidate) basicGetLinkingCandidates().get(constructorCall);
	}

	public void acceptLinkingInformation(XExpression expression, ILinkingCandidate<?> candidate) {
		if (ensureLinkingMapExists().put(expression, candidate) != null) {
			throw new IllegalStateException("Expression was already linked");
		}
	}

	protected DefaultReentrantTypeResolver getResolver() {
		return resolver;
	}
	
	protected UnboundTypeReference getUnboundTypeReference(Object handle) {
		UnboundTypeReference result = basicGetTypeParameters().get(handle);
		if (result == null) {
			throw new IllegalStateException("Could not find type parameter");
		}
		if (result.internalIsResolved())
			throw new IllegalStateException("Cannot query unbount type reference that was already resolved");
		return result;
	}

	protected UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter type) {
		UnboundTypeReference result = new UnboundTypeReference(getReferenceOwner(), expression, type);
		acceptUnboundTypeReference(result.getHandle(), result);
		return result;
	}

	protected void acceptUnboundTypeReference(Object handle, UnboundTypeReference reference) {
		ensureTypeParameterMapExists().put(handle, reference);
	}
	
	protected Map<Object, UnboundTypeReference> basicGetTypeParameters() {
		return unboundTypeParameters != null ? unboundTypeParameters : Collections.<Object, UnboundTypeReference>emptyMap();
	}
	
	private Map<Object, UnboundTypeReference> ensureTypeParameterMapExists() {
		if (unboundTypeParameters == null) {
			unboundTypeParameters = Maps.newLinkedHashMap();
		}
		return unboundTypeParameters;
	}

	protected UnboundTypeParameterPreservingSubstitutor createSubstitutor(
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping) {
		return new UnboundTypeParameterPreservingSubstitutor(typeParameterMapping, getReferenceOwner());
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getSimpleName()).append(": [");
		appendContent(result, "  ");
		closeBracket(result, "");
		return result.toString();
	}

	protected void closeBracket(StringBuilder result, String indentation) {
		if (result.charAt(result.length() - 1) != '[')
			result.append('\n').append(indentation).append("]");
		else
			result.append("]");
	}

	protected void appendContent(StringBuilder result, String indentation) {
		appendContent(types, "types", result, indentation);
		appendContent(reassignedTypes, "reassignedTypes", result, indentation);
		appendContent(expressionTypes, "expressionTypes", result, indentation);
		appendContent(featureLinking, "featureLinking", result, indentation);
		appendContent(unboundTypeParameters, "unboundTypeParameters", result, indentation);
		appendContent(typeParameterHints, "typeParameterHints", result, indentation);
	}

	protected void appendContent(@Nullable Map<?, ?> map, String prefix, StringBuilder result, String indentation) {
		if (map != null) {
			MapJoiner joiner = Joiner.on("\n" + indentation).withKeyValueSeparator(" -> ");
			result.append("\n" + indentation).append(prefix).append(": ");
			joiner.appendTo(result, map);
		}
	}
	
	protected void appendContent(@Nullable Multimap<?, ?> map, String prefix, StringBuilder result, String indentation) {
		if (map != null) {
			MultimapJoiner joiner = new MultimapJoiner(Joiner.on("\n  " + indentation), "\n" + indentation, " -> ");
			result.append("\n" + indentation).append(prefix).append(": ");
			joiner.appendTo(result, map);
		}
	}

	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.getSource() == BoundTypeArgumentSource.RESOLVED) {
			if (resolvedTypeParameters == null) {
				resolvedTypeParameters = Sets.newHashSetWithExpectedSize(3);
			}
			if (resolvedTypeParameters.add(handle)) {
				ensureTypeParameterHintsMapExists().replaceValues(handle, Collections.singletonList(boundTypeArgument));
			}
		} else {
			if (!isResolved(handle)) {
				if (boundTypeArgument.getTypeReference() instanceof UnboundTypeReference) {
					UnboundTypeReference other = (UnboundTypeReference) boundTypeArgument.getTypeReference();
					UnboundTypeReference currentUnbound = getUnboundTypeReference(handle);
					ensureTypeParameterHintsMapExists().put(
							other.getHandle(),
							new LightweightBoundTypeArgument(currentUnbound, boundTypeArgument.getSource(),
									boundTypeArgument.getOrigin(), boundTypeArgument.getDeclaredVariance(),
									boundTypeArgument.getActualVariance()));
				}
				ensureTypeParameterHintsMapExists().put(handle, boundTypeArgument);
			} else {
				throw new IllegalStateException("Cannot add hints if the reference was already resolved");
			}
		}
	}
	
	public boolean isResolved(Object handle) {
		return resolvedTypeParameters != null && resolvedTypeParameters.contains(handle);
	}

	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		List<LightweightBoundTypeArgument> actualHints = getHints(handle);
		int i = 0;
		while(i < actualHints.size()) {
			LightweightBoundTypeArgument hint = actualHints.get(i);
			if (hint.getTypeReference() instanceof UnboundTypeReference) {
				break;
			}
			i++;
		}
		if (i >= actualHints.size())
			return actualHints;
		List<LightweightBoundTypeArgument> transitivity = Lists.newArrayList();
		Set<Object> seenHandles = Sets.newHashSet(handle); 
		transitivity.addAll(actualHints.subList(0, i));
		List<LightweightBoundTypeArgument> allRemaining = actualHints.subList(i, actualHints.size());
		addNonRecursiveHints(allRemaining, seenHandles, transitivity);
		return transitivity;
	}

	protected List<LightweightBoundTypeArgument> getHints(Object handle) {
		return basicGetTypeParameterHints().get(handle);
	}

	protected void addNonRecursiveHints(List<LightweightBoundTypeArgument> hints, Set<Object> seenHandles,
			List<LightweightBoundTypeArgument> result) {
		for(LightweightBoundTypeArgument hint: hints) {
			LightweightTypeReference reference = hint.getTypeReference();
			if (reference instanceof UnboundTypeReference) {
				Object otherHandle = ((UnboundTypeReference) reference).getHandle();
				if (seenHandles.add(otherHandle)) {
					addNonRecursiveHints(getHints(otherHandle), seenHandles, result);
				}
			} else {
				result.add(hint);
			}
		}
	}
	
	protected StackedResolvedTypes pushTypes() {
		return new StackedResolvedTypes(this);
	}
	
	protected ExpressionAwareStackedResolvedTypes pushTypes(XExpression context) {
		return new ExpressionAwareStackedResolvedTypes(this, context);
	}
	
	protected StackedResolvedTypes pushReassigningTypes() {
		return new ReassigningStackedResolvedTypes(this);
	}

}
