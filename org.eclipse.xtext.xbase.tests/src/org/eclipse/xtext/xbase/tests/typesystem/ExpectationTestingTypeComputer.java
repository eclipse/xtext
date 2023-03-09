/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExpectationTestingTypeComputer extends XbaseTypeComputer {
	private AbstractExpectationTest test;

	private Function1<? super XExpression, ? extends Boolean> predicate = (XExpression it) -> {
		return it instanceof XNullLiteral;
	};

	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (predicate.apply(expression).booleanValue()) {
			test.recordExpectation(expression, state);
		}
		super.computeTypes(expression, state);
	}

	public AbstractExpectationTest getTest() {
		return test;
	}

	public void setTest(AbstractExpectationTest test) {
		this.test = test;
	}

	public Function1<? super XExpression, ? extends Boolean> getPredicate() {
		return predicate;
	}

	public void setPredicate(Function1<? super XExpression, ? extends Boolean> predicate) {
		this.predicate = predicate;
	}
}
