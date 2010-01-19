/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import com.google.common.collect.BiMap;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge
 */
public class OperatorMapping {
	
	private BiMap<String, String> map = Maps.newHashBiMap();
	
	{
		initializeMapping();
	}
	
	protected void initializeMapping() {
		map.put("+", "plus");
		map.put("-", "minus");
		map.put("**", "power");
		map.put("*", "multiply");
		map.put("/", "divide");
		map.put("%", "modulo");
		map.put("||", "or");
		map.put("&&", "and");
		map.put("+=", "add");
		map.put("==", "equals");
		map.put("!=", "notEquals");
		map.put("<", "lessThan");
		map.put("<=", "lessEqualsThan");
		map.put(">", "greateThan");
		map.put(">=", "greateEqualsThan");
		map.put("->", "mappedTo");
		map.put("..", "upTo");
		map.put("!", "not");
	}
	
	public String getMethodName(String operator) {
		return map.get(operator);
	}
	
	public String getOperator(String methodName) {
		return map.inverse().get(methodName);
	}
}	
