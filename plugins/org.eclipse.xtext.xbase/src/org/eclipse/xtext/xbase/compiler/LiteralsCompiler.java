/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LiteralsCompiler extends TypeConvertingCompiler {

	public void _toJavaExpression(XStringLiteral expr, ITracingAppendable b) {
		String javaString = Strings.convertToJavaString(expr.getValue());
		b.append("\"").append(javaString).append("\"");
	}
	
	public void _toJavaStatement(XStringLiteral expr, ITracingAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	protected void generateComment(XExpression expr, ITracingAppendable b, boolean isReferenced) {
		if (!isReferenced) {
			b.append("/*");
			internalToJavaExpression(expr, b);
			b.append("*/;");
		}
	}

	public void _toJavaExpression(XIntLiteral expr, ITracingAppendable b) {
		b.append(Integer.toString(expr.getValue()));
	}
	
	public void _toJavaStatement(XIntLiteral expr, ITracingAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	public void _toJavaExpression(XNullLiteral expr, ITracingAppendable b) {
		b.append("null");
	}
	
	public void _toJavaStatement(XNullLiteral expr, ITracingAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	public void _toJavaExpression(XBooleanLiteral expr, ITracingAppendable b) {
		b.append(Boolean.toString(expr.isIsTrue()));
	}
	
	public void _toJavaStatement(XBooleanLiteral expr, ITracingAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	public void _toJavaExpression(XTypeLiteral expr, ITracingAppendable b) {
		b.append(expr.getType().getQualifiedName('.')).append(".class");
	}
	
	public void _toJavaStatement(XTypeLiteral expr, ITracingAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITracingAppendable b) {
		if (expr instanceof XBooleanLiteral
			|| expr instanceof XStringLiteral
			|| expr instanceof XIntLiteral
			|| expr instanceof XTypeLiteral
			|| expr instanceof XClosure
			|| expr instanceof XNullLiteral)
			return false;
		return super.isVariableDeclarationRequired(expr,b);
	}
}
