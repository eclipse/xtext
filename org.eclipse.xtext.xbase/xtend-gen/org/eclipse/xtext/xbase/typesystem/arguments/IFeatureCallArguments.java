/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.arguments;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
@SuppressWarnings("all")
public interface IFeatureCallArguments {
  boolean hasUnprocessedArguments();
  
  IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot();
  
  /**
   * Returns the argument expression at index {@code idx}.
   * If there is a receiver, the index {@code 0} returns
   * {@code null}.
   */
  XExpression getArgument(final int idx);
  
  /**
   * Returns the declared parameter type for the argument at index {@code idx}.
   * The semantics are similar to {@link #getArgument(int)} except for var arg
   * parameters. Var arg parameters always return the component type of the
   * last argument if asked for the type of the last or variable argument.
   */
  LightweightTypeReference getDeclaredTypeForLambda(final int idx);
  
  /**
   * Returns the number of argument expressions where the receiver
   * is considered to be an argument, too.
   */
  int getArgumentCount();
  
  boolean isProcessed(final int argumentIndex);
  
  boolean hasEmptyTrailingVarArg();
}
