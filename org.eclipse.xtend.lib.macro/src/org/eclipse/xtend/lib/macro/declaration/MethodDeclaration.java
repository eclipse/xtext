/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.Collections;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MethodDeclaration extends ExecutableDeclaration {
	
	/**
	 * @return whether this method is declared <code>final</code>
	 */
	boolean isFinal();

	/**
	 * @return whether this method is declared <code>abstract</code>
	 */
	boolean isAbstract();

	/**
	 * @return whether this method is declared <code>static</code>
	 */
	boolean isStatic();
	
	/**
	 * @return whether this method is declared <code>synchronized</code>
	 */
	boolean isSynchronized();
	
	/**
	 * @return whether this method is declared <code>default</code>
	 */
	boolean isDefault();
	
	/**
	 * @return whether this method is declared <code>strictfp</code>
	 */
	boolean isStrictFloatingPoint();

	/**
	 * @return whether this method is declared <code>native</code>
	 */
	boolean isNative();
	
	/**
	 * @return the return type of this method
	 */
	TypeReference getReturnType();
	
	/**
	 * @return the overridden or implemented methods
	 * @since 2.23
	 */
	default Iterable<? extends MethodDeclaration> getOverriddenOrImplementedMethods() {
		return Collections.emptyList();
	}
}