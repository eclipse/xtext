/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import static java.util.Collections.*;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
@NonNullByDefault
public abstract class AbstractPendingLinkingCandidate<Expression extends XExpression> extends AbstractLinkingCandidate<Expression> { 
	
	enum CompareResult {
		THIS,
		OTHER,
		EQUAL_VALID,
		EQUAL_INVALID
	}
	
	protected final IIdentifiableElementDescription description;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	
	protected AbstractPendingLinkingCandidate(Expression expression, IIdentifiableElementDescription description,
			ExpressionTypeComputationState state) {
		super(expression, state);
		this.description = description;
		this.typeParameterMapping = initializeTypeParameterMapping();
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	protected abstract String getFeatureTypeName();
	
	protected String getArgumentTypesAsString() {
		if(!getArguments().isEmpty()) {
			StringBuilder b = new StringBuilder();
			b.append("(");
			for(int i=0; i<getArguments().size(); ++i) {
				LightweightTypeReference actualType = getActualType(getArguments().get(i));
				if(actualType != null) 
					b.append(actualType.getSimpleName());
				else 
					b.append("null");
				if(i < getArguments().size()-1)
					b.append(",");
			}
			b.append(")");
			return b.toString();
		}
		return "";
	}
	
	protected String getFeatureParameterTypesAsString() {
		if(getFeature() instanceof JvmExecutable) {
			OwnedConverter ownedConverter = new OwnedConverter(getState().getReferenceOwner());
			List<JvmFormalParameter> parameters = ((JvmExecutable) getFeature()).getParameters();
			StringBuilder b = new StringBuilder();
			b.append("(");
			for(int i=0; i<parameters.size(); ++i) {
				JvmTypeReference parameterType = parameters.get(i).getParameterType();
				LightweightTypeReference typeReference = ownedConverter.toLightweightReference(parameterType);
				b.append(typeReference.getSimpleName());
				if(i < parameters.size()-1)
					b.append(", ");
			}
			b.append(")");
			return b.toString();
		}
		return "";
	}
	
	protected String getFeatureTypeParametersAsString(boolean showBounds) {
		List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
		if(!typeParameters.isEmpty()) {
			StringBuilder b = new StringBuilder();
			b.append("<");
			for(int i=0; i<typeParameters.size(); ++i) {
				JvmTypeParameter typeParameter = typeParameters.get(i);
				if(showBounds)
					b.append(getTypeParameterAsString(typeParameter));
				else 
					b.append(typeParameter.getSimpleName());
				if(i < typeParameters.size()-1)
					b.append(", ");
			}
			b.append(">");
			return b.toString();
		}
		return "";
	}

	protected String getTypeParameterAsString(JvmTypeParameter typeParameter) {
		StringBuilder b = new StringBuilder();
		b.append(typeParameter.getName());
		OwnedConverter ownedConverter = new OwnedConverter(getState().getReferenceOwner());
		if(!typeParameter.getConstraints().isEmpty()) {
			for(int j=0; j<typeParameter.getConstraints().size(); ++j) {
				JvmTypeConstraint constraint = typeParameter.getConstraints().get(j);
				LightweightTypeReference typeRef = ownedConverter.apply(constraint.getTypeReference());
				if(constraint instanceof JvmUpperBound) {
					if(typeRef.isType(Object.class))
						continue;
					b.append(" extends ");
				} else 
					b.append(" super ");
				b.append(typeRef.getSimpleName());
			}
		}
		return b.toString();
	}
	
	protected String getTypeArgumentsAsString(List<? extends LightweightTypeReference> typeArguments) {
		if(!typeArguments.isEmpty()) {
			StringBuilder b = new StringBuilder();
			b.append("<");
			for(int i=0; i<typeArguments.size(); ++i) {
				b.append(typeArguments.get(i).getSimpleName());
				if(i < typeArguments.size()-1)
					b.append(",");
			}
			b.append(">");
			return b.toString();
		}
		return "";
	}
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (!validateVisibility(result)) {
			return false;
		}
		if (!validateArity(result)) {
			return false;
		}
		if (!validateTypeArity(result)) {
			return false;
		}
		if (!validateTypeArgumentConformance(result)) {
			return false;
		}
		if (!validateUnhandledExceptions(result)) {
			return false;
		}
		return true;
	}

