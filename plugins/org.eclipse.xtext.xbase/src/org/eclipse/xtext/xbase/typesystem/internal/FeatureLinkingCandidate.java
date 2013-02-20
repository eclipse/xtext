/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class FeatureLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements IFeatureLinkingCandidate, IFeatureNames {

	public FeatureLinkingCandidate(XAbstractFeatureCall featureCall, IIdentifiableElementDescription description,
			ExpressionTypeComputationState state) {
		super(featureCall, description, state);
	}
	
	@Override
	protected boolean isRawTypeContext() {
		LightweightTypeReference receiverType = getReceiverType();
		if(receiverType != null && receiverType.isRawType()) {
			return true;
		}
		return false;
	}
	
	@Override
	protected IFeatureLinkingCandidate getThis() {
		return this;
	}
	
	@Override
	protected void initializeMapping(JvmTypeParameter typeParameter, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result) {
		ITypeReferenceOwner owner = getState().getReferenceOwner();
		if (typeParameter.getDeclarator() instanceof JvmType && owner.getDeclaredTypeParameters().contains(typeParameter)) {
			ParameterizedTypeReference typeReference = new ParameterizedTypeReference(owner, typeParameter);
			result.put(typeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
		} else {
			super.initializeMapping(typeParameter, result);
		}
	}

	/**
	 * Returns the actual arguments of the expression. These do not include the
	 * receiver.  
	 */
	@Override
	protected List<XExpression> getArguments() {
		List<XExpression> syntacticArguments = getSyntacticArguments();
		XExpression firstArgument = getFirstArgument();
		if (firstArgument != null) {
			return createArgumentList(firstArgument, syntacticArguments);
		}
		return syntacticArguments;
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (isStatic() && !isExtension() && isInstanceAccessSyntax()) {
			String message = String.format("The static %1$s %2$s%3$s should be accessed in a static way",
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
					IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER, message, getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (!isStatic() && isStaticAccessSyntax()) {
			EObject featureOwner = getFeature().eContainer();
			String message = String.format("Cannot make a static reference to the non-static %1$s %2$s%3$s",
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			if(featureOwner instanceof JvmDeclaredType) 
				message += " from the type " + ((JvmDeclaredType) featureOwner).getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
					IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (super.validate(result)) {
			if (isExplicitOperationCallOrBuilderSyntax() && !(getFeature() instanceof JvmExecutable)) {
				String typeName = getFeatureTypeName();
				String code = IssueCodes.FIELD_ACCESS_WITH_PARENTHESES;
				if (!(getFeature() instanceof JvmField)) {
					code = IssueCodes.LOCAL_VAR_ACCESS_WITH_PARENTHESES;
				}
				String message = "Cannot access the " + typeName + " " + getFeature().getSimpleName() + " with parentheses";
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR, code, message,
						getExpression(), XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			}
			if (getFeature() instanceof JvmType && !getState().isInstanceContext()) {
				String featureName = getFeatureCall().getConcreteSyntaxFeatureName();
				if (!(SELF.getFirstSegment().equals(featureName))) {
					String message = String.format("Cannot use %s in a static context", getFeatureCall().getConcreteSyntaxFeatureName());
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
							IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getExpression(),
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
					result.accept(diagnostic);
					return false;
				}
			}
			JvmIdentifiableElement feature = getFeature();
			if (feature instanceof XVariableDeclaration && ((XVariableDeclaration) feature).isWriteable()) {
				XClosure containingClosure = EcoreUtil2.getContainerOfType(getExpression(), XClosure.class);
				if (containingClosure != null && !EcoreUtil.isAncestor(containingClosure, feature)) {
					String message = String.format("Cannot refer to the non-final variable %s inside a lambda expression", feature.getSimpleName());
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
							IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, message, getExpression(),
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
					result.accept(diagnostic);
					return false;
				}
			}
		} else {
			
		}
		return true;
	}

	protected boolean isExplicitOperationCallOrBuilderSyntax() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XBinaryOperation || featureCall instanceof XAssignment) {
			return false;
		}
		return featureCall.isExplicitOperationCallOrBuilderSyntax();
	}

	@Override
	protected String getFeatureTypeName() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmFormalParameter) {
			return "parameter";
		}
		if (feature instanceof XVariableDeclaration) {
			return "local variable";
		}
		if (feature instanceof JvmField) {
			return "field";
		}
		if (feature instanceof JvmOperation) {
			return "method";
		}
		if (feature instanceof JvmConstructor) {
			return "constructor";
		}
		throw new IllegalStateException();
	}

	protected boolean isStaticAccessSyntax() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XFeatureCall) {
			return ((XFeatureCall) featureCall).getDeclaringType() != null;
		}
		return false;
	}
	
	protected boolean isInstanceAccessSyntax() {
		if (getImplicitReceiverType() != null)
			return true;
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XAssignment) {
			return ((XAssignment) featureCall).getAssignable() != null;
		}
		return featureCall instanceof XMemberFeatureCall;
	}

	protected List<XExpression> createArgumentList(XExpression head, List<XExpression> tail) {
		// TODO investigate in optimized List impls like HEAD, syntacticArguments
		List<XExpression> result = Lists.newArrayListWithExpectedSize(tail.size() + 1);
		result.add(head);
		for(XExpression expression: tail) {
			// addAll will convert the tail to an array, first
			result.add(expression);
		}
		return result;
	}
	
	@Override
	public int getArityMismatch() {
		int result = super.getArityMismatch();
		if (isStatic() && (getImplicitReceiver() != null || getSyntacticReceiver() != null && !isExtension())) {
			if (result < 0)
				result--;
			else
				result++;
		}
		return result;
	}
	
	@Override
	protected List<XExpression> getSyntacticArguments() {
		return new FeatureLinkHelper().getSyntacticArguments(getFeatureCall());
	}
	
	@Override
	public boolean isExtension() {
		return description.isExtension();
	}
	
	@Override
	protected boolean hasReceiver() {
		return !isStatic();
	}
	
	public boolean isStatic() {
		return description.isStatic();
	}
	
	@Override
	protected EnumSet<ConformanceHint> getConformanceHints(int idx, boolean recompute) {
		if (idx == 0) {
			if (getReceiver() != null) {
				EnumSet<ConformanceHint> result = getReceiverConformanceHints();
				return result;
			}
		}
		return super.getConformanceHints(idx, recompute);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getSubstitutedExpectedType(int idx) {
		if (idx == 0) {
			if (getReceiver() != null) {
				return null;
			}
		}
		return super.getSubstitutedExpectedType(idx);
	}
	
	protected boolean isExplicitOperationCall() {
		return getFeatureCall().isExplicitOperationCallOrBuilderSyntax();
	}
	
	@Override
	protected int compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		int result = super.compareByArityWith(right);
		if (result == 0) {
			boolean isExecutable = getFeature() instanceof JvmExecutable;
			if (isExecutable != right.getFeature() instanceof JvmExecutable && isVisible() == right.isVisible()) {
				// TODO this code looks bogus to me (we need to verify why / if we need this)
				if (getExpression() instanceof XAssignment) {
					if (isExecutable)
						return 1;
					return -1;
				} else {
					if (isExplicitOperationCall()) {
						if (isExecutable)
							return -1;
						return 1;
					} else {
						if (isExecutable)
							return 1;
						return -1;
					}
				}
			}
		}
		return result;
	}
	
	@Override
	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int argumentIndex, EnumSet<ConformanceHint> leftConformance,
			EnumSet<ConformanceHint> rightConformance) {
		int result = super.compareByArgumentTypes(right, argumentIndex, leftConformance, rightConformance);
		if (result != 0 || leftConformance.contains(ConformanceHint.SUCCESS) || !(right instanceof FeatureLinkingCandidate))
			return result;
		// both types do not match - pick the one which is not an extension
		boolean firstArgumentMismatch = isFirstArgument(argumentIndex);
		boolean rightFirstArgumentMismatch = ((FeatureLinkingCandidate) right).isFirstArgument(argumentIndex);
		if (firstArgumentMismatch != rightFirstArgumentMismatch) {
			if (firstArgumentMismatch)
				return 1;
			return -1;
		}
		return result;
	}
	
	protected boolean isFirstArgument(int argumentIndex) {
		if (argumentIndex > 1 || getFirstArgument() == null)
			return false;
		if (isStatic())
			return argumentIndex == 0;
		return argumentIndex == 1;
	}
	
	@Override
	protected int compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int leftBoxing, int rightBoxing, int leftDemand, int rightDemand) {
		if (leftDemand != rightDemand) {
			if (leftDemand < rightDemand)
				return -1;
			return 1;
		}
		if (right instanceof FeatureLinkingCandidate) {
			FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
			if (isExtension() != casted.isExtension()) {
				if (isExtension())
					return 1;
				return -1;
			}
			if (isStatic() != casted.isStatic()) {
				if (isStatic()) {
					return 1;
				}
				return -1;
			}
		}
		if (leftBoxing != rightBoxing) {
			if (leftBoxing < rightBoxing)
				return -1;
			return 1;
		}
		return 0;
	}
	
	@Override
	protected void preApply() {
		applyImplicitReceiver();
		super.preApply();
		XExpression implicitFirstArgument = getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			new ImplicitFirstArgument(getFeatureCall(), (XAbstractFeatureCall) implicitFirstArgument, getState()).applyToComputationState();
		}
	}
	
	protected void applyImplicitReceiver() {
		if (!isStatic()) {
			XExpression implicitReceiver = getImplicitReceiver();
			if (implicitReceiver != null) {
				ResolvedTypes resolvedTypes = getState().getResolvedTypes();
				LightweightTypeReference receiverType = getImplicitReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException("Cannot determine the receiver's type");
				}
				LightweightTypeReference expectedReceiverType = new FeatureLinkHelper().getExpectedReceiverType(getFeature(), receiverType);
				if (expectedReceiverType != null)
					expectedReceiverType = expectedReceiverType.copyInto(resolvedTypes.getReferenceOwner());
				TypeExpectation expectation = new TypeExpectation(expectedReceiverType, getState(), false);
				resolvedTypes.acceptType(implicitReceiver, expectation, receiverType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceHint.UNCHECKED);
				if (implicitReceiver instanceof XAbstractFeatureCall) {
					new ImplicitReceiver(getFeatureCall(), (XAbstractFeatureCall) implicitReceiver, getState()).applyToComputationState();
				} else {
					throw new IllegalStateException("unexpected implicit receiver, was: " + implicitReceiver);
				}
			}
		}
	}

	@Override
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		super.resolveAgainstActualType(declaredType, actualType, state);
		if (!isStatic()) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(declaredType, actualType);
		}
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Lists.transform(getFeatureCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, @Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (argument == getSyntacticReceiver()) {
			LightweightTypeReference receiverType = getSyntacticReceiverType();
			if (receiverType != null) {
				resolveKnownArgumentType(argument, receiverType, declaredType, argumentState);
			}
		} else if (argument == getImplicitFirstArgument()) {
			LightweightTypeReference argumentType = getImplicitFirstArgumentType();
			if (argumentType != null) {
				resolveKnownArgumentType(argument, argumentType, declaredType, argumentState);
			}
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}

	// TODO some code is duplicated in ResolvedFeature - extract delegator
	protected void resolveKnownArgumentType(XExpression argument, LightweightTypeReference knownType,
			@Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (!(argumentState instanceof AbstractTypeComputationState))
			throw new IllegalArgumentException("argumentState was " + argumentState);
		AbstractTypeComputationState castedArgumentState = (AbstractTypeComputationState) argumentState;
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
		TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, castedArgumentState, false);
		LightweightTypeReference copiedReceiverType = knownType.copyInto(resolvedTypes.getReferenceOwner());
		// TODO should we use the result of #acceptType?
		resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceHint.UNCHECKED);
		if (copiedDeclaredType != null)
			resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
	}
	
	@Override
	protected void computeVarArgumentType(IFeatureCallArgumentSlot slot, TypeParameterSubstitutor<?> substitutor) {
		if (isExtension()) {
			List<XExpression> arguments = slot.getArgumentExpressions();
			if (arguments.size() == 1 && arguments.get(0) == getFirstArgument()) {
				computeFixedArityArgumentType(slot, substitutor);
				return;
			}
		}
		super.computeVarArgumentType(slot, substitutor);
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		if (isStatic())
			return super.getDeclaratorParameterMapping();
		if (getImplicitReceiver() != null)
			return description.getImplicitReceiverTypeParameterMapping();
		return description.getSyntacticReceiverTypeParameterMapping();
	}
	
	@Nullable
	protected XExpression getReceiver() {
		if (isStatic())
			return null;
		XExpression result = getImplicitReceiver();
		if (result != null)
			return result;
		return getSyntacticReceiver();
	}

	@Nullable
	protected LightweightTypeReference getReceiverType() {
		if (isStatic())
			return null;
		LightweightTypeReference result;
		if (getImplicitReceiver() != null)
			result = getImplicitReceiverType();
		else
			result = getSyntacticReceiverType();
		return result;
	}
	
	protected EnumSet<ConformanceHint> getReceiverConformanceHints() {
		if (isStatic())
			throw new IllegalStateException();
		if (getImplicitReceiver() != null) {
			return description.getImplicitReceiverConformanceHints();
		} else if (getSyntacticReceiver() != null) {
			return description.getSyntacticReceiverConformanceHints();
		}
		throw new IllegalStateException();
	}
	
	/**
	 * Returns the first argument if this is an extension. This may be
	 * the implicit first argument or the syntactic receiver of the feature call.
	 */
	@Nullable
	protected XExpression getFirstArgument() {
		if (!isExtension())
			return null;
		XExpression firstArgument = getImplicitFirstArgument();
		if (firstArgument != null)
			return firstArgument;
		return getSyntacticReceiver();
	}

	@Nullable
	protected LightweightTypeReference getFirstArgumentType() {
		if (!isExtension())
			return null;
		LightweightTypeReference result = getImplicitFirstArgumentType();
		if (result != null)
			return result;
		return getSyntacticReceiverType();
	}
	
	@Nullable
	protected XExpression getImplicitReceiver() {
		return description.getImplicitReceiver();
	}
	
	@Nullable
	protected LightweightTypeReference getImplicitReceiverType() {
		return description.getImplicitReceiverType();
	}
	
	@Nullable
	protected XExpression getSyntacticReceiver() {
		return description.getSyntacticReceiver();
	}
	
	@Nullable
	protected LightweightTypeReference getSyntacticReceiverType() {
		return description.getSyntacticReceiverType();
	}
	
	@Nullable
	protected XExpression getImplicitFirstArgument() {
		return description.getImplicitFirstArgument();
	}
	
	@Nullable
	protected LightweightTypeReference getImplicitFirstArgumentType() {
		return description.getImplicitFirstArgumentType();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getConverter().toLightweightReference(getState().getTypeReferences().getTypeForName(Void.TYPE, feature));
		}
		/*
		 * The actual result type is Class<? extends |X|> where |X| is the erasure of 
		 * the static type of the expression on which getClass is called. For example, 
		 * no cast is required in this code fragment:
		 *   Number n = 0;
		 *   Class<? extends Number> c = n.getClass();
		 */
		if (feature instanceof JvmOperation && feature.getSimpleName().equals("getClass")) {
			JvmOperation getClassOperation = (JvmOperation) feature;
			if (getClassOperation.getParameters().isEmpty() && "java.lang.Object".equals(getClassOperation.getDeclaringType().getIdentifier())) {
				LightweightTypeReference receiverType = getReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException("Cannot determine the receiver's type");
				}
				List<JvmType> rawTypes = receiverType.getRawTypes();
				if (rawTypes.isEmpty()) {
					return super.getDeclaredType(feature);
				}
				ParameterizedTypeReference result = new ParameterizedTypeReference(receiverType.getOwner(), getClassOperation.getReturnType().getType());
				WildcardTypeReference wildcard = new WildcardTypeReference(receiverType.getOwner());
				wildcard.addUpperBound(new ParameterizedTypeReference(receiverType.getOwner(), rawTypes.get(0)));
				result.addTypeArgument(wildcard);
				return result;
			}
		}
		return super.getDeclaredType(feature);
	}
	
	public void applyToModel() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
	}

}
