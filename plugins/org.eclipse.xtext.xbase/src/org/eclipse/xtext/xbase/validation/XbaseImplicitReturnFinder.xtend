/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation

import java.util.List
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
	
	def dispatch findImplicitReturns(Void expression) {
		#[]
	}

	def dispatch findImplicitReturns(XExpression expression) {
		#[]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XNumberLiteral expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XBooleanLiteral expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XCollectionLiteral expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XStringLiteral expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XNullLiteral expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XClosure expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XConstructorCall expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XAbstractFeatureCall expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XInstanceOfExpression expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XCastedExpression expression) {
		#[expression]
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XBlockExpression expression) {
		findImplicitReturns(expression.expressions.last)
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XSynchronizedExpression expression) {
		findImplicitReturns(expression.expression)
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XIfExpression expression) {
		(findImplicitReturns(expression.then) + findImplicitReturns(expression.^else)).toList
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XTryCatchFinallyExpression expression) {
		(findImplicitReturns(expression.expression) + expression.catchClauses.map[findImplicitReturns(it.expression)].flatten).toList
	}
	
	def dispatch List<? extends XExpression> findImplicitReturns(XSwitchExpression expression) {
		(expression.cases.map[findImplicitReturns(it.then)].flatten + findImplicitReturns(expression.^default)).toList
	}
	
}
