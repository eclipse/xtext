/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitor;
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
public abstract class ResolvedTypes implements IResolvedTypes {

	protected static class SharedKeysAwareMap<K, V> extends LinkedHashMap<K, V> {
		private static final long serialVersionUID = 1L;
		private final Set<K> sharedKeys;

		public SharedKeysAwareMap(Set<K> sharedKeys) {
			this.sharedKeys = sharedKeys;
		}
		
		@Override
		public V put(K key, V value) {
			sharedKeys.add(key);
			return super.put(key, value);
		}
	}
	
	protected static class SharedKeysAwareSet<E> extends HashSet<E> {
		private static final long serialVersionUID = 1L;
		private final Set<E> sharedKeys;

		public SharedKeysAwareSet(Set<E> sharedItems) {
			this.sharedKeys = sharedItems;
		}
		
		@Override
		public boolean add(E e) {
			sharedKeys.add(e);
			return super.add(e);
		}
	}

	protected class Owner extends StandardTypeReferenceOwner {

		public Owner(CommonTypeComputationServices services, ResourceSet context) {
			super(services, context);
		}

		@Override
		public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
			ResolvedTypes.this.acceptHint(handle, boundTypeArgument);
		}

		@Override
		public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
			return ResolvedTypes.this.getAllHints(handle);
		}

		@Override
		public boolean isResolved(Object handle) {
			return ResolvedTypes.this.isResolved(handle);
		}
		
		@Override
		public List<JvmTypeParameter> getDeclaredTypeParameters() {
			return ResolvedTypes.this.getDeclaredTypeParameters();
		}
		
		@Override
		public String toString() {
			return String.format("Owner: %s", ResolvedTypes.this);
		}
		
	}

	/**
	 * Shared state accross all resolved types for a single run of the resolver.
	 * 
	 * Externalized to reduce pressure on the GC and make them immediately accessible
	 * from all child resolvers.
	 */
	public static class Shared {
		final DefaultReentrantTypeResolver resolver;
		final CancelIndicator monitor;
		final IFeatureScopeTracker featureScopeTracker;
		final IssueSeverities issueSeverities;
		
		final Set<JvmIdentifiableElement> allTypes = Sets.newHashSet();
		final Set<JvmIdentifiableElement> allReassignedTypes = Sets.newHashSet();
		final Set<XExpression> allExpressionTypes = Sets.newHashSet();
		final Set<XExpression> allLinking = Sets.newHashSet();
		final Set<Object> allResolvedTypeParameters = Sets.newHashSet();
		
		ResolvedTypes root;
		
		public Shared(DefaultReentrantTypeResolver resolver, CancelIndicator monitor) {
			this.resolver = resolver;
			this.monitor = monitor;
			this.featureScopeTracker = resolver.createFeatureScopeTracker();
			this.issueSeverities = resolver.getIssueSeverities();
		}
		
	}

	private final Owner owner;
	
	private Set<AbstractDiagnostic> diagnostics;
	private Set<IAcceptor<? super IResolvedTypes>> deferredLogic;
	private Map<JvmIdentifiableElement, LightweightTypeReference> types;
	private Map<JvmIdentifiableElement, LightweightTypeReference> reassignedTypes;
	private Map<XExpression, List<TypeData>> expressionTypes;
	private Map<XExpression, IApplicableCandidate> linkingMap;
	private Map<Object, UnboundTypeReference> unboundTypeParameters;
	private Map<Object, List<LightweightBoundTypeArgument>> typeParameterHints;
	private Set<Object> resolvedTypeParameters;
	private Set<XExpression> refinedTypes;
	private Set<XExpression> propagatedTypes;
	private List<JvmTypeParameter> declaredTypeParameters;
	
	/* package */final Shared shared;
	
	protected ResolvedTypes(Shared shared) {
		this.shared = shared;
		this.owner = new Owner(shared.resolver.getServices(), shared.resolver.getRoot().eResource().getResourceSet());
	}
	
	/**
	 * @since 2.7
	 */
	protected CancelIndicator getMonitor() {
		return shared.monitor;
	}
	
	protected void checkCanceled() {
		getResolver().getOperationCanceledManager().checkCanceled(getMonitor());
	}
	
	protected void clear() {
		diagnostics = null;
		deferredLogic = null;
		types = null;
		reassignedTypes = null;
		expressionTypes = null;
		linkingMap = null;
		unboundTypeParameters = null;
		typeParameterHints = null;
		resolvedTypeParameters = null;
		propagatedTypes = null;
		refinedTypes = null;
	}
	
	protected IssueSeverities getSeverities() {
		return shared.issueSeverities;
	}
	
	protected IFeatureScopeTracker getFeatureScopeTracker() {
		return shared.featureScopeTracker;
	}
	
	public ITypeReferenceOwner getReferenceOwner() {
		return owner;
	}
	
	public ResourceSet getContextResourceSet() {
		return owner.getContextResourceSet();
	}

	public CommonTypeComputationServices getServices() {
		return owner.getServices();
	}

	@Override
	public Collection<AbstractDiagnostic> getQueuedDiagnostics() {
		if (diagnostics == null)
			return Collections.emptyList();
		return diagnostics;
	}
	
	public Collection<IAcceptor<? super IResolvedTypes>> getDeferredLogic() {
		if (deferredLogic == null)
			return Collections.emptyList();
		return deferredLogic;
	}
	
	protected void clearDeferredLogic() {
		deferredLogic = null;
	}
	
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		if (diagnostics == null) {
			diagnostics = Sets.newLinkedHashSet();
		}
		if (!diagnostics.add(diagnostic)) {
			throw new IllegalStateException("Duplicate diagnostic: " + diagnostic);
		}
	}
	
	protected void addDeferredLogic(IAcceptor<? super IResolvedTypes> code) {
		if (deferredLogic == null) {
			deferredLogic = Sets.newLinkedHashSet();
		}
		if (!deferredLogic.add(code)) {
			throw new IllegalStateException("Duplicate runnable: " + code);
		}
	}
	
	@Override
	public List<LightweightTypeReference> getThrownExceptions(XExpression obj) {
		return getServices().getEarlyExitComputer().getThrownExceptions(obj, this, this.getReferenceOwner());
	}
	
	/* @Nullable */
	@Override
	public JvmIdentifiableElement getLinkedFeature(/* @Nullable */ XAbstractFeatureCall featureCall) {
		if (!shared.allLinking.contains(featureCall)) {
			return null;
		}
		return doGetLinkedFeature(featureCall);
	}
	
	/* @Nullable */
	@Override
	public JvmIdentifiableElement getLinkedFeature(/* @Nullable */ XConstructorCall constructorCall) {
		if (!shared.allLinking.contains(constructorCall)) {
			return null;
		}
		return doGetLinkedFeature(constructorCall);
	}
	
	/* @Nullable */
	@Override
	public IFeatureLinkingCandidate getLinkingCandidate(/* @Nullable */ XAbstractFeatureCall featureCall) {
		if (!shared.allLinking.contains(featureCall)) {
			return null;
		}
		return (IFeatureLinkingCandidate) doGetCandidate(featureCall);
	}
	
	/* @Nullable */
	@Override
	public IConstructorLinkingCandidate getLinkingCandidate(/* @Nullable */ XConstructorCall constructorCall) {
		if (!shared.allLinking.contains(constructorCall)) {
			return null;
		}
		return (IConstructorLinkingCandidate) doGetCandidate(constructorCall);
	}
	
	/* @Nullable */
	protected IApplicableCandidate doGetCandidate(/* @Nullable */ XExpression featureOrConstructorCall) {
		if (linkingMap == null || featureOrConstructorCall == null)
			return null;
		IApplicableCandidate candidate = linkingMap.get(featureOrConstructorCall);
		return candidate;
	}
	
	/* @Nullable */
	protected JvmIdentifiableElement doGetLinkedFeature(/* @Nullable */ XExpression featureOrConstructorCall) {
		if (linkingMap == null || featureOrConstructorCall == null || featureOrConstructorCall.eClass() == XbasePackage.Literals.XCLOSURE)
			return null;
		IApplicableCandidate candidate = linkingMap.get(featureOrConstructorCall);
		if (candidate == null)
			return null;
		return ((ILinkingCandidate) candidate).getFeature();
	}

	/* @Nullable */
	protected TypeData getTypeData(XExpression expression, boolean returnType) {
		return getTypeData(expression, returnType, false);
	}
	
	/* @Nullable */
	protected TypeData getTypeData(XExpression expression, boolean returnType, boolean nullIfEmpty) {
		if (!shared.allExpressionTypes.contains(expression)) {
			return null;
		}
		List<TypeData> values = doGetTypeData(expression);
		if (values == null) {
			return null;
		}
		TypeData result = mergeTypeData(expression, values, returnType, nullIfEmpty);
		return result;
	}
	
	/* @Nullable */
	protected List<TypeData> doGetTypeData(XExpression expression) {
		List<TypeData> result = basicGetExpressionTypes().get(expression);
		return result;
	}
	
	private static class MergeData {
		List<LightweightTypeReference> references = Lists.newArrayList();
		boolean voidSeen = false;
		ITypeExpectation expectation = null;
		boolean allNoImplicitReturn = true;
		boolean allThrownException = true;
		int mergedFlags = ConformanceFlags.MERGED;
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MergeData [");
			if (references != null) {
				builder.append("references=");
				builder.append(references);
				builder.append(", ");
			}
			builder.append("voidSeen=");
			builder.append(voidSeen);
			builder.append(", ");
			if (expectation != null) {
				builder.append("expectation=");
				builder.append(expectation);
				builder.append(", ");
			}
			builder.append("allNoImplicitReturn=");
			builder.append(allNoImplicitReturn);
			builder.append(", allThrownException=");
			builder.append(allThrownException);
			builder.append(", mergedFlags=");
			builder.append(ConformanceFlags.toString(mergedFlags));
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	/* @Nullable */
	protected TypeData mergeTypeData(final XExpression expression, List<TypeData> allValues, boolean returnType, boolean nullIfEmpty) {
		int allSize = allValues.size();
		if (nullIfEmpty && allSize == 0) {
			return null;
		}
		final List<TypeData> values;
		if (allSize == 1) {
			TypeData result = allValues.get(0);
			if (result.isReturnType() == returnType) {
				return getSingleMergeResult(result, expression, returnType);
			}
			if (nullIfEmpty)
				return null;
			if (returnType) {
				return getSingleMergeResult(result, expression, returnType);
			}
			values = Collections.emptyList();
		} else {
			values = collectValues(allValues, returnType);
		}
		if (nullIfEmpty && values.size() == 0) {
			return null;
		}
		if (values.size() == 1) {
			TypeData typeData = values.get(0);
			return getSingleMergeResult(typeData, expression, returnType);
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
		TypeData result = new TypeData(expression, mergeData.expectation, mergedType, mergeData.mergedFlags , returnType);
		return result;
	}

	private TypeData getSingleMergeResult(TypeData typeData, final XExpression expression, boolean returnType) {
		LightweightTypeReference upperBoundSubstitute = typeData.getActualType().getUpperBoundSubstitute();
		if (upperBoundSubstitute != typeData.getActualType())
			return new TypeData(expression, typeData.getExpectation(), upperBoundSubstitute, typeData.getConformanceFlags(), returnType);
		return typeData;
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
					if (valid) {
						mergedType = expectedType; // branches have already been validated
						mergeData.mergedFlags &= ~(ConformanceFlags.UNCHECKED | ConformanceFlags.INCOMPATIBLE | ConformanceFlags.LAMBDA_RAW_COMPATIBLE | ConformanceFlags.LAMBDA_PARAMETER_COMPATIBLE);
						mergeData.mergedFlags |= ConformanceFlags.CHECKED_SUCCESS;
					}
				}
			}
		}
		if (mergeData.voidSeen && returnType && !mergeData.references.isEmpty()) {
			mergedType = mergedType.getWrapperTypeIfPrimitive();
		}
		return mergedType;
	}

	/* @Nullable */
	private LightweightTypeReference getMergedType(MergeData mergeData, List<TypeData> values) {
		LightweightTypeReference mergedType = !mergeData.references.isEmpty() || !mergeData.voidSeen ? getMergedType(/*mergedFlags, */mergeData.references) : values.get(0).getActualType();
		return mergedType;
	}

	private void enhanceMergeData(List<TypeData> values, MergeData mergeData) {
		for (int i = 0, size = values.size(); i < size; i++) {
			TypeData value = values.get(i);
			LightweightTypeReference reference = value.getActualType().getUpperBoundSubstitute();
			int flags = value.getConformanceFlags();
			if (reference.isPrimitiveVoid()) {
				if ((flags & ConformanceFlags.EXPLICIT_VOID_RETURN) != 0) {
					mergeData.references.clear();
					mergeData.references.add(reference);
					mergeData.mergedFlags = flags;
					mergeData.expectation = value.getExpectation();
					mergeData.voidSeen = false;
					return;
				}
				mergeData.voidSeen = true;
			} else {
				mergeData.references.add(reference);
			}
			mergeData.allNoImplicitReturn = mergeData.allNoImplicitReturn && (flags & ConformanceFlags.NO_IMPLICIT_RETURN) != 0; 
			mergeData.allThrownException = mergeData.allThrownException && (flags & ConformanceFlags.THROWN_EXCEPTION) != 0;
			if (!reference.isUnknown()) {
				mergeData.mergedFlags |= flags;
			}
			if (mergeData.expectation == null) {
				mergeData.expectation = value.getExpectation();
			} else if (mergeData.expectation.getExpectedType() == null) {
				ITypeExpectation knownExpectation = value.getExpectation();
				if (knownExpectation.getExpectedType() != null) {
					mergeData.expectation = knownExpectation;
				}
			}
		}
		if (mergeData.mergedFlags == ConformanceFlags.MERGED) {
			mergeData.mergedFlags |= ConformanceFlags.CHECKED_SUCCESS;
		}
		if (!mergeData.allNoImplicitReturn) {
			mergeData.mergedFlags &= ~ConformanceFlags.NO_IMPLICIT_RETURN;
		}
		if (!mergeData.allThrownException) {
			mergeData.mergedFlags &= ~ConformanceFlags.THROWN_EXCEPTION;
		}
		if ((mergeData.mergedFlags & (ConformanceFlags.CHECKED | ConformanceFlags.UNCHECKED)) == (ConformanceFlags.CHECKED | ConformanceFlags.UNCHECKED)) {
			mergeData.mergedFlags &= ~(ConformanceFlags.CHECKED | ConformanceFlags.CHECK_RESULTS);
		}
		if ((mergeData.mergedFlags & ConformanceFlags.UNCHECKED) != 0) {
			mergeData.mergedFlags &= ~ConformanceFlags.SEALED;
		}
	}
	
	private List<TypeData> collectValues(List<TypeData> allValues, boolean returnType) {
		for(int i = 0, size = allValues.size(); i < size; i++) {
			TypeData value = allValues.get(i);
			if (returnType != value.isReturnType()) {
				List<TypeData> result = Lists.newArrayListWithCapacity(allValues.size());
				if (i != 0) {
					result.addAll(allValues.subList(0, i));
				}
				for(int j = i+1; j < size; j++) {
					value = allValues.get(j);
					if (returnType == value.isReturnType()) {
						result.add(value);
					}
				}
				if (result.isEmpty() && returnType) {
					return allValues;
				}
				return result;
			}
		}
		return allValues;
	}

	/* @Nullable */
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

	/* @Nullable */
	@Override
	public LightweightTypeReference getActualType(XExpression expression) {
		LightweightTypeReference result = doGetActualType(expression);
		return toOwnedReference(result);
	}
	
	/* @Nullable */
	protected abstract LightweightTypeReference getExpectedTypeForAssociatedExpression(JvmMember member, XExpression expression);
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType(XExpression expression) {
		return this.getReturnType(expression, false);
	}
	/* @Nullable */
	@Override
	public LightweightTypeReference getReturnType(XExpression expression, boolean onlyExplicitReturns) {
		LightweightTypeReference result = doGetReturnType(expression, onlyExplicitReturns);
		return toOwnedReference(result);
	}

	/* @Nullable */
	protected LightweightTypeReference toOwnedReference(/* @Nullable */ LightweightTypeReference result) {
		return result != null ? result.copyInto(getReferenceOwner()) : null;
	}

	/* @Nullable */
	protected LightweightTypeReference doGetActualType(XExpression expression) {
		TypeData typeData = getTypeData(expression, false);
		if (typeData != null)
			return typeData.getActualType();
		return null;
	}
	
	/* @Nullable */
	protected LightweightTypeReference doGetReturnType(XExpression expression, boolean onlyExplicitReturn) {
		TypeData typeData = getTypeData(expression, true, onlyExplicitReturn);
		if (typeData != null)
			return typeData.getActualType();
		return null;
	}
	
	/* @Nullable */
	@Override
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
			exceptions.add(getReferenceOwner().toLightweightTypeReference(exception));
		}
		return pushExpectedExceptions(exceptions);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedReturnType(XExpression expression) {
		LightweightTypeReference result = doGetExpectedType(expression, true);
		return toOwnedReference(result);
	}
	
	@Override
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

	/* @Nullable */
	protected LightweightTypeReference doGetExpectedType(XExpression expression, boolean returnType) {
		TypeData typeData = getTypeData(expression, returnType, !returnType);
		if (typeData != null) {
			return typeData.getExpectation().getExpectedType();
		}
		return null;
	}
	
	@Override
	public final List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		if (!shared.allLinking.contains(expression)) {
			return Collections.emptyList();
		}
		List<LightweightTypeReference> result = doGetActualTypeArguments(expression);
		if (result == null)
			return Collections.emptyList();
		return result;
	}
	
	/* @Nullable */
	protected List<LightweightTypeReference> doGetActualTypeArguments(XExpression expression) {
		if (expression == null || expression.eClass() == XbasePackage.Literals.XCLOSURE) {
			return Collections.emptyList();
		}
		ILinkingCandidate result = (ILinkingCandidate) basicGetLinkingMap().get(expression);
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
	
	public void reassignType(JvmIdentifiableElement identifiable, /* @Nullable */ LightweightTypeReference reference) {
		if (reference != null) {
			LightweightTypeReference actualType = getActualType(identifiable);
			if (actualType != null) {
				if (actualType.getKind() == LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE && !((UnboundTypeReference) actualType).internalIsResolved()) {
					UnboundTypeReference casted = (UnboundTypeReference) actualType;
					List<LightweightBoundTypeArgument> hints = getHints(casted.getHandle());
					boolean canAddHint = true;
					for(int i = 0; i < hints.size() && canAddHint; i++) {
						LightweightBoundTypeArgument hint = hints.get(i);
						if (hint.getTypeReference() == null || (hint.getSource() != BoundTypeArgumentSource.EXPECTATION && hint.getSource() != BoundTypeArgumentSource.INFERRED_CONSTRAINT)) {
							canAddHint = false;
						}
					}
					if (canAddHint) {
						casted.acceptHint(reference, BoundTypeArgumentSource.EXPECTATION, identifiable, VarianceInfo.OUT, VarianceInfo.OUT);
					}
					ensureReassignedTypesMapExists().put(identifiable, reference);
				} else if (!reference.isAssignableFrom(actualType)) {
					if (actualType.isAssignableFrom(reference)) {
						ensureReassignedTypesMapExists().put(identifiable, reference);
					} else {
						CompoundTypeReference multiType = toMultiType(actualType, reference);
						ensureReassignedTypesMapExists().put(identifiable, multiType);					
					}
				}
			} else {
				ensureReassignedTypesMapExists().put(identifiable, reference);
			}
		} else {
			if (reassignedTypes != null)
				reassignedTypes.remove(identifiable);
		}
	}

	protected CompoundTypeReference toMultiType(LightweightTypeReference first, LightweightTypeReference second) {
		if (first == null) {
			throw new NullPointerException("first may not be null");
		}
		if (second == null) {
			throw new NullPointerException("second may not be null");
		}
		final ITypeReferenceOwner owner = second.getOwner();
		final CompoundTypeReference result = owner.newCompoundTypeReference(false);
		TypeReferenceVisitor visitor = new TypeReferenceVisitor() {
			@Override
			protected void doVisitMultiTypeReference(CompoundTypeReference reference) {
				List<LightweightTypeReference> components = reference.getMultiTypeComponents();
				for(LightweightTypeReference component: components) {
					result.addComponent(component.copyInto(owner));
				}
			}
			@Override
			protected void doVisitTypeReference(LightweightTypeReference reference) {
				result.addComponent(reference.copyInto(owner));
			}
		};
		first.accept(visitor);
		second.accept(visitor);
		return result;
	}
	
	protected boolean isRefinedType(JvmIdentifiableElement element) {
		if (reassignedTypes != null && reassignedTypes.get(element) != null) {
			return !(element instanceof JvmType);
		}
		return false;
	}
	
	public void reassignTypeWithoutMerge(JvmIdentifiableElement identifiable, /* @Nullable */ LightweightTypeReference reference) {
		ensureReassignedTypesMapExists().put(identifiable, reference);
	}
	
	protected LightweightTypeReference acceptType(final XExpression expression, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int flags) {
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
		
		final LightweightTypeReference actualType;
		if (!type.hasTypeArguments()) {
			actualType = type.getUpperBoundSubstitute();
		} else {
			TypeParameterSubstitutor<?> substitutor = new TypeParameterByUnboundSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), referenceOwner) {
				@Override
				/* @Nullable */
				protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
					if (expression instanceof XAbstractFeatureCall || expression instanceof XConstructorCall || expression instanceof XClosure) {
						return ResolvedTypes.this.createUnboundTypeReference(expression, type);
					} else {
						return null;
					}
				}
			};
			actualType = substitutor.substitute(type).getUpperBoundSubstitute();
		}
		acceptType(expression, new TypeData(expression, expectation, actualType, flags, returnType));
		return actualType;
	}
	
	protected int getConformanceFlags(TypeData typeData, boolean recompute) {
		int flags = typeData.getConformanceFlags();
		if (recompute) {
			if ((flags & ConformanceFlags.SEALED) != 0) {
				ConformanceFlags.sanityCheck(flags);
				return flags;
			}
			flags &= ~(ConformanceFlags.INCOMPATIBLE | ConformanceFlags.SUCCESS);
			flags |= ConformanceFlags.UNCHECKED;
		}
		if ((flags & ConformanceFlags.UNCHECKED) != 0) {
			LightweightTypeReference actualType = typeData.getActualType();
			ITypeExpectation expectation = typeData.getExpectation();
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null) {
				int conformanceResult = expectedType.getUpperBoundSubstitute().internalIsAssignableFrom(
						actualType, TypeConformanceComputationArgument.DEFAULT);
				flags |= conformanceResult | ConformanceFlags.CHECKED;
				flags &= ~ConformanceFlags.UNCHECKED;
			} else {
				flags &= ~ConformanceFlags.UNCHECKED;
				flags |= ConformanceFlags.CHECKED_SUCCESS; 
			}
		}
		ConformanceFlags.sanityCheck(flags);
		typeData.setConformanceFlags(flags);
		return flags;
	}
	
	protected void acceptType(XExpression expression, TypeData typeData) {
		Maps2.putIntoListMap(expression, typeData, ensureExpressionTypesMapExists());
	}
	
	protected Map<JvmIdentifiableElement, LightweightTypeReference> basicGetTypes() {
		return types != null ? types : Collections.<JvmIdentifiableElement, LightweightTypeReference>emptyMap(); 
	}
	
	private Map<JvmIdentifiableElement, LightweightTypeReference> ensureTypesMapExists() {
		if (types == null) {
			types = new SharedKeysAwareMap<JvmIdentifiableElement, LightweightTypeReference>(shared.allTypes);
		}
		return types;
	}
	
	protected Map<JvmIdentifiableElement, LightweightTypeReference> basicGetReassignedTypes() {
		return reassignedTypes != null ? reassignedTypes : Collections.<JvmIdentifiableElement, LightweightTypeReference>emptyMap(); 
	}

	private Map<JvmIdentifiableElement, LightweightTypeReference> ensureReassignedTypesMapExists() {
		if (reassignedTypes == null) {
			reassignedTypes = new SharedKeysAwareMap<JvmIdentifiableElement, LightweightTypeReference>(shared.allReassignedTypes);
		}
		return reassignedTypes;
	}
	
	protected Map<XExpression, List<TypeData>> basicGetExpressionTypes() {
		return expressionTypes != null ? expressionTypes : Collections.<XExpression, List<TypeData>>emptyMap();
	}
	
	private Map<XExpression, List<TypeData>> ensureExpressionTypesMapExists() {
		if (expressionTypes == null) {
			expressionTypes = new SharedKeysAwareMap<XExpression, List<TypeData>>(shared.allExpressionTypes); 
		}
		return expressionTypes;
	}
	

	protected void refineExpectedType(XExpression receiver, ITypeExpectation refinedExpectation) {
		Collection<TypeData> typeData = ensureExpressionTypesMapExists().get(receiver);
		List<TypeData> replaced = Lists.newArrayListWithCapacity(typeData.size());
		for(TypeData existing: typeData) {
			TypeData newTypeData = new TypeData(receiver, refinedExpectation, existing.getActualType(), existing.getConformanceFlags(), existing.isReturnType());
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

	private Map<XExpression, IApplicableCandidate> ensureLinkingMapExists() {
		if (linkingMap == null) {
			linkingMap = new SharedKeysAwareMap<XExpression, IApplicableCandidate>(shared.allLinking); 
		}
		return linkingMap;
	}
	
	protected Map<XExpression, IApplicableCandidate> basicGetLinkingMap() {
		return linkingMap != null ? linkingMap : Collections.<XExpression, IApplicableCandidate>emptyMap();
	}
	
	@Override
	public Collection<ILinkingCandidate> getFollowUpErrors() {
		Collection<?> rawResult = Collections2.filter(basicGetLinkingMap().values(), new Predicate<IApplicableCandidate>() {
			@Override
			public boolean apply(/* @Nullable */ IApplicableCandidate input) {
				if (input == null)
					throw new IllegalArgumentException();
				if (input instanceof FollowUpError)
					return true;
				return false;
			}
		});
		@SuppressWarnings("unchecked") // cast is safe
		Collection<ILinkingCandidate> result = (Collection<ILinkingCandidate>) rawResult;
		return result;
	}
	
	@Override
	public Collection<IAmbiguousLinkingCandidate> getAmbiguousLinkingCandidates() {
		Collection<?> rawResult = Collections2.filter(basicGetLinkingMap().values(), new Predicate<IApplicableCandidate>() {
			@Override
			public boolean apply(/* @Nullable */ IApplicableCandidate input) {
				if (input == null)
					throw new IllegalArgumentException();
				if (input instanceof IAmbiguousLinkingCandidate)
					return true;
				return false;
			}
		});
		@SuppressWarnings("unchecked") // cast is safe
		Collection<IAmbiguousLinkingCandidate> result = (Collection<IAmbiguousLinkingCandidate>) rawResult;
		return result;
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		LightweightTypeReference result = doGetActualType(identifiable, false);
		return toOwnedReference(result);
	}

	/* @Nullable */
	protected final LightweightTypeReference doGetActualType(JvmIdentifiableElement identifiable, boolean ignoreReassignedTypes) {
		if (ignoreReassignedTypes) {
			if (!shared.allTypes.contains(identifiable)) {
				return doGetDeclaredType(identifiable);
			}
		} else if (!shared.allReassignedTypes.contains(identifiable) && !shared.allTypes.contains(identifiable)) {
			int prevSize = shared.allReassignedTypes.size();
			LightweightTypeReference result = doGetDeclaredType(identifiable);
			// iff the declared type is a computed type and the type computation itself
			// reassignes the type, try again to find it
			// in other words: if a reassigned type was added while a declared type was converted
			// to a lightweight type, check again if the identifiable is reassigned now
			if (prevSize == shared.allReassignedTypes.size() || !shared.allReassignedTypes.contains(identifiable)) {
				return result;
			}
		}
		LightweightTypeReference result = doGetActualTypeNoDeclaration(identifiable, ignoreReassignedTypes);
		if (result == null) {
			return doGetDeclaredType(identifiable);
		}
		return result;
	}

	protected LightweightTypeReference doGetActualTypeNoDeclaration(JvmIdentifiableElement identifiable, boolean ignoreReassignedTypes) {
		if (reassignedTypes != null && !ignoreReassignedTypes) {
			LightweightTypeReference result = reassignedTypes.get(identifiable);
			if (result != null) {
				return result;
			}
		}
		LightweightTypeReference result = basicGetTypes().get(identifiable);
		return result;
	}
	
	/* @Nullable */
	protected LightweightTypeReference doGetDeclaredType(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmType) {
			ITypeReferenceOwner owner = getReferenceOwner();
			LightweightTypeReference result = owner.toLightweightTypeReference((JvmType) identifiable);
			return result;
		}
		JvmTypeReference type = getDeclaredType(identifiable);
		if (type != null) {
			ITypeReferenceOwner owner = getReferenceOwner();
			LightweightTypeReference result = owner.toLightweightTypeReference(type);
			return result;
		}
		return null;
	}
	
	/* @Nullable */
	protected JvmTypeReference getDeclaredType(JvmIdentifiableElement identifiable) {
		if (identifiable instanceof JvmOperation) {
			return ((JvmOperation) identifiable).getReturnType();
		}
		if (identifiable instanceof JvmField) {
			return ((JvmField) identifiable).getType();
		}
		if (identifiable instanceof JvmConstructor) {
			return shared.resolver.getServices().getTypeReferences().createTypeRef(((JvmConstructor) identifiable).getDeclaringType());
		}
		if (identifiable instanceof JvmFormalParameter) {
			JvmTypeReference parameterType = ((JvmFormalParameter) identifiable).getParameterType();
			return parameterType;
		}
		return null;
	}
	
	/* @Nullable */
	public final IFeatureLinkingCandidate getFeature(XAbstractFeatureCall featureCall) {
		if (!shared.allLinking.contains(featureCall)) {
			return null;
		}
		return doGetFeature(featureCall);
	}

	protected IFeatureLinkingCandidate doGetFeature(XAbstractFeatureCall featureCall) {
		return (IFeatureLinkingCandidate) basicGetLinkingMap().get(featureCall);
	}
	
	/* @Nullable */
	public final IConstructorLinkingCandidate getConstructor(XConstructorCall constructorCall) {
		if (!shared.allLinking.contains(constructorCall)) {
			return null;
		}
		return doGetConstructor(constructorCall);
	}

	protected IConstructorLinkingCandidate doGetConstructor(XConstructorCall constructorCall) {
		return (IConstructorLinkingCandidate) basicGetLinkingMap().get(constructorCall);
	}
	
	protected void acceptCandidate(XExpression expression, IApplicableCandidate candidate) {
		IApplicableCandidate prev = ensureLinkingMapExists().put(expression, candidate); 
		if (prev != null) {
			throw new IllegalStateException("Expression " + expression + " was already linked to: " + prev + "\nCannot relink to: " + candidate);
		}
	}
	
	void reassignLinkingInformation(XExpression expression, IApplicableCandidate candidate) {
		IApplicableCandidate prev = ensureLinkingMapExists().put(expression, candidate); 
		if (prev == null) {
			throw new IllegalStateException("Expression " + expression + " was never linked, cannot replace linking information");
		}
	}

	protected DefaultReentrantTypeResolver getResolver() {
		return shared.resolver;
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
		appendContent(linkingMap, "featureLinking", result, indentation);
		appendContent(unboundTypeParameters, "unboundTypeParameters", result, indentation);
		appendListMapContent(typeParameterHints, "typeParameterHints", result, indentation);
		appendContent(declaredTypeParameters, "declaredTypeParameters", result, indentation);
		appendContent(diagnostics, "diagnostics", result, indentation);
		appendContent(deferredLogic, "runnables", result, indentation);
		appendContent(propagatedTypes, "propagatedTypes", result, indentation);
	}

	protected void appendContent(/* @Nullable */ Map<?, ?> map, String prefix, StringBuilder result, String indentation) {
		if (map != null) {
			MapJoiner joiner = Joiner.on("\n  " + indentation).withKeyValueSeparator(" -> ");
			result.append("\n").append(indentation).append(prefix).append(":\n").append(indentation).append("  ");
			joiner.appendTo(result, map);
		}
	}
	
	protected void appendContent(/* @Nullable */ Collection<?> values, String prefix, StringBuilder result, String indentation) {
		if (values != null) {
			Joiner joiner = Joiner.on("\n  " + indentation);
			result.append("\n").append(indentation).append(prefix).append(":\n").append(indentation).append("  ");
			joiner.appendTo(result, values);
		}
	}
	
	protected void appendListMapContent(/* @Nullable */ Map<?, ? extends Collection<?>> map, String prefix, StringBuilder result, String indentation) {
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
				resolvedTypeParameters = new SharedKeysAwareSet<Object>(shared.allResolvedTypeParameters);
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
			protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, ConstraintVisitingInfo visiting, boolean lowerBound) {
				if (reference.getKind() == LightweightTypeReference.KIND_UNBOUND_TYPE_REFERENCE) {
					if (handle.equals(((UnboundTypeReference) reference).getHandle())) {
						return doVisitUnboundTypeReference((UnboundTypeReference) reference, visiting);
					}
				}
				return super.visitTypeArgument(reference, visiting, lowerBound);
			}
			
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
						WildcardTypeReference result = getOwner().newWildcardTypeReference();
						for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
							result.addUpperBound(visitTypeArgument(upperBound, visiting));
						}
						return result;
					}
				}
				return super.doVisitWildcardTypeReference(reference, visiting);
			}
			
			@Override
			/* @Nullable */
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
				BoundTypeArgumentSource source = existingTypeArgument.getSource();
				LightweightTypeReference existingTypeReference = existingTypeArgument.getTypeReference();
				LightweightTypeReference boundTypeReference = boundTypeArgument.getTypeReference();
				if (source == BoundTypeArgumentSource.INFERRED || source == BoundTypeArgumentSource.INFERRED_EXPECTATION) {
					if (existingTypeReference instanceof UnboundTypeReference) {
						UnboundTypeReference existingReference = (UnboundTypeReference) existingTypeReference;
						// resolve similar pending type arguments, too
						if (existingTypeArgument.getDeclaredVariance() == existingTypeArgument.getActualVariance()) {
							acceptHint(existingReference.getHandle(), boundTypeArgument);
						}
					} else if (existingTypeReference != null && existingTypeReference != boundTypeReference) {
						if (!existingTypeReference.isResolved()) {
							ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(getReferenceOwner());
							collector.processPairedReferences(boundTypeReference, existingTypeReference);
						}
					}
				} else if (source == BoundTypeArgumentSource.CONSTRAINT) {
					if (existingTypeReference instanceof UnboundTypeReference) {
						UnboundTypeReference existingReference = (UnboundTypeReference) existingTypeReference;
						if (!existingReference.internalIsResolved()) {
							existingReference.acceptHint(boundTypeReference, 
								BoundTypeArgumentSource.INFERRED, boundTypeArgument, VarianceInfo.OUT, VarianceInfo.OUT);
						}
					}
				} else if (source == BoundTypeArgumentSource.INFERRED_CONSTRAINT) {
					if (existingTypeReference instanceof UnboundTypeReference) {
						UnboundTypeReference existingReference = (UnboundTypeReference) existingTypeReference;
						if (!isResolved(existingReference.getHandle())) {
							if (!boundTypeReference.isWildcard()) {
								existingReference.acceptHint(boundTypeReference, 
										BoundTypeArgumentSource.INFERRED, boundTypeArgument, VarianceInfo.OUT, VarianceInfo.OUT);
							}
						}
					}
				} else if (source == BoundTypeArgumentSource.INFERRED_LATER) {
					if (existingTypeReference instanceof UnboundTypeReference) {
						UnboundTypeReference existingReference = (UnboundTypeReference) existingTypeReference;
						if (!isResolved(existingReference.getHandle())) {
							// we have a dependent type resolved to a wildcard:
							// normalize the wildcard to the invariant for this type reference
							// and add it as a hint iff this type argument is used as an invariant
							// bound type in a position, where an existential type can be applied
							// see bug 461923
							if (boundTypeReference.isWildcard()) {
								if (existingTypeArgument.getActualVariance() == VarianceInfo.INVARIANT && existingTypeArgument.getDeclaredVariance() == VarianceInfo.OUT) {
									existingReference.acceptHint(boundTypeReference.getInvariantBoundSubstitute(), 
											BoundTypeArgumentSource.INFERRED, boundTypeArgument, VarianceInfo.OUT, VarianceInfo.OUT);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public final boolean isResolved(Object handle) {
		return shared.allResolvedTypeParameters.contains(handle) && doIsResolved(handle);
	}

	protected boolean doIsResolved(Object handle) {
		return resolvedTypeParameters != null && resolvedTypeParameters.contains(handle);
	}

	protected boolean isPropagatedType(XExpression expression) {
		return propagatedTypes != null && propagatedTypes.contains(expression);
	}
	
	@Override
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
	
	/* @Nullable */
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
	
	protected void addExpressionScope(EObject context, IFeatureScopeSession session, IExpressionScope.Anchor anchor) {
		getFeatureScopeTracker().addExpressionScope(this, context, session, anchor);
	}
	
	protected void replacePreviousExpressionScope(EObject context, IFeatureScopeSession session, IExpressionScope.Anchor anchor) {
		getFeatureScopeTracker().replacePreviousExpressionScope(context, session, anchor);
	}
	
	@Override
	public IExpressionScope getExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		return getFeatureScopeTracker().getExpressionScope(context, anchor);
	}
	
	@Override
	public boolean hasExpressionScope(EObject context, IExpressionScope.Anchor anchor) {
		return getFeatureScopeTracker().hasExpressionScope(context, anchor);
	}
	
	protected IResolvedTypes withFlattenedReassignedTypes() {
		final Map<JvmIdentifiableElement, LightweightTypeReference> flattened = getFlattenedReassignedTypes();
		if (flattened != null)
			return new ForwardingResolvedTypes() {
				@Override
				/* @Nullable */
				public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
					LightweightTypeReference reassigned = flattened.get(identifiable);
					if (reassigned != null)
						return reassigned;
					return super.getActualType(identifiable);
				}
			
				@Override
				protected IResolvedTypes delegate() {
					return ResolvedTypes.this;
				}
			};
		return this;
	}

	/* @Nullable */
	protected Map<JvmIdentifiableElement, LightweightTypeReference> getFlattenedReassignedTypes() {
		if (reassignedTypes == null || reassignedTypes.isEmpty()) {
			return null;
		}
		if (reassignedTypes.size() == 1) {
			Map.Entry<JvmIdentifiableElement, LightweightTypeReference> singleEntry = reassignedTypes.entrySet().iterator().next();
			return Collections.singletonMap(singleEntry.getKey(), singleEntry.getValue());
		}
		return new HashMap<JvmIdentifiableElement, LightweightTypeReference>(reassignedTypes);
	}
	
}
