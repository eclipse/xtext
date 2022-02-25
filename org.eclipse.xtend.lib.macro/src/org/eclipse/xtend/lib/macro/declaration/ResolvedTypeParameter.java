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
 * The resolved representation of a type parameter in the context of a type
 * reference. Consider for instance this method:
 * 
 * <pre>
 * interface Foo&lt;T&gt; {
 *  def &lt;U extends T&gt; void foo(U arg)
 * }
 * </pre>
 * 
 * For a <code>Foo&lt;CharSequence&gt;</code>, the type parameter <code>U</code>
 * would have the upper bound <code>CharSequence</code>
 */
public interface ResolvedTypeParameter {
	/**
	 * @return the declaration that is {@link ResolvedTypeParameter resolved}
	 */
	TypeParameterDeclaration getDeclaration();

	/**
	 * @return the {@link ResolvedTypeParameter resolved} upper bounds
	 */
	Iterable<? extends TypeReference> getResolvedUpperBounds();
}