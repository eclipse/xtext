/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.controlflow;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO reimplement with Xtend dispatch
 */
@Singleton
public class DefaultEarlyExitComputer implements IEarlyExitComputer {

	private PolymorphicDispatcher<Collection<ExitPoint>> dispatcher = PolymorphicDispatcher.createForSingleTarget("_exitPoints", this);
	
	public boolean isEarlyExit(XExpression expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression);
		if (isNotEmpty(exitPoints))
			return true;
		return false;
	}
	
	protected boolean isNotEmpty(Collection<ExitPoint> exitPoints) {
		return exitPoints != null && !exitPoints.isEmpty();
	}

	public Collection<ExitPoint> getExitPoints(XExpression expression) {
		if (expression == null)
			return Collections.emptyList();
		return dispatcher.invoke(expression);
	}
	
	/**
	 * @param expression unused in this context but required in dispatch signature 
	 */
	protected Collection<ExitPoint> _exitPoints(XExpression expression) {
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XReturnExpression expression) {
		return Collections.singletonList(new ExitPoint(expression, false));
	}
	
	protected Collection<ExitPoint> _exitPoints(XThrowExpression expression) {
		return Collections.singletonList(new ExitPoint(expression, true));
	}
	
	protected Collection<ExitPoint> _exitPoints(XBlockExpression expression) {
		for(XExpression child: expression.getExpressions()) {
			Collection<ExitPoint> exitPoints = getExitPoints(child);
			if (isNotEmpty(exitPoints))
				return exitPoints;
		}
		return Collections.emptyList();
	}

	protected Collection<ExitPoint> _exitPoints(XForLoopExpression expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression.getForExpression());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XWhileExpression expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression.getPredicate());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XDoWhileExpression expression) {
		Collection<ExitPoint> exitPoints = getExitPoints(expression.getBody());
		if (isNotEmpty(exitPoints))
			return exitPoints;
		return getExitPoints(expression.getPredicate());
	}
	
	protected Collection<ExitPoint> _exitPoints(XVariableDeclaration expression) {
		return getExitPoints(expression.getRight());
	}
	
	protected Collection<ExitPoint> _exitPoints(XIfExpression expression) {
		Collection<ExitPoint> ifExitPoints = getExitPoints(expression.getIf());
		if (isNotEmpty(ifExitPoints))
			return ifExitPoints;
		Collection<ExitPoint> thenExitPoints = getExitPoints(expression.getThen());
		Collection<ExitPoint> elseExitPoints = getExitPoints(expression.getElse());
		if (isNotEmpty(thenExitPoints) && isNotEmpty(elseExitPoints)) {
			Collection<ExitPoint> result = Lists.newArrayList(thenExitPoints);
			result.addAll(elseExitPoints);
			return result;
		}
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XSwitchExpression expression) {
		Collection<ExitPoint> switchExitPoints = getExitPoints(expression.getSwitch());
		if (isNotEmpty(switchExitPoints))
			return switchExitPoints;
		Collection<ExitPoint> result = Lists.newArrayList();
		for(XCasePart casePart: expression.getCases()) {
			// TODO do we have an early exit if the first case condition is an early exit?
			Collection<ExitPoint> caseExit = getExitPoints(casePart.getThen());
			if (!isNotEmpty(caseExit))
				return Collections.emptyList();
			else
				result.addAll(caseExit);
		}
		Collection<ExitPoint> defaultExit = getExitPoints(expression.getDefault());
		if (!isNotEmpty(defaultExit))
			return Collections.emptyList();
		else
			result.addAll(defaultExit);
		return result;
	}
	
	protected Collection<ExitPoint> _exitPoints(XAbstractFeatureCall expression) {
		for(XExpression argument: expression.getActualArguments()) {
			Collection<ExitPoint> argumentExitPoints = getExitPoints(argument);
			if (isNotEmpty(argumentExitPoints))
				return argumentExitPoints;
		}
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XConstructorCall expression) {
		for(XExpression argument: expression.getArguments()) {
			Collection<ExitPoint> argumentExitPoints = getExitPoints(argument);
			if (isNotEmpty(argumentExitPoints))
				return argumentExitPoints;
		}
		return Collections.emptyList();
	}
	
	protected Collection<ExitPoint> _exitPoints(XTryCatchFinallyExpression expression) {
		Collection<ExitPoint> tryExitPoints = getExitPoints(expression.getExpression());
		if (isNotEmpty(tryExitPoints)) {
			Collection<ExitPoint> result = Lists.newArrayList(tryExitPoints);
			// TODO validate tryExitPoints against catch clauses
			for(XCatchClause catchClause: expression.getCatchClauses()) {
				Collection<ExitPoint> catchExitPoints = getExitPoints(catchClause.getExpression());
				if (isNotEmpty(catchExitPoints)) {
					result.addAll(catchExitPoints);
				} else {
					Collection<ExitPoint> finallyExitPoints = getExitPoints(expression.getFinallyExpression());
					return finallyExitPoints;
				}
			}
			return result;
		} 
		Collection<ExitPoint> finallyExitPoints = getExitPoints(expression.getFinallyExpression());
		return finallyExitPoints;
	}
	
}
