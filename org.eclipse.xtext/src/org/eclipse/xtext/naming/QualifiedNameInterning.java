/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.naming;

/**
 * Provides methods for enabling and disabling the interning of strings used in {@link QualifiedName}.
 * <p>
 * String interning is disabled by default. It can be enabled by setting the system property {@code xtext.qn.interning}
 * to <code>true</code> or by calling {@link #enable()}.
 * <p>
 * Caution: Setting the system property at runtime does not have an effect. Use {@link #enable()} to enable String
 * interning at runtime.
 * 
 * @since 2.26.0
 * 
 * @author Oliver Libutzki - Initial contribution and API
 * 
 * @see QualifiedName#USE_INTERNING
 * 
 */
public final class QualifiedNameInterning {

	/**
	 * Private constructor to ensure that this class cannot be instantiated.
	 */
	private QualifiedNameInterning() {
	}

	/**
	 * Enables the usage of a String pool for {@link QualifiedName QualifiedName's} segments.
	 * <p>
	 * Note: {@link QualifiedName QualifiedNames} which are created before enabling are not affected.
	 * <p>
	 * Caution: Interning {@link String} objects may affect performance, see bug 484215.
	 */
	public static void enable() {
		QualifiedName.USE_INTERNING = true;
	}

	/**
	 * Disables the usage of a String pool for {@link QualifiedName QualifiedName's} segments.
	 * <p>
	 * Note: {@link QualifiedName QualifiedNames} which are created before disabling are not affected.
	 */
	public static void disable() {
		QualifiedName.USE_INTERNING = false;
	}

}
