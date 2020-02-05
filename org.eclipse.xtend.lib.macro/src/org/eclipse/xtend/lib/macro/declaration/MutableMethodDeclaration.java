/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableMethodDeclaration extends MutableExecutableDeclaration, MethodDeclaration {
	
	/**
	 * @param type the return type of this method, must be not <code>null</code>
	 * @exception IllegalArgumentException if the <code>type</code> is <code>null</code>
	 */
	void setReturnType(TypeReference type);
	
	/**
	 * @param isStatic whether this method declaration is <code>static</code>
	 */
	void setStatic(boolean isStatic);
	
	/**
	 * @param isFinal whether this method declaration is <code>final</code>
	 */
	void setFinal(boolean isFinal);
	
	/**
	 * @param isStrictFloatingPoint whether this method declaration is <code>strictfp</code>
	 */
	void setStrictFloatingPoint(boolean isStrictFloatingPoint);

	/**
	 * @param isNative whether this method declaration is <code>native</code>
	 */
	void setNative(boolean isNative);

	/**
	 * @param isAbstract whether this method declaration is <code>abstract</code>
	 */
	void setAbstract(boolean isAbstract);
	
	/**
	 * @param isSynchronized whether this method declaration is <code>synchronized</code>
	 */
	void setSynchronized(boolean isSynchronized);

	/**
	 * @param isDefault whether this method declaration is <code>default</code>
	 */
	void setDefault(boolean isDefault);

}
