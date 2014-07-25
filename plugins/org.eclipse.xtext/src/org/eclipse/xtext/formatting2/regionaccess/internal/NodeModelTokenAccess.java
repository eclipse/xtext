/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.internal.AbstractTextSegment;
import org.eclipse.xtext.formatting2.internal.RegionToString;
import org.eclipse.xtext.formatting2.internal.TextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.IWhitespace;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelTokenAccess extends AbstractTokenAccess {

	public static class Builder extends AbstractTokenAccess.Builder {

		private Map<EObject, EObjectTokens> eObjToTokens;
		private ISemanticRegion firstToken;
		private ITextSegment lastTokenOrGap;
		private EObjectTokens lastTokens;
		private XtextResource resource;

		protected void add(ITextRegionAccess tokenAcces, INode node) {
			EObject semanticElement = node.getSemanticElement();
			if (semanticElement != null) {
				if (lastTokens == null || semanticElement != lastTokens.getSemanticElement())
					lastTokens = eObjToTokens.get(semanticElement);
				if (lastTokens == null)
					eObjToTokens.put(semanticElement, lastTokens = createTokens(node));
			}
			if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()) {
				ILeafNode leafNode = (ILeafNode) node;
				if (lastTokenOrGap instanceof NodeToken) {
					NodeToken lastToken = (NodeToken) lastTokenOrGap;
					Gap gap = createGap(tokenAcces);
					lastToken.setTrailingGap(gap);
					gap.setPrevious(lastToken);
					gap.hiddens.add(createHidden(gap, leafNode));
					lastTokenOrGap = gap;
				} else if (lastTokenOrGap instanceof Gap) {
					Gap lastGap = (Gap) lastTokenOrGap;
					lastGap.hiddens.add(createHidden(lastGap, leafNode));
				} else if (lastTokenOrGap == null) {
					Gap gap = createGap(tokenAcces);
					gap.hiddens.add(createHidden(gap, leafNode));
					lastTokenOrGap = gap;
				} else {
					throw new IllegalStateException();
				}
			} else {
				NodeToken newToken = createToken(tokenAcces, node);
				if (lastTokenOrGap == null)
					lastTokenOrGap = createGap(tokenAcces);
				if (lastTokenOrGap instanceof NodeToken) {
					NodeToken lastToken = (NodeToken) lastTokenOrGap;
					Gap gap = createGap(tokenAcces);
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
				lastTokens.getTokens().add(newToken);
				lastTokenOrGap = newToken;
				if (firstToken == null)
					firstToken = newToken;
			}
		}

		public NodeModelTokenAccess create() {
			NodeModelTokenAccess tokenAccess = new NodeModelTokenAccess(this);
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

		protected NodeToken createToken(ITextRegionAccess tokenAccess, INode node) {
			return new NodeToken(tokenAccess, node);
		}

		protected EObjectTokens createTokens(INode node) {
			return new EObjectTokens(node);
		}

		@Override
		protected Map<EObject, AbstractTokenAccess.EObjectTokens> getEObjectToTokensMap(ITextRegionAccess tokenAccess) {
			this.eObjToTokens = Maps.newHashMap();
			this.lastTokenOrGap = null;
			this.lastTokens = null;
			this.firstToken = null;
			TreeIterator<INode> iterator = resource.getParseResult().getRootNode().getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				INode next = iterator.next();
				if (include(next)) {
					if (next instanceof ICompositeNode) {
						Iterator<INode> it = next.getAsTreeIterable().iterator();
						while (it.hasNext()) {
							INode next2 = it.next();
							if (next2 == next)
								continue;
							if (next2 instanceof ILeafNode) {
								if (((ILeafNode) next2).isHidden())
									this.add(tokenAccess, next2);
								else
									break;
							}
						}
					}
					iterator.prune();
					this.add(tokenAccess, next);
				}
			}
			setLeadingGaps();
			setTrailingGaps();
			return ImmutableMap.<EObject, AbstractTokenAccess.EObjectTokens> copyOf(this.eObjToTokens);
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

	protected static class EObjectTokens extends AbstractTokenAccess.EObjectTokens {
		private final INode node;

		public EObjectTokens(INode node) {
			super();
			this.node = node;
		}

		@Override
		public AbstractElement getGrammarElement() {
			INode current = node;
			while (current != null) {
				EObject grammarElement = current.getGrammarElement();
				if (GrammarUtil.isAssignedEObjectRuleCall(grammarElement))
					return (AbstractElement) grammarElement;
				if (grammarElement instanceof Action) {
					Action action = (Action) grammarElement;
					if (action.getFeature() != null)
						return (AbstractElement) grammarElement;
					else {
						EObject grammarElement2 = ((ICompositeNode) current).getFirstChild().getGrammarElement();
						if (GrammarUtil.isAssignedEObjectRuleCall(grammarElement2))
							return (AbstractElement) grammarElement2;
					}
				}
				current = current.getParent();
			}
			return null;
		}

		@Override
		public EObject getSemanticElement() {
			return node.getSemanticElement();
		}
	}

	public static class Gap extends AbstractTextSegment implements IHiddenRegion {

		private List<NodeHidden> hiddens = Lists.newArrayList();
		private ISemanticRegion next;
		private ISemanticRegion previous;
		private final ITextRegionAccess tokenAccess;

		protected Gap(ITextRegionAccess tokenAccess) {
			super();
			this.tokenAccess = tokenAccess;
		}

		public boolean containsComment() {
			for (IHiddenRegionPart hidden : hiddens)
				if (hidden instanceof IComment)
					return true;
			return false;
		}

		public int getLength() {
			if (hiddens.isEmpty())
				return 0;
			int start = hiddens.get(0).getNode().getOffset();
			int end = hiddens.get(hiddens.size() - 1).getNode().getEndOffset();
			return end - start;
		}

		public IHiddenRegion getNextHiddenRegion() {
			return next == null ? null : next.getNextHiddenRegion();
		}

		public ISemanticRegion getNextSemanticRegion() {
			return next;
		}

		public int getOffset() {
			if (hiddens.isEmpty()) {
				if (previous != null)
					return previous.getOffset() + previous.getLength();
				return 0;
			} else {
				return hiddens.get(0).getOffset();
			}
		}

		public List<IHiddenRegionPart> getParts() {
			return ImmutableList.<IHiddenRegionPart> copyOf(hiddens);
		}

		public IHiddenRegion getPreviousHiddenRegion() {
			return previous == null ? null : previous.getPreviousHiddenRegion();
		}

		public ISemanticRegion getPreviousSemanticRegion() {
			return previous;
		}

		public ITextRegionAccess getTextRegionAccess() {
			return tokenAccess;
		}

		public boolean isUndefined() {
			return false;
		}

		protected void setNext(ISemanticRegion next) {
			this.next = next;
		}

		protected void setPrevious(ISemanticRegion previous) {
			this.previous = previous;
		}

		@Override
		public String toString() {
			return new RegionToString().withOrigin(this).hightlightOrigin().toString();
		}

	}

	protected static class NodeComment extends NodeHidden implements IComment {
		public NodeComment(Gap gap, INode node) {
			super(gap, node);
		}
	}

	public static class NodeHidden extends NodeRegion implements IHiddenRegionPart {

		private final Gap gap;

		protected NodeHidden(Gap gap, INode node) {
			super(gap.getTextRegionAccess(), node);
			this.gap = gap;
		}

		@Override
		public AbstractRule getGrammarElement() {
			EObject element = super.getGrammarElement();
			return element instanceof AbstractRule ? (AbstractRule) element : null;
		}

		public IHiddenRegion getHiddenRegion() {
			return gap;
		}

		public IHiddenRegionPart getNextHiddenPart() {
			int i = gap.hiddens.indexOf(this) + 1;
			if (i < gap.hiddens.size())
				return gap.hiddens.get(i);
			return null;
		}

		public IHiddenRegionPart getPreviousHiddenPart() {
			int i = gap.hiddens.indexOf(this) - 1;
			if (i > 0)
				return gap.hiddens.get(i);
			return null;
		}

	}

	public static class NodeRegion extends AbstractTextSegment {
		private final INode node;
		private final ITextRegionAccess tokenAccess;

		protected NodeRegion(ITextRegionAccess tokenAccess, INode node) {
			super();
			this.tokenAccess = tokenAccess;
			this.node = node;
		}

		public EObject getGrammarElement() {
			return node.getGrammarElement();
		}

		public int getLength() {
			return node.getLength();
		}

		public INode getNode() {
			return node;
		}

		public int getOffset() {
			return node.getOffset();
		}

		public EObject getSemanticElement() {
			return node.getSemanticElement();
		}

		public ITextRegionAccess getTextRegionAccess() {
			return tokenAccess;
		}

		@Override
		public String toString() {
			return new RegionToString().withOrigin(this).hightlightOrigin().toString();
		}
	}

	public static class NodeToken extends NodeRegion implements ISemanticRegion {

		private IHiddenRegion leading;
		private IHiddenRegion trailing;

		protected NodeToken(ITextRegionAccess tokenAccess, INode node) {
			super(tokenAccess, node);
		}

		@Override
		public AbstractElement getGrammarElement() {
			EObject element = super.getGrammarElement();
			return element instanceof AbstractElement ? (AbstractElement) element : null;
		}

		public IHiddenRegion getNextHiddenRegion() {
			return trailing;
		}

		public ISemanticRegion getNextSemanticRegion() {
			return trailing != null ? trailing.getNextSemanticRegion() : null;
		}

		public IHiddenRegion getPreviousHiddenRegion() {
			return leading;
		}

		public ISemanticRegion getPreviousSemanticRegion() {
			return leading != null ? leading.getPreviousSemanticRegion() : null;
		}

		protected void setLeadingGap(IHiddenRegion leading) {
			this.leading = leading;
		}

		protected void setTrailingGap(IHiddenRegion trailing) {
			this.trailing = trailing;
		}
	}

	public static class NodeWhitespace extends NodeHidden implements IWhitespace {
		protected NodeWhitespace(Gap gap, INode node) {
			super(gap, node);
		}
	}

	protected NodeModelTokenAccess(Builder builder) {
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

	public int getLength() {
		return getResource().getParseResult().getRootNode().getTotalEndOffset();
	}

	@Override
	public String getText() {
		return getResource().getParseResult().getRootNode().getText();
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
