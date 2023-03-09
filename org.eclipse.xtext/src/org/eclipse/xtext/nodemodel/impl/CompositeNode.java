/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.nodemodel.util.EmptyBidiIterable;
import org.eclipse.xtext.nodemodel.util.NodeIterable;
import org.eclipse.xtext.nodemodel.util.SingletonBidiIterable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Mark Christiaens - Serialization support
 * @noextend This class is not intended to be subclassed by clients.
 */
public class CompositeNode extends AbstractNode implements ICompositeNode {

	private AbstractNode firstChild;
	
	private int lookAhead;
	
	@Override
	public BidiIterable<INode> getChildren() {
		if (hasChildren()) {
			INode firstChild = getFirstChild();
			if (firstChild.hasSiblings()) {
				return new NodeIterable(firstChild);
			} else {
				return SingletonBidiIterable.<INode>create(firstChild);
			}
		}
		return EmptyBidiIterable.instance();
	}
	
	public BidiIterable<AbstractNode> basicGetChildren() {
		if (firstChild != null) {
			if (firstChild.hasSiblings()) {
				return new BasicNodeIterable(firstChild);
			} else {
				return SingletonBidiIterable.create(basicGetFirstChild());
			}
		}
		return EmptyBidiIterable.instance();
	}
	
	@Override
	public boolean hasChildren() {
		return firstChild != null || isFolded();
	}

	@Override
	public int getLookAhead() {
		return lookAhead;
	}
	
	@Override
	public int getTotalLength() {
		if (firstChild != null) {
			int offset = firstChild.getTotalOffset();
			AbstractNode lastChild = firstChild.basicGetPreviousSibling();
			return lastChild.getTotalOffset() + lastChild.getTotalLength() - offset;
		}
		return 0;
	}
	
	@Override
	public int getTotalOffset() {
		if (firstChild != null)
			return firstChild.getTotalOffset();
		AbstractNode compositeWithSiblings = this;
		while(!compositeWithSiblings.basicHasNextSibling() && compositeWithSiblings.basicGetParent() != null) {
			compositeWithSiblings = compositeWithSiblings.basicGetParent();
		}
		if (compositeWithSiblings.basicHasNextSibling()) {
			AbstractNode sibling = compositeWithSiblings.basicGetNextSibling();
			return sibling.getTotalOffset();
		}
		// expensive fallback - should never happen in a valid node model
		BidiTreeIterator<INode> iter = getRootNode().getAsTreeIterable().iterator();
		ILeafNode lastSeen = null;
		while(iter.hasNext()) {
			INode next = iter.next();
			if (next == this) {
				if (lastSeen == null)
					return 0;
				else
					return lastSeen.getTotalEndOffset();
			}
			if (next instanceof ILeafNode) {
				lastSeen = (ILeafNode) next;
			}
		}
		return 0;
	}

	protected void basicSetLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	@Override
	public INode getFirstChild() {
		if (isFolded()) {
			return new SyntheticCompositeNode(this, 1);
		}
		return firstChild;
	}
	
	protected AbstractNode basicGetFirstChild() {
		return firstChild;
	}
	
	protected void basicSetFirstChild(AbstractNode firstChild) {
		this.firstChild = firstChild;
	}
	
	@Override
	public INode getLastChild() {
		if (isFolded()) {
			return new SyntheticCompositeNode(this, 1);
		}
		return basicGetLastChild();
	}
	
	protected AbstractNode basicGetLastChild() {
		if (firstChild == null)
			return null;
		return firstChild.basicGetPreviousSibling();
	}
	
	protected boolean isFolded() {
		Object grammarElementOrArray = basicGetGrammarElement();
		return isFolded(grammarElementOrArray);
	}

	protected boolean isFolded(Object grammarElementOrArray) {
		return !(grammarElementOrArray == null || grammarElementOrArray instanceof EObject);
	}
	
