/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.ArrayList;
import java.util.List;

/**
 * Resolved representation of an {@link ExecutableDeclaration}.
 * 
 * Parameter types and declared exceptions are put into the context of a
 * specific declaring reference, e.g. {@link List#add(Object) List#add(Object)}
 * becomes <code>List#add(String)</code> in the context of an {@link ArrayList
 * ArrayList&lt;String&gt;}
 * 
 * @since 2.7
 */
public interface ResolvedExecutable {

	/**
	 * @return the executable that is {@link ResolvedExecutable resolved}
	 */
	ExecutableDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedExecutable resolved} parameters
	 */
	Iterable<? extends ResolvedParameter> getResolvedParameters();

	/**
	 * @return the {@link ResolvedExecutable resolved} exceptions
	 */
	Iterable<? extends TypeReference> getResolvedExceptionTypes();

	/**
	 * Returns the simple signature of this executable. The simple signature of
	 * <code>List&lt;String&gt;.addAll(int, Collection&lt;E&gt;)</code> is
	 * <code>addAll(int, Collection&lt;String&gt;)</code>.
	 * @return the simple, human-readable signature
	 */
	String getSimpleSignature();

	/**
	 * Returns the resolved erased signature of this feature. The resolved representation of
	 * <code>List&lt;String&gt;.addAll(int,java.util.Collection&lt;E&gt;)</code> is
	 * <code>addAll(int,Collection)</code>.
	 * 
	 * @since 2.14
	 * @return resolved erasure signature
	 */
	String getResolvedErasureSignature();
}
