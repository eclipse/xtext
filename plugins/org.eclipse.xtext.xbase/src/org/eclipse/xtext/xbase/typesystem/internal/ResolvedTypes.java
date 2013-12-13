/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintVisitingInfo;
import org.eclipse.xtext.xbase.typesystem.util.CustomTypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.eclipse.xtext.xbase.typesystem.util.MultimapJoiner;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
public abstract class ResolvedTypes implements IResolvedTypes {

	protected class Owner implements ITypeReferenceOwner {

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
		
		public List<JvmTypeParameter> getDeclaredTypeParameters() {
			return ResolvedTypes.this.getDeclaredTypeParameters();
		}
		
		@Override
		public String toString() {
			return String.format("Owner: %s", ResolvedTypes.this);
		}
		
	}
	
	private final OwnedConverter converter;

	private final DefaultReentrantTypeResolver resolver;
	
	private Set<AbstractDiagnostic> diagnostics;
	private Map<JvmIdentifiableElement, LightweightTypeReference> types;
	private Map<JvmIdentifiableElement, LightweightTypeReference> reassignedTypes;
	private Map<XExpression, List<TypeData>> expressionTypes;
	private Map<XExpression, ILinkingCandidate> featureLinking;
	private Map<Object, UnboundTypeReference> unboundTypeParameters;
	private Map<Object, List<LightweightBoundTypeArgument>> typeParameterHints;
	private Set<Object> resolvedTypeParameters;
	private Set<XExpression> refinedTypes;
	private Set<XExpression> propagatedTypes;
	private List<JvmTypeParameter> declaredTypeParameters;
	
	protected ResolvedTypes(DefaultReentrantTypeResolver resolver) {
		this.resolver = resolver;
		this.converter = createConverter();
	}
	
	protected void clear() {
		diagnostics = null;
		types = null;
		reassignedTypes = null;
		expressionTypes = null;
		featureLinking = null;
		unboundTypeParameters = null;
		typeParameterHints = null;
		resolvedTypeParameters = null;
		propagatedTypes = null;
		refinedTypes = null;
	}
	
	protected abstract IssueSeverities getSeverities();
	
	protected OwnedConverter getConverter() {
		return converter;
	}
	
	public ITypeReferenceOwner getReferenceOwner() {
		return getConverter().getOwner();
	}
	
	protected OwnedConverter createConverter() {
		return new OwnedConverter(new Owner());
	}
	
	public ResourceSet getContextResourceSet() {
		return resolver.getRoot().eResource().getResourceSet();
	}

	public CommonTypeComputationServices getServices() {
		return resolver.getServices();
	}

