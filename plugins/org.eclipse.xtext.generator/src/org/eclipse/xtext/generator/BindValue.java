/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

public class BindValue {
	private String expression;
	private String typeName;
	private boolean provider;
	private String[] statements;
	
	public String getExpression() {
		return expression;
	}

	public String getTypeName() {
		return typeName;
	}
	
	public String[] getStatements() {
		if (statements == null)
			statements = new String[0];
		return statements;
	}
	
	public boolean isProvider() {
		return provider;
	}

	private BindValue(String expression, String typeName, boolean provider, String[] statements) {
		super();
		this.expression = expression;
		this.typeName = typeName;
		this.provider = provider;
		this.statements = statements;
	}

	public static BindValue type(String name) {
		return new BindValue(null, name, false, null);
	}
	
	public static BindValue expr(String expr) {
		return new BindValue(expr, null, false, null);
	}
	
	public static BindValue provider(String name) {
		return new BindValue(null, name, true, null);
	}
	
	public static BindValue providerExpr(String expr) {
		return new BindValue(expr, null, true, null);
	}
	
	public static BindValue statements(String[] statements) {
		return new BindValue(null, null, false, statements);
	}
	
	@Override
	public String toString() {
		if (expression!=null)
			return expression;
		return typeName;
	}

}