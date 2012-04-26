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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractTypeComputationState implements ITypeComputationState, ITypeComputationState.Fork {
	private List<AbstractStackedTypeComputationState> pendingForks = null;
	private final TypeResolution typeResolution;
	private final DefaultReentrantTypeResolver reentrantTypeResolver;
	
	protected AbstractTypeComputationState(TypeResolution typeResolution,
			DefaultReentrantTypeResolver reentrantTypeResolver) {
		this.typeResolution = typeResolution;
		this.reentrantTypeResolver = reentrantTypeResolver;
	}
	
	protected void addForkedState(AbstractStackedTypeComputationState fork) {
		ensurePendingForks().add(fork);
	}
	
	protected List<AbstractStackedTypeComputationState> ensurePendingForks() {
		if (pendingForks == null)
			pendingForks = Lists.newArrayListWithCapacity(2);
		return pendingForks;
	}
	
	protected TypeResolution getTypeResolution() {
		return typeResolution;
	}
	
	protected TypeReferences getTypeReferences() {
		return reentrantTypeResolver.getTypeReferences();
	}
	
	protected ITypeComputer getTypeComputer() {
		return reentrantTypeResolver.getTypeComputer();
	}
	
	protected DefaultReentrantTypeResolver getResolver() {
		return reentrantTypeResolver;
	}
	
	public ITypeComputationResult computeTypes(@Nullable XExpression expression) {
		if (expression != null) {
			StackedTypeResolution stackedTypeResolution = new StackedTypeResolution(typeResolution);
			ExpressionTypeComputationState state = createExpressionComputationState(expression, stackedTypeResolution);
			getResolver().getTypeComputer().computeTypes(expression, state);
			return new ResolutionBasedComputationResult(expression, stackedTypeResolution.mergeIntoParent());
		} else {
			// create diagnostics if necessary
			return new NoTypeResult();
		}
	}

	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedTypeResolution typeResolution) {
		return new ExpressionTypeComputationState(typeResolution, reentrantTypeResolver, this, expression);
	}
	
	protected abstract void acceptType(AbstractTypeExpectation expectation, JvmTypeReference type, ConformanceHint conformanceHint, boolean returnType);
	
	public Fork fork() {
		return this;
	}
	
	public ITypeComputationState withExpectation(JvmTypeReference expectation) {
		return new TypeComputationStateWithExpectation(typeResolution, reentrantTypeResolver, this, expectation);
	}

	public ITypeComputationState withNonVoidExpectation() {
		return new TypeComputationStateWithNonVoidExpectation(typeResolution, reentrantTypeResolver, this);
	}

	public ITypeComputationState withoutExpectation() {
		return new NoExpectationTypeComputationState(typeResolution, reentrantTypeResolver, this);
	}

	public ITypeComputationState withReturnExpectation() {
		return new ReturnExpectationTypeComputationState(typeResolution, reentrantTypeResolver, this);
	}

	public ITypeComputationState withoutImmediateExpectation() {
		return new TypeComputationStateWithExpectation(typeResolution, reentrantTypeResolver, this, null);
	}
	
	public ITypeComputationState withTypeCheckpoint() {
		return new TypeCheckpointComputationState(typeResolution, reentrantTypeResolver, this);
	}

	public ITypeComputationState assignType(JvmIdentifiableElement element, JvmTypeReference type) {
		ITypeAssigner assigner = assignTypes();
		assigner.assignType(element, type);
		return assigner.getForkedState();
	}

	public ITypeAssigner assignTypes() {
		final TypeCheckpointComputationState state = new TypeCheckpointComputationState(typeResolution, reentrantTypeResolver, this);
		return createTypeAssigner(state);
	}

	protected ITypeAssigner createTypeAssigner(final AbstractTypeComputationState state) {
		return new ITypeAssigner() {
			
			public ITypeComputationState getForkedState() {
				return state;
			}
			
			public void assignType(JvmIdentifiableElement element, @Nullable JvmTypeReference declaredType, @Nullable JvmTypeReference expectedType) {
				// TODO validation messages
				if (declaredType != null)
					state.getTypeResolution().setType(element, declaredType);
				else
					state.getTypeResolution().setType(element, expectedType);
			}
			
			public void assignType(JvmIdentifiableElement element, @Nullable JvmTypeReference declaredType) {
				state.getTypeResolution().setType(element, declaredType);
			}
		};
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
		return typeResolution.getActualType(element);
	}

	public void reassignType(XExpression object, JvmTypeReference type) {
		JvmIdentifiableElement refinable = getTypeComputer().getRefinableCandidate(object, this);
		if (refinable != null) {
			typeResolution.reassignType(refinable, type);
		}
	}

	public void discardReassignedTypes(XExpression object) {
		JvmIdentifiableElement refinable = getTypeComputer().getRefinableCandidate(object, this);
		if (refinable != null) {
			typeResolution.reassignType(refinable, null);
		}
	}

	public List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = typeResolution.getFeature(featureCall);
		if (result != null) {
			return Collections.singletonList(result);
		}
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		List<IFeatureLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(featureCall, (IValidatedEObjectDescription) description));
		}
		if (resultList.isEmpty()) {
			throw new UnsupportedOperationException("TODO Add error candidate");
		}
		return resultList;
	}
	
	protected IFeatureLinkingCandidate createCandidate(XAbstractFeatureCall featureCall, IValidatedEObjectDescription description) {
		return new FeatureLinkingCandidate(featureCall, description, this);
	}
	
	public List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = typeResolution.getConstructor(constructorCall);
		if (result != null) {
			return Collections.singletonList(result);
		}
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR);
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
