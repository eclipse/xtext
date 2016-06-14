/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.util

/**
 * A Boolean-valued option with default value for use in generator fragments.
 */
class BooleanGeneratorOption {
	
	val boolean defaultValue
	
	Boolean value
	
	new() {
		this(false)
	}
	
	new(boolean defaultValue) {
		this.defaultValue = defaultValue
	}
	
	def boolean get() {
		value ?: defaultValue
	}
	
	def void set(boolean value) {
		this.value = value
	}
	
	def boolean isSet() {
		value !== null
	}
	
}