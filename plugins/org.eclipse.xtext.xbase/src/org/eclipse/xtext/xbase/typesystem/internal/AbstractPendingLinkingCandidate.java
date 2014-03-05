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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.conformance.RawTypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * Abstract base for linking candidates that attempt to resolve features
 * which are not yet bound.
 * 
 * This implements the overload resolution and disambiguation. That is, it
 * can be compared to another candidate and return the better match.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractPendingLinkingCandidate<Expression extends XExpression> extends AbstractLinkingCandidate<Expression> { 
	
	/**
	 * The backing feature descriptions. It carries the information about the potentially
	 * resolved feature, e.g. the implicit receiver, whether it's an extension and more.
	 */
	protected final IIdentifiableElementDescription description;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	
	protected AbstractPendingLinkingCandidate(
			Expression expression, 
			IIdentifiableElementDescription description,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(expression, expectation, state);
		this.description = description;
	}
	
	/**
	 * Returns the mapping of type parameters to their bound arguments.
	 * 
	 * @see #initializeTypeParameterMapping()
	 */
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		if (typeParameterMapping == null) {
			typeParameterMapping = initializeTypeParameterMapping();
		}
		return typeParameterMapping;
	}
	
	/**
	 * Returns the name of the feature type, e.g. a feature of type {@link JvmOperation} may 
	 * return {@code method}, a {@link XVariableDeclaration} may identify itself as {@code local variable}.
	 */
	protected abstract String getFeatureTypeName();
	
	/**
	 * Returns the resolved string representation of the argument types. The simple names of
	 * the types are used. The string representation includes the parenthesis. 
	 */
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
	
	/**
	 * Returns the unresolved string representation of the parameter types of the feature. The simple names of
	 * the types are used. The string representation includes the parenthesis. 
	 */
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
	
	/**
	 * Returns the unresolved string representation of the unresolved type parameters of the feature. The simple names of
	 * the type bounds are used. The string representation includes the angle brackets. 
	 */
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

	/**
	 * Returns the unresolved string representation of the given type parameter. The simple names of
	 * the type bounds are used. The string representation includes the bounds, except for
	 * the upper bound {@link Object}. 
	 */
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
	
	/**
	 * Returns the resolved string representation of the type arguments. The simple names of
	 * the types are used. The string representation includes the angle brackets. 
	 */
	protected String getTypeArgumentsAsString(List<? extends LightweightTypeReference> typeArguments) {
		if(!typeArguments.isEmpty()) {
			StringBuilder b = new StringBuilder();
			b.append("<");
			for(int i=0; i<typeArguments.size(); ++i) {
				b.append(typeArguments.get(i).getSimpleName());
				if(i < typeArguments.size()-1)
					b.append(", ");
			}
			b.append(">");
			return b.toString();
		}
		return "";
	}
	
	/**
	 * Validates this linking candidate and adds respective diagnostics to the given queue.
	 * 
	 * This checks the following criteria:
	 * <ol>
	 * <li>{@link #validateVisibility(IAcceptor) visibility},</li>
	 * <li>{@link #validateArity(IAcceptor) arity},</li>
	 * <li>{@link #validateTypeArity(IAcceptor) type arity},</li>
	 * <li>{@link #validateTypeArgumentConformance(IAcceptor) type arguments},</li>
	 * <li>{@link #validateUnhandledExceptions(IAcceptor) unhandled excptions},</li>
	 * </ol>
	 */
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
					String message = "Unreachable code.";
					EStructuralFeature errorFeature = null;
					if (i < arguments.size() - 1) {
						errorOn = arguments.get(i + 1);
					} else {
						errorFeature = getDefaultValidationFeature();
						if (errorOn instanceof XBinaryOperation) {
							message = "Unreachable code. The right argument expression does not complete normally.";
						} else {
							message = "Unreachable code. The last argument expression does not complete normally.";
						}
					}
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
							Severity.ERROR, 
							IssueCodes.UNREACHABLE_CODE, 
							message, 
							errorOn, 
							errorFeature, 
							-1, null);
					result.accept(diagnostic);
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
	
	protected boolean validateUnhandledExceptions(IAcceptor<? super AbstractDiagnostic> result) {
		if (getFeature() instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) getFeature();
			if (getUnhandledExceptionSeverity(executable) != Severity.IGNORE) {
				if (!executable.getExceptions().isEmpty()) {
					return validateUnhandledExceptions(executable, result);
				}
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
					getUnhandledExceptionSeverity(executable), 
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

	/**
	 * Obtain the currently applicable severity for uncaught exceptions.
	 * Sneaky throw techniques cannot be applied to delegating constructor calls.
	 * Therefore it's possible to raise the severity for them by checking the linked executable.
	 * @param executable the executable that declares the exception.
	 */
	protected Severity getUnhandledExceptionSeverity(JvmExecutable executable) {
		return getState().getSeverity(IssueCodes.UNHANDLED_EXCEPTION);
	}
	
	protected boolean isDefiniteEarlyExit(XExpression expression) {
		CommonTypeComputationServices services = getState().getReferenceOwner().getServices();
		return services.getEarlyExitComputer().isDefiniteEarlyExit(expression);
	}
	
	protected List<XExpression> getSyntacticArguments() {
		return getArguments();
	}

	/**
	 * Returns the best candidate considering the this and the given other candidate.
	 * 
	 * The result is not necessarily this or the other, but may also be a third instance,
	 * e.g. in order to disambiguate certain error conditions.
	 */
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		if (other instanceof AbstractPendingLinkingCandidate) {
			AbstractPendingLinkingCandidate<?> right = (AbstractPendingLinkingCandidate<?>) other;
			CandidateCompareResult candidateCompareResult = compareTo(right);
			switch(candidateCompareResult) {
				case AMBIGUOUS:
					return createAmbiguousLinkingCandidate(right);
				case SUSPICIOUS_OTHER:
					return createSuspiciousLinkingCandidate(right);
				case EQUALLY_INVALID:
				case THIS:
					return this;
				case OTHER:
					return other;
			}
		}
		throw new IllegalArgumentException("other was " + other);
	}
	
	/**
	 * Produce a candidate that carries the information about ambiguous candidates.
	 */
	protected abstract ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second);
	/**
	 * Produce a candidate that carries the information about suspicious overload resolution where
	 * a member on 'this' wins over a member on 'it'.
	 * 
	 * @param chosenCandidate the candidate that was picked.
	 */
	protected ILinkingCandidate createSuspiciousLinkingCandidate(AbstractPendingLinkingCandidate<?> chosenCandidate) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Returns {@code CandidateCompareResult#THIS} if this candidate is better, {@code CandidateCompareResult#OTHER} if the 
	 * right candidate was better, {@code CandidateCompareResult#AMBIGUOUS} if both candidates are valid
	 * but ambiguous or {@code CandidateCompareResult#EQUALLY_INVALID} if both candidates are 
	 * ambiguous but erroneous.
	 */
	@SuppressWarnings("incomplete-switch")
	protected CandidateCompareResult compareTo(AbstractPendingLinkingCandidate<?> right) {
		boolean invalid = false;
		{
			CandidateCompareResult arityCompareResult = compareByArityWith(right);
			switch(arityCompareResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
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
					return CandidateCompareResult.THIS;
				return CandidateCompareResult.OTHER;
			} else if (!visible) {
				invalid = true;
			}
		}
		{
			CandidateCompareResult typeArityCompareResult = compareByArity(getTypeArityMismatch(), right.getTypeArityMismatch());
			switch(typeArityCompareResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return typeArityCompareResult;
				
			}
		}
		{
			CandidateCompareResult argumentTypeCompareResult = compareByArgumentTypes(right);
			switch(argumentTypeCompareResult) {
				case EQUALLY_INVALID:
					invalid = true;
					break;
				case SUSPICIOUS_OTHER:
				case OTHER:
				case THIS:
					return argumentTypeCompareResult;
				
			}
		}
		{
			CandidateCompareResult typeArgumentCompareResult = compareByTypeArguments(right);
			switch(typeArgumentCompareResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return typeArgumentCompareResult;
				
			}
		}
		if (isVarArgs() != right.isVarArgs()) {
			if (isVarArgs())
				return CandidateCompareResult.OTHER;
			return CandidateCompareResult.THIS;
		}
		if(isTypeLiteral() && !right.isTypeLiteral()) {
			return CandidateCompareResult.OTHER;
		}
		{
			CandidateCompareResult nameCompareResult = compareByName(right);
			switch(nameCompareResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return nameCompareResult;
			}
		}
		{
			CandidateCompareResult bucketCompareResult = compareByBucket(right);
			switch(bucketCompareResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return bucketCompareResult;
				
			}
		}
		if (invalid)
			return CandidateCompareResult.EQUALLY_INVALID;
		return CandidateCompareResult.AMBIGUOUS;
	}
	
	protected CandidateCompareResult compareByName(@SuppressWarnings("unused") AbstractPendingLinkingCandidate<?> right) {
		return CandidateCompareResult.AMBIGUOUS;
	}

	protected CandidateCompareResult compareByBucket(AbstractPendingLinkingCandidate<?> right) {
		if (description.getBucketId() != right.description.getBucketId()) {
			return CandidateCompareResult.THIS;
		}
		return CandidateCompareResult.AMBIGUOUS;
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
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		boolean hadIssues = false;
		{
			CandidateCompareResult argumentTypeResult = compareByArgumentTypes(right, false);
			switch(argumentTypeResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
					// ignore since we have a second pass below
					hadIssues = true;
					break;
				case OTHER:
				case THIS:
					return argumentTypeResult;
				
			}
		}
		{
			CandidateCompareResult parameterTypeResult = compareExpectedArgumentTypes(right);
			switch(parameterTypeResult) {
				case EQUALLY_INVALID:
					throw new IllegalStateException();
				case SUSPICIOUS_OTHER:
					if (hadIssues) {
						return CandidateCompareResult.OTHER;
					}
				case OTHER:
				case THIS:
					return parameterTypeResult;
				
			}
		}
		// subsequent parameters may have altered the bound type arguments
		// TODO this is more of a workaround than a real solution
		// actually the order of added hints and their sources should take care of that case
		// in a way that UnboundTypeConformance returns false for invalid combinations
		CandidateCompareResult secondPassArgumentTypes = compareByArgumentTypes(right, true);
		if (secondPassArgumentTypes == CandidateCompareResult.SUSPICIOUS_OTHER)
			throw new IllegalStateException();
		return secondPassArgumentTypes;
	}
	
	protected CandidateCompareResult compareByTypeArguments(AbstractPendingLinkingCandidate<?> right) {
		initializeArgumentTypeComputation();
		right.initializeArgumentTypeComputation();
		
		int leftFailures = getTypeArgumentConformanceFailures(null);
		int rightFailures = right.getTypeArgumentConformanceFailures(null);
		if (leftFailures != rightFailures) {
			if (leftFailures < rightFailures)
				return CandidateCompareResult.THIS;
			return CandidateCompareResult.OTHER;
		}
		return leftFailures != 0 ? CandidateCompareResult.EQUALLY_INVALID : CandidateCompareResult.AMBIGUOUS;
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
			TypeConformanceComputer conformanceComputer = argument.getOwner().getServices().getTypeConformanceComputer();
			if (argument.getType() != declaration) {
				LightweightTypeReference reference = new ParameterizedTypeReference(argument.getOwner(), declaration);
				for(LightweightTypeReference superType: reference.getSuperTypes()) {
					LightweightTypeReference substitutedSuperType = substitutor.substitute(superType);
					if ((conformanceComputer.isConformant(substitutedSuperType, argument, 
							RawTypeConformanceComputer.ALLOW_BOXING | RawTypeConformanceComputer.ALLOW_RAW_TYPE_CONVERSION ) & RawTypeConformanceComputer.SUCCESS) == 0) {
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
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, boolean recompute) {
		int upTo = Math.max(arguments.getArgumentCount(), right.arguments.getArgumentCount());
		int leftBoxing = 0;
		int rightBoxing = 0;
		int leftVarArgs = 0;
		int rightVarArgs = 0;
		int leftDemand = 0;
		int rightDemand = 0;
		boolean invalid = false;
		for(int i = 0; i < upTo; i++) {
			EnumSet<ConformanceHint> leftConformance = getConformanceHints(i, recompute);
			EnumSet<ConformanceHint> rightConformance = right.getConformanceHints(i, recompute);
			CandidateCompareResult hintCompareResult = compareByArgumentTypes(right, i, leftConformance, rightConformance);
			switch(hintCompareResult) {
				case SUSPICIOUS_OTHER:
					throw new IllegalStateException();
				case EQUALLY_INVALID:
					invalid = true;
					break;
				case OTHER:
				case THIS:
					return hintCompareResult;
				
			}
			if (!leftConformance.equals(rightConformance)) {
				if (leftConformance.contains(ConformanceHint.VAR_ARG)) {
					leftVarArgs++;
				}
				if (rightConformance.contains(ConformanceHint.VAR_ARG)) {
					rightVarArgs++;
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
		}
		if (arguments.hasEmptyTrailingVarArg()) {
			leftVarArgs++;
		}
		if (right.arguments.hasEmptyTrailingVarArg()) {
			rightVarArgs++;
		}
		if (leftVarArgs != rightVarArgs) {
			if (leftVarArgs < rightVarArgs) {
				return CandidateCompareResult.THIS;
			}
			return CandidateCompareResult.OTHER;
		}
		CandidateCompareResult result = compareByArgumentTypes(right, leftBoxing, rightBoxing, leftDemand, rightDemand);
		switch(result) {
			case AMBIGUOUS:
				if (invalid)
					return CandidateCompareResult.EQUALLY_INVALID;
			default:
				return result;
		}
	}

	/**
	 * Compare this linking candidate with the given {@code other} candidate at {@code argumentIndex}
	 * 
	 * Returns {@code CandidateCompareResult#THIS} if this candidate is better, {@code CandidateCompareResult#OTHER} if the 
	 * right candidate was better, {@code CandidateCompareResult#AMBIGUOUS} if both candidates are valid
	 * but ambiguous or {@code CandidateCompareResult#EQUALLY_INVALID} if both candidates are 
	 * ambiguous but erroneous.
	 * 
	 * @param other the other candidate
	 * @param argumentIndex the semantic argument index
	 * @param leftConformance the computed conformance in this linking candidate
	 * @param rightConformance the computed conformance if the other candidate was chosen  
	 */
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> other, int argumentIndex, EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		int hintCompareResult = ConformanceHint.compareHints(leftConformance, rightConformance);
		if (hintCompareResult == 0) {
			if (leftConformance.contains(ConformanceHint.SUCCESS)) {
				return CandidateCompareResult.AMBIGUOUS;
			} else {
				return CandidateCompareResult.EQUALLY_INVALID;
			}
		} else if (hintCompareResult < 0) {
			return CandidateCompareResult.THIS;
		} else {
			return CandidateCompareResult.OTHER;
		}
	}

	/**
	 * Compare this linking candidate with the given {@code other} candidate at {@code argumentIndex}
	 * 
	 * Returns {@code CandidateCompareResult#THIS} if this candidate is better, {@code CandidateCompareResult#OTHER} if the 
	 * right candidate was better, {@code CandidateCompareResult#AMBIGUOUS} if both candidates are valid
	 * but ambiguous or {@code CandidateCompareResult#EQUALLY_INVALID} if both candidates are 
	 * ambiguous but erroneous.
	 * 
	 * @param other the other candidate (the rhs of the comparison)
	 * @param leftBoxing the number of required boxing conversions if this candidate was chosen
	 * @param rightBoxing the number of required boxing conversions if the other candidate was chosen
	 * @param leftDemand the number of required demand conversions if this candidate was chosen  
	 * @param rightDemand the number of required demand conversions if the other candidate was chosen  
	 */
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> other, int leftBoxing, int rightBoxing, int leftDemand, int rightDemand) {
		if (leftDemand != rightDemand) {
			if (leftDemand < rightDemand)
				return CandidateCompareResult.THIS;
			return CandidateCompareResult.OTHER;
		}
		if (leftBoxing != rightBoxing) {
			if (leftBoxing < rightBoxing)
				return CandidateCompareResult.THIS;
			return CandidateCompareResult.OTHER;
		}
		return CandidateCompareResult.AMBIGUOUS;
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

	protected CandidateCompareResult compareExpectedArgumentTypes(AbstractPendingLinkingCandidate<?> right) {
		int result = 0;
		int upTo = Math.min(arguments.getArgumentCount(), right.arguments.getArgumentCount());
		for(int i = 0; i < upTo; i++) {
			LightweightTypeReference expectedArgumentType = getSubstitutedExpectedType(i);
			LightweightTypeReference rightExpectedArgumentType = right.getSubstitutedExpectedType(i);
			if (expectedArgumentType == null) {
				if (rightExpectedArgumentType != null)
					return CandidateCompareResult.OTHER;
			} else {
				if (rightExpectedArgumentType == null) {
					return CandidateCompareResult.THIS;
				}
				boolean leftResolved = expectedArgumentType.isResolved();
				if (!leftResolved) {
					expectedArgumentType = expectedArgumentType.getRawTypeReference();
				}
				boolean rightResolved = rightExpectedArgumentType.isResolved();
				if (!rightResolved) {
					rightExpectedArgumentType = rightExpectedArgumentType.getRawTypeReference();
				}
				result += compareDeclaredTypes(expectedArgumentType, rightExpectedArgumentType, leftResolved, rightResolved);
			}
		}
		if (result == 0) {
			if (!getDeclaredTypeParameters().isEmpty() || !right.getDeclaredTypeParameters().isEmpty()) {
				return compareDeclaredParameterTypes(right);
			}
			return CandidateCompareResult.AMBIGUOUS;
		} else if (result < 0) {
			return CandidateCompareResult.THIS;
		} else {
			return getExpectedTypeCompareResultOther(right);
		}
	}

	protected int compareDeclaredTypes(LightweightTypeReference left, LightweightTypeReference right, boolean leftResolved, boolean rightResolved) {
		TypeConformanceResult rightToLeftConformance = left.internalIsAssignableFrom(right, new TypeConformanceComputationArgument());
		if (rightToLeftConformance.isConformant()) {
			if (!right.isAssignableFrom(left) && 
					(!leftResolved || !rightResolved || !rightToLeftConformance.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION))) {
				return 1;
			}
		} else {
			TypeConformanceResult leftToRightConformance = right.internalIsAssignableFrom(left, new TypeConformanceComputationArgument());
			if (leftToRightConformance.isConformant() && 
					(!leftResolved || !rightResolved || !leftToRightConformance.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION))) {
				return -1;
			}
		}
		return 0;
	}

	private CandidateCompareResult compareDeclaredParameterTypes(AbstractPendingLinkingCandidate<?> right) {
		if(getFeature() instanceof JvmExecutable && right.getFeature() instanceof JvmExecutable) {
			List<JvmFormalParameter> parameters = ((JvmExecutable) getFeature()).getParameters();
			List<JvmFormalParameter> rightParameters = ((JvmExecutable) right.getFeature()).getParameters();
			if (parameters.size() == rightParameters.size()) {
				int result = 0;
				OwnedConverter converter = new OwnedConverter(getState().getReferenceOwner());
				OwnedConverter rightConverter = new OwnedConverter(right.getState().getReferenceOwner());
				TypeParameterByConstraintSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(getDeclaratorParameterMapping(), getState().getReferenceOwner());
				TypeParameterByConstraintSubstitutor rightSubstitutor = new TypeParameterByConstraintSubstitutor(right.getDeclaratorParameterMapping(), right.getState().getReferenceOwner());
				for(int i = 0; i < parameters.size(); i++) {
					LightweightTypeReference parameterType = converter.toLightweightReference(parameters.get(i).getParameterType());
					LightweightTypeReference rightParameterType = rightConverter.toLightweightReference(rightParameters.get(i).getParameterType());
					if (!parameterType.isResolved() || !rightParameterType.isResolved()) {
						result += compareDeclaredTypes(
								substitutor.substitute(parameterType),
								rightSubstitutor.substitute(rightParameterType),
								false,
								false);
					}
				}
				if (result == 0) {
					return CandidateCompareResult.AMBIGUOUS;
				} else if (result < 0) {
					return CandidateCompareResult.THIS;
				} else {
					return getExpectedTypeCompareResultOther(right);
				}
			}
		}
		return CandidateCompareResult.AMBIGUOUS;
	}

	/**
	 * Returns the compare result for the declared parameter types if the given other candidate had won.
	 * 
	 * @param other the winner of the comparison.
	 */
	protected CandidateCompareResult getExpectedTypeCompareResultOther(AbstractPendingLinkingCandidate<?> other) {
		return CandidateCompareResult.OTHER;
	}

	protected CandidateCompareResult compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		CandidateCompareResult arityCompareResult = compareByArity(getArityMismatch(), right.getArityMismatch());
		return arityCompareResult;
	}

	protected CandidateCompareResult compareByArity(int leftArityMismatch, int rightArityMismatch) {
		if (leftArityMismatch != rightArityMismatch) {
			if (leftArityMismatch == 0)
				return CandidateCompareResult.THIS;
			if (rightArityMismatch == 0)
				return CandidateCompareResult.OTHER;
			if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
				return CandidateCompareResult.THIS;
			if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
				return CandidateCompareResult.OTHER;
			if (leftArityMismatch > 0)
				return CandidateCompareResult.THIS;
			if (rightArityMismatch > 0)
				return CandidateCompareResult.OTHER;
		}
		return leftArityMismatch == 0 ? CandidateCompareResult.AMBIGUOUS : CandidateCompareResult.EQUALLY_INVALID;
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
