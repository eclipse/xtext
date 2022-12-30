/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.batch.ITypeImporter;
import org.eclipse.xtext.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * Base implementation of {@link ITypeComputationState}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt - Validation for checked exceptions
 */
public abstract class AbstractTypeComputationState implements ITypeComputationState {
	protected final ResolvedTypes resolvedTypes;
	private IFeatureScopeSession featureScopeSession;
	private final DefaultReentrantTypeResolver reentrantTypeResolver;
	private List<AbstractTypeExpectation> expectations;
	
	private List<AbstractTypeExpectation> returnExpectations;
	
	protected AbstractTypeComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession) {
		this.resolvedTypes = resolvedTypes;
		this.featureScopeSession = featureScopeSession;
		this.reentrantTypeResolver = resolvedTypes.getResolver();
	}
	
	public ResolvedTypes getResolvedTypes() {
		return resolvedTypes;
	}
	
	public IFeatureScopeSession getFeatureScopeSession() {
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
	
	protected abstract LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int flags);
	protected abstract LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, int flags);
	
	@Override
	public final ITypeComputationResult computeTypes(/* @Nullable */ XExpression expression) {
		resolvedTypes.checkCanceled();
		if (expression != null) {
			if (expression.eContainer() == null && expression.eResource() == null)
				throw new IllegalStateException("Dangling expression: " + expression);
			assert getResolvedTypes().doGetTypeData(expression) == null : "Expression was already resolved: " + expression;  
			ExpressionAwareStackedResolvedTypes stackedResolvedTypes = doComputeTypes(expression);
			stackedResolvedTypes.performMergeIntoParent();
			return new ResolutionBasedComputationResult(expression, resolvedTypes);
		} else {
			return new NoTypeResult(null, getReferenceOwner());
		}
	}
	
	protected ExpressionAwareStackedResolvedTypes doComputeTypes(XExpression expression) {
		ExpressionAwareStackedResolvedTypes stackedResolvedTypes = pushTypes(expression);
		ExpressionTypeComputationState state = createExpressionComputationState(expression, stackedResolvedTypes);
		stackedResolvedTypes.addExpressionScope(expression, state.getFeatureScopeSession(), IExpressionScope.Anchor.BEFORE);
		getResolver().getTypeComputer().computeTypes(expression, state);
		stackedResolvedTypes.prepareMergeIntoParent();
		if (stackedResolvedTypes.doGetTypeData(expression) == null) {
			state.acceptActualType(stackedResolvedTypes.getReferenceOwner().newAnyTypeReference());
		}
		stackedResolvedTypes.addExpressionScope(expression, getFeatureScopeSession(), IExpressionScope.Anchor.AFTER);
		return stackedResolvedTypes;
	}
	
	protected ExpressionAwareStackedResolvedTypes pushTypes(XExpression expression) {
		return getResolvedTypes().pushTypes(expression);
	}
	
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new ExpressionTypeComputationState(typeResolution, featureScopeSession, this, expression);
	}
	
	@Override
	public TypeComputationStateWithExpectation withExpectation(/* @Nullable */ LightweightTypeReference expectation) {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, this, expectation);
	}
	
	@Override
	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		TypeExpectation typeExpectation = new TypeExpectation(expectation, this, false);
		getResolvedTypes().refineExpectedType(expression, typeExpectation);
	}
	
	@Override
	public TypeComputationStateWithRootExpectation withRootExpectation(/* @Nullable */ LightweightTypeReference expectation) {
		return new TypeComputationStateWithRootExpectation(resolvedTypes, featureScopeSession, this, expectation);
	}
	
	@Override
	public TypeComputationStateWithRootExpectation withoutRootExpectation() {
		return new TypeComputationStateWithRootExpectation(resolvedTypes, featureScopeSession, this, null);
	}
	
	@Override
	public AbstractTypeComputationState withNonVoidExpectation() {
		return withNonVoidExpectation(resolvedTypes);
	}
	
	protected AbstractTypeComputationState withNonVoidExpectation(ResolvedTypes resolvedTypes) {
		return new TypeComputationStateWithNonVoidExpectation(resolvedTypes, featureScopeSession, this);
	}

	@Override
	public AbstractTypeComputationState withReturnExpectation() {
		return new ReturnExpectationTypeComputationState(resolvedTypes, featureScopeSession, this);
	}

	@Override
	public AbstractTypeComputationState withoutExpectation() {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, this, null);
	}
	
	@Override
	public TypeCheckpointComputationState withTypeCheckpoint(/* @Nullable */ EObject context) {
		return new TypeCheckpointComputationState(resolvedTypes, featureScopeSession, this);
	}
	
	@Override
	public AbstractTypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes) {
		return new ExpectedExceptionTypeComputationState(resolvedTypes, featureScopeSession, this, declaredExceptionTypes);
	}
	
	@Override
	public AbstractTypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */  LightweightTypeReference type) {
		return assignType(element, type, true);
	}
	
	@Override
	public AbstractTypeComputationState assignType(JvmIdentifiableElement element, /* @Nullable */  LightweightTypeReference type, boolean addToChildScope) {
		TypeAssigner assigner = assignTypes();
		assigner.assignType(element, type, addToChildScope);
		return assigner.getForkedState();
	}
	
	@Override
	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		String simpleName = element.getSimpleName();
		if (Strings.isNullOrEmpty(simpleName))
			return;
		QualifiedName elementName = QualifiedName.create(simpleName);
		addLocalToCurrentScope(elementName, element, !getResolver().isShadowingAllowed(elementName));
	}
	
	@Override
	public void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider) {
		LightweightTypeReference knownType = getResolvedTypes().getActualType(extensionProvider);
		if (knownType != null && !knownType.isAny() && !knownType.isUnknown()) {
			XFeatureCall prototype = getResolver().getXbaseFactory().createXFeatureCall();
			prototype.setFeature(extensionProvider);
			featureScopeSession = featureScopeSession.addToExtensionScope(Collections.<XExpression, LightweightTypeReference>singletonMap(prototype, knownType));
		}
	}
	
	@Override
	public void addTypeToStaticImportScope(JvmDeclaredType type) {
		featureScopeSession = featureScopeSession.addTypesToStaticScope(Collections.<JvmType>singletonList(type), Collections.<JvmType>emptyList());
	}
	
	@Override
	public void addTypeToStaticExtensionImportScope(JvmDeclaredType type) {
		featureScopeSession = featureScopeSession.addTypesToStaticScope(Collections.<JvmType>singletonList(type), Collections.<JvmType>emptyList());
	}
	
	@Override
	public void addImports(ITypeImporter.Client importer) {
		featureScopeSession = featureScopeSession.addImports(importer);
	}
	
	@Override
	public void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders) {
		if (extensionProviders.isEmpty())
			return;
		if (extensionProviders.size() == 1) {
			addExtensionToCurrentScope(extensionProviders.get(0));
			return;
		}
		Map<XExpression, LightweightTypeReference> prototypeToType = Maps2.newLinkedHashMapWithExpectedSize(extensionProviders.size());
		for(JvmIdentifiableElement extensionProvider: extensionProviders) {
			LightweightTypeReference knownType = getResolvedTypes().getActualType(extensionProvider);
			if (knownType != null && !knownType.isAny() && !knownType.isUnknown()) {
				XFeatureCall prototype = getResolver().getXbaseFactory().createXFeatureCall();
				prototype.setFeature(extensionProvider);
				prototypeToType.put(prototype, knownType);
			}
		}
		if (!prototypeToType.isEmpty())
			featureScopeSession = featureScopeSession.addToExtensionScope(prototypeToType);
	}
	
	protected void addLocalToCurrentScope(QualifiedName elementName, JvmIdentifiableElement element, boolean raiseIssueIfShadowing) {
		if (getResolver().isDisallowedName(elementName)) {
			resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.VARIABLE_NAME_DISALLOWED, 
					"'" + elementName + "' is not a valid name", 
					getResolver().getSourceElement(element),
					element.eClass().getEStructuralFeature("name"),
					-1,
					null));
			return;
		}
		if (getResolver().isDiscouragedName(elementName)) {
			if (!isIgnored(IssueCodes.VARIABLE_NAME_DISCOURAGED)) {
				resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
						getSeverity(IssueCodes.VARIABLE_NAME_DISCOURAGED),
						IssueCodes.VARIABLE_NAME_DISCOURAGED, 
						"'" + elementName + "' is a discouraged name", 
						getResolver().getSourceElement(element),
						element.eClass().getEStructuralFeature("name"),
						-1,
						null));
			}
		}
		if (raiseIssueIfShadowing) {
			IEObjectDescription existingElement = featureScopeSession.getLocalElement(elementName);
			if (existingElement != null) {
				resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
						Severity.ERROR,
						IssueCodes.VARIABLE_NAME_SHADOWING, 
						"Duplicate local variable " + elementName, 
						getResolver().getSourceElement(element),
						element.eClass().getEStructuralFeature("name"),
						-1,
						null));
			}
		}
		featureScopeSession = featureScopeSession.addLocalElement(elementName, element, getReferenceOwner());
	}
	
	@Override
	public void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType) {
		resolvedTypes.reassignTypeWithoutMerge(rawType, actualType);
		featureScopeSession = featureScopeSession.addLocalElement(name, rawType, getReferenceOwner());
	}
	
	@Override
	public TypeAssigner assignTypes() {
		TypeCheckpointComputationState state = withTypeCheckpoint(null);
		return createTypeAssigner(state);
	}
	
	@Override
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		resolvedTypes.addDiagnostic(diagnostic);
	}

	protected TypeAssigner createTypeAssigner(final AbstractTypeComputationState state) {
		return new TypeAssigner(state);
	}

	@Override
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
	
	@Override
	public void acceptCandidate(XExpression expression, IApplicableCandidate candidate) {
		getResolvedTypes().acceptCandidate(expression, candidate);
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type) {
		for(ITypeExpectation expectation: getExpectations()) {
			expectation.acceptActualType(type, ConformanceFlags.UNCHECKED);
		}
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		acceptActualType(type, ConformanceHint.toFlags(hints));
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, EnumSet<ConformanceHint> hints) {
		acceptActualType(type, ConformanceHint.toFlags(hints));
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, int flags) {
		if ((flags & ConformanceFlags.CHECKED) == 0)
			flags |= ConformanceFlags.UNCHECKED;
		List<? extends ITypeExpectation> expectations = (flags & ConformanceFlags.EXPLICIT_VOID_RETURN) != 0 ? getReturnExpectations() : getExpectations();
		for(ITypeExpectation expectation: expectations) {
			expectation.acceptActualType(type, flags);
		}
	}

	@Override
	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		if (type == null)
			throw new IllegalArgumentException("Reassigned type may not be null");
		resolvedTypes.reassignType(refinable, type);
	}

	@Override
	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		resolvedTypes.reassignType(refinable, (LightweightTypeReference) null);
	}

	@Override
	public List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = reentrantTypeResolver.getScopeProviderAccess().getKnownFeature(featureCall, this, resolvedTypes);
		if (result != null) {
			return Collections.singletonList(result);
		}
		EObject proxyOrResolved = (EObject) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		StackedResolvedTypes demandComputedTypes = resolvedTypes.pushTypes();
		final AbstractTypeComputationState forked = withNonVoidExpectation(demandComputedTypes);
		ForwardingResolvedTypes demandResolvedTypes = new ForwardingResolvedTypes() {
			@Override
			protected IResolvedTypes delegate() {
				return forked.getResolvedTypes();
			}
			
			@Override
			/* @Nullable */
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
		AbstractPendingLinkingCandidate<?> previouslyResolved = resolvedTypes.forwardLinking(featureCall);
		for(IEObjectDescription description: descriptions) {
			IFeatureLinkingCandidate candidate = createCandidate(featureCall, demandComputedTypes, toIdentifiableDescription(description));
			// TODO apply to constructors, too
			if (matches(previouslyResolved, candidate)) {
				return Collections.singletonList(candidate);
			}
			resultList.add(candidate);
		}
		if (resultList.isEmpty()) {
			resultList.add(new NullFeatureLinkingCandidate(featureCall, this));
		}
		return resultList;
	}

	private boolean matches(AbstractPendingLinkingCandidate<?> previouslyResolved, IFeatureLinkingCandidate candidate) {
		if (previouslyResolved == null) {
			return false;
		}
		if (!previouslyResolved.getClass().equals(candidate.getClass())) {
			return false;
		}
		AbstractPendingLinkingCandidate<?> casted = (AbstractPendingLinkingCandidate<?>)candidate;
		IIdentifiableElementDescription prevDescription = previouslyResolved.description;
		IIdentifiableElementDescription description = casted.description;
		if (!prevDescription.getShadowingKey().equals(description.getShadowingKey())) {
			return false;
		}
		if (!prevDescription.getElementOrProxy().equals(description.getElementOrProxy())) {
			return false;
		}
		if (!equalTypes(prevDescription.getSyntacticReceiverType(), description.getSyntacticReceiverType())) {
			return false;
		}
		if (!equalTypes(prevDescription.getImplicitReceiverType(), description.getImplicitReceiverType())) {
			return false;
		}
		if (!equalTypes(prevDescription.getImplicitFirstArgumentType(), description.getImplicitFirstArgumentType())) {
			return false;
		}
		return true;
	}
	
	private boolean equalTypes(LightweightTypeReference left, LightweightTypeReference right) {
		if (left == right) {
			return true;
		}
		if (right == null) {
			return false;
		}
		return left.getUniqueIdentifier().equals(right.getUniqueIdentifier());
	}

	protected IFeatureLinkingCandidate createResolvedLink(XAbstractFeatureCall featureCall, JvmIdentifiableElement resolvedTo) {
		ExpressionAwareStackedResolvedTypes resolvedTypes = this.resolvedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		
		FeatureLinkHelper helper = new FeatureLinkHelper();
		XExpression syntacticReceiver = helper.getSyntacticReceiver(featureCall);
		if (syntacticReceiver != null) {
			AbstractTypeComputationState child = state.withNonVoidExpectation();
			child.computeTypes(syntacticReceiver);
		}
		XExpression implicitReceiver = featureCall.getImplicitReceiver();
		if (implicitReceiver != null) {
			AbstractTypeComputationState child = state.withNonVoidExpectation();
			child.computeTypes(implicitReceiver);
		}
		XExpression implicitFirstArgument = featureCall.getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			AbstractTypeComputationState child = state.withNonVoidExpectation();
			child.computeTypes(implicitFirstArgument);
		}
		if (featureCall.isTypeLiteral() || featureCall.isPackageFragment()) {
			return new ResolvedTypeLiteral(featureCall, resolvedTo, getSingleExpectation(state), state);
		}
		return new ResolvedFeature(featureCall, resolvedTo, helper, getSingleExpectation(state), state);
	}
	
	protected IFeatureLinkingCandidate createCandidate(XAbstractFeatureCall featureCall, final StackedResolvedTypes demandComputedTypes, IIdentifiableElementDescription description) {
		if (description.getSyntacticReceiverType() != null) { 
			return createCandidateWithReceiverType(featureCall, demandComputedTypes, description);
		}
		// pretty much the same constraints as in #createCandidateWithReceiverType 
		ExpressionAwareStackedResolvedTypes resolvedTypes = this.resolvedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			ScopeProviderAccess.ErrorDescription errorDescription = (ScopeProviderAccess.ErrorDescription) description;
			boolean followUpError = errorDescription.isFollowUpError();
			if (followUpError) {
				return new FollowUpError(featureCall, state);
			}
			return new UnresolvableFeatureCall(featureCall, errorDescription.getNode(), description.getName().toString(), state);
		} else if (description.isTypeLiteral()) {
			return new TypeLiteralLinkingCandidate(featureCall, description, getSingleExpectation(state), state);
		} else {
			return new FeatureLinkingCandidate(featureCall, description, getSingleExpectation(state), state);
		}
	}
	
	protected ITypeExpectation getSingleExpectation(ITypeComputationState state) {
		List<? extends ITypeExpectation> result = state.getExpectations();
		if (result.size() != 1) {
			throw new IllegalStateException();
		}
		return result.get(0);
	}

	protected IFeatureLinkingCandidate createCandidateWithReceiverType(XAbstractFeatureCall featureCall, final StackedResolvedTypes demandComputedTypes,
			IIdentifiableElementDescription description) {
		final ExpressionAwareStackedResolvedTypes resolvedTypes = demandComputedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			ScopeProviderAccess.ErrorDescription errorDescription = (ScopeProviderAccess.ErrorDescription) description;
			boolean followUpError = errorDescription.isFollowUpError();
			if (followUpError) {
				return new FollowUpError(featureCall, state) {
					@Override
					public void applyToComputationState() {
						super.applyToComputationState();
						demandComputedTypes.mergeIntoParent();
					}
				};
			}
			return new UnresolvableFeatureCall(featureCall, errorDescription.getNode(), description.getName().toString(), state) {
				@Override
				public void applyToComputationState() {
					super.applyToComputationState();
					demandComputedTypes.mergeIntoParent();
				}
			};
		} else if (description.isTypeLiteral()) {
			return new TypeLiteralLinkingCandidate(featureCall, description, getSingleExpectation(state), state) {
				@Override
				public void applyToComputationState() {
					super.applyToComputationState();
					demandComputedTypes.mergeIntoParent();
				}
			};
		} 
		return new FeatureLinkingCandidate(featureCall, description, getSingleExpectation(state), state) {
			@Override
			public void applyToComputationState() {
				super.applyToComputationState();
				XExpression receiver = getReceiver();
				if (receiver != null) {
					LightweightTypeReference receiverType = getReceiverType();
					if (receiverType == null) {
						throw new IllegalStateException("Cannot determine receiver's type");
					}
					LightweightTypeReference expectedReceiverType = new FeatureLinkHelper().getExpectedReceiverType(getFeature(), receiverType);
					TypeExpectation refinedExpectation = new TypeExpectation(expectedReceiverType, getState(), false);
					demandComputedTypes.refineExpectedType(receiver, refinedExpectation);
				}
				demandComputedTypes.mergeIntoParent();
			}
		};
	}
	
	@Override
	public List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = reentrantTypeResolver.getScopeProviderAccess().getKnownConstructor(constructorCall, this, resolvedTypes);
		if(result != null) {
			return Collections.singletonList(result);
		}
		EObject proxyOrResolved = (EObject) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, proxyOrResolved, featureScopeSession, resolvedTypes);
		List<IConstructorLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(constructorCall, toIdentifiableDescription(description)));
		}
		if (resultList.isEmpty()) {
			resultList.add(new NullConstructorLinkingCandidate(constructorCall, this));
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
		return new ResolvedConstructor(constructorCall, resolvedTo, getSingleExpectation(state), state);
	}
	
	protected IConstructorLinkingCandidate createCandidate(XConstructorCall constructorCall, IIdentifiableElementDescription description) {
		StackedResolvedTypes stackedResolvedTypes = resolvedTypes.pushTypes(constructorCall);
		ExpressionTypeComputationState state = createExpressionComputationState(constructorCall, stackedResolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			return new UnresolvableConstructorCall(constructorCall, ((ScopeProviderAccess.ErrorDescription) description).getNode(), description.getName().toString(), state);
		} else if (description.getElementOrProxy() instanceof JvmType) {
			return new TypeInsteadOfConstructorLinkingCandidate(constructorCall, description, state);
		} else {
			return new ConstructorLinkingCandidate(constructorCall, description, getSingleExpectation(state), state);
		}
	}

	@Override
	public String toString() {
		return String.format("%s: %s", getClass().getSimpleName(), resolvedTypes);
	}

	@Override
	public ITypeReferenceOwner getReferenceOwner() {
		return resolvedTypes.getReferenceOwner();
	}
	
	@Override
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return getResolvedTypes().createUnboundTypeReference(expression, typeParameter);
	}
	
	@Override
	public List<LightweightTypeReference> getExpectedExceptions() {
		return resolvedTypes.getExpectedExceptions();
	}
	
	protected IssueSeverities getSeverities() {
		return resolvedTypes.getSeverities();
	}

	@Override
	public Severity getSeverity(String issueCode) {
		return getSeverities().getSeverity(issueCode);
	}

	@Override
	public boolean isIgnored(String issueCode) {
		return getSeverities().isIgnored(issueCode);
	}
	
	@Override
	public void withinScope(EObject context) {
		resolvedTypes.addExpressionScope(context, featureScopeSession, IExpressionScope.Anchor.WITHIN);
	}
	
	@Override
	public void afterScope(EObject context) {
		resolvedTypes.addExpressionScope(context, featureScopeSession, IExpressionScope.Anchor.AFTER);
	}
	
	@Override
	public void rewriteScope(EObject context) {
		resolvedTypes.replacePreviousExpressionScope(context, featureScopeSession, IExpressionScope.Anchor.AFTER);
	}

}
