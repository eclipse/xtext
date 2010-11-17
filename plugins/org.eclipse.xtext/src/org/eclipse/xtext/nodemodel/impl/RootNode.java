/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootNode implements ICompositeNode, Adapter {

	private String completeContent;
	
	private EObject rootSemanticObject;
	
	private EObject grammarElement;
	
	private AbstractNode firstChild;
	
	private int lookAhead;
	
	/**
	 * @return <code>null</code> the root node does not have any parent.
	 */
	public ICompositeNode getParent() {
		return null;
	}

	public TreeIterator<INode> treeIterator() {
		throw new UnsupportedOperationException();
	}

	public int getTotalOffset() {
		return 0;
	}

	public int getTotalLength() {
		return getCompleteContent().length();
	}

	public String getText() {
		return getCompleteContent();
	}

	public EObject getGrammarElement() {
		return grammarElement;
	}

	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}

	public int getNodeType() {
		return ROOT | COMPOSITE | SEMANTIC_MODEL_REFERENCE;
	}

	public Iterator<INode> iterator() {
		throw new UnsupportedOperationException();
	}

	public void notifyChanged(Notification notification) {
		// ignore
	}

	public Notifier getTarget() {
		return getSemanticElement();
	}

	public void setTarget(Notifier newTarget) {
		if (newTarget == null || newTarget instanceof EObject)
			rootSemanticObject = (EObject) newTarget;
		else
			throw new IllegalArgumentException("Notifier must be an Eobject");
	}

	public boolean isAdapterForType(Object type) {
		return INode.class.isAssignableFrom((Class<?>)type);
	}

	public Iterable<INode> getChildren() {
		if (firstChild != null)
			return firstChild;
		return Collections.emptyList();
	}

	public EObject getSemanticElement() {
		return rootSemanticObject;
	}

	public int getLookAhead() {
		return lookAhead;
	}
	
	public int getIndex() {
		return 0;
	}
	
	public void setCompleteContent(String completeContent) {
		this.completeContent = completeContent;
	}

	public String getCompleteContent() {
		return completeContent;
	}

	public void setGrammarElement(EObject grammarElement) {
		this.grammarElement = grammarElement;
	}

	public AbstractNode getFirstChild() {
		return firstChild;
	}
	
	public void setFirstChild(AbstractNode firstChild) {
		if (this.firstChild != null) {
			this.firstChild.setParent(null);
		}
		this.firstChild = firstChild;
		if (firstChild != null) {
			firstChild.setParent(this);
			firstChild.addNext(firstChild);
			firstChild.addPrevious(firstChild);
		}
	}
	
	public void addChild(AbstractNode child) {
		if (firstChild == null)
			setFirstChild(child);
		else {
			firstChild.addPrevious(child);
		}
	}

	public void setSemanticElement(EObject element) {
		this.rootSemanticObject = element;
	}

}
