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
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessage;

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
		throw new UnsupportedOperationException();
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
	
//	public int getChildCount() {
//		if (firstChild == null)
//			return 0;
//		return firstChild.getPrevious().getIndex();
//	}

	public void setCompleteContent(String completeContent) {
		this.completeContent = completeContent;
	}

	public String getCompleteContent() {
		return completeContent;
	}

	public void setGrammarElement(EObject grammarElement) {
		this.grammarElement = grammarElement;
	}

	public void setFirstChild(AbstractNode firstChild) {
		if (this.firstChild != null) {
			this.firstChild.setParent(null);
		}
		this.firstChild = firstChild;
		firstChild.setParent(this);
	}

	public void setSemanticElement(EObject element) {
		this.rootSemanticObject = element;
	}
	
}
