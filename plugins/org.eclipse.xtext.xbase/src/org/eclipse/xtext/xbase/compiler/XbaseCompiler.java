/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseCompiler extends FeatureCallCompiler {
	protected void openBlock(XExpression xExpression, IAppendable b) {
		if (xExpression instanceof XBlockExpression) {
			return;
		}
		b.append("{").increaseIndentation();
	}

	protected void closeBlock(XExpression xExpression, IAppendable b) {
		if (xExpression instanceof XBlockExpression) {
			return;
		}
		b.decreaseIndentation().append("\n}");
	}
	
	public void _prepare(XBlockExpression expr, IAppendable b) {
		declareLocalVariable(expr, b);
		b.append("\n{").increaseIndentation();
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			if (i < expressions.size() - 1) {
				internalToJavaStatement(ex, b);
			} else {
				internalPrepare(ex, b);
				b.append("\n").append(getVarName(expr)).append(" = (");
				internalToJavaExpression(ex, b);
				b.append(");");
			}
		}
		b.decreaseIndentation().append("\n}");
	}

	public void _toJavaExpression(XBlockExpression expr, IAppendable b) {
		b.append(getVarName(expr));
	}
	
	public void _toJavaStatement(XBlockExpression expr, IAppendable b) {
		b.append("\n{").increaseIndentation();
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			internalToJavaStatement(ex, b);
		}
		b.decreaseIndentation().append("\n}");
	}
	
	public void _prepare(XTryCatchFinallyExpression expr, IAppendable b) {
		declareLocalVariable(expr, b);
		b.append("\ntry {");
			internalPrepare(expr.getExpression(), b);
			b.append("\n").append(getVarName(expr)).append(" = ");
			internalToJavaExpression(expr.getExpression(), b);
			b.append(";");
		b.append("\n}");
		appendCatchAndFinally(expr, b);
	}

	protected void appendCatchAndFinally(XTryCatchFinallyExpression expr, IAppendable b) {
		for (XCatchClause catchClause : expr.getCatchClauses()) {
			JvmTypeReference type = getTypeProvider().getType(catchClause.getDeclaredParam());
			b.append(" catch (").append(getSerializedForm(type)).append(" ").append(catchClause.getDeclaredParam().getName()).append(") { ");
			internalPrepare(catchClause.getExpression(), b);
			b.append("\n").append(getVarName(expr)).append(" = ");
			internalToJavaExpression(catchClause.getExpression(), b);
			b.append(";\n}");
		}
		final XExpression finallyExp = expr.getFinallyExpression();
		if (finallyExp!=null) {
			b.append(" finally ");
			openBlock(finallyExp, b);
			internalToJavaStatement(finallyExp, b);
			closeBlock(finallyExp, b);
		}
	}
	
	public void _toJavaExpression(XTryCatchFinallyExpression expr, IAppendable b) {
		b.append(getVarName(expr));
	}
	
	public void _toJavaStatement(XTryCatchFinallyExpression expr, IAppendable b) {
		b.append("\ntry ");
		openBlock(expr.getExpression(),b);
			internalToJavaStatement(expr.getExpression(), b);
		closeBlock(expr.getExpression(),b);
		appendCatchAndFinally(expr, b);
	}
	
	public void _prepare(XThrowExpression expr, IAppendable b) {
		internalPrepare(expr.getExpression(),b);
		b.append("throw ");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(";");
	}
	
	public void _toJavaExpression(XThrowExpression expr, IAppendable b) {
	}
	
	public void _toJavaStatement(XThrowExpression expr, IAppendable b) {
		internalPrepare(expr, b);
	}
	
	public void _prepare(XInstanceOfExpression expr, IAppendable b) {
		internalPrepare(expr.getExpression(),b);
	}
	
	public void _toJavaExpression(XInstanceOfExpression expr, IAppendable b) {
		b.append("(");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(" instanceof ").append(expr.getType().getCanonicalName()).append(")");
	}
	
	public void _toJavaStatement(XInstanceOfExpression expr, IAppendable b) {
		b.append("\n/*");
		internalPrepare(expr, b);
		internalToJavaExpression(expr, b);
		b.append("*/;");
	}

	public void _prepare(XVariableDeclaration expr, IAppendable b) {
		throw new IllegalArgumentException("A variable declaration cannot occure in this context.");
	}

	public void _toJavaExpression(XVariableDeclaration expr, IAppendable b) {
	}
	
	public void _toJavaStatement(XVariableDeclaration expr, IAppendable b) {
		internalPrepare(expr.getRight(), b);
		b.append("\n");
		if (!expr.isWriteable()) {
			b.append("final ");
		}
		if (expr.getType() != null) {
			b.append(expr.getType().getCanonicalName());
		} else {
			b.append(getReturnTypeName(expr.getRight()));
		}
		b.append(" ");
		b.append(makeJavaIdentifier(expr.getName()));
		b.append(" = ");
		internalToJavaExpression(expr.getRight(), b);
		b.append(";");
	}

	public void _prepare(XWhileExpression expr, IAppendable b) {
		_toJavaStatement(expr, b);
	}

	public void _toJavaExpression(XWhileExpression expr, IAppendable b) {
		b.append("null");
	}
	
	public void _toJavaStatement(XWhileExpression expr, IAppendable b) {
		internalPrepare(expr.getPredicate(), b);
		b.append("\nBoolean ").append(getVarName(expr)).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.append("\nwhile (");
		b.append(getVarName(expr));
		b.append(") { ");
		openBlock(expr.getBody(), b);
		internalToJavaStatement(expr.getBody(), b);
		closeBlock(expr.getBody(), b);
		b.append("\n").append(getVarName(expr)).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.append("\n}");
	}
	
	public void _prepare(XDoWhileExpression expr, IAppendable b) {
		_toJavaStatement(expr, b);
	}
	
	public void _toJavaExpression(XDoWhileExpression expr, IAppendable b) {
		b.append("null");
	}
	
	public void _toJavaStatement(XDoWhileExpression expr, IAppendable b) {
		b.append("\nBoolean ").append(getVarName(expr)).append(";");
		b.append("\ndo {");
		internalToJavaStatement(expr.getBody(), b);
		internalPrepare(expr.getPredicate(), b);
		b.append("\n").append(getVarName(expr)).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.append("\n} while(");
		b.append(getVarName(expr));
		b.append(");");
	}
	
	public void testname() throws Exception {
		boolean x = true;
		while (x) {
			Boolean condition = false;
			x = condition;
		}
	}

	public void _prepare(XForLoopExpression expr, IAppendable b) {
		_toJavaStatement(expr, b);
	}

	public void _toJavaExpression(XForLoopExpression expr, IAppendable b) {
		b.append("null");
	}
	
	public void _toJavaStatement(XForLoopExpression expr, IAppendable b) {
		internalPrepare(expr.getForExpression(), b);
		b.append("\nfor (");
		JvmTypeReference paramType = getTypeProvider().getType(expr.getDeclaredParam());
		b.append(paramType.getCanonicalName());
		b.append(" ");
		b.append(expr.getDeclaredParam().getName());
		b.append(" : ");
		internalToJavaExpression(expr.getForExpression(), b);
		b.append(") ");
		openBlock(expr.getEachExpression(), b);
		internalToJavaStatement(expr.getEachExpression(), b);
		closeBlock(expr.getEachExpression(), b);
	}

	public void _prepare(XConstructorCall expr, IAppendable b) {
		for (XExpression arg : expr.getArguments()) {
			internalPrepare(arg, b);
		}
	}

	public void _toJavaExpression(XConstructorCall expr, IAppendable b) {
		b.append("new ");
		b.append(expr.getConstructor().getDeclaringType().getCanonicalName());
		if (!expr.getTypeArguments().isEmpty()) {
			b.append("<");
			for (int i = 0; i < expr.getTypeArguments().size(); i++) {
				JvmTypeReference arg = expr.getTypeArguments().get(i);
				b.append(arg.getCanonicalName());
				if (i + 1 < expr.getTypeArguments().size())
					b.append(", ");
			}
			b.append(">");
		}
		b.append("(");
		appendArguments(expr.getArguments(), b);
		b.append(")");
	}
	
	public void _toJavaStatement(XConstructorCall expr, IAppendable b) {
		internalPrepare(expr, b);
		b.append("\n");
		internalToJavaStatement(expr, b);
		b.append(";");
	}

	public void _prepare(XCastedExpression expr, IAppendable b) {
		internalPrepare(expr.getTarget(), b);
	}

	public void _toJavaExpression(XCastedExpression expr, IAppendable b) {
		b.append("((");
		b.append(expr.getType().getCanonicalName());
		b.append(") ");
		internalToJavaExpression(expr.getTarget(), b);
		b.append(")");
	}
	
	public void _toJavaStatement(XCastedExpression expr, IAppendable b) {
		internalPrepare(expr, b);
		b.append("\n");
		internalToJavaStatement(expr, b);
		b.append(";");
	}

	public void _prepare(XIfExpression expr, IAppendable b) {
		declareLocalVariable(expr, b);
		internalPrepare(expr.getIf(), b);
		b.append("\nif (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") ");
		openBlock(expr.getThen(), b);
		internalPrepare(expr.getThen(), b);
		b.append("\n");
		b.append(getVarName(expr));
		b.append(" = ");
		internalToJavaExpression(expr.getThen(), b);
		b.append(";");
		closeBlock(expr.getThen(), b);
		if (expr.getElse() != null) {
			b.append(" else ");
			openBlock(expr.getElse(), b);
			internalPrepare(expr.getElse(), b);
			b.append("\n");
			b.append(getVarName(expr));
			b.append(" = ");
			internalToJavaExpression(expr.getElse(), b);
			b.append(";");
			closeBlock(expr.getElse(), b);
		}
	}

	public void _toJavaExpression(XIfExpression expr, IAppendable b) {
		b.append(getVarName(expr));
	}
	
	public void _toJavaStatement(XIfExpression expr, IAppendable b) {
		internalPrepare(expr.getIf(), b);
		b.append("\nif (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") ");
		openBlock(expr.getThen(), b);
		internalToJavaStatement(expr.getThen(), b);
		closeBlock(expr.getThen(), b);
		if (expr.getElse() != null) {
			b.append(" else ");
			openBlock(expr.getElse(), b);
			internalToJavaStatement(expr.getElse(), b);
			closeBlock(expr.getElse(), b);
		}
	}

}
