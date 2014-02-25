/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/**
 * Allows to describe how a certain static function should be inlined by the Xbase compiler.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
@Beta
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.METHOD })
@GwtCompatible
public @interface Inline {

	/**
	 * The inline format string. Placeholders like {@code $1, $2} etc can be used where the {@code 1..n} parameters of
	 * the inlined method are used for {@code $1} to {@code $n} and the {@link #imported()} types are used for
	 * subsequent indices. The next index {@code $n} can be used to insert all type parameters of the original
	 * declaration. And finally the last indices refer to the upper bound substitute of the type parameters
	 * individually.
	 * 
	 * So the order is arguments, imports, all type parameters at once incl. brackets and upper bounds of the individual
	 * type parameters without brackets
	 * 
	 * Example:
	 * 
	 * For the following signatures <code>
	 * 
	 * @Inline(value=".." imported = BigDecimal.class) public void <T1, T2> myMethod(String p1, String p2) { ... }
	 *                    </code> $1 refers to p1 $2 refers to p2 $3 refers to BigDecimal $4 refers to <T1, T2> $5
	 *                    refers to the upper bound of T1 $6 refers to the upper bound of T2
	 * 
	 */
	String value();

	/**
	 * Types that should be imported to inline the operation.
	 */
	Class<?>[] imported() default {};

	/**
	 * whether the inlined expression is a statement expression (see <a
	 * href="http://docs.oracle.com/javase/specs/jls/se5.0/html/statements.html#14.8">14.8 - Statement Expressions in
	 * Java Language Specification, Third Edition</a> )
	 */
	boolean statementExpression() default false;

	/**
	 * Whether the compiled Java is a constant expression operator. (see <a
	 * href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.28">15.28. Constant Expressions in Java
	 * Language Specification, Third Edition</a>
	 * 
	 * @since 2.5
	 */
	boolean constantExpression() default false;
	
	/**
	 * A list of mutable arguments' indexes. A value of a mutable argument is changed by a function.
	 * @since 2.6
	 */
	int[] mutableArguments() default {};

}
