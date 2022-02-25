/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

/**
 * {@link ResolvedExecutable Resolved} representation of a
 * {@link MethodDeclaration}.
 * 
 * @since 2.7
 */
public interface ResolvedMethod extends ResolvedExecutable {

	MethodDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedExecutable resolved} return type
	 */
	TypeReference getResolvedReturnType();

	/**
	 * @return the {@link ResolvedExecutable resolved} type parameters.
	 */
	Iterable<? extends ResolvedTypeParameter> getResolvedTypeParameters();
}
