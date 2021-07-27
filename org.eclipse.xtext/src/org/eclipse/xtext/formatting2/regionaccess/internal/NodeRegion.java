/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeRegion extends AbstractTextSegment {
	private final INode node;
	private final NodeModelBasedRegionAccess access;

	protected NodeRegion(NodeModelBasedRegionAccess access, INode node) {
		super();
		this.access = access;
		this.node = node;
	}

	public EObject getGrammarElement() {
		return node.getGrammarElement();
	}

	@Override
	public int getLength() {
		return node.getLength();
	}

	public INode getNode() {
		return node;
	}

	@Override
	public int getOffset() {
		return node.getOffset();
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return access;
	}

	@Override
	public String toString() {
		return new TextRegionAccessToString().withOrigin(this).highlightOrigin().toString();
	}
}
