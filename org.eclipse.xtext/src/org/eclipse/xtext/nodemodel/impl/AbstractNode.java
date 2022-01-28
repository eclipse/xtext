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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.nodemodel.util.NodeTreeIterator;
import org.eclipse.xtext.nodemodel.util.ReversedBidiTreeIterable;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Mark Christiaens - Serialization support
 * @noextend This class is not intended to be subclassed by clients.
 */
public abstract class AbstractNode implements INode, BidiTreeIterable<INode> {
	
	private CompositeNode parent;

	private AbstractNode prev;
	
	private AbstractNode next;
	
	private Object grammarElementOrArray;
	
	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegion getTextRegion() {
		int offset = getOffset();
		int length = getEndOffset() - offset;
		return new TextRegion(offset, length);
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegion getTotalTextRegion() {
		int totalOffset = getTotalOffset();
		int totalLength = getTotalLength();
		return new TextRegion(totalOffset, totalLength);
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegionWithLineInformation getTextRegionWithLineInformation() {
		int offset = getOffset();
		int length = getEndOffset() - offset;
		return getTextRegionWithLineInformation(offset, length);
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	public ITextRegionWithLineInformation getTotalTextRegionWithLineInformation() {
		int totalOffset = getTotalOffset();
		int totalLength = getTotalLength();
		return getTextRegionWithLineInformation(totalOffset, totalLength);
	}

	/**
	 * @since 2.5
	 */
	protected ITextRegionWithLineInformation getTextRegionWithLineInformation(int offset, int length) {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			int startLine = basicGetLineOfOffset(rootNode, offset);
			int endLine = basicGetLineOfOffset(rootNode, offset + length);
			return new TextRegionWithLineInformation(offset, length, startLine, endLine); 
		}
		return new TextRegionWithLineInformation(offset, length, 1, 1);
	}
	
	@Override
	public ICompositeNode getParent() {
		if (parent != null)
			return parent.resolveAsParent();
		return null;
	}
	
	protected CompositeNode basicGetParent() {
		return parent;
	}
	
	protected void basicSetParent(CompositeNode parent) {
		this.parent = parent;
	}
	
	@Override
	public BidiTreeIterable<INode> getAsTreeIterable() {
		return this;
	}
	
	@Override
	public BidiTreeIterator<INode> iterator() {
		return new NodeTreeIterator(this);
	}
	
	@Override
	public BidiTreeIterable<INode> reverse() {
		return new ReversedBidiTreeIterable<INode>(this);
	}
	
	@Override
	public Iterable<ILeafNode> getLeafNodes() {
		return new Iterable<ILeafNode>() {
			@Override
			public Iterator<ILeafNode> iterator() {
				return Iterators.filter(basicIterator(), ILeafNode.class);
			}
		};
	}
	
	public BidiTreeIterator<AbstractNode> basicIterator() {
		return new BasicNodeTreeIterator(this);
	}

	@Override
	public String getText() {
		INode rootNode = getRootNode();
		if (rootNode == null) {
			throw new IllegalStateException("Can't compute text, rootNode is 'null'.");
		}
		int offset = getTotalOffset();
		int length = getTotalLength();
		return rootNode.getText().substring(offset, offset + length);
	}
	
	@Override
	public int getTotalStartLine() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			return basicGetLineOfOffset(rootNode, getTotalOffset());
		}
		return 1;
	}

	/**
	 * @since 2.0
	 */
	protected int basicGetLineOfOffset(INode rootNode, int offset) {
		return InternalNodeModelUtils.getLineAndColumn(rootNode, offset).getLine();
	}
	
