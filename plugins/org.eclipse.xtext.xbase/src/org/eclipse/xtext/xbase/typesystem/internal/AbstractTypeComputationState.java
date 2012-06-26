/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.references.BaseTypeComputationState;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
public abstract class AbstractTypeComputationState extends BaseTypeComputationState {
	private final ResolvedTypes resolvedTypes;
	private IFeatureScopeSession featureScopeSession;
	private final DefaultReentrantTypeResolver reentrantTypeResolver;
	
	protected AbstractTypeComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			DefaultReentrantTypeResolver reentrantTypeResolver) {
		this.resolvedTypes = resolvedTypes;
		this.featureScopeSession = featureScopeSession;
		this.reentrantTypeResolver = reentrantTypeResolver;
	}
	
	@Override
	protected ResolvedTypes getResolvedTypes() {
		return resolvedTypes;
	}
	
	protected IFeatureScopeSession getFeatureScopeSession() {
		return featureScopeSession;
	}
	
	protected CommonTypeComputationServices getServices() {
		return reentrantTypeResolver.getServices();
	}
	
	protected TypeReferences getTypeReferences() {
		return getServices().getTypeReferences();
	}
	
	protected ITypeComputer getTypeComputer() {
		return reentrantTypeResolver.getTypeComputer();
	}
	
	protected DefaultReentrantTypeResolver getResolver() {
		return reentrantTypeResolver;
	}
	
	protected BoundTypeArgumentMerger getTypeArgumentMerger() {
		return reentrantTypeResolver.getTypeArgumentMerger();
	}
	
	public LightweightTypeComputationResult computeTypes(@Nullable XExpression expression) {
		 ResolvedTypes types = computeTypes(expression, true);
		 if (types != null) {
			return new ResolutionBasedComputationResult(expression, types); 
		 } else {
			// create diagnostics if necessary
			return new NoTypeResult();
		 }
	}
	
	@Nullable
	protected final ResolvedTypes computeTypes(@Nullable XExpression expression, boolean mergeAll) {
		if (expression != null) {
			StackedResolvedTypes stackedResolvedTypes = new ExpressionAwareStackedResolvedTypes(resolvedTypes, expression);
			ExpressionTypeComputationState state = createExpressionComputationState(expression, stackedResolvedTypes);
			getResolver().getTypeComputer().computeTypes(expression, state);
			if (mergeAll) {
				stackedResolvedTypes.mergeIntoParent();
				return resolvedTypes;
			}
			return stackedResolvedTypes;
		} else {
			return null;
		}
	}
	
	@Nullable
	protected StackedResolvedTypes computeTypesWithoutMerge(@Nullable XExpression expression) {
		return (StackedResolvedTypes) computeTypes(expression, false);
	}

	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new ExpressionTypeComputationState(typeResolution, featureScopeSession, reentrantTypeResolver, this, expression);
	}
	
	protected abstract LightweightTypeReference acceptType(AbstractTypeExpectation expectation, LightweightTypeReference type, ConformanceHint conformanceHint, boolean returnType);
	
	public AbstractTypeComputationState fork() {
		return this;
	}
	
	public AbstractTypeComputationState withExpectation(@Nullable LightweightTypeReference expectation) {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this, expectation);
	}

	public AbstractTypeComputationState withNonVoidExpectation() {
		return withNonVoidExpectation(resolvedTypes);
	}
	
	protected AbstractTypeComputationState withNonVoidExpectation(ResolvedTypes resolvedTypes) {
		return new TypeComputationStateWithNonVoidExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
	}

	public AbstractTypeComputationState withoutExpectation() {
		return new NoExpectationTypeComputationState(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
	}

	public AbstractTypeComputationState withReturnExpectation() {
		return new ReturnExpectationTypeComputationState(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
	}

	public AbstractTypeComputationState withoutImmediateExpectation() {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this, null);
	}
	
	public AbstractTypeComputationState withTypeCheckpoint() {
		return new TypeCheckpointComputationState(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
	}
	
	public AbstractTypeComputationState assignType(JvmIdentifiableElement element, LightweightTypeReference type) {
		TypeAssigner assigner = assignTypes();
		assigner.assignType(element, type);
		return assigner.getForkedState();
	}
	
	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		featureScopeSession = featureScopeSession.addLocalElement(QualifiedName.create(element.getSimpleName()), element);
	}

	public TypeAssigner assignTypes() {
		final TypeCheckpointComputationState state = new TypeCheckpointComputationState(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
		return createTypeAssigner(state);
	}

	protected TypeAssigner createTypeAssigner(final AbstractTypeComputationState state) {
		return new TypeAssigner(state);
	}

	public final List<LightweightTypeExpectation> getImmediateExpectations() {
		return getImmediateExpectations(this);
	}
	
	public final List<LightweightTypeExpectation> getReturnExpectations() {
		return getReturnExpectations(this);
	}
	
	protected abstract List<LightweightTypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState);
	
	protected abstract List<LightweightTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState);
	
	public void acceptActualType(LightweightTypeReference type) {
		for(LightweightTypeExpectation expectation: getImmediateExpectations()) {
			expectation.acceptActualType(type, ConformanceHint.EXPECTATION_INDEPENDENT);
		}
	}

	@Nullable
	public LightweightTypeReference internalGetType(JvmIdentifiableElement element) {
		return resolvedTypes.internalGetActualType(element);
	}

	public void reassignType(XExpression object, LightweightTypeReference type) {
		JvmIdentifiableElement refinable = getTypeComputer().getRefinableCandidate(object, this);
		if (refinable != null) {
			resolvedTypes.reassignType(refinable, type);
		}
	}

	public void discardReassignedTypes(XExpression object) {
		JvmIdentifiableElement refinable = getTypeComputer().getRefinableCandidate(object, this);
		if (refinable != null) {
			resolvedTypes.reassignType(refinable, (LightweightTypeReference) null);
		}
	}

	public List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = resolvedTypes.getFeature(featureCall);
		if (result != null) {
			return Collections.singletonList(result);
		}
		// TODO reuse this information later on
