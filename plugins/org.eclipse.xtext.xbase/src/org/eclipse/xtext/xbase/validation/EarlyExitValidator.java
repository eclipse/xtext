/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer.ExitPoint;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EarlyExitValidator extends AbstractDeclarativeValidator {

	// TODO disallow return in feature call arguments? 
	private final Collection<EReference> disallowedEarylExitReferences = ImmutableList.of(
		XbasePackage.Literals.XIF_EXPRESSION__IF,
		XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION,
		XbasePackage.Literals.XRETURN_EXPRESSION__EXPRESSION,
		XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH,
		XbasePackage.Literals.XCASE_PART__CASE,
		XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION,
		XbasePackage.Literals.XASSIGNMENT__ASSIGNABLE
	);
	
	protected Collection<EReference> getDisallowedEarlyExitReferences() {
		return disallowedEarylExitReferences;
	}
	
	@Inject
	private IEarlyExitComputer earlyExitComputer;
	
	@Check
	public void checkEarlyExitInvalid(XExpression expression) {
		doCheckEarlyExitInvalid(expression);
	}
	
	@Check
	public void checkEarlyExitInvalid(XCasePart casePart) {
		doCheckEarlyExitInvalid(casePart);
	}

	protected void doCheckEarlyExitInvalid(EObject eObject) {
		for(EReference reference: getDisallowedEarlyExitReferences()) {
			if (EcoreUtil2.isAssignableFrom(reference.getEContainingClass(), eObject.eClass())) {
				if (reference.isMany()) {
					List<?> values = (List<?>) eObject.eGet(reference);
					for(Object object: values) {
						if (object instanceof XExpression)
							checkExpressionExitsNormally((XExpression) object);
					}
				} else {
					Object object = eObject.eGet(reference);
					if (object instanceof XExpression)
						checkExpressionExitsNormally((XExpression) object);
				}
			}
		}
	}

	protected void checkExpressionExitsNormally(XExpression expression) {
		Collection<ExitPoint> exitPoints = earlyExitComputer.getExitPoints(expression);
		if (exitPoints != null && !exitPoints.isEmpty()) {
			for(ExitPoint exitPoint: exitPoints) {
				// TODO only mark exitPoints which are not exceptionalExits?
				error("Expression may not return early in this context.", exitPoint.getExpression(), null, IssueCodes.INVALID_EARLY_EXIT);
			}
		}
	}
	
	@Check
	public void checkDeadCode(XBlockExpression block) {
		List<XExpression> expressions = block.getExpressions();
		for(int i = 0; i < expressions.size() - 1; i++) {
			if (earlyExitComputer.isEarlyExit(expressions.get(i))) {
				error("Unreachable expression.", expressions.get(i + 1), null, IssueCodes.UNREACHABLE_CODE);
				return;
			}
		}
	}
	
	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
}
