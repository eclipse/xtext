/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.impl.BaseTokenStream;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultHiddenTokenMerger extends AbstractHiddenTokenMerger {

	protected class BackwardNodeIterator implements Iterator<AbstractNode> {

		private int index;
		private CompositeNode parent;

		public BackwardNodeIterator(AbstractNode start) {
			parent = start.getParent();
			if (parent != null)
				index = parent.getChildren().indexOf(start);
		}

		public boolean hasNext() {
			if (parent == null)
				return false;
			index--;
			if (index < 0) {
				if (parent.getParent() != null) {
					index = parent.getParent().getChildren().indexOf(parent);
					parent = parent.getParent();
					return hasNext();
				}
				return false;
			}
			else if (!includeNode(parent.getChildren().get(index))) {
				parent = (CompositeNode) parent.getChildren().get(index);
				index = parent.getChildren().size();
				return hasNext();
			}
			return true;
		}

		public AbstractNode next() {
			return parent.getChildren().get(index);
		}

		public void remove() {
		}

	}

	protected class ForwardNodeIterator implements Iterator<AbstractNode> {

		private int index;
		private CompositeNode parent;

		public ForwardNodeIterator(AbstractNode start) {
			parent = start.getParent();
			if (parent != null)
				index = parent.getChildren().indexOf(start);
		}

		public boolean hasNext() {
			if (parent == null)
				return false;
			index++;
			if (index >= parent.getChildren().size()) {
				if (parent.getParent() != null) {
					index = parent.getParent().getChildren().indexOf(parent);
					parent = parent.getParent();
					return hasNext();
				}
				return false;
			}
			else if (!includeNode(parent.getChildren().get(index))) {
				parent = (CompositeNode) parent.getChildren().get(index);
				index = -1;
				return hasNext();
			}
			return true;
		}

		public AbstractNode next() {
			return parent.getChildren().get(index);
		}

		public void remove() {
		}

	}

	protected class HiddenTokenMergerStream extends BaseTokenStream {
		private List<AbstractNode> allLeafs;

		private int lastLeaf;

		public HiddenTokenMergerStream(ITokenStream out, CompositeNode rootnode) {
			super(out);
			this.allLeafs = getAllLeafs(rootnode);
//			for (AbstractNode n : allLeafs)
//				if (n instanceof LeafNode)
//					System.out.println("Leaf: '" + ((LeafNode) n).getText() + "'");
//				else
//					System.out.println("Comp: " + n.getGrammarElement().eClass().getName());
			this.lastLeaf = -1;
		}

		protected void beforeElement(EObject grammarElement, String value) throws IOException {
			int i = lastLeaf, last = findLeafNodeFor(grammarElement, value);
			if (last >= 0)
				writeHidden(i, last);
		}

		@Override
		public void close() throws IOException {
			endSerialize();
			super.close();
		}

		public void endSerialize() throws IOException {
			if (allLeafs != null)
				writeHidden(lastLeaf, allLeafs.size());
		}

		protected int findLeafNodeFor(EObject grammarElement, String value) {
			if (allLeafs != null)
				for (int i = lastLeaf + 1; i < allLeafs.size(); i++)
					if (nodeMatches(grammarElement, value, allLeafs.get(i)))
						return lastLeaf = i;

			return -1;
		}

		protected List<AbstractNode> getAllLeafs(CompositeNode root) {
			if (root == null)
				return null;
			ArrayList<AbstractNode> r = new ArrayList<AbstractNode>();
			if (root.getParent() == null) {
				TreeIterator<EObject> it = root.eAllContents();
				while (it.hasNext()) {
					EObject o = it.next();
					if (includeNode(o)) {
						if (o instanceof CompositeNode) {
							List<LeafNode> ch = ((CompositeNode) o).getLeafNodes();
							for (LeafNode n : ch)
								if (n.isHidden())
									r.add(n);
								else
									break;
						}
						r.add((AbstractNode) o);
						it.prune();
					}
				}
			}
			else {
				BackwardNodeIterator bi = new BackwardNodeIterator(root);
				while (bi.hasNext() && bi.next() instanceof LeafNode && ((LeafNode) bi.next()).isHidden())
					r.add(bi.next());
				Collections.reverse(r);
				r.addAll(root.getLeafNodes());
				ForwardNodeIterator fi = new ForwardNodeIterator(root);
				while (fi.hasNext() && fi.next() instanceof LeafNode && ((LeafNode) fi.next()).isHidden())
					r.add(fi.next());
			}
			return r;
		}

		protected boolean nodeMatches(EObject grammarElement, String value, AbstractNode node) {
			return grammarElement == node.getGrammarElement();
		}

		@Override
		public void writeHidden(EObject grammarElement, String value) throws IOException {
			out.writeHidden(grammarElement, value);
		}

		protected void writeHidden(int leftBorder, int rightBorder) throws IOException {
			if (leftBorder + 1 == rightBorder)
				out.writeHidden(getWSRule(), "");
			else {
				boolean ws = false;
				int i = leftBorder;
				while (++i < rightBorder) {
					AbstractNode n = allLeafs.get(i);
					if (n instanceof LeafNode && ((LeafNode) n).isHidden()) {
						if (!ws && n.getGrammarElement() != getWSRule())
							out.writeHidden(getWSRule(), "");
						out.writeHidden(n.getGrammarElement(), ((LeafNode) n).getText());
						ws = n.getGrammarElement() == getWSRule();
					}
				}
				if (!ws)
					out.writeHidden(getWSRule(), "");
			}
		}

		@Override
		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			beforeElement(grammarElement, value);
//			System.out.println("Semantic" + grammarElement.eClass().getName() + " -> " + value);
			out.writeSemantic(grammarElement, value);
		}
	}

	@Inject
	protected IGrammarAccess grammar;

	protected boolean includeNode(EObject node) {
		if (node instanceof LeafNode)
			return true;
		if (node instanceof CompositeNode) {
			EObject e = ((CompositeNode) node).getGrammarElement();
			if (e instanceof RuleCall) {
				RuleCall rc = (RuleCall) ((CompositeNode) node).getGrammarElement();
				if (rc.getRule() instanceof ParserRule)
					return GrammarUtil.isDatatypeRule((ParserRule) rc.getRule());
			}
			if (e instanceof CrossReference)
				return true;
		}
		return false;
	}

	@Override
	public ITokenStream createHiddenTokenMerger(ITokenStream out, CompositeNode rootNode) {
		return new HiddenTokenMergerStream(out, rootNode);
	}

	protected TerminalRule getWSRule() {
		// FIXME: make this configurable
		return (TerminalRule) GrammarUtil.findRuleForName(grammar.getGrammar(), "WS");
	}

}
