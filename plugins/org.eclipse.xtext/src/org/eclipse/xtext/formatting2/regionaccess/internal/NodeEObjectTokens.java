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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeEObjectTokens extends AbstractEObjectTokens {
	private final INode node;
	private final NodeModelBasedRegionAccess tokenAccess;
	private EObject semantcElement;

	public NodeEObjectTokens(NodeModelBasedRegionAccess tokenAccess, INode node) {
		super();
		this.tokenAccess = tokenAccess;
		this.node = node;
	}

	@Override
	public AbstractElement getGrammarElement() {
		INode current = node;
		while (current != null) {
			EObject grammarElement = current.getGrammarElement();
			if (GrammarUtil.isAssignedEObjectRuleCall(grammarElement))
				return (AbstractElement) grammarElement;
			if (grammarElement instanceof Action) {
				Action action = (Action) grammarElement;
				if (action.getFeature() != null)
					return (AbstractElement) grammarElement;
				else {
					EObject grammarElement2 = ((ICompositeNode) current).getFirstChild().getGrammarElement();
					if (GrammarUtil.isAssignedEObjectRuleCall(grammarElement2))
						return (AbstractElement) grammarElement2;
				}
			}
			current = current.getParent();
		}
		return null;
	}

	@Override
	public EObject getSemanticElement() {
		return semantcElement;
	}

	protected void setSemantcElement(EObject semantcElement) {
		this.semantcElement = semantcElement;
	}
}