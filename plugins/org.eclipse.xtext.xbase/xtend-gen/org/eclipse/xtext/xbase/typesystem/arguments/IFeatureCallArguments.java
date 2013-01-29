/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.arguments;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.arguments.IFeatureCallArgumentSlot;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
@NonNullByDefault
@SuppressWarnings("all")
public interface IFeatureCallArguments {
  public abstract boolean hasUnprocessedArguments();
  
  public abstract IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot();
  
  public abstract XExpression getArgument(final int idx);
  
  public abstract int getArgumentCount();
  
  public abstract boolean isProcessed(final int argumentIndex);
}
