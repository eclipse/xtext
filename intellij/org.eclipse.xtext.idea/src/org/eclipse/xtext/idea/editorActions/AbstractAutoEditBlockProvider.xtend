/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.google.common.collect.LinkedListMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import com.google.inject.Injector
import com.intellij.psi.tree.TokenSet
import java.util.List

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractAutoEditBlockProvider implements AutoEditBlockProvider {

	val List<AbstractAutoEditBlock> quotes

	val Multimap<TokenSet, AbstractIndentableAutoEditBlock> blocks

	@Inject
	Injector injector

	new() {
		this.quotes = newLinkedList
		this.blocks = LinkedListMultimap.create
	}

	protected def void registerQuote(AbstractAutoEditBlock quote) {
		injector.injectMembers(quote)
		quotes += quote
	}

	protected def void registerBlock(TokenSet tokenSet, AbstractIndentableAutoEditBlock block) {
		injector.injectMembers(block)
		blocks.put(tokenSet, block)
	}

	override getQuotes() {
		quotes
	}

	override getBlocks(TokenSet tokenSet) {
		blocks.get(tokenSet)
	}

}