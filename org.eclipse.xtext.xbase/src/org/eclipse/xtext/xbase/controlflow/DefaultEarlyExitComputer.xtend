/** 
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Collection
import java.util.Collections
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBasicForLoopExpression
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XCatchClause
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.XDoWhileExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XForLoopExpression
import org.eclipse.xtext.xbase.XIfExpression
import org.eclipse.xtext.xbase.XReturnExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XSynchronizedExpression
import org.eclipse.xtext.xbase.XThrowExpression
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.XWhileExpression

/** 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton class DefaultEarlyExitComputer implements IEarlyExitComputer {
	@Inject EarlyExitInterpreter earlyExitInterpreter

	override boolean isEarlyExit(XExpression expression) {
		var Collection<ExitPoint> exitPoints = getExitPoints(expression)
		if(isNotEmpty(exitPoints)) return true
		return false
	}

	def protected boolean isNotEmpty(Collection<ExitPoint> exitPoints) {
		return exitPoints !== null && !exitPoints.isEmpty()
	}

	override Collection<ExitPoint> getExitPoints(XExpression expression) {
		if(expression === null) return Collections.emptyList()
		return exitPoints(expression)
	}

	/** 
	 * @param expression unused in this context but required in dispatch signature 
	 */
	dispatch def protected Collection<ExitPoint> exitPoints(XExpression expression) {
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XReturnExpression expression) {
		return Collections.singletonList(new ExitPoint(expression, false))
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XThrowExpression expression) {
		return Collections.singletonList(new ExitPoint(expression, true))
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XBlockExpression expression) {
		for (XExpression child : expression.getExpressions()) {
			var Collection<ExitPoint> exitPoints = getExitPoints(child)
			if(isNotEmpty(exitPoints)) return exitPoints
		}
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XBasicForLoopExpression expression) {
		for (XExpression initExpression : expression.getInitExpressions()) {
			var Collection<ExitPoint> exitPoints = getExitPoints(initExpression)
			if (isNotEmpty(exitPoints)) {
				return exitPoints
			}

		}
		var XExpression predicate = expression.getExpression()
		var Collection<ExitPoint> exitPoints = getExitPoints(predicate)
		if (isNotEmpty(exitPoints)) {
			return exitPoints
		}
		if (predicate === null || isBooleanConstant(predicate, true)) {
			exitPoints = getExitPoints(expression.getEachExpression())
			if(isNotEmpty(exitPoints)) return exitPoints
			for (XExpression child : expression.getUpdateExpressions()) {
				exitPoints = getExitPoints(child)
				if(isNotEmpty(exitPoints)) return exitPoints
			}
			return Collections.singletonList(new ExitPoint(expression, false))
		}
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XForLoopExpression expression) {
		var Collection<ExitPoint> exitPoints = getExitPoints(expression.getForExpression())
		if(isNotEmpty(exitPoints)) return exitPoints
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XWhileExpression expression) {
		var Collection<ExitPoint> exitPoints = getExitPoints(expression.getPredicate())
		if(isNotEmpty(exitPoints)) return exitPoints
		if (isBooleanConstant(expression.getPredicate(), true)) {
			exitPoints = getExitPoints(expression.getBody())
			if(isNotEmpty(exitPoints)) return exitPoints
			return Collections.singletonList(new ExitPoint(expression, false))
		}
		return Collections.emptyList()
	}

	def protected boolean isBooleanConstant(XExpression expression, boolean value) {
		return earlyExitInterpreter.isConstant(expression, value)
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XDoWhileExpression expression) {
		var Collection<ExitPoint> exitPoints = getExitPoints(expression.getBody())
		if(isNotEmpty(exitPoints)) return exitPoints
		exitPoints = getExitPoints(expression.getPredicate())
		if(isNotEmpty(exitPoints)) return exitPoints
		if (isBooleanConstant(expression.getPredicate(), true)) {
			return Collections.singletonList(new ExitPoint(expression, false))
		}
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XVariableDeclaration expression) {
		return getExitPoints(expression.getRight())
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XIfExpression expression) {
		var Collection<ExitPoint> ifExitPoints = getExitPoints(expression.getIf())
		if(isNotEmpty(ifExitPoints)) return ifExitPoints
		var Collection<ExitPoint> thenExitPoints = getExitPoints(expression.getThen())
		var Collection<ExitPoint> elseExitPoints = getExitPoints(expression.getElse())
		if (isNotEmpty(thenExitPoints) && isNotEmpty(elseExitPoints)) {
			var Collection<ExitPoint> result = Lists.newArrayList(thenExitPoints)
			result.addAll(elseExitPoints)
			return result
		}
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XSwitchExpression expression) {
		var Collection<ExitPoint> switchExitPoints = getExitPoints(expression.getSwitch())
		if(isNotEmpty(switchExitPoints)) return switchExitPoints
		var Collection<ExitPoint> result = Lists.newArrayList()
		for (XCasePart casePart : expression.getCases()) {
			// TODO do we have an early exit if the first case condition is an early exit?
			var XExpression then = casePart.getThen()
			if (then !== null) {
				var Collection<ExitPoint> caseExit = getExitPoints(then)
				if(!isNotEmpty(caseExit)) return Collections.emptyList() else result.addAll(caseExit)
			}

		}
		var Collection<ExitPoint> defaultExit = getExitPoints(expression.getDefault())
		if(!isNotEmpty(defaultExit)) return Collections.emptyList() else result.addAll(defaultExit)
		return result
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XAbstractFeatureCall expression) {
		for (XExpression argument : expression.getActualArguments()) {
			var Collection<ExitPoint> argumentExitPoints = getExitPoints(argument)
			if(isNotEmpty(argumentExitPoints)) return argumentExitPoints
		}
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XConstructorCall expression) {
		for (XExpression argument : expression.getArguments()) {
			var Collection<ExitPoint> argumentExitPoints = getExitPoints(argument)
			if(isNotEmpty(argumentExitPoints)) return argumentExitPoints
		}
		return Collections.emptyList()
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XTryCatchFinallyExpression expression) {
		var Collection<ExitPoint> tryExitPoints = getExitPoints(expression.getExpression())
		if (isNotEmpty(tryExitPoints)) {
			var Collection<ExitPoint> result = Lists.newArrayList(tryExitPoints)
			// TODO validate tryExitPoints against catch clauses
			for (XCatchClause catchClause : expression.getCatchClauses()) {
				var Collection<ExitPoint> catchExitPoints = getExitPoints(catchClause.getExpression())
				if (isNotEmpty(catchExitPoints)) {
					result.addAll(catchExitPoints)
				} else {
					return getExitPoints(expression.getFinallyExpression())
				}
			}
			return result
		}
		return getExitPoints(expression.getFinallyExpression())
	}

	dispatch def protected Collection<ExitPoint> exitPoints(XSynchronizedExpression expression) {
		var Collection<ExitPoint> paramExitPoints = getExitPoints(expression.getParam())
		if (isNotEmpty(paramExitPoints)) {
			return paramExitPoints
		}
		return getExitPoints(expression.getExpression())
	}

}
