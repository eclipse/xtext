/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeComment extends NodeHidden implements IComment {
	public NodeComment(NodeHiddenRegion gap, INode node) {
		super(gap, node);
	}
}