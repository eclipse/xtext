/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author Sven Efftinge
 */
public class OperatorMapping {
	
	public static final QualifiedName PLUS = QualifiedName.create("+");
	public static final QualifiedName MINUS = QualifiedName.create("-");
	public static final QualifiedName POWER = QualifiedName.create("**");
	public static final QualifiedName MULTIPLY = QualifiedName.create("*");
	public static final QualifiedName DIVIDE = QualifiedName.create("/");
	public static final QualifiedName MODULO = QualifiedName.create("%");
	public static final QualifiedName OR = QualifiedName.create("||");
	public static final QualifiedName AND = QualifiedName.create("&&");
	public static final QualifiedName ADD = QualifiedName.create("+=");
	public static final QualifiedName EQUALS = QualifiedName.create("==");
	public static final QualifiedName NOT_EQUALS = QualifiedName.create("!=");
	public static final QualifiedName LESS_THAN = QualifiedName.create("<");
	public static final QualifiedName LESS_EQUALS_THAN = QualifiedName.create("<=");
	public static final QualifiedName GREATER_THAN = QualifiedName.create(">");
	public static final QualifiedName GREATER_EQUALS_THAN = QualifiedName.create(">=");
	public static final QualifiedName MAPPED_TO = QualifiedName.create("->");
	public static final QualifiedName UP_TO = QualifiedName.create("..");
	public static final QualifiedName NOT = QualifiedName.create("!");
	
	private BiMap<QualifiedName, String> map = HashBiMap.create();
	
	{
		initializeMapping();
	}
	
	protected void initializeMapping() {
		map.put(PLUS, "plus");
		map.put(MINUS, "minus");
		map.put(POWER, "power");
		map.put(MULTIPLY, "multiply");
		map.put(DIVIDE, "divide");
		map.put(MODULO, "modulo");
		map.put(OR, "or");
		map.put(AND, "and");
		map.put(ADD, "add");
		map.put(EQUALS, "equals");
		map.put(NOT_EQUALS, "notEquals");
		map.put(LESS_THAN, "lessThan");
		map.put(LESS_EQUALS_THAN, "lessEqualsThan");
		map.put(GREATER_THAN, "greaterThan");
		map.put(GREATER_EQUALS_THAN, "greaterEqualsThan");
		map.put(MAPPED_TO, "mappedTo");
		map.put(UP_TO, "upTo");
		map.put(NOT, "not");
	}
	
	public String getMethodName(QualifiedName operator) {
		return map.get(operator);
	}
	
	public QualifiedName getOperator(String methodName) {
		return map.inverse().get(methodName);
	}
}	
