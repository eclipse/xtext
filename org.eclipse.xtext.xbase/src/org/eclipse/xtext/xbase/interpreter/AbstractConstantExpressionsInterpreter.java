/**
 * Copyright (c) 2014, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public abstract class AbstractConstantExpressionsInterpreter {
	@Inject
	private ConstantOperators constantOperators;

	@Inject
	private OperatorMapping operatorMapping;

	protected Object evaluate(XExpression expression, Context ctx) {
		if (ctx.getAlreadyEvaluating().add(expression)) {
			try {
				return internalEvaluate(expression, ctx);
			} finally {
				ctx.getAlreadyEvaluating().remove(expression);
			}
		} else {
			throw notConstantExpression(expression);
		}
	}

	protected Object _internalEvaluate(XExpression expression, Context ctx) {
		throw notConstantExpression(expression);
	}

	protected Object _internalEvaluate(Void nullValue, Context ctx) {
		throw notConstantExpression(null);
	}

	public ConstantExpressionEvaluationException notConstantExpression(XExpression expression) {
		String text = null;
		if (expression != null) {
			text = toText(expression);
		}
		return new ConstantExpressionEvaluationException("Not a constant expression : '" + text + "'", expression);
	}

	protected Object _internalEvaluate(XCastedExpression expression, Context ctx) {
		return evaluate(expression.getTarget(), ctx);
	}

	protected Object _internalEvaluate(XStringLiteral it, Context ctx) {
		return it.getValue();
	}

	protected Object _internalEvaluate(XBooleanLiteral it, Context ctx) {
		return it.isIsTrue();
	}

	protected Object _internalEvaluate(XAnnotation literal, Context ctx) {
		return literal;
	}

	protected Object _internalEvaluate(XTypeLiteral it, Context ctx) {
		return toTypeReference(it.getType(), it.getArrayDimensions().size());
	}

	protected JvmTypeReference toTypeReference(JvmType type, int arrayDimensions) {
		if (type == null) {
			return null;
		}
		JvmTypeReference resultTypeRef = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		((JvmParameterizedTypeReference) resultTypeRef).setType(type);
		for (int i = 0; i < arrayDimensions; i++) {
			JvmGenericArrayTypeReference arrayRef = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference();
			arrayRef.setComponentType(resultTypeRef);
			resultTypeRef = arrayRef;
		}
		return resultTypeRef;
	}

	protected Object _internalEvaluate(XBinaryOperation it, Context ctx) {
		Context context = ctx.cloneWithExpectation(null);
		Object left = evaluate(it.getLeftOperand(), context);
		Object right = evaluate(it.getRightOperand(), context);
		return evaluateBinaryOperation(it, left, right);
	}

	protected Object evaluateBinaryOperation(XBinaryOperation binaryOperation, Object left, Object right) {
		String op = getOperator(binaryOperation);
		if (op != null) {
			switch (op) {
			case "+":
				return constantOperators.plus(left, right);
			case "-":
				return constantOperators.minus(left, right);
			case "*":
				return constantOperators.multiply(left, right);
			case "/":
				return constantOperators.divide(left, right);
			case "%":
				return constantOperators.modulo(left, right);
			case "&&":
				return constantOperators.and(left, right);
			case "||":
				return constantOperators.or(left, right);
			case "<<":
				return constantOperators.shiftLeft(left, right);
			case ">>":
				return constantOperators.shiftRight(left, right);
			case ">>>":
				return constantOperators.shiftRightUnsigned(left, right);
			case "<":
				return constantOperators.lessThan(left, right);
			case ">":
				return constantOperators.greaterThan(left, right);
			case "<=":
				return constantOperators.lessEquals(left, right);
			case ">=":
				return constantOperators.greaterEquals(left, right);
			case "==":
			case "===":
				return constantOperators.same(left, right);
			case "!=":
			case "!==":
				return constantOperators.notSame(left, right);
			default:
				throw new ConstantExpressionEvaluationException(
						"Couldn't evaluate binary operator '" + op + "' on values " + left + " and " + right);
			}
		} else {
			throw new ConstantExpressionEvaluationException(
					"Couldn't evaluate binary operator '" + op + "' on values " + left + " and " + right);
		}
	}

	protected Object _internalEvaluate(XUnaryOperation it, Context ctx) {
		Object value = evaluate(it.getOperand(), ctx);
		String op = getOperator(it);
		if ("-".equals(op)) {
			return constantOperators.minus(value);
		} else if ("!".equals(op) && value instanceof Boolean) {
			return !((Boolean) value).booleanValue();
		} else if ("+".equals(op) && value instanceof Number) {
			return value;
		} else {
			throw new ConstantExpressionEvaluationException(
					"Couldn't evaluate unary operator '" + op + "' on value " + value);
		}
	}

	protected String getOperator(XAbstractFeatureCall call) {
		Resource res = call.eResource();
		if (res instanceof StorageAwareResource) {
			if (((StorageAwareResource) res).isLoadedFromStorage()) {
				QualifiedName operator = operatorMapping
						.getOperator(QualifiedName.create(call.getFeature().getSimpleName()));
				if (operator != null) {
					return operator.toString();
				}
				return null;
			}
		}
		return call.getConcreteSyntaxFeatureName();
	}

	protected String toText(XExpression expression) {
		return NodeModelUtils.getNode(expression).getText();
	}

	public Object internalEvaluate(XExpression it, Context ctx) {
		if (it instanceof XBinaryOperation) {
			return _internalEvaluate((XBinaryOperation) it, ctx);
		} else if (it instanceof XUnaryOperation) {
			return _internalEvaluate((XUnaryOperation) it, ctx);
		} else if (it instanceof XBooleanLiteral) {
			return _internalEvaluate((XBooleanLiteral) it, ctx);
		} else if (it instanceof XCastedExpression) {
			return _internalEvaluate((XCastedExpression) it, ctx);
		} else if (it instanceof XStringLiteral) {
			return _internalEvaluate((XStringLiteral) it, ctx);
		} else if (it instanceof XTypeLiteral) {
			return _internalEvaluate((XTypeLiteral) it, ctx);
		} else if (it instanceof XAnnotation) {
			return _internalEvaluate((XAnnotation) it, ctx);
		} else if (it != null) {
			return _internalEvaluate(it, ctx);
		} else {
			return _internalEvaluate((Void) null, ctx);
		}
	}

	protected ConstantOperators getConstantOperators() {
		return constantOperators;
	}
}
