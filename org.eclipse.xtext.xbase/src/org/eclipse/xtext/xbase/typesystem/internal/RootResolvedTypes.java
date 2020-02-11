/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.common.collect.Sets;

/**
 * The root resolved types are the effective result of a type computation.
 * They don't have a parent and should never yield unresolved type references
 * when clients query for types of expressions or identifiables.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt - Configurable issue severity, support for checked exceptions
 * 
 * TODO guard against unresolved type references
 * TODO toString
 */
public class RootResolvedTypes extends ResolvedTypes {

	private Set<XExpression> toBeInferredRootExpressions;

	protected RootResolvedTypes(DefaultReentrantTypeResolver resolver, CancelIndicator monitor) {
		super(new Shared(resolver, monitor));
		this.shared.root = this;
	}

	public void resolveUnboundTypeParameters() {
		for(UnboundTypeReference unbound: basicGetTypeParameters().values()) {
			unbound.resolve();
		}
	}

	public void resolveProxies() {
		Map<XExpression, IApplicableCandidate> candidates = basicGetLinkingMap();
		for(IApplicableCandidate candidate: candidates.values()) {
			candidate.applyToModel(this);
		}
	}
	
	@Override
	/* @Nullable */
	protected LightweightTypeReference getExpectedTypeForAssociatedExpression(JvmMember member, XExpression expression) {
		if (toBeInferredRootExpressions != null && toBeInferredRootExpressions.contains(expression)) {
			return null;
		}
		return getActualType(member);
	}
	
	@Override
	protected void markToBeInferred(XExpression expression) {
		if (toBeInferredRootExpressions == null) {
			toBeInferredRootExpressions = Sets.newHashSet();
		}
		toBeInferredRootExpressions.add(expression);
	}

	public void addDiagnostics(final Resource resource) {
		if (resource instanceof XtextResource) {
			if (((XtextResource) resource).isValidationDisabled())
				return;
		}
		class DiagnosticAcceptor implements IAcceptor<AbstractDiagnostic> {

			@Override
			public void accept(/* @Nullable */ AbstractDiagnostic diagnostic) {
				if (diagnostic instanceof EObjectDiagnosticImpl) {
					Severity severity = ((EObjectDiagnosticImpl) diagnostic).getSeverity();
					if (severity == Severity.ERROR) {
						resource.getErrors().add(diagnostic);
					} else if (severity == Severity.WARNING) {
						resource.getWarnings().add(diagnostic);
					}
				} else {
					resource.getErrors().add(diagnostic);
				}
			}
			
		}
		DiagnosticAcceptor acceptor = new DiagnosticAcceptor();
		addQueuedDiagnostics(acceptor);
		addLinkingDiagnostics(acceptor);
		addTypeDiagnostics(acceptor);
	}

	protected void addTypeDiagnostics(IAcceptor<? super AbstractDiagnostic> acceptor) {
		for(Map.Entry<XExpression, List<TypeData>> entry: basicGetExpressionTypes().entrySet()) {
			XExpression expression = entry.getKey();
			if (!isPropagatedType(expression))
				addTypeDiagnostic(expression, mergeTypeData(expression, entry.getValue(), false, false), acceptor);
		}
	}

	protected void addTypeDiagnostic(XExpression expression, /* @Nullable */ TypeData typeData, IAcceptor<? super AbstractDiagnostic> acceptor) {
		if (typeData != null) {
			LightweightTypeReference actualType = typeData.getActualType();
			ITypeExpectation expectation = typeData.getExpectation();
			int knownFlags = typeData.getConformanceFlags();
			if ((knownFlags & (ConformanceFlags.NO_IMPLICIT_RETURN | ConformanceFlags.PROPAGATED_TYPE)) == 0) {
				if (actualType.isPrimitiveVoid() && isIntentionalEarlyExit(expression)) {
					return;
				}
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null) {
					if (!expectedType.isPrimitiveVoid()) {
						int conformanceFlags = getConformanceFlags(typeData, false);
						if (!((conformanceFlags & ConformanceFlags.SUCCESS) != 0)) {
							AbstractDiagnostic diagnostic = createTypeDiagnostic(expression, actualType, expectedType);
							if (diagnostic == null) {
//								knownFlags |= ConformanceFlags.UNCHECKED;
							} else {
								acceptor.accept(diagnostic);
							}
						}
					}
				} else if (!expectation.isVoidTypeAllowed() && actualType.isPrimitiveVoid()) {
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, 
							"Type mismatch: type void is not applicable at this location", expression, null, -1,
							null);
					acceptor.accept(diagnostic);
				}
			}
		}
	}

	// TODO discuss / improve
	/**
	 * Returns <code>true</code> for expressions that seem to be early exit expressions, e.g.
	 * <pre>
	 *   while(condition) {
	 *     if (anotherCondition)
	 *       return value
	 *     changeResultOfFirstCondition
	 *   }
	 * </pre>
	 */
	protected boolean isIntentionalEarlyExit(/* @Nullable */ XExpression expression) {
		ExtendedEarlyExitComputer earlyExitComputer = getReferenceOwner().getServices().getEarlyExitComputer();
		return earlyExitComputer.isIntentionalEarlyExit(expression);
	}
	
	protected AbstractDiagnostic createTypeDiagnostic(XExpression expression, LightweightTypeReference actualType, LightweightTypeReference expectedType) {
		if (!expectedType.isAny()) {
			String actualName = actualType.getSimpleName();
			String expectedName = expectedType.getSimpleName();
			if (actualName.equals(expectedName)) {
				if (expectedType.isAssignableFrom(actualType)) {
					return null;
				}
			}
			if (expression.eContainingFeature() == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT) {
				return new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
						"Type mismatch: cannot convert implicit first argument from %s to %s", actualType.getHumanReadableName(), expectedType.getHumanReadableName()),
						expression, null, -1, null);
			} else {
				return new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
						"Type mismatch: cannot convert from %s to %s", actualType.getHumanReadableName(), expectedType.getHumanReadableName()),
						expression, null, -1, null);
			}
		} else {
			return new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
					"Type mismatch: type %s is not applicable at this location", actualType.getHumanReadableName()), expression, null, -1,
					null);
		}
	}

	protected void addLinkingDiagnostics(IAcceptor<? super AbstractDiagnostic> acceptor) {
		Map<XExpression, IApplicableCandidate> candidates = basicGetLinkingMap();
		for(IApplicableCandidate candidate: candidates.values()) {
			candidate.validate(acceptor);
		}
	}

	protected void addQueuedDiagnostics(IAcceptor<? super AbstractDiagnostic> acceptor) {
		for(AbstractDiagnostic diagnostic: getQueuedDiagnostics()) {
			acceptor.accept(diagnostic);
		}
	}

	protected void processDeferredLogic() {
		for(IAcceptor<? super IResolvedTypes> runnable: getDeferredLogic()) {
			runnable.accept(this);
		}
		clearDeferredLogic();
	}
}
