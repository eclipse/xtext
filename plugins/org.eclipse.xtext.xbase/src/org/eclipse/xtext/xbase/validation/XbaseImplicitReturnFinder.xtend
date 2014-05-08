/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XCollectionLiteral
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XInstanceOfExpression
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class XbaseImplicitReturnFinder implements ImplicitReturnFinder {

	def dispatch findImplicitReturns(XExpression expression) {
		#[]
	}

	def dispatch findImplicitReturns(XNumberLiteral expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XBooleanLiteral expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XCollectionLiteral expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XStringLiteral expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XNullLiteral expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XClosure expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XConstructorCall expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XAbstractFeatureCall expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XInstanceOfExpression expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XCastedExpression expression) {
		#[expression]
	}

	def dispatch findImplicitReturns(XBlockExpression expression) {
		findImplicitReturns(expression.expressions.last)
	}

	def dispatch findImplicitReturns(XSynchronizedExpression expression) {
		findImplicitReturns(expression.expression)
	}

	def dispatch findImplicitReturns(XIfExpression expression) {
		(findImplicitReturns(expression.then) + findImplicitReturns(expression.^else)).toList
	}

	def dispatch findImplicitReturns(XTryCatchFinallyExpression expression) {
		(findImplicitReturns(expression.expression) +
			expression.catchClauses.map[findImplicitReturns(it.expression)].flatten).toList
	}

	def dispatch findImplicitReturns(XSwitchExpression expression) {
		(expression.cases.map[findImplicitReturns(it.then)].flatten + findImplicitReturns(expression.^default)).toList
	}

}
