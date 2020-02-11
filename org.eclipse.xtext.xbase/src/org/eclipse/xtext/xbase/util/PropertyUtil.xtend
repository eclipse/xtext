/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util

import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmOperation

import static extension java.beans.Introspector.*
import static extension java.lang.Character.*
import java.util.Locale
import org.eclipse.xtext.util.Strings

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
			feature.getPropertyName(methodName, 'get', getterParams) ?:
			feature.getPropertyName(methodName, 'set', setterParams) ?:
			feature.getPropertyName(methodName, 'is', getterParams)
	}

	protected static def getPropertyName(
		JvmOperation operation,
		String methodName,
		String prefix,
		int params
	) {
		val prefixLength = prefix.length
		if (methodName.startsWithPrefix(prefix, prefixLength) && operation.parameters.size === params)
			methodName.substring(prefixLength).decapitalize
	}

	protected def static startsWithPrefix(String methodName, String prefix, int prefixLength) {
		methodName.length > prefixLength && methodName.startsWith(prefix) && methodName.charAt(prefixLength).upperCase
	}

	/**
	 * Returns the shorthand name for a function
	 * e.g. URI for getURI; uri for setUri; null for getuRI; enum for isEnum
	 * If the given name is invalid, the result is <code>null</code>.
	 * 
	 * @param fullName the fullName of the function we're trying to shorthand (including 'get' or 'is')
	 * 
	 * @since 2.15
	 */
	/* @Nullable */
	def static String tryGetShorthandName(String fullName) {
		val name = if (fullName.startsWith("get") || fullName.startsWith("set")) {
				fullName.substring(3)
			} else if (fullName.startsWith("is")) {
				fullName.substring(2)
			} else {
				return null
			}

		if (name.length() == 1) { // e.g. Point.getX()
			return name.toLowerCase(Locale.ENGLISH);
		} else if (name.length() > 1) {
			if (Character.isUpperCase(name.charAt(1))) {
				// if second char is uppercase, the name itself is the shorthand
				// URI is the property name for getURI
				if (Character.isUpperCase(name.charAt(0))) {
					return name;
				}
				// if the first character is not upper case, but the second is, then there is no shorthand
				// e.g. geteObject has no shorthand
				return null;
			} else {
				return Strings.toFirstLower(name);
			}
		}
		// length 0 is invalid
		return null;
	}
}	