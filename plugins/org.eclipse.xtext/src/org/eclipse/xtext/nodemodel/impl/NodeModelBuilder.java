/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;

/**
 * A statefull (!) builder that provides call back methods for clients who
 * want to create a node model and maintain its invariants. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NodeModelBuilder {

	private EObject forcedGrammarElement;
	
	public void addChild(ICompositeNode node, AbstractNode child) {
		CompositeNode composite = (CompositeNode) node;
		if (composite.basicGetFirstChild() == null) {
			checkValidNewChild(child);
			composite.basicSetFirstChild(child);
			initializeFirstChildInvariant(composite, child);
		} else {
			addPrevious(composite.basicGetFirstChild(), child);
		}
	}
	
	public void associateWithSemanticElement(ICompositeNode node, EObject astElement) {
		CompositeNodeWithSemanticElement casted = (CompositeNodeWithSemanticElement) node;
		astElement.eAdapters().add(casted);
	}
	
	public ICompositeNode newCompositeNodeAsParentOf(EObject grammarElement, int lookahead, ICompositeNode existing) {
		CompositeNodeWithSemanticElement newComposite = new CompositeNodeWithSemanticElement();
		AbstractNode castedExisting = (AbstractNode) existing;
		newComposite.basicSetGrammarElement(grammarElement);
		newComposite.basicSetLookAhead(lookahead);
		newComposite.basicSetParent(castedExisting.basicGetParent());
		if (newComposite.basicGetParent().basicGetFirstChild() == castedExisting) {
			newComposite.basicGetParent().basicSetFirstChild(newComposite);
		}
		if (castedExisting.basicGetNextSibling() == castedExisting) {
			newComposite.basicSetNextSibling(newComposite);
			newComposite.basicSetPreviousSibling(newComposite);
		} else {
			newComposite.basicSetNextSibling(castedExisting.basicGetNextSibling());
			newComposite.basicGetNextSibling().basicSetPreviousSibling(newComposite);
			newComposite.basicSetPreviousSibling(castedExisting.basicGetPreviousSibling());
			newComposite.basicGetPreviousSibling().basicSetNextSibling(newComposite);
		}
		newComposite.basicSetFirstChild(castedExisting);
		castedExisting.basicSetParent(newComposite);
		castedExisting.basicSetNextSibling(castedExisting);
		castedExisting.basicSetPreviousSibling(castedExisting);
		return compressAndReturnParent(existing);
	}

	protected void initializeFirstChildInvariant(CompositeNode node, AbstractNode child) {
		child.basicSetParent(node);
		child.basicSetNextSibling(child);
		child.basicSetPreviousSibling(child);
	}

	protected void checkValidNewChild(AbstractNode child) {
		if (child == null)
			throw new IllegalArgumentException("child may not be null");
		if (child.basicGetNextSibling() != null || child.basicGetPreviousSibling() != null)
			throw new IllegalStateException("prev has already a next or prev");
	}
	
	public void addPrevious(AbstractNode node, AbstractNode prev) {
		checkValidNewChild(prev);
		prev.basicSetPreviousSibling(node.basicGetPreviousSibling());
		prev.basicSetParent(node.basicGetParent());
		prev.basicSetNextSibling(node);
		if (node.basicGetPreviousSibling() != null) {
			node.basicGetPreviousSibling().basicSetNextSibling(prev);
		}
		node.basicSetPreviousSibling(prev);
	}
	
	public void addNext(AbstractNode node, AbstractNode next) {
		checkValidNewChild(next);
		next.basicSetNextSibling(node.basicGetNextSibling());
		next.basicSetParent(node.basicGetParent());
		next.basicSetNextSibling(node);
		if (node.basicGetNextSibling() != null) {
			node.basicGetNextSibling().basicSetNextSibling(next);
		}
		node.basicSetNextSibling(next);
	}
	
	public ICompositeNode newCompositeNode(EObject grammarElement, int lookahead, ICompositeNode parent) {
		CompositeNodeWithSemanticElement result = new CompositeNodeWithSemanticElement();
		if (forcedGrammarElement != null) {
			result.basicSetGrammarElement(forcedGrammarElement);
			forcedGrammarElement = null;
		} else {
			result.basicSetGrammarElement(grammarElement);
		}
		result.basicSetLookAhead(lookahead);
		addChild(parent, result);
		return result;
	}
	
	public ICompositeNode newRootNode(String input) {
		RootNode result = new RootNode();
		result.basicSetCompleteContent(input);
		return result;
	}

	public ILeafNode newLeafNode(int offset, int length, EObject grammarElement, boolean isHidden, String errorMessage,
			ICompositeNode parent) {
		LeafNode result = null;
		if (errorMessage != null) {
			if (isHidden) {
				result = new HiddenLeafNodeWithSyntaxError();
				((HiddenLeafNodeWithSyntaxError)result).basicSetSyntaxErrorMessage(new SyntaxErrorMessage(errorMessage, null));
			} else {
				result = new LeafNodeWithSyntaxError();
				((LeafNodeWithSyntaxError)result).basicSetSyntaxErrorMessage(new SyntaxErrorMessage(errorMessage, null));
			}
		} else {
			if (isHidden) {
				result = new HiddenLeafNode();
			} else {
				result = new LeafNode();
			}
		}
		result.basicSetGrammarElement(grammarElement);
		result.basicSetTotalOffset(offset);
		result.basicSetTotalLength(length);
		addChild(parent, result);
		return result;
	}
	
	public ICompositeNode compressAndReturnParent(ICompositeNode compositeNode) {
		CompositeNode casted = (CompositeNode) compositeNode;
//		if (casted.hasChildren() && casted.basicGetFirstChild() instanceof CompositeNode) {
//			CompositeNode mergeInto = (CompositeNode) casted.basicGetFirstChild();
//			// it is our only child
//			if (mergeInto.basicGetNextSibling() == mergeInto) {
//				// it refers not to a syntax error or a semantic object
//				if (mergeInto.getSyntaxErrorMessage() == null && casted.getSyntaxErrorMessage() == null 
//						&& mergeInto.basicGetSemanticElement() == null && casted.basicGetSemanticElement() == null
//						&& mergeInto.getLookAhead() == casted.getLookAhead()) {
//					// lets merge our grammar element into its grammar element
//					EObject newGrammarElement = casted.getGrammarElement();
//					Object oldGrammarElement = mergeInto.basicGetGrammarElement();
//					EObject[] newElements = null;
//					if (oldGrammarElement instanceof EObject) {
//						newElements = new EObject[] { newGrammarElement, (EObject) oldGrammarElement };
//					} else {
//						List<EObject> list = Lists.asList(newGrammarElement, (EObject[]) oldGrammarElement);
//						newElements =list.toArray(new EObject[list.size()]);
//					}
//					mergeInto.basicSetGrammarElement(newElements);
//					replaceWithoutChildren(casted, mergeInto);
//					casted = mergeInto;
//				}
//			}
//		}
		if (casted.basicGetSemanticElement() == null) {
			if (casted instanceof CompositeNodeWithSemanticElement) {
				if (casted.getSyntaxErrorMessage() == null) {
					CompositeNode compressed = new CompositeNode();
					compressed.basicSetGrammarElement(casted.basicGetGrammarElement());
					compressed.basicSetLookAhead(compositeNode.getLookAhead());
					replace(casted, compressed);
					return compressed.basicGetParent();
				} else {
					CompositeNodeWithSyntaxError compressed = new CompositeNodeWithSyntaxError();
					compressed.basicSetGrammarElement(casted.basicGetGrammarElement());
					compressed.basicSetLookAhead(compositeNode.getLookAhead());
					compressed.basicSetSyntaxErrorMessage(casted.getSyntaxErrorMessage());
					replace(casted, compressed);
					return compressed.basicGetParent();
				}
			}
		}
		return casted.basicGetParent();
	}
	
	public INode setSyntaxError(INode node, SyntaxErrorMessage errorMessage) {
		if (node instanceof LeafNode) {
			LeafNode oldNode = (LeafNode) node;
			LeafNode newNode = null;
			if (oldNode.isHidden()) {
				HiddenLeafNodeWithSyntaxError newLeaf = new HiddenLeafNodeWithSyntaxError();
				newLeaf.basicSetSyntaxErrorMessage(errorMessage);
				newNode = newLeaf;
			} else {
				LeafNodeWithSyntaxError newLeaf = new LeafNodeWithSyntaxError();
				newLeaf.basicSetSyntaxErrorMessage(errorMessage);
				newNode = newLeaf;
			}
			newNode.basicSetTotalLength(oldNode.getTotalLength());
			newNode.basicSetTotalOffset(oldNode.getTotalOffset());
			newNode.basicSetGrammarElement(oldNode.basicGetGrammarElement());
			replace(oldNode, newNode);
			return newNode;
		} else {
			CompositeNode oldNode = (CompositeNode) node;
			CompositeNode newNode = null;
			if (oldNode.basicGetSemanticElement() != null) {
				CompositeNodeWithSemanticElementAndSyntaxError newComposite = new CompositeNodeWithSemanticElementAndSyntaxError();
				newComposite.basicSetSemanticElement(oldNode.basicGetSemanticElement());
				newComposite.basicSetSyntaxErrorMessage(errorMessage);
				oldNode.basicGetSemanticElement().eAdapters().remove(oldNode);
				newComposite.basicGetSemanticElement().eAdapters().add(newComposite);
				newNode = newComposite;
			} else {
				CompositeNodeWithSyntaxError newComposite = new CompositeNodeWithSyntaxError();
				newComposite.basicSetSyntaxErrorMessage(errorMessage);
				newNode = newComposite;
			}
			newNode.basicSetGrammarElement(oldNode.basicGetGrammarElement());
			newNode.basicSetLookAhead(oldNode.getLookAhead());
			replace(oldNode, newNode);
			return newNode;
		}
	}

	protected void replace(AbstractNode oldNode, AbstractNode newNode) {
		replaceWithoutChildren(oldNode, newNode);
		if (oldNode instanceof CompositeNode) {
			CompositeNode oldComposite = (CompositeNode) oldNode;
			CompositeNode newComposite = (CompositeNode) newNode;
			AbstractNode child = oldComposite.basicGetFirstChild();
			if (child != null) {
				newComposite.basicSetFirstChild(child);
				while(child.basicGetParent() != newComposite) {
					child.basicSetParent(newComposite);
					child = child.basicGetNextSibling();
				}
			}
		}
	}
	
	public void replaceAndTransferLookAhead(INode oldNode, INode newRootNode) {
		AbstractNode newNode = ((CompositeNode) newRootNode).basicGetFirstChild();
		replaceWithoutChildren((AbstractNode) oldNode, newNode);
		if (oldNode instanceof ICompositeNode) {
			CompositeNode newCompositeNode = (CompositeNode) newNode;
			newCompositeNode.basicSetLookAhead(((ICompositeNode) oldNode).getLookAhead());
			// todo: unfold both nodes and compress afterwards
		}
		ICompositeNode root = newNode.getRootNode();
		BidiTreeIterator<AbstractNode> iterator = ((AbstractNode) root).basicTreeIterator();
		Iterator<LeafNode> leafNodeIter = Iterators.filter(iterator, LeafNode.class);
		int offset = 0;
		while(leafNodeIter.hasNext()) {
			LeafNode leafNode = leafNodeIter.next();
			leafNode.basicSetTotalOffset(offset);
			offset += leafNode.getTotalLength();
		}
	}

	protected void replaceWithoutChildren(AbstractNode oldNode, AbstractNode newNode) {
		newNode.basicSetParent(oldNode.basicGetParent());
		if ((oldNode.basicGetParent()).basicGetFirstChild() == oldNode) {
			(newNode.basicGetParent()).basicSetFirstChild(newNode);
		}
		if (oldNode.basicGetNextSibling() == oldNode) {
			newNode.basicSetNextSibling(newNode);
		} else {
			newNode.basicSetNextSibling(oldNode.basicGetNextSibling());
			newNode.basicGetNextSibling().basicSetPreviousSibling(newNode);
		}
		if (oldNode.getPreviousSibling() == oldNode) {
			newNode.basicSetPreviousSibling(newNode);
		} else {
			newNode.basicSetPreviousSibling(oldNode.basicGetPreviousSibling());
			newNode.basicGetPreviousSibling().basicSetNextSibling(newNode);
		}
	}

	public void setCompleteContent(ICompositeNode rootNode, String completeContent) {
		((RootNode)rootNode).basicSetCompleteContent(completeContent);
	}

	public void setForcedFirstGrammarElement(RuleCall ruleCall) {
		this.forcedGrammarElement = ruleCall;
	}

}
