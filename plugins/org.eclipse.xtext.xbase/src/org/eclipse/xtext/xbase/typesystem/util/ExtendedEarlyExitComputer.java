/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtendedEarlyExitComputer {
	
	// TODO discuss / improve
	/**
	 * Returns <code>true</code> for expressions that seem to be early exit expressions, e.g.
	 * <pre>
	 *   while(condition) {
	 *     if (anotherCondition)
	 *       return value
	 *     changeResultOfFirstCondition
	 *   }
	 * </pre>
	 */
	public boolean isIntentionalEarlyExit(@Nullable XExpression expression) {
		if (expression == null) {
			return true;
		}
		if (expression instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) expression;
			List<XExpression> children = block.getExpressions();
			for(XExpression child: children) {
				if (isIntentionalEarlyExit(child)) {
					return true;
				}
			}
		} else if (expression instanceof XIfExpression) {
			return isIntentionalEarlyExit(((XIfExpression) expression).getThen()) && isIntentionalEarlyExit(((XIfExpression) expression).getElse());
		} else if (expression instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryCatchFinally = (XTryCatchFinallyExpression) expression;
			if (isIntentionalEarlyExit(tryCatchFinally.getExpression())) {
				for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
					if (!isIntentionalEarlyExit(catchClause.getExpression()))
						return false;
				}
				return true;
			}
			return false;
		} else if (expression instanceof XAbstractWhileExpression) {
			return isIntentionalEarlyExit(((XAbstractWhileExpression) expression).getBody());
		} else if (expression instanceof XForLoopExpression) {
			return isIntentionalEarlyExit(((XForLoopExpression) expression).getEachExpression());
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}

	public boolean isDefiniteEarlyExit(XExpression expression) {
		// TODO further improvements
		if (expression instanceof XIfExpression) {
			XIfExpression ifExpression = (XIfExpression) expression;
			return isDefiniteEarlyExit(ifExpression.getThen()) && isDefiniteEarlyExit(ifExpression.getElse());
		} else if (expression instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) expression;
			if (isDefiniteEarlyExit(switchExpression.getDefault())) {
				for(XCasePart caseExpression: switchExpression.getCases()) {
					if (!isDefiniteEarlyExit(caseExpression.getThen())) {
						return false;
					}
				}
				return true;
			}
			return false;
		} else if (expression instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryExpression = (XTryCatchFinallyExpression) expression;
			if (isDefiniteEarlyExit(tryExpression.getFinallyExpression())) {
				return true;
			}
			if (isDefiniteEarlyExit(tryExpression.getExpression())) {
				for(XCatchClause catchClause: tryExpression.getCatchClauses()) {
					if (!isDefiniteEarlyExit(catchClause.getExpression())) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}
	
}
