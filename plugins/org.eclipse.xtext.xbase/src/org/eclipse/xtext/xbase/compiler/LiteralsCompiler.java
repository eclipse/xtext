/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LiteralsCompiler extends AbstractXbaseCompiler {

	public void _prepare(XStringLiteral expr, IAppendable b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XStringLiteral expr, IAppendable b) {
		String javaString = expr.getValue().replace("\"", "\\\"");
		b.append('"').append(javaString).append('"');
	}
	
	public void _toJavaStatement(XStringLiteral expr, IAppendable b) {
		b.append("/*");
		internalToJavaExpression(expr, b);
		b.append("*/;");
	}

	public void _prepare(XIntLiteral expr, IAppendable b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XIntLiteral expr, IAppendable b) {
		b.append("new Integer(").append(expr.getValue()).append(")");
	}
	
	public void _toJavaStatement(XIntLiteral expr, IAppendable b) {
		b.append("/*");
		internalToJavaExpression(expr, b);
		b.append("*/;");
	}

	public void _prepare(XNullLiteral expr, IAppendable b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XNullLiteral expr, IAppendable b) {
		b.append("null");
	}
	
	public void _toJavaStatement(XNullLiteral expr, IAppendable b) {
		b.append("/*");
		internalToJavaExpression(expr, b);
		b.append("*/;");
	}

	public void _prepare(XBooleanLiteral expr, IAppendable b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XBooleanLiteral expr, IAppendable b) {
		b.append(expr.isIsTrue());
	}
	
	public void _toJavaStatement(XBooleanLiteral expr, IAppendable b) {
		b.append("/*");
		internalToJavaExpression(expr, b);
		b.append("*/;");
	}

	public void _prepare(XTypeLiteral expr, IAppendable b) {
		//Always inline as expression
	}

	public void _toJavaExpression(XTypeLiteral expr, IAppendable b) {
		b.append(expr.getType().getCanonicalName()).append(".class");
	}
	
	public void _toJavaStatement(XTypeLiteral expr, IAppendable b) {
		b.append("/*");
		internalToJavaExpression(expr, b);
		b.append("*/;");
	}
}
