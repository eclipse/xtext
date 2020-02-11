/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments

import java.util.List
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
interface IFeatureCallArguments {
	
	def boolean hasUnprocessedArguments()
	
	def IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot()
	
	/**
	 * Returns the argument expression at index {@code idx}.
	 * If there is a receiver, the index {@code 0} returns 
	 * {@code null}.
	 */
	def /* @Nullable */ XExpression getArgument(int idx)
	
	/**
	 * Returns the declared parameter type for the argument at index {@code idx}.
	 * The semantics are similar to {@link #getArgument(int)} except for var arg
	 * parameters. Var arg parameters always return the component type of the 
	 * last argument if asked for the type of the last or variable argument.
	 */
	def /* @Nullable */ LightweightTypeReference getDeclaredTypeForLambda(int idx)
	
	/**
	 * Returns the number of argument expressions where the receiver
	 * is considered to be an argument, too.
	 */
	def int getArgumentCount()
	
	def boolean isProcessed(int argumentIndex)
	
	def boolean hasEmptyTrailingVarArg()
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
interface IFeatureCallArgumentSlot {
	
	def boolean isVarArg()
	
	def boolean isSuperfluous()
	
	/**
	 * The list of expressions. The list is never <code>null</code> but may contain
	 * <code>null</code> entries.
	 */
	def List<XExpression> getArgumentExpressions()

	/**
	 * @throws IllegalStateException iff {@link #isVarArg} and the number of arguments is not equal to '1'.
	 */
	/* @Nullable */
	def XExpression getArgumentExpression()
	
	/**
	 * @throws IllegalStateException iff {@link #isSuperfluous}
	 */
	/* @Nullable */
	def LightweightTypeReference getDeclaredType()
	
	def void markProcessed()
	
}