	protected boolean validateVisibility(IAcceptor<? super AbstractDiagnostic> result) {
		if (!isVisible()) {
			String message = String.format("The %1$s %2$s%3$s is not visible", 
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.FEATURE_NOT_VISIBLE, 
					message, 
					getExpression(), 
					getDefaultValidationFeature(), -1, null);
			result.accept(diagnostic);
			return false;
		}
		return true;
	}

	protected EReference getDefaultValidationFeature() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}
	
	@Nullable
	protected EReference getInvalidArgumentsValidationFeature() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}
	
	protected boolean validateArity(IAcceptor<? super AbstractDiagnostic> result) {
		if (getArityMismatch() != 0) {
			String message = String.format("Invalid number of arguments. The %1$s %2$s%3$s is not applicable for the arguments %4$s" , 
					getFeatureTypeName(), 
					getFeature().getSimpleName(), 
					getFeatureParameterTypesAsString(), 
					getArgumentTypesAsString());
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.INVALID_NUMBER_OF_ARGUMENTS, 
					message, 
					getExpression(), 
					getInvalidArgumentsValidationFeature(), -1, null);
			result.accept(diagnostic);
			return false;
		}
		return true;
	}
	
	protected boolean validateTypeArity(IAcceptor<? super AbstractDiagnostic> result) {
		if (getTypeArityMismatch() != 0) {
			String message = String.format("Invalid number of type arguments. The %1$s %2$s%3$s is not applicable for the type arguments %4$s",
					getFeatureTypeName(), 
					getFeature().getSimpleName(), 
					getFeatureTypeParametersAsString(true),
					getTypeArgumentsAsString(getSyntacticTypeArguments()));
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.INVALID_NUMBER_OF_TYPE_ARGUMENTS, 
					message, 
					getExpression(), 
					getDefaultValidationFeature(), -1, null);
			result.accept(diagnostic);
			return false;
		}
		return true;
	}
	
	protected boolean validateTypeArgumentConformance(IAcceptor<? super AbstractDiagnostic> result) {
		if (getTypeArgumentConformanceFailures(result) == 0) {
			// TODO use early exit computation
			List<XExpression> arguments = getSyntacticArguments();
			for(int i = 0; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				if (isDefiniteEarlyExit(argument)) {
					XExpression errorOn = getExpression();
					if (i < arguments.size() - 1) {
						errorOn = arguments.get(i + 1);
					}
					String message = "Unreachable code.";
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
							Severity.ERROR, 
							IssueCodes.UNREACHABLE_CODE, 
							message, 
							errorOn, 
							null, 
							-1, null);
					result.accept(diagnostic);
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean validateUnhandledExceptions(IAcceptor<? super AbstractDiagnostic> result) {
		if (!getState().isIgnored(IssueCodes.UNHANDLED_EXCEPTION) && getFeature() instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) getFeature();
			if (!executable.getExceptions().isEmpty()) {
				return validateUnhandledExceptions(executable, result);
			}
		}
		return true;
	}
	
	protected boolean validateUnhandledExceptions(JvmExecutable executable, IAcceptor<? super AbstractDiagnostic> result) {
		TypeParameterSubstitutor<?> substitutor = createArgumentTypeSubstitutor();
		List<LightweightTypeReference> unhandledExceptions = null;
		List<LightweightTypeReference> expectedExceptions = getState().getExpectedExceptions();
		outer: for(JvmTypeReference typeReference: executable.getExceptions()) {
			LightweightTypeReference exception = getState().getConverter().toLightweightReference(typeReference);
			LightweightTypeReference resolvedException = substitutor.substitute(exception);
			if (resolvedException.isSubtypeOf(Throwable.class) && !resolvedException.isSubtypeOf(RuntimeException.class)) {
				for (LightweightTypeReference expectedException : expectedExceptions) {
					if (expectedException.isAssignableFrom(resolvedException)) {
						continue outer;
					}
				}
				if (unhandledExceptions == null) {
					unhandledExceptions = Lists.newArrayList(resolvedException);
				} else {
					unhandledExceptions.add(resolvedException);
				}
			}
		}
		if (unhandledExceptions != null) {
			String message = null;
			int count = unhandledExceptions.size();
			if (count > 1) {
				message = String.format("Unhandled exception types %s and %s", 
						IterableExtensions.join(unhandledExceptions.subList(0, count - 1), ", "),
						unhandledExceptions.get(count - 1));
			} else {
				message = String.format("Unhandled exception type %s", unhandledExceptions.get(0).getSimpleName());
			}
			String[] data = new String[unhandledExceptions.size() + 1];
			for(int i = 0; i < data.length - 1; i++) {
				LightweightTypeReference unhandled = unhandledExceptions.get(i);
				data[i] = EcoreUtil.getURI(unhandled.getType()).toString();
			}
			data[data.length - 1] = EcoreUtil.getURI(getExpression()).toString();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					getState().getSeverity(IssueCodes.UNHANDLED_EXCEPTION), 
					IssueCodes.UNHANDLED_EXCEPTION,
					message, 
					getExpression(),
					getDefaultValidationFeature(), 
					-1, 
					data);
			result.accept(diagnostic);
			return false;
		}
		return true;
	}
	
	protected boolean isDefiniteEarlyExit(XExpression expression) {
		// TODO this needs some serious refinement
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}
	
	protected List<XExpression> getSyntacticArguments() {
		return getArguments();
	}

	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		if (other instanceof AbstractPendingLinkingCandidate) {
			AbstractPendingLinkingCandidate<?> right = (AbstractPendingLinkingCandidate<?>) other;
			CompareResult compareResult = compareTo(right);
			switch(compareResult) {
				case EQUAL_VALID:
					return createAmbiguousLinkingCandidate(right);
				case EQUAL_INVALID:
				case THIS:
					return this;
				case OTHER:
					return other;
				
			}
		}
		throw new IllegalArgumentException("other was " + other);
	}
	
	protected abstract ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second);
	
	/**
	 * Returns {@code -1} if this candidate is better, {@code +1} if the 
	 * right candidate was better, {@code 0} if both candidates are valid
	 * but ambiguous or {@code Integer.MIN_VALUE} if both candidates are 
	 * ambiguous but erroneous.
	 */
	@SuppressWarnings("incomplete-switch")
	protected CompareResult compareTo(AbstractPendingLinkingCandidate<?> right) {
		boolean invalid = false;
		{
			CompareResult arityCompareResult = compareByArityWith(right);
			switch(arityCompareResult) {
				case EQUAL_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return arityCompareResult;
				
			}
		}
		{
			boolean visible = isVisible();
			if (visible != right.isVisible()) {
				if (visible)
					return CompareResult.THIS;
				return CompareResult.OTHER;
			} else if (!visible) {
				invalid = true;
			}
		}
		{
			CompareResult typeArityCompareResult = compareByArity(getTypeArityMismatch(), right.getTypeArityMismatch());
			switch(typeArityCompareResult) {
				case EQUAL_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return typeArityCompareResult;
				
			}
		}
		{
			CompareResult argumentTypeCompareResult = compareByArgumentTypes(right);
			switch(argumentTypeCompareResult) {
				case EQUAL_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return argumentTypeCompareResult;
				
			}
		}
		{
			CompareResult typeArgumentCompareResult = compareByTypeArguments(right);
			switch(typeArgumentCompareResult) {
				case EQUAL_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return typeArgumentCompareResult;
				
			}
		}
		if (isVarArgs() != right.isVarArgs()) {
			if (isVarArgs())
				return CompareResult.OTHER;
			return CompareResult.THIS;
		}
		if(isTypeLiteral() && !right.isTypeLiteral()) {
			return CompareResult.OTHER;
		}
		if (description.getBucketId() != right.description.getBucketId()) {
			return CompareResult.THIS;
		}
		if (invalid)
			return CompareResult.EQUAL_INVALID;
		return CompareResult.EQUAL_VALID;
	}
	
	protected boolean isVisible() {
		return description.isVisible();
	}

	protected boolean isVarArgs() {
		return getFeature() instanceof JvmExecutable && ((JvmExecutable)getFeature()).isVarArgs();
	}
	
	protected boolean isExtension() {
		return false;
	}
	
	@SuppressWarnings("incomplete-switch")
	protected CompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		{
			CompareResult argumentTypeResult = compareByArgumentTypes(right, false);
			switch(argumentTypeResult) {
				case EQUAL_INVALID:
					// ignore since we have a second pass below
					break;
				case OTHER:
				case THIS:
					return argumentTypeResult;
				
			}
		}
		{
			CompareResult parameterTypeResult = compareExpectedArgumentTypes(right);
			switch(parameterTypeResult) {
				case EQUAL_INVALID:
					throw new IllegalStateException();
				case OTHER:
				case THIS:
					return parameterTypeResult;
				
			}
		}
		// subsequent parameters may have altered the bound type arguments
		// TODO this is more of a workaround than a real solution
		// actually the order of added hints and their sources should take care of that case
		// in a way that UnboundTypeConformance returns false for invalid combinations
		CompareResult secondPassArgumentTypes = compareByArgumentTypes(right, true);
		return secondPassArgumentTypes;
	}
	
	protected CompareResult compareByTypeArguments(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		
		int leftFailures = getTypeArgumentConformanceFailures(null);
		int rightFailures = right.getTypeArgumentConformanceFailures(null);
		if (leftFailures != rightFailures) {
			if (leftFailures < rightFailures)
				return CompareResult.THIS;
			return CompareResult.OTHER;
		}
		return leftFailures != 0 ? CompareResult.EQUAL_INVALID : CompareResult.EQUAL_VALID;
	}

	protected int getTypeArgumentConformanceFailures(@Nullable IAcceptor<? super AbstractDiagnostic> acceptor) {
		List<LightweightTypeReference> typeArguments = getTypeArguments();
		List<JvmTypeParameter> typeParameters = getDeclaredTypeParameters();
		int max = Math.min(typeArguments.size(), typeParameters.size());
		if (max == 0) {
			return 0;
		}
		int failures = 0;
		TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(
				getDeclaratorParameterMapping(), getState().getReferenceOwner());
		for(int i = 0; i < max; i++) {
			LightweightTypeReference argument = typeArguments.get(i);
			JvmTypeParameter declaration = typeParameters.get(i);
			substitutor.enhanceMapping(singletonMap(declaration, new LightweightMergedBoundTypeArgument(argument, VarianceInfo.INVARIANT)));
		}
		for(int i = 0; i < max; i++) {
			LightweightTypeReference argument = typeArguments.get(i);
			JvmTypeParameter declaration = typeParameters.get(i);
			if (argument.getType() != declaration) {
				LightweightTypeReference reference = new ParameterizedTypeReference(argument.getOwner(), declaration);
				for(LightweightTypeReference superType: reference.getSuperTypes()) {
					LightweightTypeReference substitutedSuperType = substitutor.substitute(superType);
					if (!substitutedSuperType.isAssignableFrom(argument)) {
						failures++;
					}
				}
			}
		}
		if(failures != 0 && acceptor != null) {
			String format = (max > 1)
					? "Bounds mismatch: The type arguments %1$s are not a valid substitute for the bounded type parameters %2$s of the %3$s %4$s%5$s"
					: "Bounds mismatch: The type argument %1$s is not a valid substitute for the bounded type parameter %2$s of the %3$s %4$s%5$s";
			String message = String.format(format,
					getTypeArgumentsAsString(typeArguments),
					getFeatureTypeParametersAsString(true),
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.TYPE_BOUNDS_MISSMATCH, 
					message, 
					getExpression(), 
					getDefaultValidationFeature(), -1, null);
			acceptor.accept(diagnostic);
		}
		return failures;
	}
	
	@SuppressWarnings("incomplete-switch")
	protected CompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, boolean recompute) {
		int upTo = Math.max(arguments.getArgumentCount(), right.arguments.getArgumentCount());
		int leftBoxing = 0;
		int rightBoxing = 0;
		int leftDemand = 0;
		int rightDemand = 0;
		boolean invalid = false;
		for(int i = 0; i < upTo; i++) {
			EnumSet<ConformanceHint> leftConformance = getConformanceHints(i, recompute);
			EnumSet<ConformanceHint> rightConformance = right.getConformanceHints(i, recompute);
			CompareResult hintCompareResult = compareByArgumentTypes(right, i, leftConformance, rightConformance);
			switch(hintCompareResult) {
				case EQUAL_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return hintCompareResult;
				
			}
			if (leftConformance.contains(ConformanceHint.DEMAND_CONVERSION)) {
				leftDemand++;
			}
			if (rightConformance.contains(ConformanceHint.DEMAND_CONVERSION)) {
				rightDemand++;
			}
			if (leftConformance.contains(ConformanceHint.BOXING) || leftConformance.contains(ConformanceHint.UNBOXING)) {
				leftBoxing++;
			}
			if (rightConformance.contains(ConformanceHint.BOXING) || rightConformance.contains(ConformanceHint.UNBOXING)) {
				rightBoxing++;
			}
		}
		CompareResult result = compareByArgumentTypes(right, leftBoxing, rightBoxing, leftDemand, rightDemand);
		switch(result) {
			case EQUAL_VALID:
				if (invalid)
					return CompareResult.EQUAL_INVALID;
			default:
				return result;
		}
	}

	/**
	 * Compare this linking candidate with the given {@code other} candidate at {@code argumentIndex}
	 * 
	 * A {@code result < 0} indicates that this candidate is a better match. {@code result > 0} and the other candidate is better.
	 * 
	 * @param other the other candidate
	 * @param argumentIndex the semantic argument index
	 * @param leftConformance the computed conformance in this linking candidate
	 * @param rightConformance the computed conformance if the other candidate was chosen  
	 */
	protected CompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> other, int argumentIndex, EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		int hintCompareResult = ConformanceHint.compareHints(leftConformance, rightConformance);
		if (hintCompareResult == 0) {
			if (leftConformance.contains(ConformanceHint.SUCCESS)) {
				return CompareResult.EQUAL_VALID;
			} else {
				return CompareResult.EQUAL_INVALID;
			}
		} else if (hintCompareResult < 0) {
			return CompareResult.THIS;
		} else {
			return CompareResult.OTHER;
		}
	}

	/**
	 * Compare this linking candidate with the given {@code other} candidate at {@code argumentIndex}
	 * 
	 * A {@code result < 0} indicates that this candidate is a better match. {@code result > 0} and the other candidate is better.
	 * 
	 * @param other the other candidate (the rhs of the comparison)
	 * @param leftBoxing the number of required boxing conversions if this candidate was chosen
	 * @param rightBoxing the number of required boxing conversions if the other candidate was chosen
	 * @param leftDemand the number of required demand conversions if this candidate was chosen  
	 * @param rightDemand the number of required demand conversions if the other candidate was chosen  
	 */
	protected CompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> other, int leftBoxing, int rightBoxing, int leftDemand, int rightDemand) {
		if (leftDemand != rightDemand) {
			if (leftDemand < rightDemand)
				return CompareResult.THIS;
			return CompareResult.OTHER;
		}
		if (leftBoxing != rightBoxing) {
			if (leftBoxing < rightBoxing)
				return CompareResult.THIS;
			return CompareResult.OTHER;
		}
		return CompareResult.EQUAL_VALID;
	}
	
	protected EnumSet<ConformanceHint> getConformanceHints(int idx, boolean recompute) {
		while(!arguments.isProcessed(idx)) {
			computeArgumentType(arguments.getNextUnprocessedArgumentSlot());
		}
		if (idx >= arguments.getArgumentCount()) {
			return EnumSet.of(ConformanceHint.SUCCESS, ConformanceHint.CHECKED); 
		}
		XExpression argument = arguments.getArgument(idx);
		if (argument == null) {
			return EnumSet.of(ConformanceHint.INCOMPATIBLE);
		}
		return getState().getStackedResolvedTypes().getConformanceHints(argument, recompute);
	}

	protected CompareResult compareExpectedArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		int result = 0;
		int upTo = Math.min(arguments.getArgumentCount(), right.arguments.getArgumentCount());
		boolean sameTypes = true;
		for(int i = 0; i < upTo; i++) {
			LightweightTypeReference expectedArgumentType = getSubstitutedExpectedType(i);
			LightweightTypeReference rightExpectedArgumentType = right.getSubstitutedExpectedType(i);
			if (expectedArgumentType == null) {
				if (rightExpectedArgumentType != null)
					return CompareResult.OTHER;
			} else {
				if (rightExpectedArgumentType == null) {
					return CompareResult.THIS;
				}
				if (expectedArgumentType.isAssignableFrom(rightExpectedArgumentType)) {
					if (!rightExpectedArgumentType.isAssignableFrom(expectedArgumentType)) {
						sameTypes = false;
						result++;
					}
				} else if (rightExpectedArgumentType.isAssignableFrom(expectedArgumentType)) {
					sameTypes = false;
					result--;
				} else {
					sameTypes = false;
				}
			}
		}
		if (result == 0) {
			if (sameTypes) { // duplicate methods or valid overrides?
				if (upTo != 0) {
					return compareByDeclarator(right);
				}
				return CompareResult.THIS;
			}
			return CompareResult.EQUAL_VALID;
		} else if (result < 0) {
			return CompareResult.THIS;
		} else {
			return CompareResult.OTHER;
		}
	}
	
	protected CompareResult compareByDeclarator(AbstractPendingLinkingCandidate<?> right) {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmMember) {
			JvmDeclaredType declaringType = ((JvmMember) feature).getDeclaringType();
			JvmIdentifiableElement rightFeature = right.getFeature();
			if (rightFeature instanceof JvmMember) {
				JvmDeclaredType rightDeclaringType = ((JvmMember) rightFeature).getDeclaringType();
				LightweightTypeReference declaringTypeRef = new ParameterizedTypeReference(getState().getReferenceOwner(), declaringType);
				if (declaringTypeRef.isSubtypeOf(rightDeclaringType)) {
					return CompareResult.THIS;
				} else if (declaringTypeRef.isAssignableFrom(rightDeclaringType)) {
					return CompareResult.OTHER;
				}
			}
		}
		return CompareResult.EQUAL_VALID;
	}

	protected CompareResult compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		CompareResult arityCompareResult = compareByArity(getArityMismatch(), right.getArityMismatch());
		return arityCompareResult;
	}

	protected CompareResult compareByArity(int leftArityMismatch, int rightArityMismatch) {
		if (leftArityMismatch != rightArityMismatch) {
			if (leftArityMismatch == 0)
				return CompareResult.THIS;
			if (rightArityMismatch == 0)
				return CompareResult.OTHER;
			if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
				return CompareResult.THIS;
			if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
				return CompareResult.OTHER;
			if (leftArityMismatch > 0)
				return CompareResult.THIS;
			if (rightArityMismatch > 0)
				return CompareResult.OTHER;
		}
		return leftArityMismatch == 0 ? CompareResult.EQUAL_VALID : CompareResult.EQUAL_INVALID;
	}
	
	/**
	 * Returns the mismatch of actually given arguments and declared parameters.
	 * Receivers and staticness of the feature is taken into account, too. The mismatch
	 * may either be negative or positive.
	 */
	public int getArityMismatch() {
		JvmIdentifiableElement identifiable = getFeature();
		if (identifiable instanceof JvmExecutable) {
			return getArityMismatch((JvmExecutable) identifiable, getArguments());
		} else if (getExpression() instanceof XAssignment) {
			return getArguments().size() - 1;
		} else {
			return getArguments().size();
		}
	}
	
	public int getTypeArityMismatch() {
		List<LightweightTypeReference> syntacticTypeArguments = getSyntacticTypeArguments();
		if (syntacticTypeArguments.size() == 0)
			return 0;
		return getDeclaredTypeParameters().size() - syntacticTypeArguments.size();
	}
	
	protected void resolveLinkingProxy(EReference structuralFeature, int featureId) {
		InternalEObject internalView = (InternalEObject) getExpression();
		JvmIdentifiableElement newFeature = getFeature();
		if (newFeature.eIsProxy()) {
			newFeature = (JvmIdentifiableElement) internalView.eResolveProxy((InternalEObject) newFeature);
		}
		resolveLinkingProxy(internalView, newFeature, structuralFeature, featureId);
	}

	protected void resolveLinkingProxy(InternalEObject owner, JvmIdentifiableElement newValue, EReference structuralFeature, int featureId) {
		EObject oldFeature = (EObject) owner.eGet(structuralFeature, false);
		if (oldFeature == null || !(oldFeature.eIsProxy())) {
			throw new IllegalStateException("Feature was already resolved to " + oldFeature);
		}
		if (owner.eNotificationRequired()) {
			boolean wasDeliver = owner.eDeliver();
			owner.eSetDeliver(false);
			internalSetValue(owner, structuralFeature, newValue);
			owner.eSetDeliver(wasDeliver);
			if (newValue != oldFeature) {
				owner.eNotify(new ENotificationImpl(owner, Notification.RESOLVE, featureId, oldFeature, newValue));
			}
		} else {
			internalSetValue(owner, structuralFeature, newValue);
		}
	}

	protected void internalSetValue(InternalEObject featureCall, EReference structuralFeature, JvmIdentifiableElement newValue) {
		featureCall.eSet(structuralFeature, newValue);
	}
	
	protected int getArityMismatch(JvmExecutable executable, List<XExpression> arguments) {
		int fixedArityParamCount = executable.getParameters().size();
		if (executable.isVarArgs()) {
			fixedArityParamCount--;
			if (arguments.size() >= fixedArityParamCount) {
				return 0;
			}
		}
		return fixedArityParamCount - arguments.size();
	}
	
	@Override
	public JvmIdentifiableElement getFeature() {
		return description.getElementOrProxy();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + description.toString() + "]";
	}
}
