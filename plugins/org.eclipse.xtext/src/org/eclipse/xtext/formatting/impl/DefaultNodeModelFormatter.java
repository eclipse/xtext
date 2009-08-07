/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultNodeModelFormatter extends AbstractNodeModelFormatter {

	@Inject
	protected IFormatter formatter;

	@Inject
	protected IValueConverterService valueConverter;

	@Override
	public IFormattedRegion format(CompositeNode root, int offset, int length) {
		List<AbstractNode> nodes = getLeafs(root, offset, offset + length);
		if (nodes.size() == 0)
			return null;

		String indent = getIndentation(root, offset);
		TokenStringBuffer buf = new TokenStringBuffer();
		ITokenStream fmt = formatter.createFormatterStream(indent, buf, false);
		try {
			for (AbstractNode n : nodes) {
				if (n instanceof LeafNode) {
					LeafNode l = (LeafNode) n;
					if (l.isHidden())
						fmt.writeHidden(n.getGrammarElement(), l.getText());
					else
						fmt.writeSemantic(n.getGrammarElement(), l.getText());
				} else {
					RuleCall rc = (RuleCall) n.getGrammarElement();
					Object val = valueConverter.toValue(
							nodeToStr((CompositeNode) n), rc.getRule()
									.getName(), n);
					String text = valueConverter.toString(val, rc.getRule()
							.getName());
					fmt.writeSemantic(rc, text);
				}
			}
			fmt.close();
		} catch (IOException e) {
			// this should never happen since TokenStringBuffer doesn't throw
			// IOEs.
			throw new RuntimeException(e);
		}
		int start = nodes.get(0).getOffset();
		int lengt = (nodes.get(nodes.size() - 1).getOffset() + nodes.get(
				nodes.size() - 1).getLength())
				- start;
		return new FormattedRegion(start, lengt, buf.toString().trim());
	}

	protected String getIndentation(EObject root, int fromOffset) {
		if (fromOffset == 0)
			return "";

		List<LeafNode> r = new ArrayList<LeafNode>();
		Iterator<EObject> it = root.eAllContents();

		// add all nodes until fromOffset
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof LeafNode) {
				LeafNode l = (LeafNode) o;
				if (l.getOffset() >= fromOffset)
					break;
				else
					r.add(l);
			}
		}

		// go backwards until first linewrap
		Pattern p = Pattern.compile("\\n([ \\t]*)");
		for (int i = r.size() - 1; i >= 0; i--) {
			Matcher m = p.matcher(r.get(i).getText());
			if (m.find()) {
				String ind = m.group(1);
				while (m.find())
					ind = m.group(1);
				return ind;
			}
		}
		return "";
	}

	protected List<AbstractNode> getLeafs(EObject root, int fromOffset,
			int toOffset) {
		List<AbstractNode> r = new ArrayList<AbstractNode>();
		TreeIterator<EObject> it = root.eAllContents();

		// seek to fromOffset
		if (fromOffset > 0)
			while (it.hasNext()) {
				EObject o = it.next();
				boolean dt = isDatatypeRuleCall(o);
				boolean ln = o instanceof LeafNode
						&& !((LeafNode) o).isHidden();
				if (dt)
					it.prune();
				if (dt || ln) {
					AbstractNode l = (AbstractNode) o;
					if (l.getOffset() + l.getLength() >= fromOffset) {
						r.add(l);
						break;
					}
				}
			}

		// add Leafs within the range
		while (it.hasNext()) {
			EObject o = it.next();
			boolean dt = isDatatypeRuleCall(o);
			if (dt)
				it.prune();
			if (o instanceof LeafNode || dt) {
				AbstractNode l = (AbstractNode) o;
				if (l.getOffset() > toOffset)
					break;
				else
					r.add(l);
			}
		}

		// remove tailing hidden leafs
		for (int i = r.size() - 1; i >= 0; i--)
			if (r.get(i) instanceof LeafNode
					&& ((LeafNode) r.get(i)).isHidden())
				r.remove(i);
			else
				break;
		return r;
	}

	protected boolean isDatatypeRuleCall(EObject node) {
		if (node instanceof CompositeNode
				&& ((CompositeNode) node).getGrammarElement() instanceof RuleCall) {
			RuleCall rc = (RuleCall) ((CompositeNode) node).getGrammarElement();
			if (rc.getRule() instanceof ParserRule)
				return GrammarUtil.isDatatypeRule((ParserRule) rc.getRule());
		}
		return false;
	}

	protected String nodeToStr(CompositeNode node) {
		Iterator<EObject> it = node.eAllContents();
		StringBuffer text = new StringBuffer();
		StringBuffer hidden = new StringBuffer();
		while (it.hasNext()) {
			EObject o = it.next();
			if (o instanceof LeafNode) {
				LeafNode l = (LeafNode) o;
				if (l.isHidden())
					hidden.append(l.getText());
				else {
					if (text.length() > 0)
						text.append(hidden);
					hidden.delete(0, hidden.length());
					text.append(l.getText());
				}
			}
		}
		return text.toString();
	}

}
