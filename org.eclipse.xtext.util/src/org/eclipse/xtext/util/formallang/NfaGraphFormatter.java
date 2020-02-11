/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.Wrapper;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */

/*
 Example:
    1 
    | 
    2 _ 
    |  \ 
   3    8 
   |    | 
   4    9 
 / |\   | 
5 3  6  3 
  *  |  * 
     7 
     || 
    5 6 
 
 Ideas:
    
    1 
    | 
    2  
   / \ 
   3 | 
   |/  
   4= 
  /| 
 | 6= 
  \| 
   5  
    
    
start -> val1=ID -> val2=ID -> val3+=ID -> val4+=ID -> stop
              '----------------^ '-^ |      '-^         ^
                                     '------------------'  
 */
public class NfaGraphFormatter {

	protected static class Canvas {
		protected List<StringBuffer> document = Lists.newArrayList();

		public void set(int line, int column, String string) {
			if (line < 0 || column < 0)
				throw new IndexOutOfBoundsException();
			for (int i = document.size() - 1; i < line; i++)
				document.add(new StringBuffer());
			StringBuffer l = document.get(line);
			int width = column + string.length();
			for (int i = l.length() - 1; i < width; i++)
				l.append(' ');
			l.replace(column, column + string.length(), string);
		}

		@Override
		public String toString() {
			return Joiner.on('\n').join(document);
		}
	}

	protected static class Node {
		protected String name;
		protected boolean alias;
		protected List<Node> children = Lists.newArrayList();

		public Node(String name, boolean alias) {
			super();
			this.name = name;
			this.alias = alias;
		}

		public int getMinChildrenWidth() {
			int result = 0;
			for (Node child : children)
				result += child.getMinWidth();
			result += children.size() - 1;
			return result;
		}

		public int getMinWidth() {
			return Math.max(name.length(), getMinChildrenWidth());
		}

		public String getNameLine() {
			int space = getMinWidth() - name.length();
			if (space <= 0)
				return name;
			int left = space / 2;
			int right = space - left;
			return ws(left) + name + ws(right);
		}

		protected int getNamePos(int column, int width) {
			return column + ((width - name.length()) / 2);
		}

		protected void drawEdge(Canvas canvas, int fromLine, int fromCol, int fromWidth, int toCol, int toWidth) {
			int toPos = toCol + ((toWidth - 1) / 2);
			if ((fromCol <= toCol && fromCol + fromWidth >= toCol)
					|| (fromCol <= toCol + toWidth && fromCol + fromWidth >= toCol + toWidth)) {
				int left = Math.max(fromCol, toCol);
				int right = Math.min(fromCol + fromWidth, toCol + toWidth);
				canvas.set(fromLine + 1, left - ((left - right) / 2), "|");
			} else if (fromCol + 1 > toPos) {
				for (int i = toPos + 2; i < fromCol - 1; i++)
					canvas.set(fromLine, i, "_");
				canvas.set(fromLine + 1, toPos + 1, "/");
			} else if (fromCol + fromWidth - 1 < toPos) {
				for (int i = toPos - 2; i > fromCol + fromWidth; i--)
					canvas.set(fromLine, i, "_");
				canvas.set(fromLine + 1, toPos - 1, "\\");
			}
		}

		public void draw(Canvas canvas, int line, int column, int width) {
			canvas.set(line, getNamePos(column, width), name);
			if (alias)
				canvas.set(line + 1, column + ((width - 1) / 2), "*");
			else if (!children.isEmpty()) {
				int[] childWidth = new int[children.size()];
				int childrenWidth = 0;
				for (int i = 0; i < children.size(); i++)
					childrenWidth += childWidth[i] = children.get(i).getMinWidth();
				while (childrenWidth < width)
					for (int i = children.size() - 1; i >= 0; i--) {
						childWidth[i]++;
						childrenWidth++;
					}
				int childCol = column;
				for (int i = 0; i < children.size(); i++) {
					Node child = children.get(i);
					drawEdge(canvas, line, getNamePos(column, width), name.length(),
							getNamePos(childCol, childWidth[i]), child.name.length());
					child.draw(canvas, line + 2, childCol, childWidth[i]);
					childCol += childWidth[i];
				}
			}
		}

		public String getBranchLine() {
			int width = getMinWidth();
			int space = width - (name.length() + 2);
			int left = space / 2;
			int right = space - left;
			StringBuilder r = new StringBuilder();
			for (Node child : children) {
				int w = child.getMinWidth();
				int t = child.getTopAnchor();
				r.append(ws(t));
				if (r.length() < left)
					r.append("/");
				else if (r.length() > width - right)
					r.append("\\");
				else
					r.append("|");
				r.append(ws(w - (t)));
			}
			return r.toString();
		}

		public int getTopAnchor() {
			return getMinWidth() / 2;
		}

		protected String ws(int count) {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < count; i++)
				b.append(" ");
			return b.toString();
		}

	}

	public <STATE> String format(Nfa<STATE> nfa) {
		Map<STATE, Integer> names = Maps.newLinkedHashMap();
		List<Node> nodes = Lists.newArrayList();
		nodes.add(createNodes(nfa, nfa.getStart(), names, new Wrapper<Integer>(0)));
		StringBuilder result = new StringBuilder();
		STATE starts = nfa.getStart();
		STATE stops = nfa.getStop();
		for (Map.Entry<STATE, Integer> e : names.entrySet()) {
			result.append(e.getValue() + ": " + e.getKey());
			if (starts == e.getKey())
				result.append(" (start)");
			if (stops == e.getKey())
				result.append(" (stop)");
			if (!new NfaUtil().canReachFinalState(nfa, e.getKey()))
				result.append(" (no connection to final state!)");
			result.append("\n");
		}
		Canvas canvas = new Canvas();
		int width = 0;
		for (Node n : nodes) {
			n.draw(canvas, 0, width, n.getMinWidth());
			width += n.getMinWidth();
		}
		//				result.append(n.getNameLine() + " ");
		//			result.append("\n");
		//			for (Node n : nodes)
		//				result.append(n.getBranchLine() + " ");
		//			result.append("\n");
		//			List<Node> children = Lists.newArrayList();
		//			for (Node n : nodes)
		//				children.addAll(n.children);
		//			nodes = children;
		//		}
		result.append(canvas);
		return result.toString();

	}

	protected <STATE> Node createNodes(Nfa<STATE> nfa, STATE state, Map<STATE, Integer> names,
			Wrapper<Integer> lastName) {
		Integer name = names.get(state);
		if (name != null)
			return new Node(String.valueOf(name), true);
		lastName.set(lastName.get() + 1);
		names.put(state, lastName.get());
		Node node = new Node(String.valueOf(lastName.get()), false);
		for (STATE follower : nfa.getFollowers(state))
			node.children.add(createNodes(nfa, follower, names, lastName));
		return node;
	}
}