	@Override
	public int getStartLine() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			int offset = getOffset();
			return basicGetLineOfOffset(rootNode, offset);
		}
		return 1;
	}
	
	@Override
	public int getEndLine() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			return basicGetLineOfOffset(rootNode, getEndOffset());
		}
		return 1;
	}
	
	@Override
	public int getTotalEndLine() {
		INode rootNode = getRootNode();
		if (rootNode != null) {
			int offset = getTotalEndOffset();
			return basicGetLineOfOffset(rootNode, offset);
		}
		return 1;
	}
	
	@Override
	public int getOffset() {
		Iterator<ILeafNode> leafIter = Iterators.filter(basicIterator(), ILeafNode.class);
		int firstLeafOffset = -1;
		while(leafIter.hasNext()) {
			ILeafNode leaf = leafIter.next();
			if (firstLeafOffset == -1) {
				firstLeafOffset = leaf.getTotalOffset();
			}
			if (!leaf.isHidden())
				return leaf.getTotalOffset();
		}
		if (firstLeafOffset != -1)
			return firstLeafOffset;
		return getTotalOffset();
	}
	
	@Override
	public int getLength() {
		BidiIterator<AbstractNode> iter = basicIterator();
		while(iter.hasPrevious()) {
			INode prev = iter.previous();
			if (prev instanceof ILeafNode && !((ILeafNode) prev).isHidden()) {
				int offset = getOffset();
				return prev.getTotalEndOffset() - offset;
			}
		}
		return getTotalLength();
	}
	
	@Override
	public int getTotalEndOffset() {
		return getTotalOffset() + getTotalLength();
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	public int getEndOffset() {
		BidiIterator<AbstractNode> iter = basicIterator();
		while(iter.hasPrevious()) {
			INode prev = iter.previous();
			if (prev instanceof ILeafNode && !((ILeafNode) prev).isHidden()) {
				return prev.getTotalEndOffset();
			}
		}
		return getTotalEndOffset();
	}

	@Override
	public ICompositeNode getRootNode() {
		if (parent == null)
			return null;
		AbstractNode candidate = parent;
		while(candidate.basicGetParent() != null)
			candidate = candidate.basicGetParent();
		return candidate.getRootNode();
	}
	
	@Override
	public EObject getSemanticElement() {
		if (parent == null)
			return null;
		return parent.getSemanticElement();
	}
	
	protected EObject basicGetSemanticElement() {
		return null;
	}
	
	@Override
	public boolean hasDirectSemanticElement() {
		return basicGetSemanticElement() != null;
	}
	
	@Override
	public EObject getGrammarElement() {
		return (EObject) grammarElementOrArray;
	}
	
	protected Object basicGetGrammarElement() {
		return grammarElementOrArray;
	}
	
	protected void basicSetGrammarElement(Object grammarElementOrArray) {
		this.grammarElementOrArray = grammarElementOrArray;
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return null;
	}
	
	@Override
	public INode getPreviousSibling() {
		if (!hasPreviousSibling())
			return null;
		return prev;
	}
	
	protected AbstractNode basicGetPreviousSibling() {
		return prev;
	}
	
	protected void basicSetPreviousSibling(AbstractNode prev) {
		this.prev = prev;
	}
	
	@Override
	public INode getNextSibling() {
		if (!hasNextSibling())
			return null;
		return next;
	}
	
	protected AbstractNode basicGetNextSibling() {
		return next;
	}
	
	protected void basicSetNextSibling(AbstractNode next) {
		this.next = next;
	}
	
	@Override
	public boolean hasPreviousSibling() {
		return basicHasPreviousSibling();
	}
	
	protected boolean basicHasPreviousSibling() {
		if (parent == null)
			return false;
		return parent.basicGetFirstChild() != this;
	}
	
	@Override
	public boolean hasNextSibling() {
		return basicHasNextSibling();
	}
	
	protected boolean basicHasNextSibling() {
		if (parent == null)
			return false;
		return parent.basicGetLastChild() != this;
	}
	
	@Override
	public boolean hasSiblings() {
		return basicHasSiblings();
	}
	
	protected boolean basicHasSiblings() {
		return prev != this;
	}

	protected enum NodeType {
		CompositeNode, LeafNode, CompositeNodeWithSemanticElement, CompositeNodeWithSyntaxError, CompositeNodeWithSemanticElementAndSyntaxError, RootNode, HiddenLeafNode, HiddenLeafNodeWithSyntaxError, LeafNodeWithSyntaxError
	}

	protected abstract NodeType getNodeId();
	
	protected void readData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		int length = SerializationUtil.readInt(in, true);

		if (length > 0) {
			GrammarElementsInterner arrayInterner = context.getArrayInterner();
			int grammarId = SerializationUtil.readInt(in, true);
			EObject grammarElement = context.getGrammarElement(grammarId);
			grammarElementOrArray = grammarElement;

			for (int i = 1; i < length; ++i) {
				grammarId = SerializationUtil.readInt(in, true);
				grammarElement = context.getGrammarElement(grammarId);
				grammarElementOrArray = arrayInterner.appendAndIntern(grammarElementOrArray, grammarElement);
			}
		} else {
			if (length != -1) {
				throw new IllegalStateException(
						"Read unexpected length of grammar element array from stream: " + length);
			}

			grammarElementOrArray = null;
		}
	}

	protected void write(DataOutputStream out, SerializationConversionContext scc) throws IOException {
		if (grammarElementOrArray instanceof EObject) {
			EObject eObject = (EObject) grammarElementOrArray;
			SerializationUtil.writeInt(out, 1, true);
			writeGrammarId(out, scc, eObject);
		} else {
			if (grammarElementOrArray instanceof EObject[]) {
				EObject[] eObjects = (EObject[]) grammarElementOrArray;
				SerializationUtil.writeInt(out, eObjects.length, true);

				for (EObject eObject : eObjects) {
					writeGrammarId(out, scc, eObject);
				}
			} else {
				SerializationUtil.writeInt(out, -1, true);
			}
		}
	}

	private void writeGrammarId(DataOutputStream out, SerializationConversionContext scc, EObject eObject)
			throws IOException {
		Integer grammarId = scc.getGrammarElementId(eObject);
		if (grammarId == null) {
			throw new IllegalStateException("Must write a grammar element but got an unknown EMF object of class "
					+ eObject.getClass().getName());
		}

		SerializationUtil.writeInt(out, grammarId.intValue(), true);
	}

	int fillGrammarElementToIdMap(int currentId, Map<EObject, Integer> grammarElementToIdMap,
			List<String> grammarIdToURIMap) {
		if (grammarElementOrArray != null) {
			if (grammarElementOrArray instanceof EObject) {
				EObject grammarElement = (EObject) grammarElementOrArray;
				currentId = updateMapping(currentId, grammarElementToIdMap, grammarIdToURIMap, grammarElement);
			}

			if (grammarElementOrArray instanceof EObject[]) {
				EObject[] grammarElements = (EObject[]) grammarElementOrArray;
				for (EObject grammarElement : grammarElements) {
					currentId = updateMapping(currentId, grammarElementToIdMap, grammarIdToURIMap, grammarElement);
				}
			}
		}

		return currentId;
	}

	private int updateMapping(int currentId, Map<EObject, Integer> grammarElementToIdMap,
			List<String> grammarIdToURIMap, EObject grammarElement) {
		if (!grammarElementToIdMap.containsKey(grammarElement)) {
			URI uri = EcoreUtil.getURI(grammarElement);
			if (uri == null) {
				throw new IllegalStateException("While building the map of grammar elements to an ID, "
						+ "got a grammar element that does not have an URI.  The " + "grammar element has class "
						+ grammarElement.eClass().getName());
			}
			grammarElementToIdMap.put(grammarElement, currentId);
			grammarIdToURIMap.add(uri.toString());
			++currentId;
		}

		if (currentId != grammarIdToURIMap.size()) {
			throw new IllegalStateException("The next id for a grammar element will be " + currentId
					+ " but the number of elements in "
					+ "the map of grammar elements to IDs contains a different number of elements: "
					+ grammarIdToURIMap.size());
		}

		return currentId;
	}
	
}