//		final Map<XExpression, StackedResolvedTypes> demandComputedTypes = Maps.newLinkedHashMap();
		
		StackedResolvedTypes demandComputedTypes = new StackedResolvedTypes(resolvedTypes);
		final AbstractTypeComputationState forked = fork().withNonVoidExpectation(demandComputedTypes);
		ForwardingResolvedTypes demandResolvedTypes = new ForwardingResolvedTypes() {
			
			@Override
			protected LightweightResolvedTypes delegate() {
				return forked.getResolvedTypes();
			}
			
			@Override
			@Nullable
			public LightweightTypeReference internalGetActualType(@Nullable XExpression expression) {
				LightweightTypeReference type = super.internalGetActualType(expression);
				if (type == null && expression != null) {
					LightweightTypeComputationResult result = forked.computeTypes(expression);
					return result.internalGetActualExpressionType();
				}
				return type;
			}
		};
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, featureScopeSession, demandResolvedTypes);
		List<IFeatureLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(featureCall, demandComputedTypes, description));
		}
		if (resultList.isEmpty()) {
			throw new UnsupportedOperationException("TODO Add error candidate");
		}
		return resultList;
	}
	
	protected IFeatureLinkingCandidate createCandidate(XAbstractFeatureCall featureCall, final StackedResolvedTypes demandComputedTypes, IEObjectDescription description) {
		if (description instanceof BucketedEObjectDescription) {
			BucketedEObjectDescription casted = (BucketedEObjectDescription) description;
			if (casted.getReceiverType() != null) {
//				final ExpressionAwareStackedResolvedTypes resolvedTypes = new ExpressionAwareStackedResolvedTypes(demandComputedTypes, featureCall);
				ExpressionTypeComputationState state = createExpressionComputationState(featureCall, demandComputedTypes);
				return new FeatureLinkingCandidate(featureCall, description, state);
			}
		}
		final ExpressionAwareStackedResolvedTypes resolvedTypes = new ExpressionAwareStackedResolvedTypes(this.resolvedTypes, featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		return new FeatureLinkingCandidate(featureCall, description, state);
	}
	
	public List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = resolvedTypes.getConstructor(constructorCall);
		if (result != null) {
			return Collections.singletonList(result);
		}
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, featureScopeSession, resolvedTypes);
		List<IConstructorLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(constructorCall, description));
		}
		if (resultList.isEmpty()) {
			throw new UnsupportedOperationException("TODO Add error candidate");
		}
		return resultList;
	}

	protected IConstructorLinkingCandidate createCandidate(XConstructorCall constructorCall, IEObjectDescription description) {
		StackedResolvedTypes stackedResolvedTypes = new ExpressionAwareStackedResolvedTypes(resolvedTypes, constructorCall);
		ExpressionTypeComputationState state = createExpressionComputationState(constructorCall, stackedResolvedTypes);
		return new ConstructorLinkingCandidate(constructorCall, description, state);
	}

	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return resolvedTypes.createUnboundTypeReference(expression, typeParameter);
	}
	
	public ActualTypeArgumentCollector createTypeArgumentCollector(List<JvmTypeParameter> typeParameters, BoundTypeArgumentSource source) {
		ActualTypeArgumentCollector typeArgumentCollector = new UnboundTypeParameterAwareTypeArgumentCollector(typeParameters, source, getReferenceOwner()) {
			@Override
			protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(
					@Nullable Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
				return createSubstitutor(mapping);
			}
//			@Override
//			public void doVisitUnboundTypeReference(UnboundTypeReference reference, LightweightTypeReference param) {
//				BaseUnboundTypeParameter stacked = getResolvedTypes().getUnboundTypeReference(reference.getHandle());
//				if (!stacked.isComputed()) {
//					LightweightTypeReference potentiallyWrapped = UnboundTypeParameters.asWrapperType(param, getServices().getPrimitives());
//					acceptHint(stacked, potentiallyWrapped);
//					return null;
//				}
//			}
		};
		return typeArgumentCollector;
	}
	
	public UnboundTypeParameterPreservingSubstitutor createSubstitutor(@Nullable Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping) {
		return getResolvedTypes().createSubstitutor(typeParameterMapping);
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", getClass().getSimpleName(), resolvedTypes);
	}

	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
		return new OwnedConverter(getReferenceOwner()).toLightweightReference(reference);
	}

	public TypeReferenceOwner getReferenceOwner() {
		return getResolvedTypes();
	}
}
