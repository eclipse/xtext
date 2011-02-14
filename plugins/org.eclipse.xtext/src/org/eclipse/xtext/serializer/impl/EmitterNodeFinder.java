/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EmitterNodeFinder {

	protected INode node;

	public EmitterNodeFinder(INode node) {
		this.node = node;
	}

	public INode next(AbstractElement grammarElement) {
		if (node == null)
			return null;
		EmitterNodeIterator ni = new EmitterNodeIterator(node, false);
		while (ni.hasNext()) {
			INode next = ni.next();
			if (next.getGrammarElement() == grammarElement)
				return node = next;
		}
		return null;
	}

}
