/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows to describe how a certain static function should be inlined by the
 * Xbase compiler.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ ElementType.METHOD })
public @interface Inline {
	
	/**
	 * The inline format string.
	 * Placeholders like {@code $1, $2} etc can be used where
	 * the {@code 1..n}parameters of the inlined method are used for {@code $1} to {@code $n}
	 * and the {@link #imported()} types are used for subsequent indizes.
	 * The last index {@code $n} can be used to insert the type parameters
	 * of the original declaration.
	 */
	String value();
	
	/**
	 * Types that should be imported to inline the operation.
	 */
	Class<?>[] imported() default {};
	
	/**
	 * Allows to limit or widen the locations where a certain method invocation
	 * should be inlined. Default is {@link InlineContext#EXPRESSION}.
	 */
	InlineContext when() default InlineContext.EXPRESSION;
	
}
