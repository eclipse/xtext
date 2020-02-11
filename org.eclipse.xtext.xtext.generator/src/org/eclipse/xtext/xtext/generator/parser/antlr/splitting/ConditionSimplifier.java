/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.BooleanLiteral;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Expression;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.MethodCall;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NotExpression;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NumberLiteral;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsFactory;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.util.SimpleExpressionsSwitch;

public class ConditionSimplifier extends SimpleExpressionsSwitch<Expression>{

	public void simplify(IfCondition condition) {
		Expression expression = simplifyRecursive(condition.getCondition());
		condition.setCondition(expression);
	}

	public Expression simplifyRecursive(Expression expression) {
		return doSwitch(expression);
	}

	@Override
	public Expression caseAndExpression(AndExpression object) {
		if (object.getRight() == null)
			return doSwitch(object.getLeft());
		if (object.getLeft() == null)
			return doSwitch(object.getRight());
		Expression left = doSwitch(object.getLeft());
		Expression right = doSwitch(object.getRight());
		if (areSemanticallyEqual(left, right))
			return left;
		if (left instanceof BooleanLiteral) {
			if (((BooleanLiteral) left).isValue()) {
				return right;
			}
			return left;
		}
		if (right instanceof BooleanLiteral) {
			if (((BooleanLiteral) right).isValue()) {
				return left;
			}
			return right;
		}
		if (left instanceof NotExpression) {
			if (areSemanticallyEqual(((NotExpression) left).getExpression(), right)) {
				BooleanLiteral result = SimpleExpressionsFactory.eINSTANCE.createBooleanLiteral();
				result.setValue(false);
				return result;
			}
		} else if (right instanceof NotExpression) {
			if (areSemanticallyEqual(left, ((NotExpression) right).getExpression())) {
				BooleanLiteral result = SimpleExpressionsFactory.eINSTANCE.createBooleanLiteral();
				result.setValue(false);
				return result;
			}
		}
		object.setLeft(left);
		object.setRight(right);
		return object;
	}

	@Override
	public Expression caseOrExpression(OrExpression object) {
		if (object.getRight() == null)
			return doSwitch(object.getLeft());
		if (object.getLeft() == null)
			return doSwitch(object.getRight());
		Expression left = doSwitch(object.getLeft());
		Expression right = doSwitch(object.getRight());
		if (areSemanticallyEqual(left, right))
			return left;
		if (left instanceof BooleanLiteral) {
			if (((BooleanLiteral) left).isValue()) {
				return left;
			}
			return right;
		}
		if (right instanceof BooleanLiteral) {
			if (((BooleanLiteral) right).isValue()) {
				return right;
			}
			return left;
		}
		if (left instanceof AndExpression) {
			AndExpression leftAsAnd = (AndExpression) left;
			if (areSemanticallyEqual(leftAsAnd.getLeft(), right)
				|| areSemanticallyEqual(leftAsAnd.getRight(), right))
				return right;
		} else if (right instanceof AndExpression) {
			AndExpression rightAsAnd = (AndExpression) right;
			if (areSemanticallyEqual(rightAsAnd.getLeft(), left)
				|| areSemanticallyEqual(rightAsAnd.getRight(), left))
				return left;
		}
		if (left instanceof OrExpression) {
			OrExpression leftAsOr = (OrExpression) left;
			if (areSemanticallyEqual(leftAsOr.getLeft(), right)
				|| areSemanticallyEqual(leftAsOr.getRight(), right))
				return left;
		} else if (right instanceof OrExpression) {
			OrExpression rightAsOr = (OrExpression) right;
			if (areSemanticallyEqual(rightAsOr.getLeft(), left)
				|| areSemanticallyEqual(rightAsOr.getRight(), left))
				return right;
		}
		if (left instanceof NotExpression) {
			if (areSemanticallyEqual(((NotExpression) left).getExpression(), right)) {
				BooleanLiteral result = SimpleExpressionsFactory.eINSTANCE.createBooleanLiteral();
				result.setValue(true);
				return result;
			}
		} else if (right instanceof NotExpression) {
			if (areSemanticallyEqual(left, ((NotExpression) right).getExpression())) {
				BooleanLiteral result = SimpleExpressionsFactory.eINSTANCE.createBooleanLiteral();
				result.setValue(true);
				return result;
			}
		}
		object.setLeft(left);
		object.setRight(right);
		return object;
	}

	@Override
	public Expression caseNotExpression(NotExpression object) {
		if (object.getExpression() instanceof NotExpression)
			return doSwitch(((NotExpression) object.getExpression()).getExpression());
		Expression result = doSwitch(object.getExpression());
		if (result instanceof BooleanLiteral) {
			BooleanLiteral casted = (BooleanLiteral) result;
			casted.setValue(!casted.isValue());
			return casted;
		} else {
			object.setExpression(result);
			return object;
		}
	}

	@Override
	public Expression caseExpression(Expression object) {
		return object;
	}

	public boolean areSemanticallyEqual(Expression left, Expression right) {
		if (left.eClass() != right.eClass())
			return false;
		if (left instanceof OrExpression) {
			OrExpression leftOrExpression = (OrExpression) left;
			OrExpression rightOrExpression = (OrExpression) right;
			return (areSemanticallyEqual(leftOrExpression.getLeft(), rightOrExpression.getLeft())
				&& areSemanticallyEqual(leftOrExpression.getRight(), rightOrExpression.getRight()))
				|| (areSemanticallyEqual(leftOrExpression.getRight(), rightOrExpression.getLeft())
				&& areSemanticallyEqual(leftOrExpression.getLeft(), rightOrExpression.getRight()));
		}
		if (left instanceof AndExpression) {
			AndExpression leftAndExpression = (AndExpression) left;
			AndExpression rightAndExpression = (AndExpression) right;
			return (areSemanticallyEqual(leftAndExpression.getLeft(), rightAndExpression.getLeft())
				&& areSemanticallyEqual(leftAndExpression.getRight(), rightAndExpression.getRight()))
				|| (areSemanticallyEqual(leftAndExpression.getRight(), rightAndExpression.getLeft())
				&& areSemanticallyEqual(leftAndExpression.getLeft(), rightAndExpression.getRight()));
		}
		if (left instanceof NotExpression) {
			return areSemanticallyEqual(((NotExpression) left).getExpression(), ((NotExpression) right).getExpression());
		}
		if (left instanceof Comparison) {
			Comparison leftComparison = (Comparison) left;
			Comparison rightComparison = (Comparison) right;
			return ((Comparison) left).getOperator().equals(rightComparison.getOperator())
				&& areSemanticallyEqual(leftComparison.getLeft(), rightComparison.getLeft())
				&& areSemanticallyEqual(leftComparison.getRight(), rightComparison.getRight());
		}
		if (left instanceof NumberLiteral) {
			int leftValue = ((NumberLiteral) left).getValue();
			int rightValue = ((NumberLiteral) right).getValue();
			return leftValue == rightValue;
		}
		if (left instanceof MethodCall) {
			String leftMethod = ((MethodCall) left).getValue();
			String rightMethod = ((MethodCall) right).getValue();
			return leftMethod.equals(rightMethod);
		}
		throw new IllegalStateException(left + " - " + right);
	}

}
