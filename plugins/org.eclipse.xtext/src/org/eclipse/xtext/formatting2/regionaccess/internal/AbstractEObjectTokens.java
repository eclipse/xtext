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
	private IHiddenRegion leadingHiddens;
	private EObject semantcElement;
	private final ITextRegionAccess access;
	private final List<ISemanticRegion> semanticRegions = Lists.newArrayList();
	private IHiddenRegion trailingHiddens;

	public AbstractEObjectTokens(AbstractRegionAccess access) {
		super();
		this.access = access;
	}

	public abstract AbstractElement getGrammarElement();

	public IHiddenRegion getLeadingHiddenRegion() {
		return leadingHiddens;
	}

	public EObject getSemanticElement() {
		return semantcElement;
	}

	public ITextRegionAccess getRegionAccess() {
		return access;
	}

	public List<ISemanticRegion> getSemanticRegions() {
		return semanticRegions;
	}

	public IHiddenRegion getTrailingHiddenRegion() {
		return trailingHiddens;
	}

	protected void setLeadingHiddenRegion(IHiddenRegion leading) {
		this.leadingHiddens = leading;
	}

	protected void setSemantcElement(EObject semantcElement) {
		this.semantcElement = semantcElement;
	}

	protected void setTrailingHiddenRegion(IHiddenRegion trailing) {
		this.trailingHiddens = trailing;
	}
}