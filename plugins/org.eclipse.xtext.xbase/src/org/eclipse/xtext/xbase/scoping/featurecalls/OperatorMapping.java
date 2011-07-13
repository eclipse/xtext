/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static org.eclipse.xtext.naming.QualifiedName.*;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge
 */
@Singleton
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
	
	protected BiMap<QualifiedName, QualifiedName> map = HashBiMap.create();
	
	{
		initializeMapping();
	}
	
	private final static String OP_PREFIX="operator_";
	
	protected void initializeMapping() {
		map.put(PLUS, create(OP_PREFIX+"plus"));
		map.put(MINUS, create(OP_PREFIX+"minus"));
		map.put(POWER, create(OP_PREFIX+"power"));
		map.put(MULTIPLY, create(OP_PREFIX+"multiply"));
		map.put(DIVIDE, create(OP_PREFIX+"divide"));
		map.put(MODULO, create(OP_PREFIX+"modulo"));
		map.put(OR, create(OP_PREFIX+"or"));
		map.put(AND, create(OP_PREFIX+"and"));
		map.put(ADD, create(OP_PREFIX+"add"));
		map.put(EQUALS, create(OP_PREFIX+"equals"));
		map.put(NOT_EQUALS, create(OP_PREFIX+"notEquals"));
		map.put(LESS_THAN, create(OP_PREFIX+"lessThan"));
		map.put(LESS_EQUALS_THAN, create(OP_PREFIX+"lessEqualsThan"));
		map.put(GREATER_THAN, create(OP_PREFIX+"greaterThan"));
		map.put(GREATER_EQUALS_THAN, create(OP_PREFIX+"greaterEqualsThan"));
		map.put(MAPPED_TO, create(OP_PREFIX+"mappedTo"));
		map.put(UP_TO, create(OP_PREFIX+"upTo"));
		map.put(NOT, create(OP_PREFIX+"not"));
	}
	
	public QualifiedName getMethodName(QualifiedName operator) {
		return map.get(operator);
	}
	
	public QualifiedName getOperator(QualifiedName methodName) {
		return map.inverse().get(methodName);
	}
}	
