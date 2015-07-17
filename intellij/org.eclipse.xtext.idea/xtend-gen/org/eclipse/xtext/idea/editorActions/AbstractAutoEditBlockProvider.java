/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.psi.tree.TokenSet;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AbstractIndentableAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractAutoEditBlockProvider implements AutoEditBlockProvider {
  private final List<AbstractAutoEditBlock> quotes;
  
  private final Multimap<TokenSet, AbstractIndentableAutoEditBlock> blocks;
  
  @Inject
  private Injector injector;
  
  public AbstractAutoEditBlockProvider() {
    LinkedList<AbstractAutoEditBlock> _newLinkedList = CollectionLiterals.<AbstractAutoEditBlock>newLinkedList();
    this.quotes = _newLinkedList;
    LinkedListMultimap<TokenSet, AbstractIndentableAutoEditBlock> _create = LinkedListMultimap.<TokenSet, AbstractIndentableAutoEditBlock>create();
    this.blocks = _create;
  }
  
  protected void registerQuote(final AbstractAutoEditBlock quote) {
    this.injector.injectMembers(quote);
    this.quotes.add(quote);
  }
  
  protected void registerBlock(final TokenSet tokenSet, final AbstractIndentableAutoEditBlock block) {
    this.injector.injectMembers(block);
    this.blocks.put(tokenSet, block);
  }
  
  @Override
  public Iterable<AbstractAutoEditBlock> getQuotes() {
    return this.quotes;
  }
  
  @Override
  public Iterable<AbstractIndentableAutoEditBlock> getBlocks(final TokenSet tokenSet) {
    return this.blocks.get(tokenSet);
  }
}
