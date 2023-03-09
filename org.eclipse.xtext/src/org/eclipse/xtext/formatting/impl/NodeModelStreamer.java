/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.formatting.INodeModelStreamer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITokenStreamExtension;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelStreamer implements INodeModelStreamer {

	@Inject
	protected IHiddenTokenHelper hiddenTokenHelper;

	@Inject
	protected TokenUtil tokenUtil;

	@Inject
	protected IValueConverterService valueConverter;

	@Override
	public ITextRegion feedTokenStream(ITokenStream out, ICompositeNode in, int offset, int length) throws IOException {
		List<INode> nodes = getLeafs(in, offset, offset + length);
		if (nodes.isEmpty())
			return new TextRegion(in.getOffset(), 0);
		if (out instanceof ITokenStreamExtension)
			((ITokenStreamExtension) out).init(findRootRuleForRegion(nodes.get(0)));
		boolean lastIsTokenOrComment = false;
		for (INode node : nodes) {
			boolean currentIsTokenOrComment = tokenUtil.isCommentNode(node) || tokenUtil.isToken(node);
			if (lastIsTokenOrComment && currentIsTokenOrComment)
				writeHiddenEmpty(out);
			lastIsTokenOrComment = currentIsTokenOrComment;
			if (node instanceof ILeafNode) {
				ILeafNode leaf = (ILeafNode) node;
				if (leaf.isHidden())
					writeHidden(out, leaf);
				else
					writeSemantic(out, leaf);
			} else if (node instanceof ICompositeNode)
				writeSemantic(out, (ICompositeNode) node);
		}
		out.flush();
		int rStart = nodes.get(0).getOffset();
		int rLength = nodes.get(nodes.size() - 1).getEndOffset() - rStart;
		return new TextRegion(rStart, rLength);
	}

	/**
	 * @since 2.0
	 */
	protected ParserRule findRootRuleForRegion(INode node) {
		if (GrammarUtil.isEObjectRule(node.getGrammarElement()))
			return (ParserRule) node.getGrammarElement();
		if (node.hasDirectSemanticElement())
			return GrammarUtil.containingParserRule(node.getGrammarElement());
		if (node.getParent() != null)
			return findRootRuleForRegion(node.getParent());
		return null;
	}

	protected List<INode> getLeafs(ICompositeNode root, int fromOffset, int toOffset) {
		List<INode> result = new ArrayList<INode>();
		TreeIterator<INode> iterator = root.getAsTreeIterable().iterator();

		// seek to fromOffset
		if (fromOffset > 0)
			while (iterator.hasNext()) {
				INode node = iterator.next();
				if (tokenUtil.isToken(node) || tokenUtil.isCommentNode(node)) {
					iterator.prune();
					if (node.getEndOffset() >= fromOffset) {
						result.add(node);
						break;
					}
				}
			}

		// add tokens within the range
		while (iterator.hasNext()) {
			INode node = iterator.next();
			if (node instanceof ILeafNode || tokenUtil.isToken(node)) {
				if (node.getOffset() > toOffset)
					break;
				else {
					if (node instanceof ILeafNode)
						result.add(node);
					else {
						iterator.prune();
						Pair<List<ILeafNode>, List<ILeafNode>> surround = tokenUtil
								.getLeadingAndTrailingHiddenTokens(node);
						result.addAll(surround.getFirst());
						result.add(node);
						result.addAll(surround.getSecond());
					}
				}
			}
		}

		// remove trailing hidden leafs
		for (int i = result.size() - 1; i >= 0; i--) {
			if (tokenUtil.isWhitespaceNode(result.get(i))) {
				result.remove(i);
			} else {
				break;
			}
		}
		return result;
	}

	protected void writeHidden(ITokenStream out, ILeafNode node) throws IOException {
		out.writeHidden(node.getGrammarElement(), node.getText());
	}

	protected void writeHiddenEmpty(ITokenStream out) throws IOException {
		out.writeHidden(hiddenTokenHelper.getWhitespaceRuleFor(null, ""), "");
	}

	protected void writeSemantic(ITokenStream out, ICompositeNode node) throws IOException {
		AbstractRule rule = tokenUtil.getTokenRule(node);
		String text = tokenUtil.serializeNode(node);
		try {
			// there and back again - the value converter is used to obtain a canonical representation of the value
			text = getFormattedDatatypeValue(node, rule, text);
		} catch(ValueConverterException e) {
			// which may fail - fall back to plain text value
		}
		out.writeSemantic(node.getGrammarElement(), text);
	}

	/**
	 * Create a canonical represenation of the data type value. Defaults to the value converter.
	 * 
	 * @since 2.9
	 */
	protected String getFormattedDatatypeValue(ICompositeNode node, AbstractRule rule, String text) throws ValueConverterException {
		Object value = valueConverter.toValue(text, rule.getName(), node);
		text = valueConverter.toString(value, rule.getName());
		return text;
	}

	protected void writeSemantic(ITokenStream out, ILeafNode node) throws IOException {
		out.writeSemantic(node.getGrammarElement(), node.getText());
	}
}
