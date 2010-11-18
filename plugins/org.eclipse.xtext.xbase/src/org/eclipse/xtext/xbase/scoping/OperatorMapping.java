/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import static org.eclipse.xtext.naming.QualifiedName.*;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author Sven Efftinge
 */
public class OperatorMapping {
	
	public static final QualifiedName PLUS = create("+");
	public static final QualifiedName MINUS = create("-");
	public static final QualifiedName POWER = create("**");
	public static final QualifiedName MULTIPLY = create("*");
	public static final QualifiedName DIVIDE = create("/");
	public static final QualifiedName MODULO = create("%");
	public static final QualifiedName OR = create("||");
	public static final QualifiedName AND = create("&&");
	public static final QualifiedName ADD = create("+=");
	public static final QualifiedName EQUALS = create("==");
	public static final QualifiedName NOT_EQUALS = create("!=");
	public static final QualifiedName LESS_THAN = create("<");
	public static final QualifiedName LESS_EQUALS_THAN = create("<=");
	public static final QualifiedName GREATER_THAN = create(">");
	public static final QualifiedName GREATER_EQUALS_THAN = create(">=");
	public static final QualifiedName MAPPED_TO = create("->");
	public static final QualifiedName UP_TO = create("..");
	public static final QualifiedName NOT = create("!");
	
	private BiMap<QualifiedName, QualifiedName> map = HashBiMap.create();
	
	{
		initializeMapping();
	}
	
	protected void initializeMapping() {
		map.put(PLUS, create("plus"));
		map.put(MINUS, create("minus"));
		map.put(POWER, create("power"));
		map.put(MULTIPLY, create("multiply"));
		map.put(DIVIDE, create("divide"));
		map.put(MODULO, create("modulo"));
		map.put(OR, create("or"));
		map.put(AND, create("and"));
		map.put(ADD, create("add"));
		map.put(EQUALS, create("equals"));
		map.put(NOT_EQUALS, create("notEquals"));
		map.put(LESS_THAN, create("lessThan"));
		map.put(LESS_EQUALS_THAN, create("lessEqualsThan"));
		map.put(GREATER_THAN, create("greaterThan"));
		map.put(GREATER_EQUALS_THAN, create("greaterEqualsThan"));
		map.put(MAPPED_TO, create("mappedTo"));
		map.put(UP_TO, create("upTo"));
		map.put(NOT, create("not"));
	}
	
	public QualifiedName getMethodName(QualifiedName operator) {
		return map.get(operator);
	}
	
	public QualifiedName getOperator(QualifiedName methodName) {
		return map.inverse().get(methodName);
	}
}	
