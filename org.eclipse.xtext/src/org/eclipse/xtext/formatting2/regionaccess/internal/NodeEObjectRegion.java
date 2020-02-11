/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeEObjectRegion extends AbstractEObjectRegion {
	private final INode node;

	public NodeEObjectRegion(NodeModelBasedRegionAccess access, INode node) {
		super(access);
		this.node = node;
	}

	public INode getNode() {
		return node;
	}

}
