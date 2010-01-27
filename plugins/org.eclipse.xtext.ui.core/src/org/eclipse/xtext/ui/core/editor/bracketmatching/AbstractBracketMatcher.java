/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.bracketmatching;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.BiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * convenience implementation of {@link IBracketMatcher}, which uses pairs of
 * grammar elements, to compute forward and backward bracket matching.
 * 
 */
public abstract class AbstractBracketMatcher implements IBracketMatcher {
	
	/**
	 * override this method to provide pairs of grammar elements.
	 */
	public abstract void configure(IBracketPairAcceptor acceptor);
	
	public interface IBracketPairAcceptor {
		void accept(AbstractElement left, AbstractElement right);
	}
	
	public IRegion computeMatchingRegion(XtextResource state, int offset) {
		if (state.getContents().isEmpty()) 
			return null;
		CompositeNode rootNode = NodeUtil.getRootNode(state.getContents().get(0));
		if (rootNode==null)
			return null;
		AbstractNode node = NodeUtil.findLeafNodeAtOffset(rootNode, offset);
		if (node==null)
			return null;
		AbstractElement element = findElement(node, getPairs());
		boolean forwardSearch = true;
		if (element == null) {
			forwardSearch = false;
			element = findElement(node, getPairs().inverse());
		}
		if (element != null) {
			AbstractNode correspondingNode = findMatchingNode(node, element,
					forwardSearch);
			if (correspondingNode != null) {
				return new Region(correspondingNode.getOffset(), correspondingNode.getLength());
			}
		}
		return null;
	}
	
	private BiMap<AbstractElement, AbstractElement> pairs = null;
	protected BiMap<AbstractElement, AbstractElement> getPairs() {
		if (pairs==null) {
			pairs = Maps.newHashBiMap();
			configure(new IBracketPairAcceptor() {
				public void accept(AbstractElement left, AbstractElement right) {
					pairs.put(left,right);
				}
			});
		}
		return pairs;
	}
	protected AbstractElement findElement(AbstractNode node, Map<AbstractElement, AbstractElement> map) {
		EObject grammarElement = node.getGrammarElement();
		return map.get(grammarElement);
	}
	
	protected AbstractNode findMatchingNode(AbstractNode node, AbstractElement element, boolean forwardSearch) {
		CompositeNode node2 = findRuleCallNode(node);
		if (node2==null)
			return null;
		Iterable<AbstractNode> children = getAllNodesInRule(node2.getChildren());
		boolean match = !forwardSearch;
		for (AbstractNode abstractNode : children) {
			if (abstractNode==node) {
				match = !match;
			} else {
				if (match && abstractNode.getGrammarElement()==element) {
					return abstractNode;
				}
			}
		}
		return null;
	}
	
	protected List<AbstractNode> getAllNodesInRule(List<AbstractNode> nodes) {
		List<AbstractNode> result = Lists.newArrayList();
		for (AbstractNode n : nodes) {
			if (!(n.getGrammarElement() instanceof RuleCall)) {
				result.add(n);
				if (n instanceof CompositeNode) {
					result.addAll(getAllNodesInRule(((CompositeNode) n).getChildren()));
				}
			}
		}
		return result;
	}
	
	protected CompositeNode findRuleCallNode(AbstractNode node) {
		while (node!=null && !(node.getGrammarElement() instanceof RuleCall))
			node = (AbstractNode) node.eContainer();
		return (CompositeNode) node;
	}
	
}