package org.eclipse.xtext.nodemodel.impl;

import java.util.Collections;


import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

public class CompositeNode extends AbstractNode implements ICompositeNode {

	private AbstractNode firstChild;
	
	private int lookAhead;
	
	public CompositeNode() {
	}
	
	public int getNodeType() {
		return COMPOSITE;
	}

	public Iterable<INode> getChildren() {
		if (firstChild != null)
			return firstChild;
		return Collections.emptyList();
	}

	public EObject getSemanticElement() {
		return null;
	}

	public int getLookAhead() {
		return lookAhead;
	}
	
	public TreeIterator<INode> treeIterator() {
		throw new UnsupportedOperationException();
	}
	
//	public int getChildCount() {
//		if (firstChild == null)
//			return 0;
//		return firstChild.getPrevious().getIndex();
//	}
	
	public int getTotalLength() {
		if (firstChild != null) {
			int offset = firstChild.getTotalOffset();
			AbstractNode lastChild = firstChild.getPrevious();
			return lastChild.getTotalOffset() + lastChild.getTotalLength() - offset;
		}
		throw new IllegalStateException();
	}
	
	public int getTotalOffset() {
		if (firstChild != null)
			return firstChild.getTotalOffset();
		throw new IllegalStateException();
	}

	public void setLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public AbstractNode getFirstChild() {
		return firstChild;
	}
	
	public void setFirstChild(AbstractNode firstChild) {
		if (this.firstChild != null) {
			this.firstChild.setParent(null);
		}
		this.firstChild = firstChild;
		firstChild.setParent(this);
	}
	
}
