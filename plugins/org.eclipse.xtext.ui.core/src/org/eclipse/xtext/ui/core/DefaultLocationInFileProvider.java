/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;


/**
 * @author Peter Friese - Implementation
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultLocationInFileProvider implements ILocationInFileProvider {

	public Region getLocation(EObject obj) {
		NodeAdapter adapter = NodeUtil.getNodeAdapter(obj);
		if (adapter == null)
			return new Region(0,0);
		
		CompositeNode startNode = adapter.getParserNode();
		EList<AbstractNode> leafNodes = startNode.getChildren();
		AbstractNode keywordNode = null;
		List<AbstractNode> idNodes = null;
		for (AbstractNode leafNode : leafNodes) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) grammarElement;
				String ruleName = ruleCall.getRule().getName();

				// TODO usually we use the name feature if the instead of the id call
				// LeafNode.getFeature()
				if (ruleName.equals("ID")) {
					if (idNodes == null) {
						idNodes = new ArrayList<AbstractNode>();
					}
					idNodes.add(leafNode);
				}
			}
			else if (grammarElement instanceof Keyword) {
				if (keywordNode == null) {
					keywordNode = leafNode;
				}
			}
		}

		if (idNodes != null) {
			// if we've got more than one ID elements, we want to select
			// them all
			AbstractNode firstIdNode = idNodes.get(0);
			AbstractNode lastIdNode = idNodes.get(idNodes.size() - 1);
			int length = (lastIdNode.getOffset() - firstIdNode.getOffset()) + lastIdNode.getLength();
			return new Region(firstIdNode.getOffset(), length);
		}
		else if (keywordNode != null) {
			return new Region(keywordNode.getOffset(), keywordNode.getLength());
		}
		else {
			return new Region(startNode.getOffset(), startNode.getLength());
		}
	}
	
}
