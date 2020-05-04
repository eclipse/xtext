/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.xtext.Action;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;

/**
 * Utility to work with the lookAhead information in the node model.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.22
 */
@Beta
public class LookAheadInfo {

	/* TODO 
	 * - add getLookAhead(INode node) with support for leaf-nodes
	 * - add getLookBeyond(INode node)
	 * - getParserInformation(int offset): ParserInformation with ParserInformation( ParserRule, TextRegion, Iterator**) 
	 *   usable for content assist, e.g. it must support parameterized rule stack recreation
	 * - getEntryPoint(int offset, int length, String newText) with support for partial parsing (consider lookBeyond)
	 * - Iterator** returns an iterator over nodes from the entry point to the position such that
	 *   the parser would reach the position as fast as possible, e.g. an iterator that skips over
	 *   regions that are not relevant to the parsers decision
	 * - INode.getLookAheadInfo(): LookAheadInfo as default method that uses the resource to obtain an 
	 *   injectable LookAheadInfo.Factory from allow customization
	 */
	
	public static class InconsistentLookAheadException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public InconsistentLookAheadException(String message, Throwable cause) {
			super(message, cause);
		}

		public InconsistentLookAheadException(String message) {
			super(message);
		}
		
	}

	private final ICompositeNode rootNode;

	public LookAheadInfo(ICompositeNode rootNode) {
		Preconditions.checkArgument(rootNode.getRootNode() == rootNode);
		this.rootNode = rootNode;
	}
	
	public void checkConsistency() throws InconsistentLookAheadException {
		AtomicInteger currentLookAhead = new AtomicInteger();
		for(INode node: rootNode.getAsTreeIterable()) {
			checkConsistency(node, currentLookAhead);
		}
	}
	
	protected void checkConsistency(INode node, AtomicInteger currentLookAhead) {
		if (node instanceof ICompositeNode) {
			checkConsistency((ICompositeNode)node, currentLookAhead);
		} else {
			checkConsistency((ILeafNode)node, currentLookAhead);
		}
	}
	
	protected void checkConsistency(ICompositeNode node, AtomicInteger currentLookAhead) {
		int nodeLookAhead = node.getLookAhead();
		if (node.getGrammarElement() instanceof Action) {
			ICompositeNode firstChild = (ICompositeNode) node.getFirstChild();
			if (firstChild.getLookAhead() != nodeLookAhead) {
				throw new InconsistentLookAheadException(
						String.format("Action nodes must have the lookahead of their first child. Expected %d but was %d at offset %d (%s)", nodeLookAhead, firstChild.getLookAhead(), node.getTotalOffset(), node.getText()));
			}
		}
		if (nodeLookAhead > currentLookAhead.get()) {
			currentLookAhead.set(nodeLookAhead);
		} else if (nodeLookAhead < currentLookAhead.get()) {
			throw new InconsistentLookAheadException(
					String.format("Expected at least %d but found %d at offset %d (%s)", currentLookAhead.get(), nodeLookAhead, node.getTotalOffset(), node.getText()));
		}
	}
	
	protected void checkConsistency(ILeafNode node, AtomicInteger currentLookAhead) {
		if (!node.isHidden()) {
			currentLookAhead.updateAndGet(old->old > 0 ? old - 1 : old);
		}
	}
	
}
