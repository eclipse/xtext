/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.inject.ImplementedBy;
import com.intellij.psi.tree.TokenSet;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditBlockProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultAutoEditBlockProvider.class)
@SuppressWarnings("all")
public interface AutoEditBlockProvider {
  public abstract Iterable<AbstractAutoEditBlock> getQuotes();
  
  public abstract Iterable<AbstractIndentableAutoEditBlock> getBlocks(final TokenSet tokenSet);
}
