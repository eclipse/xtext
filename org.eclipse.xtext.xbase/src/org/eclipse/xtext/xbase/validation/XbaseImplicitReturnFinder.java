/**
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;

import com.google.common.collect.Iterables;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class XbaseImplicitReturnFinder implements ImplicitReturnFinder {
	protected void _findImplicitReturns(Void expression, Acceptor acceptor) {
	}

	protected void _findImplicitReturns(XExpression expression, Acceptor acceptor) {
	}

	protected void _findImplicitReturns(XNumberLiteral expression, Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XBooleanLiteral expression,
			Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XCollectionLiteral expression,
			Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XStringLiteral expression, Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XNullLiteral expression, Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XTypeLiteral expression, Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XClosure expression, Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XConstructorCall expression,
			Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XAbstractFeatureCall expression,
			Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XInstanceOfExpression expression,
			Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XCastedExpression expression,
			Acceptor acceptor) {
		acceptor.accept(expression);
	}

	protected void _findImplicitReturns(XBlockExpression expression,
			Acceptor acceptor) {
		findImplicitReturns(Iterables.getLast(expression.getExpressions()), acceptor);
	}

	protected void _findImplicitReturns(XSynchronizedExpression expression,
			Acceptor acceptor) {
		findImplicitReturns(expression.getExpression(), acceptor);
	}

	protected void _findImplicitReturns(XIfExpression expression, Acceptor acceptor) {
		findImplicitReturns(expression.getThen(), acceptor);
		findImplicitReturns(expression.getElse(), acceptor);
	}

	protected void _findImplicitReturns(XTryCatchFinallyExpression expression,
			Acceptor acceptor) {
		findImplicitReturns(expression.getExpression(), acceptor);
		expression.getCatchClauses().forEach(it -> findImplicitReturns(it.getExpression(), acceptor));
	}

	protected void _findImplicitReturns(XSwitchExpression expression,
			Acceptor acceptor) {
		expression.getCases().forEach(it -> findImplicitReturns(it.getThen(), acceptor));
		findImplicitReturns(expression.getDefault(), acceptor);
	}

	@Override
	public void findImplicitReturns(XExpression expression, Acceptor acceptor) {
		if (expression instanceof XAbstractFeatureCall) {
			_findImplicitReturns((XAbstractFeatureCall) expression, acceptor);
		} else if (expression instanceof XBlockExpression) {
			_findImplicitReturns((XBlockExpression) expression, acceptor);
		} else if (expression instanceof XBooleanLiteral) {
			_findImplicitReturns((XBooleanLiteral) expression, acceptor);
		} else if (expression instanceof XCastedExpression) {
			_findImplicitReturns((XCastedExpression) expression, acceptor);
		} else if (expression instanceof XClosure) {
			_findImplicitReturns((XClosure) expression, acceptor);
		} else if (expression instanceof XCollectionLiteral) {
			_findImplicitReturns((XCollectionLiteral) expression, acceptor);
		} else if (expression instanceof XConstructorCall) {
			_findImplicitReturns((XConstructorCall) expression, acceptor);
		} else if (expression instanceof XIfExpression) {
			_findImplicitReturns((XIfExpression) expression, acceptor);
		} else if (expression instanceof XInstanceOfExpression) {
			_findImplicitReturns((XInstanceOfExpression) expression, acceptor);
		} else if (expression instanceof XNullLiteral) {
			_findImplicitReturns((XNullLiteral) expression, acceptor);
		} else if (expression instanceof XNumberLiteral) {
			_findImplicitReturns((XNumberLiteral) expression, acceptor);
		} else if (expression instanceof XStringLiteral) {
			_findImplicitReturns((XStringLiteral) expression, acceptor);
		} else if (expression instanceof XSwitchExpression) {
			_findImplicitReturns((XSwitchExpression) expression, acceptor);
		} else if (expression instanceof XSynchronizedExpression) {
			_findImplicitReturns((XSynchronizedExpression) expression, acceptor);
		} else if (expression instanceof XTryCatchFinallyExpression) {
			_findImplicitReturns((XTryCatchFinallyExpression) expression, acceptor);
		} else if (expression instanceof XTypeLiteral) {
			_findImplicitReturns((XTypeLiteral) expression, acceptor);
		} else if (expression != null) {
			_findImplicitReturns(expression, acceptor);
		} else {
			_findImplicitReturns((Void) null, acceptor);
		}
	}
}
