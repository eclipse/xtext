/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.util

/**
 * An object-valued option with default value for use in generator fragments.
 */
class GeneratorOption <T> {
	
	val T defaultValue
	
	T value
	
	/**
	 * Create an option with no default value.
	 */
	new() {
		this.defaultValue = null
	}
	
	/**
	 * Create an option with a default value.
	 */
	new(T defaultValue) {
		this.defaultValue = defaultValue
	}
	
	def T get() {
		value ?: defaultValue
	}
	
	def void set(T value) {
		this.value = value
	}
	
	def boolean isSet() {
		value !== null
	}
	
}