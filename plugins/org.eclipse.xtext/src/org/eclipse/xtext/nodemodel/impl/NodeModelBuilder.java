/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelBuilder {

	public void addChild(ICompositeNode node, AbstractNode child) {
		CompositeNode composite = (CompositeNode) node;
		if (composite.getFirstChild() == null) {
			checkValidNewChild(child);
			composite.basicSetFirstChild(child);
			initializeFirstChildInvariant(composite, child);
		} else {
			addPrevious(composite.getFirstChild(), child);
		}
	}
	
	public void associateWithSemanticElement(ICompositeNode node, EObject astElement) {
		CompositeNodeWithSemanticElement casted = (CompositeNodeWithSemanticElement) node;
		astElement.eAdapters().add(casted);
	}
	
	public ICompositeNode newCompositeNodeAsParentOf(EObject grammarElement, int lookahead, ICompositeNode existing) {
		CompositeNodeWithSemanticElement newComposite = new CompositeNodeWithSemanticElement();
		AbstractNode castedExisting = (AbstractNode) existing;
		newComposite.setGrammarElement(grammarElement);
		newComposite.setLookAhead(lookahead);
		newComposite.basicSetParent(castedExisting.getParent());
		if (newComposite.getParent().getFirstChild() == castedExisting) {
			newComposite.getParent().basicSetFirstChild(newComposite);
		}
		if (castedExisting.getNext() == castedExisting) {
			newComposite.basicSetNext(newComposite);
			newComposite.basicSetPrevious(newComposite);
		} else {
			newComposite.basicSetNext(castedExisting.getNext());
			newComposite.getNext().basicSetPrevious(newComposite);
			newComposite.basicSetPrevious(castedExisting.getPrevious());
			newComposite.getPrevious().basicSetNext(newComposite);
		}
		newComposite.basicSetFirstChild(castedExisting);
		castedExisting.basicSetParent(newComposite);
		castedExisting.basicSetNext(castedExisting);
		castedExisting.basicSetPrevious(castedExisting);
		compress(existing);
		return newComposite;
	}

	protected void initializeFirstChildInvariant(CompositeNode node, AbstractNode child) {
		child.basicSetParent(node);
		child.basicSetNext(child);
		child.basicSetPrevious(child);
	}

	protected void checkValidNewChild(AbstractNode child) {
		if (child == null)
			throw new IllegalArgumentException("child may not be null");
		if (child.getNext() != null || child.getPrevious() != null)
			throw new IllegalStateException("prev has already a next or prev");
	}
	
	public void addPrevious(AbstractNode node, AbstractNode prev) {
		checkValidNewChild(prev);
		prev.basicSetPrevious(node.getPrevious());
		prev.basicSetParent(node.getParent());
		prev.basicSetNext(node);
		if (node.getPrevious() != null) {
			node.getPrevious().basicSetNext(prev);
		}
		node.basicSetPrevious(prev);
	}
	
	public void addNext(AbstractNode node, AbstractNode next) {
		checkValidNewChild(next);
		next.basicSetNext(node.getNext());
		next.basicSetParent(node.getParent());
		next.basicSetNext(node);
		if (node.getNext() != null) {
			node.getNext().basicSetNext(next);
		}
		node.basicSetNext(next);
	}
	
	public ICompositeNode newCompositeNode(EObject grammarElement, int lookahead, ICompositeNode parent) {
		CompositeNodeWithSemanticElement result = parent != null ? new CompositeNodeWithSemanticElement() : new RootNode();
		result.setGrammarElement(grammarElement);
		result.setLookAhead(lookahead);
		if (parent != null)
			addChild(parent, result);
		return result;
	}

	public ILeafNode newLeafNode(int offset, int length, EObject grammarElement, boolean isHidden, String errorMessage,
			ICompositeNode parent) {
		LeafNode result = null;
		if (errorMessage != null) {
			if (isHidden) {
				result = new HiddenLeafNodeWithSyntaxError();
				((HiddenLeafNodeWithSyntaxError)result).setSyntaxErrorMessage(new SyntaxErrorMessage(errorMessage, null));
			} else {
				result = new LeafNodeWithSyntaxError();
				((LeafNodeWithSyntaxError)result).setSyntaxErrorMessage(new SyntaxErrorMessage(errorMessage, null));
			}
		} else {
			if (isHidden) {
				result = new HiddenLeafNode();
			} else {
				result = new LeafNode();
			}
		}
		result.setGrammarElement(grammarElement);
		result.setTotalOffset(offset);
		result.setTotalLength(length);
		addChild(parent, result);
		return result;
	}
	
	public void compress(ICompositeNode compositeNode) {
		CompositeNode casted = (CompositeNode) compositeNode;
		if (casted.basicGetSemanticElement() == null) {
			if (compositeNode instanceof CompositeNodeWithSemanticElement) {
				if (casted.getSyntaxErrorMessage() == null) {
					CompositeNode compressed = new CompositeNode();
					compressed.setGrammarElement(compositeNode.getGrammarElement());
					compressed.setLookAhead(compositeNode.getLookAhead());
					replace(casted, compressed);
				} else {
					CompositeNodeWithSyntaxError compressed = new CompositeNodeWithSyntaxError();
					compressed.setGrammarElement(compositeNode.getGrammarElement());
					compressed.setLookAhead(compositeNode.getLookAhead());
					compressed.setSyntaxErrorMessage(casted.getSyntaxErrorMessage());
					replace(casted, compressed);
				}
			}
		}
	}
	
	public INode setSyntaxError(INode node, SyntaxErrorMessage errorMessage) {
		if (node instanceof LeafNode) {
			LeafNode oldNode = (LeafNode) node;
			LeafNode newNode = null;
			if (oldNode.isHidden()) {
				HiddenLeafNodeWithSyntaxError newLeaf = new HiddenLeafNodeWithSyntaxError();
				newLeaf.setSyntaxErrorMessage(errorMessage);
				newNode = newLeaf;
			} else {
				LeafNodeWithSyntaxError newLeaf = new LeafNodeWithSyntaxError();
				newLeaf.setSyntaxErrorMessage(errorMessage);
				newNode = newLeaf;
			}
			newNode.setTotalLength(oldNode.getTotalLength());
			newNode.setTotalOffset(oldNode.getTotalOffset());
			newNode.setGrammarElement(oldNode.getGrammarElement());
			replace(oldNode, newNode);
			return newNode;
		} else {
			CompositeNode oldNode = (CompositeNode) node;
			CompositeNode newNode = null;
			if (oldNode.basicGetSemanticElement() != null) {
				CompositeNodeWithSemanticElementAndSyntaxError newComposite = new CompositeNodeWithSemanticElementAndSyntaxError();
				newComposite.setSemanticElement(oldNode.basicGetSemanticElement());
				newComposite.setSyntaxErrorMessage(errorMessage);
				oldNode.basicGetSemanticElement().eAdapters().remove(oldNode);
				newComposite.basicGetSemanticElement().eAdapters().add(newComposite);
				newNode = newComposite;
			} else {
				CompositeNodeWithSyntaxError newComposite = new CompositeNodeWithSyntaxError();
				newComposite.setSyntaxErrorMessage(errorMessage);
				newNode = newComposite;
			}
			newNode.setGrammarElement(oldNode.getGrammarElement());
			newNode.setLookAhead(oldNode.getLookAhead());
			replace(oldNode, newNode);
			return newNode;
		}
	}

	protected void replace(AbstractNode oldNode, AbstractNode newNode) {
		newNode.basicSetParent(oldNode.getParent());
		if ((oldNode.getParent()).getFirstChild() == oldNode) {
			(oldNode.getParent()).basicSetFirstChild(newNode);
		}
		if (oldNode.getNext() == oldNode) {
			newNode.basicSetNext(newNode);
		} else {
			newNode.basicSetNext(oldNode.getNext());
			newNode.getNext().basicSetPrevious(newNode);
		}
		if (oldNode.getPrevious() == oldNode) {
			newNode.basicSetPrevious(newNode);
		} else {
			newNode.basicSetPrevious(oldNode.getPrevious());
			newNode.getPrevious().basicSetNext(newNode);
		}
		if (oldNode instanceof CompositeNode) {
			CompositeNode oldComposite = (CompositeNode) oldNode;
			CompositeNode newComposite = (CompositeNode) newNode;
			AbstractNode child = oldComposite.getFirstChild();
			if (child != null) {
				newComposite.basicSetFirstChild(child);
				while(child.getParent() != newComposite) {
					child.basicSetParent(newComposite);
					child = child.getNext();
				}
			}
		}
	}

}
