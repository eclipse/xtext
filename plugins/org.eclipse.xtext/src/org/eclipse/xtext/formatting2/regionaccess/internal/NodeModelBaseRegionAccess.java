/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.internal.TextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelBaseRegionAccess extends AbstractRegionAccess {

	public static class Builder extends AbstractRegionAccess.Builder {

		private Map<EObject, EObjectTokens> eObjToTokens;
		private ISemanticRegion firstToken;
		private ITextSegment lastTokenOrGap;
		private EObjectTokens lastTokens;
		private XtextResource resource;

		protected boolean add(NodeModelBaseRegionAccess tokenAccess, INode node) {
			EObject semanticElement = tokenAccess.findSemanticElement(node);
			if (lastTokens == null || semanticElement != lastTokens.getSemanticElement())
				lastTokens = eObjToTokens.get(semanticElement);
			if (lastTokens == null)
				eObjToTokens.put(semanticElement, lastTokens = createTokens(tokenAccess, node));
			boolean result = include(node);
			if (result) {
				if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()) {
					ILeafNode leafNode = (ILeafNode) node;
					if (lastTokenOrGap instanceof NodeToken) {
						NodeToken lastToken = (NodeToken) lastTokenOrGap;
						Gap gap = createGap(tokenAccess);
						lastToken.setTrailingGap(gap);
						gap.setPrevious(lastToken);
						gap.hiddens.add(createHidden(gap, leafNode));
						lastTokenOrGap = gap;
					} else if (lastTokenOrGap instanceof Gap) {
						Gap lastGap = (Gap) lastTokenOrGap;
						lastGap.hiddens.add(createHidden(lastGap, leafNode));
					} else if (lastTokenOrGap == null) {
						Gap gap = createGap(tokenAccess);
						gap.hiddens.add(createHidden(gap, leafNode));
						lastTokenOrGap = gap;
					} else {
						throw new IllegalStateException();
					}
				} else {
					NodeToken newToken = createToken(tokenAccess, node);
					if (lastTokenOrGap == null)
						lastTokenOrGap = createGap(tokenAccess);
					if (lastTokenOrGap instanceof NodeToken) {
						NodeToken lastToken = (NodeToken) lastTokenOrGap;
						Gap gap = createGap(tokenAccess);
						lastToken.setTrailingGap(gap);
						gap.setPrevious(lastToken);
						newToken.setLeadingGap(gap);
						gap.setNext(newToken);
					} else if (lastTokenOrGap instanceof Gap) {
						Gap lastGap = (Gap) lastTokenOrGap;
						lastGap.setNext(newToken);
						newToken.setLeadingGap(lastGap);
					} else {
						throw new IllegalStateException();
					}
					if (lastTokens != null)
						lastTokens.getTokens().add(newToken);
					lastTokenOrGap = newToken;
					if (firstToken == null)
						firstToken = newToken;
				}
			}
			return result;
		}

		public NodeModelBaseRegionAccess create() {
			NodeModelBaseRegionAccess tokenAccess = new NodeModelBaseRegionAccess(this);
			//			System.out.println(tokenAccess);
			return tokenAccess;
		}

		protected Gap createGap(ITextRegionAccess tokenAccess) {
			return new Gap(tokenAccess);
		}

		protected NodeHidden createHidden(Gap gap, ILeafNode node) {
			if (isComment(node))
				return new NodeComment(gap, node);
			else
				return new NodeWhitespace(gap, node);
		}

		protected NodeToken createToken(NodeModelBaseRegionAccess tokenAccess, INode node) {
			return new NodeToken(tokenAccess, node);
		}

		protected EObjectTokens createTokens(NodeModelBaseRegionAccess access, INode node) {
			return new EObjectTokens(access, node);
		}

		@Override
		protected Map<EObject, AbstractEObjectTokens> getEObjectToTokensMap(ITextRegionAccess tokenAccess) {
			this.eObjToTokens = Maps.newHashMap();
			this.lastTokenOrGap = null;
			this.lastTokens = null;
			this.firstToken = null;
			NodeModelBaseRegionAccess access = (NodeModelBaseRegionAccess) tokenAccess;
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			TreeIterator<INode> iterator = rootNode.getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				INode next = iterator.next();
				if (next instanceof ICompositeNode && include(next)) {
					Iterator<INode> it = next.getAsTreeIterable().iterator();
					while (it.hasNext()) {
						INode next2 = it.next();
						if (next2 == next)
							continue;
						if (next2 instanceof ILeafNode) {
							if (((ILeafNode) next2).isHidden())
								this.add(access, next2);
							else
								break;
						}
					}
				}
				if (this.add(access, next))
					iterator.prune();
			}
			if (lastTokenOrGap instanceof NodeToken) {
				NodeToken last = (NodeToken) lastTokenOrGap;
				Gap gap = createGap(tokenAccess);
				last.setTrailingGap(gap);
				gap.setPrevious(last);
			}
			setLeadingGaps();
			setTrailingGaps();
			return ImmutableMap.<EObject, AbstractEObjectTokens> copyOf(this.eObjToTokens);
		}

		@Override
		protected IHiddenRegion getFirstRegion() {
			return this.firstToken.getNextHiddenRegion();
		}

		@Override
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

		protected boolean isComment(ILeafNode leaf) {
			String text = leaf.getText();
			for (int i = 0; i < text.length(); i++)
				if (!Character.isWhitespace(text.charAt(i)))
					return true;
			return false;
		}

		protected void setLeadingGaps() {
			ISemanticRegion token = firstToken;
			while (token != null) {
				IHiddenRegion gap = token.getPreviousHiddenRegion();
				EObjectTokens tokens = eObjToTokens.get(token.getSemanticElement());
				while (tokens != null && tokens.getLeadingGap() == null) {
					tokens.setLeadingGap(gap);
					tokens = eObjToTokens.get(tokens.getSemanticElement().eContainer());
				}
				token = token.getNextSemanticRegion();
			}
		}

		protected void setTrailingGaps() {
			ISemanticRegion token;
			if (lastTokenOrGap instanceof IHiddenRegion)
				token = ((IHiddenRegion) lastTokenOrGap).getPreviousSemanticRegion();
			else
				token = (ISemanticRegion) lastTokenOrGap;
			while (token != null) {
				IHiddenRegion gap = token.getNextHiddenRegion();
				EObjectTokens tokens = eObjToTokens.get(token.getSemanticElement());
				while (tokens != null && tokens.getTrailingGap() == null) {
					tokens.setTrailingGap(gap);
					tokens = eObjToTokens.get(tokens.getSemanticElement().eContainer());
				}
				token = token.getPreviousSemanticRegion();
			}
		}

		public Builder withResource(XtextResource resource) {
			this.resource = resource;
			return this;
		}
	}

	protected NodeModelBaseRegionAccess(Builder builder) {
		super(builder);
	}

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

	protected EObject findSemanticElement(INode node) {
		EObject element = node.getGrammarElement();
		if (element instanceof Action)
			return node.getSemanticElement();
		if (GrammarUtil.isParserRuleCall(element))
			return findSemanticElementFromChildren(node);
		ICompositeNode parent = node.getParent();
		if (parent == null) {
			BidiTreeIterator<INode> it = node.getAsTreeIterable().iterator();
			while (it.hasNext()) {
				EObject sem = it.next().getSemanticElement();
				if (sem != null)
					return EcoreUtil.getRootContainer(sem);
			}
		}
		return findSemanticElement(parent);
	}

	protected EObject findSemanticElementFromChildren(INode node) {
		BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
		while (iterator.hasNext()) {
			INode next = iterator.next();
			EObject grammarElement = next.getGrammarElement();
			if (next != node) {
				if (grammarElement instanceof RuleCall) {
					if (GrammarUtil.isAssigned(grammarElement)) {
						EObject semanticElement = next.getParent().getSemanticElement();
						if (semanticElement != null)
							return semanticElement;
					}
					EObject semanticElement = next.getSemanticElement();
					if (semanticElement != null)
						return semanticElement;
				}
			}
		}
		return node.getParent().getSemanticElement();
	}

	public int getLength() {
		return getResource().getParseResult().getRootNode().getTotalEndOffset();
	}

	@Override
	public String getText() {
		return getResource().getParseResult().getRootNode().getText();
	}

	public boolean hasSyntaxError() {
		return getResource().getParseResult().hasSyntaxErrors();
	}

	public boolean hasSyntaxError(EObject object) {
		BidiTreeIterator<INode> it = NodeModelUtils.getNode(object).getAsTreeIterable().iterator();
		while (it.hasNext()) {
			if (it.next().getSyntaxErrorMessage() != null)
				return true;
		}
		return false;
	}

	public ITextSegment indentationRegion(int offset) {
		String text = getText();
		int lineStart = text.lastIndexOf('\n', offset) + 1;
		for (int i = lineStart; i < text.length(); i++)
			if (!Character.isWhitespace(text.charAt(i)))
				return new TextSegment(getTextRegionAccess(), lineStart, i - lineStart);
		return null;
	}

}
