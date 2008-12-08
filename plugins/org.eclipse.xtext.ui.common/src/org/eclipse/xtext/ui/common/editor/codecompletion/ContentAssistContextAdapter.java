/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * Represents a custom emf adapter to adapt or extend the behaviour of emf
 * models used to provide CA related context information.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.emf.common.notify.Adapter
 */
public class ContentAssistContextAdapter extends AdapterImpl {

	private CompositeNode rootNode;

	private AbstractNode lastCompleteNode;

	private AbstractNode currentNode;

	private String prefix;

	private int offset;

	public ContentAssistContextAdapter(CompositeNode rootNode, AbstractNode currentNode, AbstractNode lastCompleteNode,
			int offset, String prefix) {
		super();
		this.rootNode = rootNode;
		this.currentNode = currentNode;
		this.lastCompleteNode = lastCompleteNode;
		this.offset = offset;
		this.prefix = prefix;
	}

	/**
	 * @return true or false wheter the cursor is at the the last complete node
	 */
	public boolean isCusorAtEndOfLastCompleteNode() {
		return lastCompleteNode == currentNode;
	}

	/**
	 * @return the grammar element of the current node
	 */
	public EObject getCurrentGrammarElement() {

		EObject grammarElement = GrammarUtil.containingAssignment(currentNode.getGrammarElement());

		if (null == grammarElement) {
			grammarElement =  (currentNode.getGrammarElement() instanceof ParserRule ? ((ParserRule) currentNode
					.getGrammarElement()).getAlternatives()
					: currentNode.getGrammarElement());
		}

		return grammarElement;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ContentAssistContextAdapter.class;
	}

	/**
	 * @return the rootNode
	 */
	public CompositeNode getRootNode() {
		return rootNode;
	}

	/**
	 * @param rootNode
	 *            the rootNode to set
	 */
	public void setRootNode(CompositeNode rootNode) {
		this.rootNode = rootNode;
	}

	/**
	 * @return the lastCompleteNode
	 */
	public AbstractNode getLastCompleteNode() {
		return lastCompleteNode;
	}

	/**
	 * @param lastCompleteNode
	 *            the lastCompleteNode to set
	 */
	public void setLastCompleteNode(AbstractNode lastCompleteNode) {
		this.lastCompleteNode = lastCompleteNode;
	}

	/**
	 * @return the currentNode
	 */
	public AbstractNode getCurrentNode() {
		return currentNode;
	}

	/**
	 * @param currentNode
	 *            the currentNode to set
	 */
	public void setCurrentNode(AbstractNode currentNode) {
		this.currentNode = currentNode;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix
	 *            the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

}
