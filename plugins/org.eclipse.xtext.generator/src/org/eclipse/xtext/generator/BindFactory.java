/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.HashMap;
import java.util.Map;

public class BindFactory {
	private Map<BindKey, BindValue> bindings = new HashMap<BindKey, BindValue>();
	
	public BindFactory addTypeToInstance(String s1, String s2) {
		bindings.put(BindKey.type(s1), BindValue.expr(s2));
		return this;
	}
	public BindFactory addTypeToType(String s1, String s2){
		bindings.put(BindKey.type(s1), BindValue.type(s2));
		return this;
	}
	public BindFactory addTypeToTypeSingleton(String s1, String s2){
		bindings.put(BindKey.singleton(s1), BindValue.type(s2));
		return this;
	}
	public BindFactory addTypeToTypeEagerSingleton(String s1, String s2){
		bindings.put(BindKey.eagerSingleton(s1), BindValue.type(s2));
		return this;
	}
	
	public Map<BindKey, BindValue> getBindings() {
		return bindings;
	}
}