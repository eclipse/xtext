/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializedHidden extends SerializedRegion implements IHiddenRegionPart {
	private final AbstractHiddenRegion hiddenRegion;
	private final AbstractRule rule;

	protected SerializedHidden(AbstractHiddenRegion gap, AbstractRule rule, int offset, String text) {
		super((SerializerBasedRegionAccess) gap.getTextRegionAccess(), offset, text);
		this.hiddenRegion = gap;
		this.rule = rule;
	}

	@Override
	public AbstractRule getGrammarElement() {
		return rule;
	}

	@Override
	public IHiddenRegion getHiddenRegion() {
		return hiddenRegion;
	}

	@Override
	public IHiddenRegionPart getNextHiddenPart() {
		int i = hiddenRegion.hiddens.indexOf(this) + 1;
		if (i < hiddenRegion.hiddens.size())
			return hiddenRegion.hiddens.get(i);
		return null;
	}

	@Override
	public IHiddenRegionPart getPreviousHiddenPart() {
		int i = hiddenRegion.hiddens.indexOf(this) - 1;
		if (i > 0)
			return hiddenRegion.hiddens.get(i);
		return null;
	}

}