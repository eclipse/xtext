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
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractEObjectTokens {
	private IHiddenRegion leadingGap;
	private EObject semantcElement;
	private final ITextRegionAccess tokenAccess;
	private final List<ISemanticRegion> tokens = Lists.newArrayList();
	private IHiddenRegion trailingGap;

	public AbstractEObjectTokens(AbstractRegionAccess tokenAccess) {
		super();
		this.tokenAccess = tokenAccess;
	}

	public abstract AbstractElement getGrammarElement();

	public IHiddenRegion getLeadingGap() {
		return leadingGap;
	}

	public EObject getSemanticElement() {
		return semantcElement;
	}

	public ITextRegionAccess getTokenAccess() {
		return tokenAccess;
	}

	public List<ISemanticRegion> getTokens() {
		return tokens;
	}

	public IHiddenRegion getTrailingGap() {
		return trailingGap;
	}

	protected void setLeadingGap(IHiddenRegion leadingGap) {
		this.leadingGap = leadingGap;
	}

	protected void setSemantcElement(EObject semantcElement) {
		this.semantcElement = semantcElement;
	}

	protected void setTrailingGap(IHiddenRegion trailingGap) {
		this.trailingGap = trailingGap;
	}
}