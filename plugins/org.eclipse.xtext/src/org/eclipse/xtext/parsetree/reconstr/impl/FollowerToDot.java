/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarToDot;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FollowerToDot extends GrammarToDot {

	@Override
	protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
		Node n = super.drawAbstractElementTree(ele, d);
		List<Follower> followers = ParseTreeConstructorUtil.calcFollowers(ele);
		boolean isEnd = false;
		for (int i = 0; i < followers.size(); i++) {
			if (followers.get(i).isRuleEnd())
				isEnd = true;
			else
				d.add(drawFollowerEdge(ele, followers.get(i), false, i));
		}
		List<Follower> followers2 = ParseTreeConstructorUtil
				.calcParentFollowers(ele);
		for (int i = 0; i < followers2.size(); i++) {
			if (followers2.get(i).isRuleEnd())
				isEnd = true;
			else
				d.add(drawFollowerEdge(ele, followers2.get(i), true, i));
		}
		if (followers.size() == 0 && followers2.size() == 0)
			n.setStyle("dotted");
		if (isEnd)
			n.put("peripheries", "2");
		return n;
	}

	protected Edge drawFollowerEdge(AbstractElement ele, Follower fol,
			boolean isParent, int i) {
		Edge e = new Edge(ele, fol.getFollower());
		e.setLabel(String.valueOf(i));
		e.setStyle("dotted");
		if (isParent)
			e.put("arrowtail", "odot");
		if (fol.isRuleCall())
			e.put("arrowhead", "onormalonormal");
		else
			e.put("arrowhead", "onormal");
		return e;
	}
}
