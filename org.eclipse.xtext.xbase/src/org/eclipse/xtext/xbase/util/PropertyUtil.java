/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.util;

import java.beans.Introspector;
import java.util.Locale;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;

/**
 * @author kosyakov - Initial contribution and API
 */
public class PropertyUtil {
	public static String getPropertyName(JvmFeature feature) {
		if (feature.isStatic()) {
			return getPropertyName(feature, feature.getSimpleName(), 1, 2);
		} else {
			return getPropertyName(feature, feature.getSimpleName(), 0, 1);
		}
	}

	public static String getPropertyName(JvmFeature feature, String methodName, int getterParams, int setterParams) {
		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			String propertyName = getPropertyName(operation, methodName, "get", getterParams);
			if (propertyName != null) {
				return propertyName;
			}
			propertyName = getPropertyName(operation, methodName, "set", setterParams);
			if (propertyName != null) {
				return propertyName;
			}
			return getPropertyName(operation, methodName, "is", getterParams);
		}
		return null;
	}

	protected static String getPropertyName(JvmOperation operation, String methodName, String prefix, int params) {
		int prefixLength = prefix.length();
		if (startsWithPrefix(methodName, prefix, prefixLength)
				&& operation.getParameters().size() == params) {
			return Introspector.decapitalize(methodName.substring(prefixLength));
		}
		return null;
	}

	protected static boolean startsWithPrefix(String methodName, String prefix, int prefixLength) {
		return methodName.length() > prefixLength && methodName.startsWith(prefix)
				&& Character.isUpperCase(methodName.charAt(prefixLength));
	}

	/**
	 * @Nullable
	 */
	public static String tryGetShorthandName(String fullName) {
		String name = null;
		if (fullName.startsWith("get") || fullName.startsWith("set")) {
			name = fullName.substring(3);
		} else {
			if (fullName.startsWith("is")) {
				name = fullName.substring(2);
			} else {
				return null;
			}
		}
		if (name.length() == 1) { // e.g. Point.getX()
			return name.toLowerCase(Locale.ENGLISH);
		} else {
			if (name.length() > 1) {
				if (Character.isUpperCase(name.charAt(1))) {
					// if second char is uppercase, the name itself is the
					// shorthand
					// URI is the property name for getURI
					if (Character.isUpperCase(name.charAt(0))) {
						return name;
					}
					// if the first character is not upper case, but the second
					// is, then there is no shorthand
					// e.g. geteObject has no shorthand
					return null;
				} else {
					return Strings.toFirstLower(name);
				}
			}
		}
		// length 0 is invalid
		return null;
	}
}
