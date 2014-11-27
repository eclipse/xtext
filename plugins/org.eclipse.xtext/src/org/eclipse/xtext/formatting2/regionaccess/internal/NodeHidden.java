/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeHidden extends NodeRegion implements IHiddenRegionPart {

	private final Gap gap;

	protected NodeHidden(Gap gap, INode node) {
		super((NodeModelBaseRegionAccess) gap.getTextRegionAccess(), node);
		this.gap = gap;
	}

	@Override
	public AbstractRule getGrammarElement() {
		EObject element = super.getGrammarElement();
		return element instanceof AbstractRule ? (AbstractRule) element : null;
	}

	public IHiddenRegion getHiddenRegion() {
		return gap;
	}

	public IHiddenRegionPart getNextHiddenPart() {
		int i = gap.hiddens.indexOf(this) + 1;
		if (i < gap.hiddens.size())
			return gap.hiddens.get(i);
		return null;
	}

	public IHiddenRegionPart getPreviousHiddenPart() {
		int i = gap.hiddens.indexOf(this) - 1;
		if (i > 0)
			return gap.hiddens.get(i);
		return null;
	}

}