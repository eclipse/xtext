/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data

class GuiceModuleAccess extends JavaFileAccess {
	
	@Data
	static class BindKey {
		String type
		boolean singleton
		boolean eagerSingleton
	}
	
	@Data
	static class BindValue {
		private String expression
		private String typeName
		private boolean provider
		private List<CharSequence> statements
	}
	
	@Data
	static class Binding {
		BindKey key
		BindValue value
		String contributedBy
		boolean isFinal
	}
	
	@Accessors
	val List<Binding> bindings = newArrayList
	
	new(TypeReference typeRef, CodeConfig codeConfig) {
		super(typeRef, codeConfig)
	}
		
}
