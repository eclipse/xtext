/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

/**
 * This package contains the primary hooks for the actual type computation in Xbase
 * as well as their respective base implementations.
 * 
 * Sensible entry points to explore are the these interfaces.
 * <ol>
 *	<li>{@link org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer ITypeComputer} -
 *    The primary SPI. Clients implement this interface in order to compute types or expressions.
 *    This is pretty much the only interface that is expected to be implemented by clients. It is 
 *    highly recommend to inherit from the 
 *    {@link org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer default implementation}.  
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState ITypeComputationState} -
 *    The state is passed around during the computation process. It allows to define expectations
 *    for child expressions and trigger their type inference. Other aspects are validation,
 *    querying for the current expected type and adding elements to the scope. 
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation ITypeExpectation} -
 *    One of the currently expected types. This can be evaluated in order to compute a type which
 *    depends on the current context, e.g. a {@link org.eclipse.xtext.xbase.XStringLiteral string}
 *    with one character may be a {@link java.lang.Character Character}, {@link java.lang.Character#TYPE char}
 *    or {@link java.lang.String string}.
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult ITypeComputationResult} -
 *    The (possibly intermediate) result of a type computation for an expression. It offers a means to query
 *    for the expected type which is the one that was finally picked from all expectations for that expression.
 *	</li>
 * </ol>
 * 
 * Useful utilities that can be used or specialized are:
 * <ol>
 *	<li>{@link org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider SynonymTypesProvider} -
 *    Registers automatic conversions of existing types to others that do <em>not</em> depend
 *    on the current context. By default these include conversions from {@link java.lang.Iterable iterables}
 *    to arrays and vice versa as well as boxing and unboxing semantics for primitives. 
 *    Synonyms are not considered to be retrieved for demand conversions, e.g. function type
 *    conversion.
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals NumberLiterals} -
 *    Type computation for {@link org.eclipse.xtext.xbase.XNumberLiteral}, e.g. which sort of concrete
 *    syntax may yield a {@link java.math.BigDecimal BigDecimal} or {@link java.math.BigInteger BigInteger}.
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.ClosureTypeComputer ClosureTypeComputer} -
 *    The type computation of {@link org.eclipse.xtext.xbase.XClosure lambda expressions} is implemented in
 *    this utility.
 *	</li>
 * </ol>
 * 
 * APIs that are considered primarily to be consumed but not specialized or implemented include
 * <ol>
 *	<li>{@link org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate Linking candidates} -
 *    These implement the Java'ish logic for feature linking in combination with extension method semantics,
 *    precedences and the like.
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner ITypeAssigner} -
 *    The type assigner allows to bulk-assign local variables that are defined on the same level. Good
 *    use cases include {@link org.eclipse.xtext.common.types.JvmFormalParameter parameters} of lambdas or methods.
 *	</li>
 *  <li>{@link org.eclipse.xtext.xbase.typesystem.computation.ClosureTypeComputer ClosureTypeComputer} -
 *    The type computation of {@link org.eclipse.xtext.xbase.XClosure lambda expressions} is implemented in
 *    this utility.
 *	</li>
 * </ol>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package org.eclipse.xtext.xbase.typesystem.computation;

