/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.parser;

import java.util.Iterator;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;

/**
 * This is required together with the {@link TokenSequencePreservingPartialParsingHelper}.
 * 
 * During partial parsing, the resulting token sequence is equal to the old sequence
 * thus the lookahead can be losslessly transfered from the old node to the new node. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 * @noextend This class is not intended to be subclassed by clients.
 * @nooverride This method is not intended to be re-implemented or extended by clients.
 * @noreference This method is not intended to be referenced by clients.
 */
public class LookAheadPreservingNodeModelBuilder extends NodeModelBuilder {

	@Override
	public void replaceAndTransferLookAhead(INode oldNode, INode newRootNode) {
		Iterator<AbstractNode> oldNodes = ((AbstractNode) oldNode).basicIterator();
		Iterator<AbstractNode> newNodes = ((AbstractNode) newRootNode).basicIterator();
		newNodes.next(); // basicGetFirstChild to skip that one
		while(oldNodes.hasNext()) {
			AbstractNode nextOld = oldNodes.next();
			AbstractNode nextNew = newNodes.next();
			if (nextOld instanceof CompositeNode) {
				setLookAhead((CompositeNode) nextNew, ((CompositeNode) nextOld).getLookAhead());
			}
		}
		if (newNodes.hasNext()) {
			throw new RuntimeException();
		}
		super.replaceAndTransferLookAhead(oldNode, newRootNode);
	}
	
}
