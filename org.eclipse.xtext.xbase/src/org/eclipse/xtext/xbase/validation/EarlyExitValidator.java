/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.controlflow.BooleanResult;
import org.eclipse.xtext.xbase.controlflow.ConstantConditionsInterpreter;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EarlyExitValidator extends AbstractDeclarativeValidator {

	private final Map<EReference,EarlyExitKind> disallowedEarylExitReferences = ImmutableMap.of(
		XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, EarlyExitKind.BOTH
	);
	
	/**
	 * @return map of references which 
	 */
	protected Map<EReference,EarlyExitKind> getDisallowedEarlyExitReferences() {
		return disallowedEarylExitReferences;
	}
	
	protected enum EarlyExitKind {
		RETURN, THROW, BOTH
	}
	
	@Inject
	private IEarlyExitComputer earlyExitComputer;
	
	@Inject
	private ConstantConditionsInterpreter constantExpressionInterpreter;
	
	@Check
	public void checkInvalidReturnExpression(XExpression expression) {
		final EReference contFeature = (EReference) expression.eContainingFeature();
		final Map<EReference, EarlyExitKind> map = getDisallowedEarlyExitReferences();
		if (map.containsKey(contFeature)) {
			EarlyExitKind exitKind = map.get(contFeature);
			List<XExpression> returns = newArrayList();
			collectExits(expression, returns);
			for (XExpression expr : returns) {
				if (expr instanceof XReturnExpression && (exitKind == EarlyExitKind.RETURN || exitKind == EarlyExitKind.BOTH)) {
					error("A return expression is not allowed in this context.", expr, null, IssueCodes.INVALID_EARLY_EXIT);
				}
				if (expr instanceof XThrowExpression && (exitKind == EarlyExitKind.THROW || exitKind == EarlyExitKind.BOTH)) {
					error("A throw expression is not allowed in this context.", expr, null, IssueCodes.INVALID_EARLY_EXIT);
				}
			}
		}
	}

	protected void collectExits(EObject expr, List<XExpression> found) {
		if (expr instanceof XReturnExpression) {
			found.add((XExpression) expr);
		} else if (expr instanceof XThrowExpression) {
			found.add((XExpression) expr);
		} else if (expr instanceof XClosure) {
			return;
		}
		for (EObject child : expr.eContents()) {
			collectExits(child, found);
		}
	}
	
	@Check
	public void checkDeadCode(XBlockExpression block) {
		List<XExpression> expressions = block.getExpressions();
		for(int i = 0, size = expressions.size(); i < size - 1; i++) {
			XExpression expression = expressions.get(i);
			if (earlyExitComputer.isEarlyExit(expression)) {
				if (!(expression instanceof XAbstractFeatureCall)) {
					// XAbstractFeatureCall does already a decent job for its argument lists
					// no additional error necessary
					markAsDeadCode(expressions.get(i + 1));
				}
				return;
			}
		}
	}
	
	@Check
	public void checkDeadCode(XWhileExpression loop) {
		XExpression predicate = loop.getPredicate();
		if (!earlyExitComputer.isEarlyExit(predicate)) {
			Optional<BooleanResult> result = getBooleanResult(predicate);
			if (result.isPresent()) {
				BooleanResult booleanResult = result.get();
				markConstantBooleanCondition(predicate, booleanResult, true);
				if (booleanResult.isCompileTimeConstant() && !booleanResult.getValue().or(Boolean.TRUE)) {
					markAsDeadCode(loop.getBody());
				}
			}
		} else {
			markAsDeadCode(loop.getBody());
		}
	}

	protected void markConstantBooleanCondition(XExpression predicate, BooleanResult booleanResult, boolean ignoreBooleanLiteral) {
		if (!ignoreBooleanLiteral || predicate.eClass() != XbasePackage.Literals.XBOOLEAN_LITERAL) {
			Optional<Boolean> value = booleanResult.getValue();
			if (value.isPresent()) {
				addIssue("Constant condition is always " + value.get() + ".", predicate, null, IssueCodes.CONSTANT_BOOLEAN_CONDITION);
			} else {
				addIssue("Constant condition.", predicate, null, IssueCodes.CONSTANT_BOOLEAN_CONDITION);
			}
		}
		
	}

	private boolean markAsDeadCode(List<XExpression> expressions) {
		if (!expressions.isEmpty()) {
			markAsDeadCode(expressions.get(0));
			return true;
		}
		return false;
	}
	
	private void validateCondition(XExpression expression, boolean ignoreBooleanLiteral) {
		if (!isIgnored(IssueCodes.CONSTANT_BOOLEAN_CONDITION)) {
			Optional<BooleanResult> result = getBooleanResult(expression);
			if (result.isPresent()) {
				markConstantBooleanCondition(expression, result.get(), ignoreBooleanLiteral);
			}
		}
	}
	
	private boolean markAsDeadCode(XExpression expression) {
		if (expression instanceof XBlockExpression) {
			List<XExpression> expressions = ((XBlockExpression) expression).getExpressions();
			if (markAsDeadCode(expressions)) {
				return true;
			}
		} 
		if (expression != null) {
			error("Unreachable expression.", expression, null, IssueCodes.UNREACHABLE_CODE);
			return true;
		} else {
			return false;
		}
	}
	
	private boolean markAsDeadCode(JvmTypeReference typeGuard) {
		if (typeGuard != null) {
			error("Unreachable expression.", typeGuard, null, IssueCodes.UNREACHABLE_CODE);
			return true;
		}
		return false;
	}
	
	@Check
	public void checkDeadCode(XDoWhileExpression loop) {
		if (earlyExitComputer.isEarlyExit(loop.getBody())) {
			markAsDeadCode(loop.getPredicate());
		} else {
			XExpression predicate = loop.getPredicate();
			if (!earlyExitComputer.isEarlyExit(predicate)) {
				validateCondition(predicate, true);
			}
		}
	}
	
	@Check
	public void checkDeadCode(XIfExpression condition) {
		if (!earlyExitComputer.isEarlyExit(condition.getIf())) {
			validateCondition(condition.getIf(), false);
		} else {
			if (!markAsDeadCode(condition.getThen())) {
				markAsDeadCode(condition.getElse());
			}
		}
	}
	
	@Check
	public void checkDeadCode(XBasicForLoopExpression loop) {
		XExpression predicate = loop.getExpression();
		if (!earlyExitComputer.isEarlyExit(predicate)) {
			Optional<BooleanResult> result = getBooleanResult(predicate);
			if (result.isPresent()) {
				BooleanResult booleanResult = result.get();
				markConstantBooleanCondition(predicate, booleanResult, false);
				if (booleanResult.isCompileTimeConstant() && !booleanResult.getValue().or(Boolean.TRUE)) {
					markAsDeadCode(loop.getEachExpression());
					return;
				}
			}
			if (earlyExitComputer.isEarlyExit(loop.getEachExpression())) {
				markAsDeadCode(loop.getUpdateExpressions());
			}
		} else {
			if (!markAsDeadCode(loop.getUpdateExpressions())) {
				markAsDeadCode(loop.getEachExpression());
			}
		}
	}

	protected Optional<BooleanResult> getBooleanResult(XExpression expression) {
		if (expression == null)
			return Optional.absent();
		return Optional.fromNullable(constantExpressionInterpreter.getBooleanConstantOrNull(expression));
	}
	
	@Check
	public void checkDeadCode(XSwitchExpression switchExpression) {
		List<XCasePart> cases = switchExpression.getCases();
		for(int i = 0, size = cases.size(); i < size; i++) {
			XCasePart casePart = cases.get(i);
			XExpression caseExpression = casePart.getCase();
			if (!earlyExitComputer.isEarlyExit(caseExpression)) {
				validateCondition(caseExpression, false);
			} else if (!markAsDeadCode(casePart.getThen())) {
				if (casePart.getTypeGuard() == null) { 
					i = markAsDeadCode(cases, casePart, i, size);
				}
			}
		}
	}

	protected int markAsDeadCode(List<XCasePart> cases, XCasePart from, int idx, int size) {
		if (!markAsDeadCode(from.getThen())) {
			for(int j = idx + 1; j < size; j++) {
				XCasePart next = cases.get(j);
				if (markAsDeadCode(next.getTypeGuard()) || markAsDeadCode(next.getCase()) || markAsDeadCode(next.getThen())) {
					idx = j;
					j = size;
				}
			}
		}
		return idx;
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
}
