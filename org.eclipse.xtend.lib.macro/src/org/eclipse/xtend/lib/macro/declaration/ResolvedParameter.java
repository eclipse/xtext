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
 * The resolved representation of a parameter in the context of a type
 * reference. Consider for instance this method
 * 
 * <pre>
 * interface Foo&lt;T&gt; {
 *  def void foo(T arg)
 * }
 * </pre>
 * 
 * In the context of the type reference <code>Foo&lt;String&gt;</code>, the
 * parameter <code>arg</code> has the type <code>String</code>
 * 
 * @since 2.7
 */
public interface ResolvedParameter {
	/**
	 * @return the declaration being {@link ResolvedParameter resolved}
	 */
	ParameterDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedParameter resolved} type of the parameter
	 */
	TypeReference getResolvedType();
}
