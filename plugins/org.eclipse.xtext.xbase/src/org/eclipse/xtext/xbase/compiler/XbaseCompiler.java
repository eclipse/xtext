/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.typing.FunctionConversion;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseCompiler extends FeatureCallCompiler {
	
	protected void _toJavaStatement(XBlockExpression expr, IAppendable b, boolean isReferenced) {
		if (expr.getExpressions().isEmpty())
			return;
		if (expr.getExpressions().size()==1) {
			internalToJavaStatement(expr.getExpressions().get(0), b, isReferenced);
			return;
		}
		if (isReferenced)
			declareLocalVariable(expr, b);
		b.append("\n{").increaseIndentation();
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			if (i < expressions.size() - 1) {
				internalToJavaStatement(ex, b, false);
			} else {
				internalToJavaStatement(ex, b, isReferenced);
				if (isReferenced) {
					b.append("\n").append(getVarName(expr, b)).append(" = (");
					internalToConvertedExpression(ex, b, null);
					b.append(");");
				}
			}
		}
		b.decreaseIndentation().append("\n}");
	}

	protected void _toJavaExpression(XBlockExpression expr, IAppendable b) {
		if (expr.getExpressions().isEmpty()) {
			b.append("null");
			return;
		}
		if (expr.getExpressions().size()==1) {
			internalToConvertedExpression(expr.getExpressions().get(0), b, null);
			return;
		}
		b.append(getVarName(expr, b));
	}

	protected void _toJavaStatement(XTryCatchFinallyExpression expr, IAppendable b, boolean isReferenced) {
		if (isReferenced && !isPrimitiveVoid(expr)) {
			declareLocalVariable(expr, b);
		}
		b.append("\ntry {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getExpression());
		internalToJavaStatement(expr.getExpression(), b, canBeReferenced);
		if (canBeReferenced) {
			b.append("\n").append(getVarName(expr, b)).append(" = ");
			internalToConvertedExpression(expr.getExpression(), b, null);
			b.append(";");
		}
		b.decreaseIndentation().append("\n}");
		appendCatchAndFinally(expr, b, isReferenced);
	}

	protected void appendCatchAndFinally(XTryCatchFinallyExpression expr, IAppendable b, boolean isReferenced) {
		for (XCatchClause catchClause : expr.getCatchClauses()) {
			JvmTypeReference type = catchClause.getDeclaredParam().getParameterType();
			final String name = declareNameInVariableScope(catchClause.getDeclaredParam(), b);
			b.append(" catch (");
			serialize(type,expr,b);
			b.append(" ").append(name).append(") { ");
			b.increaseIndentation();
			final boolean canBeReferenced = isReferenced && ! isPrimitiveVoid(catchClause.getExpression());
			internalToJavaStatement(catchClause.getExpression(), b, canBeReferenced);
			if (canBeReferenced) {
				b.append("\n").append(getVarName(expr, b)).append(" = ");
				internalToConvertedExpression(catchClause.getExpression(), b, null);
				b.append(";");
			}
			b.decreaseIndentation();
			b.append("\n}");
		}
		final XExpression finallyExp = expr.getFinallyExpression();
		if (finallyExp != null) {
			b.append(" finally ");
			b.append("{").increaseIndentation();
			internalToJavaStatement(finallyExp, b, false);
			b.decreaseIndentation().append("\n}");
		}
	}

	protected void _toJavaExpression(XTryCatchFinallyExpression expr, IAppendable b) {
		b.append(getVarName(expr, b));
	}

	protected void _toJavaStatement(XThrowExpression expr, IAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getExpression(), b, true);
		b.append("\nthrow ");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(";");
	}

	protected void _toJavaExpression(XThrowExpression expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaExpression(XInstanceOfExpression expr, IAppendable b) {
		b.append("(");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(" instanceof ").append(expr.getType().getQualifiedName('.')).append(")");
	}

	protected void _toJavaStatement(XInstanceOfExpression expr, IAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getExpression(), b, true);
	}

	protected void _toJavaExpression(XVariableDeclaration expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaStatement(XVariableDeclaration varDeclaration, IAppendable b, boolean isReferenced) {
		if (varDeclaration.getRight() != null) {
			internalToJavaStatement(varDeclaration.getRight(), b, true);
		}
		b.append("\n");
		if (!varDeclaration.isWriteable()) {
			b.append("final ");
		}
		JvmTypeReference type = null;
		if (varDeclaration.getType() != null) {
			type = varDeclaration.getType();
		} else {
			type = getTypeProvider().getType(varDeclaration.getRight());
		}
		serialize(type, varDeclaration, b);
		b.append(" ");
		b.append(declareNameInVariableScope(varDeclaration, b));
		b.append(" = ");
		if (varDeclaration.getRight() != null) {
			internalToConvertedExpression(varDeclaration.getRight(), b, type);
		} else {
			if (getPrimitives().isPrimitive(type)) {
				Primitive primitiveKind = getPrimitives().primitiveKind((JvmPrimitiveType) type.getType());
				switch (primitiveKind) {
					case Boolean:
						b.append("false");
						break;
					default:
						b.append("0");
						break;
				}
			} else {
				b.append("null");
			}
		}
		b.append(";");
	}

	protected void _toJavaExpression(XWhileExpression expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaStatement(XWhileExpression expr, IAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.append("\nBoolean ").append(declareNameInVariableScope(expr, b)).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.append("\nwhile (");
		b.append(getVarName(expr, b));
		b.append(") {").increaseIndentation();
		internalToJavaStatement(expr.getBody(), b, false);
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.append("\n").append(getVarName(expr, b)).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.decreaseIndentation().append("\n}");
	}

	protected void _toJavaExpression(XDoWhileExpression expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaStatement(XDoWhileExpression expr, IAppendable b, boolean isReferenced) {
		b.append("\nBoolean ").append(declareNameInVariableScope(expr, b)).append(";");
		b.append("\ndo {");
		internalToJavaStatement(expr.getBody(), b, false);
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.append("\n").append(getVarName(expr, b)).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.append("\n} while(");
		b.append(getVarName(expr, b));
		b.append(");");
	}

	protected void _toJavaExpression(XForLoopExpression expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaStatement(XForLoopExpression expr, IAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getForExpression(), b, true);
		b.append("\nfor (final ");
		JvmTypeReference paramType = getTypeProvider().getTypeForIdentifiable(expr.getDeclaredParam());
		serialize(paramType,expr,b);
		b.append(" ");
		String varName = declareNameInVariableScope(expr.getDeclaredParam(), b);
		b.append(varName);
		b.append(" : ");
		internalToJavaExpression(expr.getForExpression(), b);
		b.append(") {").increaseIndentation();
		internalToJavaStatement(expr.getEachExpression(), b, false);
		b.decreaseIndentation().append("\n}");
	}

	protected void _toJavaStatement(final XConstructorCall expr, final IAppendable b, final boolean isReferenced) {
		for (XExpression arg : expr.getArguments()) {
			internalToJavaStatement(arg, b, true);
		}
		
		Later later = new Later() {
			@Override
			public void exec() {
				b.append("new ");
				JvmTypeReference producedType = getTypeProvider().getType(expr);
				serialize(producedType, expr, b, false, false, true, false);
				b.append("(");
				appendArguments(expr.getArguments(), expr.getConstructor(), expr, b);
				b.append(")");
			}
		};
		if (isReferenced) {
			declareLocalVariable(expr, b, later);
		} else {
			b.append("\n");
			later.exec();
			b.append(";");
		}
	}

	protected void _toJavaExpression(XConstructorCall expr, IAppendable b) {
		String varName = getVarName(expr, b);
		b.append(varName);
	}
	
	protected void _toJavaStatement(XReturnExpression expr, IAppendable b, boolean isReferenced) {
		if (expr.getExpression()!=null) {
			internalToJavaStatement(expr.getExpression(), b, true);
			b.append("\nreturn ");
			internalToJavaExpression(expr.getExpression(), b);
			b.append(";");
		} else {
			b.append("\nreturn;");
		}
	}
	
	protected void _toJavaExpression(XReturnExpression expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaExpression(XCastedExpression expr, IAppendable b) {
		b.append("((");
		serialize(expr.getType(), expr, b);
		b.append(") ");
		internalToConvertedExpression(expr.getTarget(), b, expr.getType());
		b.append(")");
	}

	protected void _toJavaStatement(XCastedExpression expr, IAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getTarget(), b, isReferenced);
	}

	protected void _toJavaStatement(XIfExpression expr, IAppendable b, boolean isReferenced) {
		if (isReferenced)
			declareLocalVariable(expr, b);
		internalToJavaStatement(expr.getIf(), b, true);
		b.append("\nif (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getThen());
		internalToJavaStatement(expr.getThen(), b, canBeReferenced);
		if (canBeReferenced) {
			b.append("\n");
			b.append(getVarName(expr, b));
			b.append(" = ");
			internalToConvertedExpression(expr.getThen(), b, null);
			b.append(";");
		}
		b.decreaseIndentation().append("\n}");
		if (expr.getElse() != null) {
			b.append(" else {").increaseIndentation();
			final boolean canElseBeReferenced = isReferenced && !isPrimitiveVoid(expr.getElse());
			internalToJavaStatement(expr.getElse(), b, canElseBeReferenced);
			if (canElseBeReferenced) {
				b.append("\n");
				b.append(getVarName(expr, b));
				b.append(" = ");
				internalToConvertedExpression(expr.getElse(), b, null);
				b.append(";");
			}
			b.decreaseIndentation().append("\n}");
		}
	}

	protected void _toJavaExpression(XIfExpression expr, IAppendable b) {
		b.append(getVarName(expr, b));
	}

	protected void _toJavaStatement(XSwitchExpression expr, IAppendable b, boolean isReferenced) {
		// declare variable
		JvmTypeReference type = getTypeProvider().getType(expr);
		String switchResultName = b.declareVariable(Tuples.pair(expr,"result"), "_switchResult");
		if (isReferenced) {
			b.append("\n");
			serialize(type, expr, b);
			b.append(" ").append(switchResultName).append(" = ");
			b.append(getDefaultValueLiteral(expr));
			b.append(";");
		}
		
		internalToJavaStatement(expr.getSwitch(), b, true);

		// declare local var for the switch expression
		String name = getNameProvider().getSimpleName(expr);
		if (name!=null) { 
			name = makeJavaIdentifier(name);
		} else {
			// define synthetic name
			name = "__valOfSwitchOver";
		}
		JvmTypeReference typeReference = getTypeProvider().getType(expr.getSwitch());
		b.append("\nfinal ");
		serialize(typeReference, expr, b);
		b.append(" ");
		String variableName = b.declareVariable(expr, name);
		b.append(variableName);
		b.append(" = ");
		internalToJavaExpression(expr.getSwitch(), b);
		b.append(";");

		// declare 'boolean matched' to check whether a case has matched already
		b.append("\nboolean ");
		String matchedVariable = b.declareVariable(Tuples.pair(expr, "matches"), "matched");
		b.append(matchedVariable).append(" = false;");

		for (XCasePart casePart : expr.getCases()) {
			b.append("\nif (!").append(matchedVariable).append(") {");
			b.increaseIndentation();
			if (casePart.getTypeGuard() != null) {
				b.append("\nif (");
				b.append(variableName);
				b.append(" instanceof ");
				b.append(casePart.getTypeGuard().getType());
				b.append(") {");
				b.increaseIndentation();

				// declare local var for case
				String simpleName = getNameProvider().getSimpleName(casePart);
				if (simpleName != null) {
					b.append("\nfinal ");
					serialize(casePart.getTypeGuard(),casePart,b);
					b.append(" ");
					String typeGuardName = b.declareVariable(casePart, simpleName);
					b.append(typeGuardName);
					b.append(" = (");
					serialize(casePart.getTypeGuard(),casePart,b);
					b.append(") ").append(variableName).append(";");
				}
			}
			if (casePart.getCase() != null) {
				internalToJavaStatement(casePart.getCase(), b, true);
				b.append("\nif (");
				JvmTypeReference convertedType = getTypeProvider().getType(casePart.getCase());
				if (getTypeReferences().is(convertedType, Boolean.TYPE) || getTypeReferences().is(convertedType, Boolean.class)) {
					internalToJavaExpression(casePart.getCase(), b);
				} else {
					b.append(ObjectExtensions.class.getCanonicalName()).append(".operator_equals(").append(variableName).append(",");
					internalToJavaExpression(casePart.getCase(), b);
					b.append(")");
				}
				b.append(") {");
				b.increaseIndentation();
			}
			// set matched to true
			b.append("\n").append(matchedVariable).append("=true;");

			// execute then part
			final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(casePart.getThen());
			internalToJavaStatement(casePart.getThen(), b, canBeReferenced);
			if (canBeReferenced) {
				b.append("\n").append(switchResultName).append(" = ");
				internalToConvertedExpression(casePart.getThen(), b, null);
				b.append(";");
			}

			// close surrounding if statements
			if (casePart.getCase() != null) {
				b.decreaseIndentation().append("\n}");
			}
			if (casePart.getTypeGuard() != null) {
				b.decreaseIndentation().append("\n}");
			}
			b.decreaseIndentation();
			b.append("\n}");
		}
		if (expr.getDefault()!=null) {
			b.append("\nif (!").append(matchedVariable).append(") {");
			b.increaseIndentation();
			final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getDefault());
			internalToJavaStatement(expr.getDefault(), b, canBeReferenced);
			if (canBeReferenced) {
				b.append("\n").append(switchResultName).append(" = ");
				internalToConvertedExpression(expr.getDefault(), b, null);
				b.append(";");
			}
			b.decreaseIndentation();
			b.append("\n}");
		}
	}

	protected void _toJavaExpression(XSwitchExpression expr, IAppendable b) {
		b.append(getVarName(Tuples.pair(expr,"result"), b));
	}

	@Inject
	private FunctionConversion functionConversion;
	
	@Inject
	private TypeArgumentContextProvider ctxProvider;
	
	protected void _toJavaStatement(final XClosure closure, final IAppendable b, boolean isReferenced) {
		if (!isReferenced)
			throw new IllegalArgumentException("a closure definition does not cause any sideffeccts");
		JvmTypeReference type = getTypeProvider().getType(closure);
		TypeArgumentContext context = ctxProvider.getReceiverContext(type);
		b.append("\n").append("final ");
		serialize(type, closure, b);
		b.append(" ");
		String variableName = b.declareVariable(closure, "_function");
		b.append(variableName).append(" = ");
		b.append("new ");
		serialize(type, closure, b);
		b.append("() {");
		b.increaseIndentation().increaseIndentation();
		JvmOperation operation = functionConversion.findSingleMethod(type);
		final JvmTypeReference returnType = context.resolve(operation.getReturnType());
		b.append("\npublic ");
		serialize(returnType, closure, b);
		b.append(" ").append(operation.getSimpleName());
		b.append("(");
		EList<JvmFormalParameter> closureParams = closure.getFormalParameters();
		for (Iterator<JvmFormalParameter> iter = closureParams.iterator(); iter.hasNext();) {
			JvmFormalParameter param = iter.next();
			final JvmTypeReference parameterType2 = getTypeProvider().getTypeForIdentifiable(param);
			final JvmTypeReference parameterType = context.resolve(parameterType2);
			b.append("final ");
			serialize(parameterType, closure, b);
			b.append(" ");
			String name = declareNameInVariableScope(param, b);
			b.append(name);
			if (iter.hasNext())
				b.append(" , ");
		}
		b.append(") {");
		b.increaseIndentation();
		compile(closure.getExpression(), b, operation.getReturnType());
		b.decreaseIndentation();
		b.append("\n}");
		b.decreaseIndentation().append("\n};").decreaseIndentation();
	}
	
	protected void _toJavaExpression(final XClosure call, final IAppendable b) {
		b.append(getVarName(call, b));
	}

}
