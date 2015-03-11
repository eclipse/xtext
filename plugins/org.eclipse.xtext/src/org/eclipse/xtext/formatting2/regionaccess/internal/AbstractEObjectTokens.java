/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractEObjectTokens {
	IHiddenRegion leadingGap;
	private final List<ISemanticRegion> tokens = Lists.newArrayList();
	IHiddenRegion trailingGap;

	public AbstractEObjectTokens() {
		super();
	}

	public abstract AbstractElement getGrammarElement();

	public IHiddenRegion getLeadingGap() {
		return leadingGap;
	}

	public abstract EObject getSemanticElement();

	public List<ISemanticRegion> getTokens() {
		return tokens;
	}

	public IHiddenRegion getTrailingGap() {
		return trailingGap;
	}

	protected void setLeadingGap(IHiddenRegion leadingGap) {
		this.leadingGap = leadingGap;
	}

	protected void setTrailingGap(IHiddenRegion trailingGap) {
		this.trailingGap = trailingGap;
	}
}