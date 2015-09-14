/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.util

import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmOperation

import static extension java.beans.Introspector.*
import static extension java.lang.Character.*

/**
 * @author kosyakov - Initial contribution and API
 */
class PropertyUtil {

	def static String getPropertyName(JvmFeature feature) {
		if (feature.static) {
			feature.getPropertyName(feature.simpleName, 1, 2)
		} else {
			feature.getPropertyName(feature.simpleName, 0, 1)
		}
	}

	def static String getPropertyName(JvmFeature feature, String methodName, int getterParams, int setterParams) {
		if (feature instanceof JvmOperation)
			#[
				'get' -> getterParams,
				'set' -> setterParams,
				'is' -> getterParams
			].map[feature.getPropertyName(methodName, key, value)].filterNull.head
	}

	protected static def getPropertyName(
		JvmOperation operation,
		String methodName,
		String prefix,
		int params
	) {
		val prefixLength = prefix.length
		if (startsWithPrefix(methodName, prefix, prefixLength) && operation.parameters.size === params)
			methodName.substring(prefixLength).decapitalize
	}

	protected def static startsWithPrefix(String methodName, String prefix, int prefixLength) {
		methodName.length > prefixLength && methodName.startsWith(prefix) && methodName.charAt(prefixLength).upperCase
	}

}	