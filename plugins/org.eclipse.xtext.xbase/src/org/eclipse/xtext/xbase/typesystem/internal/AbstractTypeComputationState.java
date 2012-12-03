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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.FeatureLinkHelper;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
public abstract class AbstractTypeComputationState implements ITypeComputationState {
	protected final ResolvedTypes resolvedTypes;
	private IFeatureScopeSession featureScopeSession;
	private final DefaultReentrantTypeResolver reentrantTypeResolver;
	private List<AbstractTypeExpectation> expectations;
	private List<AbstractTypeExpectation> returnExpectations;
	
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
	
	protected TypeReferences getTypeReferences() {
		return reentrantTypeResolver.getServices().getTypeReferences();
	}
	
	protected ITypeComputer getTypeComputer() {
		return reentrantTypeResolver.getTypeComputer();
	}
	
	protected DefaultReentrantTypeResolver getResolver() {
		return reentrantTypeResolver;
	}
	
	protected abstract LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... conformanceHint);
	protected abstract LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... conformanceHint);
	
	public final ITypeComputationResult computeTypes(@Nullable XExpression expression) {
		if (expression != null) {
			if (expression.eContainer() == null && expression.eResource() == null)
				throw new IllegalStateException("Dangling expression: " + expression);
			ExpressionAwareStackedResolvedTypes stackedResolvedTypes = doComputeTypes(expression);
			stackedResolvedTypes.performMergeIntoParent();
			return new ResolutionBasedComputationResult(expression, resolvedTypes);
		} else {
			return new NoTypeResult(null, getReferenceOwner());
		}
	}
	
	protected ExpressionAwareStackedResolvedTypes doComputeTypes(XExpression expression) {
		ExpressionAwareStackedResolvedTypes stackedResolvedTypes = resolvedTypes.pushTypes(expression);
		ExpressionTypeComputationState state = createExpressionComputationState(expression, stackedResolvedTypes);
		getResolver().getTypeComputer().computeTypes(expression, state);
		stackedResolvedTypes.prepareMergeIntoParent();
		return stackedResolvedTypes;
	}
	
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new ExpressionTypeComputationState(typeResolution, featureScopeSession, reentrantTypeResolver, this, expression);
	}
	
	/*
	 * Clients who override this method have to be careful with AbstractPendingLinkingCandidate#computeArgumentTypes where
	 * a subtype of TypeComputationStateWithExpectation is used.
	 */
	public TypeComputationStateWithExpectation withExpectation(@Nullable LightweightTypeReference expectation) {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this, expectation);
	}
	
	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		TypeExpectation typeExpectation = new TypeExpectation(expectation, this, false);
		getResolvedTypes().refineExpectedType(expression, typeExpectation);
	}
	
	public TypeComputationStateWithExpectation withRootExpectation(@Nullable LightweightTypeReference expectation) {
		return new TypeComputationStateWithRootExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this, expectation);
	}
	
	public AbstractTypeComputationState withNonVoidExpectation() {
		return withNonVoidExpectation(resolvedTypes);
	}
	
	protected AbstractTypeComputationState withNonVoidExpectation(ResolvedTypes resolvedTypes) {
		return new TypeComputationStateWithNonVoidExpectation(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
	}

	public AbstractTypeComputationState withReturnExpectation() {
		return new ReturnExpectationTypeComputationState(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
	}

	public AbstractTypeComputationState withoutExpectation() {
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
		TypeCheckpointComputationState state = new TypeCheckpointComputationState(resolvedTypes, featureScopeSession, reentrantTypeResolver, this);
		return createTypeAssigner(state);
	}

	protected TypeAssigner createTypeAssigner(final AbstractTypeComputationState state) {
		return new TypeAssigner(state);
	}

	public final List<? extends ITypeExpectation> getExpectations() {
		if (expectations == null)
			expectations = getExpectations(this);
		return expectations;
	}
	
	protected final List<? extends ITypeExpectation> getReturnExpectations() {
		if (returnExpectations == null)
			returnExpectations = getReturnExpectations(this, false);
		return returnExpectations;
	}
	
	protected abstract List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState);
	
	protected abstract List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation);
	
	public void acceptActualType(LightweightTypeReference type) {
		for(ITypeExpectation expectation: getExpectations()) {
			expectation.acceptActualType(type, ConformanceHint.UNCHECKED, ConformanceHint.EXPECTATION_INDEPENDENT);
		}
	}

	@SuppressWarnings({ "null", "unused" })
	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		if (type == null)
			throw new IllegalArgumentException("Reassigned type may not be null");
		resolvedTypes.reassignType(refinable, type);
	}

	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		resolvedTypes.reassignType(refinable, (LightweightTypeReference) null);
	}

	public List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = resolvedTypes.getFeature(featureCall);
		if (result != null) {
			return Collections.<IFeatureLinkingCandidate>singletonList(new AppliedFeatureLinkingCandidate(result));
		}
		EObject proxyOrResolved = (EObject) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		if (proxyOrResolved == null) {
			result = new NullLinkingCandidate(featureCall);
			return Collections.singletonList(result);
		}
		if (!proxyOrResolved.eIsProxy()) {
			result = createResolvedLink(featureCall, (JvmIdentifiableElement) proxyOrResolved);
			return Collections.singletonList(result);
		}
		StackedResolvedTypes demandComputedTypes = resolvedTypes.pushTypes();
		final AbstractTypeComputationState forked = withNonVoidExpectation(demandComputedTypes);
		ForwardingResolvedTypes demandResolvedTypes = new ForwardingResolvedTypes() {
			@Override
			protected IResolvedTypes delegate() {
				return forked.getResolvedTypes();
			}
			
			@Override
			@Nullable
			public LightweightTypeReference getActualType(XExpression expression) {
				LightweightTypeReference type = super.getActualType(expression);
				if (type == null) {
					ITypeComputationResult result = forked.computeTypes(expression);
					return result.getActualExpressionType();
				}
				return type;
			}
		};
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, proxyOrResolved, featureScopeSession, demandResolvedTypes);
		List<IFeatureLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(featureCall, demandComputedTypes, toIdentifiableDescription(description)));
		}
		if (resultList.isEmpty()) {
			throw new IllegalStateException("Linking candidates may not be empty");
		}
		return resultList;
	}
	
	protected IFeatureLinkingCandidate createResolvedLink(XAbstractFeatureCall featureCall, JvmIdentifiableElement resolvedTo) {
		// TODO inject the helper ?
		FeatureLinkHelper helper = new FeatureLinkHelper();
		XExpression syntacticReceiver = helper.getSyntacticReceiver(featureCall);
		if (syntacticReceiver != null) {
			AbstractTypeComputationState child = withNonVoidExpectation();
			child.computeTypes(syntacticReceiver);
		}
		XExpression implicitReceiver = featureCall.getImplicitReceiver();
		if (implicitReceiver != null) {
			AbstractTypeComputationState child = withNonVoidExpectation();
			child.computeTypes(implicitReceiver);
		}
		XExpression implicitFirstArgument = featureCall.getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			AbstractTypeComputationState child = withNonVoidExpectation();
			child.computeTypes(implicitFirstArgument);
		}
		ExpressionAwareStackedResolvedTypes resolvedTypes = this.resolvedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		return new ResolvedFeature(featureCall, resolvedTo, helper, state);
	}
	
	protected IFeatureLinkingCandidate createCandidate(XAbstractFeatureCall featureCall, final StackedResolvedTypes demandComputedTypes, IIdentifiableElementDescription description) {
		if (description.getSyntacticReceiverType() != null) { // TOOD double check how we can deal with the demand computed types in an elegant manner
			final ExpressionAwareStackedResolvedTypes resolvedTypes = demandComputedTypes.pushTypes(featureCall);
			ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
			return new FeatureLinkingCandidate(featureCall, description, state) {
				@Override
				public void apply() {
					super.apply();
					XExpression receiver = getReceiver();
					if (receiver != null) {
						LightweightTypeReference receiverType = getReceiverType();
						if (receiverType == null) {
							throw new IllegalStateException("Cannot determine receiver's type");
						}
						if (receiverType.isMultiType()) {
							// cast should be safe since only members can have a receiver type
							JvmMember member = (JvmMember) getFeature();
							JvmDeclaredType declaringType = member.getDeclaringType();
							ParameterizedTypeReference declaratorReference = new ParameterizedTypeReference(receiverType.getOwner(), declaringType);
							if (!declaratorReference.isAssignableFrom(receiverType.toJavaType())) {
								for(LightweightTypeReference multiTypeComponent: receiverType.getMultiTypeComponents()) {
									if (declaratorReference.isAssignableFrom(multiTypeComponent)) {
										TypeExpectation refinedExpectation = new TypeExpectation(multiTypeComponent, getState(), false);
										demandComputedTypes.refineExpectedType(receiver, refinedExpectation);
										demandComputedTypes.mergeIntoParent();
										return;
									}
								}
							}
						}
						TypeExpectation refinedExpectation = new TypeExpectation(receiverType, getState(), false);
						demandComputedTypes.refineExpectedType(receiver, refinedExpectation);
					}
					demandComputedTypes.mergeIntoParent();
				}
			};
		}
		ExpressionAwareStackedResolvedTypes resolvedTypes = this.resolvedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			return new UnresolvableFeatureCall(featureCall, ((ScopeProviderAccess.ErrorDescription) description).getNode(), description.getName().toString(), state);
		} else {
			return new FeatureLinkingCandidate(featureCall, description, state);
		}
	}
	
	public List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = resolvedTypes.getConstructor(constructorCall);
		if (result != null) {
			return Collections.singletonList(result);
		}
		EObject proxyOrResolved = (EObject) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		if (proxyOrResolved == null) {
			result = new NullLinkingCandidate(constructorCall);
			return Collections.singletonList(result);
		}
		if (!proxyOrResolved.eIsProxy()) {
			result = createResolvedLink(constructorCall, (JvmConstructor) proxyOrResolved);
			return Collections.singletonList(result);
		}
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, proxyOrResolved, featureScopeSession, resolvedTypes);
		List<IConstructorLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(constructorCall, toIdentifiableDescription(description)));
		}
		if (resultList.isEmpty()) {
			throw new IllegalStateException("Linking candidates may not be empty");
		}
		return resultList;
	}

	protected IIdentifiableElementDescription toIdentifiableDescription(IEObjectDescription description) {
		if (description instanceof IIdentifiableElementDescription)
			return (IIdentifiableElementDescription) description;
		if (!(description.getEObjectOrProxy() instanceof JvmIdentifiableElement)) {
			throw new IllegalStateException("Given description does not describe an identifable element");
		}
		return new SimpleIdentifiableElementDescription(description);
	}

	protected IConstructorLinkingCandidate createResolvedLink(XConstructorCall constructorCall, JvmConstructor resolvedTo) {
		StackedResolvedTypes stackedResolvedTypes = resolvedTypes.pushTypes(constructorCall);
		ExpressionTypeComputationState state = createExpressionComputationState(constructorCall, stackedResolvedTypes);
		return new ResolvedConstructor(constructorCall, resolvedTo, state);
	}
	
	protected IConstructorLinkingCandidate createCandidate(XConstructorCall constructorCall, IIdentifiableElementDescription description) {
		StackedResolvedTypes stackedResolvedTypes = resolvedTypes.pushTypes(constructorCall);
		ExpressionTypeComputationState state = createExpressionComputationState(constructorCall, stackedResolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			return new UnresolvableConstructorCall(constructorCall, ((ScopeProviderAccess.ErrorDescription) description).getNode(), description.getName().toString(), state);
		} else {
			return new ConstructorLinkingCandidate(constructorCall, description, state);
		}
	}

	@Override
	public String toString() {
		return String.format("%s: %s", getClass().getSimpleName(), resolvedTypes);
	}

	public ITypeReferenceOwner getReferenceOwner() {
		return resolvedTypes.getReferenceOwner();
	}
	
	public OwnedConverter getConverter() {
		return new OwnedConverter(getReferenceOwner());
	}
}
