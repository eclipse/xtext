/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.parser;

import com.google.inject.ImplementedBy;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtext.xbase.idea.parser.DefaultOperatorTokenTypeProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultOperatorTokenTypeProvider.class)
@SuppressWarnings("all")
public interface OperatorTokenTypeProvider {
  public abstract TokenSet getOperatorTokens();
}
