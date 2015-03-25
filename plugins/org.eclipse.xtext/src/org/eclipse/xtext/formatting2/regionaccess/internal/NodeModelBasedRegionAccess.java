/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.internal.TextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelBasedRegionAccess extends AbstractRegionAccess {

	public static class Builder {

		private Map<EObject, NodeEObjectTokens> eObjToTokens;
		private LinkedList<NodeEObjectTokens> stack = new LinkedList<NodeEObjectTokens>();
		private NodeHiddenRegion firstHidden;
		private NodeHiddenRegion lastHidden;
		private XtextResource resource;

		protected void add(NodeModelBasedRegionAccess tokenAccess, INode node) {
			if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()) {
				ILeafNode leafNode = (ILeafNode) node;
				lastHidden.hiddens.add(createHidden(lastHidden, leafNode));
			} else {
				NodeEObjectTokens eObjectTokens = stack.peek();
				NodeSemanticRegion newToken = createToken(tokenAccess, node);
				NodeHiddenRegion newHidden = createGap(tokenAccess);
				newToken.setTrailingGap(newHidden);
				newHidden.setPrevious(newToken);
				newToken.setLeadingGap(lastHidden);
				lastHidden.setNext(newToken);
				eObjectTokens.getTokens().add(newToken);
				newToken.setEObjectTokens(eObjectTokens);
				lastHidden = newHidden;
			}
		}

		public NodeModelBasedRegionAccess create() {
			NodeModelBasedRegionAccess tokenAccess = new NodeModelBasedRegionAccess(this);
			return tokenAccess;
		}

		protected NodeHiddenRegion createGap(ITextRegionAccess tokenAccess) {
			return new NodeHiddenRegion(tokenAccess);
		}

		protected NodeHidden createHidden(NodeHiddenRegion gap, ILeafNode node) {
			if (isComment(node))
				return new NodeComment(gap, node);
			else
				return new NodeWhitespace(gap, node);
		}

		protected NodeSemanticRegion createToken(NodeModelBasedRegionAccess tokenAccess, INode node) {
			return new NodeSemanticRegion(tokenAccess, node);
		}

		protected NodeEObjectTokens createTokens(NodeModelBasedRegionAccess access, INode node) {
			return new NodeEObjectTokens(access, node);
		}

		protected void process(INode node, NodeModelBasedRegionAccess access) {
			NodeEObjectTokens tokens = stack.peek();
			boolean creator = isEObjectRoot(node);
			if (creator || tokens == null) {
				tokens = new NodeEObjectTokens(access, node);
				tokens.setLeadingGap(lastHidden);
				stack.push(tokens);
			}
			if (tokens.getSemanticElement() == null) {
				if (node instanceof RootNode)
					tokens.setSemantcElement(resource.getContents().get(0));
				else if (node.hasDirectSemanticElement())
					tokens.setSemantcElement(node.getSemanticElement());
			}
			if (include(node)) {
				if (node instanceof ICompositeNode) {
					for (ILeafNode leaf : node.getLeafNodes())
						if (leaf.isHidden())
							this.add(access, leaf);
						else
							break;
				}
				this.add(access, node);
			} else if (node instanceof ICompositeNode) {
				for (INode child : ((ICompositeNode) node).getChildren())
					process(child, access);
			}
			if (creator) {
				NodeEObjectTokens popped = stack.pop();
				popped.setTrailingGap(lastHidden);
				EObject semanticElement = popped.getSemanticElement();
				if (semanticElement == null)
					throw new IllegalStateException();
				NodeEObjectTokens old = eObjToTokens.put(semanticElement, popped);
				if (old != null)
					throw new IllegalStateException();
			}
		}

		protected Map<EObject, AbstractEObjectTokens> getEObjectToTokensMap(ITextRegionAccess tokenAccess) {
			this.eObjToTokens = Maps.newHashMap();
			this.firstHidden = createGap(tokenAccess);
			this.lastHidden = this.firstHidden;
			NodeModelBasedRegionAccess access = (NodeModelBasedRegionAccess) tokenAccess;
			CompositeNode rootNode = (CompositeNode) resource.getParseResult().getRootNode();
			process(rootNode, access);
			return ImmutableMap.<EObject, AbstractEObjectTokens> copyOf(this.eObjToTokens);
		}

		protected IHiddenRegion getFirstRegion() {
			return firstHidden;
		}

		protected XtextResource getXtextResource() {
			return resource;
		}

		protected boolean include(INode node) {
			if (node instanceof ILeafNode) {
				return true;
			} else if (node instanceof ICompositeNode) {
				EObject element = node.getGrammarElement();
				return GrammarUtil.isDatatypeRuleCall(element) || element instanceof CrossReference
						|| GrammarUtil.isEnumRuleCall(element);
			}
			return false;
		}

		protected boolean isDeadend(INode node) {
			if (node instanceof ICompositeNode) {
				ICompositeNode c = (ICompositeNode) node;
				INode firstChild = c.getFirstChild();
				if (firstChild == null)
					return true;
				if (firstChild == c.getLastChild() && firstChild instanceof ICompositeNode)
					return isDeadend(firstChild);
			}
			return false;
		}

		protected boolean isEObjectRoot(INode node) {
			if (node instanceof ICompositeNode) {
				ICompositeNode parent = node.getParent();
				if (parent == null)
					return true;
				INode root = parent;
				while (root != null && !root.hasDirectSemanticElement())
					root = root.getParent();
				if (root == null)
					return false;
				EObject element = node.getGrammarElement();
				if (GrammarUtil.isEObjectRuleCall(element)) {
					if (!parent.hasDirectSemanticElement())
						return false;
					BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
					iterator.next();
					while (iterator.hasNext()) {
						INode next = iterator.next();
						if (next.hasDirectSemanticElement())
							return true;
						EObject ge = next.getGrammarElement();
						if (ge instanceof Action)
							return true;
						if (ge instanceof RuleCall && GrammarUtil.isAssigned(ge)
								&& ((RuleCall) ge).getRule().getType().getClassifier() instanceof EDataType)
							return true;
						if (ge instanceof CrossReference)
							return true;
					}
				}
				if (element instanceof Action) {
					return parent.hasDirectSemanticElement();
				}
			}
			return false;
		}

		protected boolean isComment(ILeafNode leaf) {
			String text = leaf.getText();
			for (int i = 0; i < text.length(); i++)
				if (!Character.isWhitespace(text.charAt(i)))
					return true;
			return false;
		}

		public Builder withResource(XtextResource resource) {
			this.resource = resource;
			return this;
		}
	}

	private final Map<EObject, AbstractEObjectTokens> eObjectToTokens;
	private final IHiddenRegion firstRegion;
	private final XtextResource resource;

	protected NodeModelBasedRegionAccess(Builder builder) {
		this.resource = builder.getXtextResource();
		this.eObjectToTokens = ImmutableMap.copyOf(builder.getEObjectToTokensMap(this));
		this.firstRegion = builder.getFirstRegion();
	}

	@Override
	public ITextSegment expandRegionsByLines(int leadingLines, int trailingLines, ITextSegment... regions) {
		int offset = regions[0].getOffset();
		int endOffset = regions[0].getEndOffset();
		for (int i = 1; i < regions.length; i++) {
			ITextSegment region = regions[i];
			int o = region.getOffset();
			if (o < offset)
				offset = o;
			int e = region.getEndOffset();
			if (e > endOffset)
				endOffset = e;
		}
		String text = getText();
		for (int i = 0; i < leadingLines && offset >= 0; i++)
			offset = text.lastIndexOf("\n", offset) - 1;
		for (int i = 0; i < trailingLines && endOffset <= text.length() && endOffset > 0; i++)
			endOffset = text.indexOf("\n", endOffset);
		if (offset < 0)
			offset = 0;
		if (endOffset < 0 || endOffset > text.length())
			endOffset = text.length();
		return new TextSegment(this, offset, endOffset - offset);
	}

	@Override
	public IHiddenRegion getFirstRegionInFile() {
		return this.firstRegion;
	}

	@Override
	public int getLength() {
		return getResource().getParseResult().getRootNode().getTotalEndOffset();
	}

	@Override
	public XtextResource getResource() {
		return this.resource;
	}

	@Override
	public String getText() {
		return getResource().getParseResult().getRootNode().getText();
	}

	@Override
	public String getText(int offset, int length) {
		return getResource().getParseResult().getRootNode().getText().substring(offset, offset + length);
	}

	@Override
	protected AbstractEObjectTokens getTokens(EObject obj) {
		return eObjectToTokens.get(obj);
	}

	@Override
	public boolean hasSyntaxError() {
		return getResource().getParseResult().hasSyntaxErrors();
	}

	@Override
	public boolean hasSyntaxError(EObject object) {
		BidiTreeIterator<INode> it = NodeModelUtils.getNode(object).getAsTreeIterable().iterator();
		while (it.hasNext()) {
			if (it.next().getSyntaxErrorMessage() != null)
				return true;
		}
		return false;
	}

	@Override
	public ITextSegment indentationRegion(int offset) {
		String text = getText();
		int lineStart = text.lastIndexOf('\n', offset) + 1;
		for (int i = lineStart; i < text.length(); i++)
			if (!Character.isWhitespace(text.charAt(i)))
				return new TextSegment(getTextRegionAccess(), lineStart, i - lineStart);
		return null;
	}

}
