/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.xbase.XTypeLiteral

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class XbaseImplicitReturnFinder implements ImplicitReturnFinder {

	def dispatch void findImplicitReturns(Void expression, ImplicitReturnFinder.Acceptor acceptor) {
	}

	def dispatch void findImplicitReturns(XExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
	}
	
	def dispatch void findImplicitReturns(XNumberLiteral expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XBooleanLiteral expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XCollectionLiteral expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XStringLiteral expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XNullLiteral expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XTypeLiteral expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XClosure expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XConstructorCall expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XAbstractFeatureCall expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XInstanceOfExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XCastedExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		acceptor.accept(expression)
	}

	def dispatch void findImplicitReturns(XBlockExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		findImplicitReturns(expression.expressions.last, acceptor)
	}

	def dispatch void findImplicitReturns(XSynchronizedExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		findImplicitReturns(expression.expression, acceptor)
	}

	def dispatch void findImplicitReturns(XIfExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		findImplicitReturns(expression.then, acceptor)

		//TODO this will not find the implicit "return null" when there is no "else"
		findImplicitReturns(expression.^else, acceptor)
	}

	def dispatch void findImplicitReturns(XTryCatchFinallyExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		findImplicitReturns(expression.expression, acceptor)
		expression.catchClauses.forEach[findImplicitReturns(it.expression, acceptor)]
	}

	def dispatch void findImplicitReturns(XSwitchExpression expression, ImplicitReturnFinder.Acceptor acceptor) {
		expression.cases.forEach[findImplicitReturns(it.then, acceptor)]
		findImplicitReturns(expression.^default, acceptor)
	}
}
