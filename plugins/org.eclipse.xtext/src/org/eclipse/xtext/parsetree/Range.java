/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import java.util.List;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;

public class Range {

	private int fromOffset;
	private int toOffset;

	public Range(SyntaxError error) {
		this(error.getNode());
	}

	public Range(AbstractNode node) {
		this(node.getTotalOffset(), node.getTotalOffset() + node.getTotalLength());
	}

	public Range(int fromOffest, int toOffset) {
		this.fromOffset = fromOffest;
		this.toOffset = toOffset;
	}

	public void merge(Range range) {
		this.fromOffset = Math.min(fromOffset, range.fromOffset);
		this.toOffset = Math.max(toOffset, range.toOffset);
	}

	public void merge(SyntaxError error) {
		merge(new Range(error));
	}

	public int getFromOffset() {
		return fromOffset;
	}

	public void setFromOffset(int fromOffset) {
		this.fromOffset = fromOffset;
	}

	public int getToOffset() {
		return toOffset;
	}

	public void setToOffset(int toOffset) {
		this.toOffset = toOffset;
	}

	public void mergeAllErrors(AbstractNode node) {
		if (node.getSyntaxError() != null)
			merge(node.getSyntaxError());
		else if (node instanceof CompositeNode) {
			List<AbstractNode> children = ((CompositeNode) node).getChildren();
			for(int i = 0; i < children.size(); i++) {
				mergeAllErrors(children.get(i));
			}
		}
	}

	@Override
	public String toString() {
		return fromOffset + " - " + toOffset;
	}
}