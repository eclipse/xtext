/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeSemanticRegion extends NodeRegion implements ISemanticRegion {

	private IHiddenRegion leading;
	private IHiddenRegion trailing;
	private NodeEObjectTokens eObjectTokens;

	protected NodeSemanticRegion(NodeModelBasedRegionAccess tokenAccess, INode node) {
		super(tokenAccess, node);
	}

	@Override
	public AbstractElement getGrammarElement() {
		EObject element = super.getGrammarElement();
		if (element instanceof CrossReference)
			return ((CrossReference) element).getTerminal();
		return element instanceof AbstractElement ? (AbstractElement) element : null;
	}

	@Override
	public IHiddenRegion getNextHiddenRegion() {
		return trailing;
	}

	@Override
	public ISemanticRegion getNextSemanticRegion() {
		return trailing != null ? trailing.getNextSemanticRegion() : null;
	}

	@Override
	public IHiddenRegion getPreviousHiddenRegion() {
		return leading;
	}

	@Override
	public ISemanticRegion getPreviousSemanticRegion() {
		return leading != null ? leading.getPreviousSemanticRegion() : null;
	}

	protected void setLeadingGap(IHiddenRegion leading) {
		this.leading = leading;
	}

	protected void setTrailingGap(IHiddenRegion trailing) {
		this.trailing = trailing;
	}

	protected void setEObjectTokens(NodeEObjectTokens eObjectTokens) {
		this.eObjectTokens = eObjectTokens;
	}

	@Override
	public EObject getSemanticElement() {
		return eObjectTokens != null ? eObjectTokens.getSemanticElement() : null;
	}
}