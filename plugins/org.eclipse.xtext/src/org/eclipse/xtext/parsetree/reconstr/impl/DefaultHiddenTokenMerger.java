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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatter.impl.BaseTokenStream;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultHiddenTokenMerger extends AbstractHiddenTokenMerger {

	protected static class BackwardLeafIterator implements Iterator<LeafNode> {

		private int index;
		private CompositeNode parent;

		public BackwardLeafIterator(AbstractNode start) {
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
			} else if (parent.getChildren().get(index) instanceof CompositeNode) {
				parent = (CompositeNode) parent.getChildren().get(index);
				index = parent.getChildren().size();
				return hasNext();
			}
			return true;
		}

		public LeafNode next() {
			return (LeafNode) parent.getChildren().get(index);
		}

		public void remove() {
		}

	}

	protected static class ForwardLeafIterator implements Iterator<LeafNode> {

		private int index;
		private CompositeNode parent;

		public ForwardLeafIterator(AbstractNode start) {
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
			} else if (parent.getChildren().get(index) instanceof CompositeNode) {
				parent = (CompositeNode) parent.getChildren().get(index);
				index = -1;
				return hasNext();
			}
			return true;
		}

		public LeafNode next() {
			return (LeafNode) parent.getChildren().get(index);
		}

		public void remove() {
		}

	}

	protected class HiddenTokenMergerStream extends BaseTokenStream {
		private List<LeafNode> allLeafs;

		private int lastLeaf;

		public HiddenTokenMergerStream(ITokenStream out, CompositeNode rootnode) {
			super(out);
			this.allLeafs = getAllLeafs(rootnode);
			// for (LeafNode n : allLeafs)
			// System.out.println("Leaf: '" + n.getText() + "'");
			this.lastLeaf = -1;
		}

		protected void beforeElement(EObject grammarElement, String value)
				throws IOException {
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

		protected List<LeafNode> getAllLeafs(CompositeNode root) {
			if (root == null)
				return null;
			if (root.getParent() == null)
				return root.getLeafNodes();
			ArrayList<LeafNode> r = new ArrayList<LeafNode>();
			BackwardLeafIterator bi = new BackwardLeafIterator(root);
			while (bi.hasNext() && bi.next().isHidden())
				r.add(bi.next());
			Collections.reverse(r);
			r.addAll(root.getLeafNodes());
			ForwardLeafIterator fi = new ForwardLeafIterator(root);
			while (fi.hasNext() && fi.next().isHidden())
				r.add(fi.next());
			return r;
		}

		protected boolean nodeMatches(EObject grammarElement, String value,
				LeafNode leaf) {
			return grammarElement == leaf.getGrammarElement();
		}

		@Override
		public void writeHidden(EObject grammarElement, String value)
				throws IOException {
			out.writeHidden(grammarElement, value);
		}

		protected void writeHidden(int leftBorder, int rightBorder)
				throws IOException {
			if (leftBorder + 1 == rightBorder)
				out.writeHidden(getWSRule(), "");
			else {
				boolean ws = false;
				int i = leftBorder;
				while (++i < rightBorder) {
					LeafNode n = allLeafs.get(i);
					if (n.isHidden()) {
						if (!ws && n.getGrammarElement() != getWSRule())
							out.writeHidden(getWSRule(), "");
						out.writeHidden(n.getGrammarElement(), n.getText());
						ws = n.getGrammarElement() == getWSRule();
					}
				}
				if (!ws)
					out.writeHidden(getWSRule(), "");
			}
		}

		@Override
		public void writeSemantic(EObject grammarElement, String value)
				throws IOException {
			beforeElement(grammarElement, value);
			out.writeSemantic(grammarElement, value);
		}
	}

	@Inject
	protected IGrammarAccess grammar;

	public ITokenStream createHiddenTokenMerger(ITokenStream out,
			CompositeNode rootNode) {
		return new HiddenTokenMergerStream(out, rootNode);
	}

	protected TerminalRule getWSRule() {
		// FIXME: make this configurable
		return (TerminalRule) GrammarUtil.findRuleForName(grammar.getGrammar(),
				"WS");
	}

}