	public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
		if (diagnostics == null)
			return Collections.emptyList();
		return diagnostics;
	}
	
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		if (diagnostics == null) {
			diagnostics = Sets.newLinkedHashSet();
		}
		if (!diagnostics.add(diagnostic)) {
			throw new IllegalStateException("Duplicate diagnostic: " + diagnostic);
		}
	}
	
	@Nullable
	public JvmIdentifiableElement getLinkedFeature(@Nullable XAbstractFeatureCall featureCall) {
		return doGetLinkedFeature(featureCall);
	}
	
	@Nullable
	public JvmIdentifiableElement getLinkedFeature(@Nullable XConstructorCall constructorCall) {
		return doGetLinkedFeature(constructorCall);
	}
	
	@Nullable
	public IFeatureLinkingCandidate getLinkingCandidate(@Nullable XAbstractFeatureCall featureCall) {
		return (IFeatureLinkingCandidate) doGetLinkingCandidate(featureCall);
	}
	
	@Nullable
	public IConstructorLinkingCandidate getLinkingCandidate(@Nullable XConstructorCall constructorCall) {
		return (IConstructorLinkingCandidate) doGetLinkingCandidate(constructorCall);
	}
	
	@Nullable
	protected ILinkingCandidate doGetLinkingCandidate(@Nullable XExpression featureOrConstructorCall) {
		if (featureLinking == null || featureOrConstructorCall == null)
			return null;
		ILinkingCandidate candidate = featureLinking.get(featureOrConstructorCall);
		return candidate;
	}
	
	@Nullable
	protected JvmIdentifiableElement doGetLinkedFeature(@Nullable XExpression featureOrConstructorCall) {
		if (featureLinking == null || featureOrConstructorCall == null)
			return null;
		ILinkingCandidate candidate = featureLinking.get(featureOrConstructorCall);
		if (candidate == null)
			return null;
		return candidate.getFeature();
	}

	@Nullable
	protected TypeData getTypeData(XExpression expression, boolean returnType) {
		return getTypeData(expression, returnType, false);
	}
	
	@Nullable
	protected TypeData getTypeData(XExpression expression, boolean returnType, boolean nullIfEmpty) {
		Collection<TypeData> values = doGetTypeData(expression);
		if (values == null) {
			return null;
		}
		TypeData result = mergeTypeData(expression, values, returnType, nullIfEmpty);
		return result;
	}
	
	@Nullable
	protected Collection<TypeData> doGetTypeData(XExpression expression) {
		List<TypeData> result = basicGetExpressionTypes().get(expression);
		return result;
	}
	
	private static class MergeData {
		List<LightweightTypeReference> references = Lists.newArrayList();
		boolean voidSeen = false;
		ITypeExpectation expectation = null;
		boolean allNoImplicitReturn = true;
		EnumSet<ConformanceHint> mergedHints = EnumSet.of(ConformanceHint.MERGED);
	}
	
	@Nullable
	protected TypeData mergeTypeData(final XExpression expression, Collection<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		List<TypeData> values = Lists.newArrayListWithCapacity(allValues.size());
		collectValues(allValues, returnType, values);
		if (values.isEmpty()) {
			if (nullIfEmpty || allValues.isEmpty())
				return null;
			if (returnType) {
				values.addAll(allValues);
			}
		}
		if (values.size() == 1) {
			TypeData typeData = values.get(0);
			LightweightTypeReference upperBoundSubstitute = typeData.getActualType().getUpperBoundSubstitute();
			if (upperBoundSubstitute != typeData.getActualType())
				return new TypeData(expression, typeData.getExpectation(), upperBoundSubstitute, typeData.getConformanceHints(), returnType);
			return typeData;
		}
		MergeData mergeData = new MergeData();
		enhanceMergeData(values, mergeData);
		LightweightTypeReference mergedType = getMergedType(mergeData, values);
		// TODO improve - return error type information
		if (mergedType == null)
			return null;
		if (mergeData.expectation == null) {
			throw new IllegalStateException("Expectation should never be null here");
		}
		mergedType = refineMergedType(mergeData, mergedType, returnType, nullIfEmpty);
		TypeData result = new TypeData(expression, mergeData.expectation, mergedType, mergeData.mergedHints , returnType);
		return result;
	}

	private LightweightTypeReference refineMergedType(MergeData mergeData, LightweightTypeReference mergedType, boolean returnType, boolean useExpectation) {
		if (useExpectation && mergeData.expectation != null && (returnType || !mergeData.allNoImplicitReturn)) {
			LightweightTypeReference expectedType = mergeData.expectation.getExpectedType();
			if (expectedType != null && expectedType.isResolved()) {
				if (!expectedType.isAssignableFrom(mergedType)) {
					boolean valid = true;
					for (LightweightTypeReference mergedReference: mergeData.references) {
						if (!expectedType.isAssignableFrom(mergedReference)) {
							valid = false;
							break;
						}
					}
					if (valid)
						mergedType = expectedType; // branches have already been validated
				}
			}
		}
		if (mergeData.voidSeen && returnType && !mergeData.references.isEmpty()) {
			mergedType = mergedType.getWrapperTypeIfPrimitive();
		}
		return mergedType;
	}

	@Nullable
	private LightweightTypeReference getMergedType(MergeData mergeData, List<TypeData> values) {
		LightweightTypeReference mergedType = !mergeData.references.isEmpty() || !mergeData.voidSeen ? getMergedType(/*mergedHints, */mergeData.references) : values.get(0).getActualType();
		return mergedType;
	}

	private void enhanceMergeData(List<TypeData> values, MergeData mergeData) {
		for (TypeData value : values) {
			LightweightTypeReference reference = value.getActualType().getUpperBoundSubstitute();
			if (reference.isPrimitiveVoid()) {
				if (value.getConformanceHints().contains(ConformanceHint.EXPLICIT_VOID_RETURN)) {
					mergeData.references.clear();
					mergeData.references.add(reference);
					mergeData.mergedHints.clear();
					mergeData.mergedHints.addAll(value.getConformanceHints());
					mergeData.expectation = value.getExpectation();
					mergeData.voidSeen = false;
					return;
				}
				mergeData.voidSeen = true;
			} else {
				mergeData.references.add(reference);
			}
			mergeData.allNoImplicitReturn = mergeData.allNoImplicitReturn && value.getConformanceHints().contains(ConformanceHint.NO_IMPLICIT_RETURN); 
			mergeData.mergedHints.addAll(value.getConformanceHints());
			if (mergeData.expectation == null) {
				mergeData.expectation = value.getExpectation();
			} else if (mergeData.expectation.getExpectedType() == null) {
				ITypeExpectation knownExpectation = value.getExpectation();
				if (knownExpectation.getExpectedType() != null) {
					mergeData.expectation = knownExpectation;
				}
			}
		}
		if (!mergeData.allNoImplicitReturn) {
			mergeData.mergedHints.remove(ConformanceHint.NO_IMPLICIT_RETURN);
		}
	}

	private void collectValues(Collection<TypeData> allValues, boolean returnType, List<TypeData> result) {
		for(TypeData value: allValues) {
			if (returnType == value.isReturnType()) {
				result.add(value);
			}
		}
	}

	@Nullable
	protected LightweightTypeReference getMergedType(List<LightweightTypeReference> types) {
		if (types.isEmpty()) {
			return null;
		}
		if (types.size() == 1) {
			LightweightTypeReference result = types.get(0);
			return result;
		}
		LightweightTypeReference result = getServices().getTypeConformanceComputer().getCommonSuperType(types, getReferenceOwner());
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
	public LightweightTypeReference getActualType(XExpression expression) {
		LightweightTypeReference result = doGetActualType(expression);
		return toOwnedReference(result);
	}
	
	@Nullable
	protected abstract LightweightTypeReference getExpectedTypeForAssociatedExpression(JvmMember member, XExpression expression);
	
	@Nullable
	public LightweightTypeReference getReturnType(XExpression expression) {
		LightweightTypeReference result = doGetReturnType(expression);
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
	protected LightweightTypeReference doGetReturnType(XExpression expression) {
		TypeData typeData = getTypeData(expression, true);
		if (typeData != null)
			return typeData.getActualType();
		return null;
	}
	
	@Nullable
	public LightweightTypeReference getExpectedType(XExpression expression) {
		LightweightTypeReference result = doGetExpectedType(expression, false);
		return toOwnedReference(result);
	}
	
	protected ResolvedTypes pushExpectedExceptions(List<LightweightTypeReference> exceptions) {
		return new ExpectedExceptionsStackedResolvedTypes(this, exceptions);
	}
	
	protected ResolvedTypes discardExpectedExceptions() {
		return new ExpectedExceptionsStackedResolvedTypes(this);
	}
	
	protected ResolvedTypes pushExpectedExceptions(JvmExecutable exceptionDeclarator) {
		List<JvmTypeReference> executablesExceptions = exceptionDeclarator.getExceptions();
		if (executablesExceptions.isEmpty())
			return this;
		List<LightweightTypeReference> exceptions = Lists.newArrayListWithCapacity(executablesExceptions.size());
		for(JvmTypeReference exception: executablesExceptions) {
			exceptions.add(getConverter().toLightweightReference(exception));
		}
		return pushExpectedExceptions(exceptions);
	}

	@Nullable
	public LightweightTypeReference getExpectedReturnType(XExpression expression) {
		LightweightTypeReference result = doGetExpectedType(expression, true);
		return toOwnedReference(result);
	}
	
	public boolean isVoidTypeAllowed(XExpression expression) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData != null)
			return typeData.getExpectation().isVoidTypeAllowed();
		return true;
	}
	
	public boolean isVoidReturnTypeAllowed(XExpression expression) {
		TypeData typeData = getTypeData(expression, true);
		if (typeData != null && typeData.isReturnType())
			return typeData.getExpectation().isVoidTypeAllowed();
		return true;
	}

	@Nullable
	protected LightweightTypeReference doGetExpectedType(XExpression expression, boolean returnType) {
		TypeData typeData = getTypeData(expression, returnType, true);
		if (typeData != null) {
			return typeData.getExpectation().getExpectedType();
		}
		return null;
	}
	
	public final List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		List<LightweightTypeReference> result = doGetActualTypeArguments(expression);
		if (result == null)
			return Collections.emptyList();
		return result;
	}
	
	@Nullable
	protected List<LightweightTypeReference> doGetActualTypeArguments(XExpression expression) {
		ILinkingCandidate result = basicGetLinkingCandidates().get(expression);
		if (result != null) {
			return result.getTypeArguments();
		}
		return Collections.emptyList();
	}
	
	public void setType(JvmIdentifiableElement identifiable, LightweightTypeReference reference) {
		LightweightTypeReference prev = ensureTypesMapExists().put(identifiable, reference);
		if (prev!= null) {
			throw new IllegalStateException("identifiable [" + identifiable + "] was already typed as [" + prev.getIdentifier() + "]");
		}
	}
	
	public void reassignType(JvmIdentifiableElement identifiable, @Nullable LightweightTypeReference reference) {
		if (reference != null) {
			LightweightTypeReference actualType = getActualType(identifiable);
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
			if (reassignedTypes != null)
				ensureReassignedTypesMapExists().remove(identifiable);
		}
	}
	
	protected boolean isRefinedType(JvmIdentifiableElement element) {
		if (reassignedTypes != null && reassignedTypes.get(element) != null) {
			return !(element instanceof JvmType);
		}
		return false;
	}
	
	public void reassignTypeWithoutMerge(JvmIdentifiableElement identifiable, @Nullable LightweightTypeReference reference) {
		ensureReassignedTypesMapExists().put(identifiable, reference);
	}
	
	protected LightweightTypeReference acceptType(final XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		ITypeReferenceOwner referenceOwner = getReferenceOwner();
		if (!type.isOwnedBy(referenceOwner)) {
			throw new IllegalArgumentException("type is associated with an incompatible owner");
		}
		if (!expectation.isOwnedBy(referenceOwner)) {
			throw new IllegalArgumentException("expected type is associated with an incompatible owner");
		}
		
//		AbstractTypeComputationState state = expectation.getState();
		// expectation is type parameter - type is actual - bind type
		// no expectation, type wrap type and add pending type parameter data that should be resolved later on demand
		// this will resolve them to their type parameter constraints if any and no other thing is available
		// mind the conformance hint
		
		TypeParameterSubstitutor<?> substitutor = new TypeParameterByUnboundSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), referenceOwner) {
			@Override
			@Nullable
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				if (expression instanceof XAbstractFeatureCall || expression instanceof XConstructorCall || expression instanceof XClosure) {
					return ResolvedTypes.this.createUnboundTypeReference(expression, type);
				} else {
					return null;
				}
			}
		};
		LightweightTypeReference actualType = substitutor.substitute(type).getUpperBoundSubstitute();
		acceptType(expression, new TypeData(expression, expectation, actualType, EnumSet.copyOf(Arrays.asList(hints)), returnType));
		return actualType;
	}
	
	protected EnumSet<ConformanceHint> getConformanceHints(TypeData typeData, boolean recompute) {
		EnumSet<ConformanceHint> conformanceHints = typeData.getConformanceHints();
		if (recompute) {
			if (conformanceHints.contains(ConformanceHint.SEALED)) {
				return conformanceHints;
			}
			conformanceHints.add(ConformanceHint.UNCHECKED);
			conformanceHints.remove(ConformanceHint.INCOMPATIBLE);
			conformanceHints.remove(ConformanceHint.SUCCESS);
		}
		if (conformanceHints.contains(ConformanceHint.UNCHECKED)) {
			LightweightTypeReference actualType = typeData.getActualType();
			ITypeExpectation expectation = typeData.getExpectation();
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null) {
				TypeConformanceResult conformanceResult = expectedType.getUpperBoundSubstitute().internalIsAssignableFrom(actualType, new TypeConformanceComputationArgument());
				conformanceHints.addAll(conformanceResult.getConformanceHints());
				conformanceHints.remove(ConformanceHint.UNCHECKED);
				conformanceHints.add(ConformanceHint.CHECKED);
			} else {
				conformanceHints.remove(ConformanceHint.UNCHECKED);
				conformanceHints.add(ConformanceHint.CHECKED);
				conformanceHints.add(ConformanceHint.SUCCESS);
			}
		}
		return conformanceHints;
	}
	
	protected void acceptType(XExpression expression, TypeData typeData) {
		Maps2.putIntoListMap(expression, typeData, ensureExpressionTypesMapExists());
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
	
	protected Map<XExpression, List<TypeData>> basicGetExpressionTypes() {
		return expressionTypes != null ? expressionTypes : Collections.<XExpression, List<TypeData>>emptyMap();
	}
	
	private Map<XExpression, List<TypeData>> ensureExpressionTypesMapExists() {
		if (expressionTypes == null) {
			expressionTypes = Maps.newHashMap();
		}
		return expressionTypes;
	}
	

	protected void refineExpectedType(XExpression receiver, ITypeExpectation refinedExpectation) {
		Collection<TypeData> typeData = ensureExpressionTypesMapExists().get(receiver);
		List<TypeData> replaced = Lists.newArrayListWithCapacity(typeData.size());
		for(TypeData existing: typeData) {
			TypeData newTypeData = new TypeData(receiver, refinedExpectation, existing.getActualType(), existing.getConformanceHints(), existing.isReturnType());
			replaced.add(newTypeData);
		}
		ensureExpressionTypesMapExists().put(receiver, replaced);
	}
	
	protected Map<Object, List<LightweightBoundTypeArgument>> basicGetTypeParameterHints() {
		return typeParameterHints != null ? typeParameterHints : Collections.<Object, List<LightweightBoundTypeArgument>>emptyMap();
	}
	
	private Map<Object, List<LightweightBoundTypeArgument>> ensureTypeParameterHintsMapExists() {
		if (typeParameterHints == null) {
			typeParameterHints = Maps.newHashMap();
		}
		return typeParameterHints;
	}

	private Map<XExpression, ILinkingCandidate> ensureLinkingMapExists() {
		if (featureLinking == null) {
			featureLinking = Maps.newLinkedHashMap();
		}
		return featureLinking;
	}
	
	protected Map<XExpression, ILinkingCandidate> basicGetLinkingCandidates() {
		return featureLinking != null ? featureLinking : Collections.<XExpression, ILinkingCandidate>emptyMap();
	}
	
	public Collection<ILinkingCandidate> getFollowUpErrors() {
		return Collections2.filter(basicGetLinkingCandidates().values(), new Predicate<ILinkingCandidate>() {
			public boolean apply(@Nullable ILinkingCandidate input) {
				if (input == null)
					throw new IllegalArgumentException();
				if (input instanceof FollowUpError)
					return true;
				return false;
			}
		});
	}
	
	@Nullable
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = doGetActualType(identifiable, false);
		return toOwnedReference(result);
	}

	@Nullable
	protected LightweightTypeReference doGetActualType(JvmIdentifiableElement identifiable, boolean ignoreReassignedTypes) {
		if (reassignedTypes != null && !ignoreReassignedTypes) {
			LightweightTypeReference result = reassignedTypes.get(identifiable);
			if (result != null) {
				return result;
			}
		}
		LightweightTypeReference result = basicGetTypes().get(identifiable);
		if (result == null) {
			return getDeclaredType(identifiable);
		}
		return result;
	}
	
	@Nullable
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmType) {
			ITypeReferenceOwner owner = getConverter().getOwner();
			ParameterizedTypeReference result = new ParameterizedTypeReference(owner, (JvmType) identifiable);
			if (identifiable instanceof JvmTypeParameterDeclarator) {
				for(JvmTypeParameter param: ((JvmTypeParameterDeclarator) identifiable).getTypeParameters()) {
					result.addTypeArgument(new ParameterizedTypeReference(owner, param));
				}
			}
			return result;
		}
		JvmTypeReference type = getUnconvertedDeclaredType(identifiable);
		if (type != null) {
			LightweightTypeReference result = getConverter().toLightweightReference(type);
			return result;
		}
		return null;
	}
	
	@Nullable
	protected JvmTypeReference getUnconvertedDeclaredType(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmOperation) {
			return ((JvmOperation) identifiable).getReturnType();
		}
		if (identifiable instanceof JvmField) {
			return ((JvmField) identifiable).getType();
		}
		if (identifiable instanceof JvmConstructor) {
			return resolver.getServices().getTypeReferences().createTypeRef(((JvmConstructor) identifiable).getDeclaringType());
		}
		if (identifiable instanceof JvmFormalParameter) {
			JvmTypeReference parameterType = ((JvmFormalParameter) identifiable).getParameterType();
			return parameterType;
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

	public void acceptLinkingInformation(XExpression expression, ILinkingCandidate candidate) {
		ILinkingCandidate prev = ensureLinkingMapExists().put(expression, candidate); 
		if (prev != null) {
			throw new IllegalStateException("Expression " + expression + " was already linked to: " + prev + "\nCannot relink to: " + candidate);
		}
	}
	
	void reassignLinkingInformation(XExpression expression, ILinkingCandidate candidate) {
		ILinkingCandidate prev = ensureLinkingMapExists().put(expression, candidate); 
		if (prev == null) {
			throw new IllegalStateException("Expression " + expression + " was never linked, cannot replace linking information");
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
		UnboundTypeReference result = new UnboundTypeReference(getReferenceOwner(), expression, type) {
			// the constructor is protected since this guides developers better
			// therefore we use an anonymous class, here
		};
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
		appendListMapContent(expressionTypes, "expressionTypes", result, indentation);
		appendContent(featureLinking, "featureLinking", result, indentation);
		appendContent(unboundTypeParameters, "unboundTypeParameters", result, indentation);
		appendListMapContent(typeParameterHints, "typeParameterHints", result, indentation);
		appendContent(declaredTypeParameters, "declaredTypeParameters", result, indentation);
		appendContent(diagnostics, "diagnostics", result, indentation);
		appendContent(propagatedTypes, "propagatedTypes", result, indentation);
	}

	protected void appendContent(@Nullable Map<?, ?> map, String prefix, StringBuilder result, String indentation) {
		if (map != null) {
			MapJoiner joiner = Joiner.on("\n  " + indentation).withKeyValueSeparator(" -> ");
			result.append("\n").append(indentation).append(prefix).append(":\n").append(indentation).append("  ");
			joiner.appendTo(result, map);
		}
	}
	
	protected void appendContent(@Nullable Collection<?> values, String prefix, StringBuilder result, String indentation) {
		if (values != null) {
			Joiner joiner = Joiner.on("\n  " + indentation);
			result.append("\n").append(indentation).append(prefix).append(":\n").append(indentation).append("  ");
			joiner.appendTo(result, values);
		}
	}
	
	protected void appendListMapContent(@Nullable Map<?, ? extends Collection<?>> map, String prefix, StringBuilder result, String indentation) {
		if (map != null) {
			MultimapJoiner joiner = new MultimapJoiner(
					Joiner.on("\n    " + indentation), 
					"\n  " + indentation, 
					" ->\n" + indentation + "    ");
			result.append("\n").append(indentation).append(prefix).append(":\n").append(indentation).append("  ");
			joiner.appendTo(result, map);
		}
	}

	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		if (boundTypeArgument.getSource() == BoundTypeArgumentSource.RESOLVED) {
			if (resolvedTypeParameters == null) {
				resolvedTypeParameters = Sets.newHashSetWithExpectedSize(3);
			}
			if (resolvedTypeParameters.add(handle)) {
				if (boundTypeArgument.getDeclaredVariance().mergeDeclaredWithActual(boundTypeArgument.getActualVariance()) == VarianceInfo.INVARIANT) {
					resolveDependentTypeArguments(handle, boundTypeArgument);
				}
				LightweightBoundTypeArgument boundWithoutRecursion = removeRecursiveTypeArguments(handle, boundTypeArgument);
				ensureTypeParameterHintsMapExists().put(handle, Collections.singletonList(boundWithoutRecursion));
			}
		} else {
			if (!isResolved(handle)) {
				if (boundTypeArgument.getTypeReference() instanceof UnboundTypeReference && boundTypeArgument.getSource() != BoundTypeArgumentSource.CONSTRAINT) {
					UnboundTypeReference other = (UnboundTypeReference) boundTypeArgument.getTypeReference();
					Object otherHandle = other.getHandle();
					if (ensureTypeParameterHintsMapExists().containsKey(handle)) {
						// don't add fully redundant hints
						List<LightweightBoundTypeArgument> existingValues = ensureTypeParameterHintsMapExists().get(handle);
						for(LightweightBoundTypeArgument existingValue: existingValues) {
							if (existingValue.getTypeReference() instanceof UnboundTypeReference) {
								if (((UnboundTypeReference) existingValue.getTypeReference()).getHandle() == otherHandle) {
									if (existingValue.getActualVariance() == boundTypeArgument.getActualVariance() 
											&& existingValue.getDeclaredVariance() == boundTypeArgument.getDeclaredVariance()
											&& existingValue.getSource() == boundTypeArgument.getSource()) {
										return;
									}
								}
							}
						}
					}
					UnboundTypeReference currentUnbound = getUnboundTypeReference(handle);
					Maps2.putIntoListMap(otherHandle, copyBoundTypeArgument(currentUnbound, boundTypeArgument), ensureTypeParameterHintsMapExists());
				}
				Maps2.putIntoListMap(handle, boundTypeArgument, ensureTypeParameterHintsMapExists());
			} else {
				throw new IllegalStateException("Cannot add hints if the reference was already resolved");
			}
		}
	}

	protected LightweightBoundTypeArgument copyBoundTypeArgument(LightweightTypeReference typeReference,
			LightweightBoundTypeArgument boundTypeArgument) {
		return new LightweightBoundTypeArgument(typeReference, boundTypeArgument.getSource(),
				boundTypeArgument.getOrigin(), boundTypeArgument.getDeclaredVariance(),
				boundTypeArgument.getActualVariance());
	}

	protected LightweightBoundTypeArgument removeRecursiveTypeArguments(final Object handle,
			LightweightBoundTypeArgument boundTypeArgument) {
		final Set<Object> handles = Sets.newHashSet(handle);
		LightweightTypeReference boundArgumentWithoutRecursion = new CustomTypeParameterSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), boundTypeArgument.getTypeReference().getOwner()) {

			@Override
			protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference, ConstraintVisitingInfo visiting) {
				if (!handle.equals(reference.getHandle())) {
					return reference;
				}
				JvmTypeParameter typeParameter = reference.getTypeParameter();
				if (!visiting.tryVisit(typeParameter)) {
					LightweightTypeReference mappedReference = getDeclaredUpperBound(typeParameter, visiting);
					getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
					if (mappedReference != null)
						return mappedReference;
					return getObjectReference();
				}
				try {
					LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(typeParameter);
					if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
						LightweightTypeReference result = boundTypeArgument.getTypeReference().accept(this, visiting);
						return result;
					} else {
						LightweightTypeReference mappedReference = getDeclaredUpperBound(visiting.getCurrentDeclarator(), visiting.getCurrentIndex(), visiting);
						getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
						return mappedReference;
					}
				} finally {
					visiting.didVisit(typeParameter);
				}
			}
			
			@Override
			protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, ConstraintVisitingInfo visiting) {
				if (reference.isResolved() && reference.isOwnedBy(getOwner()))
					return reference;
				LightweightTypeReference lowerBound = reference.getLowerBound();
				if (lowerBound instanceof UnboundTypeReference) {
					if (!handles.add(((UnboundTypeReference) lowerBound).getHandle())) {
						WildcardTypeReference result = new WildcardTypeReference(getOwner());
						for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
							result.addUpperBound(visitTypeArgument(upperBound, visiting));
						}
						return result;
					}
				}
				return super.doVisitWildcardTypeReference(reference, visiting);
			}
			
			@Override
			@Nullable
			protected LightweightTypeReference getUnmappedSubstitute(ParameterizedTypeReference reference, JvmTypeParameter type, ConstraintVisitingInfo visiting) {
				return reference;
			}
			
		}.substitute(boundTypeArgument.getTypeReference());
		LightweightBoundTypeArgument boundWithoutRecursion = copyBoundTypeArgument(boundArgumentWithoutRecursion, boundTypeArgument);
		return boundWithoutRecursion;
	}

	protected void resolveDependentTypeArguments(final Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		List<LightweightBoundTypeArgument> existingTypeArguments = ensureTypeParameterHintsMapExists().get(handle);
		if (existingTypeArguments != null) {
			for(int i = 0; i < existingTypeArguments.size(); i++) {
				LightweightBoundTypeArgument existingTypeArgument = existingTypeArguments.get(i);
				if (existingTypeArgument.getSource() == BoundTypeArgumentSource.INFERRED) {
					if (existingTypeArgument.getTypeReference() instanceof UnboundTypeReference) {
						UnboundTypeReference existingReference = (UnboundTypeReference) existingTypeArgument.getTypeReference();
						// resolve similar pending type arguments, too
						if (existingTypeArgument.getDeclaredVariance() == existingTypeArgument.getActualVariance()) {
							acceptHint(existingReference.getHandle(), boundTypeArgument);
						}
					} else if (existingTypeArgument.getTypeReference() != null && existingTypeArgument.getTypeReference() != boundTypeArgument.getTypeReference()) {
						if (!existingTypeArgument.getTypeReference().isResolved()) {
							ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(getReferenceOwner());
							collector.processPairedReferences(boundTypeArgument.getTypeReference(), existingTypeArgument.getTypeReference());
						}
					}
				} else if (existingTypeArgument.getSource() == BoundTypeArgumentSource.CONSTRAINT) {
					if (existingTypeArgument.getTypeReference() instanceof UnboundTypeReference) {
						UnboundTypeReference existingReference = (UnboundTypeReference) existingTypeArgument.getTypeReference();
						if (!existingReference.internalIsResolved()) {
							existingReference.acceptHint(boundTypeArgument.getTypeReference(), 
								BoundTypeArgumentSource.INFERRED, boundTypeArgument, VarianceInfo.OUT, VarianceInfo.OUT);
						}
					}
				}
			}
		}
	}
	
	public boolean isResolved(Object handle) {
		return resolvedTypeParameters != null && resolvedTypeParameters.contains(handle);
	}

	protected boolean isPropagatedType(XExpression expression) {
		return propagatedTypes != null && propagatedTypes.contains(expression);
	}
	
	public boolean isRefinedType(XExpression expression) {
		return refinedTypes != null && refinedTypes.contains(expression);
	}
	
	protected void setPropagatedType(XExpression expression) {
		if (propagatedTypes == null) {
			propagatedTypes = Sets.newHashSet(expression);
		} else {
			propagatedTypes.add(expression);
		}
	}
	
	protected void setRefinedType(XExpression expression) {
		if (refinedTypes == null) {
			refinedTypes = Sets.newHashSet(expression);
		} else {
			refinedTypes.add(expression);
		}
	}
	
	protected Set<XExpression> basicGetPropagatedTypes() {
		return propagatedTypes != null ? propagatedTypes : Collections.<XExpression>emptySet();
	}
	
	protected Set<XExpression> basicGetRefinedTypes() {
		return refinedTypes != null ? refinedTypes : Collections.<XExpression>emptySet();
	}
	
	@Nullable
	protected List<JvmTypeParameter> basicGetDeclardTypeParameters() {
		return declaredTypeParameters;
	}
	
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return declaredTypeParameters != null ? declaredTypeParameters : Collections.<JvmTypeParameter>emptyList();
	}
	
	public void addDeclaredTypeParameters(List<JvmTypeParameter> typeParameters) {
		if (declaredTypeParameters == null) {
			declaredTypeParameters = Lists.newArrayList(typeParameters);
		} else {
			declaredTypeParameters.addAll(typeParameters);
		}
	}
	
	protected List<LightweightTypeReference> getExpectedExceptions() {
		return Collections.<LightweightTypeReference>emptyList();
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
		List<LightweightBoundTypeArgument> result = basicGetTypeParameterHints().get(handle);
		if (result != null)
			return result;
		return Collections.emptyList();
	}

	protected void addNonRecursiveHints(List<LightweightBoundTypeArgument> hints, Set<Object> seenHandles,
			List<LightweightBoundTypeArgument> result) {
		for(LightweightBoundTypeArgument hint: hints) {
			LightweightTypeReference reference = hint.getTypeReference();
			if (reference instanceof UnboundTypeReference) {
				addNonRecursiveHints(hint, (UnboundTypeReference)reference, seenHandles, result);
			} else {
				if (!result.contains(hint))
					result.add(hint);
			}
		}
	}
	
	protected void addNonRecursiveHints(LightweightBoundTypeArgument original, List<LightweightBoundTypeArgument> hints, Set<Object> seenHandles,
			List<LightweightBoundTypeArgument> result) {
		for(LightweightBoundTypeArgument hint: hints) {
			LightweightTypeReference reference = hint.getTypeReference();
			if (reference instanceof UnboundTypeReference) {
				addNonRecursiveHints(original, (UnboundTypeReference)reference, seenHandles, result);
			} else {
				if (original.getDeclaredVariance() == VarianceInfo.IN && hint.getTypeReference() instanceof WildcardTypeReference) {
					LightweightTypeReference upperBound = hint.getTypeReference().getUpperBoundSubstitute();
					if (upperBound instanceof UnboundTypeReference) {
						addNonRecursiveHints(original, (UnboundTypeReference)upperBound, seenHandles, result);
					} else {
						LightweightBoundTypeArgument delegateHint = new LightweightBoundTypeArgument(
								upperBound, original.getSource(), hint.getOrigin(), hint.getDeclaredVariance(), original.getActualVariance());
						result.add(delegateHint);
					}
				} else {
					if (!result.isEmpty()) {
						if (original.getDeclaredVariance() == VarianceInfo.OUT && original.getActualVariance() == VarianceInfo.INVARIANT) {
							if (hint.getDeclaredVariance() == VarianceInfo.OUT && hint.getActualVariance() == VarianceInfo.INVARIANT) {
								continue;
							}
						}
						if (!result.contains(hint))
							result.add(hint);
					} else {
						result.add(hint);
					}
				}
			}
		}
	}

	protected void addNonRecursiveHints(LightweightBoundTypeArgument original, UnboundTypeReference reference, Set<Object> seenHandles,
			List<LightweightBoundTypeArgument> result) {
		Object otherHandle = reference.getHandle();
		if (seenHandles.add(otherHandle)) {
			if (isResolved(otherHandle)) {
				result.addAll(getHints(otherHandle));
			} else {
				addNonRecursiveHints(original, getHints(otherHandle), seenHandles, result);
			}
		}
	}
	
	protected StackedResolvedTypes pushTypes() {
		return new StackedResolvedTypes(this);
	}
	
	protected ExpressionAwareStackedResolvedTypes pushTypes(XExpression context) {
		ExpressionAwareStackedResolvedTypes result = new ExpressionAwareStackedResolvedTypes(this, context);
		return result;
	}
	
	protected StackedResolvedTypes pushReassigningTypes() {
		return new ReassigningStackedResolvedTypes(this);
	}

	protected abstract void markToBeInferred(XExpression expression);

}
