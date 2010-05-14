/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.INodeModelStreamer;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextLocation;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NodeModelStreamer implements INodeModelStreamer {

	@Inject
	protected TokenUtil tokenUtil;

	@Inject
	protected IHiddenTokenHelper hiddenTokenHelper;

	@Inject
	protected IValueConverterService valueConverter;

	public TextLocation feedTokenStream(ITokenStream out, CompositeNode in, int offset, int length) throws IOException {
		List<AbstractNode> nodes = getLeafs(in, offset, offset + length);
		if (nodes.isEmpty())
			return new TextLocation(in.getOffset(), 0);
		boolean lastIsTokenOrComment = false;
		for (AbstractNode node : nodes) {
			boolean currentIsTokenOrComment = tokenUtil.isCommentNode(node) || tokenUtil.isToken(node);
			if (lastIsTokenOrComment && currentIsTokenOrComment)
				writeHiddenEmpty(out);
			lastIsTokenOrComment = currentIsTokenOrComment;
			if (node instanceof LeafNode) {
				LeafNode leaf = (LeafNode) node;
				if (leaf.isHidden())
					writeHidden(out, leaf);
				else
					writeSemantic(out, leaf);
			} else if (node instanceof CompositeNode)
				writeSemantic(out, (CompositeNode) node);
		}
		out.flush();
		int rStart = nodes.get(0).getOffset();
		int rLength = (nodes.get(nodes.size() - 1).getOffset() + nodes.get(nodes.size() - 1).getLength()) - rStart;
		return new TextLocation(rStart, rLength);
	}

	protected List<AbstractNode> getLeafs(EObject root, int fromOffset, int toOffset) {
		List<AbstractNode> result = new ArrayList<AbstractNode>();
		TreeIterator<EObject> it = root.eAllContents();

		// seek to fromOffset
		if (fromOffset > 0)
			while (it.hasNext()) {
				EObject o = it.next();
				if (o instanceof AbstractNode) {
					AbstractNode node = (AbstractNode) o;
					if (tokenUtil.isToken(node) || tokenUtil.isCommentNode(node)) {
						it.prune();
						if (node.getOffset() + node.getLength() >= fromOffset) {
							result.add(node);
							break;
						}
					}
				}
			}

		// add tokens within the range
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof AbstractNode) {
				AbstractNode node = (AbstractNode) o;
				if (node instanceof LeafNode || tokenUtil.isToken(node)) {
					if (node.getOffset() > toOffset)
						break;
					else {
						if (node instanceof LeafNode)
							result.add(node);
						else {
							it.prune();
							Pair<List<LeafNode>, List<LeafNode>> surround = tokenUtil
									.getLeadingAndTrailingHiddenTokens(node);
							result.addAll(surround.getFirst());
							result.add(node);
							result.addAll(surround.getSecond());
						}
					}
				}
			}
		}

		// remove tailing hidden leafs
		for (int i = result.size() - 1; i >= 0; i--)
			if (tokenUtil.isWhitespaceNode(result.get(i)))
				result.remove(i);
			else
				break;
		return result;
	}

	protected void writeHidden(ITokenStream out, LeafNode node) throws IOException {
		out.writeHidden(node.getGrammarElement(), node.getText());
	}

	protected void writeHiddenEmpty(ITokenStream out) throws IOException {
		out.writeHidden(hiddenTokenHelper.getWhitespaceRuleFor(null, ""), "");
	}

	protected void writeSemantic(ITokenStream out, CompositeNode node) throws IOException {
		AbstractRule rule = tokenUtil.getTokenRule(node);
		Object val = valueConverter.toValue(tokenUtil.serializeNode(node), rule.getName(), node);
		String text = valueConverter.toString(val, rule.getName());
		out.writeSemantic(node.getGrammarElement(), text);
	}

	protected void writeSemantic(ITokenStream out, LeafNode node) throws IOException {
		out.writeSemantic(node.getGrammarElement(), node.getText());
	}
}
