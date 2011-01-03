/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseCompiler {

	private PolymorphicDispatcher<Void> toJavaStmntDispatcher = 
		PolymorphicDispatcher.createForSingleTarget("_prepare", 2,2,this);

	private PolymorphicDispatcher<Void> toJavaExprDispatcher = 
		PolymorphicDispatcher.createForSingleTarget("_toJavaExpression", 2,2,this);

	public CharSequence compile(EObject obj) {
		StringBuilder builder = new StringBuilder();
		internalPrepare(obj, builder);
		builder.append("return ");
		internalToJavaExpression(obj, builder);
		builder.append(";");
		return builder;
	}

	protected void internalPrepare(EObject obj, StringBuilder builder) {
		toJavaStmntDispatcher.invoke(obj, builder);
	}

	protected void internalToJavaExpression(EObject obj, StringBuilder builder) {
		toJavaExprDispatcher.invoke(obj, builder);
	}

	@Inject
	private ITypeProvider<JvmTypeReference> typeProvider;

	public void setTypeProvider(ITypeProvider<JvmTypeReference> typeProvider) {
		this.typeProvider = typeProvider;
	}

	protected String getReturnTypeName(XExpression expr) {
		return typeProvider.getType(expr, null).getCanonicalName();
	}

	protected String getVarName(XExpression ex) {
		if (ex.eContainer() instanceof XExpression) {
			return getVarName((XExpression) ex.eContainer()) + "_" + ex.eContainer().eContents().indexOf(ex);
		}
		return "_var";
	}

	public void _prepare(XExpression func, StringBuilder b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _toJavaExpression(XExpression func, StringBuilder b) {
		throw new UnsupportedOperationException("Coudn't find a compilation strategy for expressions of type "
				+ func.getClass().getCanonicalName());
	}

	public void _prepare(XStringLiteral expr, StringBuilder b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XStringLiteral expr, StringBuilder b) {
		String javaString = expr.getValue().replace("\"", "\\\"");
		b.append('"').append(javaString).append('"');
	}

	public void _prepare(XIntLiteral expr, StringBuilder b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XIntLiteral expr, StringBuilder b) {
		b.append(expr.getValue()).append("L");
	}

	public void _prepare(XBooleanLiteral expr, StringBuilder b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XBooleanLiteral expr, StringBuilder b) {
		b.append(expr.isIsTrue());
	}

	public void _prepare(XBlockExpression expr, StringBuilder b) {
		b.append(getReturnTypeName(expr)).append(" ").append(getVarName(expr)).append(";\n");
		b.append("{\n");
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			internalPrepare(ex, b);
			if (i == expressions.size() - 1) {
				b.append(getVarName(expr)).append(" = ");
				internalToJavaExpression(ex, b);
				b.append(";").append("\n");
			}
		}
		b.append("}\n");
	}

	public void _toJavaExpression(XBlockExpression expr, StringBuilder b) {
		b.append(getVarName(expr));
	}
	
	public void _prepare(XVariableDeclaration expr, StringBuilder b) {
		internalPrepare(expr.getRight(), b);
		if (!expr.isWriteable()) {
			b.append("final ");
		}
		if (expr.getType()!=null) {
			b.append(expr.getType().toString());
		} else {
			b.append(getReturnTypeName(expr.getRight()));
		}
		b.append(" ");
		b.append(makeJavaIdentifier(expr.getName()));
		b.append(" = ");
		internalToJavaExpression(expr.getRight(), b);
		b.append(";\n");
	}
	
	protected String makeJavaIdentifier(String name) {
		return name.equals("this")?"_this":name;
	}

	public void _toJavaExpression(XVariableDeclaration expr, StringBuilder b) {
		throw new UnsupportedOperationException("A variable declaration cannot exist in the context of a Java expression.");
	}

	public void _prepare(XWhileExpression expr, StringBuilder b) {
		b.append("while (");
		internalPrepare(expr.getPredicate(), b);
		b.append(")");
		internalPrepare(expr.getBody(), b);
	}

	public void _toJavaExpression(XWhileExpression expr, StringBuilder b) {
		b.append("null");
	}
	
	public void _prepare(XForLoopExpression expr, StringBuilder b) {
		internalPrepare(expr.getForExpression(), b);
		b.append("for (");
		b.append(expr.getDeclaredParam().getParameterType().getCanonicalName());
		b.append(" ");
		b.append(expr.getDeclaredParam().getName());
		b.append(" : ");
		internalToJavaExpression(expr.getForExpression(), b);
		b.append(") {\n");
		internalPrepare(expr.getEachExpression(), b);
		internalToJavaExpression(expr.getEachExpression(), b);
		b.append("}\n");
	}
	
	public void _toJavaExpression(XForLoopExpression expr, StringBuilder b) {
		b.append("null");
	}

	public void _prepare(XConstructorCall expr, StringBuilder b) {
		for (XExpression arg : expr.getArguments()) {
			internalPrepare(arg, b);
		}
	}

	public void _toJavaExpression(XConstructorCall expr, StringBuilder b) {
		b.append("new ");
		b.append(expr.getConstructor().getDeclaringType().getCanonicalName());
		if (!expr.getTypeArguments().isEmpty()) {
			b.append("<");
			for (int i = 0; i < expr.getTypeArguments().size(); i++) {
				JvmTypeReference arg = expr.getTypeArguments().get(i);
				b.append(arg.getCanonicalName());
				if (i+1<expr.getTypeArguments().size())
					b.append(", ");
			}
			b.append(">");
		}
		b.append("(");
		appendArguments(expr.getArguments(), b);
		b.append(")");
	}

	public void _prepare(XCastedExpression expr, StringBuilder b) {
		internalPrepare(expr.getTarget(), b);
	}

	public void _toJavaExpression(XCastedExpression expr, StringBuilder b) {
		b.append("(");
		b.append(expr.getType().getCanonicalName());
		b.append(") ");
		internalToJavaExpression(expr.getTarget(), b);
	}

	public void _prepare(XAssignment expr, StringBuilder b) {
		internalPrepare(expr.getAssignable(), b);
		internalPrepare(expr.getValue(), b);
	}

	public void _toJavaExpression(XAssignment expr, StringBuilder b) {
		if (expr.getFeature() instanceof JvmOperation) {
			b.append(".");
			b.append(((JvmOperation) expr.getFeature()).getSimpleName());
			b.append("(");
			internalToJavaExpression(expr.getValue(), b);
			b.append(")");
		} else {
			b.append(" = ");
			internalToJavaExpression(expr.getValue(), b);
		}
	}
	
	public void _prepare(XIfExpression expr, StringBuilder b) {
		internalPrepare(expr.getIf(), b);
		b.append(getReturnTypeName(expr));
		b.append(" ");
		b.append(getVarName(expr));
		b.append(";\n");
		b.append("if (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") {\n");
		internalPrepare(expr.getThen(), b);
		b.append(getVarName(expr));
		b.append(" = ");
		internalToJavaExpression(expr.getThen(), b);
		b.append(";\n");
		if (expr.getElse()!=null) {
			b.append("} else {\n");
			internalPrepare(expr.getElse(), b);
			b.append(getVarName(expr));
			b.append(" = ");
			internalToJavaExpression(expr.getElse(), b);
			b.append(";\n");
		}
		b.append("}\n");
	}
	
	public void _toJavaExpression(XIfExpression expr, StringBuilder b) {
		b.append(getVarName(expr));
	}

	public void _prepare(XAbstractFeatureCall expr, StringBuilder b) {
		for (XExpression arg : expr.getArguments()) {
			internalPrepare(arg, b);
		}
	}

	public void _toJavaExpression(XAbstractFeatureCall expr, StringBuilder b) {
		if (expr instanceof XMemberFeatureCall) {
			internalToJavaExpression(((XMemberFeatureCall) expr).getMemberCallTarget(), b);
			b.append(".");
		} else if (expr instanceof XFeatureCall) {
			if (expr.getFeature() instanceof JvmMember) {
				b.append("_this.");
			}
			if (expr.getFeature() instanceof XVariableDeclaration) {
				b.append(((XVariableDeclaration)expr.getFeature()).getName());
			}
		} else if (expr instanceof XBinaryOperation) {
			internalToJavaExpression(((XBinaryOperation) expr).getLeftOperand(), b);
			b.append(".");
		}
		if (expr.getFeature() instanceof JvmMember) {
			b.append(((JvmMember) expr.getFeature()).getSimpleName());
		}
		if (expr.getFeature() instanceof JvmOperation) {
			b.append("(");
			if (expr instanceof XMemberFeatureCall) {
				EList<XExpression> arguments = ((XMemberFeatureCall) expr).getMemberCallArguments();
				appendArguments(arguments, b);
			}
			b.append(")");
		}
	}

	protected void appendArguments(EList<XExpression> eList, StringBuilder b) {
		for (int i = 0; i < eList.size(); i++) {
			XExpression expression = eList.get(i);
			internalToJavaExpression(expression, b);
			if (i+1 < eList.size())
				b.append(", ");
		}
	}
}