	public ICompositeNode resolveAsParent() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (!isFolded())
			return this;
		EObject[] grammarElements = (EObject[]) grammarElementOrArray;
		return new SyntheticCompositeNode(this, grammarElements.length - 1);
	}	
	
	@Override
	public EObject getGrammarElement() {
		Object grammarElementOrArray = basicGetGrammarElement();
		if (!isFolded())
			return (EObject) grammarElementOrArray;
		EObject[] grammarElements = (EObject[]) grammarElementOrArray;
		return grammarElements[0];
	}

	private static final NodeType[] NODE_TYPE_VALUES = NodeType.values();
	
	@Override 
	protected void readData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		super.readData(in, context);

		int childNodeCount = SerializationUtil.readInt(in, true);

		if (childNodeCount > 0) {
			AbstractNode child = null;
			AbstractNode prevChild = null;
			for (int i = 0; i < childNodeCount; ++i) {
				int nodeId = SerializationUtil.readInt(in, true);
				NodeType nodeType = NODE_TYPE_VALUES[nodeId];
				child = createChildNode(nodeType);
				child.readData(in, context);

				if (firstChild == null) {
					firstChild = child;
				}

				child.basicSetParent(this);
				child.basicSetPreviousSibling(prevChild);

				prevChild = child;
			}

			firstChild.basicSetPreviousSibling(child);

			// All left links are fine, now the right ones

			child = firstChild.basicGetPreviousSibling();
			prevChild = firstChild;

			while (child != firstChild) {
				child.basicSetNextSibling(prevChild);
				prevChild = child;
				child = child.basicGetPreviousSibling();
			}

			firstChild.basicSetNextSibling(prevChild);
		}

		lookAhead = SerializationUtil.readInt(in, true);
	}
	
	private AbstractNode createChildNode(AbstractNode.NodeType type) {
		switch (type) {
			case CompositeNode:
				return new CompositeNode();
			case CompositeNodeWithSemanticElement:
				return new CompositeNodeWithSemanticElement();
			case CompositeNodeWithSemanticElementAndSyntaxError:
				return new CompositeNodeWithSemanticElementAndSyntaxError();
			case CompositeNodeWithSyntaxError:
				return new CompositeNodeWithSyntaxError();
			case HiddenLeafNode:
				return new HiddenLeafNode();
			case HiddenLeafNodeWithSyntaxError:
				return new HiddenLeafNodeWithSyntaxError();
			case LeafNode:
				return new LeafNode();
			case LeafNodeWithSyntaxError:
				return new LeafNodeWithSyntaxError();
			case RootNode:
				return new RootNode();
			default:
				throw new IllegalArgumentException("Trying to construct a non-existing INode");
		}
	}
	
	@Override
	protected void write(DataOutputStream out, SerializationConversionContext scc) throws IOException {
		super.write(out, scc);

		int childNodeCount = getChildCount();
		SerializationUtil.writeInt(out, childNodeCount, true);

		AbstractNode it = firstChild;

		for (int i = 0; i < childNodeCount; ++i) {
			SerializationUtil.writeInt(out, it.getNodeId().ordinal(), true);
			it.write(out, scc);
			it = it.basicGetNextSibling();
		}

		SerializationUtil.writeInt(out, lookAhead, true);
	}

	private int getChildCount() {
		if (firstChild == null) {
			return 0;
		}

		AbstractNode it = firstChild;
		int count = 0;

		do {
			++count;
			it = it.basicGetNextSibling();
		} while (it != firstChild);

		return count;
	}

	@Override
	int fillGrammarElementToIdMap(int currentId, Map<EObject, Integer> grammarElementToIdMap,
			List<String> grammarIdToURIMap) {
		currentId = super.fillGrammarElementToIdMap(currentId, grammarElementToIdMap, grammarIdToURIMap);

		if (firstChild != null) {
			AbstractNode it = firstChild;

			do {
				currentId = it.fillGrammarElementToIdMap(currentId, grammarElementToIdMap, grammarIdToURIMap);
				it = it.basicGetNextSibling();
			} while (it != firstChild);
		}

		return currentId;
	}

	@Override
	protected NodeType getNodeId() {
		return NodeType.CompositeNode;
	}
}
