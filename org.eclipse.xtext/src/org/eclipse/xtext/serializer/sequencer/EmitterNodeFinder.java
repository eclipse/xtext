/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmitterNodeFinder {

	@Deprecated
	protected INode toNode;
	private List<INode> emitters;
	private int index;

	public EmitterNodeFinder(INode node) {
		this.toNode = node;
		this.emitters = EmitterNodeUtil.collectEmitterNodes(node, null);
		this.index = 0;
	}

	public INode next(AbstractElement grammarElement) {
		for (int i = index; i < emitters.size(); i++) {
			INode next = emitters.get(i);
			if (next.getGrammarElement() == grammarElement) {
				index = i + 1;
				return toNode = next;
			}
		}
		return null;
	}

}
