/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Sets.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.typing.Closures;

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
			declareSyntheticVariable(expr, b);
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
			declareSyntheticVariable(expr, b);
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
		final EList<XCatchClause> catchClauses = expr.getCatchClauses();
		if (!catchClauses.isEmpty()) {
			String variable = b.declareSyntheticVariable(Tuples.pair(expr, "_catchedThrowable"), "_t");
			b.append(" catch (final Throwable ").append(variable).append(") ");
			b.append("{").increaseIndentation();
			b.append("\n");
			Iterator<XCatchClause> iterator = catchClauses.iterator();
			while (iterator.hasNext()) {
				XCatchClause catchClause = iterator.next();
				JvmTypeReference type = catchClause.getDeclaredParam().getParameterType();
				final String name = b.declareVariable(catchClause.getDeclaredParam(), catchClause.getDeclaredParam().getName());
				b.append("if (").append(variable).append(" instanceof ");
				b.append(type.getType());
				b.append(") ").append("{");
				b.increaseIndentation();
				b.append("\nfinal ");
				serialize(type,expr,b);
				b.append(" ").append(name).append(" = (");
				serialize(type,expr,b);
				b.append(")").append(variable).append(";");
				final boolean canBeReferenced = isReferenced && ! isPrimitiveVoid(catchClause.getExpression());
				internalToJavaStatement(catchClause.getExpression(), b, canBeReferenced);
				if (canBeReferenced) {
					b.append("\n").append(getVarName(expr, b)).append(" = ");
					internalToConvertedExpression(catchClause.getExpression(), b, null);
					b.append(";");
				}
				b.decreaseIndentation();
				b.append("\n}");
				if (iterator.hasNext()) {
					b.append(" else ");
				}
			}
			b.append(" else {");
			b.increaseIndentation();
			b.append("\nthrow ");
			b.append(getTypeReferences().findDeclaredType(Exceptions.class, expr));
			b.append(".sneakyThrow(");
			b.append(variable);
			b.append(");");
			b.decreaseIndentation();
			b.append("\n}");
			b.decreaseIndentation();
			b.append("\n}");
		}
		final XExpression finallyExp = expr.getFinallyExpression();
		if (finallyExp != null) {
			b.append(" finally {").increaseIndentation();
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
		b.append(" instanceof ").append(expr.getType()).append(")");
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
		b.append(b.declareVariable(varDeclaration, varDeclaration.getName()));
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
		final String varName = b.declareSyntheticVariable(expr, "_while");
		b.append("\nboolean ").append(varName).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.append("\nwhile (");
		b.append(varName);
		b.append(") {").increaseIndentation();
		b.openPseudoScope();
		internalToJavaStatement(expr.getBody(), b, false);
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.append("\n").append(varName).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.closeScope();
		b.decreaseIndentation().append("\n}");
	}

	protected void _toJavaExpression(XDoWhileExpression expr, IAppendable b) {
		b.append("null");
	}

	protected void _toJavaStatement(XDoWhileExpression expr, IAppendable b, boolean isReferenced) {
		String variable = b.declareSyntheticVariable(expr, "_dowhile");
		b.append("\nboolean ").append(variable).append(" = false;");
		b.append("\ndo {").increaseIndentation();
		internalToJavaStatement(expr.getBody(), b, false);
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.append("\n").append(variable).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.decreaseIndentation().append("\n} while(");
		b.append(variable);
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
		String varName = b.declareVariable(expr.getDeclaredParam(), expr.getDeclaredParam().getName());
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
				appendArguments(expr.getArguments(), expr.getConstructor(), expr, b, false);
				b.append(")");
			}
		};
		if (isReferenced) {
			declareSyntheticVariable(expr, b, later);
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
			declareSyntheticVariable(expr, b);
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
		String switchResultName = b.declareSyntheticVariable(Tuples.pair(expr,"result"), "_switchResult");
		if (isReferenced) {
			b.append("\n");
			serialize(type, expr, b);
			b.append(" ").append(switchResultName).append(" = ");
			b.append(getDefaultValueLiteral(expr));
			b.append(";");
		}
		
		internalToJavaStatement(expr.getSwitch(), b, true);

		// declare local var for the switch expression
		String variableName = null;
		if(expr.getLocalVarName() == null && expr.getSwitch() instanceof XFeatureCall) {
			variableName = b.getName(((XFeatureCall) expr.getSwitch()).getFeature());
		} 
		if(variableName == null) {
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
			variableName = b.declareSyntheticVariable(expr, name);
			b.append(variableName);
			b.append(" = ");
			internalToJavaExpression(expr.getSwitch(), b);
			b.append(";");
		}
		// declare 'boolean matched' to check whether a case has matched already
		b.append("\nboolean ");
		String matchedVariable = b.declareSyntheticVariable(Tuples.pair(expr, "matches"), "matched");
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
				JvmIdentifiableElement switchOver = expr.getSwitch() instanceof XFeatureCall ? ((XFeatureCall)expr.getSwitch()).getFeature() : expr;
				b.openPseudoScope();
				final String proposedName = "_"+Strings.toFirstLower(casePart.getTypeGuard().getType().getSimpleName());
				final String castedVariableName = b.declareSyntheticVariable(switchOver, proposedName);
				b.append("\nfinal ");
				serialize(casePart.getTypeGuard(), expr, b);
				b.append(" ");
				b.append(castedVariableName);
				b.append(" = (");
				serialize(casePart.getTypeGuard(), expr, b);
				b.append(")");
				b.append(variableName);
				b.append(";");
			}
			if (casePart.getCase() != null) {
				internalToJavaStatement(casePart.getCase(), b, true);
				b.append("\nif (");
				JvmTypeReference convertedType = getTypeProvider().getType(casePart.getCase());
				if (getTypeReferences().is(convertedType, Boolean.TYPE) || getTypeReferences().is(convertedType, Boolean.class)) {
					internalToJavaExpression(casePart.getCase(), b);
				} else {
					JvmTypeReference typeRef = getTypeReferences().getTypeForName(ObjectExtensions.class, expr);
					serialize(typeRef, casePart, b);
					b.append(".operator_equals(").append(variableName).append(",");
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
				b.closeScope();
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
	private Closures closures;
	
	@Inject
	private TypeArgumentContextProvider ctxProvider;
	
	protected void _toJavaStatement(final XClosure closure, final IAppendable b, boolean isReferenced) {
		if (!isReferenced)
			throw new IllegalArgumentException("a closure definition does not cause any side-effects");
		JvmTypeReference type = getTypeProvider().getType(closure);
		ITypeArgumentContext context = ctxProvider.getTypeArgumentContext(new TypeArgumentContextProvider.ReceiverRequest(type));
		b.append("\n").append("final ");
		serialize(type, closure, b);
		b.append(" ");
		String variableName = b.declareSyntheticVariable(closure, "_function");
		b.append(variableName).append(" = ");
		b.append("new ");
		// TODO parameters in type arguments are safe to be a wildcard
		serialize(type, closure, b, false, false, true, false);
		b.append("() {");
		b.increaseIndentation().increaseIndentation();
		try {
			b.openScope();
			JvmOperation operation = closures.findImplementingOperation(type, closure.eResource());
			final JvmTypeReference returnType = context.resolve(operation.getReturnType());
			b.append("\npublic ");
			serialize(returnType, closure, b, false, false, true, true);
			b.append(" ").append(operation.getSimpleName());
			b.append("(");
			List<JvmFormalParameter> closureParams = closure.getFormalParameters();
			List<JvmFormalParameter> operationParams = operation.getParameters();
			for (int i = 0; i < closureParams.size(); i++) {
				JvmFormalParameter closureParam = closureParams.get(i);
				JvmFormalParameter operationParam = operationParams.get(i);
				JvmTypeReference parameterType = context.resolve(operationParam.getParameterType());
				b.append("final ");
				serialize(parameterType, closure, b, false, false, true, true);
				b.append(" ");
				String name = b.declareVariable(closureParam, closureParam.getName());
				b.append(name);
				if (i != closureParams.size() - 1)
					b.append(", ");
			}
			b.append(") {");
			b.increaseIndentation();
			Object element = b.getObject("this");
			if (element instanceof JvmType) {
				final String proposedName = ((JvmType) element).getSimpleName()+".this";
				if (b.getObject(proposedName) == null) {
					b.declareSyntheticVariable(element, proposedName);
					Object superElement = b.getObject("super");
					if (superElement instanceof JvmType) {
						b.declareSyntheticVariable(superElement, ((JvmType) element).getSimpleName()+".super");
					}
				}
			}
			compile(closure.getExpression(), b, operation.getReturnType(), newHashSet(operation.getExceptions()));
		} finally {
			b.closeScope();
		}
		b.decreaseIndentation();
		b.append("\n}");
		b.decreaseIndentation().append("\n};").decreaseIndentation();
	}
	
	protected void _toJavaExpression(final XClosure call, final IAppendable b) {
		b.append(getVarName(call, b));
	}
	
}
