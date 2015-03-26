/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.debug.TokenAccessToString;
import org.eclipse.xtext.formatting2.internal.AbstractTextSegment;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeRegion extends AbstractTextSegment {
	private final INode node;
	private final NodeModelBasedRegionAccess tokenAccess;

	protected NodeRegion(NodeModelBasedRegionAccess tokenAccess, INode node) {
		super();
		this.tokenAccess = tokenAccess;
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
		return tokenAccess;
	}

	@Override
	public String toString() {
		return new TokenAccessToString().withOrigin(this).hightlightOrigin().toString();
	}
}