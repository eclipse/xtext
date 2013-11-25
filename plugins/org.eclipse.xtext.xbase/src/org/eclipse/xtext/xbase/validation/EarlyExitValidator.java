/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;

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
		for(int i = 0; i < expressions.size() - 1; i++) {
			XExpression expression = expressions.get(i);
			if (earlyExitComputer.isEarlyExit(expression)) {
				if (!(expression instanceof XAbstractFeatureCall)) {
					// XAbstractFeatureCall does already a decent job for its argument lists
					// no additional error necessary
					error("Unreachable expression.", expressions.get(i + 1), null, IssueCodes.UNREACHABLE_CODE);
				}
				return;
			}
		}
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
}
