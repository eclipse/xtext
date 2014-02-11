/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.util.Iterator;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;

/**
 * This is required together with the {@link XtendPartialParsingHelper}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendNodeModelBuilder extends org.eclipse.xtext.nodemodel.impl.NodeModelBuilder {

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
