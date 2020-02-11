/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.regionaccess.HiddenRegionPartAssociation;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringHidden extends StringRegion implements IHiddenRegionPart {
	private final AbstractHiddenRegion hiddenRegion;
	private final AbstractRule rule;
	private HiddenRegionPartAssociation association = null;

	protected StringHidden(AbstractHiddenRegion hidden, AbstractRule rule, int offset, int lenght) {
		super((StringBasedRegionAccess) hidden.getTextRegionAccess(), offset, lenght);
		this.hiddenRegion = hidden;
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
		List<IHiddenRegionPart> parts = hiddenRegion.getParts();
		int i = parts.indexOf(this) + 1;
		if (i < parts.size())
			return parts.get(i);
		return null;
	}

	@Override
	public IHiddenRegionPart getPreviousHiddenPart() {
		List<IHiddenRegionPart> parts = hiddenRegion.getParts();
		int i = parts.indexOf(this) - 1;
		if (i > 0)
			return parts.get(i);
		return null;
	}

	protected void setAssociation(HiddenRegionPartAssociation association) {
		this.association = association;
	}

	@Override
	public HiddenRegionPartAssociation getAssociation() {
		if (association == null) {
			hiddenRegion.initAssociations();
		}
		return association;
	}

}