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
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractTypeComputationState implements ITypeComputationState, ITypeComputationState.Fork {
	protected static class TypeAssigner implements ITypeAssigner {
		private final AbstractTypeComputationState state;

		protected TypeAssigner(AbstractTypeComputationState state) {
			this.state = state;
		}

		public AbstractTypeComputationState getForkedState() {
			return state;
		}

		public void assignType(JvmIdentifiableElement element, @Nullable JvmTypeReference declaredType, @Nullable JvmTypeReference expectedType) {
			// TODO validation messages
			if (declaredType != null)
				state.getResolvedTypes().setType(element, declaredType);
			else
				state.getResolvedTypes().setType(element, expectedType);
			state.addLocalToCurrentScope(element);
		}

		public void assignType(JvmIdentifiableElement element, @Nullable JvmTypeReference declaredType) {
			state.getResolvedTypes().setType(element, declaredType);
			state.addLocalToCurrentScope(element);
		}
	}

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
	
	public ITypeComputationResult computeTypes(@Nullable XExpression expression) {
		 ResolvedTypes types = computeTypes(expression, true);
		 if (types != null) {
			return new ResolutionBasedComputationResult(expression, types); 
		 } else {
			// create diagnostics if necessary
			return new NoTypeResult();
		 }
	}
	
	@Nullable
	protected ResolvedTypes computeTypes(@Nullable XExpression expression, boolean mergeAll) {
		if (expression != null) {
			StackedResolvedTypes stackedResolvedTypes = new StackedResolvedTypes(resolvedTypes);
			ExpressionTypeComputationState state = createExpressionComputationState(expression, stackedResolvedTypes);
			getResolver().getTypeComputer().computeTypes(expression, state);
			// TODO selective merge
			ResolvedTypes result = mergeAll ? stackedResolvedTypes.mergeIntoParent() : stackedResolvedTypes;
			return result;
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
	
	protected abstract void acceptType(AbstractTypeExpectation expectation, JvmTypeReference type, ConformanceHint conformanceHint, boolean returnType);
	
	public AbstractTypeComputationState fork() {
		return this;
	}
	
	public AbstractTypeComputationState withExpectation(JvmTypeReference expectation) {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this, expectation);
	}

	public AbstractTypeComputationState withNonVoidExpectation() {
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
	
	public AbstractTypeComputationState assignType(JvmIdentifiableElement element, JvmTypeReference type) {
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

	public final List<ITypeExpectation> getImmediateExpectations() {
		return getImmediateExpectations(this);
	}
	
	public final List<ITypeExpectation> getReturnExpectations() {
		return getReturnExpectations(this);
	}
	
	protected abstract List<ITypeExpectation> getImmediateExpectations(AbstractTypeComputationState actualState);
	
	protected abstract List<ITypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState);
	
	protected AbstractTypeExpectation createTypeExpectation(@Nullable JvmTypeReference expectedType, AbstractTypeComputationState actualState, boolean returnType) {
		AbstractTypeExpectation result = null;
		if (expectedType != null) {
			result = new TypeExpectation(expectedType, actualState, returnType);
		} else {
			result = new NoExpectation(actualState, returnType);
		}
		return result;
	}
	
	public void acceptActualType(JvmTypeReference type) {
		for(ITypeExpectation expectation: getImmediateExpectations()) {
			expectation.acceptActualType(type, ConformanceHint.EXPECTATION_INDEPENDENT);
		}
	}

	@Nullable
	public JvmTypeReference getType(JvmIdentifiableElement element) {
		return resolvedTypes.getActualType(element);
	}

	public void reassignType(XExpression object, JvmTypeReference type) {
		JvmIdentifiableElement refinable = getTypeComputer().getRefinableCandidate(object, this);
		if (refinable != null) {
			resolvedTypes.reassignType(refinable, type);
		}
	}

	public void discardReassignedTypes(XExpression object) {
		JvmIdentifiableElement refinable = getTypeComputer().getRefinableCandidate(object, this);
		if (refinable != null) {
			resolvedTypes.reassignType(refinable, null);
		}
	}

	public List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = resolvedTypes.getFeature(featureCall);
		if (result != null) {
			return Collections.singletonList(result);
		}
		IResolvedTypes demandResolvedTypes = new DelegatingResolvedTypes(resolvedTypes) {
			
			// TODO reuse this information later on
			private Map<XExpression, StackedResolvedTypes> demandComputedTypes;
			
			@Override
			@Nullable
			public JvmTypeReference getActualType(@Nullable XExpression expression) {
				JvmTypeReference type = super.getActualType(expression);
				if (type == null && expression != null) {
					if (demandComputedTypes == null) {
						demandComputedTypes = Maps.newHashMapWithExpectedSize(4);
					}
					StackedResolvedTypes previouslyComputed = demandComputedTypes.get(expression);
					if (previouslyComputed != null) {
						return previouslyComputed.getActualType(expression);
					}
					AbstractTypeComputationState expressionState = fork().withNonVoidExpectation();
					StackedResolvedTypes result = expressionState.computeTypesWithoutMerge(expression);
					if (result != null) {
						demandComputedTypes.put(expression, result);
						return result.getActualType(expression);
					}
					return null;
				}
				return type;
			}
		};
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, featureScopeSession, demandResolvedTypes);
		List<IFeatureLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(featureCall, description));
		}
		if (resultList.isEmpty()) {
			throw new UnsupportedOperationException("TODO Add error candidate");
		}
		return resultList;
	}
	
	protected IFeatureLinkingCandidate createCandidate(XAbstractFeatureCall featureCall, IEObjectDescription description) {
		return new FeatureLinkingCandidate(featureCall, description, this);
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
		return new ConstructorLinkingCandidate(constructorCall, (JvmConstructor) description.getEObjectOrProxy(), this);
	}

}
