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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstState.Status;

import com.google.common.base.Join;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TreeConstNFAToDot extends GrammarToDot {

	protected IGrammarNFAProvider<TreeConstState, TreeConstTransition> nfaProvider = new TreeConstructionNFAProvider();

	@Override
	protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
		Node n = super.drawAbstractElementTree(ele, d);
		TreeConstState nfas = nfaProvider.getNFA(ele);

		for (TreeConstTransition t : nfas.getFollowers())
			d.add(drawFollowerEdge(ele, t, false));
		for (TreeConstTransition t : nfas.getParentFollowers())
			d.add(drawFollowerEdge(ele, t, true));

		if (nfas.getStatInt() != Status.ENABLED)
			n.setStyle("dashed");
		if (nfas.isEndState())
			n.put("peripheries", "2");
		setStatusStyle(n, nfas.getStatus());
		n.setLabel(nfas + n.get("label"));
		return n;
	}

	protected Edge drawFollowerEdge(AbstractElement ele, TreeConstTransition t, boolean isParent) {
		Edge e = new Edge(ele, t.getTarget().getElement());
		if (t.getPrecedence() > -1)
			e.setLabel(String.valueOf(t.getPrecedence()));
		e.setStyle("dotted");
		if (isParent)
			e.put("arrowtail", "odot");
		if (t.isRuleCall())
			e.put("arrowhead", "onormalonormal");
		else
			e.put("arrowhead", "onormal");
		setStatusStyle(e, t.getStatus());
		return e;
	}

	protected void setStatusStyle(Props p, Status s) {
		switch (s) {
			case AMBIGIOUS:
				p.put("color", "green");
				break;
			case DETOUR_OR_LOOP:
				p.put("color", "blue");
				break;
			case ORPHAN:
				p.put("color", "grey");
				break;
			case UNKNOWN:
				p.put("color", "red");
				break;
			case ENABLED:
				break;
		}
	}

	@Override
	protected Node newNode(EObject obj, String label) {
		TreeConstState nfas = nfaProvider.getNFA((AbstractElement) obj);
		List<String> types = Lists.newArrayList();
		for (TypeRef t : nfas.getTypesToCheck())
			types.add(t == null ? "null" : t.getClassifier().getName());
		if (obj.eContainer() instanceof AbstractRule) {
			AbstractRule r = (AbstractRule) obj.eContainer();
			String t = types.isEmpty() ? "" : " [" + Join.join(",", types) + "]";
			return new Node(obj, r.getName() + t + ":\\n" + label, "record");
		} else {
			String t = types.isEmpty() ? "" : "[" + Join.join(",", types) + "]\\n";
			return new Node(obj, t + label);
		}
	}
}
