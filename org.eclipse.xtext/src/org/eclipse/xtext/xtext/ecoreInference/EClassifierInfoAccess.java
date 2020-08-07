/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Encapsulates the access to the type information during the static analysis of Xtext grammar rules.
 * 
 * @since 2.23
 */
interface EClassifierInfoAccess {

	/**
	 * The most specific single super type of all known potential types.
	 */
	EClassifierInfo getCurrentCompatibleType();
	
	/**
	 * All types that have be used to instantiate the current object or all the types
	 * that are the outcome of a grammar alternative.
	 */
	default Collection<EClassifierInfo> getCurrentTypes() {
		EClassifierInfo currentCompatibleType = getCurrentCompatibleType();
		if (currentCompatibleType == null) {
			return Collections.emptyList();
		}
		return Arrays.asList(currentCompatibleType);
	}
	
}